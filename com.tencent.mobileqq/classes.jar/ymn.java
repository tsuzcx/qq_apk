import android.content.Context;
import android.content.IntentFilter;

public class ymn
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ymp jdField_a_of_type_Ymp;
  private ymq jdField_a_of_type_Ymq;
  
  public ymn(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ymp = new ymp(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Ymp, localIntentFilter);
  }
  
  public void a(ymq paramymq)
  {
    this.jdField_a_of_type_Ymq = paramymq;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Ymp != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ymp);
      this.jdField_a_of_type_Ymq = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ymn
 * JD-Core Version:    0.7.0.1
 */