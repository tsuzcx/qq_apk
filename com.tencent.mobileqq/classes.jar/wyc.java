import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class wyc
  implements xjl<Boolean, xjr>
{
  wyc(wyb paramwyb) {}
  
  public Void a(Boolean paramBoolean, xjr paramxjr)
  {
    if (paramBoolean.booleanValue())
    {
      wxe.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(paramxjr.b.size(), paramxjr.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      wxe.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + paramxjr.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, alud.a(2131704038) + paramxjr.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyc
 * JD-Core Version:    0.7.0.1
 */