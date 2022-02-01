import android.text.TextUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "adData", "Lorg/json/JSONObject;", "resInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "needReport", "", "scene", "", "(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;ZI)V", "getAdData", "()Lorg/json/JSONObject;", "adId", "", "configFile", "Ljava/io/File;", "manifestJson", "getNeedReport", "()Z", "getResInfo", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "resPath", "resVersion", "getScene", "()I", "checkManifest", "checkMaskType", "checkResFile", "checkVersion", "doStep", "AdResCheckInfo", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ujp
  extends ujc
{
  public static final ujr a;
  private final int jdField_a_of_type_Int;
  private final File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  @Nullable
  private final ujq jdField_a_of_type_Ujq;
  private final boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  @Nullable
  private final JSONObject jdField_b_of_type_OrgJsonJSONObject;
  
  static
  {
    jdField_a_of_type_Ujr = new ujr(null);
  }
  
  public ujp(@Nullable JSONObject paramJSONObject, @Nullable ujq paramujq, boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_Ujq = paramujq;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt;
    paramJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("res_path");
      if (paramJSONObject != null)
      {
        this.jdField_a_of_type_JavaLangString = paramJSONObject;
        this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaLangString, "manifest.json");
        paramJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
        if (paramJSONObject == null) {
          break label217;
        }
        paramJSONObject = paramJSONObject.optString("adid");
        if (paramJSONObject == null) {
          break label217;
        }
        label90:
        this.jdField_b_of_type_JavaLangString = paramJSONObject;
        paramJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
        if (paramJSONObject == null) {
          break label223;
        }
        paramInt = paramJSONObject.optInt("res_version");
        label112:
        this.jdField_a_of_type_Int = paramInt;
        if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString))
        {
          paramJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
          if (paramJSONObject == null) {
            break label229;
          }
          paramJSONObject = paramJSONObject.optString("ad_source");
          if (paramJSONObject == null) {
            break label229;
          }
          label151:
          paramujq = this.jdField_b_of_type_OrgJsonJSONObject;
          if (paramujq == null) {
            break label235;
          }
        }
      }
    }
    label217:
    label223:
    label229:
    label235:
    for (paramujq = paramujq.optString("adid");; paramujq = null)
    {
      JSONObject localJSONObject = this.jdField_b_of_type_OrgJsonJSONObject;
      paramInt = i;
      if (localJSONObject != null) {
        paramInt = localJSONObject.optInt("res_version");
      }
      paramJSONObject = uic.a(paramJSONObject, paramujq, paramInt);
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "AdMaterialResManager.obt…kConfig.resVersion) ?: 1)");
      this.jdField_a_of_type_JavaLangString = paramJSONObject;
      return;
      paramJSONObject = "";
      break;
      paramJSONObject = "";
      break label90;
      paramInt = 1;
      break label112;
      paramJSONObject = "";
      break label151;
    }
  }
  
  private final boolean b()
  {
    b("checkVersion");
    if (this.jdField_b_of_type_OrgJsonJSONObject == null)
    {
      ukq.a("ReadInJoySuperMaskAd", a() + " : ResCheckStep : checkVersion : adData is empty");
      return false;
    }
    if (this.jdField_a_of_type_Ujq == null)
    {
      ukq.a("ReadInJoySuperMaskAd", a() + " : ResCheckStep : checkVersion : resInfo is empty");
      return false;
    }
    String str1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("adid");
    String str2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("ad_source");
    int i = this.jdField_b_of_type_OrgJsonJSONObject.optInt("res_version", -1);
    if ((Intrinsics.areEqual(str1, this.jdField_a_of_type_Ujq.a())) && (Intrinsics.areEqual(str2, this.jdField_a_of_type_Ujq.b())) && (i == this.jdField_a_of_type_Ujq.a())) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        if (this.jdField_a_of_type_Boolean) {
          ujg.a.a(this.jdField_b_of_type_OrgJsonJSONObject, false, "version not match", null, "resource_use_key");
        }
        if (this.jdField_b_of_type_Int == 2) {
          ujg.a(ujg.a, "versionNoMatch", null, 2, null);
        }
      }
      return ujt.a.a(bool, (ujc)this);
    }
  }
  
  private final boolean c()
  {
    b("checkManifest");
    if (this.jdField_b_of_type_OrgJsonJSONObject == null)
    {
      ukq.a("ReadInJoySuperMaskAd", a() + " : ResCheckStep : checkManifest : adData is empty");
      return false;
    }
    if ((this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.isFile()) && (this.jdField_a_of_type_JavaIoFile.canRead())) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        if (this.jdField_a_of_type_Boolean) {
          ujg.a.a(this.jdField_b_of_type_OrgJsonJSONObject, false, "no manifest", null, "resource_use_key");
        }
        if (this.jdField_b_of_type_Int == 2) {
          ujg.a(ujg.a, "noManifest", null, 2, null);
        }
        if (this.jdField_b_of_type_Int == 1) {
          ujg.a.a(this.jdField_b_of_type_JavaLangString, "noManifest", this.jdField_a_of_type_Int);
        }
      }
      return ujt.a.a(bool, (ujc)this);
    }
  }
  
  private final boolean d()
  {
    b("checkResFile");
    if (this.jdField_b_of_type_OrgJsonJSONObject == null) {
      ukq.a("ReadInJoySuperMaskAd", a() + " : ResCheckStep : checkResFile : adData is empty");
    }
    Object localObject;
    for (;;)
    {
      return false;
      String str = this.jdField_b_of_type_OrgJsonJSONObject.optString("animFileName");
      if (this.jdField_b_of_type_Int != 1)
      {
        localObject = str;
        if (!TextUtils.isEmpty((CharSequence)str)) {}
      }
      else
      {
        long l1 = System.currentTimeMillis();
        localObject = new StringBuffer();
        fd.a((StringBuffer)localObject, this.jdField_a_of_type_JavaIoFile.getPath());
        localObject = ((StringBuffer)localObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "buffer.toString()");
        long l2 = System.currentTimeMillis();
        ukq.a("ReadInJoySuperMaskAd", a() + " : ResCheckStep : checkResFile : readTime = " + (l2 - l1));
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject((String)localObject);
        localObject = this.jdField_a_of_type_OrgJsonJSONObject;
        if (localObject == null) {
          break label312;
        }
        localObject = ((JSONObject)localObject).optString("animFileName");
        if (localObject == null) {
          break label312;
        }
      }
      try
      {
        for (;;)
        {
          this.jdField_b_of_type_OrgJsonJSONObject.put("animFileName", localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label367;
          }
          if (this.jdField_a_of_type_Boolean) {
            ujg.a.a(this.jdField_b_of_type_OrgJsonJSONObject, false, "no animFileName", null, "resource_use_key");
          }
          ukq.a("ReadInJoySuperMaskAd", a() + " : ResCheckStep : checkResFile : animFileName is empty");
          if (this.jdField_b_of_type_Int == 2) {
            ujg.a(ujg.a, "noFileName", null, 2, null);
          }
          if (this.jdField_b_of_type_Int != 1) {
            break;
          }
          ujg.a.a(this.jdField_b_of_type_JavaLangString, "noFileName", this.jdField_a_of_type_Int);
          return false;
          label312:
          localObject = "";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          StringBuilder localStringBuilder = new StringBuilder().append(a()).append(" : checkResFile, adData put animFileName fail been catch : ");
          localException.printStackTrace();
          ukq.a("ReadInJoySuperMaskAd", Unit.INSTANCE);
        }
        label367:
        localObject = new File(this.jdField_a_of_type_JavaLangString, (String)localObject);
        if (!((File)localObject).exists()) {
          break label496;
        }
      }
    }
    if ((((File)localObject).isFile()) && (((File)localObject).canRead())) {}
    label496:
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        if (this.jdField_a_of_type_Boolean) {
          ujg.a.a(this.jdField_b_of_type_OrgJsonJSONObject, false, "supermask path not exist", null, "resource_use_key");
        }
        if (this.jdField_b_of_type_Int == 2) {
          ujg.a(ujg.a, "noVideoFile", null, 2, null);
        }
        if (this.jdField_b_of_type_Int == 1) {
          ujg.a.a(this.jdField_b_of_type_JavaLangString, "noVideoFile", this.jdField_a_of_type_Int);
        }
      }
      return ujt.a.a(bool, (ujc)this);
    }
  }
  
  private final boolean e()
  {
    b("checkMaskType");
    if (this.jdField_b_of_type_OrgJsonJSONObject == null)
    {
      ukq.a("ReadInJoySuperMaskAd", a() + " : ResCheckStep : checkMaskType : adData is empty");
      return false;
    }
    int i;
    if (this.jdField_b_of_type_Int == 1)
    {
      JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (localJSONObject != null) {
        i = localJSONObject.optInt("superMaskType", 1);
      }
    }
    for (;;)
    {
      boolean bool;
      try
      {
        this.jdField_b_of_type_OrgJsonJSONObject.put("superMaskType", i);
        if (i == 1) {
          break label248;
        }
        bool = true;
        if (!bool)
        {
          if (this.jdField_a_of_type_Boolean) {
            ujg.a.a(this.jdField_b_of_type_OrgJsonJSONObject, false, "ReadInJoySuperMaskAdUtil.MASK_APNG || maskType == 0", null, "resource_use_key");
          }
          if (this.jdField_b_of_type_Int == 2) {
            ujg.a(ujg.a, "invalidType", null, 2, null);
          }
          if (this.jdField_b_of_type_Int == 1) {
            ujg.a.a(this.jdField_b_of_type_JavaLangString, "invalidType", this.jdField_a_of_type_Int);
          }
        }
        return ujt.a.a(bool, (ujc)this);
        i = 1;
        continue;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(a()).append(" : checkResFile, adData put animFileName fail been catch : ");
        localException.printStackTrace();
        ukq.a("ReadInJoySuperMaskAd", Unit.INSTANCE);
        continue;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        i = this.jdField_b_of_type_OrgJsonJSONObject.optInt("superMaskType", 1);
        continue;
        label248:
        bool = false;
      }
      else
      {
        i = 1;
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (b())
      {
        bool1 = bool2;
        if (c())
        {
          bool1 = bool2;
          if (d())
          {
            boolean bool3 = e();
            bool1 = bool2;
            if (bool3) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujp
 * JD-Core Version:    0.7.0.1
 */