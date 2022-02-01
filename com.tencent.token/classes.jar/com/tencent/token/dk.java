package com.tencent.token;

import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.QQUser;
import java.util.ArrayList;

public class dk
{
  static dk d;
  public MbInfoResult a;
  String b;
  long c;
  
  public static dk a()
  {
    dk localdk = d;
    if (localdk == null)
    {
      d = new dk();
      return d;
    }
    return localdk;
  }
  
  public int a(int paramInt)
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
  
  public void a(MbInfoResult paramMbInfoResult)
  {
    try
    {
      this.a = paramMbInfoResult;
      cs.a();
      this.b = cs.c;
      if (cs.a().e() != null) {
        this.c = cs.a().e().mUin;
      }
      return;
    }
    finally
    {
      paramMbInfoResult = finally;
      throw paramMbInfoResult;
    }
  }
  
  public void b()
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
  
  public MbInfoResult c()
  {
    try
    {
      Object localObject1 = cs.a().e();
      if ((this.b != null) && (localObject1 != null) && (this.a != null))
      {
        String str = this.b;
        cs.a();
        if ((str.equals(cs.c)) && (this.c == ((QQUser)localObject1).mUin))
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
 * Qualified Name:     com.tencent.token.dk
 * JD-Core Version:    0.7.0.1
 */