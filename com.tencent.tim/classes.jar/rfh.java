public class rfh
  implements Comparable<rfh>
{
  public String azY;
  public int id;
  public String name;
  int priority;
  public String thumbPath;
  
  public rfh()
  {
    this.id = -1;
  }
  
  public rfh(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    this.id = paramInt1;
    this.thumbPath = paramString1;
    this.priority = paramInt2;
    this.name = paramString2;
    this.azY = paramString3;
  }
  
  public int a(rfh paramrfh)
  {
    if (paramrfh == null) {}
    do
    {
      return -1;
      if (this.priority < paramrfh.priority) {
        return 1;
      }
    } while (this.priority != paramrfh.priority);
    return 0;
  }
  
  public String toString()
  {
    return "FilterTemplate{id='" + this.id + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", priority=" + this.priority + ", name='" + this.name + '\'' + ", pron='" + this.azY + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfh
 * JD-Core Version:    0.7.0.1
 */