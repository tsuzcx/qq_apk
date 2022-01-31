(function(){
    // 全局变量
    var uin,
        ua = navigator.userAgent;

    var utils = {
        getCookie: function(key){
            var pairs = document.cookie.split('; ');
            for (var i = 0, pair; pair = pairs[i] && pairs[i].split('='); i++) {
                if (decodeURIComponent(pair[0]) === key){
                    return decodeURIComponent(pair[1] || '');
                }
            }
            return null;
        }
    };

    var report = function(type, adsType, data){
        // type 0 点击上报
        // type 1 曝光上报
        var reportParam = {
            reportType: type,
            adsType: adsType,
            user_agent: ua
        };

        if(type == 0){
            reportParam.query_string = data.rl;
            reportParam.referer = location.href.replace(/^\S+url=/g, "").replace(/&\S+$/g, "");
            reportParam.acttype = 0;
        }else if(type ==1){
            reportParam.view_items = [{
                view_id: data.rl
            }];
        }

        mqq.invoke('app', 'sendRequest', {
            header: '',
            body: 'json=' + JSON.stringify(reportParam),
            callback: mqq.callback(function(json){
                // document.write(JSON.stringify(json));
            })
        });
    };

    var initClick = function(dom, adsType, data){
        var productType = data.producttype,
            productId = data.productid;

        if(productType && productType == 12 && productId){
            // 开平移动App广告, 需要跳手Q应用详情页
            dom.addEventListener("click", function(){
                mqq.invoke('qqZoneAppList', 'goUrl', {
                    url: 'sd://qapp_center_detail.htm?id=' + productId
                });
                // 点击上报
                report(0, adsType, data);
            }, false);
        } else {
            // 普通网页广告
            dom.addEventListener("click", function(){
                mqq.ui.openUrl({
                    url: data.trl,
                    target: 1,
                    style: 0
                });
                // 点击上报
                report(0, adsType, data);
            }, false);
        }

    };

    var adDataCallback = function(adsType, data){
        // list为广告数组
        // adsType 1 为banner广告, 只用1条广告数据
        // adsType 2 为结构化广告, 用到1-2条广告数
        if(adsType == 1){
            // banner
            data = data[0];

            var struct1 = document.getElementById('struct1'),
                struct1Img = document.getElementById('struct1_img');
            struct1Img.onload = function(){
                // 图片加载完后, 再通知客户端展示webview
                mqq.invoke('app', 'onAdLoad');
            };
            struct1Img.src = data.img;
            // 曝光上报
            report(1, adsType, data);

            initClick(struct1, adsType, data);

            struct1.style.display = 'block';

            // 腾讯社交广告小tips
            var ad_origin = document.getElementById("ad_origin"),
                expandFlag = false;
            ad_origin.addEventListener("click", function(e){
                e.preventDefault();
                e.stopPropagation();
                if(expandFlag){
                    ad_origin.classList.remove('expand');
                    expandFlag = false;
                } else {
                    ad_origin.classList.add('expand');
                    expandFlag = true;
                }
                
            }, false);
        } else if(adsType == 2) {
            // 结构化广告

            setTimeout(function(){
                mqq.invoke('app', 'onAdLoad');
            }, 0);

            var struct2 = document.getElementById('struct2'),
                struct2_1 = document.getElementById('struct2_1'),
                struct2_2 = document.getElementById('struct2_2'),
                struct2_1_Text = document.getElementById('struct2_1_text'),
                struct2_1_Img = document.getElementById('struct2_1_img'),
                struct2_2_Text,
                struct2_2_Img
                data1 = data[0],
                data2 = data[1];

            struct2_1_Text.innerHTML = data1.txt;
            struct2_1_Img.src = data1.img;
            // 曝光上报
            report(1, adsType, data1);

            if(data2){
                // 有两个广告
                struct2_2_Text = document.getElementById('struct2_2_text');
                struct2_2_Img = document.getElementById('struct2_2_img');

                struct2_2_Text.innerHTML = data2.txt;
                struct2_2_Img.src = data2.img;
                // 曝光上报
                report(1, adsType, data2);
            } else {
                struct2_2.style.display = 'none';
            }

            struct2.style.display = 'block';

            initClick(struct2_1, adsType, data1);

            if(data2){
                initClick(struct2_2, adsType, data2);
            }
        }

    };

    var getAdData = function(){
        // 获取广告数据, 由客户端获取后传给web
        mqq.invoke('app', 'getAdData', {
            callback: mqq.callback(function(json){
                if(json && json.retcode == 0){
                    adDataCallback(json.ads_type, json.list);
                }
            })
        });
    };

    var init = function(){
        uin = utils.getCookie('uin') ? parseInt(utils.getCookie('uin').slice(1), 10) : '';
        getAdData();
    };

    init();
})();