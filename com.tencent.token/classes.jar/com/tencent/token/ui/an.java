package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;

final class an
  implements View.OnClickListener
{
  an(AppGuidActivity paramAppGuidActivity) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == 2131296434)
    {
      if (ax.a().e() == null)
      {
        this.a.setResult(263);
        this.a.finish();
        com.tencent.token.global.RqdApplication.f = true;
        return;
      }
      if (!ax.a().e().mIsBinded)
      {
        this.a.setResult(263);
        this.a.finish();
        com.tencent.token.global.RqdApplication.f = true;
        return;
      }
      if (ax.a().j())
      {
        paramView = new Intent(this.a, FaceRecognitionDefaultActivity.class);
        paramView.putExtra("fromsplash", true);
        this.a.startActivity(paramView);
      }
      for (;;)
      {
        this.a.finish();
        return;
        paramView = new Intent(this.a, FaceRecognitionCreateActivity.class);
        paramView.putExtra("fromsplash", true);
        this.a.startActivity(paramView);
      }
    }
    this.a.setResult(263);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.an
 * JD-Core Version:    0.7.0.1
 */