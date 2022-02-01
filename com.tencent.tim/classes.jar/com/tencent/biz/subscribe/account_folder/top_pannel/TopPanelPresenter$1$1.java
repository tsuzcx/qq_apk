package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import com.tencent.mobileqq.pb.PBUInt32Field;
import common.config.service.QzoneConfig;
import java.util.List;
import sae.b;
import saf;
import sag;

public class TopPanelPresenter$1$1
  implements Runnable
{
  public TopPanelPresenter$1$1(sag paramsag, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    sae.b localb = saf.a(this.jdField_a_of_type_Sag.b);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverEntryEnable", 1) & (QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) ^ 0xFFFFFFFF)) == 1)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetRecommendUserListRsp.entry.has()) {
        localObject1 = (CertifiedAccountMeta.StEntry)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetRecommendUserListRsp.entry.get();
      }
    }
    if (localb != null)
    {
      localb.b((CertifiedAccountMeta.StEntry)localObject1, this.pq, this.aKF);
      int i = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetRecommendUserListRsp.noticeCount.get();
      if (i > 0) {
        localb.yj(i);
      }
    }
    else
    {
      return;
    }
    localb.bxF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelPresenter.1.1
 * JD-Core Version:    0.7.0.1
 */