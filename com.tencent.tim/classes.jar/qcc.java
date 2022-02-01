import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class qcc
  extends qch
{
  public static final String awH = "https://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&ptype=%d&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0" + ppf.getString(2131701925);
  public static final String awI = awH + "&type=" + "onedaylist" + "&feedid=%s&identify=%d";
  private int[] dK;
  
  public qcc(StoryVideoItem paramStoryVideoItem, String paramString, int paramInt)
  {
    Object localObject = ((qvf)psx.a(11)).a(paramString);
    if (localObject == null) {
      return;
    }
    ptf localptf = (ptf)psx.a(2);
    localObject = (QQUserUIItem)((FeedItem)localObject).getOwner();
    this.e = paramStoryVideoItem;
    this.mTitle = (((QQUserUIItem)localObject).nickName + acfp.m(2131706164) + plr.asY);
    this.awR = (((QQUserUIItem)localObject).nickName + acfp.m(2131706163) + plr.asY);
    this.mCurrentUin = localptf.h(((QQUserUIItem)localObject).getUnionId(), false);
    int i;
    if (((QQUserUIItem)localObject).isMe())
    {
      i = 0;
      this.blI = i;
      this.mFeedId = paramString;
      this.blJ = paramInt;
      this.awQ = ((QQUserUIItem)localObject).nickName;
      this.awS = ((QQUserUIItem)localObject).getUnionId();
      this.mBrief = q(this.awQ, this.e.mCreateTime);
      paramStoryVideoItem = new SimpleDateFormat("M月d日").format(Long.valueOf(this.e.mCreateTime));
      this.mSummary = (paramStoryVideoItem + " · " + this.blJ + acfp.m(2131706166));
      this.awP = ("#" + plr.asY + "# " + this.awQ + acfp.m(2131706165) + plr.asY + "（" + this.mSummary + "）");
      if (this.blI != 0) {
        break label400;
      }
    }
    label400:
    for (paramInt = 8;; paramInt = 9)
    {
      this.type = paramInt;
      if (this.blI != 0) {
        break label406;
      }
      this.dK = new int[] { 0, 81, 82, 83, 84, 85, 45 };
      return;
      i = 1;
      break;
    }
    label406:
    this.dK = new int[] { 0, 69, 70, 71, 72, 73, 45 };
  }
  
  protected String bU(int paramInt)
  {
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&ptype=%d&type=onedaylist&feedid=%s&identify=%d&sharefromtype=%d", new Object[] { this.mCurrentUin, this.e.mVid, this.awS, Integer.valueOf(5), this.mFeedId, Integer.valueOf(this.blI), Integer.valueOf(this.dK[paramInt]) });
    }
    return String.format(awI, new Object[] { this.mCurrentUin, this.e.mVid, this.awS, Integer.valueOf(5), bV(paramInt), Integer.valueOf(this.dK[paramInt]), this.mFeedId, Integer.valueOf(this.blI) });
  }
  
  public String q(String paramString, long paramLong)
  {
    String str = new SimpleDateFormat("M月d日").format(Long.valueOf(paramLong));
    return paramString + acfp.m(2131706162) + str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qcc
 * JD-Core Version:    0.7.0.1
 */