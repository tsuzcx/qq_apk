package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;

public class AccountManagerMenuDialog
  extends Dialog
{
  private Activity a;
  private Button b;
  private Button c;
  private Button d;
  private Button e;
  private QQUser f;
  private TextView g;
  private TextView h;
  private View.OnClickListener i;
  private View.OnClickListener j;
  private View.OnClickListener k;
  private View.OnClickListener l;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903134);
    this.b = ((Button)findViewById(2131296812));
    this.c = ((Button)findViewById(2131296813));
    this.d = ((Button)findViewById(2131296780));
    this.e = ((Button)findViewById(2131296781));
    this.b.setOnClickListener(this.i);
    this.c.setOnClickListener(this.k);
    this.d.setOnClickListener(this.l);
    this.e.setOnClickListener(this.j);
    this.g = ((TextView)findViewById(2131296810));
    this.h = ((TextView)findViewById(2131296811));
    setCanceledOnTouchOutside(true);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837639);
    paramBundle.getAttributes().width = -1;
    paramBundle.setGravity(80);
  }
  
  public void show()
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {
      dismiss();
    }
    while (this.f == null) {
      return;
    }
    super.show();
    int m;
    if (this.f.mIsBinded)
    {
      this.b.setVisibility(8);
      m = 3;
      this.c.setBackgroundResource(2130837549);
      this.c.setTextAppearance(this.a, 2131427381);
      this.h.setVisibility(8);
      if (!this.f.mIsCurrentUser) {
        break label200;
      }
      this.c.setVisibility(8);
      m -= 1;
      label115:
      if (m != 4) {
        break label211;
      }
      this.d.setBackgroundResource(2130837636);
      this.d.setTextAppearance(this.a, 2131427335);
    }
    for (;;)
    {
      this.g.setText(this.f.mNickName);
      return;
      this.h.setVisibility(0);
      this.b.setVisibility(0);
      this.c.setBackgroundResource(2130837636);
      this.c.setTextAppearance(this.a, 2131427335);
      m = 4;
      break;
      label200:
      this.c.setVisibility(0);
      break label115;
      label211:
      this.d.setBackgroundResource(2130837857);
      this.d.setTextAppearance(this.a, 2131427381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.AccountManagerMenuDialog
 * JD-Core Version:    0.7.0.1
 */