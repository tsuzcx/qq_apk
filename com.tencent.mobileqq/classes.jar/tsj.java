import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.WordMatcher;

public class tsj
  implements WordMatchManager.MatcherCallback
{
  public tsj(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(WordMatchManager.WordMatcher paramWordMatcher)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = paramWordMatcher;
    if (this.a.h != 0) {
      paramWordMatcher.a(this.a.h);
    }
    this.a.h = paramWordMatcher.a(1, this.a.c, 3, this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsj
 * JD-Core Version:    0.7.0.1
 */