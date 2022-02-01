import com.tencent.aekit.openrender.internal.Frame;

public class axfl
{
  private axde jdField_a_of_type_Axde = new axde();
  private axfl.a jdField_a_of_type_Axfl$a;
  private boolean dug = true;
  private Frame k = new Frame();
  private int surfaceHeight;
  private int surfaceWidth;
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2)
  {
    Frame localFrame = paramFrame;
    if (this.dug)
    {
      this.jdField_a_of_type_Axde.a(paramFrame, paramInt1, paramInt2, this.k);
      localFrame = this.k;
    }
    if (this.jdField_a_of_type_Axfl$a != null) {
      this.jdField_a_of_type_Axfl$a.a(localFrame);
    }
    return localFrame;
  }
  
  public void clear()
  {
    this.jdField_a_of_type_Axde.ClearGLSL();
    this.k.clear();
    if (this.jdField_a_of_type_Axfl$a != null) {
      this.jdField_a_of_type_Axfl$a.apk();
    }
  }
  
  public void initial()
  {
    this.jdField_a_of_type_Axde.apply();
    if (this.jdField_a_of_type_Axfl$a != null) {
      this.jdField_a_of_type_Axfl$a.onInit();
    }
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
  }
  
  public void setFrameRenderCallback(axfl.a parama)
  {
    this.jdField_a_of_type_Axfl$a = parama;
  }
  
  public void setNeedComposeAlpha(boolean paramBoolean)
  {
    this.dug = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(Frame paramFrame);
    
    public abstract void apk();
    
    public abstract void onInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfl
 * JD-Core Version:    0.7.0.1
 */