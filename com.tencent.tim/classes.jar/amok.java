import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.b;
import com.tencent.mobileqq.utils.ChnToSpell.c;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class amok
  extends ampt
{
  private Friends a;
  public ChnToSpell.b a;
  public ChnToSpell.c a;
  private long ajT;
  private long ajU = amjz.ajr;
  public ChnToSpell.b b;
  public ChnToSpell.c b;
  public ChnToSpell.b c;
  public ChnToSpell.b d;
  private int dDe;
  private String groupName;
  private String keyword;
  private String subTitle;
  private String title;
  
  public amok(QQAppInterface paramQQAppInterface, int paramInt, Friends paramFriends, String paramString, long paramLong)
  {
    super(paramQQAppInterface, paramInt, paramLong);
    this.groupName = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    if (paramQQAppInterface.a().a().gO(paramFriends.uin)) {
      this.ajU = amjz.ajm;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramFriends.remark))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$c = ChnToSpell.a(paramFriends.remark);
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$c != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$b = this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$c.a();
          this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$b = this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$c.b();
        }
      }
      if (!TextUtils.isEmpty(paramFriends.name))
      {
        this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$c = ChnToSpell.a(paramFriends.name);
        if (this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$c != null)
        {
          this.c = this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$c.a();
          this.d = this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$c.b();
        }
      }
      return;
      if (paramFriends.gathtertype == 1) {
        this.ajU = amjz.ajs;
      } else if (asgx.mS(paramFriends.cSpecialFlag)) {
        this.ajU = amjz.ajJ;
      } else if (((acff)paramQQAppInterface.getManager(51)).a(paramFriends.uin) != null) {
        this.ajU = amjz.ajq;
      }
    }
  }
  
  private void initTitle()
  {
    switch (this.dDe)
    {
    default: 
      this.title = "";
      return;
    case 0: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark))
      {
        this.title = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
        this.subTitle = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))
      {
        this.title = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        this.subTitle = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
        return;
      }
      this.title = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      this.subTitle = null;
      return;
    case 2: 
      this.title = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      this.subTitle = amxk.h(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin });
      return;
    case 1: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark))
      {
        this.title = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
        this.subTitle = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        return;
      }
      this.title = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
      this.subTitle = amxk.h(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin });
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark))
    {
      this.title = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      this.subTitle = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))
    {
      this.title = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
      this.subTitle = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
      return;
    }
    this.title = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    this.subTitle = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public boolean DR()
  {
    return (this.fromType == 21) || (this.fromType == 1) || (this.fromType == 2);
  }
  
  public int IU()
  {
    return 1;
  }
  
  public Object S()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public amxi a(String paramString)
  {
    this.keyword = paramString;
    Object localObject1 = ChnToSpell.a(paramString);
    amxi localamxi = amxk.a(paramString, (ChnToSpell.c)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$c, amjz.aiT);
    localObject1 = amxk.a(paramString, (ChnToSpell.c)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$c, amjz.aiT);
    if ((localamxi != null) && (localamxi.isMatched)) {
      if ((localObject1 != null) && (((amxi)localObject1).isMatched) && (((amxi)localObject1).dDS > localamxi.dDS))
      {
        this.dDe = 1;
        localObject2 = localObject1;
        if (localObject1 == null) {
          this.dDe = 2;
        }
      }
    }
    for (Object localObject2 = localamxi;; localObject2 = null)
    {
      if ((localObject2 != null) && (((amxi)localObject2).isMatched))
      {
        this.cDS = true;
        this.a = ((amxi)localObject2);
        initTitle();
        return localObject2;
      }
      return super.a(paramString);
      localObject1 = null;
      break;
    }
  }
  
  protected long au(String paramString)
  {
    this.keyword = paramString;
    this.ajT = -9223372036854775808L;
    long l = amxk.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$b, this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$b, amjz.aiT);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDe = 2;
    }
    l = amxk.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.c, this.d, amjz.aiY);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDe = 1;
    }
    l = amxk.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, amjz.aja, false);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDe = 3;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.strMasterUin)) {}
    for (l = amxk.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.strMasterUin, amjz.ajb, false);; l = amxk.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, amjz.ajb, false))
    {
      if (l > this.ajT)
      {
        this.ajT = l;
        this.dDe = 0;
      }
      if (this.ajT != -9223372036854775808L)
      {
        this.ajT += this.ajU;
        initTitle();
      }
      return this.ajT;
    }
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    Object localObject;
    if (amxk.lo(this.fromType))
    {
      aalb.bwg = true;
      aalb.a(paramView.getContext(), this.app, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 0, aqgv.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends), false);
      amxk.a(this.keyword, 20, 1, paramView);
      aclj.Q(this.app, this.keyword);
      String str = getTitle().toString();
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "saveSearchHistory title is null");
        }
        str = za();
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveSearchHistory titlestr is null");
          }
          localObject = zb();
        }
      }
      amxk.d(this.app, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, "", 0);
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
    if (11 == this.fromType)
    {
      localObject = (BaseActivity)paramView.getContext();
      if (((acff)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin) != null)
      {
        QQToast.a((Context)localObject, ((BaseActivity)localObject).getString(2131701720), 0).show(((BaseActivity)localObject).getTitleBarHeight());
        return;
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
    if (amxk.lo(this.fromType)) {
      return acfp.m(2131704447) + this.groupName;
    }
    return this.groupName;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public String getUin()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public int lk()
  {
    return 0;
  }
  
  public int pG()
  {
    return 1;
  }
  
  public Pair<CharSequence, CharSequence> s()
  {
    switch (this.dDe)
    {
    default: 
      return null;
    case 0: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, amxk.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.keyword, 6, false));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, amxk.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.keyword, 6, false));
      }
      return new Pair(amxk.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.keyword, 6, false), null);
    case 2: 
      return new Pair(amxk.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.keyword, 6, true), null);
    case 1: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, amxk.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.keyword, 6, true));
      }
      return new Pair(amxk.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.keyword, 6, true), null);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
      return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, amxk.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.keyword, 6, true));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name)) {
      return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, amxk.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.keyword, 6, true));
    }
    return new Pair(amxk.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.keyword, 6, true), null);
  }
  
  public int sZ()
  {
    return this.fromType;
  }
  
  public CharSequence y()
  {
    Object localObject = getTitle();
    CharSequence localCharSequence = f();
    switch (this.dDe)
    {
    }
    do
    {
      localObject = super.y();
      SpannableStringBuilder localSpannableStringBuilder;
      do
      {
        return localObject;
        localSpannableStringBuilder = new SpannableStringBuilder();
        if (localObject != null) {
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
        localObject = localSpannableStringBuilder;
      } while (localCharSequence == null);
      localSpannableStringBuilder.append(localCharSequence);
      return localSpannableStringBuilder;
      return localObject;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
        return localObject;
      }
    } while ((localCharSequence == null) || (localCharSequence.length() <= 2));
    return localCharSequence.subSequence(1, localCharSequence.length() - 1);
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
 * Qualified Name:     amok
 * JD-Core Version:    0.7.0.1
 */