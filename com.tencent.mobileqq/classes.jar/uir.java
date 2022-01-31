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

public class uir
{
  protected String a;
  public List<WeakReference<uje>> a;
  protected Map<String, uja> a;
  protected uiu a;
  protected uiw a;
  
  public uir()
  {
    this.jdField_a_of_type_Uiw = new uiw(this, null);
    this.jdField_a_of_type_Uiu = new uiu(this, null);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private boolean b(uja paramuja)
  {
    if ((paramuja.d != null) && (paramuja.d.contains("qqstocdnd")))
    {
      String str = ((uhx)urr.a(4)).a();
      wsv.a("AsyncFileDownloader", "get url key:%s", str);
      if ((str == null) || (str.equals("00"))) {
        return false;
      }
      paramuja.d = bhos.a(paramuja.d, "authkey", str);
    }
    return true;
  }
  
  public void a(List<WeakReference<uje>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      uja localuja = (uja)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
      if (localuja != null) {
        localuja.jdField_a_of_type_Uiz.b(localuja);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(uja paramuja)
  {
    paramuja = (uja)this.jdField_a_of_type_JavaUtilMap.remove(paramuja.jdField_a_of_type_JavaLangString);
    if (paramuja != null)
    {
      paramuja.jdField_a_of_type_Uiz.b(paramuja);
      return true;
    }
    return false;
  }
  
  public boolean a(uja paramuja, uit paramuit)
  {
    if (paramuja == null)
    {
      wsv.d("AsyncFileDownloader", "task is empty");
      return false;
    }
    if (TextUtils.isEmpty(paramuja.d))
    {
      if ((!xlh.a(paramuja.b)) || ((paramuja.jdField_a_of_type_Int != 2) && (paramuja.jdField_a_of_type_Int != 0))) {
        break label279;
      }
      QQStoryContext.a();
      localObject1 = xlh.a(QQStoryContext.a(), paramuja.b);
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
        if (paramuit != null) {
          paramuit.a(paramuja, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
        localObject2 = null;
      }
      if (!xne.a(QQStoryContext.a().a()))
      {
        if (paramuit != null) {
          paramuit.a(paramuja, new ErrorMessage(9004, "no net work"));
        }
        return false;
      }
      if (!b(paramuja))
      {
        if (paramuit != null) {
          paramuit.a(paramuja, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
        }
        return false;
      }
      paramuja.jdField_a_of_type_Uit = paramuit;
      paramuja.jdField_a_of_type_Long = System.currentTimeMillis();
      if (localObject2 != null) {
        paramuja.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localObject2;
      }
      for (paramuja.jdField_a_of_type_Uiz = this.jdField_a_of_type_Uiu; !paramuja.jdField_a_of_type_Uiz.a(); paramuja.jdField_a_of_type_Uiz = this.jdField_a_of_type_Uiw)
      {
        if (paramuit != null) {
          paramuit.a(paramuja, new ErrorMessage(15, "downloader not prepare"));
        }
        return false;
      }
      Bosses.get().postJob(new uis(this, "AsyncFileDownloader", paramuja));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uir
 * JD-Core Version:    0.7.0.1
 */