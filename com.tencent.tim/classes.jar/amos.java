import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

public class amos
  extends ampt
{
  private long ajT;
  private long ajU = amjz.ajz;
  private String keyword;
  public int matchType;
  private String subTitle;
  private String title;
  private TroopInfo troopInfo;
  
  public amos(QQAppInterface paramQQAppInterface, int paramInt, TroopInfo paramTroopInfo, long paramLong)
  {
    super(paramQQAppInterface, paramInt, paramLong);
    this.troopInfo = paramTroopInfo;
    if (paramQQAppInterface.a().a().kG(paramTroopInfo.troopuin)) {
      this.ajU = amjz.ajp;
    }
    while ((this.troopInfo.troopmask != 2) || (!aizp.a().ni(paramTroopInfo.troopuin))) {
      return;
    }
    this.ajU = amjz.ajp;
  }
  
  private void initTitle()
  {
    this.title = this.troopInfo.getTroopName();
    if (this.troopInfo.isQidianPrivateTroop())
    {
      this.subTitle = "";
      return;
    }
    if (this.troopInfo.isNewTroop())
    {
      this.subTitle = String.valueOf(this.troopInfo.wMemberNumClient + acfp.m(2131704432));
      return;
    }
    this.subTitle = this.troopInfo.troopuin;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int IU()
  {
    return 2;
  }
  
  public Object S()
  {
    return this.troopInfo.troopuin;
  }
  
  public TroopInfo a()
  {
    return this.troopInfo;
  }
  
  protected long au(String paramString)
  {
    this.keyword = paramString;
    this.ajT = -9223372036854775808L;
    long l = amxk.b(paramString, this.troopInfo.getTroopName(), amjz.aiS);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.matchType = 1;
      if ((!this.troopInfo.isNewTroop()) || (this.troopInfo.hasSetTroopName())) {}
    }
    do
    {
      return -9223372036854775808L;
      l = amxk.a(paramString, this.troopInfo.troopuin, amjz.ajb, false);
      if (l <= this.ajT) {
        break;
      }
    } while ((this.troopInfo.isQidianPrivateTroop()) || (this.troopInfo.isNewTroop()));
    this.ajT = l;
    this.matchType = 2;
    if (this.ajT != -9223372036854775808L)
    {
      this.ajT += this.ajU;
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
      aalb.a(paramView.getContext(), this.app, this.troopInfo.troopuin, 1, this.troopInfo.getTroopName(), false);
      amxk.a(this.keyword, 20, 2, paramView);
      aclj.Q(this.app, this.keyword);
      amxk.d(this.app, getTitle().toString(), this.troopInfo.troopuin, this.troopInfo.troopcode, 1);
      amxk.a(this.keyword, 30, paramView, false);
      amxk.a(this, paramView);
      if (((S() instanceof String)) && (!this.cDS)) {
        amxk.e(this.app, this.keyword, this.cbp, (String)S(), IU());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.cbp == null) || (TextUtils.isEmpty(this.cbp))) {
          break label254;
        }
        amub.a(null, 0, this.fromType, "0X8009D31", 2, 0, null, null);
      }
    }
    for (;;)
    {
      new anov(this.app).a("dc00899").b("Grp_listNew").c("search_result").d("clk_grp").a(new String[] { this.troopInfo.troopuin }).report();
      return;
      label254:
      amub.a(null, 0, this.fromType, "0X8009D3B", 0, 0, null, null);
      continue;
      amxk.a(paramView, this);
    }
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    if (amxk.lo(this.fromType)) {
      return "";
    }
    if (this.fromType == 8) {
      return "";
    }
    return acfp.m(2131704473);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public String getUin()
  {
    return this.troopInfo.troopuin;
  }
  
  public int lk()
  {
    return 1;
  }
  
  public int pG()
  {
    return 4;
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
 * Qualified Name:     amos
 * JD-Core Version:    0.7.0.1
 */