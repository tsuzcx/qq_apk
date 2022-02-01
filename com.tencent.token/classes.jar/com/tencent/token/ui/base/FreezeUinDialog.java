package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.xj;

public class FreezeUinDialog
  extends Dialog
{
  private int a;
  private String b;
  private TextView c;
  private TextView d;
  private Context e;
  private Handler f;
  
  public FreezeUinDialog(Context paramContext, String paramString, int paramInt, Handler paramHandler)
  {
    super(paramContext, 2131558791);
    this.a = paramInt;
    this.b = paramString;
    this.e = paramContext;
    this.f = paramHandler;
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296350);
    paramBundle = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = ((int)(((Activity)this.e).getWindowManager().getDefaultDisplay().getWidth() - IndexActivity.S_DENSITY * 46.0F));
    paramBundle.setAttributes(localLayoutParams);
    this.c = ((TextView)findViewById(2131165538));
    paramBundle = String.format(this.e.getString(2131493189), new Object[] { this.b });
    this.c.setText(paramBundle);
    this.d = ((TextView)findViewById(2131165537));
    paramBundle = String.format(this.e.getString(2131493187), new Object[] { Integer.valueOf(this.a) });
    this.d.setText(paramBundle);
    paramBundle = (CheckBox)findViewById(2131165542);
    ((TextView)findViewById(2131165535)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        FreezeUinDialog.this.dismiss();
        if (FreezeUinDialog.a(FreezeUinDialog.this) != null)
        {
          xj.a("freeze: msg=4009");
          paramAnonymousView = FreezeUinDialog.a(FreezeUinDialog.this).obtainMessage(4009);
          if (paramBundle.isChecked()) {
            paramAnonymousView.arg1 = 1;
          } else {
            paramAnonymousView.arg2 = 0;
          }
          FreezeUinDialog.a(FreezeUinDialog.this).sendMessage(paramAnonymousView);
        }
      }
    });
    ((TextView)findViewById(2131165534)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        FreezeUinDialog.this.dismiss();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.FreezeUinDialog
 * JD-Core Version:    0.7.0.1
 */