import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebDislikeUtils.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class nmv
{
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ThreadManager.executeOnSubThread(new FastWebDislikeUtils.1(paramArticleInfo, paramContext));
    e(paramArticleInfo, "0X80101DC");
  }
  
  public static void b(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    e(paramArticleInfo, "0X8009A5B");
    if ((paramContext instanceof FastWebActivity)) {
      ((FastWebActivity)paramContext).pP(false);
    }
  }
  
  public static String bE(int paramInt)
  {
    return awit.a(paramInt, 99990000L, "9999万+", "");
  }
  
  public static void c(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo.isLiked)
    {
      paramFastWebArticleInfo.isLiked = false;
      paramFastWebArticleInfo.likeCnt -= 1;
      nns.d(paramArticleInfo, "0X8009765", "2");
    }
    for (;;)
    {
      lcc.a().aJD();
      lbz.a().a(kxm.getLongAccountUin(), paramFastWebArticleInfo.isLiked, paramFastWebArticleInfo);
      return;
      paramFastWebArticleInfo.isLiked = true;
      paramFastWebArticleInfo.likeCnt += 1;
      nns.d(paramArticleInfo, "0X8009764", "2");
    }
  }
  
  public static void e(ArticleInfo paramArticleInfo, String paramString)
  {
    int j = 0;
    if (paramArticleInfo == null) {
      return;
    }
    kxm.b localb = nns.b(paramArticleInfo);
    for (;;)
    {
      try
      {
        localb.b("source_from", "2");
        localb.k();
        localb.l();
        localb.m();
        localb.a(paramArticleInfo.mAlgorithmID);
        localb.b(paramArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localb.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localb.b("businessID", i);
        }
        if (kxm.AT())
        {
          i = 1;
          localb.b("artical_interact_area", i);
          localb.b("artical_interact_type", kxm.nU());
          if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
          {
            i = j;
            if (kxm.AU()) {
              i = 1;
            }
            localb.b("ad_relative_pos", i);
          }
          nns.c(paramArticleInfo, paramString, localb.build());
          return;
        }
      }
      catch (Exception paramArticleInfo)
      {
        QLog.d("FastWebDislikeUtils", 1, "report error! msg=" + paramArticleInfo);
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmv
 * JD-Core Version:    0.7.0.1
 */