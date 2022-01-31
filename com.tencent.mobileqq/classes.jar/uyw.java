import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uyw
  extends JobSegment<uyg, List<vlp>>
{
  public String a;
  public vqa a;
  public boolean a;
  public String b = "";
  public String c;
  
  public uyw(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.c = paramString;
  }
  
  public uyw(String paramString1, String paramString2, String paramString3, vqa paramvqa)
  {
    this(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_Vqa = paramvqa;
  }
  
  public static List<vlp> a(List<uyy> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uyy localuyy = (uyy)paramList.next();
      if ((!TextUtils.isEmpty(localuyy.b)) && (!TextUtils.isEmpty(localuyy.jdField_a_of_type_JavaLangString)))
      {
        vlp localvlp = new vlp();
        localvlp.jdField_a_of_type_JavaLangString = localuyy.b;
        localvlp.b = localuyy.jdField_a_of_type_JavaLangString;
        localvlp.jdField_a_of_type_Long = localuyy.jdField_a_of_type_Long;
        localvlp.jdField_a_of_type_Boolean = localuyy.jdField_a_of_type_Boolean;
        localArrayList.add(localvlp);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, uyg paramuyg)
  {
    if (paramuyg == null)
    {
      wxe.d("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      xqq.a("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    wxe.b("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.c, paramuyg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Vqa, Integer.valueOf(paramuyg.jdField_a_of_type_JavaUtilList.size()), paramuyg.k });
    if (TextUtils.isEmpty(paramuyg.jdField_a_of_type_JavaLangString))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((paramuyg.jdField_a_of_type_JavaUtilList.size() == 0) && (paramuyg.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramuyg });
      }
      if (paramuyg.jdField_a_of_type_Int == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((paramuyg.a()) && (paramuyg.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", paramuyg });
      }
      notifyResult(a(paramuyg.jdField_a_of_type_JavaUtilList));
      return;
    }
    paramJobContext = null;
    if (paramuyg.jdField_a_of_type_Int != 12) {
      paramJobContext = uyz.a(paramuyg);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramuyg);
      }
      wxe.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = uzm.a(paramuyg, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = a(paramJobContext.a.jdField_a_of_type_JavaUtilList);
        notifyResult(paramJobContext);
        wxe.a("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      wxe.b("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      wxe.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_Vqa != null) && (this.jdField_a_of_type_Vqa.jdField_a_of_type_Boolean))
    {
      wxe.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    wxe.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new uzm(paramuyg, this.jdField_a_of_type_JavaLangString, this.b);
    wxe.a("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((paramuyg.jdField_a_of_type_Int == 12) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      wxe.b("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      paramuyg.jdField_a_of_type_JavaUtilList.clear();
    }
    urp.a().a(paramJobContext, new uyx(this, paramuyg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uyw
 * JD-Core Version:    0.7.0.1
 */