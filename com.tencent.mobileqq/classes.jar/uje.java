import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

public class uje
  implements uix
{
  private stSchema jdField_a_of_type_UserGrowthStSchema;
  private Context jdField_a_of_type_AndroidContentContext;
  private WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  private MiniAppLauncher.MiniAppLaunchListener jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener;
  private uiw jdField_a_of_type_Uiw;
  private ujg jdField_a_of_type_Ujg;
  private upr jdField_a_of_type_Upr;
  private boolean jdField_a_of_type_Boolean;
  private ujg jdField_b_of_type_Ujg;
  private boolean jdField_b_of_type_Boolean;
  
  public uje(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ujg = new ujh();
    this.jdField_b_of_type_Ujg = new uji();
  }
  
  public stSchema a()
  {
    return this.jdField_a_of_type_UserGrowthStSchema;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public WSDownloadParams a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  }
  
  public MiniAppLauncher.MiniAppLaunchListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener;
  }
  
  public uiw a()
  {
    return this.jdField_a_of_type_Uiw;
  }
  
  public uje a(stSchema paramstSchema)
  {
    this.jdField_a_of_type_UserGrowthStSchema = paramstSchema;
    return this;
  }
  
  public uje a(WSDownloadParams paramWSDownloadParams)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = paramWSDownloadParams;
    return this;
  }
  
  public uje a(uiw paramuiw)
  {
    this.jdField_a_of_type_Uiw = paramuiw;
    return this;
  }
  
  public uje a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public upr a()
  {
    return this.jdField_a_of_type_Upr;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_UserGrowthStSchema == null))
    {
      uqf.d("WSStSchemaJumpManager", "[WSStSchemaJumpManager.java][processStSchemaClickAction] mContext:" + this.jdField_a_of_type_AndroidContentContext + ", mStSchema" + this.jdField_a_of_type_UserGrowthStSchema);
      return;
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (Object localObject = this.jdField_a_of_type_Ujg;; localObject = this.jdField_b_of_type_Ujg)
    {
      localObject = ((ujg)localObject).a(this);
      if (localObject == null) {
        break;
      }
      ((uiv)localObject).a();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uje
 * JD-Core Version:    0.7.0.1
 */