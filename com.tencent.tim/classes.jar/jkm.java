import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.qcall.PstnCardInfo;
import com.tencent.tim.call.qcall.PstnSessionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa02.cmd0xa02.TinyID2UserAccInfo;

public class jkm
{
  private static Bitmap a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = ((ajdo)paramQQAppInterface.getManager(11)).b(paramString);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = aqgv.pu(((PhoneContact)localObject2).name);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = aqgv.pu(paramString);
    }
    paramString = new aqeo(paramQQAppInterface.getApp(), (String)localObject2);
    int i = paramString.getIntrinsicWidth();
    int j = paramString.getIntrinsicHeight();
    if (paramString.getOpacity() != -1) {}
    for (paramQQAppInterface = Bitmap.Config.ARGB_8888;; paramQQAppInterface = Bitmap.Config.RGB_565)
    {
      paramQQAppInterface = Bitmap.createBitmap(i, j, paramQQAppInterface);
      localObject1 = new Canvas(paramQQAppInterface);
      paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      paramString.draw((Canvas)localObject1);
      return paramQQAppInterface;
    }
  }
  
  public static AVPhoneUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = 0;
    String str;
    if ((paramString.startsWith("00")) || (paramString.startsWith("+")) || (paramString.startsWith("86"))) {
      if (paramString.startsWith("0086"))
      {
        paramString = paramString.substring(4);
        str = "0086";
        i = 1;
      }
    }
    for (;;)
    {
      AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.accountType = 3;
      localAVPhoneUserInfo.account = 0L;
      localAVPhoneUserInfo.telInfo.nation = str;
      localAVPhoneUserInfo.telInfo.mobile = paramString;
      localAVPhoneUserInfo.telInfo.nationState = i;
      return localAVPhoneUserInfo;
      if (paramString.startsWith("+86"))
      {
        paramString = paramString.substring(3);
        str = "+86";
        i = 1;
      }
      else if (paramString.startsWith("86"))
      {
        paramString = paramString.substring(2);
        str = "+86";
        i = 1;
      }
      else
      {
        return null;
        str = "+86";
      }
    }
  }
  
  public static PstnSessionInfo a(QQAppInterface paramQQAppInterface, PstnSessionInfo paramPstnSessionInfo, String paramString, int paramInt)
  {
    paramQQAppInterface = (ajdo)paramQQAppInterface.getManager(11);
    PhoneContact localPhoneContact;
    if ((paramInt == 1006) || (paramInt == 56938))
    {
      paramPstnSessionInfo.cGF = paramString;
      localPhoneContact = paramQQAppInterface.c(paramString);
      if (localPhoneContact != null) {
        if (localPhoneContact.uin.equals("0"))
        {
          paramPstnSessionInfo.mPeerUin = paramString;
          paramPstnSessionInfo.cGF = localPhoneContact.unifiedCode;
        }
      }
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null) {
        paramPstnSessionInfo.cGG = (paramQQAppInterface.nationCode + paramQQAppInterface.mobileNo);
      }
      paramPstnSessionInfo.mUinType = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("PstnUtils", 2, "PstnSessionInfo|mPeerUin=" + paramPstnSessionInfo.mPeerUin + ", mPeerPhoneNum=" + paramPstnSessionInfo.cGF + ", mSelfPhoneNum=" + paramPstnSessionInfo.cGG);
      }
      return paramPstnSessionInfo;
      paramPstnSessionInfo.mPeerUin = localPhoneContact.uin;
      break;
      paramPstnSessionInfo.mPeerUin = paramString;
      continue;
      if (paramInt == 26)
      {
        paramPstnSessionInfo.cGF = paramString;
        paramPstnSessionInfo.mPeerUin = paramString;
      }
      else
      {
        paramPstnSessionInfo.mPeerUin = paramString;
        paramString = paramQQAppInterface.a(paramString);
        if (paramString != null) {
          paramPstnSessionInfo.cGF = paramString.unifiedCode;
        }
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject2 = (atdc)paramQQAppInterface.getManager(746);
    Object localObject1 = ((atdc)localObject2).a(paramQQAppInterface.getCurrentAccountUin());
    if (paramInt == 1) {
      if ((localObject1 != null) && (((PstnCardInfo)localObject1).pstn_ever_c2c_vip == 1))
      {
        localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131697920);
        localObject2 = ((atdc)localObject2).ro("key_pstn_tried_c2c_recharge_title");
        paramQQAppInterface = (QQAppInterface)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface = (QQAppInterface)localObject1;
        }
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          str = paramQQAppInterface.getApplication().getResources().getString(2131697926);
          localObject1 = ((atdc)localObject2).ro("key_pstn_untried_c2c_recharge_title");
          paramQQAppInterface = (QQAppInterface)localObject1;
        } while (!TextUtils.isEmpty((CharSequence)localObject1));
        return str;
        if ((localObject1 == null) || (((PstnCardInfo)localObject1).pstn_ever_multi_vip != 1)) {
          break;
        }
        str = paramQQAppInterface.getApplication().getResources().getString(2131697923);
        localObject1 = ((atdc)localObject2).ro("key_pstn_tried_multi_recharge_title");
        paramQQAppInterface = (QQAppInterface)localObject1;
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      return str;
      str = paramQQAppInterface.getApplication().getResources().getString(2131697929);
      localObject1 = ((atdc)localObject2).ro("key_pstn_untried_multi_recharge_title");
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    return str;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnUtils", 2, "getPstnInfoFromQCallRecent --> uin = " + paramString + " ,uinType = " + paramInt);
    }
    if ((paramQQAppInterface == null) || (paramString == null)) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramQQAppInterface = (alkm)paramQQAppInterface.getManager(38);
      if (paramQQAppInterface == null) {
        break;
      }
      paramQQAppInterface = paramQQAppInterface.a(paramString, paramInt);
      if (paramQQAppInterface == null) {
        break;
      }
      paramString = paramQQAppInterface.pstnInfo;
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("PstnUtils", 2, "getPstnInfoFromQCallRecent --> value = " + paramString);
    return paramString;
    return null;
  }
  
  public static List<AVPhoneUserInfo> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = a(paramQQAppInterface, paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("PstnUtils", 2, " ==== getRealAVPhoneUserInfo === pstnInfo : " + (String)localObject1);
    }
    if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
      return null;
    }
    Object localObject2 = p((String)localObject1);
    if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
      return null;
    }
    localObject1 = (acdu)paramQQAppInterface.getManager(53);
    if (localObject1 == null) {
      return null;
    }
    paramString = ((acdu)localObject1).n(paramString);
    localObject1 = (ajdo)paramQQAppInterface.getManager(11);
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    AVPhoneUserInfo localAVPhoneUserInfo;
    while (((Iterator)localObject2).hasNext())
    {
      localAVPhoneUserInfo = (AVPhoneUserInfo)((Iterator)localObject2).next();
      paramQQAppInterface = localAVPhoneUserInfo.telInfo.mobile;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() != 0))
      {
        paramQQAppInterface = ((ajdo)localObject1).b(paramQQAppInterface);
        if (paramQQAppInterface == null) {
          break label266;
        }
      }
    }
    label266:
    for (paramQQAppInterface = paramQQAppInterface.uin;; paramQQAppInterface = null)
    {
      if ((paramQQAppInterface == null) || (paramQQAppInterface.length() == 0))
      {
        localArrayList.add(localAVPhoneUserInfo);
        break;
      }
      if ((paramString != null) && (paramString.containsKey(paramQQAppInterface))) {
        break;
      }
      localArrayList.add(localAVPhoneUserInfo);
      break;
      if (QLog.isColorLevel()) {
        QLog.i("PstnUtils", 2, " ==== getRealAVPhoneUserInfo === list : " + localArrayList.toString());
      }
      return localArrayList;
    }
  }
  
  public static List<Bitmap> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramQQAppInterface, paramString, paramInt1);
    QLog.i("PstnUtils", 2, " ==== getRealAVPhoneBitmap === pstnInfo : " + (String)localObject);
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = p((String)localObject);
    if ((localArrayList1 == null) || (localArrayList1.size() == 0)) {
      return null;
    }
    localObject = (acdu)paramQQAppInterface.getManager(53);
    if (localObject == null) {
      return null;
    }
    Map localMap = ((acdu)localObject).n(paramString);
    ajdo localajdo = (ajdo)paramQQAppInterface.getManager(11);
    ArrayList localArrayList2 = new ArrayList();
    paramInt2 = Math.min(paramInt2, localArrayList1.size());
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      localObject = (AVPhoneUserInfo)localArrayList1.get(paramInt1);
      String str = ((AVPhoneUserInfo)localObject).telInfo.mobile;
      if ((str == null) || (str.length() == 0)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        PhoneContact localPhoneContact = localajdo.b(str);
        paramString = null;
        if (localPhoneContact != null) {
          paramString = localPhoneContact.uin;
        }
        if ((paramString == null) || (paramString.length() == 0))
        {
          localArrayList2.add(a(paramQQAppInterface, str));
        }
        else if (!localMap.containsKey(paramString))
        {
          localObject = paramQQAppInterface.getFaceBitmap(11, ((AVPhoneUserInfo)localObject).telInfo.nation + str, (byte)3, true, 0);
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = a(paramQQAppInterface, str);
          }
          localArrayList2.add(paramString);
        }
      }
    }
    return localArrayList2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramContext, paramInt1, paramInt2, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = "https://imgcache.qq.com/lightalk/lightalk_pay/qq/index.html?_wv=1025&type=";
    if (paramBoolean) {
      localObject1 = "https://imgcache.qq.com/lightalk/lightalk_pay/qq/goods.html?_wv=1027&type=";
    }
    Object localObject2;
    if (paramInt1 != 1)
    {
      localObject2 = localObject1;
      if (paramInt1 != 2) {}
    }
    else
    {
      localObject2 = (String)localObject1 + paramInt1;
    }
    localObject1 = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", (String)localObject2);
    paramContext.startActivity((Intent)localObject1);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof QQAppInterface))) {
      aqmj.j(paramContext, paramQQAppInterface.getCurrentAccountUin(), true);
    }
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X80063EF", "0X80063EF", paramInt2, 0, "", "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    atdc localatdc = (atdc)paramQQAppInterface.getManager(746);
    paramQQAppInterface = localatdc.a(paramQQAppInterface.getCurrentAccountUin());
    if (paramQQAppInterface != null) {
      if (paramInt == 1)
      {
        if ((localatdc.Oh() == 1) && (paramQQAppInterface.pstn_c2c_try_status == 0)) {
          return true;
        }
        if (paramQQAppInterface.pstn_c2c_call_time > 0) {
          return true;
        }
      }
      else if (paramInt == 2)
      {
        if ((localatdc.Oi() == 1) && (paramQQAppInterface.pstn_multi_try_status == 0)) {
          return true;
        }
        if (paramQQAppInterface.pstn_multi_call_time > 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivity", 2, "contact manager is null.");
      }
      return false;
    }
    if (!paramQQAppInterface.Uy())
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivity", 2, "not has read contact permission.");
      }
      paramContext.startActivity(new Intent(paramContext, GuideBindPhoneActivity.class));
      return true;
    }
    if ((paramQQAppInterface.a() != null) && (paramQQAppInterface.a().isStopFindMatch))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivity", 2, "self bind info isStopFindMatch.");
      }
      paramQQAppInterface = new Intent(paramContext, PhoneLaunchActivity.class);
      paramQQAppInterface.putExtra("needAlert", true);
      paramQQAppInterface.putExtra("fromStopAndMatch", true);
      paramQQAppInterface.putExtra("returnAndFinish", true);
      paramQQAppInterface.putExtra("leftViewText", "返回");
      paramContext.startActivity(paramQQAppInterface);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivityForResult", 2, "contact manager is null.");
      }
      return false;
    }
    if ((paramBoolean) && (!paramQQAppInterface.Uy()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivityForResult", 2, "not has read contact permission.");
      }
      paramBaseActivity.startActivityForResult(new Intent(paramBaseActivity, GuideBindPhoneActivity.class), paramInt);
      return true;
    }
    if ((paramBoolean) && (paramQQAppInterface.a() != null) && (paramQQAppInterface.a().isStopFindMatch))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isEnterBindPhoneActivityForResult", 2, "self bind info isStopFindMatch.");
      }
      paramQQAppInterface = new Intent(paramBaseActivity, PhoneLaunchActivity.class);
      paramQQAppInterface.putExtra("needAlert", true);
      paramQQAppInterface.putExtra("fromStopAndMatch", true);
      paramQQAppInterface.putExtra("returnAndFinish", true);
      paramQQAppInterface.putExtra("leftViewText", "返回");
      paramBaseActivity.startActivityForResult(paramQQAppInterface, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject2 = (atdc)paramQQAppInterface.getManager(746);
    Object localObject1 = ((atdc)localObject2).a(paramQQAppInterface.getCurrentAccountUin());
    if (paramInt == 1) {
      if ((localObject1 != null) && (((PstnCardInfo)localObject1).pstn_ever_c2c_vip == 1))
      {
        localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131697919);
        localObject2 = ((atdc)localObject2).ro("key_pstn_tried_c2c_recharge_content");
        paramQQAppInterface = (QQAppInterface)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface = (QQAppInterface)localObject1;
        }
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          str = paramQQAppInterface.getApplication().getResources().getString(2131697925);
          localObject1 = ((atdc)localObject2).ro("key_pstn_untried_c2c_recharge_content");
          paramQQAppInterface = (QQAppInterface)localObject1;
        } while (!TextUtils.isEmpty((CharSequence)localObject1));
        return str;
        if ((localObject1 == null) || (((PstnCardInfo)localObject1).pstn_ever_multi_vip != 1)) {
          break;
        }
        str = paramQQAppInterface.getApplication().getResources().getString(2131697922);
        localObject1 = ((atdc)localObject2).ro("key_pstn_tried_multi_recharge_content");
        paramQQAppInterface = (QQAppInterface)localObject1;
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      return str;
      str = paramQQAppInterface.getApplication().getResources().getString(2131697928);
      localObject1 = ((atdc)localObject2).ro("key_pstn_untried_multi_recharge_content");
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    return str;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    atdc localatdc = (atdc)paramQQAppInterface.getManager(746);
    paramQQAppInterface = localatdc.a(paramQQAppInterface.getCurrentAccountUin());
    if (paramQQAppInterface != null) {
      if (paramInt == 1)
      {
        if ((localatdc.Oh() == 1) && (paramQQAppInterface.pstn_c2c_call_time > 0) && (paramQQAppInterface.pstn_c2c_call_time <= localatdc.Ok())) {
          return true;
        }
      }
      else if ((paramInt == 2) && (localatdc.Oi() == 1) && (paramQQAppInterface.pstn_multi_call_time > 0) && (paramQQAppInterface.pstn_multi_call_time <= localatdc.Ol())) {
        return true;
      }
    }
    return false;
  }
  
  public static String c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject2 = (atdc)paramQQAppInterface.getManager(746);
    Object localObject1 = ((atdc)localObject2).a(paramQQAppInterface.getCurrentAccountUin());
    if (paramInt == 1) {
      if ((localObject1 != null) && (((PstnCardInfo)localObject1).pstn_ever_c2c_vip == 1))
      {
        localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131697918);
        localObject2 = ((atdc)localObject2).ro("key_pstn_tried_c2c_recharge_confirm_text");
        paramQQAppInterface = (QQAppInterface)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface = (QQAppInterface)localObject1;
        }
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          str = paramQQAppInterface.getApplication().getResources().getString(2131697924);
          localObject1 = ((atdc)localObject2).ro("key_pstn_untried_c2c_recharge_confirm_text");
          paramQQAppInterface = (QQAppInterface)localObject1;
        } while (!TextUtils.isEmpty((CharSequence)localObject1));
        return str;
        if ((localObject1 == null) || (((PstnCardInfo)localObject1).pstn_ever_multi_vip != 1)) {
          break;
        }
        str = paramQQAppInterface.getApplication().getResources().getString(2131697921);
        localObject1 = ((atdc)localObject2).ro("key_pstn_tried_multi_recharge_confirm_text");
        paramQQAppInterface = (QQAppInterface)localObject1;
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      return str;
      str = paramQQAppInterface.getApplication().getResources().getString(2131697927);
      localObject1 = ((atdc)localObject2).ro("key_pstn_untried_multi_recharge_confirm_text");
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    return str;
  }
  
  public static String d(QQAppInterface paramQQAppInterface, int paramInt)
  {
    atdc localatdc = (atdc)paramQQAppInterface.getManager(746);
    if (paramInt == 1) {
      return String.format(paramQQAppInterface.getApplication().getResources().getString(2131697917), new Object[] { Integer.valueOf(localatdc.Ok()) });
    }
    if (paramInt == 2) {
      return String.format(paramQQAppInterface.getApplication().getResources().getString(2131697917), new Object[] { Integer.valueOf(localatdc.Ol()) });
    }
    return null;
  }
  
  public static int e(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    String str = paramString.replace("-", "").replace(" ", "");
    if (str.length() <= 6) {
      return 5;
    }
    if (str.length() > 16) {
      return 4;
    }
    paramString = str;
    if (paramBoolean) {
      if ((!str.startsWith("00")) && (!str.startsWith("+")))
      {
        paramString = str;
        if (!str.startsWith("86")) {}
      }
      else
      {
        if (!str.startsWith("0086")) {
          break label123;
        }
        paramString = str.substring(4);
      }
    }
    while ((paramString.startsWith("400")) || (paramString.startsWith("800")))
    {
      return 2;
      label123:
      if (str.startsWith("+86")) {
        paramString = str.substring(3);
      } else if (str.startsWith("86")) {
        paramString = str.substring(2);
      } else {
        return 1;
      }
    }
    if ((!paramString.startsWith("0")) && (paramString.length() <= 9)) {
      return 3;
    }
    if ((paramString.length() == 11) || (paramString.length() == 12)) {
      return 0;
    }
    return 6;
  }
  
  public static String h(ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.get(i);
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject1.put("a", localAVPhoneUserInfo.account);
        localJSONObject1.put("at", localAVPhoneUserInfo.accountType);
        localJSONObject2.put("m", localAVPhoneUserInfo.telInfo.mobile);
        localJSONObject2.put("n", localAVPhoneUserInfo.telInfo.nation);
        localJSONObject2.put("p", localAVPhoneUserInfo.telInfo.prefix);
        localJSONObject2.put("ns", localAVPhoneUserInfo.telInfo.nationState);
        localJSONObject1.put("ti", localJSONObject2);
        localJSONArray.put(localJSONObject1);
        i += 1;
      }
      paramArrayList = localJSONArray.toString();
      return paramArrayList;
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    return null;
  }
  
  public static String i(ArrayList<String> paramArrayList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        String str = (String)paramArrayList.get(i);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("NO", str);
        localJSONArray.put(localJSONObject);
        i += 1;
      }
      paramArrayList = localJSONArray.toString();
      return paramArrayList;
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList<AVPhoneUserInfo> m(List<cmd0xa02.TinyID2UserAccInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (cmd0xa02.TinyID2UserAccInfo)localIterator.next();
      AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.account = paramList.uint64_tinyid.get();
      localAVPhoneUserInfo.accountType = paramList.uint32_useracctype.get();
      paramList = paramList.str_useracc_identifier.get();
      if ((!TextUtils.isEmpty(paramList)) && (paramList.length() >= 5))
      {
        String str;
        if (paramList.contains("-"))
        {
          paramList = paramList.split("-");
          str = paramList[0];
        }
        for (paramList = paramList[1];; paramList = paramList.substring(4, paramList.length()))
        {
          localAVPhoneUserInfo.telInfo.nation = str;
          localAVPhoneUserInfo.telInfo.mobile = paramList;
          if (!TextUtils.isEmpty(localAVPhoneUserInfo.telInfo.nation)) {
            localAVPhoneUserInfo.telInfo.nationState = 1;
          }
          localArrayList.add(localAVPhoneUserInfo);
          break;
          str = paramList.substring(0, 4);
        }
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<AVPhoneUserInfo> p(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        ArrayList localArrayList = new ArrayList();
        paramString = localArrayList;
        if (i < localJSONArray.length())
        {
          paramString = localJSONArray.getJSONObject(i);
          JSONObject localJSONObject = paramString.optJSONObject("ti");
          AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
          localAVPhoneUserInfo.account = paramString.optLong("a", 0L);
          localAVPhoneUserInfo.accountType = paramString.optInt("at", -1);
          localAVPhoneUserInfo.telInfo.mobile = localJSONObject.optString("m", "");
          localAVPhoneUserInfo.telInfo.nation = localJSONObject.optString("n", "");
          localAVPhoneUserInfo.telInfo.prefix = localJSONObject.optString("p", "");
          localAVPhoneUserInfo.telInfo.nationState = localJSONObject.optInt("ns", 0);
          if (-1 == localAVPhoneUserInfo.accountType) {
            break label184;
          }
          localArrayList.add(localAVPhoneUserInfo);
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      return paramString;
      label184:
      i += 1;
    }
  }
  
  public static ArrayList<String> q(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        ArrayList localArrayList = new ArrayList();
        i = 0;
        paramString = localArrayList;
        if (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.getJSONObject(i);
          JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("ti");
          paramString = new AVPhoneUserInfo();
          paramString.accountType = ((JSONObject)localObject).optInt("at", -1);
          localObject = localJSONObject.optString("m", "");
          if (-1 == paramString.accountType) {
            break label110;
          }
          localArrayList.add(localObject);
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      return paramString;
      label110:
      i += 1;
    }
  }
  
  public static String v(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnUtils", 2, "hideCharacterInPhoneNumbe--> phoneNumber is null");
      }
      str = null;
    }
    do
    {
      do
      {
        return str;
        if (paramString.length() >= paramInt) {
          break;
        }
        str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("PstnUtils", 2, "hideCharacterInPhoneNumbe--> phoneNumber less ncount");
      return paramString;
      str = paramString;
    } while (paramString.length() < "***".length() + paramInt);
    String str = paramString.substring(paramString.length() - 2, paramString.length());
    paramString = paramString.substring(0, 3);
    return paramString + "***" + str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkm
 * JD-Core Version:    0.7.0.1
 */