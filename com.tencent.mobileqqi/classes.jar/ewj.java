import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import java.util.LinkedHashMap;

public class ewj
  extends Handler
{
  public ewj(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        Object[] arrayOfObject = (Object[])paramMessage.obj;
        if (arrayOfObject.length == 3)
        {
          this.a.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)arrayOfObject[0]);
          this.a.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject[1]);
          this.a.jdField_a_of_type_ArrayOfJavaLangString = ((String[])arrayOfObject[2]);
        }
        this.a.jdField_a_of_type_Ewo.notifyDataSetChanged();
      } while ((paramMessage.what != 2) && ((paramMessage.what != 1) || (this.a.jdField_a_of_type_Boolean)));
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k();
      return;
    case 3: 
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 40, 0);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewj
 * JD-Core Version:    0.7.0.1
 */