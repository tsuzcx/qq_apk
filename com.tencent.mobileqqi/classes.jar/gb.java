final class gb
  extends fs
{
  private gb()
  {
    super(null);
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 + paramInt2 & 0x1) + paramInt1 * paramInt2 % 3 & 0x1) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gb
 * JD-Core Version:    0.7.0.1
 */