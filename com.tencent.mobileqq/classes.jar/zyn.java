import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.demo.DemoBaseWidgetView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;

public class zyn
  extends zyu
{
  private BaseWidgetView a;
  
  public zyn(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a()
  {
    this.a.setData(null);
    setShareData("share_key_subscribe_user", new zxs(new ExtraTypeInfo()));
    notifyLoadingComplete(true);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, zxu paramzxu)
  {
    this.a = new DemoBaseWidgetView(getContext());
    return this.a;
  }
  
  protected void handleBlockChange(zxu paramzxu, int paramInt)
  {
    super.handleBlockChange(paramzxu, paramInt);
  }
  
  public void handleShareDataChange(String paramString, zxs paramzxs)
  {
    super.handleShareDataChange(paramString, paramzxs);
  }
  
  public boolean isEnableRefresh()
  {
    return false;
  }
  
  public void loadData(zxz paramzxz)
  {
    if ((paramzxz.d()) || (paramzxz.c())) {
      a();
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
    ((zyk)getViewModel(zyk.class)).a().observe((QCircleBaseFragment)getParentFragment(), new zyo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyn
 * JD-Core Version:    0.7.0.1
 */