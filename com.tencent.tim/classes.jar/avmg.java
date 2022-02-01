import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class avmg
  extends RemoteCommand
{
  public avmg()
  {
    super("qqreader_plugin_cmd");
  }
  
  private void ZV(String paramString)
  {
    QQAppInterface localQQAppInterface = getAppInterface();
    try
    {
      int i = BaseApplicationImpl.getApplication().appActivities.size();
      if (i > 0)
      {
        Activity localActivity = (Activity)((WeakReference)BaseApplicationImpl.getApplication().appActivities.get(i - 1)).get();
        if (localActivity != null)
        {
          c(localQQAppInterface, localActivity, ahav.a(new FileInfo(paramString)));
          return;
        }
        avoc.e("QRRemoteCommond", "No Activity to use to forward file");
        return;
      }
    }
    catch (FileNotFoundException paramString)
    {
      avoc.e("QRRemoteCommond", "file not found", paramString);
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null)) {}
    while (paramFileManagerEntity == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = ahav.d().longValue();
    paramQQAppInterface.a().v(localFileManagerEntity);
    int i = ahhq.e(paramFileManagerEntity);
    paramFileManagerEntity = ahhq.a(localFileManagerEntity);
    paramFileManagerEntity.setType(i);
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("forward_type", 0);
    paramQQAppInterface.putParcelable("fileinfo", paramFileManagerEntity);
    paramQQAppInterface.putBoolean("not_forward", true);
    paramFileManagerEntity = new Intent();
    paramFileManagerEntity.putExtras(paramQQAppInterface);
    paramFileManagerEntity.putExtra("destroy_last_activity", false);
    paramFileManagerEntity.putExtra("forward_type", 0);
    paramFileManagerEntity.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
    paramFileManagerEntity.putExtra("forward_text", acfp.m(2131711127) + ahav.kY(localFileManagerEntity.fileName) + acfp.m(2131711139) + ahbj.g(localFileManagerEntity.fileSize) + "。");
    paramFileManagerEntity.putExtra("k_favorites", ahav.q(localFileManagerEntity));
    if ((!ahbj.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) && ((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7)) && (localFileManagerEntity.nFileType == 0)) {
      paramFileManagerEntity.putExtra("forward_type", 0);
    }
    if ((localFileManagerEntity.getCloudType() == 8) && (localFileManagerEntity.nFileType == 0)) {
      paramFileManagerEntity.putExtra("forward_type", 1);
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      ahao.OS(2131693819);
      return;
    }
    if (agzy.a(localFileManagerEntity).bd(false))
    {
      ahal.a(paramActivity, 2131693826, 2131693832, new avmh(this, paramActivity, paramFileManagerEntity));
      return;
    }
    ahgq.f(paramActivity, paramFileManagerEntity, 103);
  }
  
  private QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = null;
    Object localObject2 = new Bundle();
    Object localObject1 = (acja)getAppInterface().getManager(56);
    switch (paramBundle.getInt("CommondType"))
    {
    default: 
    case 13: 
      for (;;)
      {
        return null;
        ZV(paramBundle.getString("KEY_FILE_PATH"));
      }
    case 1: 
      if (paramBundle == null) {
        break;
      }
    }
    for (paramBundle = paramBundle.getString("uin"); localObject1 != null; paramBundle = null)
    {
      for (;;)
      {
        if (((acja)localObject1).b(paramBundle) != null) {
          ((Bundle)localObject2).putBoolean("get_publicaccountinfo", true);
        }
        for (;;)
        {
          return localObject2;
          ((Bundle)localObject2).putBoolean("get_publicaccountinfo", false);
        }
        ((Bundle)localObject2).putInt("qq_vip_level", avmi.u(getAppInterface(), null));
        return localObject2;
        ((Bundle)localObject2).putShort("qq_vip_info", avmi.a(getAppInterface(), null));
        return localObject2;
        if (getAppInterface() == null) {
          break;
        }
        paramBundle = paramBundle.getString("publicaccount_uin");
        ((Bundle)localObject2).putBoolean("publicaccount_is_follow", ocp.c(getAppInterface(), paramBundle));
        return localObject2;
        if (getAppInterface() == null) {
          break;
        }
        localObject1 = paramBundle.getString("publicaccount_uin");
        Object localObject3 = (acja)getAppInterface().getManager(56);
        paramBundle = paramOnInvokeFinishLinstener;
        if (localObject3 != null) {
          paramBundle = ((acja)localObject3).b((String)localObject1);
        }
        if (paramBundle != null)
        {
          ((Bundle)localObject2).putBoolean("isFollow", true);
          ((Bundle)localObject2).putString("paName", paramBundle.name);
        }
        for (;;)
        {
          return localObject2;
          ((Bundle)localObject2).putBoolean("isFollow", false);
        }
        int i = paramBundle.getInt("sharetype");
        paramOnInvokeFinishLinstener = paramBundle.getString("url");
        localObject3 = (Bitmap)paramBundle.getParcelable("cover");
        Object localObject5 = paramBundle.getString("title");
        localObject1 = paramBundle.getString("detail");
        Object localObject4 = paramBundle.getString("imgUrl");
        switch (i)
        {
        default: 
        case 1: 
        case 2: 
          for (;;)
          {
            return localObject2;
            paramBundle = new Bundle();
            paramBundle.putString("title", (String)localObject5);
            paramBundle.putString("desc", (String)localObject1);
            paramBundle.putString("detail_url", paramOnInvokeFinishLinstener);
            paramOnInvokeFinishLinstener = new ArrayList(1);
            paramOnInvokeFinishLinstener.add(localObject4);
            paramBundle.putStringArrayList("image_url", paramOnInvokeFinishLinstener);
            avqq.a(getAppInterface(), getAppInterface().getApplication().getApplicationContext(), paramBundle, null);
            continue;
            localObject4 = WXShareHelper.a();
            l = System.currentTimeMillis();
            if (TextUtils.isEmpty(paramBundle.getString("detail"))) {
              localObject1 = paramOnInvokeFinishLinstener;
            }
            ((WXShareHelper)localObject4).d(String.valueOf(l), (String)localObject5, (Bitmap)localObject3, (String)localObject1, paramOnInvokeFinishLinstener);
          }
        }
        localObject4 = WXShareHelper.a();
        long l = System.currentTimeMillis();
        localObject5 = new StringBuilder().append((String)localObject5).append(":");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (paramBundle = paramOnInvokeFinishLinstener;; paramBundle = (Bundle)localObject1)
        {
          localObject5 = paramBundle;
          paramBundle = (Bundle)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramBundle = paramOnInvokeFinishLinstener;
          }
          ((WXShareHelper)localObject4).c(String.valueOf(l), (String)localObject5, (Bitmap)localObject3, paramBundle, paramOnInvokeFinishLinstener);
          break;
        }
        if ((WXShareHelper.a().isWXinstalled()) && (WXShareHelper.a().isWXsupportApi())) {
          ((Bundle)localObject2).putBoolean("is_wx_supported", true);
        }
        for (;;)
        {
          return localObject2;
          ((Bundle)localObject2).putBoolean("is_wx_supported", false);
        }
        paramBundle = paramBundle.getString("url");
        paramBundle = new Intent(getAppInterface().getApplication().getApplicationContext(), QQBrowserActivity.class).putExtra("url", paramBundle);
        paramBundle.putExtra("uin", getAppInterface().getCurrentAccountUin());
        paramBundle.putExtra("vkey", getAppInterface().rK());
        paramBundle.setFlags(268435456);
        getAppInterface().getApplication().getApplicationContext().startActivity(paramBundle);
        break;
        paramOnInvokeFinishLinstener = getAppInterface();
        if (paramOnInvokeFinishLinstener != null)
        {
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.getHandler(Conversation.class);
          if (paramOnInvokeFinishLinstener == null) {
            break;
          }
          localObject1 = paramOnInvokeFinishLinstener.obtainMessage(1134027);
          localObject2 = paramBundle.getString("bookName");
          l = paramBundle.getLong("bookId");
          paramBundle = paramBundle.getString("chapterId");
          paramBundle = (String)localObject2 + "@#" + l + "@#" + paramBundle;
          if (QLog.isColorLevel()) {
            QLog.e("QRRemoteCommond", 2, "bookInfo : " + paramBundle);
          }
          ((Message)localObject1).obj = paramBundle;
          paramOnInvokeFinishLinstener.sendMessage((Message)localObject1);
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("QRRemoteCommond", 2, "showReaderBar app = null");
        break;
        paramOnInvokeFinishLinstener = getAppInterface();
        if (paramOnInvokeFinishLinstener != null)
        {
          paramOnInvokeFinishLinstener = (altq)paramOnInvokeFinishLinstener.getManager(36);
          if (paramOnInvokeFinishLinstener != null)
          {
            paramBundle = paramOnInvokeFinishLinstener.getAppInfoByPath(paramBundle.getString("path"));
            if (paramBundle != null) {
              ((Bundle)localObject2).putParcelable("redTouchInfo", altt.a(paramBundle));
            }
          }
        }
        for (;;)
        {
          return localObject2;
          if (QLog.isColorLevel()) {
            QLog.e("QRRemoteCommond", 2, "getRedTouch app = null");
          }
        }
        paramOnInvokeFinishLinstener = getAppInterface();
        if (paramOnInvokeFinishLinstener == null) {
          break label1079;
        }
        paramOnInvokeFinishLinstener = (altq)paramOnInvokeFinishLinstener.getManager(36);
        if (paramOnInvokeFinishLinstener == null) {
          break;
        }
        paramBundle = paramBundle.getString("path");
        paramOnInvokeFinishLinstener.OS(paramBundle);
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("service_type", 2);
          ((JSONObject)localObject1).put("act_id", 1002);
          paramOnInvokeFinishLinstener.h(paramOnInvokeFinishLinstener.getAppInfoByPath(paramBundle), ((JSONObject)localObject1).toString());
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
      break;
      label1079:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QRRemoteCommond", 2, "clickRedTouch app = null");
      break;
      paramOnInvokeFinishLinstener = getAppInterface();
      if (paramOnInvokeFinishLinstener == null) {
        break;
      }
      paramOnInvokeFinishLinstener = (altq)paramOnInvokeFinishLinstener.getManager(36);
      localObject1 = paramBundle.getStringArrayList("pathList");
      if ((paramOnInvokeFinishLinstener == null) || (localObject1 == null)) {
        break;
      }
      paramBundle = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = paramOnInvokeFinishLinstener.getAppInfoByPath((String)((Iterator)localObject1).next());
        if (localObject2 != null) {
          paramBundle.add(altt.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
        }
      }
      paramOnInvokeFinishLinstener = new Bundle();
      paramOnInvokeFinishLinstener.putParcelableArrayList("redTouchInfoList", paramBundle);
      return paramOnInvokeFinishLinstener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmg
 * JD-Core Version:    0.7.0.1
 */