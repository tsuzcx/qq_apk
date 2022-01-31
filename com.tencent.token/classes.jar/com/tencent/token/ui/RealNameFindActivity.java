package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.captchasdk.TCaptchaPopupActivity;
import com.tencent.token.ch;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.cw;
import com.tencent.token.global.h;
import com.tencent.token.utils.i;
import com.tencent.token.utils.w;
import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class RealNameFindActivity
  extends BaseActivity
{
  private static final int VERIFYREQESTCODE = 1001;
  private Handler _handler;
  private byte[] backphotoinfo;
  private boolean canchange_uin;
  private TextView changeTypeTv;
  private byte[] frontphotoinfo;
  private boolean isFirstFactor = false;
  private boolean isGetQryIdResult = false;
  private boolean isShowLockVerify = false;
  private boolean isValidId = false;
  private boolean ish5zzb;
  private boolean mAutoIDCardDetect = true;
  private byte[] mBackData;
  private String mBackPath;
  private String mCountryCode = "+86";
  private byte[] mFaceData;
  private byte[] mFrontData;
  private String mFrontPath;
  private Handler mHandler = new ui(this);
  private HandlerThread mHandlerThread;
  private EditText mIdEditText;
  private ProgressBar mIdPb;
  private boolean mIsActiveSuccess = false;
  private String mMobile = "";
  private EditText mNameEditText;
  private Button mNext;
  private int mOpType = 2;
  private long mRealUin;
  private View mScanFaceLayout;
  private ImageView mScanFaceOk;
  private View mScanIdLayout;
  private ImageView mScanIdOk;
  private int mSourceId;
  private TextView mTipText;
  private QQUser mUser;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  protected QueryCaptchaResult queryCaptchaResult;
  private RealNameQueryResult result;
  private ScrollView scrollView;
  private boolean verifyFaceAndID = false;
  
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
    String str1 = this.mNameEditText.getText().toString();
    String str2 = this.mIdEditText.getText().toString();
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
    String str = this.mIdEditText.getText().toString();
    if (isVaildID(str))
    {
      this.mIdPb.setVisibility(0);
      cw.a().a(w.f(this.mRealUin), this.mRealUin, str, this.mHandler, false);
      return;
    }
    this.mTipText.setVisibility(0);
    if (TextUtils.isEmpty(str))
    {
      this.mTipText.setText(getResources().getString(2131231652));
      this.mTipText.setTextColor(-7829368);
    }
    for (;;)
    {
      this.isValidId = false;
      checkCanCommit();
      return;
      this.mTipText.setText(getResources().getString(2131231651));
      this.mTipText.setTextColor(-65536);
    }
  }
  
  private byte[] compressPicData(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (paramArrayOfByte == null) {
      return localByteArrayOutputStream.toByteArray();
    }
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        localOptions.inSampleSize = calculateInSampleSize(localOptions, 640, 640);
        localOptions.inJustDecodeBounds = false;
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions).compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        if (localByteArrayOutputStream == null) {
          continue;
        }
        try
        {
          localByteArrayOutputStream.close();
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
        continue;
      }
      finally
      {
        if (localByteArrayOutputStream == null) {
          break label130;
        }
      }
      try
      {
        localByteArrayOutputStream.close();
        return localByteArrayOutputStream.toByteArray();
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    try
    {
      localByteArrayOutputStream.close();
      label130:
      throw paramArrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void initView()
  {
    if (this.ish5zzb)
    {
      setTitle(2131230786);
      ((TextView)findViewById(2131559168)).setText(2131230785);
    }
    this.mNext = ((Button)findViewById(2131559148));
    this.mScanFaceOk = ((ImageView)findViewById(2131559157));
    this.mScanIdOk = ((ImageView)findViewById(2131559160));
    this.mScanFaceLayout = findViewById(2131559155);
    this.mScanIdLayout = findViewById(2131559158);
    this.mNameEditText = ((EditText)findViewById(2131559008));
    this.mIdEditText = ((EditText)findViewById(2131559152));
    if (this.mNameEditText != null) {
      this.mNameEditText.clearFocus();
    }
    if (this.mIdEditText != null) {
      this.mIdEditText.clearFocus();
    }
    this.mIdPb = ((ProgressBar)findViewById(2131559153));
    this.mTipText = ((TextView)findViewById(2131559154));
    this.mNameEditText.addTextChangedListener(new uw(this));
    this.mIdEditText.addTextChangedListener(new ux(this));
    this.mIdEditText.setOnFocusChangeListener(new uy(this));
    this.mIdEditText.setOnEditorActionListener(new uz(this));
    ScrollView localScrollView = (ScrollView)findViewById(2131558485);
    localScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new va(this, localScrollView));
    this.changeTypeTv = ((TextView)findViewById(2131558740));
    if (this.verifyFaceAndID)
    {
      this.changeTypeTv.setVisibility(0);
      this.changeTypeTv.setOnClickListener(new vb(this));
    }
    for (;;)
    {
      this.mScanFaceLayout.setOnClickListener(new vc(this));
      this.mScanIdLayout.setOnClickListener(new vd(this));
      this.mNext.setOnClickListener(new ut(this));
      return;
      this.changeTypeTv.setVisibility(8);
    }
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
    showProDialogWithoutShutDown(this, getResources().getString(2131231298));
    if (this.mHandlerThread == null)
    {
      this.mHandlerThread = new HandlerThread("uploadphoto", 1);
      this.mHandlerThread.start();
    }
    if (this._handler == null) {
      this._handler = new Handler(this.mHandlerThread.getLooper());
    }
    this._handler.post(new uu(this));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((this.mIsActiveSuccess) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        default: 
          if ((this.isFirstFactor) && (paramKeyEvent.getAction() == 0)) {}
          switch (paramKeyEvent.getKeyCode())
          {
          case 4: 
            return super.dispatchKeyEvent(paramKeyEvent);
          }
          break;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      startActivity(abi.a().a(this));
      return true;
    }
    return true;
  }
  
  protected void goNextVerify()
  {
    if (!this.mVerifyType.a(Integer.valueOf(this.mVerifyFactorId)))
    {
      dismissDialog();
      abi.a().a(this, this.mVerifyResult, this.mVerifyType, this.mVerifyType.a(this.mVerifyFactorId), false, this.mHandler);
      return;
    }
    if (this.mVerifyResult.b())
    {
      cw.a().b(this.mUser.mRealUin, this.mVerifyType.a(), this.mMobile, this.mCountryCode, this.mHandler);
      return;
    }
    dismissDialog();
    Intent localIntent = new Intent(this, NetActiveSetDirBySeqActivity.class);
    localIntent.putExtra("intent.qquser", this.mUser);
    localIntent.putExtra("intent.determin_factors_result", this.mVerifyResult);
    localIntent.putExtra("intent.determin_verify_type", this.mVerifyType);
    localIntent.putExtra("intent.determin_verify_factor_id", 6);
    startActivity(localIntent);
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if ((paramInt2 == 0) && (paramIntent != null) && (paramIntent.getByteArrayExtra("facedata") != null) && (paramIntent.getByteArrayExtra("facedata").length > 0))
      {
        this.mFaceData = paramIntent.getByteArrayExtra("facedata");
        h.a("realname facedata len=" + this.mFaceData.length);
        this.mScanFaceOk.setVisibility(0);
        ch.a().a(System.currentTimeMillis(), 89);
        checkCanCommit();
      }
    }
    while ((paramInt1 != 1001) || (paramInt2 == -1)) {
      try
      {
        paramIntent = new JSONObject(paramIntent.getStringExtra("retJson"));
        if (paramIntent.getInt("ret") == 0)
        {
          if (this.queryCaptchaResult != null) {
            cw.a().d(this.queryCaptchaResult.mRealUin, this.queryCaptchaResult.mSceneId, paramIntent.getString("ticket"), paramIntent.getString("randstr"), this.mHandler);
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
              ch.a().a(System.currentTimeMillis(), 90);
              checkCanCommit();
            }
          }
        }
        else
        {
          Toast.makeText(this, "未验证成功", 0).show();
          return;
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    Toast.makeText(this, "未验证成功", 0).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("intent.determin_from_list", false)) {
      overridePendingTransition(0, 0);
    }
    this.isShowLockVerify = getIntent().getBooleanExtra("not_showLockVerify", false);
    this.canchange_uin = getIntent().getBooleanExtra("canchange_uin", false);
    if (this.isShowLockVerify) {
      setNeverShowLockVerifyView();
    }
    this.mSourceId = getIntent().getIntExtra("source_id", 0);
    this.ish5zzb = getIntent().getBooleanExtra("ish5zzb", false);
    this.result = ((RealNameQueryResult)getIntent().getSerializableExtra("result"));
    this.mRealUin = getIntent().getLongExtra("real_uin", 0L);
    this.mIsActiveSuccess = false;
    this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
    if (this.mVerifyFactorId != -1)
    {
      this.verifyFaceAndID = true;
      this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
      this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
      this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
      this.isFirstFactor = getIntent().getBooleanExtra("intent.determin_first_verify_factor", false);
      if ((this.mUser == null) || (this.mVerifyResult == null) || (this.mVerifyType == null))
      {
        finish();
        return;
      }
      if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
        setNeverShowLockVerifyView();
      }
      this.mRealUin = this.mUser.mRealUin;
      if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
        this.mSourceId = 1;
      }
    }
    setContentView(2130968727);
    initView();
    cw.a().l(this.mRealUin, this.mHandler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    i.b(this.mFrontPath);
    i.b(this.mBackPath);
    abi.c();
  }
  
  protected void onResume()
  {
    super.onResume();
    Intent localIntent;
    if (this.mVerifyFactorId != -1)
    {
      this.verifyFaceAndID = true;
      localIntent = getIntent();
      if (localIntent != null) {
        break label35;
      }
    }
    label35:
    while (!localIntent.getBooleanExtra("reupload", false))
    {
      return;
      this.verifyFaceAndID = false;
      break;
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
  
  protected void setDefaultBackArrow()
  {
    super.setDefaultBackArrow();
    if (this.isFirstFactor) {
      this.mBackArrow.setOnClickListener(new uv(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameFindActivity
 * JD-Core Version:    0.7.0.1
 */