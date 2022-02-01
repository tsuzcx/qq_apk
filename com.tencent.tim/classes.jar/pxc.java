import com.tencent.biz.qqstory.base.ErrorMessage;

public class pxc
  extends plt
{
  public boolean aCu;
  public boolean aCv;
  public boolean isEnd;
  public boolean isFirstPage = true;
  
  public pxc(ErrorMessage paramErrorMessage)
  {
    this.b = paramErrorMessage;
  }
  
  public String toString()
  {
    return "{\"_class\":\"BasePageLoaderEvent\", \"errorInfo\":\"" + this.b + "\", \"isEnd\":\"" + this.isEnd + "\", \"isLocalData\":\"" + this.aCu + "\", \"isFirstPage\":\"" + this.isFirstPage + "\"}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxc
 * JD-Core Version:    0.7.0.1
 */