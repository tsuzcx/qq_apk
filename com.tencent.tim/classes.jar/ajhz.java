import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajhz
{
  private static List<Integer> De = new ArrayList();
  private static boolean coF = true;
  
  static
  {
    De.clear();
    De.add(Integer.valueOf(0));
    De.add(Integer.valueOf(1));
    De.add(Integer.valueOf(3000));
    De.add(Integer.valueOf(1004));
    De.add(Integer.valueOf(1000));
    De.add(Integer.valueOf(1022));
    De.add(Integer.valueOf(1001));
    De.add(Integer.valueOf(10002));
    De.add(Integer.valueOf(1006));
    De.add(Integer.valueOf(1005));
    De.add(Integer.valueOf(10008));
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOHelper", 2, "cropAIOFromDecorView() called with: input = [" + paramBitmap + "], contentHeight = [" + paramInt + "], activity = [" + paramActivity + "]");
    }
    if (paramBitmap == null) {
      return null;
    }
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    isNavigationBarShow(paramActivity);
    if ((paramInt > 0) && (paramInt < i)) {}
    for (;;)
    {
      i = ImmersiveUtils.getStatusBarHeight(paramActivity);
      paramInt -= i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiAIOHelper", 2, "cropAIOFromDecorView() statusBarHeight = " + i + ", width =" + j + ", finalHeight = " + paramInt);
        }
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, i, j, paramInt);
        return paramBitmap;
      }
      catch (Throwable paramBitmap)
      {
        QLog.e("MultiAIOHelper", 1, "cropAIOFromDecorView: ", paramBitmap);
        ajim.dxL();
        return null;
      }
      paramInt = i;
    }
  }
  
  public static List<RecentBaseData> a(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    ProxyManager localProxyManager = paramQQAppInterface.a();
    if (localProxyManager == null) {
      return localArrayList;
    }
    try
    {
      if (localProxyManager.a().q(false).size() > 0) {
        localArrayList.addAll(aajt.a().fl);
      }
      return a(paramFragmentActivity, paramQQAppInterface, localArrayList, paramString1, paramInt, paramString2, paramString3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MultiAIOHelper", 1, "getRecentUser error.", localException);
      }
    }
  }
  
  private static List<RecentBaseData> a(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, List<RecentBaseData> paramList, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (TextUtils.equals(paramString1, "conversation_tab_bottom")) {
      while (localIterator.hasNext())
      {
        paramFragmentActivity = (RecentBaseData)localIterator.next();
        if ((c(paramFragmentActivity)) && (!d(paramFragmentActivity))) {
          localArrayList.add(paramFragmentActivity);
        }
      }
    }
    int i = 0;
    int j = -1;
    if (i < paramList.size())
    {
      paramString1 = (RecentBaseData)paramList.get(i);
      int k = j;
      if (c(paramString1))
      {
        if ((paramString1.ng() != paramInt) || (!TextUtils.equals(paramString2, paramString1.qx()))) {
          break label151;
        }
        k = i;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        label151:
        k = j;
        if (!d(paramString1))
        {
          localArrayList.add(paramString1);
          k = j;
        }
      }
    }
    if (j == -1)
    {
      paramFragmentActivity = aaiv.a(new RecentUser(paramString2, paramInt), paramQQAppInterface, paramFragmentActivity);
      if (paramFragmentActivity != null) {
        if (paramString3 == null) {
          break label228;
        }
      }
      for (;;)
      {
        paramFragmentActivity.mTitleName = paramString3;
        localArrayList.add(0, paramFragmentActivity);
        return localArrayList;
        label228:
        paramString3 = paramFragmentActivity.getTitleName();
      }
    }
    localArrayList.add(0, paramList.get(j));
    return localArrayList;
  }
  
  public static boolean aqM()
  {
    return false;
  }
  
  private static boolean c(RecentBaseData paramRecentBaseData)
  {
    return kr(paramRecentBaseData.ng());
  }
  
  public static void clear() {}
  
  private static boolean d(RecentBaseData paramRecentBaseData)
  {
    return paramRecentBaseData.mUnreadFlag == 3;
  }
  
  public static boolean isNavigationBarShow(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint1 = new Point();
      Point localPoint2 = new Point();
      paramActivity.getSize(localPoint1);
      paramActivity.getRealSize(localPoint2);
      if (localPoint2.y == localPoint1.y) {}
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return true;
      return false;
      bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
      bool2 = KeyCharacterMap.deviceHasKey(4);
    } while ((!bool1) && (!bool2));
    return false;
  }
  
  public static boolean kr(int paramInt)
  {
    return De.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajhz
 * JD-Core Version:    0.7.0.1
 */