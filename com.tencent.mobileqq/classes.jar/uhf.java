import android.content.Context;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

public class uhf
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private uhg jdField_a_of_type_Uhg;
  private uhh jdField_a_of_type_Uhh;
  
  public uhf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Uhg != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))) {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Uhg, this.jdField_a_of_type_AndroidContentIntentFilter);
    }
  }
  
  public void a(uhh paramuhh)
  {
    this.jdField_a_of_type_Uhh = paramuhh;
    this.jdField_a_of_type_Uhg = new uhg(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Uhg != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Uhg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhf
 * JD-Core Version:    0.7.0.1
 */