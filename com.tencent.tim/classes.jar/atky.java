import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.teamwork.PadInfo;

public class atky
  extends atkw
{
  public void ga(Context paramContext)
  {
    if (!aqiw.isNetworkAvailable(paramContext)) {
      auds.D(1, paramContext.getString(2131693404), 0);
    }
    aulh localaulh;
    PadInfo localPadInfo;
    int i;
    do
    {
      do
      {
        return;
        paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localaulh = (aulh)paramContext.getBusinessHandler(178);
        localPadInfo = (PadInfo)this.fQ;
      } while ((localPadInfo == null) || (TextUtils.isEmpty(localPadInfo.pad_url)));
      i = localPadInfo.type_list;
      if (i == 2)
      {
        if ((localPadInfo.creatorUin > 0L) && (paramContext.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(localPadInfo.creatorUin))))
        {
          localaulh.Zq(localPadInfo.pad_url);
          return;
        }
        localaulh.Zr(localPadInfo.pad_url);
        return;
      }
      if (i == 1)
      {
        localaulh.Zq(localPadInfo.pad_url);
        return;
      }
      if (i == 3)
      {
        localaulh.Zs(localPadInfo.pad_url);
        return;
      }
    } while (i != 4);
    localaulh.Zp(localPadInfo.pad_url);
  }
  
  public void n(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = (PadInfo)this.fQ;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", jpa.r(paramQQAppInterface.pad_url, "_bid=2517"));
    localBundle.putInt("key_team_work_edit_type", paramQQAppInterface.type);
    localBundle.putString("key_team_work_title", paramQQAppInterface.title);
    localBundle.putString("key_team_work_rul", paramQQAppInterface.pad_url);
    localBundle.putInt("key_team_work_pad_list_type", paramQQAppInterface.type_list);
    TeamWorkDocEditBrowserActivity.a(paramContext, localBundle, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atky
 * JD-Core Version:    0.7.0.1
 */