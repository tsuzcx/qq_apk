package com.tencent.mobileqq.triton.render;

import android.app.Activity;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.triton.engine.TTLog;

public class a
  extends RelativeLayout
{
  public a(Activity paramActivity, RenderContext paramRenderContext)
  {
    super(paramActivity);
    paramActivity = new b(paramActivity, paramRenderContext, paramRenderContext.e());
    paramActivity.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(paramActivity);
    TTLog.b("GameGlobalView", "new GameGlobalView:" + this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.a
 * JD-Core Version:    0.7.0.1
 */