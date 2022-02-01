package com.tencent.mobileqq.videoplatform.api;

import java.util.HashMap;

public class PlayerState
{
  public static final HashMap<Integer, String> PLAYER_SATE_MAP = new HashMap();
  public static final int STATE_BUFFERING = 5;
  public static final int STATE_COMPLETE = 8;
  public static final int STATE_ERROR = 7;
  public static final int STATE_IDLE = 0;
  public static final int STATE_PAUSE = 6;
  public static final int STATE_PLAYING = 4;
  public static final int STATE_PREPARING = 3;
  public static final int STATE_RELEASED = 9;
  public static final int STATE_SDK_INITED = 2;
  public static final int STATE_SDK_INITING = 1;
  
  static
  {
    PLAYER_SATE_MAP.put(Integer.valueOf(0), "STATE_IDLE");
    PLAYER_SATE_MAP.put(Integer.valueOf(1), "STATE_SDK_INITING");
    PLAYER_SATE_MAP.put(Integer.valueOf(2), "STATE_SDK_INITED");
    PLAYER_SATE_MAP.put(Integer.valueOf(3), "STATE_PREPARING");
    PLAYER_SATE_MAP.put(Integer.valueOf(4), "STATE_PLAYING");
    PLAYER_SATE_MAP.put(Integer.valueOf(5), "STATE_BUFFERING");
    PLAYER_SATE_MAP.put(Integer.valueOf(6), "STATE_PAUSE");
    PLAYER_SATE_MAP.put(Integer.valueOf(7), "STATE_ERROR");
    PLAYER_SATE_MAP.put(Integer.valueOf(8), "STATE_COMPLETE");
    PLAYER_SATE_MAP.put(Integer.valueOf(9), "STATE_RELEASED");
  }
  
  public static String getStateStr(int paramInt)
  {
    String str2 = (String)PLAYER_SATE_MAP.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.api.PlayerState
 * JD-Core Version:    0.7.0.1
 */