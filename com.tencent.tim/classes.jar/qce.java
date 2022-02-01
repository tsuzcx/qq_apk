import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.app.QQAppInterface;

public class qce
  extends qdf
{
  public static final String awH = "https://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0" + ppf.getString(2131701925);
  public boolean aCO;
  private final int[] dK;
  
  public qce(StoryVideoItem paramStoryVideoItem, boolean paramBoolean, String paramString)
  {
    QQAppInterface localQQAppInterface = qem.getQQAppInterface();
    ptf localptf = (ptf)psx.a(2);
    this.e = paramStoryVideoItem;
    this.aCO = paramBoolean;
    this.awQ = localQQAppInterface.getCurrentNickname();
    String str;
    int i;
    if (this.e.isPollVideo())
    {
      str = this.awQ + acfp.m(2131708621);
      this.mTitle = str;
      this.awS = paramStoryVideoItem.mOwnerUid;
      this.mCurrentUin = localptf.h(this.awS, false);
      this.mDoodleText = paramStoryVideoItem.mDoodleText;
      str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.mFeedId = str;
      if (!paramStoryVideoItem.isMine()) {
        break label363;
      }
      i = 0;
      label137:
      this.blI = i;
      this.awQ = localQQAppInterface.getCurrentNickname();
      paramStoryVideoItem = localptf.b(this.awS);
      if ((paramStoryVideoItem != null) && (paramStoryVideoItem.isVip)) {
        this.awQ = paramStoryVideoItem.nickName;
      }
      this.mTitle = mI();
      this.mBrief = this.mTitle;
      this.mSummary = mJ();
      this.awP = ("#" + plr.asY + "# " + mI() + "（" + this.mSummary + "）");
      this.type = 11;
      if (!this.aCO) {
        break label369;
      }
    }
    label363:
    label369:
    for (this.type = 4;; this.type = 1)
    {
      if (!this.aCO) {
        break label377;
      }
      this.dK = new int[] { 0, 0, 38, 39, 40, 55, 45 };
      return;
      str = this.awQ + acfp.m(2131708622) + plr.asY;
      break;
      i = 1;
      break label137;
    }
    label377:
    this.dK = new int[] { 0, 0, 32, 33, 34, 54, 45 };
  }
  
  protected String bU(int paramInt)
  {
    int i = 3;
    if (paramInt == 1)
    {
      str1 = this.mCurrentUin;
      str2 = this.e.mVid;
      str3 = this.awS;
      str4 = this.mFeedId;
      paramInt = this.blI;
      if (this.aCO) {}
      for (;;)
      {
        return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&identify=%d&ptype=%d", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt), Integer.valueOf(i) });
        i = 1;
      }
    }
    String str1 = awH;
    String str2 = this.mCurrentUin;
    String str3 = this.e.mVid;
    String str4 = this.awS;
    String str5 = this.mFeedId;
    int j = this.blI;
    if (this.aCO) {}
    for (;;)
    {
      return String.format(str1, new Object[] { str2, str3, str4, str5, Integer.valueOf(j), Integer.valueOf(i), bV(paramInt), Integer.valueOf(this.dK[paramInt]) });
      i = 1;
    }
  }
  
  protected void g(qdk paramqdk)
  {
    ptw localptw;
    if ((paramqdk instanceof qdl))
    {
      localptw = this.e.getVideoGameInfo();
      if (localptw != null) {}
    }
    else
    {
      return;
    }
    paramqdk = (qdl)paramqdk;
    paramqdk.storyTitle = localptw.name;
    if (localptw.type == 2) {}
    for (paramqdk.storyBrief = acfp.m(2131708623);; paramqdk.storyBrief = (localptw.result + acfp.m(2131708624)))
    {
      paramqdk.brief = mI();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qce
 * JD-Core Version:    0.7.0.1
 */