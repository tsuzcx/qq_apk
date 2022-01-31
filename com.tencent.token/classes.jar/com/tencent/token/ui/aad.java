package com.tencent.token.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

final class aad
{
  private final List a = new LinkedList();
  private final boolean b = true;
  
  public final int a()
  {
    return this.a.size();
  }
  
  public final Collection a(Collection paramCollection)
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
  
  public final void a(List paramList)
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
  
  public final void b()
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
 * Qualified Name:     com.tencent.token.ui.aad
 * JD-Core Version:    0.7.0.1
 */