package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingTask;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.UploadItem;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.GridView;
import epl;
import epn;
import epo;
import epp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.util.WeakReference;

public class AvatarWallAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static Uri a;
  public static String a;
  public static final String b = "AVATAR_URL_STR";
  protected static final int c = 100;
  public static final String c = "AVATAR_LOCAL_STR";
  public static final int d = 8;
  public static final String d = "PLUS";
  public static final int e = 0;
  public static final String e = "SYSTEM_PHOTO";
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int k = 0;
  public static final int l = 1;
  public static int m = 0;
  public static final int p = 16;
  public static int q = 7;
  protected static final int r = 13;
  protected static final int s = 14;
  protected int a;
  public Handler a;
  public SparseArray a;
  public QQAppInterface a;
  public TroopAvatarManger a;
  protected AvatarWallAdapter.AddButtonStatusListener a;
  protected FaceDecoder a;
  protected List a;
  Observer a;
  public WeakReference a;
  protected boolean a;
  public int[] a;
  protected String[] a;
  public int b;
  protected Handler b;
  protected boolean b;
  public boolean c = false;
  public boolean d = false;
  public boolean e;
  protected String f;
  protected boolean f = false;
  public String g;
  protected boolean g;
  public String h;
  public boolean h;
  protected int i;
  public boolean i;
  public int j = 0;
  public int n = 0;
  protected final int o = 10;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AvatarWallAdapter";
  }
  
  public AvatarWallAdapter(WeakReference paramWeakReference, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, Handler paramHandler, boolean paramBoolean2, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilObserver = new epl(this);
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_g_of_type_JavaLangString = paramString1;
    this.jdField_h_of_type_JavaLangString = paramString2;
    this.e = paramBoolean1;
    a(paramBoolean2);
    if ((paramWeakReference != null) && (paramWeakReference.get() != null) && (paramQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder((Context)paramWeakReference.get(), paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    }
    paramWeakReference = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger = new TroopAvatarManger(this.jdField_g_of_type_JavaLangString, TroopUploadingTask.class, paramWeakReference);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.qqlite", PhotoListActivity.class.getName());
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      paramActivity.startActivity(localIntent);
      if ((paramActivity instanceof PluginActivity))
      {
        AlbumUtil.a(((PluginActivity)paramActivity).getOutActivity(), false, true);
        return;
      }
      AlbumUtil.a(paramActivity, false, true);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  protected static boolean a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isFile()) {
        paramFile.delete();
      }
      while (!paramFile.delete())
      {
        return false;
        if (paramFile.isDirectory())
        {
          File[] arrayOfFile = paramFile.listFiles();
          if (arrayOfFile != null)
          {
            int i1 = 0;
            while (i1 < arrayOfFile.length)
            {
              a(arrayOfFile[i1]);
              i1 += 1;
            }
          }
        }
      }
    }
    return true;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      return ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131493042);
    }
    return 0;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return -1;
    }
    Object localObject = new File(paramString1);
    BitmapFactory.Options localOptions = ImageUtil.a(((File)localObject).getPath(), 100);
    try
    {
      localObject = BitmapFactory.decodeFile(((File)localObject).getPath(), localOptions);
      paramString2 = new File(paramString2);
      if (paramString2.exists()) {
        return 0;
      }
    }
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
      return -1;
    }
    try
    {
      int i1 = TroopUtils.a(paramString1);
      paramString1 = (String)localObject;
      if (i1 != 0) {
        paramString1 = ImageUtil.b((Bitmap)localObject, i1);
      }
      ImageUtil.a(paramString1, paramString2);
      return 0;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  public AvatarWallAdapter.AvatarInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return null;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localActivity == null) {
      return null;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", this.jdField_h_of_type_JavaLangString, "upload_head_cancel", 0, 0, this.jdField_g_of_type_JavaLangString, String.valueOf(paramInt), "", "");
    if (paramInt == 1) {
      return localActivity.getString(2131362506);
    }
    if (paramInt == 2) {
      return localActivity.getString(2131362507);
    }
    if (paramInt == 3) {
      return localActivity.getString(2131362508);
    }
    if (paramInt == 5) {
      return localActivity.getString(2131362509);
    }
    if (paramInt == 100) {
      return localActivity.getString(2131362521);
    }
    if (paramInt == 101) {
      return localActivity.getString(2131362522);
    }
    if (paramInt == 102) {
      return localActivity.getString(2131362516);
    }
    if (paramInt == 103) {
      return localActivity.getString(2131362523);
    }
    return localActivity.getString(2131362505);
  }
  
  protected String a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramInt = 2131362510;
    }
    for (;;)
    {
      if (paramInt != -1) {
        if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
          break label81;
        }
      }
      label81:
      for (Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localActivity = null)
      {
        if (localActivity != null)
        {
          return localActivity.getString(paramInt);
          if (paramInt == 1)
          {
            paramInt = 2131362511;
            break;
          }
          if (paramInt < 4)
          {
            paramInt = 2131362512;
            break;
          }
          if (paramInt < 4) {
            break label86;
          }
          paramInt = 2131362513;
          break;
          return null;
        }
        return null;
      }
      label86:
      paramInt = -1;
    }
  }
  
  public void a()
  {
    if (this.f) {
      return;
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_b_of_type_Int <= getCount()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, this.jdField_b_of_type_Int));
      d();
    }
    if (this.c) {
      b();
    }
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt2);
    if (localObject != null) {
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_Int = paramInt1;
    }
    paramInt1 -= this.n;
    while (paramInt1 > 0)
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      epn localepn = new epn(this, paramInt2);
      int i1 = m;
      m = i1 + 1;
      ((Handler)localObject).postDelayed(localepn, i1 * 10);
      paramInt1 -= 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.j <= 0) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          this.j -= 1;
          localObject = a(paramInt1);
        } while (localObject == null);
        ((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_Boolean = false;
        ((AvatarWallAdapter.AvatarInfo)localObject).c = "AVATAR_URL_STR";
        if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
        }
        paramInt3 = 0x7FFFFFFF & paramInt3;
        if ((paramInt3 < 0) || (paramInt3 > 1))
        {
          this.jdField_i_of_type_Boolean = true;
          b(paramInt2, paramInt1);
          notifyDataSetChanged();
          return;
        }
      } while ((!this.jdField_h_of_type_Boolean) || (paramInt3 < 0) || (paramInt3 > 1));
      this.jdField_i_of_type_Boolean = true;
      localObject = null;
      if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
        localObject = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      }
    } while (localObject == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_g_of_type_JavaLangString);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
    localBundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localBundle.putBoolean("PhotoConst.IS_SINGLE_MODE", false);
    localBundle.putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localBundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    localBundle.putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    paramActivity.overridePendingTransition(2130968585, 2130968583);
    a(paramActivity, localBundle);
  }
  
  protected void a(View paramView)
  {
    if (paramView != null)
    {
      paramView = (ProgressBar)paramView.findViewById(2131296282);
      if ((paramView != null) && (paramView.getVisibility() != 8)) {
        paramView.setVisibility(8);
      }
    }
  }
  
  public void a(AvatarWallAdapter.AddButtonStatusListener paramAddButtonStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener = paramAddButtonStatusListener;
  }
  
  protected void a(AvatarWallAdapter.ViewHolder paramViewHolder, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
    paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramContext.getDrawable() != null) {
      paramContext.setImageDrawable(null);
    }
    if (paramInt1 == 1)
    {
      paramContext.setContentDescription("上传头像");
      paramViewHolder = paramViewHolder.jdField_a_of_type_AndroidWidgetImageView;
      paramViewHolder.setVisibility(8);
      if (paramInt1 != 1) {
        break label94;
      }
      paramViewHolder.setVisibility(0);
    }
    label94:
    label232:
    do
    {
      do
      {
        for (;;)
        {
          return;
          paramContext.setContentDescription("第" + (paramInt2 + 1) + "张头像");
          break;
          if (paramInt1 == 0)
          {
            if (paramString != null) {
              paramContext.setImageDrawable(URLDrawable.getDrawable(paramString));
            }
          }
          else
          {
            if (paramInt1 != 2) {
              break label232;
            }
            if (paramString != null) {
              try
              {
                paramViewHolder = a(paramInt2);
                if ((paramViewHolder != null) && ((paramViewHolder instanceof AvatarWallAdapter.AvatarInfo)))
                {
                  if (paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap == null)
                  {
                    paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(paramString, ImageUtil.a(paramString, 100));
                    paramInt1 = TroopUtils.a(paramString);
                    if (paramInt1 != 0) {
                      paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.b(paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap, paramInt1);
                    }
                  }
                  if ((paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
                  {
                    paramContext.setImageBitmap(paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap);
                    return;
                  }
                }
              }
              catch (OutOfMemoryError paramViewHolder) {}
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramViewHolder.getMessage());
      return;
    } while (paramInt1 != 3);
    paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Setting localSetting = (Setting)paramViewHolder.a(Setting.class, "troop_" + this.jdField_g_of_type_JavaLangString);
    paramViewHolder.a();
    if ((localSetting == null) || (localSetting.bHeadType == 0))
    {
      if ((localSetting == null) && (!this.jdField_g_of_type_Boolean))
      {
        this.jdField_g_of_type_Boolean = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_g_of_type_JavaLangString, 4, true);
        }
      }
      paramContext.setImageResource(2130838290);
      return;
    }
    paramContext.setImageDrawable(URLDrawable.getDrawable(paramString));
  }
  
  public void a(GridView paramGridView)
  {
    paramGridView.setOnItemClickListener(new epo(this));
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while (localActivity == null);
    QQToast.a(localActivity, paramString, 1).b(b());
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.j <= 0) {
      return;
    }
    this.j -= 1;
    if (!a(this.jdField_g_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_g_of_type_JavaLangString);
      this.d = false;
      b();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    b(paramInt);
    a(paramString);
  }
  
  public void a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    this.j += paramArrayList.size();
    if ((paramArrayList == null) || (paramString1 == null) || (paramString3 == null)) {
      return;
    }
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(TroopUploadingThread.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, paramString1, paramString2, paramString3, null);
    b();
  }
  
  public void a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3, HashMap paramHashMap)
  {
    this.j += paramArrayList.size();
    if ((paramArrayList == null) || (paramString1 == null) || (paramString3 == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(TroopUploadingThread.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, paramString1, paramString2, paramString3, paramHashMap);
    b();
  }
  
  public void a(List paramList)
  {
    if (this.f) {}
    while (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    Object localObject;
    int i1;
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label275;
      }
      localObject = (String)paramList.next();
      int i2 = -1;
      try
      {
        i1 = Integer.parseInt((String)localObject);
        if ((i1 >= 0) && (i1 < getCount()))
        {
          localObject = a(i1);
          if (localObject == null) {
            continue;
          }
          if ((((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_AndroidGraphicsBitmap != null) && (!((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
          {
            ((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_AndroidGraphicsBitmap.recycle();
            ((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_AndroidGraphicsBitmap = null;
          }
          this.jdField_a_of_type_JavaUtilList.remove(i1);
          this.jdField_b_of_type_Int -= 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, localNumberFormatException.getMessage());
            i1 = i2;
          }
        }
        i1 = this.jdField_b_of_type_Int - 1;
      }
    }
    label162:
    AvatarWallAdapter.AvatarInfo localAvatarInfo;
    if (i1 >= 0)
    {
      localAvatarInfo = a(i1);
      if (localAvatarInfo != null)
      {
        if (!((String)localObject).equals(localAvatarInfo.b)) {
          break label252;
        }
        if ((localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        this.jdField_a_of_type_JavaUtilList.remove(i1);
        this.jdField_b_of_type_Int -= 1;
      }
    }
    for (;;)
    {
      i1 -= 1;
      break label162;
      break;
      label252:
      if (((String)localObject).equals(localAvatarInfo.jdField_a_of_type_JavaLangString)) {
        b((String)localObject, i1);
      }
    }
    label275:
    d();
    if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 3)) {
      b();
    }
    notifyDataSetChanged();
  }
  
  public void a(List paramList, int paramInt1, int paramInt2)
  {
    if (TroopAvatarManger.jdField_a_of_type_Int != 0) {}
    int i2;
    int i1;
    label63:
    do
    {
      do
      {
        return;
      } while (this.f);
      localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject).what = 14;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      if ((paramList != null) && (paramList.size() != 0)) {
        break;
      }
      i2 = 1;
      if (paramInt1 != 0) {
        break label359;
      }
      i1 = 1;
      if (i2 == 0) {
        break label365;
      }
    } while (i1 == 0);
    Object localObject = new AvatarWallAdapter.AvatarInfo();
    ((AvatarWallAdapter.AvatarInfo)localObject).c = "SYSTEM_PHOTO";
    ((AvatarWallAdapter.AvatarInfo)localObject).b = "-5";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
    a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Int);
    paramInt1 = 0;
    for (;;)
    {
      label150:
      label164:
      label221:
      int i3;
      if ((i1 == 0) && (paramInt1 == 0))
      {
        i1 = 0;
        paramInt1 = 0;
        if (i1 < this.jdField_b_of_type_Int)
        {
          localObject = (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
          i2 = paramInt1;
          if (localObject == null) {
            break label424;
          }
          if ((!((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_Boolean) || (((AvatarWallAdapter.AvatarInfo)localObject).c == "AVATAR_URL_STR")) {
            break label419;
          }
        }
        i1 = 0;
        i2 = 0;
        if (i1 < paramList.size())
        {
          localObject = (AvatarWallAdapter.AvatarInfo)paramList.get(i1);
          i3 = i2;
          if (localObject == null) {
            break label442;
          }
          if ((!((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_Boolean) || (((AvatarWallAdapter.AvatarInfo)localObject).c == "AVATAR_URL_STR")) {
            break label436;
          }
        }
        if (a(this.jdField_a_of_type_JavaUtilList, paramList, paramInt1, i2)) {
          break label455;
        }
        paramList = new ArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, paramInt1));
        if (!a(paramList, paramInt1)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        d();
        if (this.c) {
          b();
        }
        notifyDataSetChanged();
        return;
        i2 = 0;
        break;
        label359:
        i1 = 0;
        break label63;
        label365:
        if ((this.jdField_b_of_type_Int <= getCount()) && (this.jdField_a_of_type_JavaUtilList != null)) {
          break label528;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Int);
        paramInt1 = 1;
        break label150;
        label419:
        i2 = paramInt1 + 1;
        label424:
        i1 += 1;
        paramInt1 = i2;
        break label164;
        label436:
        i3 = i2 + 1;
        label442:
        i1 += 1;
        i2 = i3;
        break label221;
        label455:
        localObject = null;
        if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
          localObject = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
        }
        if ((localObject != null) && (paramInt2 == 1)) {
          QQToast.a((Context)localObject, ((Activity)localObject).getString(2131362524), 1).b(b());
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        a(this.jdField_a_of_type_JavaUtilList, i2);
      }
      label528:
      paramInt1 = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void a(int[] paramArrayOfInt, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = paramActivity.getResources().getStringArray(2131230726);
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramActivity, null, 2131624119);
    int i1 = 0;
    if (i1 < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i1] == 16) {
        localActionSheet.d(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[i1]]);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if ((paramArrayOfInt[i1] >= 0) && (paramArrayOfInt[i1] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
          localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[i1]], 1);
        }
      }
    }
    localActionSheet.a(new epp(this, paramActivity, localActionSheet));
    localActionSheet.show();
  }
  
  public boolean a(int paramInt)
  {
    AvatarWallAdapter.AvatarInfo localAvatarInfo = a(paramInt);
    if (localAvatarInfo != null) {
      return localAvatarInfo.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.j != 0;
  }
  
  protected boolean a(List paramList, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {
      return false;
    }
    int i1;
    Object localObject;
    Iterator localIterator;
    if (paramInt == 8)
    {
      i1 = 1;
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a();
      if (paramList != null) {
        localIterator = paramList.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label171;
        }
        UploadItem localUploadItem = (UploadItem)localIterator.next();
        if (localUploadItem != null)
        {
          if (paramInt == 8) {
            i1 = 1;
          }
          if (i1 == 0)
          {
            AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
            localAvatarInfo.jdField_a_of_type_JavaLangString = localUploadItem.jdField_a_of_type_JavaLangString;
            localAvatarInfo.jdField_a_of_type_Int = localUploadItem.jdField_a_of_type_Int;
            localAvatarInfo.c = "AVATAR_LOCAL_STR";
            localAvatarInfo.jdField_a_of_type_Boolean = true;
            ((List)localObject).add(paramInt, localAvatarInfo);
            paramInt += 1;
            continue;
            i1 = 0;
            break;
          }
          paramList.remove(localUploadItem);
        }
      }
      label171:
      this.j = paramList.size();
    }
    return paramList != null;
  }
  
  protected boolean a(List paramList1, List paramList2, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      return true;
    }
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      Object localObject2 = (AvatarWallAdapter.AvatarInfo)paramList1.get(paramInt2);
      Object localObject1 = (AvatarWallAdapter.AvatarInfo)paramList2.get(paramInt2);
      if (localObject2 != null)
      {
        localObject2 = ((AvatarWallAdapter.AvatarInfo)localObject2).b;
        if (localObject1 != null)
        {
          localObject1 = ((AvatarWallAdapter.AvatarInfo)localObject1).b;
          if (localObject2 != null) {
            break label78;
          }
          return true;
        }
      }
      else
      {
        return true;
      }
      return false;
      label78:
      if ((localObject1 != null) && (!((String)localObject1).equals(localObject2))) {
        return true;
      }
      paramInt2 += 1;
    }
    return false;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return 0;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localActivity != null) {
      return localActivity.getResources().getDimensionPixelSize(2131492887);
    }
    return 0;
  }
  
  public int b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new FileInputStream(paramString1);
      paramString2 = new FileOutputStream(paramString2);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i1 = paramString1.read(arrayOfByte);
        if (i1 <= 0) {
          break;
        }
        paramString2.write(arrayOfByte, 0, i1);
      }
      paramString1.close();
      paramString2.close();
      return 0;
    }
    catch (Exception paramString1) {}
    return -1;
  }
  
  public void b()
  {
    Object localObject1 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((FriendsManagerImp)localObject1).a(String.valueOf(this.jdField_g_of_type_JavaLangString));
      localObject2 = new TroopInfoData();
      ((TroopInfoData)localObject2).a((TroopInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    for (boolean bool = ((TroopInfoData)localObject2).j();; bool = false)
    {
      if (bool) {
        if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
          break label149;
        }
      }
      label149:
      for (localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localObject1 = null)
      {
        if (localObject1 != null) {
          localObject1 = ((Activity)localObject1).getString(2131362580);
        }
        for (;;)
        {
          if ((localObject1 != null) && (this.jdField_b_of_type_AndroidOsHandler != null))
          {
            localObject2 = new Message();
            ((Message)localObject2).what = 11;
            ((Message)localObject2).obj = localObject1;
            this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          }
          return;
          localObject1 = a(this.jdField_b_of_type_Int, this.d);
          continue;
          localObject1 = null;
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    AvatarWallAdapter.AvatarInfo localAvatarInfo;
    do
    {
      return;
      localAvatarInfo = a(paramInt);
    } while ((localAvatarInfo == null) || (!(localAvatarInfo instanceof AvatarWallAdapter.AvatarInfo)));
    if ((localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener.a(false);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int -= 1;
      if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 4)) {
        b();
      }
      notifyDataSetChanged();
      return;
      localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
      if (this.jdField_b_of_type_Int == 8)
      {
        localAvatarInfo.c = "PLUS";
        this.jdField_a_of_type_JavaUtilList.add(localAvatarInfo);
      }
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    int i1 = 0;
    Object localObject2;
    String str;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AvatarWallAdapter.AvatarInfo)((Iterator)localObject1).next();
      if (localObject2 != null) {
        str = ((AvatarWallAdapter.AvatarInfo)localObject2).b;
      }
    }
    label287:
    label289:
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(str);
        if ((str == null) || (i2 < 0)) {
          break label289;
        }
        if (((AvatarWallAdapter.AvatarInfo)localObject2).c.equals("AVATAR_URL_STR"))
        {
          localArrayList.add(str);
          if (!str.equals(String.valueOf(paramInt1))) {
            break label289;
          }
          i1 = 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i2 = -1;
        continue;
        if ((localArrayList.size() != 0) || (!((AvatarWallAdapter.AvatarInfo)localObject2).c.equals("SYSTEM_PHOTO"))) {
          continue;
        }
        localArrayList.add(str);
        continue;
      }
      if (i1 != 0) {
        b(paramInt2);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label287;
        }
        localObject1 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (localObject1 == null) {
          break;
        }
        localObject2 = ((FriendsManagerImp)localObject1).a(String.valueOf(this.jdField_g_of_type_JavaLangString));
        if ((localObject2 == null) || (localArrayList.size() <= 0)) {
          break;
        }
        ((TroopInfo)localObject2).mTroopPicList = localArrayList;
        ((FriendsManagerImp)localObject1).b((TroopInfo)localObject2);
        return;
        localObject1 = a(paramInt2);
        ((AvatarWallAdapter.AvatarInfo)localObject1).b = String.valueOf(paramInt1);
        ((AvatarWallAdapter.AvatarInfo)localObject1).c = "AVATAR_URL_STR";
        ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_a_of_type_Boolean = false;
        localArrayList.add(((AvatarWallAdapter.AvatarInfo)localObject1).b);
      }
      break;
    }
  }
  
  public void b(String paramString)
  {
    if (this.f) {}
    while (paramString == null) {
      return;
    }
    AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
    localAvatarInfo.jdField_a_of_type_JavaLangString = paramString;
    localAvatarInfo.c = "AVATAR_LOCAL_STR";
    localAvatarInfo.jdField_a_of_type_Boolean = true;
    localAvatarInfo.b = "-1";
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_Int, localAvatarInfo);
    this.jdField_b_of_type_Int += 1;
    if ((this.jdField_b_of_type_Int == 8) && (this.jdField_a_of_type_JavaUtilList.size() == 9)) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_b_of_type_Int);
    }
    notifyDataSetChanged();
  }
  
  protected void b(String paramString, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", this.jdField_h_of_type_JavaLangString, "upload_head_cancel", 0, 0, this.jdField_g_of_type_JavaLangString, "0", "", "");
    AvatarWallAdapter.AvatarInfo localAvatarInfo = a(paramInt);
    if ((localAvatarInfo == null) || (paramString == null)) {
      return;
    }
    if (localAvatarInfo.b == null)
    {
      this.j -= 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(paramString);
    }
    for (;;)
    {
      b(paramInt);
      if (this.j != 0) {
        break;
      }
      this.d = false;
      b();
      return;
      try
      {
        int i1 = Integer.parseInt(localAvatarInfo.b);
        paramString = new ArrayList();
        paramString.add(Integer.valueOf(i1));
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_g_of_type_JavaLangString, 2, paramString);
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    this.f = true;
    int i1 = 0;
    while (i1 < this.jdField_b_of_type_Int)
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo = a(i1);
      if ((localAvatarInfo != null) && ((localAvatarInfo instanceof AvatarWallAdapter.AvatarInfo)) && (localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      i1 += 1;
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a();
    this.jdField_a_of_type_JavaUtilObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < getCount()))
    {
      c(paramInt, 0);
      e();
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    AvatarWallAdapter.AvatarInfo localAvatarInfo = a(paramInt1);
    if (localAvatarInfo != null)
    {
      if (paramInt1 >= paramInt2) {
        break label57;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramInt2 + 1, (AvatarWallAdapter.AvatarInfo)localAvatarInfo);
      this.jdField_a_of_type_JavaUtilList.remove(paramInt1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      notifyDataSetChanged();
      return;
      label57:
      this.jdField_a_of_type_JavaUtilList.add(paramInt2, (AvatarWallAdapter.AvatarInfo)localAvatarInfo);
      this.jdField_a_of_type_JavaUtilList.remove(paramInt1 + 1);
    }
  }
  
  protected void d()
  {
    if ((this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int < 8)) {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localAvatarInfo = (AvatarWallAdapter.AvatarInfo)((Iterator)localObject).next();
          if ((localAvatarInfo != null) && (localAvatarInfo.c == "PLUS")) {
            this.jdField_a_of_type_JavaUtilList.remove(localAvatarInfo);
          }
        }
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener == null) {
          break label110;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener.a(false);
      }
    }
    label110:
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener == null)
    {
      Object localObject;
      do
      {
        AvatarWallAdapter.AvatarInfo localAvatarInfo;
        return;
        localObject = new AvatarWallAdapter.AvatarInfo();
      } while (!this.c);
      ((AvatarWallAdapter.AvatarInfo)localObject).c = "PLUS";
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener.a(false);
  }
  
  public void e()
  {
    if (this.f) {}
    while (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo = (AvatarWallAdapter.AvatarInfo)localIterator.next();
      if ((localAvatarInfo != null) && (localAvatarInfo.c == "AVATAR_URL_STR")) {
        localArrayList.add(Integer.valueOf(Integer.parseInt(localAvatarInfo.b)));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_g_of_type_JavaLangString, 0, localArrayList);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", this.jdField_h_of_type_JavaLangString, "drag_head", 0, 0, this.jdField_g_of_type_JavaLangString, "", "", "");
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = new int[q];
      }
      this.jdField_a_of_type_ArrayOfInt[0] = 13;
      this.jdField_a_of_type_ArrayOfInt[1] = 14;
      this.jdField_a_of_type_ArrayOfInt[2] = 16;
      int i1 = 3;
      while (i1 < q)
      {
        this.jdField_a_of_type_ArrayOfInt[i1] = -1;
        i1 += 1;
      }
      a(this.jdField_a_of_type_ArrayOfInt, localActivity);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = 1;
    Activity localActivity = null;
    paramViewGroup = paramView;
    if (paramView == null) {
      if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
        break label523;
      }
    }
    label515:
    label523:
    for (paramViewGroup = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; paramViewGroup = null)
    {
      if (paramViewGroup == null) {}
      AvatarWallAdapter.AvatarInfo localAvatarInfo;
      do
      {
        do
        {
          return paramView;
          paramViewGroup = LayoutInflater.from(paramViewGroup).inflate(2130903297, null);
          localAvatarInfo = a(paramInt);
          paramView = paramViewGroup;
        } while (localAvatarInfo == null);
        paramView = paramViewGroup;
      } while (!(localAvatarInfo instanceof AvatarWallAdapter.AvatarInfo));
      paramView = localAvatarInfo.c;
      if (paramView.equals("PLUS")) {
        paramView = null;
      }
      for (;;)
      {
        AvatarWallAdapter.ViewHolder localViewHolder;
        if (paramViewGroup.getTag() == null)
        {
          localViewHolder = new AvatarWallAdapter.ViewHolder(this);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297576));
          localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296282));
          localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131296957));
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          localLayoutParams.height = this.jdField_i_of_type_Int;
          localLayoutParams.width = this.jdField_i_of_type_Int;
          localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
          localLayoutParams = (FrameLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.getLayoutParams();
          localLayoutParams.height = this.jdField_i_of_type_Int;
          localLayoutParams.width = this.jdField_i_of_type_Int;
          localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setLayoutParams(localLayoutParams);
          paramViewGroup.setTag(localViewHolder);
          label239:
          if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
            localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
          }
          a(localViewHolder, localActivity, i1, paramView, paramInt);
          paramView = localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar;
          if (!localAvatarInfo.jdField_a_of_type_Boolean) {
            break label499;
          }
          if (paramView.getVisibility() != 0) {
            paramView.setVisibility(0);
          }
          paramView.setProgress(localAvatarInfo.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
          paramView.setProgress(100);
        }
        for (;;)
        {
          if ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
            break label508;
          }
          paramViewGroup.setVisibility(8);
          return paramViewGroup;
          if ((paramView.equals("AVATAR_URL_STR")) && ((localAvatarInfo.jdField_a_of_type_JavaLangString == null) || (!new File(localAvatarInfo.jdField_a_of_type_JavaLangString).exists())))
          {
            paramView = AvatarTroopUtil.a(AvatarTroopUtil.a(localAvatarInfo.b, this.jdField_g_of_type_JavaLangString, 1));
            i1 = 0;
            break;
          }
          if ((paramView.equals("AVATAR_LOCAL_STR")) || ((localAvatarInfo.jdField_a_of_type_JavaLangString != null) && (new File(localAvatarInfo.jdField_a_of_type_JavaLangString).exists())))
          {
            paramView = localAvatarInfo.jdField_a_of_type_JavaLangString;
            i1 = 2;
            break;
          }
          if (!paramView.equals("SYSTEM_PHOTO")) {
            break label515;
          }
          paramView = AvatarTroopUtil.a(AvatarTroopUtil.a(localAvatarInfo.b, this.jdField_g_of_type_JavaLangString, 0));
          i1 = 3;
          break;
          localViewHolder = (AvatarWallAdapter.ViewHolder)paramViewGroup.getTag();
          break label239;
          label499:
          paramView.setVisibility(8);
        }
        label508:
        paramViewGroup.setVisibility(0);
        return paramViewGroup;
        paramView = null;
        i1 = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallAdapter
 * JD-Core Version:    0.7.0.1
 */