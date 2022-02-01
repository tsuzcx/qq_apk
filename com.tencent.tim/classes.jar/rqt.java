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
public class rqt
{
  public ArrayList<Long> a(List<String> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 1) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    long l2 = ambd.at(paramString);
    paramString = new ArrayList();
    Iterator localIterator = paramList.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      l1 = ambd.at((String)localIterator.next()) + l1;
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
  
  public boolean a(List<String> paramList, String paramString, int paramInt1, int paramInt2, MediaFormat paramMediaFormat)
  {
    int i = 0;
    Object localObject4;
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      localObject4 = new azbt.a();
      try
      {
        i = azbt.a((String)paramList.get(0), (azbt.a)localObject4);
        paramInt2 = localObject4.mMetaData[2];
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
      j = localObject4.mMetaData[0];
      paramInt2 = localObject4.mMetaData[1];
      i = paramInt1;
      paramInt1 = j;
      if (AudioHelper.aCA()) {
        return azbq.a(paramList, paramString, i);
      }
      localObject4 = new ArrayList();
      j = 0;
      while (j < paramList.size())
      {
        ((List)localObject4).add(new DecodeConfig((String)paramList.get(j), 0, false, true));
        j += 1;
      }
      localObject5 = new amae(paramString, paramInt1, paramInt2, aniq.dFI, 1, false, i);
      ((amae)localObject5).cBB = true;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        paramList = ByteBuffer.allocate(1048576);
        paramString = new MediaCodec.BufferInfo();
        localObject3 = new File(((amae)localObject5).outputFilePath);
        if (!((File)localObject3).exists()) {
          aqhq.UD(((File)localObject3).getAbsolutePath());
        }
        localObject3 = new MediaMuxer(((amae)localObject5).outputFilePath, 0);
        ((MediaMuxer)localObject3).setOrientationHint(((amae)localObject5).orientation);
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
              break label595;
            }
            MediaFormat localMediaFormat = paramMediaFormat.getTrackFormat(paramInt2);
            if (!localMediaFormat.getString("mime").startsWith("video/")) {
              break label604;
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
      label595:
      long l3 = 0L;
      long l2 = 0L;
      continue;
      label604:
      paramInt2 += 1;
    }
  }
  
  public ArrayList<Long> b(List<String> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 1) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    long l2 = ambd.at(paramString);
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
        paramString.put(localObject, Long.valueOf(ambd.at((String)localObject)));
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
  
