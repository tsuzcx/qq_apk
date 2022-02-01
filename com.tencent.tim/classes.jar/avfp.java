import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public final class avfp
{
  public static String cKq = "extra.IS_MIXED_MSG";
  public static String cKr = "extra.IS_REPLY_SRC_MSG_EXIST";
  public static ahyj h;
  public static final SparseBooleanArray s = new SparseBooleanArray();
  public static final int[] tE = { 5, 7, 9 };
  
  static
  {
    int i = 0;
    if (i < 10)
    {
      int[] arrayOfInt = tE;
      int k = arrayOfInt.length;
      j = 0;
      label57:
      if (j >= k) {
        break label108;
      }
      if (i == arrayOfInt[j] - 1) {
        s.put(i, true);
      }
    }
    label108:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        s.put(i, false);
      }
      i += 1;
      break;
      j += 1;
      break label57;
      return;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, xuh paramxuh, AIORichMediaData paramAIORichMediaData, int paramInt1, int paramInt2)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (localBundle.getBoolean("extra.ENTER_NEW_GALLERY"))
    {
      paramBundle = new Intent(paramContext, com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.class);
      if ((!(paramContext instanceof PublicFragmentActivity)) || (!(((PublicFragmentActivity)paramContext).b() instanceof ChatHistoryBubbleListForTroopFragment))) {
        break label567;
      }
    }
    label308:
    label567:
    for (int i = 1;; i = 0)
    {
      if ((!localBundle.getBoolean("extra.EXTRA_NOT_CLEAR_TOP", false)) && (paramInt2 != 3) && (paramInt2 != 2) && (i == 0))
      {
        paramBundle.addFlags(603979776);
        label95:
        localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramxuh.asBinder()));
        localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", paramAIORichMediaData);
        localBundle.putInt("extra.EXTRA_ENTRANCE", paramInt2);
        if (paramAIORichMediaData != null) {
          localBundle.putBoolean(cKq, paramAIORichMediaData.isInMixedMsg);
        }
        if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) {
          break label411;
        }
        if (!(paramContext instanceof MultiForwardActivity)) {
          break label383;
        }
        paramxuh = ((BaseActivity)paramContext).getAppInterface();
        if ((paramxuh instanceof QQAppInterface))
        {
          localBundle.putBoolean("extra.FROM_AIO", true);
          localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
          localBundle.putString("uin", ((MultiForwardActivity)paramContext).getChatFragment().a().a().aTl);
          String str = localBundle.getString("extra.GROUP_UIN");
          if ((str != null) && (((QQAppInterface)paramxuh).cs(str) == 2)) {
            localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
          }
          if ((paramAIORichMediaData != null) && (paramAIORichMediaData.isMultiMsg))
          {
            localBundle.putLong("key_multi_forward_seq", ((MultiForwardActivity)paramContext).getIntent().getLongExtra("origin_merge_structing_msg_uniseq", 0L));
            ((MultiForwardActivity)paramContext).a.bfT = true;
          }
        }
        localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
        label316:
        if (ChatHistoryActivity.a(paramContext, localBundle)) {
          paramInt1 = 38;
        }
        paramBundle.putExtras(localBundle);
        if (paramInt1 >= 0) {
          break label547;
        }
        paramContext.startActivity(paramBundle);
      }
      for (;;)
      {
        if (h != null) {
          h.dqV();
        }
        return;
        paramBundle = new Intent(paramContext, com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.class);
        break;
        paramBundle.addFlags(536870912);
        break label95;
        label383:
        localBundle.putBoolean("extra.FROM_AIO", true);
        localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
        break label308;
        if ((paramContext instanceof ChatHistoryActivity))
        {
          localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
          localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
          break label316;
        }
        if ((paramContext instanceof ChatHistory))
        {
          localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
          localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
          break label316;
        }
        if ((paramContext instanceof PublicFragmentActivity))
        {
          if (!(((PublicFragmentActivity)paramContext).b() instanceof ChatHistoryBubbleListForTroopFragment)) {
            break label316;
          }
          localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
          localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
          break label316;
        }
        if (!(paramContext instanceof ChatHistoryFileActivity)) {
          break label316;
        }
        localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
        break label316;
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).startActivityForResult(paramBundle, paramInt1);
        }
      }
    }
  }
  
  /* Error */
  public static java.util.ArrayList<java.lang.Integer> an(String paramString)
    throws java.lang.OutOfMemoryError
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 243	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 250	java/io/File:exists	()Z
    //   22: ifeq -15 -> 7
    //   25: invokestatic 255	aqip:beginPile	()V
    //   28: new 257	java/io/ByteArrayOutputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 261	java/io/File:length	()J
    //   36: l2i
    //   37: invokespecial 264	java/io/ByteArrayOutputStream:<init>	(I)V
    //   40: astore 7
    //   42: new 266	java/io/BufferedInputStream
    //   45: dup
    //   46: new 268	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 271	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 274	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore 4
    //   59: aload 4
    //   61: astore_0
    //   62: sipush 1024
    //   65: newarray byte
    //   67: astore 5
    //   69: aload 4
    //   71: astore_0
    //   72: aload 4
    //   74: aload 5
    //   76: iconst_0
    //   77: sipush 1024
    //   80: invokevirtual 278	java/io/BufferedInputStream:read	([BII)I
    //   83: istore_1
    //   84: iconst_m1
    //   85: iload_1
    //   86: if_icmpeq +119 -> 205
    //   89: aload 4
    //   91: astore_0
    //   92: aload 7
    //   94: aload 5
    //   96: iconst_0
    //   97: iload_1
    //   98: invokevirtual 282	java/io/ByteArrayOutputStream:write	([BII)V
    //   101: goto -32 -> 69
    //   104: astore 5
    //   106: aload 4
    //   108: astore_0
    //   109: aload 5
    //   111: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   114: aload 4
    //   116: ifnull +207 -> 323
    //   119: aload 4
    //   121: invokevirtual 288	java/io/BufferedInputStream:close	()V
    //   124: iconst_0
    //   125: istore_1
    //   126: aload 6
    //   128: astore_0
    //   129: iload_1
    //   130: ifeq +59 -> 189
    //   133: new 290	java/util/ArrayList
    //   136: dup
    //   137: bipush 10
    //   139: invokespecial 291	java/util/ArrayList:<init>	(I)V
    //   142: astore 4
    //   144: aload 7
    //   146: invokevirtual 295	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   149: astore 5
    //   151: aload 5
    //   153: arraylength
    //   154: istore_3
    //   155: iconst_0
    //   156: istore_1
    //   157: aload 4
    //   159: astore_0
    //   160: iload_1
    //   161: iload_3
    //   162: if_icmpge +27 -> 189
    //   165: iload_1
    //   166: iconst_1
    //   167: iadd
    //   168: istore_2
    //   169: aload 5
    //   171: iload_1
    //   172: baload
    //   173: iconst_m1
    //   174: if_icmpne +144 -> 318
    //   177: aload 5
    //   179: iload_2
    //   180: baload
    //   181: bipush 217
    //   183: if_icmpne +84 -> 267
    //   186: aload 4
    //   188: astore_0
    //   189: aload 7
    //   191: invokevirtual 296	java/io/ByteArrayOutputStream:close	()V
    //   194: ldc_w 298
    //   197: ldc_w 300
    //   200: invokestatic 303	aqip:endPile	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_0
    //   204: areturn
    //   205: iconst_1
    //   206: istore_2
    //   207: iload_2
    //   208: istore_1
    //   209: aload 4
    //   211: ifnull -85 -> 126
    //   214: aload 4
    //   216: invokevirtual 288	java/io/BufferedInputStream:close	()V
    //   219: iload_2
    //   220: istore_1
    //   221: goto -95 -> 126
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   229: iload_2
    //   230: istore_1
    //   231: goto -105 -> 126
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   239: iconst_0
    //   240: istore_1
    //   241: goto -115 -> 126
    //   244: astore 4
    //   246: aconst_null
    //   247: astore_0
    //   248: aload_0
    //   249: ifnull +7 -> 256
    //   252: aload_0
    //   253: invokevirtual 288	java/io/BufferedInputStream:close	()V
    //   256: aload 4
    //   258: athrow
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   264: goto -8 -> 256
    //   267: aload 5
    //   269: iload_2
    //   270: baload
    //   271: bipush 218
    //   273: if_icmpne +45 -> 318
    //   276: aload 4
    //   278: iload_2
    //   279: iconst_1
    //   280: isub
    //   281: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   284: invokevirtual 313	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   287: pop
    //   288: iload_2
    //   289: iconst_1
    //   290: iadd
    //   291: istore_1
    //   292: goto -135 -> 157
    //   295: astore 4
    //   297: aload 4
    //   299: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   302: goto -108 -> 194
    //   305: astore 4
    //   307: goto -59 -> 248
    //   310: astore 5
    //   312: aconst_null
    //   313: astore 4
    //   315: goto -209 -> 106
    //   318: iload_2
    //   319: istore_1
    //   320: goto -163 -> 157
    //   323: iconst_0
    //   324: istore_1
    //   325: goto -199 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramString	String
    //   83	242	1	i	int
    //   168	151	2	j	int
    //   154	9	3	k	int
    //   57	158	4	localObject1	Object
    //   244	33	4	localObject2	Object
    //   295	3	4	localIOException1	java.io.IOException
    //   305	1	4	localObject3	Object
    //   313	1	4	localObject4	Object
    //   67	28	5	arrayOfByte1	byte[]
    //   104	6	5	localIOException2	java.io.IOException
    //   149	119	5	arrayOfByte2	byte[]
    //   310	1	5	localIOException3	java.io.IOException
    //   1	126	6	localObject5	Object
    //   40	150	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   62	69	104	java/io/IOException
    //   72	84	104	java/io/IOException
    //   92	101	104	java/io/IOException
    //   214	219	224	java/io/IOException
    //   119	124	234	java/io/IOException
    //   42	59	244	finally
    //   252	256	259	java/io/IOException
    //   189	194	295	java/io/IOException
    //   62	69	305	finally
    //   72	84	305	finally
    //   92	101	305	finally
    //   109	114	305	finally
    //   42	59	310	java/io/IOException
  }
  
  public static void b(Context paramContext, Bundle paramBundle, xuh paramxuh, AIORichMediaData paramAIORichMediaData, int paramInt1, int paramInt2)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(paramContext, com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.class);
    paramBundle.addFlags(603979776);
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramxuh.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", paramAIORichMediaData);
    localBundle.putBoolean("extra.IS_GOTO_IMAGELIST", true);
    localBundle.putInt("extra.EXTRA_ENTRANCE", paramInt2);
    paramBundle.putExtras(localBundle);
    boolean bool = localBundle.getBoolean("extra.RIGHT_EXIT_TRANSITION", false);
    if (paramInt1 < 0)
    {
      paramContext.startActivity(paramBundle);
      if ((bool) && ((paramContext instanceof Activity))) {
        ((Activity)paramContext).overridePendingTransition(2130772090, 2130772097);
      }
    }
    for (;;)
    {
      if (h != null) {
        h.dqV();
      }
      return;
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(paramBundle, paramInt1);
      }
    }
  }
  
  public static int fR(String paramString)
  {
    paramString = aqhq.estimateFileType(paramString);
    int i = 0;
    if ("jpg".equals(paramString)) {
      i = 1000;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImgType", 2, "sender imgType is " + i);
      }
      return i;
      if ("png".equals(paramString)) {
        i = 1001;
      } else if ("bmp".equals(paramString)) {
        i = 1005;
      } else if ("gif".equals(paramString)) {
        i = 2000;
      } else if ("apng".equals(paramString)) {
        i = 2001;
      } else if ("sharpp".equals(paramString)) {
        i = 1004;
      } else if ("webp".equals(paramString)) {
        i = 1002;
      }
    }
  }
  
  /* Error */
  public static boolean is(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 8
    //   18: aload_0
    //   19: ifnonnull +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: new 243	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 5
    //   34: aload 5
    //   36: invokevirtual 250	java/io/File:exists	()Z
    //   39: ifeq -17 -> 22
    //   42: aload_0
    //   43: invokestatic 387	aqhu:isJPEGImage	(Ljava/lang/String;)Z
    //   46: ifeq -24 -> 22
    //   49: invokestatic 255	aqip:beginPile	()V
    //   52: new 268	java/io/FileInputStream
    //   55: dup
    //   56: aload 5
    //   58: invokespecial 271	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore 5
    //   63: aload 11
    //   65: astore 6
    //   67: aload 10
    //   69: astore 7
    //   71: aload 9
    //   73: astore 8
    //   75: aload 5
    //   77: invokevirtual 391	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   80: astore_0
    //   81: aload_0
    //   82: astore 6
    //   84: aload_0
    //   85: astore 7
    //   87: aload_0
    //   88: astore 8
    //   90: aload_0
    //   91: getstatic 397	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   94: lconst_0
    //   95: aload_0
    //   96: invokevirtual 402	java/nio/channels/FileChannel:size	()J
    //   99: invokevirtual 406	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   102: astore 9
    //   104: aload_0
    //   105: astore 6
    //   107: aload_0
    //   108: astore 7
    //   110: aload_0
    //   111: astore 8
    //   113: aload_0
    //   114: invokevirtual 402	java/nio/channels/FileChannel:size	()J
    //   117: l2i
    //   118: istore_3
    //   119: iconst_0
    //   120: istore_1
    //   121: iload_1
    //   122: iload_3
    //   123: if_icmpge +366 -> 489
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_2
    //   130: aload_0
    //   131: astore 6
    //   133: aload_0
    //   134: astore 7
    //   136: aload_0
    //   137: astore 8
    //   139: aload 9
    //   141: iload_1
    //   142: invokevirtual 412	java/nio/MappedByteBuffer:get	(I)B
    //   145: iconst_m1
    //   146: if_icmpne +338 -> 484
    //   149: iload_2
    //   150: iload_3
    //   151: if_icmpge +333 -> 484
    //   154: iload_2
    //   155: iconst_1
    //   156: iadd
    //   157: istore_1
    //   158: aload_0
    //   159: astore 6
    //   161: aload_0
    //   162: astore 7
    //   164: aload_0
    //   165: astore 8
    //   167: aload 9
    //   169: iload_2
    //   170: invokevirtual 412	java/nio/MappedByteBuffer:get	(I)B
    //   173: istore_2
    //   174: iload_2
    //   175: bipush 194
    //   177: if_icmpeq +21 -> 198
    //   180: iload_2
    //   181: bipush 198
    //   183: if_icmpeq +15 -> 198
    //   186: iload_2
    //   187: bipush 202
    //   189: if_icmpeq +9 -> 198
    //   192: iload_2
    //   193: bipush 206
    //   195: if_icmpne -74 -> 121
    //   198: iconst_1
    //   199: istore 4
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 413	java/nio/channels/FileChannel:close	()V
    //   209: aload 5
    //   211: ifnull +270 -> 481
    //   214: aload 5
    //   216: invokevirtual 414	java/io/FileInputStream:close	()V
    //   219: ldc_w 298
    //   222: ldc_w 416
    //   225: invokestatic 303	aqip:endPile	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: iload 4
    //   230: ireturn
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   236: goto -27 -> 209
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   244: goto -25 -> 219
    //   247: astore_0
    //   248: aconst_null
    //   249: astore_0
    //   250: aload 8
    //   252: ifnull +8 -> 260
    //   255: aload 8
    //   257: invokevirtual 413	java/nio/channels/FileChannel:close	()V
    //   260: aload_0
    //   261: ifnull +214 -> 475
    //   264: aload_0
    //   265: invokevirtual 414	java/io/FileInputStream:close	()V
    //   268: iconst_0
    //   269: istore 4
    //   271: goto -52 -> 219
    //   274: astore 5
    //   276: aload 5
    //   278: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   281: goto -21 -> 260
    //   284: astore_0
    //   285: aload_0
    //   286: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   289: iconst_0
    //   290: istore 4
    //   292: goto -73 -> 219
    //   295: astore_0
    //   296: aconst_null
    //   297: astore 5
    //   299: aload 7
    //   301: ifnull +8 -> 309
    //   304: aload 7
    //   306: invokevirtual 413	java/nio/channels/FileChannel:close	()V
    //   309: aload 5
    //   311: ifnull +164 -> 475
    //   314: aload 5
    //   316: invokevirtual 414	java/io/FileInputStream:close	()V
    //   319: iconst_0
    //   320: istore 4
    //   322: goto -103 -> 219
    //   325: astore_0
    //   326: aload_0
    //   327: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   330: goto -21 -> 309
    //   333: astore_0
    //   334: aload_0
    //   335: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   338: iconst_0
    //   339: istore 4
    //   341: goto -122 -> 219
    //   344: astore_0
    //   345: aconst_null
    //   346: astore 5
    //   348: aload 6
    //   350: ifnull +8 -> 358
    //   353: aload 6
    //   355: invokevirtual 413	java/nio/channels/FileChannel:close	()V
    //   358: aload 5
    //   360: ifnull +115 -> 475
    //   363: aload 5
    //   365: invokevirtual 414	java/io/FileInputStream:close	()V
    //   368: iconst_0
    //   369: istore 4
    //   371: goto -152 -> 219
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   379: goto -21 -> 358
    //   382: astore_0
    //   383: aload_0
    //   384: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   387: iconst_0
    //   388: istore 4
    //   390: goto -171 -> 219
    //   393: astore_0
    //   394: aconst_null
    //   395: astore 5
    //   397: aconst_null
    //   398: astore 6
    //   400: aload 6
    //   402: ifnull +8 -> 410
    //   405: aload 6
    //   407: invokevirtual 413	java/nio/channels/FileChannel:close	()V
    //   410: aload 5
    //   412: ifnull +8 -> 420
    //   415: aload 5
    //   417: invokevirtual 414	java/io/FileInputStream:close	()V
    //   420: aload_0
    //   421: athrow
    //   422: astore 6
    //   424: aload 6
    //   426: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   429: goto -19 -> 410
    //   432: astore 5
    //   434: aload 5
    //   436: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   439: goto -19 -> 420
    //   442: astore_0
    //   443: aconst_null
    //   444: astore 6
    //   446: goto -46 -> 400
    //   449: astore 7
    //   451: aload_0
    //   452: astore 6
    //   454: aload 7
    //   456: astore_0
    //   457: goto -57 -> 400
    //   460: astore_0
    //   461: goto -113 -> 348
    //   464: astore_0
    //   465: goto -166 -> 299
    //   468: astore_0
    //   469: aload 5
    //   471: astore_0
    //   472: goto -222 -> 250
    //   475: iconst_0
    //   476: istore 4
    //   478: goto -259 -> 219
    //   481: goto -262 -> 219
    //   484: iload_2
    //   485: istore_1
    //   486: goto -365 -> 121
    //   489: iconst_0
    //   490: istore 4
    //   492: goto -291 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	paramString	String
    //   120	366	1	i	int
    //   129	356	2	j	int
    //   118	34	3	k	int
    //   199	292	4	bool	boolean
    //   32	183	5	localObject1	Object
    //   274	3	5	localIOException1	java.io.IOException
    //   297	119	5	localObject2	Object
    //   432	38	5	localIOException2	java.io.IOException
    //   4	402	6	localObject3	Object
    //   422	3	6	localIOException3	java.io.IOException
    //   444	9	6	str	String
    //   1	304	7	localObject4	Object
    //   449	6	7	localObject5	Object
    //   16	240	8	localObject6	Object
    //   13	155	9	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   10	58	10	localObject7	Object
    //   7	57	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   205	209	231	java/io/IOException
    //   214	219	239	java/io/IOException
    //   52	63	247	java/io/FileNotFoundException
    //   255	260	274	java/io/IOException
    //   264	268	284	java/io/IOException
    //   52	63	295	java/io/IOException
    //   304	309	325	java/io/IOException
    //   314	319	333	java/io/IOException
    //   52	63	344	java/lang/IndexOutOfBoundsException
    //   353	358	374	java/io/IOException
    //   363	368	382	java/io/IOException
    //   52	63	393	finally
    //   405	410	422	java/io/IOException
    //   415	420	432	java/io/IOException
    //   75	81	442	finally
    //   90	104	449	finally
    //   113	119	449	finally
    //   139	149	449	finally
    //   167	174	449	finally
    //   75	81	460	java/lang/IndexOutOfBoundsException
    //   90	104	460	java/lang/IndexOutOfBoundsException
    //   113	119	460	java/lang/IndexOutOfBoundsException
    //   139	149	460	java/lang/IndexOutOfBoundsException
    //   167	174	460	java/lang/IndexOutOfBoundsException
    //   75	81	464	java/io/IOException
    //   90	104	464	java/io/IOException
    //   113	119	464	java/io/IOException
    //   139	149	464	java/io/IOException
    //   167	174	464	java/io/IOException
    //   75	81	468	java/io/FileNotFoundException
    //   90	104	468	java/io/FileNotFoundException
    //   113	119	468	java/io/FileNotFoundException
    //   139	149	468	java/io/FileNotFoundException
    //   167	174	468	java/io/FileNotFoundException
  }
  
  public static boolean ns(int paramInt)
  {
    return (paramInt >= 2000) || (paramInt == 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfp
 * JD-Core Version:    0.7.0.1
 */