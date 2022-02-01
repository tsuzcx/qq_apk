import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.qphone.base.util.QLog;

public class lsr
  extends ImageBase
{
  private Drawable GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private Drawable TRANSPARENT_PLACE_HOLDER = new ColorDrawable(0);
  protected NativeReadInjoyImageView l;
  
  public lsr(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.l = new NativeReadInjoyImageView(paramVafContext.getContext());
  }
  
  private boolean CG()
  {
    if (this.mSrc == null) {}
    int i;
    int j;
    do
    {
      return false;
      i = this.l.getComMeasuredWidth();
      j = this.l.getComMeasuredHeight();
    } while ((i <= 0) || (j <= 0));
    this.mSrc = kxm.c(this.mSrc, i, j);
    return true;
  }
  
  public int getComMeasuredHeight()
  {
    return this.l.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.l.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.l;
  }
  
  public void loadImage(String paramString)
  {
    QLog.d("ReadInjoyImageView", 2, "loadImage: path is " + paramString);
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label84;
      }
      this.l.setImagePlaceHolder(this.GRAY_PLACEHOLDER);
      if (CG()) {
        this.l.setImageSrc(paramString);
      }
    }
    return;
    label84:
    paramString = ImageCommon.getDrawableResourceId(paramString);
    if (paramString != null)
    {
      QLog.d("ReadInjoyImageView", 2, "loadImage: cant find in offline dir, try to load from resources");
      try
      {
        paramString = this.l.getResources().getDrawable(paramString.intValue());
        this.l.setImageDrawable(paramString);
        return;
      }
      catch (Resources.NotFoundException paramString)
      {
        QLog.d("ReadInjoyImageView", 2, "loadImage: cant find in resources dir, do nothing");
        return;
      }
    }
    this.l.setImageSrc("");
    this.l.setImagePlaceHolder(this.GRAY_PLACEHOLDER);
  }
  
  public void onComDraw(Canvas paramCanvas)
  {
    if ((this.mSrc != null) && (!this.mSrc.equals(this.l.getPath())))
    {
      CG();
      this.l.setImageSrc(this.mSrc);
    }
    super.onComDraw(paramCanvas);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.l.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.l.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.l.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.l.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(this.mScaleType, ImageView.ScaleType.CENTER_CROP));
    this.l.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    loadImage(this.mSrc);
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.l.setImageSrc(null);
    this.mSrc = null;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.l.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    this.l.setImageDrawable(paramDrawable);
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lsr(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsr
 * JD-Core Version:    0.7.0.1
 */