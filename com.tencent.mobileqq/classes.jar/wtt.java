import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class wtt
  implements xfc<Boolean, xfi>
{
  wtt(wts paramwts) {}
  
  public Void a(Boolean paramBoolean, xfi paramxfi)
  {
    if (paramBoolean.booleanValue())
    {
      wsv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(paramxfi.b.size(), paramxfi.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      wsv.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + paramxfi.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, alpo.a(2131704026) + paramxfi.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wtt
 * JD-Core Version:    0.7.0.1
 */