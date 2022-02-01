import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.a;

public class wtj
  implements XEditTextEx.a, wvr
{
  private apoa jdField_a_of_type_Apoa;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  private Activity mActivity;
  
  public wtj(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    this.mActivity = paramTroopChatPie.a();
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getSelectionStart();
    boolean bool1;
    boolean bool2;
    label88:
    Object localObject;
    label280:
    int j;
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == 65312) || (paramCharSequence.charAt(paramInt1) == '@')))
    {
      bool1 = true;
      if ((paramInt3 != 0) || (i <= 0) || ((paramCharSequence.charAt(i - 1) != 65312) && (paramCharSequence.charAt(i - 1) != '@'))) {
        break label547;
      }
      bool2 = true;
      if ((bool1) || (bool2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.isFullScreenMode()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.vV(true);
        }
        if (this.jdField_a_of_type_Apoa == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.r().findViewById(2131362375) == null)
          {
            paramCharSequence = new View(this.mActivity);
            paramCharSequence.setId(2131362375);
            localObject = new RelativeLayout.LayoutParams(-1, -2);
            ((RelativeLayout.LayoutParams)localObject).addRule(12);
            ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131369277);
            ((RelativeLayout)this.mActivity.findViewById(2131364469)).addView(paramCharSequence, 3, (ViewGroup.LayoutParams)localObject);
          }
          this.jdField_a_of_type_Apoa = new apoa(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.setKeyEventPreImeListener(this);
        }
      }
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getText().toString().lastIndexOf("＠", i - 1);
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getText().toString().lastIndexOf("@", i - 1);
      if (paramInt1 <= paramInt2) {
        break label553;
      }
      j = apof.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a);
      paramInt3 = apof.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a);
      if (i - 1 < 0) {
        break label596;
      }
    }
    label547:
    label553:
    label563:
    label569:
    label596:
    for (paramCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getText().toString().substring(i - 1, i);; paramCharSequence = null)
    {
      if ((paramInt3 >= 0) && (paramInt3 == i))
      {
        paramInt2 = 1;
        label348:
        if ((paramInt3 < 0) || (paramInt3 != i - 1) || (paramCharSequence == null) || (!paramCharSequence.equals(" "))) {
          break label563;
        }
        paramInt3 = 1;
        label378:
        if (QLog.isColorLevel()) {
          QLog.d("AIOAtHelper", 2, "selectIndex =" + i + " isFirstAddAt=" + bool1 + " isFirstBackAt=" + bool2 + " max=" + paramInt1 + " lastSpanAt=" + j + " mAtPanel=" + this.jdField_a_of_type_Apoa);
        }
        if ((j >= paramInt1) || (paramInt1 < 0) || (this.jdField_a_of_type_Apoa == null)) {
          break label569;
        }
        paramCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getText().toString().substring(paramInt1 + 1, i);
        bool1 = apof.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app);
        localObject = this.mActivity.findViewById(2131362375);
        this.jdField_a_of_type_Apoa.b((View)localObject, paramCharSequence, bool1);
      }
      for (;;)
      {
        return false;
        bool1 = false;
        break;
        bool2 = false;
        break label88;
        paramInt1 = paramInt2;
        break label280;
        paramInt2 = 0;
        break label348;
        paramInt3 = 0;
        break label378;
        if ((this.jdField_a_of_type_Apoa != null) && (paramInt3 == 0) && (paramInt2 == 0)) {
          this.jdField_a_of_type_Apoa.azJ();
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAtHelper", 2, " beforeTextChanged:  start=" + paramInt1 + " after=" + paramInt3 + " count=" + paramInt2);
    }
    if ((this.jdField_a_of_type_Apoa != null) && (this.jdField_a_of_type_Apoa.aBo())) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAtHelper", 2, "beforeTextChanged mAtPanel spanChange");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt3 != 0) || (paramInt2 <= 0) || (paramCharSequence.length() <= 0));
        paramCharSequence = apof.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a);
        paramInt2 = apof.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a);
      } while ((paramCharSequence == null) || (paramInt2 != paramInt1));
      if (QLog.isColorLevel()) {
        QLog.d("AIOAtHelper", 2, new Object[] { " delete member:", paramCharSequence.Bw(), " nick:", paramCharSequence.Bx() });
      }
    } while (this.jdField_a_of_type_Apoa == null);
    this.jdField_a_of_type_Apoa.Tr(paramCharSequence.Bw());
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    return (paramKeyEvent.getKeyCode() == 4) && (this.jdField_a_of_type_Apoa != null) && (this.jdField_a_of_type_Apoa.azJ());
  }
  
  public boolean onBackEvent()
  {
    return (this.jdField_a_of_type_Apoa != null) && (this.jdField_a_of_type_Apoa.azJ());
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Apoa != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().findViewById(2131362375);
      if (localView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.r().removeView(localView);
      }
      this.jdField_a_of_type_Apoa.dUK();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.setKeyEventPreImeListener(null);
      this.jdField_a_of_type_Apoa = null;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Apoa != null) && (this.jdField_a_of_type_Apoa.aBo())) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAtHelper", 2, "mAtPanel spanChange");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.vm() == 3) {
      return;
    }
    a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtj
 * JD-Core Version:    0.7.0.1
 */