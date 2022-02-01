import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class smu
  implements AdapterView.OnItemClickListener
{
  static String aEM = "https://imgplat.store.qq.com/bqq_qfpic/520520/%s_%s_face/0";
  public static String aEN = "https://s.p.qq.com/pub/get_face?img_type=3&uin=";
  public static String aEO = "https://spqq.mp.qq.com/pub/get_face?img_type=3&uin=";
  public static String aEP = "https://spqq.mp.qq.com/pub/get_face_https?img_type=3&uin=";
  protected ShareActionSheetBuilder a;
  protected smu.a a;
  protected int mAccountType;
  protected BaseActivity mActivity;
  protected QQAppInterface mApp;
  protected float mDensity;
  protected String mShareUrl;
  
  public smu(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, smu.a parama, int paramInt, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramBaseActivity;
    this.mDensity = paramBaseActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Smu$a = parama;
    this.mAccountType = paramInt;
    this.mShareUrl = paramString;
  }
  
  public static void a(Activity paramActivity, smu.a parama, int paramInt, String paramString)
  {
    asgx.a(paramActivity, 6, parama.name, parama.summary, paramString, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + parama.uin, parama.uin, paramInt, true);
  }
  
  public static void a(BaseActivity paramBaseActivity, smu.a parama, int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", parama.name);
    localBundle.putString("desc", parama.summary);
    localBundle.putString("detail_url", paramString);
    paramString = new ArrayList(1);
    if (paramInt == 1) {
      paramString.add(aEN + parama.uin);
    }
    for (;;)
    {
      localBundle.putStringArrayList("image_url", paramString);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("pubUin", parama.uin);
      localBundle.putBoolean("from_card", true);
      avqq.a(paramBaseActivity.app, paramBaseActivity, localBundle, null);
      return;
      if (paramInt == 2) {
        try
        {
          long l = Long.parseLong(parama.uin);
          paramInt = (int)(l % 256L);
          paramString.add(String.format(aEM, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
        }
        catch (Exception paramBaseActivity) {}
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, smu.a parama, int paramInt1, String paramString, int paramInt2)
  {
    int i = 0;
    if (!WXShareHelper.a().isWXinstalled()) {
      paramInt1 = 2131721935;
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        rwt.ez(0, paramInt1);
        return;
        if (!WXShareHelper.a().isWXsupportApi()) {
          paramInt1 = 2131721936;
        }
      }
      else
      {
        String str1 = String.valueOf(System.currentTimeMillis());
        Object localObject = new smv(str1);
        WXShareHelper.a().a((WXShareHelper.a)localObject);
        localObject = WXShareHelper.a();
        String str2 = parama.name;
        paramBaseActivity = paramBaseActivity.app.a(parama.uin, (byte)1, true);
        parama = parama.summary;
        if (paramInt2 == 9) {}
        for (paramInt1 = i;; paramInt1 = 1)
        {
          ((WXShareHelper)localObject).a(str1, str2, paramBaseActivity, parama, paramString, paramInt1);
          return;
        }
      }
      paramInt1 = -1;
    }
  }
  
  public static void b(Activity paramActivity, smu.a parama, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ShareActionSheet shareToFriend");
    }
    localIntent.setClass(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("category", paramActivity.getString(2131697475));
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("detail_url", paramString);
    localIntent.putExtra("title", parama.name);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("desc", cutString(parama.summary));
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("struct_share_key_content_action", "plugin");
    localIntent.putExtra("pubUin", parama.uin);
    localIntent.putExtra("pluginName", "public_account");
    String str = "";
    paramString = "";
    if (paramInt == 1)
    {
      localIntent.putExtra("image_url_remote", aEN + parama.uin);
      str = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + parama.uin;
      paramString = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + parama.uin + "&version=1";
    }
    for (;;)
    {
      localIntent.putExtra("struct_share_key_content_a_action_DATA", str);
      localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString);
      parama = anre.a(localIntent.getExtras());
      if (parama != null)
      {
        localIntent.putExtra("stuctmsg_bytes", parama.getBytes());
        localIntent.putExtra("from_card", true);
        paramActivity.startActivity(localIntent);
      }
      return;
      if (paramInt == 2)
      {
        long l = Long.parseLong(parama.uin);
        paramInt = (int)(l % 256L);
        localIntent.putExtra("image_url_remote", String.format(aEM, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
        str = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + parama.uin;
        paramString = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + parama.uin + "&version=1";
      }
    }
  }
  
  public static String cutString(String paramString)
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
  
  public void Qq()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.mActivity);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.mActivity.getString(2131720177));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a()
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
    localActionSheetItem.label = this.mActivity.getString(2131698643);
    localActionSheetItem.icon = 2130839253;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.mActivity.getString(2131698652);
    localActionSheetItem.icon = 2130839256;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.mActivity.getString(2131698633);
    localActionSheetItem.icon = 2130839249;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    asgx.g(this.mActivity, localArrayList);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 == null)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    int i = ((ShareActionSheetBuilder.b)localObject1).b.action;
    label99:
    Object localObject3;
    Object localObject2;
    switch (i)
    {
    default: 
      localObject1 = null;
    case 2: 
    case 3: 
      while ((this.jdField_a_of_type_Smu$a.bxN == smu.a.bxM) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject3 = this.mApp;
        String str = this.jdField_a_of_type_Smu$a.uin;
        if (!this.jdField_a_of_type_Smu$a.isFollowed) {
          break label449;
        }
        localObject2 = "02";
        anot.a((QQAppInterface)localObject3, "dc01160", "Pb_account_lifeservice", str, "0X8007CA6", "0X8007CA6", 0, 0, (String)localObject2, (String)localObject1, String.valueOf(this.jdField_a_of_type_Smu$a.aDn), "");
        break;
        b(this.mActivity, this.jdField_a_of_type_Smu$a, this.mAccountType, this.mShareUrl);
        PublicAccountHandler.a(this.mApp, this.jdField_a_of_type_Smu$a.uin, "Grp_tribe", "interest_data", "share_qq");
        localObject1 = "01";
        continue;
        a(this.mActivity, this.jdField_a_of_type_Smu$a, this.mAccountType, this.mShareUrl);
        PublicAccountHandler.a(this.mApp, this.jdField_a_of_type_Smu$a.uin, "Grp_tribe", "interest_data", "share_qzone");
        localObject1 = "02";
      }
    case 9: 
    case 10: 
      label150:
      a(this.mActivity, this.jdField_a_of_type_Smu$a, this.mAccountType, this.mShareUrl, i);
      localObject2 = this.mApp;
      localObject3 = this.jdField_a_of_type_Smu$a.uin;
      if (i == 9)
      {
        localObject1 = "share_wechat";
        label339:
        PublicAccountHandler.a((AppInterface)localObject2, (String)localObject3, "Grp_tribe", "interest_data", (String)localObject1);
        kbp.a(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_Smu$a.uin, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
        if (9 != i) {
          break label457;
        }
      }
      break;
    }
    label449:
    label457:
    for (localObject1 = "03";; localObject1 = null)
    {
      if (10 != i) {
        break label99;
      }
      localObject1 = "04";
      break label99;
      localObject1 = "share_circle";
      break label339;
      a(this.mActivity, this.jdField_a_of_type_Smu$a, this.mAccountType, this.mShareUrl);
      break;
      localObject2 = "01";
      break label150;
    }
  }
  
  public static class a
  {
    public static int bxL;
    public static int bxM = 1;
    public int aDn;
    public int bxN = bxL;
    public boolean isFollowed;
    String name;
    String summary;
    String uin;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.uin = paramString1;
      this.name = paramString2;
      this.summary = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smu
 * JD-Core Version:    0.7.0.1
 */