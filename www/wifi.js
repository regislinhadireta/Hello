/*global cordova, module*/

var Wifi {
    getSSID: function(win, fail) {
        if (typeof win != "function") {
            console.log("getSSID informe win e fail para continuar.");
            return;
        }
        cordova.exec(successCallback, errorCallback, "Wifi", "getSSID", [""]);
    }
};

module.exports = Wifi;
