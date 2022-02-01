package com.tencent.token;

import com.qq.taf.jce.JceStruct;
import com.tencent.token.global.taiji.CSReportProfile;
import com.tencent.token.global.taiji.KeyValueProfile;
import com.tencent.token.global.taiji.SCReportProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class yk
  implements ava
{
  public final void a(HashMap<Integer, String> paramHashMap, HashMap<Integer, Integer> paramHashMap1, final ava.a parama)
  {
    CSReportProfile localCSReportProfile = new CSReportProfile();
    localCSReportProfile.profileID = 4;
    localCSReportProfile.actionID = 0;
    localCSReportProfile.param = new ArrayList();
    Object localObject1;
    Object localObject2;
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      localObject1 = paramHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        KeyValueProfile localKeyValueProfile = new KeyValueProfile();
        localKeyValueProfile.keyid = ((Integer)localObject2).intValue();
        localKeyValueProfile.valueType = 3;
        localKeyValueProfile.str = ((String)paramHashMap.get(localObject2));
        localCSReportProfile.param.add(localKeyValueProfile.toByteArray("UTF-8"));
      }
    }
    if ((paramHashMap1 != null) && (paramHashMap1.size() > 0))
    {
      paramHashMap = paramHashMap1.keySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject1 = (Integer)paramHashMap.next();
        localObject2 = new KeyValueProfile();
        ((KeyValueProfile)localObject2).keyid = ((Integer)localObject1).intValue();
        ((KeyValueProfile)localObject2).valueType = 1;
        ((KeyValueProfile)localObject2).i = ((Integer)paramHashMap1.get(localObject1)).intValue();
        localCSReportProfile.param.add(((KeyValueProfile)localObject2).toByteArray("UTF-8"));
      }
    }
    ym.a.a().a(1053, localCSReportProfile, new SCReportProfile(), 18, new avg()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, JceStruct paramAnonymousJceStruct)
      {
        if ((paramAnonymousInt2 == 0) && (paramAnonymousInt3 == 0)) {
          parama.a();
        }
      }
    });
  }
  
  static final class a
  {
    private static final yk a = new yk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yk
 * JD-Core Version:    0.7.0.1
 */