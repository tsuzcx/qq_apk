import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.store.ApolloVoiceDIYHelper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abty
{
  private double bW = 2147483647.0D;
  private int crV = -1;
  private WeakReference<ApolloTextureView> fL;
  private int mActionId;
  private int mActionType;
  private int mRoleId;
  
  private void z(double paramDouble)
  {
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.fL.get();
    if (localApolloTextureView == null) {
      return;
    }
    localApolloTextureView.getRender().mIsFrameMode = true;
    localApolloTextureView.getRender().mDuration = paramDouble;
    localApolloTextureView.getRenderImpl().stopLoopDelayed(0L);
    String[] arrayOfString2 = abvg.a(13, this.mActionId, this.mRoleId, true);
    String[] arrayOfString1 = null;
    if (this.mActionType == 1) {
      arrayOfString1 = abvg.a(13, this.mActionId, this.mRoleId, false);
    }
    localApolloTextureView.getRenderImpl().a(this.mActionId, 0, arrayOfString2, arrayOfString1);
  }
  
  public void a(ApolloTextureView paramApolloTextureView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.fL = new WeakReference(paramApolloTextureView);
    if (paramInt1 != this.crV) {
      cFr();
    }
    this.mActionId = paramInt1;
    this.crV = this.mActionId;
    this.mRoleId = paramInt2;
    this.mActionType = paramInt3;
  }
  
  public void cFr()
  {
    this.bW = 2147483647.0D;
  }
  
  public void y(double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloVoiceDIYHelper", 2, "[renderFrame], curSec:" + paramDouble + ",lastDur:" + this.bW);
    }
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.fL.get();
    if (localApolloTextureView == null) {
      return;
    }
    if (paramDouble <= this.bW) {
      z(paramDouble);
    }
    for (;;)
    {
      this.bW = paramDouble;
      return;
      localApolloTextureView.queueEvent(new ApolloVoiceDIYHelper.1(this, localApolloTextureView, paramDouble - this.bW));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abty
 * JD-Core Version:    0.7.0.1
 */