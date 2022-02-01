import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.f;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class qiv
  extends AbsVideoInfoWidget
{
  private qiv.b a = new qiv.b();
  private boolean mShouldShow;
  
  public qiv(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public void N(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new qiv.a(this), "");
  }
  
  public qiv.b a()
  {
    return this.a;
  }
  
  public void a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return this.mShouldShow;
  }
  
  public void boA()
  {
    this.mShouldShow = false;
    hide();
    ram.d("Q.qqstory.playernew.LoadingMoreWidget", "hideLoadMore");
  }
  
  public void boz()
  {
    this.mShouldShow = true;
    updateUI();
    ram.d("Q.qqstory.playernew.LoadingMoreWidget", "showLoadMore");
  }
  
  public void dJ(View paramView) {}
  
  public void doOnCreate() {}
  
  public void doOnDestroy() {}
  
  public int getLayoutId()
  {
    return 2131562013;
  }
  
  public String getTag()
  {
    return "LoadingMoreWidget";
  }
  
  public static class a
    extends QQUIEventReceiver<qiv, qiy>
  {
    public a(@NonNull qiv paramqiv)
    {
      super();
    }
    
    public void a(@NonNull qiv paramqiv, @NonNull qiy paramqiy)
    {
      if (paramqiy.b.isSuccess())
      {
        ram.b("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramqiy.toString());
        paramqiv.boA();
      }
    }
    
    public Class acceptEventClass()
    {
      return qiy.class;
    }
  }
  
  public class b
    implements XViewPager.f
  {
    private int AU = rpq.getWindowScreenHeight(BaseApplication.getContext());
    private int bmx = -1;
    private float mh = -1.0F;
    private int scrollPosition = -1;
    
    public b() {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      ram.b("Q.qqstory.playernew.LoadingMoreWidget", "onPageScrollStateChanged newState=%d visible=%d", Integer.valueOf(paramInt), Integer.valueOf(qiv.this.getVisibility()));
      if (qiv.this.getVisibility() != 0) {}
      do
      {
        do
        {
          return;
          if (paramInt == 1)
          {
            this.mh = -1.0F;
            this.scrollPosition = -1;
            this.bmx = -1;
            qiv.this.mItemView.clearAnimation();
            return;
          }
        } while (paramInt != 0);
        if (this.mh < 0.5D)
        {
          qiv.this.mItemView.setTranslationY(0.0F);
          return;
        }
      } while (this.bmx == -1);
      qiv.this.mItemView.setTranslationY(this.AU);
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      if (qiv.this.getVisibility() != 0) {
        return;
      }
      if (this.scrollPosition == -1) {
        this.scrollPosition = paramInt1;
      }
      if (this.scrollPosition != paramInt1)
      {
        this.scrollPosition = paramInt1;
        this.mh = paramFloat;
      }
      if (this.mh > 0.5D)
      {
        qiv.this.mItemView.setTranslationY(this.AU - paramInt2);
        return;
      }
      qiv.this.mItemView.setTranslationY(-paramInt2);
    }
    
    public void onPageSelected(int paramInt)
    {
      if (qiv.this.getVisibility() != 0) {
        return;
      }
      this.bmx = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qiv
 * JD-Core Version:    0.7.0.1
 */