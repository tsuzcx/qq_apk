import android.content.Context;
import android.content.IntentFilter;

public class ywe
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ywg jdField_a_of_type_Ywg;
  private ywh jdField_a_of_type_Ywh;
  
  public ywe(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ywg = new ywg(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Ywg, localIntentFilter);
  }
  
  public void a(ywh paramywh)
  {
    this.jdField_a_of_type_Ywh = paramywh;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Ywg != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ywg);
      this.jdField_a_of_type_Ywh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywe
 * JD-Core Version:    0.7.0.1
 */