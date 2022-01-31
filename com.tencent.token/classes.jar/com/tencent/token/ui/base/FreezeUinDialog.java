package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.token.ui.IndexActivity;

public class FreezeUinDialog
  extends Dialog
{
  private int a;
  private String b;
  private TextView c;
  private TextView d;
  private Context e;
  private Handler f;
  
  public FreezeUinDialog(Context paramContext, int paramInt1, String paramString, int paramInt2, Handler paramHandler)
  {
    super(paramContext, paramInt1);
    this.a = paramInt2;
    this.b = paramString;
    this.e = paramContext;
    this.f = paramHandler;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968669);
    paramBundle = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = ((int)(((Activity)this.e).getWindowManager().getDefaultDisplay().getWidth() - 46.0F * IndexActivity.S_DENSITY));
    paramBundle.setAttributes(localLayoutParams);
    this.c = ((TextView)findViewById(2131558932));
    paramBundle = String.format(this.e.getString(2131231046), new Object[] { this.b });
    this.c.setText(paramBundle);
    this.d = ((TextView)findViewById(2131558933));
    paramBundle = String.format(this.e.getString(2131231044), new Object[] { Integer.valueOf(this.a) });
    this.d.setText(paramBundle);
    paramBundle = (CheckBox)findViewById(2131558934);
    ((TextView)findViewById(2131558936)).setOnClickListener(new ad(this, paramBundle));
    ((TextView)findViewById(2131558935)).setOnClickListener(new ae(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.FreezeUinDialog
 * JD-Core Version:    0.7.0.1
 */