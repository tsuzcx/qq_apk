package com.tencent.token.ui;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsMessage;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.db;
import com.tencent.token.global.e;

public class RealNameStep0VerifyMobileDownActivity
  extends BaseActivity
{
  private final int INTERVAL_TIME_AFTER_GET_SMS_1 = 61;
  private final int INTERVAL_TIME_AFTER_GET_SMS_2 = 99;
  private final int MSG_LOADING = 100;
  private final String RECEIVE_SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";
  private final int SMS_INTERVAL = 3000;
  private final String UPDATE_INTERVAL_TIME_ACTION = "com.tencent.token.realname.VRY_MOBILE_INTERVAL";
  private final int UPDATE_TIME = -100;
  byte[] backphotoinfo;
  private boolean canchange_uin;
  byte[] frontphotoinfo;
  private boolean ish5zzb;
  byte[] mBackData;
  String mBackPath;
  byte[] mFaceData;
  byte[] mFrontData;
  String mFrontPath;
  private Handler mHandler = new wn(this);
  private AlarmManager mIntervalAlarmMgr = null;
  private PendingIntent mIntervalPending = null;
  private int mIntervalTime = 61;
  private boolean mIsActiveSuccess = false;
  private boolean mIsAutoSumbit = false;
  private boolean mIsSMSRegisted = false;
  private String mMobile;
  private Button mNextBtn;
  private RealNameQueryResult mQueryResult;
  private Button mReSendBtn;
  private long mRealUin;
  private RealNameStatusResult mResult;
  private String mSMSPrefix;
  private BroadcastReceiver mSMSReceiver = new wm(this);
  private int mSceneId;
  private EditText mSmsCode;
  int mSourceId;
  
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
    e.a("interval: " + this.mIntervalTime);
    if (this.mIntervalTime > 0) {
      return;
    }
    this.mIntervalTime = 99;
    updateIntervalTimer();
    af.a().a(0L, Long.valueOf(this.mRealUin), this.mSceneId, this.mHandler);
  }
  
  /* Error */
  private byte[] compressPicData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 191	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 235	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 238	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_1
    //   14: iconst_0
    //   15: aload_1
    //   16: arraylength
    //   17: aload_2
    //   18: invokestatic 244	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: pop
    //   22: aload_2
    //   23: aload_2
    //   24: sipush 640
    //   27: sipush 640
    //   30: invokestatic 246	com/tencent/token/ui/RealNameStep0VerifyMobileDownActivity:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   33: putfield 249	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   36: aload_2
    //   37: iconst_0
    //   38: putfield 238	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   41: aload_1
    //   42: iconst_0
    //   43: aload_1
    //   44: arraylength
    //   45: aload_2
    //   46: invokestatic 244	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: astore_2
    //   50: new 251	java/io/ByteArrayOutputStream
    //   53: dup
    //   54: invokespecial 252	java/io/ByteArrayOutputStream:<init>	()V
    //   57: astore_1
    //   58: aload_2
    //   59: getstatic 258	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   62: bipush 85
    //   64: aload_1
    //   65: invokevirtual 264	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   68: pop
    //   69: aload_1
    //   70: invokevirtual 267	java/io/ByteArrayOutputStream:close	()V
    //   73: aload_1
    //   74: invokevirtual 271	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   77: areturn
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   83: goto -10 -> 73
    //   86: astore_2
    //   87: aload_1
    //   88: invokevirtual 267	java/io/ByteArrayOutputStream:close	()V
    //   91: aload_2
    //   92: athrow
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   98: goto -7 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	RealNameStep0VerifyMobileDownActivity
    //   0	101	1	paramArrayOfByte	byte[]
    //   7	52	2	localObject1	Object
    //   78	2	2	localIOException	java.io.IOException
    //   86	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   69	73	78	java/io/IOException
    //   58	69	86	finally
    //   87	91	93	java/io/IOException
  }
  
  private SmsMessage[] getMessage(Intent paramIntent)
  {
    paramIntent = (Object[])paramIntent.getSerializableExtra("pdus");
    if (paramIntent == null) {
      return null;
    }
    int j = paramIntent.length;
    SmsMessage[] arrayOfSmsMessage = new SmsMessage[j];
    int i = 0;
    while (i < j)
    {
      arrayOfSmsMessage[i] = SmsMessage.createFromPdu((byte[])paramIntent[i]);
      i += 1;
    }
    return arrayOfSmsMessage;
  }
  
  private void goReUploadDialog(String paramString)
  {
    showUserDialog(2131361808, paramString, 2131361800, new wu(this), new wv(this));
  }
  
  private void initView()
  {
    this.mNextBtn = ((Button)findViewById(2131296932));
    this.mReSendBtn = ((Button)findViewById(2131296887));
    this.mSmsCode = ((EditText)findViewById(2131296886));
    if (this.mSmsCode != null) {
      this.mSmsCode.clearFocus();
    }
    String str2 = getResources().getString(2131361823) + "\n(";
    String str1 = str2;
    if (this.mIntervalTime < 10) {
      str1 = str2 + "0";
    }
    str1 = str1 + this.mIntervalTime + ")";
    this.mReSendBtn.setText(str1);
    this.mReSendBtn.setTextColor(getResources().getColor(2131165197));
    this.mReSendBtn.setOnClickListener(new ws(this));
    this.mNextBtn.setOnClickListener(new wt(this));
  }
  
  private void registerSMSReceiver()
  {
    if (!this.mIsSMSRegisted)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
      registerReceiver(this.mSMSReceiver, localIntentFilter, "android.permission.RECEIVE_SMS", null);
      this.mIsSMSRegisted = true;
    }
  }
  
  private void setTextFromSMS(String paramString)
  {
    EditText localEditText = (EditText)findViewById(2131296886);
    if (localEditText != null)
    {
      localEditText.setText(paramString);
      this.mIsAutoSumbit = true;
      localEditText.postDelayed(new ww(this, paramString), 3000L);
    }
  }
  
  private boolean setTime(long paramLong)
  {
    if (paramLong <= 0L)
    {
      if (this.mReSendBtn != null)
      {
        this.mReSendBtn.setTextColor(getResources().getColor(2131165192));
        this.mReSendBtn.setText(2131361823);
        this.mReSendBtn.setTextSize(0, getResources().getDimensionPixelSize(2131230731));
      }
      return false;
    }
    String str2 = getResources().getString(2131361823) + "\n(";
    String str1 = str2;
    if (this.mIntervalTime < 10) {
      str1 = str2 + "0";
    }
    str1 = str1 + this.mIntervalTime + ")";
    if (this.mReSendBtn != null)
    {
      this.mReSendBtn.setText(str1);
      this.mReSendBtn.setTextColor(getResources().getColor(2131165197));
      this.mReSendBtn.setTextSize(0, getResources().getDimensionPixelSize(2131230728));
    }
    return true;
  }
  
  private void unregisterSMSReceiver()
  {
    if (this.mIsSMSRegisted)
    {
      unregisterReceiver(this.mSMSReceiver);
      this.mIsSMSRegisted = false;
    }
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
    af.a().a(0L, this.mRealUin, this.mSceneId, paramString, this.mHandler);
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130903159);
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
    if (db.e == null) {
      db.e = getString(2131361825);
    }
    this.ish5zzb = paramBundle.getBooleanExtra("ish5zzb", false);
    this.mSMSPrefix = db.e;
    this.mQueryResult = ((RealNameQueryResult)paramBundle.getSerializableExtra("result"));
    this.mIsActiveSuccess = false;
    registerSMSReceiver();
    initView();
    updateIntervalTimer();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mHandler != null) {
      this.mHandler.removeMessages(-100);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    e.a("pause");
    if (this.mIsSMSRegisted)
    {
      unregisterReceiver(this.mSMSReceiver);
      this.mIsSMSRegisted = false;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    registerSMSReceiver();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameStep0VerifyMobileDownActivity
 * JD-Core Version:    0.7.0.1
 */