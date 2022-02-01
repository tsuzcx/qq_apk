package com.tencent.moai.database.sqlite;

import android.database.StaleDataException;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

public class SparseParcelWindow
  extends SQLiteClosable
{
  private static final String TAG = "SparseParcelWindow";
  int mColumnCount;
  Row[] mData;
  int statementStep = 0;
  
  public void clear()
  {
    acquireReference();
    try
    {
      onAllReferencesReleased();
      this.mData = null;
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void dump()
  {
    int i = 0;
    while (i < this.mData.length)
    {
      this.mData[i].dump(i);
      i += 1;
    }
  }
  
  /* Error */
  public byte[] getBlob(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 30	com/tencent/moai/database/sqlite/SparseParcelWindow:acquireReference	()V
    //   4: aload_0
    //   5: iload_1
    //   6: invokevirtual 48	com/tencent/moai/database/sqlite/SparseParcelWindow:getRow	(I)Lcom/tencent/moai/database/sqlite/SparseParcelWindow$Row;
    //   9: astore_3
    //   10: aload_3
    //   11: iload_2
    //   12: invokevirtual 52	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getType	(I)I
    //   15: tableswitch	default:+109 -> 124, 0:+91->106, 1:+29->44, 2:+76->91, 3:+97->112
    //   45: nop
    //   46: istore 89
    //   48: new 56	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   55: ldc 59
    //   57: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: getstatic 67	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:TYPE_NAMES	[Ljava/lang/String;
    //   63: aload_3
    //   64: iload_2
    //   65: invokevirtual 52	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getType	(I)I
    //   68: aaload
    //   69: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 69
    //   74: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 76	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: astore_3
    //   85: aload_0
    //   86: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   89: aload_3
    //   90: athrow
    //   91: aload_3
    //   92: iload_2
    //   93: invokevirtual 80	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getString	(I)Ljava/lang/String;
    //   96: invokevirtual 86	java/lang/String:getBytes	()[B
    //   99: astore_3
    //   100: aload_0
    //   101: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   104: aload_3
    //   105: areturn
    //   106: aload_0
    //   107: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   110: aconst_null
    //   111: areturn
    //   112: aload_3
    //   113: iload_2
    //   114: invokevirtual 89	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getBlob	(I)[B
    //   117: astore_3
    //   118: aload_0
    //   119: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   122: aload_3
    //   123: areturn
    //   124: goto -80 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	SparseParcelWindow
    //   0	127	1	paramInt1	int
    //   0	127	2	paramInt2	int
    //   9	55	3	localRow	Row
    //   84	8	3	localObject	Object
    //   99	24	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   4	44	84	finally
    //   44	84	84	finally
    //   91	100	84	finally
    //   112	118	84	finally
  }
  
  /* Error */
  public double getDouble(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 30	com/tencent/moai/database/sqlite/SparseParcelWindow:acquireReference	()V
    //   4: aload_0
    //   5: iload_1
    //   6: invokevirtual 48	com/tencent/moai/database/sqlite/SparseParcelWindow:getRow	(I)Lcom/tencent/moai/database/sqlite/SparseParcelWindow$Row;
    //   9: astore 7
    //   11: aload 7
    //   13: iload_2
    //   14: invokevirtual 52	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getType	(I)I
    //   17: tableswitch	default:+141 -> 158, 0:+135->152, 1:+117->134, 2:+98->115, 3:+35->52, 4:+85->102
    //   53: nop
    //   54: istore 89
    //   56: new 56	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   63: ldc 59
    //   65: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 67	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:TYPE_NAMES	[Ljava/lang/String;
    //   71: aload 7
    //   73: iload_2
    //   74: invokevirtual 52	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getType	(I)I
    //   77: aaload
    //   78: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 93
    //   83: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokespecial 76	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   92: athrow
    //   93: astore 7
    //   95: aload_0
    //   96: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   99: aload 7
    //   101: athrow
    //   102: aload 7
    //   104: iload_2
    //   105: invokevirtual 96	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getDouble	(I)D
    //   108: dstore_3
    //   109: aload_0
    //   110: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   113: dload_3
    //   114: dreturn
    //   115: aload 7
    //   117: iload_2
    //   118: invokevirtual 80	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getString	(I)Ljava/lang/String;
    //   121: invokestatic 102	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   124: invokevirtual 106	java/lang/Double:doubleValue	()D
    //   127: dstore_3
    //   128: aload_0
    //   129: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   132: dload_3
    //   133: dreturn
    //   134: aload 7
    //   136: iload_2
    //   137: invokevirtual 110	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getLong	(I)J
    //   140: lstore 5
    //   142: lload 5
    //   144: l2d
    //   145: dstore_3
    //   146: aload_0
    //   147: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   150: dload_3
    //   151: dreturn
    //   152: aload_0
    //   153: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   156: dconst_0
    //   157: dreturn
    //   158: goto -106 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	SparseParcelWindow
    //   0	161	1	paramInt1	int
    //   0	161	2	paramInt2	int
    //   108	43	3	d	double
    //   140	3	5	l	long
    //   9	63	7	localRow	Row
    //   93	42	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	52	93	finally
    //   52	93	93	finally
    //   102	109	93	finally
    //   115	128	93	finally
    //   134	142	93	finally
  }
  
  public float getFloat(int paramInt1, int paramInt2)
  {
    return (float)getRow(paramInt1).getDouble(paramInt2);
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    return (int)getLong(paramInt1, paramInt2);
  }
  
  /* Error */
  public long getLong(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aload_0
    //   3: invokevirtual 30	com/tencent/moai/database/sqlite/SparseParcelWindow:acquireReference	()V
    //   6: aload_0
    //   7: iload_1
    //   8: invokevirtual 48	com/tencent/moai/database/sqlite/SparseParcelWindow:getRow	(I)Lcom/tencent/moai/database/sqlite/SparseParcelWindow$Row;
    //   11: astore 8
    //   13: aload 8
    //   15: iload_2
    //   16: invokevirtual 52	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getType	(I)I
    //   19: tableswitch	default:+171 -> 190, 0:+165->184, 1:+152->171, 2:+83->102, 3:+33->52, 4:+133->152
    //   53: nop
    //   54: istore 89
    //   56: new 56	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   63: ldc 59
    //   65: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 67	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:TYPE_NAMES	[Ljava/lang/String;
    //   71: aload 8
    //   73: iload_2
    //   74: invokevirtual 52	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getType	(I)I
    //   77: aaload
    //   78: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 121
    //   83: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokespecial 76	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   92: athrow
    //   93: astore 8
    //   95: aload_0
    //   96: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   99: aload 8
    //   101: athrow
    //   102: aload 8
    //   104: iload_2
    //   105: invokevirtual 80	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getString	(I)Ljava/lang/String;
    //   108: invokestatic 126	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   111: invokevirtual 130	java/lang/Long:longValue	()J
    //   114: lstore 5
    //   116: aload_0
    //   117: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   120: lload 5
    //   122: lreturn
    //   123: astore 9
    //   125: aload 8
    //   127: iload_2
    //   128: invokevirtual 80	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getString	(I)Ljava/lang/String;
    //   131: invokestatic 135	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   134: invokevirtual 139	java/lang/Boolean:booleanValue	()Z
    //   137: istore 7
    //   139: iload 7
    //   141: ifeq +5 -> 146
    //   144: lconst_1
    //   145: lstore_3
    //   146: aload_0
    //   147: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   150: lload_3
    //   151: lreturn
    //   152: aload 8
    //   154: iload_2
    //   155: invokevirtual 96	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getDouble	(I)D
    //   158: invokestatic 142	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   161: invokevirtual 143	java/lang/Double:longValue	()J
    //   164: lstore_3
    //   165: aload_0
    //   166: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   169: lload_3
    //   170: lreturn
    //   171: aload 8
    //   173: iload_2
    //   174: invokevirtual 110	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getLong	(I)J
    //   177: lstore_3
    //   178: aload_0
    //   179: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   182: lload_3
    //   183: lreturn
    //   184: aload_0
    //   185: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   188: lconst_0
    //   189: lreturn
    //   190: goto -138 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	SparseParcelWindow
    //   0	193	1	paramInt1	int
    //   0	193	2	paramInt2	int
    //   1	182	3	l1	long
    //   114	7	5	l2	long
    //   137	3	7	bool	boolean
    //   11	61	8	localRow	Row
    //   93	79	8	localObject	Object
    //   123	1	9	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   6	52	93	finally
    //   52	93	93	finally
    //   102	116	93	finally
    //   125	139	93	finally
    //   152	165	93	finally
    //   171	178	93	finally
    //   102	116	123	java/lang/NumberFormatException
  }
  
  public int getNumColumn()
  {
    return this.mColumnCount;
  }
  
  public int getNumRows()
  {
    return this.mData.length;
  }
  
  Row getRow(int paramInt)
  {
    if (this.mData == null) {
      throw new StaleDataException("SparseParcelWindow has not been initialize correctly.");
    }
    Row localRow2 = this.mData[paramInt];
    Row localRow1 = localRow2;
    if (localRow2 == null)
    {
      localRow1 = new Row(this.mColumnCount);
      this.mData[paramInt] = localRow1;
    }
    return localRow1;
  }
  
  public short getShort(int paramInt1, int paramInt2)
  {
    return (short)(int)getLong(paramInt1, paramInt2);
  }
  
  public int getStatementStep()
  {
    return this.statementStep;
  }
  
  /* Error */
  public String getString(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 30	com/tencent/moai/database/sqlite/SparseParcelWindow:acquireReference	()V
    //   4: aload_0
    //   5: iload_1
    //   6: invokevirtual 48	com/tencent/moai/database/sqlite/SparseParcelWindow:getRow	(I)Lcom/tencent/moai/database/sqlite/SparseParcelWindow$Row;
    //   9: astore 7
    //   11: aload 7
    //   13: iload_2
    //   14: invokevirtual 52	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getType	(I)I
    //   17: tableswitch	default:+156 -> 173, 0:+85->102, 1:+116->133, 2:+85->102, 3:+134->151, 4:+100->117
    //   53: nop
    //   54: istore 89
    //   56: new 56	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   63: ldc 59
    //   65: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 67	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:TYPE_NAMES	[Ljava/lang/String;
    //   71: aload 7
    //   73: iload_2
    //   74: invokevirtual 52	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getType	(I)I
    //   77: aaload
    //   78: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 161
    //   83: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokespecial 76	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   92: athrow
    //   93: astore 7
    //   95: aload_0
    //   96: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   99: aload 7
    //   101: athrow
    //   102: aload 7
    //   104: iload_2
    //   105: invokevirtual 80	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getString	(I)Ljava/lang/String;
    //   108: astore 7
    //   110: aload_0
    //   111: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   114: aload 7
    //   116: areturn
    //   117: aload 7
    //   119: iload_2
    //   120: invokevirtual 96	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getDouble	(I)D
    //   123: dstore_3
    //   124: aload_0
    //   125: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   128: dload_3
    //   129: invokestatic 164	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   132: areturn
    //   133: aload 7
    //   135: iload_2
    //   136: invokevirtual 110	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getLong	(I)J
    //   139: lstore 5
    //   141: aload_0
    //   142: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   145: lload 5
    //   147: invokestatic 167	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   150: areturn
    //   151: new 82	java/lang/String
    //   154: dup
    //   155: aload 7
    //   157: iload_2
    //   158: invokevirtual 89	com/tencent/moai/database/sqlite/SparseParcelWindow$Row:getBlob	(I)[B
    //   161: invokespecial 170	java/lang/String:<init>	([B)V
    //   164: astore 7
    //   166: aload_0
    //   167: invokevirtual 38	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   170: aload 7
    //   172: areturn
    //   173: goto -121 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	SparseParcelWindow
    //   0	176	1	paramInt1	int
    //   0	176	2	paramInt2	int
    //   123	6	3	d	double
    //   139	7	5	l	long
    //   9	63	7	localRow	Row
    //   93	10	7	localObject	Object
    //   108	63	7	str	String
    // Exception table:
    //   from	to	target	type
    //   4	52	93	finally
    //   52	93	93	finally
    //   102	110	93	finally
    //   117	124	93	finally
    //   133	141	93	finally
    //   151	166	93	finally
  }
  
  public boolean hasData(int paramInt)
  {
    return this.mData[paramInt] != null;
  }
  
  public void initWindow(int paramInt)
  {
    this.mData = new Row[paramInt];
  }
  
  protected void onAllReferencesReleased() {}
  
  public void putBlob(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      getRow(paramInt1).putType(paramInt2, 3).putBlob(paramInt2, paramArrayOfByte);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void putDouble(double paramDouble, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      getRow(paramInt1).putType(paramInt2, 4).putDouble(paramInt2, paramDouble);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void putFloat(float paramFloat, int paramInt1, int paramInt2)
  {
    putDouble(paramFloat, paramInt1, paramInt2);
  }
  
  public void putInt(int paramInt1, int paramInt2, int paramInt3)
  {
    putLong(paramInt1, paramInt2, paramInt3);
  }
  
  public void putLong(long paramLong, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      getRow(paramInt1).putType(paramInt2, 1).putLong(paramInt2, paramLong);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void putNull(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      getRow(paramInt1).putType(paramInt2, 0).putString(paramInt2, null);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void putString(String paramString, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      getRow(paramInt1).putType(paramInt2, 2).putString(paramInt2, paramString);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void putshort(short paramShort, int paramInt1, int paramInt2)
  {
    putLong(paramShort, paramInt1, paramInt2);
  }
  
  public void setNumColumn(int paramInt)
  {
    this.mColumnCount = paramInt;
  }
  
  public void setStatementStep(int paramInt)
  {
    this.statementStep = paramInt;
  }
  
  static class Row
    implements Parcelable
  {
    static final int TYPE_BLOB = 3;
    static final int TYPE_DOUBLE = 4;
    static final int TYPE_LONG = 1;
    static final String[] TYPE_NAMES = { "NULL", "LONG", "STRING", "BLOB", "DOUBLE" };
    static final int TYPE_NULL = 0;
    static final int TYPE_STRING = 2;
    final SparseArray<byte[]> mBlobs;
    final double[] mDoubles;
    final long[] mLongs;
    final String[] mStrings;
    final int[] mTypes;
    
    Row(int paramInt)
    {
      this.mTypes = new int[paramInt];
      this.mLongs = new long[paramInt];
      this.mStrings = new String[paramInt];
      this.mBlobs = new SparseArray();
      this.mDoubles = new double[paramInt];
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void dump(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder(" -> ").append(paramInt).append("|");
      paramInt = 0;
      if (paramInt < this.mTypes.length)
      {
        switch (this.mTypes[paramInt])
        {
        }
        for (;;)
        {
          paramInt += 1;
          break;
          localStringBuilder.append(this.mBlobs.get(paramInt)).append("|");
          continue;
          localStringBuilder.append(this.mStrings[paramInt]).append("|");
          continue;
          localStringBuilder.append(this.mLongs[paramInt]).append("|");
          continue;
          localStringBuilder.append(this.mDoubles[paramInt]).append("|");
          continue;
          localStringBuilder.append(this.mStrings[paramInt]).append("|");
        }
      }
      SQLiteDebug.Log.d("SparseParcelWindow", localStringBuilder.toString());
    }
    
    byte[] getBlob(int paramInt)
    {
      return (byte[])this.mBlobs.get(paramInt);
    }
    
    double getDouble(int paramInt)
    {
      return this.mDoubles[paramInt];
    }
    
    long getLong(int paramInt)
    {
      return this.mLongs[paramInt];
    }
    
    String getString(int paramInt)
    {
      return this.mStrings[paramInt];
    }
    
    int getType(int paramInt)
    {
      return this.mTypes[paramInt];
    }
    
    Row putBlob(int paramInt, byte[] paramArrayOfByte)
    {
      this.mBlobs.append(paramInt, paramArrayOfByte);
      return this;
    }
    
    Row putDouble(int paramInt, double paramDouble)
    {
      this.mDoubles[paramInt] = paramDouble;
      return this;
    }
    
    Row putLong(int paramInt, long paramLong)
    {
      this.mLongs[paramInt] = paramLong;
      return this;
    }
    
    Row putString(int paramInt, String paramString)
    {
      this.mStrings[paramInt] = paramString;
      return this;
    }
    
    Row putType(int paramInt1, int paramInt2)
    {
      this.mTypes[paramInt1] = paramInt2;
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
  
  public static class SQLiteBytes
    implements Parcelable
  {
    private byte[] data;
    
    public SQLiteBytes() {}
    
    public SQLiteBytes(Parcel paramParcel)
    {
      readFromParcel(paramParcel);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public byte[] getData()
    {
      return this.data;
    }
    
    public void readFromParcel(Parcel paramParcel)
    {
      paramParcel.readByteArray(this.data);
    }
    
    public void setData(byte[] paramArrayOfByte)
    {
      this.data = paramArrayOfByte;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeByteArray(this.data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SparseParcelWindow
 * JD-Core Version:    0.7.0.1
 */