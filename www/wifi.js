/*global cordova, module*/

module.exports = {
    getSSID: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Wifi", "getSSID", [name]);
    }
};
