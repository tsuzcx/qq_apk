import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.qcall.PstnSessionInfo;

public class aljw
{
  public static boolean O(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (ajdo)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.c(paramString);; paramQQAppInterface = null) {
      return (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.uin));
    }
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    QLog.d("OpenSDKUtils", 2, "getOpenSDKUserFaceBitmap phoneNumber = " + paramString);
    Object localObject2 = localObject1;
    if (paramQQAppInterface != null)
    {
      localObject2 = localObject1;
      if (paramString != null)
      {
        if (paramString.startsWith("+")) {
          break label55;
        }
        localObject2 = localObject1;
      }
    }
    label55:
    do
    {
      return localObject2;
      localObject1 = localObject3;
      if (O(paramQQAppInterface, paramString)) {
        localObject1 = aqdj.b(paramQQAppInterface, paramString, (byte)3);
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return aqhu.at();
  }
  
  public static PhoneContact a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ajdo localajdo = (ajdo)paramQQAppInterface.getManager(11);
    if (localajdo != null)
    {
      PhoneContact localPhoneContact = localajdo.c(paramString);
      akwi localakwi = akwj.a(paramString);
      paramQQAppInterface = localPhoneContact;
      if (localPhoneContact == null) {
        paramQQAppInterface = localajdo.b(localakwi.bUy);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramString = localajdo.b("+" + localakwi.countryCode + localakwi.bUy);
      }
      paramQQAppInterface = paramString;
      if (paramString == null) {
        paramQQAppInterface = localajdo.b(localakwi.countryCode + localakwi.bUy);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramString = localajdo.b("00" + localakwi.countryCode + localakwi.bUy);
      }
      if (paramString == null) {
        return localajdo.b(localakwi.countryCode + "-" + localakwi.bUy);
      }
      return paramString;
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt1, PstnSessionInfo paramPstnSessionInfo, int paramInt2)
  {
    QLog.d("OpenSDKUtils", 2, "enterActionSheet phoneNumber = " + paramString + "pstnStatus = " + paramInt1);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int[] arrayOfInt = new int[2];
    int[] tmp49_47 = arrayOfInt;
    tmp49_47[0] = 0;
    int[] tmp53_49 = tmp49_47;
    tmp53_49[1] = 1;
    tmp53_49;
    ausj localausj = ausj.b(paramContext);
    localausj.setMainTitle(2131689654);
    switch (paramInt1)
    {
    case 3: 
    case 4: 
    default: 
      arrayOfInt[0] = 1;
      localausj.addButton(2131691235);
    }
    for (;;)
    {
      localausj.addCancelButton(2131721058);
      localausj.a(new aljz());
      localausj.a(new alka(localausj, arrayOfInt, paramInt1, paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt2, paramString));
      localausj.show();
      return;
      localausj.addButtonWithIcon(paramContext.getResources().getString(2131721251), paramContext.getResources().getDrawable(2130843157), 0);
      continue;
      localausj.addButtonWithIcon(paramContext.getResources().getString(2131721251), paramContext.getResources().getDrawable(2130843156), 0);
      continue;
      localausj.addButtonWithIcon(paramContext.getResources().getString(2131721251), paramContext.getResources().getDrawable(2130843155), 0);
      localausj.addButton(2131691235);
    }
  }
  
  public static Bitmap b(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    QLog.d("OpenSDKUtils", 2, "getOpenSDKUserFaceBitmap phoneNumber = " + paramString);
    Object localObject2 = localObject1;
    if (paramQQAppInterface != null)
    {
      localObject2 = localObject1;
      if (paramString != null)
      {
        if (paramString.startsWith("+")) {
          break label55;
        }
        localObject2 = localObject1;
      }
    }
    label55:
    do
    {
      return localObject2;
      localObject1 = localObject3;
      if (O(paramQQAppInterface, paramString)) {
        localObject1 = paramQQAppInterface.getFaceBitmap(11, paramString, (byte)3, true, 0);
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return aqhu.G();
  }
  
  public static void f(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    QLog.d("OpenSDKUtils", 2, "enterActionSheet phoneNumber = " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 1;
    ausj localausj = ausj.b(paramContext);
    localausj.setMainTitle(2131689654);
    arrayOfInt[0] = 1;
    localausj.addButton(2131691235);
    localausj.addCancelButton(2131721058);
    localausj.a(new aljx());
    localausj.a(new aljy(localausj, arrayOfInt, paramString, paramContext, paramQQAppInterface));
    localausj.show();
  }
  
  public static String m(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName phoneNumber = " + paramString);
    if ((paramQQAppInterface == null) || (paramString == null) || (!paramString.startsWith("+")))
    {
      paramQQAppInterface = "";
      return paramQQAppInterface;
    }
    Object localObject2 = a(paramQQAppInterface, paramString);
    Object localObject1;
    if (localObject2 != null) {
      localObject1 = ((PhoneContact)localObject2).name;
    }
    for (String str = ((PhoneContact)localObject2).uin;; str = null)
    {
      QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName contactName = " + (String)localObject1 + "uin = " + str);
      localObject2 = localObject4;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = localObject4;
        if (!str.equals("0"))
        {
          localObject2 = ((acff)paramQQAppInterface.getManager(51)).e(str);
          paramQQAppInterface = localObject3;
          if (localObject2 != null)
          {
            if ((((Friends)localObject2).remark == null) || (((Friends)localObject2).remark.length() <= 0)) {
              break label225;
            }
            paramQQAppInterface = ((Friends)localObject2).remark;
          }
          label177:
          QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName FriendDisplayName = " + paramQQAppInterface);
          localObject2 = paramQQAppInterface;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      for (;;)
      {
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        return mN(paramString);
        label225:
        paramQQAppInterface = localObject3;
        if (((Friends)localObject2).name == null) {
          break label177;
        }
        paramQQAppInterface = localObject3;
        if (((Friends)localObject2).name.length() <= 0) {
          break label177;
        }
        paramQQAppInterface = ((Friends)localObject2).name;
        break label177;
        localObject1 = localObject2;
      }
      localObject1 = null;
    }
  }
  
  public static String mN(String paramString)
  {
    akwi localakwi = akwj.a(paramString);
    if (localakwi.countryCode.equals("86")) {
      paramString = localakwi.bUy;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljw
 * JD-Core Version:    0.7.0.1
 */