import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.adapter.ForwardFriendListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.QQUtils;

public class fcq
  implements DialogInterface.OnClickListener
{
  public fcq(ForwardFriendListAdapter paramForwardFriendListAdapter, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramDialogInterface = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAdapterForwardFriendListAdapter.a.getManager(8)).a(this.jdField_a_of_type_JavaLangString);
    QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardFriendListAdapter.a, this.jdField_a_of_type_JavaLangString, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fcq
 * JD-Core Version:    0.7.0.1
 */