import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class zdt
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFeedListRsp>
{
  zdt(zds paramzds, yzu paramyzu) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramBoolean) && (paramLong == 0L))
    {
      this.jdField_a_of_type_Zds.a().b(paramStGetFeedListRsp.livePageInfo.get());
      if ((this.jdField_a_of_type_Yzu.c()) || (this.jdField_a_of_type_Yzu.d())) {
        if ((paramStGetFeedListRsp.hotLive.get() == null) || (paramStGetFeedListRsp.hotLive.get().size() == 0)) {
          if (zds.a(this.jdField_a_of_type_Zds) != null)
          {
            this.jdField_a_of_type_Zds.e();
            zds.a(this.jdField_a_of_type_Zds).b(true);
          }
        }
      }
    }
    label187:
    do
    {
      do
      {
        break label187;
        break label187;
        paramVSBaseRequest = this.jdField_a_of_type_Zds;
        paramString = paramStGetFeedListRsp.hotLive.get();
        localStCommonExt = paramStGetFeedListRsp.extInfo;
        if (paramStGetFeedListRsp.isFinish.get() == 1) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          paramVSBaseRequest.a(paramString, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
          this.jdField_a_of_type_Zds.b("share_key_continue_feeds", new yzn(paramStGetFeedListRsp.hotLive.get()));
          return;
          if (zds.a(this.jdField_a_of_type_Zds) == null) {
            break;
          }
          zds.a(this.jdField_a_of_type_Zds).b(false);
          break;
        }
      } while (!this.jdField_a_of_type_Yzu.e());
      paramVSBaseRequest = this.jdField_a_of_type_Zds;
      paramString = paramStGetFeedListRsp.hotLive.get();
      COMM.StCommonExt localStCommonExt = paramStGetFeedListRsp.extInfo;
      if (paramStGetFeedListRsp.isFinish.get() == 1) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramVSBaseRequest.b(paramString, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
        return;
      }
      this.jdField_a_of_type_Zds.a(false);
    } while (((!this.jdField_a_of_type_Yzu.c()) && (!this.jdField_a_of_type_Yzu.d())) || (zds.a(this.jdField_a_of_type_Zds) == null));
    zds.a(this.jdField_a_of_type_Zds).b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdt
 * JD-Core Version:    0.7.0.1
 */