import android.content.Context;
import android.text.ClipboardManager;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.widget.XListView;

class x
  implements Runnable
{
  x(p paramp, String paramString) {}
  
  public void run()
  {
    LiteActivity.a(this.jdField_a_of_type_P.a).notifyDataSetChanged();
    try
    {
      ((ClipboardManager)LiteActivity.a(this.jdField_a_of_type_P.a).getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      label41:
      LiteActivity.a(this.jdField_a_of_type_P.a.a, LiteActivity.a(this.jdField_a_of_type_P.a));
      LiteActivity.a(LiteActivity.a(this.jdField_a_of_type_P.a));
      this.jdField_a_of_type_P.a.app.a().a().d();
      return;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     x
 * JD-Core Version:    0.7.0.1
 */