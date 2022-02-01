import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadinjoyJumpUtils.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PreloadManager.a;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.util.NetworkState;
import java.net.URL;
import java.util.ArrayList;

public class kxs
{
  public static Intent a(Context paramContext, ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    paramContext = new Intent(paramContext, VideoFeedsPlayActivity.class);
    paramContext.addFlags(536870912);
    paramContext.putExtra("VIDEO_THIRD_ICON", paramArticleInfo.thirdIcon);
    paramContext.putExtra("VIDEO_THIRD_NAME", paramArticleInfo.thirdName);
    paramContext.putExtra("VIDEO_THIRD_ACTION", paramArticleInfo.thirdAction);
    paramContext.putExtra("VIDEO_THIRD_URL", paramArticleInfo.mThirdVideoURL);
    paramContext.putExtra("VIDEO_THRID_URL_EXPIRE_TIME", paramArticleInfo.mThirdVideoURLExpireTime);
    paramContext.putExtra("VIDEO_ARTICLE_ID", paramArticleInfo.innerUniqueID);
    paramContext.putExtra("VIDEO_ARTICLE_BUSITYPE", paramArticleInfo.busiType);
    paramContext.putExtra("VIDEO_VID", paramArticleInfo.mVideoVid);
    paramContext.putExtra("VIDEO_WIDTH", String.valueOf(paramArticleInfo.mVideoJsonWidth));
    paramContext.putExtra("VIDEO_HEIGHT", String.valueOf(paramArticleInfo.mVideoJsonHeight));
    paramContext.putExtra("VIDEO_TIME", String.valueOf(paramArticleInfo.mVideoDuration));
    paramContext.putExtra("VIDEO_TITLE", paramArticleInfo.mTitle);
    paramContext.putExtra("VIDEO_COVER", paramArticleInfo.mVideoCoverUrl.getFile());
    paramContext.putExtra("VIDEO_H5_URL", paramArticleInfo.mArticleContentUrl);
    paramContext.putExtra("VIDEO_PUB_ACCOUNT_NAME", paramArticleInfo.mSubscribeName);
    paramContext.putExtra("VIDEO_PUB_ACCOUNT_UIN", paramArticleInfo.publishUin);
    paramContext.putExtra("VIDEO_SUBS_TEXT", paramArticleInfo.mVideoArticleSubsText);
    paramContext.putExtra("VIDEO_SUBS_COLOR", paramArticleInfo.mVideoArticleSubsColor);
    if (paramArticleInfo.busiType == 1) {}
    for (;;)
    {
      paramContext.putExtra("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      paramContext.putExtra("video_url_load", false);
      paramContext.putExtra("image_url_remote", paramArticleInfo.getVideoCoverURL().getFile());
      paramContext.putExtra("detail_url", paramArticleInfo.mArticleContentUrl + "&sourcefrom=0");
      paramContext.putExtra("video_url", paramArticleInfo.getVideoVid());
      paramContext.putExtra("title", paramArticleInfo.mTitle);
      paramContext.putExtra("req_create_time", kxl.ap(paramArticleInfo.mTime));
      paramContext.putExtra("brief_key", paramArticleInfo.mTitle);
      paramContext.putExtra("KEY_VIDEO_JSON_LIST", paramArticleInfo.mJsonVideoList);
      return paramContext;
      bool = false;
    }
  }
  
  /* Error */
  public static void aQ(Intent paramIntent)
  {
    // Byte code:
    //   0: invokestatic 202	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   3: checkcast 204	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: aload 5
    //   16: sipush 162
    //   19: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   22: checkcast 210	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager
    //   25: invokevirtual 214	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:c	()Lcom/tencent/biz/pubaccount/readinjoy/struct/KandianRedDotInfo;
    //   28: astore 6
    //   30: aload 6
    //   32: ifnonnull +12 -> 44
    //   35: ldc 216
    //   37: iconst_2
    //   38: ldc 218
    //   40: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: return
    //   44: aload 6
    //   46: invokevirtual 230	com/tencent/biz/pubaccount/readinjoy/struct/KandianRedDotInfo:getMessageRecord	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   49: astore 5
    //   51: aload 5
    //   53: instanceof 232
    //   56: ifeq +266 -> 322
    //   59: aload 5
    //   61: checkcast 232	com/tencent/mobileqq/data/MessageForStructing
    //   64: astore 5
    //   66: aload 5
    //   68: getfield 236	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   71: ifnull +238 -> 309
    //   74: aload 5
    //   76: getfield 236	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   79: getfield 241	com/tencent/mobileqq/structmsg/AbsStructMsg:mExtraData	Ljava/lang/String;
    //   82: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifne +224 -> 309
    //   88: new 249	org/json/JSONObject
    //   91: dup
    //   92: aload 5
    //   94: getfield 236	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   97: getfield 241	com/tencent/mobileqq/structmsg/AbsStructMsg:mExtraData	Ljava/lang/String;
    //   100: invokespecial 252	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   103: astore 5
    //   105: aload 5
    //   107: ldc 254
    //   109: invokevirtual 258	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   112: istore_2
    //   113: aload 5
    //   115: ldc_w 260
    //   118: ldc_w 262
    //   121: invokevirtual 266	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   124: astore 5
    //   126: aload 5
    //   128: invokestatic 271	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   131: invokevirtual 275	java/lang/Integer:intValue	()I
    //   134: istore_1
    //   135: aload_0
    //   136: ldc_w 277
    //   139: iload_1
    //   140: invokevirtual 69	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   143: pop
    //   144: iload_2
    //   145: istore_3
    //   146: iload_1
    //   147: istore 4
    //   149: iload_2
    //   150: ifne +164 -> 314
    //   153: ldc 216
    //   155: iconst_1
    //   156: new 154	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 279
    //   166: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 6
    //   171: getfield 283	com/tencent/biz/pubaccount/readinjoy/struct/KandianRedDotInfo:articleIDList	Ljava/util/ArrayList;
    //   174: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: return
    //   184: astore 5
    //   186: aload 5
    //   188: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   191: ldc 216
    //   193: iconst_2
    //   194: ldc_w 291
    //   197: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: iload_2
    //   201: istore_3
    //   202: iload_1
    //   203: istore_2
    //   204: iload_3
    //   205: istore_1
    //   206: aload 6
    //   208: getfield 283	com/tencent/biz/pubaccount/readinjoy/struct/KandianRedDotInfo:articleIDList	Ljava/util/ArrayList;
    //   211: astore 5
    //   213: aload 5
    //   215: ifnull +46 -> 261
    //   218: aload 5
    //   220: invokevirtual 296	java/util/ArrayList:size	()I
    //   223: ifle +38 -> 261
    //   226: aload_0
    //   227: ldc_w 298
    //   230: aload 5
    //   232: iconst_0
    //   233: invokevirtual 302	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   236: checkcast 304	java/io/Serializable
    //   239: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   242: pop
    //   243: aload_0
    //   244: ldc_w 309
    //   247: iconst_0
    //   248: invokevirtual 69	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   251: pop
    //   252: aload_0
    //   253: ldc_w 311
    //   256: iload_2
    //   257: invokevirtual 69	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   260: pop
    //   261: ldc 216
    //   263: iconst_1
    //   264: new 154	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 313
    //   274: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 5
    //   279: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   282: ldc_w 315
    //   285: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload_2
    //   289: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc_w 320
    //   295: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload_1
    //   299: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: return
    //   309: iconst_0
    //   310: istore_3
    //   311: iconst_0
    //   312: istore 4
    //   314: iload 4
    //   316: istore_2
    //   317: iload_3
    //   318: istore_1
    //   319: goto -113 -> 206
    //   322: ldc 216
    //   324: iconst_2
    //   325: ldc_w 322
    //   328: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: iconst_0
    //   332: istore_1
    //   333: iconst_0
    //   334: istore_2
    //   335: goto -129 -> 206
    //   338: astore 5
    //   340: iconst_0
    //   341: istore_1
    //   342: iconst_0
    //   343: istore_2
    //   344: goto -158 -> 186
    //   347: astore 5
    //   349: iconst_0
    //   350: istore_1
    //   351: goto -165 -> 186
    //   354: astore 5
    //   356: iconst_0
    //   357: istore_1
    //   358: goto -214 -> 144
    //   361: astore 5
    //   363: goto -219 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramIntent	Intent
    //   134	224	1	i	int
    //   112	232	2	j	int
    //   145	173	3	k	int
    //   147	168	4	m	int
    //   6	121	5	localObject	Object
    //   184	3	5	localException1	java.lang.Exception
    //   211	67	5	localArrayList	ArrayList
    //   338	1	5	localException2	java.lang.Exception
    //   347	1	5	localException3	java.lang.Exception
    //   354	1	5	localException4	java.lang.Exception
    //   361	1	5	localException5	java.lang.Exception
    //   28	179	6	localKandianRedDotInfo	com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo
    // Exception table:
    //   from	to	target	type
    //   153	183	184	java/lang/Exception
    //   59	113	338	java/lang/Exception
    //   113	126	347	java/lang/Exception
    //   126	135	354	java/lang/Exception
    //   135	144	361	java/lang/Exception
  }
  
  public static Intent b(Context paramContext, ArticleInfo paramArticleInfo)
  {
    if (kxm.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo))
    {
      localObject1 = lbz.a().a();
      if (localObject1 != null) {
        ((lhu)localObject1).a(paramArticleInfo.mArticleContentUrl, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
      }
      paramContext = new Intent(paramContext, FastWebActivity.class);
      paramContext.putExtra("fast_web_article_info", paramArticleInfo);
      paramContext.putExtra("fast_web_from_channel_id", paramArticleInfo.mChannelID);
      paramContext.putExtra("is_native_fast_web", true);
      return paramContext;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (ndi.al(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!ndi.ap(paramArticleInfo)) {
        localObject1 = ((mih.b)paramArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0)).businessUrl;
      }
    }
    localObject2 = localObject1;
    if (!(paramArticleInfo instanceof AdvertisementInfo))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject1 = (String)localObject1 + "&";
        localObject2 = (String)localObject1 + "from=0";
      }
    }
    else
    {
      localObject1 = localObject2;
      if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
      {
        localObject1 = localObject2;
        if (aqiw.isWifiConnected(null))
        {
          if (!((String)localObject2).contains("?")) {
            break label716;
          }
          localObject1 = (String)localObject2 + "&";
          label287:
          localObject1 = (String)localObject1 + "acttype=42";
        }
      }
      localBundle.putString("url", (String)localObject1);
      localBundle.putBoolean("hide_operation_bar", true);
      localBundle.putString("from", String.valueOf(53));
      localBundle.putString("subscribename", paramArticleInfo.mSubscribeName);
      localBundle.putLong("articleid", paramArticleInfo.mArticleID);
      localBundle.putLong("recommendSeq", paramArticleInfo.mRecommendSeq);
      localBundle.putInt("channelid", (int)paramArticleInfo.mChannelID);
      localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
      localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
      localBundle.putInt("articalChannelId", 9);
      localBundle.putStringArray("insertPluginsArray", new String[] { "pubAccountPreload" });
      localBundle.putBoolean("ip_connect", obt.aec);
      long l = System.currentTimeMillis();
      localBundle.putLong("startOpenPageTime", l);
      localBundle.putLong("click_time", l);
      localBundle.putLong("available_memory", aqgz.getSystemAvaialbeMemory());
      localBundle.putBoolean("preload_tool_white_list", kxm.AO());
      localObject2 = new Intent(paramContext, ReadInJoyArticleDetailActivity.class);
      localObject1 = PreloadManager.fk((String)localObject1);
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        paramContext = "";
      }
      if ((aqhq.fileExistsAndNotEmpty(acbn.bnB + paramContext)) && (PreloadManager.a().k(paramContext) != null))
      {
        localBundle.putString("read_in_joy_from_cache", paramContext);
        if (!lbz.a().aO(paramArticleInfo.mArticleID))
        {
          paramArticleInfo = PreloadManager.a();
          if ((NetworkState.getNetworkType() != 1) && (NetworkState.getNetworkType() != 4) && (NetworkState.getNetworkType() != 5)) {
            break label754;
          }
          paramContext = paramArticleInfo.s(paramContext);
          if ((paramContext != null) && (paramContext.size() > 0))
          {
            ThreadManager.post(new ReadinjoyJumpUtils.1(paramArticleInfo, (PreloadManager.a)paramContext.get(0)), 5, null, false);
            if (paramContext.size() <= 1) {
              break label742;
            }
            localBundle.putString("preload_iamge_url", ((PreloadManager.a)paramContext.get(1)).url);
          }
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject2).putExtras(localBundle);
      return localObject2;
      localObject1 = (String)localObject1 + "?";
      break;
      label716:
      localObject1 = (String)localObject2 + "?";
      break label287;
      label742:
      localBundle.putString("preload_iamge_url", null);
      continue;
      label754:
      paramContext = paramArticleInfo.s(paramContext);
      if ((paramContext != null) && (paramContext.size() > 0)) {
        localBundle.putString("preload_iamge_url", ((PreloadManager.a)paramContext.get(0)).url);
      } else {
        localBundle.putString("preload_iamge_url", null);
      }
    }
  }
  
  public static int e(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      throw new NullPointerException("article info is null");
    }
    if (kxm.m(paramBaseArticleInfo)) {
      return 3;
    }
    if (kxm.j(paramBaseArticleInfo)) {
      return 2;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kxs
 * JD-Core Version:    0.7.0.1
 */