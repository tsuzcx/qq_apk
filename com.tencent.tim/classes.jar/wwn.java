import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class wwn
  implements wvs
{
  private TextView IA;
  private TextView IB;
  private TextView Iz;
  private zxj a;
  private String aUh;
  private String aUi;
  private QQAppInterface app;
  private int bRR;
  public boolean bgi;
  private BaseChatPie c;
  private View gk;
  private LinearLayout hb;
  private Activity mActivity;
  private Context mContext;
  private SessionInfo sessionInfo;
  
  public wwn(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.app = paramBaseChatPie.app;
    this.mContext = paramBaseChatPie.mContext;
    this.mActivity = paramBaseChatPie.mActivity;
    this.sessionInfo = paramBaseChatPie.sessionInfo;
    this.a = ((zxj)this.app.getManager(125));
  }
  
  private Object[] a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (!jof.a().dd(this.sessionInfo.aTl))
      {
        if (!TextUtils.isEmpty(this.aUh)) {}
        for (arrayOfObject = this.a.a(paramString, this.sessionInfo, this.aUh, paramInt); (arrayOfObject != null) && (((Integer)arrayOfObject[0]).intValue() == 1); arrayOfObject = this.a.a(this.sessionInfo, paramString, paramInt))
        {
          this.aUh = "";
          this.aUi = "";
          this.c.getUIHandler().sendEmptyMessage(12);
          if (!QLog.isColorLevel()) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString.charAt(0));
          localStringBuilder.append("|");
          localStringBuilder.append(paramString.length());
          QLog.d("PasswdRedBagManager", 2, "passwdredbags result[0]=" + arrayOfObject[0] + ",result[1]=" + arrayOfObject[1] + ",send str=" + localStringBuilder.toString());
          return arrayOfObject;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont search passwdredbags");
    return null;
    return arrayOfObject;
  }
  
  public int[] C()
  {
    return new int[] { 7, 13, 5, 9 };
  }
  
  public void CU(int paramInt)
  {
    if (this.bRR == 0) {
      this.bRR = paramInt;
    }
    if ((!TextUtils.isEmpty(this.aUi)) && (this.bRR - paramInt > 5)) {
      ccE();
    }
  }
  
  /* Error */
  public void Ck(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: bipush 7
    //   3: if_icmpne +421 -> 424
    //   6: aload_0
    //   7: getfield 66	wwn:a	Lzxj;
    //   10: ifnull +48 -> 58
    //   13: aload_0
    //   14: getfield 66	wwn:a	Lzxj;
    //   17: getfield 186	zxj:buq	Z
    //   20: ifeq +38 -> 58
    //   23: aload_0
    //   24: getfield 56	wwn:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   27: getfield 189	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   30: iconst_1
    //   31: if_icmpeq +16 -> 47
    //   34: aload_0
    //   35: getfield 56	wwn:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   38: getfield 189	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   41: sipush 1004
    //   44: if_icmpne +14 -> 58
    //   47: aload_0
    //   48: getfield 66	wwn:a	Lzxj;
    //   51: aload_0
    //   52: getfield 56	wwn:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   55: invokevirtual 192	zxj:c	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)V
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   63: getfield 196	com/tencent/mobileqq/activity/BaseChatPie:mAIORootView	Landroid/view/ViewGroup;
    //   66: ldc 197
    //   68: invokevirtual 203	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   71: checkcast 205	android/widget/TextView
    //   74: putfield 207	wwn:Iz	Landroid/widget/TextView;
    //   77: aload_0
    //   78: new 205	android/widget/TextView
    //   81: dup
    //   82: aload_0
    //   83: getfield 48	wwn:mContext	Landroid/content/Context;
    //   86: invokespecial 210	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   89: putfield 212	wwn:IB	Landroid/widget/TextView;
    //   92: aload_0
    //   93: getfield 212	wwn:IB	Landroid/widget/TextView;
    //   96: ldc 213
    //   98: invokevirtual 216	android/widget/TextView:setTextColor	(I)V
    //   101: aload_0
    //   102: getfield 212	wwn:IB	Landroid/widget/TextView;
    //   105: iconst_1
    //   106: ldc 217
    //   108: invokevirtual 221	android/widget/TextView:setTextSize	(IF)V
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   116: getfield 196	com/tencent/mobileqq/activity/BaseChatPie:mAIORootView	Landroid/view/ViewGroup;
    //   119: ldc 222
    //   121: invokevirtual 203	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   124: checkcast 205	android/widget/TextView
    //   127: putfield 224	wwn:IA	Landroid/widget/TextView;
    //   130: aload_0
    //   131: getfield 207	wwn:Iz	Landroid/widget/TextView;
    //   134: invokevirtual 228	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   137: ldc 229
    //   139: invokestatic 235	acfp:m	(I)Ljava/lang/String;
    //   142: invokevirtual 241	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   145: fstore_2
    //   146: aload_0
    //   147: getfield 207	wwn:Iz	Landroid/widget/TextView;
    //   150: fload_2
    //   151: ldc 242
    //   153: fmul
    //   154: ldc 243
    //   156: fadd
    //   157: f2i
    //   158: invokevirtual 246	android/widget/TextView:setMaxWidth	(I)V
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   166: getfield 196	com/tencent/mobileqq/activity/BaseChatPie:mAIORootView	Landroid/view/ViewGroup;
    //   169: ldc 247
    //   171: invokevirtual 203	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   174: putfield 249	wwn:gk	Landroid/view/View;
    //   177: aload_0
    //   178: aload_0
    //   179: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   182: getfield 196	com/tencent/mobileqq/activity/BaseChatPie:mAIORootView	Landroid/view/ViewGroup;
    //   185: ldc 250
    //   187: invokevirtual 203	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   190: checkcast 252	android/widget/LinearLayout
    //   193: putfield 254	wwn:hb	Landroid/widget/LinearLayout;
    //   196: aload_0
    //   197: getfield 254	wwn:hb	Landroid/widget/LinearLayout;
    //   200: aload_0
    //   201: getfield 212	wwn:IB	Landroid/widget/TextView;
    //   204: invokevirtual 258	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   207: aload_0
    //   208: getfield 212	wwn:IB	Landroid/widget/TextView;
    //   211: invokevirtual 262	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   214: bipush 254
    //   216: putfield 267	android/view/ViewGroup$LayoutParams:width	I
    //   219: aload_0
    //   220: getfield 212	wwn:IB	Landroid/widget/TextView;
    //   223: invokevirtual 262	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   226: bipush 254
    //   228: putfield 270	android/view/ViewGroup$LayoutParams:height	I
    //   231: aload_0
    //   232: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   235: instanceof 272
    //   238: ifeq +31 -> 269
    //   241: ldc_w 274
    //   244: aload_0
    //   245: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   248: getfield 55	com/tencent/mobileqq/activity/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   251: getfield 90	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   254: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   257: ifeq +75 -> 332
    //   260: invokestatic 284	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   263: iconst_0
    //   264: bipush 54
    //   266: invokestatic 290	arlc:b	(Landroid/content/Context;ZI)V
    //   269: return
    //   270: astore_3
    //   271: ldc_w 292
    //   274: iconst_1
    //   275: new 125	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 294
    //   285: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_3
    //   289: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: goto -240 -> 58
    //   301: astore_3
    //   302: ldc_w 292
    //   305: iconst_1
    //   306: new 125	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 299
    //   316: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_3
    //   320: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: goto -98 -> 231
    //   332: ldc_w 301
    //   335: aload_0
    //   336: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   339: getfield 55	com/tencent/mobileqq/activity/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   342: getfield 90	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   345: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   348: ifeq -79 -> 269
    //   351: aload_0
    //   352: getfield 45	wwn:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   355: sipush 341
    //   358: invokevirtual 62	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   361: checkcast 303	zyd
    //   364: aload_0
    //   365: getfield 53	wwn:mActivity	Landroid/app/Activity;
    //   368: checkcast 305	com/tencent/mobileqq/app/BaseActivity
    //   371: aload_0
    //   372: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   375: invokevirtual 308	zyd:a	(Lcom/tencent/mobileqq/app/BaseActivity;Lcom/tencent/mobileqq/activity/BaseChatPie;)V
    //   378: aload_0
    //   379: getfield 45	wwn:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   382: ldc_w 310
    //   385: ldc_w 312
    //   388: ldc 105
    //   390: ldc_w 314
    //   393: ldc_w 316
    //   396: iconst_0
    //   397: iconst_0
    //   398: ldc 105
    //   400: ldc 105
    //   402: ldc 105
    //   404: ldc 105
    //   406: invokestatic 321	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   409: return
    //   410: astore_3
    //   411: ldc_w 292
    //   414: iconst_1
    //   415: aload_3
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   423: return
    //   424: iload_1
    //   425: bipush 13
    //   427: if_icmpne +140 -> 567
    //   430: invokestatic 329	ahtr:releaseCache	()V
    //   433: aload_0
    //   434: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   437: instanceof 272
    //   440: ifeq +31 -> 471
    //   443: ldc_w 274
    //   446: aload_0
    //   447: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   450: getfield 55	com/tencent/mobileqq/activity/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   453: getfield 90	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   456: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   459: ifeq +56 -> 515
    //   462: invokestatic 284	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   465: iconst_1
    //   466: bipush 54
    //   468: invokestatic 290	arlc:b	(Landroid/content/Context;ZI)V
    //   471: aload_0
    //   472: getfield 254	wwn:hb	Landroid/widget/LinearLayout;
    //   475: ifnull -206 -> 269
    //   478: aload_0
    //   479: getfield 212	wwn:IB	Landroid/widget/TextView;
    //   482: ifnull -213 -> 269
    //   485: aload_0
    //   486: getfield 254	wwn:hb	Landroid/widget/LinearLayout;
    //   489: aload_0
    //   490: getfield 212	wwn:IB	Landroid/widget/TextView;
    //   493: invokevirtual 332	android/widget/LinearLayout:removeView	(Landroid/view/View;)V
    //   496: aload_0
    //   497: aconst_null
    //   498: putfield 212	wwn:IB	Landroid/widget/TextView;
    //   501: return
    //   502: astore_3
    //   503: ldc_w 292
    //   506: iconst_1
    //   507: aload_3
    //   508: invokestatic 336	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   511: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: return
    //   515: aload_0
    //   516: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   519: getfield 55	com/tencent/mobileqq/activity/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   522: invokestatic 341	ocp:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)Z
    //   525: ifeq -54 -> 471
    //   528: aload_0
    //   529: getfield 45	wwn:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   532: sipush 341
    //   535: invokevirtual 62	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   538: checkcast 303	zyd
    //   541: aload_0
    //   542: getfield 53	wwn:mActivity	Landroid/app/Activity;
    //   545: invokevirtual 344	zyd:du	(Landroid/content/Context;)V
    //   548: goto -77 -> 471
    //   551: astore_3
    //   552: ldc_w 292
    //   555: iconst_1
    //   556: aload_3
    //   557: iconst_0
    //   558: anewarray 4	java/lang/Object
    //   561: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   564: goto -93 -> 471
    //   567: iload_1
    //   568: iconst_5
    //   569: if_icmpne +33 -> 602
    //   572: aload_0
    //   573: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   576: getfield 55	com/tencent/mobileqq/activity/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   579: invokestatic 341	ocp:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)Z
    //   582: ifeq -313 -> 269
    //   585: aload_0
    //   586: getfield 45	wwn:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   589: sipush 341
    //   592: invokevirtual 62	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   595: checkcast 303	zyd
    //   598: invokevirtual 347	zyd:csr	()V
    //   601: return
    //   602: iload_1
    //   603: bipush 9
    //   605: if_icmpne +33 -> 638
    //   608: aload_0
    //   609: getfield 40	wwn:c	Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   612: getfield 55	com/tencent/mobileqq/activity/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   615: invokestatic 341	ocp:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)Z
    //   618: ifeq -349 -> 269
    //   621: aload_0
    //   622: getfield 45	wwn:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   625: sipush 341
    //   628: invokevirtual 62	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   631: checkcast 303	zyd
    //   634: invokevirtual 350	zyd:css	()V
    //   637: return
    //   638: iload_1
    //   639: bipush 11
    //   641: if_icmpne -372 -> 269
    //   644: aload_0
    //   645: invokevirtual 180	wwn:ccE	()V
    //   648: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	this	wwn
    //   0	649	1	paramInt	int
    //   145	6	2	f	float
    //   270	19	3	localThrowable1	java.lang.Throwable
    //   301	19	3	localThrowable2	java.lang.Throwable
    //   410	6	3	localThrowable3	java.lang.Throwable
    //   502	6	3	localThrowable4	java.lang.Throwable
    //   551	6	3	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   6	47	270	java/lang/Throwable
    //   47	58	270	java/lang/Throwable
    //   58	231	301	java/lang/Throwable
    //   231	269	410	java/lang/Throwable
    //   332	409	410	java/lang/Throwable
    //   471	501	502	java/lang/Throwable
    //   433	471	551	java/lang/Throwable
    //   515	548	551	java/lang/Throwable
  }
  
  public void a(String paramString, ujt.d paramd, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && (paramString.length == 4))
    {
      paramd.mPasswdRedBagFlag = ((Integer)paramString[0]).intValue();
      paramd.mPasswdRedBagSender = ((Long)paramString[1]).longValue();
      if ((paramString[2] != null) && (zxj.d(this.app, this.sessionInfo.cZ, this.sessionInfo.aTl)))
      {
        paramd.aLP = ((String)paramString[2]);
        paramd.aLQ = ((String)paramString[3]);
        this.a = ((zxj)this.app.getManager(125));
        paramd.aTu = this.a.a(this.sessionInfo.aTl, this.sessionInfo.cZ, paramd.aLP, paramd.aLQ).booleanValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s, redBagIndex: %s", new Object[] { this.sessionInfo.aTl, Long.valueOf(paramd.mPasswdRedBagSender), Integer.valueOf(paramd.mPasswdRedBagFlag), Boolean.valueOf(paramd.aTu), paramd.aLP, paramd.aLQ }));
      }
    }
  }
  
  public void ai(String paramString1, String paramString2, String paramString3)
  {
    this.bRR = this.c.b.getFirstVisiblePosition();
    this.aUh = paramString1;
    this.aUi = paramString2;
    if (this.gk != null) {
      this.gk.setVisibility(0);
    }
    if (this.Iz != null) {
      this.Iz.setText(paramString2);
    }
    if (this.IA != null) {
      this.IA.setText(paramString3);
    }
    if (this.IB != null) {
      this.IB.setVisibility(8);
    }
    if (this.hb != null)
    {
      this.hb.setOrientation(1);
      this.hb.setVisibility(0);
      this.hb.bringToFront();
      this.hb.setOnClickListener(new wwo(this, paramString1, paramString2));
    }
    ((aewi)this.c.a(19)).cXA();
  }
  
  public void ccE()
  {
    if (this.Iz != null) {
      this.Iz.setText("");
    }
    if (this.IA != null) {
      this.IA.setText("");
    }
    if (this.hb != null) {
      this.hb.setVisibility(8);
    }
  }
  
  public void ccF()
  {
    if ((this.aUh != null) && (this.aUh.equals("0"))) {
      ccE();
    }
  }
  
  public void d(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.toString().equals(this.aUi))) {
      ccE();
    }
  }
  
  public void dB(String paramString1, String paramString2)
  {
    if ((this.hb != null) && (this.Iz != null) && (this.hb.getVisibility() == 0) && (!aqmr.isEmpty(this.aUh)) && (this.aUh.equals(paramString1)))
    {
      this.aUh = paramString1;
      this.aUi = paramString2;
      this.Iz.setText(paramString2);
    }
  }
  
  public boolean isShow()
  {
    return (this.hb != null) && (this.hb.getVisibility() == 0);
  }
  
  public void k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.aUh = paramString1;
    this.aUi = paramString2;
    if ((this.c != null) && (this.c.b != null)) {
      this.bRR = this.c.b.getFirstVisiblePosition();
    }
    if (this.gk != null) {
      this.gk.setVisibility(8);
    }
    if (this.Iz != null) {
      this.Iz.setText(paramString2);
    }
    if (this.IA != null) {
      this.IA.setText(paramString3);
    }
    if (this.IB != null)
    {
      this.IB.setVisibility(0);
      if (paramInt != 0) {
        break label188;
      }
      this.IB.setText(acfp.m(2131721905));
    }
    for (;;)
    {
      if (this.hb != null)
      {
        this.hb.setOrientation(0);
        this.hb.setVisibility(0);
        this.hb.bringToFront();
        this.hb.setOnClickListener(new wwp(this));
      }
      if (this.c != null) {
        ((aewi)this.c.a(19)).cXA();
      }
      return;
      label188:
      if (paramInt == 1) {
        this.IB.setText(acfp.m(2131721899));
      } else if (paramInt == 2) {
        this.IB.setText(acfp.m(2131721901));
      }
    }
  }
  
  public void xL(String paramString)
  {
    if ((this.hb != null) && (this.hb.getVisibility() == 0) && (!aqmr.isEmpty(this.aUh)) && (this.aUh.equals(paramString))) {
      ccE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwn
 * JD-Core Version:    0.7.0.1
 */