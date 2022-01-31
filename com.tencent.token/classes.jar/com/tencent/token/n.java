package com.tencent.token;

import com.tencent.token.global.e;
import com.tencent.token.utils.encrypt.a;
import org.json.JSONException;
import org.json.JSONObject;

public class n
{
  protected static String a(byte[] paramArrayOfByte, String... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0)
    {
      e.c("params count % 2 should be 0");
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = 0;
      while (i < paramVarArgs.length)
      {
        localJSONObject.put(paramVarArgs[i], paramVarArgs[(i + 1)]);
        i += 2;
      }
      paramVarArgs = localJSONObject.toString();
      e.a("palin: " + paramVarArgs);
      paramVarArgs = paramVarArgs.getBytes();
      paramArrayOfByte = new a().b(paramVarArgs, paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        e.c("encrypt pwd failed");
        return null;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    paramArrayOfByte = ap.a(paramArrayOfByte);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.n
 * JD-Core Version:    0.7.0.1
 */