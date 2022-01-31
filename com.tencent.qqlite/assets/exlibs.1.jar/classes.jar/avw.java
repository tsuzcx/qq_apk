import android.widget.TextView;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;

public class avw
  extends FriendListObserver
{
  public avw(ModifyFriendInfoActivity paramModifyFriendInfoActivity) {}
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((paramString != null) && (paramString.equals(this.a.jdField_a_of_type_JavaLangString)))
    {
      this.a.jdField_a_of_type_Int = paramByte1;
      return;
    }
    this.a.c();
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean)
    {
      this.a.c = paramString2;
      paramString1 = (FriendManager)this.a.app.getManager(8);
      this.a.jdField_b_of_type_JavaLangString = paramString1.a(this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avw
 * JD-Core Version:    0.7.0.1
 */