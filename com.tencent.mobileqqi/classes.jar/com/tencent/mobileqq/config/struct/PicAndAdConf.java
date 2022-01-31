package com.tencent.mobileqq.config.struct;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigListener;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fmx;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class PicAndAdConf
  extends BaseConf
  implements ImgConfHandler
{
  public static final String a = "ShanPing";
  public static final String b = "qq_config_pic";
  public static final int i = 1;
  private HashSet a;
  public boolean a;
  
  public PicAndAdConf(short paramShort, byte paramByte)
  {
    super(paramShort, paramByte);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (!paramFile.isFile()) {
        break label25;
      }
      paramFile.delete();
    }
    for (;;)
    {
      paramFile.delete();
      return;
      label25:
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile == null) {
          break;
        }
        int j = 0;
        while (j < arrayOfFile.length)
        {
          a(arrayOfFile[j]);
          j += 1;
        }
      }
    }
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 28	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_2
    //   13: invokevirtual 32	java/io/File:exists	()Z
    //   16: ifne +86 -> 102
    //   19: aload_2
    //   20: invokevirtual 56	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: new 58	java/io/FileOutputStream
    //   27: dup
    //   28: aload_2
    //   29: iconst_1
    //   30: invokespecial 61	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   33: astore_2
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 65	java/io/FileOutputStream:write	([B)V
    //   39: aload_2
    //   40: invokevirtual 69	java/io/FileOutputStream:flush	()V
    //   43: aload_2
    //   44: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   47: invokestatic 78	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   50: ldc 80
    //   52: iconst_0
    //   53: invokevirtual 86	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   56: invokeinterface 92 1 0
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 94
    //   65: lload_3
    //   66: invokeinterface 100 4 0
    //   71: pop
    //   72: aload_1
    //   73: invokeinterface 103 1 0
    //   78: pop
    //   79: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +11 -> 93
    //   85: ldc 10
    //   87: iconst_2
    //   88: ldc 110
    //   90: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   101: return
    //   102: aload_2
    //   103: invokevirtual 38	java/io/File:delete	()Z
    //   106: pop
    //   107: aload_2
    //   108: invokevirtual 56	java/io/File:createNewFile	()Z
    //   111: pop
    //   112: goto -88 -> 24
    //   115: astore_1
    //   116: aload 5
    //   118: astore_1
    //   119: aload_1
    //   120: ifnull -19 -> 101
    //   123: aload_1
    //   124: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   127: return
    //   128: astore_1
    //   129: return
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_2
    //   134: ifnull +7 -> 141
    //   137: aload_2
    //   138: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: return
    //   145: astore_2
    //   146: goto -5 -> 141
    //   149: astore_1
    //   150: goto -17 -> 133
    //   153: astore_1
    //   154: aload_2
    //   155: astore_1
    //   156: goto -37 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	PicAndAdConf
    //   0	159	1	paramArrayOfByte	byte[]
    //   0	159	2	paramString	String
    //   0	159	3	paramLong	long
    //   10	107	5	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   12	24	115	java/lang/Exception
    //   24	34	115	java/lang/Exception
    //   102	112	115	java/lang/Exception
    //   123	127	128	java/lang/Exception
    //   12	24	130	finally
    //   24	34	130	finally
    //   102	112	130	finally
    //   97	101	143	java/lang/Exception
    //   137	141	145	java/lang/Exception
    //   34	93	149	finally
    //   34	93	153	java/lang/Exception
  }
  
  /* Error */
  private boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iconst_1
    //   7: istore_3
    //   8: new 28	java/io/File
    //   11: dup
    //   12: new 119	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   19: invokestatic 78	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   22: invokevirtual 125	android/content/Context:getFilesDir	()Ljava/io/File;
    //   25: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 135
    //   33: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 6
    //   44: new 28	java/io/File
    //   47: dup
    //   48: new 119	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   55: invokestatic 78	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   58: invokevirtual 125	android/content/Context:getFilesDir	()Ljava/io/File;
    //   61: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 140
    //   69: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_2
    //   73: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_2
    //   83: aload 6
    //   85: invokevirtual 32	java/io/File:exists	()Z
    //   88: ifne +9 -> 97
    //   91: aload 6
    //   93: invokevirtual 143	java/io/File:mkdirs	()Z
    //   96: pop
    //   97: aload_2
    //   98: invokevirtual 32	java/io/File:exists	()Z
    //   101: ifne +45 -> 146
    //   104: aload_2
    //   105: invokevirtual 56	java/io/File:createNewFile	()Z
    //   108: pop
    //   109: new 58	java/io/FileOutputStream
    //   112: dup
    //   113: aload_2
    //   114: iconst_1
    //   115: invokespecial 61	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   118: astore_2
    //   119: aload_2
    //   120: aload_1
    //   121: invokevirtual 65	java/io/FileOutputStream:write	([B)V
    //   124: aload_2
    //   125: invokevirtual 69	java/io/FileOutputStream:flush	()V
    //   128: aload_2
    //   129: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   132: iconst_0
    //   133: ifeq +11 -> 144
    //   136: new 145	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 146	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: iload_3
    //   145: ireturn
    //   146: aload_2
    //   147: invokevirtual 38	java/io/File:delete	()Z
    //   150: pop
    //   151: aload_2
    //   152: invokevirtual 56	java/io/File:createNewFile	()Z
    //   155: pop
    //   156: goto -47 -> 109
    //   159: astore_1
    //   160: aload 4
    //   162: astore_1
    //   163: iconst_0
    //   164: istore_3
    //   165: aload_1
    //   166: ifnull -22 -> 144
    //   169: aload_1
    //   170: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   187: iconst_1
    //   188: ireturn
    //   189: astore_1
    //   190: aload 5
    //   192: astore_2
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   201: aload_1
    //   202: athrow
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   208: goto -7 -> 201
    //   211: astore_1
    //   212: goto -19 -> 193
    //   215: astore_1
    //   216: aload_2
    //   217: astore_1
    //   218: goto -55 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	PicAndAdConf
    //   0	221	1	paramArrayOfByte	byte[]
    //   0	221	2	paramString	String
    //   7	158	3	bool	boolean
    //   4	157	4	localObject1	java.lang.Object
    //   1	190	5	localObject2	java.lang.Object
    //   42	50	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   83	97	159	java/lang/Exception
    //   97	109	159	java/lang/Exception
    //   109	119	159	java/lang/Exception
    //   146	156	159	java/lang/Exception
    //   169	173	175	java/io/IOException
    //   136	144	182	java/io/IOException
    //   83	97	189	finally
    //   97	109	189	finally
    //   109	119	189	finally
    //   146	156	189	finally
    //   197	201	203	java/io/IOException
    //   119	132	211	finally
    //   119	132	215	java/lang/Exception
  }
  
  public long a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0L;
    }
    fmx localfmx = (fmx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    switch (this.a_)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 8: 
    case 9: 
    default: 
      return 0L;
    case 6: 
    case 10: 
      return localfmx.jdField_a_of_type_Long;
    }
    return localfmx.jdField_a_of_type_Long & 0xFFFFFFFF | this.jdField_a_of_type_Short << 32;
  }
  
  /* Error */
  public android.graphics.Bitmap a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore 4
    //   8: iload_1
    //   9: iflt +17 -> 26
    //   12: iload_1
    //   13: aload_0
    //   14: getfield 153	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: invokevirtual 159	java/util/ArrayList:size	()I
    //   20: if_icmplt +9 -> 29
    //   23: aload_3
    //   24: astore 4
    //   26: aload 4
    //   28: areturn
    //   29: aload_0
    //   30: getfield 153	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   33: iload_1
    //   34: invokevirtual 163	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   37: checkcast 165	fmx
    //   40: astore 6
    //   42: aload 6
    //   44: getfield 182	fmx:jdField_a_of_type_Byte	B
    //   47: istore_2
    //   48: aload_3
    //   49: astore 4
    //   51: iload_2
    //   52: tableswitch	default:+28 -> 80, 1:+30->82, 2:+-26->26, 3:+41->93
    //   81: areturn
    //   82: aload 6
    //   84: getfield 184	fmx:b	Ljava/lang/String;
    //   87: invokestatic 189	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   90: astore_3
    //   91: aload_3
    //   92: areturn
    //   93: aload_0
    //   94: getfield 153	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   97: iload_1
    //   98: invokevirtual 163	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   101: checkcast 165	fmx
    //   104: getfield 192	fmx:jdField_a_of_type_ArrayOfByte	[B
    //   107: astore 7
    //   109: aload_0
    //   110: getfield 153	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   113: iload_1
    //   114: invokevirtual 163	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   117: checkcast 165	fmx
    //   120: getfield 195	fmx:c	Ljava/lang/String;
    //   123: astore 4
    //   125: aload 4
    //   127: ifnull +31 -> 158
    //   130: aload_0
    //   131: getfield 169	com/tencent/mobileqq/config/struct/PicAndAdConf:a_	B
    //   134: iconst_1
    //   135: if_icmpne +23 -> 158
    //   138: aload_0
    //   139: invokevirtual 197	com/tencent/mobileqq/config/struct/PicAndAdConf:a	()Z
    //   142: ifne +16 -> 158
    //   145: aload_0
    //   146: invokevirtual 199	com/tencent/mobileqq/config/struct/PicAndAdConf:b	()Z
    //   149: ifne +9 -> 158
    //   152: aload 4
    //   154: invokestatic 189	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   157: areturn
    //   158: aload 4
    //   160: ifnull +74 -> 234
    //   163: aload_0
    //   164: getfield 169	com/tencent/mobileqq/config/struct/PicAndAdConf:a_	B
    //   167: ifne +67 -> 234
    //   170: new 28	java/io/File
    //   173: dup
    //   174: aload 4
    //   176: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: invokevirtual 32	java/io/File:exists	()Z
    //   182: ifeq +38 -> 220
    //   185: aload 4
    //   187: invokestatic 204	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   190: astore_3
    //   191: aload_3
    //   192: ifnonnull +115 -> 307
    //   195: aload 6
    //   197: getfield 205	fmx:jdField_a_of_type_Boolean	Z
    //   200: ifeq +107 -> 307
    //   203: aload 6
    //   205: iconst_0
    //   206: putfield 205	fmx:jdField_a_of_type_Boolean	Z
    //   209: aload_0
    //   210: aload 6
    //   212: getfield 184	fmx:b	Ljava/lang/String;
    //   215: invokevirtual 207	com/tencent/mobileqq/config/struct/PicAndAdConf:a_	(Ljava/lang/String;)V
    //   218: aload_3
    //   219: areturn
    //   220: aload_0
    //   221: aload 6
    //   223: getfield 184	fmx:b	Ljava/lang/String;
    //   226: invokevirtual 207	com/tencent/mobileqq/config/struct/PicAndAdConf:a_	(Ljava/lang/String;)V
    //   229: aconst_null
    //   230: astore_3
    //   231: goto -13 -> 218
    //   234: aload_3
    //   235: astore 4
    //   237: aload 7
    //   239: ifnull -213 -> 26
    //   242: aload 7
    //   244: arraylength
    //   245: istore_1
    //   246: aload_3
    //   247: astore 4
    //   249: iload_1
    //   250: ifle -224 -> 26
    //   253: aload 7
    //   255: iconst_0
    //   256: aload 7
    //   258: arraylength
    //   259: invokestatic 211	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   262: astore_3
    //   263: aload_3
    //   264: areturn
    //   265: astore 4
    //   267: aload 5
    //   269: astore_3
    //   270: aload 4
    //   272: astore 5
    //   274: aload_3
    //   275: astore 4
    //   277: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq -254 -> 26
    //   283: ldc 213
    //   285: iconst_2
    //   286: aload 5
    //   288: invokestatic 219	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   291: invokestatic 222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload_3
    //   295: areturn
    //   296: astore 5
    //   298: goto -24 -> 274
    //   301: astore_3
    //   302: aconst_null
    //   303: areturn
    //   304: astore_3
    //   305: aconst_null
    //   306: areturn
    //   307: goto -89 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	PicAndAdConf
    //   0	310	1	paramInt	int
    //   47	5	2	j	int
    //   4	291	3	localObject1	java.lang.Object
    //   301	1	3	localException	Exception
    //   304	1	3	localThrowable1	java.lang.Throwable
    //   6	242	4	localObject2	java.lang.Object
    //   265	6	4	localThrowable2	java.lang.Throwable
    //   275	1	4	localObject3	java.lang.Object
    //   1	286	5	localObject4	java.lang.Object
    //   296	1	5	localThrowable3	java.lang.Throwable
    //   40	182	6	localfmx	fmx
    //   107	150	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   29	48	265	java/lang/Throwable
    //   82	91	265	java/lang/Throwable
    //   93	125	265	java/lang/Throwable
    //   130	158	265	java/lang/Throwable
    //   163	191	265	java/lang/Throwable
    //   220	229	265	java/lang/Throwable
    //   242	246	265	java/lang/Throwable
    //   195	218	296	java/lang/Throwable
    //   82	91	301	java/lang/Exception
    //   253	263	304	java/lang/Throwable
  }
  
  public fmx a(long paramLong, String paramString1, byte paramByte, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort)
  {
    fmx localfmx = new fmx(this);
    localfmx.jdField_a_of_type_Long = paramLong;
    localfmx.jdField_a_of_type_JavaLangString = paramString1;
    localfmx.b = paramString2;
    localfmx.d = paramString3;
    localfmx.jdField_a_of_type_Byte = paramByte;
    localfmx.c = paramString4;
    localfmx.e = paramString5;
    localfmx.jdField_a_of_type_Short = paramShort;
    return localfmx;
  }
  
  public fmx a(long paramLong, String paramString1, byte paramByte, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    fmx localfmx = new fmx(this);
    localfmx.jdField_a_of_type_Long = paramLong;
    localfmx.jdField_a_of_type_JavaLangString = paramString1;
    localfmx.b = paramString2;
    localfmx.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localfmx.d = paramString3;
    localfmx.jdField_a_of_type_Byte = paramByte;
    return localfmx;
  }
  
  public fmx a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort)
  {
    return a(paramLong, paramString1, (byte)3, paramString2, paramString3, paramString4, paramString5, paramShort);
  }
  
  public fmx a(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    return a(paramLong, paramString1, (byte)3, paramString2, paramArrayOfByte, paramString3);
  }
  
  public String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return "";
    }
    return ((fmx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString, byte paramByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = paramString;
    switch (paramByte)
    {
    default: 
      str = paramString;
    }
    for (;;)
    {
      paramString = str;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShanPing", 2, "flashlogo final request url = " + str);
      return str;
      str = paramString;
      if (!paramString.startsWith("/"))
      {
        str = "/" + paramString;
        continue;
        if ((paramString.startsWith("http://")) && (!paramString.endsWith(".png")))
        {
          if (this.a_ == 6) {
            str = paramString + "_" + Config.av + "_" + Config.au + ".png";
          } else if (this.a_ == 0) {
            str = paramString + "_" + (Config.au - 2) + ".png";
          } else if ((this.a_ == 1) && (paramString.contains("[]"))) {
            str = paramString.replace("[]", DeviceInfoUtil.f() + "x" + DeviceInfoUtil.g());
          } else {
            str = paramString + "_" + Config.au + ".png";
          }
        }
        else
        {
          str = paramString;
          if (paramString.startsWith("http://"))
          {
            str = paramString;
            if (this.a_ == 1)
            {
              str = paramString;
              if (paramString.contains("[]")) {
                str = paramString.replace("[]", DeviceInfoUtil.f() + "x" + DeviceInfoUtil.g());
              }
            }
          }
        }
      }
    }
  }
  
  public short a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return -1;
    }
    return ((fmx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Short;
  }
  
  public void a()
  {
    a(true);
    long l = this.c;
    this.b = -1L;
    this.c = -1L;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    switch (this.a_)
    {
    }
    for (;;)
    {
      return;
      c();
      return;
      File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png");
      try
      {
        if (localFile.exists())
        {
          localFile.delete();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if ((paramHttpMsg1 == null) || (paramHttpMsg2 == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "flashlogo request huibao decode ");
    }
    a(paramHttpMsg1.a(), paramHttpMsg2.a());
  }
  
  public void a(DataInputStream paramDataInputStream)
  {
    this.jdField_a_of_type_Short = paramDataInputStream.readShort();
    this.jdField_a_of_type_Long = paramDataInputStream.readLong();
    this.b = paramDataInputStream.readLong();
    this.c = paramDataInputStream.readLong();
    this.a_ = paramDataInputStream.readByte();
    int k = paramDataInputStream.readInt();
    if (k > 0)
    {
      int j = 0;
      while (j < k)
      {
        fmx localfmx = new fmx(this);
        localfmx.a(paramDataInputStream);
        a(localfmx);
        j += 1;
      }
    }
  }
  
  public void a(DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.writeShort(this.jdField_a_of_type_Short);
    paramDataOutputStream.writeLong(this.jdField_a_of_type_Long);
    paramDataOutputStream.writeLong(this.b);
    paramDataOutputStream.writeLong(this.c);
    paramDataOutputStream.writeByte(this.a_);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      paramDataOutputStream.writeInt(0);
    }
    for (;;)
    {
      return;
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      paramDataOutputStream.writeInt(k);
      int j = 0;
      while (j < k)
      {
        ((fmx)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a(paramDataOutputStream);
        j += 1;
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0) || (paramString == null) || (paramString.length() <= 0)) {}
    label234:
    for (;;)
    {
      return;
      ArrayList localArrayList = Config.a();
      int j = 0;
      for (;;)
      {
        if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label234;
        }
        fmx localfmx = (fmx)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (paramString.startsWith(localfmx.b))
        {
          if (this.a_ == 1)
          {
            localfmx.c = (BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png");
            a(paramArrayOfByte, localfmx.c, this.b);
            if (localArrayList == null) {
              break;
            }
            paramArrayOfByte = localArrayList.iterator();
            while (paramArrayOfByte.hasNext()) {
              ((ConfigListener)paramArrayOfByte.next()).a(true, this.jdField_a_of_type_Short, j, paramString);
            }
            break;
          }
          if (this.a_ != 0) {
            break;
          }
          a(paramArrayOfByte, String.valueOf(localfmx.jdField_a_of_type_Long));
          if (localArrayList == null) {
            break;
          }
          paramArrayOfByte = localArrayList.iterator();
          while (paramArrayOfByte.hasNext()) {
            ((ConfigListener)paramArrayOfByte.next()).a(true, this.jdField_a_of_type_Short, j, paramString);
          }
          break;
        }
        j += 1;
      }
    }
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (paramInt == 3)
    {
      paramHttpMsg2 = paramHttpMsg2.a("Content-Type");
      paramHttpMsg1 = null;
      if (paramHttpMsg2 != null) {
        paramHttpMsg1 = paramHttpMsg2.toLowerCase();
      }
      if ((paramHttpMsg1 != null) && (paramHttpMsg1.indexOf("image") != -1)) {
        return true;
      }
    }
    return false;
  }
  
  public void a_(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http://"))) {}
    HttpCommunicator localHttpCommunicator;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaUtilHashSet == null) {
          this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
        }
      } while (!this.jdField_a_of_type_JavaUtilHashSet.add(paramString));
      localHttpCommunicator = Config.a();
    } while (localHttpCommunicator == null);
    localHttpCommunicator.a(new HttpMsg(paramString, null, this, true));
  }
  
  public String b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return "";
    }
    return ((fmx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).e;
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    int j = 0;
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramHttpMsg2 = (fmx)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (paramHttpMsg1.a().startsWith(paramHttpMsg2.b))
      {
        paramHttpMsg2 = Config.a();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2 = paramHttpMsg2.iterator();
        while (paramHttpMsg2.hasNext()) {
          ((ConfigListener)paramHttpMsg2.next()).a(false, this.jdField_a_of_type_Short, j, paramHttpMsg1.a());
        }
      }
      j += 1;
    }
  }
  
  public String c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return "";
    }
    return ((fmx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d;
  }
  
  public void c()
  {
    File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic");
    try
    {
      a(localFile);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.PicAndAdConf
 * JD-Core Version:    0.7.0.1
 */