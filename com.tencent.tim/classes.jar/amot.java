import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class amot
  extends ampt
{
  private long ajT;
  private int dDi = 1;
  private TroopMemberInfo h;
  private String keyword;
  private String subTitle;
  private String title;
  
  public amot(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.h = paramTroopMemberInfo;
  }
  
  private void initTitle()
  {
    switch (this.dDi)
    {
    default: 
      return;
    case 2: 
      this.title = this.h.troopnick;
      this.subTitle = amxk.h(new String[] { this.h.friendnick, this.h.memberuin });
      return;
    case 3: 
      this.title = this.h.autoremark;
      this.subTitle = amxk.h(new String[] { this.h.friendnick, this.h.memberuin });
      return;
    case 1: 
      this.title = amxk.h(new String[] { this.h.troopnick, this.h.autoremark });
      if (!TextUtils.isEmpty(this.title))
      {
        this.subTitle = this.h.friendnick;
        return;
      }
      this.title = this.h.friendnick;
      this.subTitle = this.h.memberuin;
      return;
    }
    this.title = amxk.h(new String[] { this.h.troopnick, this.h.autoremark, this.h.friendnick });
    this.subTitle = this.h.memberuin;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int IU()
  {
    return 1;
  }
  
  public Object S()
  {
    return this.h.memberuin;
  }
  
  protected long au(String paramString)
  {
    this.keyword = paramString;
    this.ajT = -9223372036854775808L;
    long l = amxk.b(paramString, this.h.troopnick, amjz.aiT);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDi = 2;
    }
    l = amxk.b(paramString, this.h.autoremark, amjz.aiX);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDi = 3;
    }
    l = amxk.b(paramString, this.h.friendnick, amjz.aiY);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDi = 1;
    }
    l = amxk.a(paramString, this.h.memberuin, amjz.ajb, false);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDi = 0;
    }
    if (this.ajT != -9223372036854775808L)
    {
      this.ajT += amjz.ajm;
      initTitle();
    }
    return this.ajT;
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    if (amxk.lo(this.fromType))
    {
      aalb.bwg = true;
      aalb.a(paramView.getContext(), this.h.memberuin, this.h.troopuin, 1000, za(), false);
      amxk.a(this.keyword, 20, 1, paramView);
      amxk.a(this.keyword, 20, paramView, false);
      amxk.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        amxk.d("search", "contact", "contacts", 0, 0, new String[] { amxk.fc(this.fromType) });
      }
      if (((S() instanceof String)) && (!this.cDS)) {
        amxk.e(this.app, this.keyword, this.cbp, (String)S(), IU());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.cbp != null) && (!TextUtils.isEmpty(this.cbp))) {
          amub.a(null, 0, this.fromType, "0X8009D31", 1, 0, null, null);
        }
      }
      else {
        return;
      }
      amub.a(null, 0, this.fromType, "0X8009D37", 0, 0, null, null);
      return;
    }
    amxk.a(paramView, this);
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    if (amxk.lo(this.fromType)) {
      return acfp.m(2131704446);
    }
    return acfp.m(2131704437);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public String getUin()
  {
    return this.h.memberuin;
  }
  
  public int lk()
  {
    return 1000;
  }
  
  public int pG()
  {
    return 1;
  }
  
  public String za()
  {
    return this.title;
  }
  
  public String zb()
  {
    return this.subTitle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amot
 * JD-Core Version:    0.7.0.1
 */