package com.tencent.pts.ui.view;

import android.graphics.Canvas;
import android.widget.FrameLayout;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeContainer;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;

public class PTSContainerView
  extends FrameLayout
  implements IView
{
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
  
  public PTSContainerView(PTSNodeContainer paramPTSNodeContainer)
  {
    super(paramPTSNodeContainer.getContext());
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mRoundedCorner.getSaveCount(paramCanvas);
    super.draw(paramCanvas);
    this.mRoundedCorner.drawCorner(paramCanvas, i);
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mRoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSContainerView
 * JD-Core Version:    0.7.0.1
 */