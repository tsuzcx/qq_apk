package com.tencent.token.ui;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.ag;
import com.tencent.token.as;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.core.push.a;
import com.tencent.token.db;
import com.tencent.token.global.e;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;

public class RealNameSmsContentTipActivity
  extends BaseActivity
  implements Runnable
{
  private Handler _handler;
  byte[] backphotoinfo;
  private View btnLayout;
  boolean canchange_uin;
  private TextView errorTip;
  byte[] frontphotoinfo;
  private boolean ish5zzb;
  byte[] mBackData;
  String mBackPath;
  private View.OnClickListener mCompleteButtonListener = new wf(this);
  byte[] mFaceData;
  byte[] mFrontData;
  String mFrontPath;
  Handler mHandler = new vu(this);
  private HandlerThread mHandlerThread;
  private boolean mIsActiveSuccess = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private String mMobile;
  private ProgressBar mPb;
  private RealNameQueryResult mQueryResult;
  private long mRealUin;
  private RealNameStatusResult mResult;
  private int mRetryTimes = 0;
  private int mSceneId;
  private int mSourceId;
  private long mTimeConter;
  private String mUin;
  Runnable mVrySMSRunnable = new vs(this);
  private TextView mobileNum;
  private TextView okText;
  private TextView smsContent;
  private int upSmsSceneId;
  private TextView useTip;
  
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
    //   0: new 150	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 165	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 168	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_1
    //   14: iconst_0
    //   15: aload_1
    //   16: arraylength
    //   17: aload_2
    //   18: invokestatic 174	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: pop
    //   22: aload_2
    //   23: aload_2
    //   24: sipush 640
    //   27: sipush 640
    //   30: invokestatic 176	com/tencent/token/ui/RealNameSmsContentTipActivity:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   33: putfield 179	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   36: aload_2
    //   37: iconst_0
    //   38: putfield 168	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   41: aload_1
    //   42: iconst_0
    //   43: aload_1
    //   44: arraylength
    //   45: aload_2
    //   46: invokestatic 174	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: astore_2
    //   50: new 181	java/io/ByteArrayOutputStream
    //   53: dup
    //   54: invokespecial 182	java/io/ByteArrayOutputStream:<init>	()V
    //   57: astore_1
    //   58: aload_2
    //   59: getstatic 188	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   62: bipush 85
    //   64: aload_1
    //   65: invokevirtual 194	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   68: pop
    //   69: aload_1
    //   70: invokevirtual 197	java/io/ByteArrayOutputStream:close	()V
    //   73: aload_1
    //   74: invokevirtual 201	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   77: areturn
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   83: goto -10 -> 73
    //   86: astore_2
    //   87: aload_1
    //   88: invokevirtual 197	java/io/ByteArrayOutputStream:close	()V
    //   91: aload_2
    //   92: athrow
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   98: goto -7 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	RealNameSmsContentTipActivity
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
  
  private void displaySucc()
  {
    dismissDialog();
    Object localObject = ax.a().d(this.mRealUin);
    if (localObject != null) {
      ax.a().b((QQUser)localObject);
    }
    ag.c().n();
    localObject = this.mRealUin + "";
    this.mIsActiveSuccess = true;
    setContentView(2130903050);
    this.mBackArrow.setVisibility(4);
    findViewById(2131296398).setOnClickListener(this.mCompleteButtonListener);
    setTitle(2131361842);
    ((ImageView)findViewById(2131296395)).setImageDrawable(k.a((String)localObject, s.f(Long.parseLong((String)localObject)) + " "));
    ax.a().f(Long.parseLong((String)localObject));
    a.a().a(8);
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131361831, paramString, 2131361800, new wg(this));
  }
  
  private void uploadData()
  {
    if (this.mHandlerThread == null)
    {
      this.mHandlerThread = new HandlerThread("uploadphoto", 1);
      this.mHandlerThread.start();
    }
    if (this._handler == null) {
      this._handler = new Handler(this.mHandlerThread.getLooper());
    }
    this._handler.post(new vt(this));
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
    paramBundle = getIntent();
    this.mMobile = paramBundle.getStringExtra("realname_mobile");
    this.mSceneId = paramBundle.getIntExtra("scene_id", 0);
    this.mRealUin = paramBundle.getLongExtra("real_uin", 0L);
    this.ish5zzb = paramBundle.getBooleanExtra("ish5zzb", false);
    this.upSmsSceneId = paramBundle.getIntExtra("up_sms_scene_id", -1);
    if (this.upSmsSceneId == 2)
    {
      this.mSourceId = paramBundle.getIntExtra("source_id", 0);
      this.mFrontPath = paramBundle.getStringExtra("mFrontPath");
      this.mBackPath = paramBundle.getStringExtra("mBackPath");
      this.mFaceData = paramBundle.getByteArrayExtra("mFaceData");
      this.frontphotoinfo = paramBundle.getByteArrayExtra("frontphotoinfo");
      this.backphotoinfo = paramBundle.getByteArrayExtra("backphotoinfo");
      this.canchange_uin = paramBundle.getBooleanExtra("canchange_uin", false);
      this.mQueryResult = ((RealNameQueryResult)paramBundle.getSerializableExtra("result"));
    }
    for (;;)
    {
      this.mIsActiveSuccess = false;
      setContentView(2130903201);
      this.useTip = ((TextView)findViewById(2131297100));
      this.smsContent = ((TextView)findViewById(2131297103));
      this.mobileNum = ((TextView)findViewById(2131297106));
      this.errorTip = ((TextView)findViewById(2131296593));
      this.okText = ((TextView)findViewById(2131297107));
      this.btnLayout = findViewById(2131296430);
      this.mPb = ((ProgressBar)findViewById(2131296936));
      this.smsContent.setText(db.d);
      this.mobileNum.setText(db.c);
      paramBundle = String.format(getString(2131361877), new Object[] { this.mMobile });
      this.useTip.setText(paramBundle);
      this.btnLayout.setOnClickListener(new wd(this));
      return;
      this.mResult = ((RealNameStatusResult)paramBundle.getSerializableExtra("realname_result"));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    ag.c().a.a(this.mHandler);
  }
  
  protected void onStop()
  {
    super.onStop();
    ag.c().a.a(null);
  }
  
  public void removeTimeTask(int paramInt)
  {
    this.mIsTimeTask = false;
  }
  
  public void run()
  {
    while (this.mIsRunning) {
      if ((this.mIsTimeTask) && (System.currentTimeMillis() - this.mTimeConter > 60000L)) {
        try
        {
          e.c("removeTimeTask removeTimeTask");
          removeTimeTask(6);
          Message localMessage = new Message();
          localMessage.what = 15;
          this.mHandler.sendMessage(localMessage);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131362363, 2131361827, new we(this));
  }
  
  public void startTimeTask(int paramInt)
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameSmsContentTipActivity
 * JD-Core Version:    0.7.0.1
 */