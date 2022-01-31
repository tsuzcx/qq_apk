import com.google.zxing.common.BitMatrix;

abstract class fs
{
  private static final fs[] a = { new fu(null), new fv(null), new fw(null), new fx(null), new fy(null), new fz(null), new ga(null), new gb(null) };
  
  static fs a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 7)) {
      throw new IllegalArgumentException();
    }
    return a[paramInt];
  }
  
  final void a(BitMatrix paramBitMatrix, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = 0;
      while (j < paramInt)
      {
        if (a(i, j)) {
          paramBitMatrix.b(j, i);
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  abstract boolean a(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fs
 * JD-Core Version:    0.7.0.1
 */