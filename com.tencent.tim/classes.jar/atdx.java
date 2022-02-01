import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

public class atdx
  implements auhk.b
{
  protected augx a;
  private auhk.a a;
  protected auio a;
  private aqky b;
  protected String cGJ;
  protected String cGK;
  protected Context context;
  protected arhz d;
  private boolean dhr;
  protected int epo;
  protected int epq;
  protected int epr = 2131721079;
  protected int eps = 2131721058;
  protected int maxLength = 64;
  
  public atdx(Context paramContext, int paramInt, augx paramaugx)
  {
    this.context = paramContext;
    this.epo = paramInt;
    this.jdField_a_of_type_Augx = paramaugx;
    if ((paramInt == 2) || (paramInt == 4))
    {
      this.epq = 2131720956;
      this.cGJ = paramContext.getString(2131720955);
      this.cGK = paramContext.getString(2131691661);
      this.maxLength = 64;
      return;
    }
    if ((paramInt == 3) || (paramInt == 5))
    {
      this.epq = 2131720962;
      this.cGJ = paramContext.getString(2131720961);
      this.cGK = paramContext.getString(2131691662);
      this.maxLength = 64;
      return;
    }
    if ((paramInt == 8) || (paramInt == 6))
    {
      this.epq = 2131720958;
      this.cGJ = paramContext.getString(2131720957);
      this.cGK = paramContext.getString(2131691663);
      this.maxLength = 64;
      return;
    }
    if ((paramInt == 9) || (paramInt == 7))
    {
      this.epq = 2131720960;
      this.cGJ = paramContext.getString(2131720959);
      this.cGK = paramContext.getString(2131691664);
      this.maxLength = 64;
      return;
    }
    this.epq = 2131691645;
    this.cGJ = paramContext.getString(2131691644);
    this.cGK = paramContext.getString(2131691614);
    this.maxLength = 20;
  }
  
  public boolean Pp()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Augx != null) {
      bool = this.jdField_a_of_type_Augx.Pp();
    }
    return bool;
  }
  
  public void a(auhk.a parama)
  {
    this.jdField_a_of_type_Auhk$a = parama;
  }
  
  public void a(auio paramauio)
  {
    this.jdField_a_of_type_Auio = paramauio;
  }
  
  public void al(boolean paramBoolean, String paramString)
  {
    if (Pp())
    {
      if (paramBoolean) {
        QQToast.a(this.context, 2, paramString, 0).show(this.context.getResources().getDimensionPixelSize(2131299627));
      }
    }
    else {
      return;
    }
    QQToast.a(this.context, 1, paramString, 0).show(this.context.getResources().getDimensionPixelSize(2131299627));
  }
  
  public void dismiss()
  {
    if (this.b != null) {
      this.b.dismiss();
    }
  }
  
  public void ehM()
  {
    try
    {
      if ((this.d != null) && (this.d.isShowing())) {
        this.d.dismiss();
      }
      this.d = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getInputValue()
  {
    if ((this.b != null) && (!TextUtils.isEmpty(this.b.getInputValue()))) {
      return this.b.getInputValue();
    }
    return "";
  }
  
  public void show()
  {
    atdy localatdy = new atdy(this);
    atdz localatdz = new atdz(this);
    atea localatea = new atea(this);
    this.b = aqha.a(this.context, this.epq, this.cGJ, this.cGK, localatdy, this.epr, localatdz, this.eps, localatea);
    this.b.setOnDismissListener(new ateb(this));
  }
  
  public void showLoading()
  {
    try
    {
      this.d = new arhz(this.context);
      this.d.setMessage("加载中...");
      this.d.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdx
 * JD-Core Version:    0.7.0.1
 */