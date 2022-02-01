import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.7;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.8;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.a;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xtp
  extends sxn
  implements DialogInterface.OnCancelListener, AbsListView.e, xsi.a
{
  String QE;
  xtp.a a;
  String aRJ;
  String aWf;
  xuh b;
  private int bFu;
  int bWP = 1;
  boolean biK = false;
  public xto c;
  public ArrayList<xuf> dQ = new ArrayList();
  long lastTime;
  int mCurType;
  String mTroopUin;
  
  public xtp(Activity paramActivity, sxm paramsxm, xuh paramxuh, String paramString)
  {
    super(paramActivity, paramsxm);
    this.c = ((xto)paramsxm);
    this.jdField_b_of_type_Xuh = paramxuh;
    this.aWf = paramString;
    if (TextUtils.isEmpty(this.aWf)) {
      this.aWf = "0";
    }
  }
  
  private int a(File paramFile1, AIOFilePicData paramAIOFilePicData, File paramFile2)
  {
    File localFile = paramAIOFilePicData.c(20);
    paramFile1 = localFile;
    if (localFile == null)
    {
      localFile = paramAIOFilePicData.c(18);
      paramFile1 = localFile;
      if (localFile == null)
      {
        paramFile1 = paramAIOFilePicData.c(16);
        if (paramFile1 == null) {
          break label173;
        }
      }
    }
    long l = Utils.getUsableSpace(Environment.getExternalStorageDirectory());
    if (paramFile1.length() > l)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_FULL");
      }
      return 22;
    }
    paramAIOFilePicData = new File(paramFile2, paramFile1.getName() + ".jpg");
    if (!dx.copyFile(paramFile1, paramAIOFilePicData))
    {
      if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_UNABLE");
        }
        return 24;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_UNKNOW");
      }
      return 21;
    }
    aqhu.cn(this.mContext, paramAIOFilePicData.getAbsolutePath());
    label173:
    return 20;
  }
  
  private int a(File paramFile1, AIOImageData paramAIOImageData, File paramFile2)
  {
    paramFile1 = paramAIOImageData.c(2);
    if (paramFile1 != null)
    {
      long l = Utils.getUsableSpace(Environment.getExternalStorageDirectory());
      if (paramFile1.length() > l)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_FULL");
        }
        return 22;
      }
      paramAIOImageData = new File(paramFile2, paramFile1.getName() + ".jpg");
      if (!dx.copyFile(paramFile1, paramAIOImageData))
      {
        if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_UNABLE");
          }
          return 24;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_UNKNOW");
        }
        return 21;
      }
      aqhu.cn(this.mContext, paramAIOImageData.getAbsolutePath());
    }
    return 20;
  }
  
  public static void v(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramContext, SendPhotoActivity.class);
    paramIntent = new Bundle(paramIntent.getExtras());
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent = wja.a(localIntent, null);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
    paramIntent.putBoolean("send_in_background", false);
    localIntent.putExtras(paramIntent);
    paramContext.startActivity(localIntent);
  }
  
  protected AbstractImageAdapter a(Activity paramActivity, int paramInt)
  {
    this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = new AIOPhotoListAdapter(this.mContext, paramInt, this.c, this.jdField_b_of_type_Xuh, this.mGridView);
    this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.c);
    return this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter;
  }
  
  protected AdapterView.c a()
  {
    return new xtu(this);
  }
  
  protected GestureSelectGridView.b a()
  {
    return new xtv(this);
  }
  
  boolean a(View paramView, sxy paramsxy)
  {
    Object localObject = (AIOPhotoListAdapter.a)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((AIOPhotoListAdapter.a)localObject).tO;
      localObject = ((AIOPhotoListAdapter.a)localObject).mSelectedIconView;
      switch (paramsxy.uG())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setImageResource(2130846610);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130846607);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    return false;
  }
  
  boolean a(xuf paramxuf, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = ww();
    if (paramBoolean2)
    {
      if (AIOShortVideoData.class.isInstance(paramxuf.e)) {
        return false;
      }
      if (i == 2) {
        return false;
      }
    }
    int j = paramxuf.uG();
    if (((j == 1) && (paramBoolean1)) || ((j == 2) && (!paramBoolean1))) {
      return false;
    }
    if ((j == 2) && (paramBoolean1) && (this.dQ.size() >= 20))
    {
      long l = System.currentTimeMillis();
      if (l - this.lastTime >= 700L)
      {
        if (i != 2) {
          break label175;
        }
        QQToast.a(this.mContext, 1, acfp.m(2131702258) + 20 + acfp.m(2131702253), 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      }
      for (;;)
      {
        this.lastTime = l;
        return false;
        label175:
        QQToast.a(this.mContext, 1, acfp.m(2131702248) + 20 + acfp.m(2131702252), 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      }
    }
    if ((AIOFilePicData.class.isInstance(paramxuf.e)) && (paramxuf.e.c(20) == null) && (paramxuf.e.c(18) == null) && (paramxuf.e.c(16) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "AIOFilePicData has null path!");
      }
      return false;
    }
    if (paramBoolean1)
    {
      paramxuf.setSelected(1);
      this.dQ.add(paramxuf);
    }
    for (;;)
    {
      return true;
      paramxuf.setSelected(2);
      this.dQ.remove(paramxuf);
    }
  }
  
  protected void bBS()
  {
    int k = 0;
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.setMainTitle(2131690170);
    localausj.addButton(2131690171, 5);
    int m = ww();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.dQ.size())
      {
        if (((((xuf)this.dQ.get(i)).e instanceof AIOImageData)) && (((AIOImageData)((xuf)this.dQ.get(i)).e).uuid == null)) {
          j = 1;
        }
      }
      else
      {
        if ((m == 1) && (j == 0)) {
          localausj.addButton(2131694765);
        }
        if ((this.biK) && (m == 1) && (j == 0)) {
          localausj.addButton(2131694753, 5);
        }
        localausj.addCancelButton(2131721058);
        localausj.a(new xtq(this, localausj));
        localausj.show();
        reportData("Multi_Pic_Forward", this.dQ.size());
        return;
      }
      i += 1;
    }
  }
  
  protected void bBT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "saveAllImage");
    }
    Object localObject = this.dQ.iterator();
    xuf localxuf;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break label213;
      }
      localxuf = (xuf)((Iterator)localObject).next();
      if (!AIOImageData.class.isInstance(localxuf.e)) {
        break;
      }
    } while (((AIOImageData)localxuf.e).c(2) != null);
    label213:
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        c(new Integer[] { Integer.valueOf(1) });
      }
      for (;;)
      {
        reportData("Multi_Pic_Save", this.dQ.size());
        return;
        if (!AIOShortVideoData.class.isInstance(localxuf.e)) {
          break;
        }
        break;
        localObject = BaseApplication.getContext();
        boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131697129), "qqsetting_auto_receive_pic_key", true);
        i = aqiw.getNetworkType((Context)localObject);
        if (i == -1) {
          fK(1, this.dQ.size());
        } else if ((bool) || (i == 1)) {
          c(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
        } else {
          fK(0, 0);
        }
      }
    }
  }
  
  protected void bBU()
  {
    long[] arrayOfLong = new long[this.dQ.size()];
    int i = 0;
    while (i < this.dQ.size())
    {
      if ((this.dQ.get(i) != null) && (((xuf)this.dQ.get(i)).e != null)) {
        arrayOfLong[i] = ((xuf)this.dQ.get(i)).e.id;
      }
      i += 1;
    }
    if (this.jdField_b_of_type_Xuh.asBinder().pingBinder())
    {
      this.jdField_b_of_type_Xuh.b(arrayOfLong);
      QQToast.a(this.mContext, this.mContext.getString(2131694101), 0).show();
    }
  }
  
  void bKm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardAllImage");
    }
    Object localObject = BaseApplication.getContext();
    boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131697129), "qqsetting_auto_receive_pic_key", true);
    int i;
    int j;
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1)
    {
      i = 1;
      if (aqiw.getNetworkType(BaseApplication.getContext()) != -1) {
        break label136;
      }
      j = 1;
      label64:
      localObject = this.dQ.iterator();
      xuf localxuf;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localxuf = (xuf)((Iterator)localObject).next();
      } while ((!AIOImageData.class.isInstance(localxuf.e)) || (localxuf.e.c(2) != null));
    }
    for (int k = 0;; k = 1)
    {
      if (k != 0)
      {
        bKn();
        return;
        i = 0;
        break;
        label136:
        j = 0;
        break label64;
      }
      if (j != 0)
      {
        fK(1, this.dQ.size());
        return;
      }
      if ((bool) || (i != 0))
      {
        c(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
        return;
      }
      fK(0, 1);
      return;
    }
  }
  
  void bKn()
  {
    if ((this.dQ != null) && (this.dQ.get(0) != null))
    {
      localObject1 = (xuf)this.dQ.get(0);
      if (AIOImageData.class.isInstance(((xuf)localObject1).e))
      {
        localObject2 = (AIOImageData)((xuf)localObject1).e;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).cH(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).cH(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.dQ.size() > 1) {
          ((Bundle)localObject1).putString("forward_text", this.dQ.size() + acfp.m(2131702250));
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.dQ.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localxuf = (xuf)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localxuf.e)) {
            ((ArrayList)localObject2).add(((AIOImageData)localxuf.e).aVX);
          } else if (AIOFilePicData.class.isInstance(localxuf.e)) {
            if (((AIOFilePicData)localxuf.e).c(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVY);
            } else if (((AIOFilePicData)localxuf.e).c(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVX);
            } else if (((AIOFilePicData)localxuf.e).c(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVW);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ahgq.f(this.mContext, (Intent)localObject2, 1);
      }
    }
    while (!QLog.isColorLevel())
    {
      xuf localxuf;
      do
      {
        return;
      } while (!AIOFilePicData.class.isInstance(((xuf)localObject1).e));
      Object localObject2 = (AIOFilePicData)((xuf)localObject1).e;
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 12);
      Object localObject3 = ((AIOFilePicData)localObject2).cH(18);
      ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).cH(16));
      ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
      ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
      if (this.dQ.size() > 1) {
        ((Bundle)localObject1).putString("forward_text", this.dQ.size() + acfp.m(2131702251));
      }
      ((Bundle)localObject1).putBoolean("sendMultiple", true);
      localObject2 = new ArrayList();
      localObject3 = this.dQ.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localxuf = (xuf)((Iterator)localObject3).next();
        if (AIOImageData.class.isInstance(localxuf.e)) {
          ((ArrayList)localObject2).add(((AIOImageData)localxuf.e).aVX);
        } else if (AIOFilePicData.class.isInstance(localxuf.e)) {
          if (((AIOFilePicData)localxuf.e).c(20) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVY);
          } else if (((AIOFilePicData)localxuf.e).c(18) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVX);
          } else if (((AIOFilePicData)localxuf.e).c(16) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVW);
          }
        }
      }
      ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ahgq.f(this.mContext, (Intent)localObject2, 1);
      return;
    }
    QLog.d("AIOImageListScene", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  void c(Integer... paramVarArgs)
  {
    eY(paramVarArgs[0].intValue(), 0);
    this.jdField_a_of_type_Xtp$a = new xtp.a(this.dQ);
    this.jdField_a_of_type_Xtp$a.execute(paramVarArgs);
  }
  
  public void ceN()
  {
    if (this.jdField_b_of_type_Xuh != null) {
      this.jdField_b_of_type_Xuh.loadMedias(0);
    }
  }
  
  void ceO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToGroupAlbum()");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.dQ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (xuf)localIterator.next();
      if (AIOImageData.class.isInstance(((xuf)localObject).e))
      {
        localObject = (AIOImageData)((xuf)localObject).e;
        localArrayList1.add(((AIOImageData)localObject).aVW);
        localArrayList2.add(((AIOImageData)localObject).uuid);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).timestamp));
      }
    }
    xtm.a(this.mContext, this.aWf, this.QE, this.aRJ, localArrayList1, localArrayList2, localArrayList3, 2, null, null);
  }
  
  void ceP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToQZoneAlbum()");
    }
    xtm.a(this.mContext, this.aWf, this.aRJ, this.bWP, (List)this.dQ.clone(), this.biK, this.QE);
  }
  
  void ceQ()
  {
    ((AIOPhotoListAdapter)this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).aTT = this.aOc;
    int i;
    if (this.aOc)
    {
      this.Bh.setText(2131690105);
      this.bottomBar.setVisibility(0);
      i = ww();
      if (i == 1)
      {
        this.forwardBtn.setEnabled(true);
        this.forwardBtn.setClickable(true);
        this.oS.setEnabled(true);
        this.oS.setClickable(true);
        this.oT.setEnabled(true);
        this.oT.setClickable(true);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.notifyDataSetChanged();
      return;
      if (i == 2)
      {
        if (this.dQ.size() > 1)
        {
          this.forwardBtn.setEnabled(false);
          this.forwardBtn.setClickable(false);
          this.oS.setEnabled(false);
          this.oS.setClickable(false);
        }
        for (;;)
        {
          this.oT.setEnabled(true);
          this.oT.setClickable(true);
          break;
          this.forwardBtn.setEnabled(true);
          this.forwardBtn.setClickable(true);
          this.oS.setEnabled(false);
          this.oS.setClickable(false);
        }
      }
      this.forwardBtn.setEnabled(false);
      this.forwardBtn.setClickable(false);
      this.oS.setEnabled(false);
      this.oS.setClickable(false);
      this.oT.setEnabled(false);
      this.oT.setClickable(false);
      continue;
      this.Bh.setText(2131690235);
      this.bottomBar.setVisibility(8);
      Iterator localIterator = this.dQ.iterator();
      while (localIterator.hasNext()) {
        ((sxy)localIterator.next()).setSelected(2);
      }
      this.dQ.clear();
    }
  }
  
  public void e(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6)
  {
    if (this.c == null) {}
    Object localObject1;
    label24:
    int i;
    int j;
    int k;
    label109:
    do
    {
      return;
      localObject4 = this.c;
      if (paramInt3 != 1) {
        break;
      }
      localObject1 = ???;
      i = ((xto)localObject4).a(paramLong, paramInt1, paramInt2, (String)localObject1, true);
      if (paramInt2 != 1) {
        break label240;
      }
      j = this.mGridView.getFirstVisiblePosition();
      k = this.mGridView.getChildCount();
      if ((i >= j) && (i <= k + j - 1))
      {
        localObject1 = this.mGridView.getChildAt(i - j);
        ((AIOPhotoListAdapter)this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).r(i, (View)localObject1);
      }
      if ((paramInt2 != 2) || (this.jdField_a_of_type_Xtp$a == null)) {
        break label313;
      }
      localObject1 = this.jdField_a_of_type_Xtp$a;
    } while ((((xtp.a)localObject1).g == null) || (((xtp.a)localObject1).g.e.id != paramLong) || (((xtp.a)localObject1).g.e.subId != paramInt1));
    Object localObject4 = (AIOImageData)((xtp.a)localObject1).g.e;
    if (paramInt3 == 1) {}
    for (;;)
    {
      ((AIOImageData)localObject4).aVX = ???;
      ((xtp.a)localObject1).g.isDownloading = false;
      synchronized (((xtp.a)localObject1).g)
      {
        ((xtp.a)localObject1).g.notifyAll();
        return;
      }
      Object localObject3 = "I:E";
      break label24;
      label240:
      if (paramInt2 != 16) {
        break label109;
      }
      j = this.mGridView.getFirstVisiblePosition();
      k = this.mGridView.getChildCount();
      if ((i < j) || (i > k + j - 1)) {
        break label109;
      }
      localObject3 = this.mGridView.getChildAt(i - j);
      ((AIOPhotoListAdapter)this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).r(i, (View)localObject3);
      break label109;
      label313:
      break;
      ??? = "I:E";
    }
  }
  
  void eY(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showProgressDialog step = " + paramInt1);
    }
    if (this.pd == null)
    {
      this.pd = new ReportDialog(this.mContext, 2131756467);
      this.pd.setCancelable(true);
      this.pd.show();
      this.pd.setContentView(2131559761);
      this.pd.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.pd.findViewById(2131373180);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localTextView.setText(str);
      if (!this.pd.isShowing()) {
        this.pd.show();
      }
      return;
      str = localTextView.getResources().getText(2131690169) + str;
      continue;
      str = localTextView.getResources().getText(2131690167) + str;
    }
  }
  
  public void fG(long paramLong)
  {
    if ((this.jdField_a_of_type_Sxz != null) && (this.jdField_a_of_type_Sxz.a() == this)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onRevokeMsg seq:" + paramLong + ", current:" + bool);
      }
      this.mContext.runOnUiThread(new AIOImageListScene.8(this, paramLong, bool));
      return;
    }
  }
  
  void fK(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showDownloadResult type = " + paramInt1);
    }
    if (this.t != null) {
      this.t.dismiss();
    }
    this.t = aqha.a(this.mContext, 230);
    this.t.setOnDismissListener(new xts(this));
    Object localObject;
    switch (paramInt1)
    {
    case 2: 
    default: 
      this.t = null;
      return;
    case 1: 
      this.t.setTitle(String.format(this.mContext.getResources().getString(2131690168), new Object[] { Integer.valueOf(paramInt2) }));
      this.t.setPositiveButton(2131721079, new aqha.a());
      this.t.show();
      return;
    case 0: 
      this.t.setTitle(2131690126);
      localObject = new xtt(this, paramInt2);
      this.t.setNegativeButton(2131721058, (DialogInterface.OnClickListener)localObject);
      this.t.setPositiveButton(2131720034, (DialogInterface.OnClickListener)localObject);
      this.t.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showSDCardResult type = " + paramInt2);
    }
    String str;
    if (paramInt2 == 22)
    {
      localObject = this.mContext.getString(2131719250);
      str = this.mContext.getString(2131719249);
    }
    for (;;)
    {
      this.t = aqha.a(this.mContext, 230, (String)localObject, str, null, null);
      this.t.setTitle((String)localObject);
      this.t.setMessage(str);
      this.t.setPositiveButton(2131721079, new aqha.a());
      this.t.show();
      return;
      if (paramInt2 == 24)
      {
        localObject = this.mContext.getString(2131719257);
        str = this.mContext.getString(2131719256);
      }
      else if (paramInt2 == 23)
      {
        localObject = this.mContext.getString(2131719254);
        str = this.mContext.getString(2131719253);
      }
      else
      {
        localObject = null;
        str = null;
      }
    }
  }
  
  void fL(int paramInt1, int paramInt2)
  {
    if (this.pd != null)
    {
      this.pd.dismiss();
      this.pd = null;
    }
    switch (paramInt1)
    {
    case 10: 
    default: 
      return;
    case 20: 
      QQToast.a(this.mContext, 2, this.mContext.getResources().getString(2131690166) + acbn.oM, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    case 21: 
      QQToast.a(this.mContext, 1, this.mContext.getResources().getString(2131690165) + acbn.oM, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    case 22: 
    case 23: 
    case 24: 
      fK(3, 0);
      return;
    case 11: 
      fK(1, paramInt2);
      return;
    }
    bKn();
  }
  
  void initData()
  {
    this.aOc = false;
    this.lastTime = 0L;
    Bundle localBundle = this.mContext.getIntent().getExtras();
    this.biK = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.aOb = localBundle.getBoolean("extra.RIGHT_EXIT_TRANSITION", false);
    this.mTroopUin = localBundle.getString("extra.GROUP_UIN");
    if (this.biK)
    {
      this.QE = localBundle.getString("extra.GROUP_UIN");
      this.aRJ = localBundle.getString("extra.GROUP_CODE");
      if (((this.QE == null) || (this.aRJ == null) || (this.aWf == null)) && (QLog.isColorLevel())) {
        QLog.i("AIOImageListScene", 2, "mGroupUin=" + this.QE + ", mGroupCode=" + this.aRJ + ", mMyUin=" + this.aWf);
      }
    }
    this.bWP = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.mCurType = localBundle.getInt("forward_source_uin_type", -1);
    this.c.SL();
    this.c.ceM();
    xsi.a().a(this);
  }
  
  public void notifyDataSetChanged()
  {
    if (this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null)
    {
      this.mGridView.post(new AIOImageListScene.7(this));
      this.title.setText(2131720472);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label26;
      }
      v(this.mContext, paramIntent);
    }
    label26:
    do
    {
      do
      {
        return;
      } while ((99 != paramInt1) && (98 != paramInt1));
      if (this.dQ != null)
      {
        paramIntent = this.dQ.iterator();
        while (paramIntent.hasNext()) {
          ((sxy)paramIntent.next()).setSelected(2);
        }
        this.dQ.clear();
      }
      if (this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null) {
        this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.notifyDataSetChanged();
      }
      this.aOc = false;
      if (this.Bh != null) {
        this.Bh.setText(2131690235);
      }
    } while (this.bottomBar == null);
    this.bottomBar.setVisibility(8);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.pd = null;
    paramDialogInterface = this.jdField_a_of_type_Xtp$a;
    if (paramDialogInterface != null) {
      paramDialogInterface.mRunning = false;
    }
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    initData();
    super.onCreate(paramViewGroup);
    this.mGridView.setOnScrollListener(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.dQ.clear();
    this.dQ = null;
    this.c = null;
    xsi.a().b(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.Bh != null))
    {
      yc(this.Bh.getText().toString());
      if (!this.aOc)
      {
        ceQ();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.mGridView.getLastVisiblePosition();
      int i = this.c.wu();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.bFu != i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "[onScroll] loadMedias: mLastLoadingCount=" + this.bFu);
        }
        this.bFu = i;
        ((AIOPhotoListAdapter)this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).ay(true);
        this.jdField_b_of_type_Xuh.loadMedias(0);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.c != null)
    {
      j = this.c.wt();
      k = this.c.getLastVisiblePosition();
      i = this.c.getFirstVisiblePosition();
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onStart start FirstVisiblePosition " + i + " LastVisiblePosition " + k + " SelectedIndex = " + j);
      }
      if ((j > k) || (j < i) || (j - i < 4))
      {
        if ((k <= 0) || (j <= k)) {
          break label289;
        }
        j -= k;
        if ((j > 4) && (j % 4 == 0))
        {
          i = j + i + 4;
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageListScene", 2, "onStart selectedIndex > lastPosition n " + i);
          }
          this.mGridView.setSelection(i);
          this.c.Du(this.mGridView.getFirstVisiblePosition());
          this.c.Dv(this.mGridView.getLastVisiblePosition());
        }
      }
      else if (QLog.isColorLevel())
      {
        i = this.c.getSelectedIndex();
        j = this.c.getLastVisiblePosition();
        k = this.c.getFirstVisiblePosition();
        QLog.d("AIOImageListScene", 2, "onStart end FirstVisiblePosition " + k + " LastVisiblePosition " + j + " SelectedIndex = " + i);
      }
    }
    label289:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        int j;
        int k;
        return;
        int i = j + i + 8;
        continue;
        this.mGridView.setSelection(j);
      }
    }
    QLog.d("AIOImageListScene", 2, "onStart error!! mAIOModel == null ");
  }
  
  public Rect q()
  {
    int i = this.mGridView.getFirstVisiblePosition();
    int j = this.c.wt();
    View localView = this.mGridView.getChildAt(j - i);
    if (localView != null)
    {
      Rect localRect = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
      i = localView.getWidth();
      j = localView.getHeight();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      Point localPoint = new Point();
      if ((i > 0) && (j > 0))
      {
        localPoint.set(-localView.getScrollX(), -localView.getScrollY());
        if (localViewGroup != null) {
          localViewGroup.getChildVisibleRect(localView, localRect, localPoint);
        }
      }
      return localRect;
    }
    return null;
  }
  
  void reportData(String paramString, int paramInt) {}
  
  protected View.OnClickListener w()
  {
    return new xtw(this);
  }
  
  public int ww()
  {
    if ((this.dQ == null) || (this.dQ.isEmpty())) {
      return 0;
    }
    AIORichMediaData localAIORichMediaData = ((xuf)this.dQ.get(0)).e;
    if ((AIOImageData.class.isInstance(localAIORichMediaData)) || (AIOFilePicData.class.isInstance(localAIORichMediaData))) {
      return 1;
    }
    if (AIOShortVideoData.class.isInstance(localAIORichMediaData)) {
      return 2;
    }
    return 0;
  }
  
  void yc(String paramString)
  {
    if (paramString.equalsIgnoreCase(this.mContext.getResources().getString(2131690235)))
    {
      this.aOc = true;
      reportData("Multi_Pic_choose", 0);
      return;
    }
    this.aOc = false;
  }
  
  class a
    extends AsyncTask<Integer, Integer, Integer>
  {
    xuf[] a;
    int adR;
    xuf g;
    boolean mRunning = true;
    
    public a()
    {
      Object localObject;
      this.a = ((xuf[])localObject.toArray(new xuf[0]));
    }
    
    private int a(xuf[] paramArrayOfxuf, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, Integer... paramVarArgs)
    {
      int i;
      if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_UNMOUNT");
        }
        i = 23;
      }
      File localFile;
      Object localObject;
      int j;
      do
      {
        return i;
        localFile = new File(acbn.oM);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        paramInt1 = 0;
        if (paramInt1 >= paramArrayOfxuf.length) {
          break label267;
        }
        localObject = paramArrayOfxuf[paramInt1];
        if (!paramBoolean) {
          return 1;
        }
        if (!AIOImageData.class.isInstance(((xuf)localObject).e)) {
          break;
        }
        localObject = (AIOImageData)((xuf)localObject).e;
        publishProgress(new Integer[] { Integer.valueOf(paramInt2 * 100 / paramVarArgs.length + paramInt1 * 100 / paramVarArgs.length / paramArrayOfxuf.length & 0xFFFF | paramInt3 << 16) });
        j = xtp.a(xtp.this, null, (AIOImageData)localObject, localFile);
        i = j;
      } while (j != 20);
      do
      {
        do
        {
          paramInt1 += 1;
          break;
        } while (!AIOFilePicData.class.isInstance(((xuf)localObject).e));
        localObject = (AIOFilePicData)((xuf)localObject).e;
        publishProgress(new Integer[] { Integer.valueOf(paramInt2 * 100 / paramVarArgs.length + paramInt1 * 100 / paramVarArgs.length / paramArrayOfxuf.length & 0xFFFF | paramInt3 << 16) });
        i = xtp.a(xtp.this, null, (AIOFilePicData)localObject, localFile);
      } while (i == 20);
      return i;
      label267:
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_COMPLETE");
      }
      return 20;
    }
    
    /* Error */
    protected Integer doInBackground(Integer... paramVarArgs)
    {
      // Byte code:
      //   0: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3: ifeq +525 -> 528
      //   6: ldc 63
      //   8: iconst_2
      //   9: new 127	java/lang/StringBuilder
      //   12: dup
      //   13: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   16: ldc 130
      //   18: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: aload_1
      //   22: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   25: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   28: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   31: goto +497 -> 528
      //   34: iload_3
      //   35: aload_1
      //   36: arraylength
      //   37: if_icmpge +481 -> 518
      //   40: aload_1
      //   41: iload_3
      //   42: aaload
      //   43: invokevirtual 144	java/lang/Integer:intValue	()I
      //   46: istore 4
      //   48: aload_0
      //   49: getfield 26	xtp$a:mRunning	Z
      //   52: ifne +8 -> 60
      //   55: iconst_1
      //   56: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   59: areturn
      //   60: iload_3
      //   61: bipush 100
      //   63: imul
      //   64: aload_1
      //   65: arraylength
      //   66: idiv
      //   67: istore 5
      //   69: aload_0
      //   70: iconst_1
      //   71: anewarray 100	java/lang/Integer
      //   74: dup
      //   75: iconst_0
      //   76: iload 4
      //   78: bipush 16
      //   80: ishl
      //   81: iload 5
      //   83: ldc 101
      //   85: iand
      //   86: ior
      //   87: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   90: aastore
      //   91: invokevirtual 109	xtp$a:publishProgress	([Ljava/lang/Object;)V
      //   94: iload 4
      //   96: tableswitch	default:+439 -> 535, 0:+446->542, 1:+400->496, 2:+446->542
      //   125: aload_0
      //   126: getfield 37	xtp$a:a	[Lxuf;
      //   129: arraylength
      //   130: if_icmpge +424 -> 554
      //   133: aload_0
      //   134: getfield 26	xtp$a:mRunning	Z
      //   137: ifne +8 -> 145
      //   140: iconst_1
      //   141: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   144: areturn
      //   145: aload_0
      //   146: iconst_1
      //   147: anewarray 100	java/lang/Integer
      //   150: dup
      //   151: iconst_0
      //   152: iload_3
      //   153: bipush 100
      //   155: imul
      //   156: aload_1
      //   157: arraylength
      //   158: idiv
      //   159: iload_2
      //   160: bipush 100
      //   162: imul
      //   163: aload_1
      //   164: arraylength
      //   165: idiv
      //   166: aload_0
      //   167: getfield 37	xtp$a:a	[Lxuf;
      //   170: arraylength
      //   171: idiv
      //   172: iadd
      //   173: ldc 101
      //   175: iand
      //   176: iload 4
      //   178: bipush 16
      //   180: ishl
      //   181: ior
      //   182: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   185: aastore
      //   186: invokevirtual 109	xtp$a:publishProgress	([Ljava/lang/Object;)V
      //   189: aload_0
      //   190: getfield 37	xtp$a:a	[Lxuf;
      //   193: iload_2
      //   194: aaload
      //   195: astore 7
      //   197: ldc 88
      //   199: aload 7
      //   201: getfield 92	xuf:e	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
      //   204: invokevirtual 98	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
      //   207: ifeq +340 -> 547
      //   210: aload 7
      //   212: getfield 92	xuf:e	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
      //   215: checkcast 88	com/tencent/mobileqq/activity/aio/photo/AIOImageData
      //   218: astore 6
      //   220: aload 6
      //   222: getfield 147	com/tencent/mobileqq/activity/aio/photo/AIOImageData:aVX	Ljava/lang/String;
      //   225: astore 8
      //   227: ldc 149
      //   229: aload 8
      //   231: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   234: ifeq +6 -> 240
      //   237: goto +310 -> 547
      //   240: aload_0
      //   241: aload 7
      //   243: putfield 154	xtp$a:g	Lxuf;
      //   246: aload_0
      //   247: getfield 26	xtp$a:mRunning	Z
      //   250: ifeq +164 -> 414
      //   253: aload 8
      //   255: ifnull +18 -> 273
      //   258: new 71	java/io/File
      //   261: dup
      //   262: aload 8
      //   264: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
      //   267: invokevirtual 83	java/io/File:exists	()Z
      //   270: ifne +144 -> 414
      //   273: aload_0
      //   274: getfield 154	xtp$a:g	Lxuf;
      //   277: iconst_1
      //   278: putfield 157	xuf:isDownloading	Z
      //   281: aload_0
      //   282: getfield 21	xtp$a:this$0	Lxtp;
      //   285: getfield 161	xtp:b	Lxuh;
      //   288: aload 6
      //   290: getfield 165	com/tencent/mobileqq/activity/aio/photo/AIOImageData:id	J
      //   293: aload 6
      //   295: getfield 168	com/tencent/mobileqq/activity/aio/photo/AIOImageData:subId	I
      //   298: iconst_2
      //   299: invokeinterface 174 5 0
      //   304: aload_0
      //   305: getfield 154	xtp$a:g	Lxuf;
      //   308: astore 7
      //   310: aload 7
      //   312: monitorenter
      //   313: aload_0
      //   314: getfield 154	xtp$a:g	Lxuf;
      //   317: getfield 157	xuf:isDownloading	Z
      //   320: ifeq +10 -> 330
      //   323: aload_0
      //   324: getfield 154	xtp$a:g	Lxuf;
      //   327: invokevirtual 179	java/lang/Object:wait	()V
      //   330: aload 7
      //   332: monitorexit
      //   333: aload 6
      //   335: getfield 182	com/tencent/mobileqq/activity/aio/photo/AIOImageData:bim	Z
      //   338: ifeq +76 -> 414
      //   341: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   344: ifeq +41 -> 385
      //   347: ldc 63
      //   349: iconst_2
      //   350: new 127	java/lang/StringBuilder
      //   353: dup
      //   354: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   357: ldc 184
      //   359: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   362: iload_2
      //   363: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   366: ldc 189
      //   368: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   371: aload 6
      //   373: getfield 147	com/tencent/mobileqq/activity/aio/photo/AIOImageData:aVX	Ljava/lang/String;
      //   376: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   379: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   382: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   385: aload_0
      //   386: aload_0
      //   387: getfield 37	xtp$a:a	[Lxuf;
      //   390: arraylength
      //   391: iload_2
      //   392: isub
      //   393: putfield 191	xtp$a:adR	I
      //   396: bipush 11
      //   398: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   401: areturn
      //   402: astore_1
      //   403: aload 7
      //   405: monitorexit
      //   406: aload_1
      //   407: athrow
      //   408: astore_1
      //   409: iconst_2
      //   410: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   413: areturn
      //   414: aload_0
      //   415: getfield 26	xtp$a:mRunning	Z
      //   418: ifne +8 -> 426
      //   421: iconst_1
      //   422: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   425: areturn
      //   426: aload 6
      //   428: iconst_2
      //   429: invokevirtual 195	com/tencent/mobileqq/activity/aio/photo/AIOImageData:c	(I)Ljava/io/File;
      //   432: ifnonnull +115 -> 547
      //   435: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   438: ifeq +41 -> 479
      //   441: ldc 63
      //   443: iconst_2
      //   444: new 127	java/lang/StringBuilder
      //   447: dup
      //   448: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   451: ldc 197
      //   453: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   456: iload_2
      //   457: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   460: ldc 189
      //   462: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   465: aload 6
      //   467: getfield 147	com/tencent/mobileqq/activity/aio/photo/AIOImageData:aVX	Ljava/lang/String;
      //   470: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   473: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   476: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   479: aload_0
      //   480: aload_0
      //   481: getfield 37	xtp$a:a	[Lxuf;
      //   484: arraylength
      //   485: iload_2
      //   486: isub
      //   487: putfield 191	xtp$a:adR	I
      //   490: bipush 11
      //   492: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   495: areturn
      //   496: aload_0
      //   497: aload_0
      //   498: getfield 37	xtp$a:a	[Lxuf;
      //   501: aload_0
      //   502: getfield 26	xtp$a:mRunning	Z
      //   505: iload 5
      //   507: iload_3
      //   508: iload 4
      //   510: aload_1
      //   511: invokespecial 199	xtp$a:a	([Lxuf;ZIII[Ljava/lang/Integer;)I
      //   514: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   517: areturn
      //   518: iload_2
      //   519: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   522: areturn
      //   523: astore 8
      //   525: goto -195 -> 330
      //   528: iconst_0
      //   529: istore_3
      //   530: iconst_0
      //   531: istore_2
      //   532: goto -498 -> 34
      //   535: iload_3
      //   536: iconst_1
      //   537: iadd
      //   538: istore_3
      //   539: goto -505 -> 34
      //   542: iconst_0
      //   543: istore_2
      //   544: goto -420 -> 124
      //   547: iload_2
      //   548: iconst_1
      //   549: iadd
      //   550: istore_2
      //   551: goto -427 -> 124
      //   554: iload 4
      //   556: iconst_2
      //   557: if_icmpne +9 -> 566
      //   560: bipush 30
      //   562: istore_2
      //   563: goto -28 -> 535
      //   566: bipush 10
      //   568: istore_2
      //   569: goto -34 -> 535
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	572	0	this	a
      //   0	572	1	paramVarArgs	Integer[]
      //   124	445	2	i	int
      //   34	505	3	j	int
      //   46	512	4	k	int
      //   67	439	5	m	int
      //   218	248	6	localAIOImageData	AIOImageData
      //   225	38	8	str	String
      //   523	1	8	localInterruptedException	java.lang.InterruptedException
      // Exception table:
      //   from	to	target	type
      //   313	330	402	finally
      //   330	333	402	finally
      //   403	406	402	finally
      //   0	31	408	java/lang/Throwable
      //   34	60	408	java/lang/Throwable
      //   60	94	408	java/lang/Throwable
      //   124	145	408	java/lang/Throwable
      //   145	237	408	java/lang/Throwable
      //   240	253	408	java/lang/Throwable
      //   258	273	408	java/lang/Throwable
      //   273	313	408	java/lang/Throwable
      //   333	385	408	java/lang/Throwable
      //   385	396	408	java/lang/Throwable
      //   406	408	408	java/lang/Throwable
      //   414	426	408	java/lang/Throwable
      //   426	479	408	java/lang/Throwable
      //   479	496	408	java/lang/Throwable
      //   496	518	408	java/lang/Throwable
      //   313	330	523	java/lang/InterruptedException
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      xtp.this.fL(paramInteger.intValue(), this.adR);
      xtp.this.a = null;
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      int i = paramVarArgs[(paramVarArgs.length - 1)].intValue();
      xtp.this.eY(i >> 16, 0xFFFF & i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtp
 * JD-Core Version:    0.7.0.1
 */