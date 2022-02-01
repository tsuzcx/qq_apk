import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.cloudfile.CloudFileDirBrowserActivity;

public class auel
{
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    if (paramSessionInfo.cZ == 9501)
    {
      paramQQAppInterface = (syw)paramQQAppInterface.getBusinessHandler(51);
      long l1;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.Nz())) {
        l1 = 0L;
      }
      try
      {
        long l2 = Long.parseLong(paramSessionInfo.aTl);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      localIntent.putExtra("category", 6);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", paramSessionInfo.aTl);
      localIntent.putExtra("peerType", paramSessionInfo.cZ);
      localIntent.putExtra("tab_tab_type", 5);
      localIntent.putExtra("smart_device_support_flag", paramQQAppInterface.H(l1));
      if (paramQQAppInterface.i(l1, 1)) {
        localIntent.putExtra("max_select_size", 52428800L);
      }
    }
    for (;;)
    {
      if ((paramSessionInfo.cZ == 0) || (paramSessionInfo.cZ == 3000) || (paramSessionInfo.cZ == 1)) {
        localIntent.putExtra("select_file_support_send_docs_file", aeuo.a().aib());
      }
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2130771991, 2130771992);
      return;
      if (paramSessionInfo.cZ == 8001) {
        localIntent.putExtra("busiType", 10);
      }
      localIntent.putExtra("tab_tab_type", paramInt);
      localIntent.putExtra("from_aio", true);
      localIntent.addFlags(536870912);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("peerType", paramSessionInfo.cZ);
      localIntent.putExtra("targetUin", paramSessionInfo.aTl);
      if (paramSessionInfo.cZ == 1000) {
        localIntent.putExtra("srcDiscGroup", paramSessionInfo.troopUin);
      }
      for (;;)
      {
        if (paramSessionInfo.cZ != 0) {
          break label371;
        }
        localIntent.putExtra("qfile_entrance_type_key", 1);
        break;
        if (paramSessionInfo.cZ == 1006) {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.phoneNum);
        } else {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.aTm);
        }
      }
      label371:
      if (paramSessionInfo.cZ == 3000) {
        localIntent.putExtra("qfile_entrance_type_key", 5);
      } else if (paramSessionInfo.cZ == 1) {
        localIntent.putExtra("qfile_entrance_type_key", 3);
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramActivity, CloudFileDirBrowserActivity.class);
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.bf(((atgc)paramQQAppInterface.getManager(373)).aE());
    localFileInfo.setName(paramActivity.getString(2131691665));
    localIntent.putExtra("key_file_info", localFileInfo);
    localIntent.putExtra("key_top_level_dir", true);
    localIntent.putExtra("key_file_browser_mode", 2);
    localIntent.putExtra("key_bottom_bar_left_action", 2);
    localIntent.putExtra("key_bottom_bar_right_action", 4);
    localIntent.putExtra("sessioninfo", paramSessionInfo);
    localIntent.putExtra("peerType", paramSessionInfo.cZ);
    localIntent.putExtra("targetUin", paramSessionInfo.aTl);
    if (paramSessionInfo.cZ == 1000) {
      localIntent.putExtra("srcDiscGroup", paramSessionInfo.troopUin);
    }
    for (;;)
    {
      paramActivity.overridePendingTransition(2130771991, 2130771992);
      paramActivity.startActivityForResult(localIntent, 5);
      return;
      if (paramSessionInfo.cZ == 1006) {
        localIntent.putExtra("srcDiscGroup", paramSessionInfo.phoneNum);
      } else {
        localIntent.putExtra("srcDiscGroup", paramSessionInfo.aTm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auel
 * JD-Core Version:    0.7.0.1
 */