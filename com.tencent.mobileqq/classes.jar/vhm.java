import android.app.Dialog;

class vhm
  implements Runnable
{
  vhm(vhl paramvhl, Dialog paramDialog) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vhm
 * JD-Core Version:    0.7.0.1
 */