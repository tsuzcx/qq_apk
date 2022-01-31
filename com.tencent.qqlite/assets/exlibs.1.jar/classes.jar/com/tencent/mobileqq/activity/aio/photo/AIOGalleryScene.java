package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import byv;
import byw;
import byx;
import byy;
import byz;
import bza;
import bzc;
import bzd;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.galleryactivity.AbstractGalleryPageView;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.GalleryPageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PicReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIOGalleryScene
  extends AbstractGalleryScene
{
  static final int jdField_a_of_type_Int = 0;
  public static final String a = "AIOGalleryScene";
  static final int jdField_d_of_type_Int = 250;
  static final int jdField_e_of_type_Int = 1024;
  View jdField_a_of_type_AndroidViewView;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bzd a;
  public AIOGalleryAdapter a;
  public AIOImageListModel a;
  public IAIOImageProvider a;
  boolean jdField_a_of_type_Boolean = false;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public String c;
  boolean c;
  public String d;
  boolean jdField_d_of_type_Boolean;
  boolean jdField_e_of_type_Boolean;
  private final int f = -3321;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  private final int h = -2147483648;
  private int i;
  
  public AIOGalleryScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_b_of_type_JavaLangString = paramString;
    if ((paramString == null) && (PeakActivity.class.isInstance(paramActivity))) {
      this.jdField_b_of_type_JavaLangString = ((PeakActivity)paramActivity).a.a();
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
    paramBundle = new Bundle(paramBundle);
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    paramBundle = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, localArrayList, 0, false);
  }
  
  private void r()
  {
    AIOImageInfo localAIOImageInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    File localFile = localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4);
    if (localFile == null) {
      localFile = localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2);
    }
    for (;;)
    {
      if ((localFile == null) && (this.jdField_c_of_type_Boolean)) {
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null, 2131624120);
      if (localFile != null) {
        this.jdField_d_of_type_JavaLangString = localFile.getPath();
      }
      if (localFile != null)
      {
        if (this.jdField_g_of_type_Boolean) {
          break label160;
        }
        localActionSheet.c(2131363941);
        localActionSheet.c(2131363945);
        ThreadManager.a().post(new bza(this, localFile, localActionSheet));
        localActionSheet.c(2131363944);
      }
      for (;;)
      {
        if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_g_of_type_Boolean)) {
          localActionSheet.c(2131363946);
        }
        localActionSheet.d(2131362801);
        localActionSheet.a(new bzc(this, localActionSheet, localAIOImageInfo, localFile));
        localActionSheet.show();
        return;
        label160:
        localActionSheet.c(2131363945);
      }
    }
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903521, null);
  }
  
  protected AbstractGalleryPageView a(Context paramContext)
  {
    paramContext = new GalleryPageView();
    paramContext.jdField_a_of_type_Int = 25;
    return paramContext;
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
  }
  
  /* Error */
  public java.lang.Boolean a(File paramFile)
  {
    // Byte code:
    //   0: iconst_2
    //   1: iconst_0
    //   2: ldc_w 271
    //   5: ldc_w 273
    //   8: invokestatic 279	com/tencent/qbar/QbarNative:Init	(IILjava/lang/String;Ljava/lang/String;)I
    //   11: pop
    //   12: iconst_2
    //   13: newarray int
    //   15: astore 5
    //   17: aload 5
    //   19: iconst_0
    //   20: iconst_2
    //   21: iastore
    //   22: aload 5
    //   24: iconst_1
    //   25: iconst_0
    //   26: iastore
    //   27: aload 5
    //   29: aload 5
    //   31: arraylength
    //   32: invokestatic 283	com/tencent/qbar/QbarNative:SetReaders	([II)I
    //   35: pop
    //   36: new 285	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 288
    //   46: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 295	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 304	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   62: astore 6
    //   64: iconst_m1
    //   65: istore_3
    //   66: aload_0
    //   67: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryScene:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   70: invokevirtual 310	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   73: astore_1
    //   74: new 312	android/graphics/BitmapFactory$Options
    //   77: dup
    //   78: invokespecial 313	android/graphics/BitmapFactory$Options:<init>	()V
    //   81: astore 7
    //   83: aload 7
    //   85: iconst_1
    //   86: putfield 316	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   89: aload_1
    //   90: aload 6
    //   92: invokevirtual 322	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   95: astore 5
    //   97: aload 5
    //   99: aconst_null
    //   100: aload 7
    //   102: invokestatic 328	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   105: pop
    //   106: aload 5
    //   108: invokevirtual 333	java/io/InputStream:close	()V
    //   111: aload 7
    //   113: getfield 336	android/graphics/BitmapFactory$Options:outWidth	I
    //   116: istore_2
    //   117: aload 7
    //   119: getfield 339	android/graphics/BitmapFactory$Options:outHeight	I
    //   122: istore 4
    //   124: aload 7
    //   126: iconst_0
    //   127: putfield 316	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   130: iload_2
    //   131: iload 4
    //   133: imul
    //   134: ldc_w 340
    //   137: if_icmple +158 -> 295
    //   140: aload 7
    //   142: iload_2
    //   143: iload 4
    //   145: imul
    //   146: i2d
    //   147: invokestatic 346	java/lang/Math:sqrt	(D)D
    //   150: ldc2_w 347
    //   153: ddiv
    //   154: invokestatic 351	java/lang/Math:ceil	(D)D
    //   157: d2i
    //   158: putfield 354	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   161: aload_1
    //   162: aload 6
    //   164: invokevirtual 322	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   167: astore_1
    //   168: aload_1
    //   169: aconst_null
    //   170: aload 7
    //   172: invokestatic 328	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   175: astore 7
    //   177: aload_1
    //   178: invokevirtual 333	java/io/InputStream:close	()V
    //   181: aload 7
    //   183: invokevirtual 360	android/graphics/Bitmap:getWidth	()I
    //   186: istore_2
    //   187: aload 7
    //   189: invokevirtual 363	android/graphics/Bitmap:getHeight	()I
    //   192: istore 4
    //   194: iload_2
    //   195: iload 4
    //   197: imul
    //   198: newarray int
    //   200: astore 5
    //   202: aload 7
    //   204: aload 5
    //   206: iconst_0
    //   207: iload_2
    //   208: iconst_0
    //   209: iconst_0
    //   210: iload_2
    //   211: iload 4
    //   213: invokevirtual 367	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   216: aload 7
    //   218: invokevirtual 370	android/graphics/Bitmap:recycle	()V
    //   221: iload_2
    //   222: iload 4
    //   224: imul
    //   225: newarray byte
    //   227: astore 7
    //   229: aload 5
    //   231: aload 7
    //   233: iload_2
    //   234: iload 4
    //   236: invokestatic 375	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   239: pop
    //   240: aload 7
    //   242: iload_2
    //   243: iload 4
    //   245: iconst_0
    //   246: invokestatic 379	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   249: istore_2
    //   250: invokestatic 382	com/tencent/qbar/QbarNative:Release	()I
    //   253: pop
    //   254: iload_2
    //   255: iconst_1
    //   256: if_icmpne +133 -> 389
    //   259: aload_0
    //   260: aload 6
    //   262: invokevirtual 383	android/net/Uri:getPath	()Ljava/lang/String;
    //   265: putfield 385	com/tencent/mobileqq/activity/aio/photo/AIOGalleryScene:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   268: iconst_1
    //   269: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   272: areturn
    //   273: astore_1
    //   274: invokestatic 397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +13 -> 290
    //   280: ldc 10
    //   282: iconst_2
    //   283: aload_1
    //   284: invokevirtual 398	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   287: invokestatic 402	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: iconst_0
    //   291: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   294: areturn
    //   295: aload 7
    //   297: iconst_1
    //   298: putfield 354	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   301: goto -140 -> 161
    //   304: astore_1
    //   305: iload_3
    //   306: istore_2
    //   307: invokestatic 397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq -60 -> 250
    //   313: ldc 10
    //   315: iconst_2
    //   316: aload_1
    //   317: invokevirtual 403	java/io/IOException:toString	()Ljava/lang/String;
    //   320: invokestatic 402	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: iload_3
    //   324: istore_2
    //   325: goto -75 -> 250
    //   328: astore_1
    //   329: aload 5
    //   331: astore_1
    //   332: aload_1
    //   333: invokevirtual 333	java/io/InputStream:close	()V
    //   336: iconst_m1
    //   337: istore_2
    //   338: goto -88 -> 250
    //   341: astore_1
    //   342: iload_3
    //   343: istore_2
    //   344: invokestatic 397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -97 -> 250
    //   350: ldc 10
    //   352: iconst_2
    //   353: aload_1
    //   354: invokevirtual 404	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   357: invokestatic 402	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: iload_3
    //   361: istore_2
    //   362: goto -112 -> 250
    //   365: astore_1
    //   366: iload_3
    //   367: istore_2
    //   368: invokestatic 397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq -121 -> 250
    //   374: ldc 10
    //   376: iconst_2
    //   377: aload_1
    //   378: invokevirtual 398	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   381: invokestatic 402	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: iload_3
    //   385: istore_2
    //   386: goto -136 -> 250
    //   389: iconst_0
    //   390: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   393: areturn
    //   394: astore 5
    //   396: goto -64 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	AIOGalleryScene
    //   0	399	1	paramFile	File
    //   116	270	2	j	int
    //   65	320	3	k	int
    //   122	122	4	m	int
    //   15	315	5	localObject1	Object
    //   394	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   62	199	6	localUri	android.net.Uri
    //   81	215	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	17	273	java/lang/UnsatisfiedLinkError
    //   27	36	273	java/lang/UnsatisfiedLinkError
    //   66	130	304	java/io/IOException
    //   140	161	304	java/io/IOException
    //   161	168	304	java/io/IOException
    //   168	250	304	java/io/IOException
    //   295	301	304	java/io/IOException
    //   332	336	304	java/io/IOException
    //   161	168	328	java/lang/OutOfMemoryError
    //   66	130	341	java/lang/RuntimeException
    //   140	161	341	java/lang/RuntimeException
    //   161	168	341	java/lang/RuntimeException
    //   168	250	341	java/lang/RuntimeException
    //   295	301	341	java/lang/RuntimeException
    //   332	336	341	java/lang/RuntimeException
    //   66	130	365	java/lang/UnsatisfiedLinkError
    //   140	161	365	java/lang/UnsatisfiedLinkError
    //   161	168	365	java/lang/UnsatisfiedLinkError
    //   168	250	365	java/lang/UnsatisfiedLinkError
    //   295	301	365	java/lang/UnsatisfiedLinkError
    //   332	336	365	java/lang/UnsatisfiedLinkError
    //   168	250	394	java/lang/OutOfMemoryError
  }
  
  public void a()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    AIOImageInfo localAIOImageInfo = new AIOImageInfo((AIOImageData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(localAIOImageInfo);
    localAIOImageInfo.jdField_b_of_type_AndroidGraphicsRect = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    this.jdField_c_of_type_Boolean = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.jdField_g_of_type_Int = localBundle.getInt("extra.AIO_CURRENT_PANEL_STATE", -3321);
    this.i = localBundle.getInt("extra.MOBILE_QQ_PROCESS_ID", -2147483648);
    this.jdField_g_of_type_Boolean = localBundle.getBoolean("extra.IS_FROM_MULTI_MSG");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 0)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt2 == 2)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      paramInt2 = 0;
      if (paramInt2 < ((List)localObject1).size())
      {
        localObject2 = (AIOImageInfo)((List)localObject1).get(paramInt2);
        if ((((AIOImageInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_a_of_type_Long != paramLong1) || (((AIOImageInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.d != paramInt1)) {
          break label91;
        }
        ((AIOImageInfo)localObject2).jdField_a_of_type_Int = paramInt3;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramInt3 / 100);
      }
    }
    label91:
    while ((paramInt2 != 4) || (this.jdField_a_of_type_Bzd == null) || (this.jdField_a_of_type_Bzd.jdField_a_of_type_Long != paramLong1) || (this.jdField_a_of_type_Bzd.jdField_a_of_type_Int != paramInt1) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      for (;;)
      {
        return;
        paramInt2 += 1;
      }
    }
    if ((this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
    if (paramLong2 > 0L)
    {
      localObject1 = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, (float)paramLong2);
      localObject2 = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, (float)(paramInt3 * paramLong2) / 10000.0F);
      localObject1 = (String)localObject2 + "/" + (String)localObject1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt3 / 100 + "%");
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (paramInt2 == 2)
    {
      localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
      if (paramInt3 == 1)
      {
        paramInt1 = localAIOImageListModel.a(paramLong, paramInt1, paramInt2, paramString);
        paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.q();
        paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
        {
          paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt1, paramString);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
        }
      }
    }
    while ((paramInt2 != 4) || (this.jdField_a_of_type_Bzd == null) || (this.jdField_a_of_type_Bzd.jdField_a_of_type_Long != paramLong) || (this.jdField_a_of_type_Bzd.jdField_a_of_type_Int != paramInt1)) {
      for (;;)
      {
        return;
        paramString = "I:E";
      }
    }
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 == 1)
    {
      localAIOImageListModel.a(paramLong, paramInt1, paramInt2, paramString);
      if (paramInt3 != 1) {
        break label318;
      }
      paramString = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4));
      switch (paramString.getStatus())
      {
      }
    }
    for (;;)
    {
      paramString.setTag(Integer.valueOf(1));
      paramString.setURLDrawableListener(this.jdField_a_of_type_Bzd);
      paramString.startDownload();
      this.jdField_a_of_type_Bzd.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
      return;
      paramString = "I:E";
      break;
      this.jdField_a_of_type_Bzd.onLoadSuccessed(paramString);
      return;
      this.jdField_a_of_type_Bzd.onLoadFialed(paramString, null);
      return;
      this.jdField_a_of_type_Bzd.onLoadCanceled(paramString);
    }
    label318:
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131364060), 0).a();
    c(true);
    a(false);
    this.jdField_a_of_type_Bzd = null;
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramConfiguration);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    int j = 1;
    if (paramView == null) {}
    do
    {
      return;
      paramView = (URLDrawable)((ImageView)paramView).getDrawable();
    } while (paramView.getStatus() != 1);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1).jdField_b_of_type_Int = j;
      paramView = new File(paramView.getURL().getFile());
      if (!paramView.exists()) {
        break;
      }
      new byz(this, paramView, paramInt2).execute(new Void[0]);
      return;
      j = 3;
      continue;
      j = 8;
      continue;
      j = 6;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    paramViewGroup = (RelativeLayout)a();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    localLayoutParams.leftMargin = ((int)TypedValue.applyDimension(1, 14.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    this.jdField_a_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130838765);
    this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131364053));
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageButton, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130837547);
    this.jdField_b_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    paramViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageButton, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(new byv(this));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903524, null);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131298023));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298360));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new byw(this));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new byx(this));
    if ((ProGallery.OnProGalleryListener.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter)) && (ProGallery.class.isInstance(this.jdField_a_of_type_ComTencentWidgetGallery))) {
      ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter);
    }
  }
  
  public void a(AIOImageInfo paramAIOImageInfo)
  {
    File localFile = paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4);
    if (localFile == null) {
      localFile = paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2);
    }
    for (int j = 0;; j = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(1));
      paramAIOImageInfo = paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
      if (j != 0) {}
      for (j = 4;; j = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", paramAIOImageInfo.a(j));
        localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
        paramAIOImageInfo = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
        paramAIOImageInfo.putExtras(localBundle);
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramAIOImageInfo, 0);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    c(false);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void a(AIOImageData[] paramArrayOfAIOImageData, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryScene", 2, "notifyImageListChanged list size " + paramArrayOfAIOImageData.length + ", selected " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramArrayOfAIOImageData, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() == 0)
    {
      PicReporter.b(false);
      Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, 2131363948, 0).show();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
      if (paramInt != this.jdField_a_of_type_ComTencentWidgetGallery.p()) {
        break;
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView.a(this.jdField_a_of_type_ComTencentWidgetGallery, paramInt);
      return;
      PicReporter.b(true);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(paramInt);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "3", "", "", "");
      r();
      return true;
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    try
    {
      r();
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
        }
      }
    }
  }
  
  public void b()
  {
    g();
    this.e = true;
    AIOImageInfo localAIOImageInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIOImageInfo != null) {
      localAIOImageInfo.jdField_a_of_type_Boolean = true;
    }
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    Looper.myQueue().addIdleHandler(new byy(this));
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.b(paramAdapterView, paramView, paramInt, paramLong);
    if (AIOGalleryAdapter.GalleryURLImageView.class.isInstance(paramView))
    {
      paramAdapterView = (AIOGalleryAdapter.GalleryURLImageView)paramView;
      paramView = paramAdapterView.getDrawable();
      if ((!paramAdapterView.jdField_b_of_type_Boolean) && (paramView != null) && ((paramView instanceof URLDrawable)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4)))
      {
        c(true);
        return;
      }
    }
    c(false);
  }
  
  public void c()
  {
    this.e = false;
    c(this.jdField_d_of_type_Boolean);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      if ((this.jdField_d_of_type_Boolean) && (this.e)) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
  }
  
  protected boolean c()
  {
    if ((this.jdField_g_of_type_Int == -3321) || (this.jdField_g_of_type_Int == 1)) {
      return false;
    }
    if (this.i == -2147483648) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity;
    localObject1 = ((ActivityManager)((Activity)localObject1).getSystemService("activity")).getRunningAppProcesses().iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
    } while (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.endsWith("mobileqq"));
    for (int j = ((ActivityManager.RunningAppProcessInfo)localObject2).pid;; j = -2147483648) {
      return j == this.i;
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
  }
  
  public void e() {}
  
  public void f()
  {
    super.f();
    if (this.jdField_c_of_type_Int > 0) {
      ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_spin", 0, 0, "" + this.jdField_c_of_type_Int, "", "", "");
    }
  }
  
  @TargetApi(11)
  public void g()
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b();
  }
  
  public void j()
  {
    super.j();
    AIOImageInfo localAIOImageInfo = ((AIOImageListModel)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel).b();
    if (localAIOImageInfo != null) {
      localAIOImageInfo.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void k()
  {
    super.k();
    AIOImageInfo localAIOImageInfo = ((AIOImageListModel)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel).b();
    if (localAIOImageInfo != null) {
      localAIOImageInfo.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Bzd != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(this.jdField_a_of_type_Bzd.jdField_a_of_type_Long, this.jdField_a_of_type_Bzd.jdField_a_of_type_Int, 4);
      this.jdField_a_of_type_Bzd = null;
    }
    c(false);
    a(false);
    super.m();
  }
  
  void p() {}
  
  public void q()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean) {
        n();
      }
    }
    else {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131363419, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene
 * JD-Core Version:    0.7.0.1
 */