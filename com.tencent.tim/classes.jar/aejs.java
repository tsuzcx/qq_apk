import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aejs
  extends aehv<aejs.a>
{
  public static aejs.a a()
  {
    return (aejs.a)aeif.a().o(622);
  }
  
  @NonNull
  public aejs.a a(int paramInt)
  {
    return new aejs.a();
  }
  
  @Nullable
  public aejs.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aejs.a.b(paramArrayOfaeic);
    }
    return null;
  }
  
  public void a(aejs.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonTabSortConfProcessor", 2, "EmoticonTabSortConfProcessor onUpdate");
    }
  }
  
  public Class<aejs.a> clazz()
  {
    return aejs.a.class;
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
    return 622;
  }
  
  public static class a
  {
    private int cNw;
    public List<String> tF = new ArrayList();
    public List<String> yW = new ArrayList();
    
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
        QLog.d("EmoticonTabSortConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaeic);
      }
      Object localObject1 = ((aeic)localObject1).content;
      bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool) {}
      for (;;)
      {
        int j;
        try
        {
          Object localObject2 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject2).has("setting_change_style")) {
            locala.cNw = ((JSONObject)localObject2).optInt("setting_change_style", 0);
          }
          ArrayList localArrayList;
          Object localObject3;
          if (((JSONObject)localObject2).has("setting_orders"))
          {
            localArrayList = new ArrayList();
            localObject3 = ((JSONObject)localObject2).optJSONArray("setting_orders");
            if (localObject3 != null)
            {
              j = 0;
              if (j < ((JSONArray)localObject3).length())
              {
                String str = ((JSONArray)localObject3).getString(j);
                if (localArrayList.contains(str)) {
                  break label342;
                }
                localArrayList.add(str);
                break label342;
              }
            }
            locala.yW.clear();
            locala.yW.addAll(localArrayList);
          }
          if (((JSONObject)localObject2).has("face_orders"))
          {
            localArrayList = new ArrayList();
            localObject2 = ((JSONObject)localObject2).optJSONArray("face_orders");
            if (localObject2 != null)
            {
              j = 0;
              if (j < ((JSONArray)localObject2).length())
              {
                localObject3 = ((JSONArray)localObject2).getString(j);
                if (localArrayList.contains(localObject3)) {
                  break label349;
                }
                localArrayList.add(localObject3);
                break label349;
              }
            }
            locala.tF.clear();
            locala.tF.addAll(localArrayList);
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          continue;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("EmoticonTabSortConfProcessor", 2, "parse S$EConfBean: " + (String)localObject1);
          break label335;
          return locala;
        }
        for (;;)
        {
          if (i >= k) {
            break label340;
          }
          localObject1 = paramArrayOfaeic[i];
          if (localObject1 != null) {
            break;
          }
          label335:
          i += 1;
        }
        label340:
        continue;
        label342:
        j += 1;
        continue;
        label349:
        j += 1;
      }
    }
    
    public boolean agJ()
    {
      return this.cNw == 1;
    }
    
    public String toString()
    {
      return "EmoticonTabSortConfBean{mChangeNewSettingStyle=" + this.cNw + ", mSettingOrder=" + this.yW + ", mEntryOrder=" + this.tF + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejs
 * JD-Core Version:    0.7.0.1
 */