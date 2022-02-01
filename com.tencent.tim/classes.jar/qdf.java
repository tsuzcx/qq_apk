import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.a;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class qdf
  extends qci
{
  protected String awP;
  protected String awQ;
  protected String awS;
  protected int blI;
  protected int blJ = 1;
  protected StoryVideoItem e;
  protected String mBrief;
  protected String mCurrentUin;
  protected String mDoodleText;
  protected String mFeedId;
  protected String mHeadTip;
  protected String mSummary;
  protected String mTitle;
  protected int shareType = -1;
  protected int type = -1;
  
  public final void a(qdj paramqdj)
  {
    super.a(paramqdj);
    paramqdj.url = bU(6);
    g(paramqdj);
  }
  
  public final void a(qdl paramqdl)
  {
    super.a(paramqdl);
    paramqdl.blM = 0;
    paramqdl.brief = this.mBrief;
    paramqdl.imgUrl = this.e.mVideoThumbnailUrl;
    paramqdl.mVid = this.e.mVid;
    paramqdl.mHeadTip = this.mHeadTip;
    paramqdl.msgAction = bU(1);
    if (this.shareType != -1) {
      paramqdl.shareType = this.shareType;
    }
    if (this.type != -1) {
      paramqdl.type = this.type;
    }
    g(paramqdl);
  }
  
  public final void a(qdm paramqdm)
  {
    super.a(paramqdm);
    paramqdm.imageUrl = this.e.mVideoThumbnailUrl;
    paramqdm.title = this.mTitle;
    paramqdm.summary = this.mSummary;
    paramqdm.url = bU(2);
    g(paramqdm);
  }
  
  public final void a(qdn paramqdn)
  {
    super.a(paramqdn);
    paramqdn.imageUrl = this.e.mVideoThumbnailUrl;
    paramqdn.awU = this.e.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramqdn.awU)) {
      paramqdn.awU = qdv.fV(paramqdn.imageUrl);
    }
    paramqdn.url = bU(5);
    paramqdn.title = this.awP;
    g(paramqdn);
  }
  
  public void a(qdo paramqdo)
  {
    super.a(paramqdo);
    paramqdo.summary = this.mSummary;
    paramqdo.title = this.mTitle;
    paramqdo.url = bU(3);
    paramqdo.imageUrl = this.e.mVideoThumbnailUrl;
    paramqdo.aCT = true;
    g(paramqdo);
  }
  
  public void b(qdo paramqdo)
  {
    super.b(paramqdo);
    paramqdo.summary = this.mSummary;
    paramqdo.title = this.mTitle;
    paramqdo.imageUrl = this.e.mVideoThumbnailUrl;
    paramqdo.url = bU(4);
    paramqdo.aCT = true;
    g(paramqdo);
  }
  
  protected void g(qdk paramqdk) {}
  
  protected void h(qdk paramqdk)
  {
    ram.d("VideoShareModeBase", "prepareCommonShareData");
    super.h(paramqdk);
    if (this.e.isPollVideo()) {
      paramqdk.ct("vote", "1");
    }
    for (;;)
    {
      paramqdk.f = this.e;
      return;
      if (this.e.isInteractVideo()) {
        paramqdk.ct("grade", "1");
      }
    }
  }
  
  protected String mI()
  {
    if (this.e.isPollVideo()) {
      return this.awQ + acfp.m(2131716445);
    }
    if (this.e.isInteractVideo()) {
      return this.awQ + acfp.m(2131716456);
    }
    if (this.e.isGameVideo())
    {
      ptw localptw = this.e.getVideoGameInfo();
      if (localptw.type == 2) {
        return acfp.m(2131716447) + localptw.name + acfp.m(2131716431);
      }
      if (this.blI == 0) {
        return acfp.m(2131716432) + localptw.name + localptw.result + acfp.m(2131716455);
      }
      return this.e.mOwnerName + acfp.m(2131716440) + localptw.name + localptw.result + acfp.m(2131716436);
    }
    return this.awQ + acfp.m(2131716444) + plr.asY;
  }
  
  protected String mJ()
  {
    Object localObject1 = this.e.getPollLayout();
    Object localObject2 = this.e.getInteractLayout();
    if ((localObject1 != null) && (((StoryVideoItem.b)localObject1).bR != null) && (((StoryVideoItem.b)localObject1).bR.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.bR[0];
    }
    if ((localObject2 != null) && (((StoryVideoItem.a)localObject2).bR != null) && (((StoryVideoItem.a)localObject2).bR.length > 0))
    {
      localObject1 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject1 + " · " + localObject2.bR[0];
    }
    localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
    if (TextUtils.isEmpty(this.mDoodleText)) {}
    for (localObject1 = "1个小视频";; localObject1 = this.mDoodleText) {
      return (String)localObject2 + " · " + (String)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdf
 * JD-Core Version:    0.7.0.1
 */