import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uun
  extends JobSegment<utx, List<vhg>>
{
  public String a;
  public vlr a;
  public boolean a;
  public String b = "";
  public String c;
  
  public uun(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.c = paramString;
  }
  
  public uun(String paramString1, String paramString2, String paramString3, vlr paramvlr)
  {
    this(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_Vlr = paramvlr;
  }
  
  public static List<vhg> a(List<uup> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uup localuup = (uup)paramList.next();
      if ((!TextUtils.isEmpty(localuup.b)) && (!TextUtils.isEmpty(localuup.jdField_a_of_type_JavaLangString)))
      {
        vhg localvhg = new vhg();
        localvhg.jdField_a_of_type_JavaLangString = localuup.b;
        localvhg.b = localuup.jdField_a_of_type_JavaLangString;
        localvhg.jdField_a_of_type_Long = localuup.jdField_a_of_type_Long;
        localvhg.jdField_a_of_type_Boolean = localuup.jdField_a_of_type_Boolean;
        localArrayList.add(localvhg);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, utx paramutx)
  {
    if (paramutx == null)
    {
      wsv.d("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      xmh.a("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    wsv.b("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.c, paramutx.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Vlr, Integer.valueOf(paramutx.jdField_a_of_type_JavaUtilList.size()), paramutx.k });
    if (TextUtils.isEmpty(paramutx.jdField_a_of_type_JavaLangString))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((paramutx.jdField_a_of_type_JavaUtilList.size() == 0) && (paramutx.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramutx });
      }
      if (paramutx.jdField_a_of_type_Int == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((paramutx.a()) && (paramutx.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", paramutx });
      }
      notifyResult(a(paramutx.jdField_a_of_type_JavaUtilList));
      return;
    }
    paramJobContext = null;
    if (paramutx.jdField_a_of_type_Int != 12) {
      paramJobContext = uuq.a(paramutx);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramutx);
      }
      wsv.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = uvd.a(paramutx, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = a(paramJobContext.a.jdField_a_of_type_JavaUtilList);
        notifyResult(paramJobContext);
        wsv.a("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      wsv.b("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      wsv.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_Vlr != null) && (this.jdField_a_of_type_Vlr.jdField_a_of_type_Boolean))
    {
      wsv.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    wsv.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new uvd(paramutx, this.jdField_a_of_type_JavaLangString, this.b);
    wsv.a("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((paramutx.jdField_a_of_type_Int == 12) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      wsv.b("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      paramutx.jdField_a_of_type_JavaUtilList.clear();
    }
    ung.a().a(paramJobContext, new uuo(this, paramutx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uun
 * JD-Core Version:    0.7.0.1
 */