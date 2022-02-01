import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.1;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.2;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.3;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.4;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.5;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.a;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.b;

public class awwp
  extends awwn
{
  private VideoFilterViewPager a;
  
  public awwp(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  public void XQ(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!aOe())) {
      return;
    }
    eHc();
    VideoFilterViewPager localVideoFilterViewPager = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localVideoFilterViewPager.setVisibility(i);
      this.a.setEnabled(paramBoolean);
      return;
    }
  }
  
  public void XR(boolean paramBoolean)
  {
    boolean bool2 = true;
    eHc();
    VideoFilterViewPager localVideoFilterViewPager;
    if (this.a != null)
    {
      localVideoFilterViewPager = this.a;
      if (paramBoolean) {
        break label77;
      }
      bool1 = true;
      localVideoFilterViewPager.setDisableScroll(bool1);
      localVideoFilterViewPager = this.a;
      if (paramBoolean) {
        break label82;
      }
    }
    label77:
    label82:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoFilterViewPager.ZQ(bool1);
      if (this.a != null)
      {
        this.a.setIsNormalMode(paramBoolean);
        if (paramBoolean) {
          break label87;
        }
        this.a.adv(0);
      }
      return;
      bool1 = false;
      break;
    }
    label87:
    this.a.eTQ();
  }
  
  public void XS(boolean paramBoolean)
  {
    eHc();
    this.a.post(new FilterPagerViewStubHolder.3(this, paramBoolean));
  }
  
  public alwq a()
  {
    alwq localalwq = new alwq(null);
    aA(new FilterPagerViewStubHolder.2(this, localalwq));
    return localalwq;
  }
  
  public void a(VideoFilterViewPager.a parama, boolean paramBoolean)
  {
    eHc();
    aA(new FilterPagerViewStubHolder.1(this, parama, paramBoolean));
  }
  
  public void adv(int paramInt)
  {
    aA(new FilterPagerViewStubHolder.5(this, paramInt));
  }
  
  public void clearState()
  {
    if (!aOe()) {
      return;
    }
    this.a.clearState();
  }
  
  public void eHe() {}
  
  protected void jm(View paramView)
  {
    this.a = ((VideoFilterViewPager)paramView.findViewById(2131367272));
  }
  
  public void setSecleteCallBack(VideoFilterViewPager.b paramb)
  {
    aA(new FilterPagerViewStubHolder.4(this, paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwp
 * JD-Core Version:    0.7.0.1
 */