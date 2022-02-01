import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeup
{
  private int cPl;
  private int cPm;
  private int mFlag;
  private int mShowCount;
  
  public static aeup a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      paramArrayOfaeic = null;
    }
    aeup localaeup;
    for (;;)
    {
      return paramArrayOfaeic;
      localaeup = new aeup();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaeic[0].content);
        if (localJSONObject.has("flag"))
        {
          localaeup.mFlag = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localaeup.mFlag);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localaeup.mShowCount = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localaeup.mShowCount);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localaeup.cPm = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localaeup.cPm);
          }
        }
        paramArrayOfaeic = localaeup;
        if (localJSONObject.has("groupShowCount"))
        {
          localaeup.cPl = localJSONObject.getInt("groupShowCount");
          paramArrayOfaeic = localaeup;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localaeup.cPl);
            return localaeup;
          }
        }
      }
      catch (Exception paramArrayOfaeic)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfaeic.toString());
      }
    }
    return localaeup;
  }
  
  public int CA()
  {
    return this.cPl;
  }
  
  public int CB()
  {
    return this.cPm;
  }
  
  public int Cr()
  {
    return this.mShowCount;
  }
  
  public int getFlag()
  {
    return this.mFlag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeup
 * JD-Core Version:    0.7.0.1
 */