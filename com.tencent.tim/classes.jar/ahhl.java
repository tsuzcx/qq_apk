import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import java.util.Set;

public class ahhl
  extends ahgq
{
  int cZU;
  
  public ahhl(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if ((this.e != null) && (this.e.isShowing())) {
      return;
    }
    this.bf.putString("uin", paramBundle.getString("uin"));
    this.bf.putInt("uintype", paramBundle.getInt("uintype"));
    this.bf.putBoolean("isBack2Root", true);
    this.mIntent = new Intent(this.mActivity, SplashActivity.class);
    this.mIntent = wja.a(this.mIntent, new int[] { 2 });
    this.mIntent.putExtras(this.bf);
    this.mActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
    this.mActivity.startActivity(this.mIntent);
    anot.a(this.app, "CliOper", "", "", "ep_mall", "Clk_send_nonaio_suc", 0, 0, "", "", "", "FORWARD_EMOPGK_ID");
  }
  
  public boolean anj()
  {
    super.anj();
    this.cZU = this.mIntent.getIntExtra("FORWARD_EMOPGK_ID", -1);
    return true;
  }
  
  protected void dnr()
  {
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
  }
  
  public void dnt()
  {
    super.dnt();
    anot.a(this.app, "CliOper", "", "", "ep_mall", "Clk_send_nonaio", 0, 0, "", "", "", this.mIntent.getIntExtra("FORWARD_EMOPGK_ID", -1) + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhl
 * JD-Core Version:    0.7.0.1
 */