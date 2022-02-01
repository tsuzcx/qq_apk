import android.graphics.Bitmap;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;

public class anza
  extends anyz
  implements anxy<SpriteNativeView>
{
  private Bitmap mBitmap;
  protected ImageView mImageView;
  
  public anza(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
    this.mImageView = y();
  }
  
  public void a(SpriteNativeView paramSpriteNativeView, Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    paramSpriteNativeView = new FrameLayout.LayoutParams(this.mBitmap.getWidth(), this.mBitmap.getHeight());
    this.mImageView.setImageBitmap(this.mBitmap);
    this.mImageView.setLayoutParams(paramSpriteNativeView);
    this.mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.mImageView.setPivotX(this.mBitmap.getWidth() / 2);
    this.mImageView.setPivotY(this.mBitmap.getHeight() / 2);
  }
  
  public boolean azq()
  {
    if (this.mImageView.getVisibility() != 0) {
      this.mImageView.setVisibility(0);
    }
    boolean bool = super.azq();
    if (this.mBitmap != null)
    {
      a(this.b);
      float f1 = this.b.x;
      float f2 = bv();
      float f3 = this.mBitmap.getWidth() / 2;
      float f4 = this.mViewHeight;
      float f5 = this.b.y;
      float f6 = bv();
      float f7 = this.mBitmap.getHeight() / 2;
      this.mImageView.setX(f1 * f2 - f3);
      this.mImageView.setY(f4 - f5 * f6 - f7);
    }
    this.mImageView.setScaleX(this.scale * bv());
    this.mImageView.setScaleY(this.scale * bv());
    this.mImageView.setRotation(this.rotate);
    this.mImageView.setAlpha(this.opacity * (Ky() / 255.0F) / 255.0F);
    return bool;
  }
  
  public void onAdded()
  {
    this.a.addView(this.mImageView);
    this.mImageView.setVisibility(4);
  }
  
  protected ImageView y()
  {
    return new ImageView(this.a.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anza
 * JD-Core Version:    0.7.0.1
 */