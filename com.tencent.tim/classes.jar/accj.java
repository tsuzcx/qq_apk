import android.os.Bundle;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler.1;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.selfgif.CameraEmotionRoaming_sso.DelReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.DelRet;
import tencent.im.selfgif.CameraEmotionRoaming_sso.DelRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.GetListReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.GetListRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.ImgInfo;
import tencent.im.selfgif.CameraEmotionRoaming_sso.ReqBody;
import tencent.im.selfgif.CameraEmotionRoaming_sso.RspBody;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadState;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateRet;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UploadImgInfo;

public class accj
  extends acdd<CameraEmotionData>
{
  private ConcurrentHashMap<Integer, CameraEmotionData> dM = new ConcurrentHashMap();
  
  public accj(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(List<CameraEmotionRoaming_sso.ImgInfo> paramList, List<accj.a> paramList1, List<String> paramList2)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList2 == null))
    {
      QLog.e("CameraEmoRoamingHandler", 1, "readSSoImgInfoList param error");
      return;
    }
    Iterator localIterator = paramList.iterator();
    label29:
    String str4;
    String str1;
    String str2;
    String str3;
    String str5;
    accj.a locala;
    while (localIterator.hasNext())
    {
      paramList = (CameraEmotionRoaming_sso.ImgInfo)localIterator.next();
      str4 = paramList.bytes_resource_id.get().toStringUtf8();
      str1 = ((ByteStringMicro)paramList.bytes_text.get(0)).toStringUtf8();
      str2 = paramList.url.get().toStringUtf8();
      str3 = paramList.bytes_md5.get().toStringUtf8();
      str5 = paramList.bytes_widget_id.get().toStringUtf8();
      if (!aqmr.isEmpty(str4))
      {
        locala = new accj.a();
        locala.bnT = str4;
        if (str1 != null) {
          break label254;
        }
        paramList = "";
        label146:
        locala.content = paramList;
        if (str2 != null) {
          break label260;
        }
        paramList = "";
        label160:
        locala.url = paramList;
        if (str3 != null) {
          break label266;
        }
      }
    }
    label260:
    label266:
    for (paramList = "";; paramList = str3)
    {
      locala.md5 = paramList;
      locala.templateId = str5;
      QLog.e("CameraEmoRoamingHandler", 1, "readSSoImgInfoList get CameraEmoImg content = " + str1 + "| url = " + str2 + ", templateId:" + str5);
      paramList2.add(str4);
      paramList1.add(locala);
      break label29;
      break;
      label254:
      paramList = str1;
      break label146;
      paramList = str2;
      break label160;
    }
  }
  
  private void bA(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramToServiceMsg.extraData.getInt("camera_emo_upload_id");
    QLog.d("CameraEmoRoamingHandler", 1, new Object[] { "timtest handlePrepareUploadInfo start, ", Integer.valueOf(j) });
    CameraEmotionData localCameraEmotionData = (CameraEmotionData)this.dM.get(Integer.valueOf(j));
    if ((paramObject == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      paramObject = new StringBuilder().append("fail to  handlePrepareUploadInfo error code is ");
      if (paramFromServiceMsg == null) {}
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode()))
      {
        QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg);
        a(1, false, Integer.valueOf(12), localCameraEmotionData);
        this.dM.remove(Integer.valueOf(j));
        return;
      }
    }
    paramToServiceMsg = new CameraEmotionRoaming_sso.RspBody();
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramToServiceMsg.bytes_fail_msg.get().toStringUtf8();
        if (!paramToServiceMsg.upLoad_rsp.has()) {
          break label597;
        }
        paramToServiceMsg = (CameraEmotionRoaming_sso.UpLoadRsp)paramToServiceMsg.upLoad_rsp.get();
        i = paramToServiceMsg.int32_is_upload.get();
        if (i == 0)
        {
          localCameraEmotionData.resid = paramToServiceMsg.bytes_resource_id.get().toStringUtf8();
          QLog.d("CameraEmoRoamingHandler", 1, "timtest handlePrepareUploadInfo success md5 = " + localCameraEmotionData.md5 + "| resid=" + localCameraEmotionData.resid + " | msg = " + paramFromServiceMsg + ", templateId:" + localCameraEmotionData.templateId);
          ((afgw)this.app.getManager(334)).a(localCameraEmotionData);
          paramObject = new HashMap();
          if (i != 0) {
            break label655;
          }
          paramToServiceMsg = "1";
          paramObject.put("sucFlag", paramToServiceMsg);
          paramObject.put("retCode", String.valueOf(i));
          if (paramFromServiceMsg != null) {
            break label662;
          }
          paramToServiceMsg = "";
          paramObject.put("errMsg", paramToServiceMsg);
          paramToServiceMsg = anpc.a(BaseApplication.getContext());
          if (i != 0) {
            break label667;
          }
          bool = true;
          paramToServiceMsg.collectPerformance(null, "CamEmoPrepareUpload", bool, 0L, 0L, paramObject, null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("CameraEmoRoamingHandler", 1, "func handlePrepareUploadInfo ends, errInfo:" + paramToServiceMsg.getMessage());
        a(1, false, Integer.valueOf(100), localCameraEmotionData);
        this.dM.remove(Integer.valueOf(j));
        return;
      }
      catch (OutOfMemoryError paramToServiceMsg)
      {
        QLog.e("CameraEmoRoamingHandler", 1, "handlePrepareUploadInfo oom");
        a(1, false, Integer.valueOf(100), localCameraEmotionData);
        this.dM.remove(Integer.valueOf(j));
        return;
      }
      if (i == 1)
      {
        a(1, false, Integer.valueOf(2), localCameraEmotionData);
        this.dM.remove(Integer.valueOf(j));
        QLog.e("CameraEmoRoamingHandler", 1, "func handlePrepareUploadInfo fail, nCanupload:" + i);
      }
      else
      {
        a(1, false, Integer.valueOf(13), localCameraEmotionData);
        this.dM.remove(Integer.valueOf(j));
        QLog.e("CameraEmoRoamingHandler", 1, "func handlePrepareUploadInfo fail, nCanupload:" + i);
        continue;
        label597:
        QLog.d("CameraEmoRoamingHandler", 1, "timtest handlePrepareUploadInfo end rspBody.upLoad_rsp no value msg = " + paramFromServiceMsg);
        a(1, false, Integer.valueOf(13), localCameraEmotionData);
        this.dM.remove(Integer.valueOf(j));
        i = -1;
        continue;
        label655:
        paramToServiceMsg = "0";
        continue;
        label662:
        paramToServiceMsg = paramFromServiceMsg;
        continue;
        label667:
        bool = false;
      }
    }
  }
  
  private void bB(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleNotifyServerUploadStatus start");
    int i = paramToServiceMsg.extraData.getInt("camera_emo_upload_id");
    CameraEmotionData localCameraEmotionData = (CameraEmotionData)this.dM.get(Integer.valueOf(i));
    if ((paramObject == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      paramObject = new StringBuilder().append("fail to  handlePrepareUploadInfo error code is ");
      if (paramFromServiceMsg == null) {}
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode()))
      {
        QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg);
        a(1, false, Integer.valueOf(12), localCameraEmotionData);
        this.dM.remove(Integer.valueOf(i));
        return;
      }
    }
    paramToServiceMsg = new CameraEmotionRoaming_sso.RspBody();
    for (;;)
    {
      int j;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (CameraEmotionRoaming_sso.UpLoadStateRet)((CameraEmotionRoaming_sso.UpLoadStateRsp)paramToServiceMsg.upLoad_state_rsp.get()).upload_state_ret.get(0);
        j = paramToServiceMsg.int32_upload_state_ret.get();
        if (j == 0)
        {
          localCameraEmotionData.url = paramToServiceMsg.img_info.url.get().toStringUtf8();
          a(1, true, Integer.valueOf(0), localCameraEmotionData);
          this.dM.remove(Integer.valueOf(i));
          QLog.e("CameraEmoRoamingHandler", 1, "func handleNotifyServerUploadStatus suc");
          paramFromServiceMsg = new HashMap();
          if (j != 0) {
            break label447;
          }
          paramToServiceMsg = "1";
          paramFromServiceMsg.put("sucFlag", paramToServiceMsg);
          paramFromServiceMsg.put("retCode", String.valueOf(j));
          paramToServiceMsg = anpc.a(BaseApplication.getContext());
          if (j != 0) {
            break label454;
          }
          paramToServiceMsg.collectPerformance(null, "CamEmoUpdateStat", bool, 0L, 0L, paramFromServiceMsg, null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("CameraEmoRoamingHandler", 1, "func handleNotifyServerUploadStatus ends, errInfo:" + paramToServiceMsg.getMessage());
        a(1, false, Integer.valueOf(100), localCameraEmotionData);
        this.dM.remove(Integer.valueOf(i));
        return;
      }
      catch (OutOfMemoryError paramToServiceMsg)
      {
        QLog.e("CameraEmoRoamingHandler", 1, "handleNotifyServerUploadStatus oom");
        a(1, false, Integer.valueOf(100), localCameraEmotionData);
        this.dM.remove(Integer.valueOf(i));
        return;
      }
      a(1, false, Integer.valueOf(13), localCameraEmotionData);
      this.dM.remove(Integer.valueOf(i));
      QLog.e("CameraEmoRoamingHandler", 1, new Object[] { "func handleNotifyServerUploadStatus fail, result:", Integer.valueOf(j) });
      continue;
      label447:
      paramToServiceMsg = "0";
      continue;
      label454:
      bool = false;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject, CameraEmotionData paramCameraEmotionData)
  {
    notifyUI(paramInt, paramBoolean, new Object[] { paramObject, paramCameraEmotionData }, false);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramCameraEmotionData == null)
    {
      QLog.d("CameraEmoRoamingHandler", 1, "timtest prepareUploadEmoReq start, data is null");
      a(1, false, Integer.valueOf(10), paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, new Object[] { "timtest prepareUploadEmoReq start, md5:", paramCameraEmotionData.md5, ", size:", Long.valueOf(paramLong), ", emoId:", Integer.valueOf(paramCameraEmotionData.emoId) });
    this.dM.put(Integer.valueOf(paramCameraEmotionData.emoId), paramCameraEmotionData);
    Object localObject1 = new CameraEmotionRoaming_sso.UpLoadReq();
    Object localObject2 = new CameraEmotionRoaming_sso.UploadImgInfo();
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).bytes_img_md5.set(ByteStringMicro.copyFrom(paramCameraEmotionData.md5.getBytes()));
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).uint32_img_height.set(paramInt2);
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).uint32_img_width.set(paramInt1);
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).uint64_img_size.set(paramLong);
    ((CameraEmotionRoaming_sso.UpLoadReq)localObject1).img_info.set((MessageMicro)localObject2);
    localObject2 = new CameraEmotionRoaming_sso.ReqBody();
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).uint32_cmd_type.set(1);
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).uint32_src_term.set(3);
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).bytes_version.set(ByteStringMicro.copyFrom("3.4.4".getBytes()));
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).upLoad_req.set((MessageMicro)localObject1);
    localObject1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
    ((ToServiceMsg)localObject1).extraData.putInt("cmd_camera_emo_subcmd", 1);
    ((ToServiceMsg)localObject1).extraData.putInt("camera_emo_upload_id", paramCameraEmotionData.emoId);
    ((ToServiceMsg)localObject1).putWupBuffer(((CameraEmotionRoaming_sso.ReqBody)localObject2).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, boolean paramBoolean)
  {
    if (paramCameraEmotionData == null)
    {
      QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start, data is null");
      a(1, false, Integer.valueOf(10), paramCameraEmotionData);
      return;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start, net not support");
      a(1, false, Integer.valueOf(12), paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start");
    Object localObject2 = new CameraEmotionRoaming_sso.UpLoadStateReq();
    CameraEmotionRoaming_sso.UpLoadState localUpLoadState = new CameraEmotionRoaming_sso.UpLoadState();
    localUpLoadState.bytes_resource_id.set(ByteStringMicro.copyFrom(paramCameraEmotionData.resid.getBytes()));
    Object localObject3 = localUpLoadState.bytes_text;
    int i;
    if (paramCameraEmotionData.strContext == null)
    {
      localObject1 = "";
      ((PBRepeatField)localObject3).add(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
      localObject1 = localUpLoadState.int32_upload_state;
      if (!paramBoolean) {
        break label339;
      }
      i = 0;
      label146:
      ((PBInt32Field)localObject1).set(i);
      localObject3 = localUpLoadState.bytes_widget_id;
      if (paramCameraEmotionData.templateId != null) {
        break label344;
      }
    }
    label339:
    label344:
    for (Object localObject1 = "";; localObject1 = paramCameraEmotionData.templateId)
    {
      ((PBBytesField)localObject3).set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
      ((CameraEmotionRoaming_sso.UpLoadStateReq)localObject2).upload_state.add(localUpLoadState);
      localObject1 = new CameraEmotionRoaming_sso.ReqBody();
      ((CameraEmotionRoaming_sso.ReqBody)localObject1).uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
      ((CameraEmotionRoaming_sso.ReqBody)localObject1).uint32_cmd_type.set(2);
      ((CameraEmotionRoaming_sso.ReqBody)localObject1).uint32_src_term.set(3);
      ((CameraEmotionRoaming_sso.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom("3.4.4".getBytes()));
      ((CameraEmotionRoaming_sso.ReqBody)localObject1).upLoad_state_req.set((MessageMicro)localObject2);
      localObject2 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
      ((ToServiceMsg)localObject2).extraData.putInt("cmd_camera_emo_subcmd", 2);
      ((ToServiceMsg)localObject2).extraData.putInt("camera_emo_upload_id", paramCameraEmotionData.emoId);
      ((ToServiceMsg)localObject2).putWupBuffer(((CameraEmotionRoaming_sso.ReqBody)localObject1).toByteArray());
      super.sendPbReq((ToServiceMsg)localObject2);
      return;
      localObject1 = paramCameraEmotionData.strContext;
      break;
      i = 1;
      break label146;
    }
  }
  
  public void ai(List<String> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, "timtest delUserEmoRoamingReq start size = " + paramList.size());
    Object localObject = new CameraEmotionRoaming_sso.DelReq();
    int i = 0;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      if (str == null) {}
      for (;;)
      {
        i += 1;
        break;
        ((CameraEmotionRoaming_sso.DelReq)localObject).bytes_resource_id.get().add(ByteStringMicro.copyFrom(str.getBytes()));
      }
    }
    paramList = new CameraEmotionRoaming_sso.ReqBody();
    paramList.uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    paramList.uint32_cmd_type.set(4);
    paramList.uint32_src_term.set(3);
    paramList.bytes_version.set(ByteStringMicro.copyFrom("3.4.4".getBytes()));
    paramList.del_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
    ((ToServiceMsg)localObject).extraData.putInt("cmd_camera_emo_subcmd", 4);
    ((ToServiceMsg)localObject).extraData.putBoolean("cmd_param_need_sync", paramBoolean);
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void cHj()
  {
    QLog.d("CameraEmoRoamingHandler", 1, "timtest queryUserEmoRoamingReq  start");
    String str = ((afgw)this.app.getManager(334)).us();
    Object localObject = new CameraEmotionRoaming_sso.GetListReq();
    ((CameraEmotionRoaming_sso.GetListReq)localObject).client_timestamp_version.set(ByteStringMicro.copyFrom(str.getBytes()));
    CameraEmotionRoaming_sso.ReqBody localReqBody = new CameraEmotionRoaming_sso.ReqBody();
    localReqBody.uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localReqBody.uint32_cmd_type.set(3);
    localReqBody.uint32_src_term.set(3);
    localReqBody.bytes_version.set(ByteStringMicro.copyFrom("3.4.4".getBytes()));
    localReqBody.get_list_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
    ((ToServiceMsg)localObject).extraData.putInt("cmd_camera_emo_subcmd", 3);
    ((ToServiceMsg)localObject).extraData.putString("cmd_param_data_version", str);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  protected void e(Object paramObject, boolean paramBoolean)
  {
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleDelMessage start ");
    Object localObject1 = new CameraEmotionRoaming_sso.RspBody();
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    try
    {
      ((CameraEmotionRoaming_sso.RspBody)localObject1).mergeFrom((byte[])paramObject);
      ((CameraEmotionRoaming_sso.RspBody)localObject1).bytes_fail_msg.get().toStringUtf8();
      if (((CameraEmotionRoaming_sso.RspBody)localObject1).del_rsp.has())
      {
        Object localObject2 = (CameraEmotionRoaming_sso.DelRsp)((CameraEmotionRoaming_sso.RspBody)localObject1).del_rsp.get();
        paramObject = ((CameraEmotionRoaming_sso.DelRsp)localObject2).client_timestamp_version.get().toStringUtf8();
        localObject1 = new ArrayList();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        if (((CameraEmotionRoaming_sso.DelRsp)localObject2).rpt_img_info.has()) {
          b(((CameraEmotionRoaming_sso.DelRsp)localObject2).rpt_img_info.get(), (List)localObject1, localArrayList2);
        }
        if (!((CameraEmotionRoaming_sso.DelRsp)localObject2).del_ret.has()) {
          break label249;
        }
        localObject2 = ((CameraEmotionRoaming_sso.DelRsp)localObject2).del_ret.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          CameraEmotionRoaming_sso.DelRet localDelRet = (CameraEmotionRoaming_sso.DelRet)((Iterator)localObject2).next();
          if (localDelRet.int32_del_ret.get() == 0) {
            localArrayList1.add(localDelRet.bytes_resource_id.get().toStringUtf8());
          }
        }
      }
      QLog.d("CameraEmoRoamingHandler", 1, "timtest handleDelMessage delResIDList.size = " + localArrayList1.size() + "| cameraEmoImgs.size = " + ((List)localObject1).size());
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "func handleDelMessage ends, errInfo:" + paramObject.getMessage());
      return;
    }
    catch (OutOfMemoryError paramObject)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "handleDelMessage oom");
      return;
    }
    label249:
    ThreadManagerV2.excute(new CameraEmoRoamingHandler.1(this, paramObject, (List)localObject1, localArrayList2, localArrayList1), 32, null, true);
  }
  
  public final void f(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    notifyUI(paramInt1, paramBoolean, Integer.valueOf(paramInt2), false);
  }
  
  protected void g(Object paramObject, String paramString)
  {
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleUserInfoGet start");
    Object localObject = new CameraEmotionRoaming_sso.RspBody();
    try
    {
      ((CameraEmotionRoaming_sso.RspBody)localObject).mergeFrom((byte[])paramObject);
      ((CameraEmotionRoaming_sso.RspBody)localObject).bytes_fail_msg.get().toStringUtf8();
      if (((CameraEmotionRoaming_sso.RspBody)localObject).get_list_rsp.has())
      {
        paramObject = (CameraEmotionRoaming_sso.GetListRsp)((CameraEmotionRoaming_sso.RspBody)localObject).get_list_rsp.get();
        localObject = paramObject.server_timestamp_version.get().toStringUtf8();
        if (paramString.equals(localObject))
        {
          QLog.d("CameraEmoRoamingHandler", 1, "timtest handleUserInfoGet same version = " + (String)localObject);
          f(2, true, 0);
        }
      }
      else
      {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "func handleUserInfoGet ends, errInfo:" + paramObject.getMessage());
      return;
    }
    catch (OutOfMemoryError paramObject)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "handleUserInfoGet oom");
      return;
    }
    paramString = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (paramObject.rpt_img_info.has()) {
      b(paramObject.rpt_img_info.get(), paramString, localArrayList);
    }
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleUserInfoGet cameraEmoImgs.size = " + paramString.size());
    ThreadManagerV2.excute(new CameraEmoRoamingHandler.2(this, (String)localObject, paramString, localArrayList), 32, null, true);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acck.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "timtest onReceive error : ToServiceMsg is null");
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, "timtest onReceive start");
    switch (paramToServiceMsg.extraData.getInt("cmd_camera_emo_subcmd"))
    {
    default: 
      return;
    case 1: 
      bA(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 2: 
      bB(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 3: 
      if ((paramObject == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
      {
        paramObject = new StringBuilder().append("fail to  handleUserInfoGet error code is ");
        if (paramFromServiceMsg == null) {}
        for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode()))
        {
          QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg);
          if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isSuccess())) {
            break;
          }
          ajdg.fe(String.valueOf(paramFromServiceMsg.getResultCode()), 2);
          return;
        }
        ajdg.fd("3002", 2);
        return;
      }
      g(paramObject, paramToServiceMsg.extraData.getString("cmd_param_data_version", ""));
      return;
    }
    if ((paramObject == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      paramObject = new StringBuilder().append("fail to  handleDelMessage error code is ");
      if (paramFromServiceMsg == null) {}
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode()))
      {
        QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg);
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isSuccess())) {
          break;
        }
        ajdg.fd(String.valueOf(paramFromServiceMsg.getResultCode()), 2);
        return;
      }
      ajdg.fd("3003", 2);
      return;
    }
    e(paramObject, paramToServiceMsg.extraData.getBoolean("cmd_param_need_sync"));
  }
  
  public static class a
  {
    public String bnT;
    public String content;
    public String md5;
    public String templateId;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accj
 * JD-Core Version:    0.7.0.1
 */