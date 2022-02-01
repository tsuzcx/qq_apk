import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class wuz
  implements wvs
{
  private final BaseChatPie a;
  protected wuz.a a;
  protected boolean bgf;
  private final BaseActivity mContext;
  
  public wuz(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.mContext = paramBaseChatPie.a();
  }
  
  private void a(XEditTextEx paramXEditTextEx)
  {
    this.bgf = SettingCloneUtil.readValue(this.mContext, null, this.mContext.getString(2131697083), "qqsetting_enter_sendmsg_key", false);
    if (this.bgf) {
      paramXEditTextEx.setImeOptions(4);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Wuz$a == null) {
        this.jdField_a_of_type_Wuz$a = new wuz.a(null);
      }
      paramXEditTextEx.setOnEditorActionListener(this.jdField_a_of_type_Wuz$a);
      paramXEditTextEx.setOnKeyListener(this.jdField_a_of_type_Wuz$a);
      return;
      paramXEditTextEx.setImeOptions(0);
    }
  }
  
  public int[] C()
  {
    return new int[] { 20, 8 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 20: 
      this.bgf = false;
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a);
  }
  
  class a
    implements View.OnKeyListener, TextView.OnEditorActionListener
  {
    private a() {}
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EnterForSendHelper", 2, "IME_ACTION_SEND");
        }
        wuz.a(wuz.this).bIb();
        return true;
      }
      return false;
    }
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      paramView = wuz.a(wuz.this).a;
      if (paramKeyEvent.getKeyCode() == 66)
      {
        if (paramKeyEvent.getAction() == 1)
        {
          paramView = paramView.getText().toString();
          if (QLog.isColorLevel()) {
            QLog.d("EnterForSendHelper", 2, " sendOnEnterEnabled = " + wuz.this.bgf);
          }
          if ((wuz.this.bgf) && (paramView.length() > 0)) {
            wuz.a(wuz.this).send();
          }
        }
        if (wuz.this.bgf) {
          return true;
        }
      }
      else if ((paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EnterForSendHelper", 2, "on delete, start: " + paramView.getSelectionStart() + ", end: " + paramView.getSelectionEnd() + ", span: " + paramView.getTag(2131374473));
        }
        if ((paramView.getSelectionStart() == 0) && (paramView.getSelectionEnd() == 0) && (paramView.getTag(2131374473) != null))
        {
          paramKeyEvent = paramView.getCompoundDrawables();
          paramView.setCompoundDrawables(paramKeyEvent[0], null, paramKeyEvent[2], paramKeyEvent[3]);
          paramView.setTag(2131374473, null);
          paramView.setSelection(0);
          wuz.a(wuz.this).mSourceMsgInfo = null;
          wuz.a(wuz.this).zM(2);
          anot.a(null, "dc00898", "", "", "0X800A9AC", "0X800A9AC", 0, 1, "", "", "", "");
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wuz
 * JD-Core Version:    0.7.0.1
 */