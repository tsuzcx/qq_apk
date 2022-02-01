import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

public class ttb
  implements qhl
{
  public int a;
  public long a;
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  public String a;
  private ttc<CharSequence> jdField_a_of_type_Ttc = new ttc("");
  private ttc<CharSequence> b = new ttc("");
  private ttc<CharSequence> c = new ttc("");
  
  private ttb(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_JavaLangCharSequence = qvn.a((ArticleInfo)paramBaseArticleInfo);
    this.c.a(tte.a(paramBaseArticleInfo, this));
    this.jdField_a_of_type_Ttc.a(tte.b(paramBaseArticleInfo, this));
    this.b.a(tte.c(paramBaseArticleInfo, this));
  }
  
  public static ttb a(BaseArticleInfo paramBaseArticleInfo)
  {
    return new ttb(paramBaseArticleInfo);
  }
  
  public BaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  public ttc<CharSequence> a()
  {
    return this.jdField_a_of_type_Ttc;
  }
  
  public void a()
  {
    this.c.a(tte.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.jdField_a_of_type_Ttc.a(tte.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public void a(int paramInt)
  {
    QLog.d("ArticleViewModel", 1, "setCustomLinkTextColorSummary | linkedTextColor " + paramInt);
    this.c.a(tte.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.b.a(tte.b(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public ttc<CharSequence> b()
  {
    return this.b;
  }
  
  public ttc<CharSequence> c()
  {
    return this.c;
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
    this.c.a(tte.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.jdField_a_of_type_Ttc.a(tte.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.b.a(tte.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ttb
 * JD-Core Version:    0.7.0.1
 */