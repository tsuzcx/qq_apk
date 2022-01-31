import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;

public class uhf
  extends QQUIEventReceiver<uhc, uaq>
{
  private WeakReference<ugj> a;
  
  public uhf(@NonNull uhc paramuhc)
  {
    super(paramuhc);
  }
  
  public void a(ugj paramugj)
  {
    this.a = new WeakReference(paramugj);
  }
  
  public void a(@NonNull uhc paramuhc, @NonNull uaq paramuaq)
  {
    if (paramuaq.jdField_a_of_type_Boolean) {
      if ((paramuaq.jdField_a_of_type_JavaLangString != null) && (this.a != null))
      {
        paramuhc = (ugj)this.a.get();
        if (paramuhc != null) {
          paramuhc.b(paramuaq.jdField_a_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        return;
        ved.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramuaq.jdField_a_of_type_JavaLangString });
      } while (this.a == null);
      paramuhc = (ugj)this.a.get();
    } while (paramuhc == null);
    paramuhc.d();
  }
  
  public Class acceptEventClass()
  {
    return uaq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhf
 * JD-Core Version:    0.7.0.1
 */