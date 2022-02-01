import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class tte
{
  static CharSequence a(int paramInt, BaseArticleInfo paramBaseArticleInfo, qhl paramqhl)
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
      if ((((SocializeFeedsInfo)localObject2).jdField_a_of_type_Rqw != null) && (((SocializeFeedsInfo)localObject2).jdField_a_of_type_Rqw.a != null) && (((SocializeFeedsInfo)localObject2).jdField_a_of_type_Rqw.a.size() > 0) && ((((SocializeFeedsInfo)localObject2).jdField_a_of_type_Rqw.a.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_Rqw.a.get(0)).mBiuComment)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_Rqw.a.get(0)).mBiuComment, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_Rqw.a.get(0)).mBiuComment, "：")))))
      {
        localObject1 = new SpannableStringBuilder();
        localObject2 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_Rqw.a(paramInt, (ArticleInfo)paramBaseArticleInfo, "5", paramqhl);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
        }
        i = 1;
      }
    }
    for (;;)
    {
      paramqhl = a(paramInt, (CharSequence)localObject1, paramBaseArticleInfo, paramqhl);
      QLog.d("Utils", 2, "makeBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + paramqhl + " condition flag: " + i + ", linkTextColor " + paramInt);
      return paramqhl;
      if (!TextUtils.isEmpty(((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString))
      {
        if (((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString.length() >= 100) {
          ((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString = (((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
        }
        localObject1 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString;
        i = 1;
      }
      else
      {
        i = 0;
        localObject1 = "";
      }
    }
  }
  
  public static CharSequence a(int paramInt, CharSequence paramCharSequence, long paramLong, BaseArticleInfo paramBaseArticleInfo, qhl paramqhl)
  {
    Object localObject = new StringBuilder().append(ReadInJoyUserInfoModule.a(paramLong, paramqhl, ReadInJoyUserInfoModule.a()));
    if (!TextUtils.isEmpty(paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString)) {}
    for (paramqhl = " ";; paramqhl = "：")
    {
      paramqhl = paramqhl;
      localObject = new SpannableStringBuilder(paramqhl);
      ((SpannableStringBuilder)localObject).append(paramCharSequence);
      ((SpannableStringBuilder)localObject).setSpan(new toa(paramLong, "2", (ArticleInfo)paramBaseArticleInfo, paramInt), 0, paramqhl.length(), 18);
      QLog.d("Utils", 1, "addPreAuthor: " + localObject + ", linkTextColor: " + paramInt);
      return localObject;
    }
  }
  
  public static CharSequence a(int paramInt, CharSequence paramCharSequence, BaseArticleInfo paramBaseArticleInfo, qhl paramqhl)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramBaseArticleInfo != null)
    {
      localCharSequence = paramCharSequence;
      if (paramBaseArticleInfo.articleViewModel != null)
      {
        if (TextUtils.isEmpty(paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString)) {
          break label113;
        }
        paramCharSequence = a(paramCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString);
      }
    }
    label113:
    for (;;)
    {
      localCharSequence = paramCharSequence;
      if (paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Long != 0L) {
        localCharSequence = a(paramInt, paramCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Long, paramBaseArticleInfo, paramqhl);
      }
      if (paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Int != 0) {
        localCharSequence = a(localCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Int);
      }
      for (;;)
      {
        return new QQText(localCharSequence, 3, 16);
      }
    }
  }
  
  @NotNull
  private static CharSequence a(ArticleInfo paramArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString);
      }
    }
    while (paramArticleInfo.mTitle == null) {
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(paramArticleInfo.mTitle);
    return localSpannableStringBuilder;
  }
  
  private static CharSequence a(ArticleInfo paramArticleInfo, CharSequence paramCharSequence)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString)))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 19191924) {
        try
        {
          paramArticleInfo = tnx.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rre.a.b, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rre.a.jdField_a_of_type_JavaLangString, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rre.a.c, paramArticleInfo);
          return paramArticleInfo;
        }
        catch (NullPointerException paramArticleInfo)
        {
          QLog.e("Utils", 2, paramArticleInfo.toString());
          return paramCharSequence;
        }
      }
      return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString;
    }
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mTitle))) {
      return paramArticleInfo.mTitle;
    }
    return "";
  }
  
  @NotNull
  private static CharSequence a(BaseArticleInfo paramBaseArticleInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(anvx.a(2131715392));
    rsj localrsj;
    StringBuilder localStringBuilder2;
    if (!ppe.l(paramBaseArticleInfo))
    {
      localrsj = (rsj)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rsh.a.get(0);
      localStringBuilder2 = localStringBuilder1.append("“");
      if (!TextUtils.isEmpty(localrsj.c)) {
        break label92;
      }
      paramBaseArticleInfo = "";
      localStringBuilder2 = localStringBuilder2.append(paramBaseArticleInfo);
      if (!TextUtils.isEmpty(localrsj.jdField_a_of_type_JavaLangString)) {
        break label100;
      }
    }
    label92:
    label100:
    for (paramBaseArticleInfo = "";; paramBaseArticleInfo = localrsj.jdField_a_of_type_JavaLangString)
    {
      localStringBuilder2.append(paramBaseArticleInfo).append("”");
      return localStringBuilder1;
      paramBaseArticleInfo = localrsj.c;
      break;
    }
  }
  
  static CharSequence a(BaseArticleInfo paramBaseArticleInfo, qhl paramqhl)
  {
    return a(-15504151, paramBaseArticleInfo, paramqhl);
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
  
  public static CharSequence a(CharSequence paramCharSequence, BaseArticleInfo paramBaseArticleInfo, qhl paramqhl)
  {
    return a(-15504151, paramCharSequence, paramBaseArticleInfo, paramqhl);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.append(paramCharSequence);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-6908266), 0, paramString.length(), 18);
    QLog.d("Utils", 1, "addPreCommentText: " + localSpannableStringBuilder);
    return localSpannableStringBuilder;
  }
  
  @NotNull
  private static CharSequence a(String paramString)
  {
    String str2 = pjr.a(paramString);
    String str1 = str2;
    if (TextUtils.equals(str2, paramString)) {
      str1 = bcsc.b(paramString);
    }
    return new QQText(str1, 3, 16);
  }
  
  public static qfw a(ArticleInfo paramArticleInfo)
  {
    return new qhk(null, paramArticleInfo, ppe.a(paramArticleInfo), (int)paramArticleInfo.mChannelID, 0, 0, false, 0, null, null);
  }
  
  public static CharSequence b(int paramInt, BaseArticleInfo paramBaseArticleInfo, qhl paramqhl)
  {
    QLog.d("Utils", 1, "makeSummaryText: " + paramInt);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramBaseArticleInfo = a((ArticleInfo)paramBaseArticleInfo);
    NativeSummaryView.a(paramInt, paramBaseArticleInfo, localSpannableStringBuilder, paramqhl);
    NativeSummaryView.a(paramBaseArticleInfo, localSpannableStringBuilder, paramqhl);
    return localSpannableStringBuilder;
  }
  
  static CharSequence b(BaseArticleInfo paramBaseArticleInfo, qhl paramqhl)
  {
    int i1 = 0;
    int n = 0;
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (localArticleInfo == null) {
      return "";
    }
    String str = "";
    int j;
    int k;
    int m;
    Object localObject;
    switch (ppe.a(localArticleInfo))
    {
    default: 
      j = 0;
      k = 0;
      m = 0;
      i = n;
      localObject = str;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        if (paramBaseArticleInfo.isPGCShortContent())
        {
          i = 9;
          localObject = a(localArticleInfo, "");
        }
      }
      else
      {
        label177:
        paramqhl = a((CharSequence)localObject, paramBaseArticleInfo, paramqhl);
        QLog.d("Utils", 2, "makeNonBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + paramqhl + " condition flag: " + i);
        return paramqhl;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      k = 0;
      j = 1;
      m = i;
      break;
      j = 0;
      k = 1;
      m = 0;
      break;
      if (k != 0)
      {
        localObject = localArticleInfo.mTitle;
        i = 1;
        break label177;
      }
      if ((ppe.a(localArticleInfo)) || (ppe.i(localArticleInfo)) || (ppe.h(localArticleInfo)))
      {
        if (m != 0)
        {
          localObject = a(localArticleInfo);
          i = 2;
          break label177;
        }
        if (j != 0)
        {
          if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {}
          for (localObject = localArticleInfo.mTitle;; localObject = localArticleInfo.mSummary)
          {
            i = 3;
            break;
          }
        }
        if (ppe.i(localArticleInfo))
        {
          localObject = a(paramBaseArticleInfo);
          i = 4;
          break label177;
        }
        localObject = localArticleInfo.mSummary;
        i = 5;
        break label177;
      }
      i = n;
      localObject = str;
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null) {
        break label177;
      }
      rrq localrrq = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq;
      if (pqw.a(localrrq))
      {
        localObject = localrrq.jdField_a_of_type_Rqw.a(localArticleInfo, "3", paramqhl);
        i = 6;
        break label177;
      }
      if ((rfw.c(localArticleInfo)) && (!ppe.q(localArticleInfo)))
      {
        localObject = ((rrs)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).e;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label562;
        }
        localObject = a((String)localObject);
      }
      for (i = 7;; i = i1)
      {
        break;
        i = n;
        localObject = str;
        if (TextUtils.isEmpty(localrrq.jdField_a_of_type_JavaLangString)) {
          break;
        }
        localObject = null;
        try
        {
          str = bcsc.b(localrrq.jdField_a_of_type_JavaLangString);
          localObject = str;
        }
        catch (Exception localException)
        {
          label537:
          break label537;
        }
        localObject = new QQText((CharSequence)localObject, 3, 16);
        i = 8;
        break;
        label562:
        localObject = "";
      }
    }
  }
  
  public static CharSequence c(BaseArticleInfo paramBaseArticleInfo, qhl paramqhl)
  {
    return b(-15504151, paramBaseArticleInfo, paramqhl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tte
 * JD-Core Version:    0.7.0.1
 */