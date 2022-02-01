package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants.ElementFormatMode;
import java.util.HashSet;
import java.util.Set;

public class DTHandleEventFormatFactory
{
  private static final Set<String> APP_KEY_SET;
  private static final Set<String> PAGE_KEY_SET;
  private static final Set<String> VIEW_KEY_SET = new HashSet();
  @DTConfigConstants.ElementFormatMode
  private static int sElementFormatMode;
  
  static
  {
    APP_KEY_SET = new HashSet();
    PAGE_KEY_SET = new HashSet();
    sElementFormatMode = 0;
    VIEW_KEY_SET.add("imp");
    VIEW_KEY_SET.add("clck");
    VIEW_KEY_SET.add("imp_end");
    APP_KEY_SET.add("appout");
    APP_KEY_SET.add("appin");
    APP_KEY_SET.add("vst");
    APP_KEY_SET.add("act");
    PAGE_KEY_SET.add("pgin");
    PAGE_KEY_SET.add("pgout");
  }
  
  public static IEventMapHandler fetchEventHandler(String paramString)
  {
    if (VIEW_KEY_SET.contains(paramString))
    {
      switch (sElementFormatMode)
      {
      default: 
        return EventHandlerHolder.getViewNonFlattenEventHandler();
      }
      return EventHandlerHolder.getViewFlattenEventHandler();
    }
    if (APP_KEY_SET.contains(paramString)) {
      return EventHandlerHolder.getAppEventHandler();
    }
    if (PAGE_KEY_SET.contains(paramString)) {
      return EventHandlerHolder.getPageEventHandler();
    }
    return null;
  }
  
  public static void setElementFormatMode(@DTConfigConstants.ElementFormatMode int paramInt)
  {
    sElementFormatMode = paramInt;
  }
  
  static class EventHandlerHolder
  {
    private static DTAppEventMapHandler sAppOutEventHandler;
    private static DTPageEventMapHandler sPageEventHandler;
    private static DTViewFlattenEventMapHandler sViewFlattenEventHandler;
    private static DTViewNonFlattenEventMapHandler sViewNonFlattenEventHandler;
    
    static DTAppEventMapHandler getAppEventHandler()
    {
      if (sAppOutEventHandler == null) {
        sAppOutEventHandler = new DTAppEventMapHandler();
      }
      return sAppOutEventHandler;
    }
    
    static DTPageEventMapHandler getPageEventHandler()
    {
      if (sPageEventHandler == null) {
        sPageEventHandler = new DTPageEventMapHandler();
      }
      return sPageEventHandler;
    }
    
    static DTViewFlattenEventMapHandler getViewFlattenEventHandler()
    {
      if (sViewFlattenEventHandler == null) {
        sViewFlattenEventHandler = new DTViewFlattenEventMapHandler();
      }
      return sViewFlattenEventHandler;
    }
    
    static DTViewNonFlattenEventMapHandler getViewNonFlattenEventHandler()
    {
      if (sViewNonFlattenEventHandler == null) {
        sViewNonFlattenEventHandler = new DTViewNonFlattenEventMapHandler();
      }
      return sViewNonFlattenEventHandler;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory
 * JD-Core Version:    0.7.0.1
 */