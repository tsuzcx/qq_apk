import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.common.DownloadReceiver;
import com.tencent.open.downloadnew.common.IntentFactory;
import com.tencent.open.downloadnew.common.NoticeParam;

public class fft
  implements Runnable
{
  public fft(DownloadReceiver paramDownloadReceiver, String paramString1, NoticeParam paramNoticeParam, String paramString2, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = DownloadManager.a().a(this.jdField_a_of_type_JavaLangString);
    boolean bool;
    if (localDownloadInfo == null) {
      if ((this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d != null) && (!this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d.trim().equals("")))
      {
        bool = true;
        localDownloadInfo = new DownloadInfo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.e, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.b, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a, 0, bool);
        if (!IntentFactory.c.equals(this.b)) {
          break label296;
        }
        localObject1 = DownloadManager.a().a(this.jdField_a_of_type_JavaLangString);
        if ((localObject1 != null) && (((DownloadInfo)localObject1).a() != 2) && (((DownloadInfo)localObject1).a() != 20))
        {
          localDownloadInfo.a(3);
          DownloadManager.a().a(3, localDownloadInfo);
        }
        DownloadManager.a().a(this.jdField_a_of_type_JavaLangString);
      }
    }
    label187:
    label210:
    label233:
    do
    {
      return;
      bool = false;
      break;
      if (TextUtils.isEmpty(localDownloadInfo.c))
      {
        localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.e;
        localDownloadInfo.c = ((String)localObject1);
        if (!TextUtils.isEmpty(localDownloadInfo.d)) {
          break label272;
        }
        localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d;
        localDownloadInfo.d = ((String)localObject1);
        if (!TextUtils.isEmpty(localDownloadInfo.jdField_g_of_type_JavaLangString)) {
          break label280;
        }
        localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_g_of_type_JavaLangString;
        localDownloadInfo.jdField_g_of_type_JavaLangString = ((String)localObject1);
        if (!TextUtils.isEmpty(localDownloadInfo.e)) {
          break label288;
        }
      }
      for (localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.b;; localObject1 = localDownloadInfo.e)
      {
        localDownloadInfo.e = ((String)localObject1);
        break;
        localObject1 = localDownloadInfo.c;
        break label187;
        localObject1 = localDownloadInfo.d;
        break label210;
        localObject1 = localDownloadInfo.jdField_g_of_type_JavaLangString;
        break label233;
      }
      if (IntentFactory.b.equals(this.b))
      {
        DownloadManager.a().a(localDownloadInfo);
        return;
      }
      if (IntentFactory.d.equals(this.b))
      {
        DownloadManager.a().a(localDownloadInfo);
        return;
      }
      if (IntentFactory.e.equals(this.b))
      {
        AppUtil.a(this.jdField_a_of_type_AndroidContentContext, DownloadManager.a().a(this.jdField_a_of_type_JavaLangString));
        return;
      }
    } while ((!IntentFactory.jdField_g_of_type_JavaLangString.equals(this.b)) || (!MyAppApi.a().c()) || (localDownloadInfo == null) || (localDownloadInfo.h != 1));
    label272:
    label280:
    label288:
    label296:
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a == null) {}
    for (Object localObject1 = new Bundle();; localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a.getExtras())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putString(DownloadConstants.jdField_a_of_type_JavaLangString, localDownloadInfo.b);
      ((Bundle)localObject2).putString(DownloadConstants.b, localDownloadInfo.i);
      ((Bundle)localObject2).putString(DownloadConstants.c, localDownloadInfo.j);
      ((Bundle)localObject2).putString(DownloadConstants.e, localDownloadInfo.d);
      ((Bundle)localObject2).putInt(DownloadConstants.d, localDownloadInfo.jdField_g_of_type_Int);
      MyAppApi.a().a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), (Bundle)localObject2, true, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fft
 * JD-Core Version:    0.7.0.1
 */