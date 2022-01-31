package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.captchasdk.TCaptchaPopupActivity;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode;
import com.tencent.token.cw;
import com.tencent.token.global.h;
import com.tencent.token.utils.i;
import org.json.JSONObject;

public class RealNameStep0VerifyMobileDownActivity
  extends BaseActivity
{
  private static final int VERIFYREQESTCODE = 1001;
  private final int INTERVAL_TIME_AFTER_GET_SMS_1 = 61;
  private final int INTERVAL_TIME_AFTER_GET_SMS_2 = 99;
  private final int MSG_LOADING = 100;
  private final int SMS_INTERVAL = 3000;
  private final int UPDATE_TIME = -100;
  byte[] backphotoinfo;
  private boolean canchange_uin;
  byte[] frontphotoinfo;
  private boolean isFromRecommView;
  private boolean ish5zzb;
  byte[] mBackData;
  String mBackPath;
  byte[] mFaceData;
  byte[] mFrontData;
  String mFrontPath;
  private Handler mHandler = new vy(this);
  private int mIntervalTime = 61;
  private boolean mIsActiveSuccess = false;
  private boolean mIsAutoSumbit = false;
  private String mMobile;
  private Button mNextBtn;
  private RealNameQueryResult mQueryResult;
  private Button mReSendBtn;
  private long mRealUin;
  private RealNameStatusResult mResult;
  private int mSceneId;
  private EditText mSmsCode;
  int mSourceId;
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
  
  private void checkAndGetSMS()
  {
    h.a("interval: " + this.mIntervalTime);
    if (this.mIntervalTime > 0) {
      return;
    }
    this.mIntervalTime = 99;
    updateIntervalTimer();
    cw.a().a(0L, Long.valueOf(this.mRealUin), this.mSceneId, this.mHandler);
  }
  
  /* Error */
  private byte[] compressPicData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 141	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 191	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 194	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_1
    //   14: iconst_0
    //   15: aload_1
    //   16: arraylength
    //   17: aload_2
    //   18: invokestatic 200	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: pop
    //   22: aload_2
    //   23: aload_2
    //   24: sipush 640
    //   27: sipush 640
    //   30: invokestatic 202	com/tencent/token/ui/RealNameStep0VerifyMobileDownActivity:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   33: putfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   36: aload_2
    //   37: iconst_0
    //   38: putfield 194	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   41: aload_1
    //   42: iconst_0
    //   43: aload_1
    //   44: arraylength
    //   45: aload_2
    //   46: invokestatic 200	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: astore_2
    //   50: new 207	java/io/ByteArrayOutputStream
    //   53: dup
    //   54: invokespecial 208	java/io/ByteArrayOutputStream:<init>	()V
    //   57: astore_1
    //   58: aload_2
    //   59: getstatic 214	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   62: bipush 85
    //   64: aload_1
    //   65: invokevirtual 220	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   68: pop
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 223	java/io/ByteArrayOutputStream:close	()V
    //   77: aload_1
    //   78: invokevirtual 227	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   81: areturn
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 230	java/io/IOException:printStackTrace	()V
    //   87: goto -10 -> 77
    //   90: astore_2
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 223	java/io/ByteArrayOutputStream:close	()V
    //   99: aload_2
    //   100: athrow
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 230	java/io/IOException:printStackTrace	()V
    //   106: goto -7 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	RealNameStep0VerifyMobileDownActivity
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
  
  private void goReUploadDialog(String paramString)
  {
    showUserDialog(2131230843, paramString, 2131230897, new we(this), new wf(this));
  }
  
  private void initView()
  {
    this.mNextBtn = ((Button)findViewById(2131559148));
    this.mReSendBtn = ((Button)findViewById(2131559081));
    this.mSmsCode = ((EditText)findViewById(2131559080));
    if (this.mSmsCode != null) {
      this.mSmsCode.clearFocus();
    }
    String str2 = getResources().getString(2131230800) + "\n(";
    String str1 = str2;
    if (this.mIntervalTime < 10) {
      str1 = str2 + "0";
    }
    str1 = str1 + this.mIntervalTime + ")";
    this.mReSendBtn.setText(str1);
    this.mReSendBtn.setTextColor(getResources().getColor(2131492930));
    this.mReSendBtn.setOnClickListener(new wc(this));
    this.mNextBtn.setOnClickListener(new wd(this));
  }
  
  private void setTextFromSMS(String paramString)
  {
    EditText localEditText = (EditText)findViewById(2131559080);
    if (localEditText != null)
    {
      localEditText.setText(paramString);
      this.mIsAutoSumbit = true;
      localEditText.postDelayed(new wg(this, paramString), 3000L);
    }
  }
  
  private boolean setTime(long paramLong)
  {
    if (paramLong <= 0L)
    {
      if (this.mReSendBtn != null)
      {
        this.mReSendBtn.setTextColor(getResources().getColor(2131492925));
        this.mReSendBtn.setText(2131230800);
        this.mReSendBtn.setTextSize(0, getResources().getDimensionPixelSize(2131296403));
      }
      return false;
    }
    String str2 = getResources().getString(2131230800) + "\n(";
    String str1 = str2;
    if (this.mIntervalTime < 10) {
      str1 = str2 + "0";
    }
    str1 = str1 + this.mIntervalTime + ")";
    if (this.mReSendBtn != null)
    {
      this.mReSendBtn.setText(str1);
      this.mReSendBtn.setTextColor(getResources().getColor(2131492930));
      this.mReSendBtn.setTextSize(0, getResources().getDimensionPixelSize(2131296400));
    }
    return true;
  }
  
  private void updateIntervalTimer()
  {
    this.mIntervalTime -= 1;
    if (setTime(this.mIntervalTime)) {
      this.mHandler.sendEmptyMessageDelayed(-100, 1000L);
    }
  }
  
  private void vrySmsCode(String paramString)
  {
    cw.a().a(0L, this.mRealUin, this.mSceneId, paramString, 0, this.mHandler);
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
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      if (paramInt1 == 1001)
      {
        if (paramInt2 != -1) {
          break label114;
        }
        try
        {
          paramIntent = new JSONObject(paramIntent.getStringExtra("retJson"));
          if (paramIntent.getInt("ret") == 0)
          {
            if (this.queryCaptchaResult == null) {
              continue;
            }
            cw.a().d(this.queryCaptchaResult.mRealUin, this.queryCaptchaResult.mSceneId, paramIntent.getString("ticket"), paramIntent.getString("randstr"), this.mHandler);
          }
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
    }
    Toast.makeText(this, "未验证成功", 0).show();
    return;
    label114:
    Toast.makeText(this, "未验证成功", 0).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130968722);
    paramBundle = getIntent();
    this.mResult = ((RealNameStatusResult)paramBundle.getSerializableExtra("realname_result"));
    this.mMobile = paramBundle.getStringExtra("realname_mobile");
    this.mRealUin = paramBundle.getLongExtra("real_uin", 0L);
    this.mSceneId = paramBundle.getIntExtra("scene_id", 1001);
    this.mFrontPath = paramBundle.getStringExtra("mFrontPath");
    this.mBackPath = paramBundle.getStringExtra("mBackPath");
    this.mFaceData = paramBundle.getByteArrayExtra("mFaceData");
    this.frontphotoinfo = paramBundle.getByteArrayExtra("frontphotoinfo");
    this.backphotoinfo = paramBundle.getByteArrayExtra("backphotoinfo");
    this.canchange_uin = paramBundle.getBooleanExtra("canchange_uin", false);
    this.mSourceId = paramBundle.getIntExtra("source_id", 0);
    if (ProtoGeneralGetMobileCode.f == null) {
      ProtoGeneralGetMobileCode.f = getString(2131230802);
    }
    this.ish5zzb = paramBundle.getBooleanExtra("ish5zzb", false);
    this.isFromRecommView = getIntent().getBooleanExtra("zzb_recommend_view", false);
    this.mQueryResult = ((RealNameQueryResult)paramBundle.getSerializableExtra("result"));
    initView();
    updateIntervalTimer();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mHandler != null) {
      this.mHandler.removeMessages(-100);
    }
    i.b(this.mFrontPath);
    i.b(this.mBackPath);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameStep0VerifyMobileDownActivity
 * JD-Core Version:    0.7.0.1
 */