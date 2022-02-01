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

public class wlg
  implements wkj
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Map<String, wkq> jdField_a_of_type_JavaUtilMap = new HashMap();
  private wkh jdField_a_of_type_Wkh = new wkh();
  private Handler b = new Handler(Looper.getMainLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, wlh paramwlh)
  {
    if (paramwlh == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.7(this, paramwlh, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, wlh paramwlh)
  {
    if (paramwlh == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.5(this, paramwlh, paramString, paramInt));
  }
  
  private void b(String paramString, int paramInt, wlh paramwlh)
  {
    if (paramwlh == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.6(this, paramwlh, paramString, paramInt));
  }
  
  private void b(wkq paramwkq, ErrorMessage paramErrorMessage)
  {
    int i = 1;
    yuk.d("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { paramwkq.jdField_a_of_type_JavaLangString, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0)
    {
      if (i == 0) {
        break label147;
      }
      paramwkq.jdField_b_of_type_Int = 3;
      ((wjt)wth.a(28)).b(paramwkq.jdField_b_of_type_JavaLangString, paramwkq.jdField_a_of_type_Int);
      paramErrorMessage = ((wte)wth.a(5)).a(paramwkq.jdField_b_of_type_JavaLangString);
      if (paramErrorMessage != null) {
        wkr.a(paramErrorMessage, paramwkq.e, paramwkq.jdField_a_of_type_Int, yup.a(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = paramwkq.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof wlh))) {
        a(paramwkq.jdField_b_of_type_JavaLangString, paramwkq.jdField_a_of_type_Int, (wlh)paramErrorMessage);
      }
    }
    label147:
    Object localObject;
    do
    {
      return;
      i = 0;
      break;
      localObject = paramwkq.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
    } while ((localObject == null) || (!(localObject instanceof wlh)));
    a(paramwkq.jdField_b_of_type_JavaLangString, paramwkq.jdField_a_of_type_Int, paramErrorMessage, (wlh)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.1(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, wlh paramwlh)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.2(this, paramString, paramInt, paramwlh, paramBoolean));
  }
  
  public void a(wkq paramwkq, ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.4(this, paramwkq, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlg
 * JD-Core Version:    0.7.0.1
 */