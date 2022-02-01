import android.view.MotionEvent;

public class aqod
{
  protected aqod.a a;
  private aqod.b a;
  protected aqod.c a;
  protected boolean cUQ;
  protected boolean cUR;
  protected boolean cUS = true;
  protected boolean mIsDragging;
  protected float mOffsetX;
  protected float mOffsetY;
  
  public aqod(aqod.a parama, aqod.c paramc, boolean paramBoolean)
  {
    if ((parama != null) && (paramc != null))
    {
      this.jdField_a_of_type_Aqod$a = parama;
      this.jdField_a_of_type_Aqod$c = paramc;
      return;
    }
    throw new IllegalArgumentException("DragSource and DropTarget shouldn't be null!");
  }
  
  public void Y(float paramFloat1, float paramFloat2)
  {
    this.mOffsetX = paramFloat1;
    this.mOffsetY = paramFloat2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f2;
    float f1;
    if (this.cUQ)
    {
      f2 = paramMotionEvent.getRawX();
      f1 = paramMotionEvent.getRawY();
      f2 += this.mOffsetX;
      f1 += this.mOffsetY;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    label258:
    do
    {
      do
      {
        do
        {
          return false;
          f2 = paramMotionEvent.getX();
          f1 = paramMotionEvent.getY();
          break;
          this.jdField_a_of_type_Aqod$b = this.jdField_a_of_type_Aqod$a.a(f2, f1);
        } while (this.jdField_a_of_type_Aqod$b == null);
        if ((this.jdField_a_of_type_Aqod$a.a(this.jdField_a_of_type_Aqod$b, f2, f1)) && (this.jdField_a_of_type_Aqod$b.a(this.jdField_a_of_type_Aqod$a, f2, f1))) {
          this.mIsDragging = true;
        }
        return true;
      } while (!this.mIsDragging);
      this.jdField_a_of_type_Aqod$a.a(this.jdField_a_of_type_Aqod$b, f2, f1);
      this.jdField_a_of_type_Aqod$b.a(this.jdField_a_of_type_Aqod$a, f2, f1);
      if (this.cUS)
      {
        if (!this.jdField_a_of_type_Aqod$c.M(f2, f1)) {
          break label258;
        }
        if (!this.cUR)
        {
          this.cUR = true;
          this.cUS = this.jdField_a_of_type_Aqod$c.b(this.jdField_a_of_type_Aqod$a, this.jdField_a_of_type_Aqod$b, f2, f1);
        }
        this.jdField_a_of_type_Aqod$c.b(this.jdField_a_of_type_Aqod$a, this.jdField_a_of_type_Aqod$b, f2, f1);
      }
      for (;;)
      {
        return true;
        if (this.cUR)
        {
          this.cUR = false;
          this.jdField_a_of_type_Aqod$c.a(this.jdField_a_of_type_Aqod$a, this.jdField_a_of_type_Aqod$b, f2, f1);
        }
      }
    } while (!this.mIsDragging);
    if ((this.jdField_a_of_type_Aqod$c.M(f2, f1)) && (this.jdField_a_of_type_Aqod$c.a(this.jdField_a_of_type_Aqod$a, this.jdField_a_of_type_Aqod$b, f2, f1)))
    {
      this.jdField_a_of_type_Aqod$a.a(this.jdField_a_of_type_Aqod$c, this.jdField_a_of_type_Aqod$b, f2, f1);
      this.jdField_a_of_type_Aqod$b.a(this.jdField_a_of_type_Aqod$a, this.jdField_a_of_type_Aqod$c, f2, f1);
    }
    for (;;)
    {
      this.mIsDragging = false;
      this.cUR = false;
      this.cUS = true;
      return true;
      this.jdField_a_of_type_Aqod$a.a(null, this.jdField_a_of_type_Aqod$b, f2, f1);
      this.jdField_a_of_type_Aqod$b.a(this.jdField_a_of_type_Aqod$a, null, f2, f1);
    }
  }
  
  public static abstract interface a
  {
    public abstract aqod.b a(float paramFloat1, float paramFloat2);
    
    public abstract void a(aqod.b paramb, float paramFloat1, float paramFloat2);
    
    public abstract void a(aqod.c paramc, aqod.b paramb, float paramFloat1, float paramFloat2);
    
    public abstract boolean a(aqod.b paramb, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface b
  {
    public abstract void a(aqod.a parama, float paramFloat1, float paramFloat2);
    
    public abstract void a(aqod.a parama, aqod.c paramc, float paramFloat1, float paramFloat2);
    
    public abstract boolean a(aqod.a parama, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface c
  {
    public abstract boolean M(float paramFloat1, float paramFloat2);
    
    public abstract void a(aqod.a parama, aqod.b paramb, float paramFloat1, float paramFloat2);
    
    public abstract boolean a(aqod.a parama, aqod.b paramb, float paramFloat1, float paramFloat2);
    
    public abstract void b(aqod.a parama, aqod.b paramb, float paramFloat1, float paramFloat2);
    
    public abstract boolean b(aqod.a parama, aqod.b paramb, float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqod
 * JD-Core Version:    0.7.0.1
 */