package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

public class FaceRecognitionDefaultActivity
  extends BaseActivity
{
  private Button btn_del;
  private View face_chanege_pwd;
  private boolean fromspalsh;
  private ImageView iv_facepswredicon;
  private ImageView iv_redicon;
  private boolean open_switch;
  private View rl_add;
  private View rl_pk;
  private View rl_pwd;
  private View rl_retry;
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
    setContentView(2130903096);
    int i = getIntent().getIntExtra("toastflag", -1);
    this.fromspalsh = getIntent().getBooleanExtra("fromsplash", false);
    if (i == 1)
    {
      showOrangeToast(2131362487, 2130837966);
      AccountPageActivity.mNeedRefreshEval = true;
    }
    for (;;)
    {
      this.tv_status = ((TextView)findViewById(2131296607));
      this.tv_iv_facepsw_status = ((TextView)findViewById(2131296554));
      this.iv_redicon = ((ImageView)findViewById(2131296615));
      this.rl_pwd = findViewById(2131296605);
      this.rl_pwd.setOnClickListener(new in(this));
      this.iv_facepswredicon = ((ImageView)findViewById(2131296553));
      this.face_chanege_pwd = findViewById(2131296551);
      if (t.l() == 0) {
        this.face_chanege_pwd.setVisibility(8);
      }
      this.face_chanege_pwd.setOnClickListener(new io(this));
      findViewById(2131296608).setOnClickListener(new ip(this));
      this.rl_retry = findViewById(2131296611);
      this.rl_retry.setOnClickListener(new iq(this));
      this.rl_add = findViewById(2131296612);
      this.rl_add.setOnClickListener(new ir(this));
      this.rl_pk = findViewById(2131296613);
      this.rl_pk.setOnClickListener(new is(this));
      return;
      if (i == 2) {
        showOrangeToast(2131362497, 2130837966);
      } else if (i == 4) {
        showOrangeToast(2131362498, 2130837966);
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (t.e() != 0L)
    {
      this.tv_status.setText(2131362380);
      this.tv_status.setTextAppearance(this, 2131427368);
    }
    while (ax.a().e() == null)
    {
      showNoAccountTipDialog(this, 3, 0);
      return;
      this.tv_status.setText(2131362381);
      this.tv_status.setTextAppearance(this, 2131427367);
    }
    if (!ax.a().e().mIsBinded)
    {
      showNoAccountTipDialog(this, 3, 1);
      return;
    }
    pv.a().a(this, new iu(this));
    if ((!s.i("face_changepsw_redtip")) && (t.e() == 0L)) {
      this.iv_facepswredicon.setVisibility(0);
    }
    for (;;)
    {
      this.iv_redicon.setVisibility(4);
      return;
      this.iv_facepswredicon.setVisibility(4);
    }
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new it(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionDefaultActivity
 * JD-Core Version:    0.7.0.1
 */