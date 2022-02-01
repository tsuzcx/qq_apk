import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;

public class ampc
  extends ampy
{
  public CharSequence al;
  private AccountSearchPb.record c;
  private String keyword;
  
  public ampc(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.c = paramrecord;
    this.keyword = paramString;
    this.al = paramCharSequence;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public boolean awd()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("name = ").append(this.al).append(", isCert = ");
      if ((!this.c.has()) || (this.c.flag.get() != 1L)) {
        break label102;
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("GroupNetSearchModelPublicAcntItem", 2, bool);
      if ((!this.c.flag.has()) || (this.c.flag.get() != 1L)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void cR(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((localContext != null) && ((localContext instanceof BaseActivity)))
    {
      PublicView.a((QQAppInterface)((BaseActivity)localContext).getAppRuntime(), localContext, this.c.class_index.get(), String.valueOf(this.c.uin.get()), String.valueOf(this.c.uin.get()), this.c.account_flag.get(), this.c.name.get(), 4);
      amxk.a(this.keyword, 70, 0, paramView);
      amxk.a(this.keyword, 70, paramView, false);
    }
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
    return acfp.m(2131707037);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    return amxk.a(this.c.name.get(), this.keyword);
  }
  
  public String getUin()
  {
    return String.valueOf(this.c.uin.get());
  }
  
  public int pG()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampc
 * JD-Core Version:    0.7.0.1
 */