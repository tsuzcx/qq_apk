import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial.c;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;

public class mde
{
  public static boolean G(ArticleInfo paramArticleInfo)
  {
    return (ndi.i(paramArticleInfo) == 23) || (ndi.j(paramArticleInfo) == 56);
  }
  
  public static boolean I(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = true;
    if (paramArticleInfo == null) {
      return false;
    }
    if (paramArticleInfo.mFeedType == 1)
    {
      bool1 = bool2;
      if (!ndi.S(paramArticleInfo)) {
        if (!ndi.U(paramArticleInfo)) {
          break label36;
        }
      }
    }
    label36:
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView)
  {
    paramContext = i();
    int i = ((Integer)paramContext.first).intValue();
    int j = ((Integer)paramContext.second).intValue();
    paramContext = paramKandianUrlImageView.getLayoutParams();
    paramContext.width = i;
    paramContext.height = j;
    paramKandianUrlImageView.setLayoutParams(paramContext);
    paramKandianUrlImageView.setPadding(0, 0, 0, 0);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView, double paramDouble)
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = (int)(i / paramDouble);
    paramContext = new RelativeLayout.LayoutParams(i, j);
    paramContext.width = i;
    paramContext.height = j;
    paramContext.setMargins(0, 0, 0, 0);
    paramKandianUrlImageView.setLayoutParams(paramContext);
    paramKandianUrlImageView.setPadding(0, 0, 0, 0);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView, boolean paramBoolean)
  {
    paramContext = d();
    int i = ((Integer)paramContext.first).intValue();
    int j = ((Integer)paramContext.second).intValue();
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    paramContext = localLayoutParams;
    if (localLayoutParams == null) {
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (paramContext = new LinearLayout.LayoutParams(i, j);; paramContext = new RelativeLayout.LayoutParams(i, j))
    {
      paramContext.width = i;
      paramContext.height = j;
      paramKandianUrlImageView.setLayoutParams(paramContext);
      paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
  }
  
  public static void a(Context paramContext, lie paramlie, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramContext, paramlie, paramLayoutParams, null);
  }
  
  public static void a(Context paramContext, lie paramlie, ViewGroup.LayoutParams paramLayoutParams, View paramView)
  {
    ArticleInfo localArticleInfo = paramlie.a();
    if (localArticleInfo == null)
    {
      QLog.d("UtilsForComponent", 1, "configDividerHeight failed, articleInfo is null.");
      return;
    }
    paramLayoutParams.height = paramContext.getResources().getDimensionPixelSize(2131299179);
    int i = paramlie.getCellType();
    int j = paramlie.oE();
    if (localArticleInfo.mChannelID == 70L)
    {
      paramLayoutParams.height = Utils.dp2px(5.0D);
      return;
    }
    if (paramlie.nh() == 56)
    {
      paramLayoutParams.height = Utils.dp2px(5.0D);
      return;
    }
    if ((i == 29) || (i == 30) || (j == 29) || (j == 30))
    {
      paramLayoutParams.height = Utils.dp2px(5.0D);
      return;
    }
    if (i == 53)
    {
      paramLayoutParams.height = Utils.dp2px(0.5D);
      return;
    }
    if ((localArticleInfo.mChannelID == 0L) && ((i == 6) || (i == 128) || (i == 46))) {
      if (i == 6) {
        i = Utils.dp2px(13.0D);
      }
    }
    for (;;)
    {
      if ((paramLayoutParams instanceof LinearLayout.LayoutParams))
      {
        ((LinearLayout.LayoutParams)paramLayoutParams).topMargin = i;
        ((LinearLayout.LayoutParams)paramLayoutParams).leftMargin = Utils.dp2px(6.0D);
        ((LinearLayout.LayoutParams)paramLayoutParams).rightMargin = Utils.dp2px(6.0D);
      }
      paramLayoutParams.height = Utils.dp2px(0.5D);
      paramView.setBackgroundColor(Color.parseColor("#e5e5e5"));
      return;
      if (i == 46)
      {
        i = Utils.dp2px(8.0D);
      }
      else if (i == 128)
      {
        i = Utils.dp2px(0.0D);
        continue;
        if (kvx.V(i, j))
        {
          paramLayoutParams.height = Utils.dp2px(5.0D);
          return;
        }
        paramLayoutParams.height = Utils.dp2px(5.0D);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public static void a(SocializeFeedsInfo.r paramr, ReadInJoyYAFolderTextView paramReadInJoyYAFolderTextView, mas parammas, SpannableStringBuilder paramSpannableStringBuilder)
  {
    SpannableStringBuilder localSpannableStringBuilder = paramSpannableStringBuilder;
    if (paramSpannableStringBuilder == null) {
      localSpannableStringBuilder = new SpannableStringBuilder();
    }
    if (kxm.a(paramr))
    {
      List localList = paramr.b.iT;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = new ArrayList();
      int i = localList.size();
      paramSpannableStringBuilder = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).ahj;
      int j;
      label130:
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
      long l;
      if ((!TextUtils.isEmpty(paramSpannableStringBuilder)) && ((paramSpannableStringBuilder.startsWith(":")) || (paramSpannableStringBuilder.startsWith("："))))
      {
        paramr = paramSpannableStringBuilder.substring(1);
        localStringBuilder.append(paramr);
        j = localStringBuilder.length();
        i -= 2;
        if (i < 0) {
          break label329;
        }
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        l = localBiuCommentInfo.i.longValue();
        paramr = aqgv.b((QQAppInterface)kxm.getAppRuntime(), String.valueOf(l), true);
        paramSpannableStringBuilder = "@" + paramr;
        paramr = paramSpannableStringBuilder;
        if (localBiuCommentInfo.aSO == 1) {
          paramr = paramSpannableStringBuilder + " ";
        }
        if (localBiuCommentInfo.ahj != null) {
          break label320;
        }
      }
      label320:
      for (paramSpannableStringBuilder = "";; paramSpannableStringBuilder = localBiuCommentInfo.ahj)
      {
        localStringBuilder.append(paramr).append(paramSpannableStringBuilder);
        paramSpannableStringBuilder = new ComponentHeaderNewSocial.c();
        paramSpannableStringBuilder.ahi = j;
        paramSpannableStringBuilder.adh = (paramr.length() + j);
        paramSpannableStringBuilder.uin = l;
        ((List)localObject).add(paramSpannableStringBuilder);
        j = localStringBuilder.length();
        i -= 1;
        break label130;
        paramr = paramSpannableStringBuilder;
        if (paramSpannableStringBuilder != null) {
          break;
        }
        paramr = "";
        break;
      }
      label329:
      paramr = new SpannableStringBuilder(new aofk(localStringBuilder, 7, 16));
      paramSpannableStringBuilder = ((List)localObject).iterator();
      while (paramSpannableStringBuilder.hasNext())
      {
        localObject = (ComponentHeaderNewSocial.c)paramSpannableStringBuilder.next();
        paramr.setSpan(new mat.a(((ComponentHeaderNewSocial.c)localObject).uin, -3355444, parammas), ((ComponentHeaderNewSocial.c)localObject).ahi, ((ComponentHeaderNewSocial.c)localObject).adh, 17);
      }
      localSpannableStringBuilder.append(paramr);
    }
    for (;;)
    {
      paramReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
      return;
      if (!TextUtils.isEmpty(paramr.ail)) {
        try
        {
          localSpannableStringBuilder.append(new aofk(anbk.nn(paramr.ail), 7, 16));
        }
        catch (Exception paramr)
        {
          QLog.d("UtilsForComponent", 1, "parse bytes_comments failed ", paramr);
        }
      }
    }
  }
  
  public static void a(lie paramlie, RingAvatarView paramRingAvatarView, ImageView paramImageView)
  {
    if ((paramRingAvatarView == null) || (paramImageView == null) || (paramlie == null)) {}
    do
    {
      return;
      paramlie = paramlie.a();
    } while ((paramlie == null) || (paramlie.mSocialFeedInfo == null) || (paramlie.mSocialFeedInfo.a == null));
    if (paramlie.mSocialFeedInfo.a.DD())
    {
      paramRingAvatarView.aXX();
      paramImageView.setVisibility(0);
      return;
    }
    paramRingAvatarView.showNormal();
    paramImageView.setVisibility(8);
  }
  
  public static String ba(int paramInt)
  {
    int i = paramInt / 3600;
    int j = (paramInt - i * 60) / 60;
    paramInt %= 60;
    String str1;
    String str2;
    if (j >= 10)
    {
      str1 = String.valueOf(j);
      if (paramInt < 10) {
        break label106;
      }
      str2 = String.valueOf(paramInt);
      label44:
      if (i <= 0) {
        break label150;
      }
      if (i < 10) {
        break label128;
      }
    }
    label128:
    for (String str3 = String.valueOf(i);; str3 = String.format("0%d", new Object[] { Integer.valueOf(i) }))
    {
      return String.format("%s:%s:%s", new Object[] { str3, str1, str2 });
      str1 = String.format("0%d", new Object[] { Integer.valueOf(j) });
      break;
      label106:
      str2 = String.format("0%d", new Object[] { Integer.valueOf(paramInt) });
      break label44;
    }
    label150:
    return String.format("%s:%s", new Object[] { str1, str2 });
  }
  
  public static Pair<Integer, Integer> d()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return new Pair(Integer.valueOf((localResources.getDisplayMetrics().widthPixels - wja.dp2px(3.0F, localResources)) / 3), Integer.valueOf(localResources.getDimensionPixelSize(2131299185)));
  }
  
  public static boolean dO(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 5) || (paramInt == 7);
  }
  
  public static boolean dP(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 27) || (paramInt == 28) || (paramInt == 33) || (paramInt == 35) || (paramInt == 43) || (paramInt == 44) || (paramInt == 45) || (paramInt == 49) || (paramInt == 62) || (paramInt == 63) || (paramInt == 94) || (paramInt == 95) || (paramInt == 112) || (paramInt == 113) || (paramInt == 114);
  }
  
  public static boolean dQ(int paramInt)
  {
    return (paramInt == 22) || (paramInt == 21) || (paramInt == 23) || (paramInt == 107) || (paramInt == 108) || (paramInt == 54) || (paramInt == 55) || (paramInt == 56);
  }
  
  public static int h(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    label84:
    do
    {
      do
      {
        do
        {
          return 0;
          if ((paramArticleInfo.mPackInfoObj == null) || (!paramArticleInfo.mPackInfoObj.pack_type.has())) {
            break label84;
          }
          if (paramArticleInfo.mPackInfoObj.pack_type.get() != 2) {
            break;
          }
        } while (!paramArticleInfo.mPackInfoObj.msg_special_topic_info.has());
        return 1;
      } while ((paramArticleInfo.mPackInfoObj.pack_type.get() != 3) || (!paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()));
      return 2;
    } while ((paramArticleInfo.mSubscribeInfoObj == null) || (!paramArticleInfo.mSubscribeInfoObj.uint32_is_subscribed.has()) || (paramArticleInfo.mSubscribeInfoObj.uint32_is_subscribed.get() != 1));
    return 3;
  }
  
  public static Pair<Integer, Integer> i()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.562F)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mde
 * JD-Core Version:    0.7.0.1
 */