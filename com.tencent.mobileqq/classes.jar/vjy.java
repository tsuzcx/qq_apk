import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoCommentRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoReplyRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoStickyRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetCommentListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
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
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class vjy
{
  private static vjy jdField_a_of_type_Vjy;
  private Map<String, ArrayList<FeedCloudMeta.StComment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private vua jdField_a_of_type_Vua = vua.a(61);
  private Map<String, Integer> b = new HashMap();
  private Map<String, String> c = new HashMap();
  private Map<String, vkk> d = new HashMap();
  
  public static vjy a()
  {
    if (jdField_a_of_type_Vjy == null) {}
    try
    {
      if (jdField_a_of_type_Vjy == null) {
        jdField_a_of_type_Vjy = new vjy();
      }
      return jdField_a_of_type_Vjy;
    }
    finally {}
  }
  
  private void a(int paramInt, boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramLong, paramString, paramStGetCommentListRsp, paramStFeed, paramBoolean2, false, null);
  }
  
  private void a(int paramInt, boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramInt, paramBoolean1, paramLong, paramString, paramStGetCommentListRsp, paramStFeed, paramBoolean2, false, paramBoolean3, null);
  }
  
  private void a(int paramInt, boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean2, boolean paramBoolean3, QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData)
  {
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetCommentListRsp == null))
    {
      a(paramString);
      QLog.e("QCircleCommentBusiness", 1, "getComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d("QCircleCommentBusiness", 1, "handleCommentResponse Success  isLoadMore:" + paramBoolean2);
    a(paramStFeed.id.get(), true);
    if (paramStGetCommentListRsp.extInfo.has()) {
      a((FeedCloudCommon.StCommonExt)paramStGetCommentListRsp.extInfo.get());
    }
    paramString = paramStFeed.id.get();
    String str = paramStGetCommentListRsp.feedAttchInfo.get();
    if (paramStGetCommentListRsp.isFinish.get() == 0) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      a(paramString, str, paramBoolean1, true);
      if (!paramBoolean2) {
        break;
      }
      str = paramStFeed.id.get();
      paramString = str;
      if (paramStBusiInfoCommentListData != null) {
        paramString = str + paramStBusiInfoCommentListData.comment.id.get() + paramStBusiInfoCommentListData.reply.id.get();
      }
      paramStBusiInfoCommentListData = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramStBusiInfoCommentListData != null)
      {
        QLog.d("QCircleCommentBusiness", 2, "getCommentSize:" + paramStGetCommentListRsp.vecComment.size() + ", attachInfo:" + paramStGetCommentListRsp.feedAttchInfo.get() + "isFinish：" + paramStGetCommentListRsp.isFinish.get());
        paramStBusiInfoCommentListData.addAll(paramStGetCommentListRsp.vecComment.get());
      }
      aaak.a().a(new QCircleCommentUpdateEvent(2, paramString, paramStGetCommentListRsp.vecComment.get(), a(paramStFeed.id.get()), paramInt));
      return;
    }
    paramString = paramStFeed.id.get();
    str = paramString;
    if (paramStBusiInfoCommentListData != null) {
      str = paramString + paramStBusiInfoCommentListData.comment.id.get() + paramStBusiInfoCommentListData.reply.id.get();
    }
    if (paramStGetCommentListRsp.vecComment.size() > 0)
    {
      paramString = (ArrayList)paramStGetCommentListRsp.vecComment.get();
      this.b.put(paramStFeed.id.get(), Integer.valueOf(paramStGetCommentListRsp.totalNum.get()));
      paramStGetCommentListRsp = (FeedCloudMeta.StComment)paramStGetCommentListRsp.vecComment.get(0);
      if (paramStGetCommentListRsp.typeFlag.get() == 1) {
        a(paramStFeed.id.get(), paramStGetCommentListRsp.id.get());
      }
    }
    for (;;)
    {
      paramStGetCommentListRsp = paramString;
      if (paramString == null)
      {
        paramStGetCommentListRsp = new ArrayList(0);
        this.b.put(paramStFeed.id.get(), Integer.valueOf(0));
      }
      this.jdField_a_of_type_JavaUtilMap.put(str, paramStGetCommentListRsp);
      if (a(paramStFeed.id.get()) == 0) {
        QZLog.e("QCircleCommentBusiness", 1, new Object[] { "后台返回评论数为0" });
      }
      paramString = new QCircleDanmakuEvent(1, str, paramStGetCommentListRsp, a(paramStFeed.id.get()), paramInt);
      aaak.a().a(paramString);
      return;
      paramString = null;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData)
  {
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetCommentListRsp == null))
    {
      a(paramString);
      QLog.e("QCircleCommentBusiness", 1, "getComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d("QCircleCommentBusiness", 1, "handleCommentResponse Success  isLoadMore:" + paramBoolean2);
    a(paramStFeed.id.get(), true);
    if (paramStGetCommentListRsp.extInfo.has()) {
      a((FeedCloudCommon.StCommonExt)paramStGetCommentListRsp.extInfo.get());
    }
    paramString = paramStFeed.id.get();
    String str = paramStGetCommentListRsp.feedAttchInfo.get();
    if (paramStGetCommentListRsp.isFinish.get() == 0) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      a(paramString, str, paramBoolean1, true);
      if (!paramBoolean2) {
        break;
      }
      str = paramStFeed.id.get();
      paramString = str;
      if (paramStBusiInfoCommentListData != null) {
        paramString = str + paramStBusiInfoCommentListData.comment.id.get() + paramStBusiInfoCommentListData.reply.id.get();
      }
      paramStBusiInfoCommentListData = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramStBusiInfoCommentListData != null)
      {
        QLog.d("QCircleCommentBusiness", 2, "getCommentSize:" + paramStGetCommentListRsp.vecComment.size() + ", attachInfo:" + paramStGetCommentListRsp.feedAttchInfo.get() + "isFinish：" + paramStGetCommentListRsp.isFinish.get());
        paramStBusiInfoCommentListData.addAll(paramStGetCommentListRsp.vecComment.get());
      }
      aaak.a().a(new QCircleCommentUpdateEvent(2, paramString, paramStGetCommentListRsp.vecComment.get(), a(paramStFeed.id.get()), paramInt));
      return;
    }
    paramString = paramStFeed.id.get();
    str = paramString;
    if (paramStBusiInfoCommentListData != null) {
      str = paramString + paramStBusiInfoCommentListData.comment.id.get() + paramStBusiInfoCommentListData.reply.id.get();
    }
    if (paramStGetCommentListRsp.vecComment.size() > 0)
    {
      paramString = (ArrayList)paramStGetCommentListRsp.vecComment.get();
      this.b.put(paramStFeed.id.get(), Integer.valueOf(paramStGetCommentListRsp.totalNum.get()));
      paramStGetCommentListRsp = (FeedCloudMeta.StComment)paramStGetCommentListRsp.vecComment.get(0);
      if (paramStGetCommentListRsp.typeFlag.get() == 1) {
        a(paramStFeed.id.get(), paramStGetCommentListRsp.id.get());
      }
    }
    for (;;)
    {
      paramStGetCommentListRsp = paramString;
      if (paramString == null)
      {
        paramStGetCommentListRsp = new ArrayList(0);
        this.b.put(paramStFeed.id.get(), Integer.valueOf(0));
      }
      this.jdField_a_of_type_JavaUtilMap.put(str, paramStGetCommentListRsp);
      if (a(paramStFeed.id.get()) == 0) {
        QZLog.e("QCircleCommentBusiness", 1, new Object[] { "后台返回评论数为0" });
      }
      if (paramBoolean3)
      {
        paramString = new QCircleDanmakuEvent(1, str, paramStGetCommentListRsp, a(paramStFeed.id.get()), paramInt);
        aaak.a().a(paramString);
        return;
      }
      paramString = new QCircleCommentUpdateEvent(1, str, paramStGetCommentListRsp, a(paramStFeed.id.get()), paramInt);
      paramString.needShowCommentPanel = paramBoolean4;
      aaak.a().a(paramString);
      return;
      paramString = null;
    }
  }
  
  private void a(String paramString)
  {
    if (!NetworkUtils.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, BaseApplicationImpl.getContext().getResources().getString(2131693974), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, paramString, 0).a();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("QCircleCommentBusiness", 1, "updateStickyCommentId param error");
      return;
    }
    if (this.c == null) {
      this.c = new HashMap();
    }
    QLog.d("QCircleCommentBusiness", 1, "updateStickyCommentId feedId:" + paramString1 + " commentId" + paramString2);
    this.c.put(paramString1, paramString2);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.d.get(paramString1) == null)
    {
      vkk localvkk = new vkk();
      localvkk.jdField_a_of_type_JavaLangString = paramString2;
      localvkk.jdField_a_of_type_Boolean = paramBoolean1;
      localvkk.b = paramBoolean2;
      this.d.put(paramString1, localvkk);
      QLog.d("QCircleCommentBusiness", 1, "getDetailCommentSize: feedAttachInfo:" + paramString2);
      return;
    }
    ((vkk)this.d.get(paramString1)).jdField_a_of_type_Boolean = paramBoolean1;
    ((vkk)this.d.get(paramString1)).jdField_a_of_type_JavaLangString = paramString2;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((this.d != null) && (this.d.get(paramString) != null)) {
      ((vkk)this.d.get(paramString)).b = paramBoolean;
    }
  }
  
  private void b(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    paramString = new QCircleGetCommentListRequest(paramStFeed, paramInt2, paramString, 20, paramStFeed.likeInfo.id.get());
    FeedCloudCommon.StCommonExt localStCommonExt = paramString.req.extInfo;
    if (!paramBoolean1)
    {
      bool1 = true;
      localStCommonExt.set(a(bool1));
      if (paramBoolean1) {
        break label104;
      }
    }
    label104:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.setEnableCache(bool1);
      VSNetworkHelper.a().a(paramInt1, paramString, new vke(this, paramInt1, paramStFeed, paramBoolean1, paramBoolean2));
      return;
      bool1 = false;
      break;
    }
  }
  
  private void b(int paramInt, FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    paramString = new QCircleGetCommentListRequest(paramStFeed, paramString, 20, paramStFeed.likeInfo.id.get());
    FeedCloudCommon.StCommonExt localStCommonExt = paramString.req.extInfo;
    if (!paramBoolean)
    {
      bool1 = true;
      localStCommonExt.set(a(bool1));
      if (paramBoolean) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.setEnableCache(bool1);
      VSNetworkHelper.a().a(paramInt, paramString, new vkf(this, paramInt, paramStFeed, paramBoolean));
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
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vua != null) {
      return this.jdField_a_of_type_Vua.a(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (vkk)this.d.get(paramString);
    if (paramString != null)
    {
      if ((paramString.b) && (paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_JavaLangString != null)) {
        return paramString.jdField_a_of_type_JavaLangString;
      }
      QLog.i("QCircleCommentBusiness", 1, paramString.toString());
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
  
  public ArrayList<FeedCloudMeta.StComment> a(String paramString, ArrayList<FeedCloudMeta.StComment> paramArrayList)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.put(paramString, paramArrayList);
  }
  
  public void a(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      b(paramInt1, paramInt2, paramStFeed, paramString, true, paramBoolean2);
      return;
    }
    if (aadg.a("2004"))
    {
      QLog.i("QCircleCommentBusiness", 1, "runPreload");
      aadg.a("2004", new vjz(this, paramInt1, paramStFeed, paramBoolean2));
      return;
    }
    b(paramInt1, paramInt2, paramStFeed, paramString, false, paramBoolean2);
  }
  
  public void a(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramStFeed == null)
    {
      QZLog.i("QCircleCommentBusiness", 1, "getComments  feed == null");
      return;
    }
    String str = null;
    if (paramBoolean1)
    {
      str = a(paramStFeed.id.get());
      if (str == null)
      {
        QZLog.e("QCircleCommentBusiness", 1, new Object[] { "getComments loadMore , attachInfo is null " });
        return;
      }
      QZLog.i("QCircleCommentBusiness", 1, "getComments, feedAttachInfo:" + str);
    }
    a(paramInt1, paramInt2, paramStFeed, str, paramBoolean1, paramBoolean2);
    a(paramStFeed.id.get(), false);
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    QCircleDoStickyRequest localQCircleDoStickyRequest = new QCircleDoStickyRequest(paramStFeed, paramStComment, 1);
    VSNetworkHelper.a().a(paramInt, localQCircleDoStickyRequest, new vka(this, paramStFeed, paramStComment, paramInt));
  }
  
  public void a(int paramInt1, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt2, boolean paramBoolean)
  {
    if ((paramStFeed == null) || (paramStComment == null)) {
      return;
    }
    if (paramStComment.id.get().startsWith("fake_id"))
    {
      aaak.a().a(new QCircleCommentUpdateEvent(4, paramStFeed.id.get(), paramStComment, a(paramStFeed.id.get()), paramInt1));
      return;
    }
    QCircleDoCommentRequest localQCircleDoCommentRequest = new QCircleDoCommentRequest(paramStFeed, paramStComment, paramInt2, paramBoolean);
    VSNetworkHelper.a().a(paramInt1, localQCircleDoCommentRequest, new vkh(this, paramStComment, paramStFeed, paramInt1));
  }
  
  public void a(int paramInt1, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt2, boolean paramBoolean)
  {
    if ((paramStFeed == null) || (paramStComment == null) || (paramStReply == null)) {
      return;
    }
    if (paramStReply.id.get().startsWith("fake_id"))
    {
      aaak.a().a(new QCircleCommentUpdateEvent(6, paramStFeed.id.get(), paramStComment, paramStReply, a(paramStFeed.id.get()), paramInt1));
      return;
    }
    QCircleDoReplyRequest localQCircleDoReplyRequest = new QCircleDoReplyRequest(paramStFeed, paramStComment, paramStReply, paramInt2, paramBoolean);
    VSNetworkHelper.a().a(paramInt1, localQCircleDoReplyRequest, new vkj(this, paramStReply, paramStFeed, paramStComment, paramInt1));
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean)
  {
    if ((paramStFeed == null) || (paramStComment == null) || (paramStReply == null)) {
      return;
    }
    QCircleDoReplyRequest localQCircleDoReplyRequest = new QCircleDoReplyRequest(paramStFeed, paramStComment, paramStReply, 1, paramBoolean);
    VSNetworkHelper.a().a(paramInt, localQCircleDoReplyRequest, new vki(this, paramStFeed, paramStComment, paramStReply, paramInt));
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, boolean paramBoolean)
  {
    if ((paramStFeed == null) || (paramStComment == null)) {
      return;
    }
    QCircleDoCommentRequest localQCircleDoCommentRequest = new QCircleDoCommentRequest(paramStFeed, paramStComment, 1, paramBoolean);
    VSNetworkHelper.a().a(paramInt, localQCircleDoCommentRequest, new vkg(this, paramStFeed, paramStComment, paramInt));
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramInt, paramStFeed, paramString, true);
      return;
    }
    if (aadg.a("2004"))
    {
      QLog.i("QCircleCommentBusiness", 1, "runPreload");
      aadg.a("2004", new vkc(this, paramInt, paramStFeed));
      return;
    }
    b(paramInt, paramStFeed, paramString, false);
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData)
  {
    boolean bool = false;
    if (paramStFeed == null)
    {
      QZLog.i("QCircleCommentBusiness", 1, "getComments  feed == null");
      return;
    }
    a(paramStFeed.id.get(), false);
    QCircleGetCommentListRequest localQCircleGetCommentListRequest = new QCircleGetCommentListRequest(paramStFeed, null, 20, paramStFeed.likeInfo.id.get());
    localQCircleGetCommentListRequest.req.extInfo.set(a(true));
    if (paramStBusiInfoCommentListData != null) {
      localQCircleGetCommentListRequest.req.busiReqData.set(ByteStringMicro.copyFrom(paramStBusiInfoCommentListData.toByteArray()));
    }
    localQCircleGetCommentListRequest.setEnableCache(false);
    VSNetworkHelper.a().a(paramInt, localQCircleGetCommentListRequest, new vkd(this, paramInt, paramStFeed, paramStBusiInfoCommentListData));
    paramStFeed = new StringBuilder().append("req traceId:").append(localQCircleGetCommentListRequest.getTraceId()).append("stBusiInfoCommentListData is ");
    if (paramStBusiInfoCommentListData != null) {
      bool = true;
    }
    QLog.d("QCircleCommentBusiness", 1, bool);
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    if (paramStFeed == null)
    {
      QZLog.i("QCircleCommentBusiness", 1, "getComments  feed == null");
      return;
    }
    String str = null;
    if (paramBoolean)
    {
      str = a(paramStFeed.id.get());
      if (str == null)
      {
        QZLog.e("QCircleCommentBusiness", 1, new Object[] { "getComments loadMore , attachInfo is null " });
        return;
      }
      QZLog.i("QCircleCommentBusiness", 1, "getComments, feedAttachInfo:" + str);
    }
    a(paramInt, paramStFeed, str, paramBoolean);
    a(paramStFeed.id.get(), false);
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Vua != null) {
      this.jdField_a_of_type_Vua.a(paramStCommonExt);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString1, String paramString2, ArrayList<FeedCloudMeta.StComment> paramArrayList, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramString1, paramString2, paramBoolean, true);
      if (paramArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramArrayList);
      }
      return;
    }
  }
  
  public boolean a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStFeed == null) || (paramStComment == null)) {}
    try
    {
      QLog.e("QCircleCommentBusiness", 1, "isReplaceStickyComment param is null");
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
  
  public void b(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    QCircleDoStickyRequest localQCircleDoStickyRequest = new QCircleDoStickyRequest(paramStFeed, paramStComment, 2);
    VSNetworkHelper.a().a(paramInt, localQCircleDoStickyRequest, new vkb(this, paramStFeed, paramStComment, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjy
 * JD-Core Version:    0.7.0.1
 */