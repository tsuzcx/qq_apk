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

public class wkh
{
  protected String a;
  public List<WeakReference<wku>> a;
  protected Map<String, wkq> a;
  protected wkk a;
  protected wkm a;
  
  public wkh()
  {
    this.jdField_a_of_type_Wkm = new wkm(this, null);
    this.jdField_a_of_type_Wkk = new wkk(this, null);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private boolean b(wkq paramwkq)
  {
    if ((paramwkq.d != null) && (paramwkq.d.contains("qqstocdnd")))
    {
      String str = ((wjn)wth.a(4)).a();
      yuk.a("AsyncFileDownloader", "get url key:%s", str);
      if ((str == null) || (str.equals("00"))) {
        return false;
      }
      paramwkq.d = blhn.a(paramwkq.d, "authkey", str);
    }
    return true;
  }
  
  public void a(List<WeakReference<wku>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      wkq localwkq = (wkq)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
      if (localwkq != null) {
        localwkq.jdField_a_of_type_Wkp.b(localwkq);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(wkq paramwkq)
  {
    paramwkq = (wkq)this.jdField_a_of_type_JavaUtilMap.remove(paramwkq.jdField_a_of_type_JavaLangString);
    if (paramwkq != null)
    {
      paramwkq.jdField_a_of_type_Wkp.b(paramwkq);
      return true;
    }
    return false;
  }
  
  public boolean a(wkq paramwkq, wkj paramwkj)
  {
    if (paramwkq == null)
    {
      yuk.d("AsyncFileDownloader", "task is empty");
      return false;
    }
    if (TextUtils.isEmpty(paramwkq.d))
    {
      if ((!zmw.a(paramwkq.b)) || ((paramwkq.jdField_a_of_type_Int != 2) && (paramwkq.jdField_a_of_type_Int != 0))) {
        break label279;
      }
      QQStoryContext.a();
      localObject1 = zmw.a(QQStoryContext.a(), paramwkq.b);
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
        if (paramwkj != null) {
          paramwkj.a(paramwkq, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
        localObject2 = null;
      }
      if (!zot.a(QQStoryContext.a().a()))
      {
        if (paramwkj != null) {
          paramwkj.a(paramwkq, new ErrorMessage(9004, "no net work"));
        }
        return false;
      }
      if (!b(paramwkq))
      {
        if (paramwkj != null) {
          paramwkj.a(paramwkq, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
        }
        return false;
      }
      paramwkq.jdField_a_of_type_Wkj = paramwkj;
      paramwkq.jdField_a_of_type_Long = System.currentTimeMillis();
      if (localObject2 != null) {
        paramwkq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localObject2;
      }
      for (paramwkq.jdField_a_of_type_Wkp = this.jdField_a_of_type_Wkk; !paramwkq.jdField_a_of_type_Wkp.a(); paramwkq.jdField_a_of_type_Wkp = this.jdField_a_of_type_Wkm)
      {
        if (paramwkj != null) {
          paramwkj.a(paramwkq, new ErrorMessage(15, "downloader not prepare"));
        }
        return false;
      }
      Bosses.get().postJob(new wki(this, "AsyncFileDownloader", paramwkq));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkh
 * JD-Core Version:    0.7.0.1
 */