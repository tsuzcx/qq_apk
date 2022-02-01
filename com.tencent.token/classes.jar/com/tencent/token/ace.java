package com.tencent.token;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public final class ace
{
  public static void a(Context paramContext, String paramString, aib.a parama)
  {
    new a(paramContext, paramString, parama).show();
  }
  
  static final class a
    extends Dialog
  {
    private aib.a a;
    private String b;
    
    public a(Context paramContext, String paramString, aib.a parama)
    {
      super(2131558763);
      this.a = parama;
      this.b = paramString;
      setContentView(2131296411);
      paramContext = (TextView)findViewById(2131165764);
      paramString = (TextView)findViewById(2131165802);
      parama = (TextView)findViewById(2131165364);
      paramString.setText("取消");
      parama.setText("允许");
      if (!TextUtils.isEmpty(this.b)) {
        paramContext.setText(this.b);
      }
      paramString.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          ace.a.this.dismiss();
          if (ace.a.a(ace.a.this) != null) {
            ace.a.a(ace.a.this).a(false);
          }
        }
      });
      parama.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          ace.a.this.dismiss();
          if (ace.a.a(ace.a.this) != null) {
            ace.a.a(ace.a.this).a(true);
          }
        }
      });
    }
    
    public final void dismiss()
    {
      try
      {
        super.dismiss();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public final void show()
    {
      try
      {
        super.show();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ace
 * JD-Core Version:    0.7.0.1
 */