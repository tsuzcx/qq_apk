import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.1;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.2;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.3;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.4;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.6;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.7;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.a;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class ztd
  implements Observer
{
  protected static int ceU = 7;
  public static Uri x;
  int UZ = -1;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new ztg(this);
  public apru b;
  public TroopInfo b;
  int bFL = 0;
  protected String[] cm;
  WeakReference<ztd.c> eH;
  WeakReference<ztd.b> eI;
  protected int[] fp;
  protected Handler handler = new Handler(Looper.getMainLooper());
  acnd k = new zth(this);
  Activity mActivity;
  QQAppInterface mApp;
  Context mCtx;
  String mTroopUin;
  int mType = 0;
  public ArrayList<TroopClipPic> rN = new ArrayList();
  public List<zri> uK = new ArrayList();
  List<ztd.a> uL = new ArrayList();
  
  public ztd(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.mCtx = paramContext;
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.mTroopUin = paramString;
    crL();
    paramContext = (acms)this.mApp.getBusinessHandler(20);
    this.jdField_b_of_type_Apru = new apru(this.mTroopUin, apug.class, paramContext);
    this.jdField_b_of_type_Apru.addObserver(this);
    this.mApp.addObserver(this.k, true);
  }
  
  private zri a(long paramLong)
  {
    Iterator localIterator = this.uK.iterator();
    while (localIterator.hasNext())
    {
      zri localzri = (zri)localIterator.next();
      if (localzri.ts == paramLong) {
        return localzri;
      }
    }
    return null;
  }
  
  private void crI()
  {
    x = ProfileActivity.a(this.mActivity, 257);
  }
  
  private void crJ()
  {
    if (this.UZ >= this.uK.size()) {
      this.UZ = (this.uK.size() - 1);
    }
    if (this.UZ < 0) {
      return;
    }
    int i = 0;
    label41:
    if (i < this.uK.size()) {
      if (this.UZ != i) {
        break label86;
      }
    }
    label86:
    for (((zri)this.uK.get(i)).isSelected = true;; ((zri)this.uK.get(i)).isSelected = false)
    {
      i += 1;
      break label41;
      break;
    }
  }
  
  public static void showToast(String paramString)
  {
    showToast(paramString, 0);
  }
  
  public static void showToast(String paramString, int paramInt)
  {
    int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627);
    QQToast.a(BaseApplicationImpl.getContext(), paramInt, paramString, 1).show(i);
  }
  
  public void BU(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Object localObject1;
    if (this.mApp != null)
    {
      if (paramBoolean) {
        crL();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        localObject1 = new ArrayList();
        zti.a((List)localObject1, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo);
        Object localObject2 = this.jdField_b_of_type_Apru.dW();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            apul localapul = (apul)((Iterator)localObject2).next();
            if ((localapul != null) && (localapul.type != 1)) {
              if (((List)localObject1).size() == 7)
              {
                ((Iterator)localObject2).remove();
              }
              else
              {
                zri localzri = new zri();
                localzri.baE = localapul.baE;
                localzri.progress = localapul.progress;
                localzri.type = localapul.type;
                localzri.fromType = 2;
                localzri.isUploading = true;
                localzri.ts = localapul.ts;
                localzri.clipInfo = localapul.clipInfo;
                ((List)localObject1).add(localzri);
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bserver=%b size=%d info=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(((List)localObject1).size()), localObject1.toString() }));
        }
        localObject1 = new TroopPhotoController.7(this, (List)localObject1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label297;
        }
        ((Runnable)localObject1).run();
      }
    }
    return;
    label297:
    this.handler.post((Runnable)localObject1);
  }
  
  public void BV(boolean paramBoolean)
  {
    Activity localActivity = this.mActivity;
    aqju localaqju = aqha.a(localActivity, 230);
    localaqju.setTitle(null);
    if (paramBoolean) {
      localaqju.setMessage(localActivity.getResources().getString(2131694836));
    }
    for (;;)
    {
      localaqju.setPositiveButton(localActivity.getResources().getString(2131694860), new aqha.a());
      localaqju.setPositiveButtonContentDescription(localActivity.getResources().getString(2131694860));
      localaqju.show();
      return;
      localaqju.setMessage(localActivity.getResources().getString(2131694835));
    }
  }
  
  protected void Fv(int paramInt)
  {
    Iterator localIterator = this.uL.iterator();
    while (localIterator.hasNext()) {
      ((ztd.a)localIterator.next()).onItemSelect(paramInt);
    }
  }
  
  public void Fw(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, "onInsertAvatarFailed " + paramInt);
    }
    showToast(zti.d(BaseApplicationImpl.getContext(), -1));
    Iterator localIterator = this.uK.iterator();
    while (localIterator.hasNext())
    {
      zri localzri = (zri)localIterator.next();
      if ((localzri.fromType == 2) || (localzri.isUploading))
      {
        localIterator.remove();
        b(localzri);
      }
    }
    this.rN.clear();
    this.jdField_b_of_type_Apru.Tx(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
  }
  
  public void Fx(int paramInt)
  {
    this.bFL = paramInt;
  }
  
  public zri a()
  {
    return null;
  }
  
  public void a(TroopClipPic paramTroopClipPic, String paramString1, String paramString2, String paramString3)
  {
    if ((paramTroopClipPic == null) || (paramString1 == null) || (paramString3 == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramTroopClipPic);
    this.jdField_b_of_type_Apru.a(TroopUploadingThread.class, this.mApp, localArrayList, paramString1, paramString2, paramString3, null);
  }
  
  public void a(ArrayList<TroopClipPic> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayList == null) || (paramString1 == null) || (paramString3 == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TroopClipPic localTroopClipPic = (TroopClipPic)paramArrayList.next();
        zri localzri = a(localTroopClipPic.ts);
        if ((localzri != null) && (!localzri.started))
        {
          localzri.started = true;
          localArrayList.add(localTroopClipPic);
        }
      }
    } while (localArrayList.size() == 0);
    this.jdField_b_of_type_Apru.a(TroopUploadingThread.class, this.mApp, localArrayList, paramString1, paramString2, paramString3, null);
  }
  
  protected void a(zri paramzri)
  {
    Iterator localIterator = this.uL.iterator();
    while (localIterator.hasNext()) {
      ((ztd.a)localIterator.next()).d(paramzri);
    }
  }
  
  public void a(zri paramzri, TroopUploadingThread.a parama)
  {
    Iterator localIterator = this.uL.iterator();
    while (localIterator.hasNext()) {
      ((ztd.a)localIterator.next()).b(paramzri, parama);
    }
  }
  
  public void a(ztd.a parama)
  {
    if (!this.uL.contains(parama)) {
      this.uL.add(parama);
    }
  }
  
  public void a(ztd.b paramb)
  {
    if (paramb != null) {
      this.eI = new WeakReference(paramb);
    }
  }
  
  public void a(ztd.c paramc)
  {
    if (paramc != null) {
      this.eH = new WeakReference(paramc);
    }
  }
  
  public boolean a(int paramInt, zri paramzri)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramzri }));
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject = this.uK.iterator();
    int i = 0;
    zri localzri;
    String str;
    while (((Iterator)localObject).hasNext())
    {
      localzri = (zri)((Iterator)localObject).next();
      if (localzri != null) {
        str = localzri.baF;
      }
    }
    label439:
    for (;;)
    {
      try
      {
        j = Integer.parseInt(str);
        if ((str == null) || (j < 0)) {
          break label439;
        }
        if (localzri.fromType == 1)
        {
          TroopClipPic localTroopClipPic = new TroopClipPic();
          localTroopClipPic.id = str;
          localTroopClipPic.clipInfo = localzri.clipInfo;
          localTroopClipPic.type = localzri.type;
          localArrayList.add(localTroopClipPic);
          if (localzri.aYK) {
            localHashSet.add(str);
          }
        }
        if (!str.equals(String.valueOf(paramInt))) {
          break label439;
        }
        i = 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int j = -1;
        continue;
      }
      if (i != 0)
      {
        this.uK.remove(paramzri);
        b(paramzri);
        return false;
      }
      paramzri.baF = String.valueOf(paramInt);
      paramzri.fromType = 1;
      paramzri.isUploading = false;
      localObject = new TroopClipPic();
      ((TroopClipPic)localObject).id = paramzri.baF;
      ((TroopClipPic)localObject).type = paramzri.type;
      ((TroopClipPic)localObject).clipInfo = paramzri.clipInfo;
      localArrayList.add(localObject);
      if (paramzri.aYK) {
        localHashSet.add(paramzri.baF);
      }
      if (this.mApp != null)
      {
        paramzri = (TroopManager)this.mApp.getManager(52);
        if (paramzri != null)
        {
          localObject = paramzri.b(String.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin));
          if ((localObject != null) && (localArrayList.size() > 0))
          {
            ((TroopInfo)localObject).mTroopPicList.clear();
            ((TroopInfo)localObject).mTroopPicList.addAll(localArrayList);
            ((TroopInfo)localObject).mTroopVerifyingPics.clear();
            ((TroopInfo)localObject).mTroopVerifyingPics.addAll(localHashSet);
            ThreadManager.post(new TroopPhotoController.4(this, paramzri, (TroopInfo)localObject), 8, null, false);
          }
        }
      }
      return true;
    }
  }
  
  public boolean ag(String paramString1, String paramString2)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onPicPicked clip=%s path=%s", new Object[] { paramString2, paramString1 }));
    }
    if (iv(paramString1)) {}
    TroopClipPic localTroopClipPic;
    do
    {
      do
      {
        return false;
      } while (ah(paramString1, paramString2));
      localTroopClipPic = new TroopClipPic();
      localTroopClipPic.id = paramString1;
      localTroopClipPic.clipInfo = paramString2;
      localTroopClipPic.type = this.mType;
      localTroopClipPic.ts = SystemClock.uptimeMillis();
    } while (this.uK.size() >= 7);
    paramString1 = new zri();
    paramString1.baE = localTroopClipPic.id;
    paramString1.clipInfo = localTroopClipPic.clipInfo;
    paramString1.fromType = 2;
    paramString1.isUploading = true;
    paramString1.baF = null;
    paramString1.type = localTroopClipPic.type;
    paramString1.ts = localTroopClipPic.ts;
    this.uK.add(paramString1);
    this.rN.add(localTroopClipPic);
    a(paramString1);
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onPicPicked uploadPaths=[size=%d, %s]", new Object[] { Integer.valueOf(this.rN.size()), Arrays.toString(this.uK.toArray()) }));
    }
    if (this.eH == null)
    {
      paramString1 = localObject;
      if ((paramString1 == null) || (!paramString1.hq(this.mType))) {
        break label332;
      }
    }
    label332:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        startUpload();
      }
      anot.a(this.mApp, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      return true;
      paramString1 = (ztd.c)this.eH.get();
      break;
    }
  }
  
  protected boolean ah(String paramString1, String paramString2)
  {
    if (!(this.mActivity instanceof TroopAvatarWallEditActivity))
    {
      ztd.b localb;
      Bundle localBundle;
      if (this.eI != null)
      {
        localb = (ztd.b)this.eI.get();
        if (localb != null)
        {
          localBundle = new Bundle();
          localBundle.putString("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
          localBundle.putString("key_clip_info", paramString2);
          if (this.mType != 0) {
            break label105;
          }
        }
      }
      label105:
      for (boolean bool = true;; bool = false)
      {
        localBundle.putBoolean("IS_COVER", bool);
        localBundle.putBoolean("IS_EDIT", true);
        localb.bw(localBundle);
        return true;
        localb = null;
        break;
      }
    }
    return false;
  }
  
  public void b(zri paramzri)
  {
    Iterator localIterator = this.uL.iterator();
    while (localIterator.hasNext()) {
      ((ztd.a)localIterator.next()).e(paramzri);
    }
    if (this.UZ >= this.uK.size())
    {
      crJ();
      Fv(this.UZ);
    }
  }
  
  public void c(zri paramzri)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(52)).b(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
    if ((localTroopInfo != null) && ((localTroopInfo.troopTypeExt == 2) || (localTroopInfo.troopTypeExt == 4)) && (localTroopInfo.isAdmin()))
    {
      paramzri.aYK = true;
      if ((!this.mApp.getPreferences().getBoolean("has_shown_same_city_picture_uploaded_dialog", false)) && (this.mActivity != null) && (!this.mActivity.isFinishing()))
      {
        aqha.a(this.mActivity, 230, null, this.mActivity.getString(2131698313), null, this.mActivity.getString(2131698303), new aqha.a(), null).show();
        this.mApp.getPreferences().edit().putBoolean("has_shown_same_city_picture_uploaded_dialog", true).commit();
      }
    }
  }
  
  public void crH()
  {
    int i = 3;
    int j = 0;
    if (this.mActivity == null) {
      return;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) || (this.bFL > 0))
    {
      if (this.bFL > 0) {}
      for (boolean bool = true;; bool = false)
      {
        BV(bool);
        anot.a(this.mApp, "dc00899", "Grp_certified", "", "data", "exp_edit_head", 3, 0, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
        return;
      }
    }
    if (this.fp == null) {
      this.fp = new int[ceU];
    }
    this.fp[0] = 13;
    this.fp[1] = 14;
    this.fp[2] = 16;
    while (i < ceU)
    {
      this.fp[i] = -1;
      i += 1;
    }
    if (this.cm == null) {
      this.cm = this.mActivity.getResources().getStringArray(2130968638);
    }
    ausj localausj = (ausj)auss.a(this.mActivity, null);
    i = j;
    if (i < this.fp.length)
    {
      if (this.fp[i] == 16) {
        localausj.addCancelButton(this.cm[this.fp[i]]);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.fp[i] >= 0) && (this.fp[i] < this.cm.length)) {
          localausj.addButton(this.cm[this.fp[i]], 1);
        }
      }
    }
    localausj.a(new zte(this, localausj));
    localausj.show();
  }
  
  public void crK()
  {
    if (x != null)
    {
      Object localObject = x;
      localObject = aqhu.getRealPathFromContentURI(this.mActivity, (Uri)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        zti.l(this.mActivity, (String)localObject, zti.fG(this.mType));
      }
    }
  }
  
  protected void crL()
  {
    this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.mApp.getManager(52)).b(String.valueOf(this.mTroopUin));
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.mTroopUin;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo, this.mCtx.getResources(), this.mApp.getCurrentAccountUin());
  }
  
  @NonNull
  public List<zri> dr()
  {
    return this.uK;
  }
  
  public void ff(int paramInt)
  {
    Object localObject = (zri)this.uK.get(paramInt);
    ArrayList localArrayList;
    if (apqw.isNumeric(((zri)localObject).baF))
    {
      anot.a(this.mApp, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "del_head", 0, 0, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(((zri)localObject).baF));
      this.jdField_b_of_type_Apru.d(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 2, localArrayList);
    }
    this.uK.remove(localObject);
    b((zri)localObject);
    if ((((zri)localObject).fromType == 1) && (!TextUtils.isEmpty(((zri)localObject).baF)) && (apqw.isNumeric(((zri)localObject).baF)))
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mTroopPicList);
      Iterator localIterator = localArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
          if (((zri)localObject).baF.equals(localTroopClipPic.id))
          {
            localArrayList.remove(localTroopClipPic);
            paramInt = 1;
            i = paramInt;
            if (paramInt != 0)
            {
              this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mTroopPicList.clear();
              this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mTroopPicList.addAll(localArrayList);
              this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mTroopVerifyingPics.remove(((zri)localObject).baF);
            }
          }
        }
      }
    }
    for (int i = paramInt;; i = 0)
    {
      if ((this.mApp != null) && (i != 0))
      {
        localObject = (TroopManager)this.mApp.getManager(52);
        if (localObject != null) {
          ThreadManager.post(new TroopPhotoController.6(this, (TroopManager)localObject), 8, null, false);
        }
      }
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean iu(String paramString)
  {
    return this.rN.size() == 0;
  }
  
  protected boolean iv(String paramString)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt == 2) || (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt == 3) || (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt == 4))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth < 100) || (localOptions.outHeight < 100))
      {
        QQToast.a(this.mActivity, 2131699466, 1).show();
        return true;
      }
    }
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    Iterator localIterator = this.uL.iterator();
    while (localIterator.hasNext()) {
      ((ztd.a)localIterator.next()).onDataSetChanged();
    }
    if (this.UZ >= this.uK.size())
    {
      this.UZ = this.uK.size();
      Fv(this.UZ);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_Apru.f(this);
    this.mApp.removeObserver(this.k);
    this.uL.clear();
  }
  
  public void onItemSelect(int paramInt)
  {
    this.UZ = paramInt;
    crJ();
    Fv(paramInt);
  }
  
  public void startUpload()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, "startUpload");
    }
    AccountManager localAccountManager = (AccountManager)this.mApp.getManager(0);
    String str = apuh.k(this.mApp);
    if (str == null)
    {
      localAccountManager.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    a(this.rN, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopcode, str, this.mApp.getCurrentAccountUin());
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof TroopUploadingThread.a));
        paramObservable = (TroopUploadingThread.a)paramObject;
      } while (paramObservable.type != this.mType);
      paramObject = a(paramObservable.ts);
    } while (paramObject == null);
    switch (paramObservable.dWB)
    {
    default: 
      return;
    case 0: 
      paramObject.progress = paramObservable.result;
      this.handler.post(new TroopPhotoController.1(this, paramObject, paramObservable));
      return;
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(paramObservable.result), Integer.valueOf(paramObservable.dWC), paramObject }));
      }
      int i = paramObservable.result;
      paramObservable = new TroopPhotoController.2(this, paramObservable, paramObject, i);
      this.handler.post(paramObservable);
      zti.s(i, paramObject.baE, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      return;
    }
    anot.a(this.mApp, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(paramObservable.result), "", "");
    if (TextUtils.isEmpty(paramObservable.errorMsg)) {}
    for (paramObservable = zti.d(this.mActivity, paramObservable.result);; paramObservable = paramObservable.errorMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("update() failed info=%s", new Object[] { paramObject }));
      }
      paramObservable = new TroopPhotoController.3(this, paramObject, paramObservable);
      this.handler.post(paramObservable);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(zri paramzri, TroopUploadingThread.a parama);
    
    public abstract void d(zri paramzri);
    
    public abstract void e(zri paramzri);
    
    public abstract void onDataSetChanged();
    
    public abstract void onItemSelect(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void bw(Bundle paramBundle);
  }
  
  public static abstract interface c
  {
    public abstract boolean hq(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztd
 * JD-Core Version:    0.7.0.1
 */