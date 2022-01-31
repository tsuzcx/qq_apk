package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.w;
import com.tmsdk.TMSDKContext;

class ace
  implements View.OnClickListener
{
  private int b;
  private int c;
  private int d;
  private String e;
  private String f;
  
  public ace(UtilsActivity paramUtilsActivity, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramString1;
    this.f = paramString2;
  }
  
  public void onClick(View paramView)
  {
    if (this.c == 0) {
      TMSDKContext.SaveStringData(1150109, this.f);
    }
    if (this.b == 1)
    {
      TMSDKContext.saveActionData(1150070);
      if ((this.b > 10) || (this.b < 1)) {
        break label175;
      }
      UtilsActivity.access$200(this.a, this);
    }
    label175:
    while ((this.e == null) || (this.e.length() <= 0))
    {
      return;
      if (this.b == 3)
      {
        TMSDKContext.saveActionData(1150071);
        break;
      }
      if (this.b == 2)
      {
        TMSDKContext.saveActionData(1150072);
        break;
      }
      if (this.b == 4)
      {
        TMSDKContext.saveActionData(1150073);
        break;
      }
      if (this.b == 8)
      {
        TMSDKContext.saveActionData(1150075);
        break;
      }
      if (this.b == 11)
      {
        UtilsActivity.access$000(this.a);
        break;
      }
      if (this.b == 12)
      {
        TMSDKContext.saveActionData(1150074);
        break;
      }
      if (this.b != 20) {
        break;
      }
      UtilsActivity.access$100(this.a);
      break;
    }
    w.b(this.a, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ace
 * JD-Core Version:    0.7.0.1
 */