import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.a;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.b;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.c;
import org.json.JSONObject;

class awkb
  implements TroopHWJsPlugin.c
{
  awkb(awka paramawka) {}
  
  public void y(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      JSONObject localJSONObject = this.a.a.this$0.a(this.a.a.b.cQV, this.a.a.id, this.a.a.type, "uploaded", this.a.a.videoUrl, 0);
      try
      {
        localJSONObject.put("result", 0);
        localJSONObject.put("progress", 1.0D);
        localJSONObject.put("coverurl", paramString);
        QLog.e("TroopHWJsPlugin", 2, "upload thumb success:" + localJSONObject.toString());
        this.a.a.this$0.callJs(this.a.a.b.mCallback, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("TroopHWJsPlugin", 2, "upload thumb exception:", paramString);
        return;
      }
    }
    QLog.e("TroopHWJsPlugin", 1, "upload thumb failed!");
    this.a.onError(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awkb
 * JD-Core Version:    0.7.0.1
 */