public abstract class adhi
  extends adhs
{
  private int cFX = 1;
  private int mDataSource = 1;
  
  public adhi(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 5);
  }
  
  public adhi(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mDataSource = paramInt1;
    this.cFX = paramInt2;
  }
  
  public static boolean a(adhi paramadhi)
  {
    return (paramadhi != null) && (paramadhi.aet());
  }
  
  public abstract boolean aet();
  
  public int getRenderType()
  {
    return this.cFX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhi
 * JD-Core Version:    0.7.0.1
 */