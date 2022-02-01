package com.tencent.mobileqq.app.automator.step;

import QC.Hamlet;
import QC.HamletCheck;
import QC.UniBusinessCheckItem;
import QC.UniBusinessItem;
import QC.UniLoginCheckRsp;
import acci;
import acff;
import acle;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import aqsx;
import aqsz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ChatBackgroundAuth
  extends AsyncStep
{
  private Hamlet a(ArrayList<Hamlet> paramArrayList, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Hamlet localHamlet = (Hamlet)paramArrayList.next();
      if ((localHamlet.uid == Long.parseLong(paramString)) && (paramInt == localHamlet.locationtype)) {
        return localHamlet;
      }
    }
    return null;
  }
  
  private ArrayList<Hamlet> a(HashMap<String, Integer> paramHashMap1, HashMap<String, Integer> paramHashMap2, acff paramacff, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramacff, paramHashMap1, localArrayList, paramInt1);
    a(paramacff, paramHashMap2, localArrayList, paramInt2);
    return localArrayList;
  }
  
  private void a(acff paramacff, HashMap<String, Integer> paramHashMap, ArrayList<Hamlet> paramArrayList, int paramInt)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    Object localObject3;
    Object localObject2;
    Object localObject1;
    UniBusinessItem localUniBusinessItem;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject3 = (String)localIterator.next();
        localObject2 = (Integer)paramHashMap.get(localObject3);
        localObject1 = null;
        if (localObject2 != null)
        {
          localUniBusinessItem = new UniBusinessItem(paramInt, ((Integer)localObject2).intValue());
          if (((String)localObject3).contains("_"))
          {
            localObject3 = ((String)localObject3).split("_");
            localObject1 = localObject3[0];
            i = Integer.parseInt(localObject3[1]);
            if (i > -1) {
              i = gE(i);
            }
          }
        }
      }
    }
    for (;;)
    {
      label115:
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "friendUin:" + (String)localObject1 + " serverUinType:" + i + " appId:" + paramInt + " id:" + localObject2);
      }
      localObject2 = a(paramArrayList, (String)localObject1, i);
      if (localObject2 == null)
      {
        localObject2 = new ArrayList();
        localObject1 = new Hamlet(Long.parseLong((String)localObject1), i, (ArrayList)localObject2);
        paramArrayList.add(localObject1);
      }
      for (;;)
      {
        ((Hamlet)localObject1).itemlist.add(localUniBusinessItem);
        break;
        if (paramacff.isFriend((String)localObject1))
        {
          i = 2;
          break label115;
        }
        i = 3;
        break label115;
        if (!"null".equals(localObject3)) {
          break label298;
        }
        localObject1 = this.a.app.getCurrentUin();
        i = 1;
        break label115;
        return;
        localObject1 = localObject2;
      }
      label298:
      i = 1;
    }
  }
  
  public static int gD(int paramInt)
  {
    if (paramInt == 3) {
      return 1;
    }
    if (paramInt == 2) {
      return 0;
    }
    return -1;
  }
  
  public static int gE(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 3;
    }
    while (paramInt != 0) {
      return i;
    }
    return 2;
  }
  
  public int od()
  {
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("lastChabgAuthTime", 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "doStep start auth");
      }
      Object localObject = (ChatBackgroundManager)this.a.app.getManager(63);
      HashMap localHashMap = ((ChatBackgroundManager)localObject).M();
      localObject = ((ChatBackgroundManager)localObject).O();
      ((acle)this.a.app.getBusinessHandler(13)).a(a(localHashMap, (HashMap)localObject, (acff)this.a.app.getManager(51), 8, 35), new a(this.a.app), true);
      localSharedPreferences.edit().putLong("lastChabgAuthTime", System.currentTimeMillis()).apply();
    }
    if (!aqsx.a.ad(this.a.app, "namePlate_UrlConfig")) {
      aqsx.a.download(null, "namePlate_UrlConfig", null, false);
    }
    return 7;
  }
  
  static class a
    implements acci
  {
    private WeakReference<QQAppInterface> gj;
    
    public a(QQAppInterface paramQQAppInterface)
    {
      this.gj = new WeakReference(paramQQAppInterface);
    }
    
    public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
      if (localQQAppInterface == null) {}
      for (;;)
      {
        return;
        if ((paramObject instanceof UniLoginCheckRsp))
        {
          aqsz.a(localQQAppInterface).a(((UniLoginCheckRsp)paramObject).stKeyWord);
          paramObject = (UniLoginCheckRsp)paramObject;
          if (paramObject.ret != 0) {
            break;
          }
          ChatBackgroundManager localChatBackgroundManager = (ChatBackgroundManager)localQQAppInterface.getManager(63);
          localChatBackgroundManager.dwd();
          localChatBackgroundManager.N();
          if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "bg and effect id clear");
          }
          Iterator localIterator = paramObject.stHamletList.iterator();
          while (localIterator.hasNext())
          {
            HamletCheck localHamletCheck = (HamletCheck)localIterator.next();
            if ((localHamletCheck.itemlist != null) && (localHamletCheck.itemlist.size() > 0))
            {
              int i = -1;
              paramInt = -1;
              paramObject = localHamletCheck.itemlist.iterator();
              Object localObject;
              while (paramObject.hasNext())
              {
                localObject = (UniBusinessCheckItem)paramObject.next();
                if (((UniBusinessCheckItem)localObject).appid == 8) {
                  i = ((UniBusinessCheckItem)localObject).itemid;
                } else if (((UniBusinessCheckItem)localObject).appid == 35) {
                  paramInt = ((UniBusinessCheckItem)localObject).itemid;
                }
              }
              if (i >= 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QQInitHandler", 2, "bgId:" + i + " effectId:" + paramInt);
                }
                localObject = String.valueOf(localHamletCheck.uid);
                paramObject = localObject;
                if (localQQAppInterface.getAccount().equals(localObject))
                {
                  paramObject = localObject;
                  if (localHamletCheck.locationtype == 1) {
                    paramObject = null;
                  }
                }
                if ((!"99".equals(String.valueOf(i))) || (paramInt > 0)) {
                  localChatBackgroundManager.a(i, paramInt, paramObject, "chatbgAuth", ChatBackgroundAuth.gD(localHamletCheck.locationtype));
                }
              }
            }
          }
        }
      }
      QLog.e("QQInitHandler", 1, "onResponse: ret:" + paramObject.ret + " errmsg:" + paramObject.errmsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth
 * JD-Core Version:    0.7.0.1
 */