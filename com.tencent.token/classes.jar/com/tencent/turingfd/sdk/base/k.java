package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class k
{
  public static Map a = new HashMap();
  public static Map b = new HashMap();
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("18C867F0717AA67B2AB7347505BA07ED");
    a.put(db.a(db.F), localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("31223B0BDF1DEF1FE8252971ADA3B577");
    localHashSet.add("CCD4AD38DC6669F875BC37E3F8840648");
    localHashSet.add("AA3978F41FD96FF9914A669E186474C7");
    localHashSet.add("775E696D09856872FDD8AB4F3F06B1E0");
    localHashSet.add("A6B745BF24A2C277527716F6F36EB68D");
    localHashSet.add("A01EECAB85E9E3BA2B0F6A158C855C29");
    a.put(db.a(db.G), localHashSet);
    b.put(db.a(db.F), Integer.valueOf(105118));
    b.put(db.a(db.G), Integer.valueOf(105178));
  }
  
  public static ArrayList a(Context paramContext)
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
        break label180;
      }
    }
    label180:
    label344:
    for (;;)
    {
      localArrayList1.addAll(localArrayList2);
      return localArrayList1;
      Object localObject = b.get(str);
      if ((localObject == null) || (((Integer)localObject).intValue() == 105678)) {
        break;
      }
      localObject = ed.a(paramContext, str);
      Fig localFig = new Fig();
      localFig.vc = (dk.c + dk.d);
      localFig.wc = (str + "_" + (String)localObject);
      localArrayList2.add(localFig);
      break;
      localObject = (Set)a.get(str);
      if ((localObject != null) && (((Set)localObject).size() != 0))
      {
        paramContext = ed.a(paramContext, str);
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
              break label344;
            }
            localObject = new Fig();
            ((Fig)localObject).vc = (dk.c + dk.d);
            ((Fig)localObject).wc = (str + "_" + paramContext);
            localArrayList2.add(localObject);
            break;
          }
        }
      }
    }
  }
  
  public static ArrayList b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramContext.getPackageName();
    if (TextUtils.isEmpty(str)) {
      return localArrayList;
    }
    paramContext = ed.a(paramContext, str);
    Fig localFig = new Fig();
    localFig.vc = (dk.c + dk.g);
    localFig.wc = (str + "_" + paramContext);
    localArrayList.add(localFig);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.k
 * JD-Core Version:    0.7.0.1
 */