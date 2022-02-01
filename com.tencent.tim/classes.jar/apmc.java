import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class apmc
{
  public static String A(byte[] paramArrayOfByte)
  {
    localObject = null;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    try
    {
      troop_honor.GroupUserCardHonor localGroupUserCardHonor = new troop_honor.GroupUserCardHonor();
      localGroupUserCardHonor.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localObject;
      if (localGroupUserCardHonor.id.has()) {
        paramArrayOfByte = localGroupUserCardHonor.id.get();
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        QLog.d("TroopHonor.utils", 1, "parseRspToHonorList", paramArrayOfByte);
        paramArrayOfByte = localObject;
      }
    }
    return S(paramArrayOfByte);
  }
  
  public static boolean C(long paramLong1, long paramLong2)
  {
    if (paramLong1 != 1L) {}
    while ((paramLong2 != 1003L) && (paramLong2 != 1004L) && (paramLong2 != 1005L) && (paramLong2 != 1006L) && (paramLong2 != 1021L)) {
      return false;
    }
    return true;
  }
  
  public static String S(List<Integer> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        localStringBuilder.append(paramList.get(i));
        if (i != paramList.size() - 1) {
          localStringBuilder.append("|");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String T(List<apmd> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(((apmd)paramList.get(i)).id);
      if (i != paramList.size() - 1) {
        localStringBuilder.append("|");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean T(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString) != null;
  }
  
  public static String U(List<apmd> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localStringBuilder.append(((apmd)paramList.next()).name);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static List<Integer> aY(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    ArrayList localArrayList;
    String[] arrayOfString;
    do
    {
      return paramString;
      localArrayList = new ArrayList();
      arrayOfString = paramString.split("\\|");
      paramString = localArrayList;
    } while (arrayOfString.length <= 0);
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localArrayList;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i];
      try
      {
        localArrayList.add(Integer.valueOf(paramString));
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        for (;;)
        {
          QLog.d("TroopHonor.utils", 1, "convertStrToHonorList", paramString);
        }
      }
    }
  }
  
  public static ArrayList<SingleLineTextView.f> c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((apmb)paramQQAppInterface.getManager(346)).aX(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    Collections.sort(paramString);
    paramQQAppInterface = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      apmd localapmd = (apmd)paramString.next();
      SingleLineTextView.f localf = new SingleLineTextView.f();
      localf.icon_static_url = localapmd.iconUrl;
      paramQQAppInterface.add(localf);
    }
    return paramQQAppInterface;
  }
  
  public static String i(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    return U(((apmb)paramQQAppInterface.getManager(346)).i(paramString1, paramString2));
  }
  
  public static boolean i(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (jof.a(paramMessageRecord)) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForTroopConfess)) {
      return false;
    }
    if ("1000000".equals(paramMessageRecord.senderuin)) {
      return false;
    }
    return !((aptw)paramQQAppInterface.getManager(203)).gM(paramMessageRecord.senderuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmc
 * JD-Core Version:    0.7.0.1
 */