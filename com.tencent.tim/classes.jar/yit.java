import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;

public class yit
  extends yjk
{
  MusicPanelView a;
  
  public yit(BaseChatPie paramBaseChatPie, View.OnClickListener paramOnClickListener)
  {
    super(paramBaseChatPie, paramOnClickListener);
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    return super.a(paramVarArgs);
  }
  
  protected void a(FrameLayout.LayoutParams paramLayoutParams)
  {
    this.a = new MusicPanelView(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    this.a.setOnClickListener(this.mListener);
    this.a.setLayoutParams(paramLayoutParams);
    this.a.setId(wq());
    this.a.mOnClickListener = this.mListener;
    this.a.setVisibility(0);
    this.a.setOnTouchListener(jll.a);
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
      QLog.d("ListenTogetherTipBar", 2, "showBlurView() called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    QLog.d("ListenTogetherTipBar", 1, new Object[] { "stack......\n", Log.getStackTraceString(new Throwable()) });
    if (aogk.a().azB()) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    }
    View localView;
    do
    {
      return;
      localView = this.dy.findViewById(2131372754);
      if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false))) {
        break;
      }
      localView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    } while (!QLog.isColorLevel());
    QLog.d("ListenTogetherTipBar", 2, "showBlurView() visibility called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView)));
    return;
    localView.setBackgroundColor(this.dy.getResources().getColor(2131167278));
    localView.setVisibility(0);
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherTipBar", 2, "showBlurView() gone called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.onDestroy();
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView = null;
  }
  
  protected void ciw()
  {
    super.ciw();
    if (this.a != null) {}
  }
  
  public int getType()
  {
    return 26;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    super.h(paramInt, paramVarArgs);
  }
  
  public int wM()
  {
    return 1;
  }
  
  public int wq()
  {
    return 2131370582;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yit
 * JD-Core Version:    0.7.0.1
 */