import android.support.annotation.Nullable;
import java.io.File;

public class axbu
{
  public static axbu i = ;
  public String Kq;
  public String cTB;
  public String cTC;
  public String cTD;
  public String cameraScheme;
  public String cameraTitle;
  public int categoryId;
  public int displayType = 0;
  public boolean downloading;
  public boolean dtW;
  public boolean dtX;
  public int eEx;
  public int eEy = 0;
  public boolean editablewatermark;
  public String iconurl;
  public String id;
  public int kind = 0;
  public String md5;
  public String miniAppId;
  public String name;
  public String playShowCoverImg;
  public String playShowDisplayText;
  public int position;
  public String resurl;
  public long startDownloadTime;
  public long totalLen;
  public boolean usable;
  public String webUrl;
  
  private static axbu c()
  {
    axbu localaxbu = new axbu();
    localaxbu.id = "0";
    localaxbu.categoryId = 0;
    return localaxbu;
  }
  
  public static boolean e(axbu paramaxbu)
  {
    if (paramaxbu == null) {}
    while ((paramaxbu.id != null) && (!paramaxbu.id.equals("0"))) {
      return false;
    }
    return true;
  }
  
  public static boolean f(@Nullable axbu paramaxbu)
  {
    return (paramaxbu != null) && ((paramaxbu.eEy == 0) || (paramaxbu.eEy == 4) || (paramaxbu.eEy == 5) || (paramaxbu.eEy == 6) || (paramaxbu.eEy == 7));
  }
  
  public String HD()
  {
    File localFile = new File(awtn.b.b.cSR);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath() + File.separator;
  }
  
  public String HE()
  {
    return new File(axbr.HC(), this.id).getPath();
  }
  
  public boolean aOq()
  {
    return (this.id == null) || (this.id.equals("0"));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof axbu));
      paramObject = (axbu)paramObject;
      if ((paramObject.id == null) && (this.id == null)) {
        return true;
      }
    } while (((paramObject.id == null) && (this.id != null)) || ((paramObject.id != null) && (this.id == null)));
    return paramObject.id.equals(this.id);
  }
  
  public int getDisplayIconByType()
  {
    switch (this.displayType)
    {
    default: 
      return -1;
    case 1: 
      return 2130845447;
    case 2: 
      return 2130845448;
    case 3: 
      return 2130845450;
    }
    return 2130845449;
  }
  
  public String getLocalPath()
  {
    File localFile = new File(awtn.b.b.cSR);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), this.id).getPath() + File.separator;
  }
  
  public int hashCode()
  {
    if (this.id == null) {}
    for (int j = 0;; j = this.id.hashCode()) {
      return j + 31;
    }
  }
  
  public boolean isWsBanner()
  {
    return this.kind == 12;
  }
  
  public boolean needDisplayType()
  {
    return this.displayType != 0;
  }
  
  public void x(axbu paramaxbu)
  {
    if (!equals(i))
    {
      this.usable = paramaxbu.usable;
      this.downloading = paramaxbu.downloading;
      this.editablewatermark = paramaxbu.editablewatermark;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbu
 * JD-Core Version:    0.7.0.1
 */