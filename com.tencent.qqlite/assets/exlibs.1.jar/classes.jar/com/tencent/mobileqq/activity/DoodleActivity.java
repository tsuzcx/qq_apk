package com.tencent.mobileqq.activity;

import ajw;
import ajx;
import aka;
import akb;
import akc;
import akd;
import ake;
import akf;
import akg;
import akh;
import aki;
import akj;
import akm;
import akn;
import ako;
import akp;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.DoodlePicView;
import com.tencent.mobileqq.widget.DoodleTextView;
import com.tencent.widget.ActionSheet;
import java.io.File;

public class DoodleActivity
  extends BaseActivity
{
  static final int jdField_a_of_type_Int = 6;
  private static final String jdField_a_of_type_JavaLangString = "DoodleActivity";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 6;
  private static final String jdField_f_of_type_JavaLangString = "key_photo_uri";
  private float jdField_a_of_type_Float;
  public Uri a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new akb(this);
  public ImageView a;
  public LinearLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public DoodlePicView a;
  public DoodleTextView a;
  public boolean a;
  public int[] a;
  public ImageView[] a;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new akc(this);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  private String jdField_b_of_type_JavaLangString;
  protected boolean b;
  public int[] b;
  public ImageView[] b;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new akd(this);
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public LinearLayout c;
  private String jdField_c_of_type_JavaLangString;
  public int[] c;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private String jdField_d_of_type_JavaLangString;
  public int[] d;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  
  public DoodleActivity()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131297028, 2131297029, 2131297030, 2131297031, 2131297032, 2131297033 };
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2131297037, 2131297038, 2131297039, 2131297040, 2131297041, 2131297042 };
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { null, null, null, null, null, null };
    this.jdField_b_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { null, null, null, null, null, null };
    this.jdField_c_of_type_ArrayOfInt = new int[] { 15, 13, 11, 9, 7, 5 };
    this.jdField_d_of_type_ArrayOfInt = new int[] { -16777216, -2474221, -417499, -1191381, -9719783, -14582051 };
    this.jdField_a_of_type_AndroidOsHandler = new ake(this);
  }
  
  private long a(String paramString)
  {
    long l = 0L;
    if (paramString != null)
    {
      MessageForPic localMessageForPic = MessageRecordFactory.a(this.app, this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_Int);
      localMessageForPic.path = paramString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.serial();
      ((SVIPHandler)this.app.a(12)).a(localMessageForPic);
      this.app.a().a(localMessageForPic, this.app.a());
      l = localMessageForPic.uniseq;
    }
    return l;
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Uri localUri = paramIntent.getData();
      paramIntent = localUri;
      if (localUri != null) {}
    }
    else
    {
      paramIntent = this.jdField_a_of_type_AndroidNetUri;
    }
    if (paramIntent == null) {
      return;
    }
    paramIntent = ImageUtil.c(this, paramIntent);
    if (paramIntent != null)
    {
      if (!FileUtils.e(paramIntent))
      {
        Toast.makeText(this, getString(2131363408), 0).show();
        return;
      }
      if (!new File(paramIntent).exists())
      {
        Toast.makeText(this, getString(2131363409), 0).show();
        return;
      }
    }
    PhotoUtils.a(new Intent(), this, DoodleActivity.class.getName(), null, paramIntent, false);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.setPhotoFile(paramString);
      return;
    }
    Toast.makeText(this, getString(2131363429), 0).show();
  }
  
  private void d()
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    String[] arrayOfString = getResources().getStringArray(2131230723);
    int k = arrayOfString.length;
    int j = 0;
    while (j < k)
    {
      localActionSheet.c(arrayOfString[j]);
      j += 1;
    }
    localActionSheet.d(2131362790);
    localActionSheet.a(new akf(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(new akh(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView.setHandler(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aki(this));
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setOnClickListener(new akj(this));
    this.i.setOnClickListener(new akm(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(new akn(this));
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ako(this));
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    this.g.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(new akp(this));
    this.h.setOnClickListener(new ajx(this));
    this.i.setOnClickListener(new aka(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 325	com/tencent/mobileqq/activity/DoodleActivity:jdField_b_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 325	com/tencent/mobileqq/activity/DoodleActivity:jdField_b_of_type_Boolean	Z
    //   13: new 327	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   20: getstatic 333	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   23: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 339
    //   29: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokestatic 345	java/lang/System:currentTimeMillis	()J
    //   35: invokestatic 351	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   38: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 353
    //   44: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 7
    //   52: new 187	java/io/File
    //   55: dup
    //   56: new 327	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   63: getstatic 333	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   66: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 339
    //   72: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: astore 4
    //   83: aload 4
    //   85: invokevirtual 194	java/io/File:exists	()Z
    //   88: ifne +9 -> 97
    //   91: aload 4
    //   93: invokevirtual 359	java/io/File:mkdirs	()Z
    //   96: pop
    //   97: aconst_null
    //   98: astore 4
    //   100: new 361	java/io/FileOutputStream
    //   103: dup
    //   104: aload 7
    //   106: invokespecial 362	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   109: astore 5
    //   111: aload 5
    //   113: astore 4
    //   115: aload_0
    //   116: getfield 251	com/tencent/mobileqq/activity/DoodleActivity:jdField_a_of_type_Boolean	Z
    //   119: ifeq +44 -> 163
    //   122: aload 5
    //   124: astore 4
    //   126: aload_0
    //   127: getfield 273	com/tencent/mobileqq/activity/DoodleActivity:jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView	Lcom/tencent/mobileqq/widget/DoodleTextView;
    //   130: invokevirtual 365	com/tencent/mobileqq/widget/DoodleTextView:a	()Landroid/graphics/Bitmap;
    //   133: astore 6
    //   135: aload 6
    //   137: ifnonnull +42 -> 179
    //   140: aload 5
    //   142: astore 4
    //   144: aload_0
    //   145: iconst_0
    //   146: putfield 325	com/tencent/mobileqq/activity/DoodleActivity:jdField_b_of_type_Boolean	Z
    //   149: aload 5
    //   151: ifnull -144 -> 7
    //   154: aload 5
    //   156: invokevirtual 368	java/io/FileOutputStream:close	()V
    //   159: return
    //   160: astore 4
    //   162: return
    //   163: aload 5
    //   165: astore 4
    //   167: aload_0
    //   168: getfield 209	com/tencent/mobileqq/activity/DoodleActivity:jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView	Lcom/tencent/mobileqq/widget/DoodlePicView;
    //   171: invokevirtual 369	com/tencent/mobileqq/widget/DoodlePicView:a	()Landroid/graphics/Bitmap;
    //   174: astore 6
    //   176: goto -41 -> 135
    //   179: aload 5
    //   181: astore 4
    //   183: aload 6
    //   185: getstatic 375	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   188: bipush 80
    //   190: aload 5
    //   192: invokevirtual 381	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   195: pop
    //   196: aload 5
    //   198: ifnull +8 -> 206
    //   201: aload 5
    //   203: invokevirtual 368	java/io/FileOutputStream:close	()V
    //   206: new 187	java/io/File
    //   209: dup
    //   210: aload 7
    //   212: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   215: astore 5
    //   217: aload_0
    //   218: getfield 105	com/tencent/mobileqq/activity/DoodleActivity:jdField_f_of_type_Int	I
    //   221: iconst_1
    //   222: if_icmpne +275 -> 497
    //   225: aload 5
    //   227: invokevirtual 384	java/io/File:length	()J
    //   230: ldc2_w 385
    //   233: lcmp
    //   234: ifle +263 -> 497
    //   237: new 327	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   244: getstatic 333	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   247: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 339
    //   253: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokestatic 345	java/lang/System:currentTimeMillis	()J
    //   259: invokestatic 351	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   262: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 353
    //   268: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: astore 4
    //   276: aload_0
    //   277: aload 7
    //   279: aload 4
    //   281: sipush 800
    //   284: sipush 600
    //   287: invokestatic 389	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   290: new 187	java/io/File
    //   293: dup
    //   294: aload 4
    //   296: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   299: astore 5
    //   301: aload 4
    //   303: invokestatic 395	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   306: astore 6
    //   308: aload 5
    //   310: invokevirtual 384	java/io/File:length	()J
    //   313: lstore_2
    //   314: aload_0
    //   315: getfield 99	com/tencent/mobileqq/activity/DoodleActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   318: invokevirtual 398	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   321: invokevirtual 401	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   324: invokevirtual 405	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   327: getfield 410	android/util/DisplayMetrics:density	F
    //   330: fstore_1
    //   331: aload_0
    //   332: aload 4
    //   334: aload_0
    //   335: aload 6
    //   337: invokestatic 412	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   340: ldc_w 413
    //   343: fload_1
    //   344: fmul
    //   345: f2i
    //   346: fload_1
    //   347: ldc_w 413
    //   350: fmul
    //   351: f2i
    //   352: invokestatic 389	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   355: new 155	android/content/Intent
    //   358: dup
    //   359: invokespecial 196	android/content/Intent:<init>	()V
    //   362: astore 5
    //   364: aload 5
    //   366: ldc_w 415
    //   369: iconst_1
    //   370: invokevirtual 419	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   373: pop
    //   374: aload 5
    //   376: ldc_w 421
    //   379: aload 4
    //   381: invokevirtual 424	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   384: pop
    //   385: aload 5
    //   387: ldc_w 426
    //   390: lload_2
    //   391: invokevirtual 429	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   394: pop
    //   395: aload 5
    //   397: ldc_w 431
    //   400: ldc 10
    //   402: invokevirtual 424	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   405: pop
    //   406: aload_0
    //   407: iconst_m1
    //   408: aload 5
    //   410: invokevirtual 434	com/tencent/mobileqq/activity/DoodleActivity:setResult	(ILandroid/content/Intent;)V
    //   413: aload_0
    //   414: invokevirtual 437	com/tencent/mobileqq/activity/DoodleActivity:finish	()V
    //   417: return
    //   418: astore 4
    //   420: aconst_null
    //   421: astore 5
    //   423: aload 5
    //   425: astore 4
    //   427: aload_0
    //   428: iconst_0
    //   429: putfield 325	com/tencent/mobileqq/activity/DoodleActivity:jdField_b_of_type_Boolean	Z
    //   432: aload 5
    //   434: ifnull -427 -> 7
    //   437: aload 5
    //   439: invokevirtual 368	java/io/FileOutputStream:close	()V
    //   442: return
    //   443: astore 4
    //   445: return
    //   446: astore 6
    //   448: aload 4
    //   450: astore 5
    //   452: aload 6
    //   454: astore 4
    //   456: aload 5
    //   458: ifnull +8 -> 466
    //   461: aload 5
    //   463: invokevirtual 368	java/io/FileOutputStream:close	()V
    //   466: aload 4
    //   468: athrow
    //   469: astore 4
    //   471: goto -265 -> 206
    //   474: astore 5
    //   476: goto -10 -> 466
    //   479: astore 6
    //   481: aload 4
    //   483: astore 5
    //   485: aload 6
    //   487: astore 4
    //   489: goto -33 -> 456
    //   492: astore 4
    //   494: goto -71 -> 423
    //   497: aload 7
    //   499: astore 4
    //   501: goto -200 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	DoodleActivity
    //   330	17	1	f1	float
    //   313	78	2	l	long
    //   81	62	4	localObject1	java.lang.Object
    //   160	1	4	localException1	java.lang.Exception
    //   165	215	4	localObject2	java.lang.Object
    //   418	1	4	localException2	java.lang.Exception
    //   425	1	4	localObject3	java.lang.Object
    //   443	6	4	localException3	java.lang.Exception
    //   454	13	4	localObject4	java.lang.Object
    //   469	13	4	localException4	java.lang.Exception
    //   487	1	4	localObject5	java.lang.Object
    //   492	1	4	localException5	java.lang.Exception
    //   499	1	4	str1	String
    //   109	353	5	localObject6	java.lang.Object
    //   474	1	5	localException6	java.lang.Exception
    //   483	1	5	localException7	java.lang.Exception
    //   133	203	6	localObject7	java.lang.Object
    //   446	7	6	localObject8	java.lang.Object
    //   479	7	6	localObject9	java.lang.Object
    //   50	448	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   154	159	160	java/lang/Exception
    //   100	111	418	java/lang/Exception
    //   437	442	443	java/lang/Exception
    //   100	111	446	finally
    //   201	206	469	java/lang/Exception
    //   461	466	474	java/lang/Exception
    //   115	122	479	finally
    //   126	135	479	finally
    //   144	149	479	finally
    //   167	176	479	finally
    //   183	196	479	finally
    //   427	432	479	finally
    //   115	122	492	java/lang/Exception
    //   126	135	492	java/lang/Exception
    //   144	149	492	java/lang/Exception
    //   167	176	492	java/lang/Exception
    //   183	196	492	java/lang/Exception
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Boolean);
    a(paramInt1, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903179);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("doodletype", true);
    this.jdField_f_of_type_Int = getIntent().getIntExtra("friendtype", -1);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("frienduin");
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("groupUin");
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("photofilepath");
    this.jdField_c_of_type_JavaLangString = this.app.a();
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297016));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297019));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297018));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297021));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView = ((DoodleTextView)findViewById(2131297023));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView = ((DoodlePicView)findViewById(2131297024));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297034));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297026));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297045));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297050));
    this.g = ((ImageView)findViewById(2131297048));
    this.h = ((ImageView)findViewById(2131297025));
    this.i = ((ImageView)findViewById(2131297047));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296945));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297036));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297027));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297035));
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
    for (;;)
    {
      int j = 0;
      while (j < 6)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(this.jdField_a_of_type_ArrayOfInt[j]));
        this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[j] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(this.jdField_b_of_type_ArrayOfInt[j]));
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[j].setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        j += 1;
      }
      b();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodleTextView.setPaintColor(this.jdField_d_of_type_ArrayOfInt[0]);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.setPaintColor(this.jdField_d_of_type_ArrayOfInt[0]);
    this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setBackgroundResource(2130839168);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.setPaintThickness(this.jdField_c_of_type_ArrayOfInt[2]);
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setBackgroundResource(2130839170);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new ajw(this));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(new akg(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.setPhotoFile(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.invalidate();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("key_photo_uri");
      if (paramBundle != null) {
        this.jdField_a_of_type_AndroidNetUri = ((Uri)paramBundle);
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getExtras().getString("PhotoConst.SINGLE_PHOTO_PATH");
    if ((!this.jdField_a_of_type_Boolean) && (paramIntent != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDoodlePicView.b();
      a(2, paramIntent);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    setRequestedOrientation(1);
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (this.jdField_a_of_type_AndroidNetUri != null) {
      paramBundle.putParcelable("key_photo_uri", this.jdField_a_of_type_AndroidNetUri);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DoodleActivity
 * JD-Core Version:    0.7.0.1
 */