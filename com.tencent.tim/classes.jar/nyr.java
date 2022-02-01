import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.network.SubscribeGetFollowFeedsRequest;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class nyr
  implements rxc.a<CertifiedAccountRead.StGetFollowFeedsRsp>
{
  public nyr(FolderFollowTabFragment paramFolderFollowTabFragment, SubscribeGetFollowFeedsRequest paramSubscribeGetFollowFeedsRequest, sbf paramsbf) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowFeedsRsp paramStGetFollowFeedsRsp)
  {
    boolean bool1 = true;
    boolean bool2 = VSNetworkHelper.fQ(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowFeedsRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QQToast.a(FolderFollowTabFragment.a(this.this$0), 1, paramString, 0).show();
      }
      if (!bool2)
      {
        VSBaseRequest.reMoveCache(this.a);
        if ((this.b.getItemCount() == 0) && (FolderFollowTabFragment.a(this.this$0) != null)) {
          FolderFollowTabFragment.a(this.this$0).uN(true);
        }
      }
      return;
    }
    paramString = paramStGetFollowFeedsRsp.feeds.get();
    if ((FolderFollowTabFragment.a(this.this$0) != null) && (!bool2) && (paramStGetFollowFeedsRsp.messStatus.get() != null))
    {
      FolderFollowTabFragment.a(this.this$0).us(paramStGetFollowFeedsRsp.messStatus.noticeCount.get());
      FolderFollowTabFragment.a(this.this$0).setJumpWebMessageListUrl(paramStGetFollowFeedsRsp.messStatus.jumpURL.get());
    }
    if ((!bool2) || (FolderFollowTabFragment.a(this.this$0)))
    {
      if (FolderFollowTabFragment.a(this.this$0)) {
        FolderFollowTabFragment.a(this.this$0, false);
      }
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label336;
      }
      if (FolderFollowTabFragment.a(this.this$0) != null) {
        FolderFollowTabFragment.a(this.this$0).uN(false);
      }
      sbf localsbf = this.b;
      COMM.StCommonExt localStCommonExt = paramStGetFollowFeedsRsp.extInfo;
      if (paramStGetFollowFeedsRsp.isFinish.get() != 1) {
        break label330;
      }
      localsbf.b(paramString, localStCommonExt, bool1);
      if (!bool2)
      {
        FolderFollowTabFragment.a(this.this$0).clearData();
        FolderFollowTabFragment.a(this.this$0).notifyDataSetChanged();
        FolderFollowTabFragment.a(this.this$0).b(FolderFollowTabFragment.a(this.this$0));
      }
    }
    for (;;)
    {
      this.b.notifyLoadingComplete(paramBoolean);
      return;
      label330:
      bool1 = false;
      break;
      label336:
      if (!bool2)
      {
        VSBaseRequest.reMoveCache(this.a);
        FolderFollowTabFragment.c(this.this$0, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyr
 * JD-Core Version:    0.7.0.1
 */