package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.a;
import com.tencent.token.utils.s;
import java.util.ArrayList;

final class zn
  implements View.OnClickListener
{
  zn(zm paramzm) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (((a)this.a.a.bannerlist.get(i)).b.startsWith("qmtoken://face"))
    {
      paramView = ax.a().e();
      if (paramView == null)
      {
        this.a.a.showUserDialog(9);
        return;
      }
      if (!paramView.mIsBinded)
      {
        this.a.a.showNoAccountTipDialog(this.a.a, 20, 1);
        return;
      }
      if (ax.a().j())
      {
        paramView = new Intent(this.a.a, FaceRecognitionDefaultActivity.class);
        this.a.a.startActivity(paramView);
        return;
      }
      paramView = new Intent(this.a.a, FaceRecognitionCreateActivity.class);
      this.a.a.startActivity(paramView);
      return;
    }
    s.a(this.a.a, ((a)this.a.a.bannerlist.get(i)).b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zn
 * JD-Core Version:    0.7.0.1
 */