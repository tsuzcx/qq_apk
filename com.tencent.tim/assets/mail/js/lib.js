/************
 * 全局配置
 ************/
var GLOBAL = {
	//是否开启调试模板
	PAGE_LOG_DEBUG : false,
	JAVA_LOG_DEBUG : false
};

/************
 * 基础函数
 ************/
(function(_aoNS) {
	// 给NodeList加上常用操作
	"forEach map reduce".split(/\s+/).forEach(function(fnName){
		NodeList.prototype[fnName] = NodeList.prototype[fnName] || Array.prototype[fnName];
	});

	// dom 样式 - from jQuery
	var rroot = /^(?:body|html)$/i,
		rmsPrefix = /^-ms-/,
		rdashAlpha = /-([\da-z])/gi,
		core_pnum = /[\-+]?(?:\d*\.|)\d+(?:[eE][\-+]?\d+|)/.source,
		rnumnonpx = new RegExp("^(" + core_pnum + ")(?!px)[a-z%]+$", "i"),
		rmargin = /^margin/,
		cssProps = {
			"myfloat": "cssFloat"
		},
		cssHooks = {
		},
		cssNormalTransform = {
			letterSpacing: 0,
			fontWeight: 400
		},
		fcamelCase = function (all, letter) {
			return (letter + "").toUpperCase();
		};

	var camelCase = function (string) {
		return string.replace(rmsPrefix, "ms-").replace(rdashAlpha, fcamelCase);
	};
	
	var vendorPropName = function (style, name) {
		if (name in style) {
			return name;
		}
	
		var capName = name.charAt(0).toUpperCase() + name.slice(1),
		origName = name,
		i = cssPrefixes.length;
	
		while (i--) {
			name = cssPrefixes[i] + capName;
			if (name in style) {
				return name;
			}
		}
	
		return origName;
	};
	
	var style = function (dom, name) {
		if (!dom || dom.nodeType === 3 || dom.nodeType === 8 || !dom.style) {
			return;
		}

		var ret, type, hooks,
		origName = camelCase(name),
		style = dom.style;
	
		if(origName == "float") {
			origName = "myfloat";
		}
	
		name = cssProps[origName] || (cssProps[origName] = vendorPropName(style, origName));
		hooks = cssHooks[name] || cssHooks[origName];

		if (hooks && "get" in hooks && (ret = hooks.get(elem, false, null)) !== undefined) {
			return ret;
		}

		return style[name];
	};

	var curCSS = function (elem, name) {
		var ret, width, minWidth, maxWidth,
		computed = window.getComputedStyle(elem, null),
		style = elem.style;
		if (computed) {
			ret = computed.getPropertyValue(name) || computed[name];
			if (ret === "") {
				ret = style(elem, name);
			}

			if (rnumnonpx.test(ret) && rmargin.test(name)) {
				width = style.width;
				minWidth = style.minWidth;
				maxWidth = style.maxWidth;
			
				style.minWidth = style.maxWidth = style.width = ret;
				ret = computed.width;
			
				style.width = width;
				style.minWidth = minWidth;
				style.maxWidth = maxWidth;
			}
		}
	
		return ret;
	};
	
	var css = function (dom, name) {
		var val, num, hooks,
		origName = camelCase(name);
	
		if(origName == "float"){
			origName = "myfloat";
		}
	
		name = cssProps[origName] || (cssProps[origName] = vendorPropName(dom.style, origName));
		hooks = cssHooks[name] || cssHooks[origName];

		if (hooks && "get" in hooks) {
			val = hooks.get(dom, true, extra);
		}

		if (val === undefined) {
			val = curCSS(dom, name);
		}
	
		if (val === "normal" && name in cssNormalTransform) {
			val = cssNormalTransform[name];
		}
	
		return val;
	};
	
	var offset = function (dom) {
		var docElem, body, win, clientTop, clientLeft, scrollTop, scrollLeft,
		box = {
			top: 0,
			left: 0
		},
		elem = dom,
		doc = elem && elem.ownerDocument;

		if (!doc) {
			return;
		}
		body = doc.body;
		docElem = doc.documentElement;

		if (typeof elem.getBoundingClientRect !== "undefined") {
			box = elem.getBoundingClientRect();
		}
		win = window;
		clientTop = docElem.clientTop || body.clientTop || 0;
		clientLeft = docElem.clientLeft || body.clientLeft || 0;
		scrollTop = win.pageYOffset || docElem.scrollTop;
		scrollLeft = win.pageXOffset || docElem.scrollLeft;
		return {
			top: box.top + scrollTop - clientTop,
			left: box.left + scrollLeft - clientLeft
		};
	};
	
	var offsetParentFunc = function (dom) {
		var offsetParent = dom.offsetParent || document.body;
		while (offsetParent && (!rroot.test(offsetParent.nodeName) && css(offsetParent, "position") === "static")) {
			offsetParent = offsetParent.offsetParent;
		}
		return offsetParent || document.body;
	};
	
	var replaceClassName = function(dom, oldClassName, newClassName) {
		dom && (dom.className = dom.className.replace(oldClassName, newClassName));
	};
	
	//--- 公开接口 ---
	//插入html
	_aoNS.insertHTML = function(_aoDomObj, _asWhere, _asHtml)
	{
		if (!_aoDomObj)
		{
			return false;
		}
		try
		{
			var _oRange = _aoDomObj.ownerDocument.createRange(),
				_abIsBefore = _asWhere.indexOf("before") == 0,
				_abIsBegin = _asWhere.indexOf("Begin") != -1;
			if (_abIsBefore == _abIsBegin)
			{
				_oRange[_abIsBefore ? "setStartBefore" : "setStartAfter"](_aoDomObj);
				_aoDomObj.parentNode.insertBefore(
					_oRange.createContextualFragment(_asHtml), _abIsBegin
						? _aoDomObj
						: _aoDomObj.nextSibling
				);
			}
			else
			{
				var _oDomObj = _aoDomObj[_abIsBefore ? "lastChild" : "firstChild"];
				if (_oDomObj)
				{
					_oRange[_abIsBefore ? "setStartAfter" : "setStartBefore"](_oDomObj);
					_aoDomObj[_abIsBefore ? "appendChild" : "insertBefore"](_oRange
							.createContextualFragment(_asHtml), _oDomObj);
				}
				else
				{

					_aoDomObj.innerHTML = _asHtml;
				}
			}
			return true;
		}
		catch (_oError)
		{
			//debug(_oError.message)
			return false;
		}
	};
	
	// 时间函数
	_aoNS.now = function() {
		return +new Date;
	};
	
	// dom 操作
	_aoNS.dom = function(_asQueryStr, _aoDom) {
		return (_aoDom || document).querySelector(_asQueryStr);
	};

	_aoNS.doms = function(_asQueryStr, _aoDom) {
		return (_aoDom || document).querySelectorAll(_asQueryStr);
	};
	
	_aoNS.docElem = function() {
		return document.documentElement;
	};
	
	//属性
	_aoNS.attr = function(dom, attr) {
		return dom.getAttribute(attr);
	};
	
	//样式
	_aoNS.addClass = function(dom, className) {
		dom.className += " " + className;
	};
	
	_aoNS.removeClass = function(dom, className) {
		replaceClassName(dom, className, "");
	};
	
	_aoNS.replaceClass = replaceClassName;

	//样式
	_aoNS.css = css;

	//位置
	_aoNS.position = function (dom) {
		var offsetParent = offsetParentFunc(dom);
		var offsetobj = offset(dom);
		var parentOffset = rroot.test(offsetParent.nodeName) ? {
			top: 0,
			left: 0
		} : offsetParent.offset();
		
		offsetobj.top -= parseFloat(css(dom, "marginTop")) || 0;
		offsetobj.left -= parseFloat(css(dom, "marginLeft")) || 0;

		parentOffset.top += parseFloat(css(offsetParent, "borderTopWidth")) || 0;

		return {
			top: offsetobj.top - parentOffset.top,
			left: offsetobj.left - parentOffset.left
		};
	};
})(window);

