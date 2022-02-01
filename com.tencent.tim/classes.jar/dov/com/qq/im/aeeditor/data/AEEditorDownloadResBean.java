package dov.com.qq.im.aeeditor.data;

import java.io.Serializable;

public class AEEditorDownloadResBean
  implements Serializable
{
  private String id;
  private String md5;
  private int preDownload;
  private String url;
  
  public String getId()
  {
    return this.id;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public int getPreDownload()
  {
    return this.preDownload;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMd5(String paramString)
  {
    this.md5 = paramString;
  }
  
  public void setPreDownload(int paramInt)
  {
    this.preDownload = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean
 * JD-Core Version:    0.7.0.1
 */