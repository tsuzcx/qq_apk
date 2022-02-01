import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeim
  extends aehv<aeim.a>
{
  public static aeim.a a()
  {
    return (aeim.a)aeif.a().o(457);
  }
  
  @NonNull
  public aeim.a a(int paramInt)
  {
    return new aeim.a();
  }
  
  @Nullable
  public aeim.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length == 0)) {
      return null;
    }
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor onParsed, content:" + paramArrayOfaeic);
    }
    return aeim.a.a(paramArrayOfaeic);
  }
  
  public void a(aeim.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor update.");
    }
    ((achg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(159)).cJI();
  }
  
  public Class<aeim.a> clazz()
  {
    return aeim.a.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 457;
  }
  
  public static class a
  {
    @aiin("search_empty_show_troop_recommend")
    public int cNd;
    @aiin("jump_url")
    public String jumpUrl = "";
    @aiin("poll_interval")
    public int pollInterval = 10;
    
    public static a a(String paramString)
    {
      return (a)aiio.convertFromJSONObject(paramString, a.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeim
 * JD-Core Version:    0.7.0.1
 */