import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.demo.DemoBaseWidgetView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;

public class ryc
  extends ryh
{
  private BaseWidgetView a;
  
  public ryc(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void biW()
  {
    this.a.setData(null);
    setShareData("share_key_subscribe_user", new rxn.b(new ExtraTypeInfo()));
    notifyLoadingComplete(true);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
  {
    this.a = new DemoBaseWidgetView(getContext());
    return this.a;
  }
  
  protected void handleBlockChange(rxq paramrxq, int paramInt)
  {
    super.handleBlockChange(paramrxq, paramInt);
  }
  
  public void handleShareDataChange(String paramString, rxn.b paramb)
  {
    super.handleShareDataChange(paramString, paramb);
  }
  
  public boolean isEnableRefresh()
  {
    return false;
  }
  
  public void loadData(rxt paramrxt)
  {
    if ((paramrxt.Mh()) || (paramrxt.Mg())) {
      biW();
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    ((rxz)getViewModel(rxz.class)).s().observe((QCircleBaseFragment)getParentFragment(), new ryd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryc
 * JD-Core Version:    0.7.0.1
 */