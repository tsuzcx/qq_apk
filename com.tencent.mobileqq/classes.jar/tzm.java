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

public class tzm
  extends ubc
  implements IEventReceiver, vyw, vyy, wdm, wdn
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371838);
  private tzo jdField_a_of_type_Tzo;
  private tzp jdField_a_of_type_Tzp;
  private vyu jdField_a_of_type_Vyu;
  private wdb jdField_a_of_type_Wdb;
  private boolean c;
  
  public tzm(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull uav paramuav, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramuav, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_Uav.c()) {
      return;
    }
    paramuav = ((tcz)tdc.a(5)).b(this.jdField_a_of_type_Uav.a);
    if ((paramuav != null) && (paramuav.isPollVideo()))
    {
      if (this.jdField_a_of_type_Vyu == null) {
        this.jdField_a_of_type_Vyu = vyt.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), 1, 1, null);
      }
      tst.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Vyu, 0, paramuav);
      tst.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Vyu, paramInt2, paramuav);
      return;
    }
    if ((paramuav != null) && (paramuav.isInteractVideo()))
    {
      if (this.jdField_a_of_type_Wdb == null) {
        this.jdField_a_of_type_Wdb = new wdl(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      tss.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Wdb, paramInt2, paramuav);
      tss.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Wdb, paramInt2, paramuav);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void a(vyu paramvyu)
  {
    paramvyu = ((tcz)tdc.a(5)).b(this.jdField_a_of_type_Uav.a);
    if (paramvyu != null)
    {
      vel.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { paramvyu.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(vyu paramvyu, vzc paramvzc)
  {
    StoryVideoItem localStoryVideoItem = ((tcz)tdc.a(5)).b(this.jdField_a_of_type_Uav.a);
    if (localStoryVideoItem == null) {
      return;
    }
    tst.a(this, this, paramvyu, this.b, this.jdField_a_of_type_Uav.b, localStoryVideoItem, paramvzc);
  }
  
  public void a(wdl paramwdl)
  {
    paramwdl = ((tcz)tdc.a(5)).b(this.jdField_a_of_type_Uav.a);
    if (paramwdl != null)
    {
      vel.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "http://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramwdl.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(wdl paramwdl, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((tcz)tdc.a(5)).b(this.jdField_a_of_type_Uav.a);
    if (localStoryVideoItem == null)
    {
      veg.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    tss.a(this.b, this.jdField_a_of_type_Uav.b, localStoryVideoItem, paramwdl, paramFloat);
  }
  
  protected void b()
  {
    super.b();
    this.c = true;
    this.jdField_a_of_type_Tzo = new tzo(this);
    this.jdField_a_of_type_Tzp = new tzp(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Tzo);
    ste.a().registerSubscriber(this.jdField_a_of_type_Tzp);
    a(new tzn(this));
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzm
 * JD-Core Version:    0.7.0.1
 */