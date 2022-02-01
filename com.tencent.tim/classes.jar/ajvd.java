import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;

public class ajvd
  implements Manager
{
  protected static SparseArray<Integer> cZ;
  private final List<ajve> DA = new ArrayList();
  private final List<ajve> Dz = new ArrayList();
  private ajvf jdField_a_of_type_Ajvf;
  private NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  private MqqHandler q;
  private MqqHandler jdField_t_of_type_MqqOsMqqHandler;
  private boolean[] jdField_t_of_type_ArrayOfBoolean;
  
  public ajvd(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_Ajvf = new ajvf(paramNearbyAppInterface, this);
    this.q = ThreadManager.getUIHandler();
    this.jdField_t_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  private void a(SubMsgType0x27.AppointmentNotify paramAppointmentNotify)
  {
    if (paramAppointmentNotify == null) {}
    long l;
    do
    {
      do
      {
        return;
        l = paramAppointmentNotify.uint32_notifytype.get();
        if ((l != 2L) && (l != 4L)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.nearby", 2, "hasOnLinePush|shield dating notify");
      return;
    } while (l != 5L);
  }
  
  private Object[] a(int paramInt)
  {
    return this.jdField_a_of_type_Ajvf.a(paramInt);
  }
  
  private Object[] a(int paramInt, Object... paramVarArgs)
  {
    return this.jdField_a_of_type_Ajvf.a(paramInt, paramVarArgs);
  }
  
  private Message b(Message paramMessage)
  {
    return this.jdField_a_of_type_Ajvf.b(paramMessage);
  }
  
  public int GC()
  {
    Object[] arrayOfObject = this.jdField_a_of_type_Ajvf.a(4156);
    if ((arrayOfObject == null) || (arrayOfObject.length < 1)) {
      return -1;
    }
    try
    {
      int i = ((Integer)arrayOfObject[0]).intValue();
      return i;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("getMyAccGender", 2, localException.toString());
      }
    }
    return -1;
  }
  
  public int GD()
  {
    Object[] arrayOfObject = a(4163, new Object[] { acbn.bkF });
    try
    {
      int i = ((Integer)arrayOfObject[0]).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "getNearbyMsgBoxUnreadNum toolProcess,num=" + i);
      }
      return i;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "getNearbyMsgBoxUnreadNum，exp=", localException);
      }
    }
    return 0;
  }
  
  public void MZ(String paramString)
  {
    a(4145, new Object[] { paramString });
  }
  
  public void Ru(int paramInt)
  {
    a(4158, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public Bitmap a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = new Message();
    ((Message)localObject).what = 4160;
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    localBundle.putInt("headType", paramInt);
    localBundle.putBoolean("appendToTail", paramBoolean);
    ((Message)localObject).setData(localBundle);
    paramString = b((Message)localObject);
    if (paramString == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      paramString = paramString.getData();
      paramString.setClassLoader(Bitmap.class.getClassLoader());
      localObject = (Bitmap)paramString.getParcelable("faceBmp");
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.i("Q.dynamicAvatar", 2, "ipc getFaceBitmap : " + localObject);
    return localObject;
  }
  
  public Message a(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return null;
      } while (localObject == null);
      l(4118, new Object[] { ((Bundle)localObject).getStringArrayList("keys"), ((Bundle)localObject).getStringArrayList("paths") });
      return null;
      paramMessage = paramMessage.getData();
    } while (paramMessage == null);
    int i = paramMessage.getInt("headType");
    localObject = paramMessage.getString("id");
    int j = paramMessage.getInt("idType");
    ((aqdm)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(216)).Um(FaceInfo.a(i, (String)localObject, j, 1));
    return null;
  }
  
  public DynamicAvatar a(int paramInt, String paramString)
  {
    Object localObject = new Message();
    ((Message)localObject).what = 4143;
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putString("id", paramString);
    ((Message)localObject).setData(localBundle);
    paramString = b((Message)localObject);
    if (paramString == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      paramString = paramString.getData();
      paramString.setClassLoader(DynamicAvatar.class.getClassLoader());
      localObject = (DynamicAvatar)paramString.getParcelable("avatarInfo");
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.i("Q.dynamicAvatar", 2, "ipc getDynamicAvatarInfo : " + localObject);
    return localObject;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(int paramInt)
  {
    Object localObject = null;
    Object[] arrayOfObject = a(4157, new Object[] { Integer.valueOf(paramInt) });
    if (arrayOfObject != null) {}
    for (;;)
    {
      try
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.mergeFrom((byte[])arrayOfObject[0]);
        localObject = localRedTypeInfo;
      }
      catch (Exception localException)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        localException.printStackTrace();
        return null;
      }
      return localObject;
      localObject = null;
    }
  }
  
  public void a(ajve paramajve, boolean paramBoolean)
  {
    if (paramajve == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.DA)
      {
        if (!this.DA.contains(paramajve)) {
          this.DA.add(paramajve);
        }
        return;
      }
    }
    synchronized (this.Dz)
    {
      if (!this.Dz.contains(paramajve)) {
        this.Dz.add(paramajve);
      }
      return;
    }
  }
  
  public void a(cmd0x9c7.RspBody paramRspBody)
  {
    if (paramRspBody == null) {}
    for (paramRspBody = null;; paramRspBody = paramRspBody.toByteArray())
    {
      a(4123, new Object[] { paramRspBody });
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (paramBoolean) {}
    for (int i = 4099;; i = 4098)
    {
      a(i, new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString6, paramString7, paramString8, paramString9 });
      return;
    }
  }
  
  public boolean arB()
  {
    return this.jdField_a_of_type_Ajvf.arB();
  }
  
  public akju b()
  {
    akju localakju = new akju();
    Object[] arrayOfObject = a(4165, new Object[] { Integer.valueOf(0) });
    if (arrayOfObject != null) {}
    try
    {
      localakju.num = ((Integer)arrayOfObject[0]).intValue();
      localakju.dmY = ((Integer)arrayOfObject[1]).intValue();
      localakju.dmZ = ((Integer)arrayOfObject[2]).intValue();
      localakju.dna = ((Integer)arrayOfObject[3]).intValue();
      return localakju;
    }
    catch (Exception localException)
    {
      while (!QLog.isDevelopLevel()) {}
      localException.printStackTrace();
    }
    return localakju;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo b(int paramInt)
  {
    if (cZ == null)
    {
      cZ = new SparseArray();
      cZ.put(65, Integer.valueOf(12));
    }
    Integer localInteger = (Integer)cZ.get(paramInt);
    if (localInteger != null) {
      return a(localInteger.intValue());
    }
    return null;
  }
  
  public void b(Setting paramSetting)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4134;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("setting", paramSetting);
    localMessage.setData(localBundle);
    b(localMessage);
  }
  
  public void b(oidb_0x8dd.SelfInfo paramSelfInfo)
  {
    Object localObject2 = null;
    try
    {
      Object localObject1 = paramSelfInfo.toByteArray();
      if (localObject1 != null) {
        a(4109, new Object[] { localObject1 });
      }
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        ajrk.f("Q.nearby", "updateSelfCard", new Object[] { paramSelfInfo, localObject1 });
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Integer localInteger = null;
        continue;
        localInteger = Integer.valueOf(localInteger.length);
      }
    }
  }
  
  public Object[] b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 4100: 
    case 4101: 
    case 4113: 
    case 4114: 
    case 4115: 
    case 4116: 
    case 4117: 
    case 4122: 
    case 4126: 
    case 4131: 
    case 4140: 
    case 4142: 
    case 4144: 
    case 4146: 
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return null;
                if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof Integer)))
                {
                  paramInt = ((Integer)paramVarArgs[0]).intValue();
                  if (QLog.isColorLevel())
                  {
                    ajrk.m("MSG_NOTIFY_HAS_UNREAD_MSG", new Object[] { Integer.valueOf(paramInt) });
                    return null;
                    if ((paramVarArgs != null) && (paramVarArgs.length == 1))
                    {
                      paramVarArgs = (byte[])paramVarArgs[0];
                      try
                      {
                        SubMsgType0x27.AppointmentNotify localAppointmentNotify = new SubMsgType0x27.AppointmentNotify();
                        localAppointmentNotify.mergeFrom(paramVarArgs);
                        a(localAppointmentNotify);
                        return null;
                      }
                      catch (Exception paramVarArgs)
                      {
                        paramVarArgs.printStackTrace();
                        return null;
                      }
                      if ((paramVarArgs != null) && (paramVarArgs.length == 2))
                      {
                        l(4113, new Object[] { paramVarArgs[0], paramVarArgs[1] });
                        return null;
                        if ((paramVarArgs != null) && (paramVarArgs.length == 2))
                        {
                          l(4114, new Object[] { paramVarArgs[0], paramVarArgs[1] });
                          return null;
                          if ((paramVarArgs != null) && (paramVarArgs.length == 1))
                          {
                            l(4115, paramVarArgs);
                            return null;
                            if ((paramVarArgs != null) && (paramVarArgs.length == 1))
                            {
                              l(4116, paramVarArgs);
                              return null;
                              akkx.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 0, true);
                              return null;
                              if ((paramVarArgs != null) && (paramVarArgs.length >= 3)) {
                                try
                                {
                                  paramInt = ((Integer)paramVarArgs[0]).intValue();
                                  QLog.i("updateCharmConfigIPC", 1, "Charm=" + paramInt);
                                  if (paramVarArgs[1] != null) {
                                    new Oidb_0x686.NearbyRankConfig().mergeFrom((byte[])paramVarArgs[1]);
                                  }
                                  if (paramVarArgs[2] != null)
                                  {
                                    new Oidb_0x686.NearbyFeedConfig().mergeFrom((byte[])paramVarArgs[2]);
                                    return null;
                                  }
                                }
                                catch (Exception paramVarArgs) {}
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            } while (!QLog.isColorLevel());
            QLog.d("NearbyProcManager", 2, "MSG_GET_CHARM_EVENT catch exception:", paramVarArgs);
            return null;
            ((aehy)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(210)).cXd();
            return null;
          } while ((paramVarArgs == null) || (paramVarArgs.length != 2));
          l(4131, new Object[] { Integer.valueOf(((Integer)paramVarArgs[0]).intValue()), Boolean.valueOf(((Boolean)paramVarArgs[1]).booleanValue()) });
          return null;
          aeib.cXe();
          return null;
        } while ((paramVarArgs == null) || (paramVarArgs.length != 4));
        try
        {
          long l = ((Long)paramVarArgs[0]).longValue();
          paramInt = ((Integer)paramVarArgs[1]).intValue();
          i = ((Integer)paramVarArgs[2]).intValue();
          int j = ((Integer)paramVarArgs[3]).intValue();
          ((ajra)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(219)).g(l, paramInt, i, j);
          return null;
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          return null;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.dyD();
        return null;
      } while ((paramVarArgs == null) || (paramVarArgs.length != 2));
      paramInt = ((Integer)paramVarArgs[0]).intValue();
      int i = ((Integer)paramVarArgs[1]).intValue();
      ((acig)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getBusinessHandler(3)).aK(paramInt, i);
      return null;
    case 4159: 
      l(4159, new Object[0]);
      return null;
    case 4161: 
      try
      {
        l(4161, new Object[] { (Integer)paramVarArgs[0], (String)paramVarArgs[1], (Bitmap)paramVarArgs[2] });
        return null;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return null;
      }
    case 4162: 
      try
      {
        l(4162, new Object[] { (Integer)paramVarArgs[0], (String)paramVarArgs[1] });
        return null;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return null;
      }
    }
    try
    {
      l(4164, new Object[] { (Integer)paramVarArgs[0] });
      return null;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return null;
  }
  
  public void bk(byte[] paramArrayOfByte)
  {
    a(4142, new Object[] { paramArrayOfByte });
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "saveDynamicAvarInfo2db send ipcMsg.");
    }
  }
  
  public void c(ajve paramajve)
  {
    a(paramajve, false);
  }
  
  public void d(ajve paramajve)
  {
    synchronized (this.Dz)
    {
      if (this.Dz.contains(paramajve)) {
        this.Dz.remove(paramajve);
      }
    }
    synchronized (this.DA)
    {
      if (this.DA.contains(paramajve)) {
        this.DA.remove(paramajve);
      }
      return;
      paramajve = finally;
      throw paramajve;
    }
  }
  
  public void dzA()
  {
    a(4148);
  }
  
  public void dzx()
  {
    this.jdField_a_of_type_Ajvf.bindService();
  }
  
  public void dzy()
  {
    this.jdField_a_of_type_Ajvf.amt();
  }
  
  public void dzz()
  {
    a(4147);
  }
  
  public void eC(ArrayList<String> paramArrayList)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4118;
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("key", paramArrayList);
    localMessage.setData(localBundle);
    paramArrayList = b(localMessage);
    if (paramArrayList != null) {}
    for (paramArrayList = paramArrayList.getData();; paramArrayList = null)
    {
      if (paramArrayList != null) {
        l(4118, new Object[] { paramArrayList.getStringArrayList("key"), paramArrayList.getStringArrayList("path") });
      }
      return;
    }
  }
  
  public void g(ArrayList<String> paramArrayList, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4135;
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("faceKeyList", paramArrayList);
    localBundle.putLong("faceTimestamp", paramLong);
    b(localMessage);
  }
  
  public Setting getFaceSetting(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4133;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key", paramString);
    localMessage.setData((Bundle)localObject);
    localObject = b(localMessage);
    localMessage = null;
    paramString = localMessage;
    if (localObject != null)
    {
      localObject = ((Message)localObject).getData();
      paramString = localMessage;
      if (localObject != null)
      {
        ((Bundle)localObject).setClassLoader(Setting.class.getClassLoader());
        paramString = (Setting)((Bundle)localObject).getParcelable("setting");
      }
    }
    return paramString;
  }
  
  public void l(byte paramByte)
  {
    a(4108, new Object[] { Byte.valueOf(paramByte) });
  }
  
  /* Error */
  public void l(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 32	ajvd:Dz	Ljava/util/List;
    //   7: astore 5
    //   9: aload 5
    //   11: monitorenter
    //   12: iconst_0
    //   13: istore_3
    //   14: iload_3
    //   15: aload_0
    //   16: getfield 32	ajvd:Dz	Ljava/util/List;
    //   19: invokeinterface 489 1 0
    //   24: if_icmpge +45 -> 69
    //   27: aload_0
    //   28: getfield 32	ajvd:Dz	Ljava/util/List;
    //   31: iload_3
    //   32: invokeinterface 490 2 0
    //   37: checkcast 492	ajve
    //   40: astore 6
    //   42: aload_0
    //   43: getfield 49	ajvd:q	Lmqq/os/MqqHandler;
    //   46: new 494	com/tencent/mobileqq/nearby/ipc/NearbyProcManager$1
    //   49: dup
    //   50: aload_0
    //   51: aload 6
    //   53: iload_1
    //   54: aload_2
    //   55: invokespecial 497	com/tencent/mobileqq/nearby/ipc/NearbyProcManager$1:<init>	(Lajvd;Lajve;I[Ljava/lang/Object;)V
    //   58: invokevirtual 503	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   61: pop
    //   62: iload_3
    //   63: iconst_1
    //   64: iadd
    //   65: istore_3
    //   66: goto -52 -> 14
    //   69: aload 5
    //   71: monitorexit
    //   72: aload_0
    //   73: getfield 30	ajvd:DA	Ljava/util/List;
    //   76: astore 5
    //   78: aload 5
    //   80: monitorenter
    //   81: iload 4
    //   83: istore_3
    //   84: iload_3
    //   85: aload_0
    //   86: getfield 30	ajvd:DA	Ljava/util/List;
    //   89: invokeinterface 489 1 0
    //   94: if_icmpge +51 -> 145
    //   97: aload_0
    //   98: getfield 30	ajvd:DA	Ljava/util/List;
    //   101: iload_3
    //   102: invokeinterface 490 2 0
    //   107: checkcast 492	ajve
    //   110: astore 6
    //   112: aload_0
    //   113: getfield 54	ajvd:jdField_t_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   116: new 505	com/tencent/mobileqq/nearby/ipc/NearbyProcManager$2
    //   119: dup
    //   120: aload_0
    //   121: aload 6
    //   123: iload_1
    //   124: aload_2
    //   125: invokespecial 506	com/tencent/mobileqq/nearby/ipc/NearbyProcManager$2:<init>	(Lajvd;Lajve;I[Ljava/lang/Object;)V
    //   128: invokevirtual 503	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   131: pop
    //   132: iload_3
    //   133: iconst_1
    //   134: iadd
    //   135: istore_3
    //   136: goto -52 -> 84
    //   139: astore_2
    //   140: aload 5
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: aload 5
    //   147: monitorexit
    //   148: return
    //   149: astore_2
    //   150: aload 5
    //   152: monitorexit
    //   153: aload_2
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	ajvd
    //   0	155	1	paramInt	int
    //   0	155	2	paramVarArgs	Object[]
    //   13	123	3	i	int
    //   1	81	4	j	int
    //   7	144	5	localList	List
    //   40	82	6	localajve	ajve
    // Exception table:
    //   from	to	target	type
    //   14	62	139	finally
    //   69	72	139	finally
    //   140	143	139	finally
    //   84	132	149	finally
    //   145	148	149	finally
    //   150	153	149	finally
  }
  
  public boolean m(int paramInt, boolean paramBoolean)
  {
    boolean bool1 = false;
    Object localObject = null;
    SharedPreferences localSharedPreferences = ajrb.a("nearby_event_file", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), 4);
    if (this.jdField_t_of_type_ArrayOfBoolean == null)
    {
      this.jdField_t_of_type_ArrayOfBoolean = new boolean[2];
      int i = 0;
      if (i < this.jdField_t_of_type_ArrayOfBoolean.length)
      {
        switch (i)
        {
        }
        for (;;)
        {
          this.jdField_t_of_type_ArrayOfBoolean[i] = localSharedPreferences.getBoolean((String)localObject, false);
          i += 1;
          break;
          localObject = "config_show_date";
          continue;
          localObject = "config_show_rank";
        }
      }
    }
    localObject = localSharedPreferences.edit();
    if (this.jdField_t_of_type_ArrayOfBoolean[paramInt] != paramBoolean)
    {
      this.jdField_t_of_type_ArrayOfBoolean[paramInt] = paramBoolean;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      bool1 = true;
      for (;;)
      {
        for (;;)
        {
          try
          {
            boolean bool2 = ((SharedPreferences.Editor)localObject).commit();
            if (QLog.isColorLevel()) {
              ajrk.m("onGetMyTabConfig", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
            }
            return bool1;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
          try
          {
            ((SharedPreferences.Editor)localObject).putBoolean("config_show_date", paramBoolean);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              localException.printStackTrace();
              ajrk.m("onGetMyTabConfig", new Object[] { "save config", Integer.valueOf(paramInt), localException.toString() });
            }
            bool1 = true;
          }
        }
      }
      ((SharedPreferences.Editor)localObject).putBoolean("config_show_rank", paramBoolean);
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    dzy();
    this.jdField_a_of_type_Ajvf = null;
    synchronized (this.DA)
    {
      this.DA.clear();
    }
    synchronized (this.Dz)
    {
      this.Dz.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvd
 * JD-Core Version:    0.7.0.1
 */