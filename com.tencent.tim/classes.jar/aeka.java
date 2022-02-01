import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeka
{
  public static final String TAG = ahtj.bLH + "GameCenterMsgBean";
  public String byL = ahtc.bLG;
  public String byM = "";
  public int cNE;
  public String mPrefix = ahtc.PREFIX;
  public int mViewType;
  
  public static aeka a(aeic[] paramArrayOfaeic)
  {
    aeka localaeka = new aeka();
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfaeic.length)
      {
        Object localObject = paramArrayOfaeic[i].content;
        try
        {
          localObject = new JSONObject((String)localObject);
          localaeka.cNE = ((JSONObject)localObject).optInt("gameMsgFuncSwitch");
          localaeka.byL = ((JSONObject)localObject).optString("gameMsgListUrl");
          localaeka.mPrefix = ((JSONObject)localObject).optString("gamePrefix");
          localaeka.mViewType = ((JSONObject)localObject).optInt("viewType", 0);
          localaeka.byM = ((JSONObject)localObject).optString("playerInfoUrl");
          QLog.i(TAG, 1, "[parse], mGraySwitch:" + localaeka.cNE + ",url:" + localaeka.byL + ",playerInfo:" + localaeka.byM);
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e(TAG, 1, localThrowable, new Object[0]);
          }
        }
      }
    }
    return localaeka;
  }
  
  public void a(aeka paramaeka)
  {
    if (paramaeka == null) {}
    do
    {
      return;
      this.cNE = paramaeka.cNE;
      this.mViewType = paramaeka.mViewType;
      if (!TextUtils.isEmpty(paramaeka.byL)) {
        this.byL = paramaeka.byL;
      }
      if (!TextUtils.isEmpty(paramaeka.mPrefix)) {
        this.mPrefix = paramaeka.mPrefix;
      }
    } while (TextUtils.isEmpty(paramaeka.byM));
    this.byM = paramaeka.byM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeka
 * JD-Core Version:    0.7.0.1
 */