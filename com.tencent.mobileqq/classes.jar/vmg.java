import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class vmg
{
  protected String a;
  public List<WeakReference<vmt>> a;
  protected Map<String, vmp> a;
  protected vmj a;
  protected vml a;
  
  public vmg()
  {
    this.jdField_a_of_type_Vml = new vml(this, null);
    this.jdField_a_of_type_Vmj = new vmj(this, null);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private boolean b(vmp paramvmp)
  {
    if ((paramvmp.d != null) && (paramvmp.d.contains("qqstocdnd")))
    {
      String str = ((vlm)vux.a(4)).a();
      xvv.a("AsyncFileDownloader", "get url key:%s", str);
      if ((str == null) || (str.equals("00"))) {
        return false;
      }
      paramvmp.d = bjnd.a(paramvmp.d, "authkey", str);
    }
    return true;
  }
  
  public void a(List<WeakReference<vmt>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      vmp localvmp = (vmp)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
      if (localvmp != null) {
        localvmp.jdField_a_of_type_Vmo.b(localvmp);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(vmp paramvmp)
  {
    paramvmp = (vmp)this.jdField_a_of_type_JavaUtilMap.remove(paramvmp.jdField_a_of_type_JavaLangString);
    if (paramvmp != null)
    {
      paramvmp.jdField_a_of_type_Vmo.b(paramvmp);
      return true;
    }
    return false;
  }
  
  public boolean a(vmp paramvmp, vmi paramvmi)
  {
    if (paramvmp == null)
    {
      xvv.d("AsyncFileDownloader", "task is empty");
      return false;
    }
    if (TextUtils.isEmpty(paramvmp.d))
    {
      if ((!yns.a(paramvmp.b)) || ((paramvmp.jdField_a_of_type_Int != 2) && (paramvmp.jdField_a_of_type_Int != 0))) {
        break label279;
      }
      QQStoryContext.a();
      localObject1 = yns.a(QQStoryContext.a(), paramvmp.b);
      if (!(localObject1 instanceof MessageForShortVideo)) {
        break label279;
      }
    }
    label279:
    for (Object localObject1 = (MessageForShortVideo)localObject1;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (paramvmi != null) {
          paramvmi.a(paramvmp, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
        localObject2 = null;
      }
      if (!ypp.a(QQStoryContext.a().a()))
      {
        if (paramvmi != null) {
          paramvmi.a(paramvmp, new ErrorMessage(9004, "no net work"));
        }
        return false;
      }
      if (!b(paramvmp))
      {
        if (paramvmi != null) {
          paramvmi.a(paramvmp, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
        }
        return false;
      }
      paramvmp.jdField_a_of_type_Vmi = paramvmi;
      paramvmp.jdField_a_of_type_Long = System.currentTimeMillis();
      if (localObject2 != null) {
        paramvmp.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localObject2;
      }
      for (paramvmp.jdField_a_of_type_Vmo = this.jdField_a_of_type_Vmj; !paramvmp.jdField_a_of_type_Vmo.a(); paramvmp.jdField_a_of_type_Vmo = this.jdField_a_of_type_Vml)
      {
        if (paramvmi != null) {
          paramvmi.a(paramvmp, new ErrorMessage(15, "downloader not prepare"));
        }
        return false;
      }
      Bosses.get().postJob(new vmh(this, "AsyncFileDownloader", paramvmp));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmg
 * JD-Core Version:    0.7.0.1
 */