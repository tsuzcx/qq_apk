package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.List;

public class DesktopSearchInfo
  extends DesktopItemInfo
{
  public List<String> keyword;
  public MiniAppInfo mAppInfo;
  
  public DesktopSearchInfo(MiniAppInfo paramMiniAppInfo, List<String> paramList, int paramInt)
  {
    this.mAppInfo = paramMiniAppInfo;
    this.keyword = paramList;
    this.mModuleType = paramInt;
    this.dragEnable = false;
    this.dropEnable = false;
    this.deleteEnable = false;
  }
  
  public String toString()
  {
    if (this.mAppInfo != null) {
      return this.mAppInfo.name;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo
 * JD-Core Version:    0.7.0.1
 */