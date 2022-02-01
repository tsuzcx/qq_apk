package com.tencent.guide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class WifiHintDialog
  extends Dialog
{
  View a;
  TextView b;
  
  protected void onCreate(Bundle paramBundle)
  {
    getWindow().requestFeature(1);
    getWindow().setBackgroundDrawableResource(2130968800);
    getWindow().setGravity(48);
    getWindow().clearFlags(2);
    paramBundle = getWindow().getAttributes();
    paramBundle.flags = 8;
    getWindow().setAttributes(paramBundle);
    this.a = LayoutInflater.from(getContext()).inflate(2131296367, null);
    paramBundle = new LinearLayout.LayoutParams(-1, -2);
    this.a.setLayoutParams(paramBundle);
    setContentView(this.a);
    this.b = ((TextView)this.a.findViewById(2131165331));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        WifiHintDialog.this.dismiss();
      }
    });
    setCanceledOnTouchOutside(false);
    setCancelable(true);
    setOnShowListener(new DialogInterface.OnShowListener()
    {
      public final void onShow(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.a.findViewById(2131165392).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        WifiHintDialog.this.dismiss();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.guide.WifiHintDialog
 * JD-Core Version:    0.7.0.1
 */