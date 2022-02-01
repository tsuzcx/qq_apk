import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class yrn
  implements zcw<Boolean, zdc>
{
  yrn(yrm paramyrm) {}
  
  public Void a(Boolean paramBoolean, zdc paramzdc)
  {
    if (paramBoolean.booleanValue())
    {
      yqp.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(paramzdc.b.size(), paramzdc.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      yqp.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + paramzdc.jdField_a_of_type_Int);
      QQToast.a(this.a.a(), 1, anni.a(2131702435) + paramzdc.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrn
 * JD-Core Version:    0.7.0.1
 */