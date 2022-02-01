import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amrj
{
  public static int axl = 3;
  
  public static void B(List paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList5 = C(paramList);
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = null;
    Object localObject1 = null;
    int i = paramList.size() - 1;
    Object localObject5;
    Object localObject3;
    if (i >= 0)
    {
      localObject5 = paramList.get(i);
      if ((localObject5 instanceof ampf))
      {
        localObject3 = ((ampf)localObject5).a();
        if (((localObject3 instanceof amov)) && (((amov)localObject3).ajO == 1701L))
        {
          localObject3 = (amov)localObject3;
          paramList.remove(i);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      label148:
      localObject3 = localObject1;
      Object localObject4 = localObject2;
      for (;;)
      {
        i -= 1;
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if ((!(localObject3 instanceof amov)) || (((amov)localObject3).ajO != 1003L)) {
          break label1015;
        }
        localObject3 = (amov)localObject3;
        paramList.remove(i);
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label148;
        if (((localObject5 instanceof ampg)) && ((((ampg)localObject5).ajO == 1701L) || (((ampg)localObject5).ajO == 1003L)))
        {
          paramList.remove(i);
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
        else if ((localObject5 instanceof amqo))
        {
          localObject5 = (amqo)localObject5;
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (((amqo)localObject5).a != null)
          {
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((amqo)localObject5).a.a != null)
            {
              String str = ((amqo)localObject5).a.a.appId;
              paramList.remove(i);
              localObject4 = localObject1;
              localObject3 = localObject2;
              if (!d(str, localArrayList5)) {
                if (((amqo)localObject5).cDZ)
                {
                  localArrayList3.add(0, localObject5);
                  localObject4 = localObject1;
                  localObject3 = localObject2;
                }
                else
                {
                  localArrayList4.add(0, localObject5);
                  localObject4 = localObject1;
                  localObject3 = localObject2;
                }
              }
            }
          }
        }
        else
        {
          localObject4 = localObject1;
          localObject3 = localObject2;
          if ((localObject5 instanceof amqv))
          {
            localObject5 = (amqv)localObject5;
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((amqv)localObject5).ajO == 1003L)
            {
              paramList.remove(i);
              if ((a((amqv)localObject5, paramString)) && (localArrayList1.size() == 0))
              {
                ((amqv)localObject5).cDR = true;
                localArrayList1.add(0, localObject5);
                anot.a(null, "dc00898", "", "", "0X800AC11", "0X800AC11", 0, 0, "", "", "", "");
                localObject4 = localObject1;
                localObject3 = localObject2;
              }
              else
              {
                localArrayList2.add(0, localObject5);
                localObject4 = localObject1;
                localObject3 = localObject2;
              }
            }
          }
        }
      }
      int k = 0;
      i = 0;
      int j = 0;
      label565:
      if (k < paramList.size())
      {
        localObject3 = paramList.get(k);
        if (!(localObject3 instanceof ampo)) {
          break label1012;
        }
        j = k + 1;
      }
      label1003:
      label1012:
      for (;;)
      {
        if ((((localObject3 instanceof amph)) && (a((amph)localObject3, paramString))) || ((((localObject3 instanceof ampo)) || ((localObject3 instanceof ampi)) || ((localObject3 instanceof ampk)) || ((localObject3 instanceof amrd))) && (i <= k))) {
          i = k + 1;
        }
        for (;;)
        {
          k += 1;
          break label565;
          if (localArrayList3.size() > 0)
          {
            a(paramList, j, localArrayList3, localObject2, false, axl, true);
            j = localArrayList3.size() + i + 1;
            if (paramList.size() >= j)
            {
              QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "OUT OF INDEX OF MINI");
              i = j;
            }
          }
          for (;;)
          {
            if (localArrayList4.size() > 0) {
              a(paramList, i, localArrayList4, localObject2, true, axl, false);
            }
            k = 0;
            i = 0;
            j = 0;
            label758:
            if (k < paramList.size())
            {
              localObject2 = paramList.get(k);
              if ((!(localObject2 instanceof ampo)) && ((!(localObject2 instanceof amqo)) || (((amqo)localObject2).cDZ != true)) && ((!(localObject2 instanceof amph)) || (!a((amph)localObject2, paramString)))) {
                break label1003;
              }
              j = k + 1;
            }
            for (;;)
            {
              if ((((localObject2 instanceof amph)) || ((localObject2 instanceof ampo)) || ((localObject2 instanceof ampi)) || ((localObject2 instanceof ampk)) || ((localObject2 instanceof amrd)) || ((localObject2 instanceof amqo)) || ((localObject2 instanceof ampl)) || ((localObject2 instanceof amnu))) && (i <= k)) {
                i = k + 1;
              }
              for (;;)
              {
                k += 1;
                break label758;
                if (localArrayList1.size() > 0)
                {
                  a(paramList, j, localArrayList1, localObject1, false, axl, true);
                  j = localArrayList1.size() + i + 1;
                  if (paramList.size() >= j)
                  {
                    QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "OUT OF INDEX OF PUBLLIC");
                    i = j;
                  }
                }
                while (localArrayList2.size() > 0)
                {
                  a(paramList, i, localArrayList2, localObject1, true, axl, false);
                  return;
                }
                break;
              }
            }
          }
        }
      }
      label1015:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private static ArrayList<String> C(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    Object localObject;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localObject = paramList.next();
    } while (!(localObject instanceof ampo));
    for (paramList = (ampo)localObject;; paramList = null)
    {
      if (paramList != null)
      {
        paramList = paramList.eX();
        if ((paramList != null) && (paramList.size() > 0))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (ampx)paramList.next();
            if ((localObject != null) && ((localObject instanceof amqc)))
            {
              localObject = (amqc)localObject;
              if ((localObject != null) && (((amqc)localObject).a != null))
              {
                localObject = ((amqc)localObject).a.appId;
                if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                  localArrayList.add(localObject);
                }
              }
            }
          }
        }
      }
      return localArrayList;
    }
  }
  
  public static boolean K(ArrayList paramArrayList)
  {
    boolean bool2;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool2 = false;
    }
    int i;
    boolean bool1;
    do
    {
      return bool2;
      i = paramArrayList.size() - 1;
      bool1 = false;
      bool2 = bool1;
    } while (i < 0);
    ampw localampw;
    if ((paramArrayList.get(i) instanceof ampw))
    {
      localampw = (ampw)paramArrayList.get(i);
      if ((localampw.eX() != null) && (localampw.eX().size() == 0)) {
        if ((i - 1 < 0) || (!(paramArrayList.get(i - 1) instanceof ampf)) || (!((ampf)paramArrayList.get(i - 1)).getGroupName().equals(localampw.getGroupName()))) {
          break label322;
        }
      }
    }
    label322:
    for (int j = 1;; j = 0)
    {
      paramArrayList.remove(i);
      if (j != 0)
      {
        i -= 1;
        paramArrayList.remove(i);
      }
      for (;;)
      {
        bool1 = true;
        for (;;)
        {
          i -= 1;
          break;
          if ((a(localampw) != 0) && (i - 1 >= 0) && ((paramArrayList.get(i - 1) instanceof ampf)) && (((ampf)paramArrayList.get(i - 1)).getGroupName().equals(localampw.getGroupName())))
          {
            ampf localampf = (ampf)paramArrayList.get(i - 1);
            if ((localampf.a() != null) && (localampw.eX() != null)) {
              if (localampf.a().eX() != null) {
                if (localampf.a().eX().size() != localampw.eX().size())
                {
                  QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "add new group title");
                  paramArrayList.remove(i - 1);
                  paramArrayList.add(i - 1, new ampf(localampw));
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static int a(ampw paramampw)
  {
    int j = 1;
    int i;
    if ((paramampw instanceof ampm)) {
      i = 2;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while ((paramampw instanceof ampi));
      i = j;
    } while ((paramampw instanceof ampk));
    if ((paramampw instanceof amph)) {
      return 3;
    }
    return 0;
  }
  
  private static int a(amrg.a parama, List<ampx> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int j = 0;
    while (j < paramList.size())
    {
      ampx localampx = (ampx)paramList.get(j);
      String str = "";
      Object localObject;
      int i;
      if ((localampx instanceof ampt))
      {
        localObject = (ampt)localampx;
        if ((((ampt)localObject).S() instanceof String)) {
          str = (String)((ampt)localObject).S();
        }
        i = ((ampt)localObject).IU();
      }
      while ((str.equals(parama.a.identify)) && (i == parama.a.identifyType))
      {
        parama.cEf = true;
        parama.d = localampx;
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "bEffective ");
        return j;
        if ((localampx instanceof amow))
        {
          localObject = (amow)localampx;
          str = ((amow)localObject).uU();
          i = ((amow)localObject).IU();
        }
        else
        {
          QLog.e("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "unknown type extends ISearchResultModel");
          i = -1;
        }
      }
      j += 1;
    }
    return -1;
  }
  
  private static ampw a(Object paramObject)
  {
    if ((paramObject instanceof ampm))
    {
      paramObject = (ampm)paramObject;
      return new ampm(new ArrayList(paramObject.Bu), paramObject.getKeyword(), paramObject.sZ());
    }
    if ((paramObject instanceof ampi))
    {
      paramObject = (ampi)paramObject;
      return new ampi(new ArrayList(paramObject.Bu), paramObject.getKeyword(), paramObject.sZ());
    }
    if ((paramObject instanceof ampk))
    {
      paramObject = (ampk)paramObject;
      return new ampk(new ArrayList(paramObject.Bu), paramObject.getKeyword(), paramObject.sZ());
    }
    if ((paramObject instanceof amph))
    {
      paramObject = (amph)paramObject;
      return new amph(new ArrayList(paramObject.rc), paramObject.getKeyword(), paramObject.sZ());
    }
    return null;
  }
  
  public static ArrayList a(String paramString, ArrayList<amrg.a> paramArrayList, List paramList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject2;
    if (i < paramList.size())
    {
      localObject1 = paramList.get(i);
      localObject2 = a(localObject1);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      for (;;)
      {
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsed", 2, "the i name " + localArrayList.get(i).getClass().getName());
        i += 1;
        break;
        localArrayList.add(localObject1);
      }
    }
    Object localObject1 = new ArrayList();
    int j = 0;
    i = 0;
    int k;
    label163:
    boolean bool;
    if (j < paramArrayList.size())
    {
      localObject2 = (amrg.a)paramArrayList.get(j);
      k = 0;
      if (k < localArrayList.size())
      {
        if ((localArrayList.get(k) instanceof ampw))
        {
          int m = a((ampw)localArrayList.get(k));
          if ((m == 0) || (((amrg.a)localObject2).a.businessType != m)) {
            break label471;
          }
          bool = a((amrg.a)localObject2, (ampw)localArrayList.get(k));
          label236:
          if (!bool) {}
        }
      }
      else
      {
        if (((amrg.a)localObject2).cEf != true) {
          break label462;
        }
        if ((((amrg.a)localObject2).d instanceof ampt)) {
          ((ampt)((amrg.a)localObject2).d).PR(((amrg.a)localObject2).a.searchKey);
        }
        if ((((amrg.a)localObject2).d instanceof amow)) {
          ((amow)((amrg.a)localObject2).d).PR(((amrg.a)localObject2).a.searchKey);
        }
        ((ArrayList)localObject1).add(((amrg.a)localObject2).d);
        k = i + 1;
        i = k;
        if (k != 3) {
          break label462;
        }
      }
    }
    for (;;)
    {
      K(localArrayList);
      if (k > 0)
      {
        paramString = new ampo((List)localObject1, paramString);
        localArrayList.add(0, paramString);
        localArrayList.add(0, new ampf(paramString, paramString.getGroupName(), false));
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "add GroupSearchModelMostUsed");
      }
      QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "the finish Wash orgList size " + paramList.size() + " match mostUsedList size" + paramArrayList.size() + " resultlist " + localArrayList.size());
      return localArrayList;
      k += 1;
      break label163;
      label462:
      j += 1;
      break;
      label471:
      bool = false;
      break label236;
      k = i;
    }
  }
  
  private static void a(List paramList, int paramInt1, List<ampx> paramList1, amov paramamov, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList1.size() == 0))
    {
      QLog.e("MostUsedFilterForMultiGroupResultLists", 2, " no list to add");
      return;
    }
    int i = paramInt1;
    if (paramList.size() < paramInt1)
    {
      i = paramList.size();
      QLog.e("MostUsedFilterForMultiGroupResultLists", 2, " INDEX OUT OF RANGE");
    }
    QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "addListAndTitleToIndex " + paramList1.size());
    if ((paramInt2 > 0) && (paramList1.size() > paramInt2))
    {
      paramInt1 = paramList1.size() - 1;
      while (paramInt1 >= paramInt2)
      {
        paramList1.remove(paramInt1);
        paramInt1 -= 1;
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramamov != null)
      {
        paramamov = new amov(paramamov.getKeyword(), paramamov.ajO, paramamov.getGroupName(), paramList1, paramList1.size(), paramamov.zf(), paramamov.ze(), paramamov.FZ, paramamov.cDF, paramamov.cDG, paramamov.cDH, paramamov.cbj, paramamov.cbk);
        if ((!paramBoolean1) || (paramInt1 == 0)) {
          break label306;
        }
        if (TextUtils.isEmpty(paramamov.zf())) {
          break label291;
        }
        paramBoolean1 = true;
      }
      for (;;)
      {
        if (paramList1.size() <= 0) {
          break label310;
        }
        paramInt1 = paramList1.size() - 1;
        while (paramInt1 >= 0)
        {
          paramList.add(i, paramList1.get(paramInt1));
          paramInt1 -= 1;
        }
        paramamov = new amov();
        paramamov.Bu = paramList1;
        QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "oldTitleGroupMode is empty");
        break;
        label291:
        paramBoolean1 = false;
        QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "newModel.getMoreUrl() is empty");
        continue;
        label306:
        paramBoolean1 = false;
      }
      label310:
      break;
      paramList1 = new ampf(paramamov, paramBoolean1, paramamov.cDG);
      if (paramBoolean2) {
        paramList1.cDR = true;
      }
      paramList.add(i, paramList1);
      return;
    }
  }
  
  private static boolean a(amph paramamph, String paramString)
  {
    return (paramamph != null) && (paramamph.rc != null) && (paramamph.rc.size() > 0) && ((paramamph.rc.get(0) instanceof amow)) && (((amow)paramamph.rc.get(0)).name.equals(paramString));
  }
  
  private static boolean a(amqv paramamqv, String paramString)
  {
    if ((paramamqv == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if ((paramamqv.zB != null) && (paramamqv.zB.size() > 0))
    {
      paramamqv = (amqv.c)paramamqv.zB.get(0);
      if ((paramamqv != null) && (paramamqv.ax.toString().equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(amrg.a parama, ampw paramampw)
  {
    if (paramampw == null) {}
    int i;
    do
    {
      return false;
      i = a(parama, paramampw.eX());
    } while (i < 0);
    paramampw.eX().remove(i);
    return true;
  }
  
  public static boolean d(String paramString, ArrayList<String> paramArrayList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (paramString.equalsIgnoreCase((String)paramArrayList.next())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amrj
 * JD-Core Version:    0.7.0.1
 */