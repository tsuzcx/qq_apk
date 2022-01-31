package com.tencent.mobileqq.troop.utils;

import android.graphics.BitmapFactory.Options;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TroopUploadingThread
  extends Thread
{
  public static final int a = 0;
  protected static final String a = "TroopUploadingThread";
  public static final int b = 1;
  public static final int c = 2;
  protected static final int d = 10240;
  protected static final int e = 4194304;
  protected UploadingTask a;
  protected ArrayList a;
  protected boolean a;
  
  public TroopUploadingThread()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          m = j;
        }
      }
    }
    label43:
    int k;
    label55:
    do
    {
      return m;
      j = paramOptions.outHeight;
      k = paramOptions.outWidth;
      if (j > paramInt2) {
        break;
      }
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k /= 2;
      j /= 2;
      i *= 2;
      break label55;
      n = m;
    }
  }
  
  public int a(HttpURLConnection paramHttpURLConnection, TroopUploadingThread.UploadState paramUploadState, UploadItem paramUploadItem)
  {
    int k = -1;
    Object localObject1 = Integer.valueOf(-1);
    Object localObject3 = null;
    Object localObject2 = null;
    Map localMap = paramHttpURLConnection.getHeaderFields();
    try
    {
      j = paramHttpURLConnection.getResponseCode();
      Object localObject4 = localObject1;
      if (localMap != null)
      {
        Iterator localIterator = localMap.keySet().iterator();
        for (;;)
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (!localIterator.hasNext()) {
            break label342;
          }
          localObject4 = (String)localIterator.next();
          if (localObject4 == null) {
            break label498;
          }
          localObject3 = localMap.get(localObject4);
          if ((localObject3 == null) || (!(localObject3 instanceof List))) {
            break label498;
          }
          if (!((String)localObject4).equals("Result")) {
            break;
          }
          localObject4 = ((List)localObject3).get(0);
          if ((localObject4 == null) || (!(localObject4 instanceof String))) {
            break label513;
          }
          localObject1 = Integer.valueOf(Integer.parseInt((String)((List)localObject3).get(0)));
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    catch (IOException localIOException)
    {
      label513:
      for (;;)
      {
        localIOException.printStackTrace();
        int j = -1;
        continue;
        Object localObject5;
        if (localIOException.equals("NewSeq"))
        {
          localObject5 = ((List)localObject3).get(0);
          if ((localObject5 != null) && ((localObject5 instanceof String))) {
            paramUploadState.c = Integer.parseInt((String)((List)localObject3).get(0));
          }
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        else
        {
          if (localObject5.equals("FileName"))
          {
            localObject5 = ((List)localObject3).get(0);
            if ((localObject5 != null) && ((localObject5 instanceof String)))
            {
              localObject3 = (String)((List)localObject3).get(0);
              localObject2 = localObject1;
              localObject1 = localObject3;
              continue;
              label342:
              int i = localObject5.intValue();
              if (j != 200) {
                i = 102;
              }
              if ((i != 0) && (QLog.isColorLevel())) {
                QLog.d("TroopUploadingThread", 2, "result:" + i);
              }
              j = k;
              if (localObject3 != null)
              {
                j = k;
                if (((String)localObject3).contains("_"))
                {
                  localObject1 = ((String)localObject3).split("_");
                  if (localObject1.length != 2) {
                    break label477;
                  }
                }
              }
              label477:
              do
              {
                for (;;)
                {
                  try
                  {
                    paramUploadState.b = Integer.parseInt(localObject1[1]);
                    j = i;
                    if (!paramUploadItem.jdField_a_of_type_Boolean) {
                      break;
                    }
                    i = 104;
                    return i;
                  }
                  catch (NumberFormatException paramUploadState)
                  {
                    paramUploadState.printStackTrace();
                    i = -1;
                    continue;
                  }
                  i = -1;
                }
                i = j;
              } while (paramHttpURLConnection == null);
              paramHttpURLConnection.disconnect();
              return j;
            }
          }
          label498:
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte, HttpURLConnection paramHttpURLConnection, UploadItem paramUploadItem, int paramInt)
  {
    int i = -1;
    try
    {
      localDataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      m = paramArrayOfByte.length;
      j = 0;
      i = 0;
    }
    catch (IOException paramArrayOfByte)
    {
      try
      {
        DataOutputStream localDataOutputStream;
        int m;
        int j;
        if (!paramUploadItem.jdField_a_of_type_Boolean) {
          break label89;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramUploadItem);
        localDataOutputStream.flush();
        paramInt = 104;
        do
        {
          return paramInt;
          paramArrayOfByte = paramArrayOfByte;
          paramArrayOfByte.printStackTrace();
          paramInt = i;
        } while (0 == 0);
        try
        {
          throw new NullPointerException();
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return -1;
        }
        label89:
        if (m - i <= 10240) {
          break label186;
        }
        label186:
        for (int k = 10240;; k = m - i)
        {
          localDataOutputStream.write(paramArrayOfByte, i, k);
          i += k;
          if (i * 100 / m - j > 0)
          {
            paramUploadItem.jdField_a_of_type_Int = j;
            TroopUploadingThread.UploadState localUploadState = new TroopUploadingThread.UploadState();
            localUploadState.jdField_a_of_type_Int = 0;
            localUploadState.b = j;
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsUploadingTask.notifyObservers(localUploadState);
          }
          j = i * 100 / m;
          break;
        }
        try
        {
          localDataOutputStream.flush();
          localDataOutputStream.close();
          return 0;
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          localDataOutputStream.flush();
          paramArrayOfByte.printStackTrace();
          if (paramHttpURLConnection != null) {
            paramHttpURLConnection.disconnect();
          }
          if (paramInt < 3) {
            return -4;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return -1;
        }
        return 103;
      }
    }
    if (i < m) {}
    return -1;
  }
  
  /* Error */
  ByteArrayOutputStream a(String paramString)
  {
    // Byte code:
    //   0: new 31	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 212	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getstatic 218	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   12: putfield 221	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   15: aload_2
    //   16: iconst_1
    //   17: putfield 224	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 230	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   25: pop
    //   26: aload_2
    //   27: aload_0
    //   28: aload_2
    //   29: sipush 1024
    //   32: sipush 1024
    //   35: invokespecial 232	com/tencent/mobileqq/troop/utils/TroopUploadingThread:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   38: putfield 235	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   41: aload_2
    //   42: iconst_0
    //   43: putfield 224	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   46: aload_1
    //   47: aload_2
    //   48: invokestatic 230	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnonnull +5 -> 58
    //   56: aconst_null
    //   57: areturn
    //   58: new 237	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 240	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:<init>	(Ljava/lang/String;)V
    //   66: aload_2
    //   67: invokevirtual 243	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   70: astore_1
    //   71: new 245	java/io/ByteArrayOutputStream
    //   74: dup
    //   75: invokespecial 246	java/io/ByteArrayOutputStream:<init>	()V
    //   78: astore_2
    //   79: aload_1
    //   80: getstatic 252	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   83: bipush 100
    //   85: aload_2
    //   86: invokevirtual 258	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   89: pop
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 259	java/io/ByteArrayOutputStream:close	()V
    //   98: aload_1
    //   99: ifnull +14 -> 113
    //   102: aload_1
    //   103: invokevirtual 262	android/graphics/Bitmap:isRecycled	()Z
    //   106: ifne +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 265	android/graphics/Bitmap:recycle	()V
    //   113: aload_2
    //   114: areturn
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   120: goto -22 -> 98
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 259	java/io/ByteArrayOutputStream:close	()V
    //   134: aload_1
    //   135: athrow
    //   136: astore_2
    //   137: aload_2
    //   138: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   141: goto -7 -> 134
    //   144: astore_1
    //   145: goto -19 -> 126
    //   148: astore_1
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: aconst_null
    //   153: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	TroopUploadingThread
    //   0	154	1	paramString	String
    //   7	124	2	localObject	Object
    //   136	2	2	localIOException1	IOException
    //   115	2	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   94	98	115	java/io/IOException
    //   71	79	123	finally
    //   130	134	136	java/io/IOException
    //   79	90	144	finally
    //   0	52	148	java/lang/Exception
    //   58	71	148	java/lang/Exception
    //   0	52	151	java/lang/OutOfMemoryError
    //   58	71	151	java/lang/OutOfMemoryError
  }
  
  protected String a(HashMap paramHashMap, String paramString)
  {
    String str = paramString;
    if (paramHashMap != null)
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      for (;;)
      {
        str = paramString;
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
        paramString = paramString + "&" + str + "=" + (String)paramHashMap.get(str);
      }
    }
    return str;
  }
  
  /* Error */
  public HttpURLConnection a(URL paramURL, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 285	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   4: checkcast 56	java/net/HttpURLConnection
    //   7: astore_1
    //   8: aload_1
    //   9: ifnonnull +15 -> 24
    //   12: aconst_null
    //   13: areturn
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   19: aconst_null
    //   20: astore_1
    //   21: goto -13 -> 8
    //   24: aload_1
    //   25: iconst_1
    //   26: invokevirtual 289	java/net/HttpURLConnection:setDoInput	(Z)V
    //   29: aload_1
    //   30: iconst_1
    //   31: invokevirtual 292	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   34: lload_2
    //   35: l2i
    //   36: istore 4
    //   38: aload_1
    //   39: iload 4
    //   41: invokevirtual 296	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   44: aload_1
    //   45: iconst_0
    //   46: invokevirtual 299	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   49: getstatic 304	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   52: ifnull +90 -> 142
    //   55: getstatic 307	android/os/Build$VERSION:SDK_INT	I
    //   58: bipush 13
    //   60: if_icmple +82 -> 142
    //   63: aload_1
    //   64: ldc_w 309
    //   67: ldc_w 310
    //   70: invokevirtual 314	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_1
    //   74: ldc_w 316
    //   77: invokevirtual 319	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: ldc_w 321
    //   84: ldc_w 323
    //   87: invokevirtual 314	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_1
    //   91: ldc_w 325
    //   94: new 128	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 327
    //   104: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 329
    //   110: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokevirtual 314	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_1
    //   120: areturn
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 330	java/net/ProtocolException:printStackTrace	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 331	java/lang/IllegalAccessError:printStackTrace	()V
    //   133: aconst_null
    //   134: areturn
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   140: aconst_null
    //   141: areturn
    //   142: aload_1
    //   143: ldc_w 334
    //   146: ldc_w 336
    //   149: invokevirtual 314	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: goto -79 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	TroopUploadingThread
    //   0	155	1	paramURL	URL
    //   0	155	2	paramLong	long
    //   36	4	4	i	int
    // Exception table:
    //   from	to	target	type
    //   0	8	14	java/io/IOException
    //   49	73	121	java/net/ProtocolException
    //   73	119	121	java/net/ProtocolException
    //   142	152	121	java/net/ProtocolException
    //   24	34	128	java/lang/IllegalAccessError
    //   38	49	135	java/lang/Exception
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(UploadItem paramUploadItem)
  {
    Object localObject1 = a(paramUploadItem.jdField_a_of_type_JavaLangString);
    int j;
    byte[] arrayOfByte;
    int k;
    TroopUploadingThread.UploadState localUploadState;
    int m;
    int i;
    if (localObject1 == null)
    {
      j = -1;
      arrayOfByte = null;
      k = 1;
      localUploadState = new TroopUploadingThread.UploadState();
      m = 0;
      i = -1;
      localObject1 = null;
      label40:
      if (m >= 3) {
        break label247;
      }
      if (k == 0) {
        break label106;
      }
      i = 101;
    }
    label54:
    label106:
    label244:
    label247:
    for (;;)
    {
      if (i == 0) {
        localUploadState.jdField_a_of_type_Int = 1;
      }
      for (;;)
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(paramUploadItem);
          if (i != 104) {
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsUploadingTask.notifyObservers(localUploadState);
          }
          return;
          arrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
          j = arrayOfByte.length;
          k = 0;
          break;
          try
          {
            Object localObject2 = new URL(paramUploadItem.b + "&filesize=" + arrayOfByte);
            localObject1 = localObject2;
            localObject2 = a((URL)localObject1, j);
            if (localObject2 != null) {}
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              localMalformedURLException.printStackTrace();
            }
            i = a(arrayOfByte, localMalformedURLException, paramUploadItem, m);
            if (i == -4)
            {
              m += 1;
              break label40;
            }
            if (i == -1) {
              break label244;
            }
          }
        }
        if (i == 104) {
          break label54;
        }
        i = a(localMalformedURLException, localUploadState, paramUploadItem);
        break label54;
        localUploadState.jdField_a_of_type_Int = 2;
        localUploadState.b = i;
      }
    }
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      UploadItem localUploadItem = (UploadItem)localIterator.next();
      if (localUploadItem.jdField_a_of_type_JavaLangString.equals(paramString)) {
        if (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localUploadItem) == 0) {
          localUploadItem.jdField_a_of_type_Boolean = true;
        } else {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localUploadItem);
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList, HashMap paramHashMap, String paramString, UploadingTask paramUploadingTask)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsUploadingTask = paramUploadingTask;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramUploadingTask = (String)paramArrayList.next();
      new File(paramUploadingTask);
      UploadItem localUploadItem = new UploadItem();
      localUploadItem.b = a(paramHashMap, paramString);
      localUploadItem.jdField_a_of_type_JavaLangString = paramUploadingTask;
      this.jdField_a_of_type_JavaUtilArrayList.add(localUploadItem);
    }
  }
  
  public void run()
  {
    while ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      a((UploadItem)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsUploadingTask = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUploadingThread
 * JD-Core Version:    0.7.0.1
 */