import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class ajph
{
  public static final String[] dS = { acfp.m(2131708954), "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
  public static final String[] dT = { acfp.m(2131708966), acfp.m(2131708971), acfp.m(2131708968), acfp.m(2131708955), acfp.m(2131708956), acfp.m(2131708961), acfp.m(2131708970), acfp.m(2131708959), acfp.m(2131708952), acfp.m(2131708957), acfp.m(2131708967), acfp.m(2131708950), acfp.m(2131708964) };
  public static final String[] fw = { acfp.m(2131708962), acfp.m(2131708949), acfp.m(2131708958), acfp.m(2131708960), acfp.m(2131708965), acfp.m(2131708951), acfp.m(2131708969), acfp.m(2131708953) };
  public static final int[] lT = { 0, 2130846483, 2130846479, 2130846478, 2130846484, 2130846481, 2130846482, 2130846480 };
  public static final int[] lU = { 0, 1, 2, 3 };
  public int age;
  public String bRX = "不限";
  public int career;
  public String city = "不限";
  public String country = "不限";
  public boolean cpF;
  public int dke;
  public int dkf;
  public String[] fx = { "0", "0", "0", "0" };
  public int gender = 0;
  public String province = "不限";
  public int time = 4;
  
  public static ajph a(String paramString)
  {
    return a(paramString, "nearpeople_filters");
  }
  
  public static ajph a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        return null;
        paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString2 + paramString1, 4);
      } while (paramString1 == null);
      paramString2 = new ajph();
      paramString2.gender = paramString1.getInt("gender", -1);
    } while (paramString2.gender == -1);
    paramString2.cpF = paramString1.getBoolean("byuser", false);
    paramString2.age = paramString1.getInt("age", 0);
    paramString2.dke = paramString1.getInt("interest", 0);
    paramString2.time = paramString1.getInt("time", 3);
    paramString2.dkf = paramString1.getInt("xingzuo", 0);
    paramString2.career = paramString1.getInt("key_career", 0);
    paramString2.fx[0] = paramString1.getString("key_hometown_country", "0");
    paramString2.fx[1] = paramString1.getString("key_hometown_province", "0");
    paramString2.fx[2] = paramString1.getString("key_hometown_city", "0");
    paramString2.bRX = paramString1.getString("key_hometown_string", "不限");
    paramString2.country = paramString1.getString("str_country", "不限");
    paramString2.province = paramString1.getString("str_province", "不限");
    paramString2.city = paramString1.getString("str_city", "不限");
    if ("-1".equals(paramString2.fx[0])) {
      paramString2.fx[0] = "0";
    }
    if ("-1".equals(paramString2.fx[1])) {
      paramString2.fx[1] = "0";
    }
    if ("-1".equals(paramString2.fx[2])) {
      paramString2.fx[2] = "0";
    }
    return paramString2;
  }
  
  public static void a(String paramString, ajph paramajph)
  {
    a(paramString, paramajph, "nearpeople_filters");
  }
  
  public static void a(String paramString1, ajph paramajph, String paramString2)
  {
    if ((paramajph == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString2 + paramString1, 4);
    } while (paramString1 == null);
    paramString1.edit().putBoolean("byuser", paramajph.cpF).putInt("gender", paramajph.gender).putInt("time", paramajph.time).putInt("age", paramajph.age).putInt("xingzuo", paramajph.dkf).putInt("key_career", paramajph.career).putString("key_hometown_country", paramajph.fx[0]).putString("key_hometown_province", paramajph.fx[1]).putString("key_hometown_city", paramajph.fx[2]).putString("key_hometown_string", paramajph.bRX).putString("str_country", paramajph.country).putString("str_province", paramajph.province).putString("str_city", paramajph.city).putInt("interest", paramajph.dke).commit();
  }
  
  public boolean equals(Object paramObject)
  {
    int i = 0;
    boolean bool1;
    if ((paramObject == null) || (!(paramObject instanceof ajph)))
    {
      bool1 = false;
      return bool1;
    }
    paramObject = (ajph)paramObject;
    if ((this.gender == paramObject.gender) && ((this.time == paramObject.time) || (((this.time == 4) || (this.time == 3)) && ((paramObject.time == 4) || (paramObject.time == 3)))) && (this.age == paramObject.age) && (this.dkf == paramObject.dkf) && (this.career == paramObject.career) && (this.dke == paramObject.dke)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i >= 3) {
          break;
        }
        bool2 &= this.fx[i].equalsIgnoreCase(paramObject.fx[i]);
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("筛选：");
    String str1;
    int i;
    switch (this.gender)
    {
    case 0: 
    default: 
      if ((this.age != 0) && (this.age < dS.length)) {
        localStringBuilder.append(dS[this.age]).append(',');
      }
      if ((this.dke != 0) && (this.dke < fw.length)) {
        localStringBuilder.append(fw[this.dke]).append(',');
      }
      if ((this.career != 0) && (this.career < aqek.cq.length))
      {
        String str2 = aqek.cq[this.career];
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = acfp.m(2131708963);
        }
        localStringBuilder.append(str1).append(',');
      }
      if ((!TextUtils.isEmpty(this.bRX)) && (!this.bRX.equals("不限")))
      {
        i = this.bRX.lastIndexOf("-");
        if (i > 0)
        {
          str1 = this.bRX.substring(i + 1);
          label223:
          localStringBuilder.append(str1).append(',');
        }
      }
      else
      {
        if ((this.dkf != 0) && (this.dkf < dT.length)) {
          localStringBuilder.append(dT[this.dkf]).append(',');
        }
        switch (this.time)
        {
        }
      }
      break;
    }
    for (;;)
    {
      str1 = localStringBuilder.toString();
      if (TextUtils.isEmpty(str1)) {
        break label422;
      }
      i = localStringBuilder.lastIndexOf(",");
      if (i <= 0) {
        break label422;
      }
      return str1.substring(0, i);
      localStringBuilder.append("男,");
      break;
      localStringBuilder.append("女,");
      break;
      str1 = this.bRX;
      break label223;
      localStringBuilder.append("30分钟内,");
      continue;
      localStringBuilder.append("1个小时内,");
      continue;
      localStringBuilder.append("4小时内,");
      continue;
      localStringBuilder.append("8小时内,");
    }
    label422:
    return "全部";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajph
 * JD-Core Version:    0.7.0.1
 */