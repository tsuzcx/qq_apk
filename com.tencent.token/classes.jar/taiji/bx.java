package taiji;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class bx
  extends bu
{
  private ArrayList f;
  private IBinder g;
  private ReentrantLock h;
  private int i;
  
  bx(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    this.f = new ArrayList();
    this.f.add("android.permission.CALL_PHONE");
    this.f.add("android.permission.READ_CALL_LOG");
    this.f.add("android.permission.READ_CONTACTS");
    this.f.add("android.permission.READ_SMS");
    this.f.add("android.permission.SEND_SMS");
    this.f.add("android.permission.SEND_MMS");
    this.f.add("android.permission.CHANGE_NETWORK_STATE");
    this.f.add("android.permission.CHANGE_WIFI_STATE");
    this.f.add("android.permission.BLUETOOTH_ADMIN");
    this.f.add("android.permission.ACCESS_FINE_LOCATION");
    this.f.add("android.permission.CAMERA");
    this.f.add("android.permission.RECORD_AUDIO");
    this.f.add("android.permission.NFC");
    this.f.add("android.permission.WRITE_CALL_LOG");
    this.f.add("android.permission.WRITE_CONTACTS");
    this.f.add("android.permission.WRITE_SMS");
    this.f.add("android.permission.WRITE_MMS");
    this.f.add("android.permission.READ_MMS");
    this.f.add("com.android.browser.permission.READ_HISTORY_BOOKMARKS");
    this.f.add("android.permission.READ_CALENDAR");
    this.f.add("android.permission.WRITE_CALENDAR");
    try
    {
      this.g = ((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "permission" }));
      this.h = new ReentrantLock();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  private int a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 117	taiji/bx:a	Landroid/content/Context;
    //   4: ifnull +20 -> 24
    //   7: aload_0
    //   8: getfield 30	taiji/bx:f	Ljava/util/ArrayList;
    //   11: ifnull +13 -> 24
    //   14: aload_0
    //   15: getfield 30	taiji/bx:f	Ljava/util/ArrayList;
    //   18: invokevirtual 121	java/util/ArrayList:isEmpty	()Z
    //   21: ifeq +7 -> 28
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 117	taiji/bx:a	Landroid/content/Context;
    //   32: invokevirtual 127	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: ldc 129
    //   37: invokestatic 135	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   40: ldc 137
    //   42: invokestatic 141	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   45: aconst_null
    //   46: ldc 143
    //   48: iconst_1
    //   49: anewarray 88	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: getfield 117	taiji/bx:a	Landroid/content/Context;
    //   58: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
    //   61: aastore
    //   62: aconst_null
    //   63: invokevirtual 153	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   66: astore 7
    //   68: aload 7
    //   70: ifnull +371 -> 441
    //   73: iconst_0
    //   74: istore_3
    //   75: iload_3
    //   76: istore 4
    //   78: aload 7
    //   80: astore 6
    //   82: aload 7
    //   84: invokeinterface 158 1 0
    //   89: ifeq +33 -> 122
    //   92: aload 7
    //   94: astore 6
    //   96: aload 7
    //   98: aload 7
    //   100: ldc 160
    //   102: invokeinterface 164 2 0
    //   107: invokeinterface 168 2 0
    //   112: istore 4
    //   114: iload 4
    //   116: ifeq +24 -> 140
    //   119: iload_3
    //   120: istore 4
    //   122: iload 4
    //   124: istore_1
    //   125: aload 7
    //   127: ifnull -101 -> 26
    //   130: aload 7
    //   132: invokeinterface 171 1 0
    //   137: iload 4
    //   139: ireturn
    //   140: aload 7
    //   142: astore 6
    //   144: iconst_1
    //   145: aload_0
    //   146: getfield 30	taiji/bx:f	Ljava/util/ArrayList;
    //   149: iload_1
    //   150: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: invokevirtual 181	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   156: ishl
    //   157: istore 4
    //   159: aload 7
    //   161: astore 6
    //   163: aload 7
    //   165: aload 7
    //   167: ldc 183
    //   169: invokeinterface 164 2 0
    //   174: invokeinterface 168 2 0
    //   179: iload 4
    //   181: iand
    //   182: ifeq +8 -> 190
    //   185: iconst_m1
    //   186: istore_3
    //   187: goto -112 -> 75
    //   190: aload 7
    //   192: astore 6
    //   194: aload 7
    //   196: aload 7
    //   198: ldc 185
    //   200: invokeinterface 164 2 0
    //   205: invokeinterface 168 2 0
    //   210: istore 5
    //   212: iload 4
    //   214: iload 5
    //   216: iand
    //   217: ifeq -142 -> 75
    //   220: iconst_1
    //   221: istore_3
    //   222: goto -147 -> 75
    //   225: astore 6
    //   227: aconst_null
    //   228: astore 7
    //   230: iconst_0
    //   231: istore 4
    //   233: iload 4
    //   235: istore_3
    //   236: iload_1
    //   237: tableswitch	default:+99 -> 336, 10:+123->360, 11:+123->360, 12:+123->360, 13:+102->339, 14:+123->360, 15:+102->339, 16:+123->360, 17:+102->339, 18:+102->339, 19:+102->339, 20:+102->339, 21:+123->360, 22:+123->360, 23:+102->339, 24:+123->360, 25:+102->339, 26:+102->339, 27:+123->360, 28:+123->360, 29:+123->360, 30:+123->360
    //   337: iconst_1
    //   338: istore_3
    //   339: iload_3
    //   340: iconst_m1
    //   341: if_icmpne +106 -> 447
    //   344: iload_3
    //   345: istore_1
    //   346: aload 7
    //   348: ifnull -322 -> 26
    //   351: aload 7
    //   353: invokeinterface 171 1 0
    //   358: iload_3
    //   359: ireturn
    //   360: aload 7
    //   362: astore 6
    //   364: aload_0
    //   365: iload_1
    //   366: invokespecial 188	taiji/bu:checkPermission	(I)I
    //   369: istore_3
    //   370: goto -31 -> 339
    //   373: aload 7
    //   375: astore 6
    //   377: aload_0
    //   378: aload_2
    //   379: invokespecial 190	taiji/bx:a	(Ljava/lang/String;)I
    //   382: istore_3
    //   383: iload_3
    //   384: istore_1
    //   385: aload 7
    //   387: ifnull -361 -> 26
    //   390: aload 7
    //   392: invokeinterface 171 1 0
    //   397: iload_3
    //   398: ireturn
    //   399: ldc 192
    //   401: astore_2
    //   402: goto -29 -> 373
    //   405: ldc 194
    //   407: astore_2
    //   408: goto -35 -> 373
    //   411: astore_2
    //   412: aconst_null
    //   413: astore 6
    //   415: aload 6
    //   417: ifnull +10 -> 427
    //   420: aload 6
    //   422: invokeinterface 171 1 0
    //   427: aload_2
    //   428: athrow
    //   429: astore_2
    //   430: goto -15 -> 415
    //   433: astore 6
    //   435: iload_3
    //   436: istore 4
    //   438: goto -205 -> 233
    //   441: iconst_0
    //   442: istore 4
    //   444: goto -322 -> 122
    //   447: iload_1
    //   448: bipush 16
    //   450: if_icmpeq -67 -> 383
    //   453: iload_1
    //   454: lookupswitch	default:+26->480, 13:+-55->399, 23:+-49->405
    //   481: impdep2
    //   482: fcmpl
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	bx
    //   0	483	1	paramInt	int
    //   0	483	2	paramString	String
    //   74	362	3	j	int
    //   76	367	4	k	int
    //   210	7	5	m	int
    //   80	113	6	localCursor1	android.database.Cursor
    //   225	1	6	localThrowable1	Throwable
    //   362	59	6	localCursor2	android.database.Cursor
    //   433	1	6	localThrowable2	Throwable
    //   66	325	7	localCursor3	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   28	68	225	java/lang/Throwable
    //   28	68	411	finally
    //   82	92	429	finally
    //   96	114	429	finally
    //   144	159	429	finally
    //   163	185	429	finally
    //   194	212	429	finally
    //   364	370	429	finally
    //   377	383	429	finally
    //   82	92	433	java/lang/Throwable
    //   96	114	433	java/lang/Throwable
    //   144	159	433	java/lang/Throwable
    //   163	185	433	java/lang/Throwable
    //   194	212	433	java/lang/Throwable
  }
  
  /* Error */
  private int a(android.os.Parcel paramParcel1, android.os.Parcel paramParcel2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_m1
    //   2: putfield 197	taiji/bx:i	I
    //   5: aload_0
    //   6: getfield 111	taiji/bx:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   9: invokevirtual 200	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   12: ifne +5 -> 17
    //   15: iconst_m1
    //   16: ireturn
    //   17: new 202	taiji/by
    //   20: dup
    //   21: aload_0
    //   22: aload_1
    //   23: aload_2
    //   24: invokespecial 205	taiji/by:<init>	(Ltaiji/bx;Landroid/os/Parcel;Landroid/os/Parcel;)V
    //   27: astore_1
    //   28: new 207	java/lang/Thread
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 210	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   36: invokevirtual 213	java/lang/Thread:start	()V
    //   39: aload_0
    //   40: getfield 111	taiji/bx:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   43: invokevirtual 216	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   46: aload_1
    //   47: monitorenter
    //   48: aload_1
    //   49: ldc2_w 217
    //   52: invokevirtual 222	java/lang/Object:wait	(J)V
    //   55: aload_1
    //   56: monitorexit
    //   57: aload_0
    //   58: getfield 197	taiji/bx:i	I
    //   61: ireturn
    //   62: astore_2
    //   63: aload_1
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    //   67: astore_2
    //   68: goto -13 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	bx
    //   0	71	1	paramParcel1	android.os.Parcel
    //   0	71	2	paramParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   48	55	62	finally
    //   55	57	62	finally
    //   63	65	62	finally
    //   48	55	67	java/lang/Throwable
  }
  
  /* Error */
  private int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 106	taiji/bx:g	Landroid/os/IBinder;
    //   6: ifnonnull +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: invokestatic 228	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   14: astore 4
    //   16: invokestatic 228	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   19: astore 5
    //   21: aload 4
    //   23: ldc 230
    //   25: invokevirtual 234	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 237	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   34: aload 4
    //   36: invokestatic 243	android/os/Process:myPid	()I
    //   39: invokevirtual 247	android/os/Parcel:writeInt	(I)V
    //   42: aload 4
    //   44: invokestatic 250	android/os/Process:myUid	()I
    //   47: invokevirtual 247	android/os/Parcel:writeInt	(I)V
    //   50: aload_1
    //   51: ldc 252
    //   53: invokevirtual 255	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +24 -> 80
    //   59: aload_0
    //   60: aload 4
    //   62: aload 5
    //   64: invokespecial 257	taiji/bx:a	(Landroid/os/Parcel;Landroid/os/Parcel;)I
    //   67: istore_2
    //   68: aload 4
    //   70: invokevirtual 260	android/os/Parcel:recycle	()V
    //   73: aload 5
    //   75: invokevirtual 260	android/os/Parcel:recycle	()V
    //   78: iload_2
    //   79: ireturn
    //   80: aload_0
    //   81: getfield 106	taiji/bx:g	Landroid/os/IBinder;
    //   84: iconst_1
    //   85: aload 4
    //   87: aload 5
    //   89: iconst_0
    //   90: invokeinterface 264 5 0
    //   95: pop
    //   96: aload 5
    //   98: invokevirtual 267	android/os/Parcel:readException	()V
    //   101: aload 5
    //   103: invokevirtual 270	android/os/Parcel:readInt	()I
    //   106: istore_3
    //   107: iload_3
    //   108: ifne -40 -> 68
    //   111: iconst_m1
    //   112: istore_2
    //   113: goto -45 -> 68
    //   116: astore_1
    //   117: aload 4
    //   119: invokevirtual 260	android/os/Parcel:recycle	()V
    //   122: aload 5
    //   124: invokevirtual 260	android/os/Parcel:recycle	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_1
    //   130: aload 4
    //   132: invokevirtual 260	android/os/Parcel:recycle	()V
    //   135: aload 5
    //   137: invokevirtual 260	android/os/Parcel:recycle	()V
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	bx
    //   0	142	1	paramString	String
    //   1	112	2	j	int
    //   106	2	3	k	int
    //   14	117	4	localParcel1	android.os.Parcel
    //   19	117	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   21	68	116	java/lang/Throwable
    //   80	107	116	java/lang/Throwable
    //   21	68	129	finally
    //   80	107	129	finally
  }
  
  public int checkPermission(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 0;
    }
    switch (paramInt)
    {
    case 7: 
    case 17: 
    case 26: 
    case 32: 
    case 42: 
    case 45: 
    case 47: 
    case 48: 
    default: 
      return 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 25: 
    case 31: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 43: 
    case 46: 
    case 49: 
      return super.checkPermission(paramInt);
    case 10: 
      return a(paramInt, "android.permission.CALL_PHONE");
    case 11: 
      return a(paramInt, "android.permission.READ_CALL_LOG");
    case 12: 
    case 13: 
      return a(paramInt, "android.permission.WRITE_CALL_LOG");
    case 14: 
      return a(paramInt, "android.permission.READ_SMS");
    case 15: 
      return a(paramInt, "android.permission.WRITE_SMS");
    case 16: 
      return a(paramInt, "android.permission.SEND_SMS");
    case 18: 
      return a(paramInt, "android.permission.READ_MMS");
    case 19: 
      return a(paramInt, "android.permission.WRITE_MMS");
    case 20: 
      return a(paramInt, "android.permission.SEND_MMS");
    case 21: 
      return a(paramInt, "android.permission.READ_CONTACTS");
    case 22: 
    case 23: 
      return a(paramInt, "android.permission.WRITE_CONTACTS");
    case 24: 
      return a(paramInt, "android.permission.ACCESS_FINE_LOCATION");
    case 27: 
      return a(paramInt, "android.permission.READ_CALENDAR");
    case 28: 
      return a(paramInt, "android.permission.WRITE_CALENDAR");
    case 29: 
      return a(paramInt, "android.permission.CAMERA");
    case 30: 
      return a(paramInt, "android.permission.RECORD_AUDIO");
    case 33: 
      return a(paramInt, "android.permission.CHANGE_NETWORK_STATE");
    case 34: 
      return a(paramInt, "android.permission.CHANGE_WIFI_STATE");
    case 35: 
      return a(paramInt, "android.permission.BLUETOOTH_ADMIN");
    }
    return a(paramInt, "android.permission.ACCESS_MEDIA_PROVIDER");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bx
 * JD-Core Version:    0.7.0.1
 */