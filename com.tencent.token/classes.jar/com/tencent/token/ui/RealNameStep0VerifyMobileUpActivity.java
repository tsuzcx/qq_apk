package com.tencent.token.ui;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.captchasdk.TCaptchaPopupActivity;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.dj;
import com.tencent.token.global.h;
import com.tencent.token.utils.i;
import org.json.JSONObject;

public class RealNameStep0VerifyMobileUpActivity
  extends BaseActivity
{
  private static final int VERIFYREQESTCODE = 1001;
  byte[] backphotoinfo;
  boolean canchange_uin;
  byte[] frontphotoinfo;
  private boolean isFromRecommView;
  private boolean ish5zzb;
  byte[] mBackData;
  String mBackPath;
  private Button mChangeBtn;
  byte[] mFaceData;
  byte[] mFrontData;
  String mFrontPath;
  private Handler mHandler = new wi(this);
  private boolean mIsActiveSuccess = false;
  private String mMobile;
  private Button mNextBtn;
  private RealNameQueryResult mQueryResult;
  private long mRealUin;
  private RealNameStatusResult mResult;
  private int mRetryTimes = 0;
  private int mSceneId;
  int mSourceId;
  Runnable mVrySMSRunnable = new wh(this);
  protected QueryCaptchaResult queryCaptchaResult;
  
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
  
  /* Error */
  private byte[] compressPicData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 104	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 119	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 122	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_1
    //   14: iconst_0
    //   15: aload_1
    //   16: arraylength
    //   17: aload_2
    //   18: invokestatic 128	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: pop
    //   22: aload_2
    //   23: aload_2
    //   24: sipush 640
    //   27: sipush 640
    //   30: invokestatic 130	com/tencent/token/ui/RealNameStep0VerifyMobileUpActivity:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   33: putfield 133	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   36: aload_2
    //   37: iconst_0
    //   38: putfield 122	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   41: aload_1
    //   42: iconst_0
    //   43: aload_1
    //   44: arraylength
    //   45: aload_2
    //   46: invokestatic 128	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: astore_2
    //   50: new 135	java/io/ByteArrayOutputStream
    //   53: dup
    //   54: invokespecial 136	java/io/ByteArrayOutputStream:<init>	()V
    //   57: astore_1
    //   58: aload_2
    //   59: getstatic 142	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   62: bipush 85
    //   64: aload_1
    //   65: invokevirtual 148	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   68: pop
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 151	java/io/ByteArrayOutputStream:close	()V
    //   77: aload_1
    //   78: invokevirtual 155	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   81: areturn
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   87: goto -10 -> 77
    //   90: astore_2
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 151	java/io/ByteArrayOutputStream:close	()V
    //   99: aload_2
    //   100: athrow
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   106: goto -7 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	RealNameStep0VerifyMobileUpActivity
    //   0	109	1	paramArrayOfByte	byte[]
    //   7	52	2	localObject1	java.lang.Object
    //   82	2	2	localIOException	java.io.IOException
    //   90	10	2	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   73	77	82	java/io/IOException
    //   58	69	90	finally
    //   95	99	101	java/io/IOException
  }
  
  private void initView()
  {
    ((TextView)findViewById(2131558728)).setText(this.mMobile);
    this.mNextBtn = ((Button)findViewById(2131558730));
    this.mNextBtn.setOnClickListener(new wn(this));
    this.mChangeBtn = ((Button)findViewById(2131558731));
    this.mChangeBtn.setOnClickListener(new wo(this));
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
        h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
    }
  }
  
  protected void gotoVerifyActivity(QueryCaptchaResult paramQueryCaptchaResult)
  {
    this.queryCaptchaResult = paramQueryCaptchaResult;
    Intent localIntent = new Intent(this, TCaptchaPopupActivity.class);
    if (paramQueryCaptchaResult != null) {
      localIntent.putExtra("appid", paramQueryCaptchaResult.mAppid);
    }
    startActivityForResult(localIntent, 1001);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001)
    {
      if (paramInt2 == -1) {
        try
        {
          paramIntent = new JSONObject(paramIntent.getStringExtra("retJson"));
          if (paramIntent.getInt("ret") == 0)
          {
            if (this.queryCaptchaResult == null) {
              return;
            }
            cw.a().d(this.queryCaptchaResult.mRealUin, this.queryCaptchaResult.mSceneId, paramIntent.getString("ticket"), paramIntent.getString("randstr"), this.mHandler);
            return;
          }
          Toast.makeText(this, "未验证成功", 0).show();
          return;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      } else {
        Toast.makeText(this, "未验证成功", 0).show();
      }
    }
    else {
      this.mHandler.sendEmptyMessage(3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130968723);
    paramBundle = getIntent();
    this.mResult = ((RealNameStatusResult)paramBundle.getSerializableExtra("realname_result"));
    this.mMobile = paramBundle.getStringExtra("realname_mobile");
    this.mSceneId = paramBundle.getIntExtra("scene_id", 1001);
    this.mRealUin = paramBundle.getLongExtra("real_uin", 0L);
    this.mFrontPath = paramBundle.getStringExtra("mFrontPath");
    this.mBackPath = paramBundle.getStringExtra("mBackPath");
    this.mFaceData = paramBundle.getByteArrayExtra("mFaceData");
    this.frontphotoinfo = paramBundle.getByteArrayExtra("frontphotoinfo");
    this.backphotoinfo = paramBundle.getByteArrayExtra("backphotoinfo");
    this.canchange_uin = paramBundle.getBooleanExtra("canchange_uin", false);
    this.mSourceId = paramBundle.getIntExtra("source_id", 0);
    this.ish5zzb = paramBundle.getBooleanExtra("ish5zzb", false);
    this.mQueryResult = ((RealNameQueryResult)paramBundle.getSerializableExtra("result"));
    this.isFromRecommView = getIntent().getBooleanExtra("zzb_recommend_view", false);
    this.mIsActiveSuccess = false;
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    i.b(this.mFrontPath);
    i.b(this.mBackPath);
  }
  
  public void onResume()
  {
    super.onResume();
    cx.c().a.a(this.mHandler);
  }
  
  public void onStop()
  {
    super.onStop();
    cx.c().a.a(null);
  }
  
  public void sendUpSmsBySMSAPP(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString1));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      h.b(paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameStep0VerifyMobileUpActivity
 * JD-Core Version:    0.7.0.1
 */