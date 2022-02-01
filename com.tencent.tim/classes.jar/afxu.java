import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afxu
{
  public static aftp a(afua paramafua, Context paramContext)
  {
    if (paramafua == null) {}
    while ((paramafua.mGender != 1) && (paramafua.mGender != 2) && (paramafua.mAge == -1)) {
      return null;
    }
    aftp localaftp = new aftp();
    int i;
    String str;
    if (paramafua.mGender == 2)
    {
      i = 0;
      localaftp.type = i;
      if (paramafua.mAge != -1) {
        break label154;
      }
      str = "";
      label66:
      localaftp.label = str;
      if ((paramafua.mGender == 1) || (paramafua.mGender == 2))
      {
        if (paramafua.mGender != 2) {
          break label165;
        }
        paramContext = paramContext.getResources().getDrawable(2130846015);
        label106:
        localaftp.icon = paramContext;
        if (paramafua.mGender != 2) {
          break label178;
        }
        paramContext = "#FF80BF";
        label123:
        localaftp.bFA = paramContext;
        if (paramafua.mGender != 2) {
          break label184;
        }
      }
    }
    label154:
    label165:
    label178:
    label184:
    for (paramafua = "#33FF80BF";; paramafua = "#3300CAFC")
    {
      localaftp.bFB = paramafua;
      return localaftp;
      i = 1;
      break;
      str = String.valueOf(paramafua.mAge);
      break label66;
      paramContext = paramContext.getResources().getDrawable(2130846016);
      break label106;
      paramContext = "#02B2DD";
      break label123;
    }
  }
  
  public static List<aftp> a(afua paramafua, Context paramContext)
  {
    if (paramafua == null) {
      return null;
    }
    if ((paramafua.mLabelInfos == null) || (paramafua.mLabelInfos.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramContext.getResources().getStringArray(2130968662);
    paramContext = paramContext.getResources().getStringArray(2130968661);
    int i = 0;
    while (i < paramafua.mLabelInfos.size())
    {
      aftp localaftp = new aftp();
      localaftp.icon = null;
      localaftp.type = 3;
      localaftp.label = ((afua.a)paramafua.mLabelInfos.get(i)).labelName;
      if (TextUtils.isEmpty(localaftp.label))
      {
        i += 1;
      }
      else
      {
        if (TextUtils.isEmpty(localaftp.label)) {}
        for (int j = 0;; j = localaftp.label.charAt(0))
        {
          localaftp.bFA = arrayOfString[(j % arrayOfString.length)];
          localaftp.bFB = paramContext[(j % paramContext.length)];
          localArrayList.add(localaftp);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static List<xiy.a> a(Context paramContext, JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = paramContext.getResources().getStringArray(2130968662);
        paramContext = paramContext.getResources().getStringArray(2130968661);
        int k = paramJSONArray.length();
        i = 0;
        if (i < k)
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            xiy.a locala = new xiy.a();
            locala.J = localJSONObject.optString("tagName");
            int j;
            if (TextUtils.isEmpty(locala.J))
            {
              j = 0;
              locala.textColor = Color.parseColor(arrayOfString[(j % arrayOfString.length)]);
              locala.bgColor = Color.parseColor(paramContext[(j % paramContext.length)]);
              localArrayList.add(locala);
            }
            else
            {
              j = locala.J.charAt(0);
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (JSONException paramContext) {}
      i += 1;
    }
  }
  
  public static aftp b(afua paramafua, Context paramContext)
  {
    if (paramafua == null) {
      return null;
    }
    aftp localaftp = new aftp();
    localaftp.type = 2;
    localaftp.label = String.valueOf(paramafua.mPopularity);
    localaftp.bFA = "#8173FF";
    localaftp.bFB = "#338173FF";
    localaftp.icon = paramContext.getResources().getDrawable(2130846017);
    return localaftp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxu
 * JD-Core Version:    0.7.0.1
 */