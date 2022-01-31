package com.tencent.token;

import android.os.Looper;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.LoginMsgActivity;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fo
{
  public gm a = null;
  public boolean b;
  long c = 0L;
  public int d = -1;
  public long e = 0L;
  private List f = null;
  private int g = 0;
  private boolean h = false;
  
  public fo(String paramString)
  {
    this.a = new gm(paramString);
  }
  
  public final int a(int paramInt)
  {
    this.b = false;
    int i = paramInt;
    if (this.d >= 0) {
      i = Math.max(paramInt, this.d);
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = ax.a().e();
      if ((localObject == null) || (i <= 0))
      {
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
        {
          e.c("should run in mainthread");
          e.d("should run in mainthread");
        }
        this.f.clear();
        return 0;
      }
      long l2 = ((QQUser)localObject).mUin;
      long l1 = l2;
      if (!((QQUser)localObject).mIsBinded)
      {
        l1 = l2;
        if (((QQUser)localObject).mUin == ((QQUser)localObject).mRealUin) {
          l1 = s.f(((QQUser)localObject).mRealUin);
        }
      }
      localObject = this.a.a(l1, i + 1);
      if (localObject != null)
      {
        if (((List)localObject).size() > i)
        {
          this.b = true;
          paramInt = 0;
          while (paramInt < i)
          {
            localArrayList.add(((List)localObject).get(paramInt));
            paramInt += 1;
          }
        }
        localArrayList.addAll((Collection)localObject);
      }
      if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
      {
        e.c("should run in mainthread");
        e.d("should run in mainthread");
      }
      this.f.clear();
      this.f.addAll(localArrayList);
      paramInt = this.f.size();
      return paramInt;
    }
    catch (Exception localException)
    {
      e.c("Exception:" + localException.toString());
      if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
      {
        e.c("should run in mainthread");
        e.d("should run in mainthread");
      }
      this.f.clear();
    }
    return 0;
  }
  
  public final SafeMsgItem a()
  {
    try
    {
      Object localObject = ax.a().e();
      if (localObject == null) {
        return null;
      }
      if ((this.e != 0L) && (this.e != ((QQUser)localObject).mRealUin))
      {
        this.d = -1;
        this.e = 0L;
        com.tencent.token.ui.AccountPageActivity.mNeedShowIpcMsg = false;
      }
      long l2 = ((QQUser)localObject).mUin;
      long l1 = l2;
      if (!((QQUser)localObject).mIsBinded)
      {
        l1 = l2;
        if (((QQUser)localObject).mUin == ((QQUser)localObject).mRealUin) {
          l1 = s.f(((QQUser)localObject).mRealUin);
        }
      }
      localObject = this.a.a(l1, 1);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (SafeMsgItem)((List)localObject).get(0);
        return localObject;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final d a(JSONObject paramJSONObject, long paramLong, int paramInt)
  {
    d locald = new d((byte)0);
    long l1 = t.a(paramInt, paramLong);
    for (;;)
    {
      int i;
      long l2;
      try
      {
        i = paramJSONObject.getInt("is_have_msg");
        m = paramJSONObject.getInt("rsp_msg_num");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("msgs");
        if ((i <= 0) || (m <= 0)) {
          break label528;
        }
        bool = true;
        this.h = bool;
        e.a("is need again=" + i + ", msg cnt=" + m);
        if ((m > 0) && (localJSONArray != null))
        {
          this.g = m;
          this.a.c(paramLong);
          j = 0;
          i = 0;
          if (i >= localJSONArray.length()) {
            continue;
          }
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject == null) {
            break label534;
          }
          bool = true;
          e.a(bool);
          SafeMsgItem localSafeMsgItem = new SafeMsgItem();
          localSafeMsgItem.mUin = paramLong;
          if (!localSafeMsgItem.a(localJSONObject)) {
            e.c("object item parse failed: " + i);
          }
          if (this.d == -1)
          {
            if ((localSafeMsgItem.mFlag & 0x4) != 4) {
              break label540;
            }
            k = 1;
            if (k != 0)
            {
              k = LoginMsgActivity.mNewMsgCntSetByAccount;
              l2 = ax.a().e().mRealUin;
              this.d = (k + i + 1);
              this.e = l2;
              com.tencent.token.ui.AccountPageActivity.mNeedShowIpcMsg = true;
              e.c("setlist got IPC msg,index = " + (LoginMsgActivity.mNewMsgCntSetByAccount + i + 1));
            }
          }
          if (this.a.a(localSafeMsgItem))
          {
            k = j + 1;
            j = k;
            l2 = l1;
            if (localSafeMsgItem.mTime + 1L > l1)
            {
              l2 = localSafeMsgItem.mTime + 1L;
              j = k;
            }
          }
          else
          {
            e.d("msg store to db is wrong" + localJSONObject);
            l2 = l1;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        int m;
        int j;
        locald.a(10020, "JSONException:" + paramJSONObject.toString(), null);
        locald.a = 0;
        return locald;
        if (j != m)
        {
          this.g = j;
          e.c("msg cnt is wrong");
          e.d("msg cnt is wrong" + paramJSONObject);
        }
        t.a(paramInt, paramLong, l1);
        locald.a = 0;
        return locald;
      }
      catch (Exception paramJSONObject)
      {
        locald.a(10021, "JSONException:" + paramJSONObject.toString(), null);
        continue;
      }
      i += 1;
      l1 = l2;
      continue;
      label528:
      boolean bool = false;
      continue;
      label534:
      bool = false;
      continue;
      label540:
      int k = 0;
    }
  }
  
  public final void a(long paramLong)
  {
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      e.c("should run in mainthread");
      e.d("should run in mainthread");
    }
    if (paramLong != 0L)
    {
      this.a.a(paramLong);
      this.f.clear();
    }
  }
  
  public final SafeMsgItem b(int paramInt)
  {
    int i = this.f.size();
    if ((paramInt < 0) || (paramInt >= i)) {
      return null;
    }
    return (SafeMsgItem)this.f.get(paramInt);
  }
  
  public final void b()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((SafeMsgItem)localIterator.next()).mIsChecked = true;
    }
  }
  
  public final void b(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final void c()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((SafeMsgItem)localIterator.next()).mIsChecked = false;
    }
  }
  
  public final boolean d()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      if (!((SafeMsgItem)localIterator.next()).mIsChecked) {
        return false;
      }
    }
    return true;
  }
  
  public final int e()
  {
    Iterator localIterator = this.f.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((SafeMsgItem)localIterator.next()).mIsChecked) {
        i += 1;
      }
      for (;;)
      {
        break;
      }
    }
    return i;
  }
  
  public final void f()
  {
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      e.c("should run in mainthread");
      e.d("should run in mainthread");
    }
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      SafeMsgItem localSafeMsgItem = (SafeMsgItem)localIterator.next();
      if ((localSafeMsgItem != null) && (localSafeMsgItem.mIsChecked))
      {
        this.a.b(localSafeMsgItem.mId);
        localIterator.remove();
      }
    }
  }
  
  public final int g()
  {
    return this.f.size();
  }
  
  public final void h()
  {
    this.g = 0;
  }
  
  public final int i()
  {
    return this.g;
  }
  
  public final boolean j()
  {
    boolean bool2 = false;
    QQUser localQQUser = ax.a().e();
    boolean bool1 = bool2;
    if (localQQUser != null)
    {
      bool1 = bool2;
      if (localQQUser.mUin == this.c) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean k()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fo
 * JD-Core Version:    0.7.0.1
 */