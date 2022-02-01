import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import cooperation.qqcircle.QCircleConstants;
import java.io.File;
import java.util.HashMap;

public class xjy
{
  @NonNull
  private final Context jdField_a_of_type_AndroidContentContext;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private IVideoViewBase jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  private xjz jdField_a_of_type_Xjz = new xjz();
  private xka jdField_a_of_type_Xka = new xka(this.jdField_a_of_type_Xjz);
  private xke jdField_a_of_type_Xke = new xke();
  
  public xjy(@NonNull Context paramContext)
  {
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      zdl.a(bool);
      this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
      b();
      return;
    }
  }
  
  public static TVK_PlayerVideoInfo a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "bus_type_qqstory");
  }
  
  public static TVK_PlayerVideoInfo a(String paramString1, String paramString2, String paramString3)
  {
    ykq.d("StoryPlayerTVKWrapper", "createPlayerVideoInfo, %s", new Object[] { paramString2 });
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setPreLoad(false);
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", String.valueOf(20161223));
    localTVK_PlayerVideoInfo.setConfigMap("downloadflag", "0");
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", paramString3);
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_subscribe");
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains(QCircleConstants.QCIRCLE_DOWNLOAD_VIDEO_CACHE_PATH)))
    {
      localTVK_PlayerVideoInfo.setConfigMap("file_dir", paramString2);
      paramString2 = paramString2.substring(0, paramString2.lastIndexOf(File.separator));
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = new File(paramString2);
        if (!paramString2.exists()) {
          paramString2.mkdirs();
        }
      }
    }
    localTVK_PlayerVideoInfo.setConfigMap("RawVideoPlay", "true");
    localTVK_PlayerVideoInfo.setVid(paramString1);
    return localTVK_PlayerVideoInfo;
  }
  
  private void b()
  {
    TVK_SDKMgr.setOnLogListener(this.jdField_a_of_type_Xke);
    TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    ykq.d("StoryPlayerTVKWrapper", "TVK version: %s", new Object[] { TVK_SDKMgr.getSdkVersion() });
  }
  
  public void a()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
      ThreadManager.executeOnSubThread(new StoryPlayerTVKWrapper.1(this, (TVK_IMediaPlayer)localObject));
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase != null)
    {
      localObject = (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = null;
      if (((View)localObject).getParent() != null)
      {
        ViewParent localViewParent = ((View)localObject).getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView((View)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjy
 * JD-Core Version:    0.7.0.1
 */