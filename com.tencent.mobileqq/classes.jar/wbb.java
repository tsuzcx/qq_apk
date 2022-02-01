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

public class wbb
{
  protected String a;
  public List<WeakReference<wbo>> a;
  protected Map<String, wbk> a;
  protected wbe a;
  protected wbg a;
  
  public wbb()
  {
    this.jdField_a_of_type_Wbg = new wbg(this, null);
    this.jdField_a_of_type_Wbe = new wbe(this, null);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private boolean b(wbk paramwbk)
  {
    if ((paramwbk.d != null) && (paramwbk.d.contains("qqstocdnd")))
    {
      String str = ((wah)wjs.a(4)).a();
      ykq.a("AsyncFileDownloader", "get url key:%s", str);
      if ((str == null) || (str.equals("00"))) {
        return false;
      }
      paramwbk.d = bkyp.a(paramwbk.d, "authkey", str);
    }
    return true;
  }
  
  public void a(List<WeakReference<wbo>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      wbk localwbk = (wbk)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
      if (localwbk != null) {
        localwbk.jdField_a_of_type_Wbj.b(localwbk);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(wbk paramwbk)
  {
    paramwbk = (wbk)this.jdField_a_of_type_JavaUtilMap.remove(paramwbk.jdField_a_of_type_JavaLangString);
    if (paramwbk != null)
    {
      paramwbk.jdField_a_of_type_Wbj.b(paramwbk);
      return true;
    }
    return false;
  }
  
  public boolean a(wbk paramwbk, wbd paramwbd)
  {
    if (paramwbk == null)
    {
      ykq.d("AsyncFileDownloader", "task is empty");
      return false;
    }
    if (TextUtils.isEmpty(paramwbk.d))
    {
      if ((!zcl.a(paramwbk.b)) || ((paramwbk.jdField_a_of_type_Int != 2) && (paramwbk.jdField_a_of_type_Int != 0))) {
        break label279;
      }
      QQStoryContext.a();
      localObject1 = zcl.a(QQStoryContext.a(), paramwbk.b);
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
        if (paramwbd != null) {
          paramwbd.a(paramwbk, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
        localObject2 = null;
      }
      if (!zei.a(QQStoryContext.a().a()))
      {
        if (paramwbd != null) {
          paramwbd.a(paramwbk, new ErrorMessage(9004, "no net work"));
        }
        return false;
      }
      if (!b(paramwbk))
      {
        if (paramwbd != null) {
          paramwbd.a(paramwbk, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
        }
        return false;
      }
      paramwbk.jdField_a_of_type_Wbd = paramwbd;
      paramwbk.jdField_a_of_type_Long = System.currentTimeMillis();
      if (localObject2 != null) {
        paramwbk.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localObject2;
      }
      for (paramwbk.jdField_a_of_type_Wbj = this.jdField_a_of_type_Wbe; !paramwbk.jdField_a_of_type_Wbj.a(); paramwbk.jdField_a_of_type_Wbj = this.jdField_a_of_type_Wbg)
      {
        if (paramwbd != null) {
          paramwbd.a(paramwbk, new ErrorMessage(15, "downloader not prepare"));
        }
        return false;
      }
      Bosses.get().postJob(new wbc(this, "AsyncFileDownloader", paramwbk));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbb
 * JD-Core Version:    0.7.0.1
 */