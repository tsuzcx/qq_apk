package com.tencent.mobileqq.activity.photo;

import accn;
import acfp;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import anot;
import aooy;
import aqep;
import aqfy;
import aqhu;
import arhz;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import zrv;
import zrx;
import zry;
import zrz;
import zsb;
import zti;

public class PhotoCropActivity
  extends BaseActivity
  implements View.OnClickListener
{
  int EP;
  PortraitImageview jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview;
  RegionView jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView;
  boolean aAs = false;
  zrv b;
  String baM;
  boolean bsU;
  boolean bsV;
  protected boolean bsW;
  String[] cZ;
  accn cardObserver = new zrz(this);
  int ceL;
  int ceM;
  int ceN;
  int ceO;
  protected int ceP;
  int compressQuality;
  final long dt = 10000L;
  Button eP;
  Button eQ;
  public String from;
  public Handler handler = new zrx(this);
  String leftTitle;
  Intent mIntent;
  TextView mTitle;
  String path;
  public arhz r;
  ViewGroup rootView;
  int targetHeight;
  int targetWidth;
  View yU;
  
  private void cH(int paramInt)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramInt, 0).show(getTitleBarHeight());
    }
  }
  
  @SuppressLint({"NewApi"})
  void b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.yU = findViewById(2131377546);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.yU.setFitsSystemWindows(true);
    }
    this.rootView = ((ViewGroup)findViewById(2131373211));
    this.eP = ((Button)findViewById(2131365568));
    this.eQ = ((Button)findViewById(2131363233));
    this.mTitle = ((TextView)findViewById(2131379769));
    this.eP.setOnClickListener(this);
    this.eQ.setOnClickListener(this);
    if (!TextUtils.isEmpty(this.leftTitle)) {
      this.eQ.setText(this.leftTitle);
    }
    if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.from))
    {
      this.eQ.setText("");
      this.mTitle.setText("调整QQ头像");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview = new PortraitImageview(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.addOnLayoutChangeListener(new zry(this));
  }
  
  public void bPq()
  {
    try
    {
      if (!isFinishing())
      {
        this.r = new arhz(this, getTitleBarHeight());
        this.r.setCancelable(false);
        this.r.setMessage(2131691470);
        this.r.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void bPr()
  {
    if ((this.r != null) && (this.r.isShowing())) {}
    try
    {
      this.r.dismiss();
      label24:
      this.r = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void crx()
  {
    if (this.aAs) {
      return;
    }
    this.aAs = true;
    new b(null).execute(new Void[0]);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559754);
    if (!vz())
    {
      finish();
      return false;
    }
    b(this.path, this.ceL, this.ceM, this.targetWidth, this.targetHeight, this.ceO);
    addObserver(this.cardObserver);
    new a(null).execute(new Void[0]);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.cardObserver);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.e("doOnNewIntent", 2, "get new intent");
    }
    setIntent(paramIntent);
    if (!vz())
    {
      finish();
      return;
    }
    b(this.path, this.ceL, this.ceM, this.targetWidth, this.targetHeight, this.ceO);
    new a(null).execute(new Void[0]);
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent;
    if ("FROM_PHOTO_LIST".equals(this.from))
    {
      localIntent = getIntent();
      localIntent.setClass(this, NewPhotoListActivity.class);
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      aqfy.anim(this, true, false);
      return true;
      if ("FROM_NEARBY_PROFILE".equals(this.from))
      {
        PhotoUtils.a(this, getIntent(), new ArrayList(), 0, false);
      }
      else if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.from))
      {
        anot.a(this.app, "dc00898", "", "", "0X8009B69", "0X8009B69", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("PhotoCropActivity", 2, "onBackEvent");
        }
        localIntent = getIntent();
        localIntent.putExtra("key_from_sdk_set_avatar_result", false);
        setResult(0, localIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.cZ != null)
      {
        if (this.b == null)
        {
          this.b = new zsb(this);
          this.b.C(this.cZ);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView != null) {
          this.b.Qq();
        }
      }
      for (;;)
      {
        aqfy.clearSelectItemInfo();
        aqfy.dN(this.mIntent);
        if (!"FROM_SDK_AVATAR_SET_IMAGE".equals(this.from)) {
          break;
        }
        anot.a(this.app, "dc00898", "", "", "0X8009B6A", "0X8009B6A", 0, 0, "", "", "", "");
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView != null) {
          crx();
        }
      }
      onBackEvent();
    }
  }
  
  protected boolean vz()
  {
    Intent localIntent = getIntent();
    this.mIntent = localIntent;
    this.from = localIntent.getStringExtra("FROM_WHERE");
    localIntent.removeExtra("FROM_WHERE");
    this.path = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    this.leftTitle = localIntent.getStringExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE");
    this.ceL = localIntent.getIntExtra("PhotoConst.CLIP_WIDTH", 400);
    this.ceM = localIntent.getIntExtra("PhotoConst.CLIP_HEIGHT", 400);
    this.bsU = localIntent.getBooleanExtra("PhotoConst.32_Bit_Config", false);
    this.targetWidth = localIntent.getIntExtra("PhotoConst.TARGET_WIDTH", 400);
    this.targetHeight = localIntent.getIntExtra("PhotoConst.TARGET_HEIGHT", 400);
    this.ceN = localIntent.getIntExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1280);
    this.bsV = localIntent.getBooleanExtra("PhotoConst.ORIGIN_WITH_CLIPINFO", false);
    this.baM = localIntent.getStringExtra("PhotoConst.TARGET_PATH");
    this.EP = localIntent.getIntExtra("BUSINESS_ORIGIN_NEW", 0);
    if (this.baM == null)
    {
      QQToast.a(this, 2131696882, 0).show();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhotoCropActivity", 2, String.format("initData path=%s target=%s", new Object[] { this.path, this.baM }));
    }
    this.ceO = 1;
    this.compressQuality = localIntent.getIntExtra("PhotoConst.COMPRESS_QUALITY", 100);
    this.cZ = localIntent.getStringArrayExtra("PhotoConst.QZONE_COVER_SOURCE");
    if (QLog.isColorLevel()) {
      QLog.d("PhotoCropActivity", 2, "initData from=" + this.from + " targetSampleSize=" + this.ceN + " keepClipInfo=" + this.bsV);
    }
    if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.from)) {
      anot.a(this.app, "dc00898", "", "", "0X8009B68", "0X8009B68", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  class a
    extends AsyncTask<Void, Void, Bitmap>
  {
    private int errorCode;
    
    private a() {}
    
    protected Bitmap b(Void... paramVarArgs)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        if (PhotoCropActivity.this.bsU) {}
        for (paramVarArgs = Bitmap.Config.ARGB_8888;; paramVarArgs = Bitmap.Config.RGB_565)
        {
          localOptions.inPreferredConfig = paramVarArgs;
          localOptions.inJustDecodeBounds = true;
          aqhu.d(PhotoCropActivity.this.path, localOptions);
          localOptions.inSampleSize = zti.calculateInSampleSize(localOptions, PhotoCropActivity.this.ceN, PhotoCropActivity.this.ceN);
          localOptions.inJustDecodeBounds = false;
          paramVarArgs = aqhu.d(PhotoCropActivity.this.path, localOptions);
          return new aooy(PhotoCropActivity.this.path).Q(paramVarArgs);
        }
        return null;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        this.errorCode = 1;
        return null;
      }
      catch (Exception paramVarArgs)
      {
        this.errorCode = 2;
        QLog.d("PhotoCropActivity", 1, "LoadBitmapTask err " + paramVarArgs);
      }
    }
    
    protected void o(Bitmap paramBitmap)
    {
      if (paramBitmap != null)
      {
        PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setRestrict(PhotoCropActivity.this.ceL, PhotoCropActivity.this.ceM);
        PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setImageBitmap(paramBitmap);
        paramBitmap = new ViewGroup.LayoutParams(-1, -1);
        PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = new RegionView(PhotoCropActivity.this, PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, PhotoCropActivity.this.targetWidth, PhotoCropActivity.this.targetHeight, PhotoCropActivity.this.ceO, PhotoCropActivity.this.bsU);
        PhotoCropActivity.this.rootView.removeAllViews();
        PhotoCropActivity.this.rootView.addView(PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, paramBitmap);
        PhotoCropActivity.this.rootView.addView(PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView, paramBitmap);
        if (PhotoCropActivity.this.handler != null) {
          PhotoCropActivity.this.handler.sendEmptyMessageDelayed(1000, 250L);
        }
        return;
      }
      if (PhotoCropActivity.this.getIntent().getBooleanExtra("open_chat_from_avator", false))
      {
        PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setRestrict(PhotoCropActivity.this.ceL, PhotoCropActivity.this.ceM);
        paramBitmap = new ViewGroup.LayoutParams(-1, -1);
        PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = new RegionView(PhotoCropActivity.this, PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, PhotoCropActivity.this.targetWidth, PhotoCropActivity.this.targetHeight, PhotoCropActivity.this.ceO, PhotoCropActivity.this.bsU);
        PhotoCropActivity.this.rootView.removeAllViews();
        PhotoCropActivity.this.rootView.addView(PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, paramBitmap);
        PhotoCropActivity.this.rootView.addView(PhotoCropActivity.this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView, paramBitmap);
        PhotoCropActivity.this.eP.setEnabled(false);
        return;
      }
      if (this.errorCode == 1) {
        QQToast.a(PhotoCropActivity.this, acfp.m(2131709549), 0).show();
      }
      for (;;)
      {
        PhotoCropActivity.this.finish();
        return;
        if (this.errorCode == 2) {
          QQToast.a(PhotoCropActivity.this, acfp.m(2131709550), 0).show();
        } else {
          QQToast.a(PhotoCropActivity.this, acfp.m(2131709548), 0).show();
        }
      }
    }
  }
  
  class b
    extends AsyncTask<Void, Void, String>
  {
    private b() {}
    
    /* Error */
    private String e(Bitmap paramBitmap)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aload_1
      //   4: ifnonnull +8 -> 12
      //   7: aload 5
      //   9: astore_2
      //   10: aload_2
      //   11: areturn
      //   12: new 26	java/io/File
      //   15: dup
      //   16: aload_0
      //   17: getfield 13	com/tencent/mobileqq/activity/photo/PhotoCropActivity$b:b	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
      //   20: getfield 30	com/tencent/mobileqq/activity/photo/PhotoCropActivity:baM	Ljava/lang/String;
      //   23: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
      //   26: astore_2
      //   27: aload_2
      //   28: invokevirtual 37	java/io/File:exists	()Z
      //   31: ifne +14 -> 45
      //   34: aload_0
      //   35: getfield 13	com/tencent/mobileqq/activity/photo/PhotoCropActivity$b:b	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
      //   38: getfield 30	com/tencent/mobileqq/activity/photo/PhotoCropActivity:baM	Ljava/lang/String;
      //   41: invokestatic 43	aqhu:createNewFile	(Ljava/lang/String;)Ljava/io/File;
      //   44: pop
      //   45: new 45	java/io/BufferedOutputStream
      //   48: dup
      //   49: new 47	java/io/FileOutputStream
      //   52: dup
      //   53: aload_2
      //   54: invokespecial 50	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   57: invokespecial 53	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   60: astore_3
      //   61: aload_3
      //   62: astore_2
      //   63: aload_1
      //   64: getstatic 59	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   67: aload_0
      //   68: getfield 13	com/tencent/mobileqq/activity/photo/PhotoCropActivity$b:b	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
      //   71: getfield 63	com/tencent/mobileqq/activity/photo/PhotoCropActivity:compressQuality	I
      //   74: aload_3
      //   75: invokevirtual 69	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   78: pop
      //   79: aload_3
      //   80: astore_2
      //   81: aload_0
      //   82: getfield 13	com/tencent/mobileqq/activity/photo/PhotoCropActivity$b:b	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
      //   85: getfield 30	com/tencent/mobileqq/activity/photo/PhotoCropActivity:baM	Ljava/lang/String;
      //   88: astore_1
      //   89: aload_1
      //   90: astore_2
      //   91: aload_3
      //   92: ifnull -82 -> 10
      //   95: aload_3
      //   96: invokevirtual 72	java/io/BufferedOutputStream:close	()V
      //   99: aload_1
      //   100: areturn
      //   101: astore_3
      //   102: aload_1
      //   103: astore_2
      //   104: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   107: ifeq -97 -> 10
      //   110: ldc 79
      //   112: iconst_2
      //   113: ldc 81
      //   115: aload_3
      //   116: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   119: aload_1
      //   120: areturn
      //   121: astore 4
      //   123: aconst_null
      //   124: astore_1
      //   125: aload_1
      //   126: astore_2
      //   127: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   130: ifeq +15 -> 145
      //   133: aload_1
      //   134: astore_2
      //   135: ldc 79
      //   137: iconst_2
      //   138: ldc 81
      //   140: aload 4
      //   142: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   145: aload 5
      //   147: astore_2
      //   148: aload_1
      //   149: ifnull -139 -> 10
      //   152: aload_1
      //   153: invokevirtual 72	java/io/BufferedOutputStream:close	()V
      //   156: aconst_null
      //   157: areturn
      //   158: astore_1
      //   159: aload 5
      //   161: astore_2
      //   162: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   165: ifeq -155 -> 10
      //   168: ldc 79
      //   170: iconst_2
      //   171: ldc 81
      //   173: aload_1
      //   174: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   177: aconst_null
      //   178: areturn
      //   179: astore_1
      //   180: aconst_null
      //   181: astore_2
      //   182: aload_2
      //   183: ifnull +7 -> 190
      //   186: aload_2
      //   187: invokevirtual 72	java/io/BufferedOutputStream:close	()V
      //   190: aload_1
      //   191: athrow
      //   192: astore_2
      //   193: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   196: ifeq -6 -> 190
      //   199: ldc 79
      //   201: iconst_2
      //   202: ldc 81
      //   204: aload_2
      //   205: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   208: goto -18 -> 190
      //   211: astore_1
      //   212: goto -30 -> 182
      //   215: astore 4
      //   217: aload_3
      //   218: astore_1
      //   219: goto -94 -> 125
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	222	0	this	b
      //   0	222	1	paramBitmap	Bitmap
      //   9	178	2	localObject1	Object
      //   192	13	2	localIOException1	java.io.IOException
      //   60	36	3	localBufferedOutputStream	java.io.BufferedOutputStream
      //   101	117	3	localIOException2	java.io.IOException
      //   121	20	4	localIOException3	java.io.IOException
      //   215	1	4	localIOException4	java.io.IOException
      //   1	159	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   95	99	101	java/io/IOException
      //   27	45	121	java/io/IOException
      //   45	61	121	java/io/IOException
      //   152	156	158	java/io/IOException
      //   27	45	179	finally
      //   45	61	179	finally
      //   186	190	192	java/io/IOException
      //   63	79	211	finally
      //   81	89	211	finally
      //   127	133	211	finally
      //   135	145	211	finally
      //   63	79	215	java/io/IOException
      //   81	89	215	java/io/IOException
    }
    
    protected String doInBackground(Void... paramVarArgs)
    {
      if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
        paramVarArgs = "sdcardfull";
      }
      for (;;)
      {
        return paramVarArgs;
        try
        {
          if (PhotoCropActivity.this.bsV) {}
          for (paramVarArgs = PhotoCropActivity.this.a.ao();; paramVarArgs = PhotoCropActivity.this.a.getBitmap())
          {
            String str = e(paramVarArgs);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoCropActivity", 2, String.format("store to %s", new Object[] { str }));
            }
            paramVarArgs = str;
            if (!PhotoCropActivity.this.bsV) {
              break;
            }
            paramVarArgs = PhotoCropActivity.this.a.s();
            paramVarArgs = zti.a(paramVarArgs.left, paramVarArgs.top, paramVarArgs.right, paramVarArgs.bottom);
            PhotoCropActivity.this.getIntent().putExtra("key_clip_info", paramVarArgs);
            return str;
          }
          return "oom";
        }
        catch (OutOfMemoryError paramVarArgs)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PhotoCropActivity", 2, paramVarArgs.getMessage());
          }
        }
      }
    }
    
    protected void onPostExecute(String paramString)
    {
      if (("oom".equals(paramString)) || (paramString == null))
      {
        QQToast.a(PhotoCropActivity.this, 2131696880, 0).show();
        return;
      }
      if ("sdcardfull".equals(paramString))
      {
        QQToast.a(PhotoCropActivity.this, 2131696881, 0).show();
        return;
      }
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      if ("FROM_SDK_AVATAR_SET_IMAGE".equals(PhotoCropActivity.this.from))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoCropActivity", 2, "StoreFileTask");
        }
        localObject = PhotoCropActivity.this.getIntent();
        if (aqep.a(PhotoCropActivity.this.app, paramString, (Intent)localObject))
        {
          PhotoCropActivity.this.handler.sendMessage(Message.obtain(PhotoCropActivity.this.handler, 1002));
          return;
        }
        ((Intent)localObject).putExtra("key_from_sdk_set_avatar_result", false);
        PhotoCropActivity.this.setResult(-1, (Intent)localObject);
        PhotoCropActivity.this.finish();
        return;
      }
      if (100 == PhotoCropActivity.this.EP)
      {
        PhotoCropActivity.this.getIntent().putExtra("PhotoConst.SYNCQZONE", PhotoCropActivity.this.bsW);
        PhotoCropActivity.this.getIntent().putExtra("PhotoConst.SYNCQZONE_CHECKSTATE", PhotoCropActivity.this.ceP);
      }
      PhotoUtils.a(PhotoCropActivity.this, PhotoCropActivity.this.getIntent(), (ArrayList)localObject, 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity
 * JD-Core Version:    0.7.0.1
 */