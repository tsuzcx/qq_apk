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

public class xfw
  extends xhm
  implements IEventReceiver, zep, zer, zhu, zhv
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373028);
  private xfy jdField_a_of_type_Xfy;
  private xfz jdField_a_of_type_Xfz;
  private zen jdField_a_of_type_Zen;
  private zhj jdField_a_of_type_Zhj;
  private boolean c;
  
  public xfw(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull xhf paramxhf, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramxhf, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_Xhf.c()) {
      return;
    }
    paramxhf = ((wjp)wjs.a(5)).b(this.jdField_a_of_type_Xhf.a);
    if ((paramxhf != null) && (paramxhf.isPollVideo()))
    {
      if (this.jdField_a_of_type_Zen == null) {
        this.jdField_a_of_type_Zen = zem.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), 1, 1, null);
      }
      wzj.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Zen, 0, paramxhf);
      wzj.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Zen, paramInt2, paramxhf);
      return;
    }
    if ((paramxhf != null) && (paramxhf.isInteractVideo()))
    {
      if (this.jdField_a_of_type_Zhj == null) {
        this.jdField_a_of_type_Zhj = new zht(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      wzi.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Zhj, paramInt2, paramxhf);
      wzi.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Zhj, paramInt2, paramxhf);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void a(zen paramzen)
  {
    paramzen = ((wjp)wjs.a(5)).b(this.jdField_a_of_type_Xhf.a);
    if (paramzen != null)
    {
      ykv.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { paramzen.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(zen paramzen, zev paramzev)
  {
    StoryVideoItem localStoryVideoItem = ((wjp)wjs.a(5)).b(this.jdField_a_of_type_Xhf.a);
    if (localStoryVideoItem == null) {
      return;
    }
    wzj.a(this, this, paramzen, this.b, this.jdField_a_of_type_Xhf.b, localStoryVideoItem, paramzev);
  }
  
  public void a(zht paramzht)
  {
    paramzht = ((wjp)wjs.a(5)).b(this.jdField_a_of_type_Xhf.a);
    if (paramzht != null)
    {
      ykv.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramzht.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(zht paramzht, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((wjp)wjs.a(5)).b(this.jdField_a_of_type_Xhf.a);
    if (localStoryVideoItem == null)
    {
      ykq.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    wzi.a(this.b, this.jdField_a_of_type_Xhf.b, localStoryVideoItem, paramzht, paramFloat);
  }
  
  protected void b()
  {
    super.b();
    this.c = true;
    this.jdField_a_of_type_Xfy = new xfy(this);
    this.jdField_a_of_type_Xfz = new xfz(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xfy);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xfz);
    a(new xfx(this));
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfw
 * JD-Core Version:    0.7.0.1
 */