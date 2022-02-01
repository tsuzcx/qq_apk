package dov.com.qq.im.ae.album.nocropper;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import awvs;
import awvt;
import awvu;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;

public class AECropperView
  extends FrameLayout
{
  private AECropperGridView jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperGridView;
  private a jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView$a;
  public AECropperImageView b;
  private boolean dsV;
  
  public AECropperView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public AECropperView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public AECropperView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private awvt a()
  {
    if (this.dsV) {
      return awvt.b();
    }
    awvs localawvs = this.b.a();
    if (localawvs != null) {
      return awvt.a(localawvs);
    }
    return awvt.c();
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.b = new AECropperImageView(paramContext, paramAttributeSet);
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperGridView = new AECropperGridView(paramContext, paramAttributeSet);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, 0);
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      paramAttributeSet.width = 0;
      paramAttributeSet.height = -1;
    }
    addView(this.b, 0, paramAttributeSet);
    addView(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperGridView, 1, paramAttributeSet);
    this.b.setGestureCallback(new b(null));
  }
  
  public int QF()
  {
    if (this.b == null) {
      return 1;
    }
    return this.b.QF();
  }
  
  @Nullable
  public EditorPicInfo a(@NonNull EditorPicInfo paramEditorPicInfo)
  {
    awvt localawvt = a();
    if ((localawvt.jdField_a_of_type_Awvu != awvu.c) || (localawvt.jdField_a_of_type_Awvs == null)) {
      return null;
    }
    int i = getImageWidth();
    int j = getImageHeight();
    paramEditorPicInfo.x = (localawvt.jdField_a_of_type_Awvs.x * 1.0D / i);
    paramEditorPicInfo.y = (localawvt.jdField_a_of_type_Awvs.y * 1.0D / j);
    paramEditorPicInfo.w = (localawvt.jdField_a_of_type_Awvs.width * 1.0D / i);
    paramEditorPicInfo.h = (localawvt.jdField_a_of_type_Awvs.height * 1.0D / j);
    return paramEditorPicInfo;
  }
  
  public float bY()
  {
    if (this.b == null) {
      return 0.0F;
    }
    return this.b.bX();
  }
  
  public float bh()
  {
    if (this.b == null) {
      return 0.0F;
    }
    return this.b.bh();
  }
  
  public void eGA()
  {
    if (this.b != null) {
      this.b.eGA();
    }
  }
  
  public int getImageHeight()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.getImageHeight();
  }
  
  public Matrix getImageMatrix()
  {
    if (this.b == null) {
      return new Matrix();
    }
    return new Matrix(this.b.getImageMatrix());
  }
  
  public int getImageWidth()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.getImageWidth();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getContext().getResources().getConfiguration().orientation;
    if ((i == 1) || (i == 0))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt1);
  }
  
  public void setAnimateCallback(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.b != null) {
      this.b.animatorListener = paramAnimatorListener;
    }
  }
  
  public void setDebug(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.setDEBUG(paramBoolean);
    }
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.setGestureEnabled(paramBoolean);
    }
  }
  
  public void setGridCallback(a parama)
  {
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView$a = parama;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.b != null) {
      this.b.setImageBitmap(paramBitmap);
    }
  }
  
  public void setImageMatrix(@NonNull Matrix paramMatrix)
  {
    if (this.b != null) {
      this.b.setImageMatrix(paramMatrix);
    }
  }
  
  public void setMakeSquare(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.setMakeSquare(paramBoolean);
    }
  }
  
  public void setMaxZoom(float paramFloat)
  {
    if (this.b != null) {
      this.b.setMaxZoom(paramFloat);
    }
  }
  
  public void setMinZoom(float paramFloat)
  {
    if (this.b != null) {
      this.b.setMinZoom(paramFloat);
    }
  }
  
  public void setPaddingColor(int paramInt)
  {
    if (this.b != null) {
      this.b.setPaddingColor(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean aNS();
    
    public abstract boolean aNT();
  }
  
  class b
    implements AECropperImageView.a
  {
    private b() {}
    
    public void eGE()
    {
      boolean bool = true;
      AECropperView.a(AECropperView.this, true);
      AECropperGridView localAECropperGridView;
      if (AECropperView.a(AECropperView.this) != null)
      {
        localAECropperGridView = AECropperView.a(AECropperView.this);
        if (((AECropperView.a(AECropperView.this) != null) && (!AECropperView.a(AECropperView.this).aNS())) || (AECropperView.this.b == null) || (!AECropperView.this.b.aNR())) {
          break label83;
        }
      }
      for (;;)
      {
        localAECropperGridView.setShowGrid(bool);
        return;
        label83:
        bool = false;
      }
    }
    
    public void eGF()
    {
      boolean bool2 = false;
      AECropperView.a(AECropperView.this, false);
      if (AECropperView.a(AECropperView.this) != null)
      {
        AECropperGridView localAECropperGridView = AECropperView.a(AECropperView.this);
        boolean bool1 = bool2;
        if (AECropperView.a(AECropperView.this) != null)
        {
          bool1 = bool2;
          if (AECropperView.a(AECropperView.this).aNT()) {
            bool1 = true;
          }
        }
        localAECropperGridView.setShowGrid(bool1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.nocropper.AECropperView
 * JD-Core Version:    0.7.0.1
 */