package com.tencent.superplayer.player;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

class SuperPlayerMgrCommons
{
  static class LoopbackParams
  {
    boolean isLoopback;
    long loopEndPositionMs;
    long loopStartPositionMs;
  }
  
  static class OpenMediaParams
  {
    Context context;
    String fileId;
    String localSaveUrl;
    SuperPlayerOption playerOption;
    long startPositionMilsec;
    String[] urls;
    SuperPlayerVideoInfo videoInfo;
  }
  
  static class SwitchDefnForUrlParams
  {
    int mode;
    String url;
  }
  
  static class SwitchDefnParams
  {
    String defn;
    int mode;
  }
  
  static class TVKOnTouchEventParams
  {
    MotionEvent event;
    View view;
  }
  
  static class TVKSetNextLoopVideoInfoParams
  {
    String lastDefinition;
    TVKPlayerVideoInfo videoInfo;
  }
  
  static class TVKSwitchAudioTrackParams
  {
    TVKUserInfo userInfo;
    TVKPlayerVideoInfo videoInfo;
  }
  
  static class TVKSwitchDefinitionParams
  {
    String definition;
    TVKUserInfo userInfo;
    TVKPlayerVideoInfo videoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgrCommons
 * JD-Core Version:    0.7.0.1
 */