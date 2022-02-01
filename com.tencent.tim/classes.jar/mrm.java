import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import org.json.JSONException;
import org.json.JSONObject;

public class mrm
{
  public AdData a;
  public WadlParams a;
  public int aTP;
  public String aaJ = "";
  public String aaK = "";
  public AdvertisementInfo advertisementInfo;
  public String ajG;
  public String ajH;
  public boolean anA;
  public VideoInfo.GameAdComData gameAdComData;
  public String mAppID;
  public String mAppName;
  public String mDownloadUrl;
  public String mPackageName;
  public int mState = 0;
  public String via;
  
  public static String a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramVideoAdInfo.Wo != null)
        {
          paramVideoAdInfo = new JSONObject(paramVideoAdInfo.Wo).optString("pkg_name");
          return paramVideoAdInfo;
        }
      }
      catch (JSONException paramVideoAdInfo)
      {
        paramVideoAdInfo.printStackTrace();
        QLog.d("ADVideoAppDownloadData", 1, "getADVideoAppDownloadData exception :" + paramVideoAdInfo.toString());
      }
    }
    return null;
  }
  
  /* Error */
  public static mrm a(VideoAdInfo paramVideoAdInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 47	com/tencent/biz/pubaccount/VideoAdInfo:Wo	Ljava/lang/String;
    //   10: ifnull +144 -> 154
    //   13: new 49	org/json/JSONObject
    //   16: dup
    //   17: aload_0
    //   18: getfield 47	com/tencent/biz/pubaccount/VideoAdInfo:Wo	Ljava/lang/String;
    //   21: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: new 2	mrm
    //   28: dup
    //   29: invokespecial 85	mrm:<init>	()V
    //   32: astore_2
    //   33: aload_2
    //   34: aload_1
    //   35: ldc 87
    //   37: invokevirtual 58	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: putfield 89	mrm:mAppID	Ljava/lang/String;
    //   43: aload_2
    //   44: aload_0
    //   45: getfield 92	com/tencent/biz/pubaccount/VideoAdInfo:Wc	Ljava/lang/String;
    //   48: putfield 94	mrm:ajG	Ljava/lang/String;
    //   51: aload_2
    //   52: aload_1
    //   53: ldc 54
    //   55: invokevirtual 58	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: putfield 96	mrm:mPackageName	Ljava/lang/String;
    //   61: aload_2
    //   62: aload_1
    //   63: ldc 98
    //   65: invokevirtual 58	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: putfield 100	mrm:mAppName	Ljava/lang/String;
    //   71: aload_2
    //   72: aconst_null
    //   73: putfield 102	mrm:mDownloadUrl	Ljava/lang/String;
    //   76: aload_2
    //   77: iconst_0
    //   78: putfield 104	mrm:aTP	I
    //   81: aload_2
    //   82: iconst_0
    //   83: putfield 32	mrm:mState	I
    //   86: aload_2
    //   87: astore_1
    //   88: aload_0
    //   89: getfield 107	com/tencent/biz/pubaccount/VideoAdInfo:mVia	Ljava/lang/String;
    //   92: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne +13 -> 108
    //   98: aload_2
    //   99: aload_0
    //   100: getfield 107	com/tencent/biz/pubaccount/VideoAdInfo:mVia	Ljava/lang/String;
    //   103: putfield 115	mrm:via	Ljava/lang/String;
    //   106: aload_2
    //   107: astore_1
    //   108: aload_1
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_0
    //   114: invokevirtual 61	org/json/JSONException:printStackTrace	()V
    //   117: ldc 63
    //   119: iconst_1
    //   120: new 65	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   127: ldc 68
    //   129: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: invokevirtual 76	org/json/JSONException:toString	()Ljava/lang/String;
    //   136: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: goto -37 -> 108
    //   148: astore_0
    //   149: aload_2
    //   150: astore_1
    //   151: goto -38 -> 113
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -48 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramVideoAdInfo	VideoAdInfo
    //   24	132	1	localObject	Object
    //   32	118	2	localmrm	mrm
    // Exception table:
    //   from	to	target	type
    //   6	33	110	org/json/JSONException
    //   33	86	148	org/json/JSONException
    //   88	106	148	org/json/JSONException
  }
  
  /* Error */
  public static mrm a(VideoInfo.GameAdComData paramGameAdComData)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 121	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:Xl	Ljava/lang/String;
    //   10: ifnull +177 -> 187
    //   13: new 49	org/json/JSONObject
    //   16: dup
    //   17: aload_0
    //   18: getfield 121	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:Xl	Ljava/lang/String;
    //   21: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_0
    //   26: new 123	com/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 126	com/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo:<init>	(Lorg/json/JSONObject;)V
    //   34: putfield 129	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:a	Lcom/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo;
    //   37: new 2	mrm
    //   40: dup
    //   41: invokespecial 85	mrm:<init>	()V
    //   44: astore_1
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 132	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:sAppid	Ljava/lang/String;
    //   50: putfield 89	mrm:mAppID	Ljava/lang/String;
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 135	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:WX	Ljava/lang/String;
    //   58: putfield 96	mrm:mPackageName	Ljava/lang/String;
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 138	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:sGameName	Ljava/lang/String;
    //   66: putfield 100	mrm:mAppName	Ljava/lang/String;
    //   69: aload_1
    //   70: aload_2
    //   71: ldc 140
    //   73: invokevirtual 58	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: putfield 102	mrm:mDownloadUrl	Ljava/lang/String;
    //   79: aload_1
    //   80: iconst_0
    //   81: putfield 104	mrm:aTP	I
    //   84: aload_1
    //   85: iconst_0
    //   86: putfield 32	mrm:mState	I
    //   89: aload_1
    //   90: iconst_1
    //   91: putfield 142	mrm:anA	Z
    //   94: aload_1
    //   95: aload_0
    //   96: putfield 144	mrm:gameAdComData	Lcom/tencent/biz/pubaccount/VideoInfo$GameAdComData;
    //   99: new 49	org/json/JSONObject
    //   102: dup
    //   103: aload_0
    //   104: getfield 147	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:Xt	Ljava/lang/String;
    //   107: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   110: astore_0
    //   111: aload_1
    //   112: aload_0
    //   113: ldc 149
    //   115: ldc 34
    //   117: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: putfield 38	mrm:aaK	Ljava/lang/String;
    //   123: aload_1
    //   124: aload_0
    //   125: ldc 154
    //   127: ldc 34
    //   129: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 36	mrm:aaJ	Ljava/lang/String;
    //   135: aload_1
    //   136: areturn
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: astore_1
    //   142: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq -10 -> 135
    //   148: ldc 63
    //   150: iconst_1
    //   151: new 65	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   158: ldc 68
    //   160: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_2
    //   164: invokevirtual 76	org/json/JSONException:toString	()Ljava/lang/String;
    //   167: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: astore_1
    //   178: goto -43 -> 135
    //   181: astore_2
    //   182: aload_1
    //   183: astore_0
    //   184: goto -44 -> 140
    //   187: aconst_null
    //   188: astore_1
    //   189: goto -54 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramGameAdComData	VideoInfo.GameAdComData
    //   44	145	1	localObject	Object
    //   24	47	2	localJSONObject	JSONObject
    //   137	27	2	localJSONException1	JSONException
    //   181	1	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   6	45	137	org/json/JSONException
    //   45	135	181	org/json/JSONException
  }
  
  public static mrm a(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo, false);
  }
  
  public static mrm a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    if (paramAdvertisementInfo == null) {
      return null;
    }
    Object localObject2;
    try
    {
      if (knd.f(paramAdvertisementInfo) == 2)
      {
        localObject3 = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
        localObject2 = new mrm();
        localObject1 = localObject2;
      }
    }
    catch (JSONException paramAdvertisementInfo)
    {
      Object localObject3;
      JSONObject localJSONObject;
      Object localObject1 = null;
      label323:
      paramAdvertisementInfo.printStackTrace();
      QLog.d("ADVideoAppDownloadData", 1, "getADVideoAppDownloadData exception :" + paramAdvertisementInfo.toString());
      localObject2 = localObject1;
    }
    try
    {
      ((mrm)localObject2).anA = true;
      localObject1 = localObject2;
      ((mrm)localObject2).mAppID = ((JSONObject)localObject3).optString("game_app_id");
      localObject1 = localObject2;
      ((mrm)localObject2).mPackageName = ((JSONObject)localObject3).optString("game_pkg_name");
      localObject1 = localObject2;
      ((mrm)localObject2).mAppName = ((JSONObject)localObject3).optString("game_app_name");
      localObject1 = localObject2;
      ((mrm)localObject2).mDownloadUrl = ((JSONObject)localObject3).optString("game_apk_url");
      localObject1 = localObject2;
      ((mrm)localObject2).aaJ = ((JSONObject)localObject3).optString("game_adtag");
      localObject1 = localObject2;
      ((mrm)localObject2).aaK = ((JSONObject)localObject3).optString("__ADSTR__");
      localObject1 = localObject2;
      ((mrm)localObject2).aTP = 0;
      localObject1 = localObject2;
      ((mrm)localObject2).mState = 0;
      localObject1 = localObject2;
      ((mrm)localObject2).advertisementInfo = paramAdvertisementInfo;
      return localObject2;
    }
    catch (JSONException paramAdvertisementInfo)
    {
      break label323;
      localObject2 = null;
    }
    if (paramAdvertisementInfo.mAdExt != null)
    {
      localJSONObject = new JSONObject(paramAdvertisementInfo.mAdExt);
      localObject3 = new mrm();
      localObject1 = localObject3;
      ((mrm)localObject3).mAppID = localJSONObject.optString("appid");
      if (paramBoolean) {
        localObject1 = localObject3;
      }
      for (localObject2 = paramAdvertisementInfo.mAdRl;; localObject2 = paramAdvertisementInfo.mAdDownloadApiUrl)
      {
        localObject1 = localObject3;
        ((mrm)localObject3).ajG = ((String)localObject2);
        localObject1 = localObject3;
        ((mrm)localObject3).mPackageName = localJSONObject.optString("pkg_name");
        localObject1 = localObject3;
        ((mrm)localObject3).mAppName = localJSONObject.optString("appname");
        localObject1 = localObject3;
        ((mrm)localObject3).mDownloadUrl = "";
        localObject1 = localObject3;
        ((mrm)localObject3).aTP = 0;
        localObject1 = localObject3;
        ((mrm)localObject3).mState = 0;
        localObject1 = localObject3;
        ((mrm)localObject3).advertisementInfo = paramAdvertisementInfo;
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (TextUtils.isEmpty(paramAdvertisementInfo.mAdVia)) {
          break;
        }
        localObject1 = localObject3;
        ((mrm)localObject3).via = paramAdvertisementInfo.mAdVia;
        localObject2 = localObject3;
        break;
        localObject1 = localObject3;
      }
    }
    return localObject2;
  }
  
  public static mrm a(AdData paramAdData)
  {
    if ((paramAdData == null) || (paramAdData.a == null)) {
      return null;
    }
    mrm localmrm = new mrm();
    Object localObject;
    if (paramAdData.FK())
    {
      localObject = paramAdData.aC.opt("extendInfo");
      if ((localObject instanceof JSONObject))
      {
        localmrm.mAppID = ((JSONObject)localObject).optString("game_app_id");
        localmrm.ajG = ((JSONObject)localObject).optString("game_apk_url");
        localmrm.mPackageName = ((JSONObject)localObject).optString("game_pkg_name");
        localmrm.mAppName = ((JSONObject)localObject).optString("game_app_name");
      }
    }
    for (localmrm.mDownloadUrl = ((JSONObject)localObject).optString("game_apk_url");; localmrm.mDownloadUrl = paramAdData.a.ZK)
    {
      localmrm.aTP = 0;
      localmrm.mState = 0;
      localmrm.a = paramAdData;
      if (!TextUtils.isEmpty(paramAdData.via)) {
        localmrm.via = paramAdData.via;
      }
      if (kmx.a(paramAdData)) {
        localmrm.anA = true;
      }
      localmrm.aaJ = paramAdData.alX;
      localmrm.aaK = paramAdData.alW;
      localmrm.ajH = paramAdData.ajH;
      return localmrm;
      localmrm.mAppID = paramAdData.a.appid;
      localmrm.ajG = paramAdData.a.ZJ;
      localmrm.mPackageName = paramAdData.a.pkgName;
      localmrm.mAppName = paramAdData.a.appname;
    }
  }
  
  public static mrm a(kkx paramkkx, int paramInt)
  {
    boolean bool = false;
    if (paramkkx == null) {
      return null;
    }
    mrm localmrm = new mrm();
    localmrm.mAppID = paramkkx.aaD;
    localmrm.ajG = paramkkx.aaF;
    localmrm.mPackageName = paramkkx.aaC;
    localmrm.mAppName = paramkkx.aaE;
    localmrm.mDownloadUrl = paramkkx.aaF;
    localmrm.aaJ = paramkkx.aaJ;
    localmrm.aaK = paramkkx.aaK;
    localmrm.aTP = 0;
    localmrm.mState = 0;
    if (paramInt != 0) {
      bool = true;
    }
    localmrm.anA = bool;
    return localmrm;
  }
  
  public boolean DV()
  {
    return (!TextUtils.isEmpty(this.mAppID)) && (!TextUtils.isEmpty(this.mPackageName)) && (!TextUtils.isEmpty(this.ajG));
  }
  
  public boolean e(mrm parammrm)
  {
    return (parammrm != null) && (parammrm.mAppID.equals(this.mAppID)) && (parammrm.mPackageName.equals(this.mPackageName)) && (parammrm.ajG.equals(this.ajG));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (mrm)paramObject;
      if (this.mDownloadUrl != null)
      {
        if (this.mDownloadUrl.equals(paramObject.mDownloadUrl)) {}
      }
      else {
        while (paramObject.mDownloadUrl != null) {
          return false;
        }
      }
      if (this.mPackageName != null) {
        return this.mPackageName.equals(paramObject.mPackageName);
      }
    } while (paramObject.mPackageName == null);
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.mDownloadUrl != null) {}
    for (int i = this.mDownloadUrl.hashCode();; i = 0)
    {
      if (this.mPackageName != null) {
        j = this.mPackageName.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public boolean isValid()
  {
    return !TextUtils.isEmpty(this.mDownloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrm
 * JD-Core Version:    0.7.0.1
 */