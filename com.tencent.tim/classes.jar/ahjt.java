import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;

public class ahjt
  extends ahki
{
  private boolean chi;
  
  public ahjt(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean a(aqju paramaqju)
  {
    if (this.chi)
    {
      this.d.mSourceName = this.mIntent.getStringExtra("struct_share_key_source_name");
      this.d.mSourceIcon = this.mIntent.getStringExtra("struct_share_key_source_icon");
    }
    if ((paramaqju != null) && (this.d != null))
    {
      this.a = new ahki.b(this, this.mActivity);
      paramaqju.addView(this.a.ce());
      paramaqju.adjustMessageTopBottomMargin(0.0F, 10.0F);
      b(this.d.mSourceName, paramaqju);
    }
    return false;
  }
  
  public boolean anj()
  {
    super.anj();
    this.mShareAppId = this.bf.getLong("req_share_id");
    this.chi = this.mIntent.getBooleanExtra("is_ec_live_share", false);
    if ((this.mShareAppId > 0L) && (!this.chi)) {
      svi.a(this.app, this.mAppContext, this.app.getCurrentAccountUin(), this.mShareAppId, 0L, this.jdField_e_of_type_MqqObserverBusinessObserver);
    }
    doy();
    Object localObject = new Bundle(this.bf);
    ((Bundle)localObject).putInt("req_type", 1);
    localObject = anre.a((Bundle)localObject);
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.d = ((AbsShareMsg)localObject);
    }
    doz();
    return true;
  }
  
  protected boolean anl()
  {
    doA();
    return true;
  }
  
  protected void dns()
  {
    this.jdField_e_of_type_Aqju.setMessage("");
  }
  
  protected void dnv()
  {
    if (this.cgQ)
    {
      anot.a(this.app, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.cgQ = false;
    }
    super.dnv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjt
 * JD-Core Version:    0.7.0.1
 */