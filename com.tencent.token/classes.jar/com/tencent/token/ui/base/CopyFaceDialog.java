package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.aaz;
import com.tencent.token.ui.FaceRecognitionDefaultActivity;
import com.tencent.token.ui.IndexActivity;

public class CopyFaceDialog
  extends Dialog
{
  private String a;
  private TextView b;
  private Context c;
  
  public CopyFaceDialog(Context paramContext, String paramString)
  {
    super(paramContext, 2131558791);
    this.a = paramString;
    this.c = paramContext;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296313);
    paramBundle = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = ((int)(((Activity)this.c).getWindowManager().getDefaultDisplay().getWidth() - IndexActivity.S_DENSITY * 46.0F));
    paramBundle.setAttributes(localLayoutParams);
    this.b = ((TextView)findViewById(2131165427));
    paramBundle = new StringBuilder();
    paramBundle.append(this.a);
    paramBundle.append(this.c.getResources().getString(2131493129));
    paramBundle = paramBundle.toString();
    this.b.setText(aaz.a(paramBundle, this.c.getResources().getDimension(2131034250), (int)(((Activity)this.c).getWindowManager().getDefaultDisplay().getWidth() - IndexActivity.S_DENSITY * 80.0F)));
    ((Button)findViewById(2131165357)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        CopyFaceDialog.this.dismiss();
        paramAnonymousView = new Intent(CopyFaceDialog.a(CopyFaceDialog.this), FaceRecognitionDefaultActivity.class);
        paramAnonymousView.addFlags(67108864);
        CopyFaceDialog.a(CopyFaceDialog.this).startActivity(paramAnonymousView);
        ((Activity)CopyFaceDialog.a(CopyFaceDialog.this)).finish();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.CopyFaceDialog
 * JD-Core Version:    0.7.0.1
 */