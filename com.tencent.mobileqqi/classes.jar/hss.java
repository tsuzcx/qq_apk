import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.common.DownloadReceiver;
import com.tencent.open.downloadnew.common.IntentFactory;
import com.tencent.open.downloadnew.common.NoticeParam;

public class hss
  implements Runnable
{
  public hss(DownloadReceiver paramDownloadReceiver, String paramString1, NoticeParam paramNoticeParam, String paramString2, Context paramContext) {}
  
  public void run()
  {
    Object localObject2 = DownloadManager.a().a(this.jdField_a_of_type_JavaLangString);
    boolean bool;
    if (localObject2 == null) {
      if ((this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d != null) && (!this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d.trim().equals("")))
      {
        bool = true;
        localObject2 = new DownloadInfo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.e, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.b, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a, 0, bool);
        if (!IntentFactory.c.equals(this.b)) {
          break label296;
        }
        localObject1 = DownloadManager.a().a(this.jdField_a_of_type_JavaLangString);
        if ((localObject1 != null) && (((DownloadInfo)localObject1).a() != 2) && (((DownloadInfo)localObject1).a() != 20))
        {
          ((DownloadInfo)localObject2).a(3);
          DownloadManager.a().a(3, (DownloadInfo)localObject2);
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
      if (TextUtils.isEmpty(((DownloadInfo)localObject2).c))
      {
        localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.e;
        ((DownloadInfo)localObject2).c = ((String)localObject1);
        if (!TextUtils.isEmpty(((DownloadInfo)localObject2).d)) {
          break label272;
        }
        localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d;
        ((DownloadInfo)localObject2).d = ((String)localObject1);
        if (!TextUtils.isEmpty(((DownloadInfo)localObject2).jdField_g_of_type_JavaLangString)) {
          break label280;
        }
        localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_g_of_type_JavaLangString;
        ((DownloadInfo)localObject2).jdField_g_of_type_JavaLangString = ((String)localObject1);
        if (!TextUtils.isEmpty(((DownloadInfo)localObject2).e)) {
          break label288;
        }
      }
      for (localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.b;; localObject1 = ((DownloadInfo)localObject2).e)
      {
        ((DownloadInfo)localObject2).e = ((String)localObject1);
        break;
        localObject1 = ((DownloadInfo)localObject2).c;
        break label187;
        localObject1 = ((DownloadInfo)localObject2).d;
        break label210;
        localObject1 = ((DownloadInfo)localObject2).jdField_g_of_type_JavaLangString;
        break label233;
      }
      if (IntentFactory.b.equals(this.b))
      {
        DownloadManager.a().a((DownloadInfo)localObject2);
        return;
      }
      if (IntentFactory.d.equals(this.b))
      {
        DownloadManager.a().a((DownloadInfo)localObject2);
        return;
      }
      if (IntentFactory.e.equals(this.b))
      {
        AppUtil.a(this.jdField_a_of_type_AndroidContentContext, DownloadManager.a().a(this.jdField_a_of_type_JavaLangString));
        return;
      }
    } while (!IntentFactory.jdField_g_of_type_JavaLangString.equals(this.b));
    label272:
    label280:
    label288:
    label296:
    if ((MyAppApi.a().c()) && (localObject2 != null) && (((DownloadInfo)localObject2).h == 1))
    {
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a == null) {}
      for (localObject1 = new Bundle();; localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a.getExtras())
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Bundle();
        }
        ((Bundle)localObject3).putString(DownloadConstants.jdField_a_of_type_JavaLangString, ((DownloadInfo)localObject2).b);
        ((Bundle)localObject3).putString(DownloadConstants.b, ((DownloadInfo)localObject2).i);
        ((Bundle)localObject3).putString(DownloadConstants.c, ((DownloadInfo)localObject2).j);
        ((Bundle)localObject3).putString(DownloadConstants.e, ((DownloadInfo)localObject2).d);
        ((Bundle)localObject3).putInt(DownloadConstants.d, ((DownloadInfo)localObject2).jdField_g_of_type_Int);
        MyAppApi.a().a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), (Bundle)localObject3, true, true);
        return;
      }
    }
    Object localObject3 = new Intent();
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a == null) {}
    for (Object localObject1 = new Bundle();; localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.a.getExtras())
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Intent)localObject3).putExtras((Bundle)localObject2);
      ((Intent)localObject3).setClass(CommonDataAdapter.a().a(), QZoneAppWebViewActivity.class);
      ((Intent)localObject3).addFlags(872415232);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hss
 * JD-Core Version:    0.7.0.1
 */