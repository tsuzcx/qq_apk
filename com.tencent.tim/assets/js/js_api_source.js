/*
 * Js Api基础定义
 *
*/
(function(context, publicName) {
   /**
    * 版本号
    */
   var version = "1.0";

   /**
    * 系统声明和可以调用的方法
    */
   var declaredPublicMethods = ["reportEvent", "getSdkVersion"];

   /**
    * 全局对象
    */
   var T = {};

   /**
    * 一个数组用来存储回调函数
    */
   T.callBackQueue = [];

   /**
    * 临时变量
    */
   var S = Array.prototype.slice;
   var ua = navigator.userAgent;

   function isAndroid() {
      return /android/i.test(ua) ? true : false;
   }


   /**
    * 异步回调处理函数
    */
   T.javascriptBridgeCallBack = function() {
      var params = S.call(arguments, 0);
      var index = Nubmer(params.shift());
      T.callBackQueue[index].apply(this, params);
   };

   /**
    * 参数数据转化成所需的Json字符串
    */
   function arrayToJsonString(paramsArray) {
      var typeArray = [];
      var method = paramsArray.shift();
      var n = paramsArray.length;
      for (var i = 0; i < n; i++) {
         var params = paramsArray[i];
         var type = typeof params;
         if(params == null) {
            typeArray[typeArray.length] = "string";
         } else {
            typeArray[typeArray.length] = type;
         }
         if (type == "function") {
            var d = T.callBackQueue.length;
            T.callBackQueue[d] = params;
            paramsArray[i] = d;
         }
            if(type == 'object'){
                if(params.onCallback){
                    T.callBackQueue[method] = params.onCallback;
                }
                paramsArray[i] = JSON.stringify(params);
            }
      }
      return JSON.stringify({
         method: method,
         types: typeArray,
         args: paramsArray,
         instanceName: publicName
      })
   }

   /**
    * 通过prompt调用Java对象方法
    */
   function promptCall() {
      var paramsArray = S.call(arguments, 0);
      var preFix = "DtJsBridge://";
      var jsonResult = prompt(preFix + arrayToJsonString(paramsArray));
      var re = JSON.parse(jsonResult);
      if (re.code != 200) {
         throw "call error, code:" + re.code + ", message:" + re.result;
      }
      return re.result;
   }

   /**
    * 通用回调函数
    */
   T["callback"] = function(functionName, result){
       if(T.callBackQueue[functionName]){
           T.callBackQueue[functionName](result);
       }
   }

   /**
    * 注册公共方法，注册js api句柄
    */
   if (isAndroid() && typeof context[publicName] == "undefined" && !context[publicName]) {
      declaredPublicMethods.forEach(function(d) {
         T[d] = function() {
                return promptCall.apply(T, [d].concat(S.call(arguments, 0)));
         }
      });

      context[publicName] = T;
   }
   window[publicName].hasInject = true;

   var readyEvent = new Event('onDtJsReporterReady');
   document.dispatchEvent(readyEvent);

}(this, "DtJsReporter"));
