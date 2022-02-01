import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.EntranceDownloadInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UrlJumpInfo;

public class nst
  implements nss
{
  public static String anB = "bytes_entrance_cookie_column";
  public static String anC = "https://qqpublic.qpic.cn/qq_public/0/0-2283487770-A0052D97C9C360192F1BE92BCD8ADD16/0";
  public static String anD = "https://qqpublic.qpic.cn/qq_public/0/0-2261262125-4438F0FD2808B0A8EA5C1AA0FD97295A/0";
  public static int bci = 1;
  public static int bcj = 2;
  public UrlJumpInfo a;
  public String anA;
  public int columnID;
  public String coverURL;
  public String rowkey;
  public String subTitle;
  public String title;
  
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  public UrlJumpInfo a(oidb_0x6cf.UrlJumpInfo paramUrlJumpInfo)
  {
    if ((paramUrlJumpInfo != null) && (paramUrlJumpInfo.has()) && (paramUrlJumpInfo.get() != null))
    {
      UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
      if (paramUrlJumpInfo.uint32_jump_type.has()) {}
      for (int i = paramUrlJumpInfo.uint32_jump_type.get();; i = 0)
      {
        localUrlJumpInfo.jumpType = i;
        localUrlJumpInfo.jumpSchema = a(paramUrlJumpInfo.bytes_jump_schema);
        localUrlJumpInfo.aiM = a(paramUrlJumpInfo.bytes_jump_bundle);
        localUrlJumpInfo.jumpUrl = a(paramUrlJumpInfo.bytes_jump_url);
        localUrlJumpInfo.aiN = a(paramUrlJumpInfo.bytes_clipboard_info);
        localUrlJumpInfo.WT = a(paramUrlJumpInfo.bytes_common_data);
        return localUrlJumpInfo;
      }
    }
    return null;
  }
  
  public void a(oidb_0x6cf.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if (paramEntranceDownloadInfo == null) {}
    do
    {
      return;
      if (paramEntranceDownloadInfo.bytes_column_name.has()) {
        this.title = paramEntranceDownloadInfo.bytes_column_name.get().toStringUtf8();
      }
      if (paramEntranceDownloadInfo.bytes_sub_text.has()) {
        this.subTitle = paramEntranceDownloadInfo.bytes_sub_text.get().toStringUtf8();
      }
      if (paramEntranceDownloadInfo.bytes_icon_url.has()) {
        this.coverURL = paramEntranceDownloadInfo.bytes_icon_url.get().toStringUtf8();
      }
      if (paramEntranceDownloadInfo.msg_url_jump_info.has()) {
        this.a = a(paramEntranceDownloadInfo.msg_url_jump_info);
      }
      if (paramEntranceDownloadInfo.uint32_column_id.has()) {
        this.columnID = paramEntranceDownloadInfo.uint32_column_id.get();
      }
      if (paramEntranceDownloadInfo.bytes_entrance_cookie.has()) {
        awit.H(anB, paramEntranceDownloadInfo.bytes_entrance_cookie.get().toStringUtf8());
      }
    } while (!paramEntranceDownloadInfo.bytes_rowkey.has());
    this.rowkey = paramEntranceDownloadInfo.bytes_rowkey.get().toStringUtf8();
  }
  
  public String getCoverUrl()
  {
    return this.coverURL;
  }
  
  public String hZ()
  {
    return "";
  }
  
  public String ia()
  {
    return null;
  }
  
  public void setCoverUrl(String paramString) {}
  
  public boolean yS()
  {
    return false;
  }
  
  public boolean yT()
  {
    return true;
  }
  
  public boolean yU()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nst
 * JD-Core Version:    0.7.0.1
 */