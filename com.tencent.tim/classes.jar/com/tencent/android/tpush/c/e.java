package com.tencent.android.tpush.c;

import org.json.JSONObject;

public class e
{
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (a(paramString2)) {
      paramJSONObject.put(paramString1, paramString2);
    }
  }
  
  public static boolean a(a parama)
  {
    return (parama != null) && (b(parama.b()));
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() != 0);
  }
  
  public static boolean b(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() >= 40);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.c.e
 * JD-Core Version:    0.7.0.1
 */