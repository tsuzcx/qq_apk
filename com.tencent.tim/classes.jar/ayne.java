import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ayne
  extends aymz
{
  public String aAF;
  public String aAG;
  public int brW = 100;
  public int brX;
  public boolean isDownloading;
  public final List<ayne.a> oT = new ArrayList();
  
  public ayne(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public String cc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.oT.size())) {
      return ((ayne.a)this.oT.get(paramInt)).uri;
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
  
  public int gq(String paramString)
  {
    if ((!aqmr.isEmpty(paramString)) && (this.oT != null))
    {
      Iterator localIterator = this.oT.iterator();
      while (localIterator.hasNext())
      {
        ayne.a locala = (ayne.a)localIterator.next();
        if (paramString.equals(locala.name)) {
          return locala.eKG;
        }
      }
    }
    return 0;
  }
  
  public List<ayne.a> hY()
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(this.aAG)) {}
    Object localObject;
    do
    {
      return null;
      localObject = new File(this.aAG);
    } while (!((File)localObject).exists());
    int j;
    File localFile1;
    if (((File)localObject).isDirectory())
    {
      File[] arrayOfFile = ((File)localObject).listFiles(new aynf(this));
      if (arrayOfFile != null)
      {
        int k = arrayOfFile.length;
        j = 0;
        if (j < k)
        {
          localFile1 = arrayOfFile[j];
          if (this.oT.size() < 100) {
            break label104;
          }
        }
      }
    }
    return localArrayList;
    label104:
    String str = localFile1.getName();
    int i;
    if (str.endsWith(".apng")) {
      i = 1;
    }
    for (;;)
    {
      label123:
      File localFile2;
      if (i == 1)
      {
        localObject = localFile1.getAbsolutePath();
        localObject = ((String)localObject).substring(0, ((String)localObject).length() - 5) + ".bpng";
        localFile2 = new File((String)localObject);
        if ((!localFile2.isFile()) || (!localFile2.exists())) {}
      }
      for (localObject = localFile2.toURI().toString();; localObject = null)
      {
        localArrayList.add(new ayne.a(str, localFile1.toURI().toString(), i, (String)localObject));
        j += 1;
        break;
        if (!str.endsWith(".gif")) {
          break label293;
        }
        i = 2;
        break label123;
        if (QLog.isColorLevel()) {
          QLog.d("FacePackage", 2, "dynamicStatic thumbFile not exist " + (String)localObject);
        }
      }
      label293:
      i = 0;
    }
  }
  
  public String hc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.oT.size())) {
      return ((ayne.a)this.oT.get(paramInt)).cXj;
    }
    return null;
  }
  
  public int ma(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.oT.size())) {
      return ((ayne.a)this.oT.get(paramInt)).eKG;
    }
    return 0;
  }
  
  public void oQ(List<ayne.a> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.oT.clear();
    this.oT.addAll(paramList);
  }
  
  public String sR(String paramString)
  {
    if ((!aqmr.isEmpty(paramString)) && (this.oT != null))
    {
      Iterator localIterator = this.oT.iterator();
      while (localIterator.hasNext())
      {
        ayne.a locala = (ayne.a)localIterator.next();
        if (paramString.equals(locala.name)) {
          return locala.uri;
        }
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("NormalFacePackage{");
    localStringBuffer.append("id='").append(this.id).append('\'');
    localStringBuffer.append("logoUrl='").append(this.logoUrl).append('\'');
    localStringBuffer.append("logoDrawable='").append(this.C).append('\'');
    localStringBuffer.append(", zipDownloadUrl='").append(this.aAF).append('\'');
    localStringBuffer.append(", facePkgPath='").append(this.aAG).append('\'');
    localStringBuffer.append(", isDownloading=").append(this.isDownloading);
    localStringBuffer.append(", maxProgress=").append(this.brW);
    localStringBuffer.append(", currentProgress=").append(this.brX);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public static class a
    implements Comparable
  {
    public String cXj;
    public int eKG;
    public String name;
    public String uri;
    
    public a(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      this.name = paramString1;
      this.uri = paramString2;
      this.eKG = paramInt;
      this.cXj = paramString3;
    }
    
    public int compareTo(@NonNull Object paramObject)
    {
      if ((paramObject instanceof a)) {
        return this.uri.compareTo(((a)paramObject).uri);
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayne
 * JD-Core Version:    0.7.0.1
 */