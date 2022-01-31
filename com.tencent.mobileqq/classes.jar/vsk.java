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

public class vsk
  extends vua
  implements IEventReceiver, xru, xrw, xwk, xwl
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372176);
  private vsm jdField_a_of_type_Vsm;
  private vsn jdField_a_of_type_Vsn;
  private xrs jdField_a_of_type_Xrs;
  private xvz jdField_a_of_type_Xvz;
  private boolean c;
  
  public vsk(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull vtt paramvtt, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramvtt, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_Vtt.c()) {
      return;
    }
    paramvtt = ((uvx)uwa.a(5)).b(this.jdField_a_of_type_Vtt.a);
    if ((paramvtt != null) && (paramvtt.isPollVideo()))
    {
      if (this.jdField_a_of_type_Xrs == null) {
        this.jdField_a_of_type_Xrs = xrr.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), 1, 1, null);
      }
      vlr.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Xrs, 0, paramvtt);
      vlr.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Xrs, paramInt2, paramvtt);
      return;
    }
    if ((paramvtt != null) && (paramvtt.isInteractVideo()))
    {
      if (this.jdField_a_of_type_Xvz == null) {
        this.jdField_a_of_type_Xvz = new xwj(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      vlq.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Xvz, paramInt2, paramvtt);
      vlq.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Xvz, paramInt2, paramvtt);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void a(xrs paramxrs)
  {
    paramxrs = ((uvx)uwa.a(5)).b(this.jdField_a_of_type_Vtt.a);
    if (paramxrs != null)
    {
      wxj.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { paramxrs.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(xrs paramxrs, xsa paramxsa)
  {
    StoryVideoItem localStoryVideoItem = ((uvx)uwa.a(5)).b(this.jdField_a_of_type_Vtt.a);
    if (localStoryVideoItem == null) {
      return;
    }
    vlr.a(this, this, paramxrs, this.b, this.jdField_a_of_type_Vtt.b, localStoryVideoItem, paramxsa);
  }
  
  public void a(xwj paramxwj)
  {
    paramxwj = ((uvx)uwa.a(5)).b(this.jdField_a_of_type_Vtt.a);
    if (paramxwj != null)
    {
      wxj.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "http://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramxwj.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(xwj paramxwj, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((uvx)uwa.a(5)).b(this.jdField_a_of_type_Vtt.a);
    if (localStoryVideoItem == null)
    {
      wxe.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    vlq.a(this.b, this.jdField_a_of_type_Vtt.b, localStoryVideoItem, paramxwj, paramFloat);
  }
  
  protected void b()
  {
    super.b();
    this.c = true;
    this.jdField_a_of_type_Vsm = new vsm(this);
    this.jdField_a_of_type_Vsn = new vsn(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Vsm);
    umc.a().registerSubscriber(this.jdField_a_of_type_Vsn);
    a(new vsl(this));
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vsk
 * JD-Core Version:    0.7.0.1
 */