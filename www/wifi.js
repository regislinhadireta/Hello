module.exports = {
    getSSID: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Wifi", "getSSID", [""]);
    }
};
