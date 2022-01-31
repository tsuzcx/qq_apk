import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;

public class uhi
  extends QQUIEventReceiver<uhf, uat>
{
  private WeakReference<ugm> a;
  
  public uhi(@NonNull uhf paramuhf)
  {
    super(paramuhf);
  }
  
  public void a(ugm paramugm)
  {
    this.a = new WeakReference(paramugm);
  }
  
  public void a(@NonNull uhf paramuhf, @NonNull uat paramuat)
  {
    if (paramuat.jdField_a_of_type_Boolean) {
      if ((paramuat.jdField_a_of_type_JavaLangString != null) && (this.a != null))
      {
        paramuhf = (ugm)this.a.get();
        if (paramuhf != null) {
          paramuhf.b(paramuat.jdField_a_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        return;
        veg.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramuat.jdField_a_of_type_JavaLangString });
      } while (this.a == null);
      paramuhf = (ugm)this.a.get();
    } while (paramuhf == null);
    paramuhf.d();
  }
  
  public Class acceptEventClass()
  {
    return uat.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhi
 * JD-Core Version:    0.7.0.1
 */