import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.common.app.BaseApplicationImpl;

class uqi
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private stSchema jdField_a_of_type_UserGrowthStSchema;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  
  uqi(stSimpleMetaFeed paramstSimpleMetaFeed, stSchema paramstSchema, int paramInt)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    this.jdField_a_of_type_UserGrowthStSchema = paramstSchema;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static WSDownloadParams a(String paramString)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = umu.a().a();
    localWSDownloadParams.mTestId = uyo.a(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    uvm.a("friend", this.jdField_a_of_type_Int, String.valueOf(paramInt), paramstSimpleMetaFeed);
  }
  
  public void onClick(@androidx.annotation.NonNull View paramView)
  {
    uya.a("WSFriendLikeUtil", "schema = " + this.jdField_a_of_type_UserGrowthStSchema.toString());
    if (uyo.b()) {
      return;
    }
    new upz(BaseApplicationImpl.context).a(this.jdField_a_of_type_UserGrowthStSchema).a(a(this.jdField_a_of_type_UserGrowthStSchema.schema)).a(new uqj(this)).a();
  }
  
  public void updateDrawState(@android.support.annotation.NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqi
 * JD-Core Version:    0.7.0.1
 */