package com.tencent.token.ui;

import android.widget.ListView;
import com.tencent.token.global.k;
import com.tencent.token.ui.base.cl;

class yu
  implements cl
{
  private yu(SelectCountryCodeActivity paramSelectCountryCodeActivity) {}
  
  public void a(int paramInt)
  {
    paramInt = SelectCountryCodeActivity.access$200(this.a).a(com.tencent.token.global.e.a[paramInt]);
    if (paramInt != -1) {
      SelectCountryCodeActivity.access$300(this.a).setSelection(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yu
 * JD-Core Version:    0.7.0.1
 */