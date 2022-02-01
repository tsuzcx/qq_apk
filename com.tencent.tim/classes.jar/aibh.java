import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;
import java.util.List;

public class aibh
  implements AdapterView.OnItemClickListener
{
  private static URLDrawable C;
  protected ShareActionSheetBuilder b;
  private jxc c;
  private Context mContext;
  
  public aibh(Context paramContext, jxc paramjxc)
  {
    this.mContext = paramContext;
    this.c = paramjxc;
  }
  
  private void I(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString4 = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(127).b(12345).e(paramString4).a(acfp.m(2131707392) + paramString3).a();
    Object localObject = this.c.a.UQ;
    String str = this.c.a.UR;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString4.mSourceName = this.c.a.UQ;
      if (!TextUtils.isEmpty(str)) {
        paramString4.mSourceIcon = this.c.a.UR;
      }
    }
    paramString4.mContentLayout = 2;
    localObject = anrd.a(2);
    ((anqv)localObject).aU(paramString1, paramString2, paramString3);
    paramString4.addItem((anqu)localObject);
    paramString1 = new Intent();
    paramString1.putExtra("forward_type", -3);
    paramString1.putExtra("stuctmsg_bytes", paramString4.getBytes());
    paramString1.putExtra("structmsg_service_id", paramString4.mMsgServiceID);
    paramString1.putExtra("emoInputType", 2);
    paramString1.putExtra("forwardDirect", true);
    ahgq.f((Activity)this.mContext, paramString1, 1000);
    anot.a(null, "dc00898", "", this.c.a.UD, "0X80092A2", "0X80092A2", 0, 0, this.c.a.hT, "", "", this.c.a.mNickName);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, int paramInt)
  {
    if (paramInt == 1001)
    {
      WXShareHelper.a().b(paramString1, paramString2, paramBitmap, paramString3, paramString4);
      anot.a(null, "dc00898", "", this.c.a.UD, "0X80092A3", "0X80092A3", 0, 0, this.c.a.hT, "", "", this.c.a.mNickName);
    }
    while (paramInt != 1002) {
      return;
    }
    WXShareHelper.a().a(paramString1, paramString2, paramBitmap, paramString3, paramString4);
    anot.a(null, "dc00898", "", this.c.a.UD, "0X80092A5", "0X80092A5", 0, 0, this.c.a.hT, "", "", this.c.a.mNickName);
  }
  
  private boolean b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    boolean bool1;
    if (TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed title==null");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (!bool1) {}
      return bool1;
      if (TextUtils.isEmpty(paramString2))
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed bitmapUrl==null");
          bool1 = bool2;
        }
      }
      else if (TextUtils.isEmpty(paramString3))
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed jumpUrl==null");
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  private void d(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.mTitle = paramString1;
    localQZoneShareData.mSummary = paramString2;
    localQZoneShareData.ER = new ArrayList();
    localQZoneShareData.ER.add(paramString4);
    localQZoneShareData.targetUrl = paramString3;
    avqq.a(paramContext, String.valueOf(aroi.a().getUin()), localQZoneShareData, null, 1003);
    anot.a(null, "dc00898", "", this.c.a.UD, "0X80092A4", "0X80092A4", 0, 0, this.c.a.hT, "", "", this.c.a.mNickName);
  }
  
  private void d(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (f(paramContext, paramInt))
    {
      paramContext = String.valueOf(System.currentTimeMillis());
      if (C != null) {
        C.cancelDownload();
      }
      C = URLDrawable.getDrawable(paramString4, URLDrawable.URLDrawableOptions.obtain());
      if (C.getStatus() == 1) {
        a(paramContext, paramString1, paramString2, ajxd.drawableToBitmap(C), paramString3, paramInt);
      }
    }
    else
    {
      return;
    }
    if (C.getStatus() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "s_forShare Bitmap FAILED, downloadImediatly ...");
      }
      C.downloadImediatly();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "start load URLDrawable. ...");
    }
    C.setURLDrawableListener(new aibi(this, paramContext, paramString1, paramString2, paramString3, paramInt));
    C.downloadImediatly();
  }
  
  private boolean f(Context paramContext, int paramInt)
  {
    if (!WXShareHelper.a().isWXinstalled())
    {
      QQToast.a(paramContext, 2131696070, 0).show();
      return false;
    }
    if (!WXShareHelper.a().isWXsupportApi())
    {
      QQToast.a(paramContext, 2131721936, 0).show();
      return false;
    }
    if ((paramInt == 1002) && (!WXShareHelper.a().aGS()))
    {
      QQToast.a(paramContext, 2131721936, 0).show();
      return false;
    }
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      QQToast.a(this.mContext, 1, 2131696272, 1).show();
      return false;
    }
    return true;
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.mContext.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.iconNeedBg = paramBoolean;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = paramString;
    return localActionSheetItem;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(2131698630, 2130839252, true, 2, ""));
    localArrayList.add(a(2131698643, 2130839253, true, 3, ""));
    localArrayList.add(a(2131698652, 2130839256, true, 9, ""));
    localArrayList.add(a(2131698633, 2130839249, true, 10, ""));
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void aAL()
  {
    if (this.b == null)
    {
      this.b = new ShareActionSheetBuilder(this.mContext);
      this.b.setActionSheetTitle(this.mContext.getString(2131720177));
      this.b.setActionSheetItems(a());
      this.b.setItemClickListener(this);
    }
    try
    {
      this.b.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", localException);
    }
  }
  
  public void onDestory()
  {
    this.mContext = null;
    this.b = null;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1;
    Object localObject4;
    if (QLog.isColorLevel())
    {
      if ("onshare_ItemClick mAdItem " + this.c == null)
      {
        localObject1 = " null";
        QLog.d("ImaxAdvertisement", 2, (String)localObject1);
      }
    }
    else
    {
      localObject4 = paramView.getTag();
      if ((localObject4 != null) && (this.c != null)) {
        break label87;
      }
    }
    label87:
    String str2;
    Object localObject2;
    Object localObject3;
    do
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localObject1 = this.c.toString();
      break;
      str2 = this.c.a.US;
      localObject2 = this.c.a.UO;
      localObject3 = this.c.a.UN;
      String str1 = this.c.a.UP;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.c.Uz;
      }
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = this.c.Uy;
      }
      localObject3 = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject3 = this.c.UA;
      }
    } while (!b(this.mContext, (String)localObject2, (String)localObject1, str2));
    switch (((ShareActionSheetBuilder.b)localObject4).b.action)
    {
    }
    for (;;)
    {
      this.b.dismiss();
      break;
      I((String)localObject1, (String)localObject2, (String)localObject3, str2);
      continue;
      d(this.mContext, (String)localObject2, (String)localObject3, str2, (String)localObject1);
      continue;
      d(this.mContext, (String)localObject2, (String)localObject3, str2, (String)localObject1, 1001);
      continue;
      d(this.mContext, (String)localObject2, (String)localObject3, str2, (String)localObject1, 1002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibh
 * JD-Core Version:    0.7.0.1
 */