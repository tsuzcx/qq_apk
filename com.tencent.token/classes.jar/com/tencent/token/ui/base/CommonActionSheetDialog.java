package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class CommonActionSheetDialog
  extends Dialog
{
  private Context a;
  private i b;
  private LinearLayout c;
  private String[] d;
  
  public CommonActionSheetDialog(Activity paramActivity, i parami, String[] paramArrayOfString)
  {
    super(paramActivity, 2131427400);
    this.a = paramActivity;
    this.d = paramArrayOfString;
    this.b = parami;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903071);
    this.c = ((LinearLayout)findViewById(2131296498));
    setCanceledOnTouchOutside(true);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837639);
    paramBundle.getAttributes().width = -1;
    paramBundle.setGravity(80);
    if ((this.d == null) || (this.d.length < 2)) {
      return;
    }
    paramBundle = (Button)findViewById(2131296499);
    paramBundle.setText(this.d[0]);
    paramBundle.setOnClickListener(new f(this));
    paramBundle = (Button)findViewById(2131296500);
    paramBundle.setText(this.d[1]);
    paramBundle.setOnClickListener(new g(this));
    int i = 2;
    while (i < this.d.length)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
      Button localButton = new Button(this.a);
      localButton.setLayoutParams(localLayoutParams);
      localButton.setTextAppearance(this.a, 2131427335);
      localButton.setText(this.d[i]);
      localButton.setOnClickListener(new h(this, i));
      this.c.addView(localButton);
      i += 1;
    }
    this.c.invalidate();
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.CommonActionSheetDialog
 * JD-Core Version:    0.7.0.1
 */