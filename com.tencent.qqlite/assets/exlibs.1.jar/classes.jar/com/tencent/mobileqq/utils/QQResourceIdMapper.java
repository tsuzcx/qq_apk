package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.pluginsdk.ResourceIdMapper;

public class QQResourceIdMapper
  extends ResourceIdMapper
{
  public int getHostResourceId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 2130968605;
    case 1: 
      return 2130968606;
    case 2: 
      return 2130968637;
    case 7: 
      return 2130968639;
    case 3: 
      return 2130968590;
    case 6: 
      return 2130968588;
    case 5: 
      return 2130968587;
    case 4: 
      return 2130968591;
    }
    return 2131624261;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQResourceIdMapper
 * JD-Core Version:    0.7.0.1
 */