public class aurq<T>
{
  private aurq.a<T> a;
  private long mInterval;
  private long startTime;
  
  private aurq(aurq.a<T> parama)
  {
    this.a = parama;
  }
  
  public static <T> aurq<T> a(aurq.a<T> parama)
  {
    return new aurq(parama);
  }
  
  public aurq<T> a(long paramLong)
  {
    this.mInterval = paramLong;
    return this;
  }
  
  public aurq<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.startTime > this.mInterval)
    {
      this.startTime = l;
      if (this.a != null) {
        this.a.bq(paramT);
      }
    }
    return this;
  }
  
  public static abstract interface a<T>
  {
    public abstract void bq(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurq
 * JD-Core Version:    0.7.0.1
 */