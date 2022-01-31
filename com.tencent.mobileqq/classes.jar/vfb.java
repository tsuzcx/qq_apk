import android.widget.TextView;
import java.util.List;

class vfb
  implements vqk<Boolean, vqq>
{
  vfb(vfa paramvfa) {}
  
  public Void a(Boolean paramBoolean, vqq paramvqq)
  {
    if (paramBoolean.booleanValue())
    {
      ved.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(paramvqq.b.size(), paramvqq.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      ved.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + paramvqq.jdField_a_of_type_Int);
      bcql.a(this.a.a(), 1, ajya.a(2131703654) + paramvqq.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfb
 * JD-Core Version:    0.7.0.1
 */