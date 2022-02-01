import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.4;
import com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.5;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;

public class zsi
{
  protected aqju X;
  aqju a;
  protected arhz a;
  private String aMk;
  private String aMl;
  public boolean aRg;
  private String aZT;
  private String aZU;
  private String baN;
  public boolean bqN;
  private boolean bsY;
  private Runnable eV = new SDKAvatarSettingManager.4(this);
  private Runnable eW = new SDKAvatarSettingManager.5(this);
  private boolean isSuccess;
  private Activity mActivity;
  private Handler mHandler;
  private String mPkgName;
  protected aqju x;
  
  public zsi(Activity paramActivity)
  {
    this.jdField_a_of_type_Aqju = null;
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " onCreate ");
    }
    this.mActivity = paramActivity;
    this.mHandler = new Handler();
  }
  
  private void a(Activity paramActivity, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "sdk_share:sdk callback=" + paramBoolean1 + " appid=" + paramLong);
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    if (paramBoolean2) {
      localIntent.putExtra("stay_back_stack", true);
    }
    if (paramBoolean1) {
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), "sdkSetAvatar" })));
    }
    for (;;)
    {
      if (paramActivity.getIntent() != null) {
        localIntent.setPackage(this.mPkgName);
      }
      try
      {
        paramActivity.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException paramActivity) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SDKAvatarSettingManager", 2, paramActivity.getMessage());
      return;
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error", new Object[] { Long.valueOf(paramLong), "sdkSetAvatar" })));
    }
  }
  
  private void coq()
  {
    String str = this.mActivity.getString(2131720024) + this.aZT;
    if (!TextUtils.isEmpty(this.mPkgName)) {}
    for (;;)
    {
      try
      {
        localObject1 = this.mActivity.getPackageManager().getPackageInfo(this.mPkgName, 64);
        if (localObject1 == null) {
          break label310;
        }
        localObject1 = ((PackageInfo)localObject1).signatures;
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label310;
        }
        localObject3 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject3).update(localObject1[0].toByteArray());
        localObject1 = aqhs.bytes2HexStr(((MessageDigest)localObject3).digest());
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject1 = aqha.a(this.mActivity, 230);
          ((aqju)localObject1).setMessage(acfp.m(2131714074));
          ((aqju)localObject1).setNegativeButton(2131721058, new zsj(this));
          ((aqju)localObject1).setCancelable(false);
          ((aqju)localObject1).show();
          return;
        }
        catch (Exception localException2)
        {
          Object localObject2;
          QLog.e("SDKAvatarSettingManager", 1, "show invalid param dialog, exception=", localException2);
          return;
        }
        localException1 = localException1;
        QLog.e("SDKAvatarSettingManager", 1, "check, get signature exception=", localException1);
        localObject2 = null;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SDKAvatarSettingManager", 2, "checkApiPermission api, mShareAppId=" + this.aMk + ", mPkgName=" + this.mPkgName + ",signature=" + (String)localObject1 + ",mSdkVerdion=" + this.aZU);
      }
      if ((!TextUtils.isEmpty(this.aMk)) && (!TextUtils.isEmpty(this.mPkgName)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        break;
      }
      QLog.e("SDKAvatarSettingManager", 1, new Object[] { "check, invalid param, mShareAppId=", this.aMk, ", pkgName=", this.mPkgName, ", signature=", localObject1 });
      QLog.e("SDKAvatarSettingManager", 1, "check, pkgName null");
      label310:
      localObject2 = null;
    }
    tzk.prepare();
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("sdkVersion", this.aZU);
    ((Bundle)localObject3).putString("pkgName", this.mPkgName);
    ((Bundle)localObject3).putString("signature", localException2);
    am(2131720190);
    this.mHandler.postDelayed(this.eV, 5000L);
    tzk.a(this.mActivity, 1, this.aMk, (Bundle)localObject3).a("sdk_avatar_edit", null, new zsk(this, str));
  }
  
  private void cos()
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " checkJumpAction mShareAppId = " + this.aMk + "， mShareOpenId =" + this.aMl);
    }
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(this.mActivity, false, Long.valueOf(this.aMk).longValue(), false);
      cou();
      this.mActivity.moveTaskToBack(true);
      return;
    }
    if ((TextUtils.isEmpty(this.aMk)) || (TextUtils.isEmpty(this.aMl)))
    {
      hideProgressDialog();
      zF(this.baN);
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    OpenID localOpenID = localQQAppInterface.a().a(this.aMk);
    if (localOpenID == null)
    {
      am(2131720190);
      this.mHandler.postDelayed(this.eW, 8000L);
      try
      {
        long l = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
        localQQAppInterface.a().a(l, this.aMl, Long.valueOf(this.aMk).longValue(), new zsl(this));
        return;
      }
      catch (Exception localException)
      {
        return;
      }
    }
    if (!this.aMl.equals(localOpenID.openID))
    {
      if (QLog.isColorLevel()) {
        QLog.w("SDKAvatarSettingManager", 2, "-->preForward--openid doesn't equal current local openid");
      }
      bFG();
      return;
    }
    hideProgressDialog();
    zF(this.baN);
  }
  
  private void zF(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, "-->openPhotoEdit--path = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      i = aqep.w(this.mActivity);
      localIntent = new Intent();
      localIntent.setFlags(603979776);
      localIntent.putExtra("Business_Origin", 100);
      localIntent.putExtra("FROM_WHERE", "FROM_SDK_AVATAR_SET_IMAGE");
      PhotoUtils.a(localIntent, this.mActivity, FriendProfileCardActivity.class.getName(), i, i, 1080, 1080, paramString, aqep.BR(), 1035);
      this.bsY = true;
    }
    while (!QLog.isColorLevel())
    {
      int i;
      Intent localIntent;
      return;
    }
    QLog.d("SDKAvatarSettingManager", 2, "set from sdk path null");
  }
  
  public void am(int paramInt)
  {
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this.mActivity, this.mActivity.getResources().getDimensionPixelSize(2131299627));
    }
    this.jdField_a_of_type_Arhz.setMessage(paramInt);
    if (!this.mActivity.isFinishing()) {
      this.jdField_a_of_type_Arhz.show();
    }
  }
  
  protected void bFG()
  {
    if (this.x != null)
    {
      if (!this.x.isShowing()) {
        this.x.show();
      }
      return;
    }
    this.x = aqha.a(this.mActivity, 230);
    this.x.setMessage(acfp.m(2131714075));
    this.x.setTitle(2131693317);
    zso localzso = new zso(this);
    this.x.setNegativeButton(2131721058, localzso);
    this.x.setPositiveButton(2131720034, localzso);
    this.x.show();
  }
  
  public void cA(Intent paramIntent)
  {
    paramIntent = paramIntent.getBundleExtra("profile_extres");
    if (paramIntent != null)
    {
      this.baN = paramIntent.getString("key_from_sdk_set_avatar_path", null);
      this.aZT = paramIntent.getString("key_from_sdk_set_avatar_appname", null);
      this.aMk = paramIntent.getString("key_from_sdk_set_avatar_share_id", null);
      this.aMl = paramIntent.getString("key_from_sdk_set_avatar_open_id", null);
      this.mPkgName = paramIntent.getString("pkg_name", null);
      this.aZU = paramIntent.getString("sdk_version");
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " initParam ");
    }
  }
  
  protected void cou()
  {
    Intent localIntent = new Intent();
    this.mActivity.setResult(-1, localIntent);
    this.mActivity.finish();
  }
  
  public void crz()
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " gotoConversation isSuccess = " + this.isSuccess);
    }
    if (this.isSuccess)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.mActivity, SplashActivity.class);
      localIntent.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.putExtra("fragment_id", 1);
      this.mActivity.startActivity(localIntent);
    }
  }
  
  protected void dU(String paramString1, String paramString2)
  {
    if (this.X != null) {
      this.X.dismiss();
    }
    this.x = aqha.a(this.mActivity, 230);
    this.x.setMessage(paramString1);
    paramString1 = new zsp(this);
    this.x.setNegativeButton(paramString2, paramString1);
    this.x.show();
  }
  
  public void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public void o(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " onActivityResult resultCode = " + paramInt);
    }
    if (paramInt == -1) {
      if (paramIntent.getBooleanExtra("key_from_sdk_set_avatar_result", false))
      {
        this.isSuccess = true;
        zG(this.aZT);
      }
    }
    for (;;)
    {
      this.bsY = false;
      return;
      this.isSuccess = false;
      a(this.mActivity, false, Long.valueOf(this.aMk).longValue(), false);
      cou();
      this.mActivity.moveTaskToBack(true);
      continue;
      if (paramInt == 0)
      {
        paramIntent = new Intent();
        this.mActivity.setResult(0, paramIntent);
        this.mActivity.finish();
        this.mActivity.moveTaskToBack(true);
      }
      else
      {
        this.mActivity.finish();
      }
    }
  }
  
  public void onDestory()
  {
    if (this.jdField_a_of_type_Aqju != null) {
      this.jdField_a_of_type_Aqju.dismiss();
    }
    this.isSuccess = false;
    this.bsY = false;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (!this.bsY)
    {
      onDestory();
      cA(paramIntent);
      start();
      return;
    }
    a(this.mActivity, false, Long.valueOf(this.aMk).longValue(), false);
    cou();
    this.mActivity.moveTaskToBack(true);
  }
  
  public void start()
  {
    coq();
  }
  
  void zG(String paramString)
  {
    if (this.mActivity.isFinishing()) {
      return;
    }
    if ((this.jdField_a_of_type_Aqju != null) && (!this.jdField_a_of_type_Aqju.isShowing()))
    {
      this.jdField_a_of_type_Aqju.show();
      return;
    }
    this.jdField_a_of_type_Aqju = aqha.a(this.mActivity, 230);
    this.jdField_a_of_type_Aqju.setTitle(acfp.m(2131714076));
    Object localObject = this.mActivity.getString(2131720024);
    String str = this.mActivity.getString(2131720025);
    if (paramString != null) {}
    for (paramString = (String)localObject + paramString;; paramString = (String)localObject)
    {
      localObject = new zsm(this, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Aqju.setPositiveButton(str, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Aqju.setNegativeButton(paramString, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Aqju.setOnKeyListener(new zsn(this));
      this.jdField_a_of_type_Aqju.show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsi
 * JD-Core Version:    0.7.0.1
 */