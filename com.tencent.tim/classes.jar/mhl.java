import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.KdLiveInfo;

public class mhl
{
  public String agV;
  public String agW;
  public String agX;
  public String agY;
  public String agZ;
  public String aha;
  public String statusText;
  public int style;
  
  public static mhl a(articlesummary.KdLiveInfo paramKdLiveInfo)
  {
    mhl localmhl = new mhl();
    localmhl.style = paramKdLiveInfo.uint32_style_type.get();
    localmhl.agV = paramKdLiveInfo.bytes_status_bg_url.get().toStringUtf8();
    localmhl.agW = paramKdLiveInfo.bytes_status_icon_url.get().toStringUtf8();
    localmhl.statusText = paramKdLiveInfo.bytes_status_text.get().toStringUtf8();
    localmhl.agX = paramKdLiveInfo.bytes_hot_icon_url.get().toStringUtf8();
    localmhl.agY = paramKdLiveInfo.bytes_hot_text.get().toStringUtf8();
    localmhl.agZ = paramKdLiveInfo.bytes_title_jump_url.get().toStringUtf8();
    localmhl.aha = paramKdLiveInfo.bytes_report_common_data.get().toStringUtf8();
    return localmhl;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n").append("style=").append(this.style).append("\n").append("statusBgUrl=").append(this.agV).append("\n").append("statusIconUrl=").append(this.agW).append("\n").append("statusText=").append(this.statusText).append("\n").append("hotIconUrl=").append(this.agX).append("\n").append("hotText=").append(this.agY).append("\n").append("titleJumpUrl=").append(this.agZ).append("\n").append("reportCommonData=").append(this.aha).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhl
 * JD-Core Version:    0.7.0.1
 */