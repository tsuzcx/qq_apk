package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.tencent.token.fn;
import com.tencent.token.gr;
import com.tencent.token.hg.a;
import com.tencent.token.iw;
import com.tencent.token.ja;
import com.tencent.token.jt;

public class AppCompatImageButton
  extends ImageButton
  implements fn, gr
{
  private final iw a = new iw(this);
  private final ja b;
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, hg.a.imageButtonStyle);
  }
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(jt.a(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new ja(this);
    this.b.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.a;
    if (localObject != null) {
      ((iw)localObject).d();
    }
    localObject = this.b;
    if (localObject != null) {
      ((ja)localObject).d();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    iw localiw = this.a;
    if (localiw != null) {
      return localiw.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    iw localiw = this.a;
    if (localiw != null) {
      return localiw.c();
    }
    return null;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    ja localja = this.b;
    if (localja != null) {
      return localja.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    ja localja = this.b;
    if (localja != null) {
      return localja.c();
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
    iw localiw = this.a;
    if (localiw != null) {
      localiw.a(paramInt);
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
    this.b.a(paramInt);
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
    iw localiw = this.a;
    if (localiw != null) {
      localiw.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    iw localiw = this.a;
    if (localiw != null) {
      localiw.a(paramMode);
    }
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    ja localja = this.b;
    if (localja != null) {
      localja.a(paramColorStateList);
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    ja localja = this.b;
    if (localja != null) {
      localja.a(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatImageButton
 * JD-Core Version:    0.7.0.1
 */