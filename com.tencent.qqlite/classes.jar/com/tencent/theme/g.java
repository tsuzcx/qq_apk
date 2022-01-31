package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@TargetApi(16)
class g
{
  LongSparseArray<Integer> a;
  LongSparseArray<Drawable.ConstantState>[] b;
  SkinEngine c;
  
  /* Error */
  public g(SkinEngine paramSkinEngine, Resources paramResources, java.lang.Class paramClass, int paramInt, File paramFile, LongSparseArray<Drawable.ConstantState>... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 24	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 26	com/tencent/theme/g:c	Lcom/tencent/theme/SkinEngine;
    //   9: aload_0
    //   10: aload 6
    //   12: arraylength
    //   13: anewarray 28	android/util/LongSparseArray
    //   16: putfield 30	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   19: aload 6
    //   21: iconst_0
    //   22: aload_0
    //   23: getfield 30	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   26: iconst_0
    //   27: aload 6
    //   29: arraylength
    //   30: invokestatic 36	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   33: aload_0
    //   34: new 28	android/util/LongSparseArray
    //   37: dup
    //   38: aload_3
    //   39: invokevirtual 42	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   42: arraylength
    //   43: bipush 10
    //   45: iadd
    //   46: invokespecial 45	android/util/LongSparseArray:<init>	(I)V
    //   49: putfield 47	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
    //   52: invokestatic 53	android/os/SystemClock:uptimeMillis	()J
    //   55: lstore 8
    //   57: aload 5
    //   59: ifnull +87 -> 146
    //   62: aload 5
    //   64: invokevirtual 59	java/io/File:exists	()Z
    //   67: ifeq +79 -> 146
    //   70: new 61	java/io/ObjectInputStream
    //   73: dup
    //   74: new 63	java/io/BufferedInputStream
    //   77: dup
    //   78: new 65	java/io/FileInputStream
    //   81: dup
    //   82: aload 5
    //   84: invokespecial 68	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: invokespecial 71	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: invokespecial 72	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 76	java/io/ObjectInputStream:available	()I
    //   98: ifle +160 -> 258
    //   101: aload_1
    //   102: invokevirtual 79	java/io/ObjectInputStream:readLong	()J
    //   105: lstore 10
    //   107: aload_1
    //   108: invokevirtual 82	java/io/ObjectInputStream:readInt	()I
    //   111: istore 7
    //   113: aload_0
    //   114: getfield 47	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
    //   117: lload 10
    //   119: iload 7
    //   121: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: invokevirtual 92	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   127: goto -33 -> 94
    //   130: astore_1
    //   131: getstatic 98	com/tencent/theme/SkinEngine:DEBUG	Z
    //   134: ifeq +12 -> 146
    //   137: ldc 100
    //   139: ldc 102
    //   141: aload_1
    //   142: invokestatic 108	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   145: pop
    //   146: new 110	android/util/TypedValue
    //   149: dup
    //   150: invokespecial 111	android/util/TypedValue:<init>	()V
    //   153: astore_1
    //   154: aload_2
    //   155: iload 4
    //   157: aload_1
    //   158: iconst_1
    //   159: invokevirtual 117	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   162: aload_1
    //   163: getfield 121	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   166: ifnull +83 -> 249
    //   169: aload_1
    //   170: getfield 121	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   173: invokeinterface 127 1 0
    //   178: astore_3
    //   179: aload_3
    //   180: ldc 129
    //   182: invokevirtual 135	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   185: ifne +30 -> 215
    //   188: aload_3
    //   189: ldc 137
    //   191: invokevirtual 135	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   194: ifne +21 -> 215
    //   197: aload_3
    //   198: ldc 139
    //   200: invokevirtual 135	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   203: ifne +12 -> 215
    //   206: aload_3
    //   207: ldc 141
    //   209: invokevirtual 135	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   212: ifeq +37 -> 249
    //   215: aload_1
    //   216: getfield 145	android/util/TypedValue:assetCookie	I
    //   219: i2l
    //   220: lstore 10
    //   222: aload_1
    //   223: getfield 148	android/util/TypedValue:data	I
    //   226: i2l
    //   227: lstore 12
    //   229: aload_0
    //   230: getfield 47	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
    //   233: lload 10
    //   235: bipush 32
    //   237: lshl
    //   238: lload 12
    //   240: lor
    //   241: iload 4
    //   243: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: invokevirtual 92	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   249: iload 4
    //   251: iconst_1
    //   252: iadd
    //   253: istore 4
    //   255: goto -101 -> 154
    //   258: aload_1
    //   259: invokevirtual 151	java/io/ObjectInputStream:close	()V
    //   262: getstatic 98	com/tencent/theme/SkinEngine:DEBUG	Z
    //   265: ifeq +37 -> 302
    //   268: invokestatic 53	android/os/SystemClock:uptimeMillis	()J
    //   271: lstore 10
    //   273: ldc 100
    //   275: new 153	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   282: ldc 156
    //   284: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: lload 10
    //   289: lload 8
    //   291: lsub
    //   292: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   295: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 168	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   301: pop
    //   302: return
    //   303: astore_1
    //   304: getstatic 98	com/tencent/theme/SkinEngine:DEBUG	Z
    //   307: ifeq -5 -> 302
    //   310: invokestatic 53	android/os/SystemClock:uptimeMillis	()J
    //   313: lstore 10
    //   315: ldc 100
    //   317: new 153	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   324: ldc 156
    //   326: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: lload 10
    //   331: lload 8
    //   333: lsub
    //   334: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   337: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 168	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   343: pop
    //   344: return
    //   345: astore_1
    //   346: getstatic 98	com/tencent/theme/SkinEngine:DEBUG	Z
    //   349: ifeq +37 -> 386
    //   352: invokestatic 53	android/os/SystemClock:uptimeMillis	()J
    //   355: lstore 10
    //   357: ldc 100
    //   359: new 153	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   366: ldc 156
    //   368: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: lload 10
    //   373: lload 8
    //   375: lsub
    //   376: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   379: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 168	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   385: pop
    //   386: aload_1
    //   387: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	g
    //   0	388	1	paramSkinEngine	SkinEngine
    //   0	388	2	paramResources	Resources
    //   0	388	3	paramClass	java.lang.Class
    //   0	388	4	paramInt	int
    //   0	388	5	paramFile	File
    //   0	388	6	paramVarArgs	LongSparseArray<Drawable.ConstantState>[]
    //   111	9	7	i	int
    //   55	319	8	l1	long
    //   105	267	10	l2	long
    //   227	12	12	l3	long
    // Exception table:
    //   from	to	target	type
    //   62	94	130	java/io/IOException
    //   94	127	130	java/io/IOException
    //   258	262	130	java/io/IOException
    //   154	215	303	android/content/res/Resources$NotFoundException
    //   215	249	303	android/content/res/Resources$NotFoundException
    //   62	94	345	finally
    //   94	127	345	finally
    //   131	146	345	finally
    //   146	154	345	finally
    //   154	215	345	finally
    //   215	249	345	finally
    //   258	262	345	finally
  }
  
