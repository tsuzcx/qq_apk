import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class aynb
{
  private static final Set<Integer> dD = new HashSet(5);
  private static final Set<Integer> dE = new HashSet(5);
  
  static
  {
    dD.add(Integer.valueOf(4));
    dD.add(Integer.valueOf(5));
    dD.add(Integer.valueOf(9));
    dD.add(Integer.valueOf(10));
    dE.add(Integer.valueOf(9));
    dE.add(Integer.valueOf(10));
  }
  
  public static int a(ayna.c paramc)
  {
    int j = 0;
    int i = j;
    switch (paramc.eKF)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "check num of download dir:" + i);
      }
      return i;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 14;
      continue;
      i = 1;
      continue;
      i = 33;
      continue;
      i = 5;
      continue;
      i = 2;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public static BitmapDrawable a(String paramString1, Context paramContext, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("InformationFaceConstant", 2, "to be parsed" + paramString1);
      }
      localJSONObject = new JSONObject(paramString1);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        if (QLog.isColorLevel()) {
          QLog.e("InformationFaceConstant", 2, localJSONException, new Object[0]);
        }
        localObject = null;
      }
      i = localObject.optInt("type", 0);
      switch (i)
      {
      case 6: 
      case 7: 
      case 8: 
      case 11: 
      default: 
        paramString1 = null;
      }
    }
    if (localJSONObject == null) {}
    for (;;)
    {
      return null;
      Object localObject;
      int i;
      while (paramString1 != null)
      {
        return new BitmapDrawable(paramContext.getResources(), paramString1.ba());
        paramString1 = new ayoe(paramContext, paramString1).G(paramString1);
        paramString1 = new ayoe(paramContext, ayoe.a(i, paramString1[0], paramString2, paramString1[2]));
        continue;
        paramString1 = new aynv(paramContext, paramString1).G(paramString1);
        paramString1 = new aynv(paramContext, aynv.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
        continue;
        paramString1 = new aynz(paramContext, aynz.S(i, new aynz(paramContext, paramString1).G(paramString1)[1]));
        continue;
        paramString1 = new aynx(paramContext, aynx.k(i, new aynx(paramContext, paramString1).G(paramString1)[0], paramString2));
        continue;
        paramString1 = new ayok(paramContext, paramString1).G(paramString1);
        paramString1 = new ayok(paramContext, ayok.a(i, paramString1[0], paramString1[1], paramString2));
      }
    }
  }
  
  public static ayob a(Context paramContext, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("InformationFaceConstant", 2, "to be parsed" + paramString);
      }
      localJSONObject = new JSONObject(paramString);
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      for (;;)
      {
        JSONObject localJSONObject;
        if (QLog.isColorLevel()) {
          QLog.e("InformationFaceConstant", 2, localJSONException, new Object[0]);
        }
        localObject = null;
      }
      switch (localObject.optInt("type", 0))
      {
      case 8: 
      default: 
        return null;
      case 1: 
        return new aynu(paramContext, paramString);
      case 2: 
        return new ayoh(paramContext, paramString);
      case 3: 
        return new ayof(paramContext, paramString);
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new ayoe(paramContext, paramString);
    return new aynv(paramContext, paramString);
    return new ayol(paramContext, paramString);
    return new aynt(paramContext, paramString);
    return new aynz(paramContext, paramString);
    return new aynx(paramContext, paramString);
    return new ayok(paramContext, paramString);
    return new ayns(paramContext, paramString);
  }
  
  public static ayob a(ayna.c paramc, Context paramContext, long paramLong)
  {
    int i = paramc.eKF;
    String str2;
    Object localObject;
    String str1;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new aynu(paramContext, aynu.a(i, axvz.cz(paramLong), axvz.cA(paramLong), axvz.cB(paramLong)));
    case 2: 
      return new ayoh(paramContext, ayoh.k(i, axvz.cy(paramLong), axvz.cx(paramLong)));
    case 3: 
      str2 = axsz.b(paramc);
      paramc = axvz.d(paramLong);
      localObject = str2 + File.separator + "eea02a45.ttf";
      str1 = str2 + File.separator + "outsideBorder.png";
      str2 = str2 + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + (String)localObject);
      }
      return new ayof(paramContext, ayof.a(i, paramc[2], paramc[3], paramc[0], paramc[1], (String)localObject, str1, str2));
    case 4: 
      str1 = axsz.b(paramc) + File.separator + "Roboto-Condensed.ttf";
      localObject = paramc.location;
      if (TextUtils.isEmpty(paramc.location)) {
        localObject = acfp.m(2131707413);
      }
      return new ayoe(paramContext, ayoe.a(i, axvz.cy(paramLong), (String)localObject, str1));
    case 5: 
      localObject = axsz.b(paramc);
      str1 = (String)localObject + File.separator + "Roboto-Condensed.ttf";
      str2 = (String)localObject + File.separator + "location_icon.png";
      localObject = paramc.location;
      if (TextUtils.isEmpty(paramc.location)) {
        localObject = acfp.m(2131707410);
      }
      return new aynv(paramContext, aynv.a(i, (String)localObject, axvz.cC(paramLong), str2, str1));
    case 6: 
      String str4 = axsz.b(paramc);
      localObject = str4 + File.separator + "DINCond-Medium.ttf";
      str1 = str4 + File.separator + paramc.cXi + ".apng";
      str2 = str4 + File.separator + "temperatureSymbol.png";
      String str3 = paramc.auX;
      str4 = str4 + File.separator + "line.png";
      int j = paramc.temperature;
      if (paramc.eGY == 3) {}
      for (boolean bool = true;; bool = false) {
        return new ayol(paramContext, ayol.a(i, j, str1, str3, str2, (String)localObject, str4, bool));
      }
    case 7: 
      paramc = axsz.b(paramc);
      return new aynt(paramContext, aynt.S(i, paramc + File.separator + "city.bpng"));
    case 12: 
      return new aynz(paramContext, aynz.S(i, axvz.cD(paramLong)));
    case 9: 
      str1 = paramc.location;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "YOUR CITY";
      }
      return new aynx(paramContext, aynx.k(i, axsz.b(paramc) + File.separator + "location3_icon_3x.png", (String)localObject));
    case 10: 
      localObject = paramc.location;
      return new ayok(paramContext, ayok.a(i, axsz.b(paramc) + File.separator + "location4_icon.png", axsz.b(paramc) + File.separator + "lantingzhonghei.ttf", (String)localObject));
    }
    return new ayns(paramContext, ayns.a(i, axsz.b(paramc) + File.separator + "up.png", axsz.b(paramc) + File.separator + "down.png", axvz.cE(paramLong), axvz.cF(paramLong)));
  }
  
  public static ayob a(ayob paramayob, Context paramContext, String paramString)
  {
    switch (paramayob.getType())
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return null;
    case 1: 
      return new aynu(paramContext, aynu.a(paramayob.getType(), axvz.cz(-1L), axvz.cA(-1L), axvz.cB(-1L)));
    case 2: 
      return new ayoh(paramContext, ayoh.k(paramayob.getType(), axvz.cy(-1L), axvz.cx(-1L)));
    case 4: 
      paramayob = (ayoe)paramayob;
      return new ayoe(paramContext, ayoe.a(paramayob.getType(), paramayob.IA(), paramString, paramayob.Gz()));
    case 5: 
      paramayob = (aynv)paramayob;
      return new aynv(paramContext, aynv.a(paramayob.getType(), paramString, axvz.cC(-1L), paramayob.Iy(), paramayob.getFontPath()));
    case 12: 
      paramayob = (aynz)paramayob;
      return new aynz(paramContext, aynz.S(paramayob.getType(), paramayob.Iz()));
    case 11: 
      paramayob = (ayns)paramayob;
      return new ayns(paramContext, ayns.a(paramayob.getType(), paramayob.Iw(), paramayob.Ix(), axvz.cE(-1L), axvz.cF(-1L)));
    case 9: 
      paramayob = (aynx)paramayob;
      return new aynx(paramContext, aynx.k(paramayob.getType(), paramayob.Iy(), paramString));
    }
    paramayob = (ayok)paramayob;
    return new ayok(paramContext, ayok.a(paramayob.getType(), paramayob.Iy(), paramayob.getFontPath(), paramString));
  }
  
  public static boolean oB(int paramInt)
  {
    return dD.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean oC(int paramInt)
  {
    return dE.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynb
 * JD-Core Version:    0.7.0.1
 */