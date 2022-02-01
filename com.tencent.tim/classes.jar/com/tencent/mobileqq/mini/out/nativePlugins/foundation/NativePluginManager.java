package com.tencent.mobileqq.mini.out.nativePlugins.foundation;

import java.util.HashSet;
import java.util.Set;

public class NativePluginManager
{
  private static Set<PluginInfo> pluginList = new HashSet();
  
  static
  {
    pluginList.add(new PluginInfo("uploadAvatar", "com.tencent.mobileqq.mini.out.nativePlugins.SetAvatarNativePlugin"));
    pluginList.add(new PluginInfo("weiyunDownload", "com.tencent.mobileqq.mini.out.nativePlugins.WeiyunDownloadFilePlugin"));
    pluginList.add(new PluginInfo("refreshQzoneFeed", "com.tencent.mobileqq.mini.out.nativePlugins.RefreshQzoneFeedPlugin"));
    pluginList.add(new PluginInfo("getMultiMemList", "com.tencent.mobileqq.mini.out.nativePlugins.GroupPlugin"));
    pluginList.add(new PluginInfo("checkin_invokeGYCamera", "com.tencent.mobileqq.mini.out.nativePlugins.LaunchCameraPlugin"));
    pluginList.add(new PluginInfo("requestWebSSO", "com.tencent.mobileqq.mini.out.nativePlugins.WebSsoJsPlugin"));
    pluginList.add(new PluginInfo("checkin_qzoneUploadAndPublish", "com.tencent.mobileqq.mini.out.nativePlugins.QzonePublishPlugin"));
    pluginList.add(new PluginInfo("checkin_uploadRes", "com.tencent.mobileqq.mini.out.nativePlugins.GroupCheckInUploadPlugin"));
    initTroopAlbumPlugin();
    pluginList.add(new PluginInfo("tdoc_channel", "com.tencent.mobileqq.mini.out.nativePlugins.TenDocChannelPlugin"));
    pluginList.add(new PluginInfo("openTenpayView", "com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin"));
    pluginList.add(new PluginInfo("qWalletBridge", "com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin"));
    initQQPublicAccountPlugin();
    pluginList.add(new PluginInfo("tim_space", "com.tencent.mobileqq.mini.out.nativePlugins.TimTeamPlugin"));
  }
  
  public static Set<PluginInfo> getPluginInfo()
  {
    return pluginList;
  }
  
  private static void initQQPublicAccountPlugin()
  {
    pluginList.add(new PluginInfo("qsubscribe_opendiscover", "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
    pluginList.add(new PluginInfo("qsubscribe_opendetail", "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
    pluginList.add(new PluginInfo("qsubscribe_openhomepage", "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
    pluginList.add(new PluginInfo("qsubscribe_getdeviceinfo", "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
  }
  
  private static void initTroopAlbumPlugin()
  {
    pluginList.add(new PluginInfo("groupAlbum_groupUploadPhoto", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new PluginInfo("groupAlbum_openUserQzoneHome", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new PluginInfo("groupAlbum_importGroupAIO", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new PluginInfo("groupAlbum_showGroupPhotoBrowser", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new PluginInfo("groupAlbum_jumpGroupAlbumSendBox", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new PluginInfo("groupAlbum_downloadGroupAlbumPhoto", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new PluginInfo("groupAlbum_jumpCategoryAlbum", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new PluginInfo("groupAlbum_pickQzoneAlbum", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new PluginInfo("groupAlbum_start", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
  }
  
  public static class PluginInfo
  {
    private String api_name;
    private String handlerClass;
    
    public PluginInfo(String paramString1, String paramString2)
    {
      this.api_name = paramString1;
      this.handlerClass = paramString2;
    }
    
    public String getApi_name()
    {
      return this.api_name;
    }
    
    public String getHandlerClass()
    {
      return this.handlerClass;
    }
    
    public void setApi_name(String paramString)
    {
      this.api_name = paramString;
    }
    
    public void setHandlerClass(String paramString)
    {
      this.handlerClass = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePluginManager
 * JD-Core Version:    0.7.0.1
 */