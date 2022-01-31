import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.list.QCirclePublicListFragment;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class tys<E, T>
  extends yhy
{
  private static final String TAG = "QCircleBaseListAdapter";
  protected ExtraTypeInfo mExtraTypeInfo;
  protected tyw mLastRspInfo;
  protected QCircleInitBean mQCircleInitBean;
  
  public tys(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void showErrorView(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = alud.a(2131720478);
    }
    QLog.e("QCircleBaseListAdapter", 1, paramString1 + " return error！errMsg:" + str);
    if (getItemCount() > 0) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, str, 1).a();
    }
    while ((getHostFragment() == null) || (getHostFragment().a() == null)) {
      return;
    }
    ((QCircleStatusView)getHostFragment().a().a()).c(str);
  }
  
  public abstract String getDropFrameMonitorTag();
  
  public abstract String getEmptyHint();
  
  public QCirclePublicListFragment getHostFragment()
  {
    if ((getParentFragment() instanceof QCirclePublicListFragment)) {
      return (QCirclePublicListFragment)getParentFragment();
    }
    return null;
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public abstract QCircleBaseRequest getRequest(yii paramyii);
  
  public abstract String getTitle();
  
  public abstract tyw<E> handleResponse(T paramT);
  
  protected void handleResponse(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, T paramT)
  {
    boolean bool = false;
    VSNetworkHelper.a(paramString2);
    if ((!paramBoolean1) || (paramLong != 0L) || (paramT == null))
    {
      showErrorView(paramString1, paramString2);
      notifyLoadingComplete(true, false);
      return;
    }
    paramString2 = handleResponse(paramT);
    paramBoolean1 = bool;
    if (paramString2 != null)
    {
      this.mLastRspInfo = paramString2;
      paramT = paramString2.a();
      paramBoolean1 = paramString2.a();
      if ((paramT == null) || (paramT.size() <= 0)) {
        break label234;
      }
      QLog.d("QCircleBaseListAdapter", 1, paramString1 + "rspData size:" + paramT.size() + " | isFinish:" + paramBoolean1 + " | attachInfo:" + paramString2.a());
      if (!paramBoolean2) {
        break label218;
      }
      addAll(paramT);
      if ((getHostFragment() != null) && (getHostFragment().a() != null))
      {
        getHostFragment().a().a().setVisibility(8);
        getHostFragment().a().a().setVisibility(0);
      }
      getLoadInfo().a(paramBoolean1);
    }
    for (;;)
    {
      notifyLoadingComplete(true, paramBoolean1);
      return;
      label218:
      setDatas(new ArrayList(paramT));
      break;
      label234:
      QLog.e("QCircleBaseListAdapter", 1, "handleListDataRsp() return empty data");
      if (paramBoolean2)
      {
        if (getItemCount() > 0) {
          getLoadInfo().a(paramBoolean1);
        } else {
          QLog.d("QCircleBaseListAdapter", 1, "error state empty data,but execute load more");
        }
      }
      else if ((getHostFragment() != null) && (getHostFragment().a() != null))
      {
        ((QCircleStatusView)getHostFragment().a().a()).b(getEmptyHint());
        clearData();
        notifyDataSetChanged();
      }
    }
  }
  
  public abstract void initTitleBar(View paramView);
  
  public void loadData(yii paramyii)
  {
    QCircleBaseRequest localQCircleBaseRequest = getRequest(paramyii);
    if ((localQCircleBaseRequest != null) && (getHostFragment() != null))
    {
      boolean bool1 = paramyii.e();
      boolean bool2 = localQCircleBaseRequest.isEnableCache();
      paramyii = localQCircleBaseRequest.getCmdName();
      VSNetworkHelper.a().a(getHostFragment().hashCode(), localQCircleBaseRequest, new tyt(this, paramyii, localQCircleBaseRequest, bool1, bool2));
    }
  }
  
  public void notifyLoadingComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int i;
    yib localyib;
    if ((getComponentPageView() != null) && (getParentAdapter() != null))
    {
      getLoadInfo().a(4);
      getComponentPageView().setRefreshing(false);
      if (isLastAdapter())
      {
        if (getItemCount() != 0) {
          break label74;
        }
        i = 1;
        localyib = getParentAdapter();
        if ((!paramBoolean2) || (i != 0)) {
          break label79;
        }
      }
    }
    label74:
    label79:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      localyib.a(paramBoolean1, paramBoolean2);
      return;
      i = 0;
      break;
    }
  }
  
  public void onDoubleClickTitle()
  {
    if ((getComponentPageView() != null) && (getComponentPageView().a() != null)) {
      getComponentPageView().a().scrollToPosition(0);
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setInitBean(QCircleInitBean paramQCircleInitBean)
  {
    this.mQCircleInitBean = paramQCircleInitBean;
  }
  
  public void setInitData(ArrayList<E> paramArrayList)
  {
    setDatas(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tys
 * JD-Core Version:    0.7.0.1
 */