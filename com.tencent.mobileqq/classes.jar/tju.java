import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import mqq.app.MobileQQ;

class tju
  implements biyn
{
  tju(tjt paramtjt, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((tjt.a(this.jdField_a_of_type_Tjt) == null) || (!tjt.a(this.jdField_a_of_type_Tjt).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      znl.b(1, 2131718766);
      bool = false;
    }
    for (;;)
    {
      paramBaseResp = (AppInterface)pkh.a();
      tkj.b(paramBaseResp.getApplication().getApplicationContext(), paramBaseResp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, -1, false, bool);
      return;
      znl.b(2, 2131718784);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tju
 * JD-Core Version:    0.7.0.1
 */