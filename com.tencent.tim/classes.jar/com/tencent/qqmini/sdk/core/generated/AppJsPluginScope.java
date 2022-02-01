package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.miniapp.plugin.AudioJsPlugin;
import com.tencent.qqmini.miniapp.plugin.CanvasJsPlugin;
import com.tencent.qqmini.miniapp.plugin.EmbeddedLivePlayerJsPlugin;
import com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin;
import com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin;
import com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin;
import com.tencent.qqmini.miniapp.plugin.LivePlayerJsPlugin;
import com.tencent.qqmini.miniapp.plugin.LivePusherJsPlugin;
import com.tencent.qqmini.miniapp.plugin.MediaJsPlugin;
import com.tencent.qqmini.miniapp.plugin.MiniAppFileJsPlugin;
import com.tencent.qqmini.miniapp.plugin.MiniAppUIJsPlugin;
import com.tencent.qqmini.miniapp.plugin.NavigationBarPlugin;
import com.tencent.qqmini.miniapp.plugin.PickerJsPlugin;
import com.tencent.qqmini.miniapp.plugin.PullDownRefreshJsPlugin;
import com.tencent.qqmini.miniapp.plugin.ScrollViewJsPlugin;
import com.tencent.qqmini.miniapp.plugin.SubpackageJsPlugin;
import com.tencent.qqmini.miniapp.plugin.SystemInfoPlugin;
import com.tencent.qqmini.miniapp.plugin.TabBarJsPlugin;
import com.tencent.qqmini.miniapp.plugin.TextViewJsPlugin;
import com.tencent.qqmini.miniapp.plugin.VideoJsPlugin;
import java.util.HashMap;
import java.util.Map;

public final class AppJsPluginScope
{
  public static final Map EVENT_HANDLERS = new HashMap();
  
