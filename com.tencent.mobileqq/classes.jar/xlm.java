import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import java.lang.ref.WeakReference;

public class xlm
  implements Runnable
{
  public xlm(PreloadManager paramPreloadManager, WeakReference paramWeakReference, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      PreloadManager localPreloadManager = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localPreloadManager != null) && (!localPreloadManager.jdField_a_of_type_Boolean)) {
        localPreloadManager.a(this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlm
 * JD-Core Version:    0.7.0.1
 */