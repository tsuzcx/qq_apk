import android.text.TextUtils;

public class ygz
  extends ygq
{
  private long JV;
  private long JW;
  int bYZ = 0;
  private boolean bmB;
  private int epId;
  private boolean exposed;
  private String filePath;
  private int from;
  private String iconUrl;
  private int imgHeight;
  private String imgMd5;
  private String imgUrl;
  private int imgWidth;
  private int index;
  private String keyWord;
  private String packageName;
  private String source;
  private int thumbHeight;
  private String thumbMd5;
  private String thumbUrl;
  private int thumbWidth;
  private String webUrl;
  
  public void DU(int paramInt)
  {
    this.bYZ = paramInt;
  }
  
  public void DW(int paramInt)
  {
    this.imgWidth = paramInt;
  }
  
  public void DX(int paramInt)
  {
    this.imgHeight = paramInt;
  }
  
  public void DY(int paramInt)
  {
    this.thumbWidth = paramInt;
  }
  
  public void DZ(int paramInt)
  {
    this.thumbHeight = paramInt;
  }
  
  public void Ea(int paramInt)
  {
    this.epId = paramInt;
  }
  
  public boolean TA()
  {
    return this.exposed;
  }
  
  public long es()
  {
    return this.JV;
  }
  
  public String getFilePath()
  {
    if (TextUtils.isEmpty(this.filePath)) {
      this.filePath = yhf.hG(getURL());
    }
    return this.filePath;
  }
  
  public int getHeight()
  {
    if (TextUtils.isEmpty(this.thumbUrl)) {
      return this.imgHeight;
    }
    return this.thumbHeight;
  }
  
  public String getImgUrl()
  {
    return this.imgUrl;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getKeyWord()
  {
    return this.keyWord;
  }
  
  public String getMd5()
  {
    if (TextUtils.isEmpty(this.thumbUrl)) {
      return this.imgMd5;
    }
    return this.thumbMd5;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public String getThumbUrl()
  {
    return this.thumbUrl;
  }
  
  public String getURL()
  {
    if (TextUtils.isEmpty(this.thumbUrl)) {
      return this.imgUrl;
    }
    return this.thumbUrl;
  }
  
  public String getWebUrl()
  {
    return this.webUrl;
  }
  
  public int getWidth()
  {
    if (TextUtils.isEmpty(this.thumbUrl)) {
      return this.imgWidth;
    }
    return this.thumbWidth;
  }
  
  public void gi(long paramLong)
  {
    this.JV = paramLong;
  }
  
  public void gj(long paramLong)
  {
    this.JW = paramLong;
  }
  
  public boolean isClicked()
  {
    return this.bmB;
  }
  
  public void nA(int paramInt)
  {
    this.from = paramInt;
  }
  
  public String pB()
  {
    return this.thumbMd5;
  }
  
  public String pz()
  {
    return this.imgMd5;
  }
  
  public int sZ()
  {
    return this.from;
  }
  
  public void setClicked(boolean paramBoolean)
  {
    this.bmB = paramBoolean;
  }
  
  public void setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
  }
  
  public void setImgUrl(String paramString)
  {
    this.imgUrl = paramString;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setKeyWord(String paramString)
  {
    this.keyWord = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setSource(String paramString)
  {
    this.source = paramString;
  }
  
  public void setThumbUrl(String paramString)
  {
    this.thumbUrl = paramString;
  }
  
  public void setWebUrl(String paramString)
  {
    this.webUrl = paramString;
  }
  
  public String toString()
  {
    return "imgUrl=" + this.imgUrl + " thumbUrl=" + this.thumbUrl + " imgMd5=" + this.imgMd5 + " thumbMd5=" + this.thumbMd5 + " imgWidth=" + this.imgWidth + " imgHeight=" + this.imgHeight + " thumbWidth=" + this.thumbWidth + " thumbHeight=" + this.thumbHeight + " imgFileSize=" + this.JV + " thumbFileSize=" + this.JW;
  }
  
  public int wH()
  {
    return 0;
  }
  
  public int wI()
  {
    return 0;
  }
  
  public int wL()
  {
    return this.epId;
  }
  
  public void yE(String paramString)
  {
    this.imgMd5 = paramString;
  }
  
  public void yF(String paramString)
  {
    this.thumbMd5 = paramString;
  }
  
  public void zX(boolean paramBoolean)
  {
    this.exposed = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygz
 * JD-Core Version:    0.7.0.1
 */