package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import awit;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kcr;
import kxm;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsIdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;

public class VideoPlayRecommendHandler$6
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject1 = new oidb_0x6cf.ReqBody();
      long l = 0L;
      Object localObject2 = kxm.a();
      if (localObject2 != null) {
        l = ((QQAppInterface)localObject2).getLongAccountUin();
      }
      ((oidb_0x6cf.ReqBody)localObject1).uint64_uin.set(l);
      ((oidb_0x6cf.ReqBody)localObject1).uint32_req_times.set(this.aHz);
      ((oidb_0x6cf.ReqBody)localObject1).uint32_req_network.set(kcr.a(this.this$0));
      ((oidb_0x6cf.ReqBody)localObject1).uint32_req_os.set(1);
      ((oidb_0x6cf.ReqBody)localObject1).uint32_req_sim_type.set(awit.Qg());
      ((oidb_0x6cf.ReqBody)localObject1).uint32_req_source.set(this.aHE);
      ((oidb_0x6cf.ReqBody)localObject1).uint32_req_sub_source.set(5);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.Wz))
      {
        localObject2 = ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.Wz);
        ((oidb_0x6cf.ReqBody)localObject1).bytes_inner_id.set((ByteStringMicro)localObject2);
      }
      if (!TextUtils.isEmpty(this.lr))
      {
        localObject2 = ByteStringMicro.copyFromUtf8(this.lr);
        ((oidb_0x6cf.ReqBody)localObject1).bytes_cookie.set((ByteStringMicro)localObject2);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.adB)
      {
        ((oidb_0x6cf.ReqBody)localObject1).uint32_is_ugc.set(1);
        localObject2 = new oidb_0x6cf.FeedsIdInfo();
        ((oidb_0x6cf.FeedsIdInfo)localObject2).uint64_feeds_id.set(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.rA);
        ((oidb_0x6cf.FeedsIdInfo)localObject2).uint32_feeds_type.set(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.feedType);
        ((oidb_0x6cf.ReqBody)localObject1).ugc_feeds_info.set((MessageMicro)localObject2);
      }
      for (;;)
      {
        localObject1 = this.this$0.makeOIDBPkg("OidbSvc.0x6cf", 1743, 0, ((oidb_0x6cf.ReqBody)localObject1).toByteArray());
        ((ToServiceMsg)localObject1).addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(this.jdField_a_of_type_Kcs.hashCode()));
        this.this$0.sendPbReq((ToServiceMsg)localObject1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendListForFloatingWindow: videoFromType: " + this.aHE + ",videoInfo: " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.toLogString() + ", requestTime: " + this.aHz + ", cookie: " + this.lr);
        return;
        ((oidb_0x6cf.ReqBody)localObject1).uint32_is_ugc.set(0);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "error in making packing");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoPlayRecommendHandler.6
 * JD-Core Version:    0.7.0.1
 */