import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.mobileqq.profile.ProfileCardShareHelper.3;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class alcp
{
  private alcp.a jdField_a_of_type_Alcp$a;
  private arhz jdField_a_of_type_Arhz;
  private String bVp;
  private int busiId;
  private Bitmap cR;
  private boolean cwe;
  private ShareActionSheetBuilder e;
  private Activity mActivity;
  private QQAppInterface mApp;
  private String mNickname;
  private AdapterView.OnItemClickListener mOnItemClickListener = new alcr(this);
  private String mUin;
  private BroadcastReceiver w = new alcq(this);
  
  public alcp(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt, alcp.a parama)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.busiId = paramInt;
    this.jdField_a_of_type_Alcp$a = parama;
    if (paramQQAppInterface == null) {
      registerReceiver();
    }
  }
  
  private void NX(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardShareHelper", 2, String.format("decodeFace: %s", new Object[] { paramString }));
    }
    ThreadManager.getSubThreadHandler().post(new ProfileCardShareHelper.3(this, paramString));
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.mActivity.getString(2131698630);
    localActionSheetItem.icon = 2130839252;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.mActivity.getString(2131698652);
    localActionSheetItem.icon = 2130839256;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void c(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    this.cwe = false;
    long l = System.currentTimeMillis();
    paramString1 = "https://ti.qq.com/open_qq/index2.html?url=mqqapi%3a%2f%2fuserprofile%2ffriend_profile_card%3fsrc_type%3dweb%26version%3d1.0%26source%3d2%26uin%3d" + paramString1;
    WXShareHelper.a().d(String.valueOf(l), paramString2, paramBitmap, "来自QQ的推荐好友", paramString1);
  }
  
  private void dBX()
  {
    if ((TextUtils.isEmpty(this.mUin)) || (TextUtils.isEmpty(this.mNickname))) {
      QLog.d("ProfileCardShareHelper", 1, String.format("shareToFriend, uin or nickname is empty, uin: %s, nickname: %s", new Object[] { this.mUin, this.mNickname }));
    }
    for (;;)
    {
      return;
      Object localObject1 = new AbsShareMsg.a(StructMsgForGeneralShare.class);
      String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.mUin;
      String str2 = "AppCmd://OpenContactInfo/?uin=" + this.mUin;
      String str3 = acfp.m(2131709905);
      String str4 = acfp.m(2131709951) + this.mUin;
      String str5 = this.mActivity.getResources().getString(2131718642);
      localObject1 = ((AbsShareMsg.a)localObject1).c(14).a(acfp.m(2131709934) + this.mNickname).a(2).a(1).a("plugin", "", str2, str1, str1).d(str5).a();
      Object localObject2 = new anug();
      ((anqv)localObject2).Vs(1);
      ((anqv)localObject2).Rn(str3);
      antd localantd = new antd();
      localantd.Vs(1);
      localantd.a(new ansr(str1));
      localantd.a(new StructMsgItemTitle(this.mNickname));
      localantd.a(new anux(str4));
      ((AbsShareMsg)localObject1).addItem((anqu)localObject2);
      ((AbsShareMsg)localObject1).addItem(localantd);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("forward_type", 20);
      ((Bundle)localObject2).putInt("structmsg_service_id", 14);
      ((Bundle)localObject2).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      ((Bundle)localObject2).putBoolean("k_dataline", false);
      if (this.busiId == 1)
      {
        localObject1 = new Intent(this.mActivity, ShareToQQActivity.class);
        ((Bundle)localObject2).putString("sourceFrom", "share_from_troop_member_card");
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        this.mActivity.startActivity((Intent)localObject1);
      }
      while (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(300);
        ((StringBuilder)localObject1).append("recommentFriend [title: ").append(str3).append(", nickname: ").append(this.mNickname).append(", info: ").append(str4).append(", serviceId: ").append(14).append(", pActionData: ").append(str2).append(", aActionData: ").append(str1).append(", iActionData: ").append(str1).append(", compatibleText: ").append(str5).append("]");
        QLog.i("ProfileCardShareHelper", 2, ((StringBuilder)localObject1).toString());
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        ahgq.f(this.mActivity, (Intent)localObject1, 21);
      }
    }
  }
  
  private void dEY()
  {
    if (this.cwe) {
      return;
    }
    int i;
    if (!WXShareHelper.a().isWXinstalled()) {
      i = 2131721935;
    }
    for (;;)
    {
      if (i != -1)
      {
        QQToast.a(this.mActivity, 1, i, 1).show();
        QLog.d("ProfileCardShareHelper", 1, "shareToWXFriend, but wechat is not install or version is too low");
        return;
        if (!WXShareHelper.a().isWXsupportApi()) {
          i = 2131721936;
        }
      }
      else
      {
        this.cwe = true;
        if (this.cR != null)
        {
          c(this.mUin, this.mNickname, this.cR);
          return;
        }
        if (ahbj.isFileExists(this.bVp)) {
          NX(this.bVp);
        }
        for (;;)
        {
          showProgressDialog();
          return;
          if (this.mApp != null)
          {
            this.bVp = this.mApp.getCustomFaceFilePath(1, this.mUin, 0);
            NX(this.bVp);
          }
          else
          {
            ArrayList localArrayList = new ArrayList(1);
            localArrayList.add(this.mUin);
            Intent localIntent = new Intent("com.tencent.qqhead.getheadreq");
            localIntent.putExtra("faceType", 1);
            localIntent.putStringArrayListExtra("uinList", localArrayList);
            this.mActivity.sendBroadcast(localIntent, "com.tencent.tim.qqhead.permission.getheadresp");
          }
        }
      }
      i = -1;
    }
  }
  
  public void destroy()
  {
    if (this.w != null) {
      this.mActivity.unregisterReceiver(this.w);
    }
  }
  
  public void dismissProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing()))
    {
      this.jdField_a_of_type_Arhz.dismiss();
      this.jdField_a_of_type_Arhz = null;
    }
  }
  
  public void gW(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardShareHelper", 2, String.format("share, uin: %s, nickname: %s", new Object[] { paramString1, paramString2 }));
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      if (!paramString1.equals(this.mUin)) {
        this.cR = null;
      }
      this.mUin = paramString1;
      this.mNickname = paramString2;
      if (this.e == null)
      {
        this.e = new ShareActionSheetBuilder(this.mActivity);
        this.e.setActionSheetItems(a());
        this.e.setItemClickListener(this.mOnItemClickListener);
      }
    } while (this.e.isShowing());
    this.e.show();
  }
  
  public void registerReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    this.mActivity.registerReceiver(this.w, localIntentFilter, "com.tencent.tim.qqhead.permission.getheadresp", null);
  }
  
  protected void showProgressDialog()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_Arhz == null)
      {
        this.jdField_a_of_type_Arhz = new arhz(this.mActivity, this.mActivity.getResources().getDimensionPixelSize(2131299627));
        this.jdField_a_of_type_Arhz.setCancelable(false);
      }
      this.jdField_a_of_type_Arhz.setMessage(acfp.m(2131709935));
      this.jdField_a_of_type_Arhz.show();
    }
  }
  
  public static abstract interface a
  {
    public abstract void bj(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alcp
 * JD-Core Version:    0.7.0.1
 */