package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.aac;
import com.tencent.token.aad;
import com.tencent.token.ahg;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ru;
import com.tencent.token.ru.a;
import com.tencent.token.sa;
import com.tencent.token.sz;
import com.tencent.token.xa;
import com.tencent.token.yd;
import com.tencent.token.yd.1;
import com.tencent.token.yd.2;
import com.tencent.token.yd.b;

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
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296340);
    int i = getIntent().getIntExtra("toastflag", -1);
    this.fromspalsh = getIntent().getBooleanExtra("fromsplash", false);
    if (i == 1)
    {
      showOrangeToast(2131493160, 2131100170);
      AccountPageActivity.mNeedRefreshEval = true;
    }
    else if (i == 2)
    {
      showOrangeToast(2131493182, 2131100170);
    }
    this.tv_status = ((TextView)findViewById(2131165519));
    this.tv_iv_facepsw_status = ((TextView)findViewById(2131165480));
    this.tv_iv_facemobile_status = ((TextView)findViewById(2131165476));
    this.mFaceStartPswDivider = findViewById(2131165487);
    this.mFaceChPswDivider = findViewById(2131165483);
    this.mFaceChmobileDivider = findViewById(2131165482);
    this.rl_pwd = findViewById(2131165516);
    this.rl_pwd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, FacePwdIndexActivity.class);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
      }
    });
    this.iv_facemobileredicon = ((ImageView)findViewById(2131165477));
    this.face_chanege_pwd = findViewById(2131165478);
    if (aad.i() == 0) {
      this.face_chanege_pwd.setVisibility(8);
    }
    this.face_chanege_pwd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, FaceChangePwdIndexActivity.class);
        paramAnonymousView.putExtra("open_switch", FaceRecognitionDefaultActivity.this.psw_open_switch);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
      }
    });
    paramBundle = findViewById(2131165474);
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, FaceChangeMobileActivity.class);
        paramAnonymousView.putExtra("open_switch", FaceRecognitionDefaultActivity.this.mobile_open_switch);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
        aac.h("face_changemobile_redtip");
      }
    });
    if (aad.n())
    {
      this.rl_pwd.setVisibility(0);
      this.mFaceStartPswDivider.setVisibility(0);
    }
    else
    {
      this.rl_pwd.setVisibility(8);
      this.mFaceStartPswDivider.setVisibility(8);
    }
    if (aad.o())
    {
      this.face_chanege_pwd.setVisibility(0);
      this.mFaceChPswDivider.setVisibility(0);
    }
    else
    {
      this.face_chanege_pwd.setVisibility(8);
      this.mFaceChPswDivider.setVisibility(8);
    }
    if (aad.p())
    {
      paramBundle.setVisibility(0);
      this.mFaceChmobileDivider.setVisibility(0);
    }
    else
    {
      paramBundle.setVisibility(8);
      this.mFaceChmobileDivider.setVisibility(8);
    }
    this.mOrangeView = findViewById(2131166339);
    this.mOrangeText = ((TextView)findViewById(2131166126));
    this.mOrangeClose = ((ImageView)findViewById(2131166123));
    this.mOrangeText.setText(getResources().getString(2131493130));
    this.mOrangeClose.setImageResource(2131099764);
    this.mOrangeView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, DownLineNoticeActivity.class);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
        aad.a("face_downline_notice_clicked");
        FaceRecognitionDefaultActivity.this.mOrangeView.setVisibility(8);
      }
    });
    if ((!aad.n()) && (!aad.o()) && (!aad.p())) {
      if (aad.b("face_downline_notice_clicked")) {
        this.mOrangeView.setVisibility(8);
      } else {
        this.mOrangeView.setVisibility(0);
      }
    }
    this.rl_retry = findViewById(2131165517);
    this.rl_retry.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, FaceRecognitionCameraActivity.class);
        paramAnonymousView.putExtra("flag", 2);
        paramAnonymousView.putExtra("istry", 1);
        paramAnonymousView.putExtra("scene", 6);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
      }
    });
    this.rl_add = findViewById(2131165515);
    this.rl_add.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionDefaultActivity.this, FaceRecognitionAddFaceActivity.class);
        FaceRecognitionDefaultActivity.this.startActivity(paramAnonymousView);
      }
    });
  }
  
  protected void onResume()
  {
    super.onResume();
    if (aad.e() != 0L)
    {
      this.tv_status.setText(2131493588);
      this.tv_status.setTextAppearance(this, 2131558805);
    }
    else
    {
      this.tv_status.setText(2131493587);
      this.tv_status.setTextAppearance(this, 2131558806);
    }
    if (sz.a().k.b() == null)
    {
      showNoAccountTipDialog(this, 3, 0);
      return;
    }
    if (!sz.a().k.b().mIsBinded)
    {
      showNoAccountTipDialog(this, 3, 1);
      return;
    }
    yd localyd = yd.a();
    Object localObject = new yd.b()
    {
      public final void a(int paramAnonymousInt)
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
        localObject = new StringBuilder("psw_open_switch");
        ((StringBuilder)localObject).append(FaceRecognitionDefaultActivity.this.psw_open_switch);
        xa.a(((StringBuilder)localObject).toString());
        if (FaceRecognitionDefaultActivity.this.psw_open_switch)
        {
          FaceRecognitionDefaultActivity.this.tv_iv_facepsw_status.setText(2131493588);
          FaceRecognitionDefaultActivity.this.tv_iv_facepsw_status.setTextAppearance(FaceRecognitionDefaultActivity.this, 2131558805);
        }
        else
        {
          FaceRecognitionDefaultActivity.this.tv_iv_facepsw_status.setText(2131493587);
          FaceRecognitionDefaultActivity.this.tv_iv_facepsw_status.setTextAppearance(FaceRecognitionDefaultActivity.this, 2131558806);
        }
        if (FaceRecognitionDefaultActivity.this.mobile_open_switch)
        {
          FaceRecognitionDefaultActivity.this.tv_iv_facemobile_status.setText(2131493588);
          FaceRecognitionDefaultActivity.this.tv_iv_facemobile_status.setTextAppearance(FaceRecognitionDefaultActivity.this, 2131558805);
          return;
        }
        FaceRecognitionDefaultActivity.this.tv_iv_facemobile_status.setText(2131493587);
        FaceRecognitionDefaultActivity.this.tv_iv_facemobile_status.setTextAppearance(FaceRecognitionDefaultActivity.this, 2131558806);
      }
    };
    if (!isFinishing())
    {
      QQUser localQQUser = sz.a().k.b();
      if (localQQUser == null)
      {
        localObject = getResources().getString(2131492913);
        ((BaseActivity)this).showUserDialog(2131492986, (String)localObject, 2131493040, new yd.1(localyd, this), new yd.2(localyd, this));
      }
      else if (sz.a().e())
      {
        localyd.c = this;
        localyd.a = ((yd.b)localObject);
        if (localQQUser.mRealUin == 0L)
        {
          ru.a.a().c(localyd.f);
        }
        else
        {
          localyd.d = 3;
          sa.a().a(localQQUser.mUin, localQQUser.mRealUin, 3, localyd.f);
        }
        ((BaseActivity)this).showProDialog(this, 2131492986, 2131493173, localyd.e);
      }
    }
    if ((!aac.i("face_changemobile_redtip")) && (aad.e() == 0L))
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
        public final void onClick(View paramAnonymousView)
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