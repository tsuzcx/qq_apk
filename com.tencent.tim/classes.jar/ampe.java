import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class ampe
  extends ampy
{
  private CharSequence al;
  private AccountSearchPb.record c;
  private String searchKey;
  
  public ampe(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.c = paramrecord;
    this.searchKey = paramString;
    this.al = paramCharSequence;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public void cR(View paramView)
  {
    Bundle localBundle = TroopInfoActivity.c(String.valueOf(this.c.code.get()), 2);
    localBundle.putInt("exposureSource", 3);
    apuh.a((Activity)paramView.getContext(), localBundle, 2);
    amxk.a(this.searchKey, 80, 0, paramView);
    amxk.a(this.searchKey, 80, paramView, false);
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    return acfp.m(2131707031);
  }
  
  public String getKeyword()
  {
    return this.searchKey;
  }
  
  public CharSequence getTitle()
  {
    return this.al;
  }
  
  public String getUin()
  {
    return String.valueOf(this.c.code.get());
  }
  
  public int pG()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampe
 * JD-Core Version:    0.7.0.1
 */