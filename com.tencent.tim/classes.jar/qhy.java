import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class qhy
  implements IEventReceiver
{
  private Stream<qru> jdField_a_of_type_ComTribeAsyncReactiveStream;
  private psa jdField_a_of_type_Psa = (psa)psx.a(17);
  private qhy.a jdField_a_of_type_Qhy$a;
  private qhy.b jdField_a_of_type_Qhy$b;
  private qhy.f jdField_a_of_type_Qhy$f;
  private qrl jdField_a_of_type_Qrl;
  private qru jdField_a_of_type_Qru = new qru();
  private qsn.b jdField_a_of_type_Qsn$b;
  private qvf jdField_a_of_type_Qvf = (qvf)psx.a(11);
  private boolean aDw;
  private qrl b;
  private int bms = -1;
  private WeakReference<qhy.g> cU;
  private String mFeedId;
  public CharSequence x;
  
  private void a(qru paramqru)
  {
    if (paramqru == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramqru.Kl()) {
          break label39;
        }
        if (!paramqru.Km()) {
          break;
        }
      } while (this.bms != -1);
      this.bms = 1;
      return;
      this.bms = 1;
      return;
    } while (this.bms == -1);
    this.bms = -1;
  }
  
  private void a(@NonNull qru paramqru, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      if (!paramBoolean) {
        break label120;
      }
    }
    label120:
    for (String str = "updated";; str = "not updated")
    {
      ram.w("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramqru });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Qru = paramqru;
        a(paramqru);
        bov();
        bou();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_Qrl.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((qhy.g)localObject).a(paramqru, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void bou()
  {
    if (this.jdField_a_of_type_Qsn$b == null)
    {
      this.jdField_a_of_type_Qsn$b = new qsn.b(this.mFeedId, new qhz(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Qsn$b);
      return;
    }
    this.jdField_a_of_type_Qsn$b.mFeedId = this.mFeedId;
  }
  
  private void onCreate()
  {
    ram.w("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.aDw = true;
    this.mFeedId = null;
    this.jdField_a_of_type_Qru = new qru();
    this.jdField_a_of_type_Qhy$a = new qhy.a(this);
    pmi.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_Qhy$a);
    this.jdField_a_of_type_Qhy$f = new qhy.f(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qhy$f);
    this.jdField_a_of_type_Qhy$b = new qhy.b(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qhy$b);
  }
  
  @Nullable
  public qhy.g a()
  {
    if (this.cU != null) {
      return (qhy.g)this.cU.get();
    }
    return null;
  }
  
  public qru a()
  {
    return this.jdField_a_of_type_Qru;
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qru.d(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Qru.d = ((CommentLikeFeedItem)this.jdField_a_of_type_Qvf.a(this.jdField_a_of_type_Qru.d));
    this.jdField_a_of_type_Psa.e(paramCommentEntry);
    a(this.jdField_a_of_type_Qru);
  }
  
  public void a(qhy.g paramg)
  {
    this.cU = new WeakReference(paramg);
  }
  
  public void bot()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.mFeedId).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new qhy.e()).map(new qhy.c()).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new qhy.d());
    ram.w("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.mFeedId });
  }
  
  public void bov()
  {
    ram.b("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.mFeedId);
    if (!this.jdField_a_of_type_Qru.Kl())
    {
      this.b = new qrl(new qvc(this.mFeedId, 2, this.jdField_a_of_type_Qru.j(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_Qrl = new qrl(new qvc(this.mFeedId, 2, this.jdField_a_of_type_Qru.j(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_Qrl = new qrl(new qvc(this.mFeedId, 2, this.jdField_a_of_type_Qru.j(false), 1), "CommentFloatDialogController");
    this.b = new qrl(new qvc(this.mFeedId, 2, this.jdField_a_of_type_Qru.j(true), 0), "CommentFloatDialogController");
  }
  
  public void destroy()
  {
    ram.w("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.aDw = false;
    this.mFeedId = null;
    this.jdField_a_of_type_Qru = new qru();
    if (this.jdField_a_of_type_Qhy$a != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qhy$a);
    }
    if (this.jdField_a_of_type_Qhy$f != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qhy$f);
    }
    if (this.jdField_a_of_type_Qhy$b != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qhy$b);
    }
    if (this.jdField_a_of_type_Qsn$b != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_Qsn$b);
    }
  }
  
  public boolean isOpen()
  {
    return (this.bms == -1) || (this.bms == 2);
  }
  
  public boolean isValidate()
  {
    return this.aDw;
  }
  
  public int sB()
  {
    return this.bms;
  }
  
  public void sD(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.aPh();
    }
    for (;;)
    {
      rar.a("home_page", "load_detail", 0, 0, new String[] { "", rar.bX(4444), "", this.mFeedId });
      return;
      this.jdField_a_of_type_Qrl.aPh();
    }
  }
  
  public void setFeedId(@NonNull String paramString)
  {
    if (!this.aDw) {
      onCreate();
    }
    if (!TextUtils.equals(this.mFeedId, paramString))
    {
      this.x = null;
      if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
        this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
      }
      this.jdField_a_of_type_Qru = new qru();
      bov();
    }
    this.mFeedId = paramString;
  }
  
  public void setTabType(int paramInt)
  {
    if (this.bms != paramInt)
    {
      this.bms = paramInt;
      a(this.jdField_a_of_type_Qru, new ErrorMessage(), false);
    }
  }
  
  static class a
    extends pml<qhy, qrl.b>
  {
    a(qhy paramqhy)
    {
      super();
    }
    
    public void a(@NonNull qhy paramqhy, @NonNull qrl.b paramb)
    {
      if ((!paramb.mFeedId.equals(qhy.a(paramqhy))) || (paramb.b.isFail()) || (qhy.a(paramqhy) == null)) {
        ram.d("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramb.toString());
      }
      qhy.g localg;
      do
      {
        boolean bool2;
        boolean bool1;
        do
        {
          return;
          ram.b("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramb.toString());
          bool2 = paramqhy.isOpen();
          bool1 = true;
          if (paramb.mType == 0) {
            bool1 = false;
          }
          qhy.a(paramqhy).ti(bool1);
          qhy.a(paramqhy).ac(bool1, paramb.mTotalCount);
          qhy.a(paramqhy).ap(bool1, paramb.isEnd);
          qhy.a(paramqhy).d(paramb.nh, paramb.isFirstPage, bool1);
        } while (bool2 != bool1);
        localg = paramqhy.a();
      } while (localg == null);
      localg.a(qhy.a(paramqhy), paramb.b.isSuccess());
    }
    
    public Class acceptEventClass()
    {
      return qrl.b.class;
    }
    
    public void b(@NonNull qhy paramqhy, @NonNull qrl.b paramb)
    {
      boolean bool2 = paramqhy.isOpen();
      boolean bool1 = true;
      if (paramb.mType == 0) {
        bool1 = false;
      }
      if (bool2 == bool1)
      {
        paramb = paramqhy.a();
        if (paramb != null) {
          paramb.a(qhy.a(paramqhy), false);
        }
      }
    }
  }
  
  public static class b
    extends pml<qhy, pqs>
  {
    public b(qhy paramqhy)
    {
      super();
    }
    
    public void a(@NonNull qhy paramqhy, @NonNull pqs parampqs)
    {
      if ((parampqs.bjU == 2) || (!parampqs.feedId.equals(qhy.a(paramqhy))) || (qhy.a(paramqhy) == null) || (qhy.a(paramqhy).d == null)) {
        ram.d(this.TAG, "ignore this feed info change event. %s.", parampqs.toString());
      }
      qhy.g localg;
      do
      {
        return;
        ram.b(this.TAG, "receive feed info change event. %s.", parampqs.toString());
        localg = paramqhy.a();
        switch (parampqs.what)
        {
        default: 
          return;
        }
        if (parampqs.c != null)
        {
          qhy.a(paramqhy).d.mCommentCount = parampqs.c.mCommentCount;
          qhy.a(paramqhy).d.mFriendCommentCount = parampqs.c.mFriendCommentCount;
          qhy.a(paramqhy).d.mFanCommentCount = parampqs.c.mFanCommentCount;
        }
        qhy.a(paramqhy).wv(parampqs.commentId);
      } while (localg == null);
      localg.a(qhy.a(paramqhy), parampqs.b.isSuccess());
    }
    
    public Class acceptEventClass()
    {
      return pqs.class;
    }
    
    public void b(@NonNull qhy paramqhy, @NonNull pqs parampqs) {}
  }
  
  public class c
    extends JobSegment<qru, qru>
  {
    public c() {}
    
    protected void a(JobContext paramJobContext, qru paramqru)
    {
      paramqru.d(qhy.a(qhy.this).a(paramqru.d.feedId, true), true, true);
      if (paramqru.Kl()) {
        paramqru.d(qhy.a(qhy.this).a(qhy.a(qhy.this), false), true, false);
      }
      ram.b("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", qhy.a(qhy.this).toString());
      notifyResult(paramqru);
    }
  }
  
  public class d
    extends SimpleObserver<qru>
  {
    public d() {}
    
    public void b(qru paramqru)
    {
      super.onNext(paramqru);
      qhy.a(qhy.this, paramqru, new ErrorMessage(), true);
    }
    
    public void onCancel()
    {
      super.onCancel();
      ram.w("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
    }
    
    public void onError(@NonNull Error paramError)
    {
      super.onError(paramError);
      if (((ErrorMessage)paramError).errorCode == 2223)
      {
        qhy.a(qhy.this, qhy.a(qhy.this), new ErrorMessage(), false);
        return;
      }
      qhy.a(qhy.this, qhy.a(qhy.this), (ErrorMessage)paramError, false);
    }
  }
  
  public class e
    extends JobSegment<String, qru>
  {
    public e() {}
    
    protected void a(JobContext paramJobContext, String paramString)
    {
      if ((qhy.a(qhy.this).d != null) && (TextUtils.equals(qhy.a(qhy.this).d.feedId, paramString)))
      {
        ram.w("Q.qqstory.player.CommentFloatDialogController", "feed item already exist , no need to pull again");
        notifyError(new ErrorMessage(2223, "feed item already exist"));
        return;
      }
      paramString = new qru();
      Object localObject1 = (CommentLikeFeedItem)((qvf)psx.a(11)).a(qhy.a(qhy.this));
      if (localObject1 != null)
      {
        if ((localObject1 instanceof VideoListFeedItem))
        {
          paramJobContext = (VideoListFeedItem)localObject1;
          localObject2 = ((qvi)psx.a(12)).a(qhy.a(qhy.this), paramJobContext.mVideoPullType);
          if (localObject2 != null)
          {
            paramJobContext.mVideoNextCookie = ((FeedVideoInfo)localObject2).mVideoNextCookie;
            paramJobContext.mIsVideoEnd = ((FeedVideoInfo)localObject2).mIsVideoEnd;
            paramJobContext.mVideoPullType = ((FeedVideoInfo)localObject2).mVideoPullType;
            paramJobContext.mVideoSeq = ((FeedVideoInfo)localObject2).mVideoSeq;
            paramString.I(((FeedVideoInfo)localObject2).mVideoItemList, true);
          }
        }
        paramString.d = ((CommentLikeFeedItem)localObject1);
        notifyResult(paramString);
        return;
      }
      localObject1 = new pyk();
      ((pyk)localObject1).nk = new ArrayList();
      Object localObject2 = new qvd(qhy.a(qhy.this), 0, "", "");
      ((pyk)localObject1).nk.add(localObject2);
      ppv.a().a((ppw)localObject1, new qia(this, paramJobContext, paramString));
    }
  }
  
  public static class f
    extends QQUIEventReceiver<qhy, pxs.b>
  {
    public f(@NonNull qhy paramqhy)
    {
      super();
    }
    
    public void a(@NonNull qhy paramqhy, @NonNull pxs.b paramb)
    {
      if (paramb.b.isSuccess())
      {
        ram.b(this.TAG, "receive user info event. %s.", paramb.toString());
        paramqhy = paramqhy.a();
        if (paramqhy != null) {
          paramqhy.bow();
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
  
  public static abstract interface g
  {
    public abstract void a(@NonNull qru paramqru, ErrorMessage paramErrorMessage, boolean paramBoolean);
    
    public abstract void a(@NonNull qru paramqru, boolean paramBoolean);
    
    public abstract void bow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhy
 * JD-Core Version:    0.7.0.1
 */