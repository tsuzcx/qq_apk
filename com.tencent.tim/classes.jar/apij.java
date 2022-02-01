import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;

public class apij
{
  private apij.a jdField_a_of_type_Apij$a;
  private apij.b jdField_a_of_type_Apij$b;
  private apij.c jdField_a_of_type_Apij$c;
  private IphonePickerView.d jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d;
  private int akA;
  private int aky;
  private int akz;
  private apij.c b;
  private IphonePickerView c;
  private ausj mActionSheet;
  private Context mContext;
  
  public apij(Context paramContext, IphonePickerView.d paramd)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d = paramd;
  }
  
  public IphonePickerView.d a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d;
  }
  
  public void a(apij.a parama)
  {
    this.jdField_a_of_type_Apij$a = parama;
  }
  
  public void a(apij.b paramb)
  {
    this.jdField_a_of_type_Apij$b = paramb;
  }
  
  public void dismiss()
  {
    if ((this.mActionSheet != null) && (this.mActionSheet.isShowing())) {
      this.mActionSheet.dismiss();
    }
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.c != null) {
        this.c.setSelection(paramInt1, paramInt2);
      }
      return;
      this.aky = paramInt2;
      continue;
      this.akz = paramInt2;
      continue;
      this.akA = paramInt2;
    }
  }
  
  public void show()
  {
    if (this.mActionSheet == null)
    {
      this.c = ((IphonePickerView)LayoutInflater.from(this.mContext).inflate(2131561390, null));
      this.c.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d);
      this.mActionSheet = ausj.d(this.mContext);
      this.mActionSheet.setCloseAutoRead(true);
      this.mActionSheet.setActionContentView(this.c, null);
      Object localObject = (DispatchActionMoveScrollView)this.mActionSheet.findViewById(2131362014);
      ((DispatchActionMoveScrollView)localObject).cZW = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.mActionSheet.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.c.setPickListener(new apik(this));
      this.mActionSheet.a(new apil(this));
    }
    if (!this.mActionSheet.isShowing())
    {
      this.c.setSelection(0, this.aky);
      this.c.setSelection(1, this.akz);
      this.c.setSelection(2, this.akA);
    }
    try
    {
      this.mActionSheet.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static abstract interface a
  {
    public abstract void i(int paramInt1, int paramInt2, int paramInt3);
  }
  
  public static abstract interface b
  {
    public abstract void onDismiss();
  }
  
  public static abstract interface c
  {
    public abstract void w(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apij
 * JD-Core Version:    0.7.0.1
 */