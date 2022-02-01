public class rna
  extends rmx
{
  String aBr;
  private rnb b;
  int duration = 0;
  long startTime;
  
  public rna(rnb paramrnb, String paramString, int paramInt, long paramLong)
  {
    this.duration = paramInt;
    this.startTime = paramLong;
    this.b = paramrnb;
    this.aBr = paramString;
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    if ((this.b == null) || (paramInt1 < this.startTime) || (paramInt1 > this.startTime + this.duration) || (paramInt1 >= paramInt2)) {}
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    do
    {
      return null;
      int i = this.b.bts * this.b.btu * this.b.btt / 1000;
      l1 = paramInt1;
      l2 = this.startTime;
      l3 = i;
      l4 = paramInt2;
      l5 = this.startTime;
      l6 = i;
    } while (this.b == null);
    return this.b.a(this.aBr, (l1 - l2) * l3, (l4 - l5) * l6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rna
 * JD-Core Version:    0.7.0.1
 */