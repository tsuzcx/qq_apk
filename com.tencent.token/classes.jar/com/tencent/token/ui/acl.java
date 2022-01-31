package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;

final class acl
  implements View.OnClickListener
{
  public final int a = 0;
  public final int b = 1;
  private int d = 0;
  
  public acl(ack paramack, int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    e.a("conf modify onClick=" + this.d);
    paramView = (StartPwdDigitSelActivity)ack.a(this.c);
    paramView.finish();
    switch (this.d)
    {
    default: 
      return;
    case 0: 
      localIntent = new Intent(paramView, StartPwdDigitVerifyActivity.class);
      localBundle = new Bundle();
      localBundle.putInt("enter_type", 2);
      localIntent.putExtra("com.tencent.input_param", localBundle);
      paramView.startActivity(localIntent);
      return;
    }
    Intent localIntent = new Intent(paramView, StartPwdDigitVerifyActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("enter_type", 3);
    localIntent.putExtra("com.tencent.input_param", localBundle);
    paramView.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acl
 * JD-Core Version:    0.7.0.1
 */