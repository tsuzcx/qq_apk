import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class rin
  extends rik
{
  public String aAF;
  public String aAG;
  public int brW = 100;
  public int brX;
  public boolean isDownloading;
  public final List<String> oT = new ArrayList();
  
  public rin(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public boolean LC()
  {
    if (TextUtils.isEmpty(this.aAG)) {}
    do
    {
      Object localObject1;
      do
      {
        return false;
        localObject1 = new File(this.aAG);
      } while (!((File)localObject1).exists());
      this.oT.clear();
      if (((File)localObject1).isDirectory())
      {
        localObject1 = ((File)localObject1).listFiles(new rio(this));
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            this.oT.add(localObject2.toURI().toString());
            i += 1;
          }
          Collections.sort(this.oT);
        }
      }
    } while (this.oT.isEmpty());
    return true;
  }
  
  public String cc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.oT.size())) {
      return (String)this.oT.get(paramInt);
    }
    return null;
  }
  
  public int getFaceCount()
  {
    return this.oT.size();
  }
  
  public String getType()
  {
    return "NormalFacePackage";
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("NormalFacePackage{");
    localStringBuffer.append("id='").append(this.id).append('\'');
    localStringBuffer.append("logoUrl='").append(this.logoUrl).append('\'');
    localStringBuffer.append("logoDrawable='").append(this.C).append('\'');
    localStringBuffer.append(", zipDownloadUrl='").append(this.aAF).append('\'');
    localStringBuffer.append(", facePkgPath='").append(this.aAG).append('\'');
    localStringBuffer.append(", faceUriList=").append(this.oT);
    localStringBuffer.append(", isDownloading=").append(this.isDownloading);
    localStringBuffer.append(", maxProgress=").append(this.brW);
    localStringBuffer.append(", currentProgress=").append(this.brX);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rin
 * JD-Core Version:    0.7.0.1
 */