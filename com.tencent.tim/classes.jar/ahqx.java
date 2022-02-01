import java.util.ArrayList;

public class ahqx
{
  private boolean chW;
  public int confidence;
  public int daM = -1;
  public int daN;
  public int daO;
  public String text;
  public ArrayList<ahqx.a> wY;
  
  private int a(ahqx.a parama1, ahqx.a parama2)
  {
    int i = Math.abs(parama2.x - parama1.x);
    int j = Math.abs(parama2.y - parama1.y);
    return (int)Math.ceil(Math.sqrt(i * i + j * j));
  }
  
  public int Fh()
  {
    if ((this.wY == null) || (this.wY.size() < 2)) {
      return 0;
    }
    ahqx.a locala1 = (ahqx.a)this.wY.get(0);
    ahqx.a locala2 = (ahqx.a)this.wY.get(1);
    int i = locala2.x - locala1.x;
    int j = locala2.y - locala1.y;
    double d = Math.sqrt(i * i + j * j);
    float f = (float)(Math.asin(j / d) / 3.141592653589793D * 180.0D);
    if (locala2.x < locala1.x) {
      if (f > 0.0F) {
        f = 180.0F - f;
      }
    }
    for (;;)
    {
      return Math.round(f);
      f = -(180.0F + f);
    }
  }
  
  public void aQ(float paramFloat)
  {
    if (!this.chW)
    {
      int i = 0;
      while (i < this.wY.size())
      {
        ((ahqx.a)this.wY.get(i)).x = ((int)(((ahqx.a)this.wY.get(i)).x * paramFloat));
        ((ahqx.a)this.wY.get(i)).y = ((int)(((ahqx.a)this.wY.get(i)).y * paramFloat));
        i += 1;
      }
      this.chW = true;
    }
  }
  
  public int getHeigh()
  {
    if ((this.wY == null) || (this.wY.size() < 4)) {
      return 0;
    }
    return a((ahqx.a)this.wY.get(0), (ahqx.a)this.wY.get(3));
  }
  
  public int getWidth()
  {
    if ((this.wY == null) || (this.wY.size() < 4)) {
      return 0;
    }
    return a((ahqx.a)this.wY.get(0), (ahqx.a)this.wY.get(2));
  }
  
  public String toString()
  {
    return "PicOcrResult{text='" + this.text + '\'' + ", confidence=" + this.confidence + ", coorPoints=" + this.wY + ", arc=" + Fh() + '}';
  }
  
  public static class a
  {
    public int x;
    public int y;
    
    public a(int paramInt1, int paramInt2)
    {
      this.x = paramInt1;
      this.y = paramInt2;
    }
    
    public String toString()
    {
      return "Point{x=" + this.x + ", y=" + this.y + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqx
 * JD-Core Version:    0.7.0.1
 */