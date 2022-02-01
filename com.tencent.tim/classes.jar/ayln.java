import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Region.Op;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.Clip.ClipConstant.Anchor;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView;

public class ayln
{
  private float Em;
  private float En;
  private Matrix Q = new Matrix();
  private aykv jdField_a_of_type_Aykv = new aykv();
  private ClipConstant.Anchor jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor;
  public CropNewView b;
  private RectF bp = new RectF();
  private RectF bt = new RectF();
  private RectF bu = new RectF();
  private RectF bv = new RectF();
  private boolean dvC;
  private boolean dvD = true;
  private boolean dvE;
  private boolean dzK;
  private Bitmap mImage;
  private float mRotate = 0.0F;
  
  private void ai(float paramFloat1, float paramFloat2)
  {
    this.bp.set(0.0F, 0.0F, this.mImage.getWidth(), this.mImage.getHeight());
    this.bt.set(this.bp);
    this.jdField_a_of_type_Aykv.af(paramFloat1, paramFloat2);
    if (this.bt.isEmpty()) {}
    do
    {
      return;
      eNh();
      this.dvE = true;
      eNi();
    } while (this.b == null);
    this.b.eNn();
  }
  
  private void eNg()
  {
    this.dvE = false;
    ah(this.bv.width(), this.bv.height());
    this.jdField_a_of_type_Aykv.a(this.bt, cc());
  }
  
  private void eNh()
  {
    if (this.bt.isEmpty()) {
      return;
    }
    float f = Math.min(this.bv.width() / this.bt.width(), this.bv.height() / this.bt.height());
    this.Q.setScale(f, f, this.bt.centerX(), this.bt.centerY());
    this.Q.postTranslate(this.bv.centerX() - this.bt.centerX(), this.bv.centerY() - this.bt.centerY());
    this.Q.mapRect(this.bp);
    this.Q.mapRect(this.bt);
  }
  
  private void eNi()
  {
    this.jdField_a_of_type_Aykv.a(this.bt, cc());
  }
  
  public void YE(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aykv.YE(paramBoolean);
  }
  
  public void YG(boolean paramBoolean)
  {
    this.dvC = false;
  }
  
  public void YH(boolean paramBoolean)
  {
    this.dvC = true;
  }
  
  public aylk a(float paramFloat1, float paramFloat2)
  {
    RectF localRectF = this.jdField_a_of_type_Aykv.a(paramFloat1, paramFloat2);
    this.Q.setRotate(-getRotate(), this.bt.centerX(), this.bt.centerY());
    this.Q.mapRect(this.bt, localRectF);
    return new aylk(this.bt.centerX() - localRectF.centerX() + paramFloat1, this.bt.centerY() - localRectF.centerY() + paramFloat2, getScale(), getRotate());
  }
  
