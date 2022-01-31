package com.tencent.token.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.token.ae;
import com.tencent.token.ag;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.bb;
import com.tencent.token.core.bean.c;
import com.tencent.token.core.push.a;
import com.tencent.token.gl;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import java.util.List;

final class dn
  implements AdapterView.OnItemClickListener
{
  dn(EnvirChangeListviewActivity paramEnvirChangeListviewActivity) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    EnvirChangeListviewActivity.access$000(this.a).a(paramInt);
    paramAdapterView = (c)this.a.envirDataList.get(paramInt);
    Toast.makeText(this.a.getApplicationContext(), paramAdapterView.b(), 0).show();
    b.a(paramInt);
    ag.c().e();
    ag.d();
    gl.b();
    ag.c();
    ax.a();
    ae.a();
    ax.a().m();
    ax.b();
    paramInt = b.a();
    paramAdapterView = ax.a();
    if (paramInt == 0) {
      ax.c = ax.d;
    }
    for (;;)
    {
      e.c("sessionId : " + ax.c);
      e.c("UserAgent.isInit():---" + paramAdapterView.p());
      paramAdapterView.d();
      ah.b();
      a.b();
      AccountPageActivity.mNeedRefreshEval = true;
      bb.b();
      this.a.finish();
      return;
      if (1 == paramInt) {
        ax.c = ax.e;
      } else if (2 == paramInt) {
        ax.c = ax.f;
      } else if (3 == paramInt) {
        ax.c = ax.g;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dn
 * JD-Core Version:    0.7.0.1
 */