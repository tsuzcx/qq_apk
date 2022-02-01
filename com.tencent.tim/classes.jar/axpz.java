import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.qq.im.capture.data.ComboLockManager.2;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.LockedCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class axpz
  implements IEventReceiver
{
  public static final String cGy = aasa.SDCARD_ROOT + "/tencent/qim/share/";
  axpz.a jdField_a_of_type_Axpz$a;
  LockedCategory jdField_a_of_type_DovComQqImCaptureDataLockedCategory;
  ayva.a b;
  volatile boolean dvW = false;
  public boolean dvX;
  public QIMFilterCategoryItem f;
  accn h = new axqb(this);
  AppInterface mApp = axol.getAppInterface();
  int mScene = -1;
  HashMap<String, LockedCategory> rs;
  boolean tL = true;
  
  private void eNR()
  {
    if (this.jdField_a_of_type_Axpz$a == null)
    {
      this.jdField_a_of_type_Axpz$a = new axpz.a(this);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "registerStoryReceiver");
      }
      pmi.a().registerSubscriber(this.jdField_a_of_type_Axpz$a);
    }
  }
  
  public LockedCategory a(String paramString)
  {
    return (LockedCategory)this.rs.get(paramString);
  }
  
  public void adj(String paramString)
  {
    paramString = (LockedCategory)this.rs.get(paramString);
    if (paramString != null) {
      paramString.dwb = false;
    }
  }
  
  public void adk(String paramString)
  {
    Object localObject1 = this.b.a(this.mScene).GE;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label101;
        }
        Object localObject2 = (FilterCategory)((Iterator)localObject1).next();
        if (((FilterCategory)localObject2).Fv != null)
        {
          localObject2 = ((FilterCategory)localObject2).Fv.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
            if (!paramString.equals(localQIMFilterCategoryItem.id)) {
              break;
            }
            this.f = localQIMFilterCategoryItem;
          }
        }
      }
    }
    label101:
    if (QLog.isColorLevel()) {
      QLog.i("ComboLockManager", 2, "setLockingItem " + paramString + " result " + this.f);
    }
  }
  
  public void c(ayva.a parama)
  {
    if (this.b == parama) {
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "same data");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "updateConfigData isfrist " + this.tL + " sendStory " + this.dvW);
      }
      if (this.tL)
      {
        this.tL = false;
        if (QLog.isColorLevel()) {
          QLog.i("ComboLockManager", 2, "updateConfigData first card.snedSrory " + this.dvW);
        }
      }
      this.rs = parama.rs;
      this.b = parama;
      parama = this.rs.keySet().iterator();
      while (parama.hasNext())
      {
        Object localObject = (String)parama.next();
        localObject = (LockedCategory)this.rs.get(localObject);
        ((LockedCategory)localObject).dwb = ui(((LockedCategory)localObject).mId);
        if ((((LockedCategory)localObject).dwb) && (((LockedCategory)localObject).mType == 2))
        {
          this.jdField_a_of_type_DovComQqImCaptureDataLockedCategory = ((LockedCategory)localObject);
          eNR();
        }
        if (QLog.isColorLevel()) {
          QLog.i("ComboLockManager", 2, "updateConfigData " + localObject + " lock " + ((LockedCategory)localObject).dwb);
        }
      }
    }
  }
  
  public void eNS()
  {
    if (this.jdField_a_of_type_Axpz$a != null)
    {
      this.jdField_a_of_type_Axpz$a = new axpz.a(this);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "unregisterStoryReceiver");
      }
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Axpz$a);
      this.jdField_a_of_type_Axpz$a = null;
    }
  }
  
  public void eNT()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ComboLockManager", 2, "handleSendStory");
    }
    this.dvW = true;
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Axpz$a);
    Object localObject = (CardHandler)this.mApp.getBusinessHandler(2);
    this.mApp.addObserver(this.h, true);
    if (this.jdField_a_of_type_DovComQqImCaptureDataLockedCategory != null)
    {
      localObject = BaseApplicationImpl.getContext();
      axqa localaxqa = new axqa(this, (Context)localObject);
      ThreadManager.getUIHandler().postDelayed(new ComboLockManager.2(this, (Context)localObject, localaxqa), 1000L);
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public boolean m(String paramString, Context paramContext)
  {
    boolean bool = false;
    if (ui(paramString))
    {
      Object localObject2 = a(paramString).cVJ;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.e("ComboLockManager", 1, "empty jump url");
        localObject1 = "https://ti.qq.com/unlocked/index.html?_wv=536870912&id=" + paramString;
      }
      localObject2 = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("k_f_id", paramString);
      paramContext.startActivity((Intent)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "handleLockItemClick id " + paramString);
      }
      bool = true;
    }
    return bool;
  }
  
  public void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  public boolean ui(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    LockedCategory localLockedCategory;
    if (this.rs == null)
    {
      bool1 = false;
      i = -1;
      localLockedCategory = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.i("ComboLockManager", 2, "is locke " + paramString + " code" + i);
        if (i == 3) {
          QLog.i("ComboLockManager", 2, "islock result" + bool1 + " type " + localLockedCategory.mType + " mHaveSendStory " + this.dvW);
        }
      }
      return bool1;
      localLockedCategory = (LockedCategory)this.rs.get(paramString);
      if (localLockedCategory == null)
      {
        bool1 = false;
      }
      else if (!localLockedCategory.dwb)
      {
        bool1 = false;
        i = 1;
      }
      else if (localLockedCategory.aPx())
      {
        bool1 = false;
        i = 2;
      }
      else if (localLockedCategory.mType == 2)
      {
        if (this.dvW)
        {
          bool1 = bool2;
          if (this.f != null)
          {
            bool1 = bool2;
            if (!this.f.id.equals(paramString)) {}
          }
        }
        else
        {
          bool1 = true;
        }
        i = 3;
      }
      else if (localLockedCategory.mType == 1)
      {
        if (!localLockedCategory.dwc)
        {
          localLockedCategory.dwb = aqmj.aN(BaseApplicationImpl.getApplication(), paramString);
          localLockedCategory.dwc = true;
        }
        bool1 = localLockedCategory.dwb;
        i = 3;
      }
      else
      {
        bool1 = false;
        i = 3;
      }
    }
  }
  
  public static class a
    extends QQUIEventReceiver<axpz, pnx.d>
  {
    boolean mDone = false;
    
    public a(@NonNull axpz paramaxpz)
    {
      super();
    }
    
    public void a(@NonNull axpz paramaxpz, @NonNull pnx.d paramd)
    {
      if (!this.mDone)
      {
        paramaxpz.eNT();
        this.mDone = true;
      }
    }
    
    public Class acceptEventClass()
    {
      return pnx.d.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axpz
 * JD-Core Version:    0.7.0.1
 */