// tools
function rgb2hex(red, green, blue) {
    var rgb = blue | (green << 8) | (red << 16);
    return '#' + (0x1000000 + rgb).toString(16).slice(1)
}
if (typeof Node != 'undefined') {
    Node.prototype.getParentElementByTagName = function(tagName){
        /**
         * 寻找node的父元素且该父元素的标签名必须为tagName
         * @type {String} tagName － 指定的标签名
         */
        var targetNodeName = tagName.toLowerCase();
        var targetNode = this.parentElement;
        while (targetNode && targetNode.tagName.toLowerCase() != targetNodeName) {
            targetNode = targetNode.parentElement;
        }
        return targetNode;
    }
    Node.prototype.remove = function(){
        /**
         * 移除node
         */
        if (this.parentNode) {
            this.parentNode.removeChild(this);
        }
    }
    Node.prototype.wrapBy = function(tagName){
        /**
         * 为node包一个标签
         */
        var wrapDom = document.createElement(tagName);
        wrapDom.prependBefore(this);
        wrapDom.appendChild(this);
    }
}
if (typeof HTMLElement != 'undefined') {
    HTMLElement.prototype.appendAfter = function(targetEle){
        /**
         * 将element插到targetEle后
         */
        var parentEle = targetEle.parentElement;

        if (parentEle.lastChild === targetEle){
            parentEle.appendChild(this);
        } else {
            parentEle.insertBefore(this,targetEle.nextElementSibling);
        }
    }
    HTMLElement.prototype.prependBefore = function(targetEle){
        /**
         * 将element插到targetEle前面
         */
        targetEle.parentElement.insertBefore(this, targetEle);
    }
    HTMLElement.prototype.unwrap = function(){
        /**
         * 将element的所有子node取出组成新的fragment并替换掉该element inspired by medium-editor
         * @returns {DocumentFragment} fragment
         */
        var self = this;
        if(!self.childNodes.length){
            self.parentNode.removeChild(self);
            return;
        }
        var fragment = document.createDocumentFragment(),
            nodes = Array.prototype.slice.call(self.childNodes);
        for (var i = 0; i < nodes.length; i++) {
            fragment.appendChild(nodes[i]);
        }
        self.parentNode.replaceChild(fragment, self);
        return fragment;
    }
}


