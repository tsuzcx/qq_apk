import android.os.Bundle;
import com.tencent.common.app.AppInterface;

public final class adla
{
  public static Bundle i(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new adla.f(localBundle);
    paramBundle.iR(10L);
    paramBundle.Gr(true);
    paramBundle.Gq(true);
    paramBundle.iS(4096L);
    return paramBundle.toBundle();
  }
  
  public static class a
    extends adla.b
  {
    public String buw = "10001";
    
    public void c(AppInterface paramAppInterface, Bundle paramBundle)
    {
      this.buw = paramBundle.getString("PromotionDescription");
    }
  }
  
  public static abstract class b
  {
    public long UX = 0L;
    public boolean bOO = true;
    public boolean bOP;
    public boolean bOr = true;
    public String bux = "0";
    public String mVersion = "0";
    
    public abstract void c(AppInterface paramAppInterface, Bundle paramBundle);
    
    public final void d(AppInterface paramAppInterface, Bundle paramBundle)
    {
      if (paramBundle == null) {
        return;
      }
      this.UX = paramBundle.getLong("RecoglizeMask", 0L);
      this.bux = paramBundle.getString("H5Source", "0");
      this.mVersion = paramBundle.getString("version", "0");
      if (!paramBundle.getBoolean("disablecloud", false)) {}
      for (boolean bool = true;; bool = false)
      {
        this.bOO = bool;
        this.bOP = paramBundle.getBoolean("is_from_h5_entry", false);
        this.bOr = false;
        c(paramAppInterface, paramBundle);
        return;
      }
    }
  }
  
  public static class c
    extends adla.b
  {
    public void c(AppInterface paramAppInterface, Bundle paramBundle) {}
  }
  
  public static class d
    extends adla.b
  {
    public String buy;
    
    public void c(AppInterface paramAppInterface, Bundle paramBundle)
    {
      this.buy = paramBundle.getString("PromotionDescription", "");
    }
  }
  
  public static class e
    extends adla.b
  {
    public String buy;
    
    public void c(AppInterface paramAppInterface, Bundle paramBundle)
    {
      this.buy = paramBundle.getString("PromotionDescription", "");
    }
  }
  
  public static class f
  {
    private Bundle az;
    
    public f(Bundle paramBundle)
    {
      this.az = paramBundle;
    }
    
    public void Gq(boolean paramBoolean)
    {
      this.az.putBoolean("NoLimitParams", paramBoolean);
    }
    
    public void Gr(boolean paramBoolean)
    {
      this.az.putBoolean("arTransferPromotion", paramBoolean);
    }
    
    public void iR(long paramLong)
    {
      this.az.putLong("downloadItems", paramLong);
    }
    
    public void iS(long paramLong)
    {
      this.az.putLong("recognitionMask", paramLong);
    }
    
    public Bundle toBundle()
    {
      return this.az;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adla
 * JD-Core Version:    0.7.0.1
 */