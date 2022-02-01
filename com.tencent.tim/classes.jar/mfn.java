import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public class mfn
  extends mfl
{
  public mfn(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public BaseResData a(String paramString)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    if ("operation_guide".equals(str1)) {}
    for (paramString = GuideData.class;; paramString = null)
    {
      if (paramString == null) {}
      do
      {
        return null;
        String str2 = this.mApp.getCurrentAccountUin();
        paramString = this.mEntityManager.query(paramString, paramString.getSimpleName(), true, "uin=? and showTime!=0 and business=?", new String[] { str2, str1 }, null, null, "showTime desc", "1");
      } while ((paramString == null) || (paramString.size() <= 0));
      return (BaseResData)paramString.get(0);
    }
  }
  
  public void a(String paramString, BaseResData paramBaseResData)
  {
    paramBaseResData.isReady = true;
    paramBaseResData.business = paramString;
    this.mEntityManager.persistOrReplace(paramBaseResData);
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    return true;
  }
  
  public void aOY()
  {
    if (this.mEntityManager != null)
    {
      this.mEntityManager.drop(GuideData.class);
      return;
    }
    QLog.e("ReadInJoyOperationManager", 1, "[clearGuideDataInDatabase] entity manager is null");
  }
  
  public void b(String paramString, BaseResData paramBaseResData)
  {
    paramBaseResData.showTime = ((int)(System.currentTimeMillis() / 1000L));
    paramBaseResData.setStatus(1000);
    this.mEntityManager.persistOrReplace(paramBaseResData);
  }
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return anyk.E(new File(U(paramString, paramBaseResData.id)));
  }
  
  public List<GuideData> d(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramString1 = this.mApp.getCurrentAccountUin();
    return this.mEntityManager.query(GuideData.class, GuideData.class.getSimpleName(), true, "uin=? and showTime=? and business=? and endTime>? and id=?", new String[] { paramString1, "0", str, String.valueOf(i), paramString2 }, null, null, "seq desc", null);
  }
  
  public int dq(int paramInt)
  {
    int i = -1;
    try
    {
      paramInt = this.mEntityManager.delete(GuideData.class.getSimpleName(), "source=?", new String[] { String.valueOf(paramInt) });
      return paramInt;
    }
    catch (Exception localException)
    {
      do
      {
        paramInt = i;
      } while (!QLog.isColorLevel());
      QLog.e("ReadInJoyOperationManager", 2, localException, new Object[0]);
    }
    return -1;
  }
  
  public void onDestroy() {}
  
  public void q(String[] paramArrayOfString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfn
 * JD-Core Version:    0.7.0.1
 */