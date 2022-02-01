package com.tencent.mobileqq.activity.bless;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqcu;
import aqhu;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.FileInputStream;
import java.io.InputStream;
import yld;
import ylf;
import ylg;
import ylh;
import yli;
import ylm;

public class BlessActivity
  extends BlessTypeActivity
  implements View.OnClickListener
{
  private BroadcastReceiver A;
  private String TAG = "BlessActivity";
  public AnimationDrawable2 a;
  private String aYC;
  private String aYD;
  private QQVideoView b;
  private int bZK = -1;
  private int bZL;
  private boolean bnf;
  private boolean bng;
  private boolean bnh;
  private boolean bni;
  private boolean isFromSearch;
  private AudioManager mAudioManager;
  private Handler mHandler = new Handler();
  private int mScreenHeight;
  private int mScreenWidth;
  private ImageView ul;
  private ImageView um;
  private View xN;
  
  private void Ag(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "stopPlayingStarVideo mNeedShowStarVideo=" + this.bnf + ", mIsPlayingStarVideo=" + this.bng);
    }
    if (this.bnf)
    {
      this.bng = false;
      if (paramBoolean)
      {
        View localView = findViewById(2131371174);
        localView.setVisibility(0);
        localView.bringToFront();
        findViewById(2131369676).bringToFront();
        findViewById(2131379769).bringToFront();
      }
      if (this.xN != null)
      {
        this.xN.setClickable(false);
        this.xN.setVisibility(8);
      }
      if (this.ul != null) {
        this.ul.setVisibility(8);
      }
      if (this.b != null)
      {
        if (this.b.isPlaying()) {
          this.b.stopPlayback();
        }
        this.b = null;
      }
      if (this.mAudioManager != null) {
        this.mAudioManager.abandonAudioFocus(null);
      }
    }
  }
  
  /* Error */
  private void cjb()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 167	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_Ylm	Lylm;
    //   9: invokevirtual 172	ylm:pK	()Ljava/lang/String;
    //   12: astore 7
    //   14: aload_0
    //   15: getfield 167	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_Ylm	Lylm;
    //   18: invokevirtual 175	ylm:pL	()Ljava/lang/String;
    //   21: astore 8
    //   23: aload 8
    //   25: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: istore 5
    //   30: iload 5
    //   32: ifeq +37 -> 69
    //   35: iconst_0
    //   36: ifeq +11 -> 47
    //   39: new 183	java/lang/NullPointerException
    //   42: dup
    //   43: invokespecial 184	java/lang/NullPointerException:<init>	()V
    //   46: athrow
    //   47: return
    //   48: astore 6
    //   50: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq -6 -> 47
    //   56: aload_0
    //   57: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   60: iconst_2
    //   61: ldc 186
    //   63: aload 6
    //   65: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: return
    //   69: new 192	java/io/File
    //   72: dup
    //   73: aload 7
    //   75: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 9
    //   80: new 192	java/io/File
    //   83: dup
    //   84: aload 8
    //   86: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 198	java/io/File:exists	()Z
    //   92: ifne +22 -> 114
    //   95: aload 9
    //   97: invokevirtual 198	java/io/File:exists	()Z
    //   100: ifeq +14 -> 114
    //   103: aload 9
    //   105: invokevirtual 201	java/io/File:getPath	()Ljava/lang/String;
    //   108: aload 8
    //   110: iconst_0
    //   111: invokestatic 207	aqhq:W	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   114: new 209	java/io/FileInputStream
    //   117: dup
    //   118: aload 7
    //   120: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   123: astore 7
    //   125: new 212	android/graphics/BitmapFactory$Options
    //   128: dup
    //   129: invokespecial 213	android/graphics/BitmapFactory$Options:<init>	()V
    //   132: astore 6
    //   134: aload 6
    //   136: aload 7
    //   138: aload_0
    //   139: getfield 145	com/tencent/mobileqq/activity/bless/BlessActivity:um	Landroid/widget/ImageView;
    //   142: invokevirtual 217	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   145: getfield 222	android/view/ViewGroup$LayoutParams:width	I
    //   148: aload_0
    //   149: getfield 145	com/tencent/mobileqq/activity/bless/BlessActivity:um	Landroid/widget/ImageView;
    //   152: invokevirtual 217	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   155: getfield 225	android/view/ViewGroup$LayoutParams:height	I
    //   158: invokestatic 231	aqhu:getOptRatio	(Ljava/io/InputStream;II)D
    //   161: d2i
    //   162: putfield 234	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   165: aload_0
    //   166: getfield 167	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_Ylm	Lylm;
    //   169: invokevirtual 238	ylm:xd	()I
    //   172: istore_3
    //   173: iload_3
    //   174: iconst_m1
    //   175: if_icmpne +87 -> 262
    //   178: new 67	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   185: aload 8
    //   187: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iconst_1
    //   191: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc 243
    //   196: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: aload 6
    //   204: invokestatic 249	aqcu:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   207: astore 6
    //   209: aload_0
    //   210: getfield 145	com/tencent/mobileqq/activity/bless/BlessActivity:um	Landroid/widget/ImageView;
    //   213: new 251	com/tencent/mobileqq/activity/bless/BlessActivity$3
    //   216: dup
    //   217: aload_0
    //   218: aload 6
    //   220: invokespecial 254	com/tencent/mobileqq/activity/bless/BlessActivity$3:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;Landroid/graphics/Bitmap;)V
    //   223: ldc2_w 255
    //   226: invokevirtual 260	android/widget/ImageView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   229: pop
    //   230: aload 7
    //   232: ifnull -185 -> 47
    //   235: aload 7
    //   237: invokevirtual 265	java/io/InputStream:close	()V
    //   240: return
    //   241: astore 6
    //   243: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -199 -> 47
    //   249: aload_0
    //   250: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   253: iconst_2
    //   254: ldc 186
    //   256: aload 6
    //   258: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: return
    //   262: new 192	java/io/File
    //   265: dup
    //   266: aload 8
    //   268: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   271: astore 9
    //   273: aload 9
    //   275: invokevirtual 268	java/io/File:isDirectory	()Z
    //   278: istore 5
    //   280: iload 5
    //   282: ifne +35 -> 317
    //   285: aload 7
    //   287: ifnull -240 -> 47
    //   290: aload 7
    //   292: invokevirtual 265	java/io/InputStream:close	()V
    //   295: return
    //   296: astore 6
    //   298: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq -254 -> 47
    //   304: aload_0
    //   305: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   308: iconst_2
    //   309: ldc 186
    //   311: aload 6
    //   313: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: return
    //   317: aload 9
    //   319: invokevirtual 272	java/io/File:list	()[Ljava/lang/String;
    //   322: arraylength
    //   323: istore 4
    //   325: aload_0
    //   326: getfield 167	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_Ylm	Lylm;
    //   329: invokevirtual 275	ylm:xe	()I
    //   332: istore_2
    //   333: aload_0
    //   334: new 8	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2
    //   337: dup
    //   338: aload_0
    //   339: invokespecial 277	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   342: putfield 279	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   345: iload_1
    //   346: iload 4
    //   348: if_icmpge +67 -> 415
    //   351: new 67	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   358: aload 8
    //   360: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: iload_1
    //   364: iconst_1
    //   365: iadd
    //   366: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: ldc 243
    //   371: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: aload 6
    //   379: invokestatic 249	aqcu:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   382: astore 9
    //   384: aload_0
    //   385: getfield 279	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   388: new 281	android/graphics/drawable/BitmapDrawable
    //   391: dup
    //   392: aload_0
    //   393: invokevirtual 285	com/tencent/mobileqq/activity/bless/BlessActivity:getResources	()Landroid/content/res/Resources;
    //   396: aload 9
    //   398: invokespecial 288	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   401: iload_2
    //   402: iload 4
    //   404: idiv
    //   405: invokevirtual 292	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:addFrame	(Landroid/graphics/drawable/Drawable;I)V
    //   408: iload_1
    //   409: iconst_1
    //   410: iadd
    //   411: istore_1
    //   412: goto -67 -> 345
    //   415: iload_3
    //   416: ifne +62 -> 478
    //   419: aload_0
    //   420: getfield 279	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   423: iconst_0
    //   424: invokevirtual 295	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:setOneShot	(Z)V
    //   427: aload_0
    //   428: getfield 145	com/tencent/mobileqq/activity/bless/BlessActivity:um	Landroid/widget/ImageView;
    //   431: new 297	com/tencent/mobileqq/activity/bless/BlessActivity$5
    //   434: dup
    //   435: aload_0
    //   436: invokespecial 298	com/tencent/mobileqq/activity/bless/BlessActivity$5:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   439: ldc2_w 255
    //   442: invokevirtual 260	android/widget/ImageView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   445: pop
    //   446: aload 7
    //   448: ifnull -401 -> 47
    //   451: aload 7
    //   453: invokevirtual 265	java/io/InputStream:close	()V
    //   456: return
    //   457: astore 6
    //   459: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq -415 -> 47
    //   465: aload_0
    //   466: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   469: iconst_2
    //   470: ldc 186
    //   472: aload 6
    //   474: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   477: return
    //   478: aload_0
    //   479: getfield 279	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   482: iconst_1
    //   483: invokevirtual 295	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:setOneShot	(Z)V
    //   486: aload_0
    //   487: getfield 279	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   490: new 300	yle
    //   493: dup
    //   494: aload_0
    //   495: invokespecial 301	yle:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   498: invokevirtual 304	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:a	(Lcom/tencent/mobileqq/activity/bless/BlessActivity$a;)V
    //   501: goto -74 -> 427
    //   504: astore 8
    //   506: aload 7
    //   508: astore 6
    //   510: aload 8
    //   512: astore 7
    //   514: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +16 -> 533
    //   520: aload_0
    //   521: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   524: iconst_2
    //   525: ldc_w 306
    //   528: aload 7
    //   530: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   533: aload 6
    //   535: ifnull -488 -> 47
    //   538: aload 6
    //   540: invokevirtual 265	java/io/InputStream:close	()V
    //   543: return
    //   544: astore 6
    //   546: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   549: ifeq -502 -> 47
    //   552: aload_0
    //   553: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   556: iconst_2
    //   557: ldc 186
    //   559: aload 6
    //   561: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: return
    //   565: astore 6
    //   567: aconst_null
    //   568: astore 7
    //   570: aload 7
    //   572: ifnull +8 -> 580
    //   575: aload 7
    //   577: invokevirtual 265	java/io/InputStream:close	()V
    //   580: aload 6
    //   582: athrow
    //   583: astore 7
    //   585: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   588: ifeq -8 -> 580
    //   591: aload_0
    //   592: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   595: iconst_2
    //   596: ldc 186
    //   598: aload 7
    //   600: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   603: goto -23 -> 580
    //   606: astore 6
    //   608: goto -38 -> 570
    //   611: astore 8
    //   613: aload 6
    //   615: astore 7
    //   617: aload 8
    //   619: astore 6
    //   621: goto -51 -> 570
    //   624: astore 7
    //   626: goto -112 -> 514
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	this	BlessActivity
    //   1	411	1	i	int
    //   332	73	2	j	int
    //   172	244	3	k	int
    //   323	82	4	m	int
    //   28	253	5	bool	boolean
    //   3	1	6	localObject1	Object
    //   48	16	6	localException1	Exception
    //   132	87	6	localObject2	Object
    //   241	16	6	localException2	Exception
    //   296	82	6	localException3	Exception
    //   457	16	6	localException4	Exception
    //   508	31	6	localObject3	Object
    //   544	16	6	localException5	Exception
    //   565	16	6	localObject4	Object
    //   606	8	6	localObject5	Object
    //   619	1	6	localObject6	Object
    //   12	564	7	localObject7	Object
    //   583	16	7	localException6	Exception
    //   615	1	7	localObject8	Object
    //   624	1	7	localException7	Exception
    //   21	338	8	str	String
    //   504	7	8	localException8	Exception
    //   611	7	8	localObject9	Object
    //   78	319	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   39	47	48	java/lang/Exception
    //   235	240	241	java/lang/Exception
    //   290	295	296	java/lang/Exception
    //   451	456	457	java/lang/Exception
    //   125	173	504	java/lang/Exception
    //   178	230	504	java/lang/Exception
    //   262	280	504	java/lang/Exception
    //   317	345	504	java/lang/Exception
    //   351	408	504	java/lang/Exception
    //   419	427	504	java/lang/Exception
    //   427	446	504	java/lang/Exception
    //   478	501	504	java/lang/Exception
    //   538	543	544	java/lang/Exception
    //   5	30	565	finally
    //   69	114	565	finally
    //   114	125	565	finally
    //   575	580	583	java/lang/Exception
    //   125	173	606	finally
    //   178	230	606	finally
    //   262	280	606	finally
    //   317	345	606	finally
    //   351	408	606	finally
    //   419	427	606	finally
    //   427	446	606	finally
    //   478	501	606	finally
    //   514	533	611	finally
    //   5	30	624	java/lang/Exception
    //   69	114	624	java/lang/Exception
    //   114	125	624	java/lang/Exception
  }
  
  private void cjc()
  {
    if (this.bnh) {
      return;
    }
    this.bnh = true;
    Object localObject1 = (RelativeLayout)findViewById(2131377546);
    if (this.b == null) {
      this.b = ((QQVideoView)findViewById(2131381885));
    }
    if (this.mAudioManager == null) {
      this.mAudioManager = ((AudioManager)getSystemService("audio"));
    }
    this.b.setVideoPath(this.aYC);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int j = this.mScreenWidth;
    int i = (int)(j / 900 * 700 + 0.5F);
    if (i % 2 == 1) {
      i += 1;
    }
    for (;;)
    {
      this.bng = true;
      cjd();
      Object localObject2 = (RelativeLayout.LayoutParams)findViewById(2131371174).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = j;
      ((RelativeLayout.LayoutParams)localObject2).height = i;
      this.ul = ((ImageView)findViewById(2131381878));
      this.ul.setVisibility(0);
      try
      {
        localObject2 = new FileInputStream(this.aYD);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = ((int)aqhu.getOptRatio((InputStream)localObject2, j, i));
        localObject2 = aqcu.decodeFile(this.aYD, localOptions);
        if (localObject2 != null) {
          this.ul.setImageBitmap((Bitmap)localObject2);
        }
        localObject2 = (RelativeLayout.LayoutParams)this.ul.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = j;
        ((RelativeLayout.LayoutParams)localObject2).height = i;
        this.ul.bringToFront();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.TAG, 2, "decode mVideoCoverPath error = " + localException.getMessage());
          }
        }
      }
      findViewById(2131379769).bringToFront();
      this.b.setDimension(j, i);
      ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).setMargins(0, 0, 0, 0);
      this.xN = new View(this);
      ((RelativeLayout)localObject1).addView(this.xN);
      localObject1 = (RelativeLayout.LayoutParams)this.xN.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, (int)(localDisplayMetrics.density * 31.0F + 0.5F), 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)(localDisplayMetrics.density * 60.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(localDisplayMetrics.density * 60.0F + 0.5F));
      this.xN.bringToFront();
      this.xN.setOnClickListener(new ylf(this));
      if (this.mAudioManager != null) {
        this.mAudioManager.requestAudioFocus(null, 3, 1);
      }
      this.b.setVisibility(0);
      this.b.setOnPreparedListener(new ylg(this));
      this.b.setOnCompletionListener(new ylh(this));
      this.b.setOnErrorListener(new yli(this));
      return;
    }
  }
  
  private void cjd()
  {
    if (this.A == null) {
      this.A = new yld(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.A, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  public void Ad()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 448
    //   4: invokevirtual 96	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   7: checkcast 116	android/widget/ImageView
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 167	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_Ylm	Lylm;
    //   15: invokevirtual 451	ylm:pG	()Ljava/lang/String;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +125 -> 145
    //   23: new 209	java/io/FileInputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: new 212	android/graphics/BitmapFactory$Options
    //   35: dup
    //   36: invokespecial 213	android/graphics/BitmapFactory$Options:<init>	()V
    //   39: astore 4
    //   41: aload 4
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 217	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   48: getfield 222	android/view/ViewGroup$LayoutParams:width	I
    //   51: aload_1
    //   52: invokevirtual 217	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   55: getfield 225	android/view/ViewGroup$LayoutParams:height	I
    //   58: invokestatic 231	aqhu:getOptRatio	(Ljava/io/InputStream;II)D
    //   61: d2i
    //   62: putfield 234	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   65: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +53 -> 121
    //   71: aload_0
    //   72: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   75: iconst_2
    //   76: new 67	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 453
    //   86: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 217	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   93: getfield 222	android/view/ViewGroup$LayoutParams:width	I
    //   96: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc_w 455
    //   102: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 217	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   109: getfield 225	android/view/ViewGroup$LayoutParams:height	I
    //   112: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_3
    //   122: aload 4
    //   124: invokestatic 249	aqcu:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   127: astore_3
    //   128: aload_3
    //   129: ifnull +8 -> 137
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 358	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 265	java/io/InputStream:close	()V
    //   145: aload_0
    //   146: getfield 76	com/tencent/mobileqq/activity/bless/BlessActivity:bnf	Z
    //   149: ifeq +30 -> 179
    //   152: aload_0
    //   153: ldc_w 309
    //   156: invokevirtual 96	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   159: checkcast 311	android/widget/RelativeLayout
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 459	android/widget/RelativeLayout:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   167: new 461	ylc
    //   170: dup
    //   171: aload_0
    //   172: aload_1
    //   173: invokespecial 464	ylc:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;Landroid/widget/RelativeLayout;)V
    //   176: invokevirtual 470	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   179: aload_0
    //   180: getfield 167	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_Ylm	Lylm;
    //   183: invokevirtual 474	ylm:k	()Ljava/lang/Boolean;
    //   186: invokevirtual 479	java/lang/Boolean:booleanValue	()Z
    //   189: ifeq +32 -> 221
    //   192: aload_0
    //   193: aload_0
    //   194: ldc_w 480
    //   197: invokevirtual 96	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   200: checkcast 116	android/widget/ImageView
    //   203: putfield 145	com/tencent/mobileqq/activity/bless/BlessActivity:um	Landroid/widget/ImageView;
    //   206: new 482	com/tencent/mobileqq/activity/bless/BlessActivity$2
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 483	com/tencent/mobileqq/activity/bless/BlessActivity$2:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   214: bipush 10
    //   216: aconst_null
    //   217: iconst_1
    //   218: invokestatic 489	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   221: return
    //   222: astore_1
    //   223: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq -81 -> 145
    //   229: aload_0
    //   230: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   233: iconst_2
    //   234: ldc 186
    //   236: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: goto -94 -> 145
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_1
    //   245: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +14 -> 262
    //   251: aload_0
    //   252: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   255: iconst_2
    //   256: ldc_w 491
    //   259: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_1
    //   263: ifnull -118 -> 145
    //   266: aload_1
    //   267: invokevirtual 265	java/io/InputStream:close	()V
    //   270: goto -125 -> 145
    //   273: astore_1
    //   274: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -132 -> 145
    //   280: aload_0
    //   281: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   284: iconst_2
    //   285: ldc 186
    //   287: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: goto -145 -> 145
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_2
    //   296: aload_2
    //   297: ifnull +7 -> 304
    //   300: aload_2
    //   301: invokevirtual 265	java/io/InputStream:close	()V
    //   304: aload_1
    //   305: athrow
    //   306: astore_2
    //   307: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq -6 -> 304
    //   313: aload_0
    //   314: getfield 49	com/tencent/mobileqq/activity/bless/BlessActivity:TAG	Ljava/lang/String;
    //   317: iconst_2
    //   318: ldc 186
    //   320: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: goto -19 -> 304
    //   326: astore_1
    //   327: goto -31 -> 296
    //   330: astore_3
    //   331: aload_1
    //   332: astore_2
    //   333: aload_3
    //   334: astore_1
    //   335: goto -39 -> 296
    //   338: astore_1
    //   339: aload_2
    //   340: astore_1
    //   341: goto -96 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	BlessActivity
    //   10	163	1	localObject1	Object
    //   222	1	1	localException1	Exception
    //   242	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   244	23	1	localObject2	Object
    //   273	1	1	localException2	Exception
    //   293	12	1	localObject3	Object
    //   326	6	1	localObject4	Object
    //   334	1	1	localObject5	Object
    //   338	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   340	1	1	localObject6	Object
    //   31	270	2	localFileInputStream	FileInputStream
    //   306	1	2	localException3	Exception
    //   332	8	2	localObject7	Object
    //   18	116	3	localObject8	Object
    //   330	4	3	localObject9	Object
    //   39	84	4	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   141	145	222	java/lang/Exception
    //   23	32	242	java/io/FileNotFoundException
    //   266	270	273	java/lang/Exception
    //   23	32	293	finally
    //   300	304	306	java/lang/Exception
    //   32	121	326	finally
    //   121	128	326	finally
    //   132	137	326	finally
    //   245	262	330	finally
    //   32	121	338	java/io/FileNotFoundException
    //   121	128	338	java/io/FileNotFoundException
    //   132	137	338	java/io/FileNotFoundException
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558762);
    if (this.jdField_a_of_type_Ylm.TZ())
    {
      this.aYC = this.jdField_a_of_type_Ylm.pI();
      this.aYD = this.jdField_a_of_type_Ylm.pJ();
      if ((this.aYC != null) && (this.aYD != null)) {
        this.bnf = true;
      }
    }
    this.qJ = 0.6933333F;
    this.bannerType = 1;
    Ad();
    this.jdField_a_of_type_Ylm.setRead(false);
    this.isFromSearch = getIntent().getBooleanExtra("PARAM_IS_FROM_SEARCH", false);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Ylm.cji();
    if (this.A != null) {
      unregisterReceiver(this.A);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2.isRunning())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2.stop();
    }
    this.A = null;
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnPause");
    }
    if ((this.bnf) && (this.bng))
    {
      if (!this.bni) {
        break label48;
      }
      Ag(true);
    }
    for (;;)
    {
      super.doOnPause();
      return;
      label48:
      if (this.b != null)
      {
        this.b.pause();
        this.bZK = this.b.getCurrentPosition();
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.bZK != -1) && (this.b != null))
    {
      this.b.seekTo(this.bZK);
      this.b.start();
      this.bZK = -1;
    }
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onBackEvent");
    }
    Ag(false);
    if (!this.isFromSearch)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.bnf) {
        Ag(true);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public class AnimationDrawable2
    extends AnimationDrawable
  {
    private BlessActivity.a a;
    private boolean finished;
    
    public AnimationDrawable2() {}
    
    public void a(BlessActivity.a parama)
    {
      this.a = parama;
    }
    
    public void reset()
    {
      stop();
      this.finished = false;
    }
    
    public boolean selectDrawable(int paramInt)
    {
      boolean bool = super.selectDrawable(paramInt);
      if ((paramInt != 0) && (paramInt == getNumberOfFrames() - 1) && (!this.finished))
      {
        this.finished = true;
        if (this.a != null) {
          this.a.onAnimationFinished();
        }
      }
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onAnimationFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity
 * JD-Core Version:    0.7.0.1
 */