import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class tur
  extends AccountObserver
{
  public tur(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  /* Error */
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +37 -> 43
    //   9: ldc 28
    //   11: iconst_2
    //   12: new 30	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   19: ldc 33
    //   21: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_1
    //   25: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: ldc 42
    //   30: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   47: invokevirtual 58	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:isFinishing	()Z
    //   50: ifeq +4 -> 54
    //   53: return
    //   54: iload_1
    //   55: ifne +68 -> 123
    //   58: aload_0
    //   59: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   62: invokevirtual 61	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:c	()V
    //   65: aload_3
    //   66: ifnull +453 -> 519
    //   69: new 63	java/lang/String
    //   72: dup
    //   73: aload_3
    //   74: ldc 65
    //   76: invokespecial 68	java/lang/String:<init>	([BLjava/lang/String;)V
    //   79: astore_3
    //   80: aload_3
    //   81: astore 6
    //   83: aload_3
    //   84: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifeq +14 -> 101
    //   90: aload_0
    //   91: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   94: ldc 75
    //   96: invokevirtual 79	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:getString	(I)Ljava/lang/String;
    //   99: astore 6
    //   101: aload_0
    //   102: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   105: aload 6
    //   107: iconst_0
    //   108: invokevirtual 82	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(Ljava/lang/String;I)V
    //   111: return
    //   112: astore_3
    //   113: aload_3
    //   114: invokevirtual 85	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   117: aload 6
    //   119: astore_3
    //   120: goto -40 -> 80
    //   123: aload_3
    //   124: ifnull +390 -> 514
    //   127: new 63	java/lang/String
    //   130: dup
    //   131: aload_3
    //   132: ldc 65
    //   134: invokespecial 68	java/lang/String:<init>	([BLjava/lang/String;)V
    //   137: astore_3
    //   138: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +37 -> 178
    //   144: ldc 87
    //   146: iconst_2
    //   147: new 30	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   154: ldc 89
    //   156: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload_2
    //   160: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc 91
    //   165: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_3
    //   169: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload_3
    //   179: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifne +56 -> 238
    //   185: aload_3
    //   186: ldc 93
    //   188: invokevirtual 97	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   191: istore 4
    //   193: aload_3
    //   194: ldc 99
    //   196: invokevirtual 97	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   199: istore 5
    //   201: iload 4
    //   203: ifle +35 -> 238
    //   206: iload 5
    //   208: ifle +30 -> 238
    //   211: iload 4
    //   213: iconst_1
    //   214: iadd
    //   215: iload 5
    //   217: if_icmpge +21 -> 238
    //   220: aload_0
    //   221: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   224: aload_3
    //   225: iload 4
    //   227: iconst_1
    //   228: iadd
    //   229: iload 5
    //   231: invokevirtual 103	java/lang/String:substring	(II)Ljava/lang/String;
    //   234: invokestatic 106	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;Ljava/lang/String;)Ljava/lang/String;
    //   237: pop
    //   238: iload_2
    //   239: tableswitch	default:+37 -> 276, 0:+91->330, 1:+108->347, 2:+132->371, 3:+185->424, 4:+37->276, 5:+238->477
    //   277: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   280: invokevirtual 61	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:c	()V
    //   283: aload_3
    //   284: astore 6
    //   286: aload_3
    //   287: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   290: ifeq +17 -> 307
    //   293: aload_0
    //   294: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   297: invokevirtual 110	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:getResources	()Landroid/content/res/Resources;
    //   300: ldc 75
    //   302: invokevirtual 113	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   305: astore 6
    //   307: aload_0
    //   308: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   311: aload 6
    //   313: iconst_0
    //   314: invokevirtual 82	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(Ljava/lang/String;I)V
    //   317: return
    //   318: astore 6
    //   320: aconst_null
    //   321: astore_3
    //   322: aload 6
    //   324: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   327: goto -89 -> 238
    //   330: aload_0
    //   331: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   334: iconst_0
    //   335: putfield 118	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:jdField_b_of_type_Boolean	Z
    //   338: aload_0
    //   339: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   342: aconst_null
    //   343: invokestatic 121	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;Ljava/lang/String;)V
    //   346: return
    //   347: aload_0
    //   348: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   351: invokevirtual 61	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:c	()V
    //   354: aload_0
    //   355: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   358: iconst_1
    //   359: putfield 118	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:jdField_b_of_type_Boolean	Z
    //   362: aload_0
    //   363: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   366: aconst_null
    //   367: invokestatic 121	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;Ljava/lang/String;)V
    //   370: return
    //   371: aload_0
    //   372: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   375: invokevirtual 61	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:c	()V
    //   378: aload_0
    //   379: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   382: getfield 125	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   385: aload_0
    //   386: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   389: aload_0
    //   390: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   393: getfield 128	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   396: aload_0
    //   397: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   400: getfield 130	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   403: ldc 132
    //   405: aload_0
    //   406: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   409: getfield 118	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:jdField_b_of_type_Boolean	Z
    //   412: iconst_0
    //   413: invokestatic 137	com/tencent/mobileqq/activity/RegisterPersonalInfoActivity:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
    //   416: aload_0
    //   417: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   420: invokevirtual 140	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:finish	()V
    //   423: return
    //   424: aload_0
    //   425: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   428: invokevirtual 61	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:c	()V
    //   431: aload_0
    //   432: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   435: getfield 125	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   438: aload_0
    //   439: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   442: aload_0
    //   443: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   446: getfield 128	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   449: aload_0
    //   450: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   453: getfield 130	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   456: ldc 132
    //   458: aload_0
    //   459: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   462: getfield 118	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:jdField_b_of_type_Boolean	Z
    //   465: iconst_0
    //   466: invokestatic 137	com/tencent/mobileqq/activity/RegisterPersonalInfoActivity:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
    //   469: aload_0
    //   470: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   473: invokevirtual 140	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:finish	()V
    //   476: return
    //   477: aload_0
    //   478: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   481: invokevirtual 61	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:c	()V
    //   484: aload_0
    //   485: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   488: iconst_1
    //   489: putfield 118	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:jdField_b_of_type_Boolean	Z
    //   492: aload_0
    //   493: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   496: iconst_0
    //   497: putfield 142	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:c	Z
    //   500: aload_0
    //   501: getfield 10	tur:a	Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;
    //   504: aconst_null
    //   505: invokestatic 121	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(Lcom/tencent/mobileqq/activity/RegisterPhoneNumActivity;Ljava/lang/String;)V
    //   508: return
    //   509: astore 6
    //   511: goto -189 -> 322
    //   514: aconst_null
    //   515: astore_3
    //   516: goto -378 -> 138
    //   519: aconst_null
    //   520: astore_3
    //   521: goto -441 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	tur
    //   0	524	1	paramBoolean	boolean
    //   0	524	2	paramInt	int
    //   0	524	3	paramArrayOfByte	byte[]
    //   191	38	4	i	int
    //   199	31	5	j	int
    //   1	311	6	localObject	java.lang.Object
    //   318	5	6	localException1	Exception
    //   509	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   69	80	112	java/io/UnsupportedEncodingException
    //   127	138	318	java/lang/Exception
    //   138	178	509	java/lang/Exception
    //   178	201	509	java/lang/Exception
    //   220	238	509	java/lang/Exception
  }
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterPhoneNumActivity", 2, "RegisterPhoneNumActivity onRegisterCommitMobileResp");
    }
    if (paramArrayOfByte1 != null) {}
    label138:
    for (;;)
    {
      try
      {
        paramArrayOfByte2 = new String(paramArrayOfByte1, "utf-8");
        arrayOfByte = paramArrayOfByte2;
        arrayOfByte = paramArrayOfByte2;
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("RegisterPhoneNumActivity", 2, "RegisterPhoneNumActivity onRegisterCommitMobileResp code = " + paramInt + ";strMsg = " + paramArrayOfByte2);
            arrayOfByte = paramArrayOfByte2;
          }
          if (!this.a.isFinishing()) {
            break label138;
          }
          return;
        }
        catch (Exception localException2)
        {
          byte[] arrayOfByte;
          break label95;
        }
        localException1 = localException1;
        paramArrayOfByte2 = null;
      }
      label95:
      if (QLog.isColorLevel())
      {
        QLog.d("RegisterPhoneNumActivity", 2, "RegisterPhoneNumActivity onRegisterCommitMobileResp strPromptInfo exception = " + localException1);
        arrayOfByte = paramArrayOfByte2;
        continue;
        if (paramInt != 3) {
          this.a.c();
        }
        if (!paramBoolean)
        {
          paramArrayOfByte1 = arrayOfByte;
          if (TextUtils.isEmpty(arrayOfByte)) {
            paramArrayOfByte1 = this.a.getString(2131434231);
          }
          this.a.a(paramArrayOfByte1, 0);
          return;
        }
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          this.a.a(2131434231, 0);
          return;
        case 0: 
          this.a.a(0, 0L);
          return;
        case 2: 
          if ((TextUtils.isEmpty(arrayOfByte)) || (TextUtils.isEmpty(arrayOfByte)))
          {
            this.a.a(2131434231, 0);
            return;
          }
          RegisterPhoneNumActivity.b(this.a, arrayOfByte);
          return;
        case 1: 
          this.a.a(0, 0L);
          return;
        case 3: 
          if (TextUtils.isEmpty(arrayOfByte))
          {
            this.a.a(2131434231, 0);
            return;
          }
          RegisterPhoneNumActivity.c(this.a, arrayOfByte);
          this.a.c();
          return;
        case 4: 
          if (paramArrayOfByte1 != null)
          {
            try
            {
              paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
              if (!TextUtils.isEmpty(paramArrayOfByte1))
              {
                this.a.jdField_a_of_type_AndroidOsHandler.post(new tus(this, paramArrayOfByte1));
                return;
              }
            }
            catch (Throwable paramArrayOfByte1)
            {
              paramArrayOfByte1.printStackTrace();
              return;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("RegisterPhoneNumActivity", 2, "captcha url is empty");
              return;
            }
          }
          break;
        case 7: 
          paramArrayOfByte1 = new Intent(this.a, RegisterQQNumberActivity.class);
          paramArrayOfByte1.putExtra("phonenum", this.a.jdField_a_of_type_JavaLangString);
          paramArrayOfByte1.putExtra("key", this.a.jdField_b_of_type_JavaLangString);
          paramArrayOfByte1.putExtra("key_register_is_phone_num_registered", this.a.jdField_b_of_type_Boolean);
          paramArrayOfByte1.putExtra("key_register_has_pwd", this.a.c);
          paramArrayOfByte1.putExtra("key_register_result", false);
          this.a.startActivity(paramArrayOfByte1);
          return;
          paramArrayOfByte2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tur
 * JD-Core Version:    0.7.0.1
 */