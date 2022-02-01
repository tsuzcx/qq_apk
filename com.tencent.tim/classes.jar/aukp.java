import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;
import java.util.Map;

public class aukp
{
  public static arhz a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramQQAppInterface = (aukx)paramQQAppInterface.getBusinessHandler(120);
    if ((paramQQAppInterface == null) || (paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramTeamWorkFileImportInfo.isUserClick = true;
    if (paramString2.equals(paramContext.getString(2131720932)))
    {
      paramTeamWorkFileImportInfo.cKZ = true;
      paramQQAppInterface.a(paramTeamWorkFileImportInfo, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.i("teamConvert", 2, "start convert time [" + System.currentTimeMillis() / 1000L + "]");
      }
      if ((paramQQAppInterface.a(paramTeamWorkFileImportInfo)) || (!TextUtils.isEmpty(paramQQAppInterface.b(paramTeamWorkFileImportInfo))) || (!paramTeamWorkFileImportInfo.cKZ)) {
        break label153;
      }
      paramQQAppInterface.c(paramTeamWorkFileImportInfo);
      paramQQAppInterface.QH(false);
      a(paramContext, paramTeamWorkFileImportInfo);
    }
    for (;;)
    {
      return null;
      paramTeamWorkFileImportInfo.cKZ = false;
      break;
      label153:
      if ((paramQQAppInterface.a(paramTeamWorkFileImportInfo)) && (paramTeamWorkFileImportInfo.cKZ))
      {
        paramQQAppInterface.QH(false);
        a(paramContext, paramTeamWorkFileImportInfo);
      }
      else if ((!TextUtils.isEmpty(paramQQAppInterface.b(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.cKZ))
      {
        paramString1 = new Bundle();
        paramString1.putString("url", paramQQAppInterface.b(paramTeamWorkFileImportInfo));
        paramString1.putBoolean("temp_preview_from_qq", true);
        paramString1.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
        paramString1.putString("tdsourcetag", "s_tim_file_edit");
        TeamWorkDocEditBrowserActivity.a(paramContext, paramString1, false);
      }
    }
  }
  
  public static void a(Context paramContext, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Intent localIntent = new Intent(paramContext, TeamWorkDocEditBrowserActivity.class);
    localIntent.putExtra("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
    localIntent.putExtra("temp_preview_from_qq", true);
    localIntent.putExtra("temp_preview_show_loading", true);
    localIntent.putExtra("tdsourcetag", "s_tim_file_edit");
    if (paramTeamWorkFileImportInfo != null)
    {
      if (paramTeamWorkFileImportInfo.dNQ != 1) {
        break label85;
      }
      localIntent.putExtra("tdsourcetag", "s_tim_aio_edit");
    }
    for (;;)
    {
      TeamWorkDocEditBrowserActivity.a(localIntent, null, paramContext);
      localIntent.addFlags(603979776);
      paramContext.startActivity(localIntent);
      return;
      label85:
      if (aobw.ns.containsKey(Integer.valueOf(paramTeamWorkFileImportInfo.dNQ))) {
        localIntent.putExtra("tdsourcetag", (String)aobw.ns.get(Integer.valueOf(paramTeamWorkFileImportInfo.dNQ)));
      }
    }
  }
  
  public static void a(Context paramContext, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    paramString = new Intent(paramContext, TeamWorkDocEditBrowserActivity.class);
    paramString.putExtra("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
    paramString.putExtra("tdsourcetag", "s_tim_file_edit");
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.dNQ == 1)) {
      paramString.putExtra("tdsourcetag", "s_tim_aio_edit");
    }
    paramString.putExtra("temp_preview_from_qq", true);
    paramString.putExtra("temp_preview_show_loading", true);
    TeamWorkDocEditBrowserActivity.a(paramString, null, paramContext);
    paramString.addFlags(603979776);
    paramContext.startActivity(paramString);
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = paramQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + paramQQAppInterface.getCurrentUin(), 0).getInt("tim_convert_teamwork_file_size", 20971520);
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
      QQToast.a(paramContext, "当前网络不可用，请检查你的网络设置。", 1).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
    }
    do
    {
      return false;
      if (paramInt == 6) {
        paramTeamWorkFileImportInfo.dNQ = paramInt;
      }
    } while ((!ault.cm(paramTeamWorkFileImportInfo.filePath, paramTeamWorkFileImportInfo.fileName)) || (paramTeamWorkFileImportInfo.fileSize > i));
    aukx localaukx = (aukx)paramQQAppInterface.getBusinessHandler(120);
    paramQQAppInterface = null;
    if (!TextUtils.isEmpty(localaukx.b(paramTeamWorkFileImportInfo))) {
      paramQQAppInterface = localaukx.b(paramTeamWorkFileImportInfo);
    }
    if (!localaukx.a(paramTeamWorkFileImportInfo)) {
      localaukx.c(paramTeamWorkFileImportInfo);
    }
    a(paramContext, paramTeamWorkFileImportInfo, paramQQAppInterface);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aukp
 * JD-Core Version:    0.7.0.1
 */