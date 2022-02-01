package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.base.Flat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class afb
{
  public static Map<String, Set<String>> a = new HashMap();
  public static Map<String, Integer> b = new HashMap();
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("18C867F0717AA67B2AB7347505BA07ED");
    a.put(aff.a(aff.J), localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("31223B0BDF1DEF1FE8252971ADA3B577");
    localHashSet.add("CCD4AD38DC6669F875BC37E3F8840648");
    localHashSet.add("AA3978F41FD96FF9914A669E186474C7");
    localHashSet.add("775E696D09856872FDD8AB4F3F06B1E0");
    localHashSet.add("A6B745BF24A2C277527716F6F36EB68D");
    localHashSet.add("A01EECAB85E9E3BA2B0F6A158C855C29");
    a.put(aff.a(aff.K), localHashSet);
    b.put(aff.a(aff.J), Integer.valueOf(105118));
    b.put(aff.a(aff.K), Integer.valueOf(105178));
  }
  
  public static ArrayList<Flat> a(Context paramContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = paramContext.getPackageName();
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = b.get(str);
      if ((localObject1 != null) && (((Integer)localObject1).intValue() != afh.a))
      {
        localObject1 = aey.b(paramContext, str);
        localObject2 = new Flat();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(afm.c);
        localStringBuilder.append(afm.d);
        ((Flat)localObject2).sc = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject1);
        ((Flat)localObject2).tc = localStringBuilder.toString();
        localArrayList2.add(localObject2);
      }
    }
    localArrayList1.addAll(localArrayList2);
    localArrayList2 = new ArrayList();
    str = paramContext.getPackageName();
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = (Set)a.get(str);
      if ((localObject1 != null) && (((Set)localObject1).size() != 0))
      {
        paramContext = aey.b(paramContext, str);
        if (!TextUtils.isEmpty(paramContext))
        {
          int j = 0;
          localObject1 = ((Set)localObject1).iterator();
          do
          {
            i = j;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
          } while (!((String)((Iterator)localObject1).next()).equals(paramContext));
          int i = 1;
          if (i == 0)
          {
            localObject1 = new Flat();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(afm.c);
            ((StringBuilder)localObject2).append(afm.d);
            ((Flat)localObject1).sc = ((StringBuilder)localObject2).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append("_");
            ((StringBuilder)localObject2).append(paramContext);
            ((Flat)localObject1).tc = ((StringBuilder)localObject2).toString();
            localArrayList2.add(localObject1);
          }
        }
      }
    }
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }
  
  public static ArrayList<Flat> b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramContext.getPackageName();
    if (TextUtils.isEmpty(str)) {
      return localArrayList;
    }
    paramContext = aey.b(paramContext, str);
    Flat localFlat = new Flat();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(afm.c);
    localStringBuilder.append(afm.g);
    localFlat.sc = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramContext);
    localFlat.tc = localStringBuilder.toString();
    localArrayList.add(localFlat);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afb
 * JD-Core Version:    0.7.0.1
 */