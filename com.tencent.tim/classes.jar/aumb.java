import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamworkforgroup.GPadInfo;
import com.tencent.tim.teamworkforgroup.GroupPadTemplateInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetAddTimeReq;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetAddTimeRsp;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetListReq;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetListRsp;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.ReqBody;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.RspBody;
import tencent.im.oidb.cmd0xae9.group_online_docs.DocInfo;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;
import tencent.im.oidb.cmd0xae9.online_docs.DocMetaData;
import tencent.im.oidb.cmd0xaea.Oidb_0xaea.DeleteDocReq;
import tencent.im.oidb.cmd0xaea.Oidb_0xaea.ReqBody;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee.ListRsp;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee.ReqBody;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee.RspBody;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee.Template;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef.ReqBody;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef.SearchDocReq;
import tencent.im.oidb.cmd0xaf3.Oidb_0xaf3.ReqBody;
import tencent.im.oidb.cmd0xaf3.Oidb_0xaf3.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aumb
  extends accg
{
  public static String TAG = "GroupTeamWorkHandler";
  public static String ckf = "OidbSvc.0xae9_1";
  public static String ckg = "OidbSvc.0xae9_2";
  public static String ckh = "OidbSvc.0xaef_1";
  public static String cki = "OidbSvc.0xaea_1";
  public static String ckj = "OidbSvc.0xaee";
  public static String ckk = "OidbSvc.0xaf3_1";
  public static String ckl = "OidbSvc.0xaf3_2";
  public static String ckm = "key_group_code";
  public static String ckn = "key_req_start";
  public static String cko = "key_req_limit";
  public static String ckp = "key_type_operation";
  public static String ckq = "key_type_key_word";
  public static String ckr = "key_type_pad_url";
  
  public static void a(GPadInfo paramGPadInfo, group_online_docs.DocInfo paramDocInfo, long paramLong)
  {
    boolean bool = true;
    if ((paramGPadInfo != null) && (paramDocInfo != null)) {}
    for (;;)
    {
      try
      {
        online_docs.DocMetaData localDocMetaData;
        if ((paramDocInfo.doc_meta_data != null) && (paramDocInfo.doc_meta_data.doc_id != null))
        {
          localDocMetaData = paramDocInfo.doc_meta_data;
          localObject = localDocMetaData.doc_id;
          paramGPadInfo.domainId = ((int)((online_docs.DocId)localObject).domain_id.get());
          if (((online_docs.DocId)localObject).pad_id.has())
          {
            localObject = ((online_docs.DocId)localObject).pad_id.get().toStringUtf8();
            paramGPadInfo.padId = ((String)localObject);
            if (!localDocMetaData.title.has()) {
              break label405;
            }
            localObject = localDocMetaData.title.get().toStringUtf8();
            paramGPadInfo.title = ((String)localObject);
            paramGPadInfo.creatorUin = localDocMetaData.creator_uin.get();
            paramGPadInfo.createTime = localDocMetaData.create_ts.get();
            paramGPadInfo.lastEditorUin = localDocMetaData.last_modify_uin.get();
            paramGPadInfo.lastEditTime = (1000L * localDocMetaData.last_modify_ts.get());
            paramGPadInfo.ownerUin = localDocMetaData.owner_uin.get();
            if (localDocMetaData.doc_type.get() != 0) {
              continue;
            }
            paramGPadInfo.type = 1;
            paramGPadInfo.creatorUid = localDocMetaData.creator_uid.get();
            paramGPadInfo.lastModifyUid = localDocMetaData.last_modify_uid.get();
            paramGPadInfo.owneruid = localDocMetaData.owner_uid.get();
            if (!paramDocInfo.creator_nick.has()) {
              break label392;
            }
            localObject = paramDocInfo.creator_nick.get();
            paramGPadInfo.creatorCard = ((String)localObject);
            if (!paramDocInfo.owner_nick.has()) {
              break label412;
            }
            localObject = paramDocInfo.owner_nick.get();
            paramGPadInfo.ownerCard = ((String)localObject);
            if (!paramDocInfo.last_modify_nick.has()) {
              break label419;
            }
            localObject = paramDocInfo.last_modify_nick.get();
            paramGPadInfo.lastModifyCard = ((String)localObject);
            if (paramDocInfo.top.get() != 1) {
              break label426;
            }
            paramGPadInfo.pinedFlag = bool;
            if (!paramDocInfo.doc_url.has()) {
              break label399;
            }
            paramDocInfo = paramDocInfo.doc_url.get();
            paramGPadInfo.pad_url = paramDocInfo;
            paramGPadInfo.groupCode = paramLong;
          }
        }
        else
        {
          return;
        }
        localObject = "";
        continue;
        if (localDocMetaData.doc_type.get() != 1) {
          continue;
        }
        paramGPadInfo.type = 2;
        continue;
        localObject = "";
      }
      finally {}
      label392:
      continue;
      label399:
      paramDocInfo = "";
      continue;
      label405:
      Object localObject = "";
      continue;
      label412:
      localObject = "";
      continue;
      label419:
      localObject = "";
      continue;
      label426:
      bool = false;
    }
  }
  
  public static void a(GroupPadTemplateInfo paramGroupPadTemplateInfo, Oidb_0xaee.Template paramTemplate)
  {
    if ((paramGroupPadTemplateInfo != null) && (paramTemplate != null)) {}
    try
    {
      paramGroupPadTemplateInfo.templateID = paramTemplate.template_id.get();
      paramGroupPadTemplateInfo.templateName = paramTemplate.template_name.get();
      paramGroupPadTemplateInfo.templateType = paramTemplate.group_type.get();
      paramGroupPadTemplateInfo.mobThumbUrl = paramTemplate.mob_thumb_url.get();
      paramGroupPadTemplateInfo.mobPrevUrl = paramTemplate.mob_prev_url.get();
      paramGroupPadTemplateInfo.webThumUrl = paramTemplate.web_thumb_url.get();
      paramGroupPadTemplateInfo.webPrevUrl = paramTemplate.web_prev_url.get();
      paramGroupPadTemplateInfo.templateUrl = paramTemplate.template_url.get();
      paramGroupPadTemplateInfo.docOrSheetType = paramTemplate.doc_type.get();
      paramGroupPadTemplateInfo.groupCode = paramTemplate.group_code.get();
      return;
    }
    finally
    {
      paramGroupPadTemplateInfo = finally;
      throw paramGroupPadTemplateInfo;
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
      Object localObject2 = new Oidb_0xaef.SearchDocReq();
      ((Oidb_0xaef.SearchDocReq)localObject2).group_code.set(paramLong);
      ((Oidb_0xaef.SearchDocReq)localObject2).key_word.set(ByteStringMicro.copyFromUtf8(paramString));
      ((Oidb_0xaef.SearchDocReq)localObject2).start.set(paramInt1);
      ((Oidb_0xaef.SearchDocReq)localObject2).limit.set(paramInt2);
      Object localObject1 = new Oidb_0xaef.ReqBody();
      ((Oidb_0xaef.ReqBody)localObject1).search_doc_req.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2799);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0xaef.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg(ckh);
      ((ToServiceMsg)localObject1).addAttribute(ckm, Long.valueOf(paramLong));
      ((ToServiceMsg)localObject1).addAttribute(ckn, Integer.valueOf(paramInt1));
      ((ToServiceMsg)localObject1).addAttribute(cko, Integer.valueOf(paramInt2));
      ((ToServiceMsg)localObject1).addAttribute(ckq, paramString);
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      super.sendPbReq((ToServiceMsg)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "reqSearchGroupTeamWorkList group code = " + paramLong + " start = " + paramInt1 + " count = " + paramInt2);
  }
  
  public void a(long paramLong, online_docs.DocId paramDocId, String paramString)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
      Object localObject = new Oidb_0xaf3.ReqBody();
      ((Oidb_0xaf3.ReqBody)localObject).group_code.set(paramLong);
      ((Oidb_0xaf3.ReqBody)localObject).doc_id.set(paramDocId);
      ((Oidb_0xaf3.ReqBody)localObject).doc_title.set(ByteStringMicro.copyFromUtf8(paramString));
      paramDocId = ((TicketManager)this.app.getManager(2)).getPskey(this.app.getCurrentAccountUin(), "docs.qq.com");
      ((Oidb_0xaf3.ReqBody)localObject).pskey.set(ByteStringMicro.copyFromUtf8(paramDocId));
      paramDocId = new oidb_sso.OIDBSSOPkg();
      paramDocId.uint32_command.set(2803);
      paramDocId.uint32_result.set(0);
      paramDocId.uint32_service_type.set(1);
      paramDocId.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0xaf3.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg(ckk);
      ((ToServiceMsg)localObject).addAttribute(ckm, Long.valueOf(paramLong));
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).putWupBuffer(paramDocId.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "reqAddGroupTeamWorkLink group code = " + paramLong + " title " + paramString);
  }
  
  public void a(long paramLong, online_docs.DocId paramDocId, String paramString, boolean paramBoolean)
  {
    if (paramLong == 0L) {
      return;
    }
    Object localObject = new Oidb_0xaea.DeleteDocReq();
    ((Oidb_0xaea.DeleteDocReq)localObject).group_code.set(paramLong);
    ((Oidb_0xaea.DeleteDocReq)localObject).doc_id.set(paramDocId);
    paramDocId = ((Oidb_0xaea.DeleteDocReq)localObject).copy;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramDocId.set(i);
      paramDocId = new Oidb_0xaea.ReqBody();
      paramDocId.delete_doc_req.set((MessageMicro)localObject);
      localObject = ((TicketManager)this.app.getManager(2)).getPskey(this.app.getCurrentAccountUin(), "docs.qq.com");
      paramDocId.pskey.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2794);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramDocId.toByteArray()));
      paramDocId = createToServiceMsg(cki);
      paramDocId.addAttribute(ckm, Long.valueOf(paramLong));
      paramDocId.addAttribute(ckr, paramString);
      paramDocId.setTimeout(30000L);
      paramDocId.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      super.sendPbReq(paramDocId);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(TAG, 2, "reqDeleteGroupTeamWorkFile group code = " + paramLong + " padUrl " + paramString + " isCopy: = " + paramBoolean);
      return;
    }
  }
  
  public void b(long paramLong, online_docs.DocId paramDocId, String paramString)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
      Object localObject = new Oidb_0xaf3.ReqBody();
      ((Oidb_0xaf3.ReqBody)localObject).group_code.set(paramLong);
      ((Oidb_0xaf3.ReqBody)localObject).doc_id.set(paramDocId);
      ((Oidb_0xaf3.ReqBody)localObject).doc_title.set(ByteStringMicro.copyFromUtf8(paramString));
      paramDocId = ((TicketManager)this.app.getManager(2)).getPskey(this.app.getCurrentAccountUin(), "docs.qq.com");
      ((Oidb_0xaf3.ReqBody)localObject).pskey.set(ByteStringMicro.copyFromUtf8(paramDocId));
      paramDocId = new oidb_sso.OIDBSSOPkg();
      paramDocId.uint32_command.set(2803);
      paramDocId.uint32_result.set(0);
      paramDocId.uint32_service_type.set(2);
      paramDocId.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0xaf3.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg(ckl);
      ((ToServiceMsg)localObject).addAttribute(ckm, Long.valueOf(paramLong));
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).putWupBuffer(paramDocId.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "reqAddGroupTeamWorkCopy group code = " + paramLong + " title " + paramString);
  }
  
  public void h(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
      Object localObject2 = new Oidb_0xae9.GetListReq();
      ((Oidb_0xae9.GetListReq)localObject2).group_code.set(paramLong);
      ((Oidb_0xae9.GetListReq)localObject2).start.set(paramInt1);
      ((Oidb_0xae9.GetListReq)localObject2).limit.set(paramInt2);
      Object localObject1 = new Oidb_0xae9.ReqBody();
      ((Oidb_0xae9.ReqBody)localObject1).get_list_req.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2793);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0xae9.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg(ckf);
      ((ToServiceMsg)localObject1).addAttribute(ckm, Long.valueOf(paramLong));
      ((ToServiceMsg)localObject1).addAttribute(ckn, Integer.valueOf(paramInt1));
      ((ToServiceMsg)localObject1).addAttribute(cko, Integer.valueOf(paramInt2));
      ((ToServiceMsg)localObject1).addAttribute(ckp, Integer.valueOf(paramInt3));
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      super.sendPbReq((ToServiceMsg)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "getGroupTeamWorkList group code = " + paramLong + " start = " + paramInt1 + " count = " + paramInt2);
  }
  
  public void lD(long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
      Object localObject = new Oidb_0xaee.ReqBody();
      ((Oidb_0xaee.ReqBody)localObject).group_code.set(paramLong);
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(2798);
      localOIDBSSOPkg.uint32_result.set(0);
      localOIDBSSOPkg.uint32_service_type.set(1);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0xaee.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg(ckj);
      ((ToServiceMsg)localObject).addAttribute(ckm, Long.valueOf(paramLong));
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "getGroupPadTemplateList! groupCode = " + paramLong);
  }
  
  public void lE(long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
      Object localObject2 = new Oidb_0xae9.GetAddTimeReq();
      ((Oidb_0xae9.GetAddTimeReq)localObject2).group_code.set(paramLong);
      Object localObject1 = new Oidb_0xae9.ReqBody();
      ((Oidb_0xae9.ReqBody)localObject1).get_add_time_req.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2793);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(2);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0xae9.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg(ckg);
      ((ToServiceMsg)localObject1).addAttribute(ckm, Long.valueOf(paramLong));
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      super.sendPbReq((ToServiceMsg)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "getAddGroupTeamWorkTime group code = " + paramLong);
  }
  
  public void la(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    i = -1;
    paramToServiceMsg = "";
    ArrayList localArrayList = new ArrayList();
    Object localObject = new oidb_sso.OIDBSSOPkg();
    aumx localaumx = (aumx)this.app.getManager(304);
    paramFromServiceMsg = paramToServiceMsg;
    j = i;
    for (;;)
    {
      try
      {
        localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        paramObject = paramToServiceMsg;
        k = i;
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        if (!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) {
          continue;
        }
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        if (((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.has())
        {
          paramFromServiceMsg = paramToServiceMsg;
          j = i;
          paramToServiceMsg = ((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get();
          paramObject = paramToServiceMsg;
          k = i;
          if (i != 0) {
            continue;
          }
          paramFromServiceMsg = paramToServiceMsg;
          j = i;
          paramObject = new Oidb_0xaee.RspBody();
          paramFromServiceMsg = paramToServiceMsg;
          j = i;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        int k;
        i = j;
        paramToServiceMsg = paramFromServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, " handleGetGroupPadTemplateList parse oidb_sso.OIDBSSOPkg failed.");
        paramObject.printStackTrace();
        continue;
      }
      try
      {
        paramObject.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        paramObject = paramObject.list_rsp.rpt_template.get();
        if (paramObject != null)
        {
          paramFromServiceMsg = paramToServiceMsg;
          j = i;
          if (paramObject.size() > 0)
          {
            k = 0;
            paramFromServiceMsg = paramToServiceMsg;
            j = i;
            if (k < paramObject.size())
            {
              paramFromServiceMsg = paramToServiceMsg;
              j = i;
              localObject = new GroupPadTemplateInfo();
              paramFromServiceMsg = paramToServiceMsg;
              j = i;
              a((GroupPadTemplateInfo)localObject, (Oidb_0xaee.Template)paramObject.get(k));
              paramFromServiceMsg = paramToServiceMsg;
              j = i;
              localArrayList.add(localObject);
              paramFromServiceMsg = paramToServiceMsg;
              j = i;
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = paramToServiceMsg;
                j = i;
                QLog.i(TAG, 2, " handleGetGroupPadTemplateList localPadInfo: " + localObject.toString());
              }
              k += 1;
              continue;
              paramToServiceMsg = "";
              continue;
            }
            paramFromServiceMsg = paramToServiceMsg;
            j = i;
            localaumx.mA(localArrayList);
          }
        }
        notifyUI(3, bool, new Object[] { Integer.valueOf(i), paramToServiceMsg, localArrayList });
        return;
      }
      catch (Exception paramObject)
      {
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        QLog.e(TAG, 1, " handleGetGroupPadTemplateList exception: " + paramObject.toString());
        k = i;
        paramObject = paramToServiceMsg;
      }
      paramToServiceMsg = paramObject;
      i = k;
    }
  }
  
  public void lb(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    boolean bool7 = paramFromServiceMsg.isSuccess();
    int k = -1;
    String str = "";
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    boolean bool4 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    long l1 = ((Long)paramToServiceMsg.getAttribute(ckm)).longValue();
    paramToServiceMsg = (aumx)this.app.getManager(304);
    boolean bool1 = bool5;
    paramFromServiceMsg = str;
    j = k;
    for (;;)
    {
      try
      {
        localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        paramObject = str;
        i = k;
        bool1 = bool5;
        paramFromServiceMsg = str;
        j = k;
        if (!localOIDBSSOPkg.uint32_result.has()) {
          continue;
        }
        bool1 = bool5;
        paramFromServiceMsg = str;
        j = k;
        k = localOIDBSSOPkg.uint32_result.get();
        bool1 = bool5;
        paramFromServiceMsg = str;
        j = k;
        if (localOIDBSSOPkg.str_error_msg.has())
        {
          bool1 = bool5;
          paramFromServiceMsg = str;
          j = k;
          paramToServiceMsg = localOIDBSSOPkg.str_error_msg.get();
          bool2 = bool6;
          paramObject = paramToServiceMsg;
          i = k;
          if (k != 0) {
            continue;
          }
          bool1 = bool5;
          paramFromServiceMsg = paramToServiceMsg;
          j = k;
          paramObject = new Oidb_0xae9.RspBody();
          bool2 = bool4;
          bool1 = bool5;
          paramFromServiceMsg = paramToServiceMsg;
          j = k;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        boolean bool2;
        long l2;
        paramToServiceMsg = paramFromServiceMsg;
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, " handleGetGroupPadTemplateList parse oidb_sso.OIDBSSOPkg failed.");
        paramObject.printStackTrace();
        continue;
      }
      try
      {
        paramObject.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool4;
        bool1 = bool5;
        paramFromServiceMsg = paramToServiceMsg;
        j = k;
        l2 = ((Oidb_0xae9.GetAddTimeRsp)paramObject.get_add_time_rsp.get()).timestamp.get();
        bool2 = bool4;
        bool1 = bool5;
        paramFromServiceMsg = paramToServiceMsg;
        j = k;
        if (!aumx.c(this.app.getApp(), String.valueOf(l1), "key_groupteamwork_add_timestamp", "").equals(String.valueOf(l2)))
        {
          bool4 = true;
          bool5 = true;
          bool3 = true;
          bool2 = bool4;
          bool1 = bool5;
          paramFromServiceMsg = paramToServiceMsg;
          j = k;
          aumx.o(this.app.getApp(), String.valueOf(l1), "key_groupteamwork_add_timestamp", String.valueOf(l2));
          bool2 = bool4;
          bool1 = bool5;
          paramFromServiceMsg = paramToServiceMsg;
          j = k;
          ((ajdr)this.mApp.getManager(37)).b(this.mApp.getApp(), String.valueOf(l1), "TIM_GROUP_TM_REDDOT", true);
        }
        bool1 = bool3;
        i = k;
        notifyUI(7, bool7, new Object[] { Integer.valueOf(i), paramToServiceMsg, Boolean.valueOf(bool1) });
        return;
      }
      catch (Exception paramObject)
      {
        bool1 = bool2;
        paramFromServiceMsg = paramToServiceMsg;
        j = k;
        QLog.e(TAG, 1, " handleGetGroupPadTemplateList exception: " + paramObject.toString());
        i = k;
        paramObject = paramToServiceMsg;
      }
      paramToServiceMsg = "";
      continue;
      paramToServiceMsg = paramObject;
      bool1 = bool2;
    }
  }
  
  public void lc(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    i1 = ((Integer)paramToServiceMsg.getAttribute(ckp)).intValue();
    ((Integer)paramToServiceMsg.getAttribute(ckn)).intValue();
    long l = ((Long)paramToServiceMsg.getAttribute(ckm)).longValue();
    paramToServiceMsg = "";
    n = 0;
    k = 0;
    ArrayList localArrayList = new ArrayList();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    aumx localaumx = (aumx)this.app.getManager(304);
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          try
          {
            localOIDBSSOPkg.mergeFrom((byte[])paramObject);
            if (!localOIDBSSOPkg.uint32_result.has()) {
              continue;
            }
            i = localOIDBSSOPkg.uint32_result.get();
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            int m;
            int i = 0;
            int j = -1;
            continue;
            i = 0;
            j = -1;
            continue;
            n += 1;
            continue;
            if (i1 == 1) {
              continue;
            }
            if (i1 != 2) {
              continue;
            }
            continue;
            j = i;
            i = k;
            continue;
          }
          try
          {
            if (localOIDBSSOPkg.str_error_msg.has())
            {
              paramFromServiceMsg = localOIDBSSOPkg.str_error_msg.get();
              paramToServiceMsg = paramFromServiceMsg;
              if (i != 0) {
                continue;
              }
              m = n;
            }
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            k = 0;
            j = i;
            i = k;
            continue;
            k = 0;
            j = i;
            i = k;
            continue;
          }
          try
          {
            for (;;)
            {
              paramFromServiceMsg = new Oidb_0xae9.RspBody();
              j = k;
              m = n;
              try
              {
                paramFromServiceMsg.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
                j = k;
                m = n;
                paramObject = (Oidb_0xae9.GetListRsp)paramFromServiceMsg.get_list_rsp.get();
                if (paramObject == null)
                {
                  j = k;
                  m = n;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  j = k;
                  m = n;
                  QLog.i(TAG, 2, " handleGetGroupTeamWorkList getListRsp null: ");
                  return;
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                k = j;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            j = i;
            i = m;
          }
        }
        try
        {
          QLog.e(TAG, 1, " handleGetGroupTeamWorkList exception: " + paramFromServiceMsg.toString());
          j = i;
          i = k;
          notifyUI(1, bool, new Object[] { Integer.valueOf(j), paramToServiceMsg, localArrayList, Integer.valueOf(i), Integer.valueOf(i1) });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(TAG, 2, " handleGetGroupTeamWorkList issuccess = " + bool + " retCode = " + j + " error msg = " + paramToServiceMsg + " next =" + i + " type operation = " + i1);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          j = i;
          i = k;
        }
      }
      paramToServiceMsg = "";
      continue;
      j = k;
      m = n;
      paramFromServiceMsg = paramObject.doc_list.get();
      j = k;
      m = n;
      k = paramObject.next.get();
      if (paramFromServiceMsg == null) {
        continue;
      }
      j = k;
      m = k;
      if (paramFromServiceMsg.size() <= 0) {
        continue;
      }
      n = 0;
      j = k;
      m = k;
      if (n >= paramFromServiceMsg.size()) {
        continue;
      }
      j = k;
      m = k;
      paramObject = new GPadInfo();
      j = k;
      m = k;
      a(paramObject, (group_online_docs.DocInfo)paramFromServiceMsg.get(n), l);
      j = k;
      m = k;
      localArrayList.add(paramObject);
      j = k;
      m = k;
      if (!QLog.isColorLevel()) {
        continue;
      }
      j = k;
      m = k;
      QLog.i(TAG, 2, " handleGetGroupTeamWorkList localPadInfo: " + paramObject.toString());
      continue;
      j = k;
      m = k;
      localaumx.X(2, localArrayList);
      continue;
      if (i1 != 3) {
        continue;
      }
      j = k;
      m = k;
      localaumx.X(1, localArrayList);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, " handleGetGroupTeamWorkList parse oidb_sso.OIDBSSOPkg failed.");
      }
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  /* Error */
  public void ld(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: invokevirtual 552	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   9: istore 9
    //   11: aload_1
    //   12: getstatic 61	aumb:ckn	Ljava/lang/String;
    //   15: invokevirtual 634	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   18: checkcast 384	java/lang/Integer
    //   21: invokevirtual 699	java/lang/Integer:intValue	()I
    //   24: pop
    //   25: aload_1
    //   26: getstatic 57	aumb:ckm	Ljava/lang/String;
    //   29: invokevirtual 634	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 372	java/lang/Long
    //   35: invokevirtual 637	java/lang/Long:longValue	()J
    //   38: lstore 10
    //   40: new 554	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 555	java/util/ArrayList:<init>	()V
    //   47: astore 12
    //   49: new 345	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   52: dup
    //   53: invokespecial 346	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   56: astore_1
    //   57: aload_1
    //   58: aload_3
    //   59: checkcast 559	[B
    //   62: checkcast 559	[B
    //   65: invokevirtual 563	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: checkcast 345	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   71: astore_2
    //   72: aload_2
    //   73: getfield 352	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   76: invokevirtual 564	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   79: ifeq +680 -> 759
    //   82: aload_2
    //   83: getfield 352	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   86: invokevirtual 153	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   89: istore 4
    //   91: aload_2
    //   92: getfield 567	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   95: invokevirtual 207	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   98: ifeq +251 -> 349
    //   101: aload_2
    //   102: getfield 567	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   105: invokevirtual 209	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   108: astore_1
    //   109: iload 4
    //   111: ifne +635 -> 746
    //   114: new 741	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody
    //   117: dup
    //   118: invokespecial 742	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody:<init>	()V
    //   121: astore_3
    //   122: aload_3
    //   123: aload_2
    //   124: getfield 358	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   127: invokevirtual 123	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   130: invokevirtual 571	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   133: invokevirtual 743	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: pop
    //   137: aload_3
    //   138: getfield 747	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody:search_doc_rsp	Ltencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp;
    //   141: invokevirtual 750	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   144: checkcast 749	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp
    //   147: astore_2
    //   148: aload_2
    //   149: ifnonnull +19 -> 168
    //   152: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +13 -> 168
    //   158: getstatic 25	aumb:TAG	Ljava/lang/String;
    //   161: iconst_2
    //   162: ldc_w 752
    //   165: invokestatic 432	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload_2
    //   169: getfield 753	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:next	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   172: invokevirtual 153	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   175: istore 5
    //   177: aload_2
    //   178: getfield 756	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:is_end	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   181: invokevirtual 153	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   184: istore 6
    //   186: iload 6
    //   188: iconst_1
    //   189: if_icmpne +166 -> 355
    //   192: iconst_1
    //   193: istore 8
    //   195: aload_2
    //   196: getfield 757	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:doc_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   199: invokevirtual 587	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull +223 -> 427
    //   207: aload_2
    //   208: invokeinterface 592 1 0
    //   213: ifle +214 -> 427
    //   216: iconst_0
    //   217: istore 6
    //   219: iload 6
    //   221: aload_2
    //   222: invokeinterface 592 1 0
    //   227: if_icmpge +200 -> 427
    //   230: new 106	com/tencent/tim/teamworkforgroup/GPadInfo
    //   233: dup
    //   234: invokespecial 727	com/tencent/tim/teamworkforgroup/GPadInfo:<init>	()V
    //   237: astore_3
    //   238: new 554	java/util/ArrayList
    //   241: dup
    //   242: invokespecial 555	java/util/ArrayList:<init>	()V
    //   245: astore 13
    //   247: aload_2
    //   248: iload 6
    //   250: invokeinterface 596 2 0
    //   255: checkcast 759	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchItem
    //   258: astore 14
    //   260: aload_3
    //   261: aload 14
    //   263: getfield 763	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchItem:doc_info	Ltencent/im/oidb/cmd0xae9/group_online_docs$DocInfo;
    //   266: invokevirtual 764	tencent/im/oidb/cmd0xae9/group_online_docs$DocInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   269: checkcast 82	tencent/im/oidb/cmd0xae9/group_online_docs$DocInfo
    //   272: lload 10
    //   274: invokestatic 729	aumb:a	(Lcom/tencent/tim/teamworkforgroup/GPadInfo;Ltencent/im/oidb/cmd0xae9/group_online_docs$DocInfo;J)V
    //   277: aload 14
    //   279: getfield 768	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchItem:match_word	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   282: invokevirtual 771	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   285: astore 14
    //   287: aload 14
    //   289: ifnull +72 -> 361
    //   292: aload 14
    //   294: invokeinterface 592 1 0
    //   299: ifle +62 -> 361
    //   302: iconst_0
    //   303: istore 7
    //   305: iload 7
    //   307: aload 14
    //   309: invokeinterface 592 1 0
    //   314: if_icmpge +47 -> 361
    //   317: aload 13
    //   319: aload 14
    //   321: iload 7
    //   323: invokeinterface 596 2 0
    //   328: checkcast 125	com/tencent/mobileqq/pb/ByteStringMicro
    //   331: invokevirtual 129	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   334: invokeinterface 602 2 0
    //   339: pop
    //   340: iload 7
    //   342: iconst_1
    //   343: iadd
    //   344: istore 7
    //   346: goto -41 -> 305
    //   349: ldc 242
    //   351: astore_1
    //   352: goto -243 -> 109
    //   355: iconst_0
    //   356: istore 8
    //   358: goto -163 -> 195
    //   361: aload_3
    //   362: getfield 775	com/tencent/tim/teamworkforgroup/GPadInfo:searchKeyWordList	Ljava/util/List;
    //   365: aload 13
    //   367: invokeinterface 779 2 0
    //   372: pop
    //   373: aload 12
    //   375: aload_3
    //   376: invokeinterface 602 2 0
    //   381: pop
    //   382: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +33 -> 418
    //   388: getstatic 25	aumb:TAG	Ljava/lang/String;
    //   391: iconst_2
    //   392: new 408	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 781
    //   402: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_3
    //   406: invokevirtual 732	com/tencent/tim/teamworkforgroup/GPadInfo:toString	()Ljava/lang/String;
    //   409: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 432	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: iload 6
    //   420: iconst_1
    //   421: iadd
    //   422: istore 6
    //   424: goto -205 -> 219
    //   427: iload 5
    //   429: istore 6
    //   431: iload 4
    //   433: istore 5
    //   435: iload 6
    //   437: istore 4
    //   439: aload_0
    //   440: iconst_2
    //   441: iload 9
    //   443: iconst_5
    //   444: anewarray 606	java/lang/Object
    //   447: dup
    //   448: iconst_0
    //   449: iload 5
    //   451: invokestatic 387	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: aastore
    //   455: dup
    //   456: iconst_1
    //   457: aload_1
    //   458: aastore
    //   459: dup
    //   460: iconst_2
    //   461: aload 12
    //   463: aastore
    //   464: dup
    //   465: iconst_3
    //   466: iload 4
    //   468: invokestatic 387	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   471: aastore
    //   472: dup
    //   473: iconst_4
    //   474: iload 8
    //   476: invokestatic 695	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   479: aastore
    //   480: invokevirtual 615	aumb:notifyUI	(IZLjava/lang/Object;)V
    //   483: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq -482 -> 4
    //   489: getstatic 25	aumb:TAG	Ljava/lang/String;
    //   492: iconst_2
    //   493: new 408	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   500: ldc_w 783
    //   503: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: iload 9
    //   508: invokevirtual 499	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   511: ldc_w 714
    //   514: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: iload 5
    //   519: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   522: ldc_w 716
    //   525: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload_1
    //   529: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc_w 785
    //   535: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: iload 4
    //   540: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: ldc_w 787
    //   546: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: iload 8
    //   551: invokevirtual 499	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   554: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 432	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: return
    //   561: astore_2
    //   562: iconst_0
    //   563: istore 8
    //   565: iconst_0
    //   566: istore 5
    //   568: getstatic 25	aumb:TAG	Ljava/lang/String;
    //   571: iconst_1
    //   572: new 408	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 789
    //   582: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_2
    //   586: invokevirtual 618	java/lang/Exception:toString	()Ljava/lang/String;
    //   589: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 621	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: iload 4
    //   600: istore 6
    //   602: iload 5
    //   604: istore 4
    //   606: iload 6
    //   608: istore 5
    //   610: goto -171 -> 439
    //   613: astore_2
    //   614: iconst_0
    //   615: istore 8
    //   617: iconst_0
    //   618: istore 4
    //   620: ldc 242
    //   622: astore_1
    //   623: iconst_m1
    //   624: istore 5
    //   626: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   629: ifeq +13 -> 642
    //   632: getstatic 25	aumb:TAG	Ljava/lang/String;
    //   635: iconst_2
    //   636: ldc_w 791
    //   639: invokestatic 626	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   642: aload_2
    //   643: invokevirtual 629	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   646: goto -207 -> 439
    //   649: astore_2
    //   650: iconst_0
    //   651: istore 8
    //   653: iconst_0
    //   654: istore 6
    //   656: ldc 242
    //   658: astore_1
    //   659: iload 4
    //   661: istore 5
    //   663: iload 6
    //   665: istore 4
    //   667: goto -41 -> 626
    //   670: astore_2
    //   671: iload 4
    //   673: istore 5
    //   675: iconst_0
    //   676: istore 4
    //   678: iconst_0
    //   679: istore 8
    //   681: goto -55 -> 626
    //   684: astore_2
    //   685: iconst_0
    //   686: istore 8
    //   688: iload 4
    //   690: istore 6
    //   692: iload 5
    //   694: istore 4
    //   696: iload 6
    //   698: istore 5
    //   700: goto -74 -> 626
    //   703: astore_2
    //   704: iload 4
    //   706: istore 6
    //   708: iload 5
    //   710: istore 4
    //   712: iload 6
    //   714: istore 5
    //   716: goto -90 -> 626
    //   719: astore_2
    //   720: iload 4
    //   722: istore 6
    //   724: iload 5
    //   726: istore 4
    //   728: iload 6
    //   730: istore 5
    //   732: goto -106 -> 626
    //   735: astore_2
    //   736: iconst_0
    //   737: istore 8
    //   739: goto -171 -> 568
    //   742: astore_2
    //   743: goto -175 -> 568
    //   746: iconst_0
    //   747: istore 8
    //   749: iload 4
    //   751: istore 5
    //   753: iconst_0
    //   754: istore 4
    //   756: goto -317 -> 439
    //   759: iconst_0
    //   760: istore 8
    //   762: iconst_0
    //   763: istore 4
    //   765: ldc 242
    //   767: astore_1
    //   768: iconst_m1
    //   769: istore 5
    //   771: goto -332 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	774	0	this	aumb
    //   0	774	1	paramToServiceMsg	ToServiceMsg
    //   0	774	2	paramFromServiceMsg	FromServiceMsg
    //   0	774	3	paramObject	Object
    //   89	675	4	i	int
    //   175	595	5	j	int
    //   184	545	6	k	int
    //   303	42	7	m	int
    //   193	568	8	bool1	boolean
    //   9	498	9	bool2	boolean
    //   38	235	10	l	long
    //   47	415	12	localArrayList1	ArrayList
    //   245	121	13	localArrayList2	ArrayList
    //   258	62	14	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   122	148	561	java/lang/Exception
    //   152	168	561	java/lang/Exception
    //   168	177	561	java/lang/Exception
    //   57	91	613	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   91	109	649	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   114	122	670	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	148	670	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   152	168	670	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   168	177	670	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   177	186	684	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   195	203	703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   207	216	703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   219	287	703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   292	302	703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   305	340	703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   361	418	703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   568	598	719	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   177	186	735	java/lang/Exception
    //   195	203	742	java/lang/Exception
    //   207	216	742	java/lang/Exception
    //   219	287	742	java/lang/Exception
    //   292	302	742	java/lang/Exception
    //   305	340	742	java/lang/Exception
    //   361	418	742	java/lang/Exception
  }
  
  public void le(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    int k = -1;
    Object localObject = "";
    String str = (String)paramToServiceMsg.getAttribute(ckr);
    ((Long)paramToServiceMsg.getAttribute(ckm)).longValue();
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    paramFromServiceMsg = (FromServiceMsg)localObject;
    j = k;
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = localObject;
        i = k;
        paramFromServiceMsg = (FromServiceMsg)localObject;
        j = k;
        if (paramToServiceMsg.uint32_result.has())
        {
          paramFromServiceMsg = (FromServiceMsg)localObject;
          j = k;
          k = paramToServiceMsg.uint32_result.get();
          paramFromServiceMsg = (FromServiceMsg)localObject;
          j = k;
          if (!paramToServiceMsg.str_error_msg.has()) {
            continue;
          }
          paramFromServiceMsg = (FromServiceMsg)localObject;
          j = k;
          paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
          paramObject = paramToServiceMsg;
          i = k;
          if (k == 0)
          {
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            localObject = ((aumx)this.app.getManager(304)).C();
            paramObject = paramToServiceMsg;
            i = k;
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            if (!TextUtils.isEmpty(str))
            {
              paramObject = paramToServiceMsg;
              i = k;
              paramFromServiceMsg = paramToServiceMsg;
              j = k;
              if (((ConcurrentHashMap)localObject).containsKey(str))
              {
                paramFromServiceMsg = paramToServiceMsg;
                j = k;
                ((ConcurrentHashMap)localObject).remove(ault.nT(str));
                i = k;
                paramObject = paramToServiceMsg;
              }
            }
          }
        }
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, " handleDeleteTeamWorkFile parse oidb_sso.OIDBSSOPkg failed.");
        paramToServiceMsg.printStackTrace();
        continue;
      }
      notifyUI(4, bool, new Object[] { Integer.valueOf(i), paramFromServiceMsg });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(TAG, 2, " handleDeleteTeamWorkFile issuccess = " + bool + " retCode = " + i + " error msg = " + paramFromServiceMsg);
      return;
      paramToServiceMsg = "";
    }
  }
  
  public void ml(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    int k = -1;
    Object localObject = "";
    long l = ((Long)paramToServiceMsg.getAttribute(ckm)).longValue();
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    GPadInfo localGPadInfo = new GPadInfo();
    paramFromServiceMsg = (FromServiceMsg)localObject;
    j = k;
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = localObject;
        i = k;
        paramFromServiceMsg = (FromServiceMsg)localObject;
        j = k;
        if (localOIDBSSOPkg.uint32_result.has())
        {
          paramFromServiceMsg = (FromServiceMsg)localObject;
          j = k;
          k = localOIDBSSOPkg.uint32_result.get();
          paramFromServiceMsg = (FromServiceMsg)localObject;
          j = k;
          if (!localOIDBSSOPkg.str_error_msg.has()) {
            continue;
          }
          paramFromServiceMsg = (FromServiceMsg)localObject;
          j = k;
          paramToServiceMsg = localOIDBSSOPkg.str_error_msg.get();
          paramObject = paramToServiceMsg;
          i = k;
          if (k == 0)
          {
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            paramObject = new Oidb_0xaf3.RspBody();
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            paramObject.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            a(localGPadInfo, (group_online_docs.DocInfo)paramObject.doc_info.get(), l);
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            localGPadInfo.pad_url = ("https:" + localGPadInfo.pad_url);
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            paramObject = (aumx)this.app.getManager(304);
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            localObject = paramObject.gu();
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            ((List)localObject).add(localGPadInfo);
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            paramObject.X(2, (List)localObject);
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            lE(l);
            paramFromServiceMsg = paramToServiceMsg;
            j = k;
            ault.a(this.app, localGPadInfo, String.valueOf(l));
            i = k;
            paramObject = paramToServiceMsg;
          }
        }
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, " handleAddGroupTeamWorkLink parse oidb_sso.OIDBSSOPkg failed.");
        paramToServiceMsg.printStackTrace();
        continue;
      }
      notifyUI(5, bool, new Object[] { Integer.valueOf(i), paramFromServiceMsg, localGPadInfo });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(TAG, 2, " handleAddGroupTeamWorkLink issuccess = " + bool + " retCode = " + i + " error msg = " + paramFromServiceMsg + " localpadinfo =" + localGPadInfo.toString());
      return;
      paramToServiceMsg = "";
    }
  }
  
  public void mm(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    long l = ((Long)paramToServiceMsg.getAttribute(ckm)).longValue();
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    GPadInfo localGPadInfo = new GPadInfo();
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (!paramFromServiceMsg.uint32_result.has()) {
            continue;
          }
          i = paramFromServiceMsg.uint32_result.get();
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramToServiceMsg = "";
          int i = -1;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " handleAddGroupTeamWorkCopy parse oidb_sso.OIDBSSOPkg failed.");
          }
          paramFromServiceMsg.printStackTrace();
          continue;
          paramToServiceMsg = "";
          i = -1;
          continue;
        }
        try
        {
          if (paramFromServiceMsg.str_error_msg.has())
          {
            paramToServiceMsg = paramFromServiceMsg.str_error_msg.get();
            if (i != 0) {}
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramToServiceMsg = "";
          continue;
        }
        try
        {
          paramObject = new Oidb_0xaf3.RspBody();
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          a(localGPadInfo, (group_online_docs.DocInfo)paramObject.doc_info.get(), l);
          h(l, 0, 20, 2);
          lE(l);
          localGPadInfo.pad_url = ("https:" + localGPadInfo.pad_url);
          ault.a(this.app, localGPadInfo, String.valueOf(l));
          notifyUI(6, bool, new Object[] { Integer.valueOf(i), paramToServiceMsg, localGPadInfo });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(TAG, 2, " handleAddGroupTeamWorkCopy issuccess = " + bool + " retCode = " + i + " error msg = " + paramToServiceMsg + " localpadinfo =" + localGPadInfo.toString());
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
      }
      paramToServiceMsg = "";
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add(ckf);
      this.allowCmdSet.add(ckh);
      this.allowCmdSet.add(ckj);
      this.allowCmdSet.add(cki);
      this.allowCmdSet.add(ckk);
      this.allowCmdSet.add(ckl);
      this.allowCmdSet.add(ckg);
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aumy.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    boolean bool = paramFromServiceMsg.isSuccess();
    if (ckf.equals(paramFromServiceMsg.getServiceCmd())) {
      lc(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "onReceive, cmd=" + str + ", isSucc=" + bool);
      }
      return;
      if (ckj.equals(paramFromServiceMsg.getServiceCmd())) {
        la(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (ckh.equals(paramFromServiceMsg.getServiceCmd())) {
        ld(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (cki.equals(paramFromServiceMsg.getServiceCmd())) {
        le(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (ckk.equals(paramFromServiceMsg.getServiceCmd())) {
        ml(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (ckl.equals(paramFromServiceMsg.getServiceCmd())) {
        mm(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (ckg.equals(paramFromServiceMsg.getServiceCmd())) {
        lb(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aumb
 * JD-Core Version:    0.7.0.1
 */