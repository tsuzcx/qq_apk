import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class aajx
{
  private boolean bvY;
  private boolean bvZ;
  private aqdf.a d;
  public aqdf d;
  protected QQAppInterface mApp;
  private boolean mSync;
  
  public aajx(QQAppInterface paramQQAppInterface)
  {
    this.mSync = true;
    this.mApp = paramQQAppInterface;
  }
  
  public aajx(QQAppInterface paramQQAppInterface, aqdf.a parama)
  {
    this(paramQQAppInterface, parama, false);
  }
  
  public aajx(QQAppInterface paramQQAppInterface, aqdf.a parama, boolean paramBoolean)
  {
    this.jdField_d_of_type_Aqdf = new aqdf(BaseApplication.getContext(), paramQQAppInterface);
    this.jdField_d_of_type_Aqdf.a(parama);
    this.jdField_d_of_type_Aqdf$a = parama;
    this.mApp = paramQQAppInterface;
    this.bvY = paramBoolean;
  }
  
  public static Pair<Integer, Integer> a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int k = -2147483648;
    int m = 2130841036;
    int n = 1;
    int i = m;
    int j = k;
    switch (paramInt)
    {
    default: 
      i = -2147483648;
      j = k;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      i = m;
      j = k;
      if (!String.valueOf(acbn.bkD).equals(paramString))
      {
        i = m;
        j = k;
        if (!String.valueOf(acbn.bkG).equals(paramString)) {
          if (String.valueOf(acbn.bkt).equals(paramString))
          {
            i = 2130841045;
            j = k;
          }
          else if (acbn.bkB.equals(paramString))
          {
            i = 2130841309;
            j = k;
          }
          else if (acbn.blw.equals(paramString))
          {
            j = 110;
            i = -2147483648;
          }
          else
          {
            i = -2147483648;
            j = 1;
            continue;
            i = 2130841031;
            j = k;
            continue;
            if (String.valueOf(acbn.bkE).equals(paramString))
            {
              i = 2130841029;
              j = k;
            }
            else if (acbn.bli.equals(paramString))
            {
              i = 2130846404;
              j = k;
            }
            else if (acbn.blj.equals(paramString))
            {
              i = 2130846403;
              j = k;
            }
            else if (acbn.blk.equals(paramString))
            {
              i = 2130846405;
              j = k;
            }
            else if (acbn.bll.equals(paramString))
            {
              i = 2130846402;
              j = k;
            }
            else if (acbn.blm.equals(paramString))
            {
              i = 2130846406;
              j = k;
            }
            else
            {
              j = 32;
              i = -2147483648;
              continue;
              i = 2130845074;
              j = k;
              continue;
              i = 2130845071;
              j = k;
              continue;
              j = 104;
              i = -2147483648;
              continue;
              j = 11;
              i = -2147483648;
              continue;
              j = 101;
              i = -2147483648;
              continue;
              j = 1001;
              i = -2147483648;
              continue;
              i = -2147483648;
              j = 4;
              continue;
              HotChatManager localHotChatManager = paramQQAppInterface.a(false);
              acfs localacfs = (acfs)paramQQAppInterface.getManager(255);
              if ((localacfs != null) && (localacfs.kf(paramString))) {
                paramInt = n;
              }
              for (;;)
              {
                if (((localHotChatManager != null) && (localHotChatManager.kj(paramString))) || (paramInt != 0))
                {
                  if (paramInt != 0)
                  {
                    i = 2130838616;
                    j = k;
                    break;
                    paramInt = 0;
                    continue;
                  }
                  i = HotChatManager.d(paramString, paramQQAppInterface);
                  j = k;
                  break;
                }
              }
              if (apuh.ra(paramString))
              {
                i = -2147483648;
                j = 4;
              }
              else
              {
                j = 113;
                i = -2147483648;
                continue;
                i = 2130840975;
                j = k;
                continue;
                i = 2130845636;
                j = k;
                continue;
                i = 2130841037;
                j = k;
                continue;
                i = 2130843399;
                j = k;
                continue;
                if (acbn.bku.equals(paramString))
                {
                  i = 2130841035;
                  j = k;
                }
                else
                {
                  j = 103;
                  i = -2147483648;
                  continue;
                  i = 2130841032;
                  j = k;
                  continue;
                  j = 104;
                  i = 2130840079;
                  continue;
                  j = 108;
                  i = -2147483648;
                  continue;
                  j = 105;
                  i = -2147483648;
                  continue;
                  j = 111;
                  i = -2147483648;
                  continue;
                  j = 106;
                  i = 2130847910;
                  continue;
                  if (TextUtils.isEmpty(obt.Yf)) {}
                  for (i = nyn.rb();; i = 2147483647)
                  {
                    j = 112;
                    break;
                  }
                  i = 2130841033;
                  j = k;
                  continue;
                  i = 2130840124;
                  j = k;
                  continue;
                  i = 2130840732;
                  j = k;
                  continue;
                  i = ((apqx)paramQQAppInterface.getManager(183)).getResId();
                  j = k;
                  continue;
                  if (TextUtils.equals(paramString, acbn.blK))
                  {
                    i = 2130845892;
                    j = k;
                  }
                  else if (TextUtils.equals(paramString, acbn.blL))
                  {
                    i = 2130845893;
                    j = k;
                  }
                  else
                  {
                    i = 2130845892;
                    j = k;
                    continue;
                    i = -2147483648;
                    j = 1;
                    continue;
                    i = 2130851593;
                    j = k;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private Drawable t(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return aqhu.at();
    case 4: 
      return aqhu.aV();
    case 101: 
    case 113: 
    case 1001: 
      return aqhu.aX();
    case 11: 
      return aqhu.at();
    case 102: 
      return aqhu.G(102);
    case 107: 
      return aqhu.G(107);
    case 103: 
      return aqhu.aY();
    case 32: 
      return aqhu.at();
    }
    return aqhu.c(true);
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, true);
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean)
  {
    Pair localPair = a(this.mApp, paramInt, paramString);
    int i = ((Integer)localPair.first).intValue();
    int j = ((Integer)localPair.second).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable uintype = " + paramInt + ", uin = " + paramString + ", isGetResFace = " + paramBoolean + ", faceType = " + i + ", faceResId = " + j);
    }
    if (j == 2147483647) {}
    try
    {
      return a(i, paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    if (i != -2147483648) {
      return a(paramString, i);
    }
    if ((j != -2147483648) && (paramBoolean))
    {
      paramString = BaseApplication.getContext().getResources().getDrawable(j);
      return paramString;
    }
    return null;
  }
  
  public Drawable a(RecentBaseData paramRecentBaseData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable start");
    }
    int j = paramRecentBaseData.ng();
    int i;
    if (paramRecentBaseData.ng() == 8)
    {
      i = paramRecentBaseData.mExtraType;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "getFaceDrawable type = " + i);
      }
      if (i != 0) {
        if (i == 25)
        {
          localObject = (ajdo)this.mApp.getManager(11);
          if (localObject == null) {
            break label390;
          }
        }
      }
    }
    label390:
    for (Object localObject = ((ajdo)localObject).c(paramRecentBaseData.mPhoneNumber);; localObject = null)
    {
      if (localObject != null)
      {
        localObject = aqdj.b(this.mApp, paramRecentBaseData.mPhoneNumber, (byte)3);
        paramRecentBaseData = (RecentBaseData)localObject;
        if (localObject == null) {
          paramRecentBaseData = aqhu.at();
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentFaceDecoder", 2, "getFaceDrawable end");
        }
        return paramRecentBaseData;
        paramRecentBaseData = this.mApp.getFaceBitmap(16, paramRecentBaseData.qx(), (byte)3, true, 16);
        if (paramRecentBaseData == null)
        {
          paramRecentBaseData = aqhu.at();
        }
        else
        {
          paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
          continue;
          paramRecentBaseData = this.mApp.a(paramRecentBaseData.qx(), (byte)3, true);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = aqhu.at();
          }
          else
          {
            paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
            continue;
            paramRecentBaseData = a(i, paramRecentBaseData.qx());
            continue;
            if (j == 26)
            {
              paramRecentBaseData = aljw.a(this.mApp, paramRecentBaseData.qx());
            }
            else if (j == 1034)
            {
              j = 2130845874;
              i = j;
              if ((paramRecentBaseData instanceof RecentItemConfessMsg))
              {
                i = j;
                if (((RecentItemConfessMsg)paramRecentBaseData).mConfessInfo.confessorSex == 1) {
                  i = 2130845875;
                }
              }
              paramRecentBaseData = BaseApplication.getContext().getResources().getDrawable(i);
            }
            else if (aibg.a(j, paramRecentBaseData))
            {
              paramRecentBaseData = a(114, ((RecentItemImaxADData)paramRecentBaseData).mHeaderUrl);
            }
            else
            {
              localObject = paramRecentBaseData.qx();
              i = j;
              if ((paramRecentBaseData instanceof RecentCallItem))
              {
                i = j;
                if (((RecentCallItem)paramRecentBaseData).WD()) {
                  i = 3002;
                }
              }
              paramRecentBaseData = a(i, (String)localObject);
            }
          }
        }
      }
    }
  }
  
  public Drawable a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable facetype = " + paramInt + ", uin = " + paramString);
    }
    Object localObject2;
    if (paramInt == 104)
    {
      localObject2 = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramString);
      return localObject2;
    }
    if (paramInt == 105)
    {
      paramString = obt.a(this.mApp, BaseApplication.getContext(), 1);
      if ((paramString != null) && (paramString.getIcon() != null)) {
        return paramString.getIcon();
      }
      return obt.g(BaseApplication.getContext(), 1);
    }
    if (paramInt == 111)
    {
      paramString = obt.a(this.mApp, BaseApplication.getContext(), 3);
      if ((paramString != null) && (paramString.getIcon() != null)) {}
      for (paramString = paramString.getIcon();; paramString = obt.g(BaseApplication.getContext(), 3)) {
        return kxm.a(this.mApp, paramString);
      }
    }
    if (paramInt == 106) {
      return kdm.b(BaseApplication.getContext());
    }
    if (paramInt == 108) {
      return ((ylm)this.mApp.getManager(138)).aG();
    }
    if (paramInt == 110)
    {
      paramString = obt.a(this.mApp, BaseApplication.getContext(), 2);
      if ((paramString != null) && (paramString.getIcon() != null)) {
        return paramString.getIcon();
      }
      return obt.g(BaseApplication.getContext(), 2);
    }
    if (paramInt == 112) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(nyn.rb());
    }
    if (this.mSync)
    {
      this.mApp.a(paramInt, paramString, false, 0);
      return null;
    }
    if ((this.bvY) && (!this.bvZ))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 1");
      }
      return t(paramInt);
    }
    if (paramInt == 103) {}
    for (int i = 1;; i = paramInt)
    {
      Object localObject1;
      if (this.jdField_d_of_type_Aqdf != null) {
        if (paramInt == 32) {
          localObject1 = this.jdField_d_of_type_Aqdf.a(i, paramString, 200);
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("requestDecodeFace| [").append(paramString).append(",").append(paramInt).append(",").append(localObject1).append("], isPausing=");
          if (this.jdField_d_of_type_Aqdf == null)
          {
            localObject2 = "null";
            label408:
            QLog.i("Q.recent", 4, localObject2);
          }
        }
        else
        {
          if (localObject1 != null) {
            break label565;
          }
          if ((this.jdField_d_of_type_Aqdf != null) && (!this.jdField_d_of_type_Aqdf.isPausing()))
          {
            if (i != 32) {
              break label517;
            }
            this.jdField_d_of_type_Aqdf.a(paramString, 200, true, false);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 2");
          }
          return t(paramInt);
          localObject1 = this.jdField_d_of_type_Aqdf.b(i, paramString);
          break;
          localObject2 = Boolean.valueOf(this.jdField_d_of_type_Aqdf.isPausing());
          break label408;
          label517:
          this.jdField_d_of_type_Aqdf.a(paramString, i, true, (byte)0);
          if ((i == 1001) && (this.jdField_d_of_type_Aqdf.b(101, paramString) == null)) {
            this.jdField_d_of_type_Aqdf.a(paramString, 101, true, (byte)0);
          }
        }
        label565:
        if (paramInt == 103)
        {
          localObject2 = BaseApplication.getContext().getResources().getDrawable(2130840893);
          if ((localObject2 instanceof SkinnableBitmapDrawable)) {
            ((SkinnableBitmapDrawable)localObject2).setGravity(81);
          }
          if ((localObject2 instanceof BitmapDrawable)) {
            ((BitmapDrawable)localObject2).setGravity(81);
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        }
        for (localObject1 = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1), localObject2 });; localObject1 = new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1))
        {
          localObject2 = localObject1;
          if (!acbn.blO.equals(paramString)) {
            break;
          }
          return KandianSubscribeManager.a((Drawable)localObject1, this.mApp);
        }
        localObject1 = null;
      }
    }
  }
  
  public Drawable a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    paramString1 = aqdj.a(this.mApp, paramString1, (byte)1);
    try
    {
      QLog.d("RecentFaceDecoder", 2, "getAppletsFolderDrawable width = " + paramInt1 + ", height = " + paramInt2 + ", url = " + paramString2 + ", urlSimple = " + paramString3);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = wja.dp2px(paramInt1, this.mApp.getApp().getApplicationContext().getResources());
      localURLDrawableOptions.mRequestHeight = wja.dp2px(paramInt2, this.mApp.getApp().getApplicationContext().getResources());
      localURLDrawableOptions.mLoadingDrawable = paramString1;
      localURLDrawableOptions.mFailedDrawable = paramString1;
      if (anlm.Vr())
      {
        if (!TextUtils.isEmpty(paramString3))
        {
          paramInt1 = Math.min(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight);
          paramString3 = URLDrawable.getDrawable(paramString3, localURLDrawableOptions);
          paramString3.setTag(new int[] { paramInt1, paramInt1, (int)(paramInt1 * aqhu.AE) });
          paramString3.setDecodeHandler(aqbn.a);
          return paramString3;
        }
      }
      else if (!TextUtils.isEmpty(paramString2))
      {
        paramString3 = URLDrawable.getDrawable(paramString2, localURLDrawableOptions);
        return paramString3;
      }
    }
    catch (Exception paramString3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentFaceDecoder", 2, "getAppletsFolderDrawable illegal url format: " + paramString2);
      }
    }
    return paramString1;
  }
  
  public URLDrawable a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1000: 
      paramString = ((HotChatManager)this.mApp.getManager(60)).a(paramString);
      localDrawable = aqhu.aV();
      return URLDrawable.getDrawable(paramString.iconUrl, localDrawable, localDrawable);
    case 112: 
      paramString = BaseApplicationImpl.sApplication.getResources().getDrawable(nyn.rb());
      return URLDrawable.getDrawable(obt.Yf, paramString, paramString);
    }
    Drawable localDrawable = aqhu.at();
    paramString = URLDrawable.getDrawable(paramString, localDrawable, localDrawable);
    paramString.setDecodeHandler(aqbn.b);
    return paramString;
  }
  
  public void cuT()
  {
    this.bvZ = true;
  }
  
  public QQAppInterface getAppInterface()
  {
    return this.mApp;
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_d_of_type_Aqdf != null)
    {
      this.jdField_d_of_type_Aqdf.F(paramQQAppInterface);
      this.jdField_d_of_type_Aqdf.a(this.jdField_d_of_type_Aqdf$a);
    }
    this.mApp = paramQQAppInterface;
  }
  
  public void onDestory()
  {
    if (this.jdField_d_of_type_Aqdf != null)
    {
      this.jdField_d_of_type_Aqdf.destory();
      this.jdField_d_of_type_Aqdf = null;
    }
    this.jdField_d_of_type_Aqdf$a = null;
    this.mApp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajx
 * JD-Core Version:    0.7.0.1
 */