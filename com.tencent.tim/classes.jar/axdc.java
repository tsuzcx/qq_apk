import com.tencent.aekit.openrender.internal.Frame;

public class axdc
{
  public static final Integer ax = Integer.valueOf(480);
  private axdi a = new axdi();
  private boolean bSc = true;
  private Frame j = new Frame();
  
  public void clear()
  {
    this.a.ClearGLSL();
    this.j.clear();
  }
  
  public void initial()
  {
    this.a.apply();
  }
  
  public Frame render(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.bSc)
    {
      this.a.render(paramFrame, this.j);
      localFrame = this.j;
    }
    return localFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdc
 * JD-Core Version:    0.7.0.1
 */