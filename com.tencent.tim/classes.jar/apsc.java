import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

public class apsc
{
  public static Map<Long, apsc> nN = new HashMap();
  public long mTroopUin;
  public Map<String, TroopFileData> nO = new HashMap();
  
  public apsc(long paramLong)
  {
    this.mTroopUin = paramLong;
  }
  
  public static apsc a(long paramLong)
  {
    try
    {
      apsc localapsc2 = (apsc)nN.get(Long.valueOf(paramLong));
      apsc localapsc1 = localapsc2;
      if (localapsc2 == null)
      {
        localapsc1 = new apsc(paramLong);
        nN.put(Long.valueOf(paramLong), localapsc1);
      }
      return localapsc1;
    }
    finally {}
  }
  
  public TroopFileData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    TroopFileData localTroopFileData1 = null;
    try
    {
      if (this.nO != null) {
        localTroopFileData1 = (TroopFileData)this.nO.get(paramString);
      }
      TroopFileData localTroopFileData2 = localTroopFileData1;
      if (localTroopFileData1 == null)
      {
        paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
        localTroopFileData2 = (TroopFileData)paramQQAppInterface.find(TroopFileData.class, paramString);
        paramQQAppInterface.close();
      }
      return localTroopFileData2;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, TroopFileData paramTroopFileData)
  {
    try
    {
      if (this.nO != null) {
        this.nO.put(paramTroopFileData.fileUrl, paramTroopFileData);
      }
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      paramQQAppInterface.persist(paramTroopFileData);
      paramQQAppInterface.close();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsc
 * JD-Core Version:    0.7.0.1
 */