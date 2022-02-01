import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

public class nyt
  implements rxc.a<CertifiedAccountRead.StGetFollowFeedsRsp>
{
  public nyt(FolderFollowTabFragment paramFolderFollowTabFragment, sbf paramsbf) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowFeedsRsp paramStGetFollowFeedsRsp)
  {
    boolean bool = true;
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowFeedsRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QQToast.a(FolderFollowTabFragment.a(this.this$0), 1, paramString, 0).show();
      }
      return;
    }
    if (paramStGetFollowFeedsRsp.messStatus.get() != null)
    {
      this.this$0.us(paramStGetFollowFeedsRsp.messStatus.noticeCount.get());
      FolderFollowTabFragment.a(this.this$0, paramStGetFollowFeedsRsp.messStatus.jumpURL.get());
    }
    paramString = paramStGetFollowFeedsRsp.feeds.get();
    sbf localsbf = this.b;
    COMM.StCommonExt localStCommonExt = paramStGetFollowFeedsRsp.extInfo;
    if (paramStGetFollowFeedsRsp.isFinish.get() == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localsbf.c(paramString, localStCommonExt, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyt
 * JD-Core Version:    0.7.0.1
 */