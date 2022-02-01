import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aeur
{
  private String bBQ = "";
  private String bBR = "";
  private String bBn = "";
  private String bBo = "";
  private String bBp = "";
  private String bBq = "";
  private boolean bWu;
  private int cPf;
  private int cPg;
  private int cPh;
  private int cPn;
  private int cPo;
  private SparseArray<aeur.a> ct = new SparseArray();
  private double cw;
  private Map<String, String> ka = new HashMap();
  private Map<String, aeur.a> kb = new HashMap();
  private Map<String, String> kc = new HashMap();
  private int mMaxCount;
  private List<aeur.b> za = new ArrayList();
  
  public static aeur a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    Object localObject1 = paramArrayOfaeic[0].content;
    paramArrayOfaeic = new aeur();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocTipsConfigBean", 2, "updateConfig json parse faild");
      }
      return paramArrayOfaeic;
    }
    JSONObject localJSONObject2;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    String str1;
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      localJSONObject2 = ((JSONObject)localObject1).optJSONObject("File");
      paramArrayOfaeic.mMaxCount = localJSONObject2.optInt("maxCount");
      paramArrayOfaeic.cPf = localJSONObject2.optInt("insertDur");
      localObject2 = localJSONObject2.optJSONObject("fileType");
      localObject3 = new StringBuilder();
      localObject4 = ((JSONObject)localObject2).keys();
      localObject5 = new StringBuilder();
      while (((Iterator)localObject4).hasNext())
      {
        str1 = (String)((Iterator)localObject4).next();
        ((StringBuilder)localObject3).append(str1).append("|");
        String str2 = ((JSONObject)localObject2).getString(str1);
        paramArrayOfaeic.ka.put("fileType_" + str1, str2);
        ((StringBuilder)localObject5).append(str2).append("|");
        aeur.a locala = new aeur.a();
        locala.eJ = n(str2);
        paramArrayOfaeic.kb.put(str1, locala);
        continue;
        return paramArrayOfaeic;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TencentDocTipsConfigBean", 2, localException.toString());
      localException.printStackTrace();
    }
    JSONObject localJSONObject1;
    do
    {
      if (((StringBuilder)localObject5).length() > 0) {
        ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
      }
      if (((StringBuilder)localObject3).length() > 0) {
        ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
      }
      paramArrayOfaeic.bBn = ((StringBuilder)localObject3).toString();
      paramArrayOfaeic.bBo = ((StringBuilder)localObject5).toString();
      localObject2 = localJSONObject2.optJSONObject("Similarity");
      paramArrayOfaeic.cPn = ((JSONObject)localObject2).optInt("durTime");
      paramArrayOfaeic.cPo = ((JSONObject)localObject2).optInt("maxQuery");
      paramArrayOfaeic.cw = ((JSONObject)localObject2).getDouble("Percentage");
      paramArrayOfaeic.bBQ = ((JSONObject)localObject2).optString("Tips");
      paramArrayOfaeic.bBR = ((JSONObject)localObject2).optString("Link");
      localJSONObject2 = localJSONObject2.optJSONObject("KeyWords");
      localObject2 = paramArrayOfaeic.kb.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = localJSONObject2.optJSONObject((String)localObject3);
        localObject5 = (aeur.a)paramArrayOfaeic.kb.get(localObject3);
        str1 = ((JSONObject)localObject4).optString("key");
        ((aeur.a)localObject5).eH = n(str1);
        if (paramArrayOfaeic.cPg == 1) {
          ((aeur.a)localObject5).strTips = ((JSONObject)localObject4).optString("Tips1");
        }
        for (((aeur.a)localObject5).bBr = ((JSONObject)localObject4).optString("Link1");; ((aeur.a)localObject5).bBr = ((JSONObject)localObject4).optString("Link0"))
        {
          paramArrayOfaeic.kb.put(localObject3, localObject5);
          paramArrayOfaeic.kc.put("key_str_key_words" + (String)localObject3, str1);
          paramArrayOfaeic.kc.put("key_str_key_tips" + (String)localObject3, ((aeur.a)localObject5).strTips);
          paramArrayOfaeic.kc.put("key_str_key_link" + (String)localObject3, ((aeur.a)localObject5).bBr);
          break;
          ((aeur.a)localObject5).strTips = ((JSONObject)localObject4).optString("Tips0");
        }
      }
      localJSONObject1 = localException.optJSONObject("Text");
    } while (localJSONObject1 == null);
    paramArrayOfaeic.bBp = localJSONObject1.toString();
    if (localJSONObject1.optInt("textSwitch", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfaeic.bWu = bool;
      a(localJSONObject1, paramArrayOfaeic);
      break;
    }
  }
  
  private static void a(JSONObject paramJSONObject, aeur paramaeur)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("template_list");
    int i = 0;
    if (i < localJSONArray.length())
    {
      int k = localJSONArray.getJSONObject(i).optInt("template_type", -1);
      aeur.a locala = new aeur.a();
      paramaeur.cPh = paramJSONObject.optInt("containKeyword");
      if (paramaeur.cPh == 1) {
        locala.strTips = paramJSONObject.optString("Tips1");
      }
      for (locala.bBr = paramJSONObject.optString("Link1");; locala.bBr = paramJSONObject.optString("Link0"))
      {
        int j = k;
        if (k == -1) {
          j = i;
        }
        paramaeur.ct.put(j, locala);
        i += 1;
        break;
        locala.strTips = paramJSONObject.optString("Tips0");
      }
    }
  }
  
  private static String[] n(String paramString)
  {
    int i = 0;
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "|");
    if (!localStringTokenizer.hasMoreTokens())
    {
      if (QLog.isColorLevel()) {
        QLog.i("TencentDocTipsConfigBean", 1, "split String faild :" + paramString);
      }
      return new String[0];
    }
    paramString = new String[localStringTokenizer.countTokens()];
    while (localStringTokenizer.hasMoreTokens())
    {
      paramString[i] = localStringTokenizer.nextToken();
      i += 1;
    }
    return paramString;
  }
  
  public int CC()
  {
    return this.cPn;
  }
  
  public int Cx()
  {
    return this.cPf;
  }
  
  public void Hv(boolean paramBoolean)
  {
    this.bWu = paramBoolean;
  }
  
  public Map<String, aeur.a> ah()
  {
    return this.kb;
  }
  
  public boolean aic()
  {
    return this.bWu;
  }
  
  public void bc(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      localObject = "";
      this.bBq = ((String)localObject);
      if (paramJSONObject != null) {
        break label33;
      }
      this.bWu = false;
    }
    for (;;)
    {
      return;
      localObject = paramJSONObject.toString();
      break;
      try
      {
        label33:
        localObject = paramJSONObject.optJSONArray("template_list");
        if (paramJSONObject.optInt("retcode", -1) != 0)
        {
          this.bWu = false;
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("TencentDocTipsConfigBean", 2, paramJSONObject.toString());
        return;
      }
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramJSONObject = ((JSONArray)localObject).getJSONObject(i);
          int k = paramJSONObject.optInt("template_type", -1);
          if (paramJSONObject.optJSONArray("infos") != null)
          {
            paramJSONObject = paramJSONObject.optJSONArray("infos");
            int j = 0;
            while (j < paramJSONObject.length())
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(j);
              aeur.b localb = new aeur.b();
              localb.keyword = localJSONObject.optString("template_name");
              localb.templateId = localJSONObject.optInt("template_id", -1);
              if (localb.templateId == -1) {
                QLog.d("TencentDocTipsConfigBean", 2, "template has no id");
              }
              localb.templateType = k;
              this.za.add(localb);
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public List<aeur.b> et()
  {
    return this.za;
  }
  
  public int getMaxCount()
  {
    return this.mMaxCount;
  }
  
  public SparseArray<aeur.a> h()
  {
    return this.ct;
  }
  
  public String tW()
  {
    return this.bBo;
  }
  
  public String tX()
  {
    return this.bBp;
  }
  
  public String uf()
  {
    return this.bBQ;
  }
  
  public String ug()
  {
    return this.bBR;
  }
  
  public double w()
  {
    return this.cw;
  }
  
  public static class a
  {
    public String bBr;
    public String[] eH;
    public String[] eJ;
    public String strTips;
  }
  
  public static class b
  {
    public String keyword;
    public int templateId = -1;
    public int templateType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeur
 * JD-Core Version:    0.7.0.1
 */