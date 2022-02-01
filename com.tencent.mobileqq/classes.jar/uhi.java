import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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

public class uhi
  implements tgs, tgx
{
  private View jdField_a_of_type_AndroidViewView;
  protected BaseData a;
  protected VafContext a;
  protected WeakReference<Context> a;
  protected tgr a;
  protected tjk a;
  private ufn jdField_a_of_type_Ufn;
  
  public uhi()
  {
    this.jdField_a_of_type_Tjk = new tjk();
  }
  
  public int a(BaseData paramBaseData)
  {
    return 0;
  }
  
  public tgr a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Tgr != null) {
      return this.jdField_a_of_type_Tgr;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qxj();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      piv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    try
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.a);
      piv.a(((Container)this.jdField_a_of_type_AndroidViewView).getVirtualView(), localProteusItemData.a.getViewBean());
      paramViewGroup = localProteusItemData.c.toString();
      boolean bool = false;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(paramContext);
        bool = true;
      }
      this.jdField_a_of_type_AndroidViewView.setTag(paramBaseData);
      ukq.a("WebFastBaseProteusAdCreator", "createViewHolder viewIsNull=" + bool + "  proteusData=" + paramViewGroup);
      this.jdField_a_of_type_Tgr = a(this.jdField_a_of_type_AndroidViewView, localProteusItemData);
      if ((this.jdField_a_of_type_Ufn == null) && ((this.jdField_a_of_type_AndroidViewView instanceof Container)) && (((Container)this.jdField_a_of_type_AndroidViewView).getVirtualView() != null)) {
        this.jdField_a_of_type_Ufn = ((ufn)((Container)this.jdField_a_of_type_AndroidViewView).getVirtualView().findViewBaseByName("id_view_AdDownloadView"));
      }
      return this.jdField_a_of_type_Tgr;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        paramViewGroup = "error!! msg=" + paramViewGroup.toString();
      }
    }
  }
  
  protected tgr a(View paramView, BaseData paramBaseData)
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
    if (this.jdField_a_of_type_Tjk != null) {
      this.jdField_a_of_type_Tjk.a();
    }
    if ((this.jdField_a_of_type_Tgr instanceof uhj))
    {
      localObject = this.jdField_a_of_type_Tgr.jdField_a_of_type_AndroidViewView;
      if (!(localObject instanceof Container)) {
        break label71;
      }
    }
    label71:
    for (Object localObject = (Container)localObject;; localObject = null)
    {
      if (localObject == null) {}
      while ((((Container)localObject).getVirtualView() == null) || (this.jdField_a_of_type_Ufn == null)) {
        return;
      }
      this.jdField_a_of_type_Ufn.a();
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ufn != null) {
      this.jdField_a_of_type_Ufn.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Tjk != null) {
      this.jdField_a_of_type_Tjk.b();
    }
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhi
 * JD-Core Version:    0.7.0.1
 */