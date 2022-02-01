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

public class xvi
  extends AbsVideoInfoWidget
{
  public SplitedProgressBar a;
  @NonNull
  private xgq a;
  
  public xvi(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int d()
  {
    int i = bclx.b(this.jdField_a_of_type_AndroidViewView.getContext());
    int j = bclx.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int k = bclx.d(this.jdField_a_of_type_AndroidViewView.getContext());
    boolean bool = bclx.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int m = bclx.e(this.jdField_a_of_type_AndroidViewView.getContext());
    int n = bclx.c(this.jdField_a_of_type_AndroidViewView.getContext());
    yqp.b("FredguoFix", "hasNavi: " + bool + ", naviHeight " + k);
    yqp.b("FredguoFix", "debug: instantWidth " + i + ", instantHeight" + j + ", rawWidth " + m + ", rawHeight " + n);
    yqp.b("FredguoFix", "ScreenWidth " + bclx.a + ", ScreenHeight " + bclx.b);
    if (bool) {
      return -2;
    }
    return (int)Math.min(bclx.b - bclx.a / 9.0F * 16.0F, 140.0F);
  }
  
  public String a()
  {
    return "ProgressBarVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)paramView.findViewById(2131380781));
    this.jdField_a_of_type_Xgq = new xgq(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    if (bqcd.b(b()))
    {
      paramView = (LinearLayout)a().jdField_a_of_type_AndroidViewView.findViewById(2131363601);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = d();
      if (!bclx.a(this.jdField_a_of_type_AndroidViewView.getContext())) {
        paramView.setBackgroundColor(Color.parseColor("#181818"));
      }
      paramView.setLayoutParams(localLayoutParams);
    }
    a(new xvj(this));
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void a(@NonNull xne paramxne, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(xpl paramxpl)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ProgressBarVideoInfoWidget.2(this, paramxpl));
    }
    if (!this.c)
    {
      h();
      j();
    }
    if (this.jdField_a_of_type_Xgq != null) {
      this.jdField_a_of_type_Xgq.a(paramxpl);
    }
  }
  
  public boolean a(@NonNull xne paramxne, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramxne.a == null) || (paramxne.a.a != 13);
  }
  
  public int b()
  {
    return 2131561849;
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_Xgq.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvi
 * JD-Core Version:    0.7.0.1
 */