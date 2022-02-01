import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wmo
  extends JobSegment<wly, List<wzh>>
{
  public String a;
  public xdm a;
  public boolean a;
  public String b = "";
  public String c;
  
  public wmo(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.c = paramString;
  }
  
  public wmo(String paramString1, String paramString2, String paramString3, xdm paramxdm)
  {
    this(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_Xdm = paramxdm;
  }
  
  public static List<wzh> a(List<wmq> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wmq localwmq = (wmq)paramList.next();
      if ((!TextUtils.isEmpty(localwmq.b)) && (!TextUtils.isEmpty(localwmq.jdField_a_of_type_JavaLangString)))
      {
        wzh localwzh = new wzh();
        localwzh.jdField_a_of_type_JavaLangString = localwmq.b;
        localwzh.b = localwmq.jdField_a_of_type_JavaLangString;
        localwzh.jdField_a_of_type_Long = localwmq.jdField_a_of_type_Long;
        localwzh.jdField_a_of_type_Boolean = localwmq.jdField_a_of_type_Boolean;
        localArrayList.add(localwzh);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, wly paramwly)
  {
    if (paramwly == null)
    {
      ykq.d("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      zdl.a("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    ykq.b("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.c, paramwly.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Xdm, Integer.valueOf(paramwly.jdField_a_of_type_JavaUtilList.size()), paramwly.k });
    if (TextUtils.isEmpty(paramwly.jdField_a_of_type_JavaLangString))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((paramwly.jdField_a_of_type_JavaUtilList.size() == 0) && (paramwly.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramwly });
      }
      if (paramwly.jdField_a_of_type_Int == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((paramwly.a()) && (paramwly.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", paramwly });
      }
      notifyResult(a(paramwly.jdField_a_of_type_JavaUtilList));
      return;
    }
    paramJobContext = null;
    if (paramwly.jdField_a_of_type_Int != 12) {
      paramJobContext = wmr.a(paramwly);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramwly);
      }
      ykq.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = wne.a(paramwly, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = a(paramJobContext.a.jdField_a_of_type_JavaUtilList);
        notifyResult(paramJobContext);
        ykq.a("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      ykq.b("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ykq.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_Xdm != null) && (this.jdField_a_of_type_Xdm.jdField_a_of_type_Boolean))
    {
      ykq.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    ykq.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new wne(paramwly, this.jdField_a_of_type_JavaLangString, this.b);
    ykq.a("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((paramwly.jdField_a_of_type_Int == 12) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      ykq.b("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      paramwly.jdField_a_of_type_JavaUtilList.clear();
    }
    wfi.a().a(paramJobContext, new wmp(this, paramwly));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmo
 * JD-Core Version:    0.7.0.1
 */