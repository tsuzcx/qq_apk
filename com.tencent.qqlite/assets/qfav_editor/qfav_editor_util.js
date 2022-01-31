QfavUtil = {
    notify: function(method, args, timeout) {
		var argsStr = [];
		for(var key in args) {
			argsStr.push(key + '=' + encodeURIComponent(args[key]));
		}

		var argsStr = method + '?' + argsStr.join('&');
		var self = this;
		timeout = typeof(timeout) === 'number' ? parseInt(timeout,10) : 0;
		//延迟处理
		if(timeout == 0) {
			this._postMessageToNative(argsStr);
		} else {
			window.setTimeout(function() {
				self._postMessageToNative(argsStr);
			}, timeout || 0);
		}
    },
    notifyWithResponse : function(method, args, callback) {
        var randomId = new Date().getTime();
        __callbacks[randomId] = callback;
        args['__callback'] = randomId;
        this.notify(method, args, 0);
    },
	
    excuteCallback : function(callbackId) {
        var callback = __callbacks[callbackId];
        if(typeof(callback) == 'function') {
            var params = [].slice.apply(arguments);
            callback && callback.apply(window , params.slice(1));
            delete __callbacks[callbackId];
        }
    },
	
    _postMessageToNative : function(url) {
        url = QfavUtil.NOTIFY_SCHEMA + url;
        var iframe = document.createElement("IFRAME");
        iframe.width = iframe.height = 0;
        iframe.setAttribute("src", url);
        document.documentElement.appendChild(iframe);
        iframe.parentNode.removeChild(iframe);
        iframe = null;
        this.log(url);
    },
	
	log : function() {
		console.log.apply(console, [].slice.call(arguments));
	}
};

QfavUtil.NOTIFY_SCHEMA = "qfavnotify://";