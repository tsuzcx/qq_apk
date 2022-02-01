import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class tgp
{
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  private tgx jdField_a_of_type_Tgx;
  private Context mContext;
  
  tgp(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public tgo a()
  {
    tgo localtgo = new tgo();
    localtgo.setContext(this.mContext);
    localtgo.a(this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData);
    localtgo.a(this.jdField_a_of_type_Tgx);
    return localtgo;
  }
  
  public tgp a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = paramGdtAdBoxData;
    return this;
  }
  
  public tgp a(tgx paramtgx)
  {
    this.jdField_a_of_type_Tgx = paramtgx;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgp
 * JD-Core Version:    0.7.0.1
 */