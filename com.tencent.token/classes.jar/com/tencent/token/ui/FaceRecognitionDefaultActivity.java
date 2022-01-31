package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;

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
    setContentView(2130968659);
    int i = getIntent().getIntExtra("toastflag", -1);
    this.fromspalsh = getIntent().getBooleanExtra("fromsplash", false);
    if (i == 1)
    {
      showOrangeToast(2131231017, 2130838018);
      AccountPageActivity.mNeedRefreshEval = true;
      this.tv_status = ((TextView)findViewById(2131558894));
      this.tv_iv_facepsw_status = ((TextView)findViewById(2131558840));
      this.tv_iv_facemobile_status = ((TextView)findViewById(2131558900));
      this.mFaceStartPswDivider = findViewById(2131558895);
      this.mFaceChPswDivider = findViewById(2131558896);
      this.mFaceChmobileDivider = findViewById(2131558901);
      this.rl_pwd = findViewById(2131558892);
      this.rl_pwd.setOnClickListener(new hk(this));
      this.iv_facemobileredicon = ((ImageView)findViewById(2131558899));
      this.face_chanege_pwd = findViewById(2131558837);
      if (x.i() == 0) {
        this.face_chanege_pwd.setVisibility(8);
      }
      this.face_chanege_pwd.setOnClickListener(new hl(this));
      paramBundle = findViewById(2131558897);
      paramBundle.setOnClickListener(new hm(this));
      if (!x.n()) {
        break label461;
      }
      this.rl_pwd.setVisibility(0);
      this.mFaceStartPswDivider.setVisibility(0);
      label241:
      if (!x.o()) {
        break label482;
      }
      this.face_chanege_pwd.setVisibility(0);
      this.mFaceChPswDivider.setVisibility(0);
      label263:
      if (!x.p()) {
        break label503;
      }
      paramBundle.setVisibility(0);
      this.mFaceChmobileDivider.setVisibility(0);
      label282:
      this.mOrangeView = findViewById(2131559531);
      this.mOrangeText = ((TextView)findViewById(2131558987));
      this.mOrangeClose = ((ImageView)findViewById(2131558988));
      this.mOrangeText.setText(getResources().getString(2131230987));
      this.mOrangeClose.setImageResource(2130837619);
      this.mOrangeView.setOnClickListener(new hn(this));
      if ((!x.n()) && (!x.o()) && (!x.p()))
      {
        if (!x.b("face_downline_notice_clicked", false)) {
          break label521;
        }
        this.mOrangeView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.rl_retry = findViewById(2131558903);
      this.rl_retry.setOnClickListener(new ho(this));
      this.rl_add = findViewById(2131558902);
      this.rl_add.setOnClickListener(new hp(this));
      return;
      if (i != 2) {
        break;
      }
      showOrangeToast(2131231039, 2130838018);
      break;
      label461:
      this.rl_pwd.setVisibility(8);
      this.mFaceStartPswDivider.setVisibility(8);
      break label241;
      label482:
      this.face_chanege_pwd.setVisibility(8);
      this.mFaceChPswDivider.setVisibility(8);
      break label263;
      label503:
      paramBundle.setVisibility(8);
      this.mFaceChmobileDivider.setVisibility(8);
      break label282;
      label521:
      this.mOrangeView.setVisibility(0);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (x.e() != 0L)
    {
      this.tv_status.setText(2131231443);
      this.tv_status.setTextAppearance(this, 2131362196);
    }
    while (do.a().e() == null)
    {
      showNoAccountTipDialog(this, 3, 0);
      return;
      this.tv_status.setText(2131231442);
      this.tv_status.setTextAppearance(this, 2131362197);
    }
    if (!do.a().e().mIsBinded)
    {
      showNoAccountTipDialog(this, 3, 1);
      return;
    }
    pg.a().a(this, new hr(this));
    if ((!w.a(null, "face_changemobile_redtip")) && (x.e() == 0L))
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
      this.mBackArrow.setOnClickListener(new hq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionDefaultActivity
 * JD-Core Version:    0.7.0.1
 */