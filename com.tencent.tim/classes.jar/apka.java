import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Collections;
import java.util.List;

public class apka
{
  public static String R(List<Integer> paramList)
  {
    int j = 0;
    int k = paramList.size();
    Collections.sort(paramList);
    if (k == 1) {
      return String.format(acfp.m(2131707346), new Object[] { Integer.valueOf(((Integer)paramList.get(0)).intValue() + 1) });
    }
    int i = 0;
    if (i < k - 1) {
      if (((Integer)paramList.get(i)).intValue() + 1 == ((Integer)paramList.get(i + 1)).intValue()) {}
    }
    for (i = 0;; i = 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("第");
      if (i != 0) {
        localStringBuilder.append(((Integer)paramList.get(0)).intValue() + 1).append("-").append(((Integer)paramList.get(k - 1)).intValue() + 1).append("段");
      }
      for (;;)
      {
        return localStringBuilder.toString();
        i += 1;
        break;
        while ((j < k) && (j < 3))
        {
          localStringBuilder.append(((Integer)paramList.get(j)).intValue() + 1);
          if ((j + 1 < k) && (j + 1 < 3)) {
            localStringBuilder.append("、");
          }
          j += 1;
        }
        if (k > 3) {
          localStringBuilder.append("等").append(k).append("段");
        } else {
          localStringBuilder.append("段");
        }
      }
    }
  }
  
  public static void Y(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramQQAppInterface.getCurrentUin(), 0).edit().putBoolean("ReciteGuideTipShow", paramBoolean).commit();
  }
  
  public static boolean bM(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("ReciteGuideTipShow", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apka
 * JD-Core Version:    0.7.0.1
 */