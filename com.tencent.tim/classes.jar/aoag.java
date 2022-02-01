import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class aoag
{
  public static arhz a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    aoar localaoar = (aoar)paramQQAppInterface.getBusinessHandler(120);
    if ((paramContext == null) || (localaoar == null) || (paramTeamWorkFileImportInfo == null) || (paramTeamWorkFileImportInfo.peerType != 1)) {
      return null;
    }
    paramTeamWorkFileImportInfo.dNR = 6;
    return a(paramQQAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString);
  }
  
  public static arhz a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString)
  {
    paramQQAppInterface = (aoar)paramQQAppInterface.getBusinessHandler(120);
    if ((paramQQAppInterface == null) || (paramTeamWorkFileImportInfo == null) || (!d(paramTeamWorkFileImportInfo))) {}
    do
    {
      return null;
      paramTeamWorkFileImportInfo.isUserClick = true;
      paramTeamWorkFileImportInfo.cKZ = true;
      if ((!paramQQAppInterface.e(paramTeamWorkFileImportInfo)) && (TextUtils.isEmpty(paramQQAppInterface.c(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.cKZ))
      {
        paramQQAppInterface.j(paramTeamWorkFileImportInfo);
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((paramQQAppInterface.e(paramTeamWorkFileImportInfo)) && (paramTeamWorkFileImportInfo.cKZ))
      {
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
    } while ((TextUtils.isEmpty(paramQQAppInterface.c(paramTeamWorkFileImportInfo))) || (!paramTeamWorkFileImportInfo.cKZ));
    paramString = new Bundle();
    paramString.putString("url", paramQQAppInterface.c(paramTeamWorkFileImportInfo));
    paramString.putBoolean("temp_preview_from_qq", true);
    paramString.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.azu()) {
      paramString.putString("tdsourcetag", "s_qq_file_preview");
    }
    for (;;)
    {
      TeamWorkDocEditBrowserActivity.a(paramContext, paramString, false);
      return null;
      paramString.putString("tdsourcetag", "s_qq_file_edit");
    }
  }
  
  public static arhz a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    aoar localaoar = (aoar)paramQQAppInterface.getBusinessHandler(120);
    if ((localaoar == null) || (paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return null;
      paramTeamWorkFileImportInfo.isUserClick = true;
      if (paramString2.equals(paramContext.getString(2131720932))) {}
      for (paramTeamWorkFileImportInfo.cKZ = true;; paramTeamWorkFileImportInfo.cKZ = false)
      {
        localaoar.a(paramTeamWorkFileImportInfo, paramBoolean);
        if ((localaoar.e(paramTeamWorkFileImportInfo)) || (!TextUtils.isEmpty(localaoar.c(paramTeamWorkFileImportInfo))) || (!paramTeamWorkFileImportInfo.cKZ)) {
          break;
        }
        localaoar.j(paramTeamWorkFileImportInfo);
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((localaoar.e(paramTeamWorkFileImportInfo)) && (paramTeamWorkFileImportInfo.cKZ))
      {
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((!TextUtils.isEmpty(localaoar.c(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.cKZ))
      {
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("url", localaoar.c(paramTeamWorkFileImportInfo));
        paramQQAppInterface.putBoolean("temp_preview_from_qq", true);
        paramQQAppInterface.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
        if (paramTeamWorkFileImportInfo.azu()) {
          paramQQAppInterface.putString("tdsourcetag", "s_qq_file_preview");
        }
        for (;;)
        {
          TeamWorkDocEditBrowserActivity.a(paramContext, paramQQAppInterface, false);
          return null;
          paramQQAppInterface.putString("tdsourcetag", "s_qq_file_edit");
        }
      }
    } while (paramTeamWorkFileImportInfo.cKZ);
    a(paramQQAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString1, paramString2, paramBoolean);
    return null;
  }
  
  public static String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.peerType == 1) {
      return paramTeamWorkFileImportInfo.cjE;
    }
    return paramTeamWorkFileImportInfo.Uuid;
  }
  
  public static void a(Context paramContext, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    int i = 1;
    paramString = new Intent(paramContext, TeamWorkDocEditBrowserActivity.class);
    paramString.putExtra("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
    paramString.putExtra("temp_preview_from_qq", true);
    paramString.putExtra("temp_preview_show_loading", true);
    if (paramTeamWorkFileImportInfo != null) {
      if (paramTeamWorkFileImportInfo.dNQ == 1)
      {
        paramString.putExtra("tdsourcetag", "s_qq_aio_edit");
        i = 0;
        j = i;
        if (aobw.ns.containsKey(Integer.valueOf(paramTeamWorkFileImportInfo.dNQ))) {
          paramString.putExtra("tdsourcetag", (String)aobw.ns.get(Integer.valueOf(paramTeamWorkFileImportInfo.dNQ)));
        }
      }
    }
    for (int j = i;; j = 0)
    {
      TeamWorkDocEditBrowserActivity.a(paramString, null, paramContext);
      paramString.addFlags(536870912);
      if (((paramContext instanceof Activity)) && (j != 0) && (pK(paramString.getStringExtra("tdsourcetag"))))
      {
        ((Activity)paramContext).startActivityForResult(paramString, 14002);
        return;
        if (paramTeamWorkFileImportInfo.dNQ == 5)
        {
          paramString.putExtra("tdsourcetag", "s_QQ_file_share_edit");
          break;
        }
        if (paramTeamWorkFileImportInfo.azu())
        {
          paramString.putExtra("tdsourcetag", "s_qq_file_preview");
          i = 0;
          break;
        }
        paramString.putExtra("tdsourcetag", "s_qq_file_edit");
        break;
      }
      paramContext.startActivity(paramString);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, aoag.a parama)
  {
    if (paramContext == null) {
      QLog.w(paramString, 1, "no context to show dialog");
    }
    do
    {
      return;
      if (c(paramTeamWorkFileImportInfo)) {
        break;
      }
      b(paramQQAppInterface, paramTeamWorkFileImportInfo);
      i(paramTeamWorkFileImportInfo);
      paramQQAppInterface = a(paramQQAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString, paramContext.getString(2131720932), true);
    } while (parama == null);
    parama.c(paramQQAppInterface);
    return;
    ausj localausj = (ausj)auss.a(paramContext, null);
    String str3;
    String str2;
    if (paramTeamWorkFileImportInfo.azu())
    {
      str3 = paramContext.getString(2131693024);
      str2 = paramContext.getString(2131693020);
    }
    for (String str1 = paramContext.getString(2131693022);; str1 = paramContext.getString(2131693021))
    {
      localausj.setMainTitle(2131693025);
      localausj.setSecondaryTitle(str3);
      localausj.addButton(str2, 5);
      localausj.addButton(str1, 5);
      localausj.addCancelButton(2131721058);
      localausj.a(new aoah(paramTeamWorkFileImportInfo, localausj, paramQQAppInterface, paramContext, paramString, parama));
      localausj.show();
      if (!paramTeamWorkFileImportInfo.azu()) {
        break;
      }
      aodb.aN(paramQQAppInterface, "0X8009ED0");
      return;
      str3 = paramContext.getString(2131693023);
      str2 = paramContext.getString(2131693018);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    aoar localaoar = (aoar)paramQQAppInterface.getBusinessHandler(120);
    if ((localaoar == null) || (paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      String str1 = String.format(paramContext.getString(2131720974), new Object[] { paramString2 });
      int k = aetq.a().Ct();
      int m = aetq.a().Cu();
      int j = 1;
      int i;
      if (!aqiz.s(paramQQAppInterface.getApp(), "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0"))
      {
        paramString2 = String.format(paramContext.getString(2131720974), new Object[] { paramString2 });
        if (QLog.isColorLevel()) {
          QLog.d(paramString1, 2, "jumpTimLogin tim not install ");
        }
        i = 0;
        if (i == 0) {
          break label400;
        }
        paramContext = new Bundle();
        if (paramBoolean) {
          break label389;
        }
        if (k == -1) {
          QLog.i(paramString1, 1, "tim entry not defined");
        }
        paramContext.putBoolean("isOpenTeamWork", false);
        paramContext.putInt("timEntry", k);
      }
      for (;;)
      {
        for (;;)
        {
          paramContext.putString("teamworkUrl", localaoar.c(paramTeamWorkFileImportInfo));
          paramContext.putInt("peerType", paramTeamWorkFileImportInfo.peerType);
          paramContext.putString("peerUin", paramTeamWorkFileImportInfo.peerUin);
          paramContext.putInt("busId", paramTeamWorkFileImportInfo.dNP);
          paramContext.putLong("uniSeq", paramTeamWorkFileImportInfo.msgUniseq);
          ((aizk)paramQQAppInterface.getManager(242)).cY(paramContext);
          return;
          String str2 = aqiz.O(paramQQAppInterface.getApp(), "com.tencent.tim");
          if (QLog.isColorLevel()) {
            QLog.d(paramString1, 2, "jumpTimLogin tim timVersion=" + str2);
          }
          try
          {
            int n = Integer.parseInt(str2.replace(".", ""));
            if (n == 0)
            {
              paramString2 = String.format(paramContext.getString(2131720974), new Object[] { paramString2 });
              i = 0;
              break;
            }
            i = j;
            paramString2 = str1;
            if (n >= m) {
              break;
            }
            paramString2 = paramContext.getString(2131721073);
            i = 0;
          }
          catch (Exception paramString2)
          {
            QLog.w(paramString1, 1, paramString2.toString());
            i = j;
            paramString2 = str1;
          }
        }
        break;
        label389:
        paramContext.putBoolean("isOpenTeamWork", true);
      }
      label400:
      paramQQAppInterface = aqha.a(paramContext, 0);
      paramQQAppInterface.setMessage(paramString2);
      paramQQAppInterface.setPositiveButton(paramContext.getString(2131692928), new aoai(paramContext, paramString1));
      paramQQAppInterface.setNegativeButton(paramContext.getString(2131694745), new aoaj(paramQQAppInterface));
      try
      {
        if (!paramQQAppInterface.isShowing())
        {
          paramQQAppInterface.show();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e(paramString1, 1, "mDialog.show() exception" + paramQQAppInterface.toString());
      }
    }
  }
  
  public static void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if (paramTeamWorkFileImportInfo == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      QLog.d(paramString, 2, "try pre import");
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      aoar localaoar = (aoar)localQQAppInterface.getBusinessHandler(120);
      if ((!localaoar.e(paramTeamWorkFileImportInfo)) && (TextUtils.isEmpty(localaoar.c(paramTeamWorkFileImportInfo))))
      {
        QLog.i(paramString, 1, " parseFileImportTendoc: no cache");
        paramTeamWorkFileImportInfo.dNR = 1;
        localaoar.j(paramTeamWorkFileImportInfo);
        return;
      }
      if (paramTeamWorkFileImportInfo.azu())
      {
        QLog.i(paramString, 1, " parseFileImportTendoc: has cache, but online preview, drop it");
        localaoar.l(paramTeamWorkFileImportInfo);
        localaoar.n(paramTeamWorkFileImportInfo);
        paramTeamWorkFileImportInfo.dNR = 1;
        localaoar.j(paramTeamWorkFileImportInfo);
        return;
      }
      QLog.i(paramString, 1, " parseFileImportTendoc: has cache");
      paramTeamWorkFileImportInfo.dNR = 2;
      paramTeamWorkFileImportInfo.urlType = 1;
    } while (!paramTeamWorkFileImportInfo.azu());
    aodb.aN(localQQAppInterface, "0X8009ECF");
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.filePath = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.fileName = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.nFileType = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.isFromAIO = true;
    localTeamWorkFileImportInfo.dNQ = paramInt;
    localTeamWorkFileImportInfo.fileSize = paramFileManagerEntity.fileSize;
    if (paramInt == 6)
    {
      localTeamWorkFileImportInfo.isFromAIO = false;
      localTeamWorkFileImportInfo.cKY = true;
    }
    localTeamWorkFileImportInfo.peerType = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.peerUin = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.troopUin = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.dNP = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.cjE = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.msgUniseq = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.cKX = true;
    }
    return a(localTeamWorkFileImportInfo, paramContext, paramQQAppInterface, paramInt);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.filePath = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.fileName = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.nFileType = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.isFromAIO = true;
    localTeamWorkFileImportInfo.dNQ = paramInt1;
    localTeamWorkFileImportInfo.fileSize = paramFileManagerEntity.fileSize;
    localTeamWorkFileImportInfo.device = paramInt2;
    if (paramInt1 == 6)
    {
      localTeamWorkFileImportInfo.isFromAIO = false;
      localTeamWorkFileImportInfo.cKY = true;
    }
    localTeamWorkFileImportInfo.peerType = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.peerUin = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.troopUin = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.dNP = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.cjE = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.msgUniseq = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.cKX = true;
    }
    return a(localTeamWorkFileImportInfo, paramContext, paramQQAppInterface, paramInt1);
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      QQToast.a(paramContext, acfp.m(2131715170), 1).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
      return false;
    }
    if (paramInt == 9) {
      paramTeamWorkFileImportInfo.dNQ = paramInt;
    }
    aoar localaoar = (aoar)paramQQAppInterface.getBusinessHandler(120);
    paramQQAppInterface = null;
    if (!TextUtils.isEmpty(localaoar.c(paramTeamWorkFileImportInfo))) {
      paramQQAppInterface = localaoar.c(paramTeamWorkFileImportInfo);
    }
    if (!localaoar.e(paramTeamWorkFileImportInfo)) {
      localaoar.j(paramTeamWorkFileImportInfo);
    }
    if (!paramTeamWorkFileImportInfo.azr()) {
      a(paramContext, paramTeamWorkFileImportInfo, paramQQAppInterface);
    }
    return true;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((paramQQAppInterface == null) || (paramTeamWorkFileImportInfo == null)) {}
    do
    {
      return;
      paramQQAppInterface = (aoar)paramQQAppInterface.getBusinessHandler(120);
    } while ((paramQQAppInterface == null) || (!paramQQAppInterface.e(paramTeamWorkFileImportInfo)) || ((paramTeamWorkFileImportInfo.dNR != 1) && (paramTeamWorkFileImportInfo.dNR != 2)));
    paramQQAppInterface.l(paramTeamWorkFileImportInfo);
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5));
  }
  
  public static boolean bJ(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localTeamWorkFileImportInfo.fileName = str;
    localTeamWorkFileImportInfo.srcUrl = paramString1;
    localTeamWorkFileImportInfo.createTime = SystemClock.elapsedRealtime();
    localTeamWorkFileImportInfo.cKX = true;
    localTeamWorkFileImportInfo.dNQ = 12;
    paramString1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString1 instanceof QQAppInterface)) {
      a(localTeamWorkFileImportInfo, BaseApplicationImpl.getContext(), (QQAppInterface)paramString1, localTeamWorkFileImportInfo.dNQ);
    }
    for (;;)
    {
      return true;
      paramString1 = new Bundle();
      paramString1.putParcelable("key_team_work_file_import_info", localTeamWorkFileImportInfo);
      paramString1 = affz.a("ipc_cmd_convert_team_work_url_2_doc", "", -1, paramString1);
      afjy.a().cq(paramString1);
    }
  }
  
  private static boolean c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {}
    while ((paramTeamWorkFileImportInfo.azu()) || ((paramTeamWorkFileImportInfo.urlType != 2) && (paramTeamWorkFileImportInfo.urlType != 1))) {
      return false;
    }
    return true;
  }
  
  public static boolean d(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.dNR == 6) || (paramTeamWorkFileImportInfo.dNR == 7)) && (paramTeamWorkFileImportInfo.peerType == 1);
  }
  
  public static void g(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((paramTeamWorkFileImportInfo == null) || (paramTeamWorkFileImportInfo.peerType != 1)) {}
    label65:
    for (;;)
    {
      return;
      Object localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {}
      for (localObject = (QQAppInterface)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label65;
        }
        localObject = (aoar)((QQAppInterface)localObject).getBusinessHandler(120);
        if (localObject == null) {
          break;
        }
        paramTeamWorkFileImportInfo.dNR = 7;
        ((aoar)localObject).j(paramTeamWorkFileImportInfo);
        return;
      }
    }
  }
  
  public static void h(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {}
      do
      {
        return;
        localObject = (aoar)((QQAppInterface)localObject).getBusinessHandler(120);
      } while (localObject == null);
      paramTeamWorkFileImportInfo.dNR = 1;
      ((aoar)localObject).j(paramTeamWorkFileImportInfo);
      return;
    }
  }
  
  private static void i(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {}
    while ((paramTeamWorkFileImportInfo.dNR == 0) || (paramTeamWorkFileImportInfo.dNR == 4)) {
      return;
    }
    paramTeamWorkFileImportInfo.dNR = 0;
  }
  
  public static void jI(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    for (String str = "0X800A750";; str = "0X800A751")
    {
      anot.a(null, "dc00898", "", "", str, str, paramInt2, 0, "", "", "", "");
      do
      {
        return;
      } while (paramInt1 != 1);
    }
  }
  
  private static boolean pK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = (String)aobw.nK.get(paramString);
    if (paramString == null) {
      return false;
    }
    aeob localaeob = (aeob)aeif.a().o(418);
    if (localaeob == null) {
      return false;
    }
    paramString = (aeoc)localaeob.F().get(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.ahr();
  }
  
  public static boolean pL(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (aeuu.lL(Uri.parse(paramString).getHost()));
  }
  
  public static boolean u(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject = paramJSONObject.optJSONArray("urls");
    if (localObject == null) {}
    for (localObject = null;; localObject = ((JSONArray)localObject).optString(0)) {
      return b((String)localObject, paramJSONObject.optString("filename"), paramJSONObject.optString("cookie"), paramJSONObject.optString("filetype"), paramJSONObject.optString("fileid"));
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(arhz paramarhz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoag
 * JD-Core Version:    0.7.0.1
 */