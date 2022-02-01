import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

public class uip
  implements uii
{
  private stSchema jdField_a_of_type_UserGrowthStSchema;
  private Context jdField_a_of_type_AndroidContentContext;
  private WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  private MiniAppLauncher.MiniAppLaunchListener jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener;
  private uih jdField_a_of_type_Uih;
  private uir jdField_a_of_type_Uir;
  private uos jdField_a_of_type_Uos;
  private boolean jdField_a_of_type_Boolean;
  private uir jdField_b_of_type_Uir;
  private boolean jdField_b_of_type_Boolean;
  
  public uip(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Uir = new uis();
    this.jdField_b_of_type_Uir = new uit();
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
  
  public uih a()
  {
    return this.jdField_a_of_type_Uih;
  }
  
  public uip a(stSchema paramstSchema)
  {
    this.jdField_a_of_type_UserGrowthStSchema = paramstSchema;
    return this;
  }
  
  public uip a(WSDownloadParams paramWSDownloadParams)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = paramWSDownloadParams;
    return this;
  }
  
  public uip a(uih paramuih)
  {
    this.jdField_a_of_type_Uih = paramuih;
    return this;
  }
  
  public uip a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public uos a()
  {
    return this.jdField_a_of_type_Uos;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_UserGrowthStSchema == null))
    {
      upe.d("WSStSchemaJumpManager", "[WSStSchemaJumpManager.java][processStSchemaClickAction] mContext:" + this.jdField_a_of_type_AndroidContentContext + ", mStSchema" + this.jdField_a_of_type_UserGrowthStSchema);
      return;
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (Object localObject = this.jdField_a_of_type_Uir;; localObject = this.jdField_b_of_type_Uir)
    {
      localObject = ((uir)localObject).a(this);
      if (localObject == null) {
        break;
      }
      ((uig)localObject).a();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uip
 * JD-Core Version:    0.7.0.1
 */