import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class nqn
{
  public static CharSequence a(String paramString1, String paramString2, String paramString3, String paramString4, ArticleInfo paramArticleInfo)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
    if (!TextUtils.isEmpty(paramString4)) {}
    for (paramString4 = URLDrawable.getDrawable(paramString4, (URLDrawable.URLDrawableOptions)localObject);; paramString4 = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200102/f5a4461be0ec4116bc34e5b02e5c831f.png", (URLDrawable.URLDrawableOptions)localObject))
    {
      paramString4.setBounds(0, 0, riw.dip2px(BaseApplicationImpl.getContext(), 17.0F), riw.dip2px(BaseApplicationImpl.getContext(), 17.0F));
      localObject = new SpannableStringBuilder();
      SpannableString localSpannableString = new SpannableString(paramString1);
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF262626")), 0, paramString1.length(), 33);
      localSpannableString.setSpan(new AbsoluteSizeSpan(16, true), 0, paramString1.length(), 33);
      ((SpannableStringBuilder)localObject).append(localSpannableString);
      paramString1 = " " + paramString3;
      paramString3 = new SpannableString(paramString1);
      paramString3.setSpan(new rsz(paramString4), 0, 1, 17);
      paramString3.setSpan(new nqo(-15504151, 16777215, 860716207, paramString2, paramArticleInfo), 0, paramString1.length(), 33);
      ((SpannableStringBuilder)localObject).append(paramString3);
      return ((SpannableStringBuilder)localObject).subSequence(0, ((SpannableStringBuilder)localObject).length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nqn
 * JD-Core Version:    0.7.0.1
 */