import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.activity.profile.ProfileModel.4;
import com.tencent.tim.activity.profile.ProfileModel.7;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class atbj
{
  ArrayList<aldd> DT = new ArrayList();
  accn jdField_a_of_type_Accn = new atbk(this);
  atbj.b jdField_a_of_type_Atbj$b = null;
  boolean aWP = false;
  private boolean aWu;
  protected acnd b = new atbl(this);
  int bHb = 0;
  public alcn c;
  CardHandler c;
  Handler.Callback d = new atbm(this);
  boolean dha = false;
  auru f;
  public QQAppInterface mApp = null;
  boolean mHasInit = false;
  
  public atbj()
  {
    this.jdField_c_of_type_Alcn = new alcn();
  }
  
  private void Vl(boolean paramBoolean)
  {
    ThreadManager.post(new ProfileModel.7(this, paramBoolean), 8, null, true);
  }
  
  @Nullable
  private QQAppInterface a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof QQAppInterface))) {
        return (QQAppInterface)paramQQAppInterface;
      }
      return null;
    }
    return paramQQAppInterface;
  }
  
  private void bOB()
  {
    if ((this.jdField_c_of_type_Alcn == null) || (!this.jdField_c_of_type_Alcn.cwc) || (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(this.jdField_c_of_type_Alcn.d.uin);
          Object localObject = (TroopManager)this.mApp.getManager(52);
          acms localacms = (acms)this.mApp.getBusinessHandler(20);
          localObject = ((TroopManager)localObject).b(this.jdField_c_of_type_Alcn.troopUin);
          c((TroopInfo)localObject);
          if (localObject != null)
          {
            localacms.b(this.jdField_c_of_type_Alcn.troopUin, ((TroopInfo)localObject).troopcode, localArrayList);
            localacms.ac(Long.parseLong(this.jdField_c_of_type_Alcn.troopUin), Long.parseLong(this.jdField_c_of_type_Alcn.d.uin));
            if (!TroopInfo.isQidianPrivateTroop(this.mApp, this.jdField_c_of_type_Alcn.troopUin))
            {
              localacms.hU(Long.parseLong(this.jdField_c_of_type_Alcn.d.uin));
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("ProfileModel", 2, "loadTroopMemberCard:" + localException.toString());
  }
  
  private void bOo()
  {
    if (!this.mHasInit)
    {
      if (this.f != null)
      {
        Message localMessage = null;
        if (ProfileActivity.AllInOne.g(this.jdField_c_of_type_Alcn.e))
        {
          localMessage = this.f.obtainMessage();
          localMessage.what = 1;
          localMessage.obj = this.jdField_c_of_type_Alcn.e.uin;
        }
        if (localMessage != null) {
          this.f.sendMessage(localMessage);
        }
      }
      this.mHasInit = true;
    }
  }
  
  private void cO(ArrayList<aldd> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.DT.clear();
      this.DT.addAll(paramArrayList);
      h(1001, true, "");
    }
  }
  
  private boolean cu(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_c_of_type_Alcn.e.pa == 90)
    {
      acff localacff = (acff)paramQQAppInterface.getManager(51);
      if ((localacff == null) || (!localacff.isFriend(this.jdField_c_of_type_Alcn.e.uin))) {
        break label164;
      }
    }
    for (this.jdField_c_of_type_Alcn.e.pa = 1;; this.jdField_c_of_type_Alcn.e.pa = 19)
    {
      if ((this.jdField_c_of_type_Alcn.e.bJa == 100) && (this.jdField_c_of_type_Alcn.e.pa == 34) && (!((ajdo)paramQQAppInterface.getManager(11)).Uv())) {
        this.jdField_c_of_type_Alcn.e.pa = 29;
      }
      try
      {
        if ((this.jdField_c_of_type_Alcn.e.pa != 53) && (paramQQAppInterface.getCurrentAccountUin().equals(this.jdField_c_of_type_Alcn.e.uin))) {
          this.jdField_c_of_type_Alcn.e.pa = 0;
        }
        return false;
      }
      catch (Exception paramQQAppInterface)
      {
        label164:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.profilecard.FrdProfileCard", 2, "", paramQQAppInterface);
        notifyEvent(1);
      }
    }
    return true;
  }
  
  private void esW()
  {
    if ((!this.jdField_c_of_type_Alcn.cwc) && (this.mApp != null)) {
      cO(((adyp)this.mApp.getManager(112)).cN());
    }
  }
  
  private void g(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Atbj$b != null) {
      this.jdField_a_of_type_Atbj$b.M(paramInt, paramObject);
    }
  }
  
  private void h(int paramInt, boolean paramBoolean, String paramString)
  {
    atbj.a locala = new atbj.a();
    atbj.a.a(locala, paramInt);
    atbj.a.a(locala, paramBoolean);
    atbj.a.a(locala, paramString);
    if (this.jdField_a_of_type_Atbj$b != null) {
      this.jdField_a_of_type_Atbj$b.a(locala);
    }
  }
  
  private void l(Card paramCard)
  {
    if (paramCard == null)
    {
      QLog.e("ProfileModel", 1, "refreshDetailInfo failed card is null");
      return;
    }
    if (this.jdField_c_of_type_Alcn.d == null)
    {
      this.jdField_c_of_type_Alcn.d = paramCard;
      return;
    }
    if (!this.jdField_c_of_type_Alcn.d.uin.equalsIgnoreCase(paramCard.uin))
    {
      QLog.e("ProfileModel", 2, "refreshDetailInfo failed  card.uin not equal");
      return;
    }
    this.jdField_c_of_type_Alcn.d = paramCard;
    h(1000, true, "");
  }
  
  private void notifyEvent(int paramInt)
  {
    g(paramInt, null);
  }
  
  private void parseIntent(Intent paramIntent)
  {
    Object localObject2 = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    boolean bool = paramIntent.hasExtra("troopUin");
    Object localObject1 = localObject2;
    if (bool)
    {
      this.jdField_c_of_type_Alcn.troopUin = paramIntent.getStringExtra("troopUin");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramIntent.getStringExtra("memberUin");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label212;
        }
        localObject1 = this.jdField_c_of_type_Alcn.e.uin;
      }
    }
    label212:
    for (;;)
    {
      localObject2 = ((acff)this.mApp.getManager(51)).c((String)localObject1);
      if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
        ((ProfileActivity.AllInOne)localObject1).nickname = ((Friends)localObject2).name;
        ((ProfileActivity.AllInOne)localObject1).remark = ((Friends)localObject2).remark;
      }
      for (;;)
      {
        this.jdField_c_of_type_Alcn.c = new TroopMemberCard();
        this.jdField_c_of_type_Alcn.drN = paramIntent.getIntExtra("fromFlag", -1);
        if (this.jdField_c_of_type_Alcn.drN == 8) {}
        this.jdField_c_of_type_Alcn.cwc = bool;
        this.jdField_c_of_type_Alcn.e = ((ProfileActivity.AllInOne)localObject1);
        return;
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 21);
        ((ProfileActivity.AllInOne)localObject1).subSourceId = 11;
      }
    }
  }
  
  public String EA()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getHometownDesc failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strHometownDesc;
  }
  
  public String EB()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getSchool failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strSchool;
  }
  
  public String EC()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getCompany failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strCompany;
  }
  
  public String ED()
  {
    if (!this.mHasInit) {
      QLog.e("ProfileModel", 2, "getTroopMemberCard failed mHasInit is false");
    }
    while ((!this.jdField_c_of_type_Alcn.cwc) || (this.mApp == null)) {
      return null;
    }
    return aqgv.r(this.mApp, this.jdField_c_of_type_Alcn.troopUin, this.jdField_c_of_type_Alcn.d.uin);
  }
  
  public String EE()
  {
    if (!aIY()) {}
    while (!this.dha) {
      return null;
    }
    return this.jdField_c_of_type_Alcn.bVm;
  }
  
  public String EF()
  {
    if (!this.mHasInit) {
      QLog.e("ProfileModel", 2, "getReMark failed mHasInit is false");
    }
    Object localObject;
    do
    {
      return null;
      localObject = this.jdField_c_of_type_Alcn.d.strReMark;
      if (((localObject != null) && (((String)localObject).length() > 0)) || (this.jdField_c_of_type_Alcn.e.pa != 30)) {
        break;
      }
      localObject = a();
    } while (localObject == null);
    return ((ProfileActivity.CardContactInfo)localObject).aOL;
    return localObject;
  }
  
  public String Ey()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getLocationDesc failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strLocationDesc;
  }
  
  public String Ez()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getHometown failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strHometownCodes;
  }
  
  public boolean I(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (!paramBundle.isEmpty())
      {
        this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.cg(paramBundle);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int Oc()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getProfession failed mHasInit is false");
      return -1;
    }
    return this.jdField_c_of_type_Alcn.d.iProfession;
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_c_of_type_Alcn.e != null)
    {
      localObject1 = localObject2;
      if (this.jdField_c_of_type_Alcn.e.pr != null)
      {
        localObject1 = localObject2;
        if (this.jdField_c_of_type_Alcn.e.pr.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_c_of_type_Alcn.e.pr.get(0);
        }
      }
    }
    return localObject1;
  }
  
  void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "requestUpdateCard() mHasTriedCount = " + this.bHb);
    }
    if ((this.bHb > 5) && (!paramBoolean)) {}
    while ((this.jdField_c_of_type_ComTencentMobileqqAppCardHandler == null) || (this.mApp == null)) {
      return;
    }
    this.bHb += 1;
    byte[] arrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      arrayOfByte1 = new byte[1];
      arrayOfByte1[0] = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      if (paramArrayOfByte2 == null)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      for (;;)
      {
        int i = 12;
        byte b1 = 0;
        paramArrayOfByte1 = (adyp)this.mApp.getManager(112);
        if (paramArrayOfByte1 != null) {}
        for (paramBoolean = paramArrayOfByte1.iX(1);; paramBoolean = false)
        {
          long l3 = FriendProfileCardActivity.a(this.jdField_c_of_type_Alcn.e, paramBoolean);
          long l2;
          long l1;
          String str;
          label2587:
          label2595:
          switch (this.jdField_c_of_type_Alcn.e.pa)
          {
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 29: 
          case 30: 
          case 31: 
          case 32: 
          case 33: 
          case 34: 
          case 36: 
          case 38: 
          case 39: 
          case 43: 
          case 44: 
          case 48: 
          case 49: 
          case 50: 
          case 51: 
          case 53: 
          case 54: 
          case 59: 
          case 62: 
          case 63: 
          case 64: 
          case 65: 
          case 66: 
          case 67: 
          case 68: 
          case 69: 
          case 76: 
          case 79: 
          case 80: 
          case 85: 
          case 87: 
          case 88: 
          case 89: 
          case 90: 
          case 91: 
          case 92: 
          case 93: 
          case 94: 
          case 97: 
          case 98: 
          case 99: 
          case 100: 
          case 106: 
          case 109: 
          case 114: 
          case 116: 
          case 117: 
          case 118: 
          case 119: 
          default: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 65535, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3999, arrayOfByte2, (byte)0);
            return;
          case 0: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 60: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 1: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 78: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 24, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 3022, arrayOfByte2, (byte)0);
            return;
          case 40: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 41: 
            i = 6;
            paramArrayOfByte1 = "";
            if ((TextUtils.isEmpty(this.jdField_c_of_type_Alcn.e.uin)) || (this.jdField_c_of_type_Alcn.e.uin.equals("0")))
            {
              i = 37;
              paramArrayOfByte1 = this.jdField_c_of_type_Alcn.e.encId;
            }
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, i, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 42: 
          case 73: 
          case 86: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 45: 
          case 46: 
          case 47: 
            if (this.jdField_c_of_type_Alcn.e.discussUin == null) {
              break;
            }
            l2 = 0L;
            try
            {
              l1 = Long.valueOf(this.jdField_c_of_type_Alcn.e.discussUin).longValue();
              int j = 0;
              if (this.jdField_c_of_type_Alcn.e.pa == 45)
              {
                i = 13;
                j = 1;
                paramArrayOfByte1 = this.jdField_c_of_type_ComTencentMobileqqAppCardHandler;
                paramArrayOfByte2 = this.mApp.getCurrentAccountUin();
                str = this.jdField_c_of_type_Alcn.e.uin;
                if (j != 1) {
                  break label1239;
                }
                paramArrayOfByte1.a(paramArrayOfByte2, str, i, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
              }
            }
            catch (Exception paramArrayOfByte1)
            {
              for (;;)
              {
                l1 = l2;
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                  l1 = l2;
                  continue;
                  if (this.jdField_c_of_type_Alcn.e.pa == 46) {
                    i = 4;
                  } else {
                    i = 14;
                  }
                }
              }
            }
          case 20: 
          case 21: 
          case 22: 
          case 58: 
            l1 = aqep.a(this.mApp, this.jdField_c_of_type_Alcn.e);
            if (this.jdField_c_of_type_Alcn.e.pa == 20)
            {
              i = 2;
              b1 = 1;
              paramArrayOfByte1 = this.jdField_c_of_type_ComTencentMobileqqAppCardHandler;
              paramArrayOfByte2 = this.mApp.getCurrentAccountUin();
              str = this.jdField_c_of_type_Alcn.e.uin;
              if (b1 != 1) {
                break label1405;
              }
            }
            for (;;)
            {
              paramArrayOfByte1.a(paramArrayOfByte2, str, i, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
              return;
              if ((this.jdField_c_of_type_Alcn.e.pa == 21) || (this.jdField_c_of_type_Alcn.e.pa == 58))
              {
                i = 5;
                b1 = 0;
                break;
              }
              if (this.jdField_c_of_type_Alcn.e.pa != 22) {
                break;
              }
              i = 7;
              b1 = 0;
              break;
            }
          case 3: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 2: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 74: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 35: 
          case 37: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2, (byte)0);
            return;
          case 75: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2, (byte)0);
            return;
          case 61: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 70: 
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 25: 
          case 26: 
          case 27: 
          case 28: 
          case 108: 
            if ((this.jdField_c_of_type_Alcn.e.bJb == 3004) || (this.jdField_c_of_type_Alcn.e.bJb == 2004)) {
              if (TextUtils.isEmpty(this.jdField_c_of_type_Alcn.e.troopcode)) {}
            }
          case 4: 
          case 77: 
          case 95: 
          case 52: 
          case 19: 
          case 23: 
          case 24: 
          case 104: 
          case 105: 
          case 111: 
          case 120: 
          case 55: 
          case 56: 
          case 57: 
          case 72: 
          case 71: 
          case 81: 
          case 82: 
          case 83: 
          case 84: 
          case 101: 
          case 102: 
          case 103: 
          case 107: 
          case 110: 
          case 96: 
          case 112: 
          case 113: 
          case 115: 
            label1239:
            label1405:
            for (paramArrayOfByte1 = this.jdField_c_of_type_Alcn.e.troopcode;; paramArrayOfByte1 = "0")
            {
              paramArrayOfByte2 = paramArrayOfByte1;
              if (paramArrayOfByte1 == null) {}
              for (paramArrayOfByte2 = "0";; paramArrayOfByte2 = "0")
              {
                for (;;)
                {
                  l2 = 0L;
                  try
                  {
                    l1 = Long.parseLong(paramArrayOfByte2);
                    i = 11;
                    if (this.jdField_c_of_type_Alcn.e.pa == 27) {
                      i = 35;
                    }
                    this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, i, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_c_of_type_Alcn.e.bJb, arrayOfByte2, (byte)0);
                    return;
                    if (TextUtils.isEmpty(this.jdField_c_of_type_Alcn.e.troopUin)) {
                      break label2595;
                    }
                    paramArrayOfByte1 = (TroopInfo)this.mApp.a().createEntityManager().find(TroopInfo.class, "troopcode=?", new String[] { this.jdField_c_of_type_Alcn.e.troopUin });
                    if (paramArrayOfByte1 == null) {
                      break label2595;
                    }
                    paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                    break;
                    if ((this.jdField_c_of_type_Alcn.e.bJb != 3005) && (this.jdField_c_of_type_Alcn.e.bJb != 2005)) {
                      break label2587;
                    }
                    paramArrayOfByte2 = this.jdField_c_of_type_Alcn.e.troopcode;
                  }
                  catch (Exception paramArrayOfByte1)
                  {
                    for (;;)
                    {
                      l1 = l2;
                      if (QLog.isColorLevel())
                      {
                        QLog.e("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                        l1 = l2;
                      }
                    }
                  }
                }
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 34, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 33, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3045, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 53, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3094, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(this.mApp.getCurrentAccountUin(), this.jdField_c_of_type_Alcn.e.uin, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3080, arrayOfByte2, (byte)0);
                return;
              }
            }
          }
        }
        arrayOfByte2 = paramArrayOfByte2;
      }
      arrayOfByte1 = paramArrayOfByte1;
    }
  }
  
  public void a(atbj.b paramb)
  {
    this.jdField_a_of_type_Atbj$b = paramb;
  }
  
  /* Error */
  protected void a(Card paramCard, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +277 -> 280
    //   6: aload_0
    //   7: getfield 56	atbj:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: ifnull +270 -> 280
    //   13: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +53 -> 69
    //   19: ldc_w 310
    //   22: iconst_2
    //   23: new 222	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 570
    //   33: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload_2
    //   37: invokevirtual 573	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: ldc_w 575
    //   43: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_3
    //   47: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc_w 577
    //   53: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokevirtual 580	com/tencent/mobileqq/data/Card:getProfileCardDesc	()Ljava/lang/String;
    //   60: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 582	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload_0
    //   70: getfield 41	atbj:jdField_c_of_type_Alcn	Lalcn;
    //   73: aload_1
    //   74: iload_2
    //   75: invokestatic 587	atbh:a	(Lalcn;Lcom/tencent/mobileqq/data/Card;Z)Z
    //   78: pop
    //   79: aload_0
    //   80: getfield 41	atbj:jdField_c_of_type_Alcn	Lalcn;
    //   83: invokestatic 590	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	(Lalcn;)V
    //   86: aload_0
    //   87: aload_1
    //   88: invokespecial 127	atbj:l	(Lcom/tencent/mobileqq/data/Card;)V
    //   91: aload_0
    //   92: getfield 41	atbj:jdField_c_of_type_Alcn	Lalcn;
    //   95: getfield 245	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   98: getfield 286	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   101: ifeq +179 -> 280
    //   104: iload_3
    //   105: bipush 8
    //   107: if_icmpne +173 -> 280
    //   110: aload_0
    //   111: getfield 592	atbj:aWu	Z
    //   114: ifne +166 -> 280
    //   117: aload_0
    //   118: iconst_1
    //   119: putfield 592	atbj:aWu	Z
    //   122: aload_1
    //   123: getfield 596	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   126: ldc2_w 597
    //   129: land
    //   130: lconst_0
    //   131: lcmp
    //   132: ifeq +151 -> 283
    //   135: iconst_1
    //   136: istore_2
    //   137: aload_0
    //   138: getfield 56	atbj:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: bipush 51
    //   143: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   146: checkcast 288	acff
    //   149: aload_1
    //   150: getfield 161	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   153: invokevirtual 292	acff:isFriend	(Ljava/lang/String;)Z
    //   156: istore 4
    //   158: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +69 -> 230
    //   164: ldc 220
    //   166: iconst_2
    //   167: new 222	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 600
    //   177: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload_2
    //   181: invokevirtual 573	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: ldc_w 602
    //   187: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload 4
    //   192: invokevirtual 573	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   195: ldc_w 604
    //   198: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_1
    //   202: getfield 161	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   205: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 606
    //   211: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: getfield 56	atbj:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   218: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   221: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 582	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: iload_2
    //   231: iload 4
    //   233: if_icmpeq +47 -> 280
    //   236: ldc 220
    //   238: iconst_1
    //   239: new 222	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 608
    //   249: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload_2
    //   253: invokevirtual 573	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   256: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 582	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_0
    //   263: getfield 56	atbj:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   266: iconst_1
    //   267: invokevirtual 175	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   270: checkcast 610	com/tencent/mobileqq/app/FriendListHandler
    //   273: aload_1
    //   274: getfield 161	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   277: invokevirtual 614	com/tencent/mobileqq/app/FriendListHandler:DF	(Ljava/lang/String;)V
    //   280: aload_0
    //   281: monitorexit
    //   282: return
    //   283: iconst_0
    //   284: istore_2
    //   285: goto -148 -> 137
    //   288: astore_1
    //   289: aload_0
    //   290: monitorexit
    //   291: aload_1
    //   292: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	atbj
    //   0	293	1	paramCard	Card
    //   0	293	2	paramBoolean	boolean
    //   0	293	3	paramInt	int
    //   156	78	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	69	288	finally
    //   69	104	288	finally
    //   110	135	288	finally
    //   137	230	288	finally
    //   236	280	288	finally
  }
  
  public boolean aIX()
  {
    boolean bool = this.mHasInit;
    int i;
    if (this.jdField_c_of_type_Alcn == null) {
      i = 0;
    }
    while ((bool) && (i != 0))
    {
      return true;
      if (this.jdField_c_of_type_Alcn.d != null) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return false;
  }
  
  public boolean aIY()
  {
    if (!this.mHasInit) {
      QLog.e("ProfileModel", 2, "isShowTroopMemRecentSaid failed mHasInit is false");
    }
    while (this.mApp == null) {
      return false;
    }
    if ((this.jdField_c_of_type_Alcn.cwc) && (!this.dha)) {
      this.dha = ((TroopPluginManager)this.mApp.getManager(119)).a("troop_member_card_plugin.apk", new atbn(this));
    }
    return this.dha;
  }
  
  public boolean aIZ()
  {
    return true;
  }
  
  public void b(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    if (this.mHasInit) {}
    for (;;)
    {
      return;
      if (paramIntent == null)
      {
        QLog.e("ProfileModel", 2, "initWithInputData failed profileIntent is null");
        return;
      }
      this.mApp = a(paramQQAppInterface);
      if (this.mApp == null)
      {
        QLog.e("ProfileModel", 2, "initWithInputData failed mApp is null");
        return;
      }
      parseIntent(paramIntent);
      if (!atbh.a(this.jdField_c_of_type_Alcn, paramIntent))
      {
        notifyEvent(1);
        QLog.e("ProfileModel", 2, "initWithInputData failed mApp is null");
        return;
      }
      if (!cu(paramQQAppInterface))
      {
        this.f = new auru(ThreadManager.getSubThreadLooper(), this.d);
        this.jdField_c_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.mApp.getBusinessHandler(2));
        this.mApp.addObserver(this.jdField_a_of_type_Accn);
        this.mApp.addObserver(this.b);
        try
        {
          this.jdField_c_of_type_Alcn.gh = new String[7];
          ThreadManager.excute(new ProfileModel.4(this), 16, null, true);
          bOo();
          c(((TroopManager)paramQQAppInterface.getManager(52)).b(this.jdField_c_of_type_Alcn.troopUin));
          paramIntent = (CardHandler)paramQQAppInterface.getBusinessHandler(2);
          if ((paramIntent != null) && (this.jdField_c_of_type_Alcn != null) && (this.jdField_c_of_type_Alcn.e != null) && (this.jdField_c_of_type_Alcn.e.uin != null)) {
            paramIntent.Dw(this.jdField_c_of_type_Alcn.e.uin);
          }
          if (this.jdField_c_of_type_Alcn.e.pa == 0)
          {
            esW();
            bPi();
            return;
          }
        }
        catch (Exception paramIntent)
        {
          QLog.e("ProfileModel", 1, "doOnCreate fail.", paramIntent);
          notifyEvent(1);
        }
      }
    }
  }
  
  public void bPi()
  {
    if (this.mApp == null) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.hi(this.mApp.getLongAccountUin());
  }
  
  protected void c(TroopInfo paramTroopInfo)
  {
    ProfileActivity.AllInOne localAllInOne = this.jdField_c_of_type_Alcn.e;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfileActivity.gk(localAllInOne.pa)) && (TextUtils.isEmpty(localAllInOne.troopUin)))
    {
      localAllInOne.troopUin = paramTroopInfo.troopcode;
      localAllInOne.troopcode = paramTroopInfo.troopuin;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileModel", 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
    }
  }
  
  public RichStatus d()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getSign failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.getRichStatus();
  }
  
  public ArrayList<aldd> ej()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.DT);
    return localArrayList;
  }
  
  public MessageRecord g()
  {
    if (this.mApp == null) {
      return null;
    }
    Object localObject = top.ox();
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    String str1 = MessageRecord.getTableName(this.jdField_c_of_type_Alcn.troopUin, 1);
    String str2 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(9223372036854775807L), localObject });
    if (this.jdField_c_of_type_Alcn.d != null) {}
    for (localObject = this.jdField_c_of_type_Alcn.d.uin;; localObject = this.jdField_c_of_type_Alcn.e.uin)
    {
      localObject = localEntityManager.query(MessageRecord.class, str1, false, str2, new String[] { localObject }, null, null, "shmsgseq DESC", String.valueOf(1));
      localEntityManager.close();
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break;
      }
      return (MessageRecord)((List)localObject).get(0);
    }
  }
  
  public String getCity()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getCity failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strCity;
  }
  
  public String getCountry()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getCountry failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strCountry;
  }
  
  public String getEmail()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getEmail failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strEmail;
  }
  
  public String getLocation()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getLocation failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strLocationCodes;
  }
  
  public String getNickName()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getNickName failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strNick;
  }
  
  public String getProvince()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getProvince failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.strProvince;
  }
  
  public String getUin()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getUin failed mHasInit is false");
      return null;
    }
    return this.jdField_c_of_type_Alcn.d.uin;
  }
  
  public long iq()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getBirthday failed mHasInit is false");
      return -1L;
    }
    return this.jdField_c_of_type_Alcn.d.lBirthday;
  }
  
  public long ir()
  {
    if (!this.mHasInit) {
      QLog.e("ProfileModel", 2, "getTroopMemJoinTime failed mHasInit is false");
    }
    for (;;)
    {
      return -1L;
      if (this.jdField_c_of_type_Alcn.cwc)
      {
        if (this.jdField_c_of_type_Alcn.c == null) {}
        for (long l = -1L; l != 1L; l = this.jdField_c_of_type_Alcn.c.joinTime) {
          return l;
        }
      }
    }
  }
  
  public short n()
  {
    if ((!this.mHasInit) || (this.jdField_c_of_type_Alcn.d == null))
    {
      QLog.e("ProfileModel", 2, "getSex failed mHasInit is false");
      return -1;
    }
    return this.jdField_c_of_type_Alcn.d.shGender;
  }
  
  public void onDestory()
  {
    this.mApp.removeObserver(this.b);
    if (this.f != null)
    {
      this.f.removeCallbacksAndMessages(null);
      this.f.removeMessages(0);
      this.f = null;
    }
    this.jdField_c_of_type_ComTencentMobileqqAppCardHandler = null;
    if (!this.aWP)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Accn);
      this.mApp = null;
      this.jdField_a_of_type_Atbj$b = null;
    }
  }
  
  public static class a
  {
    private String cGC = "";
    private int eoU = -1;
    private boolean result;
    
    public int Od()
    {
      return this.eoU;
    }
    
    public boolean getResult()
    {
      return this.result;
    }
  }
  
  public static abstract interface b
  {
    public abstract void M(int paramInt, Object paramObject);
    
    public abstract void a(atbj.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbj
 * JD-Core Version:    0.7.0.1
 */