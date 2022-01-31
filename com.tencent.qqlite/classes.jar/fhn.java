import android.app.Activity;
import com.tencent.open.downloadnew.MyAppApi;

public class fhn
  implements Runnable
{
  public fhn(MyAppApi paramMyAppApi, Activity paramActivity) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.e) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a != null))
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.d(this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhn
 * JD-Core Version:    0.7.0.1
 */