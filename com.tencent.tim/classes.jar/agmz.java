import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class agmz
{
  private static long Zf;
  private static int cXX;
  private static int cXY;
  public static int cXZ = 2;
  public static int cYa = 4;
  private static Set<FileInfo> cp = new HashSet();
  private static Map<String, WeiYunFileInfo> kC;
  private static Map<String, agmz.a> kD = new HashMap();
  private static ArrayList<WeiYunFileInfo> wD = new ArrayList();
  private static ArrayList<OfflineFileInfo> wE = new ArrayList();
  private static ArrayList<FileManagerEntity> wF = new ArrayList();
  private static ArrayList<FileInfo> wG;
  private static ArrayList<String> wH;
  
  static
  {
    cXX = 20;
    wG = new ArrayList();
    wH = new ArrayList();
    kC = new HashMap();
  }
  
  public static Set<FileInfo> D()
  {
    return cp;
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
  
  public static void aEf()
  {
    cXY = 0;
  }
  
  public static boolean alM()
  {
    Iterator localIterator = wF.iterator();
    while (localIterator.hasNext()) {
      if (((FileManagerEntity)localIterator.next()).nFileType == 13) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean alN()
  {
    if (fN() == 0L) {
      return false;
    }
    if (wD.size() > 0) {
      return false;
    }
    Iterator localIterator = cp.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = ahbj.getExtension(((FileInfo)localIterator.next()).getName());
      if ((str == null) || (str.length() == 0)) {
        return false;
      }
      str = str.toLowerCase();
      if (!aobw.cjR.contains(str)) {
        return false;
      }
    }
    localIterator = wF.iterator();
    while (localIterator.hasNext())
    {
      str = ahbj.getExtension(((FileManagerEntity)localIterator.next()).fileName);
      if ((str == null) || (str.length() == 0)) {
        return false;
      }
      str = str.toLowerCase();
      if (!aobw.cjR.contains(str)) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean alO()
  {
    if (fN() == 0L) {
      return false;
    }
    Iterator localIterator = cp.iterator();
    while (localIterator.hasNext()) {
      if (e((FileInfo)localIterator.next())) {
        return true;
      }
    }
    localIterator = wF.iterator();
    while (localIterator.hasNext()) {
      if (n((FileManagerEntity)localIterator.next())) {
        return true;
      }
    }
    return false;
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
    if ((cXX > 0) && (fN() >= cXX))
    {
      ahao.D(0, String.format(BaseApplicationImpl.getApplication().getResources().getString(2131693814), new Object[] { Integer.valueOf(cXX) }), 0);
      return false;
    }
    if ((Zf > 0L) && (fP() + paramLong > Zf))
    {
      String str = BaseApplicationImpl.getApplication().getResources().getString(2131693823);
      ahao.D(0, str + ahbj.g(Zf), 0);
      return false;
    }
    return true;
  }
  
  public static void clearSelected()
  {
    cp.clear();
    wF.clear();
    wE.clear();
    wD.clear();
    aEf();
  }
  
  public static void d(FileInfo paramFileInfo)
  {
    if (!cg(paramFileInfo.getSize())) {}
    while (cp.contains(paramFileInfo)) {
      return;
    }
    cp.add(paramFileInfo);
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
    return cp.contains(paramFileInfo);
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
    cp.remove(paramFileInfo);
  }
  
  public static boolean e(FileInfo paramFileInfo)
  {
    paramFileInfo = ahbj.getExtension(paramFileInfo.getName());
    if ((paramFileInfo == null) || (paramFileInfo.length() == 0)) {}
    do
    {
      return false;
      paramFileInfo = paramFileInfo.toLowerCase();
    } while (!aobw.cjR.contains(paramFileInfo));
    return true;
  }
  
  public static void en(ArrayList<FileInfo> paramArrayList)
  {
    wG.clear();
    wG.addAll(paramArrayList);
  }
  
  public static long fM()
  {
    return Zf;
  }
  
  public static long fN()
  {
    return cp.size() + wF.size() + wE.size() + wD.size();
  }
  
  public static long fO()
  {
    Iterator localIterator = cp.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((FileInfo)localIterator.next()).getSize() + l) {}
    localIterator = wF.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (agzy.a(localFileManagerEntity).bd(false)) {
        l += ahbj.getFileSize(localFileManagerEntity.getFilePath());
      }
    }
    return l;
  }
  
  public static long fP()
  {
    Iterator localIterator = cp.iterator();
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
  
  public static boolean hasFlag(int paramInt)
  {
    return (cXY & paramInt) == paramInt;
  }
  
  public static void jz(long paramLong)
  {
    Zf = paramLong;
  }
  
  public static void k(String paramString, byte[] paramArrayOfByte)
  {
    agmz.a locala = new agmz.a();
    locala.friendUin = paramString;
    locala.dY = paramArrayOfByte;
    kD.put(paramString, locala);
  }
  
  public static void kG(List<FileInfo> paramList)
  {
    cp.addAll(paramList);
  }
  
  public static boolean mz(String paramString)
  {
    return kC.containsKey(paramString);
  }
  
  public static boolean n(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = ahbj.getExtension(paramFileManagerEntity.fileName);
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.length() == 0)) {}
    do
    {
      return false;
      paramFileManagerEntity = paramFileManagerEntity.toLowerCase();
    } while (!aobw.cjR.contains(paramFileManagerEntity));
    return true;
  }
  
  public static void setFlag(int paramInt)
  {
    cXY |= paramInt;
  }
  
  public static class a
  {
    public byte[] dY;
    public String friendUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agmz
 * JD-Core Version:    0.7.0.1
 */