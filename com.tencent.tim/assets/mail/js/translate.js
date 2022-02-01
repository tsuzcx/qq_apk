function getElementTop(element){
    var actualTop = element.offsetTop;
    var current = element.offsetParent;
    while (current != null){
        actualTop += current.offsetTop;
        current = current.offsetParent;
    }
    return actualTop;
}

function changeOriginalAndTranslateHidden(isHideOrininal) {
    if(isHideOrininal) {
        document.body.className = "";
    } else {
        document.body.className = "origin";
    }
}

function mailAppTranslate(needScroll) {
    if(needScroll) {
        var originals = document.getElementsByClassName("mailAppOrigin");
        var currentTop = document.body.scrollTop;
        var domIndex = -1;
        var minDistance = -1;
        for(var i = 0; i < originals.length; i++) {
            var aDom = originals[i];
            var aTop = getElementTop(aDom);
            if(aTop >= currentTop) {
                var aDistance = aTop - currentTop;
                if(minDistance > aDistance || minDistance < 0) {
                    minDistance = aDistance;
                    domIndex = i;
                }
            }
        }

        changeOriginalAndTranslateHidden(true);

        var translates = document.getElementsByClassName("mailTranslated");
        if(domIndex >= 0) {
            var aDom = translates[domIndex];
            var aDomY = getElementTop(aDom);
            aDomY -= minDistance;
            window.scrollTo(0,aDomY);
        }
    } else {
        changeOriginalAndTranslateHidden(true);
    }
}

function mailAppOriginal(needScroll) {
    if(needScroll) {
        var translates = document.getElementsByClassName("mailTranslated");
        var currentTop = document.body.scrollTop;
        var domIndex = -1;
        var minDistance = -1;
        for(var i = 0; i < translates.length; i++) {
            var aDom = translates[i];
            var aTop = getElementTop(aDom);
            if(aTop >= currentTop) {
                var aDistance = aTop - currentTop;
                if(minDistance > aDistance || minDistance < 0) {
                    minDistance = aDistance;
                    domIndex = i;
                }
            }
        }

        changeOriginalAndTranslateHidden(false);

        var originals = document.getElementsByClassName("mailAppOrigin");
        if(domIndex >= 0) {
                var aDom = originals[domIndex];
                var aDomY = getElementTop(aDom);
                aDomY -= minDistance;
                window.scrollTo(0,aDomY);
            }
    } else {
        changeOriginalAndTranslateHidden(false);
    }
}