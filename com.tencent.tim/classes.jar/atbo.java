import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.activity.profile.ProfileViewModel.1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public abstract class atbo
  extends ViewModel
  implements atbj.b
{
  public MutableLiveData<List<atbe>> D = new MutableLiveData();
  public MutableLiveData<atbi> E = new MutableLiveData();
  public MutableLiveData<alcn> F = new MutableLiveData();
  public MutableLiveData<Boolean> G = new MutableLiveData();
  private final List<atbe> Kl = new ArrayList();
  protected atbj a = new atbj();
  protected QQAppInterface mApp;
  
  private String EM()
  {
    if (aJa()) {
      return this.a.Ey();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    c(localStringBuilder, this.a.getCountry());
    c(localStringBuilder, this.a.getProvince());
    c(localStringBuilder, this.a.getCity());
    return localStringBuilder.toString();
  }
  
  private boolean a(atbe paramatbe)
  {
    return (paramatbe == null) || (paramatbe.fP == null);
  }
  
  private void aai(int paramInt)
  {
    aaj(paramInt);
    if (this.Kl.size() > 0)
    {
      paramInt = this.Kl.size() - 1;
      if (((atbe)this.Kl.get(paramInt)).type == 1) {
        this.Kl.remove(paramInt);
      }
    }
    Collections.sort(this.Kl);
    this.D.setValue(this.Kl);
  }
  
  private atbe b(int paramInt)
  {
    if (this.Kl.size() > 0)
    {
      Iterator localIterator = this.Kl.iterator();
      while (localIterator.hasNext())
      {
        atbe localatbe = (atbe)localIterator.next();
        if (paramInt == localatbe.id) {
          return localatbe;
        }
      }
    }
    return null;
  }
  
  private void b(atbj.a parama)
  {
    if ((parama == null) || (!parama.getResult()) || (!this.a.aIX())) {}
    do
    {
      return;
      int i = parama.Od();
      esY();
      alcn localalcn = this.a.c;
      if (localalcn != null) {
        this.F.setValue(localalcn);
      }
      aai(i);
    } while (!QLog.isColorLevel());
    QLog.d("ProfileViewModel", 2, "onCardDataChanged id: " + parama.Od() + ", mCurDataList: " + this.Kl);
  }
  
  private void c(StringBuilder paramStringBuilder, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!TextUtils.isEmpty(paramStringBuilder)) {
      paramStringBuilder.append("-");
    }
    paramStringBuilder.append(paramString);
  }
  
  protected String B(boolean paramBoolean)
  {
    String str = "";
    Object localObject = this.a.d();
    if (localObject != null) {
      str = ((RichStatus)localObject).getPlainText();
    }
    localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = str;
      if (TextUtils.isEmpty(EG()))
      {
        if (!paramBoolean) {
          break label56;
        }
        localObject = BaseApplicationImpl.getContext().getString(2131695222);
      }
    }
    return localObject;
    label56:
    return BaseApplicationImpl.getContext().getString(2131695221);
  }
  
  protected String EG()
  {
    String str2 = this.a.EC();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.a.EB();
    }
    return str1;
  }
  
  public String EH()
  {
    return this.a.ED();
  }
  
  public String EI()
  {
    return this.a.EF();
  }
  
  public String EJ()
  {
    String str2 = (String)a(13, String.class);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = EI();
    }
    return str1;
  }
  
  public String EK()
  {
    String str2 = (String)a(6, String.class);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getEmail();
    }
    return str1;
  }
  
  public String EL()
  {
    String str2 = (String)a(5, String.class);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.a.EC();
    }
    return str1;
  }
  
  public String[] H()
  {
    String str = this.a.getLocation();
    if (!TextUtils.isEmpty(str)) {
      return str.split("-");
    }
    return null;
  }
  
  public void M(int paramInt, Object paramObject)
  {
    if ((paramInt == 5) || (paramInt == 4))
    {
      paramObject = this.G;
      if (paramInt != 5) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      paramObject.postValue(Boolean.valueOf(bool));
      return;
    }
  }
  
  public int Oe()
  {
    return (int)this.a.iq();
  }
  
  public int Of()
  {
    atcb localatcb = (atcb)a(0, atcb.class);
    if (localatcb != null) {
      return localatcb.birthday;
    }
    return (int)this.a.iq();
  }
  
  public boolean PI()
  {
    Iterator localIterator = this.Kl.iterator();
    while (localIterator.hasNext()) {
      if (((atbe)localIterator.next()).fP != null) {
        return true;
      }
    }
    return false;
  }
  
  public String[] T()
  {
    String str = this.a.Ez();
    if (!TextUtils.isEmpty(str)) {
      return str.split("-");
    }
    return null;
  }
  
  public alcn a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    this.Kl.clear();
    this.mApp = paramQQAppInterface;
    this.a.a(this);
    this.a.b(paramIntent, paramQQAppInterface);
    return this.a.c;
  }
  
  protected abstract atbi a();
  
  public ProfileActivity.CardContactInfo a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAllInOne != null)
    {
      localObject1 = localObject2;
      if (paramAllInOne.pr != null)
      {
        localObject1 = localObject2;
        if (paramAllInOne.pr.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)paramAllInOne.pr.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public <T> T a(int paramInt, Class<T> paramClass)
  {
    atbe localatbe = b(paramInt);
    if (localatbe != null) {
      try
      {
        if ((localatbe.fP != null) && (localatbe.fP.getClass().isAssignableFrom(paramClass)))
        {
          paramClass = paramClass.cast(localatbe.fP);
          return paramClass;
        }
      }
      catch (Throwable paramClass)
      {
        QLog.d("ProfileViewModel", 1, paramClass, new Object[0]);
      }
    }
    return null;
  }
  
  public void a(atbj.a parama)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(parama);
      return;
    }
    ThreadManager.getUIHandler().post(new ProfileViewModel.1(this, parama));
  }
  
  public boolean a(accv paramaccv)
  {
    Bundle localBundle = new Bundle();
    Object localObject = (Byte)a(1, Byte.class);
    if (localObject != null) {
      localBundle.putByte("sex", ((Byte)localObject).byteValue());
    }
    localObject = (atcb)a(0, atcb.class);
    if (localObject != null)
    {
      localBundle.putInt("birthday", ((atcb)localObject).birthday);
      localBundle.putInt("age", ((atcb)localObject).age);
      localBundle.putInt("key_constellation", ((atcb)localObject).constellation);
    }
    localObject = (Integer)a(4, Integer.class);
    if (localObject != null) {
      localBundle.putInt("profession", ((Integer)localObject).intValue());
    }
    localObject = (String)a(5, String.class);
    if (localObject != null) {
      localBundle.putString("company", (String)localObject);
    }
    try
    {
      localObject = (String[])a(2, [Ljava.lang.String.class);
      if ((localObject != null) && (localObject.length > 0))
      {
        String str = paramaccv.d((String[])localObject);
        if (!TextUtils.isEmpty(str))
        {
          localBundle.putStringArray("location", (String[])localObject);
          localBundle.putString("locationo_desc", str);
        }
        localBundle.putStringArray("location_name", paramaccv.d((String[])localObject));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ProfileViewModel", 1, localException, new Object[0]);
      }
    }
    localObject = (String[])a(3, [Ljava.lang.String.class);
    if ((localObject != null) && (localObject.length > 0))
    {
      paramaccv = paramaccv.d((String[])localObject);
      localBundle.putStringArray("hometown", (String[])localObject);
      localBundle.putString("hometown_desc", paramaccv);
    }
    paramaccv = (String)a(6, String.class);
    if ((paramaccv != null) && ((TextUtils.isEmpty(paramaccv)) || (SearchBaseActivity.Q.matcher(paramaccv).matches()))) {
      localBundle.putString("email", paramaccv);
    }
    if (localBundle.isEmpty()) {
      return false;
    }
    return this.a.I(localBundle);
  }
  
  protected boolean aJa()
  {
    return this instanceof atck;
  }
  
  protected void aab(int paramInt)
  {
    String str = EI();
    Object localObject;
    if (!TextUtils.isEmpty(str))
    {
      localObject = b(13);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileViewModel", 2, "createRemarkItem data: " + localObject + "， listSize: " + this.Kl.size());
      }
      if (localObject != null) {
        break label125;
      }
      localObject = BaseApplicationImpl.getContext().getString(2131697276);
      this.Kl.add(new atbe.a().a((String)localObject).a(true).b(str).b(13).c(paramInt).a());
    }
    label125:
    while (!a((atbe)localObject)) {
      return;
    }
    this.Kl.set(this.Kl.indexOf(localObject), ((atbe)localObject).a().b(str).a());
  }
  
  protected void aac(int paramInt)
  {
    String str1 = BaseApplicationImpl.getContext().getString(2131697247);
    String str2 = getNickName();
    atbe localatbe;
    if (!TextUtils.isEmpty(str2))
    {
      localatbe = b(14);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileViewModel", 2, "createNickItem data: " + localatbe + "， listSize: " + this.Kl.size());
      }
      if (localatbe == null) {
        this.Kl.add(new atbe.a().b(14).a(str1).b(str2).c(paramInt).a());
      }
    }
    else
    {
      return;
    }
    this.Kl.set(this.Kl.indexOf(localatbe), localatbe.a().b(str2).a());
  }
  
  protected void aad(int paramInt)
  {
    String str = this.a.getUin();
    atbe localatbe;
    if (!TextUtils.isEmpty(str))
    {
      localatbe = b(15);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileViewModel", 2, "createAccountItem data: " + localatbe + "， listSize: " + this.Kl.size());
      }
      if (localatbe == null) {
        this.Kl.add(new atbe.a().a("TIM账号").b(str).b(15).c(paramInt).a());
      }
    }
    else
    {
      return;
    }
    this.Kl.set(this.Kl.indexOf(localatbe), localatbe.a().b(str).a());
  }
  
  protected void aae(int paramInt)
  {
    String str = BaseApplicationImpl.getContext().getString(2131697230);
    long l = this.a.ir();
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (l > 0L) {}
    try
    {
      localObject1 = DateFormat.format(BaseApplicationImpl.getContext().getString(2131694932), l * 1000L).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = b(16);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileViewModel", 2, "createEnterTroopTimeItem data: " + localObject3 + "， listSize: " + this.Kl.size());
        }
        if (localObject3 == null) {
          this.Kl.add(new atbe.a().a(str).b((String)localObject1).b(16).c(paramInt).a());
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        QLog.d("ProfileViewModel", 1, localException, new Object[0]);
        localObject2 = localObject3;
      }
      this.Kl.set(this.Kl.indexOf(localObject3), ((atbe)localObject3).a().b(localObject2).a());
    }
  }
  
  protected void aaf(int paramInt)
  {
    String str;
    Object localObject;
    if (this.a.aIY())
    {
      str = this.a.EE();
      if (!TextUtils.isEmpty(str))
      {
        localObject = b(7);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileViewModel", 2, "createRecentSpeakItem data: " + localObject + "， listSize: " + this.Kl.size());
        }
        if (localObject != null) {
          break label138;
        }
        localObject = BaseApplicationImpl.getContext().getString(2131697275);
        this.Kl.add(new atbe.a().a((String)localObject).b(str).a(true).c(paramInt).b(7).a());
      }
    }
    return;
    label138:
    this.Kl.set(this.Kl.indexOf(localObject), ((atbe)localObject).a().b(str).a());
  }
  
  protected void aag(int paramInt)
  {
    String str1 = this.a.EB();
    atbe localatbe;
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = BaseApplicationImpl.getContext().getString(2131697278);
      localatbe = b(12);
      if (localatbe == null) {
        this.Kl.add(new atbe.a().a(str2).b(str1).b(12).a(true).c(paramInt).a());
      }
    }
    else
    {
      return;
    }
    this.Kl.set(this.Kl.indexOf(localatbe), localatbe.a().b(str1).a());
  }
  
  protected void aah(int paramInt)
  {
    String str2;
    atbe localatbe;
    if (this.a.aIZ())
    {
      String str1 = BaseApplicationImpl.getContext().getString(2131697274);
      str2 = String.format(BaseApplicationImpl.getContext().getString(2131697273), new Object[] { this.a.getNickName() });
      localatbe = b(20);
      if (localatbe == null) {
        this.Kl.add(new atbe.a().a(str1).b(str2).b(20).a(true).c(paramInt).a());
      }
    }
    else
    {
      return;
    }
    this.Kl.set(this.Kl.indexOf(localatbe), localatbe.a().b(str2).a());
  }
  
  protected abstract void aaj(int paramInt);
  
  protected void bQ(boolean paramBoolean, int paramInt)
  {
    int i = i();
    if ((!aJa()) && (i != 1) && (i != 0)) {}
    String str1;
    atbe localatbe;
    do
    {
      return;
      String str2 = BaseApplicationImpl.getContext().getString(2131697280);
      if (i == 1) {
        str1 = "女";
      }
      for (;;)
      {
        localatbe = b(1);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileViewModel", 2, "createGenderItem data: " + localatbe + "， listSize: " + this.Kl.size());
        }
        if (localatbe != null) {
          break;
        }
        this.Kl.add(new atbe.a().a(str2).b(str1).b(1).a(paramBoolean).c(paramInt).a());
        return;
        if (i == 0) {
          str1 = "男";
        } else {
          str1 = BaseApplicationImpl.getContext().getString(2131697279);
        }
      }
    } while (!a(localatbe));
    this.Kl.set(this.Kl.indexOf(localatbe), localatbe.a().b(str1).a());
  }
  
  protected void bR(boolean paramBoolean, int paramInt)
  {
    int i = Oe();
    if ((!aJa()) && (i <= 0)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      String str = BaseApplicationImpl.getContext().getString(2131697181);
      localObject1 = "";
      if (i >= 0) {
        localObject1 = String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & i) >>> 16), Integer.valueOf((0xFF00 & i) >>> 8), Integer.valueOf(i & 0xFF) });
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = BaseApplicationImpl.getContext().getString(2131697180);
      }
      localObject1 = b(0);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileViewModel", 2, "createBirthdayItem data: " + localObject1 + "， listSize: " + this.Kl.size());
      }
      if (localObject1 == null)
      {
        this.Kl.add(new atbe.a().a(str).b((String)localObject2).b(0).a(paramBoolean).c(paramInt).a());
        return;
      }
    } while (!a((atbe)localObject1));
    this.Kl.set(this.Kl.indexOf(localObject1), ((atbe)localObject1).a().b((String)localObject2).a());
  }
  
  protected void bS(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = EM();
    if ((!aJa()) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
    Object localObject1;
    do
    {
      return;
      String str = BaseApplicationImpl.getContext().getString(2131697242);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = BaseApplicationImpl.getContext().getString(2131697241);
      }
      localObject2 = b(2);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileViewModel", 2, "createLocationItem data: " + localObject2 + "， listSize: " + this.Kl.size());
      }
      if (localObject2 == null)
      {
        this.Kl.add(new atbe.a().a(str).b((String)localObject1).b(2).a(paramBoolean).c(paramInt).a());
        return;
      }
    } while (!a((atbe)localObject2));
    this.Kl.set(this.Kl.indexOf(localObject2), ((atbe)localObject2).a().b((String)localObject1).a());
  }
  
  protected void bT(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = this.a.EA();
    if ((!aJa()) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
    Object localObject1;
    do
    {
      return;
      String str = BaseApplicationImpl.getContext().getString(2131697238);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = BaseApplicationImpl.getContext().getString(2131697237);
      }
      localObject2 = b(3);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileViewModel", 2, "createHomeTownItem data: " + localObject2 + "， listSize: " + this.Kl.size());
      }
      if (localObject2 == null)
      {
        this.Kl.add(new atbe.a().a(str).b((String)localObject1).b(3).a(paramBoolean).c(paramInt).a());
        return;
      }
    } while (!a((atbe)localObject2));
    this.Kl.set(this.Kl.indexOf(localObject2), ((atbe)localObject2).a().b((String)localObject1).a());
  }
  
  protected void bU(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = aqek.ga(this.a.Oc());
    if ((!aJa()) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
    Object localObject1;
    do
    {
      return;
      String str = BaseApplicationImpl.getContext().getString(2131697272);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = BaseApplicationImpl.getContext().getString(2131697271);
      }
      localObject2 = b(4);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileViewModel", 2, "createProfessionItem data: " + localObject2 + "， listSize: " + this.Kl.size());
      }
      if (localObject2 == null)
      {
        this.Kl.add(new atbe.a().a(str).b((String)localObject1).b(4).a(paramBoolean).c(paramInt).a());
        return;
      }
    } while (!a((atbe)localObject2));
    this.Kl.set(this.Kl.indexOf(localObject2), ((atbe)localObject2).a().b((String)localObject1).a());
  }
  
  protected void bV(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = this.a.EC();
    if ((!aJa()) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
    Object localObject1;
    do
    {
      return;
      String str = BaseApplicationImpl.getContext().getString(2131697196);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = BaseApplicationImpl.getContext().getString(2131697195);
      }
      localObject2 = b(5);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileViewModel", 2, "createCompanyItem data: " + localObject2 + "， listSize: " + this.Kl.size());
      }
      if (localObject2 == null)
      {
        this.Kl.add(new atbe.a().a(str).b((String)localObject1).b(5).a(paramBoolean).c(paramInt).a());
        return;
      }
    } while (!a((atbe)localObject2));
    this.Kl.set(this.Kl.indexOf(localObject2), ((atbe)localObject2).a().b((String)localObject1).a());
  }
  
  protected void bW(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = getEmail();
    if ((!aJa()) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
    Object localObject1;
    do
    {
      return;
      String str = BaseApplicationImpl.getContext().getString(2131697229);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = BaseApplicationImpl.getContext().getString(2131697228);
      }
      localObject2 = b(6);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileViewModel", 2, "createEmailItem data: " + localObject2 + "， listSize: " + this.Kl.size());
      }
      if (localObject2 == null)
      {
        this.Kl.add(new atbe.a().a(str).b((String)localObject1).b(6).a(paramBoolean).c(paramInt).a());
        return;
      }
    } while (!a((atbe)localObject2));
    this.Kl.set(this.Kl.indexOf(localObject2), ((atbe)localObject2).a().b((String)localObject1).a());
  }
  
  public void d(int paramInt, String paramString, Object paramObject)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.Kl.size())
      {
        atbe localatbe = (atbe)this.Kl.get(i);
        if (localatbe.id == paramInt)
        {
          paramString = localatbe.a().b(paramString);
          if (paramObject != null) {
            paramString.b(paramObject);
          }
          this.Kl.set(i, paramString.a());
        }
      }
      else
      {
        refreshList();
        return;
      }
      i += 1;
    }
  }
  
  protected void esX()
  {
    Object localObject1;
    if (this.Kl.size() > 0)
    {
      localObject1 = this.Kl.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (atbe)((Iterator)localObject1).next();
        if ((((atbe)localObject2).id >= 8) && (((atbe)localObject2).id <= 11)) {
          ((Iterator)localObject1).remove();
        }
      }
    }
    Object localObject2 = this.a.ej();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = new atbe.a();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aldd localaldd = (aldd)((Iterator)localObject2).next();
        this.Kl.add(((atbe.a)localObject1).b().a(localaldd.xS()).b(localaldd.xR()).b(localaldd.Hu()).a(true).a(localaldd).a());
      }
    }
    this.Kl.add(atbe.b);
  }
  
  public void esY()
  {
    this.E.setValue(a());
  }
  
  public String getEmail()
  {
    return this.a.getEmail();
  }
  
  public String getNickName()
  {
    return this.a.getNickName();
  }
  
  protected String getSignature()
  {
    return B(false);
  }
  
  public byte i()
  {
    return (byte)this.a.n();
  }
  
  public byte j()
  {
    Byte localByte = (Byte)a(1, Byte.class);
    if (localByte != null) {
      return localByte.byteValue();
    }
    return i();
  }
  
  protected void kN(int paramInt1, int paramInt2)
  {
    if ((b(paramInt1) == null) && (this.Kl.size() > 0))
    {
      atbe localatbe = (atbe)this.Kl.get(this.Kl.size() - 1);
      if ((localatbe != null) && (localatbe.type != 1)) {
        this.Kl.add(new atbe.a().a(1).b(paramInt1).c(paramInt2).a());
      }
    }
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.a.onDestory();
  }
  
  public void refreshList()
  {
    aai(1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbo
 * JD-Core Version:    0.7.0.1
 */