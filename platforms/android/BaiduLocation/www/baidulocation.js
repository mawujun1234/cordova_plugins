//var cordova = require('cordova');

function BaiduLocation() {

}
BaiduLocation.prototype.execute=function(action, successCallback, errorCallback) {
		cordova.exec(     
			function(pos) {
				var errcode = pos.errcode;
				if (errcode == 61 || errcode == 65 || errcode == 161) {
					successCallback(pos);
				} else {
					if (typeof(errorCallback) != "undefined") {
						if (errcode >= 162) {
							errcode = 162;
						}
						errorCallback(pos)
					};
				}
			}, 
			function(err){},
			"BaiduLocation",
			action,
			[]
		)
};

BaiduLocation.prototype.getCurrentPosition=function(successCallback, errorCallback) {
		this.execute("getCurrentPosition", successCallback, errorCallback);
};
BaiduLocation.prototype.stopGetPosition= function(action, successCallback, errorCallback) {
		this.execute("stopGetPosition", successCallback, errorCallback);
}
var baiduLocation=new BaiduLocation();
module.exports = baiduLocation;