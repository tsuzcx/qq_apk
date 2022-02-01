import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoCommentRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoReplyRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoStickyRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetCommentListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import cooperation.qzone.util.QZLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudRead.StGetCommentListReq;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class oyh
{
  private static final String TAG = oyh.class.getSimpleName();
  private pcx a = pcx.a(61);
  private Map<String, ArrayList<FeedCloudMeta.StComment>> fh = new HashMap();
  private Map<String, Integer> fi = new HashMap();
  private Map<String, oyh.a> fj = new HashMap();
  private Map<String, String> fs = new HashMap();
  private int mContextHashCode;
  private Handler mMainHandler;
  
  public oyh(Context paramContext)
  {
    if (paramContext != null) {
      this.mContextHashCode = paramContext.hashCode();
    }
  }
  
  private void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean2)
  {
    a(paramBoolean1, paramLong, paramString, paramStGetCommentListRsp, paramStFeed, paramBoolean2, false);
  }
  
  private void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetCommentListRsp == null))
    {
      qw(paramString);
      QLog.e(TAG, 1, "getComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(TAG, 1, "handleCommentResponse Success  isLoadMore:" + paramBoolean2);
    ap(paramStFeed.id.get(), true);
    if (paramStGetCommentListRsp.extInfo.has()) {
      a((FeedCloudCommon.StCommonExt)paramStGetCommentListRsp.extInfo.get());
    }
    Object localObject = paramStFeed.id.get();
    String str = paramStGetCommentListRsp.feedAttchInfo.get();
    if (paramStGetCommentListRsp.isFinish.get() == 0) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      b((String)localObject, str, paramBoolean1, true);
      if (!paramBoolean2) {
        break;
      }
      if (this.fh.get(paramStFeed.id.get()) != null)
      {
        QLog.d(TAG, 2, "getCommentSize:" + paramStGetCommentListRsp.vecComment.size() + ", attachInfo:" + paramStGetCommentListRsp.feedAttchInfo.get() + "isFinish：" + paramStGetCommentListRsp.isFinish.get());
        ((ArrayList)this.fh.get(paramStFeed.id.get())).addAll(paramStGetCommentListRsp.vecComment.get());
      }
      pmi.a().dispatch(a(new Object[] { Integer.valueOf(2), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp, Integer.valueOf(hashCode()) }));
      return;
    }
    str = paramStFeed.id.get();
    paramStFeed = null;
    if (paramStGetCommentListRsp.vecComment.size() > 0)
    {
      localObject = (ArrayList)paramStGetCommentListRsp.vecComment.get();
      this.fi.put(str, Integer.valueOf(paramStGetCommentListRsp.totalNum.get()));
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)paramStGetCommentListRsp.vecComment.get(0);
      paramStFeed = (FeedCloudMeta.StFeed)localObject;
      if (localStComment.typeFlag.get() == 1)
      {
        cf(str, localStComment.id.get());
        paramStFeed = (FeedCloudMeta.StFeed)localObject;
      }
    }
    localObject = paramStFeed;
    if (paramStFeed == null)
    {
      localObject = new ArrayList(0);
      this.fi.put(str, Integer.valueOf(0));
    }
    this.fh.put(str, localObject);
    if (aU(str) == 0) {
      QZLog.e(TAG, 1, new Object[] { "后台返回评论数为0" });
    }
    rwv.a().a(new QCircleCommentUpdateEvent(5, str, aU(str)));
    pmi.a().dispatch(a(new Object[] { Integer.valueOf(1), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp, Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean3) }));
  }
  
  private void ap(String paramString, boolean paramBoolean)
  {
    if ((this.fj != null) && (this.fj.get(paramString) != null)) {
      ((oyh.a)this.fj.get(paramString)).axb = paramBoolean;
    }
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    paramString = new QCircleGetCommentListRequest(paramStFeed, paramString, 20, paramStFeed.likeInfo.id.get());
    FeedCloudCommon.StCommonExt localStCommonExt = paramString.req.extInfo;
    if (!paramBoolean)
    {
      bool1 = true;
      localStCommonExt.set(a(bool1));
      if (paramBoolean) {
        break label95;
      }
    }
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.setEnableCache(bool1);
      VSNetworkHelper.a().a(this.mContextHashCode, paramString, new oyk(this, paramStFeed, paramBoolean));
      return;
      bool1 = false;
      break;
    }
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.fj.get(paramString1) == null)
    {
      oyh.a locala = new oyh.a();
      locala.arL = paramString2;
      locala.hasMore = paramBoolean1;
      locala.axb = paramBoolean2;
      this.fj.put(paramString1, locala);
      QLog.d(TAG, 1, "getDetailCommentSize: feedAttachInfo:" + paramString2);
      return;
    }
    ((oyh.a)this.fj.get(paramString1)).hasMore = paramBoolean1;
    ((oyh.a)this.fj.get(paramString1)).arL = paramString2;
  }
  
  private void cf(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d(TAG, 1, "updateStickyCommentId param error");
      return;
    }
    if (this.fs == null) {
      this.fs = new HashMap();
    }
    QLog.d(TAG, 1, "updateStickyCommentId feedId:" + paramString1 + " commentId" + paramString2);
    this.fs.put(paramString1, paramString2);
  }
  
  private void qw(String paramString)
  {
    if (!NetworkUtils.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, BaseApplicationImpl.getContext().getResources().getString(2131696284), 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, paramString, 0).show();
  }
  
  public long a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    QCircleDoReplyRequest localQCircleDoReplyRequest = new QCircleDoReplyRequest(paramStFeed, paramStComment, paramStReply, 1);
    VSNetworkHelper.a().a(this.mContextHashCode, localQCircleDoReplyRequest, new oyn(this, paramStReply, paramStFeed, paramStComment));
    return 0L;
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.b(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public String a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt)
  {
    if ((paramStComment == null) || (paramStComment.id.get().startsWith("fake_id")))
    {
      pmi.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), acfp.m(2131704187), null }));
      return "";
    }
    QCircleDoCommentRequest localQCircleDoCommentRequest = new QCircleDoCommentRequest(paramStFeed, paramStComment, paramInt);
    VSNetworkHelper.a().a(this.mContextHashCode, localQCircleDoCommentRequest, new oym(this, paramStComment, paramStFeed));
    return paramStComment.id.get();
  }
  
  public String a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt)
  {
    if ((paramStReply == null) || (paramStReply.id.get().startsWith("fake_id")))
    {
      pmi.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), acfp.m(2131704185), null }));
      return "";
    }
    QCircleDoReplyRequest localQCircleDoReplyRequest = new QCircleDoReplyRequest(paramStFeed, paramStComment, paramStReply, paramInt);
    VSNetworkHelper.a().a(this.mContextHashCode, localQCircleDoReplyRequest, new oyo(this, paramStReply, paramStFeed, paramStComment));
    return paramStReply.id.get();
  }
  
  public oyc a(Object... paramVarArgs)
  {
    return new oyc(6, paramVarArgs);
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.a != null) {
      this.a.b(paramStCommonExt);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    QCircleDoCommentRequest localQCircleDoCommentRequest = new QCircleDoCommentRequest(paramStFeed, paramStComment, 1);
    VSNetworkHelper.a().a(this.mContextHashCode, localQCircleDoCommentRequest, new oyl(this, paramStComment, paramStFeed));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramStFeed, paramString, true);
      return;
    }
    if (ryo.exists("2004"))
    {
      QLog.i(TAG, 1, "runPreload");
      ryo.a("2004", new oyi(this, paramStFeed));
      return;
    }
    b(paramStFeed, paramString, false);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData)
  {
    boolean bool = false;
    if (paramStFeed == null)
    {
      QZLog.i(TAG, 1, "getComments  feed == null");
      return;
    }
    ap(paramStFeed.id.get(), false);
    Object localObject = new QCircleGetCommentListRequest(paramStFeed, null, 20, paramStFeed.likeInfo.id.get());
    ((QCircleGetCommentListRequest)localObject).req.extInfo.set(a(true));
    if (paramStBusiInfoCommentListData != null) {
      ((QCircleGetCommentListRequest)localObject).req.busiReqData.set(ByteStringMicro.copyFrom(paramStBusiInfoCommentListData.toByteArray()));
    }
    ((QCircleGetCommentListRequest)localObject).setEnableCache(false);
    VSNetworkHelper.a().a(this.mContextHashCode, (VSBaseRequest)localObject, new oyj(this, paramStFeed));
    paramStFeed = TAG;
    localObject = new StringBuilder().append("req traceId:").append(((QCircleGetCommentListRequest)localObject).getTraceId()).append("stBusiInfoCommentListData is ");
    if (paramStBusiInfoCommentListData != null) {
      bool = true;
    }
    QLog.d(paramStFeed, 1, bool);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    if (paramStFeed == null)
    {
      QZLog.i(TAG, 1, "getComments  feed == null");
      return;
    }
    String str = null;
    if (paramBoolean)
    {
      str = getAttachInfo(paramStFeed.id.get());
      if (str == null)
      {
        QZLog.e(TAG, 1, new Object[] { "getComments loadMore , attachInfo is null " });
        return;
      }
      QZLog.i(TAG, 1, "getComments, feedAttachInfo:" + str);
    }
    a(paramStFeed, str, paramBoolean);
    ap(paramStFeed.id.get(), false);
  }
  
  public boolean a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStFeed == null) || (paramStComment == null)) {}
    try
    {
      QLog.e(TAG, 1, "isReplaceStickyComment param is null");
      return false;
    }
    catch (Exception paramStFeed)
    {
      boolean bool;
      paramStFeed.printStackTrace();
    }
    if ((this.fs != null) && (this.fs.containsKey(paramStFeed.id.get())))
    {
      paramStFeed = (String)this.fs.get(paramStFeed.id.get());
      if (!TextUtils.isEmpty(paramStFeed))
      {
        bool = paramStFeed.equals(paramStComment.id.get());
        if (bool) {}
      }
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  public int aU(String paramString)
  {
    paramString = (Integer)this.fi.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    QCircleDoStickyRequest localQCircleDoStickyRequest = new QCircleDoStickyRequest(paramStFeed, paramStComment, 1);
    VSNetworkHelper.a().a(this.mContextHashCode, localQCircleDoStickyRequest, new oyp(this, paramStFeed, paramStComment));
  }
  
  public void bb(String paramString, int paramInt)
  {
    this.fi.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void c(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    QCircleDoStickyRequest localQCircleDoStickyRequest = new QCircleDoStickyRequest(paramStFeed, paramStComment, 2);
    VSNetworkHelper.a().a(this.mContextHashCode, localQCircleDoStickyRequest, new oyq(this, paramStFeed, paramStComment));
  }
  
  public String getAttachInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (oyh.a)this.fj.get(paramString);
    if (paramString != null)
    {
      if ((paramString.axb) && (paramString.hasMore) && (paramString.arL != null)) {
        return paramString.arL;
      }
      QLog.i(TAG, 1, paramString.toString());
    }
    return null;
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
  
  public ArrayList<FeedCloudMeta.StComment> t(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.fh.get(paramString);
  }
  
  static class a
  {
    public String arL;
    public boolean axb;
    public boolean hasMore;
    
    public String toString()
    {
      return "CommentResponse{hasMore=" + this.hasMore + ", attachInfo='" + this.arL + '\'' + ", hasResponse='" + this.axb + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyh
 * JD-Core Version:    0.7.0.1
 */