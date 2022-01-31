import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import java.util.LinkedHashMap;

public class com
  extends Handler
{
  public com(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
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
      this.a.jdField_a_of_type_Cos.notifyDataSetChanged();
    } while ((paramMessage.what != 2) && ((paramMessage.what != 1) || (this.a.jdField_a_of_type_Boolean)));
    this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com
 * JD-Core Version:    0.7.0.1
 */