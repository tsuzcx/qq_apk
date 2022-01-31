package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ch;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;

public class AddFaceRealNameApplyResultActivity
  extends BaseActivity
{
  byte[] backphotoinfo;
  byte[] frontphotoinfo;
  private View.OnClickListener goFaceDefaultActivity = new ar(this);
  byte[] mBackData;
  private Button mBtnAddResource;
  private int mChangeFaceResult = AddFaceResultActivity.ADD_FACE_CAN_NOT_UPDATE_ZZB;
  private Button mConfirmBtn;
  byte[] mFaceData;
  byte[] mFrontData;
  private Handler mHandler = new ao(this);
  String mId;
  String mName;
  long mRealUin;
  private ImageView mResultImage;
  private TextView mResultTip;
  private TextView mResultTitle;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (paramKeyEvent.getAction() == 0) {}
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
        return true;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return;
    }
    this.mChangeFaceResult = paramBundle.getIntExtra("change_face_result", 1);
    this.mRealUin = paramBundle.getLongExtra("real_uin", do.a().e().b());
    this.mName = paramBundle.getStringExtra("name");
    this.mId = paramBundle.getStringExtra("card_id");
    this.mFaceData = paramBundle.getByteArrayExtra("mFaceData");
    this.mFrontData = paramBundle.getByteArrayExtra("mFrontData");
    this.mBackData = paramBundle.getByteArrayExtra("mBackData");
    this.frontphotoinfo = paramBundle.getByteArrayExtra("frontphotoinfo");
    this.backphotoinfo = paramBundle.getByteArrayExtra("backphotoinfo");
    setContentView(2130968612);
    this.mBackArrow.setVisibility(8);
    this.mResultImage = ((ImageView)findViewById(2131558655));
    this.mResultTitle = ((TextView)findViewById(2131558656));
    this.mResultTip = ((TextView)findViewById(2131558657));
    this.mConfirmBtn = ((Button)findViewById(2131558659));
    this.mBtnAddResource = ((Button)findViewById(2131558660));
    if (this.mChangeFaceResult == AddFaceResultActivity.ADD_FACE_CAN_UPDATE_ZZB)
    {
      ch.a().a(System.currentTimeMillis(), 218);
      this.mResultTip.setText(getResources().getString(2131231325));
      this.mConfirmBtn.setText(getResources().getString(2131230842));
      this.mConfirmBtn.setOnClickListener(new aq(this));
      this.mBtnAddResource.setVisibility(0);
      this.mBtnAddResource.setText(getResources().getString(2131230838));
      this.mBtnAddResource.setOnClickListener(this.goFaceDefaultActivity);
      return;
    }
    this.mConfirmBtn.setText(getResources().getString(2131230897));
    this.mConfirmBtn.setOnClickListener(this.goFaceDefaultActivity);
    this.mBtnAddResource.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AddFaceRealNameApplyResultActivity
 * JD-Core Version:    0.7.0.1
 */