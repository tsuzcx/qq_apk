import com.tencent.biz.qqstory.model.item.QQUserUIItem;

public class qcd
  extends qcg
{
  public static final String awH = "https://story.now.qq.com/mobile/transfer.html?" + awJ + "&actionnamekey=3&one_page=0";
  public static final String awJ = "src_type=internal&version=1&uin=%s&usertype=%s&unionid=%s&fromId=%s&storysharefrom=%s" + ppf.getString(2131701925);
  public static final String awK = "mqqapi://qstory/infoCard?" + awJ;
  private String awL;
  private final int[] dK;
  private String mUserUin;
  private int vZ;
  
  public qcd(QQUserUIItem paramQQUserUIItem)
  {
    this.mUserUin = paramQQUserUIItem.qq;
    this.mImageUrl = paramQQUserUIItem.headUrl;
    int i;
    if (paramQQUserUIItem.isVip)
    {
      i = 1;
      this.vZ = i;
      this.awL = paramQQUserUIItem.uid;
      this.mTitle = (paramQQUserUIItem.nickName + acfp.m(2131707403) + plr.asY);
      this.mBrief = ("[" + plr.asY + acfp.m(2131707406) + paramQQUserUIItem.nickName + acfp.m(2131707409) + plr.asY);
      this.mCompatibleText = (paramQQUserUIItem.nickName + acfp.m(2131707408) + plr.asY + acfp.m(2131707402) + plr.asY + acfp.m(2131707405) + ppf.getString(2131701922) + acfp.m(2131707404));
      if (paramQQUserUIItem.videoCount > 0) {
        break label331;
      }
    }
    label331:
    for (this.mSummary = "0个小视频";; this.mSummary = (paramQQUserUIItem.videoCount + acfp.m(2131707407)))
    {
      this.awP = ("#" + plr.asY + "# " + this.mTitle + "（" + this.mSummary + "）");
      this.shareType = 102;
      this.aCP = true;
      this.dK = new int[] { 0, 13, 14, 15, 16, 17, 18 };
      return;
      i = 0;
      break;
    }
  }
  
  protected String bU(int paramInt)
  {
    if (paramInt == 1) {
      return String.format(awK, new Object[] { this.mUserUin, Integer.valueOf(this.vZ), this.awL, Integer.valueOf(this.dK[paramInt]), bV(paramInt) });
    }
    return String.format(awH, new Object[] { this.mUserUin, Integer.valueOf(this.vZ), this.awL, Integer.valueOf(this.dK[paramInt]), bV(paramInt) });
  }
  
  protected void g(qdk paramqdk)
  {
    super.g(paramqdk);
    if ((paramqdk != null) && ((paramqdk instanceof qdl))) {
      ((qdl)paramqdk).imgUrl = (qdv.fW(this.mImageUrl) + "#private_share_cache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qcd
 * JD-Core Version:    0.7.0.1
 */