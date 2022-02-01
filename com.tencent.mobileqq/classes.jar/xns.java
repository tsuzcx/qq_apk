import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;

public class xns
  extends QQUIEventReceiver<xnp, xhd>
{
  private WeakReference<xmw> a;
  
  public xns(@NonNull xnp paramxnp)
  {
    super(paramxnp);
  }
  
  public void a(@NonNull xnp paramxnp, @NonNull xhd paramxhd)
  {
    if (paramxhd.jdField_a_of_type_Boolean) {
      if ((paramxhd.jdField_a_of_type_JavaLangString != null) && (this.a != null))
      {
        paramxnp = (xmw)this.a.get();
        if (paramxnp != null) {
          paramxnp.a(paramxhd.jdField_a_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        return;
        ykq.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramxhd.jdField_a_of_type_JavaLangString });
      } while (this.a == null);
      paramxnp = (xmw)this.a.get();
    } while (paramxnp == null);
    paramxnp.a();
  }
  
  public Class acceptEventClass()
  {
    return xhd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xns
 * JD-Core Version:    0.7.0.1
 */