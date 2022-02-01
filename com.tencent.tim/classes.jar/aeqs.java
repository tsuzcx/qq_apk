import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aeqs
{
  @NonNull
  public final aeqs.a a;
  @NonNull
  public final aeqs.a b;
  @NonNull
  public final aeqs.a c;
  
  private aeqs()
  {
    this(a(null, ""), a(null, ""), a(null, ""));
  }
  
  private aeqs(aeqs.a parama1, aeqs.a parama2, aeqs.a parama3)
  {
    this.a = parama1;
    this.b = parama2;
    this.c = parama3;
    if (QLog.isColorLevel()) {
      QLog.d("KC.ConfigProcessor", 1, toString());
    }
  }
  
  @NonNull
  private static aeqs.a a(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = false;
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        Object localObject = paramJSONObject.optJSONObject(paramString);
        paramJSONObject = ((JSONObject)localObject).optString("content", null);
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("keyWords");
        localObject = ((JSONObject)localObject).optJSONArray("actionUrls");
        String[] arrayOfString1 = new String[localJSONArray.length()];
        String[] arrayOfString2 = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString1[i] = localJSONArray.optString(i, null);
          arrayOfString2[i] = ((JSONArray)localObject).optString(i, null);
          i += 1;
        }
        if (paramJSONObject != null) {
          bool = true;
        }
        paramJSONObject = new aeqs.a(paramString, bool, paramJSONObject, arrayOfString1, arrayOfString2);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("KC.ConfigProcessor", 1, "json parse error:" + paramJSONObject);
      }
    }
    return new aeqs.a();
  }
  
  @NonNull
  public static aeqs a()
  {
    return new aeqs();
  }
  
  @NonNull
  public static aeqs a(@Nullable String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        return new aeqs(a(paramString, "AIO"), a(paramString, "group"), a(paramString, "download"));
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("KC.ConfigProcessor", 1, "json parse error:" + paramString);
        paramString = null;
      }
    }
  }
  
  public String toString()
  {
    return "KingCardConfig{aio=" + this.a + ", group=" + this.b + ", download=" + this.c + '}';
  }
  
  public static class a
  {
    private final String bAA;
    private final String bAz;
    private final String content;
    private final String[] eH;
    private final String[] eI;
    public final boolean enable;
    private final String type;
    
    public a()
    {
      this.type = "";
      this.enable = false;
      this.content = null;
      this.eH = null;
      this.eI = null;
      this.bAz = null;
      this.bAA = null;
    }
    
    public a(String paramString1, boolean paramBoolean, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      this.type = paramString1;
      this.enable = paramBoolean;
      this.content = paramString2;
      this.eH = paramArrayOfString1;
      this.eI = paramArrayOfString2;
      if ("AIO".equals(paramString1))
      {
        this.bAz = "0X800A647";
        this.bAA = "0X800A648";
        return;
      }
      if ("group".equals(paramString1))
      {
        this.bAz = "0X800A649";
        this.bAA = "0X800A64A";
        return;
      }
      if ("download".equals(paramString1))
      {
        this.bAz = "0X800A64B";
        this.bAA = "0X800A64C";
        return;
      }
      this.bAz = null;
      this.bAA = null;
    }
    
    public SpannableString a(Context paramContext, CharSequence paramCharSequence)
    {
      paramCharSequence = paramCharSequence + this.content;
      SpannableString localSpannableString = new SpannableString(paramCharSequence);
      int i = 0;
      if (i < this.eH.length)
      {
        String str1 = this.eH[i];
        String str2 = this.eI[i];
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {}
        for (;;)
        {
          i += 1;
          break;
          int j = paramCharSequence.indexOf(this.eH[i]);
          localSpannableString.setSpan(new aeqt(this, str2, paramContext), j, str1.length() + j, 33);
        }
      }
      anot.a(null, "dc00898", "", "", this.bAz, this.bAz, 2, 0, "", "", "", "");
      return localSpannableString;
    }
    
    public void cXo()
    {
      anot.a(null, "dc00898", "", "", this.bAA, this.bAA, 2, 0, "", "", "", "");
    }
    
    public String tG()
    {
      if ((this.eI == null) || (this.eI.length <= 0)) {
        return "";
      }
      anot.a(null, "dc00898", "", "", this.bAz, this.bAz, 2, 0, "", "", "", "");
      return this.eI[0];
    }
    
    public String toString()
    {
      return "Item{enable=" + this.enable + ", content='" + this.content + '\'' + ", keyWords=" + Arrays.toString(this.eH) + ", actionUrls=" + Arrays.toString(this.eI) + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqs
 * JD-Core Version:    0.7.0.1
 */