import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

public class ojw
  implements ojp
{
  private stSchema jdField_a_of_type_UserGrowthStSchema;
  private ojo jdField_a_of_type_Ojo;
  private ojy jdField_a_of_type_Ojy;
  private boolean axA;
  private boolean axz;
  private MiniAppLauncher.MiniAppLaunchListener jdField_b_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener;
  private ojy jdField_b_of_type_Ojy;
  private ool.a jdField_b_of_type_Ool$a;
  private WSDownloadParams d;
  private Context mContext;
  
  public ojw(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Ojy = new ojz();
    this.jdField_b_of_type_Ojy = new oka();
  }
  
  public boolean GX()
  {
    return this.axz;
  }
  
  public stSchema a()
  {
    return this.jdField_a_of_type_UserGrowthStSchema;
  }
  
  public MiniAppLauncher.MiniAppLaunchListener a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener;
  }
  
  public ojo a()
  {
    return this.jdField_a_of_type_Ojo;
  }
  
  public ojw a(stSchema paramstSchema)
  {
    this.jdField_a_of_type_UserGrowthStSchema = paramstSchema;
    return this;
  }
  
  public ojw a(WSDownloadParams paramWSDownloadParams)
  {
    this.d = paramWSDownloadParams;
    return this;
  }
  
  public ojw a(ojo paramojo)
  {
    this.jdField_a_of_type_Ojo = paramojo;
    return this;
  }
  
  public ojw a(boolean paramBoolean)
  {
    this.axA = paramBoolean;
    return this;
  }
  
  public ool.a a()
  {
    return this.jdField_b_of_type_Ool$a;
  }
  
  public WSDownloadParams b()
  {
    return this.d;
  }
  
  public void bfC()
  {
    if ((this.mContext == null) || (this.jdField_a_of_type_UserGrowthStSchema == null))
    {
      ooz.e("WSStSchemaJumpManager", "[WSStSchemaJumpManager.java][processStSchemaClickAction] mContext:" + this.mContext + ", mStSchema" + this.jdField_a_of_type_UserGrowthStSchema);
      return;
    }
    if (this.axA) {}
    for (Object localObject = this.jdField_a_of_type_Ojy;; localObject = this.jdField_b_of_type_Ojy)
    {
      localObject = ((ojy)localObject).a(this);
      if (localObject == null) {
        break;
      }
      ((ojn)localObject).GW();
      return;
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojw
 * JD-Core Version:    0.7.0.1
 */