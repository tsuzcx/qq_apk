import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uul
  extends nbq
{
  public static uun a;
  public SparseArray<uuo> a;
  public boolean a;
  public int b;
  public SparseArray<uum> b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  
  public uul(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public String a()
  {
    return "key_for_text_filter_cfg";
  }
  
  public void a(String paramString)
  {
    int j = 0;
    this.jdField_b_of_type_JavaLangString = paramString;
    Object localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.StoryCfg.name(), "1|1");
    this.jdField_b_of_type_Boolean = true;
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new Integer[2];
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new alrg()) > 1) {
        if (localObject2[1].intValue() != 1) {
          break label115;
        }
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("is_enable", 0) != 1) {
          break label644;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        this.jdField_b_of_type_Int = paramString.optInt("bid");
        this.jdField_c_of_type_JavaLangString = paramString.optString("template_manager", "TemplateManager");
        this.jdField_c_of_type_Int = paramString.optInt("bg_alpha", 80);
        localObject1 = paramString.optJSONArray("template");
        if (localObject1 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 == null) {
              break label637;
            }
            uuo localuuo = new uuo();
            localuuo.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("id");
            localuuo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("report_id");
            localuuo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("name");
            localuuo.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("color_template_id");
            if (((JSONObject)localObject2).optInt("is_support_other_color") != 1) {
              break label650;
            }
            bool = true;
            localuuo.jdField_a_of_type_Boolean = bool;
            localuuo.jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("text_color");
            localuuo.e = ((JSONObject)localObject2).optString("background_color");
            localuuo.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("max_text_count");
            if (((JSONObject)localObject2).optInt("is_dynamictmp") != 1) {
              break label656;
            }
            bool = true;
            localuuo.jdField_b_of_type_Boolean = bool;
            localuuo.jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).optString("res_name");
            localuuo.jdField_d_of_type_Int = ((JSONObject)localObject2).optInt("bid", 0);
            localuuo.f = ((JSONObject)localObject2).optString("music_file");
            localuuo.g = ((JSONObject)localObject2).optString("pcm_music_file");
            localuuo.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject2).optJSONObject("hint");
            localuuo.h = ((JSONObject)localObject2).optString("image_url");
            localuuo.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject2).optJSONObject("extra_json_config");
            this.jdField_a_of_type_AndroidUtilSparseArray.put(localuuo.jdField_a_of_type_Int, localuuo);
            break label637;
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
              localObject2 = new uum();
              ((uum)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("id");
              ((uum)localObject2).jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("report_id");
              ((uum)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("background_color");
              ((uum)localObject2).jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("background_color2");
              ((uum)localObject2).jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("background_color3");
              ((uum)localObject2).e = ((JSONObject)localObject1).optString("text_color");
              ((uum)localObject2).jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject1).optJSONObject("extra_json_config");
              this.jdField_b_of_type_AndroidUtilSparseArray.put(((uum)localObject2).jdField_a_of_type_Int, localObject2);
            }
            i += 1;
            continue;
          }
        }
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("read TextFilter Config", 2, paramString.getMessage());
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      return;
      label637:
      i += 1;
      continue;
      label644:
      bool = false;
      continue;
      label650:
      bool = false;
      continue;
      label656:
      bool = false;
    }
  }
  
  public String b()
  {
    return "key_for_text_filter_cfg_version";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uul
 * JD-Core Version:    0.7.0.1
 */