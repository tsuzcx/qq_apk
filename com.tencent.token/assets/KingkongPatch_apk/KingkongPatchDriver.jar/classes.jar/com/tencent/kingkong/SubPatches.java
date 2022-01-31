package com.tencent.kingkong;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubPatches
{
  private static final String LOG_TAG = "SubPatches";
  private static final String TAG_FINGERPRINT_COUNT = "fingerprint_count";
  private static final String TAG_FINGERPRINT_DEFINITION = "fingerprint_definition";
  private static final String TAG_FUNCTION_NAME = "func_name";
  private static final String TAG_HOOKPOINT_FUNCTION_NAME = "hookpoint_func_name";
  private static final String TAG_HOOKPOINT_LIBRARY_NAME = "hookpoint_lib_name";
  private static final String TAG_LIBRARY_NAME = "lib_name";
  private static final String TAG_PARAMETER_COUNT = "param_count";
  private static final String TAG_PARAMETER_DEFINE = "parameter_definition";
  private static final String TAG_PARAM_INDEX = "param_index";
  private static final String TAG_PARAM_TYPE = "param_type";
  private static final String TAG_PARAM_VALUE1 = "param_value1";
  private static final String TAG_PARAM_VALUE2 = "param_value2";
  private static final String TAG_SUBPATCH_COUNT = "subpatch_count";
  private static final String TAG_SUBPATCH_HEAD = "subpatches";
  public int fingerprintCount = 0;
  public ArrayList<String> functionNames = new ArrayList();
  public String hookpointFuncName = "";
  public String hookpointLibName = "";
  public ArrayList<String> libraryNames = new ArrayList();
  public int parameterCount = 0;
  public ArrayList<ParameterDef> parameterDefines = new ArrayList();
  public int subPatchCount = 0;
  public ArrayList<SubPatch> subPatches = new ArrayList();
  
  /* Error */
  private static String getJsonString(String paramString)
  {
    // Byte code:
    //   0: new 101	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_1
    //   10: aconst_null
    //   11: astore_2
    //   12: new 104	java/io/BufferedReader
    //   15: dup
    //   16: new 106	java/io/InputStreamReader
    //   19: dup
    //   20: new 108	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   28: invokespecial 114	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: sipush 8192
    //   34: invokespecial 117	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 121	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnonnull +16 -> 60
    //   47: aload_0
    //   48: ifnull +78 -> 126
    //   51: aload_0
    //   52: invokevirtual 124	java/io/BufferedReader:close	()V
    //   55: aload_3
    //   56: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: areturn
    //   60: aload_3
    //   61: aload_1
    //   62: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: goto -28 -> 38
    //   69: astore_2
    //   70: aload_0
    //   71: astore_1
    //   72: aload_2
    //   73: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   76: aload_0
    //   77: ifnull -22 -> 55
    //   80: aload_0
    //   81: invokevirtual 124	java/io/BufferedReader:close	()V
    //   84: goto -29 -> 55
    //   87: astore_0
    //   88: goto -33 -> 55
    //   91: astore_0
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 124	java/io/BufferedReader:close	()V
    //   100: aload_0
    //   101: athrow
    //   102: astore_0
    //   103: goto -48 -> 55
    //   106: astore_1
    //   107: goto -7 -> 100
    //   110: astore_2
    //   111: aload_0
    //   112: astore_1
    //   113: aload_2
    //   114: astore_0
    //   115: goto -23 -> 92
    //   118: astore_1
    //   119: aload_2
    //   120: astore_0
    //   121: aload_1
    //   122: astore_2
    //   123: goto -53 -> 70
    //   126: goto -71 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramString	String
    //   9	88	1	str1	String
    //   106	1	1	localIOException1	java.io.IOException
    //   112	1	1	str2	String
    //   118	4	1	localIOException2	java.io.IOException
    //   11	1	2	localObject1	Object
    //   69	4	2	localIOException3	java.io.IOException
    //   110	10	2	localObject2	Object
    //   122	1	2	localIOException4	java.io.IOException
    //   7	54	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	43	69	java/io/IOException
    //   60	66	69	java/io/IOException
    //   80	84	87	java/io/IOException
    //   12	38	91	finally
    //   72	76	91	finally
    //   51	55	102	java/io/IOException
    //   96	100	106	java/io/IOException
    //   38	43	110	finally
    //   60	66	110	finally
    //   12	38	118	java/io/IOException
  }
  
  public boolean parseFromFile(String paramString)
  {
    paramString = getJsonString(paramString);
    int i;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
      }
      catch (JSONException paramString)
      {
        Object localObject1;
        Object localObject3;
        Object localObject2;
        label489:
        Common.Log.d("SubPatches", "Parse sub patches failed : " + paramString);
        return false;
      }
      try
      {
        this.fingerprintCount = paramString.getInt("fingerprint_count");
        localObject1 = paramString.getJSONArray("fingerprint_definition");
        if (((JSONArray)localObject1).length() == this.fingerprintCount) {
          break label528;
        }
        Common.Log.d("SubPatches", "Fingerprint count mismatch!");
        return false;
      }
      catch (JSONException paramString)
      {
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
      }
      if (i >= this.fingerprintCount)
      {
        this.parameterCount = paramString.getInt("param_count");
        localObject1 = paramString.getJSONArray("parameter_definition");
        if (this.parameterCount == ((JSONArray)localObject1).length()) {
          break label533;
        }
        Common.Log.d("SubPatches", "Parameter count mismatch :" + this.parameterCount + ", " + ((JSONArray)localObject1).length());
        return false;
      }
      localObject3 = ((JSONArray)localObject1).getJSONObject(i);
      localObject2 = ((JSONObject)localObject3).getString("lib_name").trim();
      localObject3 = ((JSONObject)localObject3).getString("func_name").trim();
      this.libraryNames.add(localObject2);
      this.functionNames.add(localObject3);
      Common.Log.d("SubPatches", "--> Fingerprint Library Name : " + (String)localObject2 + " ; Function Name : " + (String)localObject3);
      i += 1;
      continue;
      if (i >= this.parameterCount)
      {
        this.hookpointFuncName = paramString.getString("hookpoint_func_name").trim();
        this.hookpointLibName = paramString.getString("hookpoint_lib_name").trim();
        Common.Log.d("SubPatches", "--> Hookpoint library Name : " + this.hookpointLibName);
        Common.Log.d("SubPatches", "--> Hookpoint function Name : " + this.hookpointFuncName);
        this.subPatchCount = paramString.getInt("subpatch_count");
        paramString = paramString.getJSONArray("subpatches");
        i = 0;
      }
      for (;;)
      {
        if (i >= paramString.length())
        {
          if (this.subPatchCount == this.subPatches.size()) {
            break label522;
          }
          Common.Log.d("SubPatches", "Sub patch count mismatch, give up");
          return false;
          localObject2 = new ParameterDef();
          if (!((ParameterDef)localObject2).parse(((JSONArray)localObject1).getJSONObject(i))) {
            break label538;
          }
          if (((ParameterDef)localObject2).index != i)
          {
            Common.Log.d("SubPatches", "Parameter index error!");
            return false;
          }
          Common.Log.d("SubPatches", "--> Parameter definition : " + localObject2);
          this.parameterDefines.add(localObject2);
          i += 1;
          break;
        }
        Common.Log.d("SubPatches", "Parseing sub patch " + i);
        localObject1 = new SubPatch();
        if (!((SubPatch)localObject1).parse(this, paramString.getJSONObject(i))) {
          break label489;
        }
        ((SubPatch)localObject1).print();
        this.subPatches.add(localObject1);
        i += 1;
      }
      Common.Log.d("SubPatches", "Parse sub patch failed, give up");
      return false;
    }
    label522:
    return true;
    label528:
    label533:
    label538:
    return false;
  }
  
  public class ParameterDef
  {
    public int index;
    public int type;
    public String value1;
    public String value2;
    
    public ParameterDef() {}
    
    public boolean parse(JSONObject paramJSONObject)
    {
      try
      {
        this.index = Integer.parseInt(paramJSONObject.getString("param_index"));
        this.type = Integer.parseInt(paramJSONObject.getString("param_type"));
        this.value1 = paramJSONObject.getString("param_value1").trim();
        this.value2 = paramJSONObject.getString("param_value2").trim();
        return true;
      }
      catch (Exception paramJSONObject)
      {
        Common.Log.d("SubPatches", "Parse parameter error!");
      }
      return false;
    }
    
    public String toString()
    {
      return "Index " + this.index + ": " + this.type + ", " + this.value1 + ", " + this.value2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.SubPatches
 * JD-Core Version:    0.7.0.1
 */