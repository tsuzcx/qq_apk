import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;

public class vvx
  extends QQUIEventReceiver<vvu, vpi>
{
  private WeakReference<vvb> a;
  
  public vvx(@NonNull vvu paramvvu)
  {
    super(paramvvu);
  }
  
  public void a(vvb paramvvb)
  {
    this.a = new WeakReference(paramvvb);
  }
  
  public void a(@NonNull vvu paramvvu, @NonNull vpi paramvpi)
  {
    if (paramvpi.jdField_a_of_type_Boolean) {
      if ((paramvpi.jdField_a_of_type_JavaLangString != null) && (this.a != null))
      {
        paramvvu = (vvb)this.a.get();
        if (paramvvu != null) {
          paramvvu.b(paramvpi.jdField_a_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        return;
        wsv.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramvpi.jdField_a_of_type_JavaLangString });
      } while (this.a == null);
      paramvvu = (vvb)this.a.get();
    } while (paramvvu == null);
    paramvvu.d();
  }
  
  public Class acceptEventClass()
  {
    return vpi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvx
 * JD-Core Version:    0.7.0.1
 */