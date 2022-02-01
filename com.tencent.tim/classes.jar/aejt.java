import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aejt
  extends aehv<aejt.a>
{
  public static int cNx = 16777216;
  public static int cNy = 10240;
  
  @NonNull
  public aejt.a a(int paramInt)
  {
    aejt.a locala = new aejt.a();
    locala.cNz = cNx;
    locala.cNA = cNy;
    return locala;
  }
  
  @Nullable
  public aejt.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length == 0)) {
      return new aejt.a();
    }
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfaeic);
    }
    aejt.a locala = new aejt.a();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfaeic);
      locala.cNz = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      locala.cNA = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return locala;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfaeic);
      locala.cNz = cNx;
      locala.cNA = cNy;
    }
    return locala;
  }
  
  public void a(aejt.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onUpdate");
    }
  }
  
  public Class clazz()
  {
    return aejt.a.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 561;
  }
  
  public static class a
  {
    public int cNA;
    public int cNz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejt
 * JD-Core Version:    0.7.0.1
 */