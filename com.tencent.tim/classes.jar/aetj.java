import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aetj
{
  private String bBe = "";
  private boolean bWi;
  
  public static aetj a(aeic[] paramArrayOfaeic)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0))
    {
      paramArrayOfaeic = null;
      return paramArrayOfaeic;
    }
    aetj localaetj = new aetj();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaeic[0].content);
        paramArrayOfaeic = localaetj;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localaetj.bWi = bool;
          }
        }
        else
        {
          paramArrayOfaeic = localaetj;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localaetj.bBe = localJSONObject.getString("webDocSelectorUrl");
          return localaetj;
        }
      }
      catch (JSONException paramArrayOfaeic)
      {
        paramArrayOfaeic.printStackTrace();
        return localaetj;
      }
      bool = false;
    }
  }
  
  public String tN()
  {
    if (TextUtils.isEmpty(this.bBe)) {
      return null;
    }
    return this.bBe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetj
 * JD-Core Version:    0.7.0.1
 */