package com.tencent.token.ui.qqpim;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.token.ui.IndexActivity;

public class QQPim4GNotifyDialog
  extends Dialog
{
  private Context a;
  private a b = null;
  
  public QQPim4GNotifyDialog(Context paramContext, a parama)
  {
    super(paramContext, 2131558791);
    this.a = paramContext;
    this.b = parama;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296414);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
      localLayoutParams.width = ((int)(((Activity)this.a).getWindowManager().getDefaultDisplay().getWidth() - IndexActivity.S_DENSITY * 84.0F));
      paramBundle.setAttributes(localLayoutParams);
      ((TextView)findViewById(2131166223)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (QQPim4GNotifyDialog.a(QQPim4GNotifyDialog.this) != null) {
            QQPim4GNotifyDialog.a(QQPim4GNotifyDialog.this).a();
          }
          QQPim4GNotifyDialog.this.dismiss();
        }
      });
      ((TextView)findViewById(2131166222)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          QQPim4GNotifyDialog.this.dismiss();
        }
      });
    }
  }
  
  static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.QQPim4GNotifyDialog
 * JD-Core Version:    0.7.0.1
 */