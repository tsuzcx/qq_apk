import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.CreateColumnFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.EditColumnFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab.SelectVideoTabFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public class mix
{
  public static boolean DH()
  {
    return (pk() == 1) && (!awit.aNa());
  }
  
  public static boolean DI()
  {
    if (pk() == 2) {
      return true;
    }
    if (pk() == 1) {
      return awit.aNa();
    }
    return false;
  }
  
  public static boolean DJ()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (DI()) {
      if (Aladdin.getConfig(277).getIntegerFromString("ugc_topic_create_entrance", 0) == 0) {
        break label43;
      }
    }
    label43:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        bool1 = bool2;
        if (!DK()) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public static boolean DK()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (DI())
    {
      bool1 = bool2;
      if (Aladdin.getConfig(277).getIntegerFromString("ugc_video_upload_entrance", 0) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean DL()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (DI())
    {
      bool1 = bool2;
      if (Aladdin.getConfig(277).getIntegerFromString("add_to_column_entrance", 0) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean DM()
  {
    return DJ();
  }
  
  public static boolean DN()
  {
    return DK();
  }
  
  public static boolean DO()
  {
    return Aladdin.getConfig(281).getIntegerFromString("ugc_video_publish_reproduce_default", 1) != 0;
  }
  
  public static void Q(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from", paramInt);
    PublicFragmentActivity.start(paramContext, localIntent, CreateColumnFragment.class);
  }
  
  public static String Z(Context paramContext)
  {
    return Aladdin.getConfig(277).getString("ugc_topic_create_text", "");
  }
  
  private static int a(UgcVideo paramUgcVideo)
  {
    if ((paramUgcVideo.status == UgcVideo.STATUS_IDLE) || (paramUgcVideo.status == UgcVideo.STATUS_PAUSE)) {}
    do
    {
      return 8;
      if (paramUgcVideo.status != UgcVideo.STATUS_UPLOADING) {
        break;
      }
      if (paramUgcVideo.uploadVideoStatus == UgcVideo.SUBSTATUS_COMPRESS_VIDEO) {
        return 1;
      }
    } while (paramUgcVideo.uploadVideoStatus != UgcVideo.SUBSTATUS_UPLOADING_VIDEO);
    return 6;
    if (paramUgcVideo.status == UgcVideo.STATUS_FINISH) {
      return 13;
    }
    if (paramUgcVideo.status == UgcVideo.STATUS_FAILED) {
      return 9;
    }
    return 0;
  }
  
  public static long a(@NotNull UgcVideo paramUgcVideo)
  {
    long l = paramUgcVideo.fileSize - paramUgcVideo.videoProgress * paramUgcVideo.fileSize / 100L;
    if (l < 0L) {
      return 0L;
    }
    return l;
  }
  
  @NotNull
  public static String a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str = bq(paramInt);
    if ((str.isEmpty()) || (paramQQAppInterface == null)) {
      paramContext = "";
    }
    do
    {
      return paramContext;
      str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(str, "");
      if (str == null) {
        break;
      }
      paramContext = str;
    } while (!str.isEmpty());
    return f(paramInt, awit.z(paramQQAppInterface));
  }
  
  @NotNull
  public static kxm.b a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    return new kxm.b().a("uin", paramQQAppInterface.getCurrentAccountUin()).a("page_type", Integer.valueOf(paramInt1)).a("secret_flag", Integer.valueOf(paramInt2));
  }
  
  @NotNull
  public static kxm.b a(@Nullable QQAppInterface paramQQAppInterface, @NotNull UgcVideo paramUgcVideo)
  {
    String str = "";
    if (paramQQAppInterface != null) {
      str = paramQQAppInterface.getCurrentAccountUin();
    }
    return new kxm.b().a("uin", str).a("seqId", paramUgcVideo.seqId).a("file_size", Long.valueOf(paramUgcVideo.fileSize)).a("format", eR(paramUgcVideo.filePath)).a("bit_rate", Long.valueOf(paramUgcVideo.bitrate)).a("heigth", Integer.valueOf(paramUgcVideo.height)).a("width", Integer.valueOf(paramUgcVideo.width)).a("video_duration", Integer.valueOf(paramUgcVideo.duration));
  }
  
  public static void a(Activity paramActivity, int paramInt1, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, int paramInt2)
  {
    paramString1 = new ColumnInfo(paramInt1, paramString1, paramString2, paramString3);
    paramString2 = new Intent();
    paramString2.putExtra("key_column_info", paramString1);
    if (paramString4 != null)
    {
      paramString2.putExtra("arg_callback", paramString4);
      paramString2.putExtra("key_from", 3);
    }
    PublicFragmentActivity.startForResult(paramActivity, paramString2, EditColumnFragment.class, paramInt2);
  }
  
  public static void a(Activity paramActivity, @Nullable ColumnInfo paramColumnInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramColumnInfo != null) {
      localIntent.putExtra("key_column_info", paramColumnInfo);
    }
    localIntent.putExtra("key_from", paramInt);
    if ((paramInt == 1) || (paramInt == 2)) {
      PublicFragmentActivity.start(paramActivity, localIntent, SelectVideoFragment.class);
    }
    while ((paramInt != 3) && (paramInt != 4)) {
      return;
    }
    PublicFragmentActivity.start(paramActivity, localIntent, SelectVideoTabFragment.class);
  }
  
  public static void a(Activity paramActivity, @Nullable ColumnInfo paramColumnInfo, int paramInt1, @Nullable String paramString, int paramInt2)
  {
    Intent localIntent = new Intent();
    if (paramColumnInfo != null) {
      localIntent.putExtra("key_column_info", paramColumnInfo);
    }
    localIntent.putExtra("key_from", paramInt1);
    if (paramString != null) {
      localIntent.putExtra("arg_callback", paramString);
    }
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      PublicFragmentActivity.startForResult(paramActivity, localIntent, SelectVideoFragment.class, paramInt2);
    }
    while ((paramInt1 != 3) && (paramInt1 != 4)) {
      return;
    }
    PublicFragmentActivity.startForResult(paramActivity, localIntent, SelectVideoTabFragment.class, paramInt2);
  }
  
  public static void a(@NotNull Context paramContext, long paramLong, @NotNull mix.a parama, @Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramContext = aqha.a(paramContext, 230).setMessage(paramContext.getResources().getString(2131718545, new Object[] { au(paramLong) })).setNegativeButton(paramContext.getResources().getString(2131718380), new miz(parama)).setPositiveButton(paramContext.getResources().getString(2131718456), new miy(parama));
    if (paramOnDismissListener != null) {
      paramContext.setOnDismissListener(new mja(paramOnDismissListener));
    }
    paramContext.show();
  }
  
  public static void a(String paramString, UgcVideo paramUgcVideo)
  {
    long l1 = 0L;
    long l2 = System.currentTimeMillis() - paramUgcVideo.startUploadingTime;
    paramUgcVideo.uploadTotalCostTime += l2;
    if (paramUgcVideo.startUserWaitingTime > 0L)
    {
      l1 = System.currentTimeMillis() - paramUgcVideo.startUserWaitingTime;
      paramUgcVideo.userWaitingTotalCostTime += l1;
    }
    QLog.i("RIJUGC.RIJUgcUtils", 1, "calculateUploadingCost," + paramString + ", cost=" + l2 + ",totalCost=" + paramUgcVideo.uploadTotalCostTime + ", waitingCost=" + l1 + ", totalWaitingCost=" + paramUgcVideo.userWaitingTotalCostTime);
  }
  
  public static boolean a(@Nullable QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    while ((!DL()) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  public static String aa(Context paramContext)
  {
    return Aladdin.getConfig(277).getString("ugc_video_create_text", "");
  }
  
  public static String ac(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_and_remind_title", paramContext.getResources().getString(2131718463));
  }
  
  public static String ad(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_and_remind_tips", paramContext.getResources().getString(2131718464));
  }
  
  public static String ae(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_title", paramContext.getResources().getString(2131718462));
  }
  
  public static String af(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_tips", paramContext.getResources().getString(2131718465));
  }
  
  public static String ag(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_private_title", paramContext.getResources().getString(2131718450));
  }
  
  public static String ah(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_private_tips", paramContext.getResources().getString(2131718451));
  }
  
  public static String au(long paramLong)
  {
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    if (paramLong < 1048576L) {
      return String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F) }) + "KB";
    }
    if (paramLong < 1073741824L) {
      return String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) }) + "MB";
    }
    return String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) }) + "GB";
  }
  
  public static long b(@NotNull List<UgcVideo> paramList)
  {
    if (paramList.isEmpty()) {
      return 0L;
    }
    paramList = paramList.iterator();
    for (long l = 0L; paramList.hasNext(); l = a((UgcVideo)paramList.next()) + l) {}
    return l;
  }
  
  @NotNull
  private static String bq(int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "readinjoy_sp_key_mycolumn_entry";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return "readinjoy_sp_key_myvideo_entry";
      }
    } while (paramInt != 3);
    return "readinjoy_sp_key_mysubscribe_entry";
  }
  
  public static JSONArray d(@NotNull List<UgcVideo> paramList)
  {
    localJSONArray = new JSONArray();
    try
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        UgcVideo localUgcVideo = (UgcVideo)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("vid", String.valueOf(localUgcVideo.seqId));
        localJSONObject.put("status", a(localUgcVideo));
        localJSONObject.put("totalSize", au(localUgcVideo.fileSize));
        localJSONObject.put("duration", localUgcVideo.duration);
        localJSONObject.put("title", localUgcVideo.title);
        localJSONObject.put("coverUrl", localUgcVideo.coverUrl);
        localJSONObject.put("compressProgress", localDecimalFormat.format(localUgcVideo.compressProgress * 1.0F / 100.0F));
        localJSONObject.put("uploadingProgress", localDecimalFormat.format(localUgcVideo.videoProgress * 1.0F / 100.0F));
        localJSONObject.put("networkSpeed", localUgcVideo.uploadSpeed);
        localJSONObject.put("uploadSize", au(localUgcVideo.fileSize * localUgcVideo.videoProgress / 100L));
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      QLog.i("RIJUGC.RIJUgcUtils", 1, "getUploadVideoListForViola exception, e=" + QLog.getStackTraceString(paramList));
    }
  }
  
  public static void e(Context paramContext, int paramInt, String paramString)
  {
    String str = bq(paramInt);
    if (str.isEmpty()) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(str, paramString);
    paramContext.apply();
  }
  
  @NotNull
  public static String eR(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length() - 1)) {
      return "";
    }
    return paramString.substring(i + 1, paramString.length()).toLowerCase();
  }
  
  @NotNull
  private static String f(int paramInt, boolean paramBoolean)
  {
    String str = "";
    if (paramBoolean) {
      if (paramInt == 1) {
        str = "https://viola.qq.com/js/columnMyColumn.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=2&v_bundleName=columnMyColumn&v_bid=3740";
      }
    }
    do
    {
      do
      {
        return str;
        if (paramInt == 2) {
          return "https://viola.qq.com/js/columnMyVideo.js?_rij_violaUrl=1&v_tid=2&hideNav=1&v_nav_immer=1&v_bundleName=columnMyVideo";
        }
      } while (paramInt != 3);
      return "https://viola.qq.com/js/columnMySub.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=2&v_bundleName=columnMySub&v_bid=3740";
      if (paramInt == 1) {
        return "https://viola.qq.com/js/columnMyColumn.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bundleName=columnMyColumn&v_bid=3740";
      }
      if (paramInt == 2) {
        return "https://viola.qq.com/js/columnMyVideo.js?_rij_violaUrl=1&v_tid=6&hideNav=1&v_nav_immer=1&v_bundleName=columnMyVideo&v_bid=3740";
      }
    } while (paramInt != 3);
    return "https://viola.qq.com/js/columnMySub.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bundleName=columnMySub&v_bid=3740";
  }
  
  public static void g(Activity paramActivity, @Nullable String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramString != null)
    {
      localIntent.putExtra("arg_callback", paramString);
      localIntent.putExtra("key_from", 1);
    }
    PublicFragmentActivity.startForResult(paramActivity, CreateColumnFragment.class, paramInt);
  }
  
  public static void h(@Nullable Activity paramActivity, String paramString, int paramInt)
  {
    if ((paramActivity instanceof FragmentActivity))
    {
      Object localObject1 = (ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290);
      Object localObject2 = new FrameLayout(paramActivity);
      ((FrameLayout)localObject2).setId(2131376731);
      ((ViewGroup)localObject1).addView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
      localObject1 = new SelectTopicFragment();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_rowKey", paramString);
      ((Bundle)localObject2).putInt("key_from", paramInt);
      ((Bundle)localObject2).putInt("fragment_view_id", 2131376731);
      ((Fragment)localObject1).setArguments((Bundle)localObject2);
      ((FragmentActivity)paramActivity).getSupportFragmentManager().beginTransaction().replace(2131376731, (Fragment)localObject1).commit();
    }
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface)
  {
    return (awit.x(paramQQAppInterface) != 0) || (DJ()) || (DK());
  }
  
  public static String ka()
  {
    String str = Aladdin.getConfig(284).getString("ugc_topic_detail_page_url", "");
    if (!str.isEmpty()) {
      try
      {
        str = URLDecoder.decode(str, "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.e("RIJUGC.RIJUgcUtils", 1, "getViolaColumnDetailPageUrl decode fail. e : " + localUnsupportedEncodingException.toString());
        return "https://viola.qq.com/js/topic-detail.js?_rij_violaUrl=1&v_tid=2&v_bundleName=topic-detail&hideNav=1&v_nav_immer=1&statusColor=1&from_page=4&topicId=";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJUGC.RIJUgcUtils", 2, "getViolaColumnDetailPageUrl from aladdin fail.");
    }
    return "https://viola.qq.com/js/topic-detail.js?_rij_violaUrl=1&v_tid=2&v_bundleName=topic-detail&hideNav=1&v_nav_immer=1&statusColor=1&from_page=4&topicId=";
  }
  
  public static String kb()
  {
    String str = Aladdin.getConfig(284).getString("ugc_my_video_list_page_url", "");
    if (!str.isEmpty()) {
      try
      {
        str = URLDecoder.decode(str, "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.e("RIJUGC.RIJUgcUtils", 1, "getViolaMyVideoListPageUrl decode fail. e : " + localUnsupportedEncodingException.toString());
        return "https://viola.qq.com/js/columnAddVideo.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=2&v_bundleName=columnAddVideo&v_bid=3740&colid=";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJUGC.RIJUgcUtils", 2, "getViolaMyVideoListPageUrl from aladdin fail.");
    }
    return "https://viola.qq.com/js/columnAddVideo.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=2&v_bundleName=columnAddVideo&v_bid=3740&colid=";
  }
  
  private static int pk()
  {
    return Aladdin.getConfig(277).getIntegerFromString("ugc_video_upload_main_switch", 0);
  }
  
  public static int pl()
  {
    return Aladdin.getConfig(279).getIntegerFromString("ugc_topic_title_max_lengh", 12);
  }
  
  public static int pm()
  {
    return Aladdin.getConfig(279).getIntegerFromString("ugc_topic_brief_max_lengh", 60);
  }
  
  public static int pn()
  {
    return Aladdin.getConfig(279).getIntegerFromString("ugc_video_title_max_length", 36);
  }
  
  public static int po()
  {
    if (Aladdin.getConfig(281).getIntegerFromString("ugc_video_publish_show_reproduce", 0) == 1) {
      return 0;
    }
    return 8;
  }
  
  public static int pp()
  {
    if (Aladdin.getConfig(295).getIntegerFromString("ugc_video_publish_show_public", 0) == 1) {
      return 0;
    }
    return 8;
  }
  
  public static int pq()
  {
    int i = Aladdin.getConfig(295).getIntegerFromString("ugc_video_publish_public_default", 2);
    if (i == 1) {
      return UgcVideo.TYPE_PUBLIC_AND_REMIND;
    }
    if (i == 3) {
      return UgcVideo.TYPE_NO_PUBLIC;
    }
    return UgcVideo.TYPE_PUBLIC;
  }
  
  public static int pr()
  {
    return Aladdin.getConfig(283).getIntegerFromString("create_column_redirect", 2);
  }
  
  public static int ps()
  {
    return Aladdin.getConfig(283).getIntegerFromString("upload_video_redirect", 2);
  }
  
  public static abstract interface a
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mix
 * JD-Core Version:    0.7.0.1
 */