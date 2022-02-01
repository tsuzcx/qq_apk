import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

public class tkt
  implements pyb
{
  public int a;
  public long a;
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  public String a;
  private tku<CharSequence> jdField_a_of_type_Tku = new tku("");
  private tku<CharSequence> b = new tku("");
  private tku<CharSequence> c = new tku("");
  
  private tkt(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_JavaLangCharSequence = qky.a((ArticleInfo)paramBaseArticleInfo);
    this.c.a(tkw.a(paramBaseArticleInfo, this));
    this.jdField_a_of_type_Tku.a(tkw.b(paramBaseArticleInfo, this));
    this.b.a(tkw.c(paramBaseArticleInfo, this));
  }
  
  public static tkt a(BaseArticleInfo paramBaseArticleInfo)
  {
    return new tkt(paramBaseArticleInfo);
  }
  
  public BaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  public tku<CharSequence> a()
  {
    return this.jdField_a_of_type_Tku;
  }
  
  public void a()
  {
    this.c.a(tkw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.jdField_a_of_type_Tku.a(tkw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public void a(int paramInt)
  {
    QLog.d("ArticleViewModel", 1, "setCustomLinkTextColorSummary | linkedTextColor " + paramInt);
    this.c.a(tkw.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.b.a(tkw.b(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public tku<CharSequence> b()
  {
    return this.b;
  }
  
  public tku<CharSequence> c()
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
    this.c.a(tkw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.jdField_a_of_type_Tku.a(tkw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.b.a(tkw.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkt
 * JD-Core Version:    0.7.0.1
 */