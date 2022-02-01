package com.tencent.ttpic.trigger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FilamentTriggerCtrlItem
  extends TriggerCtrlItem
{
  private Map<String, List<TriggerCtrlItem>> animationTriggerMap = new HashMap();
  private List<TriggerCtrlItem> animationTriggers = new ArrayList();
  
  public void addTriggerCtrlItems(TriggerCtrlItem paramTriggerCtrlItem)
  {
    this.animationTriggers.add(paramTriggerCtrlItem);
  }
  
  public void addTriggerCtrlItems(List<TriggerCtrlItem> paramList) {}
  
  public List<String> getTriggerdAnimationItemNames()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.animationTriggers.iterator();
    while (localIterator.hasNext())
    {
      TriggerCtrlItem localTriggerCtrlItem = (TriggerCtrlItem)localIterator.next();
      if (localTriggerCtrlItem.isTriggered()) {
        localArrayList.add(localTriggerCtrlItem.getName());
      }
    }
    return localArrayList;
  }
  
  public Map<String, Integer> getTriggerdAnimationItems()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.animationTriggers.iterator();
    while (localIterator.hasNext())
    {
      TriggerCtrlItem localTriggerCtrlItem = (TriggerCtrlItem)localIterator.next();
      if (localTriggerCtrlItem.isFirstTriggered()) {
        localHashMap.put(localTriggerCtrlItem.getName(), Integer.valueOf(localTriggerCtrlItem.getTotalPlayCount()));
      } else if (!localTriggerCtrlItem.isTriggered()) {
        localHashMap.put(localTriggerCtrlItem.getName(), Integer.valueOf(-1));
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.trigger.FilamentTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */