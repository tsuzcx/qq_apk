import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@TargetApi(18)
public class znh
{
  public ArrayList<Long> a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 1)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    long l = -10L;
    while (paramList.hasNext())
    {
      l = bauq.a((String)paramList.next()) + l;
      localArrayList.add(Long.valueOf(l));
    }
    if (localArrayList.size() > 1) {
      localArrayList.remove(localArrayList.size() - 1);
    }
    return localArrayList;
  }
  
  public ArrayList<Long> a(List<String> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 1) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    long l2 = bauq.a(paramString);
    paramString = new ArrayList();
    Iterator localIterator = paramList.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      l1 = bauq.a((String)localIterator.next()) + l1;
      paramString.add(Long.valueOf(l1));
    }
    if (l1 > l2) {}
    for (l1 = (l1 - l2) / (paramList.size() - 1) / 2L;; l1 = 0L)
    {
      if (paramString.size() > 1) {
        paramString.remove(paramString.size() - 1);
      }
      l2 = -50L;
      int j = paramString.size();
      int i = 0;
      while (i < j)
      {
        paramString.set(i, Long.valueOf(((Long)paramString.get(i)).longValue() - l1 + l2));
        l2 -= 2L * l1;
        i += 1;
      }
      return paramString;
    }
  }
  
  /* Error */
  public boolean a(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: new 93	java/io/FileOutputStream
    //   3: dup
    //   4: new 95	java/io/File
    //   7: dup
    //   8: aload_2
    //   9: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: astore 6
    //   17: iconst_0
    //   18: istore_3
    //   19: aload 6
    //   21: astore_2
    //   22: iload_3
    //   23: aload_1
    //   24: invokeinterface 20 1 0
    //   29: if_icmpge +202 -> 231
    //   32: aload 6
    //   34: astore_2
    //   35: new 103	java/io/RandomAccessFile
    //   38: dup
    //   39: aload_1
    //   40: iload_3
    //   41: invokeinterface 104 2 0
    //   46: checkcast 41	java/lang/String
    //   49: ldc 106
    //   51: invokespecial 109	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: astore 7
    //   56: aload 6
    //   58: astore_2
    //   59: ldc 110
    //   61: newarray byte
    //   63: astore 8
    //   65: aload 7
    //   67: aload 8
    //   69: invokevirtual 114	java/io/RandomAccessFile:read	([B)I
    //   72: istore 4
    //   74: iload 4
    //   76: iconst_m1
    //   77: if_icmpeq +45 -> 122
    //   80: aload 6
    //   82: aload 8
    //   84: iconst_0
    //   85: iload 4
    //   87: invokevirtual 118	java/io/FileOutputStream:write	([BII)V
    //   90: goto -25 -> 65
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   98: aload 6
    //   100: astore_2
    //   101: aload 7
    //   103: invokevirtual 124	java/io/RandomAccessFile:close	()V
    //   106: aload 6
    //   108: ifnull +8 -> 116
    //   111: aload 6
    //   113: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   116: iconst_0
    //   117: istore 5
    //   119: iload 5
    //   121: ireturn
    //   122: aload 6
    //   124: astore_2
    //   125: aload 7
    //   127: invokevirtual 124	java/io/RandomAccessFile:close	()V
    //   130: iload_3
    //   131: iconst_1
    //   132: iadd
    //   133: istore_3
    //   134: goto -115 -> 19
    //   137: astore 7
    //   139: aload 6
    //   141: astore_2
    //   142: aload 7
    //   144: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   147: goto -17 -> 130
    //   150: astore_2
    //   151: aload 6
    //   153: astore_1
    //   154: aload_2
    //   155: astore 6
    //   157: aload_1
    //   158: astore_2
    //   159: aload 6
    //   161: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   172: iconst_0
    //   173: ireturn
    //   174: astore_1
    //   175: aload 6
    //   177: astore_2
    //   178: aload_1
    //   179: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   182: goto -76 -> 106
    //   185: astore_1
    //   186: aload_2
    //   187: ifnull +7 -> 194
    //   190: aload_2
    //   191: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   194: aload_1
    //   195: athrow
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   201: goto -85 -> 116
    //   204: astore_1
    //   205: aload 6
    //   207: astore_2
    //   208: aload 7
    //   210: invokevirtual 124	java/io/RandomAccessFile:close	()V
    //   213: aload 6
    //   215: astore_2
    //   216: aload_1
    //   217: athrow
    //   218: astore 7
    //   220: aload 6
    //   222: astore_2
    //   223: aload 7
    //   225: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   228: goto -15 -> 213
    //   231: aload 6
    //   233: astore_2
    //   234: aload 6
    //   236: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   239: iconst_1
    //   240: istore 5
    //   242: aload 6
    //   244: ifnull -125 -> 119
    //   247: aload 6
    //   249: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   252: iconst_1
    //   253: ireturn
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   259: iconst_1
    //   260: ireturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   266: goto -94 -> 172
    //   269: astore_2
    //   270: aload_2
    //   271: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   274: goto -80 -> 194
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_2
    //   280: goto -94 -> 186
    //   283: astore 6
    //   285: aconst_null
    //   286: astore_1
    //   287: goto -130 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	znh
    //   0	290	1	paramList	List<String>
    //   0	290	2	paramString	String
    //   18	116	3	i	int
    //   72	14	4	j	int
    //   117	124	5	bool	boolean
    //   15	233	6	localObject	Object
    //   283	1	6	localException1	Exception
    //   54	72	7	localRandomAccessFile	java.io.RandomAccessFile
    //   137	72	7	localException2	Exception
    //   218	6	7	localException3	Exception
    //   63	20	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   65	74	93	java/lang/Exception
    //   80	90	93	java/lang/Exception
    //   125	130	137	java/lang/Exception
    //   22	32	150	java/lang/Exception
    //   35	56	150	java/lang/Exception
    //   59	65	150	java/lang/Exception
    //   142	147	150	java/lang/Exception
    //   178	182	150	java/lang/Exception
    //   216	218	150	java/lang/Exception
    //   223	228	150	java/lang/Exception
    //   234	239	150	java/lang/Exception
    //   101	106	174	java/lang/Exception
    //   22	32	185	finally
    //   35	56	185	finally
    //   59	65	185	finally
    //   101	106	185	finally
    //   125	130	185	finally
    //   142	147	185	finally
    //   159	164	185	finally
    //   178	182	185	finally
    //   208	213	185	finally
    //   216	218	185	finally
    //   223	228	185	finally
    //   234	239	185	finally
    //   111	116	196	java/io/IOException
    //   65	74	204	finally
    //   80	90	204	finally
    //   94	98	204	finally
    //   208	213	218	java/lang/Exception
    //   247	252	254	java/io/IOException
    //   168	172	261	java/io/IOException
    //   190	194	269	java/io/IOException
    //   0	17	277	finally
    //   0	17	283	java/lang/Exception
  }
  
  public boolean a(List<String> paramList, String paramString, int paramInt1, int paramInt2, MediaFormat paramMediaFormat)
  {
    int i = 0;
    Object localObject4;
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      localObject4 = new bqiu();
      try
      {
        i = bqit.a((String)paramList.get(0), (bqiu)localObject4);
        paramInt2 = localObject4.a[2];
        paramInt1 = paramInt2;
        if (i >= 0) {
          break label117;
        }
        paramInt1 = paramInt2;
        if (!QLog.isColorLevel()) {
          break label117;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!QLog.isColorLevel()) {
            break label117;
          }
          QLog.e("QimSegmentMergeUtil", 2, "MediaMetadataUtils.getRotationDegree error: " + i);
          return false;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int j;
            Object localObject5;
            paramInt1 = paramInt2;
          }
        }
        localException1 = localException1;
        paramInt1 = 0;
      }
      QLog.e("QimSegmentMergeUtil", 2, localException1.getMessage(), localException1);
      return false;
      label117:
      j = localObject4.a[0];
      paramInt2 = localObject4.a[1];
      i = paramInt1;
      paramInt1 = j;
      if (AudioHelper.g()) {
        return bqio.a(paramList, paramString, i);
      }
      localObject4 = new ArrayList();
      j = 0;
      while (j < paramList.size())
      {
        ((List)localObject4).add(new DecodeConfig((String)paramList.get(j), 0, false, true));
        j += 1;
      }
      localObject5 = new batj(paramString, paramInt1, paramInt2, bcjb.r, 1, false, i);
      ((batj)localObject5).b = true;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        paramList = ByteBuffer.allocate(1048576);
        paramString = new MediaCodec.BufferInfo();
        localObject3 = new File(((batj)localObject5).a);
        if (!((File)localObject3).exists()) {
          bgmg.c(((File)localObject3).getAbsolutePath());
        }
        localObject3 = new MediaMuxer(((batj)localObject5).a, 0);
        ((MediaMuxer)localObject3).setOrientationHint(((batj)localObject5).g);
        i = ((MediaMuxer)localObject3).addTrack(paramMediaFormat);
        ((MediaMuxer)localObject3).start();
        paramInt1 = 1;
        localObject4 = ((List)localObject4).iterator();
        long l1 = 0L;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (DecodeConfig)((Iterator)localObject4).next();
          paramMediaFormat = new MediaExtractor();
          try
          {
            paramMediaFormat.setDataSource(((DecodeConfig)localObject5).inputFilePath);
            paramInt2 = 0;
            if (paramInt2 >= paramMediaFormat.getTrackCount()) {
              break label598;
            }
            MediaFormat localMediaFormat = paramMediaFormat.getTrackFormat(paramInt2);
            if (!localMediaFormat.getString("mime").startsWith("video/")) {
              break label607;
            }
            paramMediaFormat.selectTrack(paramInt2);
            localMediaFormat.setInteger("rotation-degrees", ((DecodeConfig)localObject5).rotation);
          }
          catch (IOException paramList)
          {
            Object localObject1;
            Object localObject2;
            paramMediaFormat.release();
            ((MediaMuxer)localObject3).release();
            paramList.printStackTrace();
            return false;
          }
          paramList.clear();
          paramInt2 = paramMediaFormat.readSampleData(paramList, 0);
          if (paramInt2 < 0)
          {
            paramMediaFormat.release();
            l1 = localObject1 + localObject2;
            continue;
          }
          l3 = paramMediaFormat.getSampleTime() + l1;
          if (l3 > 0L) {
            l2 = l3 - paramString.presentationTimeUs;
          }
          paramString.offset = 0;
          paramString.size = paramInt2;
          paramString.flags = paramInt1;
          paramInt1 = 0;
          paramString.presentationTimeUs = l3;
          ((MediaMuxer)localObject3).writeSampleData(i, paramList, paramString);
          paramMediaFormat.advance();
          continue;
        }
        ((MediaMuxer)localObject3).stop();
      }
      catch (Exception paramList)
      {
        QLog.e("QimSegmentMergeUtil", 2, paramList, new Object[0]);
        return false;
      }
      ((MediaMuxer)localObject3).release();
      return true;
      break;
      label598:
      long l3 = 0L;
      long l2 = 0L;
      continue;
      label607:
      paramInt2 += 1;
    }
  }
  
  public ArrayList<Long> b(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 1)) {
      return null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      if (localLinkedHashMap.containsKey(localObject))
      {
        l = ((Long)localLinkedHashMap.get(localObject)).longValue();
        localLinkedHashMap.put(localObject, Long.valueOf(l + l));
      }
      else
      {
        localLinkedHashMap.put(localObject, Long.valueOf(bauq.a((String)localObject)));
      }
    }
    paramList = new ArrayList();
    Object localObject = localLinkedHashMap.keySet().iterator();
    long l = -10L;
    while (((Iterator)localObject).hasNext())
    {
      l = ((Long)localLinkedHashMap.get((String)((Iterator)localObject).next())).longValue() + l;
      paramList.add(Long.valueOf(l));
    }
    if (paramList.size() > 1) {
      paramList.remove(paramList.size() - 1);
    }
    return paramList;
  }
  
  public ArrayList<Long> b(List<String> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 1) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    long l2 = bauq.a(paramString);
    paramString = new LinkedHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      if (paramString.containsKey(localObject))
      {
        l1 = ((Long)paramString.get(localObject)).longValue();
        paramString.put(localObject, Long.valueOf(l1 + l1));
      }
      else
      {
        paramString.put(localObject, Long.valueOf(bauq.a((String)localObject)));
      }
    }
    paramList = new ArrayList();
    Object localObject = paramString.keySet().iterator();
    long l1 = 0L;
    while (((Iterator)localObject).hasNext())
    {
      l1 = ((Long)paramString.get((String)((Iterator)localObject).next())).longValue() + l1;
      paramList.add(Long.valueOf(l1));
    }
    if (l1 > l2) {}
    for (l1 = (l1 - l2) / (paramString.size() - 1) / 2L;; l1 = 0L)
    {
      if (paramList.size() > 1) {
        paramList.remove(paramList.size() - 1);
      }
      l2 = -50L;
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramList.set(i, Long.valueOf(((Long)paramList.get(i)).longValue() - l1 + l2));
        l2 -= 2L * l1;
        i += 1;
      }
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znh
 * JD-Core Version:    0.7.0.1
 */