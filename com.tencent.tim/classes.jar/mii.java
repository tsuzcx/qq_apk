import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URL;
import java.util.ArrayList;

public class mii
  extends mgy
{
  private String aiL;
  
  public mii(BaseArticleInfo paramBaseArticleInfo)
  {
    super(paramBaseArticleInfo);
  }
  
  public int getCommentCount()
  {
    if (((this.j instanceof ArticleInfo)) && (!ndi.aa((ArticleInfo)this.j))) {
      return this.j.mSocialFeedInfo.mCommentCount;
    }
    return this.j.mVideoCommentCount;
  }
  
  public String getInnerUniqueID()
  {
    return ((SocializeFeedsInfo.t)this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aim;
  }
  
  public String getShareUrl()
  {
    if (((this.j instanceof ArticleInfo)) && (!ndi.aa((ArticleInfo)this.j))) {
      return ((SocializeFeedsInfo.t)this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).share_url;
    }
    return super.getShareUrl();
  }
  
  public String getSubscribeName()
  {
    if (TextUtils.isEmpty(this.aiL))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label59;
      }
    }
    label59:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = aqgv.b((QQAppInterface)localObject, getSubscribeUin(), true);; localObject = "")
      {
        this.aiL = ((String)localObject);
        return this.aiL;
      }
    }
  }
  
  public String getSubscribeUin()
  {
    if (this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
      return String.valueOf(this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
    }
    return "";
  }
  
  public URL getVideoCoverURL()
  {
    if ((this.j.mSocialFeedInfo != null) && (this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null) && (this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.size() > 0)) {
      return kxm.a(((SocializeFeedsInfo.t)this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).pic_url, true, true);
    }
    return this.j.mVideoCoverUrl;
  }
  
  public URL getVideoCoverWithSmartCut(int paramInt1, int paramInt2)
  {
    if ((this.j.mSocialFeedInfo != null) && (this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null) && (this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.size() > 0)) {
      return kxm.b(kxm.c(((SocializeFeedsInfo.t)this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).pic_url, paramInt1, paramInt2));
    }
    return this.j.mVideoCoverUrl;
  }
  
  public int getVideoDuration()
  {
    if (((this.j instanceof ArticleInfo)) && (!ndi.aa((ArticleInfo)this.j))) {
      return (int)(((SocializeFeedsInfo.t)this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).duration / 1000L);
    }
    return super.getVideoDuration();
  }
  
  public int getVideoHeight()
  {
    return ((SocializeFeedsInfo.t)this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aTd;
  }
  
  public String getVideoVid()
  {
    return ((SocializeFeedsInfo.t)this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).vid;
  }
  
  public int getVideoWidth()
  {
    return ((SocializeFeedsInfo.t)this.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aTc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mii
 * JD-Core Version:    0.7.0.1
 */