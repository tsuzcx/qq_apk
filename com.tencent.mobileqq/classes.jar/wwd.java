import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wwd
  extends JobSegment<wvn, List<xiw>>
{
  public String a;
  public xng a;
  public boolean a;
  public String b = "";
  public String c;
  
  public wwd(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.c = paramString;
  }
  
  public wwd(String paramString1, String paramString2, String paramString3, xng paramxng)
  {
    this(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_Xng = paramxng;
  }
  
  public static List<xiw> a(List<wwf> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wwf localwwf = (wwf)paramList.next();
      if ((!TextUtils.isEmpty(localwwf.b)) && (!TextUtils.isEmpty(localwwf.jdField_a_of_type_JavaLangString)))
      {
        xiw localxiw = new xiw();
        localxiw.jdField_a_of_type_JavaLangString = localwwf.b;
        localxiw.b = localwwf.jdField_a_of_type_JavaLangString;
        localxiw.jdField_a_of_type_Long = localwwf.jdField_a_of_type_Long;
        localxiw.jdField_a_of_type_Boolean = localwwf.jdField_a_of_type_Boolean;
        localArrayList.add(localxiw);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, wvn paramwvn)
  {
    if (paramwvn == null)
    {
      yuk.d("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      znw.a("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    yuk.b("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.c, paramwvn.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Xng, Integer.valueOf(paramwvn.jdField_a_of_type_JavaUtilList.size()), paramwvn.k });
    if (TextUtils.isEmpty(paramwvn.jdField_a_of_type_JavaLangString))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((paramwvn.jdField_a_of_type_JavaUtilList.size() == 0) && (paramwvn.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramwvn });
      }
      if (paramwvn.jdField_a_of_type_Int == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((paramwvn.a()) && (paramwvn.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", paramwvn });
      }
      notifyResult(a(paramwvn.jdField_a_of_type_JavaUtilList));
      return;
    }
    paramJobContext = null;
    if (paramwvn.jdField_a_of_type_Int != 12) {
      paramJobContext = wwg.a(paramwvn);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramwvn);
      }
      yuk.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = wwt.a(paramwvn, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = a(paramJobContext.a.jdField_a_of_type_JavaUtilList);
        notifyResult(paramJobContext);
        yuk.a("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      yuk.b("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      yuk.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_Xng != null) && (this.jdField_a_of_type_Xng.jdField_a_of_type_Boolean))
    {
      yuk.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    yuk.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new wwt(paramwvn, this.jdField_a_of_type_JavaLangString, this.b);
    yuk.a("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((paramwvn.jdField_a_of_type_Int == 12) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      yuk.b("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      paramwvn.jdField_a_of_type_JavaUtilList.clear();
    }
    wow.a().a(paramJobContext, new wwe(this, paramwvn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwd
 * JD-Core Version:    0.7.0.1
 */