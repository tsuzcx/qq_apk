import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.util.ArrayList;

public class wxy
  extends Handler
{
  public wxy(wxx paramwxx) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (wxx.a(this.a) != null)
      {
        wxk.b("0X80080E3", wxk.a);
        paramMessage = new ArrayList();
        paramMessage.add(Uri.parse(wxx.a(this.a)));
        paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
        paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
        if ((this.a.jdField_a_of_type_Xby != null) && (this.a.jdField_a_of_type_Xby.getActivity() != null)) {
          this.a.jdField_a_of_type_Xby.getActivity().startActivityForResult(paramMessage, 100);
        }
      }
      this.a.e();
      return;
    case 2: 
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_a_of_type_Xan.a(paramMessage, false);
      if (this.a.jdField_a_of_type_Xan.a != null)
      {
        this.a.jdField_a_of_type_Xan.a.g();
        this.a.jdField_a_of_type_Xan.u();
      }
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxy
 * JD-Core Version:    0.7.0.1
 */