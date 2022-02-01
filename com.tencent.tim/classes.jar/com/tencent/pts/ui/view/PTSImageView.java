package com.tencent.pts.ui.view;

import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeImage;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;

public class PTSImageView
  extends ImageView
  implements IView
{
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
  
  public PTSImageView(PTSNodeImage paramPTSNodeImage)
  {
    super(paramPTSNodeImage.getContext());
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mRoundedCorner.getSaveCount(paramCanvas);
    this.mRoundedCorner.clipPath(paramCanvas);
    super.draw(paramCanvas);
    this.mRoundedCorner.drawCorner(paramCanvas, i);
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mRoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSImageView
 * JD-Core Version:    0.7.0.1
 */