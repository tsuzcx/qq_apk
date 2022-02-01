package com.tencent.mobileqq.minigame.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class BlockAdManager
{
  private static final String ORIENTATION_LANDSCAPE = "landscape";
  private static final String ORIENTATION_VERTICAL = "vertical";
  private static final String TAG = "BlockAdManager";
  private static BlockAdManager mInstance;
  private HashMap<Integer, BlockAdInfo> blockAdInfoHashMap = new HashMap();
  private HashMap<Integer, BlockAdView> blockAdViewMap = new HashMap();
  
  public static BlockAdManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BlockAdManager();
    }
    return mInstance;
  }
  
  public void genarateBlockAdData() {}
  
  public BlockAdView genarateBlockAdView(Context paramContext, BlockAdInfo paramBlockAdInfo)
  {
    if (paramBlockAdInfo == null) {
      return null;
    }
    if (paramBlockAdInfo.getOri() == 90) {}
    for (boolean bool = true;; bool = false)
    {
      paramContext = new BlockAdView(paramContext, bool);
      paramContext.setData(paramBlockAdInfo);
      this.blockAdViewMap.put(Integer.valueOf(paramBlockAdInfo.getCompId()), paramContext);
      return paramContext;
    }
  }
  
  public BlockAdInfo getBlockAdInfo(int paramInt)
  {
    return (BlockAdInfo)this.blockAdInfoHashMap.get(Integer.valueOf(paramInt));
  }
  
  public BlockAdView getBlockAdView(int paramInt)
  {
    if ((this.blockAdViewMap == null) || (!this.blockAdViewMap.containsKey(Integer.valueOf(paramInt)))) {
      return null;
    }
    return (BlockAdView)this.blockAdViewMap.get(Integer.valueOf(paramInt));
  }
  
  public ArrayList<String> getReportUrlList(List<GdtAd> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GdtAd localGdtAd = (GdtAd)paramList.next();
        if ((localGdtAd != null) && (localGdtAd.info != null) && (localGdtAd.info.report_info != null) && (localGdtAd.info.report_info.exposure_url != null)) {
          localArrayList.add(localGdtAd.info.report_info.exposure_url.get());
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<MiniAppInfo> mockFakeData(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt)
    {
      MiniAppInfo localMiniAppInfo = new MiniAppInfo();
      localMiniAppInfo.appId = "363";
      localMiniAppInfo.name = ("假斗地主" + paramInt);
      localMiniAppInfo.iconUrl = "https://qzonestyle.gtimg.cn/aoi/sola/20181225203752_nOJAay9QdG.png";
      localArrayList.add(localMiniAppInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  public BlockAdInfo parseBlockAdInfoFromJson(String paramString)
  {
    int n = -1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      for (;;)
      {
        Object localObject2;
        int m;
        int k;
        int j;
        int i;
        label96:
        Object localObject1;
        try
        {
          localObject2 = new JSONObject(paramString);
          str1 = ((JSONObject)localObject2).getString("adUnitId");
        }
        catch (Exception localException1)
        {
          String str1;
          String str2;
          boolean bool;
          int i1;
          j = -1;
          k = -1;
          i = -1;
          localObject2 = "";
          m = -1;
          QLog.i("BlockAdManager", 2, "parseBannerAdPosInfoFromJson error " + paramString, localException1);
          localObject1 = localObject2;
          continue;
        }
        try
        {
          m = ((JSONObject)localObject2).getJSONObject("style").getInt("left");
        }
        catch (Exception localException2)
        {
          j = -1;
          k = -1;
          i = -1;
          m = -1;
          localObject2 = localObject1;
          localObject1 = localException2;
          continue;
        }
        try
        {
          k = ((JSONObject)localObject2).getJSONObject("style").getInt("top");
        }
        catch (Exception localException3)
        {
          j = -1;
          i = -1;
          k = -1;
          localObject2 = localObject1;
          localObject1 = localException3;
          continue;
        }
        try
        {
          j = ((JSONObject)localObject2).optInt("size", 1);
        }
        catch (Exception localException4)
        {
          i = -1;
          j = -1;
          localObject2 = localObject1;
          localObject1 = localException4;
          continue;
        }
        for (;;)
        {
          try
          {
            str2 = ((JSONObject)localObject2).optString("orientation", "landscape");
            bool = "landscape".equals(str2);
            if (bool) {
              i = 90;
            }
          }
          catch (Exception localException5)
          {
            i = -1;
            localObject2 = localObject1;
            localObject1 = localException5;
            break label205;
            break label96;
          }
          try
          {
            i1 = ((JSONObject)localObject2).getInt("compId");
            n = i1;
            if ((TextUtils.isEmpty(str1)) || (m < 0) || (k < 0) || (n < 0) || (i < 0)) {
              break;
            }
            paramString = new BlockAdInfo(str1, m, k, j, i, n);
            this.blockAdInfoHashMap.put(Integer.valueOf(n), paramString);
            return paramString;
          }
          catch (Exception localException6)
          {
            localObject2 = localObject1;
            localObject1 = localException6;
            break label205;
            i = -1;
          }
        }
      }
      bool = "vertical".equals(str2);
      if (!bool) {
        break label327;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.BlockAdManager
 * JD-Core Version:    0.7.0.1
 */