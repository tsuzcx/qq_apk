import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import java.lang.ref.WeakReference;

public class xcn
  implements Runnable
{
  public xcn(PreloadManager paramPreloadManager, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      PreloadManager localPreloadManager = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localPreloadManager != null) && (!localPreloadManager.a)) {
        localPreloadManager.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcn
 * JD-Core Version:    0.7.0.1
 */