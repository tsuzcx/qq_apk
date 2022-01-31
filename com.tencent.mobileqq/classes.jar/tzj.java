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

public class tzj
  extends uaz
  implements IEventReceiver, vyt, vyv, wdj, wdk
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371838);
  private tzl jdField_a_of_type_Tzl;
  private tzm jdField_a_of_type_Tzm;
  private vyr jdField_a_of_type_Vyr;
  private wcy jdField_a_of_type_Wcy;
  private boolean c;
  
  public tzj(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull uas paramuas, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramuas, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_Uas.c()) {
      return;
    }
    paramuas = ((tcw)tcz.a(5)).b(this.jdField_a_of_type_Uas.a);
    if ((paramuas != null) && (paramuas.isPollVideo()))
    {
      if (this.jdField_a_of_type_Vyr == null) {
        this.jdField_a_of_type_Vyr = vyq.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), 1, 1, null);
      }
      tsq.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Vyr, 0, paramuas);
      tsq.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Vyr, paramInt2, paramuas);
      return;
    }
    if ((paramuas != null) && (paramuas.isInteractVideo()))
    {
      if (this.jdField_a_of_type_Wcy == null) {
        this.jdField_a_of_type_Wcy = new wdi(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      tsp.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Wcy, paramInt2, paramuas);
      tsp.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Wcy, paramInt2, paramuas);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void a(vyr paramvyr)
  {
    paramvyr = ((tcw)tcz.a(5)).b(this.jdField_a_of_type_Uas.a);
    if (paramvyr != null)
    {
      vei.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { paramvyr.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(vyr paramvyr, vyz paramvyz)
  {
    StoryVideoItem localStoryVideoItem = ((tcw)tcz.a(5)).b(this.jdField_a_of_type_Uas.a);
    if (localStoryVideoItem == null) {
      return;
    }
    tsq.a(this, this, paramvyr, this.b, this.jdField_a_of_type_Uas.b, localStoryVideoItem, paramvyz);
  }
  
  public void a(wdi paramwdi)
  {
    paramwdi = ((tcw)tcz.a(5)).b(this.jdField_a_of_type_Uas.a);
    if (paramwdi != null)
    {
      vei.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "http://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramwdi.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(wdi paramwdi, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((tcw)tcz.a(5)).b(this.jdField_a_of_type_Uas.a);
    if (localStoryVideoItem == null)
    {
      ved.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    tsp.a(this.b, this.jdField_a_of_type_Uas.b, localStoryVideoItem, paramwdi, paramFloat);
  }
  
  protected void b()
  {
    super.b();
    this.c = true;
    this.jdField_a_of_type_Tzl = new tzl(this);
    this.jdField_a_of_type_Tzm = new tzm(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Tzl);
    stb.a().registerSubscriber(this.jdField_a_of_type_Tzm);
    a(new tzk(this));
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzj
 * JD-Core Version:    0.7.0.1
 */