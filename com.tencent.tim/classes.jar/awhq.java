import android.media.MediaPlayer;

public class awhq
{
  private MediaPlayer h;
  
  /* Error */
  public boolean gd(java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   8: ifnonnull +82 -> 90
    //   11: aload_0
    //   12: new 25	android/media/MediaPlayer
    //   15: dup
    //   16: invokespecial 26	android/media/MediaPlayer:<init>	()V
    //   19: putfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 7
    //   28: aconst_null
    //   29: astore 8
    //   31: aconst_null
    //   32: astore 6
    //   34: aload 8
    //   36: astore 4
    //   38: aload_0
    //   39: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   42: iconst_3
    //   43: invokevirtual 30	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   46: aload 8
    //   48: astore 4
    //   50: new 32	java/io/File
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: aload 8
    //   61: astore 4
    //   63: aload_1
    //   64: invokevirtual 39	java/io/File:exists	()Z
    //   67: istore_2
    //   68: iload_2
    //   69: ifne +36 -> 105
    //   72: iload_3
    //   73: istore_2
    //   74: iconst_0
    //   75: ifeq +11 -> 86
    //   78: new 41	java/lang/NullPointerException
    //   81: dup
    //   82: invokespecial 42	java/lang/NullPointerException:<init>	()V
    //   85: athrow
    //   86: aload_0
    //   87: monitorexit
    //   88: iload_2
    //   89: ireturn
    //   90: aload_0
    //   91: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   94: invokevirtual 45	android/media/MediaPlayer:reset	()V
    //   97: goto -75 -> 22
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: aload 8
    //   107: astore 4
    //   109: new 47	java/io/FileInputStream
    //   112: dup
    //   113: aload_1
    //   114: invokevirtual 51	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   117: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   120: astore_1
    //   121: aload_1
    //   122: astore 4
    //   124: aload_0
    //   125: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   128: aload_1
    //   129: invokevirtual 56	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   132: invokevirtual 60	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   135: aload_1
    //   136: astore 4
    //   138: aload_0
    //   139: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   142: invokevirtual 63	android/media/MediaPlayer:prepare	()V
    //   145: aload_1
    //   146: astore 4
    //   148: aload_1
    //   149: invokevirtual 66	java/io/FileInputStream:close	()V
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 66	java/io/FileInputStream:close	()V
    //   160: iconst_1
    //   161: istore_2
    //   162: goto -76 -> 86
    //   165: astore 5
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: astore 4
    //   172: aload 5
    //   174: invokevirtual 69	java/lang/IllegalStateException:printStackTrace	()V
    //   177: iload_3
    //   178: istore_2
    //   179: aload_1
    //   180: ifnull -94 -> 86
    //   183: aload_1
    //   184: invokevirtual 66	java/io/FileInputStream:close	()V
    //   187: iload_3
    //   188: istore_2
    //   189: goto -103 -> 86
    //   192: astore_1
    //   193: iload_3
    //   194: istore_2
    //   195: goto -109 -> 86
    //   198: astore 5
    //   200: aload 6
    //   202: astore_1
    //   203: aload_1
    //   204: astore 4
    //   206: aload 5
    //   208: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   211: iload_3
    //   212: istore_2
    //   213: aload_1
    //   214: ifnull -128 -> 86
    //   217: aload_1
    //   218: invokevirtual 66	java/io/FileInputStream:close	()V
    //   221: iload_3
    //   222: istore_2
    //   223: goto -137 -> 86
    //   226: astore_1
    //   227: iload_3
    //   228: istore_2
    //   229: goto -143 -> 86
    //   232: astore 4
    //   234: aload 5
    //   236: astore_1
    //   237: aload 4
    //   239: astore 5
    //   241: aload_1
    //   242: astore 4
    //   244: aload 5
    //   246: invokevirtual 71	java/lang/IllegalArgumentException:printStackTrace	()V
    //   249: iload_3
    //   250: istore_2
    //   251: aload_1
    //   252: ifnull -166 -> 86
    //   255: aload_1
    //   256: invokevirtual 66	java/io/FileInputStream:close	()V
    //   259: iload_3
    //   260: istore_2
    //   261: goto -175 -> 86
    //   264: astore_1
    //   265: iload_3
    //   266: istore_2
    //   267: goto -181 -> 86
    //   270: astore 5
    //   272: aload 7
    //   274: astore_1
    //   275: aload_1
    //   276: astore 4
    //   278: aload 5
    //   280: invokevirtual 72	java/lang/SecurityException:printStackTrace	()V
    //   283: iload_3
    //   284: istore_2
    //   285: aload_1
    //   286: ifnull -200 -> 86
    //   289: aload_1
    //   290: invokevirtual 66	java/io/FileInputStream:close	()V
    //   293: iload_3
    //   294: istore_2
    //   295: goto -209 -> 86
    //   298: astore_1
    //   299: iload_3
    //   300: istore_2
    //   301: goto -215 -> 86
    //   304: astore_1
    //   305: aload 4
    //   307: ifnull +8 -> 315
    //   310: aload 4
    //   312: invokevirtual 66	java/io/FileInputStream:close	()V
    //   315: aload_1
    //   316: athrow
    //   317: astore_1
    //   318: iload_3
    //   319: istore_2
    //   320: goto -234 -> 86
    //   323: astore_1
    //   324: goto -164 -> 160
    //   327: astore 4
    //   329: goto -14 -> 315
    //   332: astore_1
    //   333: goto -28 -> 305
    //   336: astore 5
    //   338: goto -63 -> 275
    //   341: astore 5
    //   343: goto -102 -> 241
    //   346: astore 5
    //   348: goto -145 -> 203
    //   351: astore 5
    //   353: goto -184 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	awhq
    //   0	356	1	paramString	java.lang.String
    //   67	253	2	bool1	boolean
    //   1	318	3	bool2	boolean
    //   36	169	4	localObject1	Object
    //   232	6	4	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   242	69	4	str	java.lang.String
    //   327	1	4	localIOException1	java.io.IOException
    //   23	1	5	localObject2	Object
    //   165	8	5	localIllegalStateException1	java.lang.IllegalStateException
    //   198	37	5	localIOException2	java.io.IOException
    //   239	6	5	localObject3	Object
    //   270	9	5	localSecurityException1	java.lang.SecurityException
    //   336	1	5	localSecurityException2	java.lang.SecurityException
    //   341	1	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   346	1	5	localIOException3	java.io.IOException
    //   351	1	5	localIllegalStateException2	java.lang.IllegalStateException
    //   32	169	6	localObject4	Object
    //   26	247	7	localObject5	Object
    //   29	77	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   4	22	100	finally
    //   78	86	100	finally
    //   90	97	100	finally
    //   156	160	100	finally
    //   183	187	100	finally
    //   217	221	100	finally
    //   255	259	100	finally
    //   289	293	100	finally
    //   310	315	100	finally
    //   315	317	100	finally
    //   38	46	165	java/lang/IllegalStateException
    //   50	59	165	java/lang/IllegalStateException
    //   63	68	165	java/lang/IllegalStateException
    //   109	121	165	java/lang/IllegalStateException
    //   183	187	192	java/io/IOException
    //   38	46	198	java/io/IOException
    //   50	59	198	java/io/IOException
    //   63	68	198	java/io/IOException
    //   109	121	198	java/io/IOException
    //   217	221	226	java/io/IOException
    //   38	46	232	java/lang/IllegalArgumentException
    //   50	59	232	java/lang/IllegalArgumentException
    //   63	68	232	java/lang/IllegalArgumentException
    //   109	121	232	java/lang/IllegalArgumentException
    //   255	259	264	java/io/IOException
    //   38	46	270	java/lang/SecurityException
    //   50	59	270	java/lang/SecurityException
    //   63	68	270	java/lang/SecurityException
    //   109	121	270	java/lang/SecurityException
    //   289	293	298	java/io/IOException
    //   38	46	304	finally
    //   50	59	304	finally
    //   63	68	304	finally
    //   109	121	304	finally
    //   206	211	304	finally
    //   244	249	304	finally
    //   278	283	304	finally
    //   78	86	317	java/io/IOException
    //   156	160	323	java/io/IOException
    //   310	315	327	java/io/IOException
    //   124	135	332	finally
    //   138	145	332	finally
    //   148	152	332	finally
    //   172	177	332	finally
    //   124	135	336	java/lang/SecurityException
    //   138	145	336	java/lang/SecurityException
    //   148	152	336	java/lang/SecurityException
    //   124	135	341	java/lang/IllegalArgumentException
    //   138	145	341	java/lang/IllegalArgumentException
    //   148	152	341	java/lang/IllegalArgumentException
    //   124	135	346	java/io/IOException
    //   138	145	346	java/io/IOException
    //   148	152	346	java/io/IOException
    //   124	135	351	java/lang/IllegalStateException
    //   138	145	351	java/lang/IllegalStateException
    //   148	152	351	java/lang/IllegalStateException
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   18: invokevirtual 76	android/media/MediaPlayer:stop	()V
    //   21: aload_0
    //   22: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   25: invokevirtual 78	android/media/MediaPlayer:release	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   33: goto -22 -> 11
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	awhq
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   36	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   14	33	36	finally
  }
  
  /* Error */
  public boolean start()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   21: invokevirtual 81	android/media/MediaPlayer:start	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 69	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	awhq
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	java.lang.IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  /* Error */
  public boolean stop()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 23	awhq:h	Landroid/media/MediaPlayer;
    //   21: invokevirtual 76	android/media/MediaPlayer:stop	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 69	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	awhq
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	java.lang.IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhq
 * JD-Core Version:    0.7.0.1
 */