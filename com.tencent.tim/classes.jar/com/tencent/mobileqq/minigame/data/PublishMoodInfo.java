package com.tencent.mobileqq.minigame.data;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import common.config.service.QzoneConfig;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONObject;

public class PublishMoodInfo
{
  public static final int MOOD_MAX_PHOTO_AND_VIDEO_COUNT;
  public static final int MOOD_MAX_SINGLE_PHOTO_SIZE;
  public static final int MOOD_MAX_SINGLE_VIDEO_DURATION = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxSingleVideoDuration", 601000);
  public static final int MOOD_MAX_SINGLE_VIDEO_SIZE;
  public static final int MOOD_MAX_TEXT_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxTextCount", 10000);
  public static final int MOOD_MAX_VIDEO_COUNT;
  private static final String TAG = "[minigame] PublishMoodInfo";
  public ArrayList<String> mAllImageAndVideo = new ArrayList();
  public String mFootnote;
  public ArrayList<MediaInfo> mMediaInfo = new ArrayList();
  public HashMap<String, LocalMediaInfo> mMediaInfoHashMap = new HashMap();
  public String mPath;
  public String mTag;
  public String mText;
  
  static
  {
    MOOD_MAX_PHOTO_AND_VIDEO_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxPhotoAndVideoCount", 50);
    MOOD_MAX_VIDEO_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxVideoCount", 10);
    MOOD_MAX_SINGLE_PHOTO_SIZE = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxSinglePhotoSize", 20971520);
    MOOD_MAX_SINGLE_VIDEO_SIZE = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxSingleVideoSize", 1610612736);
  }
  
  public PublishMoodInfo() {}
  
  public PublishMoodInfo(String paramString1, String paramString2, ArrayList<MediaInfo> paramArrayList)
  {
    this.mText = paramString1;
    this.mTag = paramString2;
    this.mMediaInfo = paramArrayList;
  }
  
  public static String filterText(String paramString)
  {
    paramString = new StringTokenizer(paramString.toString().replace("\r\n", " ").replace("\n", " "), " ");
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.hasMoreTokens()) {
      localStringBuffer.append(paramString.nextToken() + ' ');
    }
    return localStringBuffer.toString().trim();
  }
  
  public static String getFileSizeDesc(long paramLong)
  {
    if (paramLong < 1024L) {}
    try
    {
      return paramLong + "B";
    }
    catch (Exception localException)
    {
      Object localObject;
      double d1;
      double d2;
      QLog.i("[minigame] PublishMoodInfo", 2, "getFileSizeDesc " + paramLong, localException);
    }
    localObject = new DecimalFormat("##0.0");
    d1 = 1024.0D * 1024.0D;
    d2 = 1024.0D * d1;
    if (paramLong < d1) {
      return ((DecimalFormat)localObject).format(paramLong / 1024.0D) + "K";
    }
    if (paramLong < d2) {
      return ((DecimalFormat)localObject).format(paramLong / d1) + "M";
    }
    localObject = ((DecimalFormat)localObject).format(paramLong / d2) + "G";
    return localObject;
    return "";
  }
  
  public static PublishMoodInfo parseJsonToMoodInfo(String paramString)
  {
    Object localObject1;
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = null;
      return localObject1;
    }
    PublishMoodInfo localPublishMoodInfo = new PublishMoodInfo();
    for (;;)
    {
      int i;
      String str2;
      String str3;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (!((JSONObject)localObject2).has("text")) {
          break label427;
        }
        localObject1 = ((JSONObject)localObject2).getString("text");
        localPublishMoodInfo.mText = ((String)localObject1);
        if (!((JSONObject)localObject2).has("tag")) {
          break label433;
        }
        localObject1 = ((JSONObject)localObject2).getString("tag");
        localPublishMoodInfo.mTag = ((String)localObject1);
        if (!((JSONObject)localObject2).has("path")) {
          break label439;
        }
        localObject1 = ((JSONObject)localObject2).optString("path");
        localPublishMoodInfo.mPath = ((String)localObject1);
        if (!((JSONObject)localObject2).has("footnote")) {
          break label445;
        }
        localObject1 = ((JSONObject)localObject2).optString("footnote");
        localPublishMoodInfo.mFootnote = ((String)localObject1);
        localObject1 = localPublishMoodInfo;
        if (!((JSONObject)localObject2).has("media")) {
          break;
        }
        localObject1 = localPublishMoodInfo;
        if (TextUtils.isEmpty(((JSONObject)localObject2).getString("media"))) {
          break;
        }
        localObject1 = new ArrayList();
        localObject2 = ((JSONObject)localObject2).getJSONArray("media");
        int j = ((JSONArray)localObject2).length();
        i = 0;
        if (i >= j) {
          break label411;
        }
        localObject3 = ((JSONArray)localObject2).getJSONObject(i);
        if ((!((JSONObject)localObject3).has("type")) || (!((JSONObject)localObject3).has("path")))
        {
          QLog.i("[minigame] PublishMoodInfo", 2, "invalid mediaItem, " + localObject3);
        }
        else
        {
          str2 = ((JSONObject)localObject3).getString("type");
          str3 = ((JSONObject)localObject3).getString("path");
          if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
            QLog.i("[minigame] PublishMoodInfo", 2, "invalid mediaItem, " + localObject3);
          }
        }
      }
      catch (Exception localException)
      {
        QLog.i("[minigame] PublishMoodInfo", 2, "parseJsonToMoodInfo error " + paramString, localException);
        return localPublishMoodInfo;
      }
      Object localObject3 = new MediaInfo();
      ((MediaInfo)localObject3).mPath = MiniAppFileManager.getInstance().getAbsolutePath(str3);
      if ("photo".equalsIgnoreCase(str2))
      {
        ((MediaInfo)localObject3).mType = 1;
        localException.add(localObject3);
      }
      else if ("video".equalsIgnoreCase(str2))
      {
        ((MediaInfo)localObject3).mType = 2;
        localException.add(localObject3);
        break label420;
        label411:
        localPublishMoodInfo.mMediaInfo = localException;
        return localPublishMoodInfo;
      }
      label420:
      i += 1;
      continue;
      label427:
      String str1 = "";
      continue;
      label433:
      str1 = "";
      continue;
      label439:
      str1 = "";
      continue;
      label445:
      str1 = "";
    }
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder().append("mText = ").append(this.mText).append(", mTag = ").append(this.mTag).append(", media.size = ");
    if (this.mMediaInfo != null)
    {
      i = this.mMediaInfo.size();
      localStringBuilder = localStringBuilder.append(i).append(", mAllImageAndVideo.size = ");
      if (this.mAllImageAndVideo == null) {
        break label127;
      }
    }
    label127:
    for (int i = this.mAllImageAndVideo.size();; i = 0)
    {
      localStringBuilder = localStringBuilder.append(i).append(", mMediaInfoHashMap.size = ");
      i = j;
      if (this.mMediaInfoHashMap != null) {
        i = this.mMediaInfoHashMap.size();
      }
      return i;
      i = 0;
      break;
    }
  }
  
  public static class MediaInfo
  {
    public static final int TYPE_PHOTO = 1;
    public static final int TYPE_VIDEO = 2;
    public String mPath;
    public int mType;
    
    public MediaInfo() {}
    
    MediaInfo(int paramInt, String paramString)
    {
      this.mType = paramInt;
      this.mPath = paramString;
    }
    
    public String toString()
    {
      return "mType = " + this.mType + ", mPath = " + this.mPath;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.data.PublishMoodInfo
 * JD-Core Version:    0.7.0.1
 */