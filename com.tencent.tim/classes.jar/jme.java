public class jme
{
  public static int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramInt1 = mod(paramInt1, paramInt3);
    paramInt2 = mod(paramInt2, paramInt3);
    if (paramBoolean)
    {
      if (paramInt1 > paramInt2) {
        return paramInt1 - paramInt2;
      }
      return paramInt1 + (paramInt3 - paramInt2);
    }
    if (paramInt1 > paramInt2) {
      return paramInt3 - paramInt1 + paramInt2;
    }
    return paramInt2 - paramInt1;
  }
  
  public static int mod(int paramInt1, int paramInt2)
  {
    return (paramInt1 % paramInt2 + paramInt2) % paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jme
 * JD-Core Version:    0.7.0.1
 */