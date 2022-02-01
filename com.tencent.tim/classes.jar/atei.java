import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class atei
  extends atgg
{
  atei(ateh paramateh, atgc paramatgc, int paramInt) {}
  
  public void a(byte[] paramArrayOfByte, List<Object> paramList, boolean paramBoolean, String paramString1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString2)
  {
    super.a(paramArrayOfByte, paramList, paramBoolean, paramString1, paramLong1, paramLong2, paramInt1, paramInt2, paramString2);
    if (paramInt2 == 0)
    {
      paramArrayOfByte = paramList.iterator();
      while (paramArrayOfByte.hasNext())
      {
        paramList = paramArrayOfByte.next();
        if ((paramList instanceof atin))
        {
          if ((this.a.aG() != null) && (Arrays.equals(((atin)paramList).Y(), this.a.aG()))) {
            this.a.YK(((atin)paramList).name);
          }
          if ((this.a.aF() != null) && (Arrays.equals(((atin)paramList).Y(), this.a.aF()))) {
            this.a.YJ(((atin)paramList).name);
          }
        }
      }
      ateh.a(this.this$0, true, this.epx, paramBoolean);
      return;
    }
    ateh.a(this.this$0, false, this.epx, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atei
 * JD-Core Version:    0.7.0.1
 */