package com.tencent.mobileqq.vas.avatar;

import aqsg;
import java.util.ArrayList;

public class IdleGetDynamic
  extends IdleUpdater
{
  private ArrayList<aqsg> list;
  
  public IdleGetDynamic()
  {
    super(32);
  }
  
  public void a(aqsg paramaqsg)
  {
    try
    {
      if (this.list == null) {
        this.list = new ArrayList();
      }
      this.list.add(paramaqsg);
      if (this.list.size() == 1) {
        post();
      }
      return;
    }
    finally {}
  }
  
  public void onIdle()
  {
    try
    {
      ArrayList localArrayList = this.list;
      this.list = null;
      if (localArrayList == null) {
        return;
      }
    }
    finally {}
    int j = localObject.size();
    int i = 0;
    while (i < j)
    {
      ((aqsg)localObject.get(i)).ST(true);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.IdleGetDynamic
 * JD-Core Version:    0.7.0.1
 */