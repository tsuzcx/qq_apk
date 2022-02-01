import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aozy
{
  public int bizType;
  public long shmsgseq;
  public long uniseq;
  
  public aozy()
  {
    clear();
  }
  
  public aozy(aozy paramaozy)
  {
    a(paramaozy);
  }
  
  public static boolean a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    return (paramLong2 != -1L) && ((paramLong1 == -1L) || ((paramInt1 == paramInt2) && (paramLong1 > paramLong2)) || ((paramInt1 != paramInt2) && (aozx.bq(paramInt1, paramInt2))));
  }
  
  public String AT()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("biz_type", this.bizType);
      localJSONObject.put("shmsgseq", this.shmsgseq);
      localJSONObject.put("uniseq", this.uniseq);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void SG(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.bizType = paramString.optInt("biz_type");
      this.shmsgseq = paramString.getLong("shmsgseq");
      this.uniseq = paramString.getLong("uniseq");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(aozy paramaozy)
  {
    if (paramaozy != null)
    {
      this.bizType = paramaozy.bizType;
      this.shmsgseq = paramaozy.shmsgseq;
      this.uniseq = paramaozy.uniseq;
    }
  }
  
  public boolean a(aozy paramaozy)
  {
    if (paramaozy == null) {
      return false;
    }
    return b(paramaozy.bizType, paramaozy.shmsgseq, paramaozy.uniseq);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    int j = 27;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramBoolean)
      {
        paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
        i = j;
        if (paramQQAppInterface != null)
        {
          i = j;
          if (paramQQAppInterface.hasOrgs()) {
            i = 14;
          }
        }
      }
    }
    return b(i, paramLong1, paramLong2);
  }
  
  public void ar(int paramInt, long paramLong)
  {
    if ((this.bizType == paramInt) && (this.shmsgseq != -1L))
    {
      this.uniseq = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.MessageNavInfo", 2, "updateMsgSeq, preBizType = " + this.bizType + ", newBizType = " + paramInt + ", msgSeq = " + paramLong);
      }
    }
  }
  
  public void as(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.MessageNavInfo", 2, "updateShMsgSeq, preBizType = " + this.bizType + ", newBizType = " + paramInt + ", newShMsgSeq = " + paramLong);
    }
    if ((this.bizType != 0) && (this.bizType != paramInt)) {
      return;
    }
    this.bizType = paramInt;
    this.shmsgseq = paramLong;
  }
  
  public boolean b(int paramInt, long paramLong1, long paramLong2)
  {
    boolean bool = r(paramInt, paramLong1);
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.MessageNavInfo", 2, "update, preBizType = " + this.bizType + ", newBizType = " + paramInt + ", needUpdate = " + bool + ", shmsgseq = " + paramLong1 + ", uniseq = " + paramLong2);
    }
    if (bool)
    {
      this.bizType = paramInt;
      this.shmsgseq = paramLong1;
      this.uniseq = paramLong2;
      return true;
    }
    return false;
  }
  
  public void clear()
  {
    this.bizType = 0;
    this.shmsgseq = -1L;
    this.uniseq = -1L;
  }
  
  public boolean has()
  {
    return this.shmsgseq != -1L;
  }
  
  public boolean lU(int paramInt)
  {
    return this.bizType == paramInt;
  }
  
  public boolean r(int paramInt, long paramLong)
  {
    return a(this.bizType, this.shmsgseq, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozy
 * JD-Core Version:    0.7.0.1
 */