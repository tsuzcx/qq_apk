package com.tencent.mobileqq.app;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;

public class CardObserver
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    label1191:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    a(paramBoolean, paramObject);
                    return;
                  } while (!(paramObject instanceof Object[]));
                  paramObject = (Object[])paramObject;
                  b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (Card)paramObject[2]);
                  return;
                  d(paramBoolean, ((Bundle)paramObject).getString("uin"));
                  return;
                  if (paramBoolean)
                  {
                    c(paramBoolean, (Card)paramObject);
                    return;
                  }
                  c(paramBoolean, null);
                  return;
                  e(paramBoolean, ((Bundle)paramObject).getString("targetUin"));
                  return;
                } while (!(paramObject instanceof Bundle));
                paramObject = (Bundle)paramObject;
                a(paramBoolean, paramObject.getString("selfUin"), paramObject.getString("targetUin"));
                return;
                if (paramBoolean)
                {
                  localObject2 = (Object[])paramObject;
                  paramObject = (Card)localObject2[0];
                  localObject1 = (Bundle)localObject2[1];
                  localObject2 = (ArrayList)localObject2[2];
                  String str = ((Bundle)localObject1).getString("uin");
                  l1 = ((Bundle)localObject1).getLong("nextMid");
                  a(true, str, (ArrayList)localObject2, ((Bundle)localObject1).getLong("startMid"), l1, ((Bundle)localObject1).getByteArray("strCookie"), paramObject);
                  return;
                }
                a(false, ((Bundle)((Object[])(Object[])paramObject)[1]).getString("uin"), null, -1L, -1L, null, null);
                return;
                localObject1 = (Object[])paramObject;
                paramObject = (Bundle)localObject1[0];
                localObject1 = (ArrayList)localObject1[1];
                localObject2 = paramObject.getString("uin");
                l1 = paramObject.getLong("startMid", 0L);
                l2 = paramObject.getLong("nextMid");
                paramObject = paramObject.getByteArray("strCookie");
                if (paramBoolean)
                {
                  a(true, (String)localObject2, (ArrayList)localObject1, l1, l2, paramObject);
                  return;
                }
                a(false, (String)localObject2, (ArrayList)localObject1, l1, -1L, null);
                return;
                c(paramBoolean, ((Bundle)paramObject).getString("uin"));
                return;
                if (paramBoolean)
                {
                  paramObject = (Object[])paramObject;
                  a(true, (Card)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
                  return;
                }
                a(false, (Card)paramObject, false);
                return;
                if (paramBoolean)
                {
                  paramObject = (Object[])paramObject;
                  localObject1 = (Card)paramObject[0];
                  a(paramBoolean, null, ((Bundle)paramObject[1]).getInt("retCode", -1), (Card)localObject1);
                  return;
                }
                paramInt = -1;
                if ((paramObject instanceof Bundle)) {
                  paramInt = ((Bundle)paramObject).getInt("retCode", -1);
                }
                a(paramBoolean, null, paramInt, null);
                return;
              } while (!paramBoolean);
              d(paramBoolean, (Card)paramObject);
              return;
              if (paramBoolean)
              {
                localObject1 = (Object[])paramObject;
                paramObject = (Bundle)localObject1[0];
                localObject1 = (Card)localObject1[1];
                paramObject.getString("uin");
                a(paramBoolean, (Card)localObject1, paramObject.getInt("result", -1), paramObject.getByteArray("fileKey"));
                return;
              }
              localObject1 = (Object[])paramObject;
              paramObject = (Bundle)localObject1[0];
              localObject1 = (Card)localObject1[1];
              paramObject.getString("uin");
              a(paramBoolean, (Card)localObject1, paramObject.getInt("result", -1), paramObject.getByteArray("fileKey"));
              return;
              f(paramBoolean, ((Bundle)paramObject).getString("uin"));
              return;
              b(paramBoolean, ((Bundle)paramObject).getString("uin"));
              return;
            } while (!paramBoolean);
            paramObject = (Card)paramObject;
            b(paramBoolean, paramObject.uin, paramObject);
            return;
          } while (!paramBoolean);
          paramObject = (Card)paramObject;
          c(paramBoolean, paramObject.uin, paramObject);
          return;
        } while (!paramBoolean);
        paramObject = (Card)paramObject;
        a(paramBoolean, paramObject.uin, paramObject);
        return;
        paramObject = (Bundle)paramObject;
        b(paramBoolean, paramObject.getString("uin"), paramObject.getString("filekey"));
        return;
        a(paramBoolean, ((Bundle)paramObject).getString("uin"));
        return;
        if (paramBoolean)
        {
          e(paramBoolean, (Card)paramObject);
          return;
        }
        e(paramBoolean, null);
        return;
        if (paramBoolean)
        {
          b(paramBoolean, (Card)paramObject);
          return;
        }
        b(paramBoolean, null);
        return;
        paramObject = (Card)paramObject;
        if (paramBoolean)
        {
          f(paramBoolean, paramObject);
          return;
        }
        f(paramBoolean, paramObject);
        return;
        b(paramBoolean, paramObject);
        return;
        paramObject = (Bundle)paramObject;
        localObject1 = paramObject.getString("lUin");
        l1 = paramObject.getLong("nextMid");
        Object localObject2 = paramObject.getByteArray("strCookie");
        a(paramBoolean, (String)localObject1, paramObject.getStringArrayList("hexFaceInfo"), l1, (byte[])localObject2);
        return;
      } while (!paramBoolean);
      Object localObject1 = (Object[])paramObject;
      paramObject = (Card)localObject1[0];
      localObject1 = (Bundle)localObject1[1];
      ((Bundle)localObject1).getString("uin");
      paramInt = ((Bundle)localObject1).getInt("newVoteCount");
      c(paramBoolean, ((Bundle)localObject1).getString("voteeUin"), paramInt, paramObject);
      return;
      a(paramBoolean, (Card)paramObject);
      return;
      paramObject = (Bundle)paramObject;
      a(paramBoolean, paramObject.getString("uin"), paramObject.getBoolean("modify_switch_for_near_people"), paramObject.getBoolean("target_switch"));
      return;
      paramObject = (Bundle)paramObject;
      localObject1 = paramObject.getString("uin");
      long l1 = paramObject.getLong("uCloseNeighborVote", 0L);
      long l2 = paramObject.getLong("uColseTimeEntityManager", 0L);
      boolean bool1;
      if (l1 == 0L)
      {
        bool1 = true;
        if (l2 != 0L) {
          break label1191;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        b(paramBoolean, (String)localObject1, bool1, bool2);
        return;
        bool1 = false;
        break;
      }
      g(paramBoolean, ((Bundle)paramObject).getString("pttcenter_selfuin"));
      return;
      paramObject = (Bundle)paramObject;
      localObject1 = paramObject.getString("pttcenter_selfuin");
      paramInt = paramObject.getInt("pttcenter_voice_optype");
      a(paramBoolean, (String)localObject1, paramObject.getString("pttcenter_filekey"), paramInt);
      return;
      a(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
      b(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    } while (paramObject == null);
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (mobile_sub_get_cover_rsp)paramObject[1]);
  }
  
  public void a(boolean paramBoolean, Card paramCard) {}
  
  public void a(boolean paramBoolean, Card paramCard, int paramInt, byte[] paramArrayOfByte) {}
  
  protected void a(boolean paramBoolean1, Card paramCard, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp) {}
  
  public void a(boolean paramBoolean, String paramString, Card paramCard) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte) {}
  
  public void a(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard) {}
  
  public void a(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong, byte[] paramArrayOfByte) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean, Card paramCard) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean, String paramString) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  public void b(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void b(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c(boolean paramBoolean, Card paramCard) {}
  
  public void c(boolean paramBoolean, String paramString) {}
  
  protected void c(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  public void c(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void d(boolean paramBoolean, Card paramCard) {}
  
  protected void d(boolean paramBoolean, String paramString) {}
  
  public void d(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void e(boolean paramBoolean, Card paramCard) {}
  
  protected void e(boolean paramBoolean, String paramString) {}
  
  protected void f(boolean paramBoolean, Card paramCard) {}
  
  protected void f(boolean paramBoolean, String paramString) {}
  
  protected void g(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardObserver
 * JD-Core Version:    0.7.0.1
 */