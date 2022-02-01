import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

public class dfk
  extends AccountObserver
{
  public dfk(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "RegisterPhoneNumActivity.onRegQueryAccountResp isSuccess=" + paramBoolean + " code=" + paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterPhoneNumActivity", 2, "RegisterPhoneNumActivity onRegQueryAccountResp");
    }
    if (this.a.isFinishing()) {
      return;
    }
    Object localObject;
    if (!paramBoolean)
    {
      this.a.g();
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        localObject = paramArrayOfByte;
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          localObject = this.a.getString(2131561658);
        }
        this.a.a((String)localObject, 1);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
      }
    }
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("RegisterPhoneNumActivity", 2, "RegisterPhoneNumActivity onRegQueryAccountResp code = " + paramInt + ";strMsg = " + paramArrayOfByte);
          }
          switch (paramInt)
          {
          case 4: 
          default: 
            this.a.g();
            localObject = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              localObject = this.a.getResources().getString(2131561658);
            }
            this.a.a((String)localObject, 1);
            return;
          }
        }
        catch (Exception localException2)
        {
          break label270;
        }
        localException1 = localException1;
        paramArrayOfByte = null;
      }
      label270:
      continue;
      RegisterPhoneNumActivity.c(this.a);
      return;
      this.a.g();
      RegisterPhoneNumActivity.a(this.a, this.a.getResources().getString(2131562739), this.a.getResources().getString(2131563149));
      return;
      this.a.g();
      RegisterVerifyCodeActivity.a(this.a.b, this.a, this.a.c, this.a.d, this.a.e, "");
      this.a.finish();
      return;
      this.a.g();
      RegisterVerifyCodeActivity.a(this.a.b, this.a, this.a.c, this.a.d, this.a.e, "");
      this.a.finish();
      return;
      this.a.g();
      if (!TextUtils.isEmpty(paramArrayOfByte))
      {
        this.a.a(null, LocaleString.f(this.a, paramArrayOfByte));
        return;
      }
      paramArrayOfByte = this.a.getString(2131563059);
      this.a.a(null, paramArrayOfByte);
      return;
      paramArrayOfByte = null;
    }
  }
  
  /* Error */
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +11 -> 20
    //   12: ldc 55
    //   14: iconst_2
    //   15: ldc 145
    //   17: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: aload_3
    //   21: ifnull +344 -> 365
    //   24: new 67	java/lang/String
    //   27: dup
    //   28: aload_3
    //   29: ldc 69
    //   31: invokespecial 72	java/lang/String:<init>	([BLjava/lang/String;)V
    //   34: astore 5
    //   36: aload 5
    //   38: astore 6
    //   40: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +42 -> 85
    //   46: ldc 55
    //   48: iconst_2
    //   49: new 30	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   56: ldc 147
    //   58: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_2
    //   62: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 93
    //   67: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload 5
    //   72: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload 5
    //   83: astore 6
    //   85: aload_0
    //   86: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   89: invokevirtual 62	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:isFinishing	()Z
    //   92: ifeq +21 -> 113
    //   95: return
    //   96: astore 6
    //   98: aconst_null
    //   99: astore 5
    //   101: aload 6
    //   103: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   106: aload 5
    //   108: astore 6
    //   110: goto -25 -> 85
    //   113: iload_2
    //   114: iconst_3
    //   115: if_icmpeq +10 -> 125
    //   118: aload_0
    //   119: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   122: invokevirtual 65	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:g	()V
    //   125: iload_1
    //   126: ifne +34 -> 160
    //   129: aload 6
    //   131: astore_3
    //   132: aload 6
    //   134: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifeq +13 -> 150
    //   140: aload_0
    //   141: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   144: ldc 79
    //   146: invokevirtual 83	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:getString	(I)Ljava/lang/String;
    //   149: astore_3
    //   150: aload_0
    //   151: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   154: aload_3
    //   155: iconst_1
    //   156: invokevirtual 86	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(Ljava/lang/String;I)V
    //   159: return
    //   160: iconst_0
    //   161: tableswitch	default:+31 -> 192, 0:+42->203, 1:+135->296, 2:+50->211, 3:+143->304
    //   193: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   196: ldc 79
    //   198: iconst_1
    //   199: invokevirtual 150	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(II)V
    //   202: return
    //   203: aload_0
    //   204: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   207: invokevirtual 153	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:s_	()V
    //   210: return
    //   211: new 67	java/lang/String
    //   214: dup
    //   215: aload 4
    //   217: ldc 69
    //   219: invokespecial 72	java/lang/String:<init>	([BLjava/lang/String;)V
    //   222: astore 4
    //   224: new 67	java/lang/String
    //   227: dup
    //   228: aload_3
    //   229: ldc 69
    //   231: invokespecial 72	java/lang/String:<init>	([BLjava/lang/String;)V
    //   234: astore_3
    //   235: aload 4
    //   237: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   240: ifne +10 -> 250
    //   243: aload_3
    //   244: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifeq +38 -> 285
    //   250: aload_0
    //   251: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   254: ldc 79
    //   256: iconst_1
    //   257: invokevirtual 150	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(II)V
    //   260: return
    //   261: astore 4
    //   263: aload 4
    //   265: invokevirtual 89	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   268: aconst_null
    //   269: astore 4
    //   271: goto -47 -> 224
    //   274: astore_3
    //   275: aload_3
    //   276: invokevirtual 89	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   279: aload 7
    //   281: astore_3
    //   282: goto -47 -> 235
    //   285: aload_0
    //   286: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   289: aload 4
    //   291: aload_3
    //   292: invokestatic 155	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:b	(Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;Ljava/lang/String;Ljava/lang/String;)V
    //   295: return
    //   296: aload_0
    //   297: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   300: invokevirtual 153	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:s_	()V
    //   303: return
    //   304: new 67	java/lang/String
    //   307: dup
    //   308: aload_3
    //   309: ldc 69
    //   311: invokespecial 72	java/lang/String:<init>	([BLjava/lang/String;)V
    //   314: astore_3
    //   315: aload_3
    //   316: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   319: ifeq +25 -> 344
    //   322: aload_0
    //   323: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   326: ldc 79
    //   328: iconst_1
    //   329: invokevirtual 150	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(II)V
    //   332: return
    //   333: astore_3
    //   334: aload_3
    //   335: invokevirtual 89	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   338: aload 8
    //   340: astore_3
    //   341: goto -26 -> 315
    //   344: aload_0
    //   345: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   348: aload_3
    //   349: invokestatic 158	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;Ljava/lang/String;)V
    //   352: aload_0
    //   353: getfield 10	dfk:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   356: invokevirtual 65	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:g	()V
    //   359: return
    //   360: astore 6
    //   362: goto -261 -> 101
    //   365: aconst_null
    //   366: astore 5
    //   368: goto -332 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	dfk
    //   0	371	1	paramBoolean	boolean
    //   0	371	2	paramInt	int
    //   0	371	3	paramArrayOfByte1	byte[]
    //   0	371	4	paramArrayOfByte2	byte[]
    //   34	333	5	str1	String
    //   38	46	6	str2	String
    //   96	6	6	localException1	Exception
    //   108	25	6	str3	String
    //   360	1	6	localException2	Exception
    //   4	276	7	localObject1	Object
    //   1	338	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	36	96	java/lang/Exception
    //   211	224	261	java/io/UnsupportedEncodingException
    //   224	235	274	java/io/UnsupportedEncodingException
    //   304	315	333	java/io/UnsupportedEncodingException
    //   40	81	360	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dfk
 * JD-Core Version:    0.7.0.1
 */