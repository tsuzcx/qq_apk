import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager.1;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class adyp
  implements Manager
{
  aooi a = null;
  public ConcurrentHashMap<String, BusinessCard> eT;
  protected ConcurrentHashMap<String, BusinessCard> eU;
  QQAppInterface mApp;
  EntityManager mEntityManager;
  SharedPreferences pref;
  protected ArrayList<aldd> vd = new ArrayList(0);
  
  public adyp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mEntityManager = this.mApp.a().createEntityManager();
    this.eT = new ConcurrentHashMap();
    this.eU = new ConcurrentHashMap();
    this.pref = paramQQAppInterface.getApp().getSharedPreferences("pref_business_card" + paramQQAppInterface.getAccount(), 0);
    qh();
  }
  
  private boolean a(BusinessCard paramBusinessCard)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBusinessCard != null)
    {
      String str = paramBusinessCard.cardId;
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (str.length() != 0)
        {
          paramBusinessCard.setStatus(1000);
          this.mEntityManager.persistOrReplace(paramBusinessCard);
          bool1 = bool2;
          if (paramBusinessCard.getStatus() == 1001) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void d(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard != null) {
      this.mEntityManager.update(paramBusinessCard);
    }
  }
  
  private void e(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard != null) {
      this.mEntityManager.remove(paramBusinessCard);
    }
  }
  
  public int Cc()
  {
    int i = this.pref.getInt("key_server_seq", -1);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "getLocalSeq | seq = " + i);
    }
    return i;
  }
  
  public void GV(boolean paramBoolean)
  {
    this.pref.edit().putBoolean("key_red_point", paramBoolean).commit();
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "setRedPointClicked | clicked = " + paramBoolean);
    }
  }
  
  public void He(String paramString)
  {
    if (this.eT.containsKey(paramString))
    {
      e((BusinessCard)this.eT.get(paramString));
      this.eT.remove(paramString);
    }
  }
  
  public void Hf(String paramString)
  {
    if (this.eU.containsKey(paramString)) {
      this.eU.remove(paramString);
    }
  }
  
  public void LK(int paramInt)
  {
    if (paramInt != -1) {
      this.pref.edit().putInt("key_server_seq", paramInt).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "saveServerSeq | seq = " + paramInt);
    }
  }
  
  public BusinessCard a()
  {
    BusinessCard localBusinessCard;
    if (!this.eT.isEmpty())
    {
      Iterator localIterator = this.eT.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localBusinessCard = (BusinessCard)((Map.Entry)localIterator.next()).getValue();
      } while (localBusinessCard.cardType != 1);
    }
    for (;;)
    {
      if ((localBusinessCard == null) && (QLog.isColorLevel())) {
        QLog.w("BusinessCard_Manager", 2, "getMyBusinessCard return null");
      }
      return localBusinessCard;
      localBusinessCard = null;
    }
  }
  
  public BusinessCard a(String paramString)
  {
    return (BusinessCard)this.eT.get(paramString);
  }
  
  public void a(String paramString, BusinessCard paramBusinessCard)
  {
    if ((paramBusinessCard == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.eU.containsKey(paramString)) {
      this.eU.remove(paramString);
    }
    this.eU.put(paramString, paramBusinessCard);
  }
  
  public boolean afT()
  {
    boolean bool = this.pref.getBoolean("key_red_point", true);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "getRedPointClicked | ret = " + bool);
    }
    return bool;
  }
  
  public void an(List<BusinessCard> paramList, boolean paramBoolean)
  {
    if (paramList != null) {}
    try
    {
      this.mEntityManager.getTransaction().begin();
      if (paramBoolean) {
        this.mEntityManager.drop(BusinessCard.class.getSimpleName());
      }
      paramList = paramList.iterator();
      BusinessCard localBusinessCard;
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localBusinessCard = (BusinessCard)paramList.next();
      } while (a(localBusinessCard));
      throw new Exception("saveCardList exception : comicId = " + localBusinessCard.cardId);
    }
    catch (Exception paramList)
    {
      QLog.d("BusinessCard_Manager", 2, "saveComicHistoryList exception :" + paramList.toString());
      paramList.printStackTrace();
      return;
      this.mEntityManager.getTransaction().commit();
      return;
    }
    finally
    {
      this.mEntityManager.getTransaction().end();
    }
  }
  
  public BusinessCard b(String paramString)
  {
    return (BusinessCard)this.eU.get(paramString);
  }
  
  public void b(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard == null) {
      return;
    }
    if (this.eT.containsKey(paramBusinessCard.cardId)) {
      this.eT.remove(paramBusinessCard.cardId);
    }
    this.eT.put(paramBusinessCard.cardId, paramBusinessCard);
  }
  
  public void bu(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "setCardSetting|type=" + paramInt + ", flag=" + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.pref.edit().putBoolean("key_show_open_card", paramBoolean).commit();
      return;
    case 1: 
      this.pref.edit().putBoolean("key_need_req_card", paramBoolean).commit();
      return;
    }
    this.pref.edit().putBoolean("key_need_show_guide", paramBoolean).commit();
  }
  
  public BusinessCard c(String paramString)
  {
    if ((paramString == null) || (this.eT.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.eT.values().iterator();
    while (localIterator.hasNext())
    {
      BusinessCard localBusinessCard = (BusinessCard)localIterator.next();
      if ((localBusinessCard.OCRInfo != null) && (paramString.equals(localBusinessCard.OCRInfo.picUrl))) {
        return localBusinessCard;
      }
    }
    return null;
  }
  
  public void c(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard == null) {
      return;
    }
    if (this.eT.containsKey(paramBusinessCard.cardId))
    {
      this.eT.remove(paramBusinessCard.cardId);
      d(paramBusinessCard);
    }
    for (;;)
    {
      this.eT.put(paramBusinessCard.cardId, paramBusinessCard);
      return;
      a(paramBusinessCard);
    }
  }
  
  public ArrayList<aldd> cN()
  {
    synchronized (this.vd)
    {
      ArrayList localArrayList2 = (ArrayList)this.vd.clone();
      return localArrayList2;
    }
  }
  
  public ArrayList<BusinessCard> cO()
  {
    ArrayList localArrayList = new ArrayList();
    if (!this.eT.isEmpty())
    {
      Iterator localIterator = this.eT.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((BusinessCard)localEntry.getValue()).cardType == 0) {
          localArrayList.add(localEntry.getValue());
        }
      }
    }
    return localArrayList;
  }
  
  public void cVl()
  {
    this.eT.clear();
    this.mEntityManager.drop(BusinessCard.class);
  }
  
  public BusinessCard d(String paramString)
  {
    BusinessCard localBusinessCard1 = new BusinessCard();
    BusinessCard localBusinessCard2 = (BusinessCard)this.mEntityManager.find(BusinessCard.class, paramString);
    paramString = localBusinessCard2;
    if (localBusinessCard2 == null) {
      paramString = localBusinessCard1;
    }
    return paramString;
  }
  
  public void dZ(ArrayList<aldd> paramArrayList)
  {
    if (paramArrayList != null) {
      synchronized (this.vd)
      {
        this.vd.clear();
        this.vd.addAll(paramArrayList);
        return;
      }
    }
  }
  
  public List<BusinessCard> eo()
  {
    List localList = this.mEntityManager.query(BusinessCard.class);
    if ((localList != null) && (QLog.isColorLevel())) {
      QLog.d("BusinessCard_Manager", 2, "getBusinessCardListFromDB= " + localList.size());
    }
    return localList;
  }
  
  public boolean iX(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_Manager", 2, "getCardSetting|type=" + paramInt + ", result=" + bool1);
      }
      return bool1;
      bool1 = this.pref.getBoolean("key_show_open_card", false);
      continue;
      bool1 = this.pref.getBoolean("key_need_req_card", false);
      continue;
      bool1 = this.pref.getBoolean("key_need_show_guide", true);
    }
  }
  
  public void onDestroy()
  {
    this.eT.clear();
    this.eU.clear();
    this.mEntityManager.close();
  }
  
  public void qh()
  {
    ThreadManager.post(new BusinessCardManager.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyp
 * JD-Core Version:    0.7.0.1
 */