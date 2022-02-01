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

public class xlv
  extends xnl
  implements IEventReceiver, zlf, zlh, zpv, zpw
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372754);
  private xlx jdField_a_of_type_Xlx;
  private xly jdField_a_of_type_Xly;
  private zld jdField_a_of_type_Zld;
  private zpk jdField_a_of_type_Zpk;
  private boolean c;
  
  public xlv(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull xne paramxne, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramxne, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_Xne.c()) {
      return;
    }
    paramxne = ((wpj)wpm.a(5)).b(this.jdField_a_of_type_Xne.a);
    if ((paramxne != null) && (paramxne.isPollVideo()))
    {
      if (this.jdField_a_of_type_Zld == null) {
        this.jdField_a_of_type_Zld = zlc.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), 1, 1, null);
      }
      xfd.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Zld, 0, paramxne);
      xfd.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Zld, paramInt2, paramxne);
      return;
    }
    if ((paramxne != null) && (paramxne.isInteractVideo()))
    {
      if (this.jdField_a_of_type_Zpk == null) {
        this.jdField_a_of_type_Zpk = new zpu(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      xfc.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Zpk, paramInt2, paramxne);
      xfc.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Zpk, paramInt2, paramxne);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void a(zld paramzld)
  {
    paramzld = ((wpj)wpm.a(5)).b(this.jdField_a_of_type_Xne.a);
    if (paramzld != null)
    {
      yqu.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { paramzld.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(zld paramzld, zll paramzll)
  {
    StoryVideoItem localStoryVideoItem = ((wpj)wpm.a(5)).b(this.jdField_a_of_type_Xne.a);
    if (localStoryVideoItem == null) {
      return;
    }
    xfd.a(this, this, paramzld, this.b, this.jdField_a_of_type_Xne.b, localStoryVideoItem, paramzll);
  }
  
  public void a(zpu paramzpu)
  {
    paramzpu = ((wpj)wpm.a(5)).b(this.jdField_a_of_type_Xne.a);
    if (paramzpu != null)
    {
      yqu.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramzpu.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(zpu paramzpu, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((wpj)wpm.a(5)).b(this.jdField_a_of_type_Xne.a);
    if (localStoryVideoItem == null)
    {
      yqp.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    xfc.a(this.b, this.jdField_a_of_type_Xne.b, localStoryVideoItem, paramzpu, paramFloat);
  }
  
  protected void b()
  {
    super.b();
    this.c = true;
    this.jdField_a_of_type_Xlx = new xlx(this);
    this.jdField_a_of_type_Xly = new xly(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Xlx);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Xly);
    a(new xlw(this));
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlv
 * JD-Core Version:    0.7.0.1
 */