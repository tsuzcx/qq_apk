import android.content.res.Resources;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.teamwork.PadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atiz
{
  private static ArrayList<FileManagerEntity> DW = new ArrayList();
  private static ArrayList<atin> DX = new ArrayList();
  private static ArrayList<PadInfo> DY = new ArrayList();
  private static ArrayList<atkw> DZ = new ArrayList();
  private static ArrayList<FileManagerEntity> Ea = new ArrayList();
  private static String bGi;
  private static String bGj;
  private static int cWq;
  public static int cXX = 20;
  
  private static boolean A(FileManagerEntity paramFileManagerEntity)
  {
    if ((mW(1)) && (!B(paramFileManagerEntity)))
    {
      DW.add(paramFileManagerEntity);
      return true;
    }
    return false;
  }
  
  private static boolean B(FileManagerEntity paramFileManagerEntity)
  {
    Iterator localIterator = DW.iterator();
    while (localIterator.hasNext()) {
      if (athu.c((FileManagerEntity)localIterator.next(), paramFileManagerEntity)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean C(FileManagerEntity paramFileManagerEntity)
  {
    if ((mW(1)) && (!D(paramFileManagerEntity)))
    {
      Ea.add(paramFileManagerEntity);
      return true;
    }
    return false;
  }
  
  private static boolean D(FileManagerEntity paramFileManagerEntity)
  {
    Iterator localIterator = Ea.iterator();
    while (localIterator.hasNext()) {
      if (athu.c(paramFileManagerEntity, (FileManagerEntity)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static String ER()
  {
    return bGi;
  }
  
  public static String ES()
  {
    return bGj;
  }
  
  public static int Ou()
  {
    return DW.size() + DY.size() + Ea.size() + DX.size() + DZ.size();
  }
  
  public static int Ov()
  {
    return cWq;
  }
  
  private static void Y(FileManagerEntity paramFileManagerEntity)
  {
    Iterator localIterator = DW.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (athu.c(localFileManagerEntity, paramFileManagerEntity)) {
        DW.remove(localFileManagerEntity);
      }
    }
  }
  
  public static void YO(String paramString)
  {
    bGi = paramString;
  }
  
  public static void YP(String paramString)
  {
    bGj = paramString;
  }
  
  private static void Z(FileManagerEntity paramFileManagerEntity)
  {
    Iterator localIterator = Ea.iterator();
    while (localIterator.hasNext()) {
      if (athu.c(paramFileManagerEntity, (FileManagerEntity)localIterator.next())) {
        Ea.remove(paramFileManagerEntity);
      }
    }
  }
  
  private static void a(PadInfo paramPadInfo)
  {
    Iterator localIterator = DY.iterator();
    while (localIterator.hasNext())
    {
      PadInfo localPadInfo = (PadInfo)localIterator.next();
      if ((localPadInfo.padId.equals(paramPadInfo.padId)) && (localPadInfo.domainId == paramPadInfo.domainId)) {
        DY.remove(localPadInfo);
      }
    }
  }
  
  private static boolean a(atin paramatin)
  {
    if ((mW(1)) && (!b(paramatin)))
    {
      DX.add(paramatin);
      return true;
    }
    return false;
  }
  
  public static boolean a(atiu paramatiu)
  {
    if (paramatiu.getCloudFileType() == 2)
    {
      if ((paramatiu instanceof FileManagerEntity)) {
        return C((FileManagerEntity)paramatiu);
      }
      return a((PadInfo)paramatiu);
    }
    if (paramatiu.getCloudFileType() == 0) {
      return A((FileManagerEntity)paramatiu);
    }
    if (paramatiu.getCloudFileType() == 7) {
      return A((FileManagerEntity)paramatiu);
    }
    if (paramatiu.getCloudFileType() == 1) {
      return a((atin)paramatiu);
    }
    if (paramatiu.getCloudFileType() == 9) {
      return a((atkw)paramatiu);
    }
    return false;
  }
  
  private static boolean a(atkw paramatkw)
  {
    if ((mW(1)) && (!b(paramatkw)))
    {
      DZ.add(paramatkw);
      return true;
    }
    return false;
  }
  
  private static boolean a(PadInfo paramPadInfo)
  {
    if ((mW(1)) && (!b(paramPadInfo)))
    {
      DY.add(paramPadInfo);
      return true;
    }
    return false;
  }
  
  public static void aav(int paramInt)
  {
    cWq = paramInt;
  }
  
  public static boolean ay(List<? extends Object> paramList)
  {
    if (mW(paramList.size()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!B(localFileManagerEntity)) {
          DW.add(localFileManagerEntity);
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean az(List<? extends Object> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!B((FileManagerEntity)paramList.next())) {
        return false;
      }
    }
    return true;
  }
  
  private static void b(atin paramatin)
  {
    Iterator localIterator = DX.iterator();
    while (localIterator.hasNext())
    {
      atin localatin = (atin)localIterator.next();
      if (athu.a(localatin, paramatin)) {
        DX.remove(localatin);
      }
    }
  }
  
  public static void b(atiu paramatiu)
  {
    if (paramatiu.getCloudFileType() == 2) {
      if ((paramatiu instanceof FileManagerEntity)) {
        Z((FileManagerEntity)paramatiu);
      }
    }
    do
    {
      return;
      a((PadInfo)paramatiu);
      return;
      if (paramatiu.getCloudFileType() == 0)
      {
        Y((FileManagerEntity)paramatiu);
        return;
      }
      if (paramatiu.getCloudFileType() == 1)
      {
        b((atin)paramatiu);
        return;
      }
    } while (paramatiu.getCloudFileType() != 9);
    b((atkw)paramatiu);
  }
  
  private static void b(atkw paramatkw)
  {
    Iterator localIterator = DZ.iterator();
    atkw localatkw;
    Object localObject;
    label88:
    do
    {
      while (localIterator.hasNext())
      {
        localatkw = (atkw)localIterator.next();
        if (localatkw.relatedType != 7) {
          break label88;
        }
        localObject = (PadInfo)localatkw.fQ;
        PadInfo localPadInfo = (PadInfo)paramatkw.fQ;
        if ((((PadInfo)localObject).padId.equals(localPadInfo.padId)) && (((PadInfo)localObject).domainId == localPadInfo.domainId)) {
          DZ.remove(localatkw);
        }
      }
      return;
      localObject = localatkw.a;
    } while ((paramatkw.a == null) || (localObject == null) || (paramatkw.a.historyId != ((CloudHistoryInfo)localObject).historyId));
    DZ.remove(localatkw);
  }
  
  private static boolean b(atin paramatin)
  {
    Iterator localIterator = DX.iterator();
    while (localIterator.hasNext()) {
      if (athu.a((atin)localIterator.next(), paramatin)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(atiu paramatiu)
  {
    boolean bool = false;
    if (paramatiu.getCloudFileType() == 0) {
      bool = B((FileManagerEntity)paramatiu);
    }
    do
    {
      return bool;
      if (paramatiu.getCloudFileType() == 1) {
        return b((atin)paramatiu);
      }
      if (paramatiu.getCloudFileType() == 2)
      {
        if ((paramatiu instanceof FileManagerEntity)) {
          return D((FileManagerEntity)paramatiu);
        }
        return b((PadInfo)paramatiu);
      }
      if (paramatiu.getCloudFileType() == 3) {
        return az(((FileManagerEntity)paramatiu).combinePhotoList);
      }
    } while (paramatiu.getCloudFileType() != 9);
    return b((atkw)paramatiu);
  }
  
  private static boolean b(atkw paramatkw)
  {
    Iterator localIterator = DZ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (atkw)localIterator.next();
      if (((atkw)localObject).relatedType == 7)
      {
        localObject = (PadInfo)((atkw)localObject).fQ;
        PadInfo localPadInfo = (PadInfo)paramatkw.fQ;
        if ((((PadInfo)localObject).padId.equals(localPadInfo.padId)) && (((PadInfo)localObject).domainId == localPadInfo.domainId)) {
          return true;
        }
      }
      else
      {
        localObject = ((atkw)localObject).a;
        if ((paramatkw.a != null) && (localObject != null) && (paramatkw.a.historyId == ((CloudHistoryInfo)localObject).historyId)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean b(PadInfo paramPadInfo)
  {
    Iterator localIterator = DY.iterator();
    while (localIterator.hasNext())
    {
      PadInfo localPadInfo = (PadInfo)localIterator.next();
      if ((localPadInfo.padId.equals(paramPadInfo.padId)) && (localPadInfo.domainId == paramPadInfo.domainId)) {
        return true;
      }
    }
    return false;
  }
  
  public static void clearSelected()
  {
    DW.clear();
    DX.clear();
    DY.clear();
    Ea.clear();
    DZ.clear();
  }
  
  public static ArrayList<PadInfo> ek()
  {
    return DY;
  }
  
  public static ArrayList<FileManagerEntity> el()
  {
    return DW;
  }
  
  public static ArrayList<atin> em()
  {
    return DX;
  }
  
  public static ArrayList<FileManagerEntity> en()
  {
    return Ea;
  }
  
  public static ArrayList<Object> eo()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(DW);
    localArrayList.addAll(DX);
    localArrayList.addAll(DY);
    localArrayList.addAll(Ea);
    localArrayList.addAll(DZ);
    return localArrayList;
  }
  
  public static long fP()
  {
    Iterator localIterator = DW.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((FileManagerEntity)localIterator.next()).fileSize + l) {}
    return l;
  }
  
  static boolean mW(int paramInt)
  {
    long l1 = Ou() + paramInt;
    long l2 = atwb.fN();
    if ((cXX > 0) && (l1 + l2 > cXX))
    {
      auds.D(0, String.format(BaseApplicationImpl.getApplication().getResources().getString(2131693814), new Object[] { Integer.valueOf(cXX) }), 0);
      return false;
    }
    return true;
  }
  
  public static void nK(List<? extends Object> paramList)
  {
    Iterator localIterator1 = DW.iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        return;
      }
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      if (localIterator2.hasNext())
      {
        if (!athu.c(localFileManagerEntity, (FileManagerEntity)localIterator2.next())) {
          break;
        }
        localIterator1.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atiz
 * JD-Core Version:    0.7.0.1
 */