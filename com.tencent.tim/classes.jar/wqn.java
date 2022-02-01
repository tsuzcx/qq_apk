import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class wqn
{
  private final String TAG = "VoiceTextEditStateHelper";
  private VoiceTextEditPanel b;
  private int bQJ;
  private ViewGroup df;
  protected ViewGroup dg;
  private PopupWindow jdField_e_of_type_AndroidWidgetPopupWindow;
  private BaseChatPie jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  private void caX()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("showEditStatusMask topMaskPanel is nll = ");
      if (this.jdField_e_of_type_AndroidWidgetPopupWindow != null) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VoiceTextEditStateHelper", 2, bool);
      fr(this.b.getRight() - this.b.getLeft(), ImmersiveUtils.getStatusBarHeight(this.b.getContext()) + this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.a.getBottom());
      return;
    }
  }
  
  private void caY()
  {
    this.jdField_e_of_type_AndroidWidgetPopupWindow.getContentView().setOnTouchListener(new wqo(this));
  }
  
  public void CA(int paramInt)
  {
    this.bQJ = paramInt;
  }
  
  public void a(ViewGroup paramViewGroup1, VoiceTextEditPanel paramVoiceTextEditPanel, ViewGroup paramViewGroup2, BaseChatPie paramBaseChatPie)
  {
    this.dg = paramViewGroup1;
    this.b = paramVoiceTextEditPanel;
    this.df = paramViewGroup2;
    this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void caW()
  {
    if (this.bQJ == 1) {
      this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.wa(false);
    }
    while (this.bQJ != 2) {
      return;
    }
    this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.hideAllPanels();
  }
  
  public void caz()
  {
    this.jdField_e_of_type_AndroidWidgetPopupWindow = AudioPanel.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("dismissTopMaskPanel topMaskPanel is nll = ");
      if (this.jdField_e_of_type_AndroidWidgetPopupWindow != null) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VoiceTextEditStateHelper", 2, bool);
      if ((this.jdField_e_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_e_of_type_AndroidWidgetPopupWindow.isShowing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEditStateHelper", 2, "dismissTopMaskPanel");
        }
        this.jdField_e_of_type_AndroidWidgetPopupWindow.dismiss();
        this.jdField_e_of_type_AndroidWidgetPopupWindow = null;
      }
      return;
    }
  }
  
  public void fr(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("initMask topMaskPanel is nll = ");
      if (this.jdField_e_of_type_AndroidWidgetPopupWindow == null)
      {
        bool = true;
        QLog.d("VoiceTextEditStateHelper", 2, bool + " isExit =" + this.b.bfo);
      }
    }
    else
    {
      if (!this.b.bfo) {
        break label75;
      }
    }
    label75:
    do
    {
      return;
      bool = false;
      break;
      this.jdField_e_of_type_AndroidWidgetPopupWindow = AudioPanel.a();
      caY();
      if ((this.jdField_e_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_e_of_type_AndroidWidgetPopupWindow.isShowing())) {
        break label126;
      }
    } while (paramInt2 == this.jdField_e_of_type_AndroidWidgetPopupWindow.getHeight());
    this.jdField_e_of_type_AndroidWidgetPopupWindow.update(0, 0, paramInt1, paramInt2);
    return;
    label126:
    this.jdField_e_of_type_AndroidWidgetPopupWindow = AudioPanel.a(this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramInt1, paramInt2, this.b, 0, 0, 0);
    this.jdField_e_of_type_AndroidWidgetPopupWindow.update(0, 0, paramInt1, paramInt2);
    caY();
  }
  
  public int getDefaultHeight()
  {
    Rect localRect1 = new Rect();
    this.b.getWindowVisibleDisplayFrame(localRect1);
    Rect localRect2 = new Rect();
    this.df.getGlobalVisibleRect(localRect2);
    Rect localRect3 = new Rect();
    this.dg.getGlobalVisibleRect(localRect3);
    int j = localRect3.bottom;
    int i;
    if (((!Build.MODEL.startsWith("Coolpad")) || (Build.VERSION.SDK_INT != 19)) && ((!Build.MODEL.startsWith("Coolpad A8")) || (Build.VERSION.SDK_INT != 22)) && ((!Build.MODEL.startsWith("Coolpad B770")) || (Build.VERSION.SDK_INT != 22)))
    {
      i = j;
      if (Build.MODEL.startsWith("ivvi"))
      {
        i = j;
        if (Build.VERSION.SDK_INT != 22) {}
      }
    }
    else
    {
      i = j - localRect1.top;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditStateHelper", 2, "initMask height=" + i + " rect.width()=" + localRect1.width() + " inputRect=" + localRect2 + " panelIcons=" + localRect3);
    }
    return i;
  }
  
  public void reset()
  {
    this.bQJ = 0;
  }
  
  public int vT()
  {
    return this.bQJ;
  }
  
  public void yP(boolean paramBoolean)
  {
    if (paramBoolean) {
      caX();
    }
    while (this.bQJ != 0) {
      return;
    }
    fr(this.b.getRight() - this.b.getLeft(), ImmersiveUtils.getStatusBarHeight(this.b.getContext()) + this.jdField_e_of_type_ComTencentMobileqqActivityBaseChatPie.a.getBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqn
 * JD-Core Version:    0.7.0.1
 */