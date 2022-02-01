package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.token.ez;
import com.tencent.token.gd;
import com.tencent.token.ii;
import com.tencent.token.im;
import com.tencent.token.jf;

public class AppCompatImageView
  extends ImageView
  implements ez, gd
{
  private final ii a = new ii(this);
  private final im b;
  
  public AppCompatImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(jf.a(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new im(this);
    this.b.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.a;
    if (localObject != null) {
      ((ii)localObject).d();
    }
    localObject = this.b;
    if (localObject != null) {
      ((im)localObject).d();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    ii localii = this.a;
    if (localii != null) {
      return localii.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    ii localii = this.a;
    if (localii != null) {
      return localii.c();
    }
    return null;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    im localim = this.b;
    if (localim != null) {
      return localim.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    im localim = this.b;
    if (localim != null) {
      return localim.c();
    }
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    return (this.b.a()) && (super.hasOverlappingRendering());
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    ii localii = this.a;
    if (localii != null) {
      localii.a(paramInt);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    paramBitmap = this.b;
    if (paramBitmap != null) {
      paramBitmap.d();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.b;
    if (paramDrawable != null) {
      paramDrawable.d();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    im localim = this.b;
    if (localim != null) {
      localim.a(paramInt);
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = this.b;
    if (paramUri != null) {
      paramUri.d();
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    ii localii = this.a;
    if (localii != null) {
      localii.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    ii localii = this.a;
    if (localii != null) {
      localii.a(paramMode);
    }
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    im localim = this.b;
    if (localim != null) {
      localim.a(paramColorStateList);
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    im localim = this.b;
    if (localim != null) {
      localim.a(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatImageView
 * JD-Core Version:    0.7.0.1
 */