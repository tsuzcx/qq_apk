package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import awit;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kcr;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;

public class VideoPlayRecommendHandler$5
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject = new oidb_0x6cf.ReqBody();
      ((oidb_0x6cf.ReqBody)localObject).uint64_uin.set(this.val$uin);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_source.set(this.aHE);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_times.set(this.aHz);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_network.set(kcr.a(this.this$0));
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_os.set(1);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_sim_type.set(awit.Qg());
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_sub_source.set(4);
      ByteStringMicro localByteStringMicro;
      if (!TextUtils.isEmpty(this.XS))
      {
        localByteStringMicro = ByteStringMicro.copyFromUtf8(this.XS);
        ((oidb_0x6cf.ReqBody)localObject).bytes_inner_id.set(localByteStringMicro);
      }
      if (this.rH != -1L) {
        ((oidb_0x6cf.ReqBody)localObject).uint32_req_topic_id.set((int)this.rH);
      }
      if (!TextUtils.isEmpty(this.XT))
      {
        localByteStringMicro = ByteStringMicro.copyFromUtf8(this.XT);
        ((oidb_0x6cf.ReqBody)localObject).bytes_req_web.set(localByteStringMicro);
      }
      if (!TextUtils.isEmpty(this.lr))
      {
        localByteStringMicro = ByteStringMicro.copyFromUtf8(this.lr);
        ((oidb_0x6cf.ReqBody)localObject).bytes_cookie.set(localByteStringMicro);
      }
      localObject = this.this$0.makeOIDBPkg("OidbSvc.0x6cf", 1743, 2, ((oidb_0x6cf.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(this.a.hashCode()));
      this.this$0.sendPbReq((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getPolymericRecommendVideo: videoFromType: " + this.aHE + ", polymericTopicId: " + this.rH + ", requestTime: " + this.aHz + ", cookie: " + this.lr + ", commonWebData: " + this.XT + "articleId: " + this.XS + ", uin: " + this.val$uin);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "error in making packing, service type is 2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoPlayRecommendHandler.5
 * JD-Core Version:    0.7.0.1
 */