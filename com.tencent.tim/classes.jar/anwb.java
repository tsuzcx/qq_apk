import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class anwb
  extends aehv<anwb.a>
{
  public static anwb.a a()
  {
    return (anwb.a)aeif.a().o(615);
  }
  
  @NonNull
  public anwb.a a(int paramInt)
  {
    return new anwb.a();
  }
  
  @Nullable
  public anwb.a a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModePushConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return anwb.a.b(paramArrayOfaeic);
    }
    return null;
  }
  
  public void a(anwb.a parama) {}
  
  public Class<anwb.a> clazz()
  {
    return anwb.a.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 615;
  }
  
  public static final class a
  {
    public ArrayList<Integer> AX = new ArrayList();
    public String ciz = "";
    
    public static a b(aeic[] paramArrayOfaeic)
    {
      a locala = new a();
      if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i >= paramArrayOfaeic.length) {
            break label187;
          }
          String str = paramArrayOfaeic[i].content;
          try
          {
            str = new JSONObject(str).optString("black_ids");
            ArrayList localArrayList = new ArrayList();
            if (!TextUtils.isEmpty(str))
            {
              String[] arrayOfString = str.split(",");
              int k = arrayOfString.length;
              int j = 0;
              while (j < k)
              {
                localArrayList.add(Integer.valueOf(Integer.parseInt(arrayOfString[j].trim())));
                j += 1;
              }
              locala.ciz = str;
              locala.AX.addAll(localArrayList);
            }
            if (QLog.isColorLevel()) {
              QLog.i("StudyModePushConfigProcessor", 2, "[study mode push config], :" + str);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.e("StudyModePushConfigProcessor", 1, localThrowable, new Object[0]);
            }
          }
          i += 1;
        }
      }
      label187:
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwb
 * JD-Core Version:    0.7.0.1
 */