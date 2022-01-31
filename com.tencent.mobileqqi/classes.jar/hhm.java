import com.tencent.mobileqq.widget.QZoneCoverView;

public class hhm
  extends Thread
{
  public hhm(QZoneCoverView paramQZoneCoverView) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   7: getfield 27	com/tencent/mobileqq/widget/QZoneCoverView:d	Ljava/lang/String;
    //   10: astore 5
    //   12: invokestatic 33	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   15: aload 5
    //   17: invokestatic 38	cooperation/qzone/util/ImageFilePathUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_3
    //   21: aload_3
    //   22: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +36 -> 61
    //   28: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +29 -> 60
    //   34: ldc 52
    //   36: iconst_2
    //   37: new 54	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   44: ldc 57
    //   46: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 5
    //   51: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: return
    //   61: new 71	java/io/File
    //   64: dup
    //   65: aload_3
    //   66: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore 4
    //   71: aload 4
    //   73: invokevirtual 77	java/io/File:exists	()Z
    //   76: ifeq +13 -> 89
    //   79: aload 4
    //   81: invokevirtual 81	java/io/File:length	()J
    //   84: lconst_0
    //   85: lcmp
    //   86: ifgt +287 -> 373
    //   89: aload 5
    //   91: ldc 83
    //   93: invokevirtual 89	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   96: istore_1
    //   97: iload_1
    //   98: ifle +367 -> 465
    //   101: aload 5
    //   103: iconst_0
    //   104: iload_1
    //   105: invokevirtual 93	java/lang/String:substring	(II)Ljava/lang/String;
    //   108: astore_3
    //   109: aload_0
    //   110: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   113: getfield 96	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   116: aload_3
    //   117: aload 4
    //   119: invokestatic 101	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   122: istore_2
    //   123: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +37 -> 163
    //   129: ldc 52
    //   131: iconst_2
    //   132: new 54	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   139: ldc 103
    //   141: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: iload_2
    //   145: invokevirtual 106	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   148: ldc 108
    //   150: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_3
    //   154: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_0
    //   164: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   167: invokevirtual 112	com/tencent/mobileqq/widget/QZoneCoverView:getResources	()Landroid/content/res/Resources;
    //   170: ldc 113
    //   172: invokevirtual 119	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   175: astore_3
    //   176: iload_2
    //   177: ifeq +285 -> 462
    //   180: new 121	java/net/URL
    //   183: dup
    //   184: ldc 123
    //   186: ldc 125
    //   188: aload 5
    //   190: invokespecial 128	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   193: astore 4
    //   195: aload 4
    //   197: ifnull +265 -> 462
    //   200: aload_0
    //   201: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   204: getfield 131	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   207: ifnonnull +22 -> 229
    //   210: aload_0
    //   211: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   214: aload_0
    //   215: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   218: invokevirtual 112	com/tencent/mobileqq/widget/QZoneCoverView:getResources	()Landroid/content/res/Resources;
    //   221: ldc 132
    //   223: invokevirtual 119	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   226: putfield 131	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   229: aload_0
    //   230: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   233: getfield 131	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   236: ifnull +226 -> 462
    //   239: aload 4
    //   241: aload_0
    //   242: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   245: getfield 131	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   248: aload_3
    //   249: invokestatic 137	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/image/URLDrawable;
    //   252: astore_3
    //   253: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +38 -> 294
    //   259: ldc 52
    //   261: iconst_2
    //   262: new 54	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   269: ldc 139
    //   271: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_3
    //   275: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: ldc 144
    //   280: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 5
    //   285: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload_3
    //   295: ifnull -235 -> 60
    //   298: aload_0
    //   299: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   302: getfield 148	com/tencent/mobileqq/widget/QZoneCoverView:B	I
    //   305: iconst_2
    //   306: if_icmpeq +14 -> 320
    //   309: aload_0
    //   310: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   313: getfield 148	com/tencent/mobileqq/widget/QZoneCoverView:B	I
    //   316: iconst_5
    //   317: if_icmpne -257 -> 60
    //   320: aload 5
    //   322: aload_0
    //   323: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   326: getfield 27	com/tencent/mobileqq/widget/QZoneCoverView:d	Ljava/lang/String;
    //   329: invokestatic 153	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   332: ifeq -272 -> 60
    //   335: invokestatic 159	android/os/Message:obtain	()Landroid/os/Message;
    //   338: astore 4
    //   340: aload 4
    //   342: bipush 7
    //   344: putfield 162	android/os/Message:what	I
    //   347: aload 4
    //   349: aload_3
    //   350: putfield 166	android/os/Message:obj	Ljava/lang/Object;
    //   353: aload 4
    //   355: iconst_0
    //   356: putfield 169	android/os/Message:arg1	I
    //   359: aload_0
    //   360: getfield 10	hhm:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   363: getfield 172	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   366: aload 4
    //   368: invokevirtual 178	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   371: pop
    //   372: return
    //   373: iconst_1
    //   374: istore_2
    //   375: goto -212 -> 163
    //   378: astore_3
    //   379: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +13 -> 395
    //   385: ldc 52
    //   387: iconst_2
    //   388: aload_3
    //   389: invokevirtual 179	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   392: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aconst_null
    //   396: astore_3
    //   397: goto -221 -> 176
    //   400: astore_3
    //   401: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +13 -> 417
    //   407: ldc 52
    //   409: iconst_2
    //   410: aload_3
    //   411: invokevirtual 180	java/lang/Exception:toString	()Ljava/lang/String;
    //   414: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aconst_null
    //   418: astore_3
    //   419: goto -243 -> 176
    //   422: astore 7
    //   424: aload 6
    //   426: astore 4
    //   428: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq -236 -> 195
    //   434: ldc 52
    //   436: iconst_2
    //   437: aload 7
    //   439: invokevirtual 181	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   442: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload 6
    //   447: astore 4
    //   449: goto -254 -> 195
    //   452: astore 6
    //   454: aload 6
    //   456: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   459: goto -230 -> 229
    //   462: goto -209 -> 253
    //   465: aload 5
    //   467: astore_3
    //   468: goto -359 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	hhm
    //   96	9	1	i	int
    //   122	253	2	bool	boolean
    //   20	330	3	localObject1	java.lang.Object
    //   378	11	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   396	1	3	localObject2	java.lang.Object
    //   400	11	3	localException1	java.lang.Exception
    //   418	50	3	str1	java.lang.String
    //   69	379	4	localObject3	java.lang.Object
    //   10	456	5	str2	java.lang.String
    //   1	445	6	localObject4	java.lang.Object
    //   452	3	6	localException2	java.lang.Exception
    //   422	16	7	localMalformedURLException	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   163	176	378	java/lang/OutOfMemoryError
    //   163	176	400	java/lang/Exception
    //   180	195	422	java/net/MalformedURLException
    //   210	229	452	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hhm
 * JD-Core Version:    0.7.0.1
 */