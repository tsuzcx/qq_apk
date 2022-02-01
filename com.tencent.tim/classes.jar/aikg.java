import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.data.VideoUploadTask;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class aikg
  extends WebViewPlugin
{
  String So;
  acnd jdField_a_of_type_Acnd = new aikk(this);
  VideoUploadTask jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask;
  AtomicBoolean ac = new AtomicBoolean(false);
  String bOu;
  String bOv;
  String bOw;
  String bOx;
  String bOy;
  String bOz;
  int ddF;
  int ddG;
  skj h;
  ImageView ko;
  skj mClient = null;
  
  public aikg()
  {
    this.mPluginNameSpace = "troopApi";
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      Intent localIntent = AddFriendLogicActivity.a(getCurrentContext(), paramTroopInfo.troopuin, paramTroopInfo.getTroopName(), paramTroopInfo.cGroupOption, this.ddG, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.bOw, this.bOx);
      this.ddF = paramTroopInfo.cGroupOption;
      startActivityForResult(localIntent, (byte)3);
      return;
    }
    this.ddF = -1;
    showToast(2131721390);
  }
  
  private void ba(int paramInt1, int paramInt2)
  {
    if (this.mRuntime.getActivity() != null) {
      QQToast.a(this.mRuntime.getActivity(), paramInt2, this.mRuntime.getActivity().getString(paramInt1), 0).show(this.mRuntime.getActivity().getResources().getDimensionPixelSize(2131299627));
    }
  }
  
  private Context getCurrentContext()
  {
    for (Activity localActivity = this.mRuntime.getActivity(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void m(TroopInfo paramTroopInfo)
  {
    this.mClient.y(paramTroopInfo.troopuin, this.ddG, this.So);
  }
  
  private void showToast(int paramInt)
  {
    ba(paramInt, 0);
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 47
    //   2: aload_3
    //   3: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: ldc 176
    //   13: aload 4
    //   15: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +5 -> 23
    //   21: iconst_1
    //   22: ireturn
    //   23: ldc 178
    //   25: aload 4
    //   27: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifne -9 -> 21
    //   33: ldc 180
    //   35: aload 4
    //   37: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +127 -> 167
    //   43: new 182	org/json/JSONObject
    //   46: dup
    //   47: aload 5
    //   49: iconst_0
    //   50: aaload
    //   51: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   54: astore_3
    //   55: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +28 -> 86
    //   61: ldc 193
    //   63: iconst_2
    //   64: new 195	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   71: ldc 198
    //   73: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_3
    //   77: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload_3
    //   87: ldc 213
    //   89: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_1
    //   93: aload_3
    //   94: ldc 219
    //   96: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore_2
    //   100: aload_3
    //   101: ldc 221
    //   103: invokevirtual 225	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   106: lstore 8
    //   108: aload_3
    //   109: ldc 227
    //   111: invokevirtual 225	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   114: lstore 10
    //   116: aload_3
    //   117: ldc 229
    //   119: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_3
    //   123: aload_0
    //   124: getfield 38	aikg:mClient	Lskj;
    //   127: aload_1
    //   128: aload_2
    //   129: new 231	aikh
    //   132: dup
    //   133: aload_0
    //   134: lload 8
    //   136: lload 10
    //   138: aload_3
    //   139: invokespecial 234	aikh:<init>	(Laikg;JJLjava/lang/String;)V
    //   142: invokevirtual 237	skj:b	(Ljava/lang/String;Ljava/lang/String;Lskj$a;)V
    //   145: goto -124 -> 21
    //   148: astore_1
    //   149: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq -131 -> 21
    //   155: ldc 193
    //   157: iconst_2
    //   158: ldc 239
    //   160: aload_1
    //   161: invokestatic 243	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: goto -143 -> 21
    //   167: ldc 245
    //   169: aload 4
    //   171: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifeq +377 -> 551
    //   177: new 182	org/json/JSONObject
    //   180: dup
    //   181: aload 5
    //   183: iconst_0
    //   184: aaload
    //   185: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   188: astore_2
    //   189: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +28 -> 220
    //   195: ldc 247
    //   197: iconst_2
    //   198: new 195	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   205: ldc 249
    //   207: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_2
    //   221: ldc 213
    //   223: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore_1
    //   227: aload_2
    //   228: ldc 251
    //   230: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   233: astore_2
    //   234: invokestatic 256	apdg:a	()Lapdg;
    //   237: aload_1
    //   238: aload_2
    //   239: invokevirtual 260	apdg:bN	(Ljava/lang/String;Ljava/lang/String;)Z
    //   242: ifeq -221 -> 21
    //   245: aload_0
    //   246: getfield 115	aikg:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   249: invokevirtual 121	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   252: astore_2
    //   253: aload_0
    //   254: getfield 115	aikg:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   257: invokevirtual 263	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   260: astore_1
    //   261: aload_2
    //   262: ifnull +154 -> 416
    //   265: aload_2
    //   266: instanceof 265
    //   269: ifeq +147 -> 416
    //   272: aload_2
    //   273: checkcast 265	com/tencent/biz/webviewbase/AbsBaseWebViewActivity
    //   276: astore_1
    //   277: aload_1
    //   278: getfield 268	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:rightViewImg	Landroid/widget/ImageView;
    //   281: iconst_0
    //   282: invokevirtual 273	android/widget/ImageView:setVisibility	(I)V
    //   285: aload_0
    //   286: new 270	android/widget/ImageView
    //   289: dup
    //   290: aload_1
    //   291: invokespecial 276	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   294: putfield 278	aikg:ko	Landroid/widget/ImageView;
    //   297: aload_1
    //   298: ldc_w 279
    //   301: invokevirtual 283	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:findViewById	(I)Landroid/view/View;
    //   304: checkcast 285	android/widget/RelativeLayout
    //   307: astore_2
    //   308: aload_2
    //   309: ifnull -288 -> 21
    //   312: new 287	android/widget/RelativeLayout$LayoutParams
    //   315: dup
    //   316: bipush 254
    //   318: bipush 254
    //   320: invokespecial 289	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   323: astore_3
    //   324: aload_3
    //   325: bipush 7
    //   327: ldc_w 290
    //   330: invokevirtual 293	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   333: aload_3
    //   334: iconst_0
    //   335: ldc_w 294
    //   338: aload_1
    //   339: invokevirtual 295	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:getResources	()Landroid/content/res/Resources;
    //   342: invokestatic 301	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   345: ldc_w 294
    //   348: aload_1
    //   349: invokevirtual 295	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:getResources	()Landroid/content/res/Resources;
    //   352: invokestatic 301	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   355: iconst_0
    //   356: invokevirtual 305	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   359: aload_0
    //   360: getfield 278	aikg:ko	Landroid/widget/ImageView;
    //   363: aload_3
    //   364: invokevirtual 309	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   367: aload_0
    //   368: getfield 278	aikg:ko	Landroid/widget/ImageView;
    //   371: iconst_0
    //   372: invokevirtual 273	android/widget/ImageView:setVisibility	(I)V
    //   375: aload_0
    //   376: getfield 278	aikg:ko	Landroid/widget/ImageView;
    //   379: ldc_w 310
    //   382: invokevirtual 313	android/widget/ImageView:setImageResource	(I)V
    //   385: aload_2
    //   386: aload_0
    //   387: getfield 278	aikg:ko	Landroid/widget/ImageView;
    //   390: invokevirtual 317	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   393: goto -372 -> 21
    //   396: astore_1
    //   397: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq -379 -> 21
    //   403: ldc 247
    //   405: iconst_2
    //   406: ldc_w 319
    //   409: aload_1
    //   410: invokestatic 243	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: goto -392 -> 21
    //   416: aload_1
    //   417: ifnull -396 -> 21
    //   420: aload_1
    //   421: getfield 324	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Aqzl	Laqzl;
    //   424: getfield 327	aqzl:rightViewImg	Landroid/widget/ImageView;
    //   427: iconst_0
    //   428: invokevirtual 273	android/widget/ImageView:setVisibility	(I)V
    //   431: aload_0
    //   432: new 270	android/widget/ImageView
    //   435: dup
    //   436: aload_1
    //   437: invokevirtual 330	com/tencent/mobileqq/webview/swift/WebViewFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   440: invokespecial 276	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   443: putfield 278	aikg:ko	Landroid/widget/ImageView;
    //   446: aload_1
    //   447: getfield 333	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Arcd	Larcd;
    //   450: getfield 339	arcd:mRootView	Landroid/view/ViewGroup;
    //   453: ldc_w 279
    //   456: invokevirtual 342	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   459: checkcast 285	android/widget/RelativeLayout
    //   462: astore_2
    //   463: aload_2
    //   464: ifnull -443 -> 21
    //   467: new 287	android/widget/RelativeLayout$LayoutParams
    //   470: dup
    //   471: bipush 254
    //   473: bipush 254
    //   475: invokespecial 289	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   478: astore_3
    //   479: aload_3
    //   480: bipush 7
    //   482: ldc_w 290
    //   485: invokevirtual 293	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   488: aload_3
    //   489: iconst_0
    //   490: ldc_w 294
    //   493: aload_1
    //   494: invokevirtual 343	com/tencent/mobileqq/webview/swift/WebViewFragment:getResources	()Landroid/content/res/Resources;
    //   497: invokestatic 301	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   500: ldc_w 294
    //   503: aload_1
    //   504: invokevirtual 343	com/tencent/mobileqq/webview/swift/WebViewFragment:getResources	()Landroid/content/res/Resources;
    //   507: invokestatic 301	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   510: iconst_0
    //   511: invokevirtual 305	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   514: aload_0
    //   515: getfield 278	aikg:ko	Landroid/widget/ImageView;
    //   518: aload_3
    //   519: invokevirtual 309	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   522: aload_0
    //   523: getfield 278	aikg:ko	Landroid/widget/ImageView;
    //   526: iconst_0
    //   527: invokevirtual 273	android/widget/ImageView:setVisibility	(I)V
    //   530: aload_0
    //   531: getfield 278	aikg:ko	Landroid/widget/ImageView;
    //   534: ldc_w 310
    //   537: invokevirtual 313	android/widget/ImageView:setImageResource	(I)V
    //   540: aload_2
    //   541: aload_0
    //   542: getfield 278	aikg:ko	Landroid/widget/ImageView;
    //   545: invokevirtual 317	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   548: goto -527 -> 21
    //   551: ldc_w 345
    //   554: aload 4
    //   556: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   559: ifeq +132 -> 691
    //   562: new 182	org/json/JSONObject
    //   565: dup
    //   566: aload 5
    //   568: iconst_0
    //   569: aaload
    //   570: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   573: astore_3
    //   574: aload_0
    //   575: aload_3
    //   576: ldc 229
    //   578: invokevirtual 347	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   581: putfield 349	aikg:bOv	Ljava/lang/String;
    //   584: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +29 -> 616
    //   590: ldc 247
    //   592: iconst_2
    //   593: new 195	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 351
    //   603: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload_3
    //   607: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: aload_3
    //   617: ldc 213
    //   619: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   622: astore_1
    //   623: aload_3
    //   624: ldc 251
    //   626: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   629: astore_2
    //   630: aload_3
    //   631: ldc_w 353
    //   634: invokevirtual 357	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   637: istore 6
    //   639: aload_3
    //   640: ldc_w 359
    //   643: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   646: astore_3
    //   647: aload_0
    //   648: aload_0
    //   649: getfield 115	aikg:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   652: invokevirtual 121	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   655: iconst_1
    //   656: aload_1
    //   657: aload_2
    //   658: iload 6
    //   660: aload_3
    //   661: invokestatic 364	com/tencent/biz/troop/EditUniqueTitleActivity:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;
    //   664: iconst_4
    //   665: invokevirtual 107	aikg:startActivityForResult	(Landroid/content/Intent;B)V
    //   668: goto -647 -> 21
    //   671: astore_1
    //   672: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   675: ifeq -654 -> 21
    //   678: ldc 247
    //   680: iconst_2
    //   681: ldc_w 366
    //   684: aload_1
    //   685: invokestatic 243	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   688: goto -667 -> 21
    //   691: ldc_w 368
    //   694: aload 4
    //   696: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   699: ifeq +118 -> 817
    //   702: aload_0
    //   703: invokestatic 371	skj:a	()Lskj;
    //   706: putfield 373	aikg:h	Lskj;
    //   709: aload_0
    //   710: getfield 373	aikg:h	Lskj;
    //   713: invokevirtual 376	skj:bzj	()V
    //   716: new 182	org/json/JSONObject
    //   719: dup
    //   720: aload 5
    //   722: iconst_0
    //   723: aaload
    //   724: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   727: astore_1
    //   728: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   731: ifeq +29 -> 760
    //   734: ldc 247
    //   736: iconst_2
    //   737: new 195	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   744: ldc_w 378
    //   747: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload_1
    //   751: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: aload_1
    //   761: ldc 213
    //   763: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   766: astore_2
    //   767: aload_1
    //   768: ldc 251
    //   770: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   773: astore_3
    //   774: aload_1
    //   775: ldc_w 380
    //   778: invokevirtual 357	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   781: istore 6
    //   783: aload_0
    //   784: getfield 373	aikg:h	Lskj;
    //   787: aload_2
    //   788: aload_3
    //   789: iload 6
    //   791: invokevirtual 384	skj:s	(Ljava/lang/String;Ljava/lang/String;I)V
    //   794: goto -773 -> 21
    //   797: astore_1
    //   798: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   801: ifeq -780 -> 21
    //   804: ldc 247
    //   806: iconst_2
    //   807: ldc_w 386
    //   810: aload_1
    //   811: invokestatic 243	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   814: goto -793 -> 21
    //   817: ldc_w 388
    //   820: aload 4
    //   822: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   825: ifeq +113 -> 938
    //   828: new 182	org/json/JSONObject
    //   831: dup
    //   832: aload 5
    //   834: iconst_0
    //   835: aaload
    //   836: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   839: astore_2
    //   840: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +29 -> 872
    //   846: ldc 247
    //   848: iconst_2
    //   849: new 195	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   856: ldc_w 390
    //   859: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload_2
    //   863: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   866: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   872: aload_2
    //   873: ldc 213
    //   875: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   878: astore_1
    //   879: aload_2
    //   880: ldc 251
    //   882: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   885: astore_2
    //   886: invokestatic 256	apdg:a	()Lapdg;
    //   889: aload_1
    //   890: aload_2
    //   891: invokevirtual 260	apdg:bN	(Ljava/lang/String;Ljava/lang/String;)Z
    //   894: ifeq -873 -> 21
    //   897: aload_0
    //   898: getfield 278	aikg:ko	Landroid/widget/ImageView;
    //   901: bipush 8
    //   903: invokevirtual 273	android/widget/ImageView:setVisibility	(I)V
    //   906: invokestatic 256	apdg:a	()Lapdg;
    //   909: aload_1
    //   910: aload_2
    //   911: iconst_0
    //   912: invokevirtual 394	apdg:U	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   915: goto -894 -> 21
    //   918: astore_1
    //   919: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   922: ifeq -901 -> 21
    //   925: ldc 247
    //   927: iconst_2
    //   928: ldc_w 396
    //   931: aload_1
    //   932: invokestatic 243	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   935: goto -914 -> 21
    //   938: ldc_w 398
    //   941: aload 4
    //   943: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   946: ifeq +514 -> 1460
    //   949: new 182	org/json/JSONObject
    //   952: dup
    //   953: aload 5
    //   955: iconst_0
    //   956: aaload
    //   957: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   960: astore_2
    //   961: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   964: ifeq +29 -> 993
    //   967: ldc 193
    //   969: iconst_2
    //   970: new 195	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   977: ldc_w 400
    //   980: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload_2
    //   984: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   987: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   990: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   993: aload_2
    //   994: ldc 213
    //   996: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   999: astore_1
    //   1000: aload_0
    //   1001: aload_2
    //   1002: ldc_w 402
    //   1005: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1008: invokestatic 407	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1011: putfield 86	aikg:ddG	I
    //   1014: aload_2
    //   1015: ldc_w 409
    //   1018: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1021: astore 4
    //   1023: aload_2
    //   1024: ldc_w 411
    //   1027: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1030: astore_3
    //   1031: aload_3
    //   1032: ifnull +84 -> 1116
    //   1035: aload 4
    //   1037: ifnull +79 -> 1116
    //   1040: aload_3
    //   1041: invokevirtual 414	java/lang/String:isEmpty	()Z
    //   1044: ifne +72 -> 1116
    //   1047: aload 4
    //   1049: invokevirtual 414	java/lang/String:isEmpty	()Z
    //   1052: istore 12
    //   1054: iload 12
    //   1056: ifne +60 -> 1116
    //   1059: aload_3
    //   1060: invokestatic 407	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1063: istore 7
    //   1065: aload 4
    //   1067: invokestatic 407	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1070: istore 6
    //   1072: iload 6
    //   1074: iconst_1
    //   1075: if_icmpne +191 -> 1266
    //   1078: iconst_1
    //   1079: istore 6
    //   1081: iload 7
    //   1083: tableswitch	default:+33 -> 1116, 1:+189->1272, 2:+309->1392, 3:+1076->2159, 4:+1097->2180, 5:+1118->2201
    //   1117: aload_2
    //   1118: ldc_w 416
    //   1121: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1124: putfield 94	aikg:bOw	Ljava/lang/String;
    //   1127: aload_0
    //   1128: aload_2
    //   1129: ldc_w 418
    //   1132: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1135: putfield 96	aikg:bOx	Ljava/lang/String;
    //   1138: aload_0
    //   1139: aload_2
    //   1140: ldc_w 420
    //   1143: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1146: putfield 154	aikg:So	Ljava/lang/String;
    //   1149: aload_0
    //   1150: aload_2
    //   1151: ldc 229
    //   1153: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1156: putfield 422	aikg:bOu	Ljava/lang/String;
    //   1159: aload_0
    //   1160: getfield 115	aikg:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1163: invokevirtual 425	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   1166: aload_0
    //   1167: getfield 115	aikg:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1170: invokevirtual 425	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   1173: invokevirtual 430	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1176: invokevirtual 434	com/tencent/common/app/AppInterface:getEntityManagerFactory	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   1179: invokevirtual 440	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1182: astore_2
    //   1183: aload_2
    //   1184: ldc 73
    //   1186: aload_1
    //   1187: invokevirtual 446	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   1190: checkcast 73	com/tencent/mobileqq/data/TroopInfo
    //   1193: astore_3
    //   1194: aload_2
    //   1195: invokevirtual 449	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1198: aload_3
    //   1199: ifnull +247 -> 1446
    //   1202: aload_0
    //   1203: ldc_w 450
    //   1206: invokespecial 61	aikg:showToast	(I)V
    //   1209: goto -1188 -> 21
    //   1212: astore_1
    //   1213: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1216: ifeq +29 -> 1245
    //   1219: ldc 193
    //   1221: iconst_2
    //   1222: new 195	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   1229: ldc_w 452
    //   1232: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: aload_1
    //   1236: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1239: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1242: invokestatic 454	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1245: aload_0
    //   1246: aload_0
    //   1247: getfield 422	aikg:bOu	Ljava/lang/String;
    //   1250: iconst_1
    //   1251: anewarray 170	java/lang/String
    //   1254: dup
    //   1255: iconst_0
    //   1256: ldc_w 456
    //   1259: aastore
    //   1260: invokevirtual 460	aikg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1263: goto -1242 -> 21
    //   1266: iconst_0
    //   1267: istore 6
    //   1269: goto -188 -> 1081
    //   1272: iload 6
    //   1274: ifeq +110 -> 1384
    //   1277: sipush 30003
    //   1280: istore 6
    //   1282: aload_0
    //   1283: iload 6
    //   1285: putfield 86	aikg:ddG	I
    //   1288: goto -172 -> 1116
    //   1291: astore 4
    //   1293: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1296: ifeq -180 -> 1116
    //   1299: aload_0
    //   1300: getfield 463	aikg:TAG	Ljava/lang/String;
    //   1303: iconst_2
    //   1304: new 195	java/lang/StringBuilder
    //   1307: dup
    //   1308: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   1311: ldc_w 465
    //   1314: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: aload_3
    //   1318: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1324: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1327: goto -211 -> 1116
    //   1330: astore_1
    //   1331: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1334: ifeq +29 -> 1363
    //   1337: ldc 193
    //   1339: iconst_2
    //   1340: new 195	java/lang/StringBuilder
    //   1343: dup
    //   1344: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   1347: ldc_w 467
    //   1350: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: aload_1
    //   1354: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1357: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1360: invokestatic 454	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1363: aload_0
    //   1364: aload_0
    //   1365: getfield 422	aikg:bOu	Ljava/lang/String;
    //   1368: iconst_1
    //   1369: anewarray 170	java/lang/String
    //   1372: dup
    //   1373: iconst_0
    //   1374: ldc_w 469
    //   1377: aastore
    //   1378: invokevirtual 460	aikg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1381: goto -1360 -> 21
    //   1384: sipush 30005
    //   1387: istore 6
    //   1389: goto -107 -> 1282
    //   1392: iload 6
    //   1394: ifeq +757 -> 2151
    //   1397: sipush 30003
    //   1400: istore 6
    //   1402: aload_0
    //   1403: iload 6
    //   1405: putfield 86	aikg:ddG	I
    //   1408: goto -292 -> 1116
    //   1411: aload_0
    //   1412: iload 6
    //   1414: putfield 86	aikg:ddG	I
    //   1417: goto -301 -> 1116
    //   1420: aload_0
    //   1421: iload 6
    //   1423: putfield 86	aikg:ddG	I
    //   1426: goto -310 -> 1116
    //   1429: aload_0
    //   1430: iload 6
    //   1432: putfield 86	aikg:ddG	I
    //   1435: goto -319 -> 1116
    //   1438: sipush 30019
    //   1441: istore 6
    //   1443: goto -14 -> 1429
    //   1446: aload_0
    //   1447: getfield 38	aikg:mClient	Lskj;
    //   1450: aload_1
    //   1451: ldc_w 470
    //   1454: invokevirtual 474	skj:bA	(Ljava/lang/String;I)V
    //   1457: goto -1436 -> 21
    //   1460: ldc_w 476
    //   1463: aload 4
    //   1465: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1468: ifeq +108 -> 1576
    //   1471: new 182	org/json/JSONObject
    //   1474: dup
    //   1475: aload 5
    //   1477: iconst_0
    //   1478: aaload
    //   1479: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1482: astore_1
    //   1483: aload_1
    //   1484: ldc_w 478
    //   1487: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1490: astore_2
    //   1491: aload_1
    //   1492: ldc_w 480
    //   1495: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1498: astore_3
    //   1499: aload_1
    //   1500: ldc_w 482
    //   1503: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1506: astore 4
    //   1508: aload_0
    //   1509: aload_1
    //   1510: ldc 229
    //   1512: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1515: putfield 484	aikg:bOy	Ljava/lang/String;
    //   1518: aload_0
    //   1519: getfield 38	aikg:mClient	Lskj;
    //   1522: aload_2
    //   1523: aload_3
    //   1524: aload 4
    //   1526: new 486	aiki
    //   1529: dup
    //   1530: aload_0
    //   1531: invokespecial 487	aiki:<init>	(Laikg;)V
    //   1534: invokevirtual 490	skj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lskj$a;)V
    //   1537: goto -1516 -> 21
    //   1540: astore_1
    //   1541: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1544: ifeq -1523 -> 21
    //   1547: ldc 193
    //   1549: iconst_2
    //   1550: new 195	java/lang/StringBuilder
    //   1553: dup
    //   1554: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   1557: ldc_w 492
    //   1560: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: aload_1
    //   1564: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1567: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1570: invokestatic 454	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1573: goto -1552 -> 21
    //   1576: ldc_w 494
    //   1579: aload 4
    //   1581: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1584: ifeq +119 -> 1703
    //   1587: new 182	org/json/JSONObject
    //   1590: dup
    //   1591: aload 5
    //   1593: iconst_0
    //   1594: aaload
    //   1595: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1598: astore_1
    //   1599: aload_1
    //   1600: ldc_w 496
    //   1603: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1606: astore_2
    //   1607: aload_1
    //   1608: ldc_w 498
    //   1611: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1614: astore_3
    //   1615: aload_1
    //   1616: ldc_w 500
    //   1619: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1622: astore 4
    //   1624: aload_1
    //   1625: ldc_w 502
    //   1628: invokevirtual 357	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1631: istore 6
    //   1633: aload_0
    //   1634: aload_1
    //   1635: ldc 229
    //   1637: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1640: putfield 504	aikg:bOz	Ljava/lang/String;
    //   1643: aload_0
    //   1644: getfield 38	aikg:mClient	Lskj;
    //   1647: iload 6
    //   1649: aload_2
    //   1650: aload 4
    //   1652: aload_3
    //   1653: new 506	aikj
    //   1656: dup
    //   1657: aload_0
    //   1658: invokespecial 507	aikj:<init>	(Laikg;)V
    //   1661: invokevirtual 510	skj:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lskj$a;)V
    //   1664: goto -1643 -> 21
    //   1667: astore_1
    //   1668: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1671: ifeq -1650 -> 21
    //   1674: ldc 193
    //   1676: iconst_2
    //   1677: new 195	java/lang/StringBuilder
    //   1680: dup
    //   1681: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   1684: ldc_w 512
    //   1687: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: aload_1
    //   1691: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1694: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1697: invokestatic 454	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1700: goto -1679 -> 21
    //   1703: ldc_w 514
    //   1706: aload 4
    //   1708: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1711: ifeq +157 -> 1868
    //   1714: aload 5
    //   1716: iconst_0
    //   1717: aaload
    //   1718: astore_1
    //   1719: ldc_w 516
    //   1722: iconst_1
    //   1723: new 195	java/lang/StringBuilder
    //   1726: dup
    //   1727: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   1730: ldc_w 518
    //   1733: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1736: aload_1
    //   1737: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1740: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1743: invokestatic 521	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1746: new 182	org/json/JSONObject
    //   1749: dup
    //   1750: aload_1
    //   1751: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1754: astore_1
    //   1755: aload_1
    //   1756: ldc_w 523
    //   1759: invokevirtual 357	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1762: istore 6
    //   1764: aload_1
    //   1765: ldc_w 525
    //   1768: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1771: pop
    //   1772: aload_1
    //   1773: ldc 213
    //   1775: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1778: astore_1
    //   1779: iload 6
    //   1781: ifne -1760 -> 21
    //   1784: aload_0
    //   1785: getfield 115	aikg:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1788: invokevirtual 121	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   1791: checkcast 527	com/tencent/mobileqq/app/BaseActivity
    //   1794: astore_2
    //   1795: aload_2
    //   1796: ifnonnull +5 -> 1801
    //   1799: iconst_0
    //   1800: ireturn
    //   1801: new 529	android/content/Intent
    //   1804: dup
    //   1805: invokespecial 530	android/content/Intent:<init>	()V
    //   1808: astore_3
    //   1809: aload_3
    //   1810: ldc_w 531
    //   1813: invokevirtual 535	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1816: pop
    //   1817: aload_3
    //   1818: ldc_w 502
    //   1821: iconst_2
    //   1822: invokevirtual 539	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1825: pop
    //   1826: aload_3
    //   1827: ldc_w 541
    //   1830: aload_1
    //   1831: invokevirtual 544	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1834: pop
    //   1835: aload_2
    //   1836: aload_3
    //   1837: ldc_w 546
    //   1840: ldc_w 548
    //   1843: invokestatic 554	com/tencent/mobileqq/activity/PublicFragmentActivity$b:start	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;Ljava/lang/Class;)V
    //   1846: aload_2
    //   1847: iconst_0
    //   1848: iconst_0
    //   1849: invokevirtual 557	com/tencent/mobileqq/app/BaseActivity:overridePendingTransition	(II)V
    //   1852: goto -1831 -> 21
    //   1855: astore_1
    //   1856: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1859: ifeq +7 -> 1866
    //   1862: aload_1
    //   1863: invokevirtual 560	java/lang/Exception:printStackTrace	()V
    //   1866: iconst_0
    //   1867: ireturn
    //   1868: ldc_w 562
    //   1871: aload 4
    //   1873: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1876: ifeq +143 -> 2019
    //   1879: aload 5
    //   1881: ifnull -1860 -> 21
    //   1884: aload 5
    //   1886: arraylength
    //   1887: ifle -1866 -> 21
    //   1890: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1893: ifeq +32 -> 1925
    //   1896: ldc 193
    //   1898: iconst_2
    //   1899: new 195	java/lang/StringBuilder
    //   1902: dup
    //   1903: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   1906: ldc_w 564
    //   1909: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1912: aload 5
    //   1914: iconst_0
    //   1915: aaload
    //   1916: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1922: invokestatic 454	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1925: new 182	org/json/JSONObject
    //   1928: dup
    //   1929: aload 5
    //   1931: iconst_0
    //   1932: aaload
    //   1933: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1936: astore_1
    //   1937: aload_1
    //   1938: ldc 213
    //   1940: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1943: aload_1
    //   1944: ldc_w 566
    //   1947: invokevirtual 357	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1950: invokestatic 572	com/tencent/mobileqq/activity/TroopInfoActivity:c	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   1953: astore_2
    //   1954: aload_2
    //   1955: ldc_w 418
    //   1958: aload_1
    //   1959: ldc_w 418
    //   1962: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1965: invokevirtual 578	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1968: aload_0
    //   1969: getfield 115	aikg:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1972: invokevirtual 121	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   1975: aload_2
    //   1976: iconst_2
    //   1977: invokestatic 583	apuh:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   1980: goto -1959 -> 21
    //   1983: astore_1
    //   1984: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1987: ifeq -1966 -> 21
    //   1990: ldc 193
    //   1992: iconst_2
    //   1993: new 195	java/lang/StringBuilder
    //   1996: dup
    //   1997: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   2000: ldc_w 585
    //   2003: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2006: aload_1
    //   2007: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2010: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2013: invokestatic 454	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2016: goto -1995 -> 21
    //   2019: ldc_w 587
    //   2022: aload 4
    //   2024: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2027: ifeq -2006 -> 21
    //   2030: new 182	org/json/JSONObject
    //   2033: dup
    //   2034: aload 5
    //   2036: iconst_0
    //   2037: aaload
    //   2038: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2041: astore_1
    //   2042: aload_1
    //   2043: ldc_w 589
    //   2046: invokevirtual 592	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2049: istore 6
    //   2051: aload_1
    //   2052: ldc_w 594
    //   2055: invokevirtual 347	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2058: astore_1
    //   2059: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2062: ifeq +32 -> 2094
    //   2065: ldc_w 596
    //   2068: iconst_2
    //   2069: ldc_w 598
    //   2072: iconst_2
    //   2073: anewarray 600	java/lang/Object
    //   2076: dup
    //   2077: iconst_0
    //   2078: aload_1
    //   2079: aastore
    //   2080: dup
    //   2081: iconst_1
    //   2082: iload 6
    //   2084: invokestatic 604	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2087: aastore
    //   2088: invokestatic 608	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2091: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2094: aload_1
    //   2095: invokestatic 613	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2098: ifne -2077 -> 21
    //   2101: aload_0
    //   2102: getfield 38	aikg:mClient	Lskj;
    //   2105: astore_2
    //   2106: iload 6
    //   2108: iconst_1
    //   2109: if_icmpne +36 -> 2145
    //   2112: iconst_1
    //   2113: istore 12
    //   2115: aload_2
    //   2116: aload_1
    //   2117: iload 12
    //   2119: invokevirtual 617	skj:aF	(Ljava/lang/String;Z)V
    //   2122: goto -2101 -> 21
    //   2125: astore_1
    //   2126: aload_1
    //   2127: invokevirtual 560	java/lang/Exception:printStackTrace	()V
    //   2130: aload_0
    //   2131: getfield 463	aikg:TAG	Ljava/lang/String;
    //   2134: iconst_1
    //   2135: ldc_w 619
    //   2138: aload_1
    //   2139: invokestatic 621	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2142: goto -2121 -> 21
    //   2145: iconst_0
    //   2146: istore 12
    //   2148: goto -33 -> 2115
    //   2151: sipush 30007
    //   2154: istore 6
    //   2156: goto -754 -> 1402
    //   2159: iload 6
    //   2161: ifeq +11 -> 2172
    //   2164: sipush 30009
    //   2167: istore 6
    //   2169: goto -758 -> 1411
    //   2172: sipush 30011
    //   2175: istore 6
    //   2177: goto -766 -> 1411
    //   2180: iload 6
    //   2182: ifeq +11 -> 2193
    //   2185: sipush 30013
    //   2188: istore 6
    //   2190: goto -770 -> 1420
    //   2193: sipush 30015
    //   2196: istore 6
    //   2198: goto -778 -> 1420
    //   2201: iload 6
    //   2203: ifeq -765 -> 1438
    //   2206: sipush 30017
    //   2209: istore 6
    //   2211: goto -782 -> 1429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2214	0	this	aikg
    //   0	2214	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2214	2	paramString1	String
    //   0	2214	3	paramString2	String
    //   0	2214	4	paramString3	String
    //   0	2214	5	paramVarArgs	String[]
    //   637	1573	6	i	int
    //   1063	19	7	j	int
    //   106	29	8	l1	long
    //   114	23	10	l2	long
    //   1052	1095	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   43	86	148	java/lang/Exception
    //   86	145	148	java/lang/Exception
    //   177	220	396	java/lang/Exception
    //   220	261	396	java/lang/Exception
    //   265	308	396	java/lang/Exception
    //   312	393	396	java/lang/Exception
    //   420	463	396	java/lang/Exception
    //   467	548	396	java/lang/Exception
    //   562	616	671	java/lang/Exception
    //   616	668	671	java/lang/Exception
    //   702	760	797	java/lang/Exception
    //   760	794	797	java/lang/Exception
    //   828	872	918	java/lang/Exception
    //   872	915	918	java/lang/Exception
    //   949	993	1212	org/json/JSONException
    //   993	1031	1212	org/json/JSONException
    //   1040	1054	1212	org/json/JSONException
    //   1059	1072	1212	org/json/JSONException
    //   1116	1198	1212	org/json/JSONException
    //   1202	1209	1212	org/json/JSONException
    //   1282	1288	1212	org/json/JSONException
    //   1293	1327	1212	org/json/JSONException
    //   1402	1408	1212	org/json/JSONException
    //   1411	1417	1212	org/json/JSONException
    //   1420	1426	1212	org/json/JSONException
    //   1429	1435	1212	org/json/JSONException
    //   1446	1457	1212	org/json/JSONException
    //   1059	1072	1291	java/lang/NumberFormatException
    //   1282	1288	1291	java/lang/NumberFormatException
    //   1402	1408	1291	java/lang/NumberFormatException
    //   1411	1417	1291	java/lang/NumberFormatException
    //   1420	1426	1291	java/lang/NumberFormatException
    //   1429	1435	1291	java/lang/NumberFormatException
    //   949	993	1330	java/lang/Exception
    //   993	1031	1330	java/lang/Exception
    //   1040	1054	1330	java/lang/Exception
    //   1059	1072	1330	java/lang/Exception
    //   1116	1198	1330	java/lang/Exception
    //   1202	1209	1330	java/lang/Exception
    //   1282	1288	1330	java/lang/Exception
    //   1293	1327	1330	java/lang/Exception
    //   1402	1408	1330	java/lang/Exception
    //   1411	1417	1330	java/lang/Exception
    //   1420	1426	1330	java/lang/Exception
    //   1429	1435	1330	java/lang/Exception
    //   1446	1457	1330	java/lang/Exception
    //   1471	1537	1540	org/json/JSONException
    //   1587	1664	1667	org/json/JSONException
    //   1719	1779	1855	java/lang/Exception
    //   1784	1795	1855	java/lang/Exception
    //   1801	1852	1855	java/lang/Exception
    //   1884	1925	1983	org/json/JSONException
    //   1925	1980	1983	org/json/JSONException
    //   2030	2094	2125	java/lang/Exception
    //   2094	2106	2125	java/lang/Exception
    //   2115	2122	2125	java/lang/Exception
  }
  
  void init()
  {
    if (this.ac.compareAndSet(false, true))
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 4)
    {
      if (paramInt != -1) {
        break label94;
      }
      if (paramIntent != null) {
        break label75;
      }
      paramIntent = "";
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("code", 0);
        localJSONObject.put("uniqueTitle", paramIntent);
        callJs(this.bOv, new String[] { localJSONObject.toString() });
        return;
        label75:
        paramIntent = paramIntent.getStringExtra("newUniqueTitle");
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
    }
    label94:
    callJs(this.bOv, new String[] { "{\"code\":-1}" });
  }
  
  public void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.getActivity();
    if ((localAppInterface == null) || (localActivity == null)) {}
    do
    {
      return;
      init();
    } while (this.mClient == null);
    this.mClient.addObserver(this.jdField_a_of_type_Acnd);
  }
  
  public void onDestroy()
  {
    if (this.ac.get())
    {
      this.mClient.removeObserver(this.jdField_a_of_type_Acnd);
      this.mClient.bzk();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.aAQ())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.stop();
    }
    if (this.h != null) {
      this.h.bzk();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikg
 * JD-Core Version:    0.7.0.1
 */