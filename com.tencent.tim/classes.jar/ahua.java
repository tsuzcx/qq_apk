import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper.3;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ahua
{
  public static String bLN = "https://i.gtimg.cn/channel/imglib/201909/upload_368e2679238424e3f9df9be7353e26f8.zip";
  public static PreloadManager.d c = new ahub();
  
  public static FullPopData a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    try
    {
      if (((!(paramMessageRecord instanceof MessageForArkApp)) && (!(paramMessageRecord instanceof MessageForPubAccount)) && (!(paramMessageRecord instanceof MessageForStructing))) || (TextUtils.isEmpty(paramMessageRecord.extStr))) {
        break label147;
      }
      paramMessageRecord = new JSONObject(paramMessageRecord.extStr).optString("report_key_bytes_oac_msg_extend", "");
      if (TextUtils.isEmpty(paramMessageRecord)) {
        break label147;
      }
      paramMessageRecord = new JSONObject(paramMessageRecord).optString("game_extra", "");
      if (TextUtils.isEmpty(paramMessageRecord)) {
        break label147;
      }
      paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("full_pop");
      paramMessageRecord = new FullPopData(paramMessageRecord.optString("url"), paramMessageRecord.optString("jump_url"), paramMessageRecord.optLong("begin_time"), paramMessageRecord.optLong("end_time"), paramMessageRecord.optString("id", ""));
    }
    catch (Throwable paramMessageRecord)
    {
      for (;;)
      {
        paramMessageRecord.printStackTrace();
        paramMessageRecord = null;
      }
    }
    return paramMessageRecord;
  }
  
  public static void a(int paramInt1, QQGameMsgInfo paramQQGameMsgInfo, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 1, new Object[] { "publicAccountTianshuReport---> action=" + paramInt1, "   position=" + paramInt2 });
    }
    if (paramQQGameMsgInfo == null) {}
    String str;
    do
    {
      return;
      if (paramInt1 == 117) {
        adak.ae(paramQQGameMsgInfo.frienduin, paramQQGameMsgInfo.uniseq);
      }
      str = "";
      if (!TextUtils.isEmpty(paramQQGameMsgInfo.advId)) {
        str = paramQQGameMsgInfo.advId;
      }
    } while (TextUtils.isEmpty(str));
    adak.F(paramInt1, paramInt2, str);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, PreloadManager.d paramd, boolean paramBoolean)
  {
    int i = aqiw.getSystemNetwork(paramAppInterface.getApplication());
    if (((i == 1) || (i == 4)) && (!TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameHelper", 1, "---->dowloadFullPopRes");
      }
      paramAppInterface = new DownloadParam();
      paramAppInterface.url = paramString;
      paramAppInterface.isPreDownload = paramBoolean;
      PreloadManager.a().a(paramAppInterface, paramd);
    }
  }
  
  private static boolean aob()
  {
    if (!ahty.aoa()) {
      QLog.i("QQGameHelper", 2, "===can't preLoad because config switch is not open===");
    }
    while (ahty.Fl() <= 0) {
      return false;
    }
    long l = gj();
    if (NetConnInfoCenter.getServerTimeMillis() - l < ahty.Fl() * 24 * 60 * 60 * 1000)
    {
      QLog.i("QQGameHelper", 2, "===can't preLoad because time is not in===" + BaseApplicationImpl.processName);
      return false;
    }
    return true;
  }
  
  public static int c(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null) {
      return -1;
    }
    int i = ((LinearLayoutManager)paramRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    paramRecyclerView = paramRecyclerView.getLayoutManager().findViewByPosition(i);
    if (paramRecyclerView != null) {
      return i * paramRecyclerView.getHeight() - paramRecyclerView.getTop();
    }
    return -1;
  }
  
  public static void dqd()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGameHelper", 1, "===preloadSw===");
    }
    arcj.a().a(new ahuc(4096));
  }
  
  public static void dqe()
  {
    ThreadManagerV2.executeOnSubThread(new QQGameHelper.3());
  }
  
  public static void er(Context paramContext)
  {
    Intent localIntent = y();
    if (ahty.anZ())
    {
      PublicFragmentActivityForTool.start(paramContext, localIntent, QQGameFeedWebFragment.class);
      dqe();
      return;
    }
    PublicFragmentActivity.start(paramContext, localIntent, QQGamePubAccountFragment.class);
  }
  
  public static void es(Context paramContext)
  {
    Intent localIntent = y();
    if (ahty.anZ())
    {
      PublicFragmentActivityForTool.startForResult((Activity)paramContext, localIntent, QQGameFeedWebFragment.class, 10000);
      dqe();
      return;
    }
    PublicFragmentActivity.startForResult((Activity)paramContext, localIntent, QQGamePubAccountFragment.class, 10000);
  }
  
  public static AppRuntime getAppRuntime()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static long gi()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return localBaseApplicationImpl.getSharedPreferences("game_center_sp", 0).getLong(localBaseApplicationImpl.getRuntime().getAccount() + "fullpop_time", 0L);
  }
  
  public static long gj()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return localBaseApplicationImpl.getSharedPreferences("game_center_sp_mutiprocess", 4).getLong(localBaseApplicationImpl.getRuntime().getAccount() + "preload_time", 0L);
  }
  
  public static void jX(long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp", 0);
    localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "fullpop_time";
    localSharedPreferences.edit().putLong((String)localObject, paramLong).commit();
  }
  
  public static void jY(long paramLong)
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp_mutiprocess", 4);
        localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "preload_time";
        localSharedPreferences.edit().putLong((String)localObject, paramLong).apply();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGameHelper", 2, QLog.getStackTraceString(localThrowable));
    }
  }
  
  public static void kY(List<MessageRecord> paramList)
  {
    if ((!ahty.anY()) || (!ahty.anZ())) {
      break label12;
    }
    label12:
    while (paramList == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramList.size() <= 0) {
          break label12;
        }
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject = (MessageRecord)paramList.next();
          if (!"2747277822".equals(((MessageRecord)localObject).frienduin)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQGameHelper", 1, "enter qqgame message handle");
          }
          paramList = QQGameMsgInfo.parseMessageRecord((MessageRecord)localObject);
          if (paramList == null) {
            break label203;
          }
          localArrayList.add(paramList);
        }
        if (localArrayList.size() <= 0) {
          break label12;
        }
        paramList = new Intent("action_qgame_tool_messgae");
        paramList.setPackage(BaseApplicationImpl.getApplication().getPackageName());
        Object localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_get_msg", localArrayList);
        paramList.putExtras((Bundle)localObject);
        BaseApplicationImpl.getApplication().sendBroadcast(paramList);
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQGameHelper", 1, "send qqgame message fail by:" + paramList.getMessage());
      return;
      label203:
      if (QLog.isColorLevel()) {
        QLog.d("QQGameHelper", 1, "parse qqgame message fail");
      }
    }
  }
  
  public static int rM()
  {
    Object localObject = getAppRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if ((((QQAppInterface)localObject).b() == null) || (((QQAppInterface)localObject).b().a() == null)) {
        return 0;
      }
      return ((QQAppInterface)localObject).b().a().A("2747277822", 1008);
    }
    return 0;
  }
  
  public static String wJ()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return localBaseApplicationImpl.getSharedPreferences("game_center_sp", 0).getString(localBaseApplicationImpl.getRuntime().getAccount() + "fullpop_id", "");
  }
  
  public static Intent y()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("settingInfo", "");
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    localIntent.putExtra("moduleId", "cmshowgame_module");
    localIntent.putExtra("startTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("unreadNum", rM());
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahua
 * JD-Core Version:    0.7.0.1
 */