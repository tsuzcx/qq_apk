import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.e;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class prt
  extends jov
{
  public static prt.b a;
  public boolean aBn;
  public SparseArray<prt.c> aH;
  public SparseArray<prt.a> aI;
  public String auB;
  public String auC;
  public int bjW;
  public int bjX;
  public boolean mIsEnable;
  
  public prt(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public String hJ()
  {
    return "key_for_text_filter_cfg";
  }
  
  public String hK()
  {
    return "key_for_text_filter_cfg_version";
  }
  
  public void kX(String paramString)
  {
    int j = 0;
    this.auB = paramString;
    Object localObject1 = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.StoryCfg.name(), "1|1");
    this.aBn = true;
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new Integer[2];
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new DeviceProfileManager.e()) > 1) {
        if (localObject2[1].intValue() != 1) {
          break label115;
        }
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      this.aBn = bool;
      this.aH = new SparseArray();
      this.aI = new SparseArray();
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      this.mIsEnable = false;
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("is_enable", 0) != 1) {
          break label645;
        }
        bool = true;
        this.mIsEnable = bool;
        this.bjW = paramString.optInt("bid");
        this.auC = paramString.optString("template_manager", "TemplateManager");
        this.bjX = paramString.optInt("bg_alpha", 80);
        localObject1 = paramString.optJSONArray("template");
        if (localObject1 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 == null) {
              break label638;
            }
            prt.c localc = new prt.c();
            localc.mId = ((JSONObject)localObject2).optInt("id");
            localc.auD = ((JSONObject)localObject2).optString("report_id");
            localc.mName = ((JSONObject)localObject2).optString("name");
            localc.bjY = ((JSONObject)localObject2).optInt("color_template_id");
            if (((JSONObject)localObject2).optInt("is_support_other_color") != 1) {
              break label651;
            }
            bool = true;
            localc.aBo = bool;
            localc.auH = ((JSONObject)localObject2).optString("text_color");
            localc.alg = ((JSONObject)localObject2).optString("background_color");
            localc.bjZ = ((JSONObject)localObject2).optInt("max_text_count");
            if (((JSONObject)localObject2).optInt("is_dynamictmp") != 1) {
              break label657;
            }
            bool = true;
            localc.aBp = bool;
            localc.auL = ((JSONObject)localObject2).optString("res_name");
            localc.bka = ((JSONObject)localObject2).optInt("bid", 0);
            localc.auM = ((JSONObject)localObject2).optString("music_file");
            localc.auN = ((JSONObject)localObject2).optString("pcm_music_file");
            localc.aL = ((JSONObject)localObject2).optJSONObject("hint");
            localc.mImageUrl = ((JSONObject)localObject2).optString("image_url");
            localc.aK = ((JSONObject)localObject2).optJSONObject("extra_json_config");
            this.aH.put(localc.mId, localc);
            break label638;
          }
        }
        paramString = paramString.optJSONArray("color_template");
        if (paramString != null)
        {
          i = j;
          if (i < paramString.length())
          {
            localObject1 = paramString.optJSONObject(i);
            if (localObject1 != null)
            {
              localObject2 = new prt.a();
              ((prt.a)localObject2).mId = ((JSONObject)localObject1).optInt("id");
              ((prt.a)localObject2).auD = ((JSONObject)localObject1).optString("report_id");
              ((prt.a)localObject2).auE = ((JSONObject)localObject1).optString("background_color");
              ((prt.a)localObject2).auF = ((JSONObject)localObject1).optString("background_color2");
              ((prt.a)localObject2).auG = ((JSONObject)localObject1).optString("background_color3");
              ((prt.a)localObject2).auH = ((JSONObject)localObject1).optString("text_color");
              ((prt.a)localObject2).aK = ((JSONObject)localObject1).optJSONObject("extra_json_config");
              this.aI.put(((prt.a)localObject2).mId, localObject2);
            }
            i += 1;
            continue;
          }
        }
        if (!this.aBn) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("read TextFilter Config", 2, paramString.getMessage());
        }
      }
      if (!this.mIsEnable) {
        break;
      }
      return;
      label638:
      i += 1;
      continue;
      label645:
      bool = false;
      continue;
      label651:
      bool = false;
      continue;
      label657:
      bool = false;
    }
  }
  
  public static class a
  {
    public JSONObject aK;
    public String auD = "";
    public String auE;
    public String auF;
    public String auG;
    public String auH;
    public int mId;
  }
  
  public static class b
  {
    public String auI;
    public String auJ;
    public String auK;
    public int mOpIn;
    
    public b(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      this.mOpIn = paramInt;
      this.auI = paramString1;
      this.auJ = paramString2;
      this.auK = paramString3;
    }
  }
  
  public static class c
  {
    public boolean aBo;
    public boolean aBp;
    public boolean aBq;
    public boolean aBr;
    public JSONObject aK;
    public JSONObject aL;
    public String alg;
    public String auD;
    public String auH;
    public String auL;
    public String auM;
    public String auN;
    public int bjY;
    public int bjZ;
    public int bka;
    public int mId;
    public String mImageUrl;
    public String mName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prt
 * JD-Core Version:    0.7.0.1
 */