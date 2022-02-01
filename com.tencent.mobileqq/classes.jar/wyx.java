import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;

public class wyx
  extends QQUIEventReceiver<wyu, wsi>
{
  private WeakReference<wyb> a;
  
  public wyx(@NonNull wyu paramwyu)
  {
    super(paramwyu);
  }
  
  public void a(@NonNull wyu paramwyu, @NonNull wsi paramwsi)
  {
    if (paramwsi.jdField_a_of_type_Boolean) {
      if ((paramwsi.jdField_a_of_type_JavaLangString != null) && (this.a != null))
      {
        paramwyu = (wyb)this.a.get();
        if (paramwyu != null) {
          paramwyu.a(paramwsi.jdField_a_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        return;
        xvv.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramwsi.jdField_a_of_type_JavaLangString });
      } while (this.a == null);
      paramwyu = (wyb)this.a.get();
    } while (paramwyu == null);
    paramwyu.a();
  }
  
  public Class acceptEventClass()
  {
    return wsi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyx
 * JD-Core Version:    0.7.0.1
 */