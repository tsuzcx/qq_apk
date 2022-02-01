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
import com.tencent.token.ks;
import com.tencent.token.ks.a;
import com.tencent.token.zs;
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
  
  final void a()
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
    setContentView(2131296355);
    getWindow().setBackgroundDrawableResource(2131099877);
    paramBundle = (TextView)findViewById(2131165661);
    TextView localTextView = (TextView)findViewById(2131165662);
    Button localButton = (Button)findViewById(2131165568);
    findViewById(2131165382).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GuideQQPimSecureDialog.this.a();
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ks.a.a;
        ks.a(GuideQQPimSecureDialog.this.getContext(), GuideQQPimSecureDialog.this.c, GuideQQPimSecureDialog.this.b);
        GuideQQPimSecureDialog.this.a();
        TMSDKContext.SaveStringData(1150162, GuideQQPimSecureDialog.this.c);
      }
    });
    paramBundle.setText((CharSequence)this.a.get(0));
    localTextView.setText((CharSequence)this.a.get(1));
    localButton.setText((CharSequence)this.a.get(2));
    new zs((ImageView)findViewById(2131166150)).execute(new String[] { this.d });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.GuideQQPimSecureDialog
 * JD-Core Version:    0.7.0.1
 */