import java.util.ArrayList;
import java.util.List;

public final class ln
{
  private final List<lm> W;
  private final ll b;
  
  public ln(ll paramll)
  {
    if (!ll.a.equals(paramll)) {
      throw new IllegalArgumentException("Only QR Code is supported at this time");
    }
    this.b = paramll;
    this.W = new ArrayList();
    this.W.add(new lm(paramll, new int[] { 1 }));
  }
  
  private lm a(int paramInt)
  {
    if (paramInt >= this.W.size())
    {
      lm locallm = (lm)this.W.get(this.W.size() - 1);
      int i = this.W.size();
      while (i <= paramInt)
      {
        locallm = locallm.b(new lm(this.b, new int[] { 1, this.b.A(i - 1) }));
        this.W.add(locallm);
        i += 1;
      }
    }
    return (lm)this.W.get(paramInt);
  }
  
  public void b(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("No error correction bytes");
    }
    int i = paramArrayOfInt.length - paramInt;
    if (i <= 0) {
      throw new IllegalArgumentException("No data bytes provided");
    }
    Object localObject = a(paramInt);
    int[] arrayOfInt = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    localObject = new lm(this.b, arrayOfInt).b(paramInt, 1).a(localObject)[1].f();
    int j = paramInt - localObject.length;
    paramInt = 0;
    while (paramInt < j)
    {
      paramArrayOfInt[(i + paramInt)] = 0;
      paramInt += 1;
    }
    System.arraycopy(localObject, 0, paramArrayOfInt, i + j, localObject.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ln
 * JD-Core Version:    0.7.0.1
 */