import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_COMM.COMM.StCommonExt;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.subscribe.network.DoCommentRequest;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.subscribe.network.DoReplyReq;
import com.tencent.biz.subscribe.network.GetCommentListRequest;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class vzf
{
  private static final String jdField_a_of_type_JavaLangString = vzf.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Map<String, ArrayList<CertifiedAccountMeta.StComment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, Integer> b = new HashMap();
  private Map<String, vzo> c = new HashMap();
  
  private void a(String paramString, COMM.StCommonExt paramStCommonExt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c.get(paramString) == null)
    {
      vzo localvzo = new vzo();
      localvzo.jdField_a_of_type_NS_COMMCOMM$StCommonExt = paramStCommonExt;
      localvzo.jdField_a_of_type_Boolean = paramBoolean1;
      localvzo.b = paramBoolean2;
      this.c.put(paramString, localvzo);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "getDetailCommentSize: attachInfo:" + paramStCommonExt.attachInfo.get());
      return;
    }
    ((vzo)this.c.get(paramString)).jdField_a_of_type_Boolean = paramBoolean1;
    ((vzo)this.c.get(paramString)).jdField_a_of_type_NS_COMMCOMM$StCommonExt = paramStCommonExt;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((this.c != null) && (this.c.get(paramString) != null)) {
      ((vzo)this.c.get(paramString)).b = paramBoolean;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    if (paramStGetFeedDetailRsp != null)
    {
      Object localObject = paramStGetFeedDetailRsp.feed;
      String str = ((CertifiedAccountMeta.StFeed)localObject).id.get();
      a(str, paramStGetFeedDetailRsp.extInfo, true, true);
      ArrayList localArrayList = null;
      if (((CertifiedAccountMeta.StFeed)localObject).vecComment.size() > 0)
      {
        localArrayList = (ArrayList)((CertifiedAccountMeta.StFeed)localObject).vecComment.get();
        this.b.put(str, Integer.valueOf(((CertifiedAccountMeta.StFeed)localObject).commentCount.get()));
      }
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList(0);
        this.b.put(str, Integer.valueOf(0));
      }
      this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
      if (a(str) == 0) {
        QZLog.e(jdField_a_of_type_JavaLangString, 1, new Object[] { "后台返回评论数为0" });
      }
      sgi.a().dispatch(new vzr(5, new Object[] { str, Integer.valueOf(a(str)) }));
    }
    sgi.a().dispatch(a(new Object[] { Integer.valueOf(2), Long.valueOf(paramLong), paramString, paramStGetFeedDetailRsp, Integer.valueOf(hashCode()) }));
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.b.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public long a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment)
  {
    paramStFeed = new DoLikeRequest(paramStFeed);
    VSNetworkHelper.a().a(paramStFeed, new vzl(this));
    return Long.parseLong(paramStComment.id.get());
  }
  
  public long a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    paramStFeed = new DoReplyReq(paramStFeed, paramStComment, paramStReply, 1);
    VSNetworkHelper.a().a(paramStFeed, new vzj(this, paramStComment, paramStReply));
    return 0L;
  }
  
  public COMM.StCommonExt a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (vzo)this.c.get(paramString);
    if (paramString != null)
    {
      if ((paramString.b) && (paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_NS_COMMCOMM$StCommonExt != null)) {
        return paramString.jdField_a_of_type_NS_COMMCOMM$StCommonExt;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, paramString.toString());
    }
    return null;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public String a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment)
  {
    if ((paramStComment == null) || (paramStComment.id.get().startsWith("fake_id")))
    {
      sgi.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), ajjy.a(2131636380), null }));
      return "";
    }
    paramStFeed = new DoCommentRequest(paramStFeed, paramStComment, 0);
    VSNetworkHelper.a().a(paramStFeed, new vzi(this, paramStComment));
    return paramStComment.id.get();
  }
  
  public String a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if ((paramStReply == null) || (paramStReply.id.get().startsWith("fake_id")))
    {
      sgi.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), ajjy.a(2131636378), null }));
      return "";
    }
    paramStFeed = new DoReplyReq(paramStFeed, paramStComment, paramStReply, 0);
    VSNetworkHelper.a().a(paramStFeed, new vzk(this, paramStReply, paramStComment));
    return paramStReply.id.get();
  }
  
  public ArrayList<CertifiedAccountMeta.StComment> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public vzr a(Object... paramVarArgs)
  {
    return new vzr(6, paramVarArgs);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.c.clear();
    this.b.clear();
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    paramStFeed = new GetSubscribeFeedDetailRequest(paramStFeed);
    paramStFeed.setEnableCache(false);
    VSNetworkHelper.a().a(paramStFeed, new vzg(this));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment)
  {
    paramStFeed = new DoCommentRequest(paramStFeed, paramStComment, 1);
    VSNetworkHelper.a().a(paramStFeed, new vzh(this, paramStComment));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    paramStFeed = new DoLikeRequest(paramStFeed);
    VSNetworkHelper.a().a(paramStFeed, new vzm(this));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, COMM.StCommonExt paramStCommonExt)
  {
    paramStCommonExt = new GetCommentListRequest(paramStFeed, paramStCommonExt, 20);
    VSNetworkHelper.a().a(paramStCommonExt, new vzn(this, paramStFeed));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    COMM.StCommonExt localStCommonExt = a(paramStFeed.id.get());
    QZLog.i(jdField_a_of_type_JavaLangString, 1, "getComments loadMore: " + paramBoolean + ", attachInfo:" + localStCommonExt);
    if (paramBoolean)
    {
      if (localStCommonExt == null)
      {
        QZLog.e(jdField_a_of_type_JavaLangString, 1, new Object[] { "getComments loadMore: " + paramBoolean + ", attachInfo is null " });
        return;
      }
      a(paramStFeed.id.get(), false);
      a(paramStFeed, localStCommonExt);
      return;
    }
    a(paramStFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vzf
 * JD-Core Version:    0.7.0.1
 */