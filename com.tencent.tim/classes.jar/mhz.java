import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class mhz
  implements Cloneable
{
  public static int aSE;
  public static int aSF;
  public int JP = 1;
  public String ahF = "";
  public String ahG = "";
  public String ahH = "";
  public String ahI = "";
  public String ahJ = "";
  public String ahK = "";
  public String backgroundUrl = "";
  public long fromUin;
  public String py = "";
  public int showType;
  public String subTitle = "";
  public String tag = "";
  
  public static mhz a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    mhz localmhz = new mhz();
    localmhz.py = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localmhz.subTitle = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localmhz.backgroundUrl = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localmhz.ahF = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localmhz.ahG = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localmhz.ahH = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localmhz.ahI = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localmhz.ahJ = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localmhz.ahK = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localmhz.fromUin = paramScripCmsInfo.uint64_from_uin.get();
    localmhz.tag = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    aSE = paramScripCmsInfo.uint32_scrip_total_sum.get();
    aSF = paramScripCmsInfo.uint32_frequency_limit.get();
    return localmhz;
  }
  
  public mhz a()
  {
    try
    {
      super.clone();
      mhz localmhz = new mhz();
      localmhz.py = this.py;
      localmhz.subTitle = this.subTitle;
      localmhz.backgroundUrl = this.backgroundUrl;
      localmhz.ahF = this.ahF;
      localmhz.ahG = this.ahG;
      localmhz.ahH = this.ahH;
      localmhz.ahK = this.ahK;
      localmhz.ahI = this.ahI;
      localmhz.ahJ = this.ahJ;
      localmhz.JP = this.JP;
      localmhz.fromUin = this.fromUin;
      localmhz.tag = this.tag;
      return localmhz;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScripCmsInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhz
 * JD-Core Version:    0.7.0.1
 */