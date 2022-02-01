import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class akxj
{
  private static HashSet<Integer> bp = new HashSet();
  private static HashSet<Integer> bq = new HashSet();
  private static HashSet<Integer> br = new HashSet();
  
  static
  {
    bp.add(Integer.valueOf(1008));
    bp.add(Integer.valueOf(1007));
    bp.add(Integer.valueOf(1009));
    bp.add(Integer.valueOf(1006));
    bp.add(Integer.valueOf(1027));
    bp.add(Integer.valueOf(1031));
    bp.add(Integer.valueOf(1034));
    bp.add(Integer.valueOf(1038));
    bp.add(Integer.valueOf(1036));
    bp.add(Integer.valueOf(1037));
    bp.add(Integer.valueOf(1039));
    bp.add(Integer.valueOf(1040));
    bp.add(Integer.valueOf(1041));
    bp.add(Integer.valueOf(1043));
    bp.add(Integer.valueOf(1048));
    bp.add(Integer.valueOf(1));
    bp.add(Integer.valueOf(2));
    bp.add(Integer.valueOf(3));
    bp.add(Integer.valueOf(5));
    bp.add(Integer.valueOf(6));
    bp.add(Integer.valueOf(7));
    bp.add(Integer.valueOf(1050));
    bp.add(Integer.valueOf(1051));
    bp.add(Integer.valueOf(1052));
    bp.add(Integer.valueOf(1053));
    bq.add(Integer.valueOf(1045));
    br.add(Integer.valueOf(1042));
    br.add(Integer.valueOf(1047));
    br.add(Integer.valueOf(1044));
    br.add(Integer.valueOf(1049));
  }
  
  static akwv a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    akws localakws = null;
    if (bp.contains(Integer.valueOf(paramInt))) {
      localakws = new akws(paramQQAppInterface);
    }
    do
    {
      return localakws;
      if (bq.contains(Integer.valueOf(paramInt))) {
        return new akwu(paramQQAppInterface);
      }
    } while (!br.contains(Integer.valueOf(paramInt)));
    return new akwt(paramQQAppInterface, paramInt);
  }
  
  public static akwv a(akxq paramakxq, QQAppInterface paramQQAppInterface)
  {
    if (paramakxq == null)
    {
      akxe.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    akwv localakwv = a(paramakxq.busiType, paramQQAppInterface);
    if (localakwv == null)
    {
      akxe.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramakxq.busiType);
      return null;
    }
    localakwv.mApp = paramQQAppInterface;
    localakwv.e = paramakxq;
    localakwv.bUB = paramakxq.localUUID;
    localakwv.logTag = paramakxq.logTag;
    localakwv.a(paramakxq.b);
    akxe.a("PicBusiManager", "launch", "cmd:" + paramakxq.dpE + ",busiType:" + paramakxq.busiType + "localUUID:" + paramakxq.localUUID);
    switch (paramakxq.dpE)
    {
    }
    for (;;)
    {
      return localakwv;
      paramQQAppInterface = b(paramQQAppInterface);
      Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
      localIntent.putExtra("ServiceAction", 1);
      localIntent.putExtra("CompressInfo", paramakxq.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      localIntent.putExtra("CompressConfig", paramQQAppInterface);
      if (paramakxq.jdField_a_of_type_Xuj != null) {
        localIntent.putExtra("CompressCallback", new BinderWarpper(paramakxq.jdField_a_of_type_Xuj.asBinder()));
      }
      try
      {
        BaseApplication.getContext().startService(localIntent);
      }
      catch (Exception paramakxq)
      {
        akxe.b("PicBusiManager", "launch", "error,req == null" + paramakxq.getStackTrace());
      }
      continue;
      localakwv.d(paramakxq);
      continue;
      localakwv.a(paramakxq);
      continue;
      localakwv.c(paramakxq);
      continue;
      localakwv.a(paramakxq);
      continue;
      localakwv.eE(paramakxq.yu);
    }
  }
  
  static akxd a(int paramInt)
  {
    akws localakws = null;
    if (bp.contains(Integer.valueOf(paramInt))) {
      localakws = new akws();
    }
    do
    {
      return localakws;
      if (bq.contains(Integer.valueOf(paramInt))) {
        return new akwu();
      }
    } while (!br.contains(Integer.valueOf(paramInt)));
    return new akwt(paramInt);
  }
  
  public static akxm a(int paramInt, Intent paramIntent)
  {
    akxd localakxd = a(paramInt);
    if (localakxd == null) {
      return null;
    }
    return localakxd.a(paramIntent);
  }
  
  public static akxm a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    akxd localakxd = a(paramInt1);
    if (localakxd == null) {
      return null;
    }
    return localakxd.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static akxq a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static akxq a(int paramInt1, int paramInt2, int paramInt3)
  {
    akxq localakxq = new akxq();
    localakxq.dpE = paramInt1;
    localakxq.dpF = paramInt2;
    localakxq.busiType = paramInt3;
    return localakxq;
  }
  
  public static akxy a(int paramInt, Intent paramIntent)
  {
    akxd localakxd = a(paramInt);
    if (localakxd == null) {
      return null;
    }
    return localakxd.a(paramIntent);
  }
  
  public static ArrayList<akxm> a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    akxd localakxd = a(paramInt1);
    if (localakxd == null) {
      return null;
    }
    return localakxd.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static CompressInfo b(int paramInt, Intent paramIntent)
  {
    akxd localakxd = a(paramInt);
    if (localakxd == null) {
      return null;
    }
    return localakxd.a(paramIntent);
  }
  
  public static int[] b(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    akxe.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.e());
        paramQQAppInterface = paramQQAppInterface.getCurrentUin();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            akyl.dqc = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            akyl.dqd = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            akyl.dqe = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            akyl.dqf = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            akyl.dqg = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            akyl.dqh = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            akyl.dpY = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            akyl.dpZ = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            akyl.dqa = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = akyl.dqc;
      paramQQAppInterface[1] = akyl.dqd;
      paramQQAppInterface[2] = akyl.dqe;
      paramQQAppInterface[3] = akyl.dqf;
      paramQQAppInterface[4] = akyl.dqg;
      paramQQAppInterface[5] = akyl.dqh;
      paramQQAppInterface[6] = akyl.dpY;
      paramQQAppInterface[7] = akyl.dpZ;
      paramQQAppInterface[8] = akyl.dqa;
      akxe.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      akxe.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxj
 * JD-Core Version:    0.7.0.1
 */