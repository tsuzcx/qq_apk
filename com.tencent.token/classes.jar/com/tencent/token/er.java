package com.tencent.token;

import android.os.Looper;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.LoginMsgActivity;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class er
{
  public gb a = null;
  public boolean b;
  long c = 0L;
  public int d = -1;
  public long e = 0L;
  private List f = null;
  private int g = 0;
  private boolean h = false;
  
  public er(String paramString)
  {
    this.a = new gb(paramString);
  }
  
  private void a(List paramList)
  {
    l();
    this.f.clear();
    if (paramList != null) {
      this.f.addAll(paramList);
    }
  }
  
  private void l()
  {
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
      return;
    }
    h.c("should run in mainthread");
    h.d("should run in mainthread");
  }
  
  public int a(int paramInt)
  {
    this.b = false;
    int i = paramInt;
    if (this.d > -1) {
      i = Math.max(paramInt, this.d);
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = do.a().e();
      if ((localObject == null) || (i <= 0))
      {
        a(null);
        return 0;
      }
      long l2 = ((QQUser)localObject).mUin;
      long l1 = l2;
      if (!((QQUser)localObject).mIsBinded)
      {
        l1 = l2;
        if (((QQUser)localObject).mUin == ((QQUser)localObject).mRealUin) {
          l1 = w.f(((QQUser)localObject).mRealUin);
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
      a(localArrayList);
      paramInt = g();
      return paramInt;
    }
    catch (Exception localException)
    {
      h.c("Exception:" + localException.toString());
      a(null);
    }
    return 0;
  }
  
  public SafeMsgItem a()
  {
    try
    {
      Object localObject = do.a().e();
      if (localObject == null) {
        return null;
      }
      if ((this.e != 0L) && (this.e != ((QQUser)localObject).mRealUin))
      {
        k();
        com.tencent.token.ui.AccountPageActivity.mNeedShowIpcMsg = false;
      }
      long l2 = ((QQUser)localObject).mUin;
      long l1 = l2;
      if (!((QQUser)localObject).mIsBinded)
      {
        l1 = l2;
        if (((QQUser)localObject).mUin == ((QQUser)localObject).mRealUin) {
          l1 = w.f(((QQUser)localObject).mRealUin);
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
  
  public f a(JSONObject paramJSONObject, long paramLong, int paramInt)
  {
    f localf = new f();
    long l1 = x.a(paramInt, paramLong);
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
          break label508;
        }
        bool = true;
        this.h = bool;
        h.a("is need again=" + i + ", msg cnt=" + m);
        if ((m > 0) && (localJSONArray != null))
        {
          c(m);
          this.a.c(paramLong);
          j = 0;
          i = 0;
          if (i >= localJSONArray.length()) {
            continue;
          }
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject == null) {
            break label514;
          }
          bool = true;
          h.a(bool);
          SafeMsgItem localSafeMsgItem = new SafeMsgItem();
          localSafeMsgItem.mUin = paramLong;
          if (!localSafeMsgItem.a(localJSONObject)) {
            h.c("object item parse failed: " + i);
          }
          if ((this.d == -1) && (localSafeMsgItem.q()))
          {
            a(LoginMsgActivity.mNewMsgCntSetByAccount + i + 1, do.a().e().mRealUin);
            if (paramInt == 1) {
              com.tencent.token.ui.AccountPageActivity.mNeedShowIpcMsg = true;
            }
            h.c("setlist got IPC msg,index = " + (LoginMsgActivity.mNewMsgCntSetByAccount + i + 1));
          }
          if (this.a.a(localSafeMsgItem))
          {
            int k = j + 1;
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
            h.d("msg store to db is wrong" + localJSONObject);
            l2 = l1;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        int m;
        int j;
        localf.a(10020, "JSONException:" + paramJSONObject.toString());
        localf.c();
        return localf;
        if (j != m)
        {
          c(j);
          h.c("msg cnt is wrong");
          h.d("msg cnt is wrong" + paramJSONObject);
        }
        x.a(paramInt, paramLong, l1);
        localf.c();
        return localf;
      }
      catch (Exception paramJSONObject)
      {
        localf.a(10021, "JSONException:" + paramJSONObject.toString());
        continue;
      }
      i += 1;
      l1 = l2;
      continue;
      label508:
      boolean bool = false;
      continue;
      label514:
      bool = false;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.d = paramInt;
    this.e = paramLong;
  }
  
  public void a(long paramLong)
  {
    l();
    if (paramLong != 0L)
    {
      this.a.a(paramLong);
      this.f.clear();
    }
  }
  
  public void a(SafeMsgItem paramSafeMsgItem)
  {
    paramSafeMsgItem.mIsRead = true;
    this.a.d(paramSafeMsgItem.a());
  }
  
  public SafeMsgItem b(int paramInt)
  {
    int i = this.f.size();
    if ((paramInt < 0) || (paramInt >= i)) {
      return null;
    }
    return (SafeMsgItem)this.f.get(paramInt);
  }
  
  public void b()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((SafeMsgItem)localIterator.next()).mIsChecked = true;
    }
  }
  
  public void b(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void c()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((SafeMsgItem)localIterator.next()).mIsChecked = false;
    }
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public boolean d()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      if (!((SafeMsgItem)localIterator.next()).mIsChecked) {
        return false;
      }
    }
    return true;
  }
  
  public int e()
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
  
  public void f()
  {
    l();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      SafeMsgItem localSafeMsgItem = (SafeMsgItem)localIterator.next();
      if ((localSafeMsgItem != null) && (localSafeMsgItem.mIsChecked))
      {
        this.a.b(localSafeMsgItem.a());
        localIterator.remove();
      }
    }
  }
  
  public int g()
  {
    return this.f.size();
  }
  
  public int h()
  {
    return this.g;
  }
  
  public boolean i()
  {
    boolean bool2 = false;
    QQUser localQQUser = do.a().e();
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
  
  public boolean j()
  {
    return this.h;
  }
  
  public void k()
  {
    this.d = -1;
    this.e = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.er
 * JD-Core Version:    0.7.0.1
 */