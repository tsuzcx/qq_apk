import java.io.File;

public class aixq
{
  public int cBJ;
  public boolean cmw;
  public int dge;
  public int dgf;
  public String[] fq;
  public String[] fr;
  public int mDuration;
  
  public aixq()
  {
    init();
  }
  
  private void init()
  {
    this.dge = 0;
    this.cBJ = 1;
    this.mDuration = 100;
    this.dgf = 0;
    this.fq = null;
    this.fr = null;
  }
  
  public boolean apQ()
  {
    int i;
    if ((this.fq != null) && (this.fq.length > 0))
    {
      i = 0;
      while (i < this.fq.length)
      {
        if (!new File(this.fq[i]).exists()) {
          return false;
        }
        i += 1;
      }
    }
    if ((this.fr != null) && (this.fr.length > 0))
    {
      i = 0;
      for (;;)
      {
        if (i >= this.fr.length) {
          break label106;
        }
        if (!new File(this.fr[i]).exists()) {
          break;
        }
        i += 1;
      }
    }
    label106:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixq
 * JD-Core Version:    0.7.0.1
 */