import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.widget.XListView;

class at
  implements Runnable
{
  at(ak paramak, String paramString) {}
  
  public void run()
  {
    LiteActivity.a(this.jdField_a_of_type_Ak.a).notifyDataSetChanged();
    ((ClipboardManager)LiteActivity.a(this.jdField_a_of_type_Ak.a).getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", this.jdField_a_of_type_JavaLangString));
    LiteActivity.c(this.jdField_a_of_type_Ak.a);
    LiteActivity.b(this.jdField_a_of_type_Ak.a);
    this.jdField_a_of_type_Ak.a.b.a().i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     at
 * JD-Core Version:    0.7.0.1
 */