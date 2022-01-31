package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ThemeInfo
  extends JceStruct
{
  static CoverItem cache_stCoverItem;
  static ThemeItem cache_stThemeItem;
  public CoverItem stCoverItem = null;
  public ThemeItem stThemeItem = null;
  public long uTotalSize = 0L;
  
  public ThemeInfo() {}
  
  public ThemeInfo(ThemeItem paramThemeItem, CoverItem paramCoverItem, long paramLong)
  {
    this.stThemeItem = paramThemeItem;
    this.stCoverItem = paramCoverItem;
    this.uTotalSize = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stThemeItem == null) {
      cache_stThemeItem = new ThemeItem();
    }
    this.stThemeItem = ((ThemeItem)paramJceInputStream.read(cache_stThemeItem, 0, false));
    if (cache_stCoverItem == null) {
      cache_stCoverItem = new CoverItem();
    }
    this.stCoverItem = ((CoverItem)paramJceInputStream.read(cache_stCoverItem, 1, false));
    this.uTotalSize = paramJceInputStream.read(this.uTotalSize, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stThemeItem != null) {
      paramJceOutputStream.write(this.stThemeItem, 0);
    }
    if (this.stCoverItem != null) {
      paramJceOutputStream.write(this.stCoverItem, 1);
    }
    paramJceOutputStream.write(this.uTotalSize, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.ThemeInfo
 * JD-Core Version:    0.7.0.1
 */