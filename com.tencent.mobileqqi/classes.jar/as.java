import android.content.Context;
import android.text.ClipboardManager;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.widget.XListView;

class as
  implements Runnable
{
  as(ak paramak, String paramString) {}
  
  public void run()
  {
    LiteActivity.a(this.jdField_a_of_type_Ak.a).notifyDataSetChanged();
    try
    {
      ((ClipboardManager)LiteActivity.a(this.jdField_a_of_type_Ak.a).getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      label41:
      LiteActivity.c(this.jdField_a_of_type_Ak.a);
      LiteActivity.b(this.jdField_a_of_type_Ak.a);
      this.jdField_a_of_type_Ak.a.b.a().i();
      return;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     as
 * JD-Core Version:    0.7.0.1
 */