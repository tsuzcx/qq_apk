import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import eipc.EIPCResult;

class anjz
  extends QIPCModule
{
  anjz(anjy paramanjy, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ("CMD_GET_NICK_NAME_BY_UIN".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putString("VALUE_USER_NICK_NAME", aqgv.b(localQQAppInterface, paramBundle.getString("VALUE_USER_UIN_TO_GET_NICK_NAME"), true));
      return EIPCResult.createSuccessResult(paramString);
    }
    if ("CMD_GET_CURRENT_NICK_NAME".equals(paramString))
    {
      paramString = localQQAppInterface.getCurrentNickname();
      paramBundle = new Bundle();
      paramBundle.putString("VALUE_GET_CURRENT_NICK_NAME", paramString);
      return EIPCResult.createSuccessResult(paramBundle);
    }
    if ("CMD_GET_CURRENT_USER_HEAD".equals(paramString))
    {
      paramString = localQQAppInterface.getCustomFaceFilePath(1, localQQAppInterface.getCurrentUin(), 200);
      paramBundle = new Bundle();
      paramBundle.putString("VALUE_GET_CURRENT_USER_HEAD", paramString);
      return EIPCResult.createSuccessResult(paramBundle);
    }
    if ("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT".equals(paramString))
    {
      paramString = paramBundle.getString("VALUE_MSG_FRIENDUIN");
      paramInt = paramBundle.getInt("VALUE_MSG_ISTROOP");
      paramBundle = paramBundle.getString("VALUE_MSG_VIDEO_ID");
      if (paramBundle != null)
      {
        anjo.a(localQQAppInterface).aa(paramString, paramInt, paramBundle);
        VideoRedbagData.updateRewardStat(paramBundle);
      }
      return EIPCResult.createSuccessResult(new Bundle());
    }
    if ("CMD_QUERY_VIDEO_REDBAG_STAT".equals(paramString))
    {
      boolean bool = VideoRedbagData.queryRewardStat(paramBundle.getString("VALUE_MSG_VIDEO_ID"));
      paramString = new Bundle();
      paramString.putBoolean("VALUE_MSG_REDBAG_STAT", bool);
      return EIPCResult.createSuccessResult(paramString);
    }
    if ("CMD_DOWNLOAD_PTU_ADDITIONAL_RES".equals(paramString))
    {
      axce.a().a(axcd.d, null, false);
      axiy.i("VideoPlayIPCServer", "launchForResult requestAEKitDownload : AEKIT_ADDITIONAL_PACKAGE");
      return EIPCResult.createSuccessResult(new Bundle());
    }
    if ("CMD_DOWNLOAD_PTU_BASE_RES".equals(paramString))
    {
      axce.a().a(axcd.c, null, false);
      axiy.i("VideoPlayIPCServer", "launchForResult requestAEKitDownload : AEKIT_ADDITIONAL_PACKAGE");
      return EIPCResult.createSuccessResult(new Bundle());
    }
    if ("CMD_QUERY_STATUS_PTU_RES".equals(paramString))
    {
      paramInt = axce.a().a(axcd.d);
      axiy.i("VideoPlayIPCServer", "query additional_package");
      paramString = new Bundle();
      paramString.putInt("VALUE_MSG_PTU_RES_STATUS", paramInt);
      return EIPCResult.createSuccessResult(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjz
 * JD-Core Version:    0.7.0.1
 */