import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;

public class tum
  extends QQUIEventReceiver<tuj, tnx>
{
  private WeakReference<ttq> a;
  
  public tum(@NonNull tuj paramtuj)
  {
    super(paramtuj);
  }
  
  public void a(ttq paramttq)
  {
    this.a = new WeakReference(paramttq);
  }
  
  public void a(@NonNull tuj paramtuj, @NonNull tnx paramtnx)
  {
    if (paramtnx.jdField_a_of_type_Boolean) {
      if ((paramtnx.jdField_a_of_type_JavaLangString != null) && (this.a != null))
      {
        paramtuj = (ttq)this.a.get();
        if (paramtuj != null) {
          paramtuj.b(paramtnx.jdField_a_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        return;
        urk.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramtnx.jdField_a_of_type_JavaLangString });
      } while (this.a == null);
      paramtuj = (ttq)this.a.get();
    } while (paramtuj == null);
    paramtuj.d();
  }
  
  public Class acceptEventClass()
  {
    return tnx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tum
 * JD-Core Version:    0.7.0.1
 */