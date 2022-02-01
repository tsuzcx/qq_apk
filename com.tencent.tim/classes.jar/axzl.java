import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class axzl
  extends axzq
{
  private static volatile axzl jdField_a_of_type_Axzl;
  @NonNull
  private static final Executor sIOThreadExecutor = new axzn();
  @NonNull
  private static final Executor sMainThreadExecutor = new axzm();
  @NonNull
  private axzq jdField_a_of_type_Axzq = this.b;
  @NonNull
  private axzq b = new axzo();
  
  @NonNull
  public static axzl a()
  {
    if (jdField_a_of_type_Axzl != null) {
      return jdField_a_of_type_Axzl;
    }
    try
    {
      if (jdField_a_of_type_Axzl == null) {
        jdField_a_of_type_Axzl = new axzl();
      }
      return jdField_a_of_type_Axzl;
    }
    finally {}
  }
  
  public void executeOnDiskIO(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Axzq.executeOnDiskIO(paramRunnable);
  }
  
  public boolean isMainThread()
  {
    return this.jdField_a_of_type_Axzq.isMainThread();
  }
  
  public void postToMainThread(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Axzq.postToMainThread(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axzl
 * JD-Core Version:    0.7.0.1
 */