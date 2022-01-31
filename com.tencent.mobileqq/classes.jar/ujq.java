import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.3;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.5;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.6;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.7;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;

public class ujq
  implements uit
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Map<String, uja> jdField_a_of_type_JavaUtilMap = new HashMap();
  private uir jdField_a_of_type_Uir = new uir();
  private Handler b = new Handler(Looper.getMainLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, ujr paramujr)
  {
    if (paramujr == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.7(this, paramujr, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, ujr paramujr)
  {
    if (paramujr == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.5(this, paramujr, paramString, paramInt));
  }
  
  private void b(String paramString, int paramInt, ujr paramujr)
  {
    if (paramujr == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.6(this, paramujr, paramString, paramInt));
  }
  
  private void b(uja paramuja, ErrorMessage paramErrorMessage)
  {
    int i = 1;
    wsv.d("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { paramuja.jdField_a_of_type_JavaLangString, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0)
    {
      if (i == 0) {
        break label147;
      }
      paramuja.jdField_b_of_type_Int = 3;
      ((uid)urr.a(28)).b(paramuja.jdField_b_of_type_JavaLangString, paramuja.jdField_a_of_type_Int);
      paramErrorMessage = ((uro)urr.a(5)).a(paramuja.jdField_b_of_type_JavaLangString);
      if (paramErrorMessage != null) {
        ujb.a(paramErrorMessage, paramuja.e, paramuja.jdField_a_of_type_Int, wta.a(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = paramuja.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof ujr))) {
        a(paramuja.jdField_b_of_type_JavaLangString, paramuja.jdField_a_of_type_Int, (ujr)paramErrorMessage);
      }
    }
    label147:
    Object localObject;
    do
    {
      return;
      i = 0;
      break;
      localObject = paramuja.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
    } while ((localObject == null) || (!(localObject instanceof ujr)));
    a(paramuja.jdField_b_of_type_JavaLangString, paramuja.jdField_a_of_type_Int, paramErrorMessage, (ujr)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.1(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, ujr paramujr)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.2(this, paramString, paramInt, paramujr, paramBoolean));
  }
  
  public void a(uja paramuja, ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.4(this, paramuja, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujq
 * JD-Core Version:    0.7.0.1
 */