  /* Error */
  public boolean c(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: new 325	java/io/FileOutputStream
    //   3: dup
    //   4: new 177	java/io/File
    //   7: dup
    //   8: aload_2
    //   9: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 328	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: astore 6
    //   17: iconst_0
    //   18: istore_3
    //   19: aload 6
    //   21: astore_2
    //   22: iload_3
    //   23: aload_1
    //   24: invokeinterface 20 1 0
    //   29: if_icmpge +204 -> 233
    //   32: aload 6
    //   34: astore_2
    //   35: new 330	java/io/RandomAccessFile
    //   38: dup
    //   39: aload_1
    //   40: iload_3
    //   41: invokeinterface 92 2 0
    //   46: checkcast 51	java/lang/String
    //   49: ldc_w 332
    //   52: invokespecial 335	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: astore 7
    //   57: aload 6
    //   59: astore_2
    //   60: ldc_w 336
    //   63: newarray byte
    //   65: astore 8
    //   67: aload 7
    //   69: aload 8
    //   71: invokevirtual 340	java/io/RandomAccessFile:read	([B)I
    //   74: istore 4
    //   76: iload 4
    //   78: iconst_m1
    //   79: if_icmpeq +45 -> 124
    //   82: aload 6
    //   84: aload 8
    //   86: iconst_0
    //   87: iload 4
    //   89: invokevirtual 344	java/io/FileOutputStream:write	([BII)V
    //   92: goto -25 -> 67
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 345	java/lang/Exception:printStackTrace	()V
    //   100: aload 6
    //   102: astore_2
    //   103: aload 7
    //   105: invokevirtual 348	java/io/RandomAccessFile:close	()V
    //   108: aload 6
    //   110: ifnull +8 -> 118
    //   113: aload 6
    //   115: invokevirtual 349	java/io/FileOutputStream:close	()V
    //   118: iconst_0
    //   119: istore 5
    //   121: iload 5
    //   123: ireturn
    //   124: aload 6
    //   126: astore_2
    //   127: aload 7
    //   129: invokevirtual 348	java/io/RandomAccessFile:close	()V
    //   132: iload_3
    //   133: iconst_1
    //   134: iadd
    //   135: istore_3
    //   136: goto -117 -> 19
    //   139: astore 7
    //   141: aload 6
    //   143: astore_2
    //   144: aload 7
    //   146: invokevirtual 345	java/lang/Exception:printStackTrace	()V
    //   149: goto -17 -> 132
    //   152: astore_2
    //   153: aload 6
    //   155: astore_1
    //   156: aload_2
    //   157: astore 6
    //   159: aload_1
    //   160: astore_2
    //   161: aload 6
    //   163: invokevirtual 345	java/lang/Exception:printStackTrace	()V
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 349	java/io/FileOutputStream:close	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_1
    //   177: aload 6
    //   179: astore_2
    //   180: aload_1
    //   181: invokevirtual 345	java/lang/Exception:printStackTrace	()V
    //   184: goto -76 -> 108
    //   187: astore_1
    //   188: aload_2
    //   189: ifnull +7 -> 196
    //   192: aload_2
    //   193: invokevirtual 349	java/io/FileOutputStream:close	()V
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 270	java/io/IOException:printStackTrace	()V
    //   203: goto -85 -> 118
    //   206: astore_1
    //   207: aload 6
    //   209: astore_2
    //   210: aload 7
    //   212: invokevirtual 348	java/io/RandomAccessFile:close	()V
    //   215: aload 6
    //   217: astore_2
    //   218: aload_1
    //   219: athrow
    //   220: astore 7
    //   222: aload 6
    //   224: astore_2
    //   225: aload 7
    //   227: invokevirtual 345	java/lang/Exception:printStackTrace	()V
    //   230: goto -15 -> 215
    //   233: aload 6
    //   235: astore_2
    //   236: aload 6
    //   238: invokevirtual 349	java/io/FileOutputStream:close	()V
    //   241: iconst_1
    //   242: istore 5
    //   244: aload 6
    //   246: ifnull -125 -> 121
    //   249: aload 6
    //   251: invokevirtual 349	java/io/FileOutputStream:close	()V
    //   254: iconst_1
    //   255: ireturn
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual 270	java/io/IOException:printStackTrace	()V
    //   261: iconst_1
    //   262: ireturn
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 270	java/io/IOException:printStackTrace	()V
    //   268: goto -94 -> 174
    //   271: astore_2
    //   272: aload_2
    //   273: invokevirtual 270	java/io/IOException:printStackTrace	()V
    //   276: goto -80 -> 196
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_2
    //   282: goto -94 -> 188
    //   285: astore 6
    //   287: aconst_null
    //   288: astore_1
    //   289: goto -130 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	rqt
    //   0	292	1	paramList	List<String>
    //   0	292	2	paramString	String
    //   18	118	3	i	int
    //   74	14	4	j	int
    //   119	124	5	bool	boolean
    //   15	235	6	localObject	Object
    //   285	1	6	localException1	Exception
    //   55	73	7	localRandomAccessFile	java.io.RandomAccessFile
    //   139	72	7	localException2	Exception
    //   220	6	7	localException3	Exception
    //   65	20	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   67	76	95	java/lang/Exception
    //   82	92	95	java/lang/Exception
    //   127	132	139	java/lang/Exception
    //   22	32	152	java/lang/Exception
    //   35	57	152	java/lang/Exception
    //   60	67	152	java/lang/Exception
    //   144	149	152	java/lang/Exception
    //   180	184	152	java/lang/Exception
    //   218	220	152	java/lang/Exception
    //   225	230	152	java/lang/Exception
    //   236	241	152	java/lang/Exception
    //   103	108	176	java/lang/Exception
    //   22	32	187	finally
    //   35	57	187	finally
    //   60	67	187	finally
    //   103	108	187	finally
    //   127	132	187	finally
    //   144	149	187	finally
    //   161	166	187	finally
    //   180	184	187	finally
    //   210	215	187	finally
    //   218	220	187	finally
    //   225	230	187	finally
    //   236	241	187	finally
    //   113	118	198	java/io/IOException
    //   67	76	206	finally
    //   82	92	206	finally
    //   96	100	206	finally
    //   210	215	220	java/lang/Exception
    //   249	254	256	java/io/IOException
    //   170	174	263	java/io/IOException
    //   192	196	271	java/io/IOException
    //   0	17	279	finally
    //   0	17	285	java/lang/Exception
  }
  
  public ArrayList<Long> q(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 1)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    long l = -10L;
    while (paramList.hasNext())
    {
      l = ambd.at((String)paramList.next()) + l;
      localArrayList.add(Long.valueOf(l));
    }
    if (localArrayList.size() > 1) {
      localArrayList.remove(localArrayList.size() - 1);
    }
    return localArrayList;
  }
  
  public ArrayList<Long> r(List<String> paramList)
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
        localLinkedHashMap.put(localObject, Long.valueOf(ambd.at((String)localObject)));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqt
 * JD-Core Version:    0.7.0.1
 */