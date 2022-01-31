package com.tencent.token.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class yz
{
  private final List a = new LinkedList();
  private final boolean b;
  
  public yz(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt > 1073741824)) {}
    this.b = paramBoolean;
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public Collection a(Collection paramCollection)
  {
    Object localObject = paramCollection;
    if (paramCollection == null) {}
    try
    {
      localObject = new ArrayList();
      ((Collection)localObject).clear();
      ((Collection)localObject).addAll(this.a);
      return localObject;
    }
    finally {}
  }
  
  public void a(List paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        int i = paramList.size();
        if (i == 0) {
          return;
        }
        if (this.b)
        {
          i = 0;
          this.a.addAll(i, paramList);
        }
        else
        {
          i = this.a.size();
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yz
 * JD-Core Version:    0.7.0.1
 */