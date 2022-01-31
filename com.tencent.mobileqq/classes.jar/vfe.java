import android.widget.TextView;
import java.util.List;

class vfe
  implements vqn<Boolean, vqt>
{
  vfe(vfd paramvfd) {}
  
  public Void a(Boolean paramBoolean, vqt paramvqt)
  {
    if (paramBoolean.booleanValue())
    {
      veg.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(paramvqt.b.size(), paramvqt.jdField_a_of_type_JavaUtilList.size())));
      this.a.a.setEnabled(true);
    }
    for (;;)
    {
      return null;
      veg.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + paramvqt.jdField_a_of_type_Int);
      bcpw.a(this.a.a(), 1, ajyc.a(2131703643) + paramvqt.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfe
 * JD-Core Version:    0.7.0.1
 */