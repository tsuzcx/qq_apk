import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.profilecard.EditExtendFriendInfo.SchoolInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SchoolInfo;

public class afxn
{
  public static void D(Activity paramActivity, String paramString)
  {
    if (paramActivity.isFinishing())
    {
      QLog.d("CampusHelper", 1, "showGotoWriteSchoolBottomDialog return ");
      return;
    }
    DialogFromBottom localDialogFromBottom = new DialogFromBottom(paramActivity);
    View localView = paramActivity.getLayoutInflater().inflate(2131561317, null);
    localDialogFromBottom.setContentView(localView);
    Object localObject = (TextView)localView.findViewById(2131379857);
    aofk localaofk = new aofk(paramActivity.getResources().getString(2131701099) + "\024\022", 6, 16);
    aofk.a[] arrayOfa = (aofk.a[])localaofk.getSpans(0, localaofk.length(), aofk.a.class);
    if (arrayOfa.length > 0)
    {
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].setSize((int)(((TextView)localObject).getTextSize() + 0.5F) + wja.dp2px(2.0F, ((TextView)localObject).getResources()));
        i += 1;
      }
    }
    ((TextView)localObject).setText(localaofk);
    ((ImageView)localView.findViewById(2131362978)).setOnClickListener(new afxo(localDialogFromBottom));
    localDialogFromBottom.setOnCancelListener(new afxp());
    localObject = (Button)localView.findViewById(2131368097);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new afxq(paramActivity, paramString, localDialogFromBottom));
    ((LinearLayout)localView.findViewById(2131365231)).setVisibility(8);
    ((Button)localView.findViewById(2131377718)).setVisibility(8);
    localDialogFromBottom.show();
  }
  
  public static void E(Activity paramActivity, String paramString)
  {
    String str = "https://ti.qq.com/hybrid-h5/school_relation/selectschool?fromid=2&_wv=16777222&_wwv=128";
    if (!TextUtils.isEmpty(paramString)) {
      str = "https://ti.qq.com/hybrid-h5/school_relation/selectschool?fromid=2&_wv=16777222&_wwv=128&schoolname=" + paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, String.format("jumpToSchoolFillInWebPage url=%s", new Object[] { str }));
    }
    paramString = new Intent(paramActivity, QQBrowserActivity.class);
    paramString.putExtra("url", str);
    paramActivity.startActivity(paramString);
  }
  
  public static void F(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    e(paramQQAppInterface).edit().putBoolean("need_show_campus_certi_banner", paramBoolean).commit();
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "updateCampusCertificateBannerShowFlag result = " + paramBoolean);
    }
  }
  
  public static void G(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "updateShowSchoolBeginnerTip " + paramBoolean);
    }
    e(paramQQAppInterface).edit().putBoolean("extend_friend_school_beginner_guide", paramBoolean).commit();
  }
  
  public static EditExtendFriendInfo.SchoolInfo a(oidb_0xdb1.SchoolInfo paramSchoolInfo)
  {
    EditExtendFriendInfo.SchoolInfo localSchoolInfo = new EditExtendFriendInfo.SchoolInfo();
    if (paramSchoolInfo != null)
    {
      if (paramSchoolInfo.uint32_idx.has()) {
        localSchoolInfo.uint32_idx.set(paramSchoolInfo.uint32_idx.get());
      }
      if (paramSchoolInfo.uint32_category.has()) {
        localSchoolInfo.uint32_category.set(paramSchoolInfo.uint32_category.get());
      }
      if (paramSchoolInfo.str_school_id.has()) {
        localSchoolInfo.str_school_id.set(paramSchoolInfo.str_school_id.get());
      }
      if (paramSchoolInfo.str_school_name.has()) {
        localSchoolInfo.str_school_name.set(paramSchoolInfo.str_school_name.get());
      }
      if (paramSchoolInfo.str_department_id.has()) {
        localSchoolInfo.str_department_id.set(paramSchoolInfo.str_department_id.get());
      }
      if (paramSchoolInfo.str_department_name.has()) {
        localSchoolInfo.str_department_name.set(paramSchoolInfo.str_department_name.get());
      }
      if (paramSchoolInfo.uint32_degree.has()) {
        localSchoolInfo.uint32_degree.set(paramSchoolInfo.uint32_degree.get());
      }
      if (paramSchoolInfo.uint32_enrollment_year.has()) {
        localSchoolInfo.uint32_enrollment_year.set(paramSchoolInfo.uint32_enrollment_year.get());
      }
      if (paramSchoolInfo.uint32_graduation_year.has()) {
        localSchoolInfo.uint32_graduation_year.set(paramSchoolInfo.uint32_graduation_year.get());
      }
      if (paramSchoolInfo.uint32_allow_recommend.has()) {
        localSchoolInfo.uint32_allow_recommend.set(paramSchoolInfo.uint32_allow_recommend.get());
      }
      if (paramSchoolInfo.uint32_create_source.has()) {
        localSchoolInfo.uint32_create_source.set(paramSchoolInfo.uint32_create_source.get());
      }
      if (paramSchoolInfo.uint32_create_time.has()) {
        localSchoolInfo.uint32_create_time.set(paramSchoolInfo.uint32_create_time.get());
      }
      if (paramSchoolInfo.uint32_update_source.has()) {
        localSchoolInfo.uint32_update_source.set(paramSchoolInfo.uint32_update_source.get());
      }
      if (paramSchoolInfo.uint32_update_time.has()) {
        localSchoolInfo.uint32_update_time.set(paramSchoolInfo.uint32_update_time.get());
      }
      if (paramSchoolInfo.uint32_hidden_flag.has()) {
        localSchoolInfo.uint32_hidden_flag.set(paramSchoolInfo.uint32_hidden_flag.get());
      }
      if (paramSchoolInfo.uint32_verify_status.has()) {
        localSchoolInfo.uint32_verified.set(paramSchoolInfo.uint32_verify_status.get());
      }
    }
    return localSchoolInfo;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    String str = "https://ti.qq.com/hybrid-h5/school_relation/extendeducation?fromid=2&_wv=16777220&_wwv=128";
    if (!TextUtils.isEmpty(paramString1)) {
      str = "https://ti.qq.com/hybrid-h5/school_relation/extendeducation?fromid=2&_wv=16777220&_wwv=128&category=" + paramInt2 + "&schoolname=" + paramString1 + "&schoolid=" + paramString2 + "&idx=" + paramInt1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, String.format("jumpToEditSchoolInfoWebPage url=%s", new Object[] { str }));
    }
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString1.putExtra("url", str);
    paramActivity.startActivity(paramString1);
  }
  
  public static void a(Activity paramActivity, afsg paramafsg, String paramString, EditExtendFriendInfo.SchoolInfo paramSchoolInfo)
  {
    if (paramActivity.isFinishing())
    {
      QLog.d("CampusHelper", 1, "showProfileEduBackgroundUpdateDialog return ");
      return;
    }
    paramString = String.format(paramActivity.getString(2131701088), new Object[] { paramString });
    aqha.a(paramActivity, 230).setMessage(paramString).setPositiveButton(paramActivity.getString(2131701089), new afxs(paramafsg, paramSchoolInfo)).setNegativeButton(paramActivity.getString(2131721058), new afxr()).show();
  }
  
  public static boolean ax(QQAppInterface paramQQAppInterface)
  {
    boolean bool = e(paramQQAppInterface).getBoolean("has_campus_shown_dialog_before", false);
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "hasCampusTabShownDialogBefore result = " + bool);
    }
    return bool;
  }
  
  public static boolean ay(QQAppInterface paramQQAppInterface)
  {
    boolean bool = e(paramQQAppInterface).getBoolean("need_show_campus_certi_banner", false);
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "getCampusCertificateBannerShowFlag result = " + bool);
    }
    return bool;
  }
  
  public static boolean az(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return e(paramQQAppInterface).getBoolean("extend_friend_school_beginner_guide", true);
  }
  
  public static void b(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = "https://h5.qzone.qq.com/v2/wezone/schoolauth?busitype=2&_wv=3&_proxy=1&idx=" + paramInt + "&schoolname=" + paramString1 + "&schoolid=" + paramString2;
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, String.format("jumpToSchoolCertificateWebPage url=%s", new Object[] { paramString1 }));
    }
    paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramActivity.startActivity(paramString2);
  }
  
  public static void cS(QQAppInterface paramQQAppInterface)
  {
    e(paramQQAppInterface).edit().putBoolean("has_campus_shown_dialog_before", true).commit();
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "markCampusTabHasShownDialog ");
    }
  }
  
  public static SharedPreferences e(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentUin() + "extend_friend_campus_file", 0);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = e(paramQQAppInterface);
    int j = localSharedPreferences.getInt("campus_certi_status", -1);
    int i;
    if (paramInt1 != j)
    {
      i = 1;
      if (i != 0)
      {
        localSharedPreferences.edit().putInt("campus_certi_status", paramInt1).commit();
        if (paramInt1 != 0) {
          break label121;
        }
        F(paramQQAppInterface, true);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusHelper", 2, "updateCertificateBannerShowFlag  oldStatus = " + j + ",newStatus = " + paramInt1 + ",certificateType = " + paramInt2);
      }
      return;
      i = 0;
      break;
      label121:
      if (paramInt2 == 2) {
        F(paramQQAppInterface, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxn
 * JD-Core Version:    0.7.0.1
 */