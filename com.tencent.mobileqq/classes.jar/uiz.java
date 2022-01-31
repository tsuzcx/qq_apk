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

public class uiz
  extends AbsVideoInfoWidget
{
  public SplitedProgressBar a;
  @NonNull
  private tug a;
  
  public uiz(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int d()
  {
    int i = axli.b(this.jdField_a_of_type_AndroidViewView.getContext());
    int j = axli.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int k = axli.d(this.jdField_a_of_type_AndroidViewView.getContext());
    boolean bool = axli.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int m = axli.e(this.jdField_a_of_type_AndroidViewView.getContext());
    int n = axli.c(this.jdField_a_of_type_AndroidViewView.getContext());
    veg.b("FredguoFix", "hasNavi: " + bool + ", naviHeight " + k);
    veg.b("FredguoFix", "debug: instantWidth " + i + ", instantHeight" + j + ", rawWidth " + m + ", rawHeight " + n);
    veg.b("FredguoFix", "ScreenWidth " + axli.a + ", ScreenHeight " + axli.b);
    if (bool) {
      return -2;
    }
    return (int)Math.min(axli.b - axli.a / 9.0F * 16.0F, 140.0F);
  }
  
  public String a()
  {
    return "ProgressBarVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)paramView.findViewById(2131379080));
    this.jdField_a_of_type_Tug = new tug(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    if (bkur.b(b()))
    {
      paramView = (LinearLayout)a().jdField_a_of_type_AndroidViewView.findViewById(2131363369);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = d();
      if (!axli.a(this.jdField_a_of_type_AndroidViewView.getContext())) {
        paramView.setBackgroundColor(Color.parseColor("#181818"));
      }
      paramView.setLayoutParams(localLayoutParams);
    }
    a(new uja(this));
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void a(@NonNull uav paramuav, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(udc paramudc)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ProgressBarVideoInfoWidget.2(this, paramudc));
    }
    if (!this.c)
    {
      h();
      j();
    }
    if (this.jdField_a_of_type_Tug != null) {
      this.jdField_a_of_type_Tug.a(paramudc);
    }
  }
  
  public boolean a(@NonNull uav paramuav, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramuav.a == null) || (paramuav.a.a != 13);
  }
  
  public int b()
  {
    return 2131561407;
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_Tug.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uiz
 * JD-Core Version:    0.7.0.1
 */