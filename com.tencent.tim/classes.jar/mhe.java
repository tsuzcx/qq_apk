import java.net.URL;

public class mhe
{
  private int aRH;
  private int aRI;
  private boolean amv;
  private URL f;
  
  public int getFirstFrameHeight()
  {
    return this.aRI;
  }
  
  public URL getFirstFrameUrl()
  {
    return this.f;
  }
  
  public int getFirstFrameWidth()
  {
    return this.aRH;
  }
  
  public boolean hasFirstFramePreload()
  {
    return this.amv;
  }
  
  public void setFirstFrameHeight(int paramInt)
  {
    this.aRI = paramInt;
  }
  
  public void setFirstFrameUrl(URL paramURL)
  {
    this.f = paramURL;
  }
  
  public void setFirstFrameWidth(int paramInt)
  {
    this.aRH = paramInt;
  }
  
  public void setHasFirstFramePreload(boolean paramBoolean)
  {
    this.amv = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhe
 * JD-Core Version:    0.7.0.1
 */