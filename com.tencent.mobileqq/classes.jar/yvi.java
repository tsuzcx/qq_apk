import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class yvi
  implements zgr<Boolean, zgx>
{
  yvi(yvh paramyvh) {}
  
  public Void a(Boolean paramBoolean, zgx paramzgx)
  {
    if (paramBoolean.booleanValue())
    {
      yuk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(paramzgx.b.size(), paramzgx.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      yuk.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + paramzgx.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, anzj.a(2131702542) + paramzgx.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvi
 * JD-Core Version:    0.7.0.1
 */