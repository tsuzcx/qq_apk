import android.app.Dialog;
import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.a;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XListView;

public class uml
  implements Handler.Callback
{
  public uml(ChatHistory paramChatHistory) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 6: 
    case 4: 
    case 2: 
    case 0: 
    case 1: 
    case 7: 
    case 3: 
    case 5: 
    case 8: 
      do
      {
        do
        {
          do
          {
            return true;
            this.this$0.CC.setEnabled(true);
          } while (!aqiw.isNetSupport(BaseApplication.getContext()));
          this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
          return true;
          this.this$0.D = new ReportDialog(this.this$0, 2131756467);
          this.this$0.D.setContentView(2131562991);
          ((TextView)this.this$0.D.findViewById(2131365863)).setText(paramMessage.obj.toString());
          this.this$0.D.setOnCancelListener(new umm(this));
          this.this$0.D.show();
          return true;
          this.this$0.bJI();
          return true;
          this.this$0.CC.setEnabled(true);
          try
          {
            if ((this.this$0.D != null) && (this.this$0.D.isShowing())) {
              this.this$0.D.dismiss();
            }
          }
          catch (IllegalArgumentException paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ChatHistory", 2, "tipsDialog dismiss " + paramMessage.getMessage());
              }
              this.this$0.D = null;
            }
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ChatHistory", 2, "tipsDialog dismiss " + paramMessage.getMessage());
              }
              this.this$0.D = null;
            }
          }
          finally
          {
            this.this$0.D = null;
          }
          this.this$0.az(10, false);
          return true;
          this.this$0.CC.setEnabled(true);
          if (this.this$0.D != null) {
            this.this$0.D.dismiss();
          }
          this.this$0.aL(2130840095, this.this$0.getString(2131694325));
          return true;
          this.this$0.CC.setEnabled(true);
          if (this.this$0.D != null) {
            this.this$0.D.dismiss();
          }
          this.this$0.aL(2130840095, this.this$0.getString(2131694326));
          return true;
          this.this$0.CC.setEnabled(true);
          if (this.this$0.D != null) {
            this.this$0.D.dismiss();
          }
          this.this$0.aL(2130840095, this.this$0.getString(2131719617));
          return true;
          this.this$0.aL(2130840095, this.this$0.getString(2131692508));
          return true;
        } while (paramMessage.obj == null);
        paramMessage = (Cursor)paramMessage.obj;
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a != null)
        {
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.getCursor() != null) {
            this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.getCursor().deactivate();
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.changeCursor(paramMessage);
        }
      } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.bFo < 0) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.bFo >= 8));
      this.this$0.k.setSelection(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.bFo + this.this$0.k.getHeaderViewsCount());
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.bFo = -1;
      return true;
    case 9: 
      this.this$0.eX(paramMessage.arg1, paramMessage.arg2);
      this.this$0.bJF();
      this.this$0.bJD();
      return true;
    case 10: 
      this.this$0.eX(paramMessage.arg1, paramMessage.arg2);
      this.this$0.bJE();
      return true;
    case 11: 
      this.this$0.eX(paramMessage.arg1, paramMessage.arg2);
      this.this$0.bJG();
      return true;
    case 12: 
      if (paramMessage.arg1 > 0) {
        this.this$0.vj((String)paramMessage.obj);
      }
      for (;;)
      {
        anot.a(this.this$0.app, "CliOper", "", "", "0X800568F", "0X800568F", this.this$0.bFk, 0, "", "", "", "");
        return true;
        this.this$0.vk(this.this$0.getString(2131690297));
      }
    }
    this.this$0.Ar(paramMessage.arg1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uml
 * JD-Core Version:    0.7.0.1
 */