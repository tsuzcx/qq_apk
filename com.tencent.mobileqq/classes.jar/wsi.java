import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wsi
  extends JobSegment<wrs, List<xfb>>
{
  public String a;
  public xjl a;
  public boolean a;
  public String b = "";
  public String c;
  
  public wsi(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.c = paramString;
  }
  
  public wsi(String paramString1, String paramString2, String paramString3, xjl paramxjl)
  {
    this(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_Xjl = paramxjl;
  }
  
  public static List<xfb> a(List<wsk> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wsk localwsk = (wsk)paramList.next();
      if ((!TextUtils.isEmpty(localwsk.b)) && (!TextUtils.isEmpty(localwsk.jdField_a_of_type_JavaLangString)))
      {
        xfb localxfb = new xfb();
        localxfb.jdField_a_of_type_JavaLangString = localwsk.b;
        localxfb.b = localwsk.jdField_a_of_type_JavaLangString;
        localxfb.jdField_a_of_type_Long = localwsk.jdField_a_of_type_Long;
        localxfb.jdField_a_of_type_Boolean = localwsk.jdField_a_of_type_Boolean;
        localArrayList.add(localxfb);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, wrs paramwrs)
  {
    if (paramwrs == null)
    {
      yqp.d("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      zkb.a("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    yqp.b("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.c, paramwrs.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Xjl, Integer.valueOf(paramwrs.jdField_a_of_type_JavaUtilList.size()), paramwrs.k });
    if (TextUtils.isEmpty(paramwrs.jdField_a_of_type_JavaLangString))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((paramwrs.jdField_a_of_type_JavaUtilList.size() == 0) && (paramwrs.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramwrs });
      }
      if (paramwrs.jdField_a_of_type_Int == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((paramwrs.a()) && (paramwrs.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", paramwrs });
      }
      notifyResult(a(paramwrs.jdField_a_of_type_JavaUtilList));
      return;
    }
    paramJobContext = null;
    if (paramwrs.jdField_a_of_type_Int != 12) {
      paramJobContext = wsl.a(paramwrs);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramwrs);
      }
      yqp.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = wsy.a(paramwrs, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = a(paramJobContext.a.jdField_a_of_type_JavaUtilList);
        notifyResult(paramJobContext);
        yqp.a("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      yqp.b("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      yqp.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_Xjl != null) && (this.jdField_a_of_type_Xjl.jdField_a_of_type_Boolean))
    {
      yqp.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    yqp.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new wsy(paramwrs, this.jdField_a_of_type_JavaLangString, this.b);
    yqp.a("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((paramwrs.jdField_a_of_type_Int == 12) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      yqp.b("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      paramwrs.jdField_a_of_type_JavaUtilList.clear();
    }
    wlb.a().a(paramJobContext, new wsj(this, paramwrs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsi
 * JD-Core Version:    0.7.0.1
 */