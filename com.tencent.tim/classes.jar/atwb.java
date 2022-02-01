import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class atwb
{
  private static ArrayList<FileInfo> DW = new ArrayList();
  private static long Zf;
  private static int cXX;
  private static Map<String, WeiYunFileInfo> kC = new HashMap();
  private static Map<String, Object> kD = new HashMap();
  private static ArrayList<WeiYunFileInfo> wD = new ArrayList();
  private static ArrayList<OfflineFileInfo> wE = new ArrayList();
  private static ArrayList<FileManagerEntity> wF = new ArrayList();
  private static ArrayList<FileInfo> wG;
  
  static
  {
    cXX = 20;
    wG = new ArrayList();
  }
  
  public static void Og(int paramInt)
  {
    cXX = paramInt;
  }
  
  public static WeiYunFileInfo a(String paramString)
  {
    return (WeiYunFileInfo)kC.remove(paramString);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (!cg(paramFileManagerEntity.fileSize)) {
      return;
    }
    wF.add(paramFileManagerEntity);
  }
  
  public static void a(String paramString, WeiYunFileInfo paramWeiYunFileInfo)
  {
    kC.put(paramString, paramWeiYunFileInfo);
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    wF.remove(paramFileManagerEntity);
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return wF.contains(paramFileManagerEntity);
  }
  
  public static void c(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!cg(paramWeiYunFileInfo.nFileSize)) {
      return;
    }
    wD.add(paramWeiYunFileInfo);
  }
  
  public static boolean c(WeiYunFileInfo paramWeiYunFileInfo)
  {
    Iterator localIterator = wD.iterator();
    while (localIterator.hasNext()) {
      if (((WeiYunFileInfo)localIterator.next()).bIk.equals(paramWeiYunFileInfo.bIk)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean cg(long paramLong)
  {
    long l1 = fN();
    long l2 = atiz.Ou();
    if ((cXX > 0) && (l1 + l2 >= cXX))
    {
      auds.D(0, String.format(BaseApplicationImpl.getApplication().getResources().getString(2131693814), new Object[] { Integer.valueOf(cXX) }), 0);
      return false;
    }
    if ((Zf > 0L) && (fP() + paramLong > Zf))
    {
      String str = BaseApplicationImpl.getApplication().getResources().getString(2131693823);
      auds.D(0, str + aueh.g(Zf), 0);
      return false;
    }
    return true;
  }
  
  public static void clearSelected()
  {
    DW.clear();
    wF.clear();
    wE.clear();
    wD.clear();
  }
  
  public static void d(FileInfo paramFileInfo)
  {
    if (!cg(paramFileInfo.getSize())) {
      return;
    }
    DW.add(paramFileInfo);
  }
  
  public static void d(WeiYunFileInfo paramWeiYunFileInfo)
  {
    Iterator localIterator = wD.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      if (localWeiYunFileInfo.bIk.equals(paramWeiYunFileInfo.bIk)) {
        wD.remove(localWeiYunFileInfo);
      }
    }
  }
  
  public static boolean d(FileInfo paramFileInfo)
  {
    return DW.contains(paramFileInfo);
  }
  
  public static ArrayList<FileInfo> da()
  {
    return wG;
  }
  
  public static ArrayList<FileManagerEntity> db()
  {
    return wF;
  }
  
  public static ArrayList<OfflineFileInfo> dc()
  {
    return wE;
  }
  
  public static ArrayList<WeiYunFileInfo> dd()
  {
    return wD;
  }
  
  public static void dip()
  {
    wG.clear();
  }
  
  public static void e(FileInfo paramFileInfo)
  {
    DW.remove(paramFileInfo);
  }
  
  public static void en(ArrayList<FileInfo> paramArrayList)
  {
    wG.clear();
    wG.addAll(paramArrayList);
  }
  
  public static ArrayList<FileInfo> ep()
  {
    return DW;
  }
  
  public static long fN()
  {
    return DW.size() + wF.size() + wE.size() + wD.size();
  }
  
  public static long fO()
  {
    Iterator localIterator = DW.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((FileInfo)localIterator.next()).getSize() + l) {}
    localIterator = wF.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (audk.a(localFileManagerEntity).bd(false)) {
        l += aueh.getFileSize(localFileManagerEntity.getFilePath());
      }
    }
    return l;
  }
  
  public static long fP()
  {
    Iterator localIterator = DW.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((FileInfo)localIterator.next()).getSize() + l) {}
    localIterator = wD.iterator();
    while (localIterator.hasNext()) {
      l += ((WeiYunFileInfo)localIterator.next()).nFileSize;
    }
    localIterator = wE.iterator();
    while (localIterator.hasNext()) {
      l += ((OfflineFileInfo)localIterator.next()).nFileSize;
    }
    localIterator = wF.iterator();
    while (localIterator.hasNext()) {
      l += ((FileManagerEntity)localIterator.next()).fileSize;
    }
    return l;
  }
  
  public static long fQ()
  {
    Iterator localIterator = wD.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((WeiYunFileInfo)localIterator.next()).nFileSize + l) {}
    localIterator = wE.iterator();
    while (localIterator.hasNext()) {
      l += ((OfflineFileInfo)localIterator.next()).nFileSize;
    }
    localIterator = wF.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      switch (localFileManagerEntity.getCloudType())
      {
      default: 
        break;
      case 1: 
      case 2: 
        l += localFileManagerEntity.fileSize;
      }
    }
    return l;
  }
  
  public static void jz(long paramLong)
  {
    Zf = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwb
 * JD-Core Version:    0.7.0.1
 */