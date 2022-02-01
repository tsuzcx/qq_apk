package com.tencent.token;

import android.os.Looper;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.ui.LoginMsgActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aay
{
  public aiu a = null;
  public List<SafeMsgItem> b = null;
  public boolean c;
  public int d = 0;
  public long e = 0L;
  public boolean f = false;
  public int g = -1;
  public long h = 0L;
  
  public aay(String paramString)
  {
    this.a = new aiu(paramString);
  }
  
  public static void a()
  {
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
      return;
    }
    xj.c("should run in mainthread");
    xj.c("should run in mainthread");
  }
  
  private void a(List<SafeMsgItem> paramList)
  {
    a();
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
  }
  
  public final int a(int paramInt)
  {
    this.c = false;
    int j = this.g;
    int i = paramInt;
    if (j >= 0) {
      i = Math.max(paramInt, j);
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localObject = th.a().k.b();
      if ((localObject != null) && (i > 0))
      {
        long l2 = ((QQUser)localObject).mUin;
        long l1 = l2;
        if (!((QQUser)localObject).mIsBinded)
        {
          l1 = l2;
          if (((QQUser)localObject).mUin == ((QQUser)localObject).mRealUin) {
            l1 = aao.f(((QQUser)localObject).mRealUin);
          }
        }
        localObject = this.a.a(l1, i + 1);
        if (localObject != null)
        {
          if (((List)localObject).size() > i)
          {
            this.c = true;
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
        return e();
      }
      a(null);
      return 0;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder("Exception:");
      ((StringBuilder)localObject).append(localException.toString());
      xj.c(((StringBuilder)localObject).toString());
      a(null);
    }
    return 0;
  }
  
  public final xh a(JSONObject paramJSONObject, long paramLong, int paramInt)
  {
    xh localxh = new xh();
    long l1 = aap.a(paramInt, paramLong);
    for (;;)
    {
      int i;
      long l2;
      try
      {
        i = paramJSONObject.getInt("is_have_msg");
        int m = paramJSONObject.getInt("rsp_msg_num");
        localObject1 = paramJSONObject.getJSONArray("msgs");
        if ((i <= 0) || (m <= 0)) {
          break label517;
        }
        bool = true;
        this.f = bool;
        Object localObject2 = new StringBuilder("is need again=");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(", msg cnt=");
        ((StringBuilder)localObject2).append(m);
        xj.a(((StringBuilder)localObject2).toString());
        if ((m > 0) && (localObject1 != null))
        {
          this.d = m;
          this.a.c(paramLong);
          i = 0;
          int j = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            if (localObject2 == null) {
              break label523;
            }
            bool = true;
            xj.a(bool);
            SafeMsgItem localSafeMsgItem = new SafeMsgItem();
            localSafeMsgItem.mUin = paramLong;
            if (!localSafeMsgItem.a((JSONObject)localObject2)) {
              xj.c("object item parse failed: ".concat(String.valueOf(i)));
            }
            if ((this.g != -1) || (!localSafeMsgItem.b())) {
              break label529;
            }
            int k = LoginMsgActivity.mNewMsgCntSetByAccount;
            l2 = th.a().k.b().mRealUin;
            this.g = (k + i + 1);
            this.h = l2;
            if (paramInt == 1) {
              com.tencent.token.ui.AccountPageActivity.mNeedShowIpcMsg = true;
            }
            StringBuilder localStringBuilder = new StringBuilder("setlist got IPC msg,index = ");
            localStringBuilder.append(LoginMsgActivity.mNewMsgCntSetByAccount + i + 1);
            xj.c(localStringBuilder.toString());
            if (this.a.a(localSafeMsgItem))
            {
              k = j + 1;
              j = k;
              l2 = l1;
              if (localSafeMsgItem.mTime + 1L <= l1) {
                break label532;
              }
              l2 = localSafeMsgItem.mTime + 1L;
              j = k;
              break label532;
            }
            xj.c("msg store to db is wrong".concat(String.valueOf(localObject2)));
            l2 = l1;
            break label532;
          }
          if (j != m)
          {
            this.d = j;
            xj.c("msg cnt is wrong");
            xj.c("msg cnt is wrong".concat(String.valueOf(paramJSONObject)));
          }
          aap.a(paramInt, paramLong, l1);
          localxh.a = 0;
          return localxh;
        }
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = new StringBuilder("JSONException:");
        ((StringBuilder)localObject1).append(paramJSONObject.toString());
        localxh.a(10021, ((StringBuilder)localObject1).toString(), null);
      }
      catch (JSONException paramJSONObject)
      {
        Object localObject1 = new StringBuilder("JSONException:");
        ((StringBuilder)localObject1).append(paramJSONObject.toString());
        localxh.a(10020, ((StringBuilder)localObject1).toString(), null);
      }
      localxh.a = 0;
      return localxh;
      label517:
      boolean bool = false;
      continue;
      label523:
      bool = false;
      continue;
      label529:
      continue;
      label532:
      i += 1;
      l1 = l2;
    }
  }
  
  public final void a(long paramLong)
  {
    
    if (paramLong != 0L)
    {
      this.a.a(paramLong);
      this.b.clear();
    }
  }
  
  public final SafeMsgItem b()
  {
    try
    {
      Object localObject = th.a().k.b();
      if (localObject == null) {
        return null;
      }
      if ((this.h != 0L) && (this.h != ((QQUser)localObject).mRealUin))
      {
        f();
        com.tencent.token.ui.AccountPageActivity.mNeedShowIpcMsg = false;
      }
      long l2 = ((QQUser)localObject).mUin;
      long l1 = l2;
      if (!((QQUser)localObject).mIsBinded)
      {
        l1 = l2;
        if (((QQUser)localObject).mUin == ((QQUser)localObject).mRealUin) {
          l1 = aao.f(((QQUser)localObject).mRealUin);
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
  
  public final SafeMsgItem b(int paramInt)
  {
    int i = this.b.size();
    if ((paramInt >= 0) && (paramInt < i)) {
      return (SafeMsgItem)this.b.get(paramInt);
    }
    return null;
  }
  
  public final void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((SafeMsgItem)localIterator.next()).mIsChecked = false;
    }
  }
  
  public final int d()
  {
    Iterator localIterator = this.b.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (((SafeMsgItem)localIterator.next()).mIsChecked) {
        i += 1;
      }
    }
    return i;
  }
  
  public final int e()
  {
    return this.b.size();
  }
  
  public final void f()
  {
    this.g = -1;
    this.h = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aay
 * JD-Core Version:    0.7.0.1
 */