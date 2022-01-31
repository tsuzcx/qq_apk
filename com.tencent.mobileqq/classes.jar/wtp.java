import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.util.ArrayList;

public class wtp
  extends Handler
{
  public wtp(wto paramwto) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (wto.a(this.a) != null)
      {
        wtb.b("0X80080E3", wtb.a);
        paramMessage = new ArrayList();
        paramMessage.add(Uri.parse(wto.a(this.a)));
        paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
        paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
        if ((this.a.jdField_a_of_type_Wxp != null) && (this.a.jdField_a_of_type_Wxp.getActivity() != null)) {
          this.a.jdField_a_of_type_Wxp.getActivity().startActivityForResult(paramMessage, 100);
        }
      }
      this.a.e();
      return;
    case 2: 
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_a_of_type_Wwe.a(paramMessage, false);
      if (this.a.jdField_a_of_type_Wwe.a != null)
      {
        this.a.jdField_a_of_type_Wwe.a.g();
        this.a.jdField_a_of_type_Wwe.u();
      }
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wtp
 * JD-Core Version:    0.7.0.1
 */