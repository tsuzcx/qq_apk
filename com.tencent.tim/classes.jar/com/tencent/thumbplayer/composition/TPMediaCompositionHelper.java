package com.tencent.thumbplayer.composition;

class TPMediaCompositionHelper
{
  static final String EMPTY_CLIP_FLAG = "1";
  public static final int END_OF_FILE = -1;
  static final String NORMAL_CLIP_FLAG = "0";
  static final String XML_TAG_ASSERT = "assets";
  static final String XML_TAG_AUDIO_TRACK = "audio_track";
  static final String XML_TAG_AUDIO_TRACKS = "audio_tracks";
  static final String XML_TAG_AV_TRACK = "av_track";
  static final String XML_TAG_AV_TRACKS = "av_tracks";
  static final String XML_TAG_CLIP_DURATION = "clip_durationMs";
  static final String XML_TAG_CLIP_END_TIME = "clip_endTimeMs";
  static final String XML_TAG_CLIP_ID = "clip_id";
  static final String XML_TAG_CLIP_PATH = "clip_path";
  static final String XML_TAG_CLIP_PLACE_HOLDER = "clip_placeHolder";
  static final String XML_TAG_CLIP_PLAY_TIME = "clip_playTimeMs";
  static final String XML_TAG_CLIP_START_TIME = "clip_startTimeMs";
  static final String XML_TAG_DRM_APPVER = "clip_drmAppVersion";
  static final String XML_TAG_DRM_COOKIE = "clip_drmCookie";
  static final String XML_TAG_DRM_GUID = "clip_drmGuid";
  static final String XML_TAG_DRM_LICENSE = "clip_drmLicenseUrl";
  static final String XML_TAG_DRM_LICENSE_STANDARDIZATION = "clip_drmLicenseStandardization";
  static final String XML_TAG_DRM_PLATFORM = "clip_drmPlatform";
  static final String XML_TAG_DRM_PROVISION = "clip_drmProvisionUrl";
  static final String XML_TAG_DRM_SAVE_PATH = "clip_drmSavePath";
  static final String XML_TAG_DRM_TYPE = "clip_drmType";
  static final String XML_TAG_DRM_USEL1 = "clip_drmUseL1";
  static final String XML_TAG_RTC_SERVER_URL = "clip_rtcServerUrl";
  static final String XML_TAG_TRACK_CLIP = "track_clip";
  static final String XML_TAG_TRACK_ID = "track_id";
  static final String XML_TAG_UTF8 = "UTF-8";
  static final String XML_TAG_VIDEO_TRACK = "video_track";
  static final String XML_TAG_VIDEO_TRACKS = "video_tracks";
  private static int audioClidId = 0;
  private static int avClidId = 0;
  public static String composition_duration_strategy = "base_video";
  private static int videoClidId = 0;
  
  static int generateTrackClipId(int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = avClidId;
      avClidId = paramInt + 1;
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramInt = videoClidId;
      videoClidId = paramInt + 1;
      return paramInt;
    }
    if (paramInt == 3)
    {
      paramInt = audioClidId;
      audioClidId = paramInt + 1;
      return paramInt;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.composition.TPMediaCompositionHelper
 * JD-Core Version:    0.7.0.1
 */