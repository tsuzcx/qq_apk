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
      return 2130968607;
    case 1: 
      return 2130968608;
    case 2: 
      return 2130968681;
    case 7: 
      return 2130968683;
    case 3: 
      return 2130968596;
    case 6: 
      return 2130968594;
    case 5: 
      return 2130968593;
    case 4: 
      return 2130968597;
    }
    return 2131624269;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQResourceIdMapper
 * JD-Core Version:    0.7.0.1
 */