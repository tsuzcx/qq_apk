import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.Locale;

public class xpq
  extends xrg
  implements IEventReceiver, zpa, zpc, ztq, ztr
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372866);
  private xps jdField_a_of_type_Xps;
  private xpt jdField_a_of_type_Xpt;
  private zoy jdField_a_of_type_Zoy;
  private ztf jdField_a_of_type_Ztf;
  private boolean c;
  
  public xpq(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull xqz paramxqz, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramxqz, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_Xqz.c()) {
      return;
    }
    paramxqz = ((wte)wth.a(5)).b(this.jdField_a_of_type_Xqz.a);
    if ((paramxqz != null) && (paramxqz.isPollVideo()))
    {
      if (this.jdField_a_of_type_Zoy == null) {
        this.jdField_a_of_type_Zoy = zox.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), 1, 1, null);
      }
      xiy.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Zoy, 0, paramxqz);
      xiy.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Zoy, paramInt2, paramxqz);
      return;
    }
    if ((paramxqz != null) && (paramxqz.isInteractVideo()))
    {
      if (this.jdField_a_of_type_Ztf == null) {
        this.jdField_a_of_type_Ztf = new ztp(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      xix.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Ztf, paramInt2, paramxqz);
      xix.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Ztf, paramInt2, paramxqz);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void a(zoy paramzoy)
  {
    paramzoy = ((wte)wth.a(5)).b(this.jdField_a_of_type_Xqz.a);
    if (paramzoy != null)
    {
      yup.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { paramzoy.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(zoy paramzoy, zpg paramzpg)
  {
    StoryVideoItem localStoryVideoItem = ((wte)wth.a(5)).b(this.jdField_a_of_type_Xqz.a);
    if (localStoryVideoItem == null) {
      return;
    }
    xiy.a(this, this, paramzoy, this.b, this.jdField_a_of_type_Xqz.b, localStoryVideoItem, paramzpg);
  }
  
  public void a(ztp paramztp)
  {
    paramztp = ((wte)wth.a(5)).b(this.jdField_a_of_type_Xqz.a);
    if (paramztp != null)
    {
      yup.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramztp.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(ztp paramztp, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((wte)wth.a(5)).b(this.jdField_a_of_type_Xqz.a);
    if (localStoryVideoItem == null)
    {
      yuk.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    xix.a(this.b, this.jdField_a_of_type_Xqz.b, localStoryVideoItem, paramztp, paramFloat);
  }
  
  protected void b()
  {
    super.b();
    this.c = true;
    this.jdField_a_of_type_Xps = new xps(this);
    this.jdField_a_of_type_Xpt = new xpt(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Xps);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Xpt);
    a(new xpr(this));
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpq
 * JD-Core Version:    0.7.0.1
 */