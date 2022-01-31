import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_COMM.COMM.Entry;
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
import java.util.List;
import java.util.Map;

public class ybg
{
  private static final String jdField_a_of_type_JavaLangString = ybg.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Map<String, ArrayList<CertifiedAccountMeta.StComment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, Integer> b = new HashMap();
  private Map<String, ybq> c = new HashMap();
  
  private String a(COMM.StCommonExt paramStCommonExt)
  {
    if ((paramStCommonExt != null) && (paramStCommonExt.mapInfo.size() > 0)) {
      return ((COMM.Entry)paramStCommonExt.mapInfo.get(0)).value.get();
    }
    return "";
  }
  
  private void a(String paramString, COMM.StCommonExt paramStCommonExt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c.get(paramString) == null)
    {
      ybq localybq = new ybq();
      localybq.jdField_a_of_type_NS_COMMCOMM$StCommonExt = paramStCommonExt;
      localybq.jdField_a_of_type_Boolean = paramBoolean1;
      localybq.b = paramBoolean2;
      this.c.put(paramString, localybq);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "getDetailCommentSize: attachInfo:" + paramStCommonExt.attachInfo.get());
      return;
    }
    ((ybq)this.c.get(paramString)).jdField_a_of_type_Boolean = paramBoolean1;
    ((ybq)this.c.get(paramString)).jdField_a_of_type_NS_COMMCOMM$StCommonExt = paramStCommonExt;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((this.c != null) && (this.c.get(paramString) != null)) {
      ((ybq)this.c.get(paramString)).b = paramBoolean;
    }
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
        this.b.put(str, Integer.valueOf(((CertifiedAccountMeta.StFeed)localObject).commentCount.get()));
      }
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList(0);
        this.b.put(str, Integer.valueOf(0));
      }
      this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
      paramStGetFeedDetailRsp.feed.vecComment.set((List)localObject);
      if (a(str) == 0) {
        QZLog.e(jdField_a_of_type_JavaLangString, 1, new Object[] { "后台返回评论数为0" });
      }
      uht.a().dispatch(new ybt(5, new Object[] { str, Integer.valueOf(a(str)) }));
    }
    uht.a().dispatch(a(new Object[] { Integer.valueOf(2), Long.valueOf(paramLong), paramString, paramStGetFeedDetailRsp, Integer.valueOf(hashCode()), paramStCommonExt }));
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
    VSNetworkHelper.a().a(paramStFeed, new ybn(this));
    return Long.parseLong(paramStComment.id.get());
  }
  
  public long a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    paramStFeed = new DoReplyReq(paramStFeed, paramStComment, paramStReply, 1);
    VSNetworkHelper.a().a(paramStFeed, new ybl(this, paramStComment, paramStReply));
    return 0L;
  }
  
  public COMM.StCommonExt a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (ybq)this.c.get(paramString);
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
      uht.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), alpo.a(2131702547), null }));
      return "";
    }
    paramStFeed = new DoCommentRequest(paramStFeed, paramStComment, 0);
    VSNetworkHelper.a().a(paramStFeed, new ybk(this, paramStComment));
    return paramStComment.id.get();
  }
  
  public String a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if ((paramStReply == null) || (paramStReply.id.get().startsWith("fake_id")))
    {
      uht.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), alpo.a(2131702545), null }));
      return "";
    }
    paramStFeed = new DoReplyReq(paramStFeed, paramStComment, paramStReply, 0);
    VSNetworkHelper.a().a(paramStFeed, new ybm(this, paramStReply, paramStComment));
    return paramStReply.id.get();
  }
  
  public ArrayList<CertifiedAccountMeta.StComment> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
  
  public ybt a(Object... paramVarArgs)
  {
    return new ybt(6, paramVarArgs);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.c.clear();
    this.b.clear();
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment)
  {
    paramStFeed = new DoCommentRequest(paramStFeed, paramStComment, 1);
    VSNetworkHelper.a().a(paramStFeed, new ybj(this, paramStComment));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    paramStFeed = new DoLikeRequest(paramStFeed);
    VSNetworkHelper.a().a(paramStFeed, new ybo(this));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, COMM.StCommonExt paramStCommonExt)
  {
    ybh localybh = new ybh(this, paramStCommonExt);
    if (paramStCommonExt == null)
    {
      String str = paramStFeed.id.get();
      if (yfo.a("1002" + str))
      {
        yfo.a("1002" + str, new ybi(this, localybh));
        yfo.a("1002" + str);
        return;
      }
    }
    paramStFeed = new GetSubscribeFeedDetailRequest(paramStFeed, paramStCommonExt);
    paramStFeed.setEnableCache(false);
    VSNetworkHelper.a().a(paramStFeed, localybh);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, COMM.StCommonExt paramStCommonExt, String paramString)
  {
    paramStCommonExt = new GetCommentListRequest(paramStFeed, paramStCommonExt, 20);
    VSNetworkHelper.a().a(paramStCommonExt, new ybp(this, paramStFeed, paramString));
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
      QZLog.i(jdField_a_of_type_JavaLangString, 1, "getComments loadMore: " + paramBoolean + ", attachInfo:" + localStCommonExt);
      if (localStCommonExt == null)
      {
        QZLog.e(jdField_a_of_type_JavaLangString, 1, new Object[] { "getComments loadMore: " + paramBoolean + ", attachInfo is null " });
        return;
      }
      a(paramStFeed.id.get(), false);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ybg
 * JD-Core Version:    0.7.0.1
 */