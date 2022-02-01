package com.tencent.ttpic.trigger;

import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HairCosTriggerCtrlItem
  extends TriggerCtrlItem
{
  private List<HairCosInfo> hairCosInfos = new ArrayList();
  private int mvPartIndex = -1;
  private Map<String, Integer> renderHairItem;
  private List<StickerItem> stickerItems;
  
  public HairCosTriggerCtrlItem(List<StickerItem> paramList)
  {
    this.stickerItems = paramList;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)paramList.next();
        this.hairCosInfos.add(new HairCosInfo(localStickerItem.id, localStickerItem.activeParts, localStickerItem.genderType, new TriggerCtrlItem(localStickerItem)));
      }
    }
  }
  
  public Map<String, Integer> getRenderHairItem()
  {
    return this.renderHairItem;
  }
  
  public void hitCharmRange(double paramDouble)
  {
    if (this.stickerItems != null)
    {
      Iterator localIterator = this.stickerItems.iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if (localStickerItem.charmRange != null) {
          localStickerItem.charmRange.hit(paramDouble);
        }
      }
    }
    updateTriggerStatus(this.detectInfo);
  }
  
  public boolean isTriggered()
  {
    return (this.renderHairItem != null) && (this.renderHairItem.size() > 0);
  }
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo)
  {
    if (paramPTDetectInfo == null) {}
    for (;;)
    {
      return;
      this.renderHairItem = null;
      Iterator localIterator = this.hairCosInfos.iterator();
      while (localIterator.hasNext())
      {
        HairCosInfo localHairCosInfo = (HairCosInfo)localIterator.next();
        if (localHairCosInfo.updateTriggerStatus(paramPTDetectInfo, this.mvPartIndex))
        {
          if (this.renderHairItem == null) {
            this.renderHairItem = new HashMap();
          }
          this.renderHairItem.put(localHairCosInfo.id, Integer.valueOf(localHairCosInfo.getFrameIndex()));
        }
      }
    }
  }
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo, int paramInt)
  {
    this.detectInfo = paramPTDetectInfo;
    this.mvPartIndex = paramInt;
    updateTriggerStatus(paramPTDetectInfo);
  }
  
  public class HairCosInfo
  {
    public int[] activeParts;
    public int genderType = 0;
    public String id;
    public boolean needRender = false;
    public TriggerCtrlItem triggerCtrlItem;
    
    public HairCosInfo(String paramString, int[] paramArrayOfInt, int paramInt, TriggerCtrlItem paramTriggerCtrlItem)
    {
      this.id = paramString;
      this.activeParts = paramArrayOfInt;
      this.genderType = paramInt;
      this.triggerCtrlItem = paramTriggerCtrlItem;
    }
    
    private boolean isInCurPart(int paramInt, int[] paramArrayOfInt)
    {
      if ((paramArrayOfInt == null) || (paramInt < 0)) {
        return true;
      }
      int j = paramArrayOfInt.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label36;
        }
        if (paramArrayOfInt[i] == paramInt) {
          break;
        }
        i += 1;
      }
      label36:
      return false;
    }
    
    public int getFrameIndex()
    {
      return this.triggerCtrlItem.getFrameIndex();
    }
    
    public boolean updateTriggerStatus(PTDetectInfo paramPTDetectInfo)
    {
      this.triggerCtrlItem.updateTriggerStatus(paramPTDetectInfo);
      this.needRender = this.triggerCtrlItem.isTriggered();
      return this.needRender;
    }
    
    public boolean updateTriggerStatus(PTDetectInfo paramPTDetectInfo, int paramInt)
    {
      this.triggerCtrlItem.updateTriggerStatus(paramPTDetectInfo);
      if ((this.triggerCtrlItem.isTriggered()) && (isInCurPart(paramInt, this.activeParts)) && ((this.genderType == 0) || ((paramPTDetectInfo.faceStatus != null) && (this.genderType == paramPTDetectInfo.faceStatus.gender)))) {}
      for (boolean bool = true;; bool = false)
      {
        this.needRender = bool;
        return this.needRender;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.trigger.HairCosTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */