import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.MD5;
import org.json.JSONObject;

public class ailg
  implements amxk.a
{
  public ailg(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void LJ(String paramString)
  {
    if (paramString == null)
    {
      this.this$0.callJs(this.val$callback, new String[] { "{\"code\":-4}" });
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = aqhq.readFile(paramString);
        if (arrayOfByte == null) {
          break;
        }
        localJSONObject.put("code", 0);
        StringBuilder localStringBuilder = new StringBuilder("data:");
        if (akyr.lP(paramString))
        {
          str = "image/gif;";
          localStringBuilder.append(str);
          localStringBuilder.append("base64,");
          localStringBuilder.append(aqgo.encodeToString(arrayOfByte, 0));
          localJSONObject.put("imgData", localStringBuilder);
          localJSONObject.put("md5", MD5.toMD5(arrayOfByte));
          localJSONObject.put("imagePath", paramString);
          this.this$0.callJs(this.val$callback, new String[] { localJSONObject.toString() });
          return;
        }
      }
      catch (Exception paramString)
      {
        this.this$0.callJs(this.val$callback, new String[] { "{\"code\":-3}" });
        return;
      }
      String str = "image/jpg;";
    }
    this.this$0.callJs(this.val$callback, new String[] { "{\"code\":-3}" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailg
 * JD-Core Version:    0.7.0.1
 */