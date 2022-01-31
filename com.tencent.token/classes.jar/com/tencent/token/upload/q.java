package com.tencent.token.upload;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q
{
  public static List a(Context paramContext)
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
  
  public static JSONArray b(Context paramContext)
  {
    Object localObject = a(paramContext);
    paramContext = new JSONArray();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return paramContext;
    }
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        Sensor localSensor = (Sensor)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("name", localSensor.getName());
          localJSONObject.put("version", localSensor.getVersion());
          localJSONObject.put("vender", localSensor.getVendor());
          paramContext.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    return paramContext;
  }
  
  public static int c(Context paramContext)
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
  
  public static int d(Context paramContext)
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
  
  public static int e(Context paramContext)
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
  
  public static int f(Context paramContext)
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
  
  public static int g(Context paramContext)
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
  
  public static int h(Context paramContext)
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
  
  public static int i(Context paramContext)
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
  
  public static int j(Context paramContext)
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
  
  public static int k(Context paramContext)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.q
 * JD-Core Version:    0.7.0.1
 */