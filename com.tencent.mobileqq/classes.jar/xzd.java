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
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.Map;
import mqq.os.MqqHandler;

public class xzd
  extends AbsVideoInfoWidget
{
  public SplitedProgressBar a;
  @NonNull
  private xkl a;
  
  public xzd(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int d()
  {
    int i = bdep.b(this.jdField_a_of_type_AndroidViewView.getContext());
    int j = bdep.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int k = bdep.d(this.jdField_a_of_type_AndroidViewView.getContext());
    boolean bool = bdep.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int m = bdep.e(this.jdField_a_of_type_AndroidViewView.getContext());
    int n = bdep.c(this.jdField_a_of_type_AndroidViewView.getContext());
    yuk.b("FredguoFix", "hasNavi: " + bool + ", naviHeight " + k);
    yuk.b("FredguoFix", "debug: instantWidth " + i + ", instantHeight" + j + ", rawWidth " + m + ", rawHeight " + n);
    yuk.b("FredguoFix", "ScreenWidth " + bdep.a + ", ScreenHeight " + bdep.b);
    if (bool) {
      return -2;
    }
    return (int)Math.min(bdep.b - bdep.a / 9.0F * 16.0F, 140.0F);
  }
  
  public String a()
  {
    return "ProgressBarVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)paramView.findViewById(2131380958));
    this.jdField_a_of_type_Xkl = new xkl(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    if (LiuHaiUtils.b(b()))
    {
      paramView = (LinearLayout)a().jdField_a_of_type_AndroidViewView.findViewById(2131363625);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = d();
      if (!bdep.a(this.jdField_a_of_type_AndroidViewView.getContext())) {
        paramView.setBackgroundColor(Color.parseColor("#181818"));
      }
      paramView.setLayoutParams(localLayoutParams);
    }
    a(new xze(this));
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(xtg paramxtg)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ProgressBarVideoInfoWidget.2(this, paramxtg));
    }
    if (!this.c)
    {
      h();
      j();
    }
    if (this.jdField_a_of_type_Xkl != null) {
      this.jdField_a_of_type_Xkl.a(paramxtg);
    }
  }
  
  public boolean a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramxqz.a == null) || (paramxqz.a.a != 13);
  }
  
  public int b()
  {
    return 2131561890;
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_Xkl.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzd
 * JD-Core Version:    0.7.0.1
 */