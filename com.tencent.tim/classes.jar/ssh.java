import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class ssh
  implements jox
{
  ssh(ssf paramssf, QQAppInterface paramQQAppInterface) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0)
    {
      String str;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("data").optJSONObject(0);
        str = paramString.optString("url");
        paramInt = paramString.optInt("filesize");
        if ((str != null) && (str.endsWith("patch")))
        {
          aqhq.cn(jpe.dO(this.this$0.mBid) + this.this$0.mBid);
          this.this$0.bAC();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.this$0.bAB();
        return;
      }
      if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
      {
        this.this$0.a(paramString, this.val$app);
        return;
      }
      this.this$0.bAB();
      return;
    }
    this.this$0.bAB();
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssh
 * JD-Core Version:    0.7.0.1
 */