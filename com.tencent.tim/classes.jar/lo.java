import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

public final class lo
{
  private static lk a(lw paramlw, int paramInt1, int paramInt2, int paramInt3)
  {
    paramlw = paramlw.a();
    if (paramlw == null) {
      throw new IllegalStateException();
    }
    int k = paramlw.getWidth();
    int m = paramlw.getHeight();
    int i = (paramInt3 << 1) + k;
    int j = (paramInt3 << 1) + m;
    paramInt1 = Math.max(paramInt1, i);
    paramInt3 = Math.max(paramInt2, j);
    int n = Math.min(paramInt1 / i, paramInt3 / j);
    j = (paramInt1 - k * n) / 2;
    paramInt2 = (paramInt3 - m * n) / 2;
    lk locallk = new lk(paramInt1, paramInt3);
    paramInt1 = 0;
    while (paramInt1 < m)
    {
      i = 0;
      paramInt3 = j;
      while (i < k)
      {
        if (paramlw.a(i, paramInt1) == 1) {
          locallk.setRegion(paramInt3, paramInt2, n, n);
        }
        i += 1;
        paramInt3 += n;
      }
      paramInt2 += n;
      paramInt1 += 1;
    }
    return locallk;
  }
  
  public lk b(String paramString, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("Found empty contents");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("Requested dimensions are too small: " + paramInt1 + 'x' + paramInt2);
    }
    Object localObject1 = ErrorCorrectionLevel.L;
    Object localObject2 = localObject1;
    int i;
    if (paramMap != null)
    {
      localObject2 = (ErrorCorrectionLevel)paramMap.get(EncodeHintType.ERROR_CORRECTION);
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      Integer localInteger = (Integer)paramMap.get(EncodeHintType.MARGIN);
      localObject2 = localObject1;
      if (localInteger != null) {
        i = localInteger.intValue();
      }
    }
    for (;;)
    {
      return a(ls.a(paramString, (ErrorCorrectionLevel)localObject1, paramMap), paramInt1, paramInt2, i);
      i = 4;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     lo
 * JD-Core Version:    0.7.0.1
 */