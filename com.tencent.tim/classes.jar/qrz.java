import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qrz
  extends pxf
  implements ppv.b<pyw, qah>
{
  private qrz.a a;
  private boolean aEU;
  private boolean aFg;
  private String axe;
  private int bnP = 0;
  private String mCookie;
  private String mFeedId;
  private int mPullType;
  private int mVideoSeq;
  
  public qrz(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.bnP = paramInt;
    this.mFeedId = paramFeedVideoInfo.feedId;
    this.mPullType = paramFeedVideoInfo.mVideoPullType;
    this.mCookie = paramFeedVideoInfo.mVideoNextCookie;
    this.mVideoSeq = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.mFeedId))
    {
      ram.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      rom.assertTrue(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public qrz(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.bnP = paramInt1;
    this.mFeedId = paramString;
    this.mPullType = paramInt2;
    this.mCookie = "";
    this.mVideoSeq = paramInt3;
    this.aFg = true;
    if (TextUtils.isEmpty(paramString))
    {
      ram.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      rom.assertTrue(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void b(qrz.b paramb)
  {
    qrz.a locala = this.a;
    if (locala == null)
    {
      pmi.a().dispatch(this.axe, paramb);
      return;
    }
    locala.a(paramb);
  }
  
  private void bqa()
  {
    pyk localpyk = new pyk();
    localpyk.nk = new ArrayList(1);
    localpyk.nk.add(new qvd(this.mFeedId, 0, "", "0"));
    ppv.a().a(localpyk, new qsa(this));
  }
  
  private void sendRequest()
  {
    if (VideoListFeedItem.isFakeFeedId(this.mFeedId))
    {
      localObject = new qrz.b(new ErrorMessage(), this.mFeedId);
      ((qrz.b)localObject).isEnd = true;
      ((qrz.b)localObject).isFirstPage = true;
      pmi.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.aFg) && (TextUtils.isEmpty(this.mCookie)))
    {
      bqa();
      return;
    }
    Object localObject = new pyw();
    ((pyw)localObject).feedId = this.mFeedId;
    ((pyw)localObject).avV = this.mCookie;
    ((pyw)localObject).bls = this.mPullType;
    ppv.a().a((ppw)localObject, this);
    ram.b("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((pyw)localObject).toString());
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.aEU) {
      return;
    }
    this.mCookie = "";
    sendRequest();
  }
  
  public void a(@NonNull pyw parampyw, @Nullable qah paramqah, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.b("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.aEU)
    {
      ram.i("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    qrz.b localb = new qrz.b(paramErrorMessage, this.mFeedId);
    localb.aCv = this.aCx;
    if ((paramqah == null) || (paramErrorMessage.isFail()))
    {
      b(localb);
      return;
    }
    boolean bool = TextUtils.isEmpty(parampyw.avV);
    this.mCookie = paramqah.nextCookie;
    localb.oj = paramqah.mU;
    localb.isFirstPage = bool;
    localb.isEnd = paramqah.isEnd;
    if ((!localb.isEnd) && (TextUtils.isEmpty(this.mCookie))) {
      localb.isEnd = true;
    }
    localb.mUnionId = paramqah.unionId;
    localb.oj = ((qvf)psx.a(11)).a(this.mFeedId, localb.oj, bool);
    localb.a = new FeedVideoInfo(parampyw.feedId, this.mVideoSeq, this.mPullType, this.mCookie, localb.isEnd);
    parampyw = new ArrayList(localb.oj.size());
    paramqah = localb.oj.iterator();
    while (paramqah.hasNext()) {
      parampyw.add(((StoryVideoItem)paramqah.next()).mVid);
    }
    pxt.ei(parampyw);
    try
    {
      this.aCy = true;
      b(localb);
      ram.b("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localb);
      return;
    }
    finally {}
  }
  
  public void a(qrz.a parama)
  {
    this.a = parama;
  }
  
  public void aPh()
  {
    super.aPh();
    if (this.aEU) {
      return;
    }
    sendRequest();
  }
  
  public void m(int paramInt1, String paramString, int paramInt2)
  {
    this.mPullType = paramInt1;
    this.mCookie = paramString;
    this.mVideoSeq = paramInt2;
  }
  
  public void rV(String paramString)
  {
    this.axe = paramString;
  }
  
  public void terminate()
  {
    this.aEU = true;
  }
  
  public static abstract interface a
  {
    public abstract void a(qrz.b paramb);
  }
  
  public static class b
    extends pxc
  {
    public FeedVideoInfo a;
    public String mFeedId;
    public String mUnionId;
    public List<StoryVideoItem> oj = new ArrayList();
    
    public b(ErrorMessage paramErrorMessage, String paramString)
    {
      super();
      this.mFeedId = paramString;
    }
    
    public String toString()
    {
      return "GetVideoListEvent{mVideoItems=" + this.oj.size() + ", feedId=" + this.mFeedId + ", mUnionId=" + this.mUnionId + '}' + super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrz
 * JD-Core Version:    0.7.0.1
 */