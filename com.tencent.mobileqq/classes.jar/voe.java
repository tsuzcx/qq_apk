import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.list.base.PublicListInnerFragment;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public abstract class voe<E, T>
  extends zyv<E, T>
  implements zxl<QCircleReportBean>
{
  protected ExtraTypeInfo mExtraTypeInfo;
  private QCircleReportBean mReportBean;
  
  public voe(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected void assembleFromReportData()
  {
    if ((getHostFragment() == null) || (getActivity() == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getHostFragment().getActivity().getIntent();
      } while ((localObject == null) || (!((Intent)localObject).hasExtra("public_list_init_bean")));
      localObject = (QCircleInitBean)((Intent)localObject).getSerializableExtra("public_list_init_bean");
    } while ((localObject == null) || (((QCircleInitBean)localObject).mFromReportBean == null) || (this.mReportBean == null));
    this.mReportBean.assembleFromReportData(((QCircleInitBean)localObject).mFromReportBean);
  }
  
  protected QCircleStatusView createStatusView()
  {
    QCircleFullScreenStatusView localQCircleFullScreenStatusView = new QCircleFullScreenStatusView(getContext());
    localQCircleFullScreenStatusView.setEmptyImageUrls("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_relationship.png", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/1-fullscreen/text_fullscreen_01.png", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/3-action/link_fullscreen_noaction.png");
    return localQCircleFullScreenStatusView;
  }
  
  protected int getPageId()
  {
    return QCircleReportBean.getPageId(getLogTag(), this.mReportBean);
  }
  
  public abstract String getPageIdStr();
  
  protected int getParentPageId()
  {
    return QCircleReportBean.getParentPageId(getLogTag(), this.mReportBean);
  }
  
  public QCircleReportBean getReportBean()
  {
    if (this.mReportBean == null) {
      this.mReportBean = new QCircleReportBean();
    }
    assembleFromReportData();
    return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
  }
  
  public int getStatusBarColor()
  {
    return uxx.a();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    uxp.a().a();
    uxh.a();
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d(getLogTag(), 1, "onPrepareParams");
    getBlockContainer().setStatusView(createStatusView());
    if ((this.mInitBean instanceof QCircleInitBean)) {
      this.mExtraTypeInfo = ((QCircleInitBean)this.mInitBean).getExtraTypeInfo();
    }
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), paramQCircleReportBean);
  }
  
  public void showEmptyView()
  {
    if ((getHostFragment() != null) && (getHostFragment().a() != null)) {
      ((QCircleStatusView)getHostFragment().a().a()).a(getEmptyHint());
    }
  }
  
  protected void showErrorView(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = anni.a(2131718323);
      QLog.e(getLogTag(), 1, " return error！errMsg:" + paramString);
      if (getItemCount() <= 0) {
        break label61;
      }
      vtt.a(paramLong, BaseApplicationImpl.getContext(), 1, paramString, 1);
    }
    label61:
    while ((getHostFragment() == null) || (getHostFragment().a() == null))
    {
      return;
      break;
    }
    ((QCircleStatusView)getHostFragment().a().a()).b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voe
 * JD-Core Version:    0.7.0.1
 */