import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class akza
{
  private static final SparseArray<int[]> de = new SparseArray();
  private static final SparseArray<akyu> df = new SparseArray();
  private static final SparseArray<akyy> dg = new SparseArray();
  
  static
  {
    de.put(101, xro.hz);
    de.put(105, xro.hE);
    de.put(102, xro.hL);
    de.put(103, xro.hS);
    de.put(106, xro.hW);
    de.put(104, xro.id);
    dg.put(201, akyy.a(PlusPanel.fL, 130201));
    dg.put(202, akyy.a(PlusPanel.gF, 130202));
    dg.put(203, akyy.a(PlusPanel.gS, 130203));
    dg.put(204, akyy.a(PlusPanel.hc, 130204));
    dg.put(205, akyy.a(PlusPanel.fS, 130205));
    dg.put(206, akyy.a(PlusPanel.fT, 130206));
    dg.put(207, akyy.a(PlusPanel.gd, 130207));
    dg.put(220, akyy.a(PlusPanel.gg, 130220));
    dg.put(208, akyy.a(PlusPanel.gC, 130208));
    dg.put(209, akyy.a(PlusPanel.gT, 130209));
    dg.put(210, akyy.a(PlusPanel.gO, 130210));
    dg.put(211, akyy.a(PlusPanel.gr, 130211));
    dg.put(212, akyy.a(PlusPanel.gL, 130212));
    dg.put(213, akyy.a(PlusPanel.gy, 130213));
    dg.put(214, akyy.a(PlusPanel.gt, 130214));
    dg.put(215, akyy.a(PlusPanel.gR, 130215));
    dg.put(216, akyy.a(PlusPanel.gW, 130216));
    dg.put(217, akyy.a(PlusPanel.fF, 130217));
    dg.put(218, akyy.a(PlusPanel.fH, 130218));
    dg.put(219, akyy.a(PlusPanel.gx, 130219));
    dg.put(221, akyy.a(PlusPanel.gi, 130221));
  }
  
  public static akyu a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public static akyu a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = (akyu)df.get(paramInt);
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (akyt.b)aeif.a().o(496);
        if (localObject != null)
        {
          List localList = ((akyt.b)localObject).items;
          if (localList.size() > 0)
          {
            int i = 0;
            for (;;)
            {
              if (i >= localList.size()) {
                break label133;
              }
              localObject = (akyu)localList.get(i);
              int[] arrayOfInt = (int[])de.get(((akyu)localObject).id);
              if (arrayOfInt != null)
              {
                int j = arrayOfInt[0];
                if (paramInt == j) {
                  break;
                }
              }
              i += 1;
            }
          }
        }
        return null;
      }
      catch (Exception localException)
      {
        QLog.e("PlusPanelUtil", 1, localException, new Object[0]);
      }
    }
  }
  
  private static SparseIntArray a(boolean paramBoolean)
  {
    try
    {
      Object localObject;
      if (anwa.aze())
      {
        localObject = (akyw.a)aeif.a().o(611);
        if (localObject != null) {
          return ((akyw.a)localObject).ab;
        }
      }
      else
      {
        boolean bool = anlm.ayn();
        localObject = (akyw.a)aeif.a().o(495);
        if (localObject != null)
        {
          if (paramBoolean)
          {
            if (bool) {
              return ((akyw.a)localObject).ae;
            }
            return ((akyw.a)localObject).ad;
          }
          if (bool) {
            return ((akyw.a)localObject).ac;
          }
          localObject = ((akyw.a)localObject).ab;
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("PlusPanelUtil", 1, localException, new Object[0]);
    }
    return new SparseIntArray();
  }
  
  public static List<akyu> a(boolean paramBoolean, Context paramContext)
  {
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        Object localObject = (akyt.b)aeif.a().o(496);
        if (localObject != null)
        {
          localObject = ((akyt.b)localObject).items;
          if (((List)localObject).size() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            if (i < ((List)localObject).size())
            {
              akyu localakyu = (akyu)((List)localObject).get(i);
              arrayOfInt = (int[])de.get(localakyu.id);
              if (arrayOfInt != null) {
                break label215;
              }
              df.put(localakyu.id, localakyu);
              j = 1;
              if (j == 0) {
                break label220;
              }
              k = localakyu.id;
              localakyu.tag = k;
              localakyu.mDrawable = localakyu.aM();
              localakyu.fi = localakyu.aN();
              if (j == 0) {
                break label229;
              }
              j = 0;
              localakyu.dql = j;
              localakyu.mn = arrayOfInt;
              localArrayList.add(localakyu);
              i += 1;
              continue;
            }
            lL(localArrayList);
            a(localArrayList, paramContext);
            return localArrayList;
          }
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("PlusPanelUtil", 1, paramContext, new Object[0]);
      }
      return new ArrayList();
      label215:
      int j = 0;
      continue;
      label220:
      int k = arrayOfInt[0];
      continue;
      label229:
      j = arrayOfInt[3];
    }
  }
  
  private static void a(List<akyu> paramList, Context paramContext)
  {
    int i = v(paramList);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PlusPanelUtil", 2, "did not have camera icon");
      }
      return;
    }
    int[] arrayOfInt = xro.hV;
    akyu localakyu = new akyu();
    localakyu.tag = 6;
    localakyu.contentDescription = paramContext.getResources().getString(arrayOfInt[1]);
    localakyu.dql = arrayOfInt[3];
    localakyu.mn = arrayOfInt;
    if (ShortVideoUtils.awN())
    {
      localakyu.mDrawable = paramContext.getResources().getDrawable(arrayOfInt[2]);
      paramList.add(i, localakyu);
      return;
    }
    de.put(103, xro.hV);
    localakyu.mDrawable = paramContext.getResources().getDrawable(xro.hS[2]);
    paramList.set(i, localakyu);
  }
  
  private static void az(List<TroopAIOAppInfo> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      SparseIntArray localSparseIntArray = a(paramBoolean);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
        int i = localSparseIntArray.get(localTroopAIOAppInfo.appid, -1);
        if (i >= 0) {
          localTroopAIOAppInfo.sort = i;
        } else {
          localIterator.remove();
        }
      }
      Collections.sort(paramList);
    }
  }
  
  private static akyv.d b(int paramInt)
  {
    return (akyv.d)aeif.a().o(paramInt);
  }
  
  static String eI(int paramInt)
  {
    akyy localakyy = (akyy)dg.get(paramInt);
    if (localakyy != null) {
      return String.valueOf(localakyy.dqm);
    }
    return "";
  }
  
  private static void lL(List<akyu> paramList)
  {
    Collections.sort(paramList);
  }
  
  public static int[] m(int paramInt)
  {
    akyy localakyy = (akyy)dg.get(paramInt);
    if (localakyy != null) {
      return localakyy.mo;
    }
    return null;
  }
  
  public static int[] n(int paramInt)
  {
    if (de != null) {
      return (int[])de.get(paramInt);
    }
    return null;
  }
  
  private static int v(List<akyu> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((((akyu)paramList.get(i)).tag == 5) || (((akyu)paramList.get(i)).tag == 6)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static List<TroopAIOAppInfo> v(boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(b(502));
        localArrayList2.add(b(503));
        localArrayList2.add(b(504));
        localArrayList2.add(b(506));
        localArrayList2.add(b(507));
        localArrayList2.add(b(509));
        localArrayList2.add(b(515));
        localArrayList2.add(b(519));
        localArrayList2.add(b(517));
        localArrayList2.add(b(511));
        localArrayList2.add(b(513));
        localArrayList2.add(b(510));
        localArrayList2.add(b(2049));
        int j = localArrayList2.size();
        i = 0;
        if (i < j)
        {
          akyv.d locald = (akyv.d)localArrayList2.get(i);
          if (locald.b.appid > 0) {
            localArrayList1.add(locald.b);
          }
        }
        else
        {
          az(localArrayList1, paramBoolean);
          return localArrayList1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("PlusPanelUtil", 1, localException, new Object[0]);
        return localArrayList1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akza
 * JD-Core Version:    0.7.0.1
 */