package com.tencent.mobileqq.app;

import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class BizTroopObserver
  implements BusinessObserver
{
  private final String a = "BizTroopObserver";
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {}
    for (Object[] arrayOfObject = (Object[])paramObject;; arrayOfObject = null)
    {
      switch (paramInt)
      {
      case 14: 
      case 16: 
      case 17: 
      case 23: 
      default: 
        return;
      case 1: 
        if (paramBoolean)
        {
          a((String)arrayOfObject[2], (String)arrayOfObject[0], paramBoolean, (String)arrayOfObject[1]);
          return;
        }
        a("", (String)arrayOfObject[0], paramBoolean, (String)arrayOfObject[1]);
        return;
      case 3: 
        a(paramBoolean, ((Integer)arrayOfObject[1]).intValue());
        return;
      case 2: 
        e(paramBoolean, paramObject);
        return;
      case 9: 
        a(paramObject);
        return;
      case 4: 
        c(paramBoolean, paramObject);
        return;
      case 5: 
        a((String)arrayOfObject[0], paramBoolean, (String)arrayOfObject[1]);
        return;
      case 6: 
        if (paramBoolean)
        {
          a(paramBoolean, (String)arrayOfObject[0], ((Boolean)arrayOfObject[1]).booleanValue(), (List)arrayOfObject[2]);
          return;
        }
        a(paramBoolean, (String)arrayOfObject[0], ((Boolean)arrayOfObject[1]).booleanValue(), null);
        return;
      case 7: 
        a(paramBoolean, ((Integer)arrayOfObject[0]).intValue(), (List)arrayOfObject[1]);
        return;
      case 8: 
        f(paramBoolean, paramObject);
        return;
      case 10: 
        g(paramBoolean, paramObject);
        return;
      case 11: 
        a(paramBoolean, (List)paramObject);
        return;
      case 12: 
        if (paramBoolean)
        {
          a(true, ((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue(), (ArrayList)arrayOfObject[3], 0);
          return;
        }
        a(false, ((Integer)arrayOfObject[2]).intValue(), 0, 0, null, ((Integer)arrayOfObject[4]).intValue());
        return;
      case 13: 
        b(paramObject);
        return;
      case 15: 
        h(paramBoolean, paramObject);
        return;
      case 20: 
        c(paramObject);
        return;
      case 18: 
        a((String)arrayOfObject[0], ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue(), (String)arrayOfObject[3]);
        return;
      case 19: 
        i(paramBoolean, paramObject);
        return;
      case 27: 
        j(paramBoolean, paramObject);
        return;
      case 28: 
        d(paramBoolean, paramObject);
        return;
      case 29: 
        if ((arrayOfObject == null) || (arrayOfObject.length == 0))
        {
          a(false, -1L);
          return;
        }
        a(paramBoolean, ((Long)arrayOfObject[0]).longValue());
        return;
      case 21: 
        b(paramBoolean, paramObject);
        return;
      case 22: 
        if (QLog.isDevelopLevel()) {
          QLog.d("BizTroopObserver", 4, "TroopHandler.TYPE_TROOP_GAG_STATUS");
        }
        a((TroopGagMgr.GagStatus)paramObject);
        return;
      case 25: 
        a((String)arrayOfObject[0], (List)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
        return;
      case 26: 
        a(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      }
      a(paramBoolean, paramObject);
      return;
    }
  }
  
  public void a(TroopGagMgr.GagStatus paramGagStatus) {}
  
  public void a(Object paramObject) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3) {}
  
  public void a(String paramString, List paramList, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean, Object paramObject) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList, int paramInt4) {}
  
  public void a(boolean paramBoolean, int paramInt, List paramList) {}
  
  public void a(boolean paramBoolean, long paramLong) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString, List paramList) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, List paramList) {}
  
  protected void a(boolean paramBoolean, List paramList) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  protected void h(boolean paramBoolean, Object paramObject) {}
  
  protected void i(boolean paramBoolean, Object paramObject) {}
  
  public void j(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BizTroopObserver
 * JD-Core Version:    0.7.0.1
 */