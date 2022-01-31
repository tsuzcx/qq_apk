import android.content.Context;
import android.text.ClipboardManager;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.widget.XListView;

class y
  implements Runnable
{
  y(q paramq, String paramString) {}
  
  public void run()
  {
    LiteActivity.a(this.jdField_a_of_type_Q.a).notifyDataSetChanged();
    try
    {
      ((ClipboardManager)LiteActivity.a(this.jdField_a_of_type_Q.a).getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      label41:
      LiteActivity.a(this.jdField_a_of_type_Q.a.a, LiteActivity.a(this.jdField_a_of_type_Q.a));
      LiteActivity.a(LiteActivity.a(this.jdField_a_of_type_Q.a));
      this.jdField_a_of_type_Q.a.app.a().a().d();
      return;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     y
 * JD-Core Version:    0.7.0.1
 */