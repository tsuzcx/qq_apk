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

public class qnv
  extends AbsVideoInfoWidget
{
  public SplitedProgressBar a;
  @NonNull
  private qfm a;
  
  public qnv(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int sE()
  {
    int i = ankt.aD(this.mItemView.getContext());
    int j = ankt.aC(this.mItemView.getContext());
    int k = ankt.getNavigationBarHeight(this.mItemView.getContext());
    boolean bool = ankt.bA(this.mItemView.getContext());
    int m = ankt.aE(this.mItemView.getContext());
    int n = ankt.getRealHeight(this.mItemView.getContext());
    ram.d("FredguoFix", "hasNavi: " + bool + ", naviHeight " + k);
    ram.d("FredguoFix", "debug: instantWidth " + i + ", instantHeight" + j + ", rawWidth " + m + ", rawHeight " + n);
    ram.d("FredguoFix", "ScreenWidth " + ankt.SCREEN_WIDTH + ", ScreenHeight " + ankt.cIE);
    if (bool) {
      return -2;
    }
    return (int)Math.min(ankt.cIE - ankt.SCREEN_WIDTH / 9.0F * 16.0F, 140.0F);
  }
  
  public void N(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(qlb paramqlb)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ProgressBarVideoInfoWidget.2(this, paramqlb));
    }
    if (!this.aEq)
    {
      bpl();
      show();
    }
    if (this.jdField_a_of_type_Qfm != null) {
      this.jdField_a_of_type_Qfm.a(paramqlb);
    }
  }
  
  public boolean a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramqjq.h == null) || (paramqjq.h.nodeType != 13);
  }
  
  public void dJ(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)paramView.findViewById(2131381811));
    this.jdField_a_of_type_Qfm = new qfm(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    if (ayxa.hasNotchInScreenByVersion(getActivity()))
    {
      paramView = (LinearLayout)a().mItemView.findViewById(2131363674);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = sE();
      if (!ankt.bA(this.mItemView.getContext())) {
        paramView.setBackgroundColor(Color.parseColor("#181818"));
      }
      paramView.setLayoutParams(localLayoutParams);
    }
    a(new qnw(this));
  }
  
  public void doOnCreate() {}
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Qfm.bod();
  }
  
  public int getLayoutId()
  {
    return 2131562007;
  }
  
  public String getTag()
  {
    return "ProgressBarVideoInfoWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qnv
 * JD-Core Version:    0.7.0.1
 */