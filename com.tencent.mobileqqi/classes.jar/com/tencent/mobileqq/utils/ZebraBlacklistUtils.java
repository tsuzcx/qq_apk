package com.tencent.mobileqq.utils;

import AndroidClientInterface.stVerifyBlackListReq;
import AndroidClientInterface.stVerifyBlackListRsp;
import CommonClientInterface.stRspHeader;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import hir;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.ServerConfigManager.ConfigType;
import org.json.JSONArray;

public class ZebraBlacklistUtils
{
  public static final int a = 1004;
  private static volatile ZebraBlacklistUtils jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils;
  public static final String a = "1.1.0";
  public static final int b = 10;
  public static final String b = "Unknown";
  private static final int c = 1024;
  public static String c = "http://plus.xiangji.qq.com";
  public static String d = "";
  private static final String e = "Blacklist";
  private static final String f = "/Android/VerifyBlackList";
  private static final String g = "::";
  private static final String h = "zebra_blacklist";
  private static final String i = "zebra_blacklist";
  private static final String j = "blacklist";
  private static final String k = "update_time";
  private static final String l = Build.MODEL;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private ZebraBlacklistUtils.JceRequestCallback jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback = new hir(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private ZebraBlacklistUtils(Context paramContext)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        c();
        d = DeviceInfoUtil.a();
        if (Build.VERSION.SDK_INT <= 10) {
          break label138;
        }
        m = 4;
        this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("zebra_blacklist", m);
        if (this.jdField_a_of_type_AndroidContentSharedPreferences.contains(a()))
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
            this.jdField_a_of_type_JavaUtilHashMap = a(this.jdField_a_of_type_AndroidContentSharedPreferences.getString(a(), null));
          }
        }
        else
        {
          b();
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      return;
      label138:
      int m = 0;
    }
  }
  
  public static ZebraBlacklistUtils a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils != null) {
      return jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils != null)
      {
        paramContext = jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils;
        return paramContext;
      }
    }
    finally {}
    paramContext = new ZebraBlacklistUtils(paramContext);
    jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils = paramContext;
    return paramContext;
  }
  
  private String a()
  {
    try
    {
      String str = String.valueOf(10) + "_" + "blacklist";
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "blacklist";
  }
  
  /* Error */
  private String a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 153	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_2
    //   5: invokevirtual 159	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: sipush 1024
    //   12: newarray byte
    //   14: astore_2
    //   15: new 161	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 162	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore 5
    //   24: aload_1
    //   25: aload_2
    //   26: invokevirtual 168	java/io/InputStream:read	([B)I
    //   29: istore 4
    //   31: iload 4
    //   33: iconst_m1
    //   34: if_icmpne +34 -> 68
    //   37: aload 5
    //   39: aload_3
    //   40: invokevirtual 171	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_2
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 174	java/io/InputStream:close	()V
    //   52: aload_2
    //   53: astore_1
    //   54: aload 5
    //   56: ifnull +10 -> 66
    //   59: aload 5
    //   61: invokevirtual 175	java/io/ByteArrayOutputStream:close	()V
    //   64: aload_2
    //   65: astore_1
    //   66: aload_1
    //   67: areturn
    //   68: aload 5
    //   70: aload_2
    //   71: iconst_0
    //   72: iload 4
    //   74: invokevirtual 179	java/io/ByteArrayOutputStream:write	([BII)V
    //   77: goto -53 -> 24
    //   80: astore_2
    //   81: aload 5
    //   83: astore_2
    //   84: ldc 50
    //   86: astore_3
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 174	java/io/InputStream:close	()V
    //   95: aload_3
    //   96: astore_1
    //   97: aload_2
    //   98: ifnull -32 -> 66
    //   101: aload_2
    //   102: invokevirtual 175	java/io/ByteArrayOutputStream:close	()V
    //   105: ldc 50
    //   107: areturn
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   113: ldc 50
    //   115: areturn
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   121: aload_2
    //   122: areturn
    //   123: astore_2
    //   124: aconst_null
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_3
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 174	java/io/InputStream:close	()V
    //   136: aload_3
    //   137: ifnull +7 -> 144
    //   140: aload_3
    //   141: invokevirtual 175	java/io/ByteArrayOutputStream:close	()V
    //   144: aload_2
    //   145: athrow
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_3
    //   157: goto -29 -> 128
    //   160: astore_2
    //   161: aload 5
    //   163: astore_3
    //   164: goto -36 -> 128
    //   167: astore_1
    //   168: aconst_null
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_1
    //   172: goto -88 -> 84
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_2
    //   178: goto -94 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	ZebraBlacklistUtils
    //   0	181	1	paramContext	Context
    //   0	181	2	paramString1	String
    //   0	181	3	paramString2	String
    //   29	44	4	m	int
    //   22	140	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   24	31	80	java/lang/Exception
    //   37	44	80	java/lang/Exception
    //   68	77	80	java/lang/Exception
    //   91	95	108	java/io/IOException
    //   101	105	108	java/io/IOException
    //   48	52	116	java/io/IOException
    //   59	64	116	java/io/IOException
    //   0	9	123	finally
    //   132	136	146	java/io/IOException
    //   140	144	146	java/io/IOException
    //   9	24	154	finally
    //   24	31	160	finally
    //   37	44	160	finally
    //   68	77	160	finally
    //   0	9	167	java/lang/Exception
    //   9	24	175	java/lang/Exception
  }
  
  private String a(HashMap paramHashMap)
  {
    if (paramHashMap != null)
    {
      try
      {
        if (paramHashMap.size() == 0) {
          break label104;
        }
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = paramHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONArray.put(str + "::" + paramHashMap.get(str));
        }
        paramHashMap = localJSONArray.toString();
      }
      catch (Exception paramHashMap)
      {
        paramHashMap.printStackTrace();
        return "{}";
      }
      return paramHashMap;
    }
    label104:
    return "{}";
  }
  
  private HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      int m;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return localHashMap;
        }
        paramString = new JSONArray(paramString);
        if (paramString.length() != 0)
        {
          m = 0;
          int n = paramString.length();
          if (m < n) {
            try
            {
              Object localObject = paramString.getString(m);
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label139;
              }
              localObject = ((String)localObject).split("::");
              if ((localObject == null) || (localObject.length != 2) || (TextUtils.isEmpty(localObject[0]))) {
                break label139;
              }
              n = Integer.parseInt(localObject[1]);
              localHashMap.put(localObject[0], Integer.valueOf(n));
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
        return localHashMap;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      label139:
      m += 1;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          if ((!a(paramInt)) && (!b(paramInt)) && (!c(paramInt)))
          {
            this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
            paramString = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
            paramString.putString(a(), a(this.jdField_a_of_type_JavaUtilHashMap));
            if (!this.jdField_a_of_type_AndroidContentSharedPreferences.contains("update_time")) {
              paramString.putLong("update_time", System.currentTimeMillis());
            }
            paramString.commit();
            return;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
          continue;
        }
        if (a(paramInt)) {
          break label153;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if ((b(paramInt)) || (c(paramInt))) {
        label153:
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        if (paramArrayOfByte.length == 0) {
          return;
        }
        Object localObject = new UniPacket();
        ((UniPacket)localObject).setEncodeName("UTF-8");
        ((UniPacket)localObject).decode(paramArrayOfByte);
        paramArrayOfByte = (stRspHeader)((UniPacket)localObject).get("stRspHeader");
        localObject = (stVerifyBlackListRsp)((UniPacket)localObject).get("stVerifyBlackListRsp");
        if ((paramArrayOfByte != null) && (paramArrayOfByte.iRet == 0) && (localObject != null))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Blacklist", 4, "stRspHeader BlackList verifyBlackListRsp iValue = " + ((stVerifyBlackListRsp)localObject).iValue);
          }
          a(l, ((stVerifyBlackListRsp)localObject).iValue);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  private void b()
  {
    for (;;)
    {
      int m;
      try
      {
        Object localObject1 = a(this.jdField_a_of_type_AndroidContentContext, "zebra_blacklist", "utf-8");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localObject1 = ((String)localObject1).replace("\r", "").split("\n");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label213;
        }
        int n = localObject1.length;
        m = 0;
        if (m < n)
        {
          Object localObject2 = localObject1[m];
          try
          {
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label214;
            }
            localObject2 = ((String)localObject2).split("::");
            if ((localObject2 == null) || (localObject2.length < 3)) {
              break label214;
            }
            int i1 = Integer.parseInt(localObject2[0]);
            int i2 = Integer.parseInt(localObject2[2]);
            if ((i1 != 1004) || (TextUtils.isEmpty(localObject2[1]))) {
              break label214;
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject2[1], Integer.valueOf(i2));
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
      SharedPreferences.Editor localEditor;
      localEditor.putString(a(), a(this.jdField_a_of_type_JavaUtilHashMap));
      localEditor.commit();
      label213:
      return;
      label214:
      m += 1;
    }
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  private void c()
  {
    try
    {
      String str = ((QQAppInterface)BaseApplicationImpl.a().a()).a(ServerConfigManager.ConfigType.common, "watemark_initurl");
      if (!TextUtils.isEmpty(str))
      {
        if (str.startsWith("http://"))
        {
          c = str;
          return;
        }
        c = "http://" + str;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean c(int paramInt)
  {
    return (paramInt & 0x4) == 4;
  }
  
  public void a()
  {
    try
    {
      Object localObject = ZebraBlacklistUtils.NetworkTool.a("Android", "VerifyBlackList");
      stVerifyBlackListReq localstVerifyBlackListReq = new stVerifyBlackListReq();
      localstVerifyBlackListReq.strModelName = l;
      UniPacket localUniPacket = new UniPacket();
      localUniPacket.setServantName("Android");
      localUniPacket.setFuncName("VerifyBlackList");
      localUniPacket.setEncodeName("UTF-8");
      localUniPacket.put("stReqHeader", localObject);
      localUniPacket.put("stVerifyBlackListReq", localstVerifyBlackListReq);
      localObject = localUniPacket.encode();
      new Thread(new ZebraBlacklistUtils.NetworkTool(c, "/Android/VerifyBlackList", (byte[])localObject, this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback)).start();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    catch (AssertionError localAssertionError)
    {
      localAssertionError.printStackTrace();
    }
  }
  
  public boolean a()
  {
    try
    {
      if (!this.jdField_a_of_type_AndroidContentSharedPreferences.contains("update_time"))
      {
        a();
        return true;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(l))
      {
        boolean bool = c(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(l)).intValue());
        return bool;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ZebraBlacklistUtils
 * JD-Core Version:    0.7.0.1
 */