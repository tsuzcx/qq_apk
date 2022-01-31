import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SaveTrafficHandler;
import com.tencent.qphone.base.util.BaseApplication;

public class fgg
  extends Thread
{
  public fgg(SaveTrafficHandler paramSaveTrafficHandler, String paramString, int paramInt)
  {
    super(paramString);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSaveTrafficHandler.a.a() != null)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppSaveTrafficHandler.a.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppSaveTrafficHandler.a.a(), 0).edit();
      localEditor.putInt("key_savetrafficseq", this.jdField_a_of_type_Int);
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fgg
 * JD-Core Version:    0.7.0.1
 */