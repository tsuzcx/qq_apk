import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class afnu
{
  public static String bEA = bEy + "fileList";
  public static String bEB = bEq + "[epId].zip";
  public static String bEC = bEq + "pngframe/";
  public static String bEd = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].gif";
  public static String bEe = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId]_apng.png";
  public static String bEf = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/xydata.json";
  public static String bEg = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].png";
  public static String bEh = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/ring.amr";
  public static String bEi = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/pngframe.zip";
  public static String bEj = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/126x126.png";
  public static String bEk = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]";
  public static String bEl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]_apng";
  public static String bEm = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]x[height].png";
  public static String bEn = "https://gxh.vip.qq.com/club/item/parcel/img/parcel/[mod]/[epId]/200x200.png";
  public static String bEo = "https://gxh.vip.qq.com/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/200x200.png";
  public static String bEp = acbn.bno + "[epId]" + File.separator;
  public static String bEq = acbn.bmM + "[epId]" + File.separator;
  public static String bEr = bEq + "[eId].amr";
  public static String bEs = bEq + "[eId]_thu.png";
  public static String bEt = bEq + "[eId]_aio.png";
  public static String bEu = bEq + "[epId].jtmp";
  public static String bEv = bEq + "[eId]";
  public static String bEw = bEq + "[eId]_apng";
  public static String bEx = bEq + "h5_json.zip";
  public static String bEy = bEq + "h5magic" + File.separator;
  public static String bEz = bEy + "index.html";
  
  public static ajdg a()
  {
    try
    {
      AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localAppInterface != null) {
        return (ajdg)localAppInterface.getManager(14);
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        localClassCastException.printStackTrace();
        Object localObject = null;
      }
    }
    return null;
  }
  
  public static List<afoo> a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    List localList1 = Collections.synchronizedList(new ArrayList());
    List localList2 = ((ajdg)paramQQAppInterface.getManager(14)).af(paramInt);
    Object localObject = aejs.a();
    if ((localObject != null) && (!((aejs.a)localObject).tF.isEmpty())) {
      localList1.addAll(a(paramQQAppInterface, ((aejs.a)localObject).tF, null, paramInt, paramBoolean));
    }
    for (;;)
    {
      if (localList2 != null) {}
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonUtils", 2, "prepare data cost time:" + (l2 - l1));
      }
      return localList1;
      localObject = new ArrayList();
      ((List)localObject).add("sysface");
      ((List)localObject).add("favorite");
      localList1.addAll(a(paramQQAppInterface, (List)localObject, null, paramInt, paramBoolean));
    }
  }
  
  public static List<afoo> a(QQAppInterface paramQQAppInterface, List<String> paramList1, List<String> paramList2, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList1 == null) {
      return localArrayList;
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      Object localObject = (String)paramList1.next();
      if ((paramList2 == null) || (paramList2.contains(localObject))) {
        if ("sysface".equals(localObject))
        {
          localArrayList.add(new afoo(7, 7, null));
        }
        else if ("favorite".equals(localObject))
        {
          if (paramInt == 0) {
            localArrayList.add(new afoo(4, 4, null));
          }
        }
        else if ("hotpic".equals(localObject))
        {
          if (paramInt == 0) {
            localArrayList.add(new afoo(12, 4, null));
          }
        }
        else if ("camera".equals(localObject))
        {
          localObject = (afgw)paramQQAppInterface.getManager(334);
          if ((localObject != null) && (((afgw)localObject).ajk())) {
            localArrayList.add(new afoo(11, 4, null));
          }
        }
        else if ("recommend".equals(localObject))
        {
          localObject = ((ajdg)paramQQAppInterface.getManager(14)).a(false, paramInt, paramBoolean);
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localArrayList.add(new afoo(8, 3, null));
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramEmoticonPackage != null))
    {
      paramQQAppInterface = (afke)paramQQAppInterface.getManager(43);
      if ((paramQQAppInterface.e(paramEmoticonPackage.epId) < 0.0F) && (isWifi()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonUtils", 2, "downloadNormalEmotion wifi auto download emotion , epid = " + paramEmoticonPackage.epId);
        }
        paramQQAppInterface.a(paramEmoticonPackage, false, false, paramInt);
      }
    }
  }
  
  public static void a(aofk.a[] paramArrayOfa, float paramFloat1, float paramFloat2, boolean paramBoolean1, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Activity paramActivity, boolean paramBoolean2)
  {
    if ((paramArrayOfa == null) || (paramQQAppInterface == null) || (paramSessionInfo == null) || (paramActivity == null)) {}
    Object localObject1;
    int j;
    do
    {
      return;
      localObject1 = new TreeSet();
      int i = 0;
      j = paramInt1;
      paramInt1 = i;
      while (paramInt1 < paramArrayOfa.length)
      {
        Object localObject2 = paramArrayOfa[paramInt1];
        boolean bool = paramBoolean1;
        int k = j;
        i = paramInt2;
        if ((localObject2 instanceof aofk.c))
        {
          localObject2 = (aofk.c)localObject2;
          float f1 = ((aofk.c)localObject2).Aa;
          float f2 = ((aofk.c)localObject2).Ab;
          float f3 = ((aofk.c)localObject2).Ac;
          float f4 = ((aofk.c)localObject2).Ad;
          int m = ((aofk.c)localObject2).dOt;
          int n = ((aofk.c)localObject2).dOu;
          ((TreeSet)localObject1).add(Integer.valueOf(m));
          bool = paramBoolean1;
          k = j;
          i = paramInt2;
          if (!paramBoolean2)
          {
            bool = paramBoolean1;
            k = j;
            i = paramInt2;
            if (paramFloat1 >= f1)
            {
              bool = paramBoolean1;
              k = j;
              i = paramInt2;
              if (paramFloat1 <= f3)
              {
                bool = paramBoolean1;
                k = j;
                i = paramInt2;
                if (paramFloat2 >= f2)
                {
                  bool = paramBoolean1;
                  k = j;
                  i = paramInt2;
                  if (paramFloat2 <= f4)
                  {
                    bool = paramBoolean1;
                    k = j;
                    i = paramInt2;
                    if (!paramBoolean1)
                    {
                      bool = true;
                      i = n;
                      k = m;
                    }
                  }
                }
              }
            }
          }
        }
        paramInt1 += 1;
        paramBoolean1 = bool;
        j = k;
        paramInt2 = i;
      }
    } while (!paramBoolean1);
    if (((TreeSet)localObject1).size() == 1)
    {
      ((ajdg)paramQQAppInterface.getManager(14)).b(String.valueOf(j), 0, new afnv(paramSessionInfo, paramQQAppInterface, j, paramActivity));
      return;
    }
    paramSessionInfo = ((TreeSet)localObject1).iterator();
    for (paramArrayOfa = ""; paramSessionInfo.hasNext(); paramArrayOfa = paramArrayOfa + localObject1 + ",") {
      localObject1 = (Integer)paramSessionInfo.next();
    }
    paramSessionInfo = paramArrayOfa;
    if (!paramArrayOfa.equals("")) {
      paramSessionInfo = paramArrayOfa.substring(0, paramArrayOfa.length() - 1);
    }
    EmojiHomeUiPlugin.openSmallEmojiListPage(paramActivity, paramQQAppInterface.getAccount(), 11, paramSessionInfo);
    anot.a(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007000", 0, 0, String.valueOf(j), String.valueOf(paramInt2), "", "");
  }
  
  public static boolean a(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage != null) && (paramEmoticonPackage.status == 2) && ((paramEmoticonPackage.updateFlag & 0x1) == 1);
  }
  
  public static boolean ajD()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int i = aqiw.getSystemNetwork(localBaseApplication);
    boolean bool = SettingCloneUtil.readValue(localBaseApplication, null, localBaseApplication.getString(2131697129), "qqsetting_auto_receive_magic_face_key", true);
    return ((i == 3) || (i == 4)) && (!bool);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        anot.a(paramQQAppInterface, "dc00898", "", "", "0X800AEE5", "0X800AEE5", paramInt, 0, "", "", paramString1, paramString2);
        return;
      }
    }
  }
  
  public static void cN(String paramString, int paramInt)
  {
    report(paramString, paramString, paramInt);
  }
  
  public static List<afoo> g(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList1 = new ArrayList();
    aejs.a locala = aejs.a();
    if ((locala != null) && (!locala.tF.isEmpty()))
    {
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add("sysface");
      localArrayList2.add("favorite");
      localArrayList2.add("hotpic");
      localArrayList2.add("camera");
      localArrayList1.addAll(a(paramQQAppInterface, locala.tF, localArrayList2, 0, false));
      return localArrayList1;
    }
    localArrayList1.add(new afoo(7, 7, null));
    localArrayList1.add(new afoo(4, 4, null));
    localArrayList1.add(new afoo(12, 4, null));
    localArrayList1.add(new afoo(11, 4, null));
    return localArrayList1;
  }
  
  public static List<afoo> h(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new ArrayList();
    paramQQAppInterface.add(new afoo(7, 7, null));
    return paramQQAppInterface;
  }
  
  public static boolean isWifi()
  {
    return aqiw.getSystemNetwork(BaseApplication.getContext()) == 1;
  }
  
  public static boolean isWifiOrG3OrG4()
  {
    int i = aqiw.getSystemNetwork(BaseApplication.getContext());
    return (i == 1) || (i == 3) || (i == 4);
  }
  
  public static boolean ju(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 99999);
  }
  
  public static boolean jx(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean jy(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static void report(String paramString1, String paramString2, int paramInt)
  {
    anot.a(null, "dc00898", "", "", paramString1, paramString2, paramInt, 0, "", "0", "0", "");
  }
  
  public static byte[] w(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnu
 * JD-Core Version:    0.7.0.1
 */