import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.List;

public class soo
{
  private String Bm;
  private int Sm;
  String aFr;
  String aFs;
  String aFt;
  String aws;
  private List<soo> dV;
  private Drawable mIcon;
  private String mTitle;
  
  public soo(String paramString1, String paramString2, Drawable paramDrawable, int paramInt)
  {
    this.mIcon = paramDrawable;
    this.mTitle = paramString2;
    this.Bm = paramString1;
    this.Sm = paramInt;
  }
  
  public soo a(int paramInt)
  {
    if (this.dV == null) {
      return null;
    }
    return (soo)this.dV.get(paramInt);
  }
  
  public void b(mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo.logo_url.has()) {
      this.aws = paramButtonInfo.logo_url.get();
    }
    if (paramButtonInfo.texture_url.has()) {
      this.aFt = paramButtonInfo.texture_url.get();
    }
    if (paramButtonInfo.bg_colors.has())
    {
      paramButtonInfo = paramButtonInfo.bg_colors.get().split("\\|");
      if (paramButtonInfo.length > 0) {
        this.aFr = paramButtonInfo[0];
      }
      if (paramButtonInfo.length > 1) {
        this.aFs = paramButtonInfo[1];
      }
    }
  }
  
  public void b(soo paramsoo)
  {
    if (paramsoo == null) {
      return;
    }
    if (this.dV == null) {
      this.dV = new ArrayList();
    }
    this.dV.add(paramsoo);
  }
  
  public List<soo> co()
  {
    return this.dV;
  }
  
  public String eo()
  {
    return this.Bm;
  }
  
  public Drawable getIcon()
  {
    return this.mIcon;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public int hE()
  {
    if (this.dV == null) {
      return 0;
    }
    return this.dV.size();
  }
  
  public int hF()
  {
    return this.Sm;
  }
  
  public boolean hasSubMenu()
  {
    return this.dV != null;
  }
  
  public String nE()
  {
    return this.aws;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     soo
 * JD-Core Version:    0.7.0.1
 */