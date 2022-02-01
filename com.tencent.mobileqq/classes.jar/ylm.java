import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class ylm
  implements ywk<Boolean, ywq>
{
  ylm(yll paramyll) {}
  
  public Void a(Boolean paramBoolean, ywq paramywq)
  {
    if (paramBoolean.booleanValue())
    {
      ykq.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(paramywq.b.size(), paramywq.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      ykq.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + paramywq.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, anvx.a(2131703128) + paramywq.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylm
 * JD-Core Version:    0.7.0.1
 */