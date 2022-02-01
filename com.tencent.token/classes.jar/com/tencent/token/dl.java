package com.tencent.token;

import android.os.Looper;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.LoginMsgActivity;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dl
{
  public eu a = null;
  public boolean b;
  long c = 0L;
  public int d = -1;
  public long e = 0L;
  private List<SafeMsgItem> f = null;
  private int g = 0;
  private boolean h = false;
  
  public dl(String paramString)
  {
    this.a = new eu(paramString);
  }
  
  private void a(List<SafeMsgItem> paramList)
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
    g.c("should run in mainthread");
    g.d("should run in mainthread");
  }
  
  public int a(int paramInt)
  {
    this.b = false;
    int j = this.d;
    int i = paramInt;
    if (j > -1) {
      i = Math.max(paramInt, j);
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localObject = cs.a().e();
      if ((localObject != null) && (i > 0))
      {
        long l2 = ((QQUser)localObject).mUin;
        long l1 = l2;
        if (!((QQUser)localObject).mIsBinded)
        {
          l1 = l2;
          if (((QQUser)localObject).mUin == ((QQUser)localObject).mRealUin) {
            l1 = l.f(((QQUser)localObject).mRealUin);
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
        return g();
      }
      a(null);
      return 0;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Exception:");
      ((StringBuilder)localObject).append(localException.toString());
      g.c(((StringBuilder)localObject).toString());
      a(null);
    }
    return 0;
  }
  
  public SafeMsgItem a()
  {
    try
    {
      Object localObject = cs.a().e();
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
          l1 = l.f(((QQUser)localObject).mRealUin);
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
  
  public e a(JSONObject paramJSONObject, long paramLong, int paramInt)
  {
    long l1 = paramLong;
    e locale = new e();
    long l2 = m.a(paramInt, l1);
    label592:
    label598:
    label604:
    label607:
    label620:
    for (;;)
    {
      int i;
      try
      {
        i = paramJSONObject.getInt("is_have_msg");
        int m = paramJSONObject.getInt("rsp_msg_num");
        localObject1 = paramJSONObject.getJSONArray("msgs");
        if ((i <= 0) || (m <= 0)) {
          break label592;
        }
        bool = true;
        this.h = bool;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("is need again=");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(", msg cnt=");
        ((StringBuilder)localObject2).append(m);
        g.a(((StringBuilder)localObject2).toString());
        if ((m > 0) && (localObject1 != null))
        {
          c(m);
          this.a.c(l1);
          l1 = l2;
          i = 0;
          int j = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            if (localObject2 == null) {
              break label598;
            }
            bool = true;
            g.a(bool);
            Object localObject3 = new SafeMsgItem();
            ((SafeMsgItem)localObject3).mUin = paramLong;
            if (!((SafeMsgItem)localObject3).a((JSONObject)localObject2))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("object item parse failed: ");
              localStringBuilder.append(i);
              g.c(localStringBuilder.toString());
            }
            if ((this.d != -1) || (!((SafeMsgItem)localObject3).q())) {
              break label604;
            }
            a(LoginMsgActivity.mNewMsgCntSetByAccount + i + 1, cs.a().e().mRealUin);
            if (paramInt == 1) {
              com.tencent.token.ui.AccountPageActivity.mNeedShowIpcMsg = true;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setlist got IPC msg,index = ");
            localStringBuilder.append(LoginMsgActivity.mNewMsgCntSetByAccount + i + 1);
            g.c(localStringBuilder.toString());
            if (this.a.a((SafeMsgItem)localObject3))
            {
              int k = j + 1;
              j = k;
              l2 = l1;
              if (((SafeMsgItem)localObject3).mTime + 1L <= l1) {
                break label607;
              }
              l2 = ((SafeMsgItem)localObject3).mTime + 1L;
              j = k;
              break label607;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("msg store to db is wrong");
            ((StringBuilder)localObject3).append(localObject2);
            g.d(((StringBuilder)localObject3).toString());
            l2 = l1;
            break label607;
          }
          if (j == m) {
            break label620;
          }
          c(j);
          g.c("msg cnt is wrong");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("msg cnt is wrong");
          ((StringBuilder)localObject1).append(paramJSONObject);
          g.d(((StringBuilder)localObject1).toString());
          m.a(paramInt, paramLong, l1);
          locale.c();
          return locale;
        }
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("JSONException:");
        ((StringBuilder)localObject1).append(paramJSONObject.toString());
        locale.a(10021, ((StringBuilder)localObject1).toString());
      }
      catch (JSONException paramJSONObject)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("JSONException:");
        ((StringBuilder)localObject1).append(paramJSONObject.toString());
        locale.a(10020, ((StringBuilder)localObject1).toString());
      }
      locale.c();
      return locale;
      boolean bool = false;
      continue;
      bool = false;
      continue;
      continue;
      i += 1;
      l1 = l2;
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
    if ((paramInt >= 0) && (paramInt < i)) {
      return (SafeMsgItem)this.f.get(paramInt);
    }
    return null;
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
  
  public List<SafeMsgItem> c(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    SafeMsgItem localSafeMsgItem = a();
    if (localSafeMsgItem != null) {
      localArrayList.add(localSafeMsgItem);
    }
    return localArrayList;
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
    while (localIterator.hasNext()) {
      if (((SafeMsgItem)localIterator.next()).mIsChecked) {
        i += 1;
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
    QQUser localQQUser = cs.a().e();
    boolean bool = false;
    if (localQQUser != null)
    {
      if (localQQUser.mUin == this.c) {
        bool = true;
      }
      return bool;
    }
    return false;
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
 * Qualified Name:     com.tencent.token.dl
 * JD-Core Version:    0.7.0.1
 */