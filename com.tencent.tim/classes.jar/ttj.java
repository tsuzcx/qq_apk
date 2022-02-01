import java.util.List;

public class ttj
  extends ttl<tvk>
{
  private final tvk a;
  
  public ttj(List<? extends tsl<tvk>> paramList)
  {
    super(paramList);
    paramList = (tvk)((tsl)paramList.get(0)).startValue;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.getSize())
    {
      this.a = new tvk(new float[i], new int[i]);
      return;
    }
  }
  
  tvk a(tsl<tvk> paramtsl, float paramFloat)
  {
    this.a.a((tvk)paramtsl.startValue, (tvk)paramtsl.endValue, paramFloat);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttj
 * JD-Core Version:    0.7.0.1
 */