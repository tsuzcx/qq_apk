import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class amor
  extends ampt
{
  private long ajT;
  private long ajU = amjz.ajy;
  private String cbh;
  private String cbi;
  private String keyword;
  private String title;
  private String uin;
  private int uinType;
  
  public amor(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    super(paramQQAppInterface, paramInt1, paramLong);
    this.uin = paramString;
    this.uinType = paramInt2;
    initTitle();
  }
  
  private void initTitle()
  {
    switch (this.uinType)
    {
    default: 
    case 6000: 
    case 9002: 
    case 5000: 
    case 7120: 
    case 7210: 
    case 7230: 
    case 1001: 
    case 10002: 
    case 7000: 
      do
      {
        for (;;)
        {
          if (!TextUtils.isEmpty(this.title))
          {
            this.cbh = ChnToSpell.aJ(this.title, 1).toLowerCase();
            this.cbi = ChnToSpell.aJ(this.title, 2).toLowerCase();
          }
          return;
          this.title = BaseApplicationImpl.sApplication.getString(2131695446);
          continue;
          this.title = BaseApplicationImpl.sApplication.getString(2131689680);
          continue;
          this.title = BaseApplicationImpl.sApplication.getString(2131721297);
          continue;
          this.title = BaseApplicationImpl.sApplication.getString(2131692998);
          continue;
          this.title = obt.a(this.app, BaseApplicationImpl.getContext());
          continue;
          this.title = nyn.d(this.app);
          continue;
          this.title = BaseApplicationImpl.sApplication.getString(2131694588);
          continue;
          this.title = BaseApplicationImpl.sApplication.getString(2131694590);
        }
        this.title = BaseApplicationImpl.sApplication.getString(2131720509);
      } while (acbn.bku.equals(this.uin));
      localObject1 = (acff)this.app.getManager(51);
      if (localObject1 == null) {
        break;
      }
    }
    for (Object localObject1 = ((acff)localObject1).e(this.uin);; localObject1 = null)
    {
      if ((localObject1 != null) && (((Friends)localObject1).name != null)) {}
      for (Object localObject2 = ((Friends)localObject1).name;; localObject2 = this.uin)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals(this.uin)) {}
        }
        else
        {
          String str = aqgv.c(this.app, this.uin, true);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = str;
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.uin;
        }
        this.title = (this.title + "(" + (String)localObject2 + ")");
        break;
      }
      this.title = BaseApplicationImpl.sApplication.getString(2131692100);
      break;
      this.title = BaseApplicationImpl.sApplication.getString(2131690931);
      break;
      this.title = BaseApplicationImpl.sApplication.getString(2131696301);
      break;
      if (!TextUtils.equals(this.uin, acbn.blw)) {
        break;
      }
      this.title = obt.b(this.app, BaseApplicationImpl.getContext());
      break;
      this.title = obt.c(this.app, BaseApplicationImpl.getContext());
      break;
    }
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int IU()
  {
    return 5;
  }
  
  public Object S()
  {
    return "tool:" + this.uin;
  }
  
  protected long au(String paramString)
  {
    this.keyword = paramString;
    this.ajT = -9223372036854775808L;
    long l = amxk.b(paramString, this.title, amjz.aiY);
    if (l > this.ajT) {
      this.ajT = l;
    }
    if ((this.uinType == 7220) || ((this.uinType == 1008) && (TextUtils.equals(this.uin, acbn.blw))))
    {
      l = amxk.b(paramString, acfp.m(2131695158), amjz.aiY);
      if (l > this.ajT) {
        this.ajT = l;
      }
    }
    if ((awit.cA(this.app)) && (this.uinType == 7220))
    {
      l = amxk.b(paramString, String.format(BaseApplicationImpl.sApplication.getString(2131701893), new Object[] { obt.a(this.app, this.app.getApplication().getApplicationContext()), obt.c(this.app, this.app.getApplication().getApplicationContext()), obt.c(this.app, this.app.getApplication().getApplicationContext()) }), amjz.ajc);
      if (l > this.ajT) {
        this.ajT = l;
      }
    }
    if (this.uinType == 9002)
    {
      l = amxk.b(paramString, BaseApplicationImpl.sApplication.getString(2131690054), amjz.ajc);
      if (l > this.ajT) {
        this.ajT = l;
      }
    }
    if (this.ajT != -9223372036854775808L)
    {
      this.ajT += amjz.ajA;
      if ((acbn.blb.equals(getUin())) && ((acfp.m(2131704457).equals(paramString)) || (acfp.m(2131704464).equals(paramString)) || (acfp.m(2131704439).equals(paramString)))) {
        this.ajT = (amjz.ajk + 1L);
      }
    }
    return this.ajT;
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    if (amxk.lo(this.fromType))
    {
      switch (this.uinType)
      {
      }
      for (;;)
      {
        aclj.Q(this.app, this.keyword);
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(this.uin);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            Object localObject;
            kdm localkdm;
            int j;
            int i;
            localNumberFormatException.printStackTrace();
          }
        }
        amxk.a(this.keyword, 20, (int)l1, paramView);
        return;
        localObject = new Intent(paramView.getContext(), LiteActivity.class);
        ((Intent)localObject).putExtra("targetUin", acbn.bkw);
        aalb.bwg = true;
        aalb.cT((Intent)localObject);
        paramView.getContext().startActivity((Intent)localObject);
        continue;
        localObject = new Intent(paramView.getContext(), ActivateFriendActivity.class);
        ((Intent)localObject).putExtra("af_key_from", 5);
        paramView.getContext().startActivity((Intent)localObject);
        if ((this.fromType == 2) || (this.fromType == 1))
        {
          anot.a(this.app, "CliOper", "", "", "0X8006477", "0X8006477", this.fromType, 0, "", "", "", "");
          continue;
          localObject = new Intent(paramView.getContext(), EcshopWebActivity.class);
          ((Intent)localObject).putExtra("from_search", true);
          ((Intent)localObject).setFlags(67108864);
          localkdm = (kdm)this.app.getManager(88);
          if (localkdm != null) {
            localkdm.a((Intent)localObject, paramView.getContext(), -1);
          }
          paramView.getContext().startActivity((Intent)localObject);
          anot.a(this.app, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Clk_Searchshopfolder", 0, 0, "", "", "", "");
          continue;
          localObject = oan.a();
          ((oan)localObject).j(this.app, false);
          ((oan)localObject).i(this.app, false);
          if (awit.cA(this.app)) {}
          for (localObject = kgw.a(paramView.getContext(), 0, 1);; localObject = kgw.a(paramView.getContext(), -1, 1))
          {
            ((Intent)localObject).putExtra("come_from", 1);
            ((Intent)localObject).setFlags(67108864);
            paramView.getContext().startActivity((Intent)localObject);
            break;
          }
          rzd.a(paramView.getContext(), 9005, null);
          if (QLog.isColorLevel())
          {
            QLog.d("ContactSearchModelTool", 2, "enterServiceAccountFolderActivityFromSearch");
            continue;
            MsgBoxListActivity.g(paramView.getContext(), 1001, String.valueOf(9999L));
            continue;
            localObject = new Intent(paramView.getContext(), TroopAssistantActivity.class);
            ((Intent)localObject).setFlags(67108864);
            paramView.getContext().startActivity((Intent)localObject);
            continue;
            anxj.j(this.app, paramView.getContext(), this.uin);
            this.app.b().ca(this.uin, this.uinType);
            continue;
            localObject = new Intent();
            ((Intent)localObject).putExtra("key_tab_mode", 2);
            ((Intent)localObject).setClass(paramView.getContext(), TroopActivity.class);
            j = anze.a().af(this.app);
            i = j;
            if (j <= 0) {
              i = ackn.F(this.app);
            }
            this.app.a().G(acbn.bkT, 9000, -i);
            paramView.getContext().startActivity((Intent)localObject);
            continue;
            ((ylm)this.app.getManager(138)).dq(paramView.getContext());
            continue;
            NewFriendActivity.g(paramView.getContext(), null, 0);
            continue;
            if (TextUtils.equals(this.uin, acbn.blw))
            {
              kbp.a(null, "CliOper", "", "", "0X800671A", "0X800671A", 0, 0, "", "", "", "", false);
              kgw.a(paramView.getContext(), null, -1L, 1);
              ocp.k(this.app, true);
              amxk.d(this.app, getTitle().toString(), this.uin, "", this.uinType);
              continue;
              kgw.b(this.app, paramView.getContext(), 1, 0);
              kbp.a(null, "CliOper", "", "", "0X800671A", "0X800671A", 0, 0, "", "", "", "", false);
              ocp.k(this.app, true);
              amxk.d(this.app, getTitle().toString(), this.uin, "", this.uinType);
            }
          }
        }
      }
    }
    amxk.a(paramView, this);
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    switch (this.uinType)
    {
    default: 
      return null;
    case 9002: 
      return amxk.a(BaseApplicationImpl.sApplication.getString(2131690054), this.keyword, 255);
    }
    return amxk.a(String.format(BaseApplicationImpl.sApplication.getString(2131701893), new Object[] { obt.a(this.app, this.app.getApplication().getApplicationContext()), obt.c(this.app, this.app.getApplication().getApplicationContext()), obt.c(this.app, this.app.getApplication().getApplicationContext()) }), this.keyword, 255);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public int lk()
  {
    return this.uinType;
  }
  
  public int pG()
  {
    return ((Integer)aajx.a(this.app, this.uinType, this.uin).first).intValue();
  }
  
  public String za()
  {
    return this.title;
  }
  
  public String zb()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amor
 * JD-Core Version:    0.7.0.1
 */