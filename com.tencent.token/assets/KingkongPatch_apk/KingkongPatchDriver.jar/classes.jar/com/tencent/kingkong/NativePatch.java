package com.tencent.kingkong;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class NativePatch
  extends Patch
{
  private static final String LOG_TAG = "KingKongNativePatch";
  private static final String TAG_BASIC_GROUP = "basic_group";
  private static final String TAG_FINGERPRINT_COUNT = "fingerprint_count";
  private static final String TAG_FINGERPRINT_DEFINE = "fingerprint_definition";
  private static final String TAG_FINGERPRINT_FUNCTION_NAME = "func_name";
  private static final String TAG_FINGERPRINT_LIBRARY_NAME = "lib_name";
  private static final String TAG_FINGERPRINT_TYPE = "type";
  private static final String TAG_HOOKPOINT_COUNT = "hookpoint_count";
  private static final String TAG_HOOKPOINT_DEFINE = "hookpoint_definition";
  private static final String TAG_HOOKPOINT_FUNCTION_NAME = "hookpoint_func_name";
  private static final String TAG_HOOKPOINT_LIBRARY_NAME = "hookpoint_lib_name";
  private static final String TAG_HOOKPOINT_TYPE = "hookpoint_type";
  private static final String TAG_PARAMETER_COUNT = "param_count";
  private static final String TAG_PARAMETER_DEFINE = "parameter_definition";
  private static final String TAG_PARAM_INDEX = "param_index";
  private static final String TAG_PARAM_TYPE = "param_type";
  private static final String TAG_PARAM_VALUE1 = "param_value1";
  private static final String TAG_PARAM_VALUE2 = "param_value2";
  private static final String TAG_PATCH_NAME = "name";
  private static final String TAG_TYPE = "type";
  private static final String TAG_VERSION = "ver";
  private static String mPathSeparator = File.separator;
  private int mFingerprintCount = 0;
  private ArrayList<FingerprintDef> mFingerprintDefines = new ArrayList();
  private int mHookPointCount = 0;
  private ArrayList<HookPointDef> mHookPointDefines = new ArrayList();
  private ArrayList<NativeSubPatch> mNativeSubPatches = new ArrayList();
  private int mParameterCount = 0;
  private ArrayList<ParameterDef> mParameterDefines = new ArrayList();
  private NativeSubPatch mValidSubPatch = null;
  
  public NativePatch(String paramString1, String paramString2)
  {
    this.mPath = paramString1;
    this.mPatchName = paramString2;
  }
  
  public static Patch CreatePatch(String paramString, PatchInfo paramPatchInfo)
  {
    paramString = new NativePatch(paramString, paramPatchInfo.mPatchName);
    if ((paramString.parseConfig(paramString.getConfigFileName())) && (paramString.parseSubPatches())) {
      return paramString;
    }
    return null;
  }
  
  public static String getFingerprint(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = PatchManager.nativeGetFingerprint(paramString1, paramString2, 0, paramInt);
    if ((paramString1 != null) && (paramString1.length != 0)) {
      return Utils.getSHA1String(paramString1);
    }
    return "";
  }
  
  public static String getFingerprint(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = PatchManager.nativeGetFingerprint(paramString1, paramString2, paramInt1, paramInt2);
    if ((paramString1 != null) && (paramString1.length != 0)) {
      return Utils.getSHA1String(paramString1);
    }
    return "";
  }
  
  private ArrayList<String> getFingerprintLibraries()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i >= this.mFingerprintDefines.size()) {
        return localArrayList;
      }
      localArrayList.add(((FingerprintDef)this.mFingerprintDefines.get(i)).libName);
      i += 1;
    }
  }
  
  private int[] getGotHookPoints()
  {
    int[] arrayOfInt2 = Common.getPatchGotHookPoints(this.mPatchInfo.mFlag);
    Object localObject;
    if (arrayOfInt2 == null)
    {
      Common.Log.d("KingKongNativePatch", "No GOT Hookpoint found");
      localObject = null;
      return localObject;
    }
    if (arrayOfInt2.length != this.mHookPointCount)
    {
      Common.Log.d("KingKongNativePatch", "Got Hookpoint length mismatch " + this.mHookPointCount + ", " + arrayOfInt2.length);
      return null;
    }
    int[] arrayOfInt1 = new int[this.mHookPointCount];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfInt1;
      if (i >= this.mHookPointCount) {
        break;
      }
      arrayOfInt1[i] = PatchManager.nativeCalcParameter(2, ((HookPointDef)this.mHookPointDefines.get(i)).libName, "", arrayOfInt2[i]);
      if (arrayOfInt1[i] == -1)
      {
        Common.Log.d("KingKongNativePatch", "Calculate GOT Hookpoint failed " + i);
        return null;
      }
      i += 1;
    }
  }
  
  private int[] getJumperPoints()
  {
    int[] arrayOfInt2 = Common.getPatchJumperPoints(this.mPatchInfo.mFlag);
    Object localObject;
    if (arrayOfInt2 == null)
    {
      Common.Log.d("KingKongNativePatch", "No Jumper point found");
      localObject = null;
      return localObject;
    }
    if (arrayOfInt2.length != this.mHookPointCount)
    {
      Common.Log.d("KingKongNativePatch", "Jumper point length mismatch " + this.mHookPointCount + ", " + arrayOfInt2.length);
      return null;
    }
    int[] arrayOfInt1 = new int[this.mHookPointCount];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfInt1;
      if (i >= this.mHookPointCount) {
        break;
      }
      arrayOfInt1[i] = PatchManager.nativeCalcParameter(2, ((HookPointDef)this.mHookPointDefines.get(i)).libName, "", arrayOfInt2[i]);
      if (arrayOfInt1[i] == -1)
      {
        Common.Log.d("KingKongNativePatch", "Calculate Jumper point failed " + i);
        return null;
      }
      i += 1;
    }
  }
  
  private String getSubPatchFileName()
  {
    return this.mPath + mPathSeparator + this.mPatchName + ".subpatch";
  }
  
  private int getValidPatchIndex()
  {
    int i = 0;
    if (i >= this.mNativeSubPatches.size())
    {
      Common.Log.d("KingKongNativePatch", "Unable to get valid subpatch by offset!");
      return -1;
    }
    NativeSubPatch localNativeSubPatch = (NativeSubPatch)this.mNativeSubPatches.get(i);
    if ((localNativeSubPatch.fingerprints.size() != this.mFingerprintCount) || (localNativeSubPatch.hookPoints.size() != this.mHookPointCount) || (localNativeSubPatch.fingerprints_value.size() != this.mFingerprintCount)) {
      Common.Log.d("KingKongNativePatch", "Skip fingerprint/hookpoint count mismatch subpatch " + i);
    }
    label303:
    for (;;)
    {
      i += 1;
      break;
      int j = 0;
      for (;;)
      {
        if (j >= this.mFingerprintCount) {
          break label303;
        }
        Object localObject = (FingerprintDef)this.mFingerprintDefines.get(j);
        String str1 = ((FingerprintDef)localObject).libName;
        String str2 = ((FingerprintDef)localObject).funcName;
        int k = ((FingerprintDef)localObject).type;
        int m = ((Integer)localNativeSubPatch.fingerprints_value.get(j)).intValue();
        localObject = (String)localNativeSubPatch.fingerprints.get(j);
        if ((m == -1) || ("null".equals(localObject)))
        {
          Common.Log.d("KingKongNativePatch", "Skip null fingerprint ");
          if (j == this.mFingerprintCount - 1)
          {
            Common.Log.d("KingKongNativePatch", "Well done, all fingerprints matched!");
            return i;
          }
        }
        else
        {
          str1 = getFingerprint(str1, str2, m, k);
          if ((str1 == null) || (!str1.equals(localObject))) {
            break;
          }
          Common.Log.d("KingKongNativePatch", "Matches fingerprint " + str1);
          if (j == this.mFingerprintCount - 1)
          {
            Common.Log.d("KingKongNativePatch", "Well done, all fingerprints matched!");
            return i;
          }
        }
        j += 1;
      }
    }
  }
  
  private int hookpointTypeToParamType(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 2;
    }
    return i;
  }
  
  private boolean parseConfig(String paramString)
  {
    paramString = Utils.ReadFileToString(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.mPatchName = paramString.getString("name");
      this.mPatchVersion = paramString.getString("ver");
      this.mPatchType = paramString.getString("type");
      JSONObject localJSONObject = paramString.getJSONObject("basic_group");
      this.mFingerprintCount = localJSONObject.getInt("fingerprint_count");
      this.mParameterCount = localJSONObject.getInt("param_count");
      this.mHookPointCount = localJSONObject.getInt("hookpoint_count");
      Common.Log.d("KingKongNativePatch", "--> Fingerprint count : " + this.mFingerprintCount);
      Common.Log.d("KingKongNativePatch", "--> Parameter count : " + this.mParameterCount);
      Common.Log.d("KingKongNativePatch", "--> HookPoint count : " + this.mHookPointCount);
      int i = 0;
      if (i >= this.mHookPointCount)
      {
        i = 0;
        label168:
        if (i < this.mFingerprintCount) {
          break label274;
        }
        i = 0;
      }
      for (;;)
      {
        if (i >= this.mParameterCount)
        {
          return true;
          localJSONObject = paramString.getJSONObject("hookpoint_definition_" + String.valueOf(i + 1));
          localObject = new HookPointDef();
          if (!((HookPointDef)localObject).parse(localJSONObject)) {
            break label492;
          }
          Common.Log.d("KingKongNativePatch", "--> HookPoint : " + localObject);
          this.mHookPointDefines.add(localObject);
          i += 1;
          break;
          label274:
          localJSONObject = paramString.getJSONObject("fingerprint_definition_" + String.valueOf(i + 1));
          localObject = new FingerprintDef();
          if (!((FingerprintDef)localObject).parse(localJSONObject)) {
            break label494;
          }
          this.mFingerprintDefines.add(localObject);
          Common.Log.d("KingKongNativePatch", "--> Fingerprint " + localObject);
          i += 1;
          break label168;
        }
        localJSONObject = paramString.getJSONObject("parameter_definition_" + String.valueOf(i + 1));
        Object localObject = new ParameterDef();
        if (!((ParameterDef)localObject).parse(localJSONObject)) {
          break label465;
        }
        if (((ParameterDef)localObject).index != i)
        {
          Common.Log.d("KingKongNativePatch", "Parameter index error!");
          return false;
        }
        Common.Log.d("KingKongNativePatch", "--> Parameter definition : " + localObject);
        this.mParameterDefines.add(localObject);
        i += 1;
      }
      label465:
      return false;
    }
    catch (JSONException paramString)
    {
      Common.Log.d("KingKongNativePatch", "Parse sub patches failed : " + paramString);
      return false;
    }
    label492:
    return false;
    label494:
    return false;
  }
  
  private boolean parseSubPatches()
  {
    this.mNativeSubPatches = NativeSubPatch.parseSubPatchesFromFile(getSubPatchFileName());
    return this.mNativeSubPatches != null;
  }
  
  public int[] calcParameters(ArrayList<ParameterDef> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    int[] arrayOfInt = new int[paramArrayList.size()];
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        return arrayOfInt;
      }
      ParameterDef localParameterDef = (ParameterDef)paramArrayList.get(i);
      int j = ((Integer)paramArrayList1.get(i)).intValue();
      arrayOfInt[i] = PatchManager.nativeCalcParameter(localParameterDef.type, localParameterDef.value1, localParameterDef.value2, j);
      if (arrayOfInt[i] == -1)
      {
        Common.Log.d("KingKongNativePatch", "Calculate parameter failed " + i);
        return null;
      }
      i += 1;
    }
  }
  
  public int doPatch(Context paramContext)
  {
    Common.Log.d("KingKongNativePatch", "---> Patching " + this.mPatchName + "  <-------");
    int i = Common.getSubPatchIndex(this.mPatchInfo.mFlag, getFingerprintLibraries());
    if ((i == -1) || (i >= this.mNativeSubPatches.size()))
    {
      Common.Log.d("KingKongNativePatch", "Unable to find valid subpatch index " + i);
      return 12;
    }
    paramContext = (NativeSubPatch)this.mNativeSubPatches.get(i);
    if ((paramContext.hookPoints.size() != this.mHookPointCount) || (this.mHookPointDefines.size() != this.mHookPointCount))
    {
      Common.Log.d("KingKongNativePatch", "SubPatch Hookpoint count mismatch ");
      return 11;
    }
    int[] arrayOfInt1 = getGotHookPoints();
    int[] arrayOfInt2 = getJumperPoints();
    if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
    {
      Common.Log.d("KingKongNativePatch", "Unable to get GOT HookPoint or Jumper point");
      return 8;
    }
    int j = paramContext.isThumb2;
    i = 0;
    if (i >= this.mHookPointCount)
    {
      Common.Log.d("KingKongNativePatch", "---> Do patch OK <----");
      return 0;
    }
    Object localObject2 = (HookPointDef)this.mHookPointDefines.get(i);
    Object localObject1 = paramContext.parameters;
    int n = ((Integer)paramContext.hookPoints.get(i)).intValue();
    int k = arrayOfInt2[i];
    int m = arrayOfInt1[i];
    int i1 = ((HookPointDef)localObject2).type;
    String str = ((HookPointDef)localObject2).libName;
    localObject2 = ((HookPointDef)localObject2).funcName;
    if (n == -1) {
      Common.Log.d("KingKongNativePatch", "Skip empty hook point " + i);
    }
    do
    {
      i += 1;
      break;
      n = PatchManager.nativeCalcParameter(hookpointTypeToParamType(i1), str, (String)localObject2, n);
      if (n == -1)
      {
        Common.Log.d("KingKongNativePatch", "Calculate hookPoint failed");
        return 7;
      }
      localObject1 = calcParameters(this.mParameterDefines, (ArrayList)localObject1);
      if (localObject1 == null) {
        return 6;
      }
    } while (PatchManager.nativeDoPatch(Common.makeInstallName(this.mPatchInfo.mFolder + File.separator + "lib" + this.mPatchName + ".so"), str, (String)localObject2, n, k, m, (int[])localObject1, this.mParameterCount, j));
    Common.Log.d("KingKongNativePatch", "Native do patch failed");
    return 10;
  }
  
  public NativeSubPatch getNativeSubPatch()
  {
    return this.mValidSubPatch;
  }
  
  public boolean initPatch()
  {
    int j = getValidPatchIndex();
    if (j == -1) {
      return false;
    }
    Common.Log.d("KingKongNativePatch", "Valid subpatch index : " + this.mPatchName + " : " + j);
    int[] arrayOfInt1 = new int[this.mHookPointCount];
    int[] arrayOfInt2 = new int[this.mHookPointCount];
    int i = 0;
    for (;;)
    {
      if (i >= this.mHookPointCount)
      {
        Common.storePatchHookParams(this.mPatchInfo.mFlag, this.mHookPointCount, arrayOfInt1, arrayOfInt2);
        Common.storeSubPatchIndex(this.mPatchInfo.mFlag, j, getFingerprintLibraries());
        return true;
      }
      String str = ((HookPointDef)this.mHookPointDefines.get(i)).libName;
      int k = PatchManager.nativeCalcJumperPoint(str);
      int m = PatchManager.nativeCalcGotHookPoint(str);
      if ((k == -1) || (m == -1))
      {
        Common.Log.d("KingKongNativePatch", "Calculate jumper/got point failed");
        return false;
      }
      Common.Log.d("KingKongNativePatch", "Patch params " + i + ", " + str + ", " + k + ", " + m);
      arrayOfInt1[i] = k;
      arrayOfInt2[i] = m;
      i += 1;
    }
  }
  
  public class FingerprintDef
  {
    public String funcName;
    public String libName;
    public int type;
    
    public FingerprintDef() {}
    
    public boolean parse(JSONObject paramJSONObject)
    {
      try
      {
        this.type = Integer.parseInt(paramJSONObject.getString("type"));
        this.libName = paramJSONObject.getString("lib_name").trim();
        this.funcName = paramJSONObject.getString("func_name").trim();
        return true;
      }
      catch (Exception paramJSONObject)
      {
        Common.Log.d("KingKongNativePatch", "Parse fingerprint error!");
      }
      return false;
    }
    
    public String toString()
    {
      return this.type + ", " + this.libName + ", " + this.funcName;
    }
  }
  
  public class HookPointDef
  {
    public String funcName;
    public String libName;
    public int type;
    
    public HookPointDef() {}
    
    public boolean parse(JSONObject paramJSONObject)
    {
      try
      {
        this.type = Integer.parseInt(paramJSONObject.getString("hookpoint_type"));
        this.libName = paramJSONObject.getString("hookpoint_lib_name").trim();
        this.funcName = paramJSONObject.getString("hookpoint_func_name").trim();
        return true;
      }
      catch (Exception paramJSONObject)
      {
        Common.Log.d("KingKongNativePatch", "Parse HookPoint error!");
      }
      return false;
    }
    
    public String toString()
    {
      return this.type + ", " + this.libName + ", " + this.funcName;
    }
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
        Common.Log.d("KingKongNativePatch", "Parse parameter error!");
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
 * Qualified Name:     com.tencent.kingkong.NativePatch
 * JD-Core Version:    0.7.0.1
 */