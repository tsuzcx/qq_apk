import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

public class nte
  implements ReadInJoyUserInfoModule.a
{
  public int aPH;
  public String afx;
  private ntf<CharSequence> b = new ntf("");
  private ntf<CharSequence> c = new ntf("");
  private final BaseArticleInfo jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private ntf<CharSequence> jdField_d_of_type_Ntf = new ntf("");
  private CharSequence t = "";
  public long uF;
  
  private nte(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.t = lsy.a((ArticleInfo)paramBaseArticleInfo);
    this.jdField_d_of_type_Ntf.set(nth.a(paramBaseArticleInfo, this));
    this.b.set(nth.b(paramBaseArticleInfo, this));
    this.c.set(nth.c(paramBaseArticleInfo, this));
  }
  
  public static nte a(BaseArticleInfo paramBaseArticleInfo)
  {
    return new nte(paramBaseArticleInfo);
  }
  
  public BaseArticleInfo a()
  {
    return this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  public ntf<CharSequence> a()
  {
    return this.b;
  }
  
  public ntf<CharSequence> b()
  {
    return this.c;
  }
  
  public ntf<CharSequence> c()
  {
    return this.jdField_d_of_type_Ntf;
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.e("ArticleViewModel", 1, "[onLoadUserInfoFailed] uin=" + paramString1 + ", msg=" + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleViewModel", 2, "[onLoadUserInfoSucceed] uin=" + paramString + " userInfo: " + paramReadInJoyUserInfo);
    }
    this.jdField_d_of_type_Ntf.set(nth.a(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.b.set(nth.b(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.c.set(nth.c(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
  }
  
  public void reset()
  {
    this.jdField_d_of_type_Ntf.set(nth.a(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.b.set(nth.b(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nte
 * JD-Core Version:    0.7.0.1
 */