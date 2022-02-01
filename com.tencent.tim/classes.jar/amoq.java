import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Map;

public class amoq
  extends ampt
{
  private static final int[] nc = { 1000, 1004, 1005, 1006, 1001, 10002, 10004 };
  private long ajT;
  private String cbg;
  private RecentUser d;
  private int dDi = 1;
  private String description;
  private String inteRemark;
  private String keyword;
  private String nickName;
  private String remark;
  private String subTitle;
  private String title;
  private String uin;
  
  public amoq(QQAppInterface paramQQAppInterface, int paramInt, RecentUser paramRecentUser, long paramLong)
  {
    super(paramQQAppInterface, paramInt, paramLong);
    this.d = paramRecentUser;
    initData();
  }
  
  private void initData()
  {
    this.uin = this.d.uin;
    this.nickName = this.d.displayName;
    Object localObject1 = (TroopManager)this.app.getManager(52);
    switch (this.d.getType())
    {
    default: 
      localObject1 = acfp.m(2131704452);
      if (!amxk.lo(this.fromType)) {
        break;
      }
    }
    for (this.description = (acfp.m(2131704474) + (String)localObject1);; this.description = ((String)localObject1))
    {
      if ((TextUtils.isEmpty(this.nickName)) || (this.nickName.equals(this.uin))) {
        this.nickName = aqgv.b(this.app, this.uin, true);
      }
      return;
      localObject1 = ((TroopManager)localObject1).b(((TroopManager)localObject1).jp(this.d.troopUin), this.d.uin);
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) {
          this.remark = ((TroopMemberInfo)localObject1).troopnick;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).autoremark)) {
          this.inteRemark = ((TroopMemberInfo)localObject1).autoremark;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).friendnick)) {
          this.nickName = ((TroopMemberInfo)localObject1).friendnick;
        }
      }
      localObject1 = acfp.m(2131704436);
      break;
      localObject1 = ((acdu)this.app.getManager(53)).n(this.d.troopUin);
      if (localObject1 != null)
      {
        localObject1 = (DiscussionMemberInfo)((Map)localObject1).get(this.d.uin);
        if (localObject1 != null)
        {
          localObject2 = ((DiscussionMemberInfo)localObject1).memberName;
          if (!TextUtils.isEmpty(((DiscussionMemberInfo)localObject1).inteRemark)) {
            this.inteRemark = ((DiscussionMemberInfo)localObject1).inteRemark;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.nickName = ((String)localObject2);
          }
        }
      }
      Object localObject2 = acfp.m(2131704459);
      localObject1 = localObject2;
      if (this.nickName == null) {
        break;
      }
      localObject1 = localObject2;
      if (!this.nickName.equals(this.d.uin)) {
        break;
      }
      this.nickName = aqgv.b(this.app, this.d.uin, true);
      localObject1 = localObject2;
      break;
      localObject1 = "wap临时会话";
      break;
      this.cbg = this.d.displayName;
      this.nickName = null;
      localObject1 = aqgv.x(this.app, this.d.uin);
      localObject2 = ((ajdo)this.app.getManager(11)).c(this.d.uin);
      if (localObject2 != null) {
        this.cbg = ((PhoneContact)localObject2).name;
      }
      for (;;)
      {
        localObject1 = acfp.m(2131704477);
        break;
        if (localObject1 != null) {
          this.cbg = aqgv.b(this.app, (String)localObject1, true);
        }
      }
      localObject1 = acfp.m(2131704471);
      break;
      localObject1 = acfp.m(2131704442);
      break;
      localObject1 = "QQ电影票临时会话";
      break;
    }
  }
  
  private void initTitle()
  {
    switch (this.dDi)
    {
    default: 
      return;
    case 2: 
      this.title = this.remark;
      this.subTitle = amxk.h(new String[] { this.nickName, this.uin });
      return;
    case 3: 
      this.title = this.inteRemark;
      this.subTitle = amxk.h(new String[] { this.nickName, this.uin });
      return;
    case 1: 
      this.title = amxk.h(new String[] { this.remark, this.inteRemark });
      if (!TextUtils.isEmpty(this.title))
      {
        this.subTitle = this.nickName;
        return;
      }
      this.title = this.nickName;
      this.subTitle = this.uin;
      return;
    case 4: 
      this.title = this.cbg;
      this.subTitle = this.uin;
      return;
    }
    this.title = amxk.h(new String[] { this.remark, this.inteRemark, this.nickName });
    this.subTitle = this.uin;
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
    return this.d.uin;
  }
  
  protected long au(String paramString)
  {
    this.keyword = paramString;
    this.ajT = -9223372036854775808L;
    long l = amxk.b(paramString, this.remark, amjz.aiT);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDi = 2;
    }
    l = amxk.b(paramString, this.inteRemark, amjz.aiX);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDi = 3;
    }
    l = amxk.b(paramString, this.nickName, amjz.aiY);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDi = 1;
    }
    l = amxk.b(paramString, this.cbg, amjz.aiZ);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDi = 4;
    }
    l = amxk.a(paramString, this.uin, amjz.ajb, false);
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
      QQAppInterface localQQAppInterface;
      String str2;
      String str3;
      if (!amkl.gM(this.d.uin)) {
        switch (this.d.getType())
        {
        default: 
          amxk.a(this.keyword, 20, 1, paramView);
          aclj.Q(this.app, this.keyword);
          localQQAppInterface = this.app;
          str2 = getTitle().toString();
          str3 = this.uin;
          if (this.d.troopUin != null) {
            break;
          }
        }
      }
      for (String str1 = "";; str1 = this.d.troopUin)
      {
        amxk.d(localQQAppInterface, str2, str3, str1, this.d.getType());
        amxk.a(this.keyword, 20, paramView, false);
        amxk.a(this, paramView);
        if (SearchConfigManager.needSeparate) {
          amxk.d("search", "contact", "contacts", 0, 0, new String[] { amxk.fc(this.fromType) });
        }
        if ((S() instanceof String)) {
          amxk.e(this.app, this.keyword, this.cbp, (String)S(), IU());
        }
        if ((paramView.getContext() instanceof UniteSearchActivity))
        {
          if ((this.cbp == null) || (TextUtils.isEmpty(this.cbp))) {
            break label419;
          }
          amub.a(null, 0, this.fromType, "0X8009D31", 1, 0, null, null);
        }
        return;
        aalb.bwg = true;
        aalb.a(paramView.getContext(), this.d.uin, this.d.troopUin, this.d.getType(), this.title, false);
        break;
        aalb.a(paramView.getContext(), this.app, this.d.uin, this.d.getType(), this.title, false);
        break;
        aprg.H(paramView.getContext(), null, this.d.uin);
        break;
      }
      label419:
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
    return this.description;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public String getUin()
  {
    return this.d.uin;
  }
  
  public int lk()
  {
    return this.d.getType();
  }
  
  public String nD()
  {
    return this.d.troopUin;
  }
  
  public int pG()
  {
    switch (this.d.getType())
    {
    case 1000: 
    case 1004: 
    case 1005: 
    default: 
      return 1;
    case 1006: 
      return 11;
    }
    return 32;
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
 * Qualified Name:     amoq
 * JD-Core Version:    0.7.0.1
 */