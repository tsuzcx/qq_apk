package com.tencent.mobileqq.app;

import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class BizTroopObserver
  implements BusinessObserver
{
  private final String a = "BizTroopObserver";
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  protected void a(TroopGagMgr.GagStatus paramGagStatus) {}
  
  protected void a(Object paramObject) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3) {}
  
  protected void a(String paramString, List paramList, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean, Object paramObject) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2) {}
  
  protected void a(JSONObject paramJSONObject) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList, int paramInt4) {}
  
  protected void a(boolean paramBoolean, int paramInt, List paramList) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString, List paramList) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, List paramList) {}
  
  protected void a(boolean paramBoolean, List paramList) {}
  
  protected void a(boolean paramBoolean, oidb_0x88d.GroupInfo paramGroupInfo) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, List paramList) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void c(Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  protected void h(boolean paramBoolean, Object paramObject) {}
  
  protected void i(boolean paramBoolean, Object paramObject) {}
  
  protected void j(boolean paramBoolean, Object paramObject) {}
  
  protected void k(boolean paramBoolean, Object paramObject) {}
  
  protected void l(boolean paramBoolean, Object paramObject) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof Object[])) {}
    for (Object[] arrayOfObject = (Object[])paramObject;; arrayOfObject = null)
    {
      switch (paramInt)
      {
      case 14: 
      case 15: 
      case 16: 
      case 18: 
      case 23: 
      case 39: 
      case 40: 
      default: 
      case 1: 
      case 3: 
      case 2: 
      case 9: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 17: 
      case 35: 
      case 20: 
      case 19: 
      case 27: 
      case 28: 
      case 29: 
      case 21: 
      case 22: 
      case 25: 
      case 30: 
      case 26: 
      case 24: 
      case 32: 
      case 34: 
      case 33: 
      case 31: 
      case 36: 
      case 37: 
        do
        {
          return;
          if (paramBoolean)
          {
            a((String)arrayOfObject[2], (String)arrayOfObject[0], paramBoolean, (String)arrayOfObject[1]);
            return;
          }
          a("", (String)arrayOfObject[0], paramBoolean, (String)arrayOfObject[1]);
          return;
          if (arrayOfObject.length > 2) {
            bool = ((Boolean)arrayOfObject[2]).booleanValue();
          }
          if (bool)
          {
            if (arrayOfObject.length > 3)
            {
              a(paramBoolean, (oidb_0x88d.GroupInfo)arrayOfObject[3]);
              return;
            }
            a(paramBoolean, null);
            return;
          }
          a(paramBoolean, ((Integer)arrayOfObject[1]).intValue());
          return;
          f(paramBoolean, paramObject);
          return;
          a(paramObject);
          return;
          b(paramBoolean, paramObject);
          return;
          a((String)arrayOfObject[0], paramBoolean, (String)arrayOfObject[1]);
          return;
          if (paramBoolean)
          {
            a(paramBoolean, (String)arrayOfObject[0], ((Boolean)arrayOfObject[1]).booleanValue(), (List)arrayOfObject[2]);
            return;
          }
          a(paramBoolean, (String)arrayOfObject[0], ((Boolean)arrayOfObject[1]).booleanValue(), null);
          return;
          a(paramBoolean, ((Integer)arrayOfObject[0]).intValue(), (List)arrayOfObject[1]);
          return;
          g(paramBoolean, paramObject);
          return;
          h(paramBoolean, paramObject);
          return;
          b(paramBoolean, (List)paramObject);
          return;
          if (paramBoolean)
          {
            a(true, ((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue(), (ArrayList)arrayOfObject[3], 0);
            return;
          }
          a(false, ((Integer)arrayOfObject[2]).intValue(), 0, 0, null, ((Integer)arrayOfObject[4]).intValue());
          return;
          b(paramObject);
          return;
          if (paramBoolean)
          {
            a(paramBoolean, (String)arrayOfObject[0], (List)arrayOfObject[1]);
            return;
          }
          a(paramBoolean, null, null);
          return;
          if (paramBoolean)
          {
            a(paramBoolean, (List)arrayOfObject[0]);
            return;
          }
          a(paramBoolean, null);
          return;
          c(paramObject);
          return;
          i(paramBoolean, paramObject);
          return;
          j(paramBoolean, paramObject);
          return;
          c(paramBoolean, paramObject);
          return;
          if ((arrayOfObject == null) || (arrayOfObject.length == 0))
          {
            a(false, -1L, "");
            return;
          }
          a(paramBoolean, ((Long)arrayOfObject[0]).longValue(), (String)arrayOfObject[1]);
          return;
          a(paramBoolean, paramObject);
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("BizTroopObserver", 4, "TroopHandler.TYPE_TROOP_GAG_STATUS");
          }
          a((TroopGagMgr.GagStatus)paramObject);
          return;
          a((String)arrayOfObject[0], (List)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
          return;
          a(paramBoolean, ((Boolean)paramObject).booleanValue());
          return;
          c(paramBoolean, ((Boolean)paramObject).booleanValue());
          return;
          d(paramBoolean, paramObject);
          return;
          a(paramBoolean, ((Long)arrayOfObject[0]).longValue(), ((Long)arrayOfObject[1]).longValue());
          return;
          e(paramBoolean, paramObject);
          return;
          a(paramBoolean, ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
          return;
          b(paramBoolean, ((Boolean)arrayOfObject[1]).booleanValue());
          return;
          l(paramBoolean, paramObject);
          return;
        } while ((paramObject == null) || (!(paramObject instanceof JSONObject)));
        a((JSONObject)paramObject);
        return;
      case 38: 
        if (paramBoolean) {
          a(((Long)arrayOfObject[0]).longValue(), ((Long)arrayOfObject[1]).longValue(), ((Long)arrayOfObject[2]).longValue(), (String)arrayOfObject[3]);
        }
        break;
      }
      for (;;)
      {
        k(paramBoolean, paramObject);
        return;
        a(-1L, -1L, -1L, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BizTroopObserver
 * JD-Core Version:    0.7.0.1
 */