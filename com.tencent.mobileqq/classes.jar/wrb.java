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

public class wrb
  extends wsr
  implements IEventReceiver, ypw, ypy, ytb, ytc
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372834);
  private wrd jdField_a_of_type_Wrd;
  private wre jdField_a_of_type_Wre;
  private ypu jdField_a_of_type_Ypu;
  private ysq jdField_a_of_type_Ysq;
  private boolean c;
  
  public wrb(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull wsk paramwsk, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramwsk, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_Wsk.c()) {
      return;
    }
    paramwsk = ((vuu)vux.a(5)).b(this.jdField_a_of_type_Wsk.a);
    if ((paramwsk != null) && (paramwsk.isPollVideo()))
    {
      if (this.jdField_a_of_type_Ypu == null) {
        this.jdField_a_of_type_Ypu = ypt.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), 1, 1, null);
      }
      wko.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Ypu, 0, paramwsk);
      wko.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Ypu, paramInt2, paramwsk);
      return;
    }
    if ((paramwsk != null) && (paramwsk.isInteractVideo()))
    {
      if (this.jdField_a_of_type_Ysq == null) {
        this.jdField_a_of_type_Ysq = new yta(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      wkn.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Ysq, paramInt2, paramwsk);
      wkn.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Ysq, paramInt2, paramwsk);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void a(ypu paramypu)
  {
    paramypu = ((vuu)vux.a(5)).b(this.jdField_a_of_type_Wsk.a);
    if (paramypu != null)
    {
      xwa.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { paramypu.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(ypu paramypu, yqc paramyqc)
  {
    StoryVideoItem localStoryVideoItem = ((vuu)vux.a(5)).b(this.jdField_a_of_type_Wsk.a);
    if (localStoryVideoItem == null) {
      return;
    }
    wko.a(this, this, paramypu, this.b, this.jdField_a_of_type_Wsk.b, localStoryVideoItem, paramyqc);
  }
  
  public void a(yta paramyta)
  {
    paramyta = ((vuu)vux.a(5)).b(this.jdField_a_of_type_Wsk.a);
    if (paramyta != null)
    {
      xwa.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramyta.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(yta paramyta, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((vuu)vux.a(5)).b(this.jdField_a_of_type_Wsk.a);
    if (localStoryVideoItem == null)
    {
      xvv.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    wkn.a(this.b, this.jdField_a_of_type_Wsk.b, localStoryVideoItem, paramyta, paramFloat);
  }
  
  protected void b()
  {
    super.b();
    this.c = true;
    this.jdField_a_of_type_Wrd = new wrd(this);
    this.jdField_a_of_type_Wre = new wre(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Wrd);
    vli.a().registerSubscriber(this.jdField_a_of_type_Wre);
    a(new wrc(this));
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrb
 * JD-Core Version:    0.7.0.1
 */