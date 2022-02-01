import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.list.base.PublicListFragment;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public abstract class pbt<E, T>
  extends ryi<E, T>
{
  private static final String TAG = "QCircleBaseListBlock";
  protected ExtraTypeInfo mExtraTypeInfo;
  
  public pbt(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int getStatusBarColor()
  {
    return ovd.rY();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    ouy.a().release();
    ous.clearMemoryCache();
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleBaseListBlock", 1, "onPrepareParams");
    if ((this.mInitBean instanceof QCircleInitBean)) {
      this.mExtraTypeInfo = ((QCircleInitBean)this.mInitBean).getExtraTypeInfo();
    }
  }
  
  public void showEmptyView()
  {
    if ((getHostFragment() != null) && (getHostFragment().getBlockContainer() != null)) {
      ((QCircleStatusView)getHostFragment().getBlockContainer().a()).showEmptyView(getEmptyHint());
    }
  }
  
  protected void showErrorView(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = acfp.m(2131720624);
    }
    QLog.e("QCircleBaseListBlock", 1, " return error！errMsg:" + str);
    if (getItemCount() > 0) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, str, 1).show();
    }
    while ((getHostFragment() == null) || (getHostFragment().getBlockContainer() == null)) {
      return;
    }
    ((QCircleStatusView)getHostFragment().getBlockContainer().a()).showErrorView(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbt
 * JD-Core Version:    0.7.0.1
 */