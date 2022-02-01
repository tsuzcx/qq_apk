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

public class whl
  implements wgo
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Map<String, wgv> jdField_a_of_type_JavaUtilMap = new HashMap();
  private wgm jdField_a_of_type_Wgm = new wgm();
  private Handler b = new Handler(Looper.getMainLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, whm paramwhm)
  {
    if (paramwhm == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.7(this, paramwhm, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, whm paramwhm)
  {
    if (paramwhm == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.5(this, paramwhm, paramString, paramInt));
  }
  
  private void b(String paramString, int paramInt, whm paramwhm)
  {
    if (paramwhm == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.6(this, paramwhm, paramString, paramInt));
  }
  
  private void b(wgv paramwgv, ErrorMessage paramErrorMessage)
  {
    int i = 1;
    yqp.d("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { paramwgv.jdField_a_of_type_JavaLangString, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0)
    {
      if (i == 0) {
        break label147;
      }
      paramwgv.jdField_b_of_type_Int = 3;
      ((wfy)wpm.a(28)).b(paramwgv.jdField_b_of_type_JavaLangString, paramwgv.jdField_a_of_type_Int);
      paramErrorMessage = ((wpj)wpm.a(5)).a(paramwgv.jdField_b_of_type_JavaLangString);
      if (paramErrorMessage != null) {
        wgw.a(paramErrorMessage, paramwgv.e, paramwgv.jdField_a_of_type_Int, yqu.a(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = paramwgv.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof whm))) {
        a(paramwgv.jdField_b_of_type_JavaLangString, paramwgv.jdField_a_of_type_Int, (whm)paramErrorMessage);
      }
    }
    label147:
    Object localObject;
    do
    {
      return;
      i = 0;
      break;
      localObject = paramwgv.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
    } while ((localObject == null) || (!(localObject instanceof whm)));
    a(paramwgv.jdField_b_of_type_JavaLangString, paramwgv.jdField_a_of_type_Int, paramErrorMessage, (whm)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.1(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, whm paramwhm)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.2(this, paramString, paramInt, paramwhm, paramBoolean));
  }
  
  public void a(wgv paramwgv, ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.4(this, paramwgv, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whl
 * JD-Core Version:    0.7.0.1
 */