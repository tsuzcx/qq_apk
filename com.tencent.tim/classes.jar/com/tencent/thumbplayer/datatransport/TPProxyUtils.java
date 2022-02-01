package com.tencent.thumbplayer.datatransport;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;

public class TPProxyUtils
{
  public static final String PROXY_SO_NAME = "DownloadProxy";
  public static final String TAG = "TPProxyUtils";
  
  public static TPDownloadParam convertProxyDownloadParams(String paramString, TPDownloadParamData paramTPDownloadParamData, Map<String, String> paramMap)
  {
    Object localObject;
    if (paramTPDownloadParamData != null)
    {
      localObject = new ArrayList();
      if ((paramTPDownloadParamData.getUrlCdnidList() == null) || (paramTPDownloadParamData.getUrlCdnidList().isEmpty()))
      {
        if (!TextUtils.isEmpty(paramString)) {
          ((ArrayList)localObject).add(paramString);
        }
        for (;;)
        {
          paramString = paramTPDownloadParamData.getBakUrl();
          if ((paramString == null) || (paramString.length <= 0)) {
            break;
          }
          int i = 0;
          while (i < paramString.length)
          {
            if (!TextUtils.isEmpty(paramString[i])) {
              ((ArrayList)localObject).add(paramString[i]);
            }
            i += 1;
          }
          ((ArrayList)localObject).add(paramTPDownloadParamData.url);
        }
        if (paramMap == null) {
          break label1364;
        }
        paramString = new ArrayList();
        paramString.add(paramMap);
      }
    }
    for (;;)
    {
      paramMap = (Map<String, String>)localObject;
      localObject = new HashMap();
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getFlowId()))
      {
        TPLogUtil.i("TPProxyUtils", paramTPDownloadParamData.getFlowId());
        ((Map)localObject).put("dl_param_play_flowid", paramTPDownloadParamData.getFlowId());
      }
      if (paramTPDownloadParamData.getUrlExpireTime() > 0) {
        ((Map)localObject).put("dl_param_url_expire_time", Integer.valueOf(paramTPDownloadParamData.getUrlExpireTime()));
      }
      if (paramTPDownloadParamData.getFileSize() > 0L) {
        ((Map)localObject).put("dl_param_file_size", Long.valueOf(paramTPDownloadParamData.getFileSize()));
      }
      if (paramTPDownloadParamData.getFileDuration() > 0L) {
        ((Map)localObject).put("dl_param_file_duration", Long.valueOf(paramTPDownloadParamData.getFileDuration()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getDownloadFileID())) {
        ((Map)localObject).put("dl_param_play_keyid", paramTPDownloadParamData.getDownloadFileID());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getVid())) {
        ((Map)localObject).put("dl_param_vid", paramTPDownloadParamData.getVid());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getPlayDefinition()))
      {
        ((Map)localObject).put("dl_param_play_definition", paramTPDownloadParamData.getPlayDefinition());
        ((Map)localObject).put("dl_param_current_format", paramTPDownloadParamData.getPlayDefinition());
      }
      if (paramTPDownloadParamData.getCurrentFormatID() > 0) {
        ((Map)localObject).put("dl_param_current_formatid", Integer.valueOf(paramTPDownloadParamData.getCurrentFormatID()));
      }
      if (!TPCommonUtils.isEmpty(paramTPDownloadParamData.getFormatInfo())) {
        ((Map)localObject).put("dl_param_format_info", paramTPDownloadParamData.getFormatInfo());
      }
      ((Map)localObject).put("dl_param_source_is_charge", Boolean.valueOf(paramTPDownloadParamData.isCharge()));
      ((Map)localObject).put("dl_param_cache_need_encrypt", Boolean.valueOf(paramTPDownloadParamData.isNeedEncryptCache()));
      ((Map)localObject).put("dl_param_is_offline", Boolean.valueOf(paramTPDownloadParamData.isOffline()));
      ((Map)localObject).put("dl_param_enable_expand_donwload_url", Boolean.valueOf(paramTPDownloadParamData.isExtraParam()));
      if ((paramString != null) && (!paramString.isEmpty())) {
        ((Map)localObject).put("dl_param_url_header", paramString);
      }
      if (paramTPDownloadParamData.getPreloadSize() > 0L) {
        ((Map)localObject).put("dl_param_preload_size", Long.valueOf(paramTPDownloadParamData.getPreloadSize()));
      }
      if (paramTPDownloadParamData.getPreloadDuration() > 0L) {
        ((Map)localObject).put("dl_param_preload_duration", Long.valueOf(paramTPDownloadParamData.getPreloadDuration()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getSavePath())) {
        ((Map)localObject).put("dl_param_save_path", paramTPDownloadParamData.getSavePath());
      }
      if (paramTPDownloadParamData.getStarTimeMS() > 0) {
        ((Map)localObject).put("dl_param_play_start_time", Integer.valueOf(paramTPDownloadParamData.getStarTimeMS()));
      }
      if (paramTPDownloadParamData.getEndTimeMS() > 0) {
        ((Map)localObject).put("dl_param_play_end_time", Integer.valueOf(paramTPDownloadParamData.getEndTimeMS()));
      }
      if (paramTPDownloadParamData.getClipCount() > 0) {
        ((Map)localObject).put("dl_param_play_clip_count", Integer.valueOf(paramTPDownloadParamData.getClipCount()));
      }
      if (paramTPDownloadParamData.getClipNo() > 0) {
        ((Map)localObject).put("dl_param_play_clip_no", Integer.valueOf(paramTPDownloadParamData.getClipNo()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getBase())) {
        ((Map)localObject).put("dl_param_vinfo_base", paramTPDownloadParamData.getBase());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getLinkVid())) {
        ((Map)localObject).put("dl_param_vinfo_link_vid", paramTPDownloadParamData.getLinkVid());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getFileMD5())) {
        ((Map)localObject).put("dl_param_file_md5", paramTPDownloadParamData.getFileMD5());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getM3u8())) {
        ((Map)localObject).put("dl_param_vinfo_m3u8", paramTPDownloadParamData.getM3u8());
      }
      if (paramTPDownloadParamData.getTm() > 0L) {
        ((Map)localObject).put("dl_param_vinfo_tm", Long.valueOf(paramTPDownloadParamData.getTm()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getNonce()))
      {
        TPLogUtil.i("TPProxyUtils", "nonce:" + paramTPDownloadParamData.getNonce());
        ((Map)localObject).put("dl_param_nonce", paramTPDownloadParamData.getNonce());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getDecKey()))
      {
        TPLogUtil.i("TPProxyUtils", "encrypt stream key:" + paramTPDownloadParamData.getDecKey());
        ((Map)localObject).put("dl_param_encrypt_stream_key", paramTPDownloadParamData.getDecKey());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getRandoms()))
      {
        TPLogUtil.i("TPProxyUtils", "encrypt randoms:" + paramTPDownloadParamData.getRandoms());
        ((Map)localObject).put("dl_param_encrypt_stream_randoms", paramTPDownloadParamData.getRandoms());
      }
      if (paramTPDownloadParamData.getFp2p() > 0) {
        ((Map)localObject).put("dl_param_vinfo_fp2p", Integer.valueOf(paramTPDownloadParamData.getFp2p()));
      }
      if (paramTPDownloadParamData.getTestid() > 0) {
        ((Map)localObject).put("dl_param_vinfo_testid", Integer.valueOf(paramTPDownloadParamData.getTestid()));
      }
      if (paramTPDownloadParamData.getExceptDelay() > 0) {
        ((Map)localObject).put("dl_param_expect_delay_time", Integer.valueOf(paramTPDownloadParamData.getExceptDelay()));
      }
      if (!TPCommonUtils.isEmpty(paramTPDownloadParamData.getExtInfoMap())) {
        ((Map)localObject).putAll(paramTPDownloadParamData.getExtInfoMap());
      }
      if (paramTPDownloadParamData.getSelfAdaption()) {
        ((Map)localObject).put("dl_param_adaptive_type", Integer.valueOf(3));
      }
      Iterator localIterator;
      for (;;)
      {
        ((Map)localObject).put("dl_param_format_nodes", paramTPDownloadParamData.getDefInfoList());
        if ((paramTPDownloadParamData.getPcdnUrlList() == null) || (paramTPDownloadParamData.getPcdnUrlList().isEmpty())) {
          break label1211;
        }
        paramString = new StringBuilder("");
        localIterator = paramTPDownloadParamData.getPcdnUrlList().iterator();
        while (localIterator.hasNext())
        {
          paramString.append((String)localIterator.next());
          paramString.append(";");
        }
        paramMap = paramTPDownloadParamData.getUrlCdnidList();
        paramString = paramTPDownloadParamData.getUrlCdnidHttpHeaderList();
        break;
        ((Map)localObject).put("dl_param_adaptive_type", Integer.valueOf(0));
      }
      if (paramString.length() > 0) {
        paramString.deleteCharAt(paramString.length() - 1);
      }
      TPLogUtil.i("TPProxyUtils", "pcdn url list: " + paramString.toString());
      ((Map)localObject).put("dl_param_pcdn_urls", paramString.toString());
      label1211:
      if ((paramTPDownloadParamData.getPcdnVtList() != null) && (!paramTPDownloadParamData.getPcdnVtList().isEmpty()))
      {
        paramString = new StringBuilder("");
        localIterator = paramTPDownloadParamData.getPcdnVtList().iterator();
        while (localIterator.hasNext())
        {
          paramString.append(((Integer)localIterator.next()).intValue());
          paramString.append(";");
        }
        if (paramString.length() > 0) {
          paramString.deleteCharAt(paramString.length() - 1);
        }
        ((Map)localObject).put("dl_param_pcdn_vts", paramString.toString());
      }
      return new TPDownloadParam(paramMap, TPProxyEnumUtils.dlType2Inner(paramTPDownloadParamData.getDlType()), (Map)localObject);
      paramTPDownloadParamData = new ArrayList(1);
      paramTPDownloadParamData.add(paramString);
      return new TPDownloadParam(paramTPDownloadParamData, 0, null);
      label1364:
      paramString = null;
    }
  }
  
  static TPDLProxyInitParam getProxyInitParam(Context paramContext, int paramInt)
  {
    return new TPDLProxyInitParam(TPPlayerConfig.getPlatform(), TPPlayerConfig.getAppVersionName(paramContext), TPPlayerConfig.getGuid(), TPPlayerConfig.getProxyCacheDir(paramInt), TPPlayerConfig.getProxyDataDir(paramInt), TPPlayerConfig.getProxyConfigStr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPProxyUtils
 * JD-Core Version:    0.7.0.1
 */