package cooperation.weiyun;

import agkf;
import agkj;
import ahav;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;

public class WeiyunBroadcastReceiver
  extends BroadcastReceiver
{
  public void a(Context paramContext, WeiYunFileInfo paramWeiYunFileInfo, FileManagerEntity paramFileManagerEntity)
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.Oj(paramFileManagerEntity.getCloudType());
    localForwardFileInfo.setType(10001);
    localForwardFileInfo.p(paramFileManagerEntity.nSessionId);
    localForwardFileInfo.setFileName(paramWeiYunFileInfo.strFileName);
    localForwardFileInfo.setFileId(paramWeiYunFileInfo.bIk);
    localForwardFileInfo.Oi(2);
    localForwardFileInfo.setFileSize(paramWeiYunFileInfo.nFileSize);
    localForwardFileInfo.e(paramWeiYunFileInfo);
    localForwardFileInfo.setLocalPath(paramFileManagerEntity.getFilePath());
    localForwardFileInfo.jB(paramFileManagerEntity.uniseq);
    localForwardFileInfo.setUuid(paramFileManagerEntity.Uuid);
    paramWeiYunFileInfo = new Intent(paramContext, FileBrowserActivity.class);
    paramWeiYunFileInfo.addFlags(268435456);
    paramWeiYunFileInfo.putExtra("fileinfo", localForwardFileInfo);
    paramContext.startActivity(paramWeiYunFileInfo);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getExtras();
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramIntent != null)
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayList("fileinfos");
        paramContext = null;
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          paramContext = ahav.b((WeiYunFileInfo)localIterator.next());
          paramContext.nOpType = 5;
          localQQAppInterface.a().s(paramContext);
          localQQAppInterface.a().x(paramContext);
        }
        if (localArrayList.size() == 1)
        {
          a(localQQAppInterface.getApp(), (WeiYunFileInfo)localArrayList.get(0), paramContext);
          return;
        }
        paramContext = new Intent(localQQAppInterface.getApp(), FMActivity.class);
        paramContext.putExtra("tab_tab_type", 7);
        paramContext.addFlags(268435456);
        new Bundle().putLong("category", 13L);
        paramContext.putExtra("bundle", paramIntent);
        localQQAppInterface.getApp().startActivity(paramContext);
        return;
      }
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.weiyun.WeiyunBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */