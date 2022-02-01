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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tribe.async.dispatch.Subscriber;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.Map;
import mqq.os.MqqHandler;

public class xao
  extends AbsVideoInfoWidget
{
  public SplitedProgressBar a;
  @NonNull
  private wlw a;
  
  public xao(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int d()
  {
    int i = ScreenUtil.getInstantScreenWidth(this.jdField_a_of_type_AndroidViewView.getContext());
    int j = ScreenUtil.getInstantScreenHeight(this.jdField_a_of_type_AndroidViewView.getContext());
    int k = ScreenUtil.getNavigationBarHeight(this.jdField_a_of_type_AndroidViewView.getContext());
    boolean bool = ScreenUtil.checkDeviceHasNavigationBar(this.jdField_a_of_type_AndroidViewView.getContext());
    int m = ScreenUtil.getRealWidth(this.jdField_a_of_type_AndroidViewView.getContext());
    int n = ScreenUtil.getRealHeight(this.jdField_a_of_type_AndroidViewView.getContext());
    xvv.b("FredguoFix", "hasNavi: " + bool + ", naviHeight " + k);
    xvv.b("FredguoFix", "debug: instantWidth " + i + ", instantHeight" + j + ", rawWidth " + m + ", rawHeight " + n);
    xvv.b("FredguoFix", "ScreenWidth " + ScreenUtil.SCREEN_WIDTH + ", ScreenHeight " + ScreenUtil.SCREEN_HIGHT);
    if (bool) {
      return -2;
    }
    return (int)Math.min(ScreenUtil.SCREEN_HIGHT - ScreenUtil.SCREEN_WIDTH / 9.0F * 16.0F, 140.0F);
  }
  
  public String a()
  {
    return "ProgressBarVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)paramView.findViewById(2131380684));
    this.jdField_a_of_type_Wlw = new wlw(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    if (LiuHaiUtils.b(b()))
    {
      paramView = (LinearLayout)a().jdField_a_of_type_AndroidViewView.findViewById(2131363657);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = d();
      if (!ScreenUtil.checkDeviceHasNavigationBar(this.jdField_a_of_type_AndroidViewView.getContext())) {
        paramView.setBackgroundColor(Color.parseColor("#181818"));
      }
      paramView.setLayoutParams(localLayoutParams);
    }
    a(new xap(this));
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void a(@NonNull wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(wur paramwur)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ProgressBarVideoInfoWidget.2(this, paramwur));
    }
    if (!this.c)
    {
      h();
      j();
    }
    if (this.jdField_a_of_type_Wlw != null) {
      this.jdField_a_of_type_Wlw.a(paramwur);
    }
  }
  
  public boolean a(@NonNull wsk paramwsk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramwsk.a == null) || (paramwsk.a.a != 13);
  }
  
  public int b()
  {
    return 2131561767;
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_Wlw.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xao
 * JD-Core Version:    0.7.0.1
 */