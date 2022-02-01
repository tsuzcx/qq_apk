package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import aqgz;
import awit;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kxm;
import lhf;
import lir;
import ljd;
import lup;
import luq.d;
import luq.d.a;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.InnerMsg;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ReqBody;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ReqChannelPara;

public class VideoArticleModule$2
  implements Runnable
{
  public void run()
  {
    oidb_cmd0xbed.ReqChannelPara localReqChannelPara;
    Object localObject;
    for (;;)
    {
      try
      {
        oidb_cmd0xbed.ReqBody localReqBody = new oidb_cmd0xbed.ReqBody();
        localReqChannelPara = new oidb_cmd0xbed.ReqChannelPara();
        localReqChannelPara.uint32_channel_id.set(this.a.channelID);
        localReqChannelPara.uint32_channel_type.set(this.a.channelType);
        if (this.a.uH != -1L) {
          localReqChannelPara.uint64_begin_recommend_seq.set(this.a.uH);
        }
        if (this.a.uI != -1L) {
          localReqChannelPara.uint64_end_recommend_seq.set(this.a.uI);
        }
        if (!TextUtils.isEmpty(this.a.afM)) {
          localReqChannelPara.bytes_begin_recommend_rowkey.set(ByteStringMicro.copyFromUtf8(this.a.afM));
        }
        if (!TextUtils.isEmpty(this.a.afN)) {
          localReqChannelPara.bytes_end_recommend_rowkey.set(ByteStringMicro.copyFromUtf8(this.a.afN));
        }
        localReqChannelPara.uint64_begin_collection_id.set(this.a.uK);
        localReqChannelPara.uint64_end_collection_id.set(this.a.uL);
        localObject = aqgz.getIMEI();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localReqChannelPara.bytes_device_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
        }
        localReqChannelPara.uint32_update_times.set(this.a.aQe);
        localReqChannelPara.uint32_sim_type.set(awit.Qg());
        localReqChannelPara.uint32_network_type.set(lhf.getNetType());
        if (this.a.businessInfo != null) {
          localReqChannelPara.bytes_business_info.set(ByteStringMicro.copyFrom(this.a.businessInfo));
        }
        if ((this.a.iu == null) || (this.a.iu.size() <= 0)) {
          break label588;
        }
        localReqChannelPara.rpt_subscription_article_list.set(this.a.iu);
        localObject = new ArrayList();
        Iterator localIterator = this.a.iu.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Long localLong = (Long)localIterator.next();
        oidb_cmd0xbed.InnerMsg localInnerMsg = new oidb_cmd0xbed.InnerMsg();
        if (this.a.aPY > 0)
        {
          localInnerMsg.uint32_jump_src_type.set(this.a.aPY);
          localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localLong)));
          if (!TextUtils.isEmpty(this.a.a.pushContext))
          {
            localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(this.a.a.pushContext));
            if (QLog.isColorLevel()) {
              QLog.d(ljd.TAG, 2, "add push contenxt:" + this.a.a.pushContext);
            }
          }
          localInnerMsg.uint64_algorithm_id.set(this.a.a.uM);
          localInnerMsg.uint32_strategy_id.set(this.a.a.strategyID);
          ((List)localObject).add(localInnerMsg);
        }
        else
        {
          localInnerMsg.uint32_jump_src_type.set(1);
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e(ljd.TAG, 2, "request0xbedSendWeiShiArticleInfoList makeParams:" + kxm.getStackTrace(localThrowable));
        }
        return;
      }
    }
    localReqChannelPara.rpt_inner_msg_list.set((List)localObject);
    label588:
    localThrowable.reqChannelPara.set(localReqChannelPara);
    ToServiceMsg localToServiceMsg = lup.makeOIDBPkg("OidbSvc.0xbed", 3053, 1, localThrowable.toByteArray());
    if (localToServiceMsg != null)
    {
      localToServiceMsg.getAttributes().put("channelID", Integer.valueOf(this.a.channelID));
      localToServiceMsg.getAttributes().put(lir.afg, Long.valueOf(this.a.uH));
      localToServiceMsg.getAttributes().put(lir.afh, Long.valueOf(this.a.uI));
      localToServiceMsg.getAttributes().put("CountOfRequest_0xbed", Integer.valueOf(1));
    }
    this.this$0.sendPbReq(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.2
 * JD-Core Version:    0.7.0.1
 */