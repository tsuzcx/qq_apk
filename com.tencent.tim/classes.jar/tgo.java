import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class tgo
{
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  private tgq jdField_a_of_type_Tgq;
  private tgx jdField_a_of_type_Tgx;
  private Context mContext;
  
  public static tgp a(Context paramContext)
  {
    return new tgp(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  void a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = paramGdtAdBoxData;
  }
  
  void a(tgx paramtgx)
  {
    this.jdField_a_of_type_Tgx = paramtgx;
  }
  
  public void destroy()
  {
    if ((this.jdField_a_of_type_Tgq != null) && (this.jdField_a_of_type_Tgq.isShowing()))
    {
      this.jdField_a_of_type_Tgq.dismiss();
      this.jdField_a_of_type_Tgq = null;
    }
    this.jdField_a_of_type_Tgx = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.mContext = null;
  }
  
  public void onDismiss()
  {
    if (this.jdField_a_of_type_Tgx != null) {
      this.jdField_a_of_type_Tgx.onDismiss();
    }
  }
  
  void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void show()
  {
    this.jdField_a_of_type_Tgq = new tgw(this.mContext);
    this.jdField_a_of_type_Tgq.a(this);
    this.jdField_a_of_type_Tgq.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgo
 * JD-Core Version:    0.7.0.1
 */