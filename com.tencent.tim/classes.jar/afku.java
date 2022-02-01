import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afku
{
  public static int Db()
  {
    int j = afkv.a().a(2).Dc();
    int i = j;
    if (j < aoff.oo.length) {
      i = aoff.oo.length;
    }
    return i;
  }
  
  public static int cM(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = afkv.a().a(2);
    if ((localQQSysAndEmojiResInfo instanceof afkt)) {
      return ((afkt)localQQSysAndEmojiResInfo).cM(paramString);
    }
    return -1;
  }
  
  public static ArrayList<Integer> cV()
  {
    ArrayList localArrayList = afkv.a().a(2).cV();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return localArrayList;
    }
    localArrayList = new ArrayList(afme.cRU);
    int i = 0;
    while (i < afme.cRU)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public static String dZ(int paramInt)
  {
    String str2 = afkv.a().a(2).dY(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if ((paramInt >= 0) && (paramInt < aoff.hk.length)) {
        str1 = aoff.hk[paramInt];
      }
    }
    else {
      return str1;
    }
    return "未知";
  }
  
  public static int hi(int paramInt)
  {
    int j = afkv.a().a(2).hh(paramInt);
    int i = j;
    if (j == -1)
    {
      if ((paramInt >= 0) && (paramInt < aoff.oo.length)) {
        i = aoff.oo[paramInt];
      }
    }
    else {
      return i;
    }
    QLog.d("EmojiUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
    return j;
  }
  
  public static int hj(int paramInt)
  {
    int j = afkv.a().a(2).hk(paramInt);
    int i = j;
    if (j == -1) {
      i = aoff.ah.get(paramInt, -1);
    }
    return i;
  }
  
  public static boolean jl(int paramInt)
  {
    int j = afkv.a().a(2).Da();
    int i = j;
    if (j <= 0) {
      i = aoff.oo.length - 1;
    }
    return (paramInt >= 0) && (paramInt <= i);
  }
  
  public static boolean jm(int paramInt)
  {
    return afkv.a().a(2).jk(paramInt);
  }
  
  public static Drawable x(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji static index: " + paramInt);
    }
    Object localObject = BaseApplicationImpl.getContext().getResources();
    if (paramInt >= 1000) {
      localObject = aofy.j((Resources)localObject, paramInt);
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      if (paramInt < aoff.dOq)
      {
        paramInt = 2130839808 + paramInt;
        if (BaseApplicationImpl.sImageCache != null) {
          return aofy.i((Resources)localObject, paramInt);
        }
        return ((Resources)localObject).getDrawable(paramInt);
      }
      localDrawable = afkv.a().a(2).getDrawable(paramInt);
      localObject = localDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("EmojiUtil", 2, "getEmojiDrawable in new way");
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afku
 * JD-Core Version:    0.7.0.1
 */