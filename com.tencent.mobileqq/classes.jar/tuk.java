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
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
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

public class tuk
{
  private static final String jdField_a_of_type_JavaLangString = tuk.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Map<String, ArrayList<FeedCloudMeta.StComment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private uae jdField_a_of_type_Uae = uae.a(61);
  private Map<String, Integer> b = new HashMap();
  private Map<String, String> c = new HashMap();
  private Map<String, tuu> d = new HashMap();
  
  public tuk(Context paramContext)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_Int = paramContext.hashCode();
    }
  }
  
  private void a(String paramString)
  {
    if (!NetworkUtils.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, BaseApplicationImpl.getContext().getResources().getString(2131694779), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, paramString, 0).a();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "updateStickyCommentId param error");
      return;
    }
    if (this.c == null) {
      this.c = new HashMap();
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "updateStickyCommentId feedId:" + paramString1 + " commentId" + paramString2);
    this.c.put(paramString1, paramString2);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.d.get(paramString1) == null)
    {
      tuu localtuu = new tuu();
      localtuu.jdField_a_of_type_JavaLangString = paramString2;
      localtuu.jdField_a_of_type_Boolean = paramBoolean1;
      localtuu.b = paramBoolean2;
      this.d.put(paramString1, localtuu);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "getDetailCommentSize: feedAttachInfo:" + paramString2);
      return;
    }
    ((tuu)this.d.get(paramString1)).jdField_a_of_type_Boolean = paramBoolean1;
    ((tuu)this.d.get(paramString1)).jdField_a_of_type_JavaLangString = paramString2;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((this.d != null) && (this.d.get(paramString) != null)) {
      ((tuu)this.d.get(paramString)).b = paramBoolean;
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
      a(paramString);
      QLog.e(jdField_a_of_type_JavaLangString, 1, "getComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "handleCommentResponse Success  isLoadMore:" + paramBoolean2);
    a(paramStFeed.id.get(), true);
    if (paramStGetCommentListRsp.extInfo.has()) {
      a((FeedCloudCommon.StCommonExt)paramStGetCommentListRsp.extInfo.get());
    }
    Object localObject = paramStFeed.id.get();
    String str = paramStGetCommentListRsp.feedAttchInfo.get();
    if (paramStGetCommentListRsp.isFinish.get() == 0) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      a((String)localObject, str, paramBoolean1, true);
      if (!paramBoolean2) {
        break;
      }
      if (this.jdField_a_of_type_JavaUtilMap.get(paramStFeed.id.get()) != null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getCommentSize:" + paramStGetCommentListRsp.vecComment.size() + ", attachInfo:" + paramStGetCommentListRsp.feedAttchInfo.get() + "isFinish：" + paramStGetCommentListRsp.isFinish.get());
        ((ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramStFeed.id.get())).addAll(paramStGetCommentListRsp.vecComment.get());
      }
      umc.a().dispatch(a(new Object[] { Integer.valueOf(2), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp, Integer.valueOf(hashCode()) }));
      return;
    }
    str = paramStFeed.id.get();
    paramStFeed = null;
    if (paramStGetCommentListRsp.vecComment.size() > 0)
    {
      localObject = (ArrayList)paramStGetCommentListRsp.vecComment.get();
      this.b.put(str, Integer.valueOf(paramStGetCommentListRsp.totalNum.get()));
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)paramStGetCommentListRsp.vecComment.get(0);
      paramStFeed = (FeedCloudMeta.StFeed)localObject;
      if (localStComment.typeFlag.get() == 1)
      {
        a(str, localStComment.id.get());
        paramStFeed = (FeedCloudMeta.StFeed)localObject;
      }
    }
    localObject = paramStFeed;
    if (paramStFeed == null)
    {
      localObject = new ArrayList(0);
      this.b.put(str, Integer.valueOf(0));
    }
    this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
    if (a(str) == 0) {
      QZLog.e(jdField_a_of_type_JavaLangString, 1, new Object[] { "后台返回评论数为0" });
    }
    yiw.a().a(new QCircleCommentUpdateEvent(5, str, a(str)));
    umc.a().dispatch(a(new Object[] { Integer.valueOf(1), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp, Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean3) }));
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
      VSNetworkHelper.a().a(this.jdField_a_of_type_Int, paramString, new tun(this, paramStFeed, paramBoolean));
      return;
      bool1 = false;
      break;
    }
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.b.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public long a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    QCircleDoReplyRequest localQCircleDoReplyRequest = new QCircleDoReplyRequest(paramStFeed, paramStComment, paramStReply, 1);
    VSNetworkHelper.a().a(this.jdField_a_of_type_Int, localQCircleDoReplyRequest, new tuq(this, paramStReply, paramStFeed, paramStComment));
    return 0L;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uae != null) {
      return this.jdField_a_of_type_Uae.a(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public String a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt)
  {
    if ((paramStComment == null) || (paramStComment.id.get().startsWith("fake_id")))
    {
      umc.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), alud.a(2131702559), null }));
      return "";
    }
    QCircleDoCommentRequest localQCircleDoCommentRequest = new QCircleDoCommentRequest(paramStFeed, paramStComment, paramInt);
    VSNetworkHelper.a().a(this.jdField_a_of_type_Int, localQCircleDoCommentRequest, new tup(this, paramStComment, paramStFeed));
    return paramStComment.id.get();
  }
  
  public String a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt)
  {
    if ((paramStReply == null) || (paramStReply.id.get().startsWith("fake_id")))
    {
      umc.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), alud.a(2131702557), null }));
      return "";
    }
    QCircleDoReplyRequest localQCircleDoReplyRequest = new QCircleDoReplyRequest(paramStFeed, paramStComment, paramStReply, paramInt);
    VSNetworkHelper.a().a(this.jdField_a_of_type_Int, localQCircleDoReplyRequest, new tur(this, paramStReply, paramStFeed, paramStComment));
    return paramStReply.id.get();
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (tuu)this.d.get(paramString);
    if (paramString != null)
    {
      if ((paramString.b) && (paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_JavaLangString != null)) {
        return paramString.jdField_a_of_type_JavaLangString;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, paramString.toString());
    }
    return null;
  }
  
  public ArrayList<FeedCloudMeta.StComment> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public tuf a(Object... paramVarArgs)
  {
    return new tuf(6, paramVarArgs);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.d.clear();
    this.b.clear();
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Uae != null) {
      this.jdField_a_of_type_Uae.a(paramStCommonExt);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    QCircleDoCommentRequest localQCircleDoCommentRequest = new QCircleDoCommentRequest(paramStFeed, paramStComment, 1);
    VSNetworkHelper.a().a(this.jdField_a_of_type_Int, localQCircleDoCommentRequest, new tuo(this, paramStComment, paramStFeed));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramStFeed, paramString, true);
      return;
    }
    if (ykb.a("2004"))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "runPreload");
      ykb.a("2004", new tul(this, paramStFeed));
      return;
    }
    b(paramStFeed, paramString, false);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData)
  {
    boolean bool = false;
    if (paramStFeed == null)
    {
      QZLog.i(jdField_a_of_type_JavaLangString, 1, "getComments  feed == null");
      return;
    }
    a(paramStFeed.id.get(), false);
    Object localObject = new QCircleGetCommentListRequest(paramStFeed, null, 20, paramStFeed.likeInfo.id.get());
    ((QCircleGetCommentListRequest)localObject).req.extInfo.set(a(true));
    if (paramStBusiInfoCommentListData != null) {
      ((QCircleGetCommentListRequest)localObject).req.busiReqData.set(ByteStringMicro.copyFrom(paramStBusiInfoCommentListData.toByteArray()));
    }
    ((QCircleGetCommentListRequest)localObject).setEnableCache(false);
    VSNetworkHelper.a().a(this.jdField_a_of_type_Int, (VSBaseRequest)localObject, new tum(this, paramStFeed));
    paramStFeed = jdField_a_of_type_JavaLangString;
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
      QZLog.i(jdField_a_of_type_JavaLangString, 1, "getComments  feed == null");
      return;
    }
    String str = null;
    if (paramBoolean)
    {
      str = a(paramStFeed.id.get());
      if (str == null)
      {
        QZLog.e(jdField_a_of_type_JavaLangString, 1, new Object[] { "getComments loadMore , attachInfo is null " });
        return;
      }
      QZLog.i(jdField_a_of_type_JavaLangString, 1, "getComments, feedAttachInfo:" + str);
    }
    a(paramStFeed, str, paramBoolean);
    a(paramStFeed.id.get(), false);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.put(paramString, Integer.valueOf(paramInt));
  }
  
  public boolean a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStFeed == null) || (paramStComment == null)) {}
    try
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "isReplaceStickyComment param is null");
      return false;
    }
    catch (Exception paramStFeed)
    {
      boolean bool;
      paramStFeed.printStackTrace();
    }
    if ((this.c != null) && (this.c.containsKey(paramStFeed.id.get())))
    {
      paramStFeed = (String)this.c.get(paramStFeed.id.get());
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
  
  public void b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    QCircleDoStickyRequest localQCircleDoStickyRequest = new QCircleDoStickyRequest(paramStFeed, paramStComment, 1);
    VSNetworkHelper.a().a(this.jdField_a_of_type_Int, localQCircleDoStickyRequest, new tus(this, paramStFeed, paramStComment));
  }
  
  public void c(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    QCircleDoStickyRequest localQCircleDoStickyRequest = new QCircleDoStickyRequest(paramStFeed, paramStComment, 2);
    VSNetworkHelper.a().a(this.jdField_a_of_type_Int, localQCircleDoStickyRequest, new tut(this, paramStFeed, paramStComment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuk
 * JD-Core Version:    0.7.0.1
 */