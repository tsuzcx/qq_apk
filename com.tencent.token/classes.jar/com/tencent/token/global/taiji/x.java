package com.tencent.token.global.taiji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager.IProfileUploadCallback;

public class x
  implements ITaijiKVProfileManager
{
  public static x a()
  {
    return z.a();
  }
  
  public void uploadKVProfile(HashMap paramHashMap1, HashMap paramHashMap2, ITaijiKVProfileManager.IProfileUploadCallback paramIProfileUploadCallback)
  {
    CSReportProfile localCSReportProfile = new CSReportProfile();
    localCSReportProfile.profileID = 4;
    localCSReportProfile.actionID = 0;
    localCSReportProfile.param = new ArrayList();
    Object localObject1;
    Object localObject2;
    if ((paramHashMap1 != null) && (paramHashMap1.size() > 0))
    {
      localObject1 = paramHashMap1.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        KeyValueProfile localKeyValueProfile = new KeyValueProfile();
        localKeyValueProfile.keyid = ((Integer)localObject2).intValue();
        localKeyValueProfile.valueType = 3;
        localKeyValueProfile.str = ((String)paramHashMap1.get(localObject2));
        localCSReportProfile.param.add(localKeyValueProfile.toByteArray("UTF-8"));
      }
    }
    if ((paramHashMap2 != null) && (paramHashMap2.size() > 0))
    {
      paramHashMap1 = paramHashMap2.keySet().iterator();
      while (paramHashMap1.hasNext())
      {
        localObject1 = (Integer)paramHashMap1.next();
        localObject2 = new KeyValueProfile();
        ((KeyValueProfile)localObject2).keyid = ((Integer)localObject1).intValue();
        ((KeyValueProfile)localObject2).valueType = 1;
        ((KeyValueProfile)localObject2).i = ((Integer)paramHashMap2.get(localObject1)).intValue();
        localCSReportProfile.param.add(((KeyValueProfile)localObject2).toByteArray("UTF-8"));
      }
    }
    ab.a().sendShark(1053, localCSReportProfile, new SCReportProfile(), 18, new y(this, paramIProfileUploadCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.x
 * JD-Core Version:    0.7.0.1
 */