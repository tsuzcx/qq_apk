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

public class wca
  implements wbd
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Map<String, wbk> jdField_a_of_type_JavaUtilMap = new HashMap();
  private wbb jdField_a_of_type_Wbb = new wbb();
  private Handler b = new Handler(Looper.getMainLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, wcb paramwcb)
  {
    if (paramwcb == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.7(this, paramwcb, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, wcb paramwcb)
  {
    if (paramwcb == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.5(this, paramwcb, paramString, paramInt));
  }
  
  private void b(String paramString, int paramInt, wcb paramwcb)
  {
    if (paramwcb == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.6(this, paramwcb, paramString, paramInt));
  }
  
  private void b(wbk paramwbk, ErrorMessage paramErrorMessage)
  {
    int i = 1;
    ykq.d("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { paramwbk.jdField_a_of_type_JavaLangString, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0)
    {
      if (i == 0) {
        break label147;
      }
      paramwbk.jdField_b_of_type_Int = 3;
      ((wan)wjs.a(28)).b(paramwbk.jdField_b_of_type_JavaLangString, paramwbk.jdField_a_of_type_Int);
      paramErrorMessage = ((wjp)wjs.a(5)).a(paramwbk.jdField_b_of_type_JavaLangString);
      if (paramErrorMessage != null) {
        wbl.a(paramErrorMessage, paramwbk.e, paramwbk.jdField_a_of_type_Int, ykv.a(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = paramwbk.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof wcb))) {
        a(paramwbk.jdField_b_of_type_JavaLangString, paramwbk.jdField_a_of_type_Int, (wcb)paramErrorMessage);
      }
    }
    label147:
    Object localObject;
    do
    {
      return;
      i = 0;
      break;
      localObject = paramwbk.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
    } while ((localObject == null) || (!(localObject instanceof wcb)));
    a(paramwbk.jdField_b_of_type_JavaLangString, paramwbk.jdField_a_of_type_Int, paramErrorMessage, (wcb)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.1(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, wcb paramwcb)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.2(this, paramString, paramInt, paramwcb, paramBoolean));
  }
  
  public void a(wbk paramwbk, ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.4(this, paramwbk, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wca
 * JD-Core Version:    0.7.0.1
 */