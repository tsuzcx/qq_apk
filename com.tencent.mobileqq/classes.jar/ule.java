import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import org.json.JSONException;
import org.json.JSONObject;

public class ule
{
  public int a;
  public VideoInfo.GameAdComData a;
  public AdvertisementInfo a;
  public AdData a;
  public WadlParams a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g = "";
  public String h = "";
  public String i;
  public String j;
  
  public ule()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static String a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramVideoAdInfo.r != null)
        {
          paramVideoAdInfo = new JSONObject(paramVideoAdInfo.r).optString("pkg_name");
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
  public static ule a(VideoInfo.GameAdComData paramGameAdComData)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 83	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:t	Ljava/lang/String;
    //   10: ifnull +185 -> 195
    //   13: new 44	org/json/JSONObject
    //   16: dup
    //   17: aload_0
    //   18: getfield 83	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:t	Ljava/lang/String;
    //   21: invokespecial 47	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_0
    //   26: new 85	com/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 88	com/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo:<init>	(Lorg/json/JSONObject;)V
    //   34: putfield 91	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:a	Lcom/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo;
    //   37: new 2	ule
    //   40: dup
    //   41: invokespecial 92	ule:<init>	()V
    //   44: astore_1
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 93	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:g	Ljava/lang/String;
    //   50: putfield 95	ule:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 97	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:d	Ljava/lang/String;
    //   58: putfield 98	ule:d	Ljava/lang/String;
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 100	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:c	Ljava/lang/String;
    //   66: putfield 102	ule:e	Ljava/lang/String;
    //   69: aload_1
    //   70: aload_2
    //   71: ldc 104
    //   73: invokevirtual 53	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: putfield 105	ule:c	Ljava/lang/String;
    //   79: aload_1
    //   80: iconst_0
    //   81: putfield 107	ule:jdField_b_of_type_Int	I
    //   84: aload_1
    //   85: iconst_0
    //   86: putfield 27	ule:jdField_a_of_type_Int	I
    //   89: aload_1
    //   90: iconst_1
    //   91: putfield 109	ule:jdField_a_of_type_Boolean	Z
    //   94: aload_1
    //   95: aload_0
    //   96: putfield 111	ule:jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData	Lcom/tencent/biz/pubaccount/VideoInfo$GameAdComData;
    //   99: new 44	org/json/JSONObject
    //   102: dup
    //   103: aload_0
    //   104: getfield 114	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:B	Ljava/lang/String;
    //   107: invokespecial 47	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   110: astore_2
    //   111: aload_1
    //   112: aload_2
    //   113: ldc 116
    //   115: ldc 29
    //   117: invokevirtual 119	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: putfield 33	ule:h	Ljava/lang/String;
    //   123: aload_1
    //   124: aload_2
    //   125: ldc 121
    //   127: ldc 29
    //   129: invokevirtual 119	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 31	ule:g	Ljava/lang/String;
    //   135: aload_1
    //   136: aload_0
    //   137: getfield 124	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:v	Ljava/lang/String;
    //   140: putfield 126	ule:j	Ljava/lang/String;
    //   143: aload_1
    //   144: areturn
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_0
    //   149: astore_1
    //   150: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq -10 -> 143
    //   156: ldc 58
    //   158: iconst_1
    //   159: new 60	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   166: ldc 63
    //   168: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_2
    //   172: invokevirtual 71	org/json/JSONException:toString	()Ljava/lang/String;
    //   175: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_0
    //   185: astore_1
    //   186: goto -43 -> 143
    //   189: astore_2
    //   190: aload_1
    //   191: astore_0
    //   192: goto -44 -> 148
    //   195: aconst_null
    //   196: astore_1
    //   197: goto -54 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramGameAdComData	VideoInfo.GameAdComData
    //   44	153	1	localObject	Object
    //   24	101	2	localJSONObject	JSONObject
    //   145	27	2	localJSONException1	JSONException
    //   189	1	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   6	45	145	org/json/JSONException
    //   45	143	189	org/json/JSONException
  }
  
  public static ule a(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo, false);
  }
  
  public static ule a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramAdvertisementInfo == null) {}
    for (;;)
    {
      return localObject2;
      try
      {
        if (uks.a(paramAdvertisementInfo) == 2)
        {
          localObject3 = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
          localObject1 = new ule();
          localObject2 = localObject1;
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              ((ule)localObject1).jdField_a_of_type_Boolean = true;
              localObject2 = localObject1;
              ((ule)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("game_app_id");
              localObject2 = localObject1;
              ((ule)localObject1).d = ((JSONObject)localObject3).optString("game_pkg_name");
              localObject2 = localObject1;
              ((ule)localObject1).e = ((JSONObject)localObject3).optString("game_app_name");
              localObject2 = localObject1;
              ((ule)localObject1).c = ((JSONObject)localObject3).optString("game_apk_url");
              localObject2 = localObject1;
              ((ule)localObject1).g = ((JSONObject)localObject3).optString("game_adtag");
              localObject2 = localObject1;
              ((ule)localObject1).h = ((JSONObject)localObject3).optString("__ADSTR__");
              localObject2 = localObject1;
              ((ule)localObject1).jdField_b_of_type_Int = 0;
              localObject2 = localObject1;
              ((ule)localObject1).jdField_a_of_type_Int = 0;
              localObject2 = localObject1;
              ((ule)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
              localObject2 = localObject1;
              if (paramAdvertisementInfo.mAdExt == null) {
                continue;
              }
              localObject2 = localObject1;
              localJSONObject = new JSONObject(paramAdvertisementInfo.mAdExt);
              localObject2 = localObject1;
              localObject3 = new ule();
            }
            catch (JSONException localJSONException3)
            {
              Object localObject3;
              JSONObject localJSONObject;
              localObject1 = localObject2;
              continue;
              JSONException localJSONException4;
              continue;
            }
            try
            {
              ((ule)localObject3).jdField_a_of_type_JavaLangString = localJSONObject.optString("appid");
              if (paramBoolean)
              {
                localObject1 = paramAdvertisementInfo.mAdRl;
                ((ule)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject1);
                ((ule)localObject3).d = localJSONObject.optString("pkg_name");
                ((ule)localObject3).e = localJSONObject.optString("appname");
                if (!TextUtils.isEmpty(((ule)localObject3).jdField_b_of_type_JavaLangString)) {
                  continue;
                }
                localObject1 = localJSONObject.optString("pkgurl");
                ((ule)localObject3).c = ((String)localObject1);
                ((ule)localObject3).jdField_b_of_type_Int = 0;
                ((ule)localObject3).jdField_a_of_type_Int = 0;
                ((ule)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
                localObject1 = localObject3;
                if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdVia))
                {
                  ((ule)localObject3).f = paramAdvertisementInfo.mAdVia;
                  localObject1 = localObject3;
                }
                localObject2 = localObject1;
                if (localObject1 == null) {
                  break;
                }
                ((ule)localObject1).j = paramAdvertisementInfo.mAdBtnTxt;
                return localObject1;
              }
              localObject1 = paramAdvertisementInfo.mAdDownloadApiUrl;
              continue;
              localObject1 = "";
              continue;
              localJSONException2 = localJSONException2;
              localObject1 = null;
            }
            catch (JSONException localJSONException1)
            {
              localObject1 = localJSONException3;
              localJSONException4 = localJSONException1;
            }
          }
          localJSONException2.printStackTrace();
          QLog.d("ADVideoAppDownloadData", 1, "getADVideoAppDownloadData exception :" + localJSONException2.toString());
          continue;
          Object localObject1 = null;
        }
      }
    }
  }
  
  public static ule a(AdData paramAdData)
  {
    if ((paramAdData == null) || (paramAdData.jdField_a_of_type_Ufq == null)) {
      return null;
    }
    ule localule = new ule();
    if (paramAdData.a())
    {
      Object localObject = paramAdData.b.opt("extendInfo");
      if ((localObject instanceof JSONObject))
      {
        localule.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("game_app_id");
        localule.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("game_apk_url");
        localule.d = ((JSONObject)localObject).optString("game_pkg_name");
        localule.e = ((JSONObject)localObject).optString("game_app_name");
        localule.c = ((JSONObject)localObject).optString("game_apk_url");
        localule.j = paramAdData.b.optString("button");
      }
    }
    for (;;)
    {
      localule.jdField_b_of_type_Int = 0;
      localule.jdField_a_of_type_Int = 0;
      localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
      if (!TextUtils.isEmpty(paramAdData.s)) {
        localule.f = paramAdData.s;
      }
      localule.g = paramAdData.K;
      localule.h = paramAdData.J;
      localule.i = paramAdData.I;
      return localule;
      localule.jdField_a_of_type_JavaLangString = paramAdData.jdField_a_of_type_Ufq.c;
      localule.jdField_b_of_type_JavaLangString = paramAdData.jdField_a_of_type_Ufq.jdField_a_of_type_JavaLangString;
      localule.d = paramAdData.jdField_a_of_type_Ufq.jdField_b_of_type_JavaLangString;
      localule.e = paramAdData.jdField_a_of_type_Ufq.d;
      localule.c = paramAdData.jdField_a_of_type_Ufq.e;
      if (uki.a(paramAdData))
      {
        localule.jdField_a_of_type_Boolean = true;
        if (paramAdData.jdField_a_of_type_Ufr != null) {
          localule.j = paramAdData.jdField_a_of_type_Ufr.l;
        }
      }
      else if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        localule.j = paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt;
      }
    }
  }
  
  public static ule a(uga paramuga, int paramInt)
  {
    boolean bool = false;
    if (paramuga == null) {
      return null;
    }
    ule localule = new ule();
    localule.jdField_a_of_type_JavaLangString = paramuga.p;
    localule.jdField_b_of_type_JavaLangString = paramuga.r;
    localule.d = paramuga.o;
    localule.e = paramuga.q;
    localule.c = paramuga.r;
    localule.g = paramuga.v;
    localule.h = paramuga.w;
    localule.jdField_b_of_type_Int = 0;
    localule.jdField_a_of_type_Int = 0;
    if (paramInt != 0) {
      bool = true;
    }
    localule.jdField_a_of_type_Boolean = bool;
    localule.j = paramuga.D;
    return localule;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.c);
  }
  
  public boolean a(ule paramule)
  {
    return (paramule != null) && (paramule.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramule.d.equals(this.d)) && (paramule.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean b()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
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
      paramObject = (ule)paramObject;
      if (this.c != null)
      {
        if (this.c.equals(paramObject.c)) {}
      }
      else {
        while (paramObject.c != null) {
          return false;
        }
      }
      if (this.d != null) {
        return this.d.equals(paramObject.d);
      }
    } while (paramObject.d == null);
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    if (this.c != null) {}
    for (int k = this.c.hashCode();; k = 0)
    {
      if (this.d != null) {
        m = this.d.hashCode();
      }
      return k * 31 + m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ule
 * JD-Core Version:    0.7.0.1
 */