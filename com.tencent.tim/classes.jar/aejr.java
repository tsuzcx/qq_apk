import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aejr
  extends aehv<aejr.a>
{
  public static aejr.a a()
  {
    return (aejr.a)aeif.a().o(620);
  }
  
  @NonNull
  public aejr.a a(int paramInt)
  {
    return new aejr.a();
  }
  
  @Nullable
  public aejr.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aejr.a.b(paramArrayOfaeic);
    }
    return null;
  }
  
  public void a(aejr.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonSearchTagsConfProcessor", 2, "EmoticonSearchTagsConfProcessor onUpdate");
    }
  }
  
  public Class<aejr.a> clazz()
  {
    return aejr.a.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 620;
  }
  
  public static class a
  {
    public List<String> yV = new ArrayList();
    
    public static a b(aeic[] paramArrayOfaeic)
    {
      a locala = new a();
      int k;
      int i;
      try
      {
        k = paramArrayOfaeic.length;
        i = 0;
      }
      catch (Throwable paramArrayOfaeic)
      {
        boolean bool;
        QLog.d("EmoticonSearchTagsConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaeic);
      }
      Object localObject1 = ((aeic)localObject1).content;
      bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool)
      {
        try
        {
          Object localObject2 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject2).has("keyWords"))
          {
            localObject2 = ((JSONObject)localObject2).optJSONArray("keyWords");
            int j = 0;
            while (j < ((JSONArray)localObject2).length())
            {
              locala.yV.add(((JSONArray)localObject2).optString(j, ""));
              j += 1;
            }
          }
          if (!QLog.isColorLevel()) {
            break label173;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        QLog.i("EmoticonSearchTagsConfProcessor", 2, "parse S$EConfBean: " + (String)localObject1);
      }
      label173:
      label178:
      for (;;)
      {
        return locala;
        for (;;)
        {
          if (i >= k) {
            break label178;
          }
          localObject1 = paramArrayOfaeic[i];
          if (localObject1 != null) {
            break;
          }
          i += 1;
        }
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("mConfig:");
      if (this.yV == null) {}
      for (String str = "null";; str = this.yV.toString())
      {
        localStringBuilder.append(str);
        return super.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejr
 * JD-Core Version:    0.7.0.1
 */