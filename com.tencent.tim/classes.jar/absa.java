import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.a;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class absa
{
  private absb jdField_a_of_type_Absb;
  private abse jdField_a_of_type_Abse;
  private absf jdField_a_of_type_Absf;
  private absj jdField_a_of_type_Absj;
  private absk jdField_a_of_type_Absk;
  private absl jdField_a_of_type_Absl;
  private final int cro;
  private boolean mIsInit;
  
  public absa(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteScriptManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Abse = new abse();
    this.jdField_a_of_type_Abse.setUin(paramString);
    this.jdField_a_of_type_Absj = new absj(this.jdField_a_of_type_Abse);
    this.jdField_a_of_type_Absl = new absl(this.jdField_a_of_type_Abse, this.jdField_a_of_type_Absj, this);
    this.jdField_a_of_type_Absk = new absk(this.jdField_a_of_type_Abse);
    this.jdField_a_of_type_Absf = new absf(this.jdField_a_of_type_Abse, this.jdField_a_of_type_Absj, this.jdField_a_of_type_Absk, this.jdField_a_of_type_Absl);
    this.jdField_a_of_type_Abse.a(this.jdField_a_of_type_Absk);
    this.cro = paramInt;
  }
  
  public void CP(String paramString)
  {
    this.jdField_a_of_type_Absf.CP(paramString);
  }
  
  public void HW(int paramInt)
  {
    QLog.i("CmShow_SpriteScriptManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Abse == null) || (this.jdField_a_of_type_Absf == null) || (this.jdField_a_of_type_Absl == null)) {
      return;
    }
    this.jdField_a_of_type_Abse.gJ(0, 0);
    this.jdField_a_of_type_Abse.Ec(true);
    paramInt = this.cro;
    this.jdField_a_of_type_Abse.HT(paramInt);
    this.jdField_a_of_type_Absl.cED();
    this.jdField_a_of_type_Abse.Eb(true);
    this.mIsInit = true;
    this.jdField_a_of_type_Absb = ((absb)this.jdField_a_of_type_Absl.a(100));
  }
  
  public absb a()
  {
    return this.jdField_a_of_type_Absb;
  }
  
  public abse a()
  {
    return this.jdField_a_of_type_Abse;
  }
  
  public absk a()
  {
    return this.jdField_a_of_type_Absk;
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    this.jdField_a_of_type_Absf.a(this.jdField_a_of_type_Abse, paramPlayActionConfig);
  }
  
  public void a(CmShowRenderView.a parama)
  {
    this.jdField_a_of_type_Absj.b(parama);
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Abse.mFriendUin = paramString2;
    this.jdField_a_of_type_Abse.mSelfUin = paramString1;
    this.jdField_a_of_type_Abse.mScale = paramFloat;
    if (this.jdField_a_of_type_Absj != null) {
      this.jdField_a_of_type_Absf.a(this.jdField_a_of_type_Abse, paramInt, this.jdField_a_of_type_Absj.d, paramBundle);
    }
  }
  
  public void ah(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Absf.ah(paramList, paramBoolean);
  }
  
  public void b(abix paramabix)
  {
    if (paramabix == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Abse.a(paramabix);
      localApolloCmdChannel = ApolloUtil.a();
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramabix);
  }
  
  public void bx(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Absf.bx(paramString, paramBoolean);
  }
  
  public void dm(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Absf.dm(paramString, paramInt);
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Absb != null) {
      this.jdField_a_of_type_Absb.HP(1);
    }
    this.jdField_a_of_type_Abse.setBubbleType(-1);
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_Absb != null) {
      this.jdField_a_of_type_Absb.HP(2);
    }
  }
  
  public void ez(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Absf != null) {
      this.jdField_a_of_type_Absf.a(this.jdField_a_of_type_Abse, paramString1, paramString2);
    }
  }
  
  public void f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Absf.f(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void gL(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Absf.gL(paramInt1, paramInt2);
  }
  
  public void k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Absf.k(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Absk != null) {
      this.jdField_a_of_type_Absk.reset();
    }
    Object localObject = this.jdField_a_of_type_Abse.a();
    if (localObject != null)
    {
      localObject = ((abix)localObject).getRenderImpl();
      if (localObject != null) {
        ((abii)localObject).onDestroy();
      }
    }
    this.jdField_a_of_type_Absj.clear();
    this.jdField_a_of_type_Absl.clear();
    this.jdField_a_of_type_Abse.clear();
    this.jdField_a_of_type_Absf.clear();
    this.mIsInit = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absa
 * JD-Core Version:    0.7.0.1
 */