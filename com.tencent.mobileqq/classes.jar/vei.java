import UserGrowth.stFriendLike;
import UserGrowth.stFriendLikes;
import UserGrowth.stSimpleMetaFeed;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class vei
{
  private static int jdField_a_of_type_Int = ScreenUtil.getRealWidth(BaseApplicationImpl.context) - ScreenUtil.dip2px(30.0F);
  private static String jdField_a_of_type_JavaLangString = "、";
  
  private static String a()
  {
    return " 赞了";
  }
  
  private static String a(int paramInt)
  {
    return " 等" + c(paramInt) + "位好友赞了";
  }
  
  @NotNull
  private static vej a(stSimpleMetaFeed paramstSimpleMetaFeed, stFriendLike paramstFriendLike, int paramInt)
  {
    return new vej(paramstSimpleMetaFeed, paramstFriendLike.schema, paramInt);
  }
  
  public static vel a(stSimpleMetaFeed paramstSimpleMetaFeed, TextPaint paramTextPaint, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    stFriendLikes localstFriendLikes;
    int k;
    if (paramstSimpleMetaFeed != null)
    {
      localstFriendLikes = paramstSimpleMetaFeed.friendLikes;
      if (localstFriendLikes != null)
      {
        k = localstFriendLikes.total;
        if ((k > 0) && (paramTextPaint != null)) {
          break label64;
        }
      }
    }
    vmp.e("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]friendLikes is empty，hide displayLine");
    return new vel(null, 0, "");
    label64:
    if (localstFriendLikes.likeFriends == null)
    {
      vmp.e("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]friendLikes.likeFriends is empty，but friendLikes.total > 0，show the num");
      return new vel(null, 0, b(k));
    }
    int m = localstFriendLikes.likeFriends.size();
    int n = (int)paramTextPaint.measureText(a());
    int i1 = (int)paramTextPaint.measureText(a(k));
    int i2 = jdField_a_of_type_Int;
    int i3 = jdField_a_of_type_Int;
    float f = 0.0F;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      stFriendLike localstFriendLike = (stFriendLike)localstFriendLikes.likeFriends.get(j);
      String str2 = localstFriendLike.nick;
      if (j == m - 1) {}
      for (String str1 = str2;; str1 = str2 + jdField_a_of_type_JavaLangString)
      {
        localSpannableStringBuilder.append(str1);
        f = paramTextPaint.measureText(localSpannableStringBuilder.toString());
        if (f <= i2 - n) {
          break;
        }
        l2 = System.currentTimeMillis();
        vmp.a("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]the cost of friendLikes'Parsing： " + (l2 - l1));
        vmp.e("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]the width of friendLikes is out of the max width，show with ...");
        return new vel(localSpannableStringBuilder, i3 - i1, a(k));
      }
      localSpannableStringBuilder.setSpan(a(paramstSimpleMetaFeed, localstFriendLike, paramInt), i, str2.length() + i, 33);
      int i4 = str1.length();
      j += 1;
      i += i4;
    }
    long l2 = System.currentTimeMillis();
    vmp.a("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]the cost of friendLikes'Parsing： " + (l2 - l1));
    vmp.e("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]the width of friendLikes is in the max width，show completely");
    return new vel(localSpannableStringBuilder, (int)f, a());
  }
  
  private static String b(int paramInt)
  {
    return c(paramInt) + "位好友 赞了";
  }
  
  private static String c(int paramInt)
  {
    return six.e(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vei
 * JD-Core Version:    0.7.0.1
 */