(function(win, doc){

    var QMUIEditor = win.QMUIEditor = {};

/**
 * 配置
 */
    var CONST = {
        defaultParagraph: 'div', // 段落标签，div或者p
        stateScheme: 'qmuire-state://',  // 传递编辑器当前光标选区状态
        contentScheme: 'qmuire-content://',  // 传递编辑器当前innerHTML
        eventScheme: 'qmuire-event://',  // 传递图片点击的事件给native
        audioScheme: 'qmuire-audio://',  // 传递录音数据给native
        emptyScheme: 'qmuire-empty://',  // 传递当前内容是否为空给native
        focusScheme: 'qmuire-focus://',  // 编辑器被聚焦
        blurScheme: 'qmuire-blur://',  // 编辑器失焦
        logScheme: 'qmuire-log://',  // 传递编辑器log信息
        inputScheme: 'qmuire-input://',  // 告知业务层目前有输入发生
        fontSizeSmall: 3,
        fontSizeNormal: 4,
        fontSizeBig: 5,
        fontSizeLarge: 6
    };

/**
 * nativeNotify: 原生通信相关
 */
    var nativeNotify = QMUIEditor.nativeNotify = function(type, data){
        var scheme = '';
        switch(type){
            case 'state': scheme = CONST.stateScheme; break;
            case 'content': scheme = CONST.contentScheme; break;
            case 'event': scheme = CONST.eventScheme; break;
            case 'audio': scheme = CONST.audioScheme; break;
            case 'log': scheme = CONST.logScheme; break;
            case 'empty': scheme = CONST.emptyScheme; break;
            case 'blur': scheme = CONST.blurScheme; break;
            case 'focus': scheme = CONST.focusScheme; break;
            case 'input': scheme = CONST.inputScheme; break;
        }
        console.log(scheme + data);
    }

/**
 * state: 编辑器状态
 */
    var state = QMUIEditor.state = {};
    state.map = {
        bold: 'BOLD',
        strikeThrough: 'STRIKETHROUGH',
        insertUnorderedList: 'UNORDEREDLIST',
        justifyCenter: 'JUSTIFYCENTER',
        color: {
            hook: function(output){
                var colorArr = doc.queryCommandValue('forecolor').replace("rgb(",'').replace(")",'').replace(/\s/g,'').split(',');
                output.push('COLOR='+rgb2hex(colorArr[0], colorArr[1], colorArr[2]));
            }
        },
        fontSize: {
            hook: function(output){
                function getSizeName(size){
                    switch(size){
                        case CONST.fontSizeLarge: return 'LARGE';
                        case CONST.fontSizeBig: return 'BIG';
                        case CONST.fontSizeNormal: return 'NORMAL';
                        case CONST.fontSizeSmall: return 'SMALL';
                        default: return 'UNKNOWN';
                    }
                }
                var size = parseInt(doc.queryCommandValue('fontSize'));
                output.push('FONTSIZE='+getSizeName(size));
            }
        },
        formatBlock: {
            hook: function(output){
                var formatBlock = doc.queryCommandValue('formatBlock')
                if(formatBlock.length > 0){
                    output.push('FORMATBOLCK=' + formatBlock.toUpperCase())
                }
            }
        },
        selectionContent: {
            hook: function(output){
                if (win.getSelection().toString().length > 0) {
                    output.push('SELECTIONCONTENT=' + win.getSelection().toString());
                }
            }
        }
    }
    state.current = '';
    state.push = function() {
        var self = this,
            states = [];
        for(var key in self.map){
            if(Object.prototype.hasOwnProperty.call(self.map, key)){
                var val = self.map[key]
                if(val.hook){
                    val.hook(states)
                }else{
                    doc.queryCommandState(key) && states.push(val);
                }
            }
        }
        states = states.join('&');
        if(self.current === states){
            return;
        }
        self.current = states;
        nativeNotify('content', editor.getHtml());
        nativeNotify('state', states);
    }


/**
 * selection: 光标选区相关
 */
    var selection = QMUIEditor.selection = {};
    selection.current = {
        'startContainer': null,
        'startOffset': 0,
        'endContainer': null,
        'endOffset': 0
    };
    selection.backup = function(){
        /**
         * 备份当前选区到selection.current
         */
        var sel = win.getSelection();
        if (sel.rangeCount > 0) {
            var range = sel.getRangeAt(0);
            this.current = {
                'startContainer': range.startContainer,
                'startOffset': range.startOffset,
                'endContainer': range.endContainer,
                'endOffset': range.endOffset
            };
        }
    }
    selection.restore = function(){
        /**
         * 将selection.current还原到编辑器里
         */
        var sel = win.getSelection();
        sel.removeAllRanges();
        var range = doc.createRange();
        if(this.current.startOffset > this.current.startContainer.length){
            this.current.startOffset = this.current.startContainer.length;
        }
        if(this.current.endOffset > this.current.endContainer.length){
            this.current.endOffset = this.current.endContainer.length;
        }
        range.setStart(this.current.startContainer, this.current.startOffset);
        range.setEnd(this.current.endContainer, this.current.endOffset);
        sel.addRange(range);
    }
    selection.getYCoods = function(){
        /**
         * 取得光标位置在y方向的数据，包括height,top,bottom,其中:
         * top: 光标上边缘到window上边缘的距离
         * bottom: 光标下边缘到window上边缘的距离
         * height: 光标上边缘
         * 上述“光标”指的是光标形成的rect
         * inspired by http://stackoverflow.com/questions/11126047/find-y-coordinate-for-cursor-position-in-div-in-uiwebview#answer-12300505
         */
        var sel = doc.selection,
            range,
            top = 0,
            bottom = 0,
            height = 0;
        if (win.getSelection) {
            sel = win.getSelection();
            if (sel.rangeCount) {
                range = sel.getRangeAt(0).cloneRange();
                var rect;
                if (range.getClientRects().length > 0) {
                    range.collapse(true);
                    // 然而因为该方法只会在input事件中调用，也就是用户用按键并输入的行为完成后调用，因此此时只有一个 rect
                    rect = range.getClientRects()[0];
                    top = rect.top;
                    height = rect.height;
                    bottom = rect.bottom;
                } else {
                    var currentNode = range.endContainer,
                        currentOffset = range.endOffset,
                        children = Array.prototype.slice.call(currentNode.childNodes);
                    if(children[currentOffset - 1]){
                        rect = children[currentOffset - 1].getBoundingClientRect();
                    }else{
                        rect = currentNode.getBoundingClientRect();
                    }
                    top = rect.top;
                    height = rect.height;
                    bottom = rect.bottom;
                }
            }
        }
        return {
            top: top,
            bottom: bottom,
            height: height
        };
    }
    selection.selectNodeAndCollapse = function(node, begin){
        /**
         * 选择一个node并将光标聚焦在它的开始或结束位置
         * @param {Bool} begin - 与系统range.collapse()方法的参数作用一致，true表示开始位置，false表示结束位置
         */
        var sel = win.getSelection(),
            range = doc.createRange();
        range.selectNodeContents(node);
        range.collapse(begin);
        sel.removeAllRanges();
        sel.addRange(range);
    }


/**
 * editor: 编辑器div拓展
 */
    var editor = QMUIEditor.editor =  doc.querySelector('#QMUIEditor');
    var header = doc.querySelector('#QMUIEditorHead');
    editor.setHeaderHeight = function(height) {
        /**
         * 设置编辑器头部区域高度，该区域用来放业务需要的view
         */
        header.style.cssText = 'height:' + height + 'px';
//        this.style.cssText = 'min-height:' + (win.innerHeight - height) + 'px';
//        win.onresize = function(){
//            editor.style.cssText = 'min-height:' + (win.innerHeight - height) + 'px';
//        }
    }
    editor.clear = function(){
        /**
         * 清空编辑器内容还原为最初状态
         * 邮箱里编辑器需要有一个 <div><sign></sign></div> 给客户端设置签名
         */
        this.innerHTML = '<' + CONST.defaultParagraph + '><br></' + CONST.defaultParagraph + '><div><sign></sign></div>';
    }
    editor.isFocused = function(){
        return doc.activeElement === this;
    }
    editor.isEmpty = function(){
        /**
         * 检查编辑器的内容是否为空，按顺序遵循以下规则：
         * 若存在具有特殊视觉表现的标签，则返回 false
         * 当innerText长度为1且br个数为1，相当于当前编辑器只有一个空的段落，返回 true
         * 判断innerText的长度，这里不判断trim后的情况，因为当在第一行执行回车，编辑器的innerText为两个空字符（获取innerText时一个br就是一个空字符），此时不能说浏览器为空。同理当用户已开始猛敲空格，我们也不能将它定义为 空 ，因为有可能这就是用户想要执行的输入行为
         */
        if(this.querySelectorAll('img, iframe, canvas, object, blockquote, ul, h1, h2, h3, h4, h5, h6').length > 0){
            return false;
        }
        if(this.innerText.length === 1 && this.innerText.length === this.querySelectorAll('br').length){
            return true;
        }
        return this.innerText.length <= 0;
    }
    editor.setPlaceholder = function(text){
        this.setAttribute('placeholder', text);
    }
    editor.togglePlaceholder = function(){
        /**
         * 切换placeholder的显示
         */
        if(this.isEmpty()){
            this.classList.add('QMUIEditor_empty');
        }else{
            this.classList.remove('QMUIEditor_empty');
        }
    }
    editor.focusEditorAtStartSelection = function(){
         selection.selectNodeAndCollapse(this, true);
         this.focus();
    }
    editor.blurfocus = function(){
        // 备份一下选区,以防失焦状态下插入失败
        // selection.backup();
        this.blur();
        win.getSelection().removeAllRanges();
    }
    editor.focusEditorAtBackupSelection = function(){
        /**
         * 聚焦编辑器并将光标恢复到上一次backup的位置
         * 如果没有backup过则将光标移动到编辑器的最末尾
         */
        if(selection.current.startContainer) {
            selection.restore();
        }else{
            selection.selectNodeAndCollapse(this, false);
        }
        this.focus();
    }
    editor.updatingScrollY = false;
    editor.updateScrollY = function(){
        /**
         * 调整页面的scrollTop，保证光标聚焦的地方可见且不会紧贴window下边缘
         */
            var caretTopToWindowTop = selection.getYCoods().top,
                caretBottomToWindowTop = selection.getYCoods().bottom,
                windowHeight = win.innerHeight,
                scrollTop = win.scrollY,
                comfortableOffset = 20,
                offset = 0;
            if(caretBottomToWindowTop + comfortableOffset >= windowHeight && !editor.updatingScrollY){
                editor.updatingScrollY = true;
                offset = caretBottomToWindowTop - windowHeight + comfortableOffset;
                window.scrollTo(0, scrollTop + offset);
                editor.updatingScrollY = false;
            }
    }

    editor.setHtml = function(contents){
        /**
         * 设置编辑器的内容
         * @param {String} html.
         */
        this.innerHTML = decodeURIComponent(contents.replace(/\+/g, '%20'));
    }
    editor.getHtml = function(){
        /**
         * 获取编辑器的原始内容
         * 去掉所有系统生成的带style的span
         * 邮箱业务需要, 将blockquote的样式全部内联到标签里
         * @returns {String}
         */
        var output = '';
        var virtualDom = doc.createElement('div');
        virtualDom.innerHTML = this.innerHTML;
        var bq = this.querySelector('blockquote'),
            spanWithStyle = this.querySelectorAll('span[style]');
        if(bq){
            var cssObj = win.getComputedStyle(bq, null);
            var cssText = 'margin:' + cssObj['margin'] + ';' +
                            'padding:' + cssObj['padding'] + ';' +
                            'color:' + cssObj['color'] + ';' +
                            'background-color: ' + cssObj['background-color'];
            var bqs = virtualDom.querySelectorAll('blockquote');
            for(var i=0; i< bqs.length; i++){
                bqs[i].style.cssText += cssText;
            }
        }
        if(spanWithStyle.length > 0){
            var spanWithStyle = virtualDom.querySelectorAll('span[style]');
            for(var i = 0; i < spanWithStyle.length; i++){
                spanWithStyle[i].unwrap();
            }
        }
        output = virtualDom.innerHTML;
        nativeNotify('content', output);
        return output;
    }
    editor.getRawHtml = function(){
        /**
         * 返回完整的innerHTML
         */
        var html = this.innerHTML;
        nativeNotify('content', html);
        return html;
    }
    editor.addEventListener('input', function(){
        /*
         * 监听输入事件，完成：
         * 1 保证编辑器首行有一个默认段落标签
         * 2 更新placeholder的显示状态
         * 3 更新页面scrollTop保证input的内容完整可见
         * 4 input事件的其他处理
         * 5 回调页面内容给app
         */
        if(editor.isEmpty()){
            nativeNotify('empty', "true");
            this.clear();
            selection.selectNodeAndCollapse(editor.firstChild, true);
        } else {
            nativeNotify('empty', "false");
        }
        this.togglePlaceholder();
        this.updateScrollY();
        edit.inputHandler();
    });
    editor.onImgClick = function(e){
        var img = e.target,
            src = img.getAttribute('src'),
            addition = img.getAttribute('data-addition'),
            data = '?src=' + src + '&addition=' + addition;
        nativeNotify('event', 'click/' + data);
    }
    editor.onAudioClick = function(e){
            var img = e.target,
                src = img.getAttribute('qmpath'),
                data = src;
        nativeNotify('audio', data);
    }
    editor.addEventListener('click', function(e){
        /**
         * 监听编辑器内的img的点击并回调数据给app
         */
        if(e.target.nodeName.toLowerCase() == 'img'){
            if(e.target.hasAttribute("qmpath")) {
                this.onAudioClick(e);
            } else {
                this.onImgClick(e);
            }
        }
    });
    editor.addEventListener('focus', function(e){
        /**
         * 编辑器聚焦时通知native
         */
         nativeNotify('focus', "true");
    });
    editor.addEventListener('blur', function(e){
        /**
         * 编辑器失焦时通知native
         */
         nativeNotify('focus', "false");
    });


/**
 * 编辑器操作的相关方法
 */
    var edit = QMUIEditor.edit = {};
    edit.delete = function() {
        /**
         * 调用系统命令进行退格删除
         */
        doc.execCommand('delete', false, null);
    }
    edit.undo = function() {
        /**
         * 撤销最近执行的命令
         */
        doc.execCommand('undo', false, null);
    }
    edit.redo = function() {
        /**
         * 重做被撤销的操作
         */
        doc.execCommand('redo', false, null);
    }
    edit.insert = function(content, onlyText){
        /**
         * 原生的insert命令需要存在selection时候才可以进行，与是否被聚焦无关。这里加个通用方法做下判断确保有一个selection
         * @param {String} content - 插入的内容
         * @param {Bool} onlyText - 是否用纯文本
         */
        if(win.getSelection().rangeCount <= 0){
            if(selection.current.start){
                selection.restore();
            }else{
                selection.selectNodeAndCollapse(editor, false);
            }
        }
        doc.execCommand(onlyText?'insertText':'insertHTML', false, content);
    }
    edit.insertHtml = function(html){
        /**
         * 插入html片段，用的是默认的系统命令
         */
        this.insert(html);
    }
    edit.insertText = function(text){
        /**
         * 插入文本，用的是默认的系统命令
         */
        this.insert(text, true);
    }
    edit.insertImage = function(img){
        /**
         * 插入图片
         * @param {Object} img
         * @param {String} img.src
         * @param {String} img.alt
         * @param {Int} img.w - 图片原始高度
         * @param {Int} img.h - 图片原始高度
         * @param {String} img.addition - 附加数据
         */
        if(!img.src){
            console.log('img src not found');
            return;
        }
        var imgHtml = '<img src="' + img.src + '" width="' + (img.w || '') + '" height="' + (img.h || '') + '" data-addition="' + (img.addition || '') + '" alt="' + (img.alt || '') + '" />';
        this.insert(imgHtml);
    }
    edit.setBold = function(){
        /**
         * 加粗
         */
        doc.execCommand('bold', false, null);
        edit.removeSpanWithStyle();
        state.push();
    }
    edit.strikeThrough = function(){
        /**
         * 中划线
         */
        doc.execCommand('strikeThrough', false, null);
        edit.removeSpanWithStyle();
        state.push();
    }
    edit.setTextColor = function(color){
        doc.execCommand('forecolor', false, color);
        edit.removeSpanWithStyle();
        state.push();
    }
    edit.setFontSize = function(size){
        /**
         * 设置字号
         * @param {int} size 字号的档次，三个值看CONST里的设定
         * https://developer.mozilla.org/zh-CN/docs/Web/API/Document/execCommand
         * <font size=”?“>  CSS font-size; ?
         *      1               10px 太小，忽略
         *      2               ~14px
         *      3               15px-16px
         *      4               17px-20px
         *      5               21px-27px
         *      6               28px-39px
         *      7               40px~
         */
        doc.execCommand("fontSize", false, size);
        edit.removeSpanWithStyle();
        state.push();
    }
    edit.setLargeFontSize = function(){
        edit.setFontSize(CONST.fontSizeLarge);
    }
    edit.setBigFontSize = function(){
        edit.setFontSize(CONST.fontSizeBig);
    }
    edit.setNormalFontSize = function(){
        edit.setFontSize(CONST.fontSizeNormal);
    }
    edit.setSmallFontSize = function(){
        edit.setFontSize(CONST.fontSizeSmall);
    }

    edit.setJustifyCenter = function(){
        /**
         * 设置居中，对居中的内容调用则会取消居中
         */
        if (doc.queryCommandState('justifyCenter')) {
            doc.execCommand('justifyLeft', false, null);
        }else{
            doc.execCommand('justifyCenter', false, null);
        }
        edit.removeSpanWithStyle();
        state.push();
    }
    edit.setTitle = function(titleTag) {
        /**
         * 设置标题
         * h1[h2 h3 ...]不与其他段落格式共存，设置其中一个都需要取消另外两个
         */

        var formatBlock = doc.queryCommandValue('formatBlock');
        if (formatBlock === 'blockquote') {
            doc.execCommand('formatBlock', false, '<' + CONST.defaultParagraph + '>')
        }
        if (formatBlock.length > 0 && formatBlock.toLowerCase() === titleTag) {
            doc.execCommand('formatBlock', false, '<' + CONST.defaultParagraph + '>');
        } else {
            doc.execCommand('formatBlock', false, '<' + titleTag + '>');
        }
        if (doc.queryCommandState('insertUnorderedList')) {
            doc.execCommand('InsertUnorderedList', false, null);
        }
        edit.removeSpanWithStyle();
    }
    edit.setBlockquote = function() {
        /**
         * 设置引用段落
         * 允许引用里存在列表
         */
        var formatBlock = doc.queryCommandValue('formatBlock');
        if (this.isHeadingFormat(formatBlock)) {
            doc.execCommand('formatBlock', false, '<' + CONST.defaultParagraph + '>');
        }
        if (formatBlock == 'blockquote') {
            doc.execCommand('formatBlock', false, '<' + CONST.defaultParagraph + '>')
        } else {
            doc.execCommand('formatBlock', false, '<blockquote>');
        }
        edit.removeSpanWithStyle();
    }
    edit.saveFontTagWithSpace = function(){
        /**
         * 编辑器里生成font标签后设置列表
         * 如果
         * 1 当前光标所在的font标签的parent的唯一子node就是这个font
         * 2 当前光标所在的font标签的parent的子node只有这个font和一个br标签
         * 设置／取消列表的操作就会导致font标签消失，系统会主动做类似unwrap的行为
         * 这里在需要的时候为font标签前（或者后）加一个任意的字符node，就能避免这个行为
         * 步骤：
         * 保存选区，加字符－－执行需要的操作－－去掉字符，恢复选区
         * 选区的保存和恢复是必要的，因为任意dom的增减都会导致选区丢失
         */
        selection.backup();
        var fonts = doc.querySelectorAll('font');
        for(var i = 0;i <fonts.length; i++){
            var font = fonts[i],
                fontParent = font.parentNode;
            if((font == fontParent.firstChild && font == fontParent.lastChild) ||
                (font == fontParent.firstChild && fontParent.lastChild.nodeName.toLowerCase() == 'br' && fontParent.childNodes.length == 2)){
                var spaceTag = document.createElement('i');
                spaceTag.className = 'fontTag_space';
                spaceTag.innerHTML = '&nbsp;';
                spaceTag.prependBefore(font);
            }
        }
        selection.restore();
    }
    edit.removeSpaceTag = function(){
        selection.backup();
        var spaces = doc.querySelectorAll('.fontTag_space');
        for(var i = 0; i < spaces.length; i++){
            spaces[i].remove();
        }
        selection.restore();
    }
    edit.setUnorderedList = function() {
        /**
         * 设置无序列表
         */
        edit.saveFontTagWithSpace();
        var formatBlock = doc.queryCommandValue('formatBlock');
        if (this.isHeadingFormat(formatBlock)) {
            doc.execCommand('formatBlock', false, '<' + CONST.defaultParagraph + '>');
        }
        doc.execCommand('InsertUnorderedList', false, null);
        edit.removeSpanWithStyle();
        edit.removeSpaceTag();
    }
    edit.setOrderedList = function() {
        /**
         * 设置顺序列表
         */
        edit.saveFontTagWithSpace();
        var formatBlock = doc.queryCommandValue('formatBlock');
        if (this.isHeadingFormat(formatBlock)) {
            doc.execCommand('formatBlock', false, '<' + CONST.defaultParagraph + '>');
        }
        doc.execCommand('InsertOrderedList', false, null);
        edit.removeSpanWithStyle();
        edit.removeSpaceTag();
    }
    edit.isHeadingFormat = function(formatName){
        return ['h1','h2','h3','h4','h5','h6'].indexOf(formatName) >= 0;
    }
    edit.changeSign = function(content){
        var sign = doc.querySelectorAll("sign")[0];
        if(sign) {
            sign.innerHTML = content;
        }
    }
    edit.changeImgSrc = function(lastSrc, newSrc) {
        var imgs = doc.querySelectorAll("img");
        var currSrc;
        for(var i = 0; i < imgs.length; i++){
           currSrc = imgs[i].src;
           currSrc = decodeURIComponent(currSrc.replace(/\+/g, '%20'));
           if(currSrc.endsWith(lastSrc)) {
               currSrc = currSrc.replace(lastSrc, newSrc);
               imgs[i].src = currSrc;
           }
        }
    }
//    备用,勿删
//    edit.addLineForBlockquote = function(){
//        // 如果blockquote后面是一个不可聚焦的行,则补一个空行在后面给用户聚焦,否则当blockquote包着ul>li时,按回车永远跳不出blockquote
//        var node = win.getSelection().focusNode,
//            blockquote = null;
//        if(node.getParentElementByTagName('blockquote')){
//            blockquote = node.getParentElementByTagName('blockquote');
//        }else if(node.nodeName.toLowerCase() == 'blockquote'){
//            blockquote = node;
//        }else{
//            return;
//        }
//        if((blockquote.nextElementSibling && blockquote.nextElementSibling.textContent.length == 0) || !blockquote.nextElementSibling){
//            var newLine = doc.createElement('div');
//            newLine.innerHTML = '<br>';
//            newLine.appendAfter(blockquote);
//        }
//    }
    edit.inputHandler = function(){
        // 监听input事件并执行需要的特殊操作
        // 目前有:
        // 避免在blockquote里产生段落,重现路径:在blockquote里设置列表,回车取消列表,这时会产生一个段落元素。理想的情况应该在这时候光标跳出blockquote
        var node = win.getSelection().focusNode,
            div = null,
            blockquote = null;
        if(node.nodeName.toLowerCase() == CONST.defaultParagraph){
            div = node;
        }else if(node.getParentElementByTagName(CONST.defaultParagraph)){
            div = node.getParentElementByTagName(CONST.defaultParagraph);
        }else {
            return;
        }
        if(div.getParentElementByTagName('blockquote')){
            blockquote = div.getParentElementByTagName('blockquote');
            div.appendAfter(blockquote);
            if(!blockquote.innerHTML){
                blockquote.remove();
            }
            selection.selectNodeAndCollapse(div, false);
        }
        nativeNotify('input', "");
    }
    edit.removeSpanWithStyle = function(){
        // 在input事件里去掉所有span
        var spans = QMUIEditor.editor.querySelectorAll('span[style]');
       if(spans.length > 0){
          for(var i = 0; i<spans.length; i++){
              selection.backup();
              var span = spans[i];
              if(span.parentNode == editor){
                  span.wrapBy('div');
              }
              spans[i].unwrap();
              selection.restore();
          }
       }
    }

/*
 * 初始化:
 * 设置默认首行段落标签
 * 设置默认的段落标签
 * 监听光标选区变化事件，完成：
 * 1 editor.togglePlaceholder();
 * 2 回调当前光标选区所在位置的标志给app，具体标志见 state.map
 * 3 及时备份选区
 */
    QMUIEditor.init = function(){
        doc.execCommand('defaultParagraphSeparator', false, CONST.defaultParagraph);
        editor.clear();
        doc.addEventListener('selectionchange', function(){
            editor.togglePlaceholder();
            state.push();
            selection.backup();
        });
    }

})(window, document);

QMUIEditor.init();