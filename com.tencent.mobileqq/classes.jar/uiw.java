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

public class uiw
  extends AbsVideoInfoWidget
{
  public SplitedProgressBar a;
  @NonNull
  private tud a;
  
  public uiw(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int d()
  {
    int i = axlk.b(this.jdField_a_of_type_AndroidViewView.getContext());
    int j = axlk.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int k = axlk.d(this.jdField_a_of_type_AndroidViewView.getContext());
    boolean bool = axlk.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int m = axlk.e(this.jdField_a_of_type_AndroidViewView.getContext());
    int n = axlk.c(this.jdField_a_of_type_AndroidViewView.getContext());
    ved.b("FredguoFix", "hasNavi: " + bool + ", naviHeight " + k);
    ved.b("FredguoFix", "debug: instantWidth " + i + ", instantHeight" + j + ", rawWidth " + m + ", rawHeight " + n);
    ved.b("FredguoFix", "ScreenWidth " + axlk.a + ", ScreenHeight " + axlk.b);
    if (bool) {
      return -2;
    }
    return (int)Math.min(axlk.b - axlk.a / 9.0F * 16.0F, 140.0F);
  }
  
  public String a()
  {
    return "ProgressBarVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)paramView.findViewById(2131379085));
    this.jdField_a_of_type_Tud = new tud(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    if (bkvi.b(b()))
    {
      paramView = (LinearLayout)a().jdField_a_of_type_AndroidViewView.findViewById(2131363368);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = d();
      if (!axlk.a(this.jdField_a_of_type_AndroidViewView.getContext())) {
        paramView.setBackgroundColor(Color.parseColor("#181818"));
      }
      paramView.setLayoutParams(localLayoutParams);
    }
    a(new uix(this));
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(ucz paramucz)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ProgressBarVideoInfoWidget.2(this, paramucz));
    }
    if (!this.c)
    {
      h();
      j();
    }
    if (this.jdField_a_of_type_Tud != null) {
      this.jdField_a_of_type_Tud.a(paramucz);
    }
  }
  
  public boolean a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramuas.a == null) || (paramuas.a.a != 13);
  }
  
  public int b()
  {
    return 2131561406;
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_Tud.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uiw
 * JD-Core Version:    0.7.0.1
 */