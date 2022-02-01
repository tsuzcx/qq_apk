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

public class vnf
  implements vmi
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Map<String, vmp> jdField_a_of_type_JavaUtilMap = new HashMap();
  private vmg jdField_a_of_type_Vmg = new vmg();
  private Handler b = new Handler(Looper.getMainLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, vng paramvng)
  {
    if (paramvng == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.7(this, paramvng, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, vng paramvng)
  {
    if (paramvng == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.5(this, paramvng, paramString, paramInt));
  }
  
  private void b(String paramString, int paramInt, vng paramvng)
  {
    if (paramvng == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.6(this, paramvng, paramString, paramInt));
  }
  
  private void b(vmp paramvmp, ErrorMessage paramErrorMessage)
  {
    int i = 1;
    xvv.d("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { paramvmp.jdField_a_of_type_JavaLangString, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0)
    {
      if (i == 0) {
        break label147;
      }
      paramvmp.jdField_b_of_type_Int = 3;
      ((vls)vux.a(28)).b(paramvmp.jdField_b_of_type_JavaLangString, paramvmp.jdField_a_of_type_Int);
      paramErrorMessage = ((vuu)vux.a(5)).a(paramvmp.jdField_b_of_type_JavaLangString);
      if (paramErrorMessage != null) {
        vmq.a(paramErrorMessage, paramvmp.e, paramvmp.jdField_a_of_type_Int, xwa.a(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = paramvmp.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof vng))) {
        a(paramvmp.jdField_b_of_type_JavaLangString, paramvmp.jdField_a_of_type_Int, (vng)paramErrorMessage);
      }
    }
    label147:
    Object localObject;
    do
    {
      return;
      i = 0;
      break;
      localObject = paramvmp.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
    } while ((localObject == null) || (!(localObject instanceof vng)));
    a(paramvmp.jdField_b_of_type_JavaLangString, paramvmp.jdField_a_of_type_Int, paramErrorMessage, (vng)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.1(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, vng paramvng)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.2(this, paramString, paramInt, paramvng, paramBoolean));
  }
  
  public void a(vmp paramvmp, ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.4(this, paramvmp, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnf
 * JD-Core Version:    0.7.0.1
 */