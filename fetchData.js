var fs = require('fs');

try {  
    var readRefuelBasic = fs.readFileSync('./pierwotne/Zestaw 1/refuel.log', 'utf8').split('\n');
    var readNozzleBasic = fs.readFileSync('./pierwotne/Zestaw 1/nozzleMeasures.log', 'utf8').split('\n');
    var readTankBasic = fs.readFileSync('./pierwotne/Zestaw 1/tankMeasures.log', 'utf8').split('\n');
    var readRefuelDistorted = fs.readFileSync('./zniekształcone/Zestaw 1/refuel.log', 'utf8').split('\n');
    var readNozzleDistorted = fs.readFileSync('./zniekształcone/Zestaw 1/nozzleMeasures.log', 'utf8').split('\n');
    var readTankDistorted = fs.readFileSync('./zniekształcone/Zestaw 1/tankMeasures.log', 'utf8').split('\n');
} catch(e) {
    console.log('Error:', e.stack);
}

function dataParsing(data, i){ 

    var tank_1 = toJSON(data.filter(function(value, index, Arr) {
        return value.charAt(i) == 1
    }),i);
    var tank_2 = toJSON(data.filter(function(value, index, Arr) {
        return value.charAt(i) == 2
    }),i);
    var tank_3 = toJSON(data.filter(function(value, index, Arr) {
        return value.charAt(i) == 3
    }),i);
    var tank_4 = toJSON(data.filter(function(value, index, Arr) {
        return value.charAt(22) == 4
    }),i);

    return {'tank1': tank_1, 'tank2': tank_2, 'tank3': tank_3, 'tank4': tank_4}
}

function toJSON(data, index) {

	var dataJSON = data.map(function(value) {
        var tankEx = value.split(';');
        if (index==22)
        return {'date': tankEx[0], 'tank_id': tankEx[3], 'petrol_level': tankEx[3], 'petrol_velocity': tankEx[4], 'petrol_temp': tankEx[5] }
        else if (index==24)
        return {'date': tankEx[0], 'gun_id': tankEx[2], 'tank_id': tankEx[3], 'actual_state': tankEx[4], 'total_state': tankEx[5], 'gun_state': tankEx[6] }
        else if (index==20)
        return {'date': tankEx[0], 'tank_id': tankEx[1], 'petrol_velocity': tankEx[2], 'refualing_speed': tankEx[3] }
    });
  
    return dataJSON;
}

module.exports = {
    TankBasic: dataParsing(readTankBasic, 22),
    TankDistorted: dataParsing(readTankDistorted, 22),
    NozzleBasic: dataParsing(readNozzleBasic, 24),
    NozzleDistorted: dataParsing(readNozzleDistorted, 24),
    RefuelBasic: dataParsing(readRefuelBasic, 20),
    RefuelDistorted: dataParsing(readRefuelDistorted, 20)
  };