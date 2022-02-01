package taiji;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class be
  extends bb
{
  private ArrayList<String> f;
  private IBinder g;
  private ReentrantLock h;
  private int i;
  
  be(Context paramContext)
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
    //   1: getfield 120	taiji/be:a	Landroid/content/Context;
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 6
    //   12: iconst_0
    //   13: istore 7
    //   15: iconst_0
    //   16: istore_3
    //   17: iload 6
    //   19: istore 5
    //   21: aload 8
    //   23: ifnull +477 -> 500
    //   26: aload_0
    //   27: getfield 33	taiji/be:f	Ljava/util/ArrayList;
    //   30: astore 8
    //   32: iload 6
    //   34: istore 5
    //   36: aload 8
    //   38: ifnull +462 -> 500
    //   41: aload 8
    //   43: invokevirtual 124	java/util/ArrayList:isEmpty	()Z
    //   46: ifeq +5 -> 51
    //   49: iconst_0
    //   50: ireturn
    //   51: aconst_null
    //   52: astore 8
    //   54: aconst_null
    //   55: astore 9
    //   57: iload 7
    //   59: istore 5
    //   61: aload_0
    //   62: getfield 120	taiji/be:a	Landroid/content/Context;
    //   65: invokevirtual 130	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   68: ldc 132
    //   70: invokestatic 138	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   73: ldc 140
    //   75: invokestatic 144	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   78: aconst_null
    //   79: ldc 146
    //   81: iconst_1
    //   82: anewarray 91	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: aload_0
    //   88: getfield 120	taiji/be:a	Landroid/content/Context;
    //   91: invokevirtual 150	android/content/Context:getPackageName	()Ljava/lang/String;
    //   94: aastore
    //   95: aconst_null
    //   96: invokevirtual 156	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   99: astore 10
    //   101: aload 10
    //   103: ifnull +169 -> 272
    //   106: iload_3
    //   107: istore 4
    //   109: aload 10
    //   111: astore 9
    //   113: aload 10
    //   115: astore 8
    //   117: iload_3
    //   118: istore 5
    //   120: aload 10
    //   122: invokeinterface 161 1 0
    //   127: ifeq +145 -> 272
    //   130: aload 10
    //   132: astore 9
    //   134: aload 10
    //   136: astore 8
    //   138: iload_3
    //   139: istore 5
    //   141: aload 10
    //   143: aload 10
    //   145: ldc 163
    //   147: invokeinterface 167 2 0
    //   152: invokeinterface 171 2 0
    //   157: ifeq +9 -> 166
    //   160: iload_3
    //   161: istore 4
    //   163: goto +109 -> 272
    //   166: aload 10
    //   168: astore 9
    //   170: aload 10
    //   172: astore 8
    //   174: iload_3
    //   175: istore 5
    //   177: iconst_1
    //   178: aload_0
    //   179: getfield 33	taiji/be:f	Ljava/util/ArrayList;
    //   182: iload_1
    //   183: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: invokevirtual 181	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   189: ishl
    //   190: istore 4
    //   192: aload 10
    //   194: astore 9
    //   196: aload 10
    //   198: astore 8
    //   200: iload_3
    //   201: istore 5
    //   203: aload 10
    //   205: aload 10
    //   207: ldc 183
    //   209: invokeinterface 167 2 0
    //   214: invokeinterface 171 2 0
    //   219: iload 4
    //   221: iand
    //   222: ifeq +8 -> 230
    //   225: iconst_m1
    //   226: istore_3
    //   227: goto -121 -> 106
    //   230: aload 10
    //   232: astore 9
    //   234: aload 10
    //   236: astore 8
    //   238: iload_3
    //   239: istore 5
    //   241: aload 10
    //   243: aload 10
    //   245: ldc 185
    //   247: invokeinterface 167 2 0
    //   252: invokeinterface 171 2 0
    //   257: istore 6
    //   259: iload 4
    //   261: iload 6
    //   263: iand
    //   264: ifeq -158 -> 106
    //   267: iconst_1
    //   268: istore_3
    //   269: goto -163 -> 106
    //   272: iload 4
    //   274: istore 5
    //   276: aload 10
    //   278: ifnull +222 -> 500
    //   281: iload 4
    //   283: istore_3
    //   284: aload 10
    //   286: astore 8
    //   288: aload 8
    //   290: invokeinterface 188 1 0
    //   295: iload_3
    //   296: ireturn
    //   297: astore_2
    //   298: goto +177 -> 475
    //   301: iload_1
    //   302: tableswitch	default:+98 -> 400, 10:+104->406, 11:+104->406, 12:+104->406, 13:+98->400, 14:+104->406, 15:+98->400, 16:+104->406, 17:+98->400, 18:+98->400, 19:+98->400, 20:+98->400, 21:+104->406, 22:+104->406, 23:+98->400, 24:+104->406, 25:+98->400, 26:+98->400, 27:+104->406, 28:+104->406, 29:+104->406, 30:+104->406
    //   401: iconst_2
    //   402: istore_3
    //   403: goto +13 -> 416
    //   406: aload 8
    //   408: astore 9
    //   410: aload_0
    //   411: iload_1
    //   412: invokespecial 191	taiji/bb:checkPermission	(I)I
    //   415: istore_3
    //   416: iload_3
    //   417: iconst_m1
    //   418: if_icmpne +17 -> 435
    //   421: aload 8
    //   423: ifnull +10 -> 433
    //   426: aload 8
    //   428: invokeinterface 188 1 0
    //   433: iload_3
    //   434: ireturn
    //   435: iload_1
    //   436: bipush 16
    //   438: if_icmpeq +51 -> 489
    //   441: iload_1
    //   442: bipush 13
    //   444: if_icmpeq +64 -> 508
    //   447: iload_1
    //   448: bipush 23
    //   450: if_icmpeq +6 -> 456
    //   453: goto +9 -> 462
    //   456: ldc 193
    //   458: astore_2
    //   459: goto +3 -> 462
    //   462: aload 8
    //   464: astore 9
    //   466: aload_0
    //   467: aload_2
    //   468: invokespecial 195	taiji/be:a	(Ljava/lang/String;)I
    //   471: istore_3
    //   472: goto +17 -> 489
    //   475: aload 9
    //   477: ifnull +10 -> 487
    //   480: aload 9
    //   482: invokeinterface 188 1 0
    //   487: aload_2
    //   488: athrow
    //   489: iload_3
    //   490: istore 5
    //   492: aload 8
    //   494: ifnull +6 -> 500
    //   497: goto -209 -> 288
    //   500: iload 5
    //   502: ireturn
    //   503: astore 9
    //   505: goto -204 -> 301
    //   508: ldc 197
    //   510: astore_2
    //   511: goto -49 -> 462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	be
    //   0	514	1	paramInt	int
    //   0	514	2	paramString	String
    //   16	474	3	j	int
    //   7	275	4	k	int
    //   19	482	5	m	int
    //   10	254	6	n	int
    //   13	45	7	i1	int
    //   4	489	8	localObject1	Object
    //   55	426	9	localObject2	Object
    //   503	1	9	localThrowable	Throwable
    //   99	186	10	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   61	101	297	finally
    //   120	130	297	finally
    //   141	160	297	finally
    //   177	192	297	finally
    //   203	225	297	finally
    //   241	259	297	finally
    //   410	416	297	finally
    //   466	472	297	finally
    //   61	101	503	java/lang/Throwable
    //   120	130	503	java/lang/Throwable
    //   141	160	503	java/lang/Throwable
    //   177	192	503	java/lang/Throwable
    //   203	225	503	java/lang/Throwable
    //   241	259	503	java/lang/Throwable
  }
  
  private int a(final Parcel paramParcel1, final Parcel paramParcel2)
  {
    this.i = -1;
    if (!this.h.tryLock()) {
      return -1;
    }
    paramParcel1 = new Runnable()
    {
      public void run()
      {
        try
        {
          long l = System.currentTimeMillis();
          be.a(be.this).lock();
          be.b(be.this).transact(1, paramParcel1, paramParcel2, 0);
          be.a(be.this).unlock();
          paramParcel2.readException();
          int i = paramParcel2.readInt();
          if (System.currentTimeMillis() - l < 200L)
          {
            if (i == 0) {
              be.a(be.this, -1);
            } else {
              be.a(be.this, 0);
            }
            try
            {
              notify();
              return;
            }
            finally {}
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    };
    new Thread(paramParcel1).start();
    this.h.unlock();
    try
    {
      try
      {
        paramParcel1.wait(200L);
      }
      finally
      {
        break label69;
      }
    }
    catch (Throwable paramParcel2)
    {
      label62:
      label69:
      break label62;
    }
    return this.i;
    throw paramParcel2;
  }
  
  private int a(String paramString)
  {
    Object localObject = this.g;
    int j = 0;
    if (localObject == null) {
      return 0;
    }
    localObject = Parcel.obtain();
    Parcel localParcel = Parcel.obtain();
    try
    {
      try
      {
        ((Parcel)localObject).writeInterfaceToken("android.os.IPermissionController");
        ((Parcel)localObject).writeString(paramString);
        ((Parcel)localObject).writeInt(Process.myPid());
        ((Parcel)localObject).writeInt(Process.myUid());
        int k;
        if (paramString.equals("android.permission.ACCESS_MEDIA_PROVIDER"))
        {
          k = a((Parcel)localObject, localParcel);
          j = k;
        }
        else
        {
          this.g.transact(1, (Parcel)localObject, localParcel, 0);
          localParcel.readException();
          k = localParcel.readInt();
          if (k == 0) {
            j = -1;
          }
        }
      }
      finally
      {
        ((Parcel)localObject).recycle();
        localParcel.recycle();
      }
    }
    catch (Throwable paramString)
    {
      label126:
      break label126;
    }
    ((Parcel)localObject).recycle();
    localParcel.recycle();
    return j;
  }
  
  public int checkPermission(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 0;
    }
    String str;
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
    case 44: 
      str = "android.permission.ACCESS_MEDIA_PROVIDER";
    case 35: 
    case 34: 
    case 33: 
    case 30: 
    case 29: 
    case 28: 
    case 27: 
    case 24: 
    case 22: 
    case 23: 
    case 21: 
    case 20: 
    case 19: 
    case 18: 
    case 16: 
    case 15: 
    case 14: 
    case 12: 
    case 13: 
    case 11: 
    case 10: 
      for (;;)
      {
        return a(paramInt, str);
        str = "android.permission.BLUETOOTH_ADMIN";
        continue;
        str = "android.permission.CHANGE_WIFI_STATE";
        continue;
        str = "android.permission.CHANGE_NETWORK_STATE";
        continue;
        str = "android.permission.RECORD_AUDIO";
        continue;
        str = "android.permission.CAMERA";
        continue;
        str = "android.permission.WRITE_CALENDAR";
        continue;
        str = "android.permission.READ_CALENDAR";
        continue;
        str = "android.permission.ACCESS_FINE_LOCATION";
        continue;
        str = "android.permission.WRITE_CONTACTS";
        continue;
        str = "android.permission.READ_CONTACTS";
        continue;
        str = "android.permission.SEND_MMS";
        continue;
        str = "android.permission.WRITE_MMS";
        continue;
        str = "android.permission.READ_MMS";
        continue;
        str = "android.permission.SEND_SMS";
        continue;
        str = "android.permission.WRITE_SMS";
        continue;
        str = "android.permission.READ_SMS";
        continue;
        str = "android.permission.WRITE_CALL_LOG";
        continue;
        str = "android.permission.READ_CALL_LOG";
        continue;
        str = "android.permission.CALL_PHONE";
      }
    }
    return super.checkPermission(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.be
 * JD-Core Version:    0.7.0.1
 */