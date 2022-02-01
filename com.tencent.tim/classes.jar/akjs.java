import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class akjs
{
  public String bTB;
  public String bTC = "";
  public String bTD = "";
  public String bTE;
  public int content_type = 1;
  public boolean css;
  public boolean cst;
  public int redDotNum;
  public long uin;
  public int user_type;
  
  public void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo == null) {}
    while (!paramRedTypeInfo.red_desc.has()) {
      return;
    }
    Object localObject = paramRedTypeInfo.red_desc.get();
    try
    {
      localObject = new JSONObject((String)localObject);
      this.cst = ((JSONObject)localObject).optBoolean("isOfficialNotify");
      this.content_type = ((JSONObject)localObject).optInt("redContentType");
      this.bTB = ((JSONObject)localObject).optString("redContentMsg");
      this.bTC = ((JSONObject)localObject).optString("topicId");
      this.user_type = ((JSONObject)localObject).optInt("userType");
      this.bTD = ((JSONObject)localObject).optString("msgId");
      this.redDotNum = Integer.valueOf(paramRedTypeInfo.red_content.get()).intValue();
      this.bTE = ((JSONObject)localObject).optString("faceUrl");
      this.uin = ((JSONObject)localObject).optLong("uin");
      return;
    }
    catch (Exception paramRedTypeInfo)
    {
      paramRedTypeInfo.printStackTrace();
    }
  }
  
  public void h(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    boolean bool2 = true;
    if (paramRedDotInfo == null) {}
    while ((!paramRedDotInfo.str_custom_buffer.has()) || (paramRedDotInfo.str_custom_buffer.get().isEmpty())) {
      return;
    }
    paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
    for (;;)
    {
      try
      {
        paramRedDotInfo = new JSONObject(paramRedDotInfo);
        if (paramRedDotInfo.optInt("official_topic") == 1)
        {
          bool1 = true;
          this.cst = bool1;
          this.content_type = paramRedDotInfo.optInt("red_content_type");
          this.bTB = paramRedDotInfo.optString("red_content_msg");
          this.bTC = paramRedDotInfo.optString("red_topic_tag");
          this.user_type = paramRedDotInfo.optInt("red_user_type");
          if (paramRedDotInfo.optInt("red_type") != 0) {
            break label145;
          }
          bool1 = bool2;
          this.css = bool1;
          this.bTD = paramRedDotInfo.optString("red_msg_id");
          return;
        }
      }
      catch (Exception paramRedDotInfo)
      {
        paramRedDotInfo.printStackTrace();
        return;
      }
      boolean bool1 = false;
      continue;
      label145:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akjs
 * JD-Core Version:    0.7.0.1
 */