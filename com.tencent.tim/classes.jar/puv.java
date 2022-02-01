import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class puv
  extends JobSegment<puh, List<qej>>
{
  public qhc.a a;
  public boolean aBQ;
  public String mCookie = "";
  public String mFrom;
  public String mStartVid = "";
  
  public puv(String paramString)
  {
    this.mFrom = paramString;
  }
  
  public puv(String paramString1, String paramString2, String paramString3, qhc.a parama)
  {
    this(paramString1);
    this.mCookie = paramString2;
    this.mStartVid = paramString3;
    this.a = parama;
  }
  
  public static List<qej> an(List<pux> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      pux localpux = (pux)paramList.next();
      if ((!TextUtils.isEmpty(localpux.feedId)) && (!TextUtils.isEmpty(localpux.vid)))
      {
        qej localqej = new qej();
        localqej.feedId = localpux.feedId;
        localqej.vid = localpux.vid;
        localqej.Ak = localpux.Ak;
        localqej.aBR = localpux.aBR;
        localArrayList.add(localqej);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, puh parampuh)
  {
    if (parampuh == null)
    {
      ram.w("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      rom.fail("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    ram.d("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.mFrom, parampuh.unionId, this.mCookie, this.mStartVid, this.a, Integer.valueOf(parampuh.iO.size()), parampuh.passthrough });
    if (TextUtils.isEmpty(parampuh.unionId))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((parampuh.iO.size() == 0) && (parampuh.nodeType != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", parampuh });
      }
      if (parampuh.nodeType == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((parampuh.Ja()) && (parampuh.nodeType != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", parampuh });
      }
      notifyResult(an(parampuh.iO));
      return;
    }
    paramJobContext = null;
    if (parampuh.nodeType != 12) {
      paramJobContext = puy.a(parampuh);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + parampuh);
      }
      ram.d("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = pvg.a(parampuh, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = an(paramJobContext.b.iO);
        notifyResult(paramJobContext);
        ram.b("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      ram.d("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.aBQ)
    {
      ram.d("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    if ((this.a != null) && (this.a.mIsEnd))
    {
      ram.d("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    ram.d("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new pvg(parampuh, this.mCookie, this.mStartVid);
    ram.b("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((parampuh.nodeType == 12) && (TextUtils.isEmpty(this.mCookie)))
    {
      ram.d("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      parampuh.iO.clear();
    }
    ppv.a().a(paramJobContext, new puw(this, parampuh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     puv
 * JD-Core Version:    0.7.0.1
 */