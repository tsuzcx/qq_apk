import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class apha
{
  private boolean cQv;
  private boolean cQw;
  private String cpd = "";
  private String cpe = "";
  private String cpf = "";
  private String cpg = "";
  
  public apha() {}
  
  public apha(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, String paramString4)
  {
    this.cQv = paramBoolean1;
    this.cQw = paramBoolean2;
    this.cpd = paramString1;
    this.cpe = paramString2;
    this.cpf = paramString3;
    this.cpg = paramString4;
  }
  
  public static apha a(aeic[] paramArrayOfaeic)
  {
    localObject2 = "";
    localObject1 = "";
    localObject3 = "";
    Object localObject9 = "";
    int n = 0;
    i = 0;
    int k = 0;
    if (n < paramArrayOfaeic.length)
    {
      Object localObject4 = paramArrayOfaeic[n].content;
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject7 = localObject9;
        localObject6 = localObject3;
      }
      for (;;)
      {
        n += 1;
        localObject3 = localObject6;
        localObject9 = localObject7;
        break;
        m = k;
        try
        {
          localJSONObject1 = new JSONObject((String)localObject4);
          m = k;
          j = localJSONObject1.optInt("globalOpen", 0);
          m = j;
          k = localJSONObject1.optInt("globalOpenTXDoc", 0);
          m = k;
          localObject8 = localObject2;
          localObject7 = localObject1;
          localObject6 = localObject3;
        }
        catch (JSONException localJSONException1)
        {
          try
          {
            localJSONObject2 = localJSONObject1.optJSONObject("weikeUrls");
            localObject5 = localObject2;
            localObject4 = localObject1;
            if (localJSONObject2 != null)
            {
              localObject8 = localObject2;
              localObject7 = localObject1;
              localObject6 = localObject3;
              localObject2 = localJSONObject2.optString("choose_exam");
            }
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              JSONObject localJSONObject1;
              int j;
              Object localObject8;
              JSONObject localJSONObject2;
              Object localObject5;
              boolean bool1;
              boolean bool2;
              i = m;
              localObject2 = localObject8;
              localObject1 = localObject7;
              localObject3 = localObject6;
            }
          }
          try
          {
            localObject4 = localJSONObject2.optString("get_exam_info");
            localObject5 = localObject2;
            localObject8 = localObject5;
            localObject7 = localObject4;
            localObject6 = localObject3;
            localJSONObject1 = localJSONObject1.optJSONObject("txDocUrls");
            i = m;
            k = j;
            localObject2 = localObject5;
            localObject1 = localObject4;
            localObject6 = localObject3;
            localObject7 = localObject9;
            if (localJSONObject1 == null) {
              continue;
            }
            localObject8 = localObject5;
            localObject7 = localObject4;
            localObject6 = localObject3;
            localObject3 = localJSONObject1.optString("choose_doc");
            localObject8 = localObject5;
            localObject7 = localObject4;
            localObject6 = localObject3;
            localObject1 = localJSONObject1.optString("get_doc_info");
            localObject7 = localObject1;
            i = m;
            k = j;
            localObject2 = localObject5;
            localObject1 = localObject4;
            localObject6 = localObject3;
          }
          catch (JSONException localJSONException3)
          {
            i = m;
            break label299;
          }
          localJSONException1 = localJSONException1;
          j = m;
        }
        label299:
        localJSONException1.printStackTrace();
        k = j;
        localObject6 = localObject3;
        localObject7 = localObject9;
      }
    }
    if (k == 1)
    {
      bool1 = true;
      if (i != 1) {
        break label377;
      }
    }
    label377:
    for (bool2 = true;; bool2 = false)
    {
      paramArrayOfaeic = new apha(bool1, (String)localObject2, (String)localObject1, bool2, (String)localObject3, (String)localObject9);
      if (QLog.isColorLevel()) {
        QLog.i("PublishHwkThirdPartyEntryConfig", 2, paramArrayOfaeic.toString());
      }
      return paramArrayOfaeic;
      bool1 = false;
      break;
    }
  }
  
  public String Bk()
  {
    return this.cpd;
  }
  
  public String Bl()
  {
    return this.cpe;
  }
  
  public String Bm()
  {
    return this.cpf;
  }
  
  public String Bn()
  {
    return this.cpg;
  }
  
  public boolean aBa()
  {
    return this.cQv;
  }
  
  public boolean aBb()
  {
    return this.cQw;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsGlobalOpenWeiKe:").append(this.cQv).append("\r\n");
    localStringBuilder.append("mIsGlobalOpenTXDoc:").append(this.cQw).append("\r\n");
    localStringBuilder.append("mStrSelectWeiKeUrl:").append(this.cpd).append("\r\n");
    localStringBuilder.append("mStrDetailWeiKeUrl:").append(this.cpe).append("\r\n");
    localStringBuilder.append("mStrSelectDocUrl:").append(this.cpf).append("\r\n");
    localStringBuilder.append("mStrDetailDocUrl:").append(this.cpg).append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apha
 * JD-Core Version:    0.7.0.1
 */