import android.widget.TextView;
import java.util.List;

class usi
  implements vdr<Boolean, vdx>
{
  usi(ush paramush) {}
  
  public Void a(Boolean paramBoolean, vdx paramvdx)
  {
    if (paramBoolean.booleanValue())
    {
      urk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(paramvdx.b.size(), paramvdx.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      urk.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + paramvdx.jdField_a_of_type_Int);
      bbmy.a(this.a.a(), 1, ajjy.a(2131637858) + paramvdx.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usi
 * JD-Core Version:    0.7.0.1
 */