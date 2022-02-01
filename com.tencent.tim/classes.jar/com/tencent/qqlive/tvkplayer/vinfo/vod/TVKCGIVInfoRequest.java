package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.InvalidResponseCodeException;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVInfoResponse;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.RSAUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoConfig;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoEnum;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoHttpProcessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TVKCGIVInfoRequest
{
  private static final int CGI_RETRY_MAX_COUNT = 2;
  private static int CURRENT_HOST_URL_RETRY_MAX_COUNT = TVKVideoInfoConfig.getInstance().getCgiRetryTime();
  private static final String ENCRYPT_VER_4 = "4.1";
  private static final String ENCRYPT_VER_4_2 = "4.2";
  private static final String ENCRYPT_VER_5 = "5.1";
  private static final String TAG = "MediaPlayerMgr[TVKCGIVInfoRequest.java]";
  private int mCGIRetryCount = 0;
  private String mCKey = "";
  private ITVKCGIVInfoResponse mCallback;
  private int mCurrentHostUrlRetryCount = 0;
  private int mGetUrlCount;
  private ITVKHttpProcessor.ITVKHttpCallback mGetVinfoCb = new TVKCGIVInfoRequest.1(this);
  private boolean mIsCanceled = false;
  private TVKCGIVInfoRequestParams mParams = null;
  private String mRequestID = "";
  private boolean mRetryWithoutHttps = true;
  private long mStartRequestMS = 0L;
  private boolean mUseBakUrl;
  
  public TVKCGIVInfoRequest(TVKCGIVInfoRequestParams paramTVKCGIVInfoRequestParams, ITVKCGIVInfoResponse paramITVKCGIVInfoResponse)
  {
    this.mParams = paramTVKCGIVInfoRequestParams;
    this.mCallback = paramITVKCGIVInfoResponse;
    this.mRequestID = paramTVKCGIVInfoRequestParams.getRequestID();
  }
  
  private void callbackOnFailureOrRetry(int paramInt)
  {
    if ((this.mUseBakUrl) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT) && (this.mCallback != null))
    {
      paramInt = 1401000 + paramInt;
      this.mCallback.onVInfoFailure(this.mRequestID, String.format("%d.%d", new Object[] { Integer.valueOf(101), Integer.valueOf(paramInt) }), paramInt);
      return;
    }
    executeRequest();
  }
  
  private void fillClipAndDtypeParams(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (this.mParams == null)) {
      return;
    }
    if (this.mParams.getDlType() == 0)
    {
      paramMap.put("clip", "0");
      paramMap.put("dtype", "3");
      return;
    }
    if (this.mParams.getDlType() == 4)
    {
      paramMap.put("clip", "2");
      paramMap.put("dtype", "1");
      return;
    }
    if (this.mParams.getDlType() == 5)
    {
      paramMap.put("clip", "3");
      paramMap.put("dtype", "1");
      return;
    }
    if (this.mParams.getDlType() == 1)
    {
      paramMap.put("clip", "4");
      paramMap.put("dtype", "1");
      return;
    }
    if (this.mParams.getDlType() == 3)
    {
      paramMap.put("clip", "0");
      paramMap.put("dtype", "3");
      return;
    }
    paramMap.put("clip", "0");
    paramMap.put("dtype", String.valueOf(this.mParams.getDlType()));
  }
  
  private void fillEncryptVerParam(Map<String, String> paramMap)
  {
    if (65 == this.mParams.getEncrypVer())
    {
      paramMap.put("encryptVer", "4.1");
      return;
    }
    if (66 == this.mParams.getEncrypVer())
    {
      paramMap.put("encryptVer", "4.2");
      return;
    }
    paramMap.put("encryptVer", "5.1");
  }
  
  private void fillUpcParam(Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty(this.mParams.getUpc()))
    {
      String[] arrayOfString1;
      int i;
      label48:
      String[] arrayOfString2;
      if (this.mParams.getUpc().contains("&"))
      {
        arrayOfString1 = this.mParams.getUpc().split("&");
        int j = arrayOfString1.length;
        i = 0;
        if (i >= j) {
          return;
        }
        arrayOfString2 = arrayOfString1[i].split("=");
        if (arrayOfString2.length != 2) {
          break label113;
        }
        paramMap.put(arrayOfString2[0], arrayOfString2[1]);
      }
      for (;;)
      {
        i += 1;
        break label48;
        arrayOfString1 = new String[1];
        arrayOfString1[0] = this.mParams.getUpc();
        break;
        label113:
        if (arrayOfString2.length == 1) {
          paramMap.put(arrayOfString2[0], "");
        }
      }
    }
  }
  
  private int findAppDrmType(Map<String, String> paramMap)
  {
    int j = 0;
    int i = j;
    if (paramMap != null)
    {
      i = j;
      if (!paramMap.isEmpty())
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        i = 0;
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          i = j;
          if (localEntry != null)
          {
            i = j;
            try
            {
              if (localEntry.getKey() != null)
              {
                i = j;
                if (localEntry.getValue() != null) {
                  if (((String)localEntry.getKey()).equalsIgnoreCase("drm"))
                  {
                    i = TVKUtils.optInt((String)localEntry.getValue(), 0);
                  }
                  else
                  {
                    paramMap.put(localEntry.getKey(), localEntry.getValue());
                    i = j;
                  }
                }
              }
            }
            catch (Throwable localThrowable)
            {
              TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", localThrowable, "packRequestParams failed");
              i = j;
            }
          }
        }
        i = j;
      }
    }
    return i;
  }
  
  private String genCkey(TVKCGIVInfoRequestParams paramTVKCGIVInfoRequestParams, Map<String, String> paramMap)
  {
    int i = paramTVKCGIVInfoRequestParams.getEncrypVer();
    int j = paramTVKCGIVInfoRequestParams.getPlatForm();
    String str1 = paramTVKCGIVInfoRequestParams.getSdtFrom();
    Object localObject2 = paramTVKCGIVInfoRequestParams.getVid();
    String str2 = paramTVKCGIVInfoRequestParams.getAppVer();
    paramTVKCGIVInfoRequestParams.getFd();
    String str3 = paramTVKCGIVInfoRequestParams.getGuid();
    Object localObject1 = localObject2;
    if (paramMap != null)
    {
      localObject1 = localObject2;
      if (paramMap.containsKey("previd"))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)paramMap.get("previd"))) {
          localObject1 = RSAUtils.getNewVid((String)paramMap.get("previd"));
        }
      }
    }
    long l1 = TVKVideoInfoCheckTime.mServerTime;
    long l2 = (SystemClock.elapsedRealtime() - TVKVideoInfoCheckTime.mElapsedRealTime) / 1000L;
    paramMap = paramTVKCGIVInfoRequestParams.getCkeyExtraParamsMap();
    localObject2 = new int[3];
    localObject2[0] = 0;
    localObject2[1] = 0;
    localObject2[2] = 0;
    if (paramTVKCGIVInfoRequestParams.getRequestType() == 0)
    {
      localObject2[0] = 0;
      if (paramMap != null)
      {
        if ((!paramMap.containsKey("toushe")) || (!paramMap.containsKey("from_platform"))) {
          break label330;
        }
        localObject2[0] = 16;
        localObject2[1] = TVKUtils.optInt((String)paramMap.get("from_platform"), j);
      }
    }
    for (;;)
    {
      this.mCKey = CKeyFacade.getCKey(str3, l1 + l2, (String)localObject1, str2, String.valueOf(j), str1, (int[])localObject2, localObject2.length, "");
      TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] GenCkey appVer = " + TVideoMgr.getPlayerVersion() + " vid = " + (String)localObject1 + " encryptVer = " + i + " platform= " + j + " ckey= " + this.mCKey);
      return this.mCKey;
      localObject2[0] = 4;
      break;
      label330:
      if (paramMap.containsKey("sptest")) {
        localObject2[0] = 64;
      } else if (paramMap.containsKey("ottflag")) {
        localObject2[2] = TVKUtils.optInt((String)paramMap.get("ottflag"), 0);
      } else if (paramMap.containsKey("dlna")) {
        localObject2[0] = 1;
      }
    }
  }
  
  private Map<String, String> getHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", "qqlive");
    if (this.mParams.useIpV6Dns()) {
      localHashMap.put("Host", TVKVideoInfoEnum.VINFO_IPV6_HOST);
    }
    for (;;)
    {
      if (3 == this.mParams.getDlType()) {
        localHashMap.put("Accept-Encoding", "gzip");
      }
      if (this.mParams.getDlType() == 0) {
        localHashMap.put("Accept-Encoding", "gzip");
      }
      if (!TextUtils.isEmpty(this.mParams.getLoginCookie())) {
        localHashMap.put("Cookie", this.mParams.getLoginCookie());
      }
      return localHashMap;
      if (this.mUseBakUrl) {
        localHashMap.put("Host", TVKVideoInfoEnum.VINFO_BK_HOST);
      } else {
        localHashMap.put("Host", TVKVideoInfoEnum.VINFO_HOST);
      }
    }
  }
  
  private int getRequestTypeForVinfo()
  {
    if (this.mParams.useIpV6Dns()) {
      return 4;
    }
    return 1;
  }
  
  private String getRequestUrl()
  {
    Object localObject1;
    Object localObject2;
    if (this.mParams.useIpV6Dns())
    {
      localObject1 = TVKVideoInfoEnum.VINFO_IPV6_SERVER;
      localObject2 = TVKVideoInfoEnum.VINFO_IPV6_HOST;
    }
    for (;;)
    {
      Object localObject3 = localObject1;
      if (this.mParams.useIpV6Dns())
      {
        localObject3 = localObject1;
        if (!TVKVideoInfoCache.getInstance().isIpv6Error())
        {
          localObject2 = new TVKVideoInfoDnsQuery((String)localObject2);
          ((TVKVideoInfoDnsQuery)localObject2).start();
        }
      }
      try
      {
        ((TVKVideoInfoDnsQuery)localObject2).join(2000L);
        localObject2 = ((TVKVideoInfoDnsQuery)localObject2).getDnsIpv6();
        localObject3 = localObject1;
        if (((ArrayList)localObject2).size() > 0) {
          localObject3 = "http://[" + (String)((ArrayList)localObject2).get(0) + "]/getvinfo";
        }
        localObject1 = localObject3;
        if (!this.mRetryWithoutHttps) {
          if (!TVKVideoInfoConfig.getInstance().isEnableHttps())
          {
            localObject1 = localObject3;
            if (!TVKVideoInfoConfig.getInstance().isVinfoEnableHttps()) {}
          }
          else
          {
            localObject1 = ((String)localObject3).replaceFirst("http", "https");
          }
        }
        return localObject1;
        if (this.mUseBakUrl)
        {
          localObject1 = TVKVideoInfoEnum.VINFO_BK_SERVER;
          localObject2 = TVKVideoInfoEnum.VINFO_BK_HOST;
          continue;
        }
        localObject1 = TVKVideoInfoEnum.VINFO_SERVER;
        localObject2 = TVKVideoInfoEnum.VINFO_HOST;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "DNS Exception");
        }
      }
    }
  }
  
  private void handleHttpCallbackOnFailure(IOException paramIOException)
  {
    TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "getvinfo onFailure, e:" + paramIOException.toString());
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.mStartRequestMS;
    if ((paramIOException instanceof ITVKHttpProcessor.InvalidResponseCodeException)) {}
    for (int i = ((ITVKHttpProcessor.InvalidResponseCodeException)paramIOException).responseCode;; i = TVKVideoInfoErrorCodeUtil.getErrCodeByThrowable(paramIOException.getCause()))
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] failed, time cost:" + (l1 - l2) + "ms error:" + paramIOException.toString());
      if ((this.mUseBakUrl) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT) && (this.mCallback != null))
      {
        int j = 1401000 + i;
        this.mCallback.onVInfoFailure(this.mRequestID, String.format("%d.%d", new Object[] { Integer.valueOf(101), Integer.valueOf(j) }), j);
      }
      if ((i >= 16) && (i <= 20)) {
        this.mRetryWithoutHttps = true;
      }
      if (this.mParams.useIpV6Dns()) {
        TVKVideoInfoCache.getInstance().setIpv6Error(true);
      }
      executeRequest();
      return;
    }
  }
  
  private void handleHttpCallbackOnSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "getvinfo onSuccess.");
    for (;;)
    {
      try
      {
        if ((paramHttpResponse.mHeaders.containsKey("Content-Encoding")) && (((List)paramHttpResponse.mHeaders.get("Content-Encoding")).contains("gzip")))
        {
          paramHttpResponse = TVKUtils.gzipDeCompress(paramHttpResponse.mData);
          if (paramHttpResponse == null) {
            break label355;
          }
          paramHttpResponse = new String(paramHttpResponse, "UTF-8");
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.mStartRequestMS;
          TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] success time cost:" + (l1 - l2) + " xml:" + paramHttpResponse);
          if (!paramHttpResponse.contains("<?xml"))
          {
            this.mRetryWithoutHttps = false;
            executeRequest();
          }
        }
        else
        {
          paramHttpResponse = new String(paramHttpResponse.mData, "UTF-8");
          continue;
        }
        if (TextUtils.isEmpty(paramHttpResponse)) {
          break label340;
        }
      }
      catch (Exception paramHttpResponse)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", paramHttpResponse);
        callbackOnFailureOrRetry(23);
        return;
      }
      paramHttpResponse = new TVKCGIParser(paramHttpResponse);
      if (paramHttpResponse.init())
      {
        if ((this.mCGIRetryCount <= 2) && ((paramHttpResponse.isXML85ErrorCode()) || (paramHttpResponse.isXMLHaveRetryNode())))
        {
          TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] cgi return retry or 85 error");
          this.mCGIRetryCount += 1;
          this.mCurrentHostUrlRetryCount -= 1;
          this.mGetUrlCount -= 1;
          if (this.mCGIRetryCount == 2) {
            if (this.mUseBakUrl) {
              break label290;
            }
          }
          label290:
          for (boolean bool = true;; bool = false)
          {
            this.mUseBakUrl = bool;
            this.mCurrentHostUrlRetryCount = 0;
            executeRequest();
            return;
          }
        }
        if (this.mCallback != null) {
          this.mCallback.onVInfoSuccess(this.mRequestID, paramHttpResponse.getXml(), paramHttpResponse.getDocument());
        }
      }
      else
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] xml parse error");
        callbackOnFailureOrRetry(15);
        return;
        label340:
        TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] return xml error!");
        callbackOnFailureOrRetry(13);
        return;
        label355:
        paramHttpResponse = "";
      }
    }
  }
  
  private Map<String, String> packRequestParams()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("vid", this.mParams.getVid());
    localHashMap.put("charge", String.valueOf(this.mParams.isCharge()));
    localHashMap.put("platform", String.valueOf(this.mParams.getPlatForm()));
    localHashMap.put("sdtfrom", this.mParams.getSdtFrom());
    localHashMap.put("fhdswitch", "0");
    localHashMap.put("sphls", "1");
    localHashMap.put("defn", this.mParams.getFormat());
    localHashMap.put("ipstack", String.valueOf(this.mParams.getipstack()));
    fillClipAndDtypeParams(localHashMap);
    if ((this.mParams.getDlType() == 0) || (this.mParams.getDlType() == 3)) {
      if ((this.mParams.getCkeyExtraParamsMap() != null) && (!this.mParams.getCkeyExtraParamsMap().isEmpty())) {
        break label420;
      }
    }
    label420:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localHashMap.put("sphls", "2");
        localHashMap.put("spgzip", "1");
      }
      if (this.mParams.getPlayerCapacity() > 0) {
        localHashMap.put("device", String.valueOf(this.mParams.getPlayerCapacity()));
      }
      if (this.mParams.getAppVer() != null) {
        localHashMap.put("appVer", this.mParams.getAppVer());
      }
      fillEncryptVerParam(localHashMap);
      fillUpcParam(localHashMap);
      Map localMap = this.mParams.getExtraParamsMap();
      localHashMap.put("drm", String.valueOf(findAppDrmType(localMap) + this.mParams.getDrm()));
      localHashMap.put("cKey", genCkey(this.mParams, localMap));
      localHashMap.put("newnettype", String.valueOf(this.mParams.getNetworkType()));
      localHashMap.put("otype", "xml");
      if (!TextUtils.isEmpty(this.mParams.getWxOpenId())) {
        localHashMap.put("openid", this.mParams.getWxOpenId());
      }
      localHashMap.put("spwm", "1");
      return localHashMap;
    }
  }
  
  public void cancelRequest()
  {
    this.mIsCanceled = true;
  }
  
  public void executeRequest()
  {
    if (this.mIsCanceled) {
      return;
    }
    if ((!this.mUseBakUrl) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT)) {
      if (this.mUseBakUrl) {
        break label138;
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      this.mUseBakUrl = bool;
      this.mCurrentHostUrlRetryCount = 0;
      if (this.mCurrentHostUrlRetryCount >= CURRENT_HOST_URL_RETRY_MAX_COUNT) {
        break;
      }
      this.mGetUrlCount += 1;
      this.mCurrentHostUrlRetryCount += 1;
      Map localMap = packRequestParams();
      TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] start to request, request time:" + this.mCurrentHostUrlRetryCount);
      this.mStartRequestMS = SystemClock.elapsedRealtime();
      TVKVideoInfoHttpProcessor.getInstance().addToRequestQueue(this.mCurrentHostUrlRetryCount, getRequestUrl(), localMap, getHeaders(), this.mGetVinfoCb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVInfoRequest
 * JD-Core Version:    0.7.0.1
 */