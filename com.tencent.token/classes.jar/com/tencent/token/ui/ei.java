package com.tencent.token.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.ds;
import com.tencent.token.ga;
import com.tencent.token.global.c;
import com.tencent.token.global.h;
import java.util.List;

class ei
  implements AdapterView.OnItemClickListener
{
  ei(EnvirChangeListviewActivity paramEnvirChangeListviewActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    EnvirChangeListviewActivity.access$000(this.a).a(paramInt);
    paramAdapterView = (com.tencent.token.core.bean.b)this.a.envirDataList.get(paramInt);
    Toast.makeText(this.a.getApplicationContext(), paramAdapterView.b(), 0).show();
    c.a(paramInt);
    paramAdapterView = cx.c();
    paramAdapterView.e();
    paramAdapterView.d();
    ga.b();
    cx.c();
    paramAdapterView = do.a();
    cv.a().c();
    paramAdapterView.b();
    paramInt = c.a();
    paramAdapterView = do.a();
    if (paramInt == 0) {
      do.c = do.d;
    }
    for (;;)
    {
      h.c("sessionId : " + do.c);
      h.c("UserAgent.isInit():---" + paramAdapterView.p());
      cy.b();
      com.tencent.token.core.push.b.b();
      AccountPageActivity.mNeedRefreshEval = true;
      ds.b();
      this.a.finish();
      return;
      if (1 == paramInt) {
        do.c = do.e;
      } else if (2 == paramInt) {
        do.c = do.f;
      } else if (3 == paramInt) {
        do.c = do.g;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ei
 * JD-Core Version:    0.7.0.1
 */