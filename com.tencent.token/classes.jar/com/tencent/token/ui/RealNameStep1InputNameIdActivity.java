package com.tencent.token.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.core.bean.RealNameRegResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.utils.s;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RealNameStep1InputNameIdActivity
  extends BaseActivity
{
  private final String RECEIVE_SMS_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
  private final int START_ANIM = 0;
  private final String UPDATE_INTERVAL_TIME_ACTION = "com.tencent.token.realname.AUDIT_INTERVAL";
  private final int UPDATE_TIME = -100;
  private Handler _handler;
  private byte[] backphotoinfo;
  private LinearLayout baselayout;
  private boolean checkid;
  private byte[] frontphotoinfo;
  private boolean isGetQryIdResult = false;
  private boolean isValidId = false;
  private long mAuditTime;
  private boolean mAutoIDCardDetect = true;
  private byte[] mBackData;
  private String mBackPath;
  private TextView mChanceLeft;
  Dialog mDialog;
  private byte[] mFaceData;
  private byte[] mFrontData;
  private String mFrontPath;
  private Handler mHandler = new xg(this);
  private HandlerThread mHandlerThread;
  private EditText mId;
  private ProgressBar mIdPb;
  private boolean mIsNETRegisted;
  private boolean mIsRegOk = false;
  private EditText mName;
  private Button mNext;
  private int mOpType = 1;
  private long mRealUin = 0L;
  private RealNameStatusResult mResult;
  private View mScanFaceLayout;
  private ImageView mScanFaceOk;
  private View mScanIdLayout;
  private ImageView mScanIdOk;
  private TextView mTip1;
  private TextView mTip3;
  private TextView mTipText;
  private ak mView;
  private BroadcastReceiver mnetReceiver = new xy(this);
  private ScrollView scrollView;
  private View toastView = null;
  private RelativeLayout topToast;
  private TextView topToastText;
  
  private void back2RealNameActivity()
  {
    Intent localIntent = new Intent(this, RealNameActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("realname_result", this.mResult);
    startActivity(localIntent);
  }
  
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
    String str1 = this.mName.getText().toString();
    String str2 = this.mId.getText().toString();
    if ((str1 != null) && (str1.length() > 0) && (str2 != null) && (str2.length() > 0) && (this.mScanFaceOk.getVisibility() == 0) && (this.mScanIdOk.getVisibility() == 0) && (this.isValidId)) {}
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
  
  private void checkIdCard()
  {
    String str = this.mId.getText().toString();
    if (isVaildID(str))
    {
      this.mIdPb.setVisibility(0);
      af.a().a(s.f(this.mRealUin), this.mRealUin, str, this.mHandler);
      return;
    }
    this.mTipText.setVisibility(0);
    if (TextUtils.isEmpty(str))
    {
      this.mTipText.setText(getResources().getString(2131362554));
      this.mTipText.setTextColor(-7829368);
      if ((this.toastView == null) || (this.toastView.getVisibility() != 0)) {
        break label182;
      }
      this.scrollView.scrollTo(0, this.mTipText.getMeasuredHeight() + s.a(this, 20.0F) + this.toastView.getMeasuredHeight());
    }
    for (;;)
    {
      this.isValidId = false;
      checkCanCommit();
      return;
      this.mTipText.setText(getResources().getString(2131362553));
      this.mTipText.setTextColor(-65536);
      break;
      label182:
      this.scrollView.scrollTo(0, this.mTipText.getMeasuredHeight() + s.a(this, 20.0F));
    }
  }
  
  /* Error */
  private byte[] compressPicData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 268	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 397	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 400	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_1
    //   14: iconst_0
    //   15: aload_1
    //   16: arraylength
    //   17: aload_2
    //   18: invokestatic 406	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: pop
    //   22: aload_2
    //   23: aload_2
    //   24: sipush 640
    //   27: sipush 640
    //   30: invokestatic 408	com/tencent/token/ui/RealNameStep1InputNameIdActivity:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   33: putfield 411	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   36: aload_2
    //   37: iconst_0
    //   38: putfield 400	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   41: aload_1
    //   42: iconst_0
    //   43: aload_1
    //   44: arraylength
    //   45: aload_2
    //   46: invokestatic 406	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: astore_2
    //   50: new 413	java/io/ByteArrayOutputStream
    //   53: dup
    //   54: invokespecial 414	java/io/ByteArrayOutputStream:<init>	()V
    //   57: astore_1
    //   58: aload_2
    //   59: getstatic 420	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   62: bipush 85
    //   64: aload_1
    //   65: invokevirtual 426	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   68: pop
    //   69: aload_1
    //   70: invokevirtual 429	java/io/ByteArrayOutputStream:close	()V
    //   73: aload_1
    //   74: invokevirtual 433	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   77: areturn
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 436	java/io/IOException:printStackTrace	()V
    //   83: goto -10 -> 73
    //   86: astore_2
    //   87: aload_1
    //   88: invokevirtual 429	java/io/ByteArrayOutputStream:close	()V
    //   91: aload_2
    //   92: athrow
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 436	java/io/IOException:printStackTrace	()V
    //   98: goto -7 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	RealNameStep1InputNameIdActivity
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
  
  private void dosuccess(RealNameRegResult paramRealNameRegResult)
  {
    dismissDialog();
    setContentView(2130903164);
    setTitle(2131362604);
    this.mAuditTime = paramRealNameRegResult.time_left;
    this.mTip3 = ((TextView)findViewById(2131296961));
    this.mTip3.setText(Html.fromHtml(String.format(getResources().getString(2131362777), new Object[] { Integer.valueOf(paramRealNameRegResult.chance_left) })));
    this.mTip1 = ((TextView)findViewById(2131296955));
    this.mTip1.setText(String.format(getResources().getString(2131362775), new Object[] { Integer.valueOf(paramRealNameRegResult.dispatch_time), Integer.valueOf(paramRealNameRegResult.daily_zzb_cnt) }));
    this.mResult.mRealStatus = 2;
    this.mResult.mLeftTime = paramRealNameRegResult.time_left;
    this.mResult.mCompleteTime = paramRealNameRegResult.complete_time;
    this.mResult.mSubmitTime = paramRealNameRegResult.submit_time;
    this.mResult.chanceLeft = paramRealNameRegResult.chance_left;
    this.mResult.mDailyZzbCnt = paramRealNameRegResult.daily_zzb_cnt;
    this.mResult.mMsgText = paramRealNameRegResult.top_msg_text;
    this.mIsRegOk = true;
    this.topToast = ((RelativeLayout)findViewById(2131296950));
    this.topToastText = ((TextView)findViewById(2131296784));
    if ((!TextUtils.isEmpty(paramRealNameRegResult.top_msg_text)) && (paramRealNameRegResult.chance_left > 0))
    {
      this.topToast.setVisibility(0);
      this.topToastText.setText(paramRealNameRegResult.top_msg_text);
    }
    this.mBackArrow.setOnClickListener(new xu(this));
  }
  
  private void initView()
  {
    this.toastView = findViewById(2131297337);
    this.scrollView = ((ScrollView)findViewById(2131296934));
    this.mResult = ((RealNameStatusResult)getIntent().getSerializableExtra("realname_result"));
    this.mRealUin = getIntent().getLongExtra("real_uin", 0L);
    this.mName = ((EditText)findViewById(2131296804));
    this.mId = ((EditText)findViewById(2131296935));
    if ((this.mName != null) && (this.mId != null))
    {
      this.mName.clearFocus();
      this.mId.clearFocus();
    }
    this.mIdPb = ((ProgressBar)findViewById(2131296936));
    this.mTipText = ((TextView)findViewById(2131296593));
    this.mNext = ((Button)findViewById(2131296932));
    this.mScanFaceOk = ((ImageView)findViewById(2131296939));
    this.mScanIdOk = ((ImageView)findViewById(2131296942));
    this.mScanFaceLayout = findViewById(2131296937);
    this.mScanIdLayout = findViewById(2131296940);
    this.mName.addTextChangedListener(new ya(this));
    this.mId.addTextChangedListener(new yb(this));
    this.mId.setOnFocusChangeListener(new yc(this));
    this.mId.setOnEditorActionListener(new yd(this));
    ScrollView localScrollView = (ScrollView)findViewById(2131296934);
    localScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new xn(this, localScrollView));
    this.mScanFaceLayout.setOnClickListener(new xo(this));
    this.mScanIdLayout.setOnClickListener(new xp(this));
    this.mNext.setOnClickListener(new xq(this));
    this.baselayout = ((LinearLayout)findViewById(2131296933));
    this.mView = new ak(getApplicationContext(), this.lineImg, this.arcImg);
    this.animLayout.addView(this.mView);
  }
  
  private boolean isVaildID(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("([0-9]{17}([0-9]|X|x))|([0-9]{15})").matcher(paramString).matches();
  }
  
  private void registerNETReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.mnetReceiver, localIntentFilter, "android.permission.ACCESS_WIFI_STATE", null);
    this.mIsNETRegisted = true;
  }
  
  private void showErrDialog(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2131361804;
    if (paramBoolean2) {
      i = 2131361803;
    }
    showUserDialog(2131361808, paramString, 2131361914, i, new xv(this, paramBoolean1), new xx(this, paramBoolean2));
  }
  
  private void startAnim()
  {
    this.animLayout.setVisibility(0);
    this.animLayout.setClickable(true);
    this.animLayout.setFocusable(true);
    this.animLayout.setFocusableInTouchMode(true);
    this.animLayout.requestFocus();
    this.animLayout.requestFocusFromTouch();
    this.baselayout.setEnabled(false);
    this.mView.c();
  }
  
  private void unregisterNETReceiver()
  {
    if (this.mIsNETRegisted)
    {
      unregisterReceiver(this.mnetReceiver);
      this.mIsNETRegisted = false;
    }
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
    this._handler.post(new xt(this));
    startAnim();
  }
  
  public void dismiss()
  {
    if (isFinishing()) {}
    for (;;)
    {
      return;
      try
      {
        if (this.mDialog != null)
        {
          this.mDialog.cancel();
          this.mDialog = null;
          return;
        }
      }
      catch (Exception localException)
      {
        e.b(localException.toString());
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((!this.mIsRegOk) || (paramKeyEvent.getAction() != 0)) {
          break label55;
        }
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
      back2RealNameActivity();
      return true;
      label55:
      int i = this.animLayout.getVisibility();
      if (i == 0) {
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
        p.a().a(System.currentTimeMillis(), 85);
        checkCanCommit();
      }
    }
    for (;;)
    {
      if (!this.isGetQryIdResult) {
        checkIdCard();
      }
      return;
      if (paramInt1 == 2) {
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
        }
        else if ((paramInt2 == 0) && (paramIntent != null) && (paramIntent.getStringExtra("frontdata") != null) && (paramIntent.getStringExtra("frontdata").length() > 0) && (paramIntent.getStringExtra("backdata") != null) && (paramIntent.getStringExtra("backdata").length() > 0))
        {
          this.mFrontPath = paramIntent.getStringExtra("frontdata");
          this.mBackPath = paramIntent.getStringExtra("backdata");
          this.frontphotoinfo = paramIntent.getByteArrayExtra("frontphotoinfo");
          this.backphotoinfo = paramIntent.getByteArrayExtra("backphotoinfo");
          e.a("realname id frontlen=" + this.mFrontPath.length() + ", backlen=" + this.mBackPath.length());
          this.mScanIdOk.setVisibility(0);
          p.a().a(System.currentTimeMillis(), 86);
          checkCanCommit();
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903161);
    initView();
    registerNETReceiver();
    af.a().n(-1L, this.mHandler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mIsNETRegisted)
    {
      unregisterReceiver(this.mnetReceiver);
      this.mIsNETRegisted = false;
    }
  }
  
  public void showUserDialogComfig(int paramInt1, String paramString1, String paramString2, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    if (isFinishing()) {
      return;
    }
    dismiss();
    this.mDialog = new Dialog(this, 2131427443);
    this.mDialog.setContentView(paramInt1);
    if (paramInt2 != 0) {
      ((ImageView)this.mDialog.findViewById(2131296966)).setImageResource(paramInt2);
    }
    if (paramString1 != null) {
      ((TextView)this.mDialog.findViewById(2131296404)).setText(paramString1);
    }
    if (paramString2 != null) {
      ((TextView)this.mDialog.findViewById(2131296804)).setText(paramString2);
    }
    paramString1 = (Button)this.mDialog.findViewById(2131296514);
    if (paramString1 != null) {
      paramString1.setOnClickListener(paramOnClickListener2);
    }
    paramString1 = (Button)this.mDialog.findViewById(2131296516);
    if (paramString1 != null) {
      paramString1.setOnClickListener(paramOnClickListener1);
    }
    this.mDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameStep1InputNameIdActivity
 * JD-Core Version:    0.7.0.1
 */