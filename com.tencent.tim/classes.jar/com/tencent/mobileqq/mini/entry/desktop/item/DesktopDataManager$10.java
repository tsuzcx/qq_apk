package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DesktopDataManager$10
  implements Runnable
{
  DesktopDataManager$10(DesktopDataManager paramDesktopDataManager, INTERFACE.StModuleInfo paramStModuleInfo) {}
  
  public void run()
  {
    int j = 0;
    Object localObject1;
    Object localObject2;
    int i;
    try
    {
      if ((this.val$moduleInfo != null) && (this.val$moduleInfo.useOld.get() == 1)) {
        return;
      }
      if ((this.val$moduleInfo == null) || (DesktopDataManager.access$1600(this.this$0) == null) || (this.val$moduleInfo.useOld.get() != 0) || (this.val$moduleInfo.userAppList.get() == null) || (this.val$moduleInfo.userAppList.get().size() <= 0)) {
        break label554;
      }
      localObject1 = new DesktopAppModuleInfo(this.val$moduleInfo.moduleType.get(), this.val$moduleInfo.title.get());
      if (((DesktopAppModuleInfo)localObject1).getModuleType() == 2) {
        DesktopDataManager.access$1700(this.this$0).clear();
      }
      ArrayList localArrayList1 = new ArrayList();
      localObject2 = this.val$moduleInfo.userAppList.get().iterator();
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Object localObject3 = (INTERFACE.StUserAppInfo)((Iterator)localObject2).next();
        localObject3 = new DesktopAppInfo(this.val$moduleInfo.moduleType.get(), MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject3));
        if ((((DesktopAppModuleInfo)localObject1).getModuleType() == 2) && (((DesktopAppInfo)localObject3).mMiniAppInfo != null))
        {
          RecommendAppInfo localRecommendAppInfo = new RecommendAppInfo(((DesktopAppInfo)localObject3).mMiniAppInfo.appId, 0, System.currentTimeMillis());
          QLog.d("DesktopDataManager-Recommend", 2, "updateModuleInfo add " + localRecommendAppInfo.toString());
          DesktopDataManager.access$1700(this.this$0).add(localRecommendAppInfo);
        }
        localArrayList1.add(localObject3);
      }
      i += 1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DesktopDataManager-Recommend", 2, "updateModuleInfo error!!!", localThrowable);
      return;
    }
    do
    {
      do
      {
        if (i >= DesktopDataManager.access$1600(this.this$0).size()) {
          break;
        }
        localObject1 = (DesktopItemInfo)DesktopDataManager.access$1600(this.this$0).get(i);
      } while ((!(localObject1 instanceof DesktopAppInfo)) || (((DesktopItemInfo)localObject1).mModuleType != this.val$moduleInfo.moduleType.get()));
      localObject1 = (DesktopAppInfo)localObject1;
    } while ((((DesktopAppInfo)localObject1).mMiniAppInfo == null) || (((DesktopAppInfo)localObject1).mMiniAppInfo.isSpecialMiniApp()));
    for (;;)
    {
      localObject1 = DesktopDataManager.access$1600(this.this$0).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DesktopItemInfo)((Iterator)localObject1).next();
        if (((localObject2 instanceof DesktopAppInfo)) && (((DesktopItemInfo)localObject2).mModuleType == this.val$moduleInfo.moduleType.get()))
        {
          localObject2 = (DesktopAppInfo)localObject2;
          if ((((DesktopAppInfo)localObject2).mMiniAppInfo != null) && (!((DesktopAppInfo)localObject2).mMiniAppInfo.isSpecialMiniApp())) {
            ((Iterator)localObject1).remove();
          }
        }
      }
      if ((i != -1) && (localThrowable.size() > 0)) {
        DesktopDataManager.access$1600(this.this$0).addAll(i, localThrowable);
      }
      QLog.d("DesktopDataManager", 1, "updateModuleInfo, recommend list: " + localThrowable.toString());
      label554:
      DesktopDataManager.access$1800(this.this$0);
      DesktopDataManager.access$1900(DesktopDataManager.access$1600(this.this$0));
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.addAll(DesktopDataManager.access$1600(this.this$0));
      DesktopDataManager.access$2000(this.this$0, localArrayList2);
      if (DesktopDataManager.access$1500(this.this$0) == null) {
        break;
      }
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.10
 * JD-Core Version:    0.7.0.1
 */