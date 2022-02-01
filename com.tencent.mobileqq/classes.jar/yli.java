import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.util.ArrayList;

public class yli
  extends Handler
{
  public yli(ylh paramylh) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (ylh.a(this.a) != null)
      {
        ykw.b("0X80080E3", ykw.a);
        paramMessage = new ArrayList();
        paramMessage.add(Uri.parse(ylh.a(this.a)));
        paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
        paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
        if ((this.a.jdField_a_of_type_Ypg != null) && (this.a.jdField_a_of_type_Ypg.getActivity() != null)) {
          this.a.jdField_a_of_type_Ypg.getActivity().startActivityForResult(paramMessage, 100);
        }
      }
      this.a.e();
      return;
    case 2: 
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_a_of_type_Ynw.a(paramMessage, false);
      if (this.a.jdField_a_of_type_Ynw.a != null)
      {
        this.a.jdField_a_of_type_Ynw.a.h();
        this.a.jdField_a_of_type_Ynw.u();
      }
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yli
 * JD-Core Version:    0.7.0.1
 */