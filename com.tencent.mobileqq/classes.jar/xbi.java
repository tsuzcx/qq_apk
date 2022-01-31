import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class xbi
  implements AdapterView.OnItemClickListener
{
  static String a;
  public static String b;
  public static String c;
  public static String d = "https://spqq.mp.qq.com/pub/get_face_https?img_type=3&uin=";
  protected float a;
  protected int a;
  protected bbjq a;
  protected BaseActivity a;
  protected QQAppInterface a;
  protected xbk a;
  protected String e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://imgplat.store.qq.com/bqq_qfpic/520520/%s_%s_face/0";
    jdField_b_of_type_JavaLangString = "http://s.p.qq.com/pub/get_face?img_type=3&uin=";
    jdField_c_of_type_JavaLangString = "https://spqq.mp.qq.com/pub/get_face?img_type=3&uin=";
  }
  
  public xbi(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, xbk paramxbk, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Float = paramBaseActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Xbk = paramxbk;
    this.jdField_a_of_type_Int = paramInt;
    this.e = paramString;
  }
  
  public static String a(String paramString)
  {
    if ((paramString.length() <= 30) && (paramString.getBytes().length <= 100)) {
      return paramString;
    }
    String str = paramString;
    if (paramString.length() > 30) {
      str = paramString.substring(0, 30);
    }
    paramString = str;
    if (Math.min(str.getBytes().length, 100) == 100)
    {
      int i = str.length() / 2;
      paramString = new StringBuilder(str.substring(0, i));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(str.charAt(i));
        i += 1;
      }
      paramString = paramString.toString();
    }
    return paramString + "...";
  }
  
  public static void a(Activity paramActivity, xbk paramxbk, int paramInt, String paramString)
  {
    bduf.a(paramActivity, 6, paramxbk.jdField_b_of_type_JavaLangString, paramxbk.jdField_c_of_type_JavaLangString, paramString, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramxbk.jdField_a_of_type_JavaLangString, paramxbk.jdField_a_of_type_JavaLangString, paramInt, true);
  }
  
  public static void a(BaseActivity paramBaseActivity, xbk paramxbk, int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramxbk.jdField_b_of_type_JavaLangString);
    localBundle.putString("desc", paramxbk.jdField_c_of_type_JavaLangString);
    localBundle.putString("detail_url", paramString);
    paramString = new ArrayList(1);
    if (paramInt == 1) {
      paramString.add(jdField_b_of_type_JavaLangString + paramxbk.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      localBundle.putStringArrayList("image_url", paramString);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("pubUin", paramxbk.jdField_a_of_type_JavaLangString);
      localBundle.putBoolean("from_card", true);
      bgzl.a(paramBaseActivity.app, paramBaseActivity, localBundle, null);
      return;
      if (paramInt == 2) {
        try
        {
          long l = Long.parseLong(paramxbk.jdField_a_of_type_JavaLangString);
          paramInt = (int)(l % 256L);
          paramString.add(String.format(jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
        }
        catch (Exception paramBaseActivity) {}
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, xbk paramxbk, int paramInt1, String paramString, int paramInt2)
  {
    int i = 0;
    if (!WXShareHelper.a().a()) {
      paramInt1 = 2131720917;
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        wij.a(0, paramInt1);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt1 = 2131720918;
        }
      }
      else
      {
        String str1 = String.valueOf(System.currentTimeMillis());
        Object localObject = new xbj(str1);
        WXShareHelper.a().a((bcww)localObject);
        localObject = WXShareHelper.a();
        String str2 = paramxbk.jdField_b_of_type_JavaLangString;
        paramBaseActivity = paramBaseActivity.app.a(paramxbk.jdField_a_of_type_JavaLangString, (byte)1, true);
        paramxbk = paramxbk.jdField_c_of_type_JavaLangString;
        if (paramInt2 == 9) {}
        for (paramInt1 = i;; paramInt1 = 1)
        {
          ((WXShareHelper)localObject).b(str1, str2, paramBaseActivity, paramxbk, paramString, paramInt1);
          return;
        }
      }
      paramInt1 = -1;
    }
  }
  
  public static void b(Activity paramActivity, xbk paramxbk, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ShareActionSheet shareToFriend");
    }
    localIntent.setClass(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("category", paramActivity.getString(2131695612));
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("detail_url", paramString);
    localIntent.putExtra("title", paramxbk.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("desc", a(paramxbk.jdField_c_of_type_JavaLangString));
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("struct_share_key_content_action", "plugin");
    localIntent.putExtra("pubUin", paramxbk.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("pluginName", "public_account");
    String str = "";
    paramString = "";
    if (paramInt == 1)
    {
      localIntent.putExtra("image_url_remote", jdField_b_of_type_JavaLangString + paramxbk.jdField_a_of_type_JavaLangString);
      str = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramxbk.jdField_a_of_type_JavaLangString;
      paramString = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + paramxbk.jdField_a_of_type_JavaLangString + "&version=1";
    }
    for (;;)
    {
      localIntent.putExtra("struct_share_key_content_a_action_DATA", str);
      localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString);
      paramxbk = axva.a(localIntent.getExtras());
      if (paramxbk != null)
      {
        localIntent.putExtra("stuctmsg_bytes", paramxbk.getBytes());
        localIntent.putExtra("from_card", true);
        paramActivity.startActivity(localIntent);
      }
      return;
      if (paramInt == 2)
      {
        long l = Long.parseLong(paramxbk.jdField_a_of_type_JavaLangString);
        paramInt = (int)(l % 256L);
        localIntent.putExtra("image_url_remote", String.format(jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
        str = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramxbk.jdField_a_of_type_JavaLangString;
        paramString = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramxbk.jdField_a_of_type_JavaLangString + "&version=1";
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbjq == null)
    {
      this.jdField_a_of_type_Bbjq = new bbjq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_Bbjq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719508));
      this.jdField_a_of_type_Bbjq.a(a());
      this.jdField_a_of_type_Bbjq.a(this);
    }
    try
    {
      this.jdField_a_of_type_Bbjq.a();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  protected List<bbjs>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    bbjs localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696696);
    localbbjs.jdField_b_of_type_Int = 2130838754;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.jdField_c_of_type_Int = 2;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696709);
    localbbjs.jdField_b_of_type_Int = 2130838755;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.jdField_c_of_type_Int = 3;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696716);
    localbbjs.jdField_b_of_type_Int = 2130838758;
    localbbjs.jdField_c_of_type_Int = 9;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696699);
    localbbjs.jdField_b_of_type_Int = 2130838752;
    localbbjs.jdField_c_of_type_Int = 10;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    bduf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    this.jdField_a_of_type_Bbjq.b();
    paramInt = ((bbjv)paramAdapterView).a.jdField_c_of_type_Int;
    label82:
    Object localObject;
    switch (paramInt)
    {
    default: 
      paramAdapterView = null;
    case 2: 
    case 3: 
      while ((this.jdField_a_of_type_Xbk.jdField_c_of_type_Int == xbk.jdField_b_of_type_Int) && (!TextUtils.isEmpty(paramAdapterView)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_Xbk.jdField_a_of_type_JavaLangString;
        if (!this.jdField_a_of_type_Xbk.jdField_a_of_type_Boolean) {
          break label413;
        }
        paramView = "02";
        axqy.b((QQAppInterface)localObject, "dc01160", "Pb_account_lifeservice", str, "0X8007CA6", "0X8007CA6", 0, 0, paramView, paramAdapterView, String.valueOf(this.jdField_a_of_type_Xbk.d), "");
        return;
        b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Xbk, this.jdField_a_of_type_Int, this.e);
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Xbk.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "share_qq");
        paramAdapterView = "01";
        continue;
        a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Xbk, this.jdField_a_of_type_Int, this.e);
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Xbk.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "share_qzone");
        paramAdapterView = "02";
      }
    case 9: 
    case 10: 
      label131:
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Xbk, this.jdField_a_of_type_Int, this.e, paramInt);
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject = this.jdField_a_of_type_Xbk.jdField_a_of_type_JavaLangString;
      if (paramInt == 9)
      {
        paramAdapterView = "share_wechat";
        label310:
        PublicAccountHandler.a(paramView, (String)localObject, "Grp_tribe", "interest_data", paramAdapterView);
        nol.a(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_Xbk.jdField_a_of_type_JavaLangString, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
        if (9 != paramInt) {
          break label420;
        }
      }
      break;
    }
    label413:
    label420:
    for (paramAdapterView = "03";; paramAdapterView = null)
    {
      if (10 != paramInt) {
        break label82;
      }
      paramAdapterView = "04";
      break label82;
      paramAdapterView = "share_circle";
      break label310;
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Xbk, this.jdField_a_of_type_Int, this.e);
      break;
      paramView = "01";
      break label131;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xbi
 * JD-Core Version:    0.7.0.1
 */