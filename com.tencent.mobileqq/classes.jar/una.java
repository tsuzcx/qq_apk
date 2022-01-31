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

public class una
{
  protected String a;
  public List<WeakReference<unn>> a;
  protected Map<String, unj> a;
  protected und a;
  protected unf a;
  
  public una()
  {
    this.jdField_a_of_type_Unf = new unf(this, null);
    this.jdField_a_of_type_Und = new und(this, null);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private boolean b(unj paramunj)
  {
    if ((paramunj.d != null) && (paramunj.d.contains("qqstocdnd")))
    {
      String str = ((umg)uwa.a(4)).a();
      wxe.a("AsyncFileDownloader", "get url key:%s", str);
      if ((str == null) || (str.equals("00"))) {
        return false;
      }
      paramunj.d = bhsz.a(paramunj.d, "authkey", str);
    }
    return true;
  }
  
  public void a(List<WeakReference<unn>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      unj localunj = (unj)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
      if (localunj != null) {
        localunj.jdField_a_of_type_Uni.b(localunj);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(unj paramunj)
  {
    paramunj = (unj)this.jdField_a_of_type_JavaUtilMap.remove(paramunj.jdField_a_of_type_JavaLangString);
    if (paramunj != null)
    {
      paramunj.jdField_a_of_type_Uni.b(paramunj);
      return true;
    }
    return false;
  }
  
  public boolean a(unj paramunj, unc paramunc)
  {
    if (paramunj == null)
    {
      wxe.d("AsyncFileDownloader", "task is empty");
      return false;
    }
    if (TextUtils.isEmpty(paramunj.d))
    {
      if ((!xpq.a(paramunj.b)) || ((paramunj.jdField_a_of_type_Int != 2) && (paramunj.jdField_a_of_type_Int != 0))) {
        break label279;
      }
      QQStoryContext.a();
      localObject1 = xpq.a(QQStoryContext.a(), paramunj.b);
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
        if (paramunc != null) {
          paramunc.a(paramunj, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
        localObject2 = null;
      }
      if (!xrn.a(QQStoryContext.a().a()))
      {
        if (paramunc != null) {
          paramunc.a(paramunj, new ErrorMessage(9004, "no net work"));
        }
        return false;
      }
      if (!b(paramunj))
      {
        if (paramunc != null) {
          paramunc.a(paramunj, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
        }
        return false;
      }
      paramunj.jdField_a_of_type_Unc = paramunc;
      paramunj.jdField_a_of_type_Long = System.currentTimeMillis();
      if (localObject2 != null) {
        paramunj.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localObject2;
      }
      for (paramunj.jdField_a_of_type_Uni = this.jdField_a_of_type_Und; !paramunj.jdField_a_of_type_Uni.a(); paramunj.jdField_a_of_type_Uni = this.jdField_a_of_type_Unf)
      {
        if (paramunc != null) {
          paramunc.a(paramunj, new ErrorMessage(15, "downloader not prepare"));
        }
        return false;
      }
      Bosses.get().postJob(new unb(this, "AsyncFileDownloader", paramunj));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     una
 * JD-Core Version:    0.7.0.1
 */