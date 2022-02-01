import java.io.PrintStream;

public class anyh
  extends anyb
{
  private int dNt;
  private int dNu;
  
  public anyh(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 8, 0);
    this.dNt = paramInt2;
    this.dNu = paramInt3;
  }
  
  protected void s(int paramInt, float paramFloat)
  {
    System.out.println("time = " + paramInt + ", percent = " + paramFloat);
    this.rotate = ((int)(this.dNt + (this.dNu - this.dNt) * paramFloat));
    if (this.dNu - this.dNt > 0) {
      if (this.rotate >= this.dNu) {
        this.rotate = this.dNu;
      }
    }
    for (;;)
    {
      super.s(paramInt, paramFloat);
      return;
      if (this.rotate <= this.dNu) {
        this.rotate = this.dNu;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyh
 * JD-Core Version:    0.7.0.1
 */