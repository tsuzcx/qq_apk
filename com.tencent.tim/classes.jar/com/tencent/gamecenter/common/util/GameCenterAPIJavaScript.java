package com.tencent.gamecenter.common.util;

import affz;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import anpc;
import aroi;
import arwo;
import arxr;
import arzk;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbc;
import tbd;
import tbe;
import tbl;
import wja;

public class GameCenterAPIJavaScript
  extends VasWebviewJsPlugin
{
  public static final String APPKEY_PLAYER = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  public static final String CLOSE_SWITCH = "closeSwitch";
  public static final String DEL_IMG = "delImg";
  public static String EVENT_UPDATE_SESSION_INFO = "gameCenter_sessionChanged";
  public static String EVENT_UPDATE_UNREAD_CNT;
  public static String METHOD_GET_REQUEST_INFO;
  public static String METHOD_GET_SESSION_INFO = "getSessionData";
  public static String METHOD_GET_UNREAD_TOTAL;
  public static String METHOD_OPEN_AIO = "clickCommonSession";
  public static String METHOD_TOGGLE_CHANGE = "setSwitch";
  public static final String OPEN_SWITCH = "openSwitch";
  public static final String QUERY_INFO = "queryInfo";
  public static final String REMOVE_MASK = "removeMask";
  public static final String SHOT_SCREEN = "shotScreen";
  public static final String TAG = "GCApi";
  private static boolean mIsInited;
  private String CALLBACK_UPDATE_SESSION = "";
  private DisplayMetrics dm;
  private Context mContext;
  private a mMsgReceiver = new a(null);
  public Bundle mReqBundle;
  private TouchWebView.OnScrollChangedListener mScrollChangedListener;
  private FrameLayout mVideoContainer;
  private Map<Integer, b> mVideoViewMap = new HashMap();
  private String uin = "";
  
  static
  {
    METHOD_GET_REQUEST_INFO = "getRequestData";
    METHOD_GET_UNREAD_TOTAL = "getNewMsgCount";
    EVENT_UPDATE_UNREAD_CNT = "gameCenter_newMsgCountChanged";
  }
  
  public GameCenterAPIJavaScript()
  {
    this.mPluginNameSpace = "GCApi";
  }
  
  void callbackError(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramString2);
      super.callJs(paramString1 + "&&" + paramString1 + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.e("GCApi", 2, "callbackId->" + paramString1 + " errorMsg: " + paramString2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GCApi", 2, localException.getMessage());
        }
      }
    }
  }
  
  public void callbackJS(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("msg", paramString2);
      super.callJs(paramString1 + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 2, "callbackId->" + paramString1 + " callbackOk" + localJSONObject.toString());
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("GCApi", 2, paramString1.getMessage());
    }
  }
  
  void callbackOk(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", 0);
      localJSONObject.put("msg", "");
      super.callJs(paramString + "&&" + paramString + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 2, "callbackId->" + paramString + " callbackOk" + localJSONObject.toString());
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("GCApi", 2, paramString.getMessage());
    }
  }
  
  /* Error */
  public int createVideo(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 193	allf:isSDKReady	()Z
    //   3: ifne +56 -> 59
    //   6: aload_0
    //   7: getfield 197	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   10: ifnull +26 -> 36
    //   13: aload_0
    //   14: getfield 197	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   17: invokevirtual 202	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   20: ifnull +16 -> 36
    //   23: aload_0
    //   24: getfield 197	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   27: invokevirtual 202	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   30: invokevirtual 208	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   33: ifnonnull +5 -> 38
    //   36: iconst_m1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 197	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   42: invokevirtual 202	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   45: invokevirtual 208	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   48: new 210	tbf
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 213	tbf:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   56: invokestatic 216	allf:a	(Landroid/app/Application;Lcom/tencent/mobileqq/videoplatform/SDKInitListener;)V
    //   59: aload_1
    //   60: ldc 218
    //   62: invokevirtual 222	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   65: istore 5
    //   67: aload_1
    //   68: ldc 224
    //   70: invokevirtual 222	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   73: istore 6
    //   75: aload_1
    //   76: ldc 226
    //   78: invokevirtual 222	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   81: istore 8
    //   83: aload_1
    //   84: ldc 228
    //   86: invokevirtual 222	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   89: istore 9
    //   91: aload_1
    //   92: ldc 230
    //   94: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 14
    //   99: aload_1
    //   100: ldc 236
    //   102: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore 15
    //   107: aload_1
    //   108: ldc 238
    //   110: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 16
    //   115: aload_1
    //   116: ldc 240
    //   118: invokevirtual 222	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   121: istore 7
    //   123: aload_1
    //   124: ldc 242
    //   126: invokevirtual 222	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   129: iconst_1
    //   130: if_icmpne +617 -> 747
    //   133: iconst_1
    //   134: istore 4
    //   136: aload_1
    //   137: ldc 244
    //   139: invokevirtual 222	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   142: iconst_1
    //   143: if_icmpne +610 -> 753
    //   146: iconst_1
    //   147: istore 12
    //   149: aload_1
    //   150: ldc 246
    //   152: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 17
    //   157: aload_1
    //   158: ldc 248
    //   160: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 18
    //   165: aload_1
    //   166: ldc 250
    //   168: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 19
    //   173: aload_1
    //   174: ldc 252
    //   176: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore 20
    //   181: aload_1
    //   182: ldc 254
    //   184: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 21
    //   189: aload_1
    //   190: ldc_w 256
    //   193: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 22
    //   198: aload_1
    //   199: ldc_w 258
    //   202: iconst_0
    //   203: invokevirtual 261	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   206: istore 10
    //   208: aload_1
    //   209: ldc_w 263
    //   212: iconst_0
    //   213: invokevirtual 261	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   216: istore 11
    //   218: aload_1
    //   219: ldc_w 265
    //   222: iconst_0
    //   223: invokevirtual 269	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   226: istore 13
    //   228: aload_1
    //   229: ldc_w 271
    //   232: ldc 97
    //   234: invokevirtual 274	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   237: astore_1
    //   238: aload_1
    //   239: invokestatic 280	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   242: pop
    //   243: invokestatic 286	acej:aV	()F
    //   246: ldc_w 287
    //   249: fdiv
    //   250: fstore_3
    //   251: fconst_0
    //   252: fstore_2
    //   253: fload_3
    //   254: fconst_0
    //   255: fcmpl
    //   256: ifeq +9 -> 265
    //   259: invokestatic 292	aqgz:getDesity	()F
    //   262: fload_3
    //   263: fdiv
    //   264: fstore_2
    //   265: fload_2
    //   266: fconst_0
    //   267: fcmpl
    //   268: ifne +504 -> 772
    //   271: invokestatic 292	aqgz:getDesity	()F
    //   274: fstore_2
    //   275: aload_0
    //   276: getfield 118	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   279: invokevirtual 298	android/widget/FrameLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   282: checkcast 300	android/widget/RelativeLayout$LayoutParams
    //   285: astore_1
    //   286: aload_1
    //   287: iload 10
    //   289: i2f
    //   290: fload_2
    //   291: fmul
    //   292: f2i
    //   293: putfield 304	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   296: aload_1
    //   297: iload 11
    //   299: i2f
    //   300: fload_2
    //   301: fmul
    //   302: f2i
    //   303: putfield 307	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   306: aload_0
    //   307: getfield 118	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   310: aload_1
    //   311: invokevirtual 311	android/widget/FrameLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   314: new 313	android/widget/FrameLayout$LayoutParams
    //   317: dup
    //   318: iload 8
    //   320: i2f
    //   321: fload_2
    //   322: fmul
    //   323: f2i
    //   324: iload 9
    //   326: i2f
    //   327: fload_2
    //   328: fmul
    //   329: f2i
    //   330: invokespecial 316	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   333: astore 23
    //   335: aload 23
    //   337: iload 5
    //   339: iload 10
    //   341: isub
    //   342: i2f
    //   343: fload_2
    //   344: fmul
    //   345: f2i
    //   346: putfield 317	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   349: aload 23
    //   351: fload_2
    //   352: iload 6
    //   354: i2f
    //   355: fmul
    //   356: f2i
    //   357: putfield 320	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   360: new 322	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController
    //   363: dup
    //   364: aload_0
    //   365: getfield 197	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   368: invokevirtual 326	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   371: invokespecial 329	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:<init>	(Landroid/content/Context;)V
    //   374: astore_1
    //   375: aload_1
    //   376: ldc_w 330
    //   379: invokevirtual 334	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setBackgroundColor	(I)V
    //   382: iload 13
    //   384: ifeq +28 -> 412
    //   387: getstatic 339	android/os/Build$VERSION:SDK_INT	I
    //   390: bipush 21
    //   392: if_icmplt +20 -> 412
    //   395: aload_1
    //   396: new 341	tbg
    //   399: dup
    //   400: aload_0
    //   401: invokespecial 342	tbg:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   404: invokevirtual 346	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setOutlineProvider	(Landroid/view/ViewOutlineProvider;)V
    //   407: aload_1
    //   408: iconst_1
    //   409: invokevirtual 350	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setClipToOutline	(Z)V
    //   412: aload_1
    //   413: invokevirtual 353	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:dpS	()V
    //   416: aload_1
    //   417: invokevirtual 356	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:dpT	()V
    //   420: new 294	android/widget/FrameLayout
    //   423: dup
    //   424: aload_0
    //   425: getfield 197	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   428: invokevirtual 326	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   431: invokespecial 357	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   434: astore 24
    //   436: aload_1
    //   437: aload 24
    //   439: new 313	android/widget/FrameLayout$LayoutParams
    //   442: dup
    //   443: iconst_m1
    //   444: iconst_m1
    //   445: invokespecial 316	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   448: invokevirtual 361	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   451: aload_0
    //   452: getfield 118	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoContainer	Landroid/widget/FrameLayout;
    //   455: aload_1
    //   456: aload 23
    //   458: invokevirtual 362	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   461: aload_0
    //   462: getfield 197	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   465: invokevirtual 366	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   468: checkcast 368	com/tencent/biz/ui/TouchWebView
    //   471: checkcast 368	com/tencent/biz/ui/TouchWebView
    //   474: aload_0
    //   475: getfield 370	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mScrollChangedListener	Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;
    //   478: invokevirtual 374	com/tencent/biz/ui/TouchWebView:setOnScrollChangedListener	(Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;)V
    //   481: new 140	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   488: aload 14
    //   490: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload 15
    //   495: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokevirtual 380	java/lang/String:hashCode	()I
    //   504: invokestatic 386	java/lang/Math:abs	(I)I
    //   507: istore 8
    //   509: aload_1
    //   510: iload 8
    //   512: invokevirtual 389	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoId	(I)V
    //   515: new 9	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b
    //   518: dup
    //   519: aload_1
    //   520: aload 24
    //   522: new 101	java/util/HashMap
    //   525: dup
    //   526: invokespecial 102	java/util/HashMap:<init>	()V
    //   529: invokespecial 392	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:<init>	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;Landroid/widget/FrameLayout;Ljava/util/Map;)V
    //   532: astore 23
    //   534: aload 23
    //   536: aload 14
    //   538: putfield 394	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:vid	Ljava/lang/String;
    //   541: aload 23
    //   543: iload 12
    //   545: putfield 396	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:autoPlay	Z
    //   548: aload 23
    //   550: iload 6
    //   552: putfield 399	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:left	I
    //   555: aload 23
    //   557: iload 5
    //   559: putfield 402	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:top	I
    //   562: aload 23
    //   564: iload 8
    //   566: putfield 405	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:id	I
    //   569: aload 23
    //   571: iload 7
    //   573: putfield 408	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:bAU	I
    //   576: aload 23
    //   578: aload 16
    //   580: putfield 410	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:protocol	Ljava/lang/String;
    //   583: aload 23
    //   585: aload 17
    //   587: putfield 413	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:aIH	Ljava/lang/String;
    //   590: aload 23
    //   592: aload 18
    //   594: putfield 416	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:aII	Ljava/lang/String;
    //   597: aload 23
    //   599: aload 20
    //   601: putfield 419	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:aIK	Ljava/lang/String;
    //   604: aload 23
    //   606: aload 19
    //   608: putfield 422	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:aIJ	Ljava/lang/String;
    //   611: aload 23
    //   613: aload 21
    //   615: putfield 425	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:aIL	Ljava/lang/String;
    //   618: aload 23
    //   620: aload 22
    //   622: putfield 428	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript$b:aIM	Ljava/lang/String;
    //   625: aload_0
    //   626: getfield 104	com/tencent/gamecenter/common/util/GameCenterAPIJavaScript:mVideoViewMap	Ljava/util/Map;
    //   629: iload 8
    //   631: invokestatic 434	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   634: aload 23
    //   636: invokeinterface 439 3 0
    //   641: pop
    //   642: new 441	com/tencent/mobileqq/gamecenter/data/FeedsItemData
    //   645: dup
    //   646: invokespecial 442	com/tencent/mobileqq/gamecenter/data/FeedsItemData:<init>	()V
    //   649: astore 16
    //   651: aload 16
    //   653: aload 14
    //   655: putfield 445	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoVid	Ljava/lang/String;
    //   658: iload 7
    //   660: iconst_1
    //   661: if_icmpne +98 -> 759
    //   664: aload 16
    //   666: iconst_2
    //   667: putfield 448	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   670: aload 16
    //   672: aload 15
    //   674: putfield 451	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoUrl	Ljava/lang/String;
    //   677: aload_1
    //   678: aload 16
    //   680: iconst_1
    //   681: invokevirtual 455	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setData	(Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;I)V
    //   684: iload 12
    //   686: ifeq +7 -> 693
    //   689: aload_1
    //   690: invokevirtual 458	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:dpN	()V
    //   693: iload 4
    //   695: ifeq +8 -> 703
    //   698: aload_1
    //   699: iconst_1
    //   700: invokevirtual 461	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setMute	(Z)V
    //   703: aload_1
    //   704: new 463	tbh
    //   707: dup
    //   708: aload_0
    //   709: invokespecial 464	tbh:<init>	(Lcom/tencent/gamecenter/common/util/GameCenterAPIJavaScript;)V
    //   712: invokevirtual 468	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoStatusChangerListener	(Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController$a;)V
    //   715: iload 8
    //   717: ireturn
    //   718: astore_1
    //   719: ldc 42
    //   721: iconst_1
    //   722: new 140	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 470
    //   732: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload_1
    //   736: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   739: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   745: iconst_m1
    //   746: ireturn
    //   747: iconst_0
    //   748: istore 4
    //   750: goto -614 -> 136
    //   753: iconst_0
    //   754: istore 12
    //   756: goto -607 -> 149
    //   759: aload 16
    //   761: iconst_1
    //   762: putfield 448	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   765: goto -95 -> 670
    //   768: astore_1
    //   769: goto -526 -> 243
    //   772: goto -497 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	775	0	this	GameCenterAPIJavaScript
    //   0	775	1	paramJSONObject	JSONObject
    //   252	100	2	f1	float
    //   250	13	3	f2	float
    //   134	615	4	i	int
    //   65	493	5	j	int
    //   73	478	6	k	int
    //   121	541	7	m	int
    //   81	635	8	n	int
    //   89	236	9	i1	int
    //   206	136	10	i2	int
    //   216	82	11	i3	int
    //   147	608	12	bool1	boolean
    //   226	157	13	bool2	boolean
    //   97	557	14	str1	String
    //   105	568	15	str2	String
    //   113	647	16	localObject1	Object
    //   155	431	17	str3	String
    //   163	430	18	str4	String
    //   171	436	19	str5	String
    //   179	421	20	str6	String
    //   187	427	21	str7	String
    //   196	425	22	str8	String
    //   333	302	23	localObject2	Object
    //   434	87	24	localFrameLayout	FrameLayout
    // Exception table:
    //   from	to	target	type
    //   59	133	718	java/lang/Exception
    //   136	146	718	java/lang/Exception
    //   149	238	718	java/lang/Exception
    //   243	251	718	java/lang/Exception
    //   259	265	718	java/lang/Exception
    //   271	275	718	java/lang/Exception
    //   275	382	718	java/lang/Exception
    //   387	412	718	java/lang/Exception
    //   412	658	718	java/lang/Exception
    //   664	670	718	java/lang/Exception
    //   670	684	718	java/lang/Exception
    //   689	693	718	java/lang/Exception
    //   698	703	718	java/lang/Exception
    //   703	715	718	java/lang/Exception
    //   759	765	718	java/lang/Exception
    //   238	243	768	java/lang/Exception
  }
  
  public int delFlag(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("pid");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = (b)this.mVideoViewMap.get(Integer.valueOf(i));
        View localView = (View)paramJSONObject.gB.get(Integer.valueOf(j));
        paramJSONObject.aP.removeView(localView);
        paramJSONObject.gB.remove(Integer.valueOf(j));
        return 0;
      }
      QLog.e("GCApi", 1, "[setText] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setText Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public int delText(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("pid");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = (b)this.mVideoViewMap.get(Integer.valueOf(i));
        View localView = (View)paramJSONObject.gB.get(Integer.valueOf(j));
        paramJSONObject.aP.removeView(localView);
        paramJSONObject.gB.remove(Integer.valueOf(j));
        return 0;
      }
      QLog.e("GCApi", 1, "[setText] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setText Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public int destoryVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = ((b)this.mVideoViewMap.get(Integer.valueOf(i))).a;
        paramJSONObject.stop();
        paramJSONObject.release();
        this.mVideoContainer.removeView(paramJSONObject);
        this.mVideoContainer.removeView(((b)this.mVideoViewMap.get(Integer.valueOf(i))).aP);
        this.mVideoViewMap.remove(Integer.valueOf(i));
      }
      else
      {
        QLog.e("GCApi", 1, "[destoryVideo] Err: not find videoPlayer");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "[destoryVideo] Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  public String getOpenidBatch(String paramString)
  {
    String str = "";
    if ((this.mContext instanceof GameCenterActivity)) {
      str = GameCenterActivity.a(this.mContext, "https://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.uin);
    }
    return str;
  }
  
  public long getProgress(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        return ((b)this.mVideoViewMap.get(Integer.valueOf(i))).a.getCurrentPostion();
      }
      QLog.e("GCApi", 1, "[getProgress] Err: not find videoPlayer");
      return -1L;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "getProgress Err:" + paramJSONObject.toString());
    }
    return -1L;
  }
  
  public String getReportPublicData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append("" + arxr.getImei());
      localStringBuilder.append("|");
      localStringBuilder.append("" + arxr.Dy());
      localStringBuilder.append("|");
      localStringBuilder.append("" + tbc.ar(this.mContext.getApplicationContext()));
      localStringBuilder.append("|");
      localStringBuilder.append("" + Build.MODEL);
      return localStringBuilder.toString();
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String getReportPublicHighData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append("" + tbc.getLocalIpAddress());
      localStringBuilder.append("|");
      localStringBuilder.append("" + arwo.bE(this.mContext.getApplicationContext()));
      localStringBuilder.append("|");
      localStringBuilder.append("" + Build.VERSION.RELEASE);
      localStringBuilder.append("|");
      localStringBuilder.append("" + aroi.a().getVersionName());
      localStringBuilder.append("|");
      localStringBuilder.append(AppSetting.getAppId());
      localStringBuilder.append("|");
      localStringBuilder.append(this.dm.widthPixels + " * " + this.dm.heightPixels);
      return localStringBuilder.toString();
    }
    catch (Exception localException) {}
    return "";
  }
  
  public long getTotalDuration(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        return ((b)this.mVideoViewMap.get(Integer.valueOf(i))).a.getDuration();
      }
      QLog.e("GCApi", 1, "[getProgress] Err: not find videoPlayer");
      return -1L;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "getProgress Err:" + paramJSONObject.toString());
    }
    return -1L;
  }
  
  public String getVersionName()
  {
    try
    {
      String str = aroi.a().getVersionName();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "4.3.0";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("GCApi", 2, "[handleJsRequest] method:" + paramString3 + "params:" + paramVarArgs[0]);
    }
    if ("GCApi".equals(paramString2))
    {
      if (METHOD_GET_SESSION_INFO.equals(paramString3)) {}
      for (;;)
      {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString1.optString("callback");
          this.mReqBundle.clear();
          this.mReqBundle.putInt("dataType", paramString1.optInt("dataType", 0));
          super.sendRemoteReq(affz.a("ipc_cmd_gamecenter_get_session_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          paramString1 = null;
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
          paramString1 = null;
          continue;
        }
        if ((paramJsBridgeListener != null) && (paramString1 != null)) {
          paramJsBridgeListener.onComplete(paramString1);
        }
        return true;
        if (METHOD_GET_REQUEST_INFO.equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramString2 = paramString1.optString("callback");
            this.mReqBundle.clear();
            this.mReqBundle.putString("gameId", paramString1.optString("gameId", ""));
            super.sendRemoteReq(affz.a("ipc_cmd_gamecenter_get_request_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if (METHOD_OPEN_AIO.equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramString2 = paramString1.optString("callback");
            this.mReqBundle.clear();
            this.mReqBundle.putString("sessionId", paramString1.optString("sessionId", ""));
            super.sendRemoteReq(affz.a("ipc_cmd_gamecenter_open_aio", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if (METHOD_GET_UNREAD_TOTAL.equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
            this.mReqBundle.clear();
            super.sendRemoteReq(affz.a("ipc_cmd_gamecenter_get_unread_total", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if (METHOD_TOGGLE_CHANGE.equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramString2 = paramString1.optString("callback");
            this.mReqBundle.clear();
            this.mReqBundle.putString("gameId", paramString1.optString("gameId", ""));
            this.mReqBundle.putInt("switchType", paramString1.optInt("switchType", -1));
            this.mReqBundle.putInt("value", paramString1.optInt("value", -1));
            super.sendRemoteReq(affz.a("ipc_cmd_gamecenter_toggle_changed", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("createVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            int j = createVideo(paramString2);
            if (j > 0) {}
            for (;;)
            {
              paramString2 = new JSONObject();
              paramString2.put("ret", i);
              paramString2.put("id", j);
              super.callJs(paramString1 + "(" + paramString2.toString() + ");");
              paramString1 = null;
              break;
              i = j;
            }
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("destoryVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = destoryVideo(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("playVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = playVideo(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("pauseVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = pauseVideo(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("stopVideo".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = stopVideo(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setPosition".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setPosition(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setFlag".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setFlag(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", 0);
            paramString2.put("pid", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("delFlag".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = delFlag(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setText".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setText(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", 0);
            paramString2.put("pid", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("delText".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = delText(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setFullScreen".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setFullScreen(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("setMute".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            i = setMute(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", i);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if ("getProgress".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("callback");
            long l1 = getProgress(paramString2);
            long l2 = getTotalDuration(paramString2);
            paramString2 = new JSONObject();
            paramString2.put("ret", 0);
            paramString2.put("current", l1);
            paramString2.put("total", l2);
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
        else if (("getOpenidBatch".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          paramString1 = getOpenidBatch(paramVarArgs[0]);
        }
        else if (("showWarningToast".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          showWarningToast(paramVarArgs[0]);
          paramString1 = null;
        }
        else if ("getUin".equals(paramString3))
        {
          paramString1 = this.uin;
        }
        else if (("setTitleLoading".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          setTitleLoading(paramVarArgs[0]);
          paramString1 = null;
        }
        else if ("getReportPublicData".equals(paramString3))
        {
          paramString1 = getReportPublicData();
        }
        else if ("getReportPublicHighData".equals(paramString3))
        {
          paramString1 = getReportPublicHighData();
        }
        else if (("reportAction".equals(paramString3)) && (paramVarArgs.length == 3))
        {
          reportAction(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
          paramString1 = null;
        }
        else if ("getVersionName".equals(paramString3))
        {
          paramString1 = getVersionName();
        }
        else if (("startToAuthorized".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          startToAuthorized(paramVarArgs[0]);
          paramString1 = null;
        }
        else
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramString2 = paramString1.optString("callback");
            handleScreenShotMethod(paramString3, paramString1.optJSONObject("data"), paramString2);
            paramString1 = null;
          }
          catch (JSONException paramString1)
          {
            QLog.e("GCApi", 1, "handleScreenShotMethod e=" + paramString1.toString());
            paramString1 = null;
          }
        }
      }
    }
    return false;
  }
  
  public boolean handleScreenShotMethod(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    paramString2 = new tbd(this, paramString2);
    if ("shotScreen".equals(paramString1))
    {
      tbl.a().a(this.mRuntime.getWebView(), paramJSONObject.optString("key"), paramString2);
      return true;
    }
    if ("removeMask".equals(paramString1))
    {
      tbl.a().a(this.mRuntime.getWebView(), paramString2);
      return true;
    }
    if ("delImg".equals(paramString1))
    {
      tbl.a().a(paramString2);
      return true;
    }
    if ("closeSwitch".equals(paramString1))
    {
      tbl.a().b(paramString2);
      return true;
    }
    if ("openSwitch".equals(paramString1))
    {
      tbl.a().c(paramString2);
      return true;
    }
    if ("queryInfo".equals(paramString1))
    {
      tbl.a().a(paramJSONObject.optString("key"), paramString2);
      return true;
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    this.dm = new DisplayMetrics();
    this.mContext = this.mRuntime.getActivity();
    if (this.mContext != null) {
      ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics(this.dm);
    }
    if (this.mRuntime.a() != null) {
      this.uin = this.mRuntime.a().getCurrentAccountUin();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_messgae_change");
    localIntentFilter.addAction("action_qgame_unread_change");
    BaseApplicationImpl.getApplication().registerReceiver(this.mMsgReceiver, localIntentFilter);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mMsgReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.mMsgReceiver);
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
    Object localObject;
    int i;
    String str;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("cmd");
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 1, "[onResponse] cmd:" + (String)localObject);
      }
      i = paramBundle.getInt("respkey", 0);
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 1, "[onResponse] respkey:" + i + "，key:" + this.mOnRemoteResp.key);
      }
      if (i == this.mOnRemoteResp.key)
      {
        str = paramBundle.getString("callbackid");
        paramBundle = paramBundle.getBundle("response");
        if ((localObject != null) && (paramBundle != null))
        {
          Activity localActivity = this.mRuntime.getActivity();
          if ((localActivity != null) && (!this.isDestroy) && (!localActivity.isFinishing())) {
            break label182;
          }
          callbackError(str, "-1000");
        }
      }
    }
    label182:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              if ("ipc_cmd_gamecenter_get_session_info".equals(localObject))
              {
                i = paramBundle.getInt("result");
                paramBundle = paramBundle.getString("data");
                localObject = new JSONObject(paramBundle);
                ((JSONObject)localObject).put("ret", i);
                super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject).toString() + ");");
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("GCApi", 2, "ipc_cmd_gamecenter_get_session_info onResponse dataStr is:" + paramBundle);
              }
            }
            catch (Throwable paramBundle)
            {
              if (QLog.isColorLevel()) {
                QLog.e("GCApi", 2, paramBundle.getMessage());
              }
              callbackError(str, "-2000");
              return;
            }
          }
          if (!"ipc_cmd_gamecenter_get_request_info".equals(localObject)) {
            break;
          }
          i = paramBundle.getInt("result");
          paramBundle = paramBundle.getString("data");
          localObject = new JSONObject(paramBundle);
          ((JSONObject)localObject).put("ret", i);
          super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject).toString() + ");");
        } while (!QLog.isColorLevel());
        QLog.d("GCApi", 2, "ipc_cmd_gamecenter_get_request_info onResponse dataStr is:" + paramBundle);
        return;
        if ("ipc_cmd_gamecenter_open_aio".equals(localObject))
        {
          i = paramBundle.getInt("result", -1);
          paramBundle = new JSONObject();
          paramBundle.put("ret", i);
          super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
          return;
        }
        if (!"ipc_cmd_gamecenter_get_unread_total".equals(localObject)) {
          break;
        }
        i = paramBundle.getInt("result");
        localObject = new JSONObject();
        ((JSONObject)localObject).put("ret", i);
        ((JSONObject)localObject).put("newMsgCount", paramBundle.getInt("cnt"));
        super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject).toString() + ");");
      } while (!QLog.isColorLevel());
      QLog.d("GCApi", 2, "ipc_cmd_gamecenter_get_request_info onResponse dataStr is:" + ((JSONObject)localObject).toString());
      return;
    } while (!"ipc_cmd_gamecenter_toggle_changed".equals(localObject));
    callbackOk(str);
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    RefreshView localRefreshView = (RefreshView)this.mRuntime.getActivity().findViewById(2131382187);
    this.mVideoContainer = new GameCenterAPIJavaScript.2(this, this.mRuntime.getActivity(), paramCustomWebView);
    localRefreshView.addView(this.mVideoContainer, localLayoutParams);
    paramCustomWebView = (TouchWebView)this.mRuntime.getWebView();
    this.mVideoContainer.scrollBy(0, paramCustomWebView.mTotalYoffset);
    this.mScrollChangedListener = new tbe(this);
    paramCustomWebView = this.mRuntime.getActivity();
    if ((paramCustomWebView instanceof GameCenterActivity)) {
      ((GameCenterActivity)paramCustomWebView).setOnScrollChangedListener(this.mScrollChangedListener);
    }
  }
  
  public int pauseVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        ((b)this.mVideoViewMap.get(Integer.valueOf(i))).a.pause();
        new JSONObject();
      }
      else
      {
        QLog.e("GCApi", 1, "[pauseVideo] Err: not find videoPlayer");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "pauseVideo Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  public int playVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        ((b)this.mVideoViewMap.get(Integer.valueOf(i))).a.play();
      } else {
        QLog.e("GCApi", 1, "[playVideo] Err: not find videoPlayer");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "playVideo Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3)
  {
    anpc.a(BaseApplication.getContext()).a(this.mRuntime.a(), this.uin, paramString1, paramString2, 0, 1, paramString3, null, null, null, null);
  }
  
  public int setFlag(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("y");
      int k = paramJSONObject.optInt("x");
      int m = paramJSONObject.optInt("width");
      int n = paramJSONObject.optInt("height");
      paramJSONObject = paramJSONObject.optString("pic");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        FrameLayout localFrameLayout = ((b)this.mVideoViewMap.get(Integer.valueOf(i))).aP;
        URLImageView localURLImageView = new URLImageView(this.mContext);
        float f = this.mRuntime.getActivity().getResources().getDisplayMetrics().density;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(m * f), (int)(n * f));
        localLayoutParams.topMargin = ((int)(j * f));
        localLayoutParams.leftMargin = ((int)(k * f));
        localFrameLayout.addView(localURLImageView, localLayoutParams);
        j = localURLImageView.hashCode();
        ((b)this.mVideoViewMap.get(Integer.valueOf(i))).gB.put(Integer.valueOf(j), localURLImageView);
        localURLImageView.setImageURL(paramJSONObject);
        return j;
      }
      QLog.e("GCApi", 1, "[setFlag] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setFlag Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public int setFullScreen(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      boolean bool = paramJSONObject.optBoolean("fullscreen");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = ((b)this.mVideoViewMap.get(Integer.valueOf(i))).a;
        if (bool) {
          paramJSONObject.aVf();
        } else {
          paramJSONObject.aUp();
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setFullScreen Err:" + paramJSONObject.toString());
      return -1;
    }
    QLog.e("GCApi", 1, "[setFullScreen] Err: not find videoPlayer");
    return -1;
    return 0;
  }
  
  public int setMute(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      boolean bool = paramJSONObject.optBoolean("mute");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        ((b)this.mVideoViewMap.get(Integer.valueOf(i))).a.setMute(bool);
        return 0;
      }
      QLog.e("GCApi", 1, "[setMute] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setMute Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public int setPosition(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("y");
      int k = paramJSONObject.optInt("x");
      int m = paramJSONObject.optInt("tabHeight", 0);
      int n = paramJSONObject.optInt("bottomHeight", 0);
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = ((b)this.mVideoViewMap.get(Integer.valueOf(i))).a;
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramJSONObject.getLayoutParams();
        float f = this.mRuntime.getActivity().getResources().getDisplayMetrics().density;
        localLayoutParams.topMargin = ((int)((j - m) * f));
        localLayoutParams.leftMargin = ((int)((k - n) * f));
        paramJSONObject.setLayoutParams(localLayoutParams);
      }
      else
      {
        QLog.e("GCApi", 1, "[setPostion] Err: not find videoPlayer");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setPostion Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  public int setText(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      int j = paramJSONObject.optInt("y");
      int k = paramJSONObject.optInt("x");
      int m = paramJSONObject.optInt("fontsize", 10);
      Object localObject = paramJSONObject.optString("color");
      String str = paramJSONObject.optString("txt");
      boolean bool = paramJSONObject.optBoolean("border", false);
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null)
      {
        paramJSONObject = ((b)this.mVideoViewMap.get(Integer.valueOf(i))).aP;
        TextView localTextView = new TextView(this.mContext);
        if (bool) {
          localTextView.setBackgroundResource(2130840538);
        }
        float f = this.mRuntime.getActivity().getResources().getDisplayMetrics().density;
        localTextView.setPadding(wja.dp2px(3.0F, this.mContext.getResources()), wja.dp2px(3.0F, this.mContext.getResources()), wja.dp2px(3.0F, this.mContext.getResources()), wja.dp2px(3.0F, this.mContext.getResources()));
        localTextView.setText(str);
        localTextView.setTextSize(m);
        localTextView.setTextColor(Color.parseColor((String)localObject));
        m = localTextView.hashCode();
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(j * f));
        ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(k * f));
        paramJSONObject.addView(localTextView, (ViewGroup.LayoutParams)localObject);
        ((b)this.mVideoViewMap.get(Integer.valueOf(i))).gB.put(Integer.valueOf(m), localTextView);
        return m;
      }
      QLog.e("GCApi", 1, "[setText] Err: not find videoPlayer");
      return -1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "setText Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public void setTitleLoading(String paramString)
  {
    if ((this.mContext instanceof GameCenterActivity)) {
      try
      {
        if ("true".equals(paramString)) {}
        for (int i = 1; i != 0; i = 0)
        {
          ((GameCenterActivity)this.mContext).bE.sendEmptyMessage(2003);
          return;
          if (!"false".equals(paramString)) {
            return;
          }
        }
        ((GameCenterActivity)this.mContext).bE.sendEmptyMessage(2004);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void showWarningToast(String paramString)
  {
    if ((this.mContext instanceof GameCenterActivity)) {}
    try
    {
      Message localMessage = Message.obtain(((GameCenterActivity)this.mContext).bE);
      localMessage.what = 2006;
      localMessage.obj = paramString;
      ((GameCenterActivity)this.mContext).bE.sendMessage(localMessage);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void startToAuthorized(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("uin", this.uin);
      localObject = ((JSONObject)localObject).toString();
      paramString = (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    arzk.a().a(paramString, null, (Activity)this.mContext);
  }
  
  public int stopVideo(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("id");
      if (this.mVideoViewMap.get(Integer.valueOf(i)) != null) {
        ((b)this.mVideoViewMap.get(Integer.valueOf(i))).a.stop();
      } else {
        QLog.e("GCApi", 1, "[stopVideo] Err: not find videoPlayer");
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("GCApi", 1, "stopVideo Err:" + paramJSONObject.toString());
      return -1;
    }
    return 0;
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = null;
      String str = paramIntent.getAction();
      if (QLog.isColorLevel())
      {
        if ("[onRecevier] action:" + str + ",data:" + paramIntent.getExtras() != null) {
          paramContext = paramIntent.getExtras().toString();
        }
        QLog.d("GCApi", 2, paramContext);
      }
      if (str == null) {}
      do
      {
        do
        {
          for (;;)
          {
            return;
            if ("action_qgame_messgae_change".equals(str))
            {
              paramIntent = paramIntent.getExtras();
              if (paramIntent == null) {
                continue;
              }
              paramContext = (GameCenterSessionInfo)paramIntent.getParcelable("key_game_msg");
              i = paramIntent.getInt("key_msg_change_type");
              if (QLog.isColorLevel()) {
                QLog.d("GCApi", 0, "[onReceive] type:" + i + ",info:" + paramContext);
              }
              paramIntent = new JSONArray();
              if (paramContext != null) {
                paramIntent.put(paramContext.aa());
              }
              try
              {
                paramContext = new JSONObject();
                paramContext.put("session", paramIntent);
                paramContext.put("eventType", i);
                paramContext.put("ret", 0);
                GameCenterAPIJavaScript.this.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_UPDATE_SESSION_INFO, paramContext, null);
                if (QLog.isColorLevel())
                {
                  QLog.d("GCApi", 2, "[onReceive] gameCenterMsg: " + paramContext.toString());
                  return;
                }
              }
              catch (Exception paramContext)
              {
                return;
              }
            }
          }
        } while (!"action_qgame_unread_change".equals(str));
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      int i = paramContext.getInt("key_msg_unread_cnt");
      if (QLog.isColorLevel()) {
        QLog.d("GCApi", 2, "[onReceive] cnt:" + i);
      }
      try
      {
        paramContext = new JSONObject();
        paramContext.put("newMsgCount", i);
        paramContext.put("ret", 0);
        GameCenterAPIJavaScript.this.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_UPDATE_UNREAD_CNT, paramContext, null);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("GCApi", 1, paramContext, new Object[0]);
      }
    }
  }
  
  public static class b
  {
    public GameCenterVideoViewController a;
    public String aIH;
    public String aII;
    public String aIJ;
    public String aIK;
    public String aIL;
    public String aIM;
    public boolean aOC;
    public FrameLayout aP;
    public boolean autoPlay;
    public int bAU;
    public Map<Integer, View> gB;
    public int id;
    public boolean isFullScreen;
    public int left;
    public String protocol;
    public int top;
    public String url;
    public String vid;
    
    public b(GameCenterVideoViewController paramGameCenterVideoViewController, FrameLayout paramFrameLayout, Map<Integer, View> paramMap)
    {
      this.a = paramGameCenterVideoViewController;
      this.aP = paramFrameLayout;
      this.gB = paramMap;
    }
    
    public String oc()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("id", this.id);
        localJSONObject.put("x", this.left);
        localJSONObject.put("y", this.top);
        localJSONObject.put("vid", this.vid);
        localJSONObject.put("url", this.url);
        localJSONObject.put("streamType", this.bAU);
        localJSONObject.put("protocol", this.protocol);
        localJSONObject.put("mute", this.a.getOutputMute());
        localJSONObject.put("total", this.a.getDuration());
        localJSONObject.put("current", this.a.getCurrentPostion());
        localJSONObject.put("autoPlay", this.autoPlay);
        localJSONObject.put("isFullScreen", this.isFullScreen);
        return localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */