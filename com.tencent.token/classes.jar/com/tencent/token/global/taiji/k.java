package com.tencent.token.global.taiji;

import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager.IProfileUploadCallback;
import tmsdk.common.module.pgsdk.manager.shark.ISharkCallBack;

public class k
  implements ITaijiKVProfileManager
{
  public static k a()
  {
    return a.a();
  }
  
  public void uploadKVProfile(HashMap<Integer, String> paramHashMap, HashMap<Integer, Integer> paramHashMap1, final ITaijiKVProfileManager.IProfileUploadCallback paramIProfileUploadCallback)
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
    m.a().sendShark(1053, localCSReportProfile, new SCReportProfile(), 18, new ISharkCallBack()
    {
      public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {
          paramIProfileUploadCallback.onUploadSuccess();
        }
      }
    });
  }
  
  private static final class a
  {
    private static final k a = new k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.k
 * JD-Core Version:    0.7.0.1
 */