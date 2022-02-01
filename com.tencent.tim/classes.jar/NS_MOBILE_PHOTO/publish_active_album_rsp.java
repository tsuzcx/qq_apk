package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_arkshare;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class publish_active_album_rsp
  extends JceStruct
{
  static s_arkshare cache_ark_sharedata = new s_arkshare();
  public s_arkshare ark_sharedata;
  public String fake_feeds_client_key = "";
  public String mgz_id = "";
  public String msg = "";
  public int ret;
  public String share_url = "";
  public String xcx_name = "";
  public String xcx_share_path = "";
  
  public publish_active_album_rsp() {}
  
  public publish_active_album_rsp(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, s_arkshare params_arkshare, String paramString5, String paramString6)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.fake_feeds_client_key = paramString2;
    this.share_url = paramString3;
    this.mgz_id = paramString4;
    this.ark_sharedata = params_arkshare;
    this.xcx_share_path = paramString5;
    this.xcx_name = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.fake_feeds_client_key = paramJceInputStream.readString(2, false);
    this.share_url = paramJceInputStream.readString(3, false);
    this.mgz_id = paramJceInputStream.readString(4, false);
    this.ark_sharedata = ((s_arkshare)paramJceInputStream.read(cache_ark_sharedata, 5, false));
    this.xcx_share_path = paramJceInputStream.readString(6, false);
    this.xcx_name = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.msg, 1);
    if (this.fake_feeds_client_key != null) {
      paramJceOutputStream.write(this.fake_feeds_client_key, 2);
    }
    if (this.share_url != null) {
      paramJceOutputStream.write(this.share_url, 3);
    }
    if (this.mgz_id != null) {
      paramJceOutputStream.write(this.mgz_id, 4);
    }
    if (this.ark_sharedata != null) {
      paramJceOutputStream.write(this.ark_sharedata, 5);
    }
    if (this.xcx_share_path != null) {
      paramJceOutputStream.write(this.xcx_share_path, 6);
    }
    if (this.xcx_name != null) {
      paramJceOutputStream.write(this.xcx_name, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.publish_active_album_rsp
 * JD-Core Version:    0.7.0.1
 */