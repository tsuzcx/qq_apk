import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class ampa
  extends ampy
{
  private CharSequence al;
  private CharSequence am;
  private AccountSearchPb.record c;
  private String keyword;
  
  public ampa(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.c = paramrecord;
    this.keyword = paramString;
    this.al = paramCharSequence;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public void cR(View paramView)
  {
    AddFriendActivity.a((Activity)paramView.getContext(), new SearchResultItem(this.c), ((BaseActivity)paramView.getContext()).app, true, 1);
    amxk.a(this.keyword, 70, 0, paramView);
    amxk.a(this.keyword, 70, paramView, false);
  }
  
  public CharSequence f()
  {
    StringBuilder localStringBuilder;
    if (this.am == null)
    {
      localStringBuilder = new StringBuilder().append("(");
      if (this.c.uin.get() == 0L) {
        break label78;
      }
    }
    label78:
    for (String str = String.valueOf(this.c.uin.get());; str = this.c.mobile.get())
    {
      this.am = amxk.a(str + ")", this.keyword);
      return this.am;
    }
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    return acfp.m(2131707036);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    return this.al;
  }
  
  public String getUin()
  {
    if (this.c.uin.get() != 0L) {
      return String.valueOf(this.c.uin.get());
    }
    return this.c.mobile.get();
  }
  
  public int pG()
  {
    if (this.c.uin.get() != 0L) {
      return 1;
    }
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampa
 * JD-Core Version:    0.7.0.1
 */