  static
  {
    EVENT_HANDLERS.put("drawCanvas", CanvasJsPlugin.class);
    EVENT_HANDLERS.put("canvasToTempFilePath", CanvasJsPlugin.class);
    EVENT_HANDLERS.put("canvasPutImageData", CanvasJsPlugin.class);
    EVENT_HANDLERS.put("canvasGetImageData", CanvasJsPlugin.class);
    EVENT_HANDLERS.put("insertCanvas", CanvasJsPlugin.class);
    EVENT_HANDLERS.put("updateCanvas", CanvasJsPlugin.class);
    EVENT_HANDLERS.put("removeCanvas", CanvasJsPlugin.class);
    EVENT_HANDLERS.put("measureText", CanvasJsPlugin.class);
    EVENT_HANDLERS.put("openDocument", MiniAppFileJsPlugin.class);
    EVENT_HANDLERS.put("insertXWebLivePlayer", EmbeddedLivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("updateXWebLivePlayer", EmbeddedLivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("operateXWebLivePlayer", EmbeddedLivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("removePositioningContainer", EmbeddedLivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("showVirtualBottomNavigationBar", EmbeddedLivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("hideVirtualBottomNavigationBar", EmbeddedLivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("showVirtualBottomNavigationBar", EmbeddedLivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("hideVirtualBottomNavigationBar", EmbeddedLivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("setDisplayOrientation", EmbeddedLivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("insertImageView", ImageViewJsPlugin.class);
    EVENT_HANDLERS.put("updateImageView", ImageViewJsPlugin.class);
    EVENT_HANDLERS.put("removeImageView", ImageViewJsPlugin.class);
    EVENT_HANDLERS.put("startRecord", AudioJsPlugin.class);
    EVENT_HANDLERS.put("stopRecord", AudioJsPlugin.class);
    EVENT_HANDLERS.put("playVoice", AudioJsPlugin.class);
    EVENT_HANDLERS.put("pauseVoice", AudioJsPlugin.class);
    EVENT_HANDLERS.put("stopVoice", AudioJsPlugin.class);
    EVENT_HANDLERS.put("operateRecorder", AudioJsPlugin.class);
    EVENT_HANDLERS.put("operateMusicPlayer", AudioJsPlugin.class);
    EVENT_HANDLERS.put("getMusicPlayerState", AudioJsPlugin.class);
    EVENT_HANDLERS.put("getBackgroundAudioState", AudioJsPlugin.class);
    EVENT_HANDLERS.put("operateBackgroundAudio", AudioJsPlugin.class);
    EVENT_HANDLERS.put("setBackgroundAudioState", AudioJsPlugin.class);
    EVENT_HANDLERS.put("getAvailableAudioSources", AudioJsPlugin.class);
    EVENT_HANDLERS.put("createAudioInstance", AudioJsPlugin.class);
    EVENT_HANDLERS.put("setAudioState", AudioJsPlugin.class);
    EVENT_HANDLERS.put("getAudioState", AudioJsPlugin.class);
    EVENT_HANDLERS.put("operateAudio", AudioJsPlugin.class);
    EVENT_HANDLERS.put("destroyAudioInstance", AudioJsPlugin.class);
    EVENT_HANDLERS.put("setInnerAudioOption", AudioJsPlugin.class);
    EVENT_HANDLERS.put("startPullDownRefresh", PullDownRefreshJsPlugin.class);
    EVENT_HANDLERS.put("stopPullDownRefresh", PullDownRefreshJsPlugin.class);
    EVENT_HANDLERS.put("disableScrollBounce", PullDownRefreshJsPlugin.class);
    EVENT_HANDLERS.put("showTabBar", TabBarJsPlugin.class);
    EVENT_HANDLERS.put("hideTabBar", TabBarJsPlugin.class);
    EVENT_HANDLERS.put("setTabBarItem", TabBarJsPlugin.class);
    EVENT_HANDLERS.put("setTabBarStyle", TabBarJsPlugin.class);
    EVENT_HANDLERS.put("setTabBarBadge", TabBarJsPlugin.class);
    EVENT_HANDLERS.put("removeTabBarBadge", TabBarJsPlugin.class);
    EVENT_HANDLERS.put("showTabBarRedDot", TabBarJsPlugin.class);
    EVENT_HANDLERS.put("hideTabBarRedDot", TabBarJsPlugin.class);
    EVENT_HANDLERS.put("insertLivePlayer", LivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("updateLivePlayer", LivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("removeLivePlayer", LivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("operateLivePlayer", LivePlayerJsPlugin.class);
    EVENT_HANDLERS.put("insertScrollView", ScrollViewJsPlugin.class);
    EVENT_HANDLERS.put("updateScrollView", ScrollViewJsPlugin.class);
    EVENT_HANDLERS.put("removeScrollView", ScrollViewJsPlugin.class);
    EVENT_HANDLERS.put("operateVideoPlayer", MediaJsPlugin.class);
    EVENT_HANDLERS.put("insertVideoPlayer", MediaJsPlugin.class);
    EVENT_HANDLERS.put("updateVideoPlayer", MediaJsPlugin.class);
    EVENT_HANDLERS.put("removeVideoPlayer", MediaJsPlugin.class);
    EVENT_HANDLERS.put("insertCamera", MediaJsPlugin.class);
    EVENT_HANDLERS.put("removeCamera", MediaJsPlugin.class);
    EVENT_HANDLERS.put("operateCamera", MediaJsPlugin.class);
    EVENT_HANDLERS.put("updateCamera", MediaJsPlugin.class);
    EVENT_HANDLERS.put("insertTextView", TextViewJsPlugin.class);
    EVENT_HANDLERS.put("updateTextView", TextViewJsPlugin.class);
    EVENT_HANDLERS.put("removeTextView", TextViewJsPlugin.class);
    EVENT_HANDLERS.put("showPickerView", PickerJsPlugin.class);
    EVENT_HANDLERS.put("showMultiPickerView", PickerJsPlugin.class);
    EVENT_HANDLERS.put("showDatePickerView", PickerJsPlugin.class);
    EVENT_HANDLERS.put("updateMultiPickerView", PickerJsPlugin.class);
    EVENT_HANDLERS.put("createLoadSubPackageTask", SubpackageJsPlugin.class);
    EVENT_HANDLERS.put("getVolume", EmbeddedVideoJsPlugin.class);
    EVENT_HANDLERS.put("setVolume", EmbeddedVideoJsPlugin.class);
    EVENT_HANDLERS.put("insertXWebVideo", EmbeddedVideoJsPlugin.class);
    EVENT_HANDLERS.put("updateXWebVideo", EmbeddedVideoJsPlugin.class);
    EVENT_HANDLERS.put("operateXWebVideo", EmbeddedVideoJsPlugin.class);
    EVENT_HANDLERS.put("removeXWebVideo", EmbeddedVideoJsPlugin.class);
    EVENT_HANDLERS.put("setDisplayOrientation", EmbeddedVideoJsPlugin.class);
    EVENT_HANDLERS.put("hideVirtualBottomNavigationBar", EmbeddedVideoJsPlugin.class);
    EVENT_HANDLERS.put("showVirtualBottomNavigationBar", EmbeddedVideoJsPlugin.class);
    EVENT_HANDLERS.put("insertXWebLivePusher", EmbeddedLivePusherJsPlugin.class);
    EVENT_HANDLERS.put("operateXWebLivePusher", EmbeddedLivePusherJsPlugin.class);
    EVENT_HANDLERS.put("updateXWebLivePusher", EmbeddedLivePusherJsPlugin.class);
    EVENT_HANDLERS.put("removeXWebLivePusher", EmbeddedLivePusherJsPlugin.class);
    EVENT_HANDLERS.put("showVirtualBottomNavigationBar", EmbeddedLivePusherJsPlugin.class);
    EVENT_HANDLERS.put("hideVirtualBottomNavigationBar", EmbeddedLivePusherJsPlugin.class);
    EVENT_HANDLERS.put("setDisplayOrientation", EmbeddedLivePusherJsPlugin.class);
    EVENT_HANDLERS.put("insertLivePusher", LivePusherJsPlugin.class);
    EVENT_HANDLERS.put("updateLivePusher", LivePusherJsPlugin.class);
    EVENT_HANDLERS.put("removeLivePusher", LivePusherJsPlugin.class);
    EVENT_HANDLERS.put("operateLivePusher", LivePusherJsPlugin.class);
    EVENT_HANDLERS.put("setBackgroundTextStyle", MiniAppUIJsPlugin.class);
    EVENT_HANDLERS.put("setBackgroundColor", MiniAppUIJsPlugin.class);
    EVENT_HANDLERS.put("scrollWebviewTo", MiniAppUIJsPlugin.class);
    EVENT_HANDLERS.put("getRegionData", MiniAppUIJsPlugin.class);
    EVENT_HANDLERS.put("scrollWebviewTo", MiniAppUIJsPlugin.class);
    EVENT_HANDLERS.put("insertHTMLWebView", MiniAppUIJsPlugin.class);
    EVENT_HANDLERS.put("updateHTMLWebView", MiniAppUIJsPlugin.class);
    EVENT_HANDLERS.put("removeHTMLWebView", MiniAppUIJsPlugin.class);
    EVENT_HANDLERS.put("setNavigationBarTitle", NavigationBarPlugin.class);
    EVENT_HANDLERS.put("showNavigationBarLoading", NavigationBarPlugin.class);
    EVENT_HANDLERS.put("hideNavigationBarLoading", NavigationBarPlugin.class);
    EVENT_HANDLERS.put("setNavigationBarColor", NavigationBarPlugin.class);
    EVENT_HANDLERS.put("getSystemInfo", SystemInfoPlugin.class);
    EVENT_HANDLERS.put("getSystemInfoSync", SystemInfoPlugin.class);
    EVENT_HANDLERS.put("chooseVideo", VideoJsPlugin.class);
    EVENT_HANDLERS.put("saveVideoToPhotosAlbum", VideoJsPlugin.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.AppJsPluginScope
 * JD-Core Version:    0.7.0.1
 */