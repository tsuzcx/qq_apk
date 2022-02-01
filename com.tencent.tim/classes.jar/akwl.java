import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class akwl
  implements BusinessObserver
{
  private void bx(boolean paramBoolean, int paramInt)
  {
    ao(paramBoolean, paramInt);
    if (paramBoolean) {
      aI(true, 7);
    }
  }
  
  protected void AS(boolean paramBoolean) {}
  
  protected void BT(boolean paramBoolean) {}
  
  protected void C(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void D(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void No(boolean paramBoolean) {}
  
  protected void Np(boolean paramBoolean) {}
  
  protected void aG(boolean paramBoolean, int paramInt) {}
  
  protected void aH(boolean paramBoolean, int paramInt) {}
  
  protected void aI(boolean paramBoolean, int paramInt) {}
  
  protected void aJ(boolean paramBoolean, int paramInt) {}
  
  protected void aJ(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void aX(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void ao(boolean paramBoolean, int paramInt) {}
  
  protected void ar(boolean paramBoolean, int paramInt) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  protected String eF(int paramInt)
  {
    if (paramInt == 217) {
      return acfp.m(2131704363);
    }
    if ((paramInt == 219) || (paramInt == 216)) {
      return acfp.m(2131704368);
    }
    if (paramInt == 224) {
      return acfp.m(2131704360);
    }
    if (paramInt == 223) {
      return acfp.m(2131704361);
    }
    return acfp.m(2131704364);
  }
  
  protected void fV(int paramInt1, int paramInt2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int k = 0;
    int i = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int j = 0;
    switch (paramInt)
    {
    default: 
      return;
    case 12: 
      if (paramBoolean)
      {
        if (paramBundle.getBoolean("bind_state"))
        {
          aJ(true, true);
          return;
        }
        aJ(true, false);
        return;
      }
      aJ(false, false);
      return;
    case 35: 
      C(paramBoolean, paramBundle);
      return;
    case 14: 
      paramInt = j;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      ao(paramBoolean, paramInt);
      return;
    case 15: 
      paramInt = k;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      ar(paramBoolean, paramInt);
      return;
    case 28: 
      paramInt = i;
      if (paramBundle != null)
      {
        paramInt = i;
        if (paramBundle.getBoolean("hasUpdate")) {
          paramInt = 1;
        }
      }
      aI(paramBoolean, paramInt);
      return;
    case 16: 
      if (paramBundle != null) {}
      for (paramInt = paramBundle.getInt("k_result");; paramInt = -1)
      {
        aJ(paramBoolean, paramInt);
        return;
      }
    case 17: 
      No(paramBoolean);
      return;
    case 19: 
      D(paramBoolean, paramBundle);
      return;
    case 20: 
      xM(paramBoolean);
      return;
    case 23: 
      Np(paramBoolean);
      return;
    case 26: 
      c(paramBoolean, paramBundle.getBoolean("bindOK"), paramBundle.getBoolean("hadBind"), paramBundle.getString("bindUin"));
      return;
    case 27: 
      aX(paramBoolean, paramBundle.getBoolean("bind_state", false));
      return;
    case 31: 
      paramInt = m;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      bx(paramBoolean, paramInt);
      return;
    case 30: 
      paramInt = n;
      if (paramBoolean) {
        paramInt = paramBundle.getInt("param_update_flag");
      }
      aI(paramBoolean, paramInt);
      return;
    case 100: 
      fV(paramBundle.getInt("current_percentage"), paramBundle.getInt("expected_percentage"));
      return;
    case 32: 
      AS(paramBoolean);
      return;
    case 33: 
      BT(paramBoolean);
      return;
    case 34: 
      xp(paramBoolean);
      return;
    case 38: 
      paramInt = i1;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      aH(paramBoolean, paramInt);
      return;
    }
    paramInt = i2;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("param_fail_reason", 0);
    }
    aG(paramBoolean, paramInt);
  }
  
  protected void xM(boolean paramBoolean) {}
  
  protected void xp(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akwl
 * JD-Core Version:    0.7.0.1
 */