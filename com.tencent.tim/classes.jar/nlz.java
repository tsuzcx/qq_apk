import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusBookData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.widget.AbsListView;
import org.json.JSONObject;

public class nlz
  implements nln, nlp
{
  private static boolean atv;
  private VafContext a;
  private ArticleInfo articleInfo;
  private lhu.a b = new nma(this);
  
  public int a(BaseData paramBaseData)
  {
    return 16;
  }
  
  public nlm a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.a == null)
    {
      this.a = new luh();
      this.a.setContext(paramContext);
    }
    if (this.articleInfo == null) {
      this.articleInfo = paramBaseData.articleInfo;
    }
    paramViewGroup = (ProteusBookData)paramBaseData;
    Container localContainer = this.a.getViewFactory().inflate(this.a, paramViewGroup.d);
    paramViewGroup = localContainer;
    if (localContainer == null) {
      paramViewGroup = new View(paramContext);
    }
    return new nlz.a(paramViewGroup, paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.type == 18;
  }
  
  public void aEe() {}
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    lhu locallhu = lbz.a().a();
    if (locallhu != null) {
      locallhu.N(this.b);
    }
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    if (atv)
    {
      atv = false;
      lhu locallhu = lbz.a().a();
      if (locallhu != null) {
        locallhu.a(this.articleInfo, this.b, false);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  static class a
    extends nlm
  {
    private Container f;
    
    public a(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      if ((paramView instanceof Container)) {
        this.f = ((Container)paramView);
      }
    }
    
    private JSONObject a(ProteusBookData paramProteusBookData)
    {
      if (paramProteusBookData.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) {
        return paramProteusBookData.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.f(paramProteusBookData.sourceId);
      }
      return null;
    }
    
    private void aZv()
    {
      ViewFactory.findClickableViewListener(this.f.getVirtualView(), new nmb(this));
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      switch (paramBaseData2.type)
      {
      }
      do
      {
        return;
      } while (this.f == null);
      paramBaseData1 = (ProteusBookData)paramBaseData2;
      if (paramBaseData1.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean != null)
      {
        paramBaseData1.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.putDynamicJson(a(paramBaseData1));
        kvx.a(this.f.getVirtualView(), paramBaseData1.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getViewBean());
      }
      aZv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlz
 * JD-Core Version:    0.7.0.1
 */