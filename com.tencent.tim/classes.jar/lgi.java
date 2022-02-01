import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.viola.vinstance.VInstanceAction.VInstanceEventListener;
import com.tencent.widget.AbsListView;

public class lgi
  extends lfz
{
  private nxq a = new nxq();
  
  private void aMa()
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    int i = ((AbsListView)localObject1).getFirstVisiblePosition();
    int k = ((AbsListView)localObject1).getLastVisiblePosition();
    label24:
    BaseArticleInfo localBaseArticleInfo;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (i <= k)
    {
      localObject1 = getData(i);
      if (localObject1 != null)
      {
        localBaseArticleInfo = (BaseArticleInfo)localObject1;
        localObject2 = kxm.c(localBaseArticleInfo);
        int j = 0;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = kxm.d(localBaseArticleInfo);
          j = 1;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = kxm.e(localBaseArticleInfo);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ("1".equals(Uri.parse((String)localObject2).getQueryParameter("v_feeds_preload"))))
        {
          msg.a().nQ((String)localObject2);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("preloadFrom: ");
            if (j != 0) {
              break label205;
            }
          }
        }
      }
    }
    label205:
    for (localObject1 = "Gallery";; localObject1 = "ShortContent")
    {
      QLog.d("ViolaHandler", 2, (String)localObject1 + " and invoke webpreload data ,openUrl = " + (String)localObject2 + ";articleInfo = " + localBaseArticleInfo.toString());
      i += 1;
      break label24;
      break;
    }
  }
  
  public View d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560563, paramViewGroup, false);
      localView.setTag(new lgi.a(this.a, (WormholeView)localView, this));
    }
    paramView = (lgi.a)localView.getTag();
    paramViewGroup = getData(paramInt);
    if ((paramViewGroup instanceof BaseArticleInfo))
    {
      paramViewGroup = (BaseArticleInfo)paramViewGroup;
      paramView.setPosition(paramInt);
      paramView.d(paramViewGroup);
      paramView.g(paramViewGroup, paramInt);
    }
    return localView;
  }
  
  public boolean df(int paramInt)
  {
    return paramInt == 136;
  }
  
  public int np()
  {
    return 4;
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  public void onListViewScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a != null) {
      this.a.i(paramAbsListView);
    }
  }
  
  public void onListViewScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      aMa();
    }
  }
  
  public static class a
    implements View.OnClickListener, WormholeView.a, VInstanceAction.VInstanceEventListener
  {
    private WormholeView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView;
    private lgi jdField_a_of_type_Lgi;
    private nxq jdField_a_of_type_Nxq;
    private BaseArticleInfo d;
    private int position;
    
    public a(nxq paramnxq, WormholeView paramWormholeView, lgi paramlgi)
    {
      this.jdField_a_of_type_Nxq = paramnxq;
      this.jdField_a_of_type_Lgi = paramlgi;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView = paramWormholeView;
      paramWormholeView.setLifeListener(this);
      paramWormholeView.initView();
      paramWormholeView.setOnErrorViewClickListener(this);
    }
    
    private boolean dL(String paramString)
    {
      return (this.d != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.d.getWormholeId()));
    }
    
    public void a(WormholeView paramWormholeView)
    {
      if (this.jdField_a_of_type_Nxq != null)
      {
        this.jdField_a_of_type_Nxq.willAppear(paramWormholeView.getContainer(), this.jdField_a_of_type_Lgi.a());
        if (this.d != null) {
          this.jdField_a_of_type_Nxq.addVInstanceEventListener(this.d.getWormholeId(), this);
        }
      }
    }
    
    public void b(WormholeView paramWormholeView)
    {
      if (this.jdField_a_of_type_Nxq != null)
      {
        this.jdField_a_of_type_Nxq.jdMethod_do(paramWormholeView.getContainer());
        if (this.d != null) {
          this.jdField_a_of_type_Nxq.removeVInstanceEventListener(this.d.getWormholeId());
        }
      }
    }
    
    public void d(BaseArticleInfo paramBaseArticleInfo)
    {
      this.d = paramBaseArticleInfo;
    }
    
    public void g(BaseArticleInfo paramBaseArticleInfo, int paramInt)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView == null) {
        return;
      }
      if ((this.jdField_a_of_type_Nxq != null) && (this.jdField_a_of_type_Nxq.a(paramBaseArticleInfo, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.getContainer())))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.hideLoading();
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.showLoading();
    }
    
    public void onClick(View paramView)
    {
      if ((paramView.getId() == 2131382321) && (this.d != null) && (this.jdField_a_of_type_Nxq != null)) {
        this.jdField_a_of_type_Nxq.bQ(this.d.getWormholeId(), this.d.getWormholeData());
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public void onError(String paramString)
    {
      if ((dL(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaWormholeWormholeView.showError();
      }
    }
    
    public void onRefreshItem(String paramString)
    {
      if (dL(paramString)) {
        g(this.d, this.position);
      }
    }
    
    public void setPosition(int paramInt)
    {
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgi
 * JD-Core Version:    0.7.0.1
 */