import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

class aejc
  extends aejb
{
  private String mName;
  
  public aejc(String paramString)
  {
    this.mName = paramString;
  }
  
  public Object g(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      paramObject = (LinkedHashMap)paramObject;
      if (!(paramObject instanceof LinkedHashMap))
      {
        QLog.e("ArkMsgReplyConfigMgr", 1, "getElement instance wrong");
        return null;
      }
    } while (TextUtils.isEmpty(this.mName));
    return paramObject.get(this.mName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejc
 * JD-Core Version:    0.7.0.1
 */