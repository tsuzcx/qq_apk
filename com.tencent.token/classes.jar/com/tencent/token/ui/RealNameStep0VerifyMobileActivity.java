package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.do;

public class RealNameStep0VerifyMobileActivity
  extends BaseActivity
{
  byte[] backphotoinfo;
  private boolean canchange_uin;
  byte[] frontphotoinfo;
  boolean isFromRecommView;
  private boolean isShowLockVerify = false;
  boolean ish5zzb;
  byte[] mBackData;
  String mBackPath;
  private Button mChangeMobileBtnBtn;
  byte[] mFaceData;
  byte[] mFrontData;
  String mFrontPath;
  private Handler mHandler = new vt(this);
  private TextView mInfo;
  private TextView mMaskMobile;
  private String mMobile;
  private Button mNextBtn;
  private RealNameQueryResult mQueryResult;
  private long mRealUin;
  private RealNameStatusResult mResult;
  private int mSceneId;
  private int mSourceId;
  int pageid;
  
  private void initView()
  {
    setContentView(2130968721);
    setTitle(2131231620);
    this.mInfo = ((TextView)findViewById(2131559101));
    this.mMaskMobile = ((TextView)findViewById(2131558728));
    this.mNextBtn = ((Button)findViewById(2131558730));
    this.mChangeMobileBtnBtn = ((Button)findViewById(2131559147));
    if (this.mSceneId == 1001) {
      this.mChangeMobileBtnBtn.setOnClickListener(new vv(this));
    }
    for (;;)
    {
      this.mMaskMobile.setText(this.mMobile);
      this.mNextBtn.setOnClickListener(new vx(this));
      return;
      if (this.mSceneId == 1003)
      {
        this.mChangeMobileBtnBtn.setVisibility(4);
      }
      else
      {
        this.mInfo.setText(2131230796);
        this.mInfo.setGravity(17);
        this.mChangeMobileBtnBtn.setText(2131230801);
        this.mChangeMobileBtnBtn.setOnClickListener(new vw(this));
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.isShowLockVerify = getIntent().getBooleanExtra("not_showLockVerify", false);
    this.canchange_uin = getIntent().getBooleanExtra("canchange_uin", false);
    if (this.isShowLockVerify) {
      setNeverShowLockVerifyView();
    }
    this.mResult = ((RealNameStatusResult)getIntent().getSerializableExtra("realname_result"));
    paramBundle = getIntent();
    this.mMobile = paramBundle.getStringExtra("realname_mobile");
    this.mSceneId = paramBundle.getIntExtra("scene_id", 1001);
    this.mSourceId = paramBundle.getIntExtra("source_id", 0);
    this.mRealUin = paramBundle.getLongExtra("real_uin", 0L);
    this.pageid = paramBundle.getIntExtra("page_id", 0);
    this.mFrontPath = paramBundle.getStringExtra("mFrontPath");
    this.mBackPath = paramBundle.getStringExtra("mBackPath");
    this.mFaceData = paramBundle.getByteArrayExtra("mFaceData");
    this.frontphotoinfo = paramBundle.getByteArrayExtra("frontphotoinfo");
    this.backphotoinfo = paramBundle.getByteArrayExtra("backphotoinfo");
    this.canchange_uin = paramBundle.getBooleanExtra("canchange_uin", false);
    this.mQueryResult = ((RealNameQueryResult)getIntent().getSerializableExtra("result"));
    this.ish5zzb = paramBundle.getBooleanExtra("ish5zzb", false);
    this.isFromRecommView = getIntent().getBooleanExtra("zzb_recommend_view", false);
    if ((this.mRealUin == 0L) && (do.a().e() != null)) {
      this.mRealUin = do.a().e().mRealUin;
    }
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameStep0VerifyMobileActivity
 * JD-Core Version:    0.7.0.1
 */