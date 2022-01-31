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

public class tmq
  extends tog
  implements IEventReceiver, vma, vmc, vqq, vqr
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131306141);
  private tms jdField_a_of_type_Tms;
  private tmt jdField_a_of_type_Tmt;
  private vly jdField_a_of_type_Vly;
  private vqf jdField_a_of_type_Vqf;
  private boolean c;
  
  public tmq(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull tnz paramtnz, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramtnz, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_Tnz.c()) {
      return;
    }
    paramtnz = ((sqd)sqg.a(5)).b(this.jdField_a_of_type_Tnz.a);
    if ((paramtnz != null) && (paramtnz.isPollVideo()))
    {
      if (this.jdField_a_of_type_Vly == null) {
        this.jdField_a_of_type_Vly = vlx.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), 1, 1, null);
      }
      tfx.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Vly, 0, paramtnz);
      tfx.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Vly, paramInt2, paramtnz);
      return;
    }
    if ((paramtnz != null) && (paramtnz.isInteractVideo()))
    {
      if (this.jdField_a_of_type_Vqf == null) {
        this.jdField_a_of_type_Vqf = new vqp(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      tfw.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Vqf, paramInt2, paramtnz);
      tfw.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Vqf, paramInt2, paramtnz);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void a(vly paramvly)
  {
    paramvly = ((sqd)sqg.a(5)).b(this.jdField_a_of_type_Tnz.a);
    if (paramvly != null)
    {
      urp.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { paramvly.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(vly paramvly, vmg paramvmg)
  {
    StoryVideoItem localStoryVideoItem = ((sqd)sqg.a(5)).b(this.jdField_a_of_type_Tnz.a);
    if (localStoryVideoItem == null) {
      return;
    }
    tfx.a(this, this, paramvly, this.b, this.jdField_a_of_type_Tnz.b, localStoryVideoItem, paramvmg);
  }
  
  public void a(vqp paramvqp)
  {
    paramvqp = ((sqd)sqg.a(5)).b(this.jdField_a_of_type_Tnz.a);
    if (paramvqp != null)
    {
      urp.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "http://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramvqp.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(vqp paramvqp, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((sqd)sqg.a(5)).b(this.jdField_a_of_type_Tnz.a);
    if (localStoryVideoItem == null)
    {
      urk.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    tfw.a(this.b, this.jdField_a_of_type_Tnz.b, localStoryVideoItem, paramvqp, paramFloat);
  }
  
  protected void b()
  {
    super.b();
    this.c = true;
    this.jdField_a_of_type_Tms = new tms(this);
    this.jdField_a_of_type_Tmt = new tmt(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Tms);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Tmt);
    a(new tmr(this));
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tmq
 * JD-Core Version:    0.7.0.1
 */