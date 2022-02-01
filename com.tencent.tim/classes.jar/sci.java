import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.DoCommentRequest;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.subscribe.network.DoReplyReq;
import com.tencent.biz.subscribe.network.GetCommentListRequest;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sci
{
  private static final String TAG = sci.class.getSimpleName();
  private Map<String, ArrayList<CertifiedAccountMeta.StComment>> fh = new HashMap();
  private Map<String, Integer> fi = new HashMap();
  private Map<String, sci.a> fj = new HashMap();
  private Handler mMainHandler;
  
  private String a(COMM.StCommonExt paramStCommonExt)
  {
    if ((paramStCommonExt != null) && (paramStCommonExt.mapInfo.size() > 0)) {
      return ((COMM.Entry)paramStCommonExt.mapInfo.get(0)).value.get();
    }
    return "";
  }
  
  private void a(String paramString, COMM.StCommonExt paramStCommonExt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.fj.get(paramString) == null)
    {
      sci.a locala = new sci.a();
      locala.d = paramStCommonExt;
      locala.hasMore = paramBoolean1;
      locala.axb = paramBoolean2;
      this.fj.put(paramString, locala);
      QLog.d(TAG, 1, "getDetailCommentSize: attachInfo:" + paramStCommonExt.attachInfo.get());
      return;
    }
    ((sci.a)this.fj.get(paramString)).hasMore = paramBoolean1;
    ((sci.a)this.fj.get(paramString)).d = paramStCommonExt;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, COMM.StCommonExt paramStCommonExt)
  {
    if (paramStGetFeedDetailRsp != null)
    {
      Object localObject = paramStGetFeedDetailRsp.feed;
      String str = ((CertifiedAccountMeta.StFeed)localObject).id.get();
      a(str, paramStGetFeedDetailRsp.extInfo, true, true);
      ArrayList localArrayList = null;
      if (((CertifiedAccountMeta.StFeed)localObject).vecComment.size() > 0)
      {
        localArrayList = (ArrayList)a((ArrayList)((CertifiedAccountMeta.StFeed)localObject).vecComment.get(), a(paramStCommonExt), 1);
        this.fi.put(str, Integer.valueOf(((CertifiedAccountMeta.StFeed)localObject).commentCount.get()));
      }
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList(0);
        this.fi.put(str, Integer.valueOf(0));
      }
      this.fh.put(str, localObject);
      paramStGetFeedDetailRsp.feed.vecComment.set((List)localObject);
      if (aU(str) == 0) {
        QZLog.e(TAG, 1, new Object[] { "后台返回评论数为0" });
      }
      pmi.a().dispatch(new sct(5, new Object[] { str, Integer.valueOf(aU(str)) }));
    }
    pmi.a().dispatch(a(new Object[] { Integer.valueOf(2), Long.valueOf(paramLong), paramString, paramStGetFeedDetailRsp, Integer.valueOf(hashCode()), paramStCommonExt }));
  }
  
  private void ap(String paramString, boolean paramBoolean)
  {
    if ((this.fj != null) && (this.fj.get(paramString) != null)) {
      ((sci.a)this.fj.get(paramString)).axb = paramBoolean;
    }
  }
  
  public long a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment)
  {
    paramStFeed = new DoLikeRequest(paramStFeed);
    VSNetworkHelper.a().a(paramStFeed, new scp(this));
    return Long.parseLong(paramStComment.id.get());
  }
  
  public long a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    paramStFeed = new DoReplyReq(paramStFeed, paramStComment, paramStReply, 1);
    VSNetworkHelper.a().a(paramStFeed, new scn(this, paramStComment, paramStReply));
    return 0L;
  }
  
  public COMM.StCommonExt a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (sci.a)this.fj.get(paramString);
    if (paramString != null)
    {
      if ((paramString.axb) && (paramString.hasMore) && (paramString.d != null)) {
        return paramString.d;
      }
      QLog.i(TAG, 1, paramString.toString());
    }
    return null;
  }
  
  public String a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment)
  {
    if ((paramStComment == null) || (paramStComment.id.get().startsWith("fake_id")))
    {
      pmi.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), acfp.m(2131704187), null }));
      return "";
    }
    paramStFeed = new DoCommentRequest(paramStFeed, paramStComment, 0);
    VSNetworkHelper.a().a(paramStFeed, new scm(this, paramStComment));
    return paramStComment.id.get();
  }
  
  public String a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if ((paramStReply == null) || (paramStReply.id.get().startsWith("fake_id")))
    {
      pmi.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), acfp.m(2131704185), null }));
      return "";
    }
    paramStFeed = new DoReplyReq(paramStFeed, paramStComment, paramStReply, 0);
    VSNetworkHelper.a().a(paramStFeed, new sco(this, paramStReply, paramStComment));
    return paramStReply.id.get();
  }
  
  public List<CertifiedAccountMeta.StComment> a(List<CertifiedAccountMeta.StComment> paramList, String paramString)
  {
    return a(paramList, paramString, 0);
  }
  
  public List<CertifiedAccountMeta.StComment> a(List<CertifiedAccountMeta.StComment> paramList, String paramString, int paramInt)
  {
    int j = paramList.size();
    if ((TextUtils.isEmpty(paramString)) || (paramInt < 0) || (paramInt > j)) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramInt;
    if (paramInt > 0)
    {
      localArrayList.addAll(paramList.subList(0, paramInt));
      i = paramInt;
    }
    while (i < j)
    {
      CertifiedAccountMeta.StComment localStComment = (CertifiedAccountMeta.StComment)paramList.get(i);
      if (!localStComment.id.get().equals(paramString)) {
        localArrayList.add(localStComment);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public sct a(Object... paramVarArgs)
  {
    return new sct(6, paramVarArgs);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment)
  {
    paramStFeed = new DoCommentRequest(paramStFeed, paramStComment, 1);
    VSNetworkHelper.a().a(paramStFeed, new scl(this, paramStComment));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    paramStFeed = new DoLikeRequest(paramStFeed);
    VSNetworkHelper.a().a(paramStFeed, new scq(this));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, COMM.StCommonExt paramStCommonExt)
  {
    scj localscj = new scj(this, paramStCommonExt);
    if (paramStCommonExt == null)
    {
      String str = paramStFeed.id.get();
      if (ryo.exists("1002" + str))
      {
        ryo.a("1002" + str, new sck(this, localscj));
        ryo.remove("1002" + str);
        return;
      }
    }
    paramStFeed = new GetSubscribeFeedDetailRequest(paramStFeed, paramStCommonExt);
    paramStFeed.setEnableCache(false);
    VSNetworkHelper.a().a(paramStFeed, localscj);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, COMM.StCommonExt paramStCommonExt, String paramString)
  {
    paramStCommonExt = new GetCommentListRequest(paramStFeed, paramStCommonExt, 20);
    VSNetworkHelper.a().a(paramStCommonExt, new scr(this, paramStFeed, paramString));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    a(paramStFeed, paramBoolean, "");
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, boolean paramBoolean, String paramString)
  {
    COMM.StCommonExt localStCommonExt;
    if (paramBoolean)
    {
      localStCommonExt = a(paramStFeed.id.get());
      QZLog.i(TAG, 1, "getComments loadMore: " + paramBoolean + ", attachInfo:" + localStCommonExt);
      if (localStCommonExt == null)
      {
        QZLog.e(TAG, 1, new Object[] { "getComments loadMore: " + paramBoolean + ", attachInfo is null " });
        return;
      }
      ap(paramStFeed.id.get(), false);
      a(paramStFeed, localStCommonExt, paramString);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localStCommonExt = new COMM.StCommonExt();
      COMM.Entry localEntry = new COMM.Entry();
      localEntry.key.set("commentID");
      localEntry.value.set(paramString);
      localStCommonExt.mapInfo.add(localEntry);
      a(paramStFeed, localStCommonExt);
      return;
    }
    a(paramStFeed, null);
  }
  
  public int aU(String paramString)
  {
    paramString = (Integer)this.fi.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public Handler getHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  public void release()
  {
    this.fh.clear();
    this.fj.clear();
    this.fi.clear();
  }
  
  public ArrayList<CertifiedAccountMeta.StComment> t(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.fh.get(paramString);
  }
  
  static class a
  {
    public boolean axb;
    public COMM.StCommonExt d;
    public boolean hasMore;
    
    public String toString()
    {
      return "CommentResponse{hasMore=" + this.hasMore + ", attachInfo='" + this.d.attachInfo.get() + '\'' + ", hasResponse='" + this.axb + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sci
 * JD-Core Version:    0.7.0.1
 */