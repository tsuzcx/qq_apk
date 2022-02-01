import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

public class upz
  implements ups
{
  private stSchema jdField_a_of_type_UserGrowthStSchema;
  private Context jdField_a_of_type_AndroidContentContext;
  private WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  private MiniAppLauncher.MiniAppLaunchListener jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener;
  private upr jdField_a_of_type_Upr;
  private uqb jdField_a_of_type_Uqb;
  private uxm jdField_a_of_type_Uxm;
  private boolean jdField_a_of_type_Boolean;
  private uqb jdField_b_of_type_Uqb;
  private boolean jdField_b_of_type_Boolean;
  
  public upz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Uqb = new uqc();
    this.jdField_b_of_type_Uqb = new uqd();
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
  
  public upr a()
  {
    return this.jdField_a_of_type_Upr;
  }
  
  public upz a(stSchema paramstSchema)
  {
    this.jdField_a_of_type_UserGrowthStSchema = paramstSchema;
    return this;
  }
  
  public upz a(WSDownloadParams paramWSDownloadParams)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = paramWSDownloadParams;
    return this;
  }
  
  public upz a(upr paramupr)
  {
    this.jdField_a_of_type_Upr = paramupr;
    return this;
  }
  
  public upz a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public uxm a()
  {
    return this.jdField_a_of_type_Uxm;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_UserGrowthStSchema == null))
    {
      uya.d("WSStSchemaJumpManager", "[WSStSchemaJumpManager.java][processStSchemaClickAction] mContext:" + this.jdField_a_of_type_AndroidContentContext + ", mStSchema" + this.jdField_a_of_type_UserGrowthStSchema);
      return;
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (Object localObject = this.jdField_a_of_type_Uqb;; localObject = this.jdField_b_of_type_Uqb)
    {
      localObject = ((uqb)localObject).a(this);
      if (localObject == null) {
        break;
      }
      ((upq)localObject).a();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upz
 * JD-Core Version:    0.7.0.1
 */