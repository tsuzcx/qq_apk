import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRspItem;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.RspBody;

public class acih
  implements acci
{
  private void aA(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue(), (String)paramObject[8]);
    }
  }
  
  private void aB(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      a(((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), (String)paramObject[7]);
    }
  }
  
  private void aC(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean == true) && (paramObject != null))
    {
      paramObject = (Object[])paramObject;
      b(true, new LBSInfo(String.valueOf(paramObject[0]), String.valueOf(paramObject[1]), String.valueOf(paramObject[2]), String.valueOf(paramObject[3]), String.valueOf(paramObject[4]), String.valueOf(paramObject[5]), String.valueOf(paramObject[6]), String.valueOf(paramObject[7]), ((Integer)paramObject[8]).doubleValue(), ((Integer)paramObject[9]).doubleValue(), ((Integer)paramObject[10]).doubleValue(), (String[])paramObject[11]));
      return;
    }
    b(false, null);
  }
  
  private void aD(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null)) {
      a(true, (byte[])paramObject);
    }
  }
  
  private void aE(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      onGetNearbyMyTabCard(paramBoolean, (NearbyMyTabCard)((Object[])(Object[])paramObject)[0]);
      return;
    }
    onGetNearbyMyTabCard(false, null);
  }
  
  private void aZ(Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      jb((List)((Object[])(Object[])paramObject)[0]);
    }
  }
  
  private void av(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
    }
  }
  
  private void aw(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      j(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
    }
  }
  
  private void ax(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      L(paramBoolean, (List)((Object[])(Object[])paramObject)[0]);
    }
  }
  
  private void ay(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      g(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
    }
  }
  
  private void az(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue(), (String)paramObject[9], (String)paramObject[10], (String)paramObject[11]);
    }
  }
  
  private void ba(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 3);
    e((FromServiceMsg)paramObject[0], (ToServiceMsg)paramObject[1], (Object[])paramObject[2]);
  }
  
  private void i(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (Object[])paramObject;
    } while (localObject.length < 4);
    int i = ((Integer)localObject[0]).intValue();
    if ((localObject[1] instanceof oidb_0x8dd.RspBody)) {}
    for (paramObject = (oidb_0x8dd.RspBody)localObject[1];; paramObject = null)
    {
      if ((localObject[2] instanceof ToServiceMsg)) {}
      for (ToServiceMsg localToServiceMsg = (ToServiceMsg)localObject[2];; localToServiceMsg = null)
      {
        if ((localObject[3] instanceof List)) {}
        for (localObject = (List)localObject[3];; localObject = null)
        {
          if (paramInt == 1)
          {
            b(paramBoolean, i, paramObject, localToServiceMsg, (List)localObject);
            return;
          }
          a(paramBoolean, i, paramObject, localToServiceMsg, (List)localObject);
          return;
        }
      }
    }
  }
  
  private void r(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramBoolean) && (paramArrayOfObject != null))
    {
      a(true, (NearbyMyTabCard)paramArrayOfObject[0]);
      return;
    }
    a(false, null);
  }
  
  protected void L(boolean paramBoolean, List<ilive_feeds_near_anchor.NearAnchorInfo> paramList) {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, oidb_0x8dd.RspBody paramRspBody, ToServiceMsg paramToServiceMsg, List<Object> paramList) {}
  
  public void a(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
  
  public void a(boolean paramBoolean, String paramString1, List<ajuu> paramList, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean1, ArrayList<StrangerInfo> paramArrayList, byte[] paramArrayOfByte, int paramInt, long paramLong1, String paramString, boolean paramBoolean2, long paramLong2, long paramLong3) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  protected void b(boolean paramBoolean, int paramInt, oidb_0x8dd.RspBody paramRspBody, ToServiceMsg paramToServiceMsg, List<Object> paramList) {}
  
  protected void b(boolean paramBoolean, LBSInfo paramLBSInfo) {}
  
  protected void b(boolean paramBoolean, String paramString, long paramLong) {}
  
  protected void cKS() {}
  
  public void cKT() {}
  
  protected void e(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject) {}
  
  protected void g(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void j(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void jb(List<nearbyPeopleRecommend.QueryRspItem> paramList) {}
  
  protected void onGetNearbyMyTabCard(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 2: 
    case 7: 
    case 14: 
    default: 
      return;
    case 15: 
      ba(paramObject);
      return;
    case 1: 
    case 13: 
      i(paramInt, paramBoolean, paramObject);
      return;
    case 12: 
      cKS();
      return;
    case 3: 
      aE(paramBoolean, paramObject);
      return;
    case 4: 
      r(paramBoolean, (Object[])paramObject);
      return;
    case 5: 
      aD(paramBoolean, paramObject);
      return;
    case 6: 
      aC(paramBoolean, paramObject);
      return;
    case 8: 
      aB(paramBoolean, paramObject);
      return;
    case 9: 
      aA(paramBoolean, paramObject);
      return;
    case 10: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (List)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 11: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (ArrayList)paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), ((Long)paramObject[3]).longValue(), (String)paramObject[4], ((Boolean)paramObject[5]).booleanValue(), ((Long)paramObject[6]).longValue(), ((Long)paramObject[7]).longValue());
      return;
    case 16: 
      az(paramBoolean, paramObject);
      return;
    case 17: 
      av(paramBoolean, paramObject);
      return;
    case 18: 
      aw(paramBoolean, paramObject);
      return;
    case 19: 
      ax(paramBoolean, paramObject);
      return;
    case 20: 
      cKT();
      return;
    case 21: 
      ay(paramBoolean, paramObject);
      return;
    }
    aZ(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acih
 * JD-Core Version:    0.7.0.1
 */