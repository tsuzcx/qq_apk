package com.tencent.token;

import com.tencent.token.global.g;
import com.tencent.token.utils.encrypt.a;
import org.json.JSONException;
import org.json.JSONObject;

public class bs
{
  private String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = new a().b(paramArrayOfByte1, paramArrayOfByte2);
    if (paramArrayOfByte1 == null)
    {
      g.c("encrypt pwd failed");
      return null;
    }
    return cj.a(paramArrayOfByte1);
  }
  
  protected String a(byte[] paramArrayOfByte, String... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0)
    {
      g.c("params count % 2 should be 0");
      return null;
    }
    try
    {
      Object localObject = new JSONObject();
      int i = 0;
      while (i < paramVarArgs.length)
      {
        ((JSONObject)localObject).put(paramVarArgs[i], paramVarArgs[(i + 1)]);
        i += 2;
      }
      paramVarArgs = ((JSONObject)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("palin: ");
      ((StringBuilder)localObject).append(paramVarArgs);
      g.a(((StringBuilder)localObject).toString());
      paramArrayOfByte = a(paramVarArgs.getBytes(), paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bs
 * JD-Core Version:    0.7.0.1
 */