import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.2;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.5;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainerHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.BindDataUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class lty
  extends RecyclerView.Adapter
  implements PolymericContainer
{
  private static int aPR;
  private static Map<Long, List<ArticleInfo>> et = new HashMap();
  private static List<Integer> is = new ArrayList();
  private String TAG = "RecycleViewAdapterHelper";
  private EventCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericEventCallback = new luf(this);
  public PolymericContainerHelper a;
  protected lie a;
  private lty.b jdField_a_of_type_Lty$b;
  private lty.c jdField_a_of_type_Lty$c;
  protected int aPS;
  private boolean ala = true;
  private ProteusRecycleView b;
  private VafContext c;
  protected Map<String, Integer> er = new HashMap();
  protected Map<Integer, String> es = new HashMap();
  private List<BaseArticleInfo> il;
  
  public lty(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper = new PolymericContainerHelper();
    this.c = paramVafContext;
    is.add(Integer.valueOf(0));
  }
  
  private void G(Runnable paramRunnable)
  {
    if (!this.b.isComputingLayout())
    {
      paramRunnable.run();
      return;
    }
    this.b.postDelayed(new RecycleViewAdapterHelper.5(this, paramRunnable), 100L);
  }
  
  private void aH(String paramString, int paramInt)
  {
    this.es.put(Integer.valueOf(paramInt), paramString);
    this.er.put(paramString, Integer.valueOf(paramInt));
  }
  
  public static void aNv()
  {
    is.clear();
    is.add(Integer.valueOf(aPR));
  }
  
  public static List<Integer> aV()
  {
    return is;
  }
  
  public static void eB(long paramLong)
  {
    et.remove(Long.valueOf(paramLong));
  }
  
  private View getErrorView()
  {
    View localView = new View(this.c.getContext());
    localView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
    localView.setVisibility(8);
    return localView;
  }
  
  public static List<ArticleInfo> h(long paramLong)
  {
    return (List)et.get(Long.valueOf(paramLong));
  }
  
  private void h(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    Object localObject;
    ArticleInfo localArticleInfo;
    int j;
    int k;
    if ((paramBaseArticleInfo instanceof ArticleInfo))
    {
      localObject = this.jdField_a_of_type_Lie.a().getContext();
      localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
      j = getItemViewType(paramInt);
      k = (int)paramBaseArticleInfo.mChannelID;
      if (paramBaseArticleInfo.mChannelID != 3L) {
        break label108;
      }
    }
    label108:
    for (int i = 1;; i = 0)
    {
      localObject = new lis((Context)localObject, localArticleInfo, j, k, i, paramInt, false, getDataCount(), null, this.jdField_a_of_type_Lie.b());
      this.jdField_a_of_type_Lie.b().a(paramBaseArticleInfo, (lie)localObject, System.currentTimeMillis(), paramInt);
      return;
    }
  }
  
  private JSONObject j(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject.toString());
      paramJSONObject.put("style_ID", "ReadInjoy_daily_check_share");
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e(this.TAG, 1, paramJSONObject, new Object[0]);
    }
    return null;
  }
  
  private void rx(int paramInt)
  {
    QLog.d(this.TAG, 1, "addExportItem curPosition: " + paramInt + "  model :" + this.jdField_a_of_type_Lie);
    TemplateBean localTemplateBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.getCellData(paramInt);
    if ((this.jdField_a_of_type_Lie != null) && (this.jdField_a_of_type_Lie.a() != null) && (localTemplateBean != null)) {}
    try
    {
      if ((this.jdField_a_of_type_Lie.a().mGroupSubArticleList != null) && (this.jdField_a_of_type_Lie.a().mGroupSubArticleList.size() > paramInt) && (kxm.B(this.jdField_a_of_type_Lie.a())) && (this.jdField_a_of_type_Lie.a().mNewPolymericInfo.amx)) {
        h((BaseArticleInfo)this.jdField_a_of_type_Lie.a().mGroupSubArticleList.get(paramInt), paramInt);
      }
      for (;;)
      {
        QLog.d(this.TAG, 1, "addExportItem added curPosition: " + paramInt + "  data :" + localTemplateBean + "   " + localTemplateBean.getDataAttribute(null));
        Object localObject1;
        do
        {
          return;
          localObject2 = (List)et.get(Long.valueOf(this.jdField_a_of_type_Lie.a().mArticleID));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            et.put(Long.valueOf(this.jdField_a_of_type_Lie.a().mArticleID), localObject1);
          }
        } while (paramInt < ((List)localObject1).size());
        Object localObject2 = this.jdField_a_of_type_Lie.a().clone();
        ((ArticleInfo)localObject2).mProteusTemplateBean = localTemplateBean;
        ((List)localObject1).add(localObject2);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d(this.TAG, 2, localException.getMessage());
      }
    }
  }
  
  public void a(ProteusRecycleView paramProteusRecycleView)
  {
    this.b = paramProteusRecycleView;
  }
  
  public void a(lty.b paramb)
  {
    this.jdField_a_of_type_Lty$b = paramb;
  }
  
  public void a(lty.c paramc)
  {
    this.jdField_a_of_type_Lty$c = paramc;
    G(new RecycleViewAdapterHelper.1(this));
  }
  
  public void cE(List<BaseArticleInfo> paramList)
  {
    this.il = paramList;
  }
  
  public int dp(int paramInt)
  {
    int i = paramInt;
    if (this.ala)
    {
      int j = getDataCount();
      i = paramInt;
      if (j > 0) {
        i = paramInt % j;
      }
    }
    return i;
  }
  
  public int getDataCount()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.childs.size();
  }
  
  public EventCallback getEventCallback()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericEventCallback;
  }
  
  public int getItemCount()
  {
    if ((this.ala) && (getDataCount() > 1)) {
      return 2147483647;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.childs.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    paramInt = dp(paramInt);
    TemplateBean localTemplateBean = (TemplateBean)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.childs.get(paramInt);
    Integer localInteger2 = (Integer)this.er.get(localTemplateBean.getStyleName());
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger1 = Integer.valueOf(this.aPS);
      aH(localTemplateBean.getStyleName(), localInteger1.intValue());
      this.aPS += 1;
    }
    return localInteger1.intValue();
  }
  
  public void nH(boolean paramBoolean)
  {
    this.ala = paramBoolean;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = dp(paramInt);
    Object localObject1;
    if ((paramViewHolder instanceof lty.d))
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.getCellData(i);
      if (localObject1 == null) {
        QLog.e(this.TAG, 2, "data == null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      rx(i);
      Object localObject2 = (lty.d)paramViewHolder;
      Container localContainer = (Container)((lty.d)localObject2).itemView;
      BindDataUtil.bindDynamicValueWithoutRecursion(localContainer, ((lty.d)localObject2).c, (TemplateBean)localObject1);
      Layout.Params localParams = localContainer.getVirtualView().getComLayoutParams();
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localContainer.getLayoutParams();
      if ((localParams.mLayoutWidth > 0) && (localParams.mLayoutHeight > 0) && ((localLayoutParams.width != localParams.mLayoutWidth) || (localLayoutParams.height != localParams.mLayoutHeight)))
      {
        localLayoutParams.width = localParams.mLayoutWidth;
        localLayoutParams.height = localParams.mLayoutHeight;
        localContainer.setLayoutParams(localLayoutParams);
      }
      ViewFactory.findClickableViewListener(((Container)((lty.d)localObject2).itemView).getVirtualView(), new ltz(this, i, (TemplateBean)localObject1));
      continue;
      if ((paramViewHolder instanceof lty.a))
      {
        localObject1 = (lty.a)paramViewHolder;
        localObject2 = ((lty.a)localObject1).itemView.getLayoutParams();
        if (localObject2 != null)
        {
          ((ViewGroup.LayoutParams)localObject2).width = 0;
          ((ViewGroup.LayoutParams)localObject2).height = 0;
          ((lty.a)localObject1).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (String)this.es.get(Integer.valueOf(paramInt));
    Object localObject = this.c.getTemplateFactory().getTemplate(paramViewGroup);
    localObject = this.c.getViewFactory().inflate(this.c, (TemplateBean)localObject);
    if (localObject == null)
    {
      QLog.e(this.TAG, 1, "styleName : " + paramViewGroup);
      obr.M("error", "", paramViewGroup);
      G(new RecycleViewAdapterHelper.2(this));
      return new lty.a(getErrorView());
    }
    paramViewGroup = ((Container)localObject).getVirtualView().getComLayoutParams();
    ((Container)localObject).setLayoutParams(new RecyclerView.LayoutParams(paramViewGroup.mLayoutWidth, paramViewGroup.mLayoutHeight));
    return new lty.d((Container)localObject, null);
  }
  
  public void setCellArray(BaseTemplateFactory paramBaseTemplateFactory, JSONArray paramJSONArray)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.setCellArray(paramBaseTemplateFactory, paramJSONArray);
  }
  
  public void setEventCallback(EventCallback paramEventCallback)
  {
    if (paramEventCallback == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericEventCallback = paramEventCallback;
  }
  
  public void setModel(lie paramlie)
  {
    if (paramlie == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Lie = paramlie;
    } while (this.jdField_a_of_type_Lie.a() == null);
    cE(this.jdField_a_of_type_Lie.a().mGroupSubArticleList);
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onError();
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean);
  }
  
  public class d
    extends RecyclerView.ViewHolder
  {
    public TemplateBean c;
    
    public d(Container paramContainer, TemplateBean paramTemplateBean)
    {
      super();
      this.c = paramTemplateBean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lty
 * JD-Core Version:    0.7.0.1
 */