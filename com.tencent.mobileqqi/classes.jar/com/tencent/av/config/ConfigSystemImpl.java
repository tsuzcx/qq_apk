package com.tencent.av.config;

import android.content.Context;
import android.os.Build.VERSION;
import bhg;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.qphone.base.util.QLog;

public class ConfigSystemImpl
{
  public static final byte a = 0;
  static ConfigProtocol.S2CConfigInfoProtocol jdField_a_of_type_ComTencentAvConfigConfigProtocol$S2CConfigInfoProtocol = null;
  static boolean jdField_a_of_type_Boolean = false;
  public static final byte b = 1;
  public static final byte c = 2;
  public static final byte d = 3;
  static byte e = 0;
  static byte f = 0;
  static byte g = 0;
  static byte h = 0;
  static byte i = 0;
  static byte j = 0;
  static byte k = 0;
  static byte l = 0;
  static byte m = 0;
  static byte n = 0;
  static byte o = 0;
  static byte p = 0;
  static byte q = 1;
  Context jdField_a_of_type_AndroidContentContext = null;
  ConfigProtocol jdField_a_of_type_ComTencentAvConfigConfigProtocol = null;
  VcSystemInfo jdField_a_of_type_ComTencentAvCoreVcSystemInfo = null;
  String jdField_a_of_type_JavaLangString = null;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  
  public ConfigSystemImpl(String paramString, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo = new VcSystemInfo();
    this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.a();
    this.jdField_a_of_type_ComTencentAvConfigConfigProtocol = new ConfigProtocol();
    paramString = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    paramString.getClass();
    jdField_a_of_type_ComTencentAvConfigConfigProtocol$S2CConfigInfoProtocol = new ConfigProtocol.S2CConfigInfoProtocol(paramString);
  }
  
