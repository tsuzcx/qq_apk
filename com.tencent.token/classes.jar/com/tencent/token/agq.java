package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.qps.Damson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class agq
{
  public static Map<String, Set<String>> a = new HashMap();
  public static Map<String, Integer> b = new HashMap();
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("18C867F0717AA67B2AB7347505BA07ED");
    Map localMap = a;
    int[] arrayOfInt1 = agg.J;
    localMap.put(agg.a(arrayOfInt1), localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("31223B0BDF1DEF1FE8252971ADA3B577");
    localHashSet.add("CCD4AD38DC6669F875BC37E3F8840648");
    localHashSet.add("AA3978F41FD96FF9914A669E186474C7");
    localHashSet.add("775E696D09856872FDD8AB4F3F06B1E0");
    localHashSet.add("A6B745BF24A2C277527716F6F36EB68D");
    localHashSet.add("A01EECAB85E9E3BA2B0F6A158C855C29");
    localMap = a;
    int[] arrayOfInt2 = agg.K;
    localMap.put(agg.a(arrayOfInt2), localHashSet);
    b.put(agg.a(arrayOfInt1), Integer.valueOf(105118));
    b.put(agg.a(arrayOfInt2), Integer.valueOf(105178));
  }
  
  public static ArrayList<Damson> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramContext.getPackageName();
    if (TextUtils.isEmpty(str)) {
      return localArrayList;
    }
    paramContext = adj.a(paramContext, str);
    Damson localDamson = new Damson();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ago.c);
    localStringBuilder.append(ago.g);
    localDamson.a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramContext);
    localDamson.b = localStringBuilder.toString();
    localArrayList.add(localDamson);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agq
 * JD-Core Version:    0.7.0.1
 */