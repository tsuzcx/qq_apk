package com.tencent.token.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class GuideQQPimSecureDialog
  extends Dialog
{
  ArrayList a;
  
  public GuideQQPimSecureDialog(Context paramContext, ArrayList paramArrayList)
  {
    super(paramContext);
    this.a = paramArrayList;
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
    setContentView(2130968674);
    getWindow().setBackgroundDrawableResource(2130837730);
    paramBundle = (TextView)findViewById(2131558408);
    TextView localTextView1 = (TextView)findViewById(2131558946);
    TextView localTextView2 = (TextView)findViewById(2131558409);
    Button localButton = (Button)findViewById(2131558947);
    findViewById(2131558948).setOnClickListener(new bb(this));
    localButton.setOnClickListener(new bc(this));
    paramBundle.setText((CharSequence)this.a.get(0));
    localTextView1.setText((CharSequence)this.a.get(1));
    localTextView2.setText((CharSequence)this.a.get(2));
    localButton.setText((CharSequence)this.a.get(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.GuideQQPimSecureDialog
 * JD-Core Version:    0.7.0.1
 */