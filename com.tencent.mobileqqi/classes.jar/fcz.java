import com.rookery.translate.tencent.TranslateRespWrapperFYJ;
import com.tencent.mobileqq.app.I18nTranslatorHandler;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class fcz
  implements Runnable
{
  public fcz(I18nTranslatorHandler paramI18nTranslatorHandler, String paramString, Long paramLong, List paramList) {}
  
  public void run()
  {
    localObject1 = new fdb(this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangLong, this.jdField_a_of_type_JavaUtilList);
    localObject3 = Executors.newSingleThreadExecutor();
    localObject1 = ((ExecutorService)localObject3).submit((Callable)localObject1);
    try
    {
      localObject1 = (Boolean)((Future)localObject1).get(20L, TimeUnit.SECONDS);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localObject1 = Boolean.valueOf(false);
        localInterruptedException.printStackTrace();
        ((ExecutorService)localObject3).shutdownNow();
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        localObject1 = Boolean.valueOf(false);
        localExecutionException.printStackTrace();
        ((ExecutorService)localObject3).shutdownNow();
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        localObject1 = Boolean.valueOf(false);
        localTimeoutException.printStackTrace();
        ((ExecutorService)localObject3).shutdownNow();
      }
    }
    finally
    {
      ((ExecutorService)localObject3).shutdownNow();
    }
    if (!((Boolean)localObject1).booleanValue())
    {
      localObject3 = new TranslateRespWrapperFYJ();
      ((TranslateRespWrapperFYJ)localObject3).jdField_a_of_type_JavaLangLong = this.jdField_a_of_type_JavaLangLong;
      ((TranslateRespWrapperFYJ)localObject3).jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler.a(80002, ((Boolean)localObject1).booleanValue(), localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fcz
 * JD-Core Version:    0.7.0.1
 */