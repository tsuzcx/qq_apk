import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;

public class amom
  extends ampt
{
  protected long ajL;
  protected long ajW = amjz.ajI;
  protected int dDh;
  protected String mKeyword;
  protected String mMemberCard;
  protected String mMemberName;
  protected String mMemberUin;
  protected String mSubTitle;
  protected String mTitle;
  public String mTroopUin;
  protected TroopInfo troopInfo;
  
  public amom(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.mTroopUin = paramString1;
    this.mMemberUin = paramString2;
    this.mMemberCard = paramString3;
    this.mMemberName = paramString4;
    this.troopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).c(this.mTroopUin);
    if (this.troopInfo.isNewTroop()) {
      this.ajW = amjz.ajt;
    }
  }
  
  private void initTitle()
  {
    switch (this.dDh)
    {
    default: 
      this.mTitle = "";
      this.mSubTitle = null;
      return;
    case 0: 
      if (!TextUtils.isEmpty(this.mMemberCard))
      {
        this.mTitle = this.mMemberCard;
        this.mSubTitle = this.mMemberUin;
        return;
      }
      if (!TextUtils.isEmpty(this.mMemberName))
      {
        this.mTitle = this.mMemberName;
        this.mSubTitle = this.mMemberUin;
        return;
      }
      this.mTitle = this.mMemberUin;
      this.mSubTitle = null;
      return;
    case 2: 
      this.mTitle = this.mMemberCard;
      if (!TextUtils.isEmpty(this.mMemberName))
      {
        this.mSubTitle = this.mMemberName;
        return;
      }
      this.mSubTitle = this.mMemberUin;
      return;
    }
    if (!TextUtils.isEmpty(this.mMemberCard))
    {
      this.mTitle = this.mMemberCard;
      this.mSubTitle = this.mMemberName;
      return;
    }
    this.mTitle = this.mMemberName;
    this.mSubTitle = this.mMemberUin;
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
    return this.mMemberUin;
  }
  
  protected long au(String paramString)
  {
    this.mKeyword = paramString;
    this.ajL = -9223372036854775808L;
    boolean bool;
    if (this.troopInfo.isNewTroop())
    {
      bool = false;
      if (!this.troopInfo.isNewTroop()) {
        break label188;
      }
      l = amjz.aiV;
      label38:
      l = amxk.a(paramString, this.mMemberCard, l, false, false, bool);
      if (l > this.ajL)
      {
        this.ajL = l;
        this.dDh = 2;
      }
      if (!this.troopInfo.isNewTroop()) {
        break label195;
      }
    }
    label188:
    label195:
    for (long l = amjz.aiU;; l = amjz.aiY)
    {
      l = amxk.a(paramString, this.mMemberName, l, false, false, bool);
      if (l > this.ajL)
      {
        this.ajL = l;
        this.dDh = 1;
      }
      l = amxk.a(paramString, this.mMemberUin, amjz.ajb, false, true, true);
      if (l > this.ajL)
      {
        this.ajL = l;
        this.dDh = 0;
      }
      if (this.ajL != -9223372036854775808L)
      {
        this.ajL += this.ajW;
        initTitle();
      }
      return this.ajL;
      bool = true;
      break;
      l = amjz.ajd;
      break label38;
    }
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    String str2;
    Object localObject;
    if (amxk.lo(this.fromType))
    {
      aalb.bwg = true;
      str2 = ((TroopManager)this.app.getManager(52)).jr(this.mTroopUin);
      localObject = ((acff)this.app.getManager(51)).b(this.mMemberUin);
      if (amkl.gM(this.mMemberUin)) {
        break label391;
      }
      if ((localObject == null) || (!((Friends)localObject).isFriend())) {
        break label276;
      }
      aalb.a(paramView.getContext(), this.app, this.mMemberUin, 0, aqgv.c((Friends)localObject), false);
      amxk.d(this.app, aqgv.c((Friends)localObject), this.mMemberUin, "", 0);
    }
    for (;;)
    {
      aclj.Q(this.app, this.mKeyword);
      amxk.a(this.mKeyword, 20, 1, paramView);
      amxk.a(this.mKeyword, 20, paramView, false);
      amxk.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        amxk.d("search", "contact", "contacts", 0, 0, new String[] { amxk.fc(this.fromType) });
      }
      if (((S() instanceof String)) && (!this.cDS)) {
        amxk.e(this.app, this.mKeyword, this.cbp, (String)S(), IU());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.cbp == null) || (TextUtils.isEmpty(this.cbp))) {
          break;
        }
        amub.a(null, 0, this.fromType, "0X8009D31", 1, 0, null, null);
      }
      return;
      label276:
      aalb.a(paramView.getContext(), this.mMemberUin, str2, 1000, getTitle().toString(), false);
      String str1 = getTitle().toString();
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "saveSearchHistory title is null");
        }
        str1 = za();
        localObject = str1;
        if (TextUtils.isEmpty(str1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveSearchHistory titlestr is null");
          }
          localObject = zb();
        }
      }
      amxk.d(this.app, (String)localObject, this.mMemberUin, str2, 1000);
      continue;
      label391:
      aprg.H(paramView.getContext(), null, this.mMemberUin);
      amxk.d(this.app, getTitle().toString(), this.mMemberUin, str2, 1000);
    }
    amub.a(null, 0, this.fromType, "0X8009D37", 0, 0, null, null);
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    String str = aqgv.a(this.app, this.mTroopUin, true);
    if (str != null) {
      return acfp.m(2131704430) + str;
    }
    return acfp.m(2131704422);
  }
  
  public String getKeyword()
  {
    return this.mKeyword;
  }
  
  public String getUin()
  {
    return this.mMemberUin;
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
    return this.mTitle;
  }
  
  public String zb()
  {
    return this.mSubTitle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amom
 * JD-Core Version:    0.7.0.1
 */