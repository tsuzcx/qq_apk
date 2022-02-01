package dov.com.qq.im.aeeditor.module.music;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import NS_QQ_STORY_META.META.StMusic;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import aoll;
import aolm;
import aomi;
import aqiw;
import axiy;
import axjj.b.a;
import axnb.a;
import axnc;
import axnd;
import axne;
import axnf;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.richframework.network.request.SmartMusicMatchRequest;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.a;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.weseevideo.model.data.MusicData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONObject;
import rxc.a;

public class AEEditorMusicHelper
{
  @Nullable
  public static VsMusicItemInfo a(@NonNull Intent paramIntent)
  {
    axiy.i("AEEditorMusicHelper", "[parseMusicWebData]");
    String str = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    axiy.i("AEEditorMusicHelper", "[parseMusicWebData], eventValue=" + paramIntent);
    if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("kTribeSelectMusic"))) {
      return null;
    }
    axiy.i("AEEditorMusicHelper", "[parseMusicWebData], dataValue=" + str);
    try
    {
      paramIntent = new VsMusicItemInfo(new JSONObject(str));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      axiy.e("AEEditorMusicHelper", "[parseMusicWebData], error=", paramIntent);
    }
    return null;
  }
  
  public static MusicData a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    MusicData localMusicData = new MusicData();
    if ((paramInt1 > 0) && (paramInt1 < paramInt2)) {}
    for (;;)
    {
      localMusicData.setPath(paramString);
      localMusicData.setStartTime(paramInt1);
      localMusicData.setTotalTime(paramInt2);
      localMusicData.setSegDuration(paramInt2 - paramInt1);
      return localMusicData;
      paramInt1 = 0;
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, @NonNull axnb.a parama, @NonNull String paramString1, @NonNull String paramString2, @Nullable a parama1)
  {
    axiy.i("AEEditorMusicHelper", "[downloadMusic], url=" + paramString1 + ", localPath=" + paramString2);
    aoll localaoll = new aoll();
    localaoll.bZ = paramString1;
    localaoll.mHttpMethod = 0;
    localaoll.atY = paramString2;
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    localaoll.mExcuteTimeLimit = 30000L;
    localaoll.f = new axnf(parama1, parama, paramString2);
    try
    {
      paramAppInterface.getNetEngine(0).a(localaoll);
      return;
    }
    catch (Exception paramAppInterface)
    {
      axiy.e("AEEditorMusicHelper", "[downloadMusic], error=" + paramAppInterface);
    }
  }
  
  public static void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, @Nullable FrameVideoHelper.a parama)
  {
    axiy.i("AEEditorMusicHelper", "[extractFrameForSmartMusic], videoPath=" + paramString + ", videoWidth=" + paramInt1 + ", videoHeight=" + paramInt2 + ", videoDuration=" + paramLong1 + ", videoStartOffset=" + paramLong2);
    paramString = new FrameVideoHelper(paramString, paramInt1, paramInt2, paramLong1);
    paramString.a(paramLong2, new axnc(paramString, parama));
  }
  
  public static void a(@NonNull ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, @Nullable SosoInterface.SosoLocation paramSosoLocation, boolean paramBoolean, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt, @Nullable rxc.a<CLIENT.StSmartMatchMusicRsp> parama)
  {
    axiy.i("AEEditorMusicHelper", "[requestRecommendMusicList]");
    paramArrayList = new SmartMusicMatchRequest(paramArrayList, paramSosoLocation, paramBoolean, paramInt, paramLocalMediaInfo);
    long l = System.currentTimeMillis();
    VSNetworkHelper.a().a(paramArrayList, new axnd(parama, l));
  }
  
  public static void a(@NonNull ArrayList<String> paramArrayList, @Nullable rxc.a<CLIENT.StBatchGetMusicInfoRsp> parama)
  {
    axiy.i("AEEditorMusicHelper", "[requestDetailedMusicInfo]");
    long l = System.currentTimeMillis();
    VSNetworkHelper.a().a(new BatchGetMusicInfoRequest(paramArrayList), new axne(parama, l));
  }
  
  public static boolean a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    return (!TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mMusicName)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mUrl)) && (paramVsMusicItemInfo.musicDuration != 0);
  }
  
  @NonNull
  public static String b(@Nullable axnb.a parama)
  {
    axiy.i("AEEditorMusicHelper", "[getLocalMusicPath], editorMusicInfo=" + parama);
    if ((parama == null) || (parama.aPf())) {
      return "";
    }
    return axjj.b.a.cVc + File.separator + parama.getSongMid() + ".m4a";
  }
  
  @NonNull
  public static List<VsMusicItemInfo> bC(@Nullable List<META.StMusic> paramList)
  {
    axiy.i("AEEditorMusicHelper", "[convertToMusicItemList]");
    if (paramList == null) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if (i < paramList.size())
    {
      META.StMusic localStMusic = (META.StMusic)paramList.get(i);
      if (localStMusic == null) {}
      for (;;)
      {
        i += 1;
        break;
        localLinkedList.add(new VsMusicItemInfo(localStMusic));
      }
    }
    return localLinkedList;
  }
  
  public static List<axnb.a> bD(@Nullable List<VsMusicItemInfo> paramList)
  {
    axiy.i("AEEditorMusicHelper", "[assembleEditorMusicInfoList]");
    if (paramList == null) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if (i < paramList.size())
    {
      VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)paramList.get(i);
      if (localVsMusicItemInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        localLinkedList.add(new axnb.a(localVsMusicItemInfo, false));
      }
    }
    return localLinkedList;
  }
  
  public static void gG(@NonNull Context paramContext)
  {
    axiy.i("AEEditorMusicHelper", "[preLoadWebView]");
    Intent localIntent = new Intent(paramContext, PreloadWebService.class);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      axiy.e("AEEditorMusicHelper", "[preLoadWebView], error=", paramContext);
    }
  }
  
  public static void gH(@NonNull Context paramContext)
  {
    axiy.i("AEEditorMusicHelper", "[startMusicWebView]");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { UserAction.getQIMEI(), "", Integer.valueOf(6) }));
    paramContext.startActivity(localIntent);
  }
  
  public static boolean uh(@Nullable String paramString)
  {
    axiy.i("AEEditorMusicHelper", "[localMusicExists], localMusicPath=" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static class MusicDownloadRunnable
    implements Runnable
  {
    private AppInterface appInterface;
    private WeakReference<AEEditorMusicHelper.a> bx;
    private axnb.a e;
    private String localPath;
    private String url;
    
    public MusicDownloadRunnable(@NonNull AppInterface paramAppInterface, @NonNull axnb.a parama, @NonNull String paramString1, @NonNull String paramString2, @NonNull AEEditorMusicHelper.a parama1)
    {
      this.appInterface = paramAppInterface;
      this.e = parama;
      this.url = paramString1;
      this.localPath = paramString2;
      this.bx = new WeakReference(parama1);
    }
    
    public void run()
    {
      AEEditorMusicHelper.a(this.appInterface, this.e, this.url, this.localPath, (AEEditorMusicHelper.a)this.bx.get());
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(@NonNull axnb.a parama, boolean paramBoolean, @NonNull String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper
 * JD-Core Version:    0.7.0.1
 */