  public static byte a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte)
  {
    if (!jdField_a_of_type_Boolean)
    {
      a(paramContext);
      jdField_a_of_type_Boolean = true;
    }
    byte b1 = 0;
    if (paramBoolean2) {
      if (paramBoolean1) {
        b1 = e;
      }
    }
    do
    {
      do
      {
        return b1;
        return f;
        if (!paramBoolean1) {
          break;
        }
        if (paramByte == 0) {
          return g;
        }
        if (paramByte == 1) {
          return h;
        }
        if (paramByte == 2) {
          return i;
        }
      } while (paramByte != 3);
      return j;
      if (paramByte == 0) {
        return k;
      }
      if (paramByte == 1) {
        return l;
      }
      if (paramByte == 2) {
        return m;
      }
    } while (paramByte != 3);
    return n;
  }
  
  static void a(Context paramContext)
  {
    paramContext = Common.a(paramContext, "VideoConfigInfo");
    if (paramContext == null) {}
    for (;;)
    {
      return;
      Object localObject = new ConfigProtocol();
      localObject.getClass();
      localObject = new ConfigProtocol.S2CConfigInfoProtocol((ConfigProtocol)localObject);
      if (((ConfigProtocol.S2CConfigInfoProtocol)localObject).a(new ByteBuffer(paramContext)))
      {
        int i2 = ((ConfigProtocol.S2CConfigInfoProtocol)localObject).b();
        int i1 = 0;
        while (i1 < i2)
        {
          paramContext = ((ConfigProtocol.S2CConfigInfoProtocol)localObject).a(i1);
          if ((paramContext != null) && (paramContext.b() == 8))
          {
            paramContext = (bhg)paramContext;
            e = paramContext.a();
            f = paramContext.b();
            g = paramContext.c();
            h = paramContext.e();
            i = paramContext.g();
            j = paramContext.i();
            k = paramContext.d();
            l = paramContext.f();
            m = paramContext.h();
            n = paramContext.j();
            o = paramContext.k();
            p = paramContext.l();
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    b(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("shanezhai", 2, "isDAudioEnable:" + q);
    }
    return q == 1;
  }
  
  public static boolean a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      paramString = new ConfigSystemImpl(paramString, paramContext);
      paramString.a(paramArrayOfByte);
      paramString.a();
      return paramString.a();
    }
    return false;
  }
  
  public static byte[] a(String paramString, Context paramContext)
  {
    return new ConfigSystemImpl(paramString, paramContext).a();
  }
  
  static void b(Context paramContext)
  {
    paramContext = Common.a(paramContext, "VideoConfigInfo");
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("shanezhai", 2, "not have config file");
      }
    }
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = new ConfigProtocol();
        localObject.getClass();
        localObject = new ConfigProtocol.S2CConfigInfoProtocol((ConfigProtocol)localObject);
        if (((ConfigProtocol.S2CConfigInfoProtocol)localObject).a(new ByteBuffer(paramContext))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("shanezhai", 2, "unPack TLV video config err");
      return;
      int i2 = ((ConfigProtocol.S2CConfigInfoProtocol)localObject).b();
      int i1 = 0;
      while (i1 < i2)
      {
        paramContext = ((ConfigProtocol.S2CConfigInfoProtocol)localObject).a(i1);
        if ((paramContext != null) && (paramContext.b() == 11))
        {
          q = ((ConfigProtocol.AVSwitchTypeTLV)paramContext).a();
          return;
        }
        i1 += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("shanezhai", 2, "file has no DAudio Config item");
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      Common.a(this.jdField_a_of_type_AndroidContentContext, "VideoConfigInfo", this.jdField_a_of_type_ArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("shanezhai", 2, "WriteConfigInfoToFile commit!");
      }
      q = 1;
    }
  }
  
  void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    for (;;)
    {
      return false;
      Object localObject = new ByteBuffer(this.jdField_a_of_type_ArrayOfByte);
      if (jdField_a_of_type_ComTencentAvConfigConfigProtocol$S2CConfigInfoProtocol.a((ByteBuffer)localObject))
      {
        int i2 = jdField_a_of_type_ComTencentAvConfigConfigProtocol$S2CConfigInfoProtocol.b();
        if (i2 > 0)
        {
          int i1 = 0;
          while (i1 < i2)
          {
            localObject = jdField_a_of_type_ComTencentAvConfigConfigProtocol$S2CConfigInfoProtocol.a(i1);
            if ((localObject != null) && ((((ConfigProtocol.TLVBase)localObject).b() == 2) || (((ConfigProtocol.TLVBase)localObject).b() == 3))) {
              return true;
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  public byte[] a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    localObject1.getClass();
    localObject1 = new ConfigProtocol.C2SReqConfigProtocol((ConfigProtocol)localObject1);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a((short)1);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientDeviceTypeTLV((ConfigProtocol)localObject2);
    ((ConfigProtocol.ClientDeviceTypeTLV)localObject2).a((short)101);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientOSTypeTLV((ConfigProtocol)localObject2);
    ((ConfigProtocol.ClientOSTypeTLV)localObject2).a((short)this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.c());
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientAppIDTLV((ConfigProtocol)localObject2, (short)0);
    ((ConfigProtocol.ClientAppIDTLV)localObject2).a(this.jdField_a_of_type_JavaLangString);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.EngineVersionTLV((ConfigProtocol)localObject2, (short)0);
    ((ConfigProtocol.EngineVersionTLV)localObject2).a(Common.a(this.jdField_a_of_type_AndroidContentContext));
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientDevNameTLV((ConfigProtocol)localObject2);
    ((ConfigProtocol.ClientDevNameTLV)localObject2).a(VcSystemInfo.b());
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientHardWareInfoTLV((ConfigProtocol)localObject2);
    ((ConfigProtocol.ClientHardWareInfoTLV)localObject2).a((short)this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.d(), (short)VcSystemInfo.a(), (int)(VcSystemInfo.a() / 1000L), (short)0);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientAVEngineInfoTLV((ConfigProtocol)localObject2);
    ((ConfigProtocol.ClientAVEngineInfoTLV)localObject2).a((byte)0, (byte)0, (short)this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.e, (short)this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.f);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientRomInfoTLV((ConfigProtocol)localObject2);
    ((ConfigProtocol.ClientRomInfoTLV)localObject2).a(Build.VERSION.INCREMENTAL);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigProtocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientSharpInfoTLV((ConfigProtocol)localObject2);
    ((ConfigProtocol.ClientSharpInfoTLV)localObject2).a(22);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a((ConfigProtocol.TLVBase)localObject2);
    return ((ConfigProtocol.C2SReqConfigProtocol)localObject1).a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigSystemImpl
 * JD-Core Version:    0.7.0.1
 */