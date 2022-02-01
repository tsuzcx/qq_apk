import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;
import com.tencent.mobileqq.forward.ForwardQQStoryMsgOption.1;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

public class ahjs
  extends ahlx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ScrollView l;
  
  public ahjs(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a(String paramString1, String paramString2, Context paramContext)
  {
    int i = 3;
    try
    {
      paramString2 = aqik.c(this.app, paramContext, paramString2);
      paramContext = "";
      str = "";
      for (;;)
      {
        try
        {
          j = this.bf.getInt("uintype");
          if (j != 0) {
            break label242;
          }
          i = 1;
          if (paramString2 == null) {
            continue;
          }
          paramContext = paramString2.getAttribute("unionid");
          str = paramString2.getAttribute("storyid");
        }
        catch (Exception paramString1)
        {
          if (!QLog.isColorLevel()) {
            break label236;
          }
          QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramString1);
          return;
          j = -1;
          paramString2 = str;
          continue;
        }
        try
        {
          j = Integer.valueOf(paramString2.getAttribute("contentType")).intValue();
          paramString2 = str;
        }
        catch (Exception paramString2)
        {
          paramString2.printStackTrace();
          paramString2 = str;
          j = -1;
        }
      }
      rar.a("share", paramString1, i, j, new String[] { paramContext, paramString2, "", "" });
      if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardQQStoryMsgOption", 2, "reportClickEvent: opName=" + paramString1 + ", fromType=" + i + ", result=" + j + ", extra1=" + paramContext + ", extra2=" + paramString2);
        return;
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        String str;
        int j;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.qqstory.share", 2, "report exp:", paramString2);
          break label237;
          label236:
          return;
        }
        label237:
        paramString2 = null;
        continue;
        label242:
        if (j == 1) {
          i = 2;
        } else if (j != 3000) {
          i = -1;
        }
      }
    }
  }
  
  /* Error */
  protected boolean a(aqju paramaqju)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 130	aqju:getWindow	()Landroid/view/Window;
    //   4: bipush 19
    //   6: invokevirtual 136	android/view/Window:setSoftInputMode	(I)V
    //   9: aload_0
    //   10: getfield 139	ahjs:d	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   13: ifnull +646 -> 659
    //   16: aload_0
    //   17: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   20: ldc 144
    //   22: invokestatic 150	aqcx:dip2px	(Landroid/content/Context;F)I
    //   25: istore_2
    //   26: aload_0
    //   27: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   30: ldc 151
    //   32: invokestatic 150	aqcx:dip2px	(Landroid/content/Context;F)I
    //   35: istore_3
    //   36: aload_0
    //   37: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   40: ldc 152
    //   42: invokestatic 150	aqcx:dip2px	(Landroid/content/Context;F)I
    //   45: istore 4
    //   47: aload_0
    //   48: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   51: ldc 153
    //   53: invokestatic 150	aqcx:dip2px	(Landroid/content/Context;F)I
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   62: ldc 154
    //   64: invokestatic 150	aqcx:dip2px	(Landroid/content/Context;F)I
    //   67: istore 6
    //   69: ldc 156
    //   71: invokestatic 161	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   74: istore 7
    //   76: new 163	android/widget/LinearLayout
    //   79: dup
    //   80: aload_0
    //   81: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   84: invokespecial 166	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   87: astore 8
    //   89: aload 8
    //   91: iconst_1
    //   92: invokevirtual 169	android/widget/LinearLayout:setOrientation	(I)V
    //   95: new 171	android/widget/LinearLayout$LayoutParams
    //   98: dup
    //   99: bipush 254
    //   101: bipush 254
    //   103: invokespecial 174	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   106: astore 9
    //   108: aload 9
    //   110: iconst_1
    //   111: putfield 178	android/widget/LinearLayout$LayoutParams:gravity	I
    //   114: new 180	android/widget/RelativeLayout
    //   117: dup
    //   118: aload_0
    //   119: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   122: invokespecial 181	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   125: astore 10
    //   127: new 171	android/widget/LinearLayout$LayoutParams
    //   130: dup
    //   131: iload_3
    //   132: iload 4
    //   134: invokespecial 174	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   137: astore 11
    //   139: new 183	com/tencent/image/URLImageView
    //   142: dup
    //   143: aload_0
    //   144: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   147: invokespecial 184	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   150: astore 14
    //   152: aload 14
    //   154: getstatic 190	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   157: invokevirtual 194	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   160: new 196	android/widget/RelativeLayout$LayoutParams
    //   163: dup
    //   164: iconst_m1
    //   165: iconst_m1
    //   166: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   169: astore 12
    //   171: new 183	com/tencent/image/URLImageView
    //   174: dup
    //   175: aload_0
    //   176: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   179: invokespecial 184	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   182: astore 13
    //   184: aload 13
    //   186: getstatic 200	android/widget/ImageView$ScaleType:FIT_START	Landroid/widget/ImageView$ScaleType;
    //   189: invokevirtual 194	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   192: new 196	android/widget/RelativeLayout$LayoutParams
    //   195: dup
    //   196: iload 5
    //   198: iload 6
    //   200: invokespecial 197	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   203: astore 15
    //   205: aload 15
    //   207: bipush 9
    //   209: invokevirtual 203	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   212: aload 15
    //   214: bipush 10
    //   216: invokevirtual 203	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   219: aload 15
    //   221: iload_2
    //   222: putfield 206	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   225: aload 15
    //   227: aload_0
    //   228: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   231: ldc 207
    //   233: invokestatic 150	aqcx:dip2px	(Landroid/content/Context;F)I
    //   236: putfield 210	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   239: new 212	android/widget/TextView
    //   242: dup
    //   243: aload_0
    //   244: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   247: invokespecial 213	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   250: astore 16
    //   252: aload 16
    //   254: ldc 214
    //   256: invokevirtual 217	android/widget/TextView:setTextColor	(I)V
    //   259: aload 16
    //   261: iconst_1
    //   262: ldc 144
    //   264: invokevirtual 221	android/widget/TextView:setTextSize	(IF)V
    //   267: new 171	android/widget/LinearLayout$LayoutParams
    //   270: dup
    //   271: bipush 254
    //   273: bipush 254
    //   275: invokespecial 174	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   278: astore 17
    //   280: aload 17
    //   282: aload_0
    //   283: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   286: ldc 222
    //   288: invokestatic 150	aqcx:dip2px	(Landroid/content/Context;F)I
    //   291: putfield 223	android/widget/LinearLayout$LayoutParams:topMargin	I
    //   294: aload 17
    //   296: iconst_3
    //   297: putfield 178	android/widget/LinearLayout$LayoutParams:gravity	I
    //   300: aload 10
    //   302: aload 14
    //   304: aload 12
    //   306: invokevirtual 227	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   309: aload 10
    //   311: aload 13
    //   313: aload 15
    //   315: invokevirtual 227	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   318: aload 8
    //   320: aload 10
    //   322: aload 11
    //   324: invokevirtual 228	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   327: aload 8
    //   329: aload 16
    //   331: aload 17
    //   333: invokevirtual 228	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   336: aload_1
    //   337: aload 8
    //   339: aload 9
    //   341: invokevirtual 231	aqju:addView	(Landroid/view/View;Landroid/widget/LinearLayout$LayoutParams;)Laqju;
    //   344: pop
    //   345: aload 16
    //   347: aload_0
    //   348: getfield 139	ahjs:d	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   351: getfield 237	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceName	Ljava/lang/String;
    //   354: invokevirtual 241	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   357: ldc 29
    //   359: astore 12
    //   361: new 243	org/json/JSONObject
    //   364: dup
    //   365: aload_0
    //   366: getfield 139	ahjs:d	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   369: getfield 246	com/tencent/mobileqq/structmsg/AbsShareMsg:mQQStoryExtra	Ljava/lang/String;
    //   372: invokespecial 249	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   375: astore 9
    //   377: aload 9
    //   379: ldc 251
    //   381: invokevirtual 254	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: astore 8
    //   386: aload 9
    //   388: ldc_w 256
    //   391: invokevirtual 254	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   394: astore 9
    //   396: aload 8
    //   398: astore 10
    //   400: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +35 -> 438
    //   406: ldc 112
    //   408: iconst_2
    //   409: new 82	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   416: ldc_w 258
    //   419: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_0
    //   423: getfield 139	ahjs:d	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   426: getfield 246	com/tencent/mobileqq/structmsg/AbsShareMsg:mQQStoryExtra	Ljava/lang/String;
    //   429: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: new 260	android/graphics/drawable/ColorDrawable
    //   441: dup
    //   442: iload 7
    //   444: invokespecial 262	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   447: astore 8
    //   449: aload 14
    //   451: aload 8
    //   453: invokevirtual 266	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   456: invokestatic 272	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   459: astore 11
    //   461: aload 11
    //   463: aload 8
    //   465: putfield 276	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   468: aload 11
    //   470: aload 8
    //   472: putfield 279	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   475: aload 11
    //   477: iload_3
    //   478: putfield 282	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   481: aload 11
    //   483: iload 4
    //   485: putfield 285	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   488: aload 10
    //   490: aload 11
    //   492: invokestatic 291	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   495: astore 8
    //   497: aload 8
    //   499: invokevirtual 294	com/tencent/image/URLDrawable:getStatus	()I
    //   502: iconst_2
    //   503: if_icmpne +8 -> 511
    //   506: aload 8
    //   508: invokevirtual 297	com/tencent/image/URLDrawable:restartDownload	()V
    //   511: aload 14
    //   513: aload 8
    //   515: invokevirtual 266	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   518: new 260	android/graphics/drawable/ColorDrawable
    //   521: dup
    //   522: ldc_w 299
    //   525: invokestatic 161	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   528: invokespecial 262	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   531: astore 8
    //   533: aload 13
    //   535: aload 8
    //   537: invokevirtual 266	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   540: invokestatic 272	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   543: astore 10
    //   545: aload 10
    //   547: aload 8
    //   549: putfield 276	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   552: aload 10
    //   554: aload 8
    //   556: putfield 279	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   559: aload 10
    //   561: iload 5
    //   563: putfield 282	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   566: aload 10
    //   568: iload 6
    //   570: putfield 285	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   573: aload 9
    //   575: aload 10
    //   577: invokestatic 291	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   580: astore 8
    //   582: aload 8
    //   584: invokevirtual 294	com/tencent/image/URLDrawable:getStatus	()I
    //   587: iconst_2
    //   588: if_icmpne +8 -> 596
    //   591: aload 8
    //   593: invokevirtual 297	com/tencent/image/URLDrawable:restartDownload	()V
    //   596: aload 13
    //   598: aload 8
    //   600: invokevirtual 266	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   603: aload_0
    //   604: aload_1
    //   605: invokevirtual 130	aqju:getWindow	()Landroid/view/Window;
    //   608: invokevirtual 303	android/view/Window:getDecorView	()Landroid/view/View;
    //   611: ldc_w 304
    //   614: invokevirtual 310	android/view/View:findViewById	(I)Landroid/view/View;
    //   617: checkcast 312	android/widget/ScrollView
    //   620: putfield 314	ahjs:l	Landroid/widget/ScrollView;
    //   623: aload_0
    //   624: getfield 314	ahjs:l	Landroid/widget/ScrollView;
    //   627: ifnull +14 -> 641
    //   630: aload_0
    //   631: getfield 314	ahjs:l	Landroid/widget/ScrollView;
    //   634: invokevirtual 318	android/widget/ScrollView:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   637: aload_0
    //   638: invokevirtual 324	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   641: aload_0
    //   642: ldc_w 326
    //   645: aload_0
    //   646: getfield 139	ahjs:d	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   649: getfield 329	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgAction	Ljava/lang/String;
    //   652: aload_0
    //   653: getfield 143	ahjs:mActivity	Landroid/app/Activity;
    //   656: invokevirtual 331	ahjs:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   659: iconst_1
    //   660: ireturn
    //   661: astore 11
    //   663: ldc 29
    //   665: astore 8
    //   667: aload 12
    //   669: astore 9
    //   671: aload 8
    //   673: astore 10
    //   675: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   678: ifeq -278 -> 400
    //   681: ldc 112
    //   683: iconst_2
    //   684: ldc_w 258
    //   687: aload 11
    //   689: invokestatic 118	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   692: aload 12
    //   694: astore 9
    //   696: aload 8
    //   698: astore 10
    //   700: goto -300 -> 400
    //   703: astore 8
    //   705: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   708: ifeq -190 -> 518
    //   711: ldc 112
    //   713: iconst_2
    //   714: ldc_w 258
    //   717: aload 8
    //   719: invokestatic 118	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   722: goto -204 -> 518
    //   725: astore 8
    //   727: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq -127 -> 603
    //   733: ldc 112
    //   735: iconst_2
    //   736: ldc_w 258
    //   739: aload 8
    //   741: invokestatic 118	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   744: goto -141 -> 603
    //   747: astore_1
    //   748: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   751: ifeq -110 -> 641
    //   754: ldc 112
    //   756: iconst_2
    //   757: new 82	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   764: ldc_w 258
    //   767: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload_1
    //   771: invokevirtual 332	java/lang/Exception:toString	()Ljava/lang/String;
    //   774: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 334	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: goto -142 -> 641
    //   786: astore 11
    //   788: goto -121 -> 667
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	791	0	this	ahjs
    //   0	791	1	paramaqju	aqju
    //   25	197	2	i	int
    //   35	443	3	j	int
    //   45	439	4	k	int
    //   56	506	5	m	int
    //   67	502	6	n	int
    //   74	369	7	i1	int
    //   87	610	8	localObject1	java.lang.Object
    //   703	15	8	localException1	Exception
    //   725	15	8	localException2	Exception
    //   106	589	9	localObject2	java.lang.Object
    //   125	574	10	localObject3	java.lang.Object
    //   137	354	11	localObject4	java.lang.Object
    //   661	27	11	localException3	Exception
    //   786	1	11	localException4	Exception
    //   169	524	12	localObject5	java.lang.Object
    //   182	415	13	localURLImageView1	com.tencent.image.URLImageView
    //   150	362	14	localURLImageView2	com.tencent.image.URLImageView
    //   203	111	15	localLayoutParams	android.widget.RelativeLayout.LayoutParams
    //   250	96	16	localTextView	android.widget.TextView
    //   278	54	17	localLayoutParams1	android.widget.LinearLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   361	386	661	java/lang/Exception
    //   438	511	703	java/lang/Exception
    //   511	518	703	java/lang/Exception
    //   518	596	725	java/lang/Exception
    //   596	603	725	java/lang/Exception
    //   603	641	747	java/lang/Exception
    //   386	396	786	java/lang/Exception
  }
  
  protected boolean ans()
  {
    return false;
  }
  
  protected void dnO()
  {
    super.dnO();
    removeLayoutListener();
    if (this.d != null) {
      a("cancel", this.d.mMsgAction, this.mActivity);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "forwardOnCancel");
    }
  }
  
  protected void dnv()
  {
    int i = EU();
    String str = "";
    if (i != 0) {
      str = this.e.getInputValue();
    }
    this.bf.putString("share_comment_message", str);
    removeLayoutListener();
    if (this.d != null) {
      a("clk_send", this.d.mMsgAction, this.mActivity);
    }
    super.dnv();
  }
  
  public void onGlobalLayout()
  {
    if (this.l != null) {
      this.l.post(new ForwardQQStoryMsgOption.1(this));
    }
  }
  
  protected void removeLayoutListener()
  {
    if (this.l != null) {}
    try
    {
      this.l.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "removeLayoutListener:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjs
 * JD-Core Version:    0.7.0.1
 */