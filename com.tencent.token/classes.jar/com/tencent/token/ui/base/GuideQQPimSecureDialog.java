package com.tencent.token.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.j;
import com.tencent.token.utils.a;
import com.tmsdk.TMSDKContext;
import java.util.ArrayList;

public class GuideQQPimSecureDialog
  extends Dialog
{
  ArrayList<String> a;
  ArrayList<String> b;
  String c;
  String d;
  
  public GuideQQPimSecureDialog(Context paramContext, String paramString1, String paramString2, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    super(paramContext);
    this.c = paramString1;
    this.d = paramString2;
    this.a = paramArrayList1;
    this.b = paramArrayList2;
  }
  
  void a()
  {
    try
    {
      dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296354);
    getWindow().setBackgroundDrawableResource(2131099876);
    paramBundle = (TextView)findViewById(2131165657);
    TextView localTextView = (TextView)findViewById(2131165658);
    Button localButton = (Button)findViewById(2131165566);
    findViewById(2131165380).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        GuideQQPimSecureDialog.this.a();
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        j.a().a(GuideQQPimSecureDialog.this.getContext(), GuideQQPimSecureDialog.this.c, GuideQQPimSecureDialog.this.b);
        GuideQQPimSecureDialog.this.a();
        TMSDKContext.SaveStringData(1150162, GuideQQPimSecureDialog.this.c);
      }
    });
    paramBundle.setText((CharSequence)this.a.get(0));
    localTextView.setText((CharSequence)this.a.get(1));
    localButton.setText((CharSequence)this.a.get(2));
    new a((ImageView)findViewById(2131166144)).execute(new String[] { this.d });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.GuideQQPimSecureDialog
 * JD-Core Version:    0.7.0.1
 */