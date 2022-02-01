package com.tencent.qqmini.sdk.core.generated;

import assm;
import assn;
import assp;
import assr;
import asss;
import asst;
import assu;
import assv;
import assw;
import assx;
import astf;
import astg;
import astj;
import asuh;
import asvt;
import com.tencent.qqmini.nativePlugins.TenpayPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExtJsPluginScope
{
  public static final Map EVENT_HANDLERS;
  public static final List PRELOAD_PLUGINS = new ArrayList();
  public static final Map SECONDARY_EVENT_HANDLERS;
  
  static
  {
    EVENT_HANDLERS = new HashMap();
    SECONDARY_EVENT_HANDLERS = new HashMap();
    EVENT_HANDLERS.put("addColorSign", asuh.class);
    EVENT_HANDLERS.put("addColorSignDirectly", asuh.class);
    EVENT_HANDLERS.put("exitMiniProgram", asvt.class);
    EVENT_HANDLERS.put("navigateBackMiniProgram", asvt.class);
    EVENT_HANDLERS.put("navigateToMiniProgram", asvt.class);
    EVENT_HANDLERS.put("showMiniAIOEntrance", astj.class);
    EVENT_HANDLERS.put("hideMiniAIOEntrance", astj.class);
    SECONDARY_EVENT_HANDLERS.put("requestWebSSO", astf.class);
    SECONDARY_EVENT_HANDLERS.put("getMultiMemList", assn.class);
    SECONDARY_EVENT_HANDLERS.put("openTenpayView", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_groupUploadPhoto", assx.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_openUserQzoneHome", assx.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_importGroupAIO", assx.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_showGroupPhotoBrowser", assx.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpGroupAlbumSendBox", assx.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_downloadGroupAlbumPhoto", assx.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpCategoryAlbum", assx.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_pickQzoneAlbum", assx.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_start", assx.class);
    SECONDARY_EVENT_HANDLERS.put("tim_space", assw.class);
    SECONDARY_EVENT_HANDLERS.put("uploadAvatar", assu.class);
    SECONDARY_EVENT_HANDLERS.put("tdoc_channel", assv.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendiscover", assr.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendetail", assr.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_openhomepage", assr.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_getdeviceinfo", assr.class);
    SECONDARY_EVENT_HANDLERS.put("weiyunDownload", astg.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_qzoneUploadAndPublish", asss.class);
    SECONDARY_EVENT_HANDLERS.put("refreshQzoneFeed", asst.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_invokeGYCamera", assp.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_uploadRes", assm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope
 * JD-Core Version:    0.7.0.1
 */