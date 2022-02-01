import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.util.LruCache;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.b;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class amop
  extends ampt
{
  private static LruCache<String, String> A = new LruCache(3);
  private long ajT;
  private long ajU = amjz.ajv;
  public ChnToSpell.b e;
  public PhoneContact f;
  public ChnToSpell.b f;
  private String keyword;
  
  public amop(QQAppInterface paramQQAppInterface, int paramInt, PhoneContact paramPhoneContact)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
    if (TextUtils.isEmpty(paramPhoneContact.uin)) {
      this.ajU = amjz.ajD;
    }
    if (!TextUtils.isEmpty(paramPhoneContact.name))
    {
      this.e = ChnToSpell.a(paramPhoneContact.name, 1);
      this.jdField_f_of_type_ComTencentMobileqqUtilsChnToSpell$b = ChnToSpell.a(paramPhoneContact.name, 2);
    }
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int IU()
  {
    return 4;
  }
  
  public Object S()
  {
    String str2 = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "mn:" + this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.equals("0"));
    return this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
  
  protected long au(String paramString)
  {
    this.keyword = paramString;
    this.ajT = -9223372036854775808L;
    long l = amxk.a(paramString, this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.name, this.e, this.jdField_f_of_type_ComTencentMobileqqUtilsChnToSpell$b, amjz.aiZ);
    if (l > this.ajT) {
      this.ajT = l;
    }
    String str2 = (String)A.get(paramString);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramString.replaceAll("-", "");
      A.put(paramString, str1);
    }
    l = amxk.a(str1, this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.mobileNo, amjz.ajc, true);
    if (l > this.ajT) {
      this.ajT = l;
    }
    l = amxk.a(paramString, this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.nickName, amjz.aiY, false);
    if (l > this.ajT) {
      this.ajT = l;
    }
    if (this.ajT != -9223372036854775808L) {
      this.ajT += this.ajU;
    }
    return this.ajT;
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    int j;
    int i;
    Object localObject1;
    if ((paramView.getId() == 2131377201) && (this.fromType == 17)) {
      if (!((ajdo)this.app.getManager(11)).Uv())
      {
        anot.a(this.app, "dc00898", "", "", "0X80077CD", "0X80077CD", 3, 0, "", "", "", "");
        anot.a(this.app, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
        j = 1;
        i = 3075;
        localObject1 = AddFriendLogicActivity.a(paramView.getContext(), 2, this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, null, i, j, this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.name, null, null, acfp.m(2131704475), null);
        paramView.getContext().startActivity((Intent)localObject1);
      }
    }
    for (;;)
    {
      if ((amxk.lo(this.fromType)) && ((S() instanceof String)) && (!this.cDS)) {
        amxk.e(this.app, this.keyword, this.cbp, (String)S(), IU());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.cbp == null) || (TextUtils.isEmpty(this.cbp))) {
          break label1173;
        }
        amub.a(null, 0, this.fromType, "0X8009D31", 1, 0, null, null);
      }
      return;
      anot.a(this.app, "dc00898", "", "", "0X80077D3", "0X80077D3", 3, 0, "", "", "", "");
      anot.a(this.app, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
      j = 13;
      i = 3006;
      break;
      Object localObject2;
      if (this.fromType == 17)
      {
        PhoneContact localPhoneContact = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact;
        localObject1 = (PhoneContactManagerImp)this.app.getManager(11);
        if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!"0".equals(localPhoneContact.uin)))
        {
          localObject2 = localPhoneContact.unifiedCode;
          localObject1 = new ProfileActivity.AllInOne((String)localObject2, 53);
          i = 56939;
        }
        for (;;)
        {
          ((ProfileActivity.AllInOne)localObject1).contactName = localPhoneContact.name;
          ((ProfileActivity.AllInOne)localObject1).nickname = localPhoneContact.name;
          ((ProfileActivity.AllInOne)localObject1).bJa = 103;
          ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject1);
          aclj.Q(this.app, this.keyword);
          amxk.d(this.app, getTitle().toString(), (String)localObject2, "", i);
          break;
          if ("0".equals(localPhoneContact.uin))
          {
            localObject2 = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
            if (((PhoneContactManagerImp)localObject1).Uv())
            {
              localObject1 = new ProfileActivity.AllInOne((String)localObject2, 53);
              i = 56941;
            }
            else
            {
              localObject1 = new ProfileActivity.AllInOne((String)localObject2, 29);
              i = 56940;
            }
          }
          else
          {
            localObject2 = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
            localObject1 = new ProfileActivity.AllInOne((String)localObject2, 53);
            i = 56942;
          }
        }
      }
      if (amxk.lo(this.fromType))
      {
        aalb.bwg = true;
        localObject1 = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin;
        i = 0;
        if (!((PhoneContactManagerImp)this.app.getManager(11)).Uv())
        {
          if ("0".equals(this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
            localObject2 = new ProfileActivity.AllInOne((String)localObject1, 29);
            ((ProfileActivity.AllInOne)localObject2).pr = new ArrayList();
            ((ProfileActivity.AllInOne)localObject2).contactName = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.name;
            ((ProfileActivity.AllInOne)localObject2).nickname = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.nickName;
            ((ProfileActivity.AllInOne)localObject2).bIW = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.ability;
            ((ProfileActivity.AllInOne)localObject2).bIZ = 3;
            ((ProfileActivity.AllInOne)localObject2).bJa = 103;
            ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
            aclj.Q(this.app, this.keyword);
            amxk.d(this.app, getTitle().toString(), (String)localObject1, "", 56940);
            return;
          }
          if (TextUtils.isEmpty(this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
            localObject2 = new ProfileActivity.AllInOne((String)localObject1, 53);
            ((ProfileActivity.AllInOne)localObject2).pr = new ArrayList();
            ((ProfileActivity.AllInOne)localObject2).contactName = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.name;
            ((ProfileActivity.AllInOne)localObject2).nickname = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.nickName;
            ((ProfileActivity.AllInOne)localObject2).bIW = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.ability;
            ((ProfileActivity.AllInOne)localObject2).bIZ = 3;
            ((ProfileActivity.AllInOne)localObject2).bJa = 103;
            ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
            aclj.Q(this.app, this.keyword);
            amxk.d(this.app, getTitle().toString(), (String)localObject1, "", 56942);
          }
        }
        else
        {
          if (TextUtils.isEmpty(this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
            localObject2 = new ProfileActivity.AllInOne((String)localObject1, 53);
            ((ProfileActivity.AllInOne)localObject2).pr = new ArrayList();
            ((ProfileActivity.AllInOne)localObject2).contactName = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.name;
            ((ProfileActivity.AllInOne)localObject2).nickname = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.nickName;
            ((ProfileActivity.AllInOne)localObject2).bIW = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.ability;
            ((ProfileActivity.AllInOne)localObject2).bIZ = 3;
            ((ProfileActivity.AllInOne)localObject2).bJa = 103;
            ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
            aclj.Q(this.app, this.keyword);
            amxk.d(this.app, getTitle().toString(), (String)localObject1, "", 56942);
            return;
          }
          if ("0".equals(this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
            i = 1006;
          }
        }
        aalb.a(paramView.getContext(), this.app, (String)localObject1, i, this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.name, false);
        amxk.a(this.keyword, 20, 1, paramView);
        aclj.Q(this.app, this.keyword);
        amxk.d(this.app, getTitle().toString(), (String)localObject1, "", i);
        amxk.a(this.keyword, 20, paramView, false);
        amxk.a(this, paramView);
        if (SearchConfigManager.needSeparate) {
          amxk.d("search", "contact", "contacts", 0, 0, new String[] { amxk.fc(this.fromType) });
        }
      }
      else
      {
        amxk.a(paramView, this);
      }
    }
    label1173:
    amub.a(null, 0, this.fromType, "0X8009D37", 0, 0, null, null);
  }
  
  public CharSequence f()
  {
    if (this.fromType == 17)
    {
      String str = zb();
      if (!TextUtils.isEmpty(str))
      {
        if ((!str.equals(this.cbx)) || (!TextUtils.equals(this.cbw, getKeyword())))
        {
          this.cbx = str;
          this.cbw = getKeyword();
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(acfp.m(2131704440));
          localSpannableStringBuilder.append(amxk.a(str, getKeyword(), 10));
          this.ao = localSpannableStringBuilder;
        }
        return this.ao;
      }
      this.cbx = null;
      return null;
    }
    return super.f();
  }
  
  public CharSequence g()
  {
    if ((this.fromType == 17) && (this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.samFriend > 0)) {
      return String.format(this.app.getApplication().getResources().getString(2131692075), new Object[] { Integer.valueOf(this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.samFriend) });
    }
    return null;
  }
  
  public CharSequence getDescription()
  {
    if (amxk.lo(this.fromType)) {
      return acfp.m(2131704434);
    }
    if ((this.fromType == 17) || (this.fromType == 19))
    {
      acff localacff = (acff)this.app.getManager(51);
      if ((!TextUtils.isEmpty(this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin)) && (!this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin.equalsIgnoreCase("0"))) {
        return acfp.m(2131704455);
      }
      if (localacff.w(this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, true)) {
        return acfp.m(2131704479);
      }
      return null;
    }
    return acfp.m(2131704472);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public String getUin()
  {
    String str2 = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.equals("0"));
    return this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
  
  public int lk()
  {
    if (TextUtils.isEmpty(this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin)) {
      return 56938;
    }
    if (this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0")) {
      return 1006;
    }
    return 0;
  }
  
  public int pG()
  {
    if ((TextUtils.isEmpty(this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin)) || (this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0"))) {
      return 11;
    }
    return 1;
  }
  
  public String za()
  {
    return this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.name;
  }
  
  public String zb()
  {
    if (this.fromType == 17) {
      return null;
    }
    return this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
  }
  
  public String zd()
  {
    return this.jdField_f_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amop
 * JD-Core Version:    0.7.0.1
 */