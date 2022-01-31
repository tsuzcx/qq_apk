package com.tencent.mobileqq.app;

import KQQ.RespBatchProcess;
import android.os.Bundle;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopshare.TroopShareResp;
import com.tencent.qphone.base.util.QLog;
import cwp;
import cwq;
import java.util.ArrayList;
import java.util.List;

public class TroopObserver
  implements BusinessObserver, mqq.observer.BusinessObserver
{
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt, byte paramByte) {}
  
  protected void a(int paramInt, byte paramByte, String paramString) {}
  
  protected void a(int paramInt1, boolean paramBoolean, int paramInt2, long paramLong, List paramList) {}
  
  protected void a(int paramInt1, boolean paramBoolean, int paramInt2, List paramList) {}
  
  protected void a(long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3) {}
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(String paramString1, String paramString2, byte paramByte) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  protected void a(boolean paramBoolean, long paramLong, long[] paramArrayOfLong, String[] paramArrayOfString) {}
  
  protected void a(boolean paramBoolean, RespBatchProcess paramRespBatchProcess) {}
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo) {}
  
  public void a(boolean paramBoolean, TroopShareResp paramTroopShareResp) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List paramList, int paramInt) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList) {}
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void c(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void d(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      a(paramBundle.getString("troop_code"), paramBundle.getString("troop_member_uin"), paramBundle.getByte("operation"));
      return;
    }
    paramInt = 0;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("error_code");
    }
    a(paramInt);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    label1460:
    label1500:
    int i;
    label1522:
    String str;
    int j;
    switch (paramInt)
    {
    case 12: 
    case 14: 
    case 17: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 27: 
    case 30: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 41: 
    case 42: 
    case 47: 
    case 48: 
    case 53: 
    case 54: 
    case 55: 
    case 59: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 40: 
    case 6: 
    case 5: 
    case 7: 
    case 8: 
    case 10: 
    case 49: 
    case 9: 
    case 16: 
    case 11: 
    case 13: 
    case 28: 
    case 15: 
    case 18: 
    case 25: 
    case 19: 
    case 20: 
    case 50: 
    case 26: 
    case 29: 
    case 60: 
    case 32: 
    case 43: 
    case 44: 
    case 31: 
    case 33: 
    case 45: 
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
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            a(paramBoolean);
                            a();
                            return;
                            c(paramBoolean);
                          } while (paramObject == null);
                          a(paramBoolean, (ArrayList)paramObject);
                          return;
                          d(paramBoolean);
                          return;
                          b(paramBoolean);
                          return;
                          a(paramBoolean, ((Integer)paramObject).intValue());
                          return;
                          if (paramBoolean)
                          {
                            paramObject = (Object[])paramObject;
                            a(true, ((Byte)paramObject[0]).byteValue(), (TroopInfo)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
                            return;
                          }
                          a(false, (byte)0, null, false);
                          return;
                          if (paramBoolean)
                          {
                            paramObject = (Object[])paramObject;
                            a(((Integer)paramObject[0]).intValue(), ((Byte)paramObject[1]).byteValue(), (String)paramObject[2]);
                            return;
                          }
                          paramObject = (Object[])paramObject;
                          a(((Integer)paramObject[0]).intValue(), ((Byte)paramObject[1]).byteValue());
                          return;
                          paramObject = (Object[])paramObject;
                          if (paramBoolean)
                          {
                            a(true, ((Long)paramObject[0]).longValue(), (long[])paramObject[1], (String[])paramObject[3]);
                            return;
                          }
                          a(false, ((Long)paramObject[0]).longValue(), (long[])paramObject[1], null);
                          return;
                          a(paramBoolean, (String)paramObject);
                          return;
                          if (paramObject != null)
                          {
                            localObject1 = (Object[])paramObject;
                            paramObject = (ArrayList)localObject1[0];
                            localObject1 = (Boolean)localObject1[1];
                            if (QLog.isColorLevel()) {
                              QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST suc");
                            }
                            if (QLog.isColorLevel()) {
                              QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST bSaved2DBSuccess = " + localObject1);
                            }
                            d(paramBoolean, paramObject);
                            a(paramBoolean, paramObject, ((Boolean)localObject1).booleanValue());
                            return;
                          }
                          d(paramBoolean, null);
                          a(paramBoolean, null, false);
                        } while (!QLog.isColorLevel());
                        QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST failed");
                        return;
                        a(paramBoolean, paramObject);
                        return;
                        b(paramBoolean, (ArrayList)paramObject);
                        return;
                        c(paramBoolean, (ArrayList)paramObject);
                        return;
                        try
                        {
                          paramObject = (Object[])paramObject;
                          a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2]);
                          return;
                        }
                        catch (Exception paramObject) {}
                      } while (!QLog.isColorLevel());
                      QLog.d("Q.troopinfo", 2, paramObject.toString());
                      return;
                      paramObject = (cwq)paramObject;
                      a(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_Boolean, paramObject.b, paramObject.jdField_a_of_type_JavaUtilList);
                      return;
                      paramObject = (cwq)paramObject;
                      a(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_Boolean, paramObject.b, paramObject.jdField_a_of_type_Long, paramObject.jdField_a_of_type_JavaUtilList);
                      return;
                      paramObject = (cwp)paramObject;
                      a(paramObject.jdField_a_of_type_Long, paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_Boolean, paramObject.jdField_a_of_type_JavaLangString, paramObject.b, paramObject.c);
                      return;
                      paramObject = (Object[])paramObject;
                      c(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
                      return;
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
                      return;
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
                      return;
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
                      return;
                      paramObject = (Object[])paramObject;
                      b(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
                      return;
                      if (paramBoolean)
                      {
                        paramObject = (Object[])paramObject;
                        a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                        return;
                      }
                      a(false, null, -1);
                      return;
                    } while (!(paramObject instanceof Object[]));
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1], ((Integer)paramObject[2]).intValue());
                    return;
                  } while (!(paramObject instanceof Object[]));
                  paramObject = (Object[])paramObject;
                  a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
                  return;
                } while (!paramBoolean);
                a(paramBoolean, (RespBatchProcess)paramObject);
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
              a(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1]);
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (long[])paramObject[2]);
            return;
          } while (!(paramObject instanceof Object[]));
          localObject2 = (Object[])paramObject;
          paramObject = localObject1;
          if (localObject2.length >= 3)
          {
            paramObject = localObject1;
            if ((localObject2[2] instanceof String)) {
              paramObject = (String)localObject2[2];
            }
          }
          b(paramBoolean, paramObject);
          return;
        } while (!(paramObject instanceof Object[]));
        localObject1 = (Object[])paramObject;
        paramObject = localObject2;
        if (localObject1.length >= 3)
        {
          paramObject = localObject2;
          if ((localObject1[2] instanceof TroopInfo)) {
            paramObject = (TroopInfo)localObject1[2];
          }
        }
        a(paramBoolean, paramObject);
        return;
      } while (!(paramObject instanceof Object[]));
      localObject2 = (Object[])paramObject;
      paramInt = -1;
      if (localObject2.length <= 5) {
        if ((localObject2[4] instanceof List))
        {
          paramObject = (List)localObject2[4];
          if ((localObject2[3] instanceof Integer)) {
            paramInt = ((Integer)localObject2[3]).intValue();
          }
          if ((localObject2[2] instanceof String))
          {
            localObject1 = (String)localObject2[2];
            if ((localObject2[1] instanceof Integer))
            {
              i = ((Integer)localObject2[1]).intValue();
              if ((localObject2[0] instanceof String))
              {
                str = (String)localObject2[0];
                localObject2 = paramObject;
                paramObject = str;
                j = i;
                i = paramInt;
                paramInt = j;
              }
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      a(paramBoolean, paramObject, paramInt, (String)localObject1, i, (List)localObject2);
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      localObject2 = (Object[])paramObject;
      paramInt = -1;
      if (localObject2.length <= 5) {
        if ((localObject2[4] instanceof List))
        {
          paramObject = (List)localObject2[4];
          label1614:
          if ((localObject2[3] instanceof Integer)) {
            paramInt = ((Integer)localObject2[3]).intValue();
          }
          label1676:
          if ((localObject2[2] instanceof String))
          {
            localObject1 = (String)localObject2[2];
            label1654:
            if ((localObject2[1] instanceof Integer))
            {
              i = ((Integer)localObject2[1]).intValue();
              if ((localObject2[0] instanceof String))
              {
                str = (String)localObject2[0];
                localObject2 = paramObject;
                paramObject = str;
                j = i;
                i = paramInt;
                paramInt = j;
              }
            }
          }
        }
      }
      for (;;)
      {
        b(paramBoolean, paramObject, paramInt, (String)localObject1, i, (List)localObject2);
        return;
        a(paramBoolean, (TroopShareResp)paramObject);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a((String)paramObject[0], ((Integer)paramObject[1]).intValue());
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        localObject1 = (String)paramObject[0];
        ((Integer)paramObject[1]).intValue();
        paramInt = -1;
        if (paramBoolean) {
          paramInt = ((Integer)paramObject[2]).intValue();
        }
        b(paramBoolean, (String)localObject1, paramInt);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2], (String)paramObject[3]);
        return;
        b(paramBoolean, paramObject);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue());
        return;
        if ((paramObject == null) || (!(paramObject instanceof String))) {
          break;
        }
        a((String)paramObject);
        return;
        localObject2 = paramObject;
        paramObject = null;
        j = paramInt;
        paramInt = i;
        i = j;
        continue;
        i = -1;
        break label1676;
        localObject1 = null;
        break label1654;
        paramObject = null;
        break label1614;
        paramObject = null;
        localObject1 = null;
        paramInt = -1;
        localObject2 = null;
        i = -1;
      }
      localObject2 = paramObject;
      paramObject = null;
      j = paramInt;
      paramInt = i;
      i = j;
      continue;
      i = -1;
      break label1522;
      localObject1 = null;
      break label1500;
      paramObject = null;
      break label1460;
      paramObject = null;
      localObject1 = null;
      paramInt = -1;
      localObject2 = null;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopObserver
 * JD-Core Version:    0.7.0.1
 */