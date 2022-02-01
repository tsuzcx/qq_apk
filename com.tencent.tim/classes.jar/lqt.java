import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.qphone.base.util.QLog;

class lqt
  implements ljc.c
{
  lqt(lqr paramlqr, ArticleInfo paramArticleInfo) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("OnSocialHeaderFollowClickListener", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    this.d.invalidateProteusTemplateBean();
    if ((paramBoolean) && (paramInt == 2))
    {
      this.d.mSocialFeedInfo.mFollowStatus = paramInt;
      this.d.mSocialFeedInfo.mFollowStatus = 2;
      lbz.a().j(this.d);
      lbz.a().ab(this.d.mSocialFeedInfo.a.uin, paramInt);
      lcc.a().aCi();
      lcc.a().a(this.d, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqt
 * JD-Core Version:    0.7.0.1
 */