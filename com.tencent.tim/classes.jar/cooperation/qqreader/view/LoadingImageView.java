package cooperation.qqreader.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import avoh;

public class LoadingImageView
  extends ImageView
{
  private boolean dbQ;
  private Drawable mDrawable = avoh.t("https://qzonestyle.gtimg.cn/aoi/sola/20191212143823_h3cZSvL8ed.png");
  private int mHeight;
  private boolean mInit;
  private int mWidth;
  private float yC;
  
  public LoadingImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LoadingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundDrawable(this.mDrawable);
    invalidate();
  }
  
  private void eBq()
  {
    if (!this.mInit)
    {
      this.mInit = true;
      this.mWidth = getMeasuredWidth();
      this.mHeight = getMeasuredHeight();
    }
  }
  
  public void eBr()
  {
    if (!this.dbQ)
    {
      this.dbQ = true;
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    eBq();
    paramCanvas.save();
    paramCanvas.rotate(this.yC, this.mWidth / 2.0F, this.mHeight / 2.0F);
    this.mDrawable.draw(paramCanvas);
    super.onDraw(paramCanvas);
    paramCanvas.restore();
    if (this.dbQ)
    {
      this.yC = ((this.yC + 5.0F) % 360.0F);
      postDelayed(new LoadingImageView.1(this), 30L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.view.LoadingImageView
 * JD-Core Version:    0.7.0.1
 */