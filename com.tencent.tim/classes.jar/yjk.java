import android.annotation.TargetApi;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.ui.WatchPanelView;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;

public class yjk
  implements yjf
{
  private WatchPanelView a;
  protected boolean bmP;
  protected BaseChatPie c;
  protected QQBlurView c;
  protected ViewGroup dy;
  protected View.OnClickListener mListener;
  
  public yjk(BaseChatPie paramBaseChatPie, View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.mListener = paramOnClickListener;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.dy != null)
    {
      civ();
      return this.dy;
    }
    this.dy = ((ViewGroup)LayoutInflater.from(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2131561205, null));
    civ();
    paramVarArgs = new FrameLayout.LayoutParams(-1, wja.dp2px(56.0F, this.dy.getResources()));
    View localView = this.dy.findViewById(wq());
    if (localView != null) {
      this.dy.removeView(localView);
    }
    a(paramVarArgs);
    return this.dy;
  }
  
  protected void a(FrameLayout.LayoutParams paramLayoutParams)
  {
    this.a = new WatchPanelView(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    this.a.mOnClickListener = this.mListener;
    this.a.setLayoutParams(paramLayoutParams);
    this.a.setId(wq());
    this.a.setOnClickListener(this.mListener);
    this.a.setVisibility(0);
    this.dy.addView(this.a);
  }
  
  public View aR()
  {
    return this.a;
  }
  
  protected void civ()
  {
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.dy.findViewById(2131379973));
    cix();
    if (QLog.isColorLevel()) {
      QLog.d("TogetherTipsBar", 2, "showBlurView() called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    View localView = this.dy.findViewById(2131372754);
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) || (ThemeUtil.isSimpleDayTheme(false)))
    {
      localView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherTipsBar", 2, "showBlurView() visibility called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView)));
      }
      return;
    }
    localView.setBackgroundColor(this.dy.getResources().getColor(2131167278));
    localView.setVisibility(0);
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("TogetherTipsBar", 2, "showBlurView() gone called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView = null;
  }
  
  protected void ciw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherTipsBar", 2, "destroyUI()");
    }
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) {
      this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a.a(null);
    }
    if (this.bmP)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.dy.findViewById(2131379973));
      this.bmP = false;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.onDestroy();
      if (QLog.isColorLevel()) {
        QLog.d("TogetherTipsBar", 2, "destroyBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView)));
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  @TargetApi(19)
  protected void cix()
  {
    if (this.bmP) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView == null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.iD(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mAIORootView);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.iE(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.YI(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.bg(8.0F);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.YK(4);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.onCreate();
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
      this.bmP = true;
    } while (!QLog.isColorLevel());
    QLog.d("TogetherTipsBar", 2, "initBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView)));
  }
  
  public int getType()
  {
    return 26;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000) {
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView != null)
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherTipsBar", 2, "resumeBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView)));
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 1003) {
            break;
          }
        } while (this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView == null);
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.onPause();
      } while (!QLog.isColorLevel());
      QLog.d("TogetherTipsBar", 2, "pauseBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView)));
      return;
    } while (paramInt != 1004);
    ciw();
  }
  
  public int wM()
  {
    return 1;
  }
  
  protected int wq()
  {
    return 2131379972;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjk
 * JD-Core Version:    0.7.0.1
 */