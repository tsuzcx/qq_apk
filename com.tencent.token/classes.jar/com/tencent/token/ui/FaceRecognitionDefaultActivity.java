package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cr;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;

public class FaceRecognitionDefaultActivity
  extends BaseActivity
{
  private Button btn_del;
  private View face_chanege_pwd;
  private boolean fromspalsh;
  private ImageView iv_facemobileredicon;
  private View mFaceChPswDivider;
  private View mFaceChmobileDivider;
  private View mFaceStartPswDivider;
  private ImageView mOrangeClose;
  private TextView mOrangeText;
  private View mOrangeView;
  private boolean mobile_open_switch;
  private boolean psw_open_switch;
  private View rl_add;
  private View rl_pwd;
  private View rl_retry;
  private TextView tv_iv_facemobile_status;
  private TextView tv_iv_facepsw_status;
  private TextView tv_status;
  
  public void onBackPressed()
  {
    if (this.fromspalsh)
    {
      Intent localIntent = new Intent(this, MyMbSubPageActivity.class);
      localIntent.putExtra("fromspalsh", this.fromspalsh);
      startActivity(localIntent);
      finish();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296339);
    int i = getIntent().getIntExtra("toastflag", -1);
    this.fromspalsh = getIntent().getBooleanExtra("fromsplash", false);
    if (i == 1)
    {
      showOrangeToast(2131493159, 2131100167);
      AccountPageActivity.mNeedRefreshEval = true;
    }
    else if (i == 2)
    {
      showOrangeToast(2131493181, 2131100167);
    }
    this.tv_status = ((TextView)findViewById(2131165515));
    this.tv_iv_facepsw_status = ((TextView)findViewById(2131165476));
    this.tv_iv_facemobile_status = ((TextView)findViewById(2131165472));
    this.mFaceStartPswDivider = findViewById(2131165483);
    this.mFaceChPswDivider = findViewById(2131165479);
    this.mFaceChmobileDivider = findViewById(2131165478);
    this.rl_pwd = findViewById(2131165512);
    this.rl_pwd.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, FacePwdIndexActivity.class);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
      }
    });
    this.iv_facemobileredicon = ((ImageView)findViewById(2131165473));
    this.face_chanege_pwd = findViewById(2131165474);
    if (m.i() == 0) {
      this.face_chanege_pwd.setVisibility(8);
    }
    this.face_chanege_pwd.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, FaceChangePwdIndexActivity.class);
        paramAnonymousView.putExtra("open_switch", FaceRecognitionDefaultActivity.this.psw_open_switch);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
      }
    });
    paramBundle = findViewById(2131165470);
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, FaceChangeMobileActivity.class);
        paramAnonymousView.putExtra("open_switch", FaceRecognitionDefaultActivity.this.mobile_open_switch);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
        l.a(null, "face_changemobile_redtip", true);
      }
    });
    if (m.n())
    {
      this.rl_pwd.setVisibility(0);
      this.mFaceStartPswDivider.setVisibility(0);
    }
    else
    {
      this.rl_pwd.setVisibility(8);
      this.mFaceStartPswDivider.setVisibility(8);
    }
    if (m.o())
    {
      this.face_chanege_pwd.setVisibility(0);
      this.mFaceChPswDivider.setVisibility(0);
    }
    else
    {
      this.face_chanege_pwd.setVisibility(8);
      this.mFaceChPswDivider.setVisibility(8);
    }
    if (m.p())
    {
      paramBundle.setVisibility(0);
      this.mFaceChmobileDivider.setVisibility(0);
    }
    else
    {
      paramBundle.setVisibility(8);
      this.mFaceChmobileDivider.setVisibility(8);
    }
    this.mOrangeView = findViewById(2131166324);
    this.mOrangeText = ((TextView)findViewById(2131166118));
    this.mOrangeClose = ((ImageView)findViewById(2131166115));
    this.mOrangeText.setText(getResources().getString(2131493129));
    this.mOrangeClose.setImageResource(2131099764);
    this.mOrangeView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, DownLineNoticeActivity.class);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
        m.a("face_downline_notice_clicked", true);
        FaceRecognitionDefaultActivity.this.mOrangeView.setVisibility(8);
      }
    });
    if ((!m.n()) && (!m.o()) && (!m.p())) {
      if (m.b("face_downline_notice_clicked", false)) {
        this.mOrangeView.setVisibility(8);
      } else {
        this.mOrangeView.setVisibility(0);
      }
    }
    this.rl_retry = findViewById(2131165513);
    this.rl_retry.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, FaceRecognitionCameraActivity.class);
        paramAnonymousView.putExtra("flag", 2);
        paramAnonymousView.putExtra("istry", 1);
        paramAnonymousView.putExtra("scene", 6);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
      }
    });
    this.rl_add = findViewById(2131165511);
    this.rl_add.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, FaceRecognitionAddFaceActivity.class);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
      }
    });
  }
  
  protected void onResume()
  {
    super.onResume();
    if (m.e() != 0L)
    {
      this.tv_status.setText(2131493586);
      this.tv_status.setTextAppearance(this, 2131558805);
    }
    else
    {
      this.tv_status.setText(2131493585);
      this.tv_status.setTextAppearance(this, 2131558806);
    }
    if (cr.a().e() == null)
    {
      showNoAccountTipDialog(this, 3, 0);
      return;
    }
    if (!cr.a().e().mIsBinded)
    {
      showNoAccountTipDialog(this, 3, 1);
      return;
    }
    o.a().a(this, new o.b()
    {
      public void a(int paramAnonymousInt)
      {
        Object localObject = FaceRecognitionDefaultActivity.this;
        boolean bool2 = false;
        boolean bool1;
        if ((paramAnonymousInt != 1) && (paramAnonymousInt != 3)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        FaceRecognitionDefaultActivity.access$002((FaceRecognitionDefaultActivity)localObject, bool1);
        localObject = FaceRecognitionDefaultActivity.this;
        if (paramAnonymousInt != 2)
        {
          bool1 = bool2;
          if (paramAnonymousInt != 3) {}
        }
        else
        {
          bool1 = true;
        }
        FaceRecognitionDefaultActivity.access$102((FaceRecognitionDefaultActivity)localObject, bool1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("psw_open_switch");
        ((StringBuilder)localObject).append(FaceRecognitionDefaultActivity.this.psw_open_switch);
        g.a(((StringBuilder)localObject).toString());
        if (FaceRecognitionDefaultActivity.this.psw_open_switch)
        {
          FaceRecognitionDefaultActivity.this.tv_iv_facepsw_status.setText(2131493586);
          FaceRecognitionDefaultActivity.this.tv_iv_facepsw_status.setTextAppearance(FaceRecognitionDefaultActivity.this, 2131558805);
        }
        else
        {
          FaceRecognitionDefaultActivity.this.tv_iv_facepsw_status.setText(2131493585);
          FaceRecognitionDefaultActivity.this.tv_iv_facepsw_status.setTextAppearance(FaceRecognitionDefaultActivity.this, 2131558806);
        }
        if (FaceRecognitionDefaultActivity.this.mobile_open_switch)
        {
          FaceRecognitionDefaultActivity.this.tv_iv_facemobile_status.setText(2131493586);
          FaceRecognitionDefaultActivity.this.tv_iv_facemobile_status.setTextAppearance(FaceRecognitionDefaultActivity.this, 2131558805);
          return;
        }
        FaceRecognitionDefaultActivity.this.tv_iv_facemobile_status.setText(2131493585);
        FaceRecognitionDefaultActivity.this.tv_iv_facemobile_status.setTextAppearance(FaceRecognitionDefaultActivity.this, 2131558806);
      }
    });
    if ((!l.a(null, "face_changemobile_redtip")) && (m.e() == 0L))
    {
      this.iv_facemobileredicon.setVisibility(0);
      return;
    }
    this.iv_facemobileredicon.setVisibility(4);
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FaceRecognitionDefaultActivity.this.onBackPressed();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionDefaultActivity
 * JD-Core Version:    0.7.0.1
 */