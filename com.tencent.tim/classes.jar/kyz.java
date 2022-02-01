import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class kyz
  implements AladdinConfigHandler
{
  lik a(String paramString, List<lik> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      lik locallik = (lik)paramList.next();
      if (locallik.key.equals(paramString)) {
        return locallik;
      }
    }
    return null;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("KandianDailySettingConfigHandler", 2, "[onReceiveConfig] " + paramString);
    Map localMap = kye.i(paramString);
    Object localObject4 = localMap.keySet();
    Object localObject1 = ReadInJoyMMapKvStorage.getInstance().getValeForKey("KANDIAN_DAILY_SETTING_CONFIG");
    paramString = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if (localObject1 != null) {}
        Object localObject5;
        String[] arrayOfString;
        Object localObject3;
        Object localObject2;
        for (;;) {}
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            QLog.d("KandianDailySettingConfigHandler", 2, "old data: " + localObject1);
            paramInt1 = 0;
            if (paramInt1 < ((JSONArray)localObject1).length())
            {
              localArrayList.add(lik.a(((JSONArray)localObject1).optJSONObject(paramInt1)));
              paramInt1 += 1;
              continue;
            }
            paramString = (String)localObject1;
            localObject4 = ((Set)localObject4).iterator();
            if (!((Iterator)localObject4).hasNext()) {
              continue;
            }
            localObject5 = (String)((Iterator)localObject4).next();
            localObject1 = (String)localMap.get(localObject5);
            QLog.d("KandianDailySettingConfigHandler", 2, "[onReceiveConfig] key=" + (String)localObject5 + ", value=" + (String)localObject1);
            arrayOfString = ((String)localObject1).split("\\|");
            if (arrayOfString.length != 3) {
              continue;
            }
            paramInt1 = 1;
            localObject3 = a((String)localObject5, localArrayList);
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              paramInt1 = 0;
              localObject1 = new lik();
            }
            ((lik)localObject1).name = arrayOfString[0];
            ((lik)localObject1).key = ((String)localObject5);
            localObject3 = arrayOfString[1].split(",");
            localObject5 = arrayOfString[2].split(",");
            ((lik)localObject1).jdField_if = new ArrayList();
            ((lik)localObject1).eS = new ArrayList();
            ((lik)localObject1).jdField_if.add("");
            ((lik)localObject1).eS.add("");
            paramInt2 = 0;
            if (paramInt2 >= localObject3.length) {
              continue;
            }
            ((lik)localObject1).eS.add(localObject3[paramInt2]);
            paramInt2 += 1;
            continue;
            localJSONException1 = localJSONException1;
          }
          catch (JSONException localJSONException2)
          {
            paramString = localJSONException1;
            localObject2 = localJSONException2;
            continue;
          }
          localJSONException1.printStackTrace();
          continue;
          paramInt2 = 0;
          if (paramInt2 < localObject5.length)
          {
            localJSONException1.jdField_if.add(localObject5[paramInt2]);
            paramInt2 += 1;
          }
          else if (paramInt1 == 0)
          {
            paramString.put(localJSONException1.toJSONObject());
          }
        }
        QLog.d("KandianDailySettingConfigHandler", 2, "new data: " + paramString.toString());
        ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", paramString.toString());
        return true;
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("KandianDailySettingConfigHandler", 2, "[onWipeConfig]");
    ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kyz
 * JD-Core Version:    0.7.0.1
 */