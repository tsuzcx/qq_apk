package com.tencent.mobileqq.triton.sdk;

public class TTConstant
{
  public static final String GAME_CONFIG = "game.json";
  public static final String GAME_RES = "GameRes://";
  public static final String INDEX = "game.js";
  public static final String OPEN_DATA = "index.js";
  public static final String OPEN_DATA_SUBCONTEXT = "subContext.js";
  
  public static class AudioPluginConst
  {
    public static final String API_CREATE_AUDIO_INSTANCE = "createAudioInstance";
    public static final String API_DESTROY_AUDIO_INSTANCE = "destroyAudioInstance";
    public static final String API_GET_AUDIO_STATE = "getAudioState";
    public static final String API_GET_AVAILABLE_AUDIO_SOURCES = "getAvailableAudioSources";
    public static final String API_ON_AUDIO_STATE_CHANGE = "onAudioStateChange";
    public static final String API_OPERATE_AUDIO = "operateAudio";
    public static final String API_SET_AUDIO_STATE = "setAudioState";
    public static final String API_SET_INNER_AUDIO_OPTION = "setInnerAudioOptionQGame";
  }
  
  public static class FontPluginConst
  {
    public static final String EVENT_GET_TEXT_LINE_HEIGHT = "getTextLineHeight";
    public static final String EVENT_LOAD_FONT = "loadFont";
  }
  
  public static final class JsFramework
  {
    public static final String DEFAULT_PRELOAD_JS_MAIN = "QGame.js";
    public static final String DEFAULT_PRELOAD_JS_OPENDATA = "QGameOpenDataContext.js";
    public static final String DEFAULT_PRELOAD_JS_WORKER = "QGameWorkerContext.js";
  }
  
  public static abstract interface TTError
  {
    public static final int ERROR_LOAD_CPP_SO = 1002;
    public static final int ERROR_LOAD_PNG_SO = 1003;
    public static final int ERROR_LOAD_SCRIPT = 1005;
    public static final int ERROR_LOAD_SO = 1001;
    public static final int ERROR_LOAD_SO_BASE = 1000;
    public static final int ERROR_LOAD_TRITON_SO = 1004;
    public static final int ERROR_NDK_INIT = 2001;
    public static final int ERROR_NDK_INIT_BASE = 2000;
    public static final int ERROR_NOT_INIT = 1;
    public static final int ERROR_OK = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.TTConstant
 * JD-Core Version:    0.7.0.1
 */