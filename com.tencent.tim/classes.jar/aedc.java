import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aedc
{
  public static final int[] kO = { 17039360, 17104896 };
  
  public static List<ColorNote> T(int paramInt)
  {
    List localList1 = U(paramInt);
    List localList2 = W(0);
    if (localList1 == null) {
      return null;
    }
    if ((localList2 == null) || (localList2.size() == 0)) {
      return localList1;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      ColorNote localColorNote = (ColorNote)localIterator1.next();
      Iterator localIterator2 = localList2.iterator();
      while (localIterator2.hasNext()) {
        if (aebs.a(localColorNote, (ColorNote)localIterator2.next())) {
          localArrayList.add(localColorNote);
        }
      }
    }
    localList1.removeAll(localArrayList);
    return localList1;
  }
  
  public static List<ColorNote> U(int paramInt)
  {
    return h(W(2), paramInt);
  }
  
  public static List<ColorNote> W(int paramInt)
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().a(false, paramInt);
  }
  
  public static aedn a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 16908292: 
      return new aedj();
    case 17104896: 
      return new aedk();
    case 17039360: 
      return new agsq();
    }
    return new aedl();
  }
  
  public static List<ColorNote> aU(List<ColorNote> paramList)
  {
    Object localObject = paramList;
    if (paramList != null)
    {
      localObject = paramList;
      if (paramList.size() > 3) {
        localObject = paramList.subList(0, 3);
      }
    }
    return localObject;
  }
  
  static List<ColorNote> h(List<ColorNote> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ColorNote localColorNote = (ColorNote)paramList.next();
      if (localColorNote.getServiceType() == paramInt) {
        localArrayList.add(0, localColorNote);
      }
    }
    return localArrayList;
  }
  
  private static void jG(List<ColorNote> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 20))
    {
      aeaz localaeaz = new aeaz();
      int i = 9;
      while (i < paramList.size())
      {
        ColorNote localColorNote = (ColorNote)paramList.get(i);
        localaeaz.B(localColorNote.getServiceType(), localColorNote.getSubType(), 2);
        i += 1;
      }
    }
  }
  
  public static boolean jc(int paramInt)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      List localList = U(paramInt);
      if ((localList != null) && (localList.size() > 20)) {
        jG(localList);
      }
      return true;
    }
    aeba.iZ(paramInt);
    return true;
  }
  
  public static void q(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (TextUtils.isEmpty(paramColorNote.getMainTitle()))) {
      return;
    }
    paramColorNote = aebs.c(paramColorNote);
    paramColorNote.setType(2);
    aeaz localaeaz = new aeaz();
    localaeaz.B(paramColorNote.getServiceType(), paramColorNote.getSubType(), 2);
    localaeaz.setOnColorNoteCurdListener(new aedd(localaeaz, paramColorNote));
    jc(paramColorNote.getServiceType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedc
 * JD-Core Version:    0.7.0.1
 */