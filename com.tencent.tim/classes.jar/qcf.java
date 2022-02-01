import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class qcf
  extends qdf
{
  public static final String awM = "https://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&ptype=%d&identify=1&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0" + ppf.getString(2131701925);
  public static final String awN = awM + "&et=%d&time_zone=%d";
  private final int[] dK;
  protected int mPlayType;
  
  public qcf(ShareGroupItem paramShareGroupItem, StoryVideoItem paramStoryVideoItem, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    ptf localptf = (ptf)psx.a(2);
    this.e = paramStoryVideoItem;
    this.mFeedId = paramString;
    this.mPlayType = paramInt1;
    this.blJ = paramInt2;
    this.awS = paramStoryVideoItem.mOwnerUid;
    this.mCurrentUin = localptf.h(this.awS, false);
    this.awQ = aqmr.substring(paramShareGroupItem.name, 0, 16, "...");
    this.mDoodleText = paramStoryVideoItem.mDoodleText;
    this.mTitle = mI();
    this.mBrief = (acfp.m(2131714365) + this.awQ + acfp.m(2131714373) + plr.asY);
    this.mHeadTip = (this.awQ + "\n" + paramInt2 + acfp.m(2131714369));
    new SimpleDateFormat("M月d日").format(Long.valueOf(paramLong));
    this.mSummary = mJ();
    this.awP = ("#" + plr.asY + "# " + mI() + "（" + this.mSummary + "）");
    this.type = 11;
    this.dK = new int[] { 0, 0, 97, 98, 99, 100, 101 };
  }
  
  public static qcf a(ShareGroupItem paramShareGroupItem, StoryVideoItem paramStoryVideoItem, String paramString, long paramLong, int paramInt)
  {
    return new qcf(paramShareGroupItem, paramStoryVideoItem, paramString, paramLong, 9, paramInt);
  }
  
  protected String bU(int paramInt)
  {
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&ptype=%d&identify=1&type=onedaylist&et=%d&time_zone=%d", new Object[] { this.mCurrentUin, this.e.mVid, this.awS, this.mFeedId, Integer.valueOf(this.mPlayType), Long.valueOf(this.e.mCreateTime / 1000L), Integer.valueOf(rpq.tP()) });
    }
    return String.format(awN, new Object[] { this.mCurrentUin, this.e.mVid, this.awS, this.mFeedId, Integer.valueOf(this.mPlayType), bV(paramInt), Integer.valueOf(this.dK[paramInt]), Long.valueOf(this.e.mCreateTime / 1000L), Integer.valueOf(rpq.tP()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qcf
 * JD-Core Version:    0.7.0.1
 */