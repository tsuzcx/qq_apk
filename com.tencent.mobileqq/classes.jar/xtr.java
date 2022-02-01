import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;

public class xtr
  extends QQUIEventReceiver<xto, xnc>
{
  private WeakReference<xsv> a;
  
  public xtr(@NonNull xto paramxto)
  {
    super(paramxto);
  }
  
  public void a(xsv paramxsv)
  {
    this.a = new WeakReference(paramxsv);
  }
  
  public void a(@NonNull xto paramxto, @NonNull xnc paramxnc)
  {
    if (paramxnc.jdField_a_of_type_Boolean) {
      if ((paramxnc.jdField_a_of_type_JavaLangString != null) && (this.a != null))
      {
        paramxto = (xsv)this.a.get();
        if (paramxto != null) {
          paramxto.b(paramxnc.jdField_a_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        return;
        yqp.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramxnc.jdField_a_of_type_JavaLangString });
      } while (this.a == null);
      paramxto = (xsv)this.a.get();
    } while (paramxto == null);
    paramxto.d();
  }
  
  public Class acceptEventClass()
  {
    return xnc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtr
 * JD-Core Version:    0.7.0.1
 */