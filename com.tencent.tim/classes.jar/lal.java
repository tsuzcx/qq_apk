import com.tencent.qqlive.module.videoreport.PageParams;
import java.util.HashMap;
import java.util.Map;

public class lal
{
  private HashMap<String, Object> params = new HashMap();
  
  public PageParams a()
  {
    return new PageParams(this.params);
  }
  
  public lal a(long paramLong)
  {
    this.params.put("channel_id", Long.valueOf(paramLong));
    return this;
  }
  
  public lal a(String paramString)
  {
    this.params.put("rowkey", paramString);
    return this;
  }
  
  public Map<String, Object> build()
  {
    return this.params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lal
 * JD-Core Version:    0.7.0.1
 */