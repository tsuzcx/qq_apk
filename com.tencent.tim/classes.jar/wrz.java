import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class wrz
{
  private wro jdField_a_of_type_Wro = new wro();
  private wrx jdField_a_of_type_Wrx = new wrx();
  private wsa jdField_a_of_type_Wsa;
  
  public wrz(wro paramwro, int paramInt1, List<wrx.a> paramList, int paramInt2)
  {
    if (paramwro == null) {
      return;
    }
    this.jdField_a_of_type_Wro.a(paramwro);
    this.jdField_a_of_type_Wrx.setColor(paramInt1);
    this.jdField_a_of_type_Wrx.setTextureID(paramInt2);
    this.jdField_a_of_type_Wrx.gh(paramList);
  }
  
  public wrz(wrz paramwrz)
  {
    this.jdField_a_of_type_Wrx.b(paramwrz.a());
  }
  
  public void H(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Wsa != null) {
      this.jdField_a_of_type_Wsa.d(paramFloat1, paramFloat2, this.jdField_a_of_type_Wro.aI(), 0L);
    }
    this.jdField_a_of_type_Wrx.cbs();
    this.jdField_a_of_type_Wrx.b(paramFloat1, paramFloat2, this.jdField_a_of_type_Wro.aI(), 0L);
  }
  
  public wrx a()
  {
    return this.jdField_a_of_type_Wrx;
  }
  
  public wsa a()
  {
    if (this.jdField_a_of_type_Wsa != null)
    {
      this.jdField_a_of_type_Wsa.reset();
      this.jdField_a_of_type_Wsa.setColor(this.jdField_a_of_type_Wrx.getColor());
      this.jdField_a_of_type_Wsa.setTexture(this.jdField_a_of_type_Wrx.getTextureID());
    }
    for (;;)
    {
      return this.jdField_a_of_type_Wsa;
      Rect localRect = this.jdField_a_of_type_Wro.k();
      this.jdField_a_of_type_Wsa = new wsa(this.jdField_a_of_type_Wrx, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Wsa != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_Wsa.C(0, 0, i, j);
      }
      this.jdField_a_of_type_Wsa.draw(paramCanvas);
    }
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Wsa != null) {
      return this.jdField_a_of_type_Wsa.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public void aD(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wsa != null) {
      this.jdField_a_of_type_Wsa.aD(paramBoolean);
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_Wro.aI();
    wrx.a locala = this.jdField_a_of_type_Wrx.b();
    long l;
    if (locala != null)
    {
      l = paramLong - locala.getTime();
      if (l <= 0L) {
        f = locala.getWidth();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Wsa != null) {
        this.jdField_a_of_type_Wsa.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_Wrx.b(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_Wro.a(l, locala.getX(), locala.getY(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_Wsa = null;
    }
  }
  
  public int getSegmentCount()
  {
    if (this.jdField_a_of_type_Wsa == null) {
      return 0;
    }
    return this.jdField_a_of_type_Wsa.getSegmentCount();
  }
  
  public boolean init()
  {
    if (this.jdField_a_of_type_Wrx == null) {
      return false;
    }
    a();
    return true;
  }
  
  public void unInit()
  {
    if (this.jdField_a_of_type_Wsa != null) {
      this.jdField_a_of_type_Wsa.setTexture(-1);
    }
  }
  
  public int wc()
  {
    if (this.jdField_a_of_type_Wrx == null) {
      return 0;
    }
    return this.jdField_a_of_type_Wrx.wa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrz
 * JD-Core Version:    0.7.0.1
 */