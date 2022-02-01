import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler.1;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.label.comm.PersonalityTagComm.LabelInfo;
import tencent.im.oidb.cmd0x8f0.cmd0x8f0.ReqBody;
import tencent.im.oidb.cmd0x8f0.cmd0x8f0.RspBody;
import tencent.im.oidb.cmd0x8f1.oidb_0x8f1.ReqBody;
import tencent.im.oidb.cmd0x8f1.oidb_0x8f1.RspBody;
import tencent.im.oidb.cmd0x8f3.oidb_0x8f3.ReqBody;
import tencent.im.oidb.cmd0x909.oidb_0x909.ReqBody;
import tencent.im.oidb.cmd0x90c.oidb_0x90c.ReqBody;
import tencent.im.oidb.cmd0x90c.oidb_0x90c.RspBody;
import tencent.im.oidb.cmd0x91d.cmd0x91d.LabelUpdateInfo;
import tencent.im.oidb.cmd0x91d.cmd0x91d.ReqBody;
import tencent.im.oidb.cmd0x91d.cmd0x91d.RspBody;

public class albz
  extends accg
{
  public albz(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static void a(Activity paramActivity, String paramString, QQAppInterface paramQQAppInterface, PersonalityLabel paramPersonalityLabel, alcn paramalcn)
  {
    byte[] arrayOfByte = PersonalityLabel.convertToBytes(paramPersonalityLabel);
    paramActivity.runOnUiThread(new PersonalityLabelHandler.1(paramString, paramQQAppInterface, paramalcn, arrayOfByte));
    paramActivity = (acff)paramQQAppInterface.getManager(51);
    paramString = paramActivity.b(paramString);
    if (paramString != null)
    {
      paramString.vPersonalityLabelV2 = arrayOfByte;
      paramString.personalityLabel = paramPersonalityLabel;
      paramActivity.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabel,update card");
      }
    }
  }
  
  private void dEV()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "handleDeleteLabel");
    }
  }
  
  private void kN(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(3, false, null);
      return;
    }
    oidb_0x8f1.RspBody localRspBody = new oidb_0x8f1.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("key_uin", "");
    long l = paramToServiceMsg.extraData.getLong("label_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelPhotos : result = " + i + ", uin = " + paramFromServiceMsg);
    }
    if (i == 0)
    {
      notifyUI(3, true, new Object[] { paramFromServiceMsg, Long.valueOf(l), PersonalityLabelInfo.convertFromPb((PersonalityTagComm.LabelInfo)localRspBody.msg_label_info.get()), Integer.valueOf(localRspBody.uint32_complete_flag.get()), localRspBody.bytes_label_cookie.get().toByteArray() });
      return;
    }
    notifyUI(3, false, new Object[] { paramFromServiceMsg, Long.valueOf(l), null, null, null });
  }
  
  private void kP(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "handleZan");
    }
  }
  
  private void kQ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(4, false, null);
      return;
    }
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0x90c.RspBody());
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("key_uin", "");
    long l1 = paramToServiceMsg.extraData.getLong("label_id", 0L);
    long l2 = paramToServiceMsg.extraData.getLong("photo_id", 0L);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder().append("handleDeletePhoto, result==0 ");
      if (i == 0)
      {
        bool = true;
        QLog.i("PersonalityLabelHandler", 2, bool + "," + paramFromServiceMsg + "," + l2 + "," + l1);
      }
    }
    else
    {
      if (i != 0) {
        break label183;
      }
    }
    label183:
    for (boolean bool = true;; bool = false)
    {
      notifyUI(4, bool, new Object[] { paramFromServiceMsg, Long.valueOf(l1), Long.valueOf(l2) });
      return;
      bool = false;
      break;
    }
  }
  
  private void s(String paramString1, String paramString2, long paramLong)
  {
    wkh localwkh = (wkh)this.mApp.getManager(282);
    Object localObject = localwkh.a(paramString2, 0, 3);
    if (localObject != null) {
      if (((BeancurdMsg)localObject).originTime < paramLong) {
        break label230;
      }
    }
    label230:
    for (int i = 0;; i = 1) {
      for (;;)
      {
        if (i != 0) {}
        try
        {
          localObject = new BeancurdMsg();
          ((BeancurdMsg)localObject).frienduin = paramString2;
          ((BeancurdMsg)localObject).busiid = 3;
          ((BeancurdMsg)localObject).isNeedDelHistory = true;
          ((BeancurdMsg)localObject).ispush = false;
          ((BeancurdMsg)localObject).originTime = paramLong;
          ((BeancurdMsg)localObject).startTime = anaz.gQ();
          ((BeancurdMsg)localObject).validTime = 2592000L;
          ((BeancurdMsg)localObject).buffer = paramString1;
          localwkh.a((BeancurdMsg)localObject);
          return;
          localObject = this.app.b().b(paramString2, 0, new int[] { -2060 });
          if ((localObject != null) && (((List)localObject).size() > 0) && (((MessageForPLNews)((List)localObject).get(((List)localObject).size() - 1)).ts >= paramLong)) {
            i = 0;
          }
        }
        catch (Exception paramString1)
        {
          do
          {
            paramString1.printStackTrace();
          } while (!QLog.isColorLevel());
          QLog.i("PersonalityLabelHandler", 2, "handleAIOQQStoryFeedMessage: parse data to MessageRecord has error. Message: " + paramString1.getMessage());
          return;
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "getPersonalityLabelPhotos : uin = " + paramString + ", labelId = " + paramLong + ", count = " + paramInt + ", cookie = " + paramArrayOfByte);
    }
    oidb_0x8f1.ReqBody localReqBody = new oidb_0x8f1.ReqBody();
    localReqBody.uint64_req_uin.set(Long.valueOf(paramString).longValue());
    localReqBody.uint64_label_id.set(paramLong);
    localReqBody.uint32_req_num.set(paramInt);
    if (paramArrayOfByte != null) {
      localReqBody.bytes_label_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramArrayOfByte = makeOIDBPkg("OidbSvc.0x8f1", 2289, 0, localReqBody.toByteArray());
    paramArrayOfByte.extraData.putString("key_uin", paramString);
    paramArrayOfByte.extraData.putLong("label_id", paramLong);
    sendPbReq(paramArrayOfByte);
  }
  
  public void ax(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "zan");
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    paramString = new oidb_0x909.ReqBody();
    paramString.uint64_to.set(l1);
    paramString.uint64_labelid.set(paramLong);
    paramString.int32_count.set(1);
    sendPbReq(makeOIDBPkg("OidbSvc.0x909", 2313, 0, paramString.toByteArray()));
  }
  
  public void fy(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "getPersonalityLabel:" + paramString);
    }
    Object localObject = new cmd0x8f0.ReqBody();
    ((cmd0x8f0.ReqBody)localObject).uint64_req_uin.set(Long.valueOf(paramString).longValue());
    ((cmd0x8f0.ReqBody)localObject).uint32_req_digest.set(paramInt);
    localObject = makeOIDBPkg("OidbSvc.0x8f0", 2288, 0, ((cmd0x8f0.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("flag", paramInt);
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    send((ToServiceMsg)localObject);
  }
  
  public void kD(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "deleteLabel, labelId = " + paramLong);
    }
    oidb_0x8f3.ReqBody localReqBody = new oidb_0x8f3.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    localReqBody.rpt_uint64_labels.set(localArrayList);
    sendPbReq(makeOIDBPkg("OidbSvc.0x8f3", 2291, 0, localReqBody.toByteArray()));
  }
  
  @TargetApi(12)
  public void kM(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(1, false, null);
      return;
    }
    Object localObject = new cmd0x8f0.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("key_uin", "");
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder().append("handleGetPersonalityLabel, result==0 ");
      if (i != 0) {
        break label219;
      }
    }
    int j;
    label219:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("PersonalityLabelHandler", 2, bool + "," + paramFromServiceMsg);
      j = paramToServiceMsg.extraData.getInt("flag", 0);
      if (i != 0) {
        break;
      }
      paramToServiceMsg = PersonalityLabel.convertFromPb((cmd0x8f0.RspBody)localObject);
      paramObject = PersonalityLabel.convertToBytes(paramToServiceMsg);
      localObject = (acff)this.app.getManager(51);
      Card localCard = ((acff)localObject).b(paramFromServiceMsg);
      if (localCard != null)
      {
        localCard.vPersonalityLabelV2 = paramObject;
        localCard.personalityLabel = paramToServiceMsg;
        ((acff)localObject).a(localCard);
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabel,update card");
        }
      }
      notifyUI(1, true, new Object[] { paramFromServiceMsg, paramToServiceMsg, paramObject, Integer.valueOf(j) });
      return;
    }
    notifyUI(1, false, new Object[] { paramFromServiceMsg, null, null, Integer.valueOf(j) });
  }
  
  public void kO(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    label94:
    label502:
    do
    {
      long l1;
      acff localacff;
      do
      {
        int i;
        do
        {
          for (;;)
          {
            return;
            cmd0x91d.RspBody localRspBody = new cmd0x91d.RspBody();
            i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
            paramObject = paramToServiceMsg.extraData.getString("key_uin", "0");
            long l2 = paramToServiceMsg.extraData.getLong("key_timestamp", 0L);
            l1 = paramToServiceMsg.extraData.getLong("latestPLUpdateTimestamp", 0L);
            boolean bool;
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder().append("handleGetPersonalityLabelNews, result==0 ");
              if (i == 0)
              {
                bool = true;
                QLog.i("PersonalityLabelHandler", 2, bool + "," + paramObject);
              }
            }
            else
            {
              localacff = (acff)this.app.getManager(51);
              paramFromServiceMsg = localacff.a(paramObject);
              paramToServiceMsg = paramFromServiceMsg;
              if (paramFromServiceMsg == null)
              {
                paramToServiceMsg = new ExtensionInfo();
                paramToServiceMsg.uin = paramObject;
              }
              paramToServiceMsg.lastPullPLNewsTimestamp = (System.currentTimeMillis() / 1000L);
              if (i != 0) {
                break label518;
              }
              if (!localRspBody.uint64_last_time.has()) {
                break label260;
              }
              l1 = localRspBody.uint64_last_time.get();
              if ((l1 > l2) && (localRspBody.msg_update_info.has())) {
                break label269;
              }
              if (l2 < l1) {
                break label266;
              }
              l1 = l2;
            }
            for (;;)
            {
              paramToServiceMsg.latestPLUpdateTimestamp = l1;
              localacff.a(paramToServiceMsg);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews no update");
              return;
              bool = false;
              break label94;
              l1 = 0L;
              break label195;
            }
            paramToServiceMsg.lastPLNewsTimestamp = l1;
            paramToServiceMsg.latestPLUpdateTimestamp = l1;
            localacff.a(paramToServiceMsg);
            if (localRspBody.msg_update_info.has())
            {
              paramToServiceMsg = (cmd0x91d.LabelUpdateInfo)localRspBody.msg_update_info.get();
              if ((paramToServiceMsg == null) || (!paramToServiceMsg.msg_label_info.has())) {
                break label502;
              }
              paramFromServiceMsg = paramToServiceMsg.msg_label_info;
              if (paramToServiceMsg.uint32_upload_photos.has()) {
                paramToServiceMsg.uint32_upload_photos.get();
              }
              paramToServiceMsg = PersonalityLabelInfo.convertFromPb(paramFromServiceMsg);
              paramFromServiceMsg = new JSONObject();
            }
            try
            {
              paramFromServiceMsg.put("text", paramToServiceMsg.text);
              paramFromServiceMsg.put("bgColor", paramToServiceMsg.bgColor);
              paramFromServiceMsg.put("ts", l1);
              if (paramToServiceMsg.getSize() > 0) {}
              for (paramToServiceMsg = ((PersonalityLabelPhoto)paramToServiceMsg.personalityLabelPhotos.get(0)).get128SizeUrl() + albf.bVj;; paramToServiceMsg = "")
              {
                paramFromServiceMsg.put("cover", paramToServiceMsg);
                if (QLog.isColorLevel()) {
                  QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews insert gray msg");
                }
                s(paramFromServiceMsg.toString(), paramObject, l1);
                return;
                paramToServiceMsg = null;
                break;
              }
              if (!QLog.isColorLevel()) {}
            }
            catch (JSONException paramToServiceMsg) {}
          }
          QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews", paramToServiceMsg);
          return;
        } while (!QLog.isColorLevel());
        QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews update, no data");
        return;
        if (i != 1206) {
          break;
        }
        paramToServiceMsg.lastPLNewsTimestamp = l1;
        paramToServiceMsg.latestPLUpdateTimestamp = l1;
        localacff.a(paramToServiceMsg);
      } while (!QLog.isColorLevel());
      QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews 1206 " + l1);
      return;
      localacff.a(paramToServiceMsg);
    } while (!QLog.isColorLevel());
    label195:
    QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews failed");
    label260:
    label266:
    label269:
    return;
  }
  
  public void l(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "getPersonalityLabelNews uin:" + paramString + " ts:" + paramLong1);
    }
    Object localObject = new cmd0x91d.ReqBody();
    ((cmd0x91d.ReqBody)localObject).uint64_req_uin.set(Long.valueOf(paramString).longValue());
    ((cmd0x91d.ReqBody)localObject).uint64_last_time.set((int)paramLong1);
    localObject = makeOIDBPkg("OidbSvc.0x91d", 2333, 0, ((cmd0x91d.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("key_timestamp", paramLong1);
    ((ToServiceMsg)localObject).extraData.putLong("latestPLUpdateTimestamp", paramLong2);
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    send((ToServiceMsg)localObject);
  }
  
  public void m(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "deletePhoto, uin = " + paramString + ", labelId = " + paramLong1 + ", photoId = " + paramLong2);
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Object localObject;
        ArrayList localArrayList;
        localNumberFormatException.printStackTrace();
      }
    }
    localObject = new oidb_0x90c.ReqBody();
    ((oidb_0x90c.ReqBody)localObject).uint64_to.set(l1);
    ((oidb_0x90c.ReqBody)localObject).uint64_labelid.set(paramLong1);
    localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong2));
    ((oidb_0x90c.ReqBody)localObject).rpt_photoids.set(localArrayList);
    localObject = makeOIDBPkg("OidbSvc.0x90c", 2316, 0, ((oidb_0x90c.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("label_id", paramLong1);
    ((ToServiceMsg)localObject).extraData.putLong("photo_id", paramLong2);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8f0");
      this.allowCmdSet.add("OidbSvc.0x91d");
      this.allowCmdSet.add("OidbSvc.0x909");
      this.allowCmdSet.add("OidbSvc.0x90c");
      this.allowCmdSet.add("OidbSvc.0x8f3");
      this.allowCmdSet.add("OidbSvc.0x8f1");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return alcb.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x8f0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      kM(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.0x91d".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        kO(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x909".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        kP(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x90c".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        kQ(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8f3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        dEV();
        return;
      }
    } while (!"OidbSvc.0x8f1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    kN(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albz
 * JD-Core Version:    0.7.0.1
 */