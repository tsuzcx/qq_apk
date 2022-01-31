package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.bf;

public class SecondVerifyDialog
  extends Dialog
{
  ProDialog a = null;
  private TextView b;
  private TextView c;
  private Activity d;
  private EditText e;
  private Button f;
  private Button g;
  private Handler h;
  private boolean i = false;
  private int j;
  
  public SecondVerifyDialog(Activity paramActivity, Handler paramHandler, int paramInt)
  {
    super(paramActivity, 2131427400);
    this.d = paramActivity;
    this.h = paramHandler;
    this.j = paramInt;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if ((this.d == null) || ((this.d != null) && (this.d.isFinishing())))
    {
      dismiss();
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2130903191);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837639);
    ((ViewGroup.MarginLayoutParams)findViewById(2131297037).getLayoutParams()).width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
    paramBundle = bf.a();
    this.b = ((TextView)findViewById(2131297039));
    if ((paramBundle.b() != null) && (paramBundle.b().length() > 0)) {
      this.b.setText(paramBundle.b());
    }
    for (;;)
    {
      this.c = ((TextView)findViewById(2131297040));
      if ((paramBundle.c() != null) && (paramBundle.c().length() > 0)) {
        this.c.setText(paramBundle.c());
      }
      this.e = ((EditText)findViewById(2131297041));
      this.e.clearFocus();
      this.f = ((Button)findViewById(2131297043));
      this.f.setText(paramBundle.e());
      this.f.setOnClickListener(new cw(this));
      this.g = ((Button)findViewById(2131297042));
      this.g.setText(paramBundle.d());
      this.g.setOnClickListener(new cy(this));
      return;
      this.b.setText(this.d.getResources().getString(2131361808));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.SecondVerifyDialog
 * JD-Core Version:    0.7.0.1
 */