/************
 * 页面调试 + 异常处理
 ************/
(function(_aoNS) {
	var _t = 0,
		_oCache = [];

	/*
	 * 调试接口
	 */
	function _console(_anType, _asText, _abIsLogFile) {
		//App接口可用才调用
		if (window.App) {
			//调用java的log
			if (_abIsLogFile) {
				App.logFile(_asText);
			}
			else if (GLOBAL.JAVA_LOG_DEBUG && _asText) {
				App.log(_asText);
			}
		}

		//显示在页面
		if (GLOBAL.PAGE_LOG_DEBUG) {
			var _sId = "qQmAilcOnsoLe",
				_oDomConsole = dom("#" + _sId);

			//计算时间
			_t = (+new Date) - _t;
		
			if (!_oDomConsole && document.body) {
				_oDomConsole = document.createElement("div");
				_oDomConsole.id = _sId;
				//调试器样式
				_oDomConsole.style.cssText = "position:absolute;left:0;" + 
					"background:#000;color:#fff;" + 
					"opacity:0.8;font-size:12px!important;padding:10px!important;z-index:999;";
				//由于4.4需要加fillDiv在头部，所以console插在body1比较合适
				document.body.insertBefore(_oDomConsole, document.body.firstChild);
			}
	
			//先cache一下
			_asText && _oCache.push(
				//1为错误
				(_anType == 1 ? "<b style='color:red'>" : "") + 
					_asText + (_t < 10000 ? " t=" + _t + "ms" : "") +
				(_anType == 1 ? "</b>" : "")
			);

			//没创建成功的话，不处理
			if (_oDomConsole && _oCache.length > 0) {
				var _oDomDiv = document.createElement("div");
				//少于10s显示时间差
				_oDomDiv.innerHTML = _oCache.join("<br>");
				_oDomConsole.appendChild(_oDomDiv);
				//清空cache
				_oCache.length = 0;
			}

			//更新时间
			_t = +new Date;
		}
	}

	/*
	 * 打普通日志
	 */
	function _log(_asText) {
		_asText && _console(0, _asText);
	}

	/*
	 * 打错误日志，强制输出到文件
	 */
	function _err(_asText) {
		_asText && _console(1, _asText, true);
	}

	if (GLOBAL.PAGE_LOG_DEBUG) {
		//保护：刷新出console数据
		document.addEventListener("DOMContentLoaded", function() {
			_console();
		});
	}
	
	//异常处理
	_aoNS.onerror = function(_asMsg, _asUrl, _asLine) {
		_err("js_error: msg=" + _asMsg + " url=" + _asUrl + " line=" + _asLine);
	};
	
	//默认显示调试器
	_log("-- Debug Opened --");

	//接口
	_aoNS.console = {
		log : _log,
		err : _err
	};
})(window);