public class aqxr
{
  public boolean aIS = false;
  public boolean cWP = true;
  public boolean cWQ = false;
  public boolean cWR = true;
  public String cyC = null;
  public boolean needCompress = true;
  
  public aqxr(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString)
  {
    this.aIS = paramBoolean1;
    this.cWP = paramBoolean2;
    this.needCompress = paramBoolean3;
    this.cWQ = paramBoolean4;
    this.cWR = paramBoolean5;
    this.cyC = paramString;
  }
  
  public static aqxr a()
  {
    return new aqxr(true, false, true, true, true, null);
  }
  
  public static aqxr a(String paramString)
  {
    return new aqxr(false, true, true, false, true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxr
 * JD-Core Version:    0.7.0.1
 */