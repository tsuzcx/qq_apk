package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.x;

public class CopyFaceDialog
  extends Dialog
{
  private String a;
  private TextView b;
  private Context c;
  
  public CopyFaceDialog(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt);
    this.a = paramString;
    this.c = paramContext;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968630);
    paramBundle = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = ((int)(((Activity)this.c).getWindowManager().getDefaultDisplay().getWidth() - 46.0F * IndexActivity.S_DENSITY));
    paramBundle.setAttributes(localLayoutParams);
    this.b = ((TextView)findViewById(2131558759));
    paramBundle = this.a + this.c.getResources().getString(2131230984);
    this.b.setText(x.a(paramBundle, this.c.getResources().getDimension(2131296399), (int)(((Activity)this.c).getWindowManager().getDefaultDisplay().getWidth() - 80.0F * IndexActivity.S_DENSITY)));
    ((Button)findViewById(2131558760)).setOnClickListener(new f(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.CopyFaceDialog
 * JD-Core Version:    0.7.0.1
 */