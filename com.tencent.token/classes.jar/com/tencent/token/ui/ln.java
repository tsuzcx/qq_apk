package com.tencent.token.ui;

import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;
import com.tencent.token.utils.x;

class ln
  implements TabHost.OnTabChangeListener
{
  ln(IndexActivity paramIndexActivity) {}
  
  public void onTabChanged(String paramString)
  {
    int i = IndexActivity.access$1400(this.a).getCurrentTab();
    if (i == 0) {
      if (IndexActivity.access$1600(this.a) != 2131492909) {
        x.a(this.a, IndexActivity.access$1600(this.a));
      }
    }
    for (;;)
    {
      IndexActivity.access$2600(this.a, i);
      IndexActivity.access$2700(this.a);
      IndexActivity.access$2000(this.a);
      return;
      paramString = do.a().e();
      if ((paramString != null) && (paramString.mIsZzb))
      {
        x.a(this.a, 2131492882);
      }
      else
      {
        x.a(this.a, 2131492875);
        continue;
        x.a(this.a, 2131492909);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ln
 * JD-Core Version:    0.7.0.1
 */