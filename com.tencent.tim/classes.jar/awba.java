import java.util.Random;

public class awba
  extends awbk
{
  protected int frequency = 1;
  protected Random random = new Random(System.currentTimeMillis());
  
  public awba(int paramInt)
  {
    aci(paramInt);
  }
  
  public boolean aMa()
  {
    return this.random.nextInt(this.frequency) < 1;
  }
  
  public void aci(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    this.frequency = i;
  }
  
  public int getFrequency()
  {
    return this.frequency;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awba
 * JD-Core Version:    0.7.0.1
 */