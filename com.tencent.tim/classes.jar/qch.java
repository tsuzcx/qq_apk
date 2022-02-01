import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class qch
  extends qci
{
  protected String awP;
  protected String awQ;
  protected String awR;
  protected String awS;
  protected int blI;
  protected int blJ = 1;
  protected StoryVideoItem e;
  protected String mBrief;
  protected String mCurrentUin;
  protected String mFeedId;
  protected String mSummary;
  protected String mTitle;
  protected int shareType = -1;
  protected int type = -1;
  
  public final void a(qdj paramqdj)
  {
    super.a(paramqdj);
    paramqdj.url = bU(6);
  }
  
  public final void a(qdl paramqdl)
  {
    super.a(paramqdl);
    paramqdl.blM = 0;
    paramqdl.brief = this.mBrief;
    paramqdl.imgUrl = this.e.mVideoThumbnailUrl;
    paramqdl.mVid = this.e.mVid;
    paramqdl.msgAction = bU(1);
    if (this.shareType != -1) {
      paramqdl.shareType = this.shareType;
    }
    if (this.type != -1) {
      paramqdl.type = this.type;
    }
  }
  
  public final void a(qdm paramqdm)
  {
    super.a(paramqdm);
    paramqdm.imageUrl = this.e.mVideoThumbnailUrl;
    paramqdm.title = this.mTitle;
    paramqdm.summary = this.mSummary;
    paramqdm.url = bU(2);
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
  }
  
  public void a(qdo paramqdo)
  {
    super.a(paramqdo);
    paramqdo.summary = this.mSummary;
    paramqdo.title = this.awR;
    paramqdo.url = bU(3);
    paramqdo.imageUrl = this.e.mVideoThumbnailUrl;
    paramqdo.aCT = true;
  }
  
  public void b(qdo paramqdo)
  {
    super.b(paramqdo);
    paramqdo.summary = this.mSummary;
    paramqdo.title = this.mTitle;
    paramqdo.url = bU(4);
    paramqdo.imageUrl = this.e.mVideoThumbnailUrl;
    paramqdo.aCT = true;
  }
  
  protected void h(qdk paramqdk)
  {
    ram.d("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qch
 * JD-Core Version:    0.7.0.1
 */