  /* Error */
  public g(SkinEngine paramSkinEngine, Resources paramResources, int[] paramArrayOfInt, File paramFile, LongSparseArray<Drawable.ConstantState>... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 24	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 26	com/tencent/theme/g:c	Lcom/tencent/theme/SkinEngine;
    //   9: aload_0
    //   10: aload 5
    //   12: arraylength
    //   13: anewarray 28	android/util/LongSparseArray
    //   16: putfield 30	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   19: aload 5
    //   21: iconst_0
    //   22: aload_0
    //   23: getfield 30	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   26: iconst_0
    //   27: aload 5
    //   29: arraylength
    //   30: invokestatic 36	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   33: aload_0
    //   34: new 28	android/util/LongSparseArray
    //   37: dup
    //   38: aload_3
    //   39: arraylength
    //   40: invokespecial 45	android/util/LongSparseArray:<init>	(I)V
    //   43: putfield 47	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
    //   46: invokestatic 53	android/os/SystemClock:uptimeMillis	()J
    //   49: lstore 9
    //   51: aload 4
    //   53: ifnull +87 -> 140
    //   56: aload 4
    //   58: invokevirtual 59	java/io/File:exists	()Z
    //   61: ifeq +79 -> 140
    //   64: new 61	java/io/ObjectInputStream
    //   67: dup
    //   68: new 63	java/io/BufferedInputStream
    //   71: dup
    //   72: new 65	java/io/FileInputStream
    //   75: dup
    //   76: aload 4
    //   78: invokespecial 68	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 71	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: invokespecial 72	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 76	java/io/ObjectInputStream:available	()I
    //   92: ifle +185 -> 277
    //   95: aload_1
    //   96: invokevirtual 79	java/io/ObjectInputStream:readLong	()J
    //   99: lstore 11
    //   101: aload_1
    //   102: invokevirtual 82	java/io/ObjectInputStream:readInt	()I
    //   105: istore 6
    //   107: aload_0
    //   108: getfield 47	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
    //   111: lload 11
    //   113: iload 6
    //   115: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 92	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   121: goto -33 -> 88
    //   124: astore_1
    //   125: getstatic 98	com/tencent/theme/SkinEngine:DEBUG	Z
    //   128: ifeq +12 -> 140
    //   131: ldc 100
    //   133: ldc 102
    //   135: aload_1
    //   136: invokestatic 108	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   139: pop
    //   140: new 110	android/util/TypedValue
    //   143: dup
    //   144: invokespecial 111	android/util/TypedValue:<init>	()V
    //   147: astore_1
    //   148: aload_3
    //   149: arraylength
    //   150: istore 7
    //   152: iconst_0
    //   153: istore 6
    //   155: iload 6
    //   157: iload 7
    //   159: if_icmpge +163 -> 322
    //   162: aload_3
    //   163: iload 6
    //   165: iaload
    //   166: istore 8
    //   168: aload_2
    //   169: iload 8
    //   171: aload_1
    //   172: iconst_1
    //   173: invokevirtual 117	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   176: aload_1
    //   177: getfield 121	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   180: ifnull +88 -> 268
    //   183: aload_1
    //   184: getfield 121	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   187: invokeinterface 127 1 0
    //   192: astore 4
    //   194: aload 4
    //   196: ldc 129
    //   198: invokevirtual 135	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   201: ifne +33 -> 234
    //   204: aload 4
    //   206: ldc 137
    //   208: invokevirtual 135	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   211: ifne +23 -> 234
    //   214: aload 4
    //   216: ldc 139
    //   218: invokevirtual 135	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   221: ifne +13 -> 234
    //   224: aload 4
    //   226: ldc 141
    //   228: invokevirtual 135	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   231: ifeq +37 -> 268
    //   234: aload_1
    //   235: getfield 145	android/util/TypedValue:assetCookie	I
    //   238: i2l
    //   239: lstore 11
    //   241: aload_1
    //   242: getfield 148	android/util/TypedValue:data	I
    //   245: i2l
    //   246: lstore 13
    //   248: aload_0
    //   249: getfield 47	com/tencent/theme/g:a	Landroid/util/LongSparseArray;
    //   252: lload 11
    //   254: bipush 32
    //   256: lshl
    //   257: lload 13
    //   259: lor
    //   260: iload 8
    //   262: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: invokevirtual 92	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   268: iload 6
    //   270: iconst_1
    //   271: iadd
    //   272: istore 6
    //   274: goto -119 -> 155
    //   277: aload_1
    //   278: invokevirtual 151	java/io/ObjectInputStream:close	()V
    //   281: getstatic 98	com/tencent/theme/SkinEngine:DEBUG	Z
    //   284: ifeq +37 -> 321
    //   287: invokestatic 53	android/os/SystemClock:uptimeMillis	()J
    //   290: lstore 11
    //   292: ldc 100
    //   294: new 153	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   301: ldc 156
    //   303: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: lload 11
    //   308: lload 9
    //   310: lsub
    //   311: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   314: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 168	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   320: pop
    //   321: return
    //   322: getstatic 98	com/tencent/theme/SkinEngine:DEBUG	Z
    //   325: ifeq -4 -> 321
    //   328: invokestatic 53	android/os/SystemClock:uptimeMillis	()J
    //   331: lstore 11
    //   333: ldc 100
    //   335: new 153	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   342: ldc 156
    //   344: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: lload 11
    //   349: lload 9
    //   351: lsub
    //   352: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 168	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   361: pop
    //   362: return
    //   363: astore_1
    //   364: getstatic 98	com/tencent/theme/SkinEngine:DEBUG	Z
    //   367: ifeq +37 -> 404
    //   370: invokestatic 53	android/os/SystemClock:uptimeMillis	()J
    //   373: lstore 11
    //   375: ldc 100
    //   377: new 153	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   384: ldc 156
    //   386: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: lload 11
    //   391: lload 9
    //   393: lsub
    //   394: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   397: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 168	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   403: pop
    //   404: aload_1
    //   405: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	g
    //   0	406	1	paramSkinEngine	SkinEngine
    //   0	406	2	paramResources	Resources
    //   0	406	3	paramArrayOfInt	int[]
    //   0	406	4	paramFile	File
    //   0	406	5	paramVarArgs	LongSparseArray<Drawable.ConstantState>[]
    //   105	168	6	i	int
    //   150	10	7	j	int
    //   166	95	8	k	int
    //   49	343	9	l1	long
    //   99	291	11	l2	long
    //   246	12	13	l3	long
    // Exception table:
    //   from	to	target	type
    //   56	88	124	java/io/IOException
    //   88	121	124	java/io/IOException
    //   277	281	124	java/io/IOException
    //   56	88	363	finally
    //   88	121	363	finally
    //   125	140	363	finally
    //   140	152	363	finally
    //   168	234	363	finally
    //   234	268	363	finally
    //   277	281	363	finally
  }
  
