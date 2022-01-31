package com.tencent.token.ui;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.fi;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.ui.base.cd;
import java.util.ArrayList;

public class FaceRegCameraActivity
  extends BaseActivity
{
  private AnimationDrawable animationDrawable;
  private Handler handler = new hs(this);
  private boolean isShowingErrorDialog = false;
  private int[] mActions;
  private Animation mAnimLeft;
  private cd mDrawable;
  private int mFaceOpType = 1;
  private int mFaceScene = 1;
  private FaceView mFaceView;
  private FaceData mImgData1;
  private FaceData mImgData2;
  private ImageView mLiveDetectImg;
  private boolean mNeedLiveAction = false;
  private FaceRecognitionCameraPreview mPreview;
  private ImageView mProgress;
  private int mScene;
  private byte[] mServerData;
  private int mStep;
  private RelativeLayout mTipAreaLayout;
  private TextView mTipTxt;
  
  private void doFaceReg()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mImgData1 == null) || (this.mImgData2 == null)) {}
    do
    {
      return;
      localArrayList.add(this.mImgData1.mUploadData);
      localArrayList.add(this.mImgData2.mUploadData);
      this.mServerData = fi.a(localArrayList);
    } while ((this.mServerData == null) || (this.mServerData.length <= 100));
    setContentView(2130968661);
    this.mProgress = ((ImageView)findViewById(2131558912));
    this.mProgress.setBackgroundDrawable(this.mDrawable);
    this.handler.sendEmptyMessageDelayed(13, 10000L);
    if (do.a().e() != null) {}
    for (long l = do.a().e().mRealUin;; l = 0L)
    {
      cw.a().a(0L, l, this.mFaceOpType, this.mServerData, 0, this.mFaceScene, this.mFaceView.getBrightModeIntValue(), this.handler);
      this.mPreview.c();
      return;
    }
  }
  
  private void doRealnameReg()
  {
    Object localObject = new ArrayList();
    if ((this.mImgData1 == null) || (this.mImgData2 == null)) {}
    do
    {
      return;
      ((ArrayList)localObject).add(this.mImgData1.mUploadData);
      ((ArrayList)localObject).add(this.mImgData2.mUploadData);
      this.mServerData = fi.a((ArrayList)localObject);
    } while ((this.mServerData == null) || (this.mServerData.length <= 100));
    localObject = new Intent();
    ((Intent)localObject).putExtra("facedata", this.mServerData);
    setResult(0, (Intent)localObject);
    finish();
  }
  
  private void init()
  {
    findViewById(2131558858).setOnClickListener(new id(this));
    this.mTipAreaLayout = ((RelativeLayout)findViewById(2131558868));
    this.mTipTxt = ((TextView)findViewById(2131558865));
    this.mLiveDetectImg = ((ImageView)findViewById(2131558869));
    TextView localTextView = (TextView)findViewById(2131558857);
    if (this.mScene == 1) {
      localTextView.setText(2131230986);
    }
    for (;;)
    {
      this.mPreview = ((FaceRecognitionCameraPreview)findViewById(2131558767));
      this.mPreview.setVisibility(4);
      this.mFaceView = ((FaceView)findViewById(2131558768));
      this.mDrawable = new cd(this);
      return;
      localTextView.setText(2131231371);
    }
  }
  
  private void setLiveDetectTxt(int paramInt)
  {
    this.mTipTxt.setVisibility(0);
    this.mLiveDetectImg.setVisibility(0);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.mTipTxt.setText(2131231146);
      this.mLiveDetectImg.setImageResource(2130837858);
      this.animationDrawable = ((AnimationDrawable)this.mLiveDetectImg.getDrawable());
      this.animationDrawable.start();
      return;
    case 2: 
      this.mTipTxt.setText(2131231147);
      this.mLiveDetectImg.setImageResource(2130837629);
      this.animationDrawable = ((AnimationDrawable)this.mLiveDetectImg.getDrawable());
      this.animationDrawable.start();
      return;
    case 3: 
      this.mTipTxt.setText(2131231148);
      this.mLiveDetectImg.setImageResource(2130837843);
      this.animationDrawable = ((AnimationDrawable)this.mLiveDetectImg.getDrawable());
      this.animationDrawable.start();
      return;
    }
    this.mTipTxt.setText(2131231149);
    this.mLiveDetectImg.setImageResource(2130837953);
    this.animationDrawable = ((AnimationDrawable)this.mLiveDetectImg.getDrawable());
    this.animationDrawable.start();
  }
  
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
      if (RqdApplication.f())
      {
        exitToken();
        return true;
      }
      finish();
      return true;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    h.a("requestcode=" + paramInt1 + ",resultcode=" + paramInt2);
    if (paramInt1 == 100) {
      if (paramInt2 == 10) {
        if (this.mStep < 1) {
          if (this.mImgData1 != null)
          {
            this.mImgData1.mOriginDataPath = null;
            this.mImgData1.mUploadData = null;
            this.mImgData1 = null;
          }
        }
      }
    }
    label123:
    do
    {
      do
      {
        do
        {
          break label123;
          for (;;)
          {
            this.mPreview.a(true, false, 0, this.mStep);
            this.mFaceView.setStatus(0);
            this.mTipTxt.setText(2131231151);
            this.mLiveDetectImg.setImageResource(2130837790);
            return;
            if (this.mImgData2 != null)
            {
              this.mImgData2.mOriginDataPath = null;
              this.mImgData2.mUploadData = null;
              this.mImgData2 = null;
            }
          }
        } while (paramInt2 != 20);
        if (this.mScene == 1)
        {
          this.mStep += 1;
          if (this.mStep < 2)
          {
            showOrangeToast(2131231027, 2130838017);
            this.mPreview.a(true, false, 0, this.mStep);
            this.mFaceView.setStatus(3);
            return;
          }
          doFaceReg();
          return;
        }
        this.mStep += 1;
        if (this.mStep < 2)
        {
          showOrangeToast(2131231027, 2130838017);
          this.mPreview.a(true, false, 0, this.mStep);
          this.mFaceView.setStatus(0);
          return;
        }
        doRealnameReg();
        return;
      } while (paramInt1 != 200);
      if (paramInt2 == 10)
      {
        this.mStep = 0;
        if (this.mImgData1 != null)
        {
          this.mImgData1.mOriginDataPath = null;
          this.mImgData1.mUploadData = null;
          this.mImgData1 = null;
        }
        if (this.mImgData2 != null)
        {
          this.mImgData2.mOriginDataPath = null;
          this.mImgData2.mUploadData = null;
          this.mImgData2 = null;
        }
        this.mPreview.a(true, false, 0, this.mStep);
        this.mFaceView.setStatus(0);
        this.mTipTxt.setText(2131231151);
        this.mLiveDetectImg.setImageResource(2130837790);
        return;
      }
    } while (paramInt2 != 20);
    if (this.mScene == 1)
    {
      doFaceReg();
      return;
    }
    doRealnameReg();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.mScene = getIntent().getIntExtra("scene", 1);
    requestWindowFeature(1);
    setContentView(2130968655);
    hideTitle();
    init();
    ProtoFaceCommon.e();
    cw.a().f(-1L, this.mScene, this.handler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mServerData = null;
    if (this.mPreview != null)
    {
      this.mPreview.c();
      this.mPreview = null;
    }
    this.handler = null;
    if (this.mImgData1 != null)
    {
      this.mImgData1.mOriginDataPath = null;
      this.mImgData1.mUploadData = null;
      this.mImgData1 = null;
    }
    if (this.mImgData2 != null)
    {
      this.mImgData2.mOriginDataPath = null;
      this.mImgData2.mUploadData = null;
      this.mImgData2 = null;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    RqdApplication.b = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    RqdApplication.b = true;
    if (this.mPreview != null)
    {
      if localif = new if(this);
      requestRuntimePermissions(new String[] { "android.permission.CAMERA" }, localif);
      this.mPreview.setStop(false);
    }
    if (this.mAnimLeft == null) {
      this.mAnimLeft = AnimationUtils.loadAnimation(this, 2131034128);
    }
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new ie(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRegCameraActivity
 * JD-Core Version:    0.7.0.1
 */