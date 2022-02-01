import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;

public class xxm
  extends QQUIEventReceiver<xxj, xqx>
{
  private WeakReference<xwq> a;
  
  public xxm(@NonNull xxj paramxxj)
  {
    super(paramxxj);
  }
  
  public void a(xwq paramxwq)
  {
    this.a = new WeakReference(paramxwq);
  }
  
  public void a(@NonNull xxj paramxxj, @NonNull xqx paramxqx)
  {
    if (paramxqx.jdField_a_of_type_Boolean) {
      if ((paramxqx.jdField_a_of_type_JavaLangString != null) && (this.a != null))
      {
        paramxxj = (xwq)this.a.get();
        if (paramxxj != null) {
          paramxxj.b(paramxqx.jdField_a_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        return;
        yuk.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramxqx.jdField_a_of_type_JavaLangString });
      } while (this.a == null);
      paramxxj = (xwq)this.a.get();
    } while (paramxxj == null);
    paramxxj.d();
  }
  
  public Class acceptEventClass()
  {
    return xqx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxm
 * JD-Core Version:    0.7.0.1
 */