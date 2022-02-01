import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;

class ujn
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private stSchema jdField_a_of_type_UserGrowthStSchema;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  
  ujn(stSimpleMetaFeed paramstSimpleMetaFeed, stSchema paramstSchema, int paramInt)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    this.jdField_a_of_type_UserGrowthStSchema = paramstSchema;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    uns.a("friend", this.jdField_a_of_type_Int, String.valueOf(paramInt), paramstSimpleMetaFeed);
  }
  
  public void onClick(@androidx.annotation.NonNull View paramView)
  {
    uqf.a("WSFriendLikeUtil", "schema = " + this.jdField_a_of_type_UserGrowthStSchema.toString());
    new uje(BaseApplicationImpl.context).a(this.jdField_a_of_type_UserGrowthStSchema).a(new ujo(this)).a();
  }
  
  public void updateDrawState(@android.support.annotation.NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujn
 * JD-Core Version:    0.7.0.1
 */