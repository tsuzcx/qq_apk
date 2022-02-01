import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

public class vea
  implements vdt
{
  private stSchema jdField_a_of_type_UserGrowthStSchema;
  private Context jdField_a_of_type_AndroidContentContext;
  private WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  private MiniAppLauncher.MiniAppLaunchListener jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener;
  private vds jdField_a_of_type_Vds;
  private vec jdField_a_of_type_Vec;
  private vmb jdField_a_of_type_Vmb;
  private boolean jdField_a_of_type_Boolean;
  private vec jdField_b_of_type_Vec;
  private boolean jdField_b_of_type_Boolean;
  
  public vea(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Vec = new ved();
    this.jdField_b_of_type_Vec = new vee();
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
  
  public vds a()
  {
    return this.jdField_a_of_type_Vds;
  }
  
  public vea a(stSchema paramstSchema)
  {
    this.jdField_a_of_type_UserGrowthStSchema = paramstSchema;
    return this;
  }
  
  public vea a(WSDownloadParams paramWSDownloadParams)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = paramWSDownloadParams;
    return this;
  }
  
  public vea a(vds paramvds)
  {
    this.jdField_a_of_type_Vds = paramvds;
    return this;
  }
  
  public vea a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public vmb a()
  {
    return this.jdField_a_of_type_Vmb;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_UserGrowthStSchema == null))
    {
      vmp.d("WSStSchemaJumpManager", "[WSStSchemaJumpManager.java][processStSchemaClickAction] mContext:" + this.jdField_a_of_type_AndroidContentContext + ", mStSchema" + this.jdField_a_of_type_UserGrowthStSchema);
      return;
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (Object localObject = this.jdField_a_of_type_Vec;; localObject = this.jdField_b_of_type_Vec)
    {
      localObject = ((vec)localObject).a(this);
      if (localObject == null) {
        break;
      }
      ((vdr)localObject).a();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vea
 * JD-Core Version:    0.7.0.1
 */