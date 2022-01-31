import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class yxv
  implements Runnable
{
  public yxv(CmGameCommonShare paramCmGameCommonShare, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(CmGameCommonShare.b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare))) {
      CmGameCommonShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare, "shareQRCode_default.png");
    }
    File localFile;
    Object localObject;
    if (CmGameCommonShare.b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare).startsWith("http"))
    {
      localFile = new File(ApolloConstant.n + CmGameCommonShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare) + "/shareQRCode.png");
      if (localFile.exists()) {
        localFile.delete();
      }
      localObject = new DownloadTask(CmGameCommonShare.b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare), localFile);
      ((DownloadTask)localObject).n = false;
      ((DownloadTask)localObject).h = false;
      ((DownloadTask)localObject).l = true;
      ((DownloadTask)localObject).q = false;
      ((DownloadTask)localObject).o = true;
      ((DownloadTask)localObject).p = true;
      ((DownloadTask)localObject).b = true;
      ((DownloadTask)localObject).f = "apollo_res";
      if (DownloaderFactory.a((DownloadTask)localObject, CmGameUtil.a().getCurrentAccountUin(), BaseApplicationImpl.getContext()) == 3) {
        break label188;
      }
      ApolloItemBuilder.a("分享游戏失败", 1, BaseApplicationImpl.getContext());
    }
    for (;;)
    {
      return;
      localFile = new File(CmGameCommonShare.c(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare));
      try
      {
        label188:
        if ((!localFile.isFile()) || (!localFile.exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", localFile.getAbsolutePath() });
          localFile = new File(CmGameCommonShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare, CmGameCommonShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare)));
        }
        for (;;)
        {
          if (localFile.exists()) {}
          for (localObject = BitmapFactory.decodeFile(localFile.getAbsolutePath()); localObject != null; localObject = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130838160))
          {
            localObject = TroopShareUtility.a((Bitmap)localObject);
            WXShareHelper.a().a(new yxw(this));
            WXShareHelper.a().a(localFile.getAbsolutePath(), (Bitmap)localObject, this.jdField_a_of_type_Int);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("apollo_cmGame_CmGameCommonShare", 1, "fail to invite wxFriend, oom happens, errInfo->" + localOutOfMemoryError.getMessage());
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("apollo_cmGame_CmGameCommonShare", 1, "fail to invite wxFriend, error happens, errInfo->" + localThrowable.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxv
 * JD-Core Version:    0.7.0.1
 */