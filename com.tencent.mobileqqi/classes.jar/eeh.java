import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.LocationItemBuilder;
import com.tencent.mobileqq.data.MessageForText;

public class eeh
  implements DialogInterface.OnClickListener
{
  public eeh(LocationItemBuilder paramLocationItemBuilder, MessageForText paramMessageForText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(LocationItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder), this.jdField_a_of_type_ComTencentMobileqqDataMessageForText);
    ChatActivityFacade.b(LocationItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder), LocationItemBuilder.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder), LocationItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder), this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg);
    LocationItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eeh
 * JD-Core Version:    0.7.0.1
 */