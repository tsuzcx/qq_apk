package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class cp
{
  public static Map<String, Set<String>> a = new HashMap();
  public static Map<String, Integer> b = new HashMap();
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("18C867F0717AA67B2AB7347505BA07ED");
    a.put(ct.a(ct.J), localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("31223B0BDF1DEF1FE8252971ADA3B577");
    localHashSet.add("CCD4AD38DC6669F875BC37E3F8840648");
    localHashSet.add("AA3978F41FD96FF9914A669E186474C7");
    localHashSet.add("775E696D09856872FDD8AB4F3F06B1E0");
    localHashSet.add("A6B745BF24A2C277527716F6F36EB68D");
    localHashSet.add("A01EECAB85E9E3BA2B0F6A158C855C29");
    a.put(ct.a(ct.K), localHashSet);
    b.put(ct.a(ct.J), Integer.valueOf(105118));
    b.put(ct.a(ct.K), Integer.valueOf(105178));
  }
  
  public static ArrayList<Flat> a(Context paramContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = paramContext.getPackageName();
    if (TextUtils.isEmpty(str))
    {
      localArrayList1.addAll(localArrayList2);
      localArrayList2 = new ArrayList();
      str = paramContext.getPackageName();
      if (!TextUtils.isEmpty(str)) {
        break label181;
      }
    }
    label181:
    label345:
    for (;;)
    {
      localArrayList1.addAll(localArrayList2);
      return localArrayList1;
      Object localObject = b.get(str);
      if ((localObject == null) || (((Integer)localObject).intValue() == cv.a)) {
        break;
      }
      localObject = cm.b(paramContext, str);
      Flat localFlat = new Flat();
      localFlat.sc = (da.c + da.d);
      localFlat.tc = (str + "_" + (String)localObject);
      localArrayList2.add(localFlat);
      break;
      localObject = (Set)a.get(str);
      if ((localObject != null) && (((Set)localObject).size() != 0))
      {
        paramContext = cm.b(paramContext, str);
        if (!TextUtils.isEmpty(paramContext))
        {
          localObject = ((Set)localObject).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!((String)((Iterator)localObject).next()).equals(paramContext));
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label345;
            }
            localObject = new Flat();
            ((Flat)localObject).sc = (da.c + da.d);
            ((Flat)localObject).tc = (str + "_" + paramContext);
            localArrayList2.add(localObject);
            break;
          }
        }
      }
    }
  }
  
  public static ArrayList<Flat> b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramContext.getPackageName();
    if (TextUtils.isEmpty(str)) {
      return localArrayList;
    }
    paramContext = cm.b(paramContext, str);
    Flat localFlat = new Flat();
    localFlat.sc = (da.c + da.g);
    localFlat.tc = (str + "_" + paramContext);
    localArrayList.add(localFlat);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cp
 * JD-Core Version:    0.7.0.1
 */