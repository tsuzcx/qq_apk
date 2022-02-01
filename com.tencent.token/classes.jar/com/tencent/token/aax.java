package com.tencent.token;

import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.QQUser;
import java.util.ArrayList;

public final class aax
{
  static aax c;
  public MbInfoResult a;
  long b;
  
  public static aax a()
  {
    aax localaax = c;
    if (localaax == null)
    {
      localaax = new aax();
      c = localaax;
      return localaax;
    }
    return localaax;
  }
  
  public final int a(int paramInt)
  {
    try
    {
      Object localObject1 = c();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = this.a.mMbInfoItems;
      if (localObject1 == null) {
        return -1;
      }
      int i = 0;
      while (i < this.a.mMbInfoItems.size())
      {
        int j = ((MbInfoResult.MbInfoItem)this.a.mMbInfoItems.get(i)).mId;
        if (j == paramInt) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    finally {}
  }
  
  public final void a(MbInfoResult paramMbInfoResult)
  {
    try
    {
      this.a = paramMbInfoResult;
      if (th.a().k.b() != null) {
        this.b = th.a().k.b().mUin;
      }
      return;
    }
    finally
    {
      paramMbInfoResult = finally;
      throw paramMbInfoResult;
    }
  }
  
  public final void b()
  {
    try
    {
      this.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final MbInfoResult c()
  {
    try
    {
      Object localObject1 = th.a().k.b();
      if ((localObject1 != null) && (this.a != null))
      {
        if (this.b == ((QQUser)localObject1).mUin)
        {
          localObject1 = this.a;
          return localObject1;
        }
        return null;
      }
      return null;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aax
 * JD-Core Version:    0.7.0.1
 */