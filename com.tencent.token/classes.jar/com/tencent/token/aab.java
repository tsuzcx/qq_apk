package com.tencent.token;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aab
{
  public static JSONArray a(Context paramContext)
  {
    paramContext = k(paramContext);
    JSONArray localJSONArray = new JSONArray();
    if (paramContext != null)
    {
      if (paramContext.size() == 0) {
        return localJSONArray;
      }
      int j = paramContext.size();
      int i = 0;
      while (i < j)
      {
        Sensor localSensor = (Sensor)paramContext.get(i);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("name", localSensor.getName());
          localJSONObject.put("version", localSensor.getVersion());
          localJSONObject.put("vender", localSensor.getVendor());
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        localJSONArray.put(localJSONObject);
        i += 1;
      }
      return localJSONArray;
    }
    return localJSONArray;
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(1);
      if (paramContext != null) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int c(Context paramContext)
  {
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(2);
      if (paramContext != null) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int d(Context paramContext)
  {
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(4);
      if (paramContext != null) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int e(Context paramContext)
  {
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(9);
      if (paramContext != null) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int f(Context paramContext)
  {
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(10);
      if (paramContext != null) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int g(Context paramContext)
  {
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(5);
      if (paramContext != null) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int h(Context paramContext)
  {
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(8);
      if (paramContext != null) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int i(Context paramContext)
  {
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(7);
      if (paramContext != null) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int j(Context paramContext)
  {
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(6);
      if (paramContext != null) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  private static List<Sensor> k(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getSensorList(-1);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aab
 * JD-Core Version:    0.7.0.1
 */