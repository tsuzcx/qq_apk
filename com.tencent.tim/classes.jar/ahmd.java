import android.content.Intent;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;
import com.tencent.mobileqq.forward.ForwardTribeShortVideoMsgOption.1;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;

public class ahmd
  extends ahlx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  protected String bKU;
  public ScrollView l;
  
  public ahmd(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  /* Error */
  protected boolean a(aqju paramaqju)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 25	aqju:getWindow	()Landroid/view/Window;
    //   4: bipush 19
    //   6: invokevirtual 31	android/view/Window:setSoftInputMode	(I)V
    //   9: aload_0
    //   10: getfield 35	ahmd:d	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   13: ifnull +477 -> 490
    //   16: aload_0
    //   17: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   20: ldc 40
    //   22: invokestatic 46	aqcx:dip2px	(Landroid/content/Context;F)I
    //   25: istore_2
    //   26: aload_0
    //   27: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   30: ldc 47
    //   32: invokestatic 46	aqcx:dip2px	(Landroid/content/Context;F)I
    //   35: istore_3
    //   36: aload_0
    //   37: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   40: ldc 48
    //   42: invokestatic 46	aqcx:dip2px	(Landroid/content/Context;F)I
    //   45: istore 4
    //   47: aload_0
    //   48: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   51: ldc 49
    //   53: invokestatic 46	aqcx:dip2px	(Landroid/content/Context;F)I
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   62: ldc 50
    //   64: invokestatic 46	aqcx:dip2px	(Landroid/content/Context;F)I
    //   67: istore 6
    //   69: ldc 52
    //   71: invokestatic 58	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   74: istore 7
    //   76: new 60	android/widget/LinearLayout
    //   79: dup
    //   80: aload_0
    //   81: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   84: invokespecial 63	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   87: astore 9
    //   89: aload 9
    //   91: iconst_1
    //   92: invokevirtual 66	android/widget/LinearLayout:setOrientation	(I)V
    //   95: new 68	android/widget/LinearLayout$LayoutParams
    //   98: dup
    //   99: bipush 254
    //   101: bipush 254
    //   103: invokespecial 71	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   106: astore 10
    //   108: aload 10
    //   110: iconst_1
    //   111: putfield 75	android/widget/LinearLayout$LayoutParams:gravity	I
    //   114: new 77	android/widget/RelativeLayout
    //   117: dup
    //   118: aload_0
    //   119: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   122: invokespecial 78	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   125: astore 11
    //   127: new 68	android/widget/LinearLayout$LayoutParams
    //   130: dup
    //   131: iload_3
    //   132: iload 4
    //   134: invokespecial 71	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   137: astore 12
    //   139: new 80	com/tencent/image/URLImageView
    //   142: dup
    //   143: aload_0
    //   144: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   147: invokespecial 81	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   150: astore 8
    //   152: aload 8
    //   154: getstatic 87	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   157: invokevirtual 91	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   160: new 93	android/widget/RelativeLayout$LayoutParams
    //   163: dup
    //   164: iconst_m1
    //   165: iconst_m1
    //   166: invokespecial 94	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   169: astore 13
    //   171: new 93	android/widget/RelativeLayout$LayoutParams
    //   174: dup
    //   175: iload 5
    //   177: iload 6
    //   179: invokespecial 94	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   182: astore 14
    //   184: aload 14
    //   186: bipush 9
    //   188: invokevirtual 97	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   191: aload 14
    //   193: bipush 10
    //   195: invokevirtual 97	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   198: aload 14
    //   200: iload_2
    //   201: putfield 100	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   204: aload 14
    //   206: aload_0
    //   207: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   210: ldc 101
    //   212: invokestatic 46	aqcx:dip2px	(Landroid/content/Context;F)I
    //   215: putfield 104	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   218: new 106	android/widget/TextView
    //   221: dup
    //   222: aload_0
    //   223: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   226: invokespecial 107	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   229: astore 14
    //   231: aload 14
    //   233: ldc 108
    //   235: invokevirtual 111	android/widget/TextView:setTextColor	(I)V
    //   238: aload 14
    //   240: iconst_1
    //   241: ldc 40
    //   243: invokevirtual 115	android/widget/TextView:setTextSize	(IF)V
    //   246: new 68	android/widget/LinearLayout$LayoutParams
    //   249: dup
    //   250: bipush 254
    //   252: bipush 254
    //   254: invokespecial 71	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   257: astore 15
    //   259: aload 15
    //   261: aload_0
    //   262: getfield 39	ahmd:mActivity	Landroid/app/Activity;
    //   265: ldc 116
    //   267: invokestatic 46	aqcx:dip2px	(Landroid/content/Context;F)I
    //   270: putfield 117	android/widget/LinearLayout$LayoutParams:topMargin	I
    //   273: aload 15
    //   275: iconst_3
    //   276: putfield 75	android/widget/LinearLayout$LayoutParams:gravity	I
    //   279: aload 11
    //   281: aload 8
    //   283: aload 13
    //   285: invokevirtual 121	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   288: aload 9
    //   290: aload 11
    //   292: aload 12
    //   294: invokevirtual 122	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   297: aload 9
    //   299: aload 14
    //   301: aload 15
    //   303: invokevirtual 122	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   306: aload_1
    //   307: aload 9
    //   309: aload 10
    //   311: invokevirtual 125	aqju:addView	(Landroid/view/View;Landroid/widget/LinearLayout$LayoutParams;)Laqju;
    //   314: pop
    //   315: aload 14
    //   317: aload_0
    //   318: getfield 35	ahmd:d	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   321: getfield 130	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceName	Ljava/lang/String;
    //   324: invokevirtual 134	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   327: aload_0
    //   328: getfield 35	ahmd:d	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   331: getfield 137	com/tencent/mobileqq/structmsg/AbsShareMsg:mContentCover	Ljava/lang/String;
    //   334: astore 9
    //   336: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +34 -> 373
    //   342: ldc 145
    //   344: iconst_2
    //   345: new 147	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   352: ldc 152
    //   354: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_0
    //   358: getfield 35	ahmd:d	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   361: getfield 159	com/tencent/mobileqq/structmsg/AbsShareMsg:mTribeShortVideoExtra	Ljava/lang/String;
    //   364: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: new 168	android/graphics/drawable/ColorDrawable
    //   376: dup
    //   377: iload 7
    //   379: invokespecial 170	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   382: astore 10
    //   384: aload 8
    //   386: aload 10
    //   388: invokevirtual 174	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   391: invokestatic 180	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   394: astore 11
    //   396: aload 11
    //   398: aload 10
    //   400: putfield 184	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   403: aload 11
    //   405: aload 10
    //   407: putfield 187	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   410: aload 11
    //   412: iload_3
    //   413: putfield 190	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   416: aload 11
    //   418: iload 4
    //   420: putfield 193	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   423: aload 9
    //   425: aload 11
    //   427: invokestatic 199	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   430: astore 9
    //   432: aload 9
    //   434: invokevirtual 203	com/tencent/image/URLDrawable:getStatus	()I
    //   437: iconst_2
    //   438: if_icmpne +8 -> 446
    //   441: aload 9
    //   443: invokevirtual 206	com/tencent/image/URLDrawable:restartDownload	()V
    //   446: aload 8
    //   448: aload 9
    //   450: invokevirtual 174	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   453: aload_0
    //   454: aload_1
    //   455: invokevirtual 25	aqju:getWindow	()Landroid/view/Window;
    //   458: invokevirtual 210	android/view/Window:getDecorView	()Landroid/view/View;
    //   461: ldc 211
    //   463: invokevirtual 217	android/view/View:findViewById	(I)Landroid/view/View;
    //   466: checkcast 219	android/widget/ScrollView
    //   469: putfield 221	ahmd:l	Landroid/widget/ScrollView;
    //   472: aload_0
    //   473: getfield 221	ahmd:l	Landroid/widget/ScrollView;
    //   476: ifnull +14 -> 490
    //   479: aload_0
    //   480: getfield 221	ahmd:l	Landroid/widget/ScrollView;
    //   483: invokevirtual 225	android/widget/ScrollView:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   486: aload_0
    //   487: invokevirtual 231	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   490: iconst_1
    //   491: ireturn
    //   492: astore 8
    //   494: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq -44 -> 453
    //   500: ldc 233
    //   502: iconst_2
    //   503: ldc 152
    //   505: aload 8
    //   507: invokestatic 237	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   510: goto -57 -> 453
    //   513: astore_1
    //   514: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq -27 -> 490
    //   520: ldc 233
    //   522: iconst_2
    //   523: new 147	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   530: ldc 152
    //   532: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload_1
    //   536: invokevirtual 238	java/lang/Exception:toString	()Ljava/lang/String;
    //   539: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 240	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   548: goto -58 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	551	0	this	ahmd
    //   0	551	1	paramaqju	aqju
    //   25	176	2	i	int
    //   35	378	3	j	int
    //   45	374	4	k	int
    //   56	120	5	m	int
    //   67	111	6	n	int
    //   74	304	7	i1	int
    //   150	297	8	localURLImageView	com.tencent.image.URLImageView
    //   492	14	8	localException	Exception
    //   87	362	9	localObject1	java.lang.Object
    //   106	300	10	localObject2	java.lang.Object
    //   125	301	11	localObject3	java.lang.Object
    //   137	156	12	localLayoutParams1	android.widget.LinearLayout.LayoutParams
    //   169	115	13	localLayoutParams	android.widget.RelativeLayout.LayoutParams
    //   182	134	14	localObject4	java.lang.Object
    //   257	45	15	localLayoutParams2	android.widget.LinearLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   373	446	492	java/lang/Exception
    //   446	453	492	java/lang/Exception
    //   453	490	513	java/lang/Exception
  }
  
  public boolean anj()
  {
    super.anj();
    this.bKU = this.bf.getString("qqtribeVideoInfoExtra ");
    AbsStructMsg localAbsStructMsg = anre.a(this.bf.getByteArray("stuctmsg_bytes"));
    if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg))) {
      this.d = ((AbsShareMsg)localAbsStructMsg);
    }
    if (this.d != null)
    {
      this.bf.putInt("emoInputType", 3);
      this.d.mTribeShortVideoExtra = this.bKU;
    }
    return true;
  }
  
  protected boolean ans()
  {
    return false;
  }
  
  protected void dnO()
  {
    super.dnO();
    removeLayoutListener();
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
    super.dnv();
  }
  
  public void onGlobalLayout()
  {
    if (this.l != null) {
      this.l.post(new ForwardTribeShortVideoMsgOption.1(this));
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
 * Qualified Name:     ahmd
 * JD-Core Version:    0.7.0.1
 */