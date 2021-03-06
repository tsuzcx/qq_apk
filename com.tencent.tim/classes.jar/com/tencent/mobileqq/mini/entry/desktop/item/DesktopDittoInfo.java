package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DesktopDittoInfo
  extends DesktopItemInfo
{
  public List<MiniAppInfo> appInfoList = new ArrayList();
  public Map<String, MiniAppInfo> appInfoMap = new HashMap();
  public int currentIndex;
  public String dittoDls;
  public MiniAppInfo jumpMoreInfo;
  public int subType;
  public String title;
  
  public DesktopDittoInfo(int paramInt)
  {
    this.mModuleType = paramInt;
    this.dragEnable = false;
    this.dropEnable = false;
    this.deleteEnable = false;
  }
  
  private boolean hasRepeatApp()
  {
    return this.subType == 5;
  }
  
  public void incrementIndex()
  {
    this.currentIndex += 1;
  }
  
  public void mergePbData(INTERFACE.StModuleInfo paramStModuleInfo)
  {
    this.title = paramStModuleInfo.title.get();
    this.dittoDls = paramStModuleInfo.dittoDsl.get();
    this.jumpMoreInfo = MiniAppInfo.from(paramStModuleInfo.jumpMoreApp);
    this.subType = paramStModuleInfo.subTypes.get();
    if ((paramStModuleInfo.userAppList != null) && (paramStModuleInfo.userAppList.get().size() > 0))
    {
      paramStModuleInfo = paramStModuleInfo.userAppList.get().iterator();
      while (paramStModuleInfo.hasNext())
      {
        MiniAppInfo localMiniAppInfo = MiniAppInfo.from((INTERFACE.StUserAppInfo)paramStModuleInfo.next());
        if (localMiniAppInfo != null) {
          if (hasRepeatApp()) {
            this.appInfoList.add(localMiniAppInfo);
          } else {
            this.appInfoMap.put(localMiniAppInfo.appId, localMiniAppInfo);
          }
        }
      }
    }
    this.currentIndex = 0;
  }
  
  public String toString()
  {
    return this.title + "_" + this.mModuleType;
  }
  
  public static class DittoType
  {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_FEEDS = 5;
    public static final int TYPE_FRIENDS_PLAYING = 2;
    public static final int TYPE_QUICK_MATCH = 4;
    public static final int TYPE_RECOMMEND = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo
 * JD-Core Version:    0.7.0.1
 */