  public Drawable.ConstantState a(int paramInt, long paramLong)
  {
    Integer localInteger = (Integer)this.a.get(paramLong);
    if (localInteger == null) {
      return (Drawable.ConstantState)this.b[paramInt].get(paramLong);
    }
    if ((SkinEngine.mIconResourceID != null) && (SkinEngine.mIconResourceID.equals(localInteger)))
    {
      if (SkinEngine.DEBUG) {
        Log.d("SkinEngine", "To support Samsung multi-window, return default icon resource");
      }
      return null;
    }
    return this.c.a(localInteger.intValue());
  }
  
  void a(Resources paramResources, int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    paramResources.getValue(paramInt, localTypedValue, true);
    if ((localTypedValue.string != null) && (localTypedValue.string.toString().endsWith(".xml"))) {
      this.a.put(localTypedValue.assetCookie << 32 | localTypedValue.data, Integer.valueOf(paramInt));
    }
  }
  
  void a(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      paramFile.createNewFile();
    }
    if (paramFile != null)
    {
      paramFile.delete();
      paramFile.createNewFile();
    }
    for (paramFile = new ObjectOutputStream(new FileOutputStream(paramFile));; paramFile = null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        long l = this.a.keyAt(i);
        int j = ((Integer)this.a.valueAt(i)).intValue();
        paramFile.writeLong(l);
        paramFile.writeInt(j);
        i += 1;
      }
      paramFile.close();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.theme.g
 * JD-Core Version:    0.7.0.1
 */