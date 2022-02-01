import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class adae
  extends ContentObserver
{
  private static final String[] PROJECTION = { "_id", "address", "body", "date" };
  private static long preTime;
  adac a;
  Context context;
  
  public adae(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public adae(Handler paramHandler, long paramLong)
  {
    super(paramHandler);
    preTime = paramLong;
  }
  
  private void b(Context paramContext, adac paramadac)
  {
    this.context = paramContext;
    this.a = paramadac;
    try
    {
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(Context paramContext, adac paramadac)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
      } while ((!(paramContext instanceof BaseActivity)) || (!a((BaseActivity)paramContext, paramadac)));
      b(paramContext, paramadac);
    } while (!QLog.isColorLevel());
    QLog.d("sms.content", 2, "register...");
  }
  
  @TargetApi(23)
  public boolean a(BaseActivity paramBaseActivity, adac paramadac)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (paramBaseActivity.checkSelfPermission("android.permission.READ_SMS") != 0))
    {
      paramBaseActivity.requestPermissions(new adaf(this, paramBaseActivity, paramadac), 1, new String[] { "android.permission.READ_SMS" });
      return false;
    }
    return true;
  }
  
  /* Error */
  public void onChange(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 116	android/database/ContentObserver:onChange	(Z)V
    //   5: aload_0
    //   6: getfield 43	adae:context	Landroid/content/Context;
    //   9: ifnonnull +18 -> 27
    //   12: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 81
    //   20: iconst_2
    //   21: ldc 118
    //   23: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: return
    //   27: aload_0
    //   28: getfield 43	adae:context	Landroid/content/Context;
    //   31: invokevirtual 51	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   34: ldc 120
    //   36: invokestatic 59	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: getstatic 26	adae:PROJECTION	[Ljava/lang/String;
    //   42: aconst_null
    //   43: aconst_null
    //   44: ldc 122
    //   46: invokestatic 128	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +216 -> 269
    //   56: aload 5
    //   58: astore 4
    //   60: aload 5
    //   62: invokeinterface 133 1 0
    //   67: ifne +202 -> 269
    //   70: aload 5
    //   72: astore 4
    //   74: aload 5
    //   76: invokeinterface 136 1 0
    //   81: ifeq +188 -> 269
    //   84: aload 5
    //   86: astore 4
    //   88: aload 5
    //   90: aload 5
    //   92: ldc 20
    //   94: invokeinterface 139 2 0
    //   99: invokeinterface 143 2 0
    //   104: astore 6
    //   106: aload 5
    //   108: astore 4
    //   110: aload 5
    //   112: aload 5
    //   114: ldc 22
    //   116: invokeinterface 139 2 0
    //   121: invokeinterface 143 2 0
    //   126: astore 7
    //   128: aload 5
    //   130: astore 4
    //   132: aload 5
    //   134: aload 5
    //   136: ldc 24
    //   138: invokeinterface 139 2 0
    //   143: invokeinterface 147 2 0
    //   148: lstore_2
    //   149: aload 5
    //   151: astore 4
    //   153: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +63 -> 219
    //   159: aload 5
    //   161: astore 4
    //   163: ldc 81
    //   165: iconst_2
    //   166: new 149	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   173: ldc 153
    //   175: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 6
    //   180: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 159
    //   185: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 7
    //   190: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 161
    //   195: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: lload_2
    //   199: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: ldc 166
    //   204: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: getstatic 34	adae:preTime	J
    //   210: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload 5
    //   221: astore 4
    //   223: lload_2
    //   224: getstatic 34	adae:preTime	J
    //   227: lcmp
    //   228: iflt +41 -> 269
    //   231: aload 5
    //   233: astore 4
    //   235: aload_0
    //   236: getfield 45	adae:a	Ladac;
    //   239: ifnull +30 -> 269
    //   242: aload 5
    //   244: astore 4
    //   246: aload_0
    //   247: getfield 45	adae:a	Ladac;
    //   250: aload 6
    //   252: aload 7
    //   254: invokeinterface 176 3 0
    //   259: aload 5
    //   261: astore 4
    //   263: lconst_1
    //   264: lload_2
    //   265: ladd
    //   266: putstatic 34	adae:preTime	J
    //   269: aload 5
    //   271: ifnull -245 -> 26
    //   274: aload 5
    //   276: invokeinterface 179 1 0
    //   281: return
    //   282: astore 6
    //   284: aconst_null
    //   285: astore 5
    //   287: aload 5
    //   289: astore 4
    //   291: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +17 -> 311
    //   297: aload 5
    //   299: astore 4
    //   301: ldc 81
    //   303: iconst_2
    //   304: ldc 180
    //   306: aload 6
    //   308: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: aload 5
    //   313: ifnull -287 -> 26
    //   316: aload 5
    //   318: invokeinterface 179 1 0
    //   323: return
    //   324: astore 5
    //   326: aconst_null
    //   327: astore 4
    //   329: aload 4
    //   331: ifnull +10 -> 341
    //   334: aload 4
    //   336: invokeinterface 179 1 0
    //   341: aload 5
    //   343: athrow
    //   344: astore 5
    //   346: goto -17 -> 329
    //   349: astore 6
    //   351: goto -64 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	adae
    //   0	354	1	paramBoolean	boolean
    //   148	117	2	l	long
    //   58	277	4	localCursor1	android.database.Cursor
    //   49	268	5	localCursor2	android.database.Cursor
    //   324	18	5	localObject1	java.lang.Object
    //   344	1	5	localObject2	java.lang.Object
    //   104	147	6	str1	String
    //   282	25	6	localException1	Exception
    //   349	1	6	localException2	Exception
    //   126	127	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   27	51	282	java/lang/Exception
    //   27	51	324	finally
    //   60	70	344	finally
    //   74	84	344	finally
    //   88	106	344	finally
    //   110	128	344	finally
    //   132	149	344	finally
    //   153	159	344	finally
    //   163	219	344	finally
    //   223	231	344	finally
    //   235	242	344	finally
    //   246	259	344	finally
    //   263	269	344	finally
    //   291	297	344	finally
    //   301	311	344	finally
    //   60	70	349	java/lang/Exception
    //   74	84	349	java/lang/Exception
    //   88	106	349	java/lang/Exception
    //   110	128	349	java/lang/Exception
    //   132	149	349	java/lang/Exception
    //   153	159	349	java/lang/Exception
    //   163	219	349	java/lang/Exception
    //   223	231	349	java/lang/Exception
    //   235	242	349	java/lang/Exception
    //   246	259	349	java/lang/Exception
    //   263	269	349	java/lang/Exception
  }
  
  public void unregister()
  {
    if (this.context != null)
    {
      this.context.getContentResolver().unregisterContentObserver(this);
      if (QLog.isColorLevel()) {
        QLog.d("sms.content", 2, "unregister...");
      }
      this.context = null;
    }
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adae
 * JD-Core Version:    0.7.0.1
 */