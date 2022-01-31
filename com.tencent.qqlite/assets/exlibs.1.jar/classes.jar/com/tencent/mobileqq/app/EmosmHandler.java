package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.emosm.EmosmPb.ReqBody;
import com.tencent.pb.emosm.EmosmPb.RspBody;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x1ReqDelTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x1RspDelTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2ReqFetchTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab.TabInfo;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x3ReqFetchBq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x3RspFetchBq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x6Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x6Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x7Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x7Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x8ReqAddTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocReq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class EmosmHandler
  extends BusinessHandler
{
  public static final String a = "EmosmHandler";
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private SparseArray b = new SparseArray();
  
  public EmosmHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static byte[] a(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  protected Class a()
  {
    return EmosmObserver.class;
  }
  
  public void a()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(92);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x490_92");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new EmosmPb.SubCmd0x1ReqDelTab();
    ((EmosmPb.SubCmd0x1ReqDelTab)localObject).uint32_tab_id.set(paramInt);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.msg_subcmd0x1_req_deltab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", paramInt);
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 1);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new EmosmPb.SubCmd0x2ReqFetchTab();
    ((EmosmPb.SubCmd0x2ReqFetchTab)localObject).fixed32_timestamp.set(paramInt1);
    ((EmosmPb.SubCmd0x2ReqFetchTab)localObject).int32_segment_flag.set(paramInt2);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(2);
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.msg_subcmd0x2_req_fetchtab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 2);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.int32_plat_id.set(109);
    Object localObject;
    if (6 == paramInt1)
    {
      localReqBody.uint32_sub_cmd.set(paramInt1);
      localObject = new EmosmPb.SubCmd0x6Req();
      ((EmosmPb.SubCmd0x6Req)localObject).u32_tab_id.set(paramInt2);
      ((EmosmPb.SubCmd0x6Req)localObject).str_item_id.set(paramString);
      localReqBody.msg_subcmd0x6_req.set((MessageMicro)localObject);
    }
    for (;;)
    {
      paramString = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
      paramString.extraData.putInt("EmosmPackageId", paramInt2);
      paramString.extraData.putInt("EmosmSubCmd", paramInt1);
      paramString.extraData.putBoolean("EmosmSubCmdFllow", false);
      if (107 == paramInt1)
      {
        paramString.extraData.putInt("EmosmSubCmd", 7);
        paramString.extraData.putBoolean("EmosmSubCmdFllow", true);
      }
      paramString.putWupBuffer(localReqBody.toByteArray());
      b(paramString);
      return;
      if ((7 == paramInt1) || (107 == paramInt1))
      {
        localReqBody.uint32_sub_cmd.set(7);
        localObject = new EmosmPb.SubCmd0x7Req();
        ((EmosmPb.SubCmd0x7Req)localObject).u32_tab_id.set(paramInt2);
        ((EmosmPb.SubCmd0x7Req)localObject).str_item_id.set(paramString);
        localReqBody.msg_subcmd0x7_req.set((MessageMicro)localObject);
      }
    }
  }
  
  public void a(int paramInt, ArrayList paramArrayList, String paramString)
  {
    if (paramArrayList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmosmHandler", 2, "emosm...fetch key count  = " + paramArrayList.size() + " epid = " + ((Emoticon)paramArrayList.get(0)).epId + "  eid.0 = " + ((Emoticon)paramArrayList.get(0)).eId);
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(ByteStringMicro.copyFrom(a(((Emoticon)((Iterator)localObject2).next()).eId)));
    }
    localObject2 = new EmosmPb.SubCmd0x3ReqFetchBq();
    ((EmosmPb.SubCmd0x3ReqFetchBq)localObject2).uint32_tab_id.set(paramInt);
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      ((EmosmPb.SubCmd0x3ReqFetchBq)localObject2).rpt_bytes_bqid.get().add(((List)localObject1).get(i));
      i += 1;
    }
    localObject1 = new EmosmPb.ReqBody();
    ((EmosmPb.ReqBody)localObject1).uint32_sub_cmd.set(3);
    ((EmosmPb.ReqBody)localObject1).uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    ((EmosmPb.ReqBody)localObject1).msg_subcmd0x3_req_fetchbq.set((MessageMicro)localObject2);
    ((EmosmPb.ReqBody)localObject1).int32_plat_id.set(109);
    localObject2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmPackageId", paramInt);
    ((ToServiceMsg)localObject2).extraData.putSerializable("EmosmEmos", paramArrayList);
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmSubCmd", 3);
    ((ToServiceMsg)localObject2).addAttribute("_tag_LOGSTR", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("EmosmHandler", 2, "getKeySeq reqlocalseq:" + paramString);
    }
    ((ToServiceMsg)localObject2).putWupBuffer(((EmosmPb.ReqBody)localObject1).toByteArray());
    b((ToServiceMsg)localObject2);
  }
  
  public void a(EmosmHandler.EmosmHandlerListener paramEmosmHandlerListener)
  {
    if ((paramEmosmHandlerListener != null) && (!this.jdField_a_of_type_JavaUtilList.contains(paramEmosmHandlerListener))) {
      this.jdField_a_of_type_JavaUtilList.add(paramEmosmHandlerListener);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int j;
    int i;
    Object localObject1;
    Object localObject2;
    EmosmResp localEmosmResp;
    if (paramFromServiceMsg.getServiceCmd().equals("BQMallSvc.TabOpReq"))
    {
      bool1 = paramFromServiceMsg.isSuccess();
      j = paramToServiceMsg.extraData.getInt("EmosmPackageId");
      i = paramToServiceMsg.extraData.getInt("EmosmSubCmd");
      localObject1 = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
      localObject2 = (ArrayList)paramToServiceMsg.extraData.getSerializable("EmosmEmos");
      localEmosmResp = new EmosmResp();
      localEmosmResp.resultcode = paramFromServiceMsg.getResultCode();
      localEmosmResp.data = ((List)localObject2);
      localEmosmResp.epId = j;
      localEmosmResp.keySeq = ((String)localObject1);
      localEmosmResp.timeoutReason = MessageHandler.a(paramFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "key_seq=" + (String)localObject1 + " isSuccess=" + bool1 + " resultCode=" + paramFromServiceMsg.getResultCode() + " timeout:" + localEmosmResp.timeoutReason);
      }
      if (!bool1) {
        break label1563;
      }
      paramFromServiceMsg = new EmosmPb.RspBody();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (EmosmPb.RspBody)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          break label1243;
        }
        k = paramFromServiceMsg.int32_result.get();
        localEmosmResp.resultcode = k;
        if (k != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmosmHandler", 2, "emosm...fetch key 回包 sso 成功 ，server 失败，result = " + k);
          }
          bool1 = false;
          if (i == 1) {}
          localEmosmResp.delEpId = ((EmosmPb.SubCmd0x1RspDelTab)paramFromServiceMsg.msg_subcmd0x1_rsp_deltab.get()).uint32_tab_id.get();
          j = i;
          label307:
          paramToServiceMsg = this.jdField_a_of_type_JavaUtilList.iterator();
          if (!paramToServiceMsg.hasNext()) {
            break label1286;
          }
          ((EmosmHandler.EmosmHandlerListener)paramToServiceMsg.next()).a(bool1, j, localEmosmResp);
          continue;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        localEmosmResp.resultcode = -1;
        paramFromServiceMsg = null;
        continue;
        switch (i)
        {
        }
      }
      label412:
      continue;
      localEmosmResp.data = null;
      localEmosmResp.delEpId = ((EmosmPb.SubCmd0x1RspDelTab)paramFromServiceMsg.msg_subcmd0x1_rsp_deltab.get()).uint32_tab_id.get();
      continue;
      int k = paramFromServiceMsg.int32_result.get();
      paramToServiceMsg = ((EmosmPb.SubCmd0x2RspFetchTab)paramFromServiceMsg.msg_subcmd0x2_rsp_fetchtab.get()).rpt_msg_tabinfo.get();
      paramObject = ((EmosmPb.SubCmd0x2RspFetchTab)paramFromServiceMsg.msg_subcmd0x2_rsp_fetchtab.get()).rpt_magic_tabinfo.get();
      int m = ((EmosmPb.SubCmd0x2RspFetchTab)paramFromServiceMsg.msg_subcmd0x2_rsp_fetchtab.get()).fixed32_timestamp.get();
      if ((k == 0) || (k == -1))
      {
        localEmosmResp.timestamp = m;
        paramFromServiceMsg = new ArrayList();
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) == null) {
          break label1560;
        }
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).addAll(paramToServiceMsg);
        paramToServiceMsg = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(j);
      }
      label1286:
      label1560:
      for (;;)
      {
        paramToServiceMsg = paramToServiceMsg.iterator();
        boolean bool2;
        if (paramToServiceMsg.hasNext())
        {
          localObject1 = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramToServiceMsg.next();
          localObject2 = new EmoticonPackage();
          ((EmoticonPackage)localObject2).epId = String.valueOf(((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).uint32_tab_id.get());
          ((EmoticonPackage)localObject2).expiretime = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).fixed32_expire_time.get();
          if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).uint32_flags.get() == 1) {}
          for (bool2 = true;; bool2 = false)
          {
            ((EmoticonPackage)localObject2).valid = bool2;
            ((EmoticonPackage)localObject2).wordingId = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject1).int32_wording_id.get();
            paramFromServiceMsg.add(localObject2);
            break;
          }
        }
        localEmosmResp.data = paramFromServiceMsg;
        paramFromServiceMsg = new ArrayList();
        if (this.b.get(j) != null)
        {
          ((List)this.b.get(j)).addAll(paramObject);
          paramToServiceMsg = (List)this.b.get(j);
          this.b.remove(j);
        }
        for (;;)
        {
          paramToServiceMsg = paramToServiceMsg.iterator();
          if (paramToServiceMsg.hasNext())
          {
            paramObject = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramToServiceMsg.next();
            localObject1 = new EmoticonPackage();
            ((EmoticonPackage)localObject1).epId = String.valueOf(paramObject.uint32_tab_id.get());
            ((EmoticonPackage)localObject1).expiretime = paramObject.fixed32_expire_time.get();
            if (paramObject.uint32_flags.get() == 1) {}
            for (bool2 = true;; bool2 = false)
            {
              ((EmoticonPackage)localObject1).valid = bool2;
              ((EmoticonPackage)localObject1).wordingId = paramObject.int32_wording_id.get();
              ((EmoticonPackage)localObject1).jobType = 3;
              ((EmoticonPackage)localObject1).type = 1;
              paramFromServiceMsg.add(localObject1);
              break;
            }
          }
          localEmosmResp.magicData = paramFromServiceMsg;
          break;
          if (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) != null)
          {
            ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).addAll(paramToServiceMsg);
            label939:
            if (this.b.get(j) == null) {
              break label992;
            }
            ((List)this.b.get(j)).addAll(paramObject);
            label970:
            a(m, k);
          }
          label992:
          label1507:
          label1513:
          label1519:
          do
          {
            do
            {
              return;
              this.jdField_a_of_type_AndroidUtilSparseArray.put(j, paramToServiceMsg);
              break label939;
              this.jdField_a_of_type_AndroidUtilSparseArray.put(j, paramObject);
              break label970;
              paramToServiceMsg = (ArrayList)localEmosmResp.data;
              localEmosmResp.epId = j;
              paramFromServiceMsg = ((EmosmPb.SubCmd0x3RspFetchBq)paramFromServiceMsg.msg_subcmd0x3_rsp_fetchbq.get()).rpt_bytes_key.get();
              j = 0;
              while (j < paramFromServiceMsg.size())
              {
                paramObject = (ByteStringMicro)paramFromServiceMsg.get(j);
                ((Emoticon)paramToServiceMsg.get(j)).encryptKey = paramObject.toStringUtf8();
                j += 1;
              }
              localEmosmResp.data = paramToServiceMsg;
              if (!QLog.isColorLevel()) {
                break label412;
              }
              QLog.d("EmosmHandler", 2, "emosm...fetch key 回包 sso 成功 ，server 成功");
              break;
              localEmosmResp.delEpId = ((EmosmPb.SubCmd0x6Rsp)paramFromServiceMsg.msg_subcmd0x6_collect_auth.get()).int32_auth_detail.get();
              localEmosmResp.keySeq = ((EmosmPb.SubCmd0x6Rsp)paramFromServiceMsg.msg_subcmd0x6_collect_auth.get()).str_auth_msg.get();
              break;
              localEmosmResp.delEpId = ((EmosmPb.SubCmd0x7Rsp)paramFromServiceMsg.msg_subcmd0x7_rsp.get()).int32_auth_detail.get();
              localEmosmResp.keySeq = ((EmosmPb.SubCmd0x7Rsp)paramFromServiceMsg.msg_subcmd0x7_rsp.get()).str_auth_msg.get();
              if (!paramToServiceMsg.extraData.getBoolean("EmosmSubCmdFllow")) {
                break label412;
              }
              i = 107;
              break;
              localEmosmResp.data = ((EmosmPb.SubCmd0x9BqAssocRsp)paramFromServiceMsg.msg_subcmd0x9_rsp.get()).rpt_assoc_bqs.get();
              break label412;
              bool2 = false;
              localEmosmResp.resultcode = -1;
              bool1 = bool2;
              j = i;
              if (!QLog.isColorLevel()) {
                break label307;
              }
              QLog.d("EmosmHandler", 2, "emosm...fetch key 回包 异常");
              bool1 = bool2;
              j = i;
              break label307;
              a(j, bool1, localEmosmResp);
              return;
              if (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x490_92")) {
                break label1519;
              }
              if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
                break label1501;
              }
              i = 1;
              bool1 = true;
            } while (i == 0);
            for (;;)
            {
              try
              {
                paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
                paramToServiceMsg.mergeFrom((byte[])paramObject);
                if (paramToServiceMsg.uint32_result.get() != 0) {
                  break label1507;
                }
                i = 1;
                if (i != 0)
                {
                  paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
                  long l = paramToServiceMsg.getInt();
                  if (paramToServiceMsg.get() != 1) {
                    break label1513;
                  }
                  bool1 = true;
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("QQLite", 0).edit().putBoolean("emosm_has_download_emosmpackage_tag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), bool1).commit();
                }
                if (!bool1) {
                  break;
                }
                ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a();
                return;
              }
              catch (Exception paramToServiceMsg) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("GetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
              return;
              i = 0;
              break label1323;
              i = 0;
              continue;
              bool1 = false;
            }
          } while (!QLog.isColorLevel());
          label1243:
          label1501:
          QLog.d("EmosmHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
          label1323:
          return;
          paramToServiceMsg = paramObject;
        }
      }
      label1563:
      j = i;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmosmHandler", 2, "ReportAddEmoticonPkg, pkgId=" + paramString);
    }
    Object localObject = new EmosmPb.SubCmd0x8ReqAddTab();
    ((EmosmPb.SubCmd0x8ReqAddTab)localObject).uint32_tab_id.set(Integer.parseInt(paramString));
    paramString = new EmosmPb.ReqBody();
    paramString.uint32_sub_cmd.set(8);
    paramString.uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    paramString.int32_plat_id.set(109);
    paramString.str_app_version.set("3.4.0");
    paramString.msg_subcmd0x8_req_addtab.set((MessageMicro)localObject);
    paramString.setHasFlag(true);
    localObject = a("BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 8);
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_sub_cmd.set(9);
    EmosmPb.SubCmd0x9BqAssocReq localSubCmd0x9BqAssocReq = new EmosmPb.SubCmd0x9BqAssocReq();
    localSubCmd0x9BqAssocReq.str_key_word.set(paramString);
    localSubCmd0x9BqAssocReq.rpt_str_bq_item_id.set(paramArrayList);
    localReqBody.msg_subcmd0x9_req.set(localSubCmd0x9BqAssocReq);
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BQMallSvc.TabOpReq");
    paramString.extraData.putInt("EmosmSubCmd", 9);
    paramString.putWupBuffer(localReqBody.toByteArray());
    b(paramString);
  }
  
  public void b(EmosmHandler.EmosmHandlerListener paramEmosmHandlerListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramEmosmHandlerListener)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramEmosmHandlerListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.EmosmHandler
 * JD-Core Version:    0.7.0.1
 */