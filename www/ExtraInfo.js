var exec = require('cordova/exec');

exports.getExtra = function(success, error) {

    var success = function(result){
        alert(" ExtraInfo:"+result);
    }

    var error = function(result){
        alert(" ExtraInfo:"+result);
    }

    exec(success, error, "ExtraInfo", "getExtra", []);
};

