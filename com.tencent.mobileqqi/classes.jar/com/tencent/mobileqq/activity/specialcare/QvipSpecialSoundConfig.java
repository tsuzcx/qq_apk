package com.tencent.mobileqq.activity.specialcare;

import esv;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QvipSpecialSoundConfig
{
  public String a;
  public List a;
  
  public QvipSpecialSoundConfig()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static QvipSpecialSoundConfig a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new QvipSpecialSoundConfig();
    }
    for (;;)
    {
      return paramJSONObject;
      localQvipSpecialSoundConfig = new QvipSpecialSoundConfig();
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("sound_config");
        localQvipSpecialSoundConfig.jdField_a_of_type_JavaLangString = paramJSONObject.getString("version");
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localQvipSpecialSoundConfig;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localQvipSpecialSoundConfig;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localQvipSpecialSoundConfig;
          if (i >= j) {
            break;
          }
          paramJSONObject = esv.a(localJSONArray.getJSONObject(i));
          localQvipSpecialSoundConfig.jdField_a_of_type_JavaUtilList.add(paramJSONObject);
          i += 1;
        }
        return localQvipSpecialSoundConfig;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundConfig
 * JD-Core Version:    0.7.0.1
 */