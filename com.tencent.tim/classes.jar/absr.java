import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.a;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class absr
{
  public static int crr;
  private absp a;
  private absa jdField_b_of_type_Absa;
  private ApolloTextureView jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView;
  private int cpd;
  private final int cro;
  
  public absr(CmShowRenderView paramCmShowRenderView, int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = paramCmShowRenderView;
    this.cro = paramInt;
  }
  
  public static void b(ArrayList<String> paramArrayList, int[] paramArrayOfInt)
  {
    QLog.i("CmShow_RenderViewController", 1, "CmShow_ preLoadRes start");
    Bundle localBundle = new Bundle();
    localBundle.putIntArray("actionIds", paramArrayOfInt);
    localBundle.putStringArrayList("uins", paramArrayList);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_preload_res", localBundle, new abss());
  }
  
  public void CP(String paramString)
  {
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.CP(paramString);
    }
  }
  
  @TargetApi(14)
  public void CQ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "initApolloSurfaceView");
    }
    this.jdField_b_of_type_Absa = new absa(paramString, this.cro);
    this.a = new absp(this.jdField_b_of_type_Absa, 0);
    this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.a);
    this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDumplicateCreateRenderThread(abhh.bCR);
    this.jdField_b_of_type_Absa.b(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView);
    int i = abrj.zN();
    this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setInitHeight(i);
  }
  
  public boolean Yo()
  {
    return this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null;
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.a(paramPlayActionConfig);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.a(paramString1, paramString2, paramFloat, paramInt, paramBundle);
    }
  }
  
  public void ah(List<String> paramList, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.ah(paramList, paramBoolean);
    }
  }
  
  public void b(CmShowRenderView.a parama)
  {
    if (this.a != null) {
      this.a.b(parama);
    }
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.a(parama);
    }
  }
  
  public void bx(String paramString, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.bx(paramString, paramBoolean);
    }
  }
  
  public void dm(String paramString, int paramInt)
  {
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.dm(paramString, paramInt);
    }
  }
  
  public void ez(String paramString1, String paramString2)
  {
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.ez(paramString1, paramString2);
    }
  }
  
  public void f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.f(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void gL(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.gL(paramInt1, paramInt2);
    }
  }
  
  public void k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Absa != null) {
      this.jdField_b_of_type_Absa.k(paramString1, paramString2, paramInt1, paramInt2);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onDestroy ");
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      ApolloRender localApolloRender = this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender();
      if (localApolloRender != null) {
        localApolloRender.queueDestroy();
      }
    }
    if (this.jdField_b_of_type_Absa != null)
    {
      this.jdField_b_of_type_Absa.onDestroy();
      this.jdField_b_of_type_Absa = null;
    }
    if (!Yo())
    {
      QLog.e("CmShow_RenderViewController", 1, new Object[] { "[onDestory] isViewAvailable:", Boolean.valueOf(Yo()) });
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      if ((this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getParent()).removeView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView);
      }
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = null;
    }
    this.cpd = 0;
    abru.clearCache();
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onPause");
    }
    if ((Yo()) && (this.jdField_b_of_type_Absa != null)) {
      this.jdField_b_of_type_Absa.doOnPause();
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onResume");
    }
    if ((Yo()) && (this.jdField_b_of_type_Absa != null)) {
      this.jdField_b_of_type_Absa.doOnResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absr
 * JD-Core Version:    0.7.0.1
 */