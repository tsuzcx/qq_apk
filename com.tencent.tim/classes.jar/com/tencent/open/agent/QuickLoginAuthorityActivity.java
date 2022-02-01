package com.tencent.open.agent;

import acfp;
import ahlw;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqhs;
import aqiw;
import arhz;
import aroe;
import aroi;
import arsj;
import arsk;
import arsl;
import arsm;
import arsn;
import arso;
import arsp;
import arsq;
import arts;
import artw;
import aruh;
import arxc;
import arxi.a;
import aryn;
import asaw;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class QuickLoginAuthorityActivity
  extends BaseActivity
  implements View.OnClickListener, arxi.a
{
  protected static final String[] ip = { "http://ptlogin2.qq.com", "http://ptlogin2.soso.com", "http://ptlogin2.paipai.com", "http://ptlogin2.tenpay.com", "http://ptlogin2.taotao.com", "http://ptlogin2.tencent.com", "http://ptlogin2.oa.com", "http://ptlogin2.webdev.com", "http://ptlogin2.3366.com", "http://ptlogin2.imqq.com", "http://ptlogin2.pengyou.com", "http://ptlogin2.qplus.com", "http://ptlogin2.qzone.com", "http://ptlogin2.id.qq.com", "http://ptlogin2.myapp.com", "http://ptlogin2.kuyoo.cn", "http://ptlogin2.function.qq.com", "http://ptlogin2.crm2.qq.com", "http://ptlogin2.weiyun.com", "http://ptlogin2.wechatapp.com", "http://ptlogin2.51buy.com", "http://ptlogin2.qcloud.com", "http://ptlogin2.wechat.com", "http://ptlogin2.qmail.com", "http://ptlogin2.ejinshang.com", "http://ptlogin2.lvren.com", "http://ptlogin2.weishi.com", "https://ssl.ptlogin2.qq.com", "https://ssl.ptlogin2.tenpay.com", "https://ssl.ptlogin2.paipai.com", "https://ssl.ptlogin2.soso.com", "https://ssl.ptlogin2.3366.com", "https://ssl.ptlogin2.pengyou.com", "https://ssl.ptlogin2.imqq.com", "https://ssl.ptlogin2.qzone.com", "https://ssl.ptlogin2.qcloud.com", "https://ssl.ptlogin2.51buy.com", "https://ssl.ptlogin2.weiyun.com", "https://ssl.ptlogin2.myapp.com", "https://ssl.ptlogin2.yixun.com", "https://ssl.ptlogin2.wanggou.com", "https://ssl.ptlogin2.ejinshang.com" };
  private TextView GY;
  protected View JO;
  public CardContainer a;
  private MaxHeightScrollView jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView;
  public OpenSDKAppInterface a;
  public WtloginManager a;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new arsm(this);
  public String aIE;
  protected SharedPreferences ac;
  private long awv;
  private byte[] bM;
  protected SSOAccountObserver c = new arsj(this);
  public String cBU;
  protected String cBV;
  protected String cBr;
  private String cBs;
  private boolean dcL;
  protected boolean dcW;
  private boolean dcX;
  private boolean dcY;
  protected float density;
  private ImmersiveTitleBar2 jdField_e_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private WtloginObserver jdField_e_of_type_MqqObserverWtloginObserver = new arsl(this);
  private TextView ey;
  protected Button hA;
  public byte[] hl;
  private int mFromType;
  protected RelativeLayout mG;
  public Handler mHandler = new arsq(this, Looper.getMainLooper());
  public Bundle mParams;
  protected arhz mProgress;
  protected View mRoot;
  public Handler mSubHandler = new arsp(this, ThreadManager.getSubThreadLooper());
  private TextView mTitleView;
  protected List<String> qg;
  
  private int Nd()
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->verifyQRCode()");
    String str = this.mParams.getString("qrcode");
    int i = str.indexOf("?k=") + 3;
    str = str.substring(i, i + 32);
    this.bM = QRLoginAuthActivity.base64_decode_url(str.getBytes(), str.length());
    return this.jdField_a_of_type_MqqManagerWtloginManager.VerifyCode(this.aIE, 16L, true, this.bM, null, 1, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private int Ne()
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->getAppidByWtlogin()");
    Object localObject = this.mParams.getString("qrcode");
    int i = ((String)localObject).indexOf("?k=") + 3;
    localObject = ((String)localObject).substring(i, i + 32);
    this.bM = QRLoginAuthActivity.base64_decode_url(((String)localObject).getBytes(), ((String)localObject).length());
    localObject = this.jdField_a_of_type_MqqManagerWtloginManager;
    String str = this.aIE;
    byte[] arrayOfByte = this.bM;
    WtloginObserver localWtloginObserver = this.jdField_e_of_type_MqqObserverWtloginObserver;
    return ((WtloginManager)localObject).VerifyCode(str, 16L, true, arrayOfByte, new int[] { 3, 5, 32, 54 }, 1, localWtloginObserver);
  }
  
  private void ekP()
  {
    this.jdField_e_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131379866));
    this.ey = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369579));
    this.mTitleView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369627));
    this.GY = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369612));
    this.ey.setOnClickListener(this);
    this.GY.setOnClickListener(this);
    this.mTitleView.setText(2131696643);
    this.GY.setText(2131721058);
    this.jdField_e_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.abu(0);
  }
  
  private Bundle j(String paramString)
  {
    Bundle localBundle = new Bundle();
    try
    {
      paramString = new URL(paramString);
      paramString = paramString.getQuery();
      if (TextUtils.isEmpty(paramString)) {
        return localBundle;
      }
    }
    catch (MalformedURLException paramString)
    {
      return localBundle;
    }
    paramString = paramString.split("&");
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i];
      int j = localObject.indexOf('=');
      if (j > 0) {
        localBundle.putString(localObject.substring(0, j), localObject.substring(j + 1, localObject.length()));
      }
      i += 1;
    }
    return localBundle;
  }
  
  public void E(String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("-->onTaskCompleted--identifier = ").append(paramString).append("bitmap = null ? ");
      if (paramBitmap != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, bool);
      if (paramString.equals(this.aIE)) {
        runOnUiThread(new QuickLoginAuthorityActivity.10(this, paramBitmap));
      }
      return;
    }
  }
  
  /* Error */
  protected void WM(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +13 -> 17
    //   7: aload_1
    //   8: ldc_w 396
    //   11: invokevirtual 378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +13 -> 27
    //   17: ldc 201
    //   19: iconst_1
    //   20: ldc_w 398
    //   23: invokestatic 400	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: return
    //   27: new 402	oicq/wlogin_sdk/sharemem/WloginSimpleInfo
    //   30: dup
    //   31: invokespecial 403	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:<init>	()V
    //   34: astore 4
    //   36: aload_0
    //   37: getfield 246	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_MqqManagerWtloginManager	Lmqq/manager/WtloginManager;
    //   40: aload_1
    //   41: aload 4
    //   43: invokeinterface 407 3 0
    //   48: pop
    //   49: new 67	java/lang/String
    //   52: dup
    //   53: aload 4
    //   55: getfield 410	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:_nick	[B
    //   58: invokespecial 413	java/lang/String:<init>	([B)V
    //   61: astore 5
    //   63: aload 5
    //   65: astore 4
    //   67: aload 5
    //   69: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifeq +6 -> 78
    //   75: aload_1
    //   76: astore 4
    //   78: aload_1
    //   79: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifne +927 -> 1009
    //   85: aload_0
    //   86: getfield 415	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface	Lcom/tencent/qqconnect/wtlogin/OpenSDKAppInterface;
    //   89: aload_1
    //   90: ldc_w 416
    //   93: aload_0
    //   94: getfield 418	com/tencent/open/agent/QuickLoginAuthorityActivity:density	F
    //   97: fmul
    //   98: f2i
    //   99: iconst_1
    //   100: invokevirtual 423	com/tencent/qqconnect/wtlogin/OpenSDKAppInterface:b	(Ljava/lang/String;IZ)Landroid/graphics/Bitmap;
    //   103: astore 5
    //   105: aload_0
    //   106: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   109: aload_1
    //   110: aload 4
    //   112: aload 5
    //   114: iconst_1
    //   115: invokevirtual 426	com/tencent/open/agent/CardContainer:a	(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   118: aload 5
    //   120: ifnull +33 -> 153
    //   123: invokestatic 432	android/os/Message:obtain	()Landroid/os/Message;
    //   126: astore 4
    //   128: aload 4
    //   130: sipush 1000
    //   133: putfield 435	android/os/Message:what	I
    //   136: aload 4
    //   138: aload 5
    //   140: putfield 439	android/os/Message:obj	Ljava/lang/Object;
    //   143: aload_0
    //   144: getfield 187	com/tencent/open/agent/QuickLoginAuthorityActivity:mSubHandler	Landroid/os/Handler;
    //   147: aload 4
    //   149: invokevirtual 445	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   152: pop
    //   153: aload_0
    //   154: getfield 447	com/tencent/open/agent/QuickLoginAuthorityActivity:dcW	Z
    //   157: ifeq +35 -> 192
    //   160: aload_0
    //   161: invokevirtual 451	com/tencent/open/agent/QuickLoginAuthorityActivity:getResources	()Landroid/content/res/Resources;
    //   164: ldc_w 452
    //   167: invokevirtual 457	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   170: astore 4
    //   172: aload_0
    //   173: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   176: aload 4
    //   178: aconst_null
    //   179: invokevirtual 459	com/tencent/open/agent/CardContainer:F	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   182: aload_0
    //   183: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   186: ldc_w 461
    //   189: invokevirtual 464	com/tencent/open/agent/CardContainer:setAppType	(Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 211	com/tencent/open/agent/QuickLoginAuthorityActivity:mParams	Landroid/os/Bundle;
    //   196: ldc_w 466
    //   199: invokevirtual 219	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: astore 6
    //   204: ldc_w 468
    //   207: astore 7
    //   209: aload 7
    //   211: astore 5
    //   213: aload_0
    //   214: getfield 447	com/tencent/open/agent/QuickLoginAuthorityActivity:dcW	Z
    //   217: ifeq +452 -> 669
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 211	com/tencent/open/agent/QuickLoginAuthorityActivity:mParams	Landroid/os/Bundle;
    //   225: ldc_w 470
    //   228: invokevirtual 219	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   231: invokespecial 472	com/tencent/open/agent/QuickLoginAuthorityActivity:j	(Ljava/lang/String;)Landroid/os/Bundle;
    //   234: astore 8
    //   236: aload_0
    //   237: getfield 211	com/tencent/open/agent/QuickLoginAuthorityActivity:mParams	Landroid/os/Bundle;
    //   240: ldc_w 474
    //   243: invokevirtual 219	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore 5
    //   248: aload 5
    //   250: astore 4
    //   252: aload 5
    //   254: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifeq +13 -> 270
    //   260: aload 8
    //   262: ldc_w 476
    //   265: invokevirtual 219	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   268: astore 4
    //   270: aload 4
    //   272: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   275: ifne +42 -> 317
    //   278: aload 4
    //   280: astore 5
    //   282: aload 4
    //   284: invokevirtual 236	java/lang/String:length	()I
    //   287: bipush 20
    //   289: if_icmple +13 -> 302
    //   292: aload 4
    //   294: iconst_0
    //   295: bipush 20
    //   297: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   300: astore 5
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 269	com/tencent/open/agent/QuickLoginAuthorityActivity:dcY	Z
    //   307: aload_0
    //   308: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   311: aload 5
    //   313: aconst_null
    //   314: invokevirtual 459	com/tencent/open/agent/CardContainer:F	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   317: aload_0
    //   318: getfield 211	com/tencent/open/agent/QuickLoginAuthorityActivity:mParams	Landroid/os/Bundle;
    //   321: ldc_w 478
    //   324: invokevirtual 219	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   327: astore 4
    //   329: aload 4
    //   331: astore 5
    //   333: aload 4
    //   335: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   338: ifeq +13 -> 351
    //   341: aload 8
    //   343: ldc_w 480
    //   346: invokevirtual 219	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: astore 5
    //   351: aload 5
    //   353: astore 4
    //   355: aload 5
    //   357: ifnull +27 -> 384
    //   360: aload 5
    //   362: astore 4
    //   364: aload 5
    //   366: invokevirtual 236	java/lang/String:length	()I
    //   369: bipush 100
    //   371: if_icmple +13 -> 384
    //   374: aload 5
    //   376: iconst_0
    //   377: bipush 100
    //   379: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   382: astore 4
    //   384: aload 4
    //   386: astore 6
    //   388: aload 7
    //   390: astore 5
    //   392: aload 4
    //   394: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   397: ifeq +272 -> 669
    //   400: aload 4
    //   402: astore 6
    //   404: aload 7
    //   406: astore 5
    //   408: aload 8
    //   410: ifnull +259 -> 669
    //   413: aload 4
    //   415: astore 6
    //   417: aload 7
    //   419: astore 5
    //   421: aload 8
    //   423: ldc_w 482
    //   426: invokevirtual 219	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   429: ifnull +240 -> 669
    //   432: aload 8
    //   434: ldc_w 482
    //   437: ldc_w 468
    //   440: invokevirtual 485	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   443: astore 7
    //   445: aload 7
    //   447: ldc_w 487
    //   450: invokevirtual 378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   453: ifeq +197 -> 650
    //   456: aload_0
    //   457: iconst_1
    //   458: putfield 269	com/tencent/open/agent/QuickLoginAuthorityActivity:dcY	Z
    //   461: aload_0
    //   462: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   465: ldc_w 489
    //   468: aconst_null
    //   469: invokevirtual 459	com/tencent/open/agent/CardContainer:F	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   472: ldc_w 491
    //   475: astore 5
    //   477: aload 7
    //   479: astore 4
    //   481: aload 5
    //   483: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   486: ifeq +227 -> 713
    //   489: aload 4
    //   491: ldc_w 493
    //   494: invokevirtual 378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   497: ifeq +115 -> 612
    //   500: aload_0
    //   501: getfield 211	com/tencent/open/agent/QuickLoginAuthorityActivity:mParams	Landroid/os/Bundle;
    //   504: ldc_w 470
    //   507: invokevirtual 219	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   510: invokestatic 498	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore_1
    //   514: aload_0
    //   515: aload_1
    //   516: invokespecial 472	com/tencent/open/agent/QuickLoginAuthorityActivity:j	(Ljava/lang/String;)Landroid/os/Bundle;
    //   519: ldc_w 500
    //   522: ldc_w 502
    //   525: invokevirtual 485	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   528: invokestatic 508	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   531: invokevirtual 512	java/lang/Long:longValue	()J
    //   534: lstore_2
    //   535: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq +39 -> 577
    //   541: ldc 201
    //   543: iconst_2
    //   544: new 356	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 514
    //   554: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_1
    //   558: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: ldc_w 516
    //   564: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: lload_2
    //   568: invokevirtual 519	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   571: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 374	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: aload_0
    //   578: lload_2
    //   579: ldc_w 461
    //   582: invokevirtual 523	com/tencent/open/agent/QuickLoginAuthorityActivity:aO	(JLjava/lang/String;)V
    //   585: invokestatic 432	android/os/Message:obtain	()Landroid/os/Message;
    //   588: astore_1
    //   589: aload_1
    //   590: sipush 1004
    //   593: putfield 435	android/os/Message:what	I
    //   596: aload_1
    //   597: ldc_w 461
    //   600: putfield 439	android/os/Message:obj	Ljava/lang/Object;
    //   603: aload_0
    //   604: getfield 197	com/tencent/open/agent/QuickLoginAuthorityActivity:mHandler	Landroid/os/Handler;
    //   607: aload_1
    //   608: invokevirtual 445	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   611: pop
    //   612: ldc 201
    //   614: iconst_1
    //   615: iconst_4
    //   616: anewarray 525	java/lang/Object
    //   619: dup
    //   620: iconst_0
    //   621: ldc_w 527
    //   624: aastore
    //   625: dup
    //   626: iconst_1
    //   627: aload_0
    //   628: getfield 447	com/tencent/open/agent/QuickLoginAuthorityActivity:dcW	Z
    //   631: invokestatic 532	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   634: aastore
    //   635: dup
    //   636: iconst_2
    //   637: ldc_w 534
    //   640: aastore
    //   641: dup
    //   642: iconst_3
    //   643: aload 4
    //   645: aastore
    //   646: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   649: return
    //   650: aload 4
    //   652: astore 6
    //   654: aload 7
    //   656: astore 5
    //   658: aload 7
    //   660: ldc_w 493
    //   663: invokevirtual 378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   666: ifeq +3 -> 669
    //   669: aload 5
    //   671: astore 4
    //   673: aload 6
    //   675: astore 5
    //   677: goto -196 -> 481
    //   680: astore_1
    //   681: ldc 201
    //   683: iconst_1
    //   684: new 356	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   691: ldc_w 539
    //   694: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_1
    //   698: invokevirtual 542	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   701: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 400	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: goto -98 -> 612
    //   713: aload 5
    //   715: aload_1
    //   716: invokestatic 546	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   719: invokestatic 549	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   722: invokevirtual 512	java/lang/Long:longValue	()J
    //   725: invokestatic 555	oicq/wlogin_sdk/request/WtloginHelper:GetFastLoginUrl	(Ljava/lang/String;J)Loicq/wlogin_sdk/request/WFastLoginInfo;
    //   728: astore 4
    //   730: aload 4
    //   732: ifnonnull +30 -> 762
    //   735: ldc 201
    //   737: iconst_1
    //   738: ldc_w 557
    //   741: invokestatic 400	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: return
    //   745: astore_1
    //   746: ldc 201
    //   748: iconst_1
    //   749: ldc_w 559
    //   752: aload_1
    //   753: invokestatic 562	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   756: aconst_null
    //   757: astore 4
    //   759: goto -29 -> 730
    //   762: ldc 201
    //   764: iconst_1
    //   765: iconst_5
    //   766: anewarray 525	java/lang/Object
    //   769: dup
    //   770: iconst_0
    //   771: ldc_w 564
    //   774: aastore
    //   775: dup
    //   776: iconst_1
    //   777: aload_0
    //   778: getfield 447	com/tencent/open/agent/QuickLoginAuthorityActivity:dcW	Z
    //   781: invokestatic 532	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   784: aastore
    //   785: dup
    //   786: iconst_2
    //   787: ldc_w 566
    //   790: aastore
    //   791: dup
    //   792: iconst_3
    //   793: new 356	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   800: aload 4
    //   802: getfield 571	oicq/wlogin_sdk/request/WFastLoginInfo:iconUrl	Ljava/lang/String;
    //   805: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc_w 573
    //   811: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: aastore
    //   818: dup
    //   819: iconst_4
    //   820: aload 4
    //   822: getfield 576	oicq/wlogin_sdk/request/WFastLoginInfo:adUrl	Ljava/lang/String;
    //   825: aastore
    //   826: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   829: aload 4
    //   831: getfield 571	oicq/wlogin_sdk/request/WFastLoginInfo:iconUrl	Ljava/lang/String;
    //   834: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   837: ifne +37 -> 874
    //   840: aload_0
    //   841: iconst_1
    //   842: putfield 275	com/tencent/open/agent/QuickLoginAuthorityActivity:dcX	Z
    //   845: invokestatic 432	android/os/Message:obtain	()Landroid/os/Message;
    //   848: astore_1
    //   849: aload_1
    //   850: sipush 1001
    //   853: putfield 435	android/os/Message:what	I
    //   856: aload_1
    //   857: aload 4
    //   859: getfield 571	oicq/wlogin_sdk/request/WFastLoginInfo:iconUrl	Ljava/lang/String;
    //   862: putfield 439	android/os/Message:obj	Ljava/lang/Object;
    //   865: aload_0
    //   866: getfield 187	com/tencent/open/agent/QuickLoginAuthorityActivity:mSubHandler	Landroid/os/Handler;
    //   869: aload_1
    //   870: invokevirtual 445	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   873: pop
    //   874: aload_0
    //   875: getfield 447	com/tencent/open/agent/QuickLoginAuthorityActivity:dcW	Z
    //   878: ifne +70 -> 948
    //   881: ldc_w 468
    //   884: astore 7
    //   886: aload_0
    //   887: invokespecial 580	com/tencent/mobileqq/app/BaseActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   890: astore_1
    //   891: aload_1
    //   892: aload 5
    //   894: iconst_0
    //   895: invokevirtual 586	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   898: astore 6
    //   900: aload_1
    //   901: astore 5
    //   903: aload 6
    //   905: astore_1
    //   906: aload 7
    //   908: astore 6
    //   910: aload_1
    //   911: ifnull +14 -> 925
    //   914: aload 5
    //   916: aload_1
    //   917: invokevirtual 590	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   920: checkcast 67	java/lang/String
    //   923: astore 6
    //   925: aload 6
    //   927: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   930: ifne +18 -> 948
    //   933: aload_0
    //   934: iconst_1
    //   935: putfield 269	com/tencent/open/agent/QuickLoginAuthorityActivity:dcY	Z
    //   938: aload_0
    //   939: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   942: aload 6
    //   944: aconst_null
    //   945: invokevirtual 459	com/tencent/open/agent/CardContainer:F	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   948: aload 4
    //   950: getfield 576	oicq/wlogin_sdk/request/WFastLoginInfo:adUrl	Ljava/lang/String;
    //   953: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   956: ifne -930 -> 26
    //   959: new 592	java/lang/StringBuffer
    //   962: dup
    //   963: aload 4
    //   965: getfield 576	oicq/wlogin_sdk/request/WFastLoginInfo:adUrl	Ljava/lang/String;
    //   968: invokespecial 593	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   971: astore_1
    //   972: aload_0
    //   973: getfield 280	com/tencent/open/agent/QuickLoginAuthorityActivity:jdField_a_of_type_ComTencentOpenAgentCardContainer	Lcom/tencent/open/agent/CardContainer;
    //   976: aconst_null
    //   977: aload_1
    //   978: iconst_0
    //   979: iconst_4
    //   980: ldc_w 595
    //   983: invokevirtual 599	java/lang/StringBuffer:replace	(IILjava/lang/String;)Ljava/lang/StringBuffer;
    //   986: invokevirtual 600	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   989: invokevirtual 604	com/tencent/open/agent/CardContainer:setAdImageByURL	(Lcom/tencent/mobileqq/widget/AnyScaleTypeImageView;Ljava/lang/String;)V
    //   992: return
    //   993: astore_1
    //   994: aconst_null
    //   995: astore_1
    //   996: aload_1
    //   997: astore 5
    //   999: aconst_null
    //   1000: astore_1
    //   1001: goto -95 -> 906
    //   1004: astore 5
    //   1006: goto -10 -> 996
    //   1009: aconst_null
    //   1010: astore 5
    //   1012: goto -907 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1015	0	this	QuickLoginAuthorityActivity
    //   0	1015	1	paramString	String
    //   534	45	2	l	long
    //   34	930	4	localObject1	Object
    //   61	937	5	localObject2	Object
    //   1004	1	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   1010	1	5	localObject3	Object
    //   202	741	6	localObject4	Object
    //   207	700	7	str	String
    //   234	199	8	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   500	577	680	java/lang/Exception
    //   577	612	680	java/lang/Exception
    //   713	730	745	java/lang/NumberFormatException
    //   886	891	993	android/content/pm/PackageManager$NameNotFoundException
    //   891	900	1004	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public void WO(String paramString)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->showLoginActivity--uin = *" + artw.qx(paramString) + ",mIsPtloginAction=" + this.dcW + ", mThirdAppId=" + this.awv);
    Intent localIntent = new Intent(this, Login.class);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    if (this.dcW)
    {
      localIntent.putExtra("key_req_src", 3);
      localIntent.putExtra("appid", Long.toString(this.awv));
    }
    for (;;)
    {
      super.startActivityForResult(localIntent, 1);
      return;
      localIntent.putExtra("key_req_src", 2);
      if (this.mParams != null) {
        localIntent.putExtra("appid", Long.toString(this.mParams.getLong("dstAppid", 0L)));
      }
    }
  }
  
  protected void WP(String paramString)
  {
    Object localObject2 = new ArrayList();
    if (this.ac.getString("accList", null) != null) {}
    for (Object localObject1 = this.ac.getString("accList", null).split(",");; localObject1 = null)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = localObject1[i];
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((ArrayList)localObject2).add(localObject3);
          }
          i += 1;
        }
      }
      if (!((ArrayList)localObject2).contains(paramString)) {
        ((ArrayList)localObject2).add(paramString);
      }
      for (;;)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + "," + (String)localObject3) {
          localObject3 = (String)((Iterator)localObject2).next();
        }
        ((ArrayList)localObject2).remove(paramString);
        ((ArrayList)localObject2).add(paramString);
      }
      localObject2 = this.ac.edit();
      ((SharedPreferences.Editor)localObject2).putString("last_account", paramString);
      ((SharedPreferences.Editor)localObject2).putString("accList", (String)localObject1);
      ((SharedPreferences.Editor)localObject2).commit();
      return;
    }
  }
  
  protected void WW(String paramString)
  {
    aryn.WE(paramString);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    paramString = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.aIE = paramString;
    boolean bool;
    if (this.qg.contains(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
      }
      bool = true;
      paramString = new WloginSimpleInfo();
      if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
        break label198;
      }
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.aIE, paramString);
    }
    label198:
    for (paramString = new String(paramString._nick);; paramString = null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.aIE, paramString, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + bool);
        }
        WP(this.aIE);
      }
      return;
      bool = false;
      break;
    }
  }
  
  protected void WX(String paramString)
  {
    aryn.WE(paramString);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    paramString = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.aIE = paramString;
    boolean bool;
    if (this.qg.contains(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
      }
      bool = true;
      paramString = new WloginSimpleInfo();
      if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
        break label198;
      }
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.aIE, paramString);
    }
    label198:
    for (paramString = new String(paramString._nick);; paramString = null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.aIE, paramString, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + bool);
        }
        WP(this.aIE);
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_errmsg", paramString2);
    localIntent.putExtra("quicklogin_uin", paramString1);
    localIntent.putExtra("quicklogin_ret", paramInt);
    localIntent.putExtra("quicklogin_buff", paramArrayOfByte);
    super.setResult(-1, localIntent);
    jf();
    super.finish();
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult:error:" + paramString2);
    if (this.dcL) {}
    try
    {
      paramString1 = arts.a();
      paramString2 = this.aIE;
      if (paramInt != 0) {
        break label208;
      }
      paramArrayOfByte = "0";
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) || (this.aIE.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
          break label207;
        }
        paramString1 = arts.a();
        paramString2 = this.aIE;
        if (paramInt != 0) {
          break label229;
        }
        for (paramArrayOfByte = "0";; paramArrayOfByte = "1")
        {
          paramString1.a(paramString2, "", "", "1", "10", paramArrayOfByte, true, true);
          return;
          paramArrayOfByte = "1";
          break;
          paramArrayOfByte = paramArrayOfByte;
          QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult report exception1:", paramArrayOfByte);
          break label138;
        }
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult report exception2:", paramArrayOfByte);
      }
    }
    paramString1.a(paramString2, "", "", "1", "9", paramArrayOfByte, true, true);
  }
  
  protected boolean aHa()
  {
    if (super.getIntent() == null) {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, " checkIntentValidity() [[[return false]]] intent = null activity=" + this);
    }
    do
    {
      return false;
      this.mParams = super.getIntent().getBundleExtra("key_params");
      if (this.mParams == null)
      {
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, " checkIntentValidity() [[[return false]]] mParams = null, activity=" + this);
        return false;
      }
      str = super.getIntent().getStringExtra("key_action");
      if ((!"action_ptlogin_login".equals(str)) && (!"action_quick_login".equals(str)))
      {
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "checkIntentValidity() invalid action = " + str);
        return false;
      }
      this.dcW = "action_ptlogin_login".equals(str);
      if (!this.dcW) {
        break;
      }
      if ((this.mParams.containsKey("qrcode")) && (this.mParams.containsKey("schemacallback"))) {
        return true;
      }
    } while (!this.mParams.containsKey("p"));
    String str = this.mParams.getString("p");
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = ip;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (str.startsWith(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "checkIntentValidity() invalid path! " + str);
    return false;
    this.hl = this.mParams.getByteArray("publickey");
    this.cBV = this.mParams.getString("packagename");
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "mSrcPackageName: " + this.cBV);
    }
    if ((this.hl != null) && (!TextUtils.isEmpty(this.cBV)) && (this.mParams.containsKey("dstSsoVer")) && (this.mParams.containsKey("subDstAppid")) && (this.mParams.containsKey("dstAppid")) && (this.mParams.containsKey("dstAppVer"))) {
      return true;
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "checkIntentValidity() invalid parameters! " + this.mParams.toString());
    return false;
  }
  
  public void aO(long paramLong, String paramString)
  {
    this.awv = paramLong;
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "getAppInfo appid =" + paramLong + ",comfrom =" + paramString);
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong);
    localGetAppinfoRequest.sdkp.set(paramString);
    if (Build.VERSION.RELEASE == null) {}
    for (paramString = "";; paramString = Build.VERSION.RELEASE)
    {
      localGetAppinfoRequest.os.set(paramString);
      localGetAppinfoRequest.qqv.set(aroi.a().getVersionName());
      localGetAppinfoRequest.setHasFlag(true);
      paramString = artw.i(this);
      if (!TextUtils.isEmpty(paramString)) {
        localGetAppinfoRequest.appUniqueIdentifier.set(paramString);
      }
      localGetAppinfoRequest.referer.set(1);
      paramString = new NewIntent(BaseApplicationImpl.getContext(), aruh.class);
      paramString.setWithouLogin(true);
      paramString.putExtra("uin", this.aIE);
      paramString.putExtra("data", localGetAppinfoRequest.toByteArray());
      paramString.putExtra("cmd", "ConnAuthSvr.get_app_info");
      paramString.setObserver(new arsk(this));
      super.getAppRuntime().startServlet(paramString);
      return;
    }
  }
  
  protected void bFf()
  {
    this.mProgress.setMessage(super.getString(2131696661));
    if (!this.mProgress.isShowing()) {
      this.mProgress.show();
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize()");
    if (this.dcW)
    {
      localObject1 = new Bundle();
      localObject2 = (TicketManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(2);
      if ((localObject2 != null) && (TextUtils.isEmpty(((TicketManager)localObject2).getStweb(this.aIE))))
      {
        ((Bundle)localObject1).putByteArray("connect_data", artw.ah(Long.toString(this.awv)));
        ((Bundle)localObject1).putLong("dwSrcAppid", 1600001540L);
        ((Bundle)localObject1).putLong("dwDstAppid", 1600001540L);
      }
      if ((this.mParams.containsKey("qrcode")) && (this.mParams.containsKey("schemacallback"))) {
        if (this.aIE.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))
        {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize verifyQRCode");
          Nd();
        }
      }
      while (!this.mParams.containsKey("p"))
      {
        return;
        ahlw.ao("qrcode_ssoGetTicketNoPasswd", 0L);
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.aIE, 32, this.c, (Bundle)localObject1);
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize URL_PARAM_QRCODE");
        return;
      }
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doAuthorize URL_PARAM_PATH");
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.aIE, 32, this.c, (Bundle)localObject1);
      return;
    }
    long l1 = this.mParams.getLong("dstSsoVer", 0L);
    long l2 = this.mParams.getLong("subDstAppid", 0L);
    long l3 = this.mParams.getLong("dstAppid", 0L);
    Object localObject1 = this.mParams.getByteArray("dstAppVer");
    Object localObject2 = this.jdField_a_of_type_MqqManagerWtloginManager.getPkgSigFromApkName(this, this.cBV);
    if (QLog.isColorLevel())
    {
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "mSrcPackageName: " + this.cBV);
      localObject3 = aqhs.bytes2HexStr((byte[])localObject2);
      QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "dstAppSign: " + (String)localObject3);
    }
    Object localObject3 = new Bundle();
    if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.aIE, 16L))
    {
      ((Bundle)localObject3).putLong("dwSrcAppid", 1600001540L);
      ((Bundle)localObject3).putLong("dwSubSrcAppid", 1600001540L);
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetA1WithA1(this.aIE, this.cBV.getBytes(), l1, l3, l2, (byte[])localObject1, (byte[])localObject2, this.c, (Bundle)localObject3);
  }
  
  public boolean cb(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, new Object[] { "checkSignature packageName:", paramString1, " targetSig:", paramString2 });
            return false;
          }
        }
        else
        {
          byte[] arrayOfByte = getPackageManager().getPackageInfo(paramString1, 64).signatures[0].toByteArray();
          arrayOfByte = MessageDigest.getInstance("SHA1").digest(arrayOfByte);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < arrayOfByte.length)
          {
            String str = Integer.toHexString(arrayOfByte[i] & 0xFF).toUpperCase(Locale.US);
            if (str.length() == 1) {
              localStringBuilder.append("0");
            }
            localStringBuilder.append(str);
            if (i == arrayOfByte.length - 1) {
              break label245;
            }
            localStringBuilder.append(":");
            break label245;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, new Object[] { "checkSignature packageName:", paramString1, " targetSig:", paramString2, " hexStr:", localStringBuilder });
          }
          boolean bool = paramString2.equals(localStringBuilder.toString());
          return bool;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramString1, new Object[0]);
      }
      return false;
      label245:
      i += 1;
    }
  }
  
  protected void ddP()
  {
    if (TextUtils.isEmpty(this.aIE))
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "updateViews() return for empry account");
      return;
    }
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "updateViews()");
    String str = ((TicketManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(2)).getSkey(this.aIE);
    arxc.a().a(this, this.aIE, str, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ri(this.aIE), this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doOnCreate--");
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    String str = Build.MANUFACTURER + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 2, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
    }
    if ((str != null) && ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C")))) {
      ImmersiveUtils.clearCoverForStatus(getWindow(), true);
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
      return;
      ImmersiveUtils.l(getActivity().getWindow());
    }
  }
  
  public void dt(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(paramString, 16L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "-->login--has aone");
      }
      if (paramBoolean)
      {
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "changeAccountLogin, auto login is true, account is " + paramString + " ;currentAccount is" + this.aIE);
        this.cBU = this.aIE;
        WW(paramString);
        return;
      }
      WX(paramString);
      this.cBU = null;
      return;
    }
    WO(paramString);
  }
  
  public void eb(Intent paramIntent)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setResultCancel data=" + paramIntent);
    if (paramIntent == null) {
      super.setResult(0);
    }
    for (;;)
    {
      super.finish();
      return;
      super.setResult(0, paramIntent);
    }
  }
  
  protected void ekQ()
  {
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      this.ac = super.getSharedPreferences("accountList", i);
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      login();
      return;
    }
  }
  
  public void ekU()
  {
    int i = getResources().getColor(2131167654);
    ColorStateList localColorStateList = getResources().getColorStateList(2131166195);
    if (this.mTitleView != null)
    {
      this.mTitleView.setTextColor(i);
      this.mTitleView.setText("");
    }
    if (this.GY != null) {
      this.GY.setTextColor(localColorStateList);
    }
  }
  
  protected void elw()
  {
    int i = 0;
    if (this.qg != null) {
      i = this.qg.size();
    }
    if (i > 1)
    {
      Intent localIntent = new Intent(this, SwitchAccountActivity.class);
      if (this.aIE != null) {
        localIntent.putExtra("param_uin", this.aIE);
      }
      if (this.dcW) {
        localIntent.putExtra("key_req_src", 3);
      }
      for (;;)
      {
        super.startActivityForResult(localIntent, 1);
        return;
        localIntent.putExtra("key_req_src", 2);
      }
    }
    WO(this.aIE);
  }
  
  public void elx()
  {
    super.setResult(-1, new Intent());
    jf();
    super.finish();
    if (this.dcL) {}
    try
    {
      arts.a().a(this.aIE, "", "", "1", "9", "0", true, true);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) && (!this.aIE.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
            arts.a().a(this.aIE, "", "", "1", "10", "0", true, true);
          }
          new QuickLoginAuthorityActivity.9(this).start();
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult:");
          return;
          localException1 = localException1;
          QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult report exception1:", localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setPtloginSdkResult report exception2:", localException2);
        }
      }
    }
  }
  
  public void jf()
  {
    if ((!super.isFinishing()) && (this.mProgress != null) && (this.mProgress.isShowing())) {}
    try
    {
      this.mProgress.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void login()
  {
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
    {
      elw();
      return;
    }
    if (!TextUtils.isEmpty(this.cBr))
    {
      this.aIE = this.cBr;
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "login mAccountString :" + this.cBr);
      }
    }
    WM(this.aIE);
    if (!TextUtils.isEmpty(this.aIE))
    {
      boolean bool;
      if (this.dcW) {
        if (!artw.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE)) {
          bool = true;
        }
      }
      while (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "login have");
        }
        ddP();
        return;
        bool = false;
        continue;
        bool = artw.b(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE);
      }
      elw();
      QQToast.a(BaseApplicationImpl.getContext(), 2131696671, 0).show(getResources().getDimensionPixelSize(2131299627));
      return;
    }
    elw();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onActivityResult: resultcode:").append(paramInt2).append("requestCode:").append(paramInt1).append("data null?");
      if (paramIntent == null)
      {
        bool = true;
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, bool);
      }
    }
    else
    {
      if (paramInt1 != 100) {
        break label107;
      }
      if (paramInt2 != -1) {
        break label101;
      }
      if (paramIntent != null) {
        this.cBr = paramIntent.getStringExtra("uin");
      }
      ekQ();
    }
    label101:
    label107:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        eb(null);
        return;
        jf();
        if (paramInt2 != 0) {
          break label199;
        }
        if (this.aIE == null)
        {
          eb(paramIntent);
          return;
        }
      } while (this.cBU == null);
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onActivityResult cancel , current account is : " + this.aIE + ", preAccount is : " + this.cBU);
      this.aIE = this.cBU;
      WM(this.aIE);
      this.cBU = null;
      return;
    } while ((-1 != paramInt2) || (paramIntent == null));
    label199:
    this.aIE = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null) {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.aIE, (WloginSimpleInfo)localObject);
    }
    for (paramIntent = new String(((WloginSimpleInfo)localObject)._nick);; paramIntent = paramIntent.getStringExtra("nick"))
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.aIE, paramIntent, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + bool);
        }
        WP(this.aIE);
      }
      ddP();
      paramIntent = Message.obtain();
      paramIntent.what = 1005;
      this.mSubHandler.sendMessage(paramIntent);
      return;
    }
  }
  
  public void onBackPressed()
  {
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onBackPressed mIsPtloginAction=" + this.dcW);
    eb(null);
    if (this.dcW) {
      aroe.ekE();
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.GY)
      {
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onClick cancel mIsPtloginAction=" + this.dcW);
        eb(null);
        if (this.dcW) {
          aroe.ekE();
        }
      }
      else if (paramView == this.hA)
      {
        String str4 = "2";
        String str1;
        if (this.dcY)
        {
          str1 = "1";
          label94:
          if (!this.dcX) {
            break label281;
          }
        }
        label281:
        for (String str2 = "1";; str2 = "2")
        {
          String str3 = str4;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))
          {
            str3 = str4;
            if (!this.aIE.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) {
              str3 = "1";
            }
          }
          anot.a(null, "dc00898", "", "", "0X800A7BE", "0X800A7BE", this.mFromType, 0, str3, str1, str2, "");
          QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "report-dc00898-0X800A7BE-fromType=", Integer.valueOf(this.mFromType), ",changeaccount=", str3, ", hasGetName=", str1, ", hasGetIcon=", str2 });
          if (aqiw.isNetworkAvailable(this)) {
            break label289;
          }
          jf();
          this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.aV(this, getResources().getString(2131696664));
          break;
          str1 = "2";
          break label94;
        }
        label289:
        boolean bool;
        if (this.dcW) {
          if (!artw.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE)) {
            bool = true;
          }
        }
        for (;;)
        {
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onClick login have");
          if (!bool) {
            break label352;
          }
          bFf();
          break;
          bool = false;
          continue;
          bool = artw.b(this.jdField_a_of_type_MqqManagerWtloginManager, this.aIE);
        }
        label352:
        elw();
        QQToast.a(BaseApplicationImpl.getContext(), 2131696671, 0).show(super.getResources().getDimensionPixelSize(2131299627));
      }
      else
      {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131363101: 
          WO(this.aIE);
          if (this.jdField_a_of_type_ComTencentOpenAgentCardContainer != null) {
            this.jdField_a_of_type_ComTencentOpenAgentCardContainer.ekJ();
          }
          break;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    if (paramBundle != null)
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onCreate return for savedInstanceState is not null");
      eb(null);
    }
    String str1;
    label688:
    label713:
    do
    {
      return;
      if (!aHa())
      {
        QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131712638), 0).show();
        eb(null);
        return;
      }
      this.dcL = getIntent().getBooleanExtra("authority_start_qq_login", false);
      str1 = this.mParams.getString("schemacallback");
      String str2 = this.mParams.getString("packagename");
      paramBundle = super.getIntent().getStringExtra("key_action");
      String str3 = this.mParams.getString("p");
      StringBuilder localStringBuilder = new StringBuilder("onCreate()=> mFromSdkLoginAuthority=");
      localStringBuilder.append(this.dcL).append("\n schemacallback=").append(str1).append("\n packageName=").append(str2).append("\n action=").append(paramBundle).append("\n urlPraram=").append(str3);
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
      super.setContentView(2131559871);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131364330));
      ekP();
      this.mRoot = findViewById(2131377546);
      this.JO = findViewById(2131363832);
      this.hA = ((Button)super.findViewById(2131372662));
      this.hA.setOnClickListener(this);
      this.mG = ((RelativeLayout)super.findViewById(2131363103));
      this.mG.setVisibility(8);
      this.density = super.getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView = ((MaxHeightScrollView)findViewById(2131364331));
      this.jdField_a_of_type_ComTencentOpenWidgetMaxHeightScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new arsn(this));
      if (this.dcL)
      {
        this.mProgress = new arhz(this, 0, 2131561631, 17);
        this.mProgress.setHeightParams(-1);
        this.mFromType = 1;
        if (TextUtils.isEmpty(str2)) {
          break label688;
        }
      }
      for (this.mFromType = 3;; this.mFromType = 2) {
        do
        {
          anot.a(null, "dc00898", "", "", "0X800A7BC", "0X800A7BC", this.mFromType, 0, "", "", "", "");
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "report-dc00898-0X800A7BC-fromType=" + this.mFromType);
          this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setChangeAccountListener(new arso(this));
          this.mProgress.setCanceledOnTouchOutside(false);
          asaw.a().emz();
          this.qg = aryn.eh();
          if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
            this.aIE = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
          }
          if ((this.aIE == null) && (this.qg != null)) {
            this.aIE = ((String)this.qg.get(0));
          }
          this.cBs = getIntent().getStringExtra("login_success_uin");
          if ((!TextUtils.isEmpty(this.cBs)) && (!this.cBs.equals(this.aIE))) {
            this.aIE = this.cBs;
          }
          paramBundle = super.getAppRuntime().getAccount();
          if ((!GesturePWDUtils.getJumpLock(this, paramBundle)) || (GesturePWDUtils.getAppForground(this))) {
            break label713;
          }
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onCreate--has gesture password, will start unlock activity");
          this.cBr = paramBundle;
          paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
          paramBundle.putExtra("key_gesture_from_authority", true);
          super.startActivityForResult(paramBundle, 100);
          return;
          if (isChild()) {}
          for (paramBundle = getParent();; paramBundle = this)
          {
            this.mProgress = new arhz(paramBundle, super.getTitleBarHeight());
            break;
          }
        } while ((TextUtils.isEmpty(str1)) || (!str1.contains("weixin://")));
      }
      ekQ();
    } while ((TextUtils.isEmpty(str1)) || (!str1.contains("weixin://")));
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.ekI();
    ThreadManager.getSubThreadHandler().post(new QuickLoginAuthorityActivity.6(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "ondestroy");
    jf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity
 * JD-Core Version:    0.7.0.1
 */