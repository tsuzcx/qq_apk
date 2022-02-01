import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Region.Op;
import dov.com.qq.im.aeeditor.view.ClipConstant.Anchor;
import dov.com.qq.im.aeeditor.view.EditorClipView;

public class axoj
{
  private static double dt = 1.0D;
  private float Em;
  private float En;
  private Matrix Q = new Matrix();
  private axoi jdField_a_of_type_Axoi = new axoi();
  private ClipConstant.Anchor jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor;
  private RectF bp = new RectF();
  private RectF bt = new RectF();
  private RectF bu = new RectF();
  private RectF bv = new RectF();
  public EditorClipView c;
  private boolean dvC;
  private boolean dvD = true;
  private boolean dvE;
  private Bitmap mImage;
  private float mRotate = 0.0F;
  
  public static void B(double paramDouble)
  {
    if (paramDouble > 0.0D) {
      dt = paramDouble;
    }
  }
  
  private void ai(float paramFloat1, float paramFloat2)
  {
    this.bp.set(0.0F, 0.0F, this.mImage.getWidth(), this.mImage.getHeight());
    this.bt.set(this.bp);
    this.jdField_a_of_type_Axoi.af(paramFloat1, paramFloat2);
    if (this.bt.isEmpty()) {}
    do
    {
      return;
      eNh();
      this.dvE = true;
      eNi();
    } while (this.c == null);
    this.c.eNn();
  }
  
  private void eNg()
  {
    this.dvE = false;
    ah(this.bv.width(), this.bv.height());
    this.jdField_a_of_type_Axoi.a(this.bt, cc());
  }
  
  private void eNh()
  {
    if (this.bt.isEmpty()) {
      return;
    }
    float f1 = this.bv.width() / this.bt.width();
    float f2 = (float)(this.bv.width() / dt) / this.bt.height();
    this.Q.setScale(f1, f2, this.bt.centerX(), this.bt.centerY());
    this.Q.postTranslate(this.bv.centerX() - this.bt.centerX(), this.bv.centerY() - this.bt.centerY());
    this.Q.mapRect(this.bt);
    f1 = Math.max(this.bt.width() / this.bp.width(), this.bt.height() / this.bp.height());
    this.Q.setScale(f1, f1, this.bp.centerX(), this.bp.centerY());
    this.Q.postTranslate(this.bv.centerX() - this.bp.centerX(), this.bv.centerY() - this.bp.centerY());
    this.Q.mapRect(this.bp);
  }
  
  private void eNi()
  {
    this.jdField_a_of_type_Axoi.a(this.bt, cc());
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
    RectF localRectF = this.jdField_a_of_type_Axoi.a(paramFloat1, paramFloat2);
    this.Q.setRotate(-getRotate(), this.bt.centerX(), this.bt.centerY());
    this.Q.mapRect(this.bt, localRectF);
    return new aylk(this.bt.centerX() - localRectF.centerX() + paramFloat1, this.bt.centerY() - localRectF.centerY() + paramFloat2, getScale(), getRotate());
  }
  
  public aylk a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Axoi.YF(false);
    if (this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor != null)
    {
      this.jdField_a_of_type_Axoi.a(this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor, paramFloat3, paramFloat4);
      RectF localRectF1 = new RectF();
      this.Q.setRotate(getRotate(), this.bt.centerX(), this.bt.centerY());
      this.Q.mapRect(localRectF1, this.bp);
      RectF localRectF2 = this.jdField_a_of_type_Axoi.a(paramFloat1, paramFloat2);
      aylk localaylk = new aylk(paramFloat1, paramFloat2, getScale(), cc());
      localaylk.b(ayku.b(localRectF2, localRectF1, this.bt.centerX(), this.bt.centerY()));
      return localaylk;
    }
    return null;
  }
  
  public void a(EditorClipView paramEditorClipView)
  {
    this.c = paramEditorClipView;
  }
  
  public boolean aPk()
  {
    return this.jdField_a_of_type_Axoi.aPh();
  }
  
  public void aes(int paramInt)
  {
    this.dvD = false;
    this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor = ClipConstant.Anchor.valueOf(paramInt);
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
      this.jdField_a_of_type_Axoi.af(paramFloat1, paramFloat2);
      return;
      this.Q.setTranslate(this.bv.centerX() - this.bt.centerX(), this.bv.centerY() - this.bt.centerY());
      this.Q.mapRect(this.bp);
      this.Q.mapRect(this.bt);
    }
  }
  
  public void aj(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor = null;
    }
  }
  
  public void ak(float paramFloat1, float paramFloat2)
  {
    this.dvD = true;
    aPk();
    this.jdField_a_of_type_Axoi.YF(true);
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
      this.jdField_a_of_type_Axoi.YC(false);
      this.jdField_a_of_type_Axoi.YD(true);
      this.jdField_a_of_type_Axoi.YE(false);
      return paramBoolean;
    }
  }
  
  public void bW(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Axoi.aPj()) {}
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
    this.jdField_a_of_type_Axoi.bt(paramFloat);
  }
  
  public aylk c(float paramFloat1, float paramFloat2)
  {
    aylk localaylk = new aylk(paramFloat1, paramFloat2, getScale(), cc());
    RectF localRectF1 = new RectF(this.jdField_a_of_type_Axoi.j());
    localRectF1.offset(paramFloat1, paramFloat2);
    if (this.jdField_a_of_type_Axoi.isResetting())
    {
      localRectF2 = new RectF();
      this.Q.setRotate(cc(), this.bt.centerX(), this.bt.centerY());
      this.Q.mapRect(localRectF2, this.bt);
      localaylk.b(ayku.a(localRectF1, localRectF2));
      return localaylk;
    }
    RectF localRectF2 = new RectF();
    if (this.jdField_a_of_type_Axoi.aPi())
    {
      this.Q.setRotate(cc() - getRotate(), this.bt.centerX(), this.bt.centerY());
      this.Q.mapRect(localRectF2, this.jdField_a_of_type_Axoi.a(paramFloat1, paramFloat2));
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
  
  public void d(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Axoi.onDraw(paramCanvas);
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
  
  public void eNk()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor = null;
    }
    this.dvD = true;
  }
  
  public void g(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.dvD = false;
    if (paramBoolean) {
      this.jdField_a_of_type_DovComQqImAeeditorViewClipConstant$Anchor = this.jdField_a_of_type_Axoi.a(paramFloat1, paramFloat2);
    }
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
  
  public void k(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    RectF localRectF = this.jdField_a_of_type_Axoi.a(paramInt1, paramInt2);
    paramCanvas.clipRect(this.bp.left, this.bp.top, this.bp.right, this.bp.bottom);
    paramCanvas.clipRect(localRectF, Region.Op.DIFFERENCE);
    paramCanvas.drawColor(-872415232);
  }
  
  public RectF l()
  {
    return this.bp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axoj
 * JD-Core Version:    0.7.0.1
 */