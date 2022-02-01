import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.TroopAvatarController.1;
import com.tencent.mobileqq.activity.photo.TroopAvatarController.3;
import com.tencent.mobileqq.activity.photo.TroopAvatarController.4;
import com.tencent.mobileqq.activity.photo.TroopAvatarController.5;
import com.tencent.mobileqq.activity.photo.TroopAvatarController.6;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.a;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class zta
  extends ztd
{
  private TroopClipPic jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new ztb(this);
  private zri jdField_a_of_type_Zri;
  private zri b;
  
  public zta(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, paramActivity, paramQQAppInterface, paramString);
    this.mType = 1;
  }
  
  public void BU(boolean paramBoolean)
  {
    Object localObject3 = null;
    apul localapul = null;
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Object localObject1;
    Object localObject2;
    if (this.mApp != null)
    {
      if (paramBoolean) {
        crL();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead;
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList hasHead=%b id=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mTroopAvatarId) }));
        }
        if (!paramBoolean) {
          break label435;
        }
        int i = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mTroopAvatarId;
        if (i <= 0) {
          break label430;
        }
        localObject1 = new zri();
        ((zri)localObject1).baF = String.valueOf(i);
        ((zri)localObject1).type = 1;
        ((zri)localObject1).fromType = 1;
        ((zri)localObject1).aYK = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mTroopVerifyingPics.contains(((zri)localObject1).baF);
        if (localObject1 != null) {
          break label424;
        }
        localObject2 = new zri();
        ((zri)localObject2).baF = zri.baD;
        ((zri)localObject2).type = 1;
        ((zri)localObject2).fromType = 3;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = this.jdField_b_of_type_Apru.dW();
      if (localArrayList != null)
      {
        Iterator localIterator = localArrayList.iterator();
        localObject1 = localapul;
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localapul = (apul)localIterator.next();
          if (localapul != null)
          {
            localObject3 = localObject1;
            if (localapul.type == 1)
            {
              if (localObject1 != null)
              {
                localIterator.remove();
              }
              else
              {
                localObject3 = new zri();
                ((zri)localObject3).baE = localapul.baE;
                ((zri)localObject3).progress = localapul.progress;
                ((zri)localObject3).type = localapul.type;
                ((zri)localObject3).fromType = 2;
                ((zri)localObject3).isUploading = true;
                ((zri)localObject3).ts = localapul.ts;
                ((zri)localObject3).clipInfo = localapul.clipInfo;
              }
            }
            else {
              localObject1 = localObject3;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList uploadItems=%s", new Object[] { localArrayList }));
      }
      localObject1 = new TroopAvatarController.1(this, (zri)localObject2, (zri)localObject3);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        ((Runnable)localObject1).run();
        return;
      }
      this.handler.post((Runnable)localObject1);
      return;
      label424:
      localObject2 = localObject1;
      continue;
      label430:
      localObject1 = null;
      break;
      label435:
      localObject2 = null;
    }
  }
  
  protected void Fv(int paramInt) {}
  
  public zri a()
  {
    if (this.jdField_b_of_type_Zri != null) {
      return this.jdField_b_of_type_Zri;
    }
    return this.jdField_a_of_type_Zri;
  }
  
  protected void a(zri paramzri) {}
  
  public void a(zri paramzri, TroopUploadingThread.a parama)
  {
    super.a(paramzri, parama);
  }
  
  public boolean a(int paramInt, zri paramzri)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramzri }));
    }
    if (this.jdField_a_of_type_Zri != null)
    {
      localObject = this.jdField_a_of_type_Zri.baF;
      try
      {
        i = Integer.parseInt((String)localObject);
        if ((localObject != null) && (i >= 0) && (i == paramInt)) {
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int i = -1;
        }
      }
    }
    Object localObject = new HashSet();
    if (paramzri.aYK) {
      ((Set)localObject).add(paramzri.baF);
    }
    if (this.mApp != null)
    {
      paramzri = (TroopManager)this.mApp.getManager(52);
      if (paramzri != null)
      {
        TroopInfo localTroopInfo = paramzri.b(String.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin));
        if (localTroopInfo != null)
        {
          localTroopInfo.mTroopAvatarId = paramInt;
          localTroopInfo.mTroopVerifyingPics.addAll((Collection)localObject);
          ThreadManager.post(new TroopAvatarController.6(this, paramzri, localTroopInfo), 8, null, false);
        }
      }
    }
    return true;
  }
  
  public boolean ag(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onNewIntent clip=%s path=%s", new Object[] { paramString2, paramString1 }));
    }
    if (iv(paramString1)) {}
    while (ah(paramString1, paramString2)) {
      return false;
    }
    TroopClipPic localTroopClipPic = new TroopClipPic();
    localTroopClipPic.id = paramString1;
    localTroopClipPic.clipInfo = paramString2;
    localTroopClipPic.type = this.mType;
    localTroopClipPic.ts = SystemClock.uptimeMillis();
    paramString1 = new zri();
    paramString1.baE = localTroopClipPic.id;
    paramString1.clipInfo = localTroopClipPic.clipInfo;
    paramString1.fromType = 2;
    paramString1.isUploading = true;
    paramString1.baF = "-1";
    paramString1.type = localTroopClipPic.type;
    paramString1.ts = localTroopClipPic.ts;
    paramString2 = this.jdField_b_of_type_Apru.dW();
    if (paramString2 != null)
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        apul localapul = (apul)paramString2.next();
        if ((localapul != null) && (localapul.type == 1)) {
          paramString2.remove();
        }
      }
    }
    this.jdField_b_of_type_Zri = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = localTroopClipPic;
    notifyDataSetChanged();
    startUpload();
    anot.a(this.mApp, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    return true;
  }
  
  protected void b(zri paramzri) {}
  
  public List<zri> dr()
  {
    return null;
  }
  
  public void ff(int paramInt) {}
  
  public void notifyDataSetChanged()
  {
    Iterator localIterator = this.uL.iterator();
    while (localIterator.hasNext()) {
      ((ztd.a)localIterator.next()).onDataSetChanged();
    }
  }
  
  public void onItemSelect(int paramInt) {}
  
  public void startUpload()
  {
    AccountManager localAccountManager = (AccountManager)this.mApp.getManager(0);
    String str = apuh.k(this.mApp);
    if (str == null)
    {
      localAccountManager.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopcode, str, this.mApp.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopClipPic = null;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    TroopUploadingThread.a locala;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof TroopUploadingThread.a));
        locala = (TroopUploadingThread.a)paramObject;
      } while (locala.type != this.mType);
      long l = locala.ts;
      paramObject = this.jdField_b_of_type_Zri;
      if ((paramObject != null) && (paramObject.ts == l))
      {
        switch (locala.dWB)
        {
        default: 
          return;
        case 0: 
          paramObject.progress = locala.result;
          this.handler.post(new TroopAvatarController.3(this, paramObject, locala));
          return;
        case 1: 
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(locala.result), Integer.valueOf(locala.dWC), paramObject }));
          }
          int i = locala.result;
          paramObservable = new TroopAvatarController.4(this, locala, paramObject, i);
          this.handler.post(paramObservable);
          zti.s(i, paramObject.baE, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
          return;
        }
        anot.a(this.mApp, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(locala.result), "", "");
        if (TextUtils.isEmpty(locala.errorMsg)) {}
        for (paramObservable = zti.d(this.mActivity, locala.result);; paramObservable = locala.errorMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() failed result=%d info=%s", new Object[] { Integer.valueOf(locala.result), paramObject }));
          }
          paramObservable = new TroopAvatarController.5(this, paramObservable);
          this.handler.post(paramObservable);
          return;
        }
      }
    } while (locala.dWB != 1);
    this.jdField_b_of_type_Apru.Tx(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zta
 * JD-Core Version:    0.7.0.1
 */