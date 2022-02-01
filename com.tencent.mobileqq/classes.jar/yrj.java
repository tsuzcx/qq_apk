import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.util.ArrayList;

public class yrj
  extends Handler
{
  public yrj(yri paramyri) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (yri.a(this.a) != null)
      {
        yqv.b("0X80080E3", yqv.a);
        paramMessage = new ArrayList();
        paramMessage.add(Uri.parse(yri.a(this.a)));
        paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
        paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
        if ((this.a.jdField_a_of_type_Yvj != null) && (this.a.jdField_a_of_type_Yvj.getActivity() != null)) {
          this.a.jdField_a_of_type_Yvj.getActivity().startActivityForResult(paramMessage, 100);
        }
      }
      this.a.e();
      return;
    case 2: 
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_a_of_type_Yty.a(paramMessage, false);
      if (this.a.jdField_a_of_type_Yty.a != null)
      {
        this.a.jdField_a_of_type_Yty.a.g();
        this.a.jdField_a_of_type_Yty.u();
      }
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrj
 * JD-Core Version:    0.7.0.1
 */