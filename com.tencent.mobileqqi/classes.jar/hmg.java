import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

public final class hmg
  implements Runnable
{
  public hmg(Bundle paramBundle, int paramInt1, int paramInt2, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject1 = DownloadApi.a;
    Object localObject2 = new StringBuilder().append("doDownloadAction pParams=").append(this.jdField_a_of_type_AndroidOsBundle).append(" source=").append(this.jdField_a_of_type_Int).append(" myAppConfig=").append(this.b).append(" ac==null is");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      LogUtility.a((String)localObject1, bool1);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        break;
      }
      LogUtility.e(DownloadApi.a, "doDownloadAction pParams == null return");
      return;
    }
    DownloadManager.a().a();
    localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.a);
    this.jdField_a_of_type_AndroidOsBundle.putInt(DownloadConstants.r, this.jdField_a_of_type_Int);
    localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.A);
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equals("0"))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.A, "");
    }
    localObject1 = DownloadManager.a().a((String)localObject1);
    if ((localObject1 == null) && (this.jdField_a_of_type_Int == 0) && (ControlPolicyUtil.c()))
    {
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.j);
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.e);
      if ((i == 5) && (((String)localObject2).equals("com.tencent.android.qqdownloader")))
      {
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.h);
        MyAppApi.a().b(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1);
        return;
      }
    }
    if (DownloadApi.a(this.jdField_a_of_type_AndroidOsBundle))
    {
      LogUtility.a(DownloadApi.a, "doDownloadAction installApp");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null) && (this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 2) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.i))) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.i, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
    }
    if (this.b == 0)
    {
      if ((localObject1 != null) && (((DownloadInfo)localObject1).h == 1))
      {
        DownloadApi.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.b);
        return;
      }
      boolean bool3 = APNUtil.d(CommonDataAdapter.a().a());
      boolean bool4 = APNUtil.c(CommonDataAdapter.a().a());
      if ((localObject1 == null) || (((DownloadInfo)localObject1).a() == 1))
      {
        bool1 = true;
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          break label546;
        }
      }
      for (;;)
      {
        LogUtility.a(DownloadApi.a, "check wifi dialog isWifiActive=" + bool4 + " isFirstDownload=" + bool1 + " acIsNull=" + bool2);
        if ((!bool3) || (bool2) || (bool4) || (!bool1) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean(DownloadConstants.q))) {
          break label551;
        }
        DownloadManager.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.b);
        return;
        bool1 = false;
        break;
        label546:
        bool2 = false;
      }
      label551:
      DownloadApi.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
      return;
    }
    if ((localObject1 == null) || (((DownloadInfo)localObject1).h == 1))
    {
      DownloadApi.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.b);
      return;
    }
    DownloadApi.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hmg
 * JD-Core Version:    0.7.0.1
 */