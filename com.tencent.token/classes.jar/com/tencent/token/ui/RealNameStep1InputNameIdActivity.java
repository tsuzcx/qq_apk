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
import com.tencent.token.ch;
import com.tencent.token.core.bean.RealNameRegResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.cw;
import com.tencent.token.global.h;
import com.tencent.token.utils.i;
import com.tencent.token.utils.w;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RealNameStep1InputNameIdActivity
  extends BaseActivity
{
  private final String RECEIVE_SMS_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
  private final int UPDATE_TIME = -100;
  private Handler _handler;
  private byte[] backphotoinfo;
  private LinearLayout baselayout;
  private boolean checkid;
  private byte[] frontphotoinfo;
  private boolean isFromRecommView = false;
  private boolean isGetQryIdResult = false;
  private boolean isValidId = false;
  private boolean mAutoIDCardDetect = true;
  private byte[] mBackData;
  private String mBackPath;
  Dialog mDialog;
  private byte[] mFaceData;
  private byte[] mFrontData;
  private String mFrontPath;
  private Handler mHandler = new wp(this);
  private HandlerThread mHandlerThread;
  private EditText mId;
  private ProgressBar mIdPb;
  private boolean mIsNETRegisted;
  private boolean mIsRegOk = false;
  private View mLogoLayout;
  private EditText mName;
  private Button mNext;
  private int mOpType = 1;
  private long mRealUin = 0L;
  private RealNameStatusResult mResult;
  private TextView mResultTipText;
  private View mScanFaceLayout;
  private ImageView mScanFaceOk;
  private View mScanIdLayout;
  private ImageView mScanIdOk;
  private TextView mTipText;
  private ax mView;
  private BroadcastReceiver mnetReceiver = new xn(this);
  private ScrollView scrollView;
  private int sourceFromAddFace = AddFaceResultActivity.ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE;
  private View toastView = null;
  
  private void back2RealNameActivity()
  {
    Intent localIntent = new Intent(this, RealNameActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("realname_result", this.mResult);
    startActivity(localIntent);
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
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
        this.mNext.setTextAppearance(this, 2131362228);
        this.mNext.setBackgroundResource(2130837632);
        this.mNext.setEnabled(true);
        return true;
      }
      this.mNext.setTextAppearance(this, 2131362186);
      this.mNext.setBackgroundResource(2130837728);
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
      cw.a().a(w.f(this.mRealUin), this.mRealUin, str, this.mHandler, true);
      return;
    }
    this.mTipText.setVisibility(0);
    if (TextUtils.isEmpty(str))
    {
      this.mTipText.setText(getResources().getString(2131231652));
      this.mTipText.setTextColor(-7829368);
      if ((this.toastView == null) || (this.toastView.getVisibility() != 0)) {
        break label183;
      }
      this.scrollView.scrollTo(0, this.mTipText.getMeasuredHeight() + w.a(this, 20.0F) + this.toastView.getMeasuredHeight());
    }
    for (;;)
    {
      this.isValidId = false;
      checkCanCommit();
      return;
      this.mTipText.setText(getResources().getString(2131231651));
      this.mTipText.setTextColor(-65536);
      break;
      label183:
      this.scrollView.scrollTo(0, this.mTipText.getMeasuredHeight() + w.a(this, 20.0F));
    }
  }
  
  /* Error */
  public static byte[] compressPicData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 263	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 394	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: iconst_1
    //   10: putfield 397	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_0
    //   14: iconst_0
    //   15: aload_0
    //   16: arraylength
    //   17: aload_1
    //   18: invokestatic 403	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: pop
    //   22: aload_1
    //   23: aload_1
    //   24: sipush 640
    //   27: sipush 640
    //   30: invokestatic 405	com/tencent/token/ui/RealNameStep1InputNameIdActivity:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   33: putfield 408	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   36: aload_1
    //   37: iconst_0
    //   38: putfield 397	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   41: aload_0
    //   42: iconst_0
    //   43: aload_0
    //   44: arraylength
    //   45: aload_1
    //   46: invokestatic 403	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: astore_1
    //   50: new 410	java/io/ByteArrayOutputStream
    //   53: dup
    //   54: invokespecial 411	java/io/ByteArrayOutputStream:<init>	()V
    //   57: astore_0
    //   58: aload_1
    //   59: getstatic 417	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   62: bipush 85
    //   64: aload_0
    //   65: invokevirtual 423	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   68: pop
    //   69: aload_0
    //   70: ifnull +7 -> 77
    //   73: aload_0
    //   74: invokevirtual 426	java/io/ByteArrayOutputStream:close	()V
    //   77: aload_0
    //   78: invokevirtual 430	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   81: areturn
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   87: goto -10 -> 77
    //   90: astore_1
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 426	java/io/ByteArrayOutputStream:close	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   106: goto -7 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramArrayOfByte	byte[]
    //   7	52	1	localObject1	Object
    //   82	2	1	localIOException	java.io.IOException
    //   90	10	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   73	77	82	java/io/IOException
    //   58	69	90	finally
    //   95	99	101	java/io/IOException
  }
  
  private void dosuccess(RealNameRegResult paramRealNameRegResult)
  {
    dismissDialog();
    setContentView(2130968726);
    setTitle(2131230849);
    this.mResult.mRealStatus = 2;
    this.mResult.mLeftTime = paramRealNameRegResult.time_left;
    this.mResult.mCompleteTime = paramRealNameRegResult.complete_time;
    this.mResult.mSubmitTime = paramRealNameRegResult.submit_time;
    this.mResult.chanceLeft = paramRealNameRegResult.chance_left;
    this.mResult.mDailyZzbCnt = paramRealNameRegResult.daily_zzb_cnt;
    this.mResult.mMsgText = paramRealNameRegResult.top_msg_text;
    this.mIsRegOk = true;
    this.mResultTipText = ((TextView)findViewById(2131559167));
    int i = w.c(this.mResult.mLeftTime);
    this.mResultTipText.setText(Html.fromHtml(String.format(getResources().getString(2131231671), new Object[] { Integer.valueOf(i) })));
    this.mBackArrow.setOnClickListener(new xj(this));
  }
  
  private void initView()
  {
    this.toastView = findViewById(2131559531);
    this.scrollView = ((ScrollView)findViewById(2131558485));
    this.mResult = ((RealNameStatusResult)getIntent().getSerializableExtra("realname_result"));
    this.isFromRecommView = getIntent().getBooleanExtra("zzb_recommend_view", false);
    this.sourceFromAddFace = getIntent().getIntExtra("from_add_face", -1);
    this.mRealUin = getIntent().getLongExtra("real_uin", 0L);
    this.mName = ((EditText)findViewById(2131559008));
    this.mId = ((EditText)findViewById(2131559152));
    if ((this.mName != null) && (this.mId != null))
    {
      this.mName.clearFocus();
      this.mId.clearFocus();
    }
    this.mIdPb = ((ProgressBar)findViewById(2131559153));
    this.mTipText = ((TextView)findViewById(2131559154));
    this.mNext = ((Button)findViewById(2131559148));
    this.mScanFaceOk = ((ImageView)findViewById(2131559157));
    this.mScanIdOk = ((ImageView)findViewById(2131559160));
    this.mScanFaceLayout = findViewById(2131559155);
    this.mScanIdLayout = findViewById(2131559158);
    Object localObject = (TextView)findViewById(2131559151);
    this.mLogoLayout = findViewById(2131559150);
    if (this.sourceFromAddFace != AddFaceResultActivity.ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE)
    {
      ch.a().a(System.currentTimeMillis(), 215);
      setTitle(getResources().getString(2131230839));
      this.mLogoLayout.setVisibility(8);
      ((TextView)localObject).setText(getResources().getString(2131231329));
    }
    this.mName.addTextChangedListener(new xp(this));
    this.mId.addTextChangedListener(new xq(this));
    this.mId.setOnFocusChangeListener(new xr(this));
    this.mId.setOnEditorActionListener(new xs(this));
    localObject = (ScrollView)findViewById(2131558485);
    ((ScrollView)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new xc(this, (ScrollView)localObject));
    this.mScanFaceLayout.setOnClickListener(new xd(this));
    this.mScanIdLayout.setOnClickListener(new xe(this));
    this.mNext.setOnClickListener(new xf(this));
    this.baselayout = ((LinearLayout)findViewById(2131559149));
    this.mView = new ax(getApplicationContext(), this.lineImg, this.arcImg);
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
    int i = 2131230886;
    if (paramBoolean2) {
      i = 2131231389;
    }
    showUserDialog(2131230843, paramString, 2131230881, i, new xk(this, paramBoolean1), new xm(this, paramBoolean2));
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
    this.mView.d();
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
    this._handler.post(new xi(this));
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
        h.b(localException.toString());
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
        h.a("realname facedata len=" + this.mFaceData.length);
        this.mScanFaceOk.setVisibility(0);
        ch.a().a(System.currentTimeMillis(), 85);
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
          h.a("realname id frontlen=" + this.mFrontPath.length() + ", backlen=" + this.mBackPath.length());
          this.mScanIdOk.setVisibility(0);
          ch.a().a(System.currentTimeMillis(), 86);
          checkCanCommit();
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968724);
    initView();
    registerNETReceiver();
    cw.a().l(-1L, this.mHandler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterNETReceiver();
    i.b(this.mFrontPath);
    i.b(this.mBackPath);
  }
  
  public void showUserDialogComfig(int paramInt1, String paramString1, String paramString2, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    if (isFinishing()) {
      return;
    }
    dismiss();
    this.mDialog = new Dialog(this, 2131362064);
    this.mDialog.setContentView(paramInt1);
    if (paramInt2 != 0) {
      ((ImageView)this.mDialog.findViewById(2131559172)).setImageResource(paramInt2);
    }
    if (paramString1 != null) {
      ((TextView)this.mDialog.findViewById(2131558419)).setText(paramString1);
    }
    if (paramString2 != null) {
      ((TextView)this.mDialog.findViewById(2131559008)).setText(paramString2);
    }
    paramString1 = (Button)this.mDialog.findViewById(2131558797);
    if (paramString1 != null) {
      paramString1.setOnClickListener(paramOnClickListener2);
    }
    paramString1 = (Button)this.mDialog.findViewById(2131558799);
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