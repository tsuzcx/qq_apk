import android.app.Dialog;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;

public class byw
  extends CardObserver
{
  public byw(ChatActivity paramChatActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (this.a.a.jdField_a_of_type_JavaLangString != null) && (paramObject != null) && (this.a.a.jdField_a_of_type_JavaLangString.equals(paramObject.uin)) && ((this.a.a.jdField_a_of_type_Int == 1001) || (this.a.a.jdField_a_of_type_Int == 1003)) && (paramObject != null) && (paramObject.strCertificationInfo != null) && (!paramObject.strCertificationInfo.equals(""))) {
        ChatActivityFacade.d(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a);
      }
      if ((paramBoolean) && (paramObject != null)) {}
      switch (this.a.a.jdField_a_of_type_Int)
      {
      default: 
        if ((this.a.a.jdField_a_of_type_JavaLangString != null) && (this.a.a.jdField_a_of_type_JavaLangString.equals(paramObject.uin)))
        {
          this.a.h();
          this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.a.d);
          if (3000 == this.a.a.jdField_a_of_type_Int) {
            ChatActivity.a(this.a, this.a.a.d, this.a.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_AndroidWidgetTextView);
          }
        }
        return;
      }
      this.a.b(false);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.c != null) && (this.a.c.isShowing())) {
      this.a.dismissDialog(231);
    }
    if (paramBoolean)
    {
      this.a.showDialog(232);
      return;
    }
    this.a.showDialog(233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byw
 * JD-Core Version:    0.7.0.1
 */