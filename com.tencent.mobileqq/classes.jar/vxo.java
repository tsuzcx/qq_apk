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

public class vxo
  extends AbsVideoInfoWidget
{
  public SplitedProgressBar a;
  @NonNull
  private viv a;
  
  public vxo(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int d()
  {
    int i = azgq.b(this.jdField_a_of_type_AndroidViewView.getContext());
    int j = azgq.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int k = azgq.d(this.jdField_a_of_type_AndroidViewView.getContext());
    boolean bool = azgq.a(this.jdField_a_of_type_AndroidViewView.getContext());
    int m = azgq.e(this.jdField_a_of_type_AndroidViewView.getContext());
    int n = azgq.c(this.jdField_a_of_type_AndroidViewView.getContext());
    wsv.b("FredguoFix", "hasNavi: " + bool + ", naviHeight " + k);
    wsv.b("FredguoFix", "debug: instantWidth " + i + ", instantHeight" + j + ", rawWidth " + m + ", rawHeight " + n);
    wsv.b("FredguoFix", "ScreenWidth " + azgq.a + ", ScreenHeight " + azgq.b);
    if (bool) {
      return -2;
    }
    return (int)Math.min(azgq.b - azgq.a / 9.0F * 16.0F, 140.0F);
  }
  
  public String a()
  {
    return "ProgressBarVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)paramView.findViewById(2131379764));
    this.jdField_a_of_type_Viv = new viv(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    if (bngs.b(b()))
    {
      paramView = (LinearLayout)a().jdField_a_of_type_AndroidViewView.findViewById(2131363407);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = d();
      if (!azgq.a(this.jdField_a_of_type_AndroidViewView.getContext())) {
        paramView.setBackgroundColor(Color.parseColor("#181818"));
      }
      paramView.setLayoutParams(localLayoutParams);
    }
    a(new vxp(this));
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void a(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(vrr paramvrr)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ProgressBarVideoInfoWidget.2(this, paramvrr));
    }
    if (!this.c)
    {
      h();
      j();
    }
    if (this.jdField_a_of_type_Viv != null) {
      this.jdField_a_of_type_Viv.a(paramvrr);
    }
  }
  
  public boolean a(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramvpk.a == null) || (paramvpk.a.a != 13);
  }
  
  public int b()
  {
    return 2131561596;
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_Viv.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxo
 * JD-Core Version:    0.7.0.1
 */