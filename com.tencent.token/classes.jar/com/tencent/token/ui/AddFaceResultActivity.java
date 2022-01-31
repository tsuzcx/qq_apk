package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;

public class AddFaceResultActivity
  extends BaseActivity
{
  public static int ADD_FACE_CAN_NOT_UPDATE_ZZB = 1;
  public static int ADD_FACE_CAN_UPDATE_ZZB = 2;
  public static int ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE = -1;
  private boolean canModifyFace = false;
  private int fromAddFaceToZzb = ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE;
  private boolean mAddFaceSucc = false;
  private Button mBtn;
  private Button mBtnAddResource;
  private Handler mHandler = new as(this);
  private ImageView mResultImage;
  private TextView mResultTip;
  private TextView mResultTitle;
  private QQUser mUser;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if (paramKeyEvent.getAction() == 0) {}
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
      if (this.mAddFaceSucc) {
        break;
      }
      paramKeyEvent = new Intent(this, FaceRecognitionDefaultActivity.class);
      paramKeyEvent.addFlags(67108864);
      startActivity(paramKeyEvent);
      finish();
      return true;
    }
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968613);
    this.mAddFaceSucc = getIntent().getBooleanExtra("add_face_succ", false);
    this.canModifyFace = getIntent().getBooleanExtra("can_modify_face", false);
    this.mUser = do.a().e();
    if (this.mUser == null)
    {
      finish();
      return;
    }
    this.mResultImage = ((ImageView)findViewById(2131558661));
    this.mResultTitle = ((TextView)findViewById(2131558662));
    this.mResultTip = ((TextView)findViewById(2131558663));
    this.mBtn = ((Button)findViewById(2131558664));
    this.mBtnAddResource = ((Button)findViewById(2131558660));
    if (this.mAddFaceSucc)
    {
      this.mBackArrow.setVisibility(8);
      this.mBtn.setOnClickListener(new at(this));
      return;
    }
    this.mResultImage.setBackgroundResource(2130837607);
    this.mResultTitle.setText(getResources().getString(2131230834));
    this.mBtn.setText(getResources().getString(2131231387));
    this.mBtn.setOnClickListener(new au(this));
    if (this.canModifyFace)
    {
      this.mResultTip.setText(getResources().getString(2131230832));
      this.mBtnAddResource.setVisibility(0);
      this.mBtnAddResource.setText(getResources().getString(2131230839));
      this.mBtnAddResource.setOnClickListener(new av(this));
      return;
    }
    this.mResultTip.setText(getResources().getString(2131230833));
    this.mBtnAddResource.setVisibility(8);
  }
  
  protected void setDefaultBackArrow()
  {
    super.setDefaultBackArrow();
    this.mBackArrow.setVisibility(0);
    this.mBackArrow.setOnClickListener(new aw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AddFaceResultActivity
 * JD-Core Version:    0.7.0.1
 */