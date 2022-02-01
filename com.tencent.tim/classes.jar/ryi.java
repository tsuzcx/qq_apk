import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.list.base.PublicListFragment;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ryi<E, T>
  extends rxq
{
  private static final String TAG = "BaseListBlock";
  protected Serializable mInitBean;
  protected String mLastAttachInfo;
  
  public ryi(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void showListView()
  {
    if ((getHostFragment() != null) && (getHostFragment().getBlockContainer() != null))
    {
      getHostFragment().getBlockContainer().a().setVisibility(8);
      getHostFragment().getBlockContainer().a().setVisibility(0);
    }
  }
  
  public abstract String getAttachInfoFromRsp(T paramT);
  
  public int getContentLayoutId()
  {
    return 2131560876;
  }
  
  public abstract String getDropFrameMonitorTag();
  
  public abstract String getEmptyHint();
  
  public PublicListFragment getHostFragment()
  {
    if ((getParentFragment() instanceof PublicListFragment)) {
      return (PublicListFragment)getParentFragment();
    }
    return null;
  }
  
  public abstract boolean getIsFinishFromRsp(T paramT);
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public abstract List<E> getListDataFromRsp(T paramT);
  
  public abstract VSBaseRequest getRequest(String paramString);
  
  public VSBaseRequest getRequestWithLoadInfo(rxt paramrxt)
  {
    VSBaseRequest localVSBaseRequest = null;
    if (paramrxt.Mg())
    {
      localVSBaseRequest = getRequest(null);
      localVSBaseRequest.setEnableCache(true);
    }
    do
    {
      return localVSBaseRequest;
      if (paramrxt.Mh()) {
        return getRequest(null);
      }
    } while (!paramrxt.Mi());
    return getRequest(this.mLastAttachInfo);
  }
  
  public abstract int getStatusBarColor();
  
  public abstract String getTitle();
  
  protected void handleResponse(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, T paramT)
  {
    if ((!paramBoolean1) || (paramLong != 0L) || (paramT == null))
    {
      showErrorView(paramString2);
      notifyLoadingComplete(true, false);
      return;
    }
    paramString2 = getListDataFromRsp(paramT);
    paramBoolean1 = getIsFinishFromRsp(paramT);
    this.mLastAttachInfo = getAttachInfoFromRsp(paramT);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      QLog.d("BaseListBlock", 1, paramString1 + "rspData size:" + paramString2.size() + " | isFinish:" + paramBoolean1 + " | attachInfo:" + getAttachInfoFromRsp(paramT));
      if (paramBoolean2)
      {
        addAll(paramString2);
        showListView();
        getLoadInfo().setFinish(paramBoolean1);
      }
    }
    for (;;)
    {
      notifyLoadingComplete(true, paramBoolean1);
      return;
      setDatas(new ArrayList(paramString2));
      break;
      QLog.e("BaseListBlock", 1, "handleListDataRsp() return empty data");
      if (paramBoolean2)
      {
        if (getItemCount() > 0) {
          getLoadInfo().setFinish(paramBoolean1);
        } else {
          QLog.d("BaseListBlock", 1, "error state empty data,but execute load more");
        }
      }
      else
      {
        showEmptyView();
        clearData();
        notifyDataSetChanged();
      }
    }
  }
  
  public abstract void initTitleBar(View paramView);
  
  public void loadData(rxt paramrxt)
  {
    VSBaseRequest localVSBaseRequest = getRequestWithLoadInfo(paramrxt);
    if ((localVSBaseRequest != null) && (getParentFragment() != null))
    {
      boolean bool1 = paramrxt.Mi();
      boolean bool2 = localVSBaseRequest.isEnableCache();
      paramrxt = localVSBaseRequest.getCmdName();
      VSNetworkHelper.a().a(getParentFragment().hashCode(), localVSBaseRequest, new ryj(this, paramrxt, localVSBaseRequest, bool1, bool2));
    }
  }
  
  public void notifyLoadingComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int i;
    rxn localrxn;
    if ((getBlockContainer() != null) && (getBlockMerger() != null))
    {
      getLoadInfo().setCurrentState(4);
      getBlockContainer().setRefreshing(false);
      if (isLastPeerBlock())
      {
        if (getItemCount() != 0) {
          break label74;
        }
        i = 1;
        localrxn = getBlockMerger();
        if ((!paramBoolean2) || (i != 0)) {
          break label79;
        }
      }
    }
    label74:
    label79:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      localrxn.ay(paramBoolean1, paramBoolean2);
      return;
      i = 0;
      break;
    }
  }
  
  public void onDoubleClickTitle()
  {
    if ((getBlockContainer() != null) && (getBlockContainer().a() != null)) {
      getBlockContainer().a().scrollToPosition(0);
    }
  }
  
  public void setInitBean(Serializable paramSerializable)
  {
    this.mInitBean = paramSerializable;
  }
  
  public void setInitData(ArrayList<E> paramArrayList)
  {
    setDatas(paramArrayList);
  }
  
  protected void showEmptyView()
  {
    if ((getHostFragment() != null) && (getHostFragment().getBlockContainer() != null)) {
      getHostFragment().getBlockContainer().a().qH(getEmptyHint());
    }
  }
  
  protected void showErrorView(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = acfp.m(2131720624);
    }
    if (getItemCount() > 0) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, str, 1).show();
    }
    while ((getHostFragment() == null) || (getHostFragment().getBlockContainer() == null)) {
      return;
    }
    getHostFragment().getBlockContainer().a().qH(str);
  }
  
  public static class a
    extends RecyclerView.ViewHolder
  {
    public a(BaseWidgetView paramBaseWidgetView)
    {
      super();
    }
    
    public void a(Object paramObject, int paramInt, ExtraTypeInfo paramExtraTypeInfo)
    {
      if ((this.itemView instanceof BaseWidgetView))
      {
        this.itemView.setTag(this);
        ((BaseWidgetView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
        ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryi
 * JD-Core Version:    0.7.0.1
 */