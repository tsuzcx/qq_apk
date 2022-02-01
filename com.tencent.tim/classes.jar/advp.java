import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.ReqBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class advp
  extends accg
{
  public advp(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject = null;
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(Integer.valueOf(17));
    localArrayList2.add(Integer.valueOf(18));
    ArrayList localArrayList1;
    if (paramInt1 != 18)
    {
      localArrayList1 = new ArrayList();
      localArrayList1.add(paramLong);
    }
    for (;;)
    {
      oidb_0x74b.ReqBody localReqBody = new oidb_0x74b.ReqBody();
      if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
        localReqBody.rpt_uint64_uin.set(localArrayList1);
      }
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        localReqBody.rpt_uint64_tinyid.set((List)localObject);
      }
      if ((localArrayList2 != null) && (!localArrayList2.isEmpty())) {
        localReqBody.rpt_head_type.set(localArrayList2);
      }
      localObject = makeOIDBPkg("OidbSvc.0x74b", 1867, 0, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).extraData.putLong("id", paramLong.longValue());
      ((ToServiceMsg)localObject).extraData.putInt("type", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("headType", paramInt2);
      ((ToServiceMsg)localObject).extraData.putInt("sizeType", paramInt3);
      ((ToServiceMsg)localObject).extraData.putBoolean("isSmartMode", paramBoolean);
      sendPbReq((ToServiceMsg)localObject);
      return;
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramLong);
      localArrayList1 = null;
    }
  }
  
  public void iH(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      notifyUI(1001, false, null);
    }
    oidb_0x74b.RspBody localRspBody;
    int j;
    int k;
    int m;
    boolean bool;
    do
    {
      return;
      localRspBody = new oidb_0x74b.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("id"));
      j = paramToServiceMsg.extraData.getInt("type");
      k = paramToServiceMsg.extraData.getInt("headType");
      m = paramToServiceMsg.extraData.getInt("sizeType");
      bool = paramToServiceMsg.extraData.getBoolean("isSmartMode");
      QLog.i("Q.dynamicAvatar", 2, "handleDynamicAvatarInfo, result : " + i);
      if (i != 0) {
        break;
      }
      paramToServiceMsg = advo.a(localRspBody);
      notifyUI(1001, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
      paramFromServiceMsg = (advr)this.mApp.getManager(180);
    } while (paramFromServiceMsg == null);
    if ((this.mApp instanceof QQAppInterface))
    {
      paramFromServiceMsg.a(paramToServiceMsg);
      return;
    }
    paramFromServiceMsg.aZ(localRspBody.toByteArray());
    return;
    QLog.i("Q.dynamicAvatar", 1, "handleGetDynamicAvatarInfo result not success.");
    notifyUI(1001, false, new Object[] { null, paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x74b");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return advq.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      do
      {
        return;
      } while (msgCmdFilter(paramFromServiceMsg.getServiceCmd()));
      paramFromServiceMsg.getServiceCmd();
    } while (!"OidbSvc.0x74b".equals(paramFromServiceMsg.getServiceCmd()));
    iH(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advp
 * JD-Core Version:    0.7.0.1
 */