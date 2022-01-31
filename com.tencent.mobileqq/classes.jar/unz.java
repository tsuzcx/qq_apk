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

public class unz
  implements unc
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Map<String, unj> jdField_a_of_type_JavaUtilMap = new HashMap();
  private una jdField_a_of_type_Una = new una();
  private Handler b = new Handler(Looper.getMainLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, uoa paramuoa)
  {
    if (paramuoa == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.7(this, paramuoa, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, uoa paramuoa)
  {
    if (paramuoa == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.5(this, paramuoa, paramString, paramInt));
  }
  
  private void b(String paramString, int paramInt, uoa paramuoa)
  {
    if (paramuoa == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.6(this, paramuoa, paramString, paramInt));
  }
  
  private void b(unj paramunj, ErrorMessage paramErrorMessage)
  {
    int i = 1;
    wxe.d("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { paramunj.jdField_a_of_type_JavaLangString, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0)
    {
      if (i == 0) {
        break label147;
      }
      paramunj.jdField_b_of_type_Int = 3;
      ((umm)uwa.a(28)).b(paramunj.jdField_b_of_type_JavaLangString, paramunj.jdField_a_of_type_Int);
      paramErrorMessage = ((uvx)uwa.a(5)).a(paramunj.jdField_b_of_type_JavaLangString);
      if (paramErrorMessage != null) {
        unk.a(paramErrorMessage, paramunj.e, paramunj.jdField_a_of_type_Int, wxj.a(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = paramunj.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof uoa))) {
        a(paramunj.jdField_b_of_type_JavaLangString, paramunj.jdField_a_of_type_Int, (uoa)paramErrorMessage);
      }
    }
    label147:
    Object localObject;
    do
    {
      return;
      i = 0;
      break;
      localObject = paramunj.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
    } while ((localObject == null) || (!(localObject instanceof uoa)));
    a(paramunj.jdField_b_of_type_JavaLangString, paramunj.jdField_a_of_type_Int, paramErrorMessage, (uoa)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.1(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, uoa paramuoa)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.2(this, paramString, paramInt, paramuoa, paramBoolean));
  }
  
  public void a(unj paramunj, ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.4(this, paramunj, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unz
 * JD-Core Version:    0.7.0.1
 */