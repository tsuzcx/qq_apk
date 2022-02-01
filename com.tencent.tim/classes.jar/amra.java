import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;

public class amra
  extends amqg
{
  private String awx;
  private String brc;
  private boolean cEc;
  private int dDA;
  private int dDz;
  private String mExtraData;
  private int mType;
  
  public amra(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public int IY()
  {
    return this.dDA;
  }
  
  public int IZ()
  {
    return this.mType;
  }
  
  public void PS(String paramString)
  {
    this.brc = paramString;
    if (TextUtils.isEmpty(this.brc)) {
      return;
    }
    try
    {
      this.dDA = new JSONObject(this.brc).getInt("appid");
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(TAG, 2, "parseLayoutExtensions exception:" + paramString);
    }
  }
  
  public void PT(String paramString)
  {
    this.mExtraData = paramString;
  }
  
  public void Pu(boolean paramBoolean)
  {
    this.cEc = paramBoolean;
  }
  
  public void UB(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public boolean awh()
  {
    return this.cEc;
  }
  
  public String getConfig()
  {
    return this.awx;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void setConfig(String paramString)
  {
    this.awx = paramString;
  }
  
  public void setTemplateID(int paramInt)
  {
    this.dDz = paramInt;
  }
  
  public int vY()
  {
    return this.dDz;
  }
  
  public String zk()
  {
    return this.brc;
  }
  
  public String zl()
  {
    return this.mExtraData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amra
 * JD-Core Version:    0.7.0.1
 */