import com.tencent.mobileqq.config.ConfigManager;
import java.util.TimerTask;

public class dca
  extends TimerTask
{
  int jdField_a_of_type_Int = 0;
  
  public dca(ConfigManager paramConfigManager) {}
  
  public void run()
  {
    synchronized (ConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqConfigConfigManager))
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int > 30)
      {
        this.jdField_a_of_type_ComTencentMobileqqConfigConfigManager.d();
        cancel();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dca
 * JD-Core Version:    0.7.0.1
 */