import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.data.MessageRecord;

public class aibg
{
  public static boolean a(int paramInt, RecentBaseData paramRecentBaseData)
  {
    return (paramInt == 10005) && ((paramRecentBaseData instanceof RecentItemImaxADData)) && (!TextUtils.isEmpty(((RecentItemImaxADData)paramRecentBaseData).mHeaderUrl));
  }
  
  public static boolean aC(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.istroop == 10005;
  }
  
  public static void aI(String paramString1, String paramString2, String paramString3)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_data_" + paramString1, 4).edit().putString(paramString2, paramString3).apply();
  }
  
  public static String bf(String paramString1, String paramString2)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_data_" + paramString1, 4).getString(paramString2, "");
  }
  
  public static void gm(String paramString1, String paramString2)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_data_" + paramString1, 4).edit().remove(paramString2).apply();
  }
  
  public static boolean isVisibleAreaSatisfied(View paramView)
  {
    if (paramView != null)
    {
      int i = paramView.getHeight();
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      if (localRect.height() >= i / 2) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibg
 * JD-Core Version:    0.7.0.1
 */