public class isx
  extends isd
{
  public int HEIGHT;
  public int LEFT;
  public int TOP;
  public int WIDTH;
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = this.LEFT * paramInt1 / 750;
    paramInt3 = this.TOP * paramInt1 / 750;
    setBounds(paramInt2, paramInt3, this.WIDTH * paramInt1 / 750 + paramInt2, this.HEIGHT * paramInt1 / 750 + paramInt3);
  }
  
  public void update(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isx
 * JD-Core Version:    0.7.0.1
 */