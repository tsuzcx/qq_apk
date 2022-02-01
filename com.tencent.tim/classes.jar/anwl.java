import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anwl
  extends aehv<anwk>
{
  public static anwk a()
  {
    return (anwk)aeif.a().o(612);
  }
  
  public static void dTH()
  {
    aeif.a().n(new int[] { 612 });
  }
  
  @NonNull
  public anwk a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new anwk();
  }
  
  @Nullable
  public anwk a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onParsed]");
    }
    anwk localanwk = new anwk();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      paramArrayOfaeic = paramArrayOfaeic[0];
      if ((paramArrayOfaeic == null) || (TextUtils.isEmpty(paramArrayOfaeic.content))) {}
    }
    try
    {
      localanwk.data = new JSONObject(paramArrayOfaeic.content);
      return localanwk;
    }
    catch (JSONException paramArrayOfaeic)
    {
      QLog.e("StudyRoomConfProcessor", 4, paramArrayOfaeic, new Object[0]);
    }
    return localanwk;
  }
  
  public void a(anwk paramanwk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onUpdate] newConf:" + paramanwk);
    }
  }
  
  public Class<anwk> clazz()
  {
    return anwk.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + a());
    }
  }
  
  public int type()
  {
    return 612;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwl
 * JD-Core Version:    0.7.0.1
 */