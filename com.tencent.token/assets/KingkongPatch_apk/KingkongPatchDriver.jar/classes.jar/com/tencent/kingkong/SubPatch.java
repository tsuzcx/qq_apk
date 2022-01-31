package com.tencent.kingkong;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubPatch
{
  private static final String LOG_TAG = "SubPatch";
  private static final String TAG_FINGERPRINTS = "fingerprints";
  private static final String TAG_HOOK_POINT = "hook_point";
  private static final String TAG_JUMPER_POINT = "jumper_point";
  private static final String TAG_PARAMETERS = "parameters";
  private static final String TAG_PATCH_FILE = "patch_file";
  public ArrayList<String> fingerprints = new ArrayList();
  public int hookPoint;
  public int jumperPoint;
  public ArrayList<Integer> parameters = new ArrayList();
  public String patchFileName;
  
  public boolean parse(SubPatches paramSubPatches, JSONObject paramJSONObject)
  {
    int j;
    int i;
    try
    {
      this.patchFileName = paramJSONObject.getString("patch_file").trim();
      this.hookPoint = paramJSONObject.getInt("hook_point");
      this.jumperPoint = paramJSONObject.getInt("jumper_point");
      k = paramSubPatches.parameterCount;
      j = paramSubPatches.fingerprintCount;
      paramSubPatches = paramJSONObject.getJSONArray("parameters");
      paramJSONObject = paramJSONObject.getJSONArray("fingerprints");
      if (paramSubPatches.length() == k) {
        break label178;
      }
      Common.Log.d("SubPatch", "Parameter count error!");
      return false;
    }
    catch (JSONException paramSubPatches)
    {
      for (;;)
      {
        int k;
        Common.Log.d("SubPatch", "Parse subpatch error : " + paramSubPatches);
        return false;
        int m = paramSubPatches.getInt(i);
        this.parameters.add(Integer.valueOf(m));
        i += 1;
      }
      this.fingerprints.add(paramJSONObject.getString(i).trim());
      i += 1;
    }
    catch (Exception paramSubPatches)
    {
      return false;
    }
    if (i >= k)
    {
      if (paramJSONObject.length() == j) {
        break label183;
      }
      Common.Log.d("SubPatch", "Fingerprint count error!");
      return false;
    }
    label178:
    label183:
    while (i < j)
    {
      i = 0;
      break;
      i = 0;
    }
    return true;
  }
  
  public void print()
  {
    Common.Log.d("SubPatch", "--> HookPoint : " + this.hookPoint + " ; JumperPoint : " + this.jumperPoint + "\n");
    int i = 0;
    if (i >= this.parameters.size()) {
      i = 0;
    }
    for (;;)
    {
      if (i >= this.fingerprints.size())
      {
        return;
        Common.Log.d("SubPatch", "--> Parameters : " + ((Integer)this.parameters.get(i)).toString());
        i += 1;
        break;
      }
      Common.Log.d("SubPatch", "--> FingerPrint : " + (String)this.fingerprints.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.SubPatch
 * JD-Core Version:    0.7.0.1
 */