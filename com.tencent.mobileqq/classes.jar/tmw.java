import android.content.Context;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

public class tmw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private tmx jdField_a_of_type_Tmx;
  private tmy jdField_a_of_type_Tmy;
  
  public tmw(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Tmx != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))) {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Tmx, this.jdField_a_of_type_AndroidContentIntentFilter);
    }
  }
  
  public void a(tmy paramtmy)
  {
    this.jdField_a_of_type_Tmy = paramtmy;
    this.jdField_a_of_type_Tmx = new tmx(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Tmx != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Tmx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tmw
 * JD-Core Version:    0.7.0.1
 */