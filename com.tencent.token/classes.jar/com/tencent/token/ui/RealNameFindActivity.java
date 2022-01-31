package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.global.e;
import com.tencent.token.p;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RealNameFindActivity
  extends BaseActivity
{
  private Handler _handler;
  private byte[] backphotoinfo;
  private boolean canchange_uin;
  private byte[] frontphotoinfo;
  private boolean isShowLockVerify = false;
  private boolean ish5zzb;
  private boolean mAutoIDCardDetect = true;
  private byte[] mBackData;
  private String mBackPath;
  private byte[] mFaceData;
  private byte[] mFrontData;
  private String mFrontPath;
  private Handler mHandler = new ux(this);
  private HandlerThread mHandlerThread;
  private boolean mIsActiveSuccess = false;
  private Button mNext;
  private int mOpType = 2;
  private long mRealUin;
  private View mScanFaceLayout;
  private ImageView mScanFaceOk;
  private View mScanIdLayout;
  private ImageView mScanIdOk;
  private int mSourceId;
  private RealNameQueryResult result;
  
  private static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int i = 1;
    if ((k > paramInt2) || (j > paramInt1))
    {
      paramInt2 = Math.round(k / paramInt2);
      i = Math.round(j / paramInt1);
      if (paramInt2 >= i) {}
    }
    else
    {
      return i;
    }
    return paramInt2;
  }
  
  private boolean checkCanCommit()
  {
    if ((this.mScanFaceOk.getVisibility() == 0) && (this.mScanIdOk.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.mNext.setTextAppearance(this, 2131427381);
        this.mNext.setBackgroundResource(2130837549);
        this.mNext.setEnabled(true);
        return true;
      }
      this.mNext.setTextAppearance(this, 2131427335);
      this.mNext.setBackgroundResource(2130837636);
      this.mNext.setEnabled(false);
      return false;
    }
  }
  
  /* Error */
  private byte[] compressPicData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 141	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 186	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 189	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_1
    //   14: iconst_0
    //   15: aload_1
    //   16: arraylength
    //   17: aload_2
    //   18: invokestatic 195	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: pop
    //   22: aload_2
    //   23: aload_2
    //   24: sipush 640
    //   27: sipush 640
    //   30: invokestatic 197	com/tencent/token/ui/RealNameFindActivity:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   33: putfield 200	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   36: aload_2
    //   37: iconst_0
    //   38: putfield 189	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   41: aload_1
    //   42: iconst_0
    //   43: aload_1
    //   44: arraylength
    //   45: aload_2
    //   46: invokestatic 195	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: astore_2
    //   50: new 202	java/io/ByteArrayOutputStream
    //   53: dup
    //   54: invokespecial 203	java/io/ByteArrayOutputStream:<init>	()V
    //   57: astore_1
    //   58: aload_2
    //   59: getstatic 209	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   62: bipush 85
    //   64: aload_1
    //   65: invokevirtual 215	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   68: pop
    //   69: aload_1
    //   70: invokevirtual 218	java/io/ByteArrayOutputStream:close	()V
    //   73: aload_1
    //   74: invokevirtual 222	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   77: areturn
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 225	java/io/IOException:printStackTrace	()V
    //   83: goto -10 -> 73
    //   86: astore_2
    //   87: aload_1
    //   88: invokevirtual 218	java/io/ByteArrayOutputStream:close	()V
    //   91: aload_2
    //   92: athrow
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 225	java/io/IOException:printStackTrace	()V
    //   98: goto -7 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	RealNameFindActivity
    //   0	101	1	paramArrayOfByte	byte[]
    //   7	52	2	localObject1	java.lang.Object
    //   78	2	2	localIOException	java.io.IOException
    //   86	6	2	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   69	73	78	java/io/IOException
    //   58	69	86	finally
    //   87	91	93	java/io/IOException
  }
  
  private void initView()
  {
    if (this.ish5zzb)
    {
      setTitle(2131362799);
      ((TextView)findViewById(2131296962)).setText(2131362800);
    }
    this.mNext = ((Button)findViewById(2131296932));
    this.mScanFaceOk = ((ImageView)findViewById(2131296939));
    this.mScanIdOk = ((ImageView)findViewById(2131296942));
    this.mScanFaceLayout = findViewById(2131296937);
    this.mScanIdLayout = findViewById(2131296940);
    this.mScanFaceLayout.setOnClickListener(new vg(this));
    this.mScanIdLayout.setOnClickListener(new vh(this));
    this.mNext.setOnClickListener(new vi(this));
  }
  
  private boolean isVaildID(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("([0-9]{17}([0-9]|X|x))|([0-9]{15})").matcher(paramString).matches();
  }
  
  private void uploadData()
  {
    showProDialogWithoutShutDown(this, getResources().getString(2131361817));
    if (this.mHandlerThread == null)
    {
      this.mHandlerThread = new HandlerThread("uploadphoto", 1);
      this.mHandlerThread.start();
    }
    if (this._handler == null) {
      this._handler = new Handler(this.mHandlerThread.getLooper());
    }
    this._handler.post(new vj(this));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.mIsActiveSuccess) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if ((paramInt2 == 0) && (paramIntent != null) && (paramIntent.getByteArrayExtra("facedata") != null) && (paramIntent.getByteArrayExtra("facedata").length > 0))
      {
        this.mFaceData = paramIntent.getByteArrayExtra("facedata");
        e.a("realname facedata len=" + this.mFaceData.length);
        this.mScanFaceOk.setVisibility(0);
        p.a().a(System.currentTimeMillis(), 89);
      }
    }
    do
    {
      checkCanCommit();
      do
      {
        return;
      } while (paramInt1 != 2);
      if (paramInt2 == 1)
      {
        Intent localIntent = new Intent(this, RealNameTakeIDPhotoActivity.class);
        if ((paramIntent.getStringExtra("frontdata") != null) && (paramIntent.getStringExtra("frontdata").length() > 0))
        {
          this.mFrontPath = paramIntent.getStringExtra("frontdata");
          this.frontphotoinfo = paramIntent.getByteArrayExtra("frontphotoinfo");
          localIntent.putExtra("frontdata", this.mFrontPath);
        }
        localIntent.putExtra("scene", 2);
        startActivityForResult(localIntent, 2);
        return;
      }
    } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getStringExtra("frontdata") == null) || (paramIntent.getStringExtra("frontdata").length() <= 0) || (paramIntent.getStringExtra("backdata") == null) || (paramIntent.getStringExtra("backdata").length() <= 0));
    this.mFrontPath = paramIntent.getStringExtra("frontdata");
    this.mBackPath = paramIntent.getStringExtra("backdata");
    this.frontphotoinfo = paramIntent.getByteArrayExtra("frontphotoinfo");
    this.backphotoinfo = paramIntent.getByteArrayExtra("backphotoinfo");
    e.a("realname id frontlen=" + this.mFrontPath.length() + ", backlen=" + this.mBackPath.length());
    this.mScanIdOk.setVisibility(0);
    p.a().a(System.currentTimeMillis(), 90);
    checkCanCommit();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.isShowLockVerify = getIntent().getBooleanExtra("not_showLockVerify", false);
    this.canchange_uin = getIntent().getBooleanExtra("canchange_uin", false);
    if (this.isShowLockVerify) {
      setNeverShowLockVerifyView();
    }
    setContentView(2130903165);
    this.mSourceId = getIntent().getIntExtra("source_id", 0);
    this.ish5zzb = getIntent().getBooleanExtra("ish5zzb", false);
    this.result = ((RealNameQueryResult)getIntent().getSerializableExtra("result"));
    this.mRealUin = getIntent().getLongExtra("real_uin", 0L);
    this.mIsActiveSuccess = false;
    initView();
    af.a().n(-1L, this.mHandler);
  }
  
  protected void onResume()
  {
    super.onResume();
    Intent localIntent = getIntent();
    if (localIntent == null) {}
    while (!localIntent.getBooleanExtra("reupload", false)) {
      return;
    }
    this.result = ((RealNameQueryResult)localIntent.getSerializableExtra("result"));
    this.mRealUin = localIntent.getLongExtra("real_uin", 0L);
    this.mSourceId = localIntent.getIntExtra("source_id", 0);
    this.mFrontPath = localIntent.getStringExtra("mFrontPath");
    this.mBackPath = localIntent.getStringExtra("mBackPath");
    this.frontphotoinfo = localIntent.getByteArrayExtra("frontphotoinfo");
    this.backphotoinfo = localIntent.getByteArrayExtra("backphotoinfo");
    this.mFaceData = localIntent.getByteArrayExtra("mFaceData");
    this.canchange_uin = localIntent.getBooleanExtra("canchange_uin", false);
    if (this.mFaceData != null) {
      this.mScanFaceOk.setVisibility(0);
    }
    if ((this.mFrontPath != null) && (this.mFrontPath.length() > 0) && (this.mBackPath != null) && (this.mBackPath.length() > 0)) {
      this.mScanIdOk.setVisibility(0);
    }
    checkCanCommit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameFindActivity
 * JD-Core Version:    0.7.0.1
 */