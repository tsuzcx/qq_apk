package com.tencent.mobileqq.emosm.favroaming;

import afhf;
import afhs;
import afhu;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;

public class EmoAddedAuthCallback$4
  implements Runnable
{
  public EmoAddedAuthCallback$4(afhf paramafhf) {}
  
  public void run()
  {
    int i = ((afhu)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(149)).eA().size();
    if (i != afhs.cQW)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("local_size", String.valueOf(i));
      localHashMap.put("roaming_max_size", String.valueOf(afhs.cQW));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "AddFavEmotionError", false, 0L, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.4
 * JD-Core Version:    0.7.0.1
 */