  public aylk a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Aykv.YF(false);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor != null)
    {
      this.jdField_a_of_type_Aykv.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor, paramFloat3, paramFloat4);
      RectF localRectF1 = new RectF();
      this.Q.setRotate(getRotate(), this.bt.centerX(), this.bt.centerY());
      this.Q.mapRect(localRectF1, this.bp);
      RectF localRectF2 = this.jdField_a_of_type_Aykv.a(paramFloat1, paramFloat2);
      aylk localaylk = new aylk(paramFloat1, paramFloat2, getScale(), cc());
      localaylk.b(ayku.b(localRectF2, localRectF1, this.bt.centerX(), this.bt.centerY()));
      return localaylk;
    }
    return null;
  }
  
  public void a(CropNewView paramCropNewView)
  {
    this.b = paramCropNewView;
  }
  
  public boolean aPk()
  {
    return this.jdField_a_of_type_Aykv.aPh();
  }
  
  public void ah(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == 0.0F) || (paramFloat2 == 0.0F)) {
      return;
    }
    this.bv.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    if (!this.dvE) {
      ai(paramFloat1, paramFloat2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aykv.af(paramFloat1, paramFloat2);
      return;
      this.Q.setTranslate(this.bv.centerX() - this.bt.centerX(), this.bv.centerY() - this.bt.centerY());
      this.Q.mapRect(this.bp);
      this.Q.mapRect(this.bt);
    }
  }
  
  public void aj(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor = null;
    }
  }
  
  public void ak(float paramFloat1, float paramFloat2)
  {
    this.dvD = true;
    aPk();
    this.jdField_a_of_type_Aykv.YF(true);
  }
  
  public void al(float paramFloat1, float paramFloat2)
  {
    this.dvD = false;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiClipClipConstant$Anchor = this.jdField_a_of_type_Aykv.a(paramFloat1, paramFloat2);
  }
  
  public aylk b(float paramFloat1, float paramFloat2)
  {
    return new aylk(paramFloat1, paramFloat2, getScale(), getRotate());
  }
  
  public boolean b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!this.dvC) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Aykv.YC(false);
      this.jdField_a_of_type_Aykv.YD(true);
      this.jdField_a_of_type_Aykv.YE(false);
      return paramBoolean;
    }
  }
  
  public void bW(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Aykv.aPj()) {}
    for (RectF localRectF = this.bp;; localRectF = this.bt)
    {
      paramCanvas.clipRect(localRectF);
      paramCanvas.drawBitmap(this.mImage, null, this.bp, null);
      return;
    }
  }
  
  public void bu(float paramFloat)
  {
    this.En = paramFloat;
  }
  
  public void bv(float paramFloat)
  {
    this.jdField_a_of_type_Aykv.bt(paramFloat);
  }
  
  public aylk c(float paramFloat1, float paramFloat2)
  {
    aylk localaylk = new aylk(paramFloat1, paramFloat2, getScale(), cc());
    RectF localRectF1 = new RectF(this.jdField_a_of_type_Aykv.j());
    localRectF1.offset(paramFloat1, paramFloat2);
    if (this.jdField_a_of_type_Aykv.isResetting())
    {
      localRectF2 = new RectF();
      this.Q.setRotate(cc(), this.bt.centerX(), this.bt.centerY());
      this.Q.mapRect(localRectF2, this.bt);
      localaylk.b(ayku.a(localRectF1, localRectF2));
      return localaylk;
    }
    RectF localRectF2 = new RectF();
    if (this.jdField_a_of_type_Aykv.aPi())
    {
      this.Q.setRotate(cc() - getRotate(), this.bt.centerX(), this.bt.centerY());
      this.Q.mapRect(localRectF2, this.jdField_a_of_type_Aykv.a(paramFloat1, paramFloat2));
      localaylk.b(ayku.a(localRectF1, localRectF2, this.bt.centerX(), this.bt.centerY()));
      return localaylk;
    }
    this.Q.setRotate(cc(), this.bt.centerX(), this.bt.centerY());
    this.Q.mapRect(localRectF2, this.bp);
    localaylk.b(ayku.b(localRectF1, localRectF2, this.bt.centerX(), this.bt.centerY()));
    return localaylk;
  }
  
  public float cc()
  {
    return this.En;
  }
  
  public void ch(Canvas paramCanvas)
  {
    if (this.dvD)
    {
      paramCanvas.clipRect(this.bp.left, this.bp.top, this.bp.right, this.bp.bottom);
      paramCanvas.clipRect(this.bt, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(-872415232);
    }
  }
  
  public void d(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Aykv.onDraw(paramCanvas);
  }
  
  public void dbE() {}
  
  public void eNf()
  {
    this.Em = getRotate();
    this.bu.set(this.bt);
    float f = 1.0F / getScale();
    this.Q.setTranslate(-this.bp.left, -this.bp.top);
    this.Q.postScale(f, f);
    this.Q.mapRect(this.bu);
  }
  
  public void eNj() {}
  
  public void eSv()
  {
    this.Q.setScale(getScale(), getScale());
    this.Q.postTranslate(this.bp.left, this.bp.top);
    this.Q.mapRect(this.bt, this.bu);
    bu(this.Em);
    this.dzK = true;
  }
  
  public void eSw()
  {
    bu(getRotate() - getRotate() % 360.0F);
    this.bt.set(this.bp);
    this.jdField_a_of_type_Aykv.a(this.bt, cc());
  }
  
  public float getRotate()
  {
    return this.mRotate;
  }
  
  public float getScale()
  {
    return 1.0F * this.bp.width() / this.mImage.getWidth();
  }
  
  public RectF k()
  {
    return this.bt;
  }
  
  public void onScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 == 1.0F) {
      return;
    }
    float f = paramFloat1;
    if (Math.min(this.bt.width(), this.bt.height()) <= 500.0F) {
      f = paramFloat1 + (1.0F - paramFloat1) / 2.0F;
    }
    this.Q.setScale(f, f, paramFloat2, paramFloat3);
    this.Q.mapRect(this.bp);
    this.Q.mapRect(this.bt);
  }
  
  public void rotate(int paramInt)
  {
    this.En = (Math.round((this.mRotate + paramInt) / 90.0F) * 90 % 360);
    this.jdField_a_of_type_Aykv.a(this.bt, cc());
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return;
    }
    this.mImage = paramBitmap;
    setRotate(0.0F);
    bu(0.0F);
    eNg();
  }
  
  public void setRotate(float paramFloat)
  {
    this.mRotate = paramFloat;
  }
  
  public void setScale(float paramFloat)
  {
    setScale(paramFloat, this.bt.centerX(), this.bt.centerY());
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    onScale(paramFloat1 / getScale(), paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayln
 * JD-Core Version:    0.7.0.1
 */