final class fz
  extends fs
{
  private fz()
  {
    super(null);
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    paramInt1 *= paramInt2;
    return paramInt1 % 3 + (paramInt1 & 0x1) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fz
 * JD-Core Version:    0.7.0.1
 */