import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.SubVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;

public class mhq
{
  public int aHc;
  public String ahk;
  public String ahl;
  public boolean amw;
  public String appIconUrl;
  public String appName;
  public String bgUrl;
  public String color;
  public String columnName;
  public UrlJumpInfo d;
  public UrlJumpInfo e;
  public List<mie> iO = new ArrayList(6);
  public int subscribeCount;
  public int updateCount;
  
  public static mhq a(articlesummary.VideoColumnInfo paramVideoColumnInfo)
  {
    boolean bool = true;
    mhq localmhq = new mhq();
    localmhq.aHc = paramVideoColumnInfo.uint32_column_id.get();
    localmhq.columnName = paramVideoColumnInfo.bytes_column_name.get().toStringUtf8();
    localmhq.ahl = paramVideoColumnInfo.bytes_sub_title.get().toStringUtf8();
    localmhq.ahk = paramVideoColumnInfo.bytes_column_card_icon_url.get().toStringUtf8();
    localmhq.updateCount = paramVideoColumnInfo.uint32_update_count.get();
    localmhq.subscribeCount = paramVideoColumnInfo.uint32_subscribe_count.get();
    if (paramVideoColumnInfo.uint32_is_subscribed.get() == 1) {}
    for (;;)
    {
      localmhq.amw = bool;
      localmhq.bgUrl = paramVideoColumnInfo.bytes_column_card_bg_url.get().toStringUtf8();
      localmhq.color = paramVideoColumnInfo.bytes_column_card_bg_color.get().toStringUtf8();
      localmhq.appName = paramVideoColumnInfo.bytes_app_name.get().toStringUtf8();
      localmhq.appIconUrl = paramVideoColumnInfo.bytes_app_icon_url.get().toStringUtf8();
      Iterator localIterator = paramVideoColumnInfo.rpt_sub_video_info.get().iterator();
      while (localIterator.hasNext())
      {
        articlesummary.SubVideoInfo localSubVideoInfo = (articlesummary.SubVideoInfo)localIterator.next();
        mie localmie = new mie();
        localmie.id = localSubVideoInfo.uint64_article_id.get();
        localmie.rowKey = localSubVideoInfo.bytes_inner_uniq_id.get().toStringUtf8();
        localmie.title = localSubVideoInfo.bytes_article_title.get().toStringUtf8();
        localmie.picUrl = localSubVideoInfo.bytes_first_page_pic_url.get().toStringUtf8();
        localmie.playCount = localSubVideoInfo.uint32_video_play_count.get();
        localmie.a = UrlJumpInfo.a((articlesummary.UrlJumpInfo)localSubVideoInfo.bytes_jum_url.get());
        localmie.duration = localSubVideoInfo.uint32_duration.get();
        localmhq.iO.add(localmie);
      }
      bool = false;
    }
    localmhq.d = UrlJumpInfo.a(paramVideoColumnInfo.default_jump_info);
    localmhq.e = UrlJumpInfo.a(paramVideoColumnInfo.app_jump_info);
    return localmhq;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n").append("columnId=").append(this.aHc).append("\n").append("columnName=").append(this.columnName).append("\n").append("cardIconUrl=").append(this.ahk).append("\n").append("subTitle=").append(this.ahl).append("\n").append("subscribeCount=").append(this.subscribeCount).append("\n").append("isSubscribed=").append(this.amw).append("\n").append("cardBgUrl=").append(this.bgUrl).append("\n").append("color=").append(this.color).append("\n").append("appName=").append(this.appName).append("\n").append("appIconUrl").append(this.appIconUrl).append("\n").append("subVideoInfoList={");
    Iterator localIterator = this.iO.iterator();
    while (localIterator.hasNext())
    {
      mie localmie = (mie)localIterator.next();
      localStringBuilder.append("\n[").append(localmie.toString()).append("]");
    }
    localStringBuilder.append("}").append("\n").append("defaultJumpUrl=").append(this.d.toString()).append("\n").append("appJumpUrl=").append(this.e.toString()).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhq
 * JD-Core Version:    0.7.0.1
 */