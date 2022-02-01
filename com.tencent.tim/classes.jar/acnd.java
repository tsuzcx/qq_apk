import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.hw.group_mgr.CardInfo;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.RspBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.Result;
import tencent.im.troop.homework.ReqSend1V1Msg;
import tencent.im.troop.homework.RspSend1V1Msg;

public class acnd
  implements acci, BusinessObserver
{
  private void A(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 92) {}
    do
    {
      return;
      try
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (oidb_0x88d.GroupInfo)paramObject[4]);
        return;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d("oidb_0x91a_1", 2, paramObject.toString());
  }
  
  private void B(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 93) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject != null) && (paramObject.length > 1))
    {
      h(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    }
    h(paramBoolean, -1, "");
  }
  
  private void C(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 94) {}
    do
    {
      return;
      try
      {
        paramObject = (Object[])paramObject;
        j(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
        return;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d("oidb_0x91a_1", 2, paramObject.toString());
  }
  
  private void D(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 29) {
      return;
    }
    A(paramBoolean, (ArrayList)paramObject);
  }
  
  private void E(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 15) {
      return;
    }
    paramObject = (acnd.a)paramObject;
    a(paramObject.mTroopUin, paramObject.mErrCode, paramObject.mIsClear, paramObject.mLocation, paramObject.blu, paramObject.cyp);
  }
  
  private void F(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 18) {
      return;
    }
    paramObject = (Object[])paramObject;
    Object[] arrayOfObject = new Object[2];
    if (paramObject.length == 7)
    {
      arrayOfObject[0] = paramObject[5];
      arrayOfObject[1] = paramObject[6];
    }
    a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4], arrayOfObject);
  }
  
  private void G(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 26) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
  }
  
  private void H(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 19) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
  }
  
  private void I(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 20) {
      return;
    }
    paramObject = (Object[])paramObject;
    b(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
  }
  
  private void J(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 21) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
  }
  
  private void K(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 51) {
      return;
    }
    paramObject = (Object[])paramObject;
    b(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
  }
  
  private void L(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 27) {
      return;
    }
    if (paramBoolean)
    {
      paramObject = (Object[])paramObject;
      h(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    }
    h(false, null, -1);
  }
  
  private void M(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 30) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1], ((Integer)paramObject[2]).intValue());
  }
  
  private void N(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 62) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue());
  }
  
  private void O(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 90) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    ah(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void P(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 67) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 3);
    a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
  }
  
  private void Q(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 33) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while (!(paramObject instanceof Object[]));
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Long)paramObject[0]).longValue(), (RespBatchProcess)paramObject[1], (Bundle)paramObject[2]);
    return;
    a(paramBoolean, -1L, null, null);
  }
  
  private void R(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 44) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    paramInt = ((Integer)paramObject[0]).intValue();
    ArrayList localArrayList = (ArrayList)paramObject[1];
    b(paramBoolean, paramInt, localArrayList);
    if (paramObject.length > 2)
    {
      a(paramBoolean, paramInt, localArrayList, (String)paramObject[2]);
      return;
    }
    a(paramBoolean, paramInt, localArrayList, null);
  }
  
  private void S(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 45) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (long[])paramObject[2]);
  }
  
  private void T(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 32) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    Object localObject = null;
    paramObject = localObject;
    if (arrayOfObject.length >= 3)
    {
      paramObject = localObject;
      if ((arrayOfObject[2] instanceof String)) {
        paramObject = (String)arrayOfObject[2];
      }
    }
    T(paramBoolean, paramObject);
  }
  
  private void U(int paramInt, boolean paramBoolean, Object paramObject)
  {
    String str = null;
    if (paramInt != 34) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    if ((arrayOfObject.length >= 3) && ((arrayOfObject[2] instanceof TroopInfo)))
    {
      paramObject = (TroopInfo)arrayOfObject[2];
      str = (String)arrayOfObject[5];
    }
    for (;;)
    {
      a(paramBoolean, paramObject, str);
      return;
      paramObject = null;
    }
  }
  
  private void V(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = -1;
    String str = null;
    if (paramInt != 46) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    List localList;
    label76:
    label94:
    int j;
    if (arrayOfObject.length <= 5) {
      if ((arrayOfObject[4] instanceof List))
      {
        localList = (List)arrayOfObject[4];
        if ((arrayOfObject[3] instanceof Integer))
        {
          paramInt = ((Integer)arrayOfObject[3]).intValue();
          if ((arrayOfObject[2] instanceof String))
          {
            paramObject = (String)arrayOfObject[2];
            if ((arrayOfObject[1] instanceof Integer)) {
              i = ((Integer)arrayOfObject[1]).intValue();
            }
            if ((arrayOfObject[0] instanceof String))
            {
              str = (String)arrayOfObject[0];
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
      a(paramBoolean, str, paramInt, paramObject, i, localList);
      return;
      j = paramInt;
      paramInt = i;
      i = j;
      continue;
      paramObject = null;
      break label94;
      paramInt = -1;
      break label76;
      localList = null;
      break;
      localList = null;
      i = -1;
      paramInt = -1;
      paramObject = null;
    }
  }
  
  private void W(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = -1;
    Object localObject2 = null;
    if (paramInt != 47) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    Object localObject3 = (Object[])paramObject;
    label75:
    Object localObject1;
    label94:
    int j;
    if (localObject3.length <= 5) {
      if ((localObject3[4] instanceof List))
      {
        paramObject = (List)localObject3[4];
        if ((localObject3[3] instanceof Integer))
        {
          paramInt = ((Integer)localObject3[3]).intValue();
          if ((localObject3[2] instanceof String))
          {
            localObject1 = (String)localObject3[2];
            if ((localObject3[1] instanceof Integer)) {
              i = ((Integer)localObject3[1]).intValue();
            }
            if ((localObject3[0] instanceof String))
            {
              localObject3 = (String)localObject3[0];
              j = i;
              localObject2 = localObject1;
              localObject1 = paramObject;
              i = paramInt;
              paramObject = localObject2;
              paramInt = j;
              localObject2 = localObject3;
            }
          }
        }
      }
    }
    for (;;)
    {
      b(paramBoolean, localObject2, paramInt, paramObject, i, (List)localObject1);
      return;
      localObject3 = paramObject;
      paramObject = localObject1;
      j = paramInt;
      paramInt = i;
      i = j;
      localObject1 = localObject3;
      continue;
      localObject1 = null;
      break label94;
      paramInt = -1;
      break label75;
      paramObject = null;
      break;
      localObject1 = null;
      i = -1;
      paramInt = -1;
      paramObject = null;
    }
  }
  
  private void X(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 0) {
      return;
    }
    a(paramBoolean, (apzf)paramObject);
  }
  
  private void Y(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 118) {
      return;
    }
    long l;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length > 0)
      {
        l = ((Long)paramObject[0]).longValue();
        if (paramObject.length > 1) {
          paramInt = ((Integer)paramObject[1]).intValue();
        }
      }
    }
    for (;;)
    {
      g(paramBoolean, l, paramInt);
      return;
      paramInt = 0;
      continue;
      l = -1L;
      break;
      l = -1L;
      paramInt = 0;
    }
  }
  
  private void Z(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 119) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      localObject1 = localObject2;
      if (paramObject.length > 0) {
        localObject1 = (apgk)paramObject[0];
      }
    }
    a(paramBoolean, (apgk)localObject1);
  }
  
  private void aA(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 83) {
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramObject.length > 3)
    {
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue());
      return;
    }
    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), false, 0, 0);
  }
  
  private void aB(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 85) {
      return;
    }
    paramObject = (Object[])paramObject;
    b(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
  }
  
  private void aC(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 86) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  private void aD(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 87) {
      return;
    }
    paramObject = (Object[])paramObject;
    e(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue());
  }
  
  private void aE(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 88) {
      return;
    }
    aQ(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
  
  private void aF(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 89) {
      return;
    }
    aP(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
  
  private void aG(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 95) {
      return;
    }
    paramObject = (Object[])paramObject;
    d(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void aH(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 96) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5], (String)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue(), ((Long)paramObject[9]).longValue());
  }
  
  private void aI(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 97) {
      return;
    }
    a((apdj.a)paramObject);
  }
  
  private void aJ(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 98) {
      return;
    }
    paramObject = (Object[])paramObject;
    q(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void aK(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 99) {
      return;
    }
    paramObject = (Object[])paramObject;
    l(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  private void aL(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 100) {
      return;
    }
    paramObject = (Object[])paramObject;
    h(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  private void aM(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 101) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void aN(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 102) {
      return;
    }
    paramObject = (Object[])paramObject;
    b(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void aO(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 122) {
      return;
    }
    paramObject = (Object[])paramObject;
    c(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void aP(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 103) {
      return;
    }
    paramObject = (Object[])paramObject;
    p(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void aQ(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 105) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), (HashMap)paramObject[6], (List)paramObject[7]);
  }
  
  private void aR(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 113) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
  }
  
  private void aS(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 115) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    if (arrayOfObject[2] != null) {}
    for (paramObject = (List)arrayOfObject[2];; paramObject = null)
    {
      a(paramBoolean, (String)arrayOfObject[0], ((Integer)arrayOfObject[1]).intValue(), paramObject);
      return;
    }
  }
  
  private void aT(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 112) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Boolean)paramObject[3]).booleanValue());
  }
  
  private void aU(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 104) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue());
  }
  
  private void aV(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 106) {
      return;
    }
    paramObject = (Pair)paramObject;
    h(paramBoolean, ((Boolean)paramObject.first).booleanValue(), (String)paramObject.second);
  }
  
  private void aW(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 107) {
      return;
    }
    chP();
  }
  
  private void aX(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 108) {
      return;
    }
    yA((String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void aY(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 109) {
      return;
    }
    paramObject = (Object[])paramObject;
    a((oidb_0xea4.RspBody)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  private void aZ(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 110) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4]);
  }
  
  private void aa(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 120) {
      return;
    }
    int i = 0;
    paramInt = i;
    if (paramObject != null)
    {
      paramInt = i;
      if ((paramObject instanceof Integer)) {
        paramInt = ((Integer)paramObject).intValue();
      }
    }
    bc(paramBoolean, paramInt);
  }
  
  private void ab(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 71) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (ArrayList)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue());
  }
  
  private void ac(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 84) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (ProfileActivity.AllInOne)paramObject[6]);
  }
  
  private void ad(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 72) {
      return;
    }
    i(Boolean.valueOf(paramBoolean));
  }
  
  private void ae(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 73) {
      return;
    }
    j(Boolean.valueOf(paramBoolean));
  }
  
  private void af(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 74) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(Boolean.valueOf(paramBoolean), (ArrayList)paramObject[0], (List)paramObject[1]);
  }
  
  private void ag(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 52) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    bC((String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  private void ah(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 48) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (String)paramObject[6], (String)paramObject[7]);
      return;
    }
    a(paramBoolean, null, null, 0, 0, 0, 0, null, null);
  }
  
  private void ai(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 53) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    String str = (String)paramObject[0];
    ((Integer)paramObject[1]).intValue();
    paramInt = -1;
    if (paramBoolean) {
      paramInt = ((Integer)paramObject[2]).intValue();
    }
    i(paramBoolean, str, paramInt);
  }
  
  private void aj(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 54) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
  }
  
  private void ak(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 55) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
  }
  
  private void al(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 56) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    paramInt = ((Integer)paramObject[0]).intValue();
    List localList = (List)paramObject[1];
    if (paramObject.length >= 3)
    {
      b(paramBoolean, paramInt, localList, (List)paramObject[2]);
      return;
    }
    b(paramBoolean, paramInt, localList, null);
  }
  
  private void am(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = false;
    if (paramInt != 57) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    String str1 = (String)paramObject[0];
    boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
    String str2 = (String)paramObject[2];
    String str3 = (String)paramObject[3];
    if (paramObject.length >= 5) {
      bool1 = ((Boolean)paramObject[4]).booleanValue();
    }
    a(paramBoolean, str1, bool2, str2, str3, bool1);
  }
  
  private void an(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 58) {
      return;
    }
    u(paramBoolean, paramObject);
  }
  
  private void ao(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 60) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
  }
  
  private void ap(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 59) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    boolean bool1 = ((Boolean)paramObject[0]).booleanValue();
    boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
    boolean bool3 = ((Boolean)paramObject[2]).booleanValue();
    a((String)paramObject[3], paramBoolean, bool1, bool2, bool3);
  }
  
  private void aq(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 63) {}
    while ((paramObject == null) || (!(paramObject instanceof String))) {
      return;
    }
    wK((String)paramObject);
  }
  
  private void ar(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 64) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    ag((String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
  }
  
  private void as(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 65) {
      return;
    }
    if ((paramObject instanceof String))
    {
      uX((String)paramObject);
      return;
    }
    uX(null);
  }
  
  private void at(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 66) {
      return;
    }
    if ((paramObject instanceof Long))
    {
      y(paramBoolean, ((Long)paramObject).longValue());
      return;
    }
    y(paramBoolean, 0L);
  }
  
  private void au(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 68) {
      return;
    }
    yz((String)paramObject);
  }
  
  private void av(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 69) {
      return;
    }
    if (paramBoolean)
    {
      a(0, "", (group_mgr.CardInfo)paramObject);
      return;
    }
    paramObject = (Object[])paramObject;
    a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], null);
  }
  
  private void aw(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 70) {
      return;
    }
    paramObject = (Object[])paramObject;
    cd(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
  }
  
  private void ax(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 75) {
      return;
    }
    paramObject = (Object[])paramObject;
    RecvGVideoLevelInfo[] arrayOfRecvGVideoLevelInfo = new RecvGVideoLevelInfo[paramObject.length];
    paramInt = 0;
    while (paramInt < arrayOfRecvGVideoLevelInfo.length)
    {
      arrayOfRecvGVideoLevelInfo[paramInt] = ((RecvGVideoLevelInfo)paramObject[paramInt]);
      paramInt += 1;
    }
    b(arrayOfRecvGVideoLevelInfo);
  }
  
  private void ay(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 77) {
      return;
    }
    paramObject = (Object[])paramObject;
    c(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
  }
  
  private void az(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 82) {
      return;
    }
    paramObject = (Object[])paramObject;
    dG((String)paramObject[0], (String)paramObject[1]);
  }
  
  private void bA(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    if (paramInt != 147) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    paramInt = ((Integer)paramObject[0]).intValue();
    int i = ((Integer)paramObject[1]).intValue();
    int j = ((Integer)paramObject[2]).intValue();
    ArrayList localArrayList = (ArrayList)paramObject[3];
    boolean bool2 = ((Boolean)paramObject[4]).booleanValue();
    if (j == 1) {}
    for (;;)
    {
      b(paramBoolean, paramInt, i, bool1, localArrayList, bool2);
      return;
      bool1 = false;
    }
  }
  
  private void bB(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 142) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 2);
    dj((String)paramObject[0], (String)paramObject[1]);
  }
  
  private void bC(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 144) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 3);
    v((String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
  }
  
  private void bD(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 145) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    g(paramBoolean, (ArrayList)((Object[])(Object[])paramObject)[0]);
  }
  
  private void bE(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 148) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 5);
    a(paramBoolean, (String)paramObject[0], (ArrayList)paramObject[1], (byte[])paramObject[2], ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
  }
  
  private void bF(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 149) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        a(paramBoolean, ((Long)paramObject[0]).longValue(), (List)paramObject[1], ((Integer)paramObject[2]).intValue());
        return;
      }
      a(false, 0L, null, -1);
      return;
    }
    a(false, 0L, null, -1);
  }
  
  private void bG(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 150) {}
    do
    {
      do
      {
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 4);
    a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3]);
  }
  
  private void ba(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 111) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
  }
  
  private void bb(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 61) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
  }
  
  private void bc(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    ai(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void bd(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 114) {
      return;
    }
    paramObject = (Object[])paramObject;
    l(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void be(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 116) {
      return;
    }
    paramObject = (Object[])paramObject;
    di((String)paramObject[0], (String)paramObject[1]);
  }
  
  private void bf(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 117) {
      return;
    }
    paramObject = (Object[])paramObject;
    E((String)paramObject[0], (List)paramObject[1]);
  }
  
  private void bg(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 121) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (homework.RspSend1V1Msg)paramObject[0], (homework.ReqSend1V1Msg)paramObject[1]);
  }
  
  private void bh(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 125) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    S(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void bi(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 126) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    cG((String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  private void bj(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 127) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    yB((String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void bk(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 128) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    aw(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void bl(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 129) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    k(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void bm(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 130) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (ArrayList)paramObject[3], ((Integer)paramObject[4]).intValue());
      return;
    }
    a(false, -1, 0, 0, null, 0);
  }
  
  private void bn(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 143) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 2)
      {
        a(paramBoolean, ((Long)paramObject[0]).longValue(), (ArrayList)paramObject[1]);
        return;
      }
      a(false, 0L, null);
      return;
    }
    a(false, 0L, null);
  }
  
  private void bo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 131) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 3);
    c(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), (ArrayList)paramObject[2]);
  }
  
  private void bp(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 132) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 3);
    a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), (aptu)paramObject[2]);
  }
  
  private void bq(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 133) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
      } while (paramObject.length < 4);
      paramInt = ((Integer)paramObject[3]).intValue();
      if (paramInt == 0)
      {
        c(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
        return;
      }
    } while (paramInt != 1);
    b(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
  }
  
  private void br(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 134) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 3);
    b(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
  }
  
  private void bs(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 135) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      localObject = (Object[])paramObject;
    } while (localObject.length < 4);
    paramObject = (Boolean)localObject[0];
    String str1 = (String)localObject[1];
    String str2 = (String)localObject[2];
    Object localObject = (String)localObject[3];
    if (paramObject.booleanValue())
    {
      ay(str1, str2, (String)localObject);
      return;
    }
    ac(str1, str2, (String)localObject);
  }
  
  private void bt(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 136) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 2);
    bb((String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  private void bu(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 137) {
      return;
    }
    String str = "";
    if ((paramObject instanceof Object[])) {
      str = (String)((Object[])(Object[])paramObject)[0];
    }
    ax(paramBoolean, str);
  }
  
  private void bv(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 138) {
      return;
    }
    String str1 = "";
    String str2 = "";
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      str1 = (String)paramObject[0];
      str2 = (String)paramObject[1];
    }
    z(paramBoolean, str1, str2);
  }
  
  private void bw(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 139) {
      return;
    }
    paramInt = -1;
    long l = 0L;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      paramInt = ((Integer)paramObject[0]).intValue();
      l = ((Long)paramObject[1]).longValue();
    }
    c(paramBoolean, paramInt, l);
  }
  
  private void bx(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 140) {
      return;
    }
    boolean bool = true;
    if ((paramObject instanceof Object[])) {
      bool = ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue();
    }
    bL(paramBoolean, bool);
  }
  
  private void by(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool = true;
    if (paramInt != 141) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    long l = ((Long)paramObject[0]).longValue();
    paramInt = ((Integer)paramObject[1]).intValue();
    int i = ((Integer)paramObject[2]).intValue();
    paramObject = (ArrayList)paramObject[3];
    if (i == 1) {}
    for (;;)
    {
      b(paramBoolean, l, paramInt, bool, paramObject);
      return;
      bool = false;
    }
  }
  
  private void bz(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    if (paramInt != 146) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    paramInt = ((Integer)paramObject[0]).intValue();
    String str = (String)paramObject[1];
    int i = ((Integer)paramObject[2]).intValue();
    int j = ((Integer)paramObject[3]).intValue();
    ArrayList localArrayList = (ArrayList)paramObject[4];
    boolean bool2 = ((Boolean)paramObject[5]).booleanValue();
    if (j == 1) {}
    for (;;)
    {
      b(paramBoolean, paramInt, str, i, bool1, localArrayList, bool2);
      return;
      bool1 = false;
    }
  }
  
  private void j(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 2) {
      return;
    }
    jc(paramBoolean);
    onUpdateRecentList();
  }
  
  private void k(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 80) {
      return;
    }
    onUpdateRecentList();
  }
  
  private void l(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 3) {}
    do
    {
      return;
      xj(paramBoolean);
    } while (paramObject == null);
    d(paramBoolean, (ArrayList)paramObject);
  }
  
  private void m(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 5) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    if (arrayOfObject.length == 5)
    {
      String str = (String)arrayOfObject[0];
      if (arrayOfObject[1] == null) {}
      for (paramObject = null;; paramObject = (List)arrayOfObject[1])
      {
        a(str, paramBoolean, paramObject, ((Integer)arrayOfObject[2]).intValue(), ((Long)arrayOfObject[3]).longValue(), ((Integer)arrayOfObject[4]).intValue());
        return;
      }
    }
    QLog.d("TroopObserver", 1, "onUpdate,TYPR_GET_TROOP_GETMEMBERLIST datas.length error");
  }
  
  private void n(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 76) {
      return;
    }
    v(paramBoolean, (List)paramObject);
  }
  
  private void o(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 41) {
      return;
    }
    bb(paramBoolean, ((Integer)paramObject).intValue());
  }
  
  private void p(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 7) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    byte b = ((Byte)arrayOfObject[0]).byteValue();
    if (arrayOfObject[1] != null) {}
    for (paramObject = (TroopInfo)arrayOfObject[1];; paramObject = null)
    {
      a(true, b, paramObject, ((Boolean)arrayOfObject[2]).booleanValue());
      return;
    }
  }
  
  private void q(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 6) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject[1] instanceof Integer)) {}
    for (paramInt = ((Integer)paramObject[1]).intValue(); paramBoolean; paramInt = ((Byte)paramObject[1]).byteValue())
    {
      q(((Integer)paramObject[0]).intValue(), paramInt, (String)paramObject[2]);
      return;
    }
    eE(((Integer)paramObject[0]).intValue(), paramInt);
  }
  
  private void r(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 8) {
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramBoolean)
    {
      a(true, ((Long)paramObject[0]).longValue(), (long[])paramObject[1], (String[])paramObject[3]);
      return;
    }
    a(false, ((Long)paramObject[0]).longValue(), (long[])paramObject[1], null);
  }
  
  private void s(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 9) {
      return;
    }
    H(paramBoolean, (String)paramObject);
  }
  
  private void t(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 91) {}
    do
    {
      return;
      try
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, (Long)paramObject[0], (List)paramObject[1]);
        return;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d("onGetInvitedUinList", 2, paramObject.toString());
  }
  
  private void u(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 11) {}
    do
    {
      return;
      if (paramObject != null)
      {
        Object localObject = (Object[])paramObject;
        paramObject = (ArrayList)localObject[0];
        localObject = (Boolean)localObject[1];
        if (QLog.isColorLevel()) {
          QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST suc");
        }
        if (QLog.isColorLevel()) {
          QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST bSaved2DBSuccess = " + localObject);
        }
        c(paramBoolean, paramObject);
        a(paramBoolean, paramObject, ((Boolean)localObject).booleanValue());
        return;
      }
      c(paramBoolean, null);
      a(paramBoolean, null, false);
    } while (!QLog.isColorLevel());
    QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST failed");
  }
  
  private void v(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 50) {
      return;
    }
    v(paramBoolean, paramObject);
  }
  
  private void w(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 79) {
      return;
    }
    J(paramBoolean, paramObject);
  }
  
  private void x(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 10) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject != null) && (paramObject.length > 1))
    {
      b(paramBoolean, (ArrayList)paramObject[0], (String)paramObject[1]);
      return;
    }
    b(paramBoolean, null, "");
  }
  
  private void y(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 16) {
      return;
    }
    e(paramBoolean, (ArrayList)paramObject);
  }
  
  private void z(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 12) {}
    do
    {
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
  }
  
  protected void A(boolean paramBoolean, List<RecommendTroopItem> paramList) {}
  
  protected void By(int paramInt) {}
  
  protected void E(String paramString, List<Pair<String, String>> paramList) {}
  
  protected void H(boolean paramBoolean, String paramString) {}
  
  protected void J(boolean paramBoolean, Object paramObject) {}
  
  protected void S(boolean paramBoolean, String paramString) {}
  
  protected void T(boolean paramBoolean, String paramString) {}
  
  protected void a(int paramInt, String paramString, group_mgr.CardInfo paramCardInfo) {}
  
  protected void a(long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3) {}
  
  protected void a(apdj.a parama) {}
  
  protected void a(Boolean paramBoolean, ArrayList<Integer> paramArrayList, List<cmd0xca05.Result> paramList) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  protected void a(oidb_0xea4.RspBody paramRspBody, int paramInt) {}
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, aptu paramaptu) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProfileActivity.AllInOne paramAllInOne) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4, int paramInt5) {}
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject) {}
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList<String> paramArrayList) {}
  
  public void a(boolean paramBoolean, long paramLong, List paramList, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong, long[] paramArrayOfLong, String[] paramArrayOfString) {}
  
  public void a(boolean paramBoolean, apgk paramapgk) {}
  
  public void a(boolean paramBoolean, apzf paramapzf) {}
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString) {}
  
  protected void a(boolean paramBoolean, Long paramLong, List<Long> paramList) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, oidb_0x88d.GroupInfo paramGroupInfo) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, List<String> paramList) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, int paramInt) {}
  
  protected void a(boolean paramBoolean1, String paramString, long paramLong, int paramInt, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap, List<String> paramList) {}
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, String paramString1, ArrayList<yva> paramArrayList, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString, List<String> paramList) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2) {}
  
  protected void a(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, homework.RspSend1V1Msg paramRspSend1V1Msg, homework.ReqSend1V1Msg paramReqSend1V1Msg) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<apyk> paramList, int paramInt) {}
  
  protected void aP(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void aQ(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void ac(String paramString1, String paramString2, String paramString3) {}
  
  protected void ag(String paramString1, String paramString2, String paramString3) {}
  
  protected void ah(boolean paramBoolean, String paramString) {}
  
  protected void ai(boolean paramBoolean, String paramString) {}
  
  protected void aw(boolean paramBoolean, String paramString) {}
  
  protected void ax(boolean paramBoolean, String paramString) {}
  
  protected void ay(String paramString1, String paramString2, String paramString3) {}
  
  protected void b(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2) {}
  
  protected void b(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void b(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList) {}
  
  protected void b(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList, List<String> paramList1) {}
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void b(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void b(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList) {}
  
  protected void b(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList) {}
  
  protected void b(boolean paramBoolean, String paramString, List<String> paramList) {}
  
  protected void b(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString) {}
  
  protected void b(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo) {}
  
  protected void bC(String paramString, int paramInt) {}
  
  protected void bL(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void bb(String paramString, boolean paramBoolean) {}
  
  protected void bb(boolean paramBoolean, int paramInt) {}
  
  public void bc(boolean paramBoolean, int paramInt) {}
  
  protected void c(String paramString1, String paramString2, byte paramByte) {}
  
  protected void c(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void c(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2) {}
  
  protected void c(boolean paramBoolean, int paramInt, long paramLong, ArrayList<aptv> paramArrayList) {}
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void c(boolean paramBoolean, String paramString, List<oidb_0xa2a.UserInfo> paramList) {}
  
  protected void c(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList) {}
  
  protected void cG(String paramString, int paramInt) {}
  
  protected void cd(int paramInt, String paramString) {}
  
  protected void chP() {}
  
  protected void d(boolean paramBoolean, String paramString, List<TroopAIONotifyItem> paramList) {}
  
  protected void d(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList) {}
  
  protected void dG(String paramString1, String paramString2) {}
  
  protected void di(String paramString1, String paramString2) {}
  
  protected void dj(String paramString1, String paramString2) {}
  
  protected void e(boolean paramBoolean, long paramLong, int paramInt) {}
  
  protected void e(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList) {}
  
  protected void eE(int paramInt1, int paramInt2) {}
  
  public void g(boolean paramBoolean, long paramLong, int paramInt) {}
  
  protected void g(boolean paramBoolean, ArrayList<ypn> paramArrayList) {}
  
  protected void h(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void h(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void h(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void h(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  protected void i(Boolean paramBoolean) {}
  
  protected void i(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void j(Boolean paramBoolean) {}
  
  protected void j(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void jc(boolean paramBoolean) {}
  
  protected void k(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void l(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void l(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      c(paramBundle.getString("troop_code"), paramBundle.getString("troop_member_uin"), paramBundle.getByte("operation"));
      return;
    }
    paramInt = 0;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("error_code");
    }
    By(paramInt);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    j(paramInt, paramBoolean, paramObject);
    k(paramInt, paramBoolean, paramObject);
    l(paramInt, paramBoolean, paramObject);
    m(paramInt, paramBoolean, paramObject);
    n(paramInt, paramBoolean, paramObject);
    o(paramInt, paramBoolean, paramObject);
    p(paramInt, paramBoolean, paramObject);
    q(paramInt, paramBoolean, paramObject);
    r(paramInt, paramBoolean, paramObject);
    s(paramInt, paramBoolean, paramObject);
    t(paramInt, paramBoolean, paramObject);
    u(paramInt, paramBoolean, paramObject);
    v(paramInt, paramBoolean, paramObject);
    w(paramInt, paramBoolean, paramObject);
    x(paramInt, paramBoolean, paramObject);
    y(paramInt, paramBoolean, paramObject);
    z(paramInt, paramBoolean, paramObject);
    A(paramInt, paramBoolean, paramObject);
    B(paramInt, paramBoolean, paramObject);
    C(paramInt, paramBoolean, paramObject);
    D(paramInt, paramBoolean, paramObject);
    E(paramInt, paramBoolean, paramObject);
    F(paramInt, paramBoolean, paramObject);
    G(paramInt, paramBoolean, paramObject);
    H(paramInt, paramBoolean, paramObject);
    I(paramInt, paramBoolean, paramObject);
    J(paramInt, paramBoolean, paramObject);
    K(paramInt, paramBoolean, paramObject);
    L(paramInt, paramBoolean, paramObject);
    M(paramInt, paramBoolean, paramObject);
    N(paramInt, paramBoolean, paramObject);
    O(paramInt, paramBoolean, paramObject);
    P(paramInt, paramBoolean, paramObject);
    Q(paramInt, paramBoolean, paramObject);
    R(paramInt, paramBoolean, paramObject);
    S(paramInt, paramBoolean, paramObject);
    T(paramInt, paramBoolean, paramObject);
    U(paramInt, paramBoolean, paramObject);
    V(paramInt, paramBoolean, paramObject);
    W(paramInt, paramBoolean, paramObject);
    X(paramInt, paramBoolean, paramObject);
    Y(paramInt, paramBoolean, paramObject);
    Z(paramInt, paramBoolean, paramObject);
    aa(paramInt, paramBoolean, paramObject);
    ab(paramInt, paramBoolean, paramObject);
    ac(paramInt, paramBoolean, paramObject);
    ad(paramInt, paramBoolean, paramObject);
    ae(paramInt, paramBoolean, paramObject);
    af(paramInt, paramBoolean, paramObject);
    ag(paramInt, paramBoolean, paramObject);
    ah(paramInt, paramBoolean, paramObject);
    ai(paramInt, paramBoolean, paramObject);
    aj(paramInt, paramBoolean, paramObject);
    ak(paramInt, paramBoolean, paramObject);
    al(paramInt, paramBoolean, paramObject);
    am(paramInt, paramBoolean, paramObject);
    an(paramInt, paramBoolean, paramObject);
    ao(paramInt, paramBoolean, paramObject);
    ap(paramInt, paramBoolean, paramObject);
    aq(paramInt, paramBoolean, paramObject);
    ar(paramInt, paramBoolean, paramObject);
    as(paramInt, paramBoolean, paramObject);
    at(paramInt, paramBoolean, paramObject);
    au(paramInt, paramBoolean, paramObject);
    av(paramInt, paramBoolean, paramObject);
    aw(paramInt, paramBoolean, paramObject);
    ax(paramInt, paramBoolean, paramObject);
    ay(paramInt, paramBoolean, paramObject);
    az(paramInt, paramBoolean, paramObject);
    aA(paramInt, paramBoolean, paramObject);
    aB(paramInt, paramBoolean, paramObject);
    aC(paramInt, paramBoolean, paramObject);
    aD(paramInt, paramBoolean, paramObject);
    aE(paramInt, paramBoolean, paramObject);
    aF(paramInt, paramBoolean, paramObject);
    aG(paramInt, paramBoolean, paramObject);
    aH(paramInt, paramBoolean, paramObject);
    aI(paramInt, paramBoolean, paramObject);
    aJ(paramInt, paramBoolean, paramObject);
    aK(paramInt, paramBoolean, paramObject);
    aL(paramInt, paramBoolean, paramObject);
    aM(paramInt, paramBoolean, paramObject);
    aN(paramInt, paramBoolean, paramObject);
    aO(paramInt, paramBoolean, paramObject);
    aP(paramInt, paramBoolean, paramObject);
    aQ(paramInt, paramBoolean, paramObject);
    aR(paramInt, paramBoolean, paramObject);
    aS(paramInt, paramBoolean, paramObject);
    aT(paramInt, paramBoolean, paramObject);
    aU(paramInt, paramBoolean, paramObject);
    aV(paramInt, paramBoolean, paramObject);
    aW(paramInt, paramBoolean, paramObject);
    aX(paramInt, paramBoolean, paramObject);
    aY(paramInt, paramBoolean, paramObject);
    aZ(paramInt, paramBoolean, paramObject);
    ba(paramInt, paramBoolean, paramObject);
    bb(paramInt, paramBoolean, paramObject);
    bc(paramInt, paramBoolean, paramObject);
    bd(paramInt, paramBoolean, paramObject);
    be(paramInt, paramBoolean, paramObject);
    bf(paramInt, paramBoolean, paramObject);
    bg(paramInt, paramBoolean, paramObject);
    bh(paramInt, paramBoolean, paramObject);
    bi(paramInt, paramBoolean, paramObject);
    bj(paramInt, paramBoolean, paramObject);
    bk(paramInt, paramBoolean, paramObject);
    bl(paramInt, paramBoolean, paramObject);
    bm(paramInt, paramBoolean, paramObject);
    bn(paramInt, paramBoolean, paramObject);
    bo(paramInt, paramBoolean, paramObject);
    bp(paramInt, paramBoolean, paramObject);
    bq(paramInt, paramBoolean, paramObject);
    br(paramInt, paramBoolean, paramObject);
    bs(paramInt, paramBoolean, paramObject);
    bt(paramInt, paramBoolean, paramObject);
    bu(paramInt, paramBoolean, paramObject);
    bv(paramInt, paramBoolean, paramObject);
    bw(paramInt, paramBoolean, paramObject);
    bx(paramInt, paramBoolean, paramObject);
    by(paramInt, paramBoolean, paramObject);
    bz(paramInt, paramBoolean, paramObject);
    bA(paramInt, paramBoolean, paramObject);
    bB(paramInt, paramBoolean, paramObject);
    bC(paramInt, paramBoolean, paramObject);
    bD(paramInt, paramBoolean, paramObject);
    bE(paramInt, paramBoolean, paramObject);
    bF(paramInt, paramBoolean, paramObject);
    bG(paramInt, paramBoolean, paramObject);
  }
  
  protected void onUpdateRecentList() {}
  
  protected void p(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void q(int paramInt1, int paramInt2, String paramString) {}
  
  protected void q(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void u(boolean paramBoolean, Object paramObject) {}
  
  protected void uX(String paramString) {}
  
  protected void v(String paramString1, String paramString2, int paramInt) {}
  
  protected void v(boolean paramBoolean, Object paramObject) {}
  
  protected void v(boolean paramBoolean, List<cmd0x406.GroupFeeMember> paramList) {}
  
  protected void wK(String paramString) {}
  
  protected void xj(boolean paramBoolean) {}
  
  protected void y(boolean paramBoolean, long paramLong) {}
  
  protected void yA(String paramString) {}
  
  protected void yB(String paramString) {}
  
  protected void yz(String paramString) {}
  
  protected void z(boolean paramBoolean, String paramString1, String paramString2) {}
  
  static class a
  {
    public int blu;
    public int cyp;
    public int mErrCode;
    public boolean mIsClear;
    public String mLocation;
    public long mTroopUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acnd
 * JD-Core Version:    0.7.0.1
 */