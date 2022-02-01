import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class xwt
  implements yhr<Boolean, yhx>
{
  xwt(xws paramxws) {}
  
  public Void a(Boolean paramBoolean, yhx paramyhx)
  {
    if (paramBoolean.booleanValue())
    {
      xvv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(paramyhx.b.size(), paramyhx.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      xvv.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + paramyhx.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, amtj.a(2131702777) + paramyhx.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwt
 * JD-Core Version:    0.7.0.1
 */