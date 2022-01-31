import android.graphics.Color;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.biz.qqstory.playvideo.playerwidget.ProgressBarVideoInfoWidget.2;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;
import mqq.os.MqqHandler;

public class twd
  extends AbsVideoInfoWidget
{
  public SplitedProgressBar a;
  @NonNull
  private thk a;
  
  public twd(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int d()
  {
    int i = awmc.b(this.jdField_a_of_type_AndroidViewView.getContext());
    int j = awmc.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int k = awmc.d(this.jdField_a_of_type_AndroidViewView.getContext());
    boolean bool = awmc.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int m = awmc.e(this.jdField_a_of_type_AndroidViewView.getContext());
    int n = awmc.c(this.jdField_a_of_type_AndroidViewView.getContext());
    urk.b("FredguoFix", "hasNavi: " + bool + ", naviHeight " + k);
    urk.b("FredguoFix", "debug: instantWidth " + i + ", instantHeight" + j + ", rawWidth " + m + ", rawHeight " + n);
    urk.b("FredguoFix", "ScreenWidth " + awmc.a + ", ScreenHeight " + awmc.b);
    if (bool) {
      return -2;
    }
    return (int)Math.min(awmc.b - awmc.a / 9.0F * 16.0F, 140.0F);
  }
  
  public String a()
  {
    return "ProgressBarVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)paramView.findViewById(2131313244));
    this.jdField_a_of_type_Thk = new thk(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    if (bjeh.b(b()))
    {
      paramView = (LinearLayout)a().jdField_a_of_type_AndroidViewView.findViewById(2131297823);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = d();
      if (!awmc.a(this.jdField_a_of_type_AndroidViewView.getContext())) {
        paramView.setBackgroundColor(Color.parseColor("#181818"));
      }
      paramView.setLayoutParams(localLayoutParams);
    }
    a(new twe(this));
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void a(@NonNull tnz paramtnz, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(tqg paramtqg)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ProgressBarVideoInfoWidget.2(this, paramtqg));
    }
    if (!this.c)
    {
      h();
      j();
    }
    if (this.jdField_a_of_type_Thk != null) {
      this.jdField_a_of_type_Thk.a(paramtqg);
    }
  }
  
  public boolean a(@NonNull tnz paramtnz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramtnz.a == null) || (paramtnz.a.a != 13);
  }
  
  public int b()
  {
    return 2131495816;
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_Thk.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twd
 * JD-Core Version:    0.7.0.1
 */