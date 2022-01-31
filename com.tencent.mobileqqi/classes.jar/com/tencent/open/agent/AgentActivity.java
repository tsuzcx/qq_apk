package com.tencent.open.agent;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;

public class AgentActivity
  extends Activity
{
  protected static final String b = "AgentActivity";
  private static final String c = "RESTART_FLAG";
  protected Handler a;
  protected String a;
  protected boolean a;
  
  public AgentActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  protected static String a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64).signatures;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramContext[0].toByteArray());
      paramContext = a(localMessageDigest.digest());
      localMessageDigest.reset();
      localMessageDigest.update((paramString1 + "_" + paramContext + "_" + paramString2 + "").getBytes());
      paramContext = a(localMessageDigest.digest());
      paramString1.printStackTrace();
    }
    catch (Exception paramString1)
    {
      try
      {
        localMessageDigest.reset();
        return paramContext;
      }
      catch (Exception paramString1)
      {
        break label104;
      }
      paramString1 = paramString1;
      paramContext = "";
    }
    label104:
    return paramContext;
  }
  
  protected static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toString(paramArrayOfByte[i] & 0xFF, 16);
      String str1 = str2;
      if (str2.length() == 1) {
        str1 = "0" + str2;
      }
      localStringBuilder.append(str1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  protected void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", "传入参数有误!");
    localIntent.putExtra("key_error_detail", "");
    localIntent.putExtra("key_response", "");
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onActivityResult, action: " + this.jdField_a_of_type_JavaLangString + " | requestCode: " + paramInt1 + " | resultCode: " + paramInt2 + " | data: " + paramIntent);
    }
    super.setResult(paramInt2, paramIntent);
    super.finish();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((super.getIntent() == null) || (paramBundle != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AgentActivity", 2, "-->onCreate, intent: " + super.getIntent() + " | savedInstanceState: " + paramBundle);
      }
      return;
    }
    if (BaseActivity.a(getIntent()))
    {
      finish();
      return;
    }
    String str = super.getIntent().getStringExtra("key_action");
    this.jdField_a_of_type_JavaLangString = str;
    LogUtility.c("AgentActivity", "action = " + str);
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onCreate, action: " + str);
    }
    Bundle localBundle = super.getIntent().getBundleExtra("key_params");
    if (localBundle == null)
    {
      a(-5);
      return;
    }
    Object localObject;
    if ("action_login".equals(str))
    {
      paramBundle = new Intent(this, AuthorityActivity.class);
      paramBundle.putExtra("key_action", str);
      str = super.getCallingPackage();
      localObject = paramBundle;
      if (!TextUtils.isEmpty(str))
      {
        localObject = System.currentTimeMillis() / 1000L + "";
        str = a(this, str, (String)localObject);
        localBundle.putString("sign", str);
        localBundle.putString("time", (String)localObject);
        localObject = paramBundle;
        if (QLog.isColorLevel())
        {
          QLog.d("AgentActivity", 2, "-->onCreate, sign: " + str);
          localObject = paramBundle;
        }
      }
    }
    label302:
    while (localObject != null)
    {
      ((Intent)localObject).putExtra("key_params", localBundle);
      try
      {
        super.startActivityForResult((Intent)localObject, 0);
        return;
      }
      catch (ActivityNotFoundException paramBundle)
      {
        paramBundle.printStackTrace();
        a(-6);
        super.finish();
        return;
      }
      if ("action_pay".equals(str))
      {
        localObject = new Intent(this, AuthorityActivity.class);
        ((Intent)localObject).putExtra("key_action", str);
      }
      else if (("action_quick_login".equals(str)) || ("action_ptlogin_login".equals(str)))
      {
        paramBundle = super.getCallingPackage();
        localObject = new Intent(this, QuickLoginAuthorityActivity.class);
        ((Intent)localObject).putExtra("key_action", str);
        localBundle.putString("packagename", paramBundle);
      }
      else
      {
        if ((!"action_invite".equals(str)) && (!"action_gift".equals(str)) && (!"action_ask".equals(str)) && (!"action_reactive".equals(str))) {
          break label536;
        }
        paramBundle = new Intent(this, SocialFriendChooser.class);
      }
    }
    for (;;)
    {
      localObject = paramBundle;
      if (paramBundle == null) {
        break label302;
      }
      paramBundle.putExtra("key_action", str);
      localObject = localBundle.getString("hopenid");
      localBundle.putString("encrytoken", OpensdkPreference.a(this, "openid_encrytoken").getString((String)localObject, ""));
      localObject = paramBundle;
      break label302;
      break;
      label536:
      if ("action_story".equals(str))
      {
        paramBundle = new Intent(this, SendStoryActivity.class);
      }
      else if ("action_brag".equals(str))
      {
        paramBundle = new Intent(this, BragActivity.class);
      }
      else
      {
        if (!"action_challenge".equals(str)) {
          break label614;
        }
        paramBundle = new Intent(this, ChallengeActivity.class);
      }
    }
    label614:
    a(-5);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onDestroy, action: " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean) {
      Process.killProcess(Process.myPid());
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("RESTART_FLAG", true);
    super.onSaveInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onSaveInstanceState, action: " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity
 * JD-Core Version:    0.7.0.1
 */