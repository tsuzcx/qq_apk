import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.j;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.l;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class nth
{
  static CharSequence a(BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.a parama)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    Object localObject2;
    Object localObject1;
    int i;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      localObject2 = paramBaseArticleInfo.mSocialFeedInfo;
      if ((((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null) && (((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT != null) && (((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() > 0) && ((((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.get(0)).ahj)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.get(0)).ahj, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.get(0)).ahj, "：")))))
      {
        localObject1 = new SpannableStringBuilder();
        localObject2 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.a((ArticleInfo)paramBaseArticleInfo, "5", parama);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
        }
        i = 1;
      }
    }
    for (;;)
    {
      parama = a((CharSequence)localObject1, paramBaseArticleInfo, parama);
      QLog.d("Utils", 2, "makeBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + parama + " condition flag: " + i);
      return parama;
      if (!TextUtils.isEmpty(((SocializeFeedsInfo)localObject2).ahL))
      {
        if (((SocializeFeedsInfo)localObject2).ahL.length() >= 100) {
          ((SocializeFeedsInfo)localObject2).ahL = (((SocializeFeedsInfo)localObject2).ahL.substring(0, 99) + '…');
        }
        localObject1 = ((SocializeFeedsInfo)localObject2).ahL;
        i = 1;
      }
      else
      {
        i = 0;
        localObject1 = "";
      }
    }
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localSpannableStringBuilder.append(" ");
      i += 1;
    }
    localSpannableStringBuilder.append(paramCharSequence);
    QLog.d("Utils", 1, "addPreBlank: " + localSpannableStringBuilder);
    return localSpannableStringBuilder;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, long paramLong, BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.a parama)
  {
    Object localObject = new StringBuilder().append(ReadInJoyUserInfoModule.a(paramLong, parama, ReadInJoyUserInfoModule.getDefaultNickName()));
    if (!TextUtils.isEmpty(paramBaseArticleInfo.articleViewModel.afx)) {}
    for (parama = " ";; parama = "：")
    {
      parama = parama;
      localObject = new SpannableStringBuilder(parama);
      ((SpannableStringBuilder)localObject).append(paramCharSequence);
      ((SpannableStringBuilder)localObject).setSpan(new nqp(paramLong, "2", (ArticleInfo)paramBaseArticleInfo), 0, parama.length(), 18);
      QLog.d("Utils", 1, "addPreAuthor: " + localObject);
      return localObject;
    }
  }
  
  public static CharSequence a(CharSequence paramCharSequence, BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.a parama)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramBaseArticleInfo != null)
    {
      localCharSequence = paramCharSequence;
      if (paramBaseArticleInfo.articleViewModel != null)
      {
        localCharSequence = paramCharSequence;
        if (!TextUtils.isEmpty(paramBaseArticleInfo.articleViewModel.afx)) {
          localCharSequence = a(paramCharSequence, paramBaseArticleInfo.articleViewModel.afx);
        }
        paramCharSequence = localCharSequence;
        if (paramBaseArticleInfo.articleViewModel.uF != 0L) {
          paramCharSequence = a(localCharSequence, paramBaseArticleInfo.articleViewModel.uF, paramBaseArticleInfo, parama);
        }
        localCharSequence = paramCharSequence;
        if (paramBaseArticleInfo.articleViewModel.aPH != 0) {
          localCharSequence = a(paramCharSequence, paramBaseArticleInfo.articleViewModel.aPH);
        }
      }
    }
    return new aofk(localCharSequence, 3, 16);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.append(paramCharSequence);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-6908266), 0, paramString.length(), 18);
    QLog.d("Utils", 1, "addPreCommentText: " + localSpannableStringBuilder);
    return localSpannableStringBuilder;
  }
  
  public static lie a(ArticleInfo paramArticleInfo)
  {
    return new lis(null, paramArticleInfo, ndi.k(paramArticleInfo), (int)paramArticleInfo.mChannelID, 0, 0, false, 0, null, null);
  }
  
  static CharSequence b(BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.a parama)
  {
    int i1 = 0;
    int n = 0;
    Object localObject4 = (ArticleInfo)paramBaseArticleInfo;
    if (localObject4 == null) {
      return "";
    }
    Object localObject3 = "";
    int j;
    int k;
    int m;
    int i;
    Object localObject1;
    switch (ndi.k((ArticleInfo)localObject4))
    {
    default: 
      j = 0;
      k = 0;
      m = 0;
      i = n;
      localObject1 = localObject3;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        if (!paramBaseArticleInfo.isPGCShortContent()) {
          break label431;
        }
        i = 9;
        if ((localObject4 == null) || (((ArticleInfo)localObject4).mSocialFeedInfo == null) || (((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m == null) || (TextUtils.isEmpty(((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih))) {
          break label398;
        }
        if (((ArticleInfo)localObject4).mSocialFeedInfo.aSG != 19191924) {
          break label382;
        }
      }
      break;
    }
    label770:
    for (;;)
    {
      try
      {
        localObject1 = nqn.a(((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih, ((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.a.aig, ((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.a.title, ((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.a.iconUrl, (ArticleInfo)localObject4);
        parama = a((CharSequence)localObject1, paramBaseArticleInfo, parama);
        QLog.d("Utils", 2, "makeNonBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + parama + " condition flag: " + i);
        return parama;
        i = 1;
        k = 0;
        j = 1;
        m = i;
        break;
        j = 0;
        k = 1;
        m = 0;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("Utils", 2, localNullPointerException.toString());
        localObject2 = localObject3;
        continue;
      }
      label382:
      Object localObject2 = ((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih;
      continue;
      label398:
      if ((localObject4 != null) && (!TextUtils.isEmpty(((ArticleInfo)localObject4).mTitle)))
      {
        localObject2 = ((ArticleInfo)localObject4).mTitle;
      }
      else
      {
        localObject2 = "";
        continue;
        label431:
        if (k != 0)
        {
          localObject2 = ((ArticleInfo)localObject4).mTitle;
          i = 1;
        }
        else
        {
          Object localObject5;
          if ((ndi.K((ArticleInfo)localObject4)) || (ndi.am((BaseArticleInfo)localObject4)) || (ndi.R((ArticleInfo)localObject4)))
          {
            if (m != 0)
            {
              localObject2 = new SpannableStringBuilder();
              if ((((ArticleInfo)localObject4).mSocialFeedInfo != null) && (((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih != null))
              {
                ((SpannableStringBuilder)localObject2).append(((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih);
                }
              }
              for (;;)
              {
                i = 2;
                break;
                if (((ArticleInfo)localObject4).mTitle != null) {
                  ((SpannableStringBuilder)localObject2).append(((ArticleInfo)localObject4).mTitle);
                }
              }
            }
            if (j != 0)
            {
              if (!TextUtils.isEmpty(((ArticleInfo)localObject4).mTitle)) {}
              for (localObject2 = ((ArticleInfo)localObject4).mTitle;; localObject2 = ((ArticleInfo)localObject4).mSummary)
              {
                i = 3;
                break;
              }
            }
            if (ndi.am((BaseArticleInfo)localObject4))
            {
              localObject3 = new StringBuilder("");
              if (!ndi.ap(paramBaseArticleInfo))
              {
                localObject4 = (mih.b)paramBaseArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0);
                localObject5 = ((StringBuilder)localObject3).append("“");
                if (!TextUtils.isEmpty(((mih.b)localObject4).businessNamePrefix)) {
                  break label760;
                }
                localObject2 = "";
                label713:
                localObject5 = ((StringBuilder)localObject5).append((String)localObject2);
                if (!TextUtils.isEmpty(((mih.b)localObject4).businessName)) {
                  break label770;
                }
              }
              for (localObject2 = "";; localObject2 = ((mih.b)localObject4).businessName)
              {
                ((StringBuilder)localObject5).append((String)localObject2).append("”");
                i = 4;
                localObject2 = localObject3;
                break;
                label760:
                localObject2 = ((mih.b)localObject4).businessNamePrefix;
                break label713;
              }
            }
            localObject2 = ((ArticleInfo)localObject4).mSummary;
            i = 5;
          }
          else
          {
            i = n;
            localObject2 = localObject3;
            if (((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null)
            {
              localObject5 = ((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r;
              if (kxm.a((SocializeFeedsInfo.r)localObject5))
              {
                localObject2 = ((SocializeFeedsInfo.r)localObject5).b.a((ArticleInfo)localObject4, "3", parama);
                i = 6;
              }
              else
              {
                if ((mas.H((ArticleInfo)localObject4)) && (!ndi.aa((ArticleInfo)localObject4)))
                {
                  localObject4 = ((SocializeFeedsInfo.t)((ArticleInfo)localObject4).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).title;
                  if (TextUtils.isEmpty((CharSequence)localObject4)) {
                    break label1005;
                  }
                  localObject3 = kwz.ep((String)localObject4);
                  localObject2 = localObject3;
                  if (TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject4)) {
                    localObject2 = anbk.nn((String)localObject4);
                  }
                  localObject2 = new aofk((CharSequence)localObject2, 3, 16);
                }
                for (i = 7;; i = i1)
                {
                  break;
                  i = n;
                  localObject2 = localObject3;
                  if (TextUtils.isEmpty(((SocializeFeedsInfo.r)localObject5).ail)) {
                    break;
                  }
                  localObject2 = null;
                  try
                  {
                    localObject3 = anbk.nn(((SocializeFeedsInfo.r)localObject5).ail);
                    localObject2 = localObject3;
                  }
                  catch (Exception localException)
                  {
                    label980:
                    break label980;
                  }
                  localObject2 = new aofk((CharSequence)localObject2, 3, 16);
                  i = 8;
                  break;
                  label1005:
                  localObject2 = "";
                }
                i = 0;
              }
            }
          }
        }
      }
    }
  }
  
  public static CharSequence c(BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.a parama)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramBaseArticleInfo = a((ArticleInfo)paramBaseArticleInfo);
    NativeSummaryView.a(paramBaseArticleInfo, localSpannableStringBuilder, parama);
    NativeSummaryView.b(paramBaseArticleInfo, localSpannableStringBuilder, parama);
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nth
 * JD-Core Version:    0.7.0.1
 */