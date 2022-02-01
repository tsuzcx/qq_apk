import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class tsx
  implements sth, stm
{
  private View a;
  protected BaseData a;
  protected VafContext a;
  protected WeakReference<Context> a;
  protected stg a;
  protected svz a;
  
  public tsx()
  {
    this.jdField_a_of_type_Svz = new svz();
  }
  
  public int a(BaseData paramBaseData)
  {
    return 0;
  }
  
  public stg a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Stg != null) {
      return this.jdField_a_of_type_Stg;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qle();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      ozp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    try
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.a);
      ozp.a(((Container)this.jdField_a_of_type_AndroidViewView).getVirtualView(), localProteusItemData.a.getViewBean());
      paramViewGroup = localProteusItemData.c.toString();
      boolean bool = false;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(paramContext);
        bool = true;
      }
      this.jdField_a_of_type_AndroidViewView.setTag(paramBaseData);
      twp.a("WebFastBaseProteusAdCreator", "createViewHolder viewIsNull=" + bool + "  proteusData=" + paramViewGroup);
      this.jdField_a_of_type_Stg = a(this.jdField_a_of_type_AndroidViewView, localProteusItemData);
      return this.jdField_a_of_type_Stg;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        paramViewGroup = "error!! msg=" + paramViewGroup.toString();
      }
    }
  }
  
  protected stg a(View paramView, BaseData paramBaseData)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Svz != null) {
      this.jdField_a_of_type_Svz.a();
    }
    if ((this.jdField_a_of_type_Stg instanceof tsy))
    {
      localObject = this.jdField_a_of_type_Stg.jdField_a_of_type_AndroidViewView;
      if (!(localObject instanceof Container)) {
        break label93;
      }
    }
    label93:
    for (Object localObject = (Container)localObject;; localObject = null)
    {
      if (localObject == null) {}
      do
      {
        do
        {
          return;
          localObject = ((Container)localObject).getVirtualView();
        } while (localObject == null);
        localObject = ((ViewBase)localObject).findViewBaseByName(tqi.a(Aladdin.getConfig(341).getIntegerFromString("bottom_ad_style", 0)));
      } while (!(localObject instanceof tyx));
      ((tyx)localObject).c();
      return;
    }
  }
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_a_of_type_Svz != null) {
      this.jdField_a_of_type_Svz.b();
    }
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsx
 * JD-Core Version:    0.7.0.1
 */