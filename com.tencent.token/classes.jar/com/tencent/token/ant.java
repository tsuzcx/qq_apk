package com.tencent.token;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public final class ant
  extends anq
{
  IBinder f;
  ReentrantLock g;
  int h;
  private ArrayList<String> i;
  
  public ant(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    this.i = new ArrayList();
    this.i.add("android.permission.CALL_PHONE");
    this.i.add("android.permission.READ_CALL_LOG");
    this.i.add("android.permission.READ_CONTACTS");
    this.i.add("android.permission.READ_SMS");
    this.i.add("android.permission.SEND_SMS");
    this.i.add("android.permission.SEND_MMS");
    this.i.add("android.permission.CHANGE_NETWORK_STATE");
    this.i.add("android.permission.CHANGE_WIFI_STATE");
    this.i.add("android.permission.BLUETOOTH_ADMIN");
    this.i.add("android.permission.ACCESS_FINE_LOCATION");
    this.i.add("android.permission.CAMERA");
    this.i.add("android.permission.RECORD_AUDIO");
    this.i.add("android.permission.NFC");
    this.i.add("android.permission.WRITE_CALL_LOG");
    this.i.add("android.permission.WRITE_CONTACTS");
    this.i.add("android.permission.WRITE_SMS");
    this.i.add("android.permission.WRITE_MMS");
    this.i.add("android.permission.READ_MMS");
    this.i.add("com.android.browser.permission.READ_HISTORY_BOOKMARKS");
    this.i.add("android.permission.READ_CALENDAR");
    this.i.add("android.permission.WRITE_CALENDAR");
    try
    {
      this.f = ((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "permission" }));
      this.g = new ReentrantLock();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  private int a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 120	com/tencent/token/ant:a	Landroid/content/Context;
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
    //   23: ifnull +473 -> 496
    //   26: aload_0
    //   27: getfield 33	com/tencent/token/ant:i	Ljava/util/ArrayList;
    //   30: astore 8
    //   32: iload 6
    //   34: istore 5
    //   36: aload 8
    //   38: ifnull +458 -> 496
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
    //   62: getfield 120	com/tencent/token/ant:a	Landroid/content/Context;
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
    //   88: getfield 120	com/tencent/token/ant:a	Landroid/content/Context;
    //   91: invokevirtual 150	android/content/Context:getPackageName	()Ljava/lang/String;
    //   94: aastore
    //   95: aconst_null
    //   96: invokevirtual 156	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   99: astore 10
    //   101: aload 10
    //   103: ifnull +166 -> 269
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
    //   127: ifeq +142 -> 269
    //   130: iload_3
    //   131: istore 4
    //   133: aload 10
    //   135: astore 9
    //   137: aload 10
    //   139: astore 8
    //   141: iload_3
    //   142: istore 5
    //   144: aload 10
    //   146: aload 10
    //   148: ldc 163
    //   150: invokeinterface 167 2 0
    //   155: invokeinterface 171 2 0
    //   160: ifne +109 -> 269
    //   163: aload 10
    //   165: astore 9
    //   167: aload 10
    //   169: astore 8
    //   171: iload_3
    //   172: istore 5
    //   174: iconst_1
    //   175: aload_0
    //   176: getfield 33	com/tencent/token/ant:i	Ljava/util/ArrayList;
    //   179: iload_1
    //   180: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: invokevirtual 181	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   186: ishl
    //   187: istore 4
    //   189: aload 10
    //   191: astore 9
    //   193: aload 10
    //   195: astore 8
    //   197: iload_3
    //   198: istore 5
    //   200: aload 10
    //   202: aload 10
    //   204: ldc 183
    //   206: invokeinterface 167 2 0
    //   211: invokeinterface 171 2 0
    //   216: iload 4
    //   218: iand
    //   219: ifeq +8 -> 227
    //   222: iconst_m1
    //   223: istore_3
    //   224: goto -118 -> 106
    //   227: aload 10
    //   229: astore 9
    //   231: aload 10
    //   233: astore 8
    //   235: iload_3
    //   236: istore 5
    //   238: aload 10
    //   240: aload 10
    //   242: ldc 185
    //   244: invokeinterface 167 2 0
    //   249: invokeinterface 171 2 0
    //   254: istore 6
    //   256: iload 4
    //   258: iload 6
    //   260: iand
    //   261: ifeq -155 -> 106
    //   264: iconst_1
    //   265: istore_3
    //   266: goto -160 -> 106
    //   269: iload 4
    //   271: istore 5
    //   273: aload 10
    //   275: ifnull +221 -> 496
    //   278: iload 4
    //   280: istore_3
    //   281: aload 10
    //   283: astore 8
    //   285: aload 8
    //   287: invokeinterface 188 1 0
    //   292: iload_3
    //   293: ireturn
    //   294: astore_2
    //   295: goto +176 -> 471
    //   298: iload_1
    //   299: tableswitch	default:+97 -> 396, 10:+103->402, 11:+103->402, 12:+103->402, 13:+97->396, 14:+103->402, 15:+97->396, 16:+103->402, 17:+97->396, 18:+97->396, 19:+97->396, 20:+97->396, 21:+103->402, 22:+103->402, 23:+97->396, 24:+103->402, 25:+97->396, 26:+97->396, 27:+103->402, 28:+103->402, 29:+103->402, 30:+103->402
    //   397: iconst_2
    //   398: istore_3
    //   399: goto +13 -> 412
    //   402: aload 8
    //   404: astore 9
    //   406: aload_0
    //   407: iload_1
    //   408: invokespecial 190	com/tencent/token/anq:a	(I)I
    //   411: istore_3
    //   412: iload_3
    //   413: iconst_m1
    //   414: if_icmpne +17 -> 431
    //   417: aload 8
    //   419: ifnull +10 -> 429
    //   422: aload 8
    //   424: invokeinterface 188 1 0
    //   429: iload_3
    //   430: ireturn
    //   431: iload_1
    //   432: bipush 16
    //   434: if_icmpeq +51 -> 485
    //   437: iload_1
    //   438: bipush 13
    //   440: if_icmpeq +64 -> 504
    //   443: iload_1
    //   444: bipush 23
    //   446: if_icmpeq +6 -> 452
    //   449: goto +9 -> 458
    //   452: ldc 192
    //   454: astore_2
    //   455: goto +3 -> 458
    //   458: aload 8
    //   460: astore 9
    //   462: aload_0
    //   463: aload_2
    //   464: invokespecial 194	com/tencent/token/ant:a	(Ljava/lang/String;)I
    //   467: istore_3
    //   468: goto +17 -> 485
    //   471: aload 9
    //   473: ifnull +10 -> 483
    //   476: aload 9
    //   478: invokeinterface 188 1 0
    //   483: aload_2
    //   484: athrow
    //   485: iload_3
    //   486: istore 5
    //   488: aload 8
    //   490: ifnull +6 -> 496
    //   493: goto -208 -> 285
    //   496: iload 5
    //   498: ireturn
    //   499: astore 9
    //   501: goto -203 -> 298
    //   504: ldc 196
    //   506: astore_2
    //   507: goto -49 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	this	ant
    //   0	510	1	paramInt	int
    //   0	510	2	paramString	String
    //   16	470	3	j	int
    //   7	272	4	k	int
    //   19	478	5	m	int
    //   10	251	6	n	int
    //   13	45	7	i1	int
    //   4	485	8	localObject1	Object
    //   55	422	9	localObject2	Object
    //   499	1	9	localThrowable	Throwable
    //   99	183	10	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   61	101	294	finally
    //   120	130	294	finally
    //   144	163	294	finally
    //   174	189	294	finally
    //   200	222	294	finally
    //   238	256	294	finally
    //   406	412	294	finally
    //   462	468	294	finally
    //   61	101	499	java/lang/Throwable
    //   120	130	499	java/lang/Throwable
    //   144	163	499	java/lang/Throwable
    //   174	189	499	java/lang/Throwable
    //   200	222	499	java/lang/Throwable
    //   238	256	499	java/lang/Throwable
  }
  
  private int a(final Parcel paramParcel1, final Parcel paramParcel2)
  {
    this.h = -1;
    if (!this.g.tryLock()) {
      return -1;
    }
    paramParcel1 = new Runnable()
    {
      public final void run()
      {
        try
        {
          long l = System.currentTimeMillis();
          ant.this.g.lock();
          ant.this.f.transact(1, paramParcel1, paramParcel2, 0);
          ant.this.g.unlock();
          paramParcel2.readException();
          int i = paramParcel2.readInt();
          if (System.currentTimeMillis() - l < 200L)
          {
            if (i == 0) {
              ant.this.h = -1;
            } else {
              ant.this.h = 0;
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
    this.g.unlock();
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
    return this.h;
    throw paramParcel2;
  }
  
  private int a(String paramString)
  {
    Object localObject = this.f;
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
          this.f.transact(1, (Parcel)localObject, localParcel, 0);
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
  
  public final int a(int paramInt)
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
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ant
 * JD-Core Version:    0.7.0.1
 */