/*globals TT,__TT__GLOBAL__*/
//var global = __TT__GLOBAL__;

(function(global){
    var allModules = {};
    function define(absolutPath,f) // absolutePath:后续required的索引，f即factory原型为function(require, module, exports, process)
    {
        if (!allModules[absolutPath]) {
            var m = {exports:{},factory:f,status:1};
            allModules[absolutPath] = m;
        }
    }
    function realPreload(absolutPath)
    {
        if (!allModules[absolutPath]) {
            TT.Script.loadJS(absolutPath); // loadJS同时define了一个以absolutePath为key的module
        }
    }
    function realRequire(absolutPath)
    {
        realPreload(absolutPath);
        var m = allModules[absolutPath];
        if (1 === m.status) {
            var d = m.factory;//factory就是实际的define
            var tempM = {//i module
                exports: {}
            };
            var ret = void 0;
            d && (ret = d(getRequire(absolutPath), tempM, tempM.exports));//o 是指根据项目目录的绝对路径获取require
            m.exports = tempM.exports || ret;//获取后缓存起来
            m.status = 2;//标记已经获取到过
        }
        return m.exports;
    }
    function getRequire(path)
    {
        function getDir(p) {
            var t = p.match(/(.*)\/([^\/]+)?$/);
            return t && t[1] ? t[1] : "./";
        }
        var dir = getDir(path);
        return function(targetName){
            if ("string" != typeof targetName) throw new Error("require args must be a string");
            for (var targetDirs = [], targetPaths = (dir + "/" + targetName).split("/"), i = 0, len = targetPaths.length; i < len; ++i) {
                var d = targetPaths[i];
                if ("" != d && "." != d) if (".." == d) {
                    if (0 == targetDirs.length) throw new Error("can't find module : " + targetName);
                    targetDirs.pop();
                } else {
                    i + 1 < len && ".." == targetPaths[i + 1] ? i++:targetDirs.push(d);
                }
            }
//            try {
                var targetPath = targetDirs.join("/");
                if (!(/\.js$/.test(targetPath))) {
                    targetPath += ".js";
                }
                return realRequire(targetPath);
//            } catch(e) {
//                throw e
//            }
        };
    }
    function getPreload(path)
    {
        function getDir(p) {
            var t = p.match(/(.*)\/([^\/]+)?$/);
            return t && t[1] ? t[1] : "./";
        }
        var dir = getDir(path);
        return function(targetName){
            if ("string" != typeof targetName) throw new Error("require args must be a string");
            for (var targetDirs = [], targetPaths = (dir + "/" + targetName).split("/"), i = 0, len = targetPaths.length; i < len; ++i) {
                var d = targetPaths[i];
                if ("" != d && "." != d) if (".." == d) {
                    if (0 == targetDirs.length) throw new Error("can't find module : " + targetName);
                    targetDirs.pop()
                } else
                    i + 1 < len && ".." == targetPaths[i + 1] ? i++:targetDirs.push(d)
            }
//            try {
                var targetPath = targetDirs.join("/");
                if (!(/\.js$/.test(targetPath))) {
                    targetPath += ".js"
                }
                realPreload(targetPath);
//            } catch(e) {
//                throw e
//            }
        }
    }


    global.__tt__allModules = allModules;
    global.define = define;


    var startedJS = 'main.js';
    global.require = getRequire(startedJS);
    global.__tt__preloadjs = getPreload(startedJS); 
}(this));



