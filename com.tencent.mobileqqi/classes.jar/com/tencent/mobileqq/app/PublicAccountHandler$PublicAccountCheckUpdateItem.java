package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.util.Utils;

public class PublicAccountHandler$PublicAccountCheckUpdateItem
  implements CheckUpdateItemInterface
{
  public PublicAccountHandler$PublicAccountCheckUpdateItem(PublicAccountHandler paramPublicAccountHandler) {}
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 0;
    localReqItem.eServiceID = 102;
    long l1 = PublicAccountHandler.a(this.a);
    long l2 = PublicAccountHandler.b(this.a);
    mobileqq_mp.GetUserFollowListRequest localGetUserFollowListRequest = new mobileqq_mp.GetUserFollowListRequest();
    localGetUserFollowListRequest.follow_seqno.set(Utils.a(l1));
    localGetUserFollowListRequest.public_account_seqno.set(Utils.a(l2));
    localGetUserFollowListRequest.begin.set(0);
    localGetUserFollowListRequest.limit.set(1);
    localGetUserFollowListRequest.version.set(1);
    localGetUserFollowListRequest.is_increment.set(true);
    localReqItem.vecParam = PublicAccountServlet.a(localGetUserFollowListRequest.toByteArray());
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 102) && (paramRespItem.cResult == 0)) {
      this.a.a();
    }
  }
  
  public int b()
  {
    return 102;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.PublicAccountCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */