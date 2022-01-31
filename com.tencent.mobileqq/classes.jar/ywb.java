import android.content.Context;
import android.content.IntentFilter;

public class ywb
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ywd jdField_a_of_type_Ywd;
  private ywe jdField_a_of_type_Ywe;
  
  public ywb(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ywd = new ywd(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Ywd, localIntentFilter);
  }
  
  public void a(ywe paramywe)
  {
    this.jdField_a_of_type_Ywe = paramywe;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Ywd != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ywd);
      this.jdField_a_of_type_Ywe = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywb
 * JD-Core Version:    0.7.0.1
 */