import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;

public class wag
  extends QQUIEventReceiver<wad, vtr>
{
  private WeakReference<vzk> a;
  
  public wag(@NonNull wad paramwad)
  {
    super(paramwad);
  }
  
  public void a(vzk paramvzk)
  {
    this.a = new WeakReference(paramvzk);
  }
  
  public void a(@NonNull wad paramwad, @NonNull vtr paramvtr)
  {
    if (paramvtr.jdField_a_of_type_Boolean) {
      if ((paramvtr.jdField_a_of_type_JavaLangString != null) && (this.a != null))
      {
        paramwad = (vzk)this.a.get();
        if (paramwad != null) {
          paramwad.b(paramvtr.jdField_a_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        return;
        wxe.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramvtr.jdField_a_of_type_JavaLangString });
      } while (this.a == null);
      paramwad = (vzk)this.a.get();
    } while (paramwad == null);
    paramwad.d();
  }
  
  public Class acceptEventClass()
  {
    return vtr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wag
 * JD-Core Version:    0.7.0.1
 */