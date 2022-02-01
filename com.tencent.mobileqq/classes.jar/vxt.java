import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vxt
  extends JobSegment<vxd, List<wkm>>
{
  public String a;
  public wor a;
  public boolean a;
  public String b = "";
  public String c;
  
  public vxt(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.c = paramString;
  }
  
  public vxt(String paramString1, String paramString2, String paramString3, wor paramwor)
  {
    this(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_Wor = paramwor;
  }
  
  public static List<wkm> a(List<vxv> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      vxv localvxv = (vxv)paramList.next();
      if ((!TextUtils.isEmpty(localvxv.b)) && (!TextUtils.isEmpty(localvxv.jdField_a_of_type_JavaLangString)))
      {
        wkm localwkm = new wkm();
        localwkm.jdField_a_of_type_JavaLangString = localvxv.b;
        localwkm.b = localvxv.jdField_a_of_type_JavaLangString;
        localwkm.jdField_a_of_type_Long = localvxv.jdField_a_of_type_Long;
        localwkm.jdField_a_of_type_Boolean = localvxv.jdField_a_of_type_Boolean;
        localArrayList.add(localwkm);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, vxd paramvxd)
  {
    if (paramvxd == null)
    {
      xvv.d("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      yos.a("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    xvv.b("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.c, paramvxd.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Wor, Integer.valueOf(paramvxd.jdField_a_of_type_JavaUtilList.size()), paramvxd.k });
    if (TextUtils.isEmpty(paramvxd.jdField_a_of_type_JavaLangString))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((paramvxd.jdField_a_of_type_JavaUtilList.size() == 0) && (paramvxd.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramvxd });
      }
      if (paramvxd.jdField_a_of_type_Int == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((paramvxd.a()) && (paramvxd.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", paramvxd });
      }
      notifyResult(a(paramvxd.jdField_a_of_type_JavaUtilList));
      return;
    }
    paramJobContext = null;
    if (paramvxd.jdField_a_of_type_Int != 12) {
      paramJobContext = vxw.a(paramvxd);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramvxd);
      }
      xvv.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = vyj.a(paramvxd, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = a(paramJobContext.a.jdField_a_of_type_JavaUtilList);
        notifyResult(paramJobContext);
        xvv.a("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      xvv.b("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      xvv.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_Wor != null) && (this.jdField_a_of_type_Wor.jdField_a_of_type_Boolean))
    {
      xvv.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    xvv.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new vyj(paramvxd, this.jdField_a_of_type_JavaLangString, this.b);
    xvv.a("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((paramvxd.jdField_a_of_type_Int == 12) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      xvv.b("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      paramvxd.jdField_a_of_type_JavaUtilList.clear();
    }
    vqn.a().a(paramJobContext, new vxu(this, paramvxd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxt
 * JD-Core Version:    0.7.0.1
 */