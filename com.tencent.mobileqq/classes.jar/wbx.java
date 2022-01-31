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

public class wbx
  extends AbsVideoInfoWidget
{
  public SplitedProgressBar a;
  @NonNull
  private vne a;
  
  public wbx(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int d()
  {
    int i = azkz.b(this.jdField_a_of_type_AndroidViewView.getContext());
    int j = azkz.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int k = azkz.d(this.jdField_a_of_type_AndroidViewView.getContext());
    boolean bool = azkz.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int m = azkz.e(this.jdField_a_of_type_AndroidViewView.getContext());
    int n = azkz.c(this.jdField_a_of_type_AndroidViewView.getContext());
    wxe.b("FredguoFix", "hasNavi: " + bool + ", naviHeight " + k);
    wxe.b("FredguoFix", "debug: instantWidth " + i + ", instantHeight" + j + ", rawWidth " + m + ", rawHeight " + n);
    wxe.b("FredguoFix", "ScreenWidth " + azkz.a + ", ScreenHeight " + azkz.b);
    if (bool) {
      return -2;
    }
    return (int)Math.min(azkz.b - azkz.a / 9.0F * 16.0F, 140.0F);
  }
  
  public String a()
  {
    return "ProgressBarVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)paramView.findViewById(2131379822));
    this.jdField_a_of_type_Vne = new vne(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    if (bnle.b(b()))
    {
      paramView = (LinearLayout)a().jdField_a_of_type_AndroidViewView.findViewById(2131363407);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = d();
      if (!azkz.a(this.jdField_a_of_type_AndroidViewView.getContext())) {
        paramView.setBackgroundColor(Color.parseColor("#181818"));
      }
      paramView.setLayoutParams(localLayoutParams);
    }
    a(new wby(this));
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void a(@NonNull vtt paramvtt, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(vwa paramvwa)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ProgressBarVideoInfoWidget.2(this, paramvwa));
    }
    if (!this.c)
    {
      h();
      j();
    }
    if (this.jdField_a_of_type_Vne != null) {
      this.jdField_a_of_type_Vne.a(paramvwa);
    }
  }
  
  public boolean a(@NonNull vtt paramvtt, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramvtt.a == null) || (paramvtt.a.a != 13);
  }
  
  public int b()
  {
    return 2131561614;
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_Vne.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbx
 * JD-Core Version:    0.7.0.1
 */