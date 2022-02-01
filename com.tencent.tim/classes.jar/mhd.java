import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;

public class mhd
  implements Cloneable
{
  public int BT;
  public int aOw;
  public String agS;
  public String agT;
  
  public static mhd a(articlesummary.FamilyCommentInfo paramFamilyCommentInfo)
  {
    mhd localmhd = new mhd();
    localmhd.agS = paramFamilyCommentInfo.icon_url.get().toStringUtf8();
    localmhd.agT = paramFamilyCommentInfo.jump_url.get().toStringUtf8();
    localmhd.aOw = paramFamilyCommentInfo.medal_urls_width.get();
    localmhd.BT = paramFamilyCommentInfo.medal_urls_height.get();
    return localmhd;
  }
  
  public mhd a()
  {
    try
    {
      super.clone();
      mhd localmhd = new mhd();
      localmhd.agS = this.agS;
      localmhd.agT = this.agT;
      localmhd.BT = this.BT;
      localmhd.aOw = this.aOw;
      return localmhd;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FamilyCommentInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
        }
      }
    }
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.agT)) && (!TextUtils.isEmpty(this.agS));
  }
  
  public String toString()
  {
    return "FamilyCommentInfo\n familyIconUrl " + this.agS + "\n familyJumpUrl " + this.agT + "\n width " + this.aOw + "\n height " + this.BT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhd
 * JD-Core Version:    0.7.0.1
 */