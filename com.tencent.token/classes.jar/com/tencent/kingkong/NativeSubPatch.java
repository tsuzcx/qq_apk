package com.tencent.kingkong;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeSubPatch
{
  private static final String LOG_TAG = "KingKongSubPatch";
  private static final String TAG_FINGERPRINTS = "fingerprints";
  private static final String TAG_FINGERPRINTS_VALUE = "fingerprints_value";
  private static final String TAG_HOOK_POINT = "hook_point";
  private static final String TAG_IS_THUMB2 = "isThumb2";
  private static final String TAG_PARAMETERS = "parameters";
  private static final String TAG_PATCH_FILE = "patch_file";
  public ArrayList<String> fingerprints = new ArrayList();
  public ArrayList<Integer> fingerprints_value = new ArrayList();
  public ArrayList<Integer> hookPoints = new ArrayList();
  public int isThumb2 = 1;
  public ArrayList<Integer> parameters = new ArrayList();
  public String patchFileName;
  
  public static ArrayList<NativeSubPatch> parseSubPatchesFromFile(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(Utils.ReadFileToString(paramString));
      int i = 0;
      for (;;)
      {
        if (i >= paramString.length()) {
          return localArrayList;
        }
        Common.Log.v("KingKongSubPatch", "Parsing sub patch " + i);
        NativeSubPatch localNativeSubPatch = new NativeSubPatch();
        if (!localNativeSubPatch.parseFromJSON(paramString.getJSONObject(i))) {
          break;
        }
        localNativeSubPatch.print();
        localArrayList.add(localNativeSubPatch);
        i += 1;
      }
      Common.Log.d("KingKongSubPatch", "Parse sub patch failed, give up");
      return null;
    }
    catch (Exception paramString)
    {
      Common.Log.d("KingKongSubPatch", "Parse SubPatch List exception : " + paramString);
    }
    return null;
  }
  
  public boolean parseFromJSON(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int k;
      int i;
      try
      {
        this.patchFileName = paramJSONObject.getString("patch_file").trim();
        JSONArray localJSONArray1 = paramJSONObject.getJSONArray("parameters");
        JSONArray localJSONArray2 = paramJSONObject.getJSONArray("fingerprints");
        JSONArray localJSONArray3 = paramJSONObject.getJSONArray("hook_point");
        JSONArray localJSONArray4 = paramJSONObject.getJSONArray("fingerprints_value");
        int m = localJSONArray1.length();
        k = localJSONArray2.length();
        int n = localJSONArray4.length();
        int j = localJSONArray3.length();
        i = 0;
        if (i >= m)
        {
          if (n != k)
          {
            Common.Log.d("KingKongSubPatch", "Fingerprint value count mismatch " + n + ", " + k);
            return false;
          }
        }
        else
        {
          this.parameters.add(Integer.valueOf(localJSONArray1.getInt(i)));
          i += 1;
          continue;
          if (i >= j)
          {
            this.isThumb2 = paramJSONObject.optInt("isThumb2", 1);
            return true;
            this.fingerprints.add(localJSONArray2.getString(i).trim());
            this.fingerprints_value.add(Integer.valueOf(localJSONArray4.getInt(i)));
            i += 1;
            break label257;
          }
          this.hookPoints.add(Integer.valueOf(localJSONArray3.getInt(i)));
          i += 1;
          continue;
        }
        i = 0;
      }
      catch (JSONException paramJSONObject)
      {
        Common.Log.d("KingKongSubPatch", "Parse SubPatch error : " + paramJSONObject);
        return false;
      }
      catch (Exception paramJSONObject)
      {
        return false;
      }
      label257:
      if (i >= k) {
        i = 0;
      }
    }
  }
  
  public void print()
  {
    int i = 0;
    if (i >= this.hookPoints.size())
    {
      i = 0;
      label15:
      if (i < this.parameters.size()) {
        break label75;
      }
      i = 0;
    }
    for (;;)
    {
      if (i >= this.fingerprints.size())
      {
        return;
        Common.Log.v("KingKongSubPatch", "--> HookPoints : " + this.hookPoints.get(i));
        i += 1;
        break;
        label75:
        Common.Log.v("KingKongSubPatch", "--> Parameters : " + ((Integer)this.parameters.get(i)).toString());
        i += 1;
        break label15;
      }
      Common.Log.v("KingKongSubPatch", "--> FingerPrint : " + (String)this.fingerprints.get(i) + ", " + this.fingerprints_value.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.NativeSubPatch
 * JD-Core Version:    0.7.0.1
 */