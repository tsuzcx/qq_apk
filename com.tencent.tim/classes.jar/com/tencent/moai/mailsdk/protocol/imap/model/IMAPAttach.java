package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.mime.AttachListener;
import com.tencent.moai.mailsdk.util.ASCIIUtility;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import com.tencent.moai.mailsdk.util.stream.LineInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class IMAPAttach
{
  private static final String TAG = "IMAPAttach";
  private File file;
  private ArrayList<IMAPFetchItem> itemList = new ArrayList();
  private File tempFile;
  
  private int getAttachSize(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    if (paramIMAPResponse.readByte() != 91) {
      throw new MessageException(2, "BODY parse error: missing ``['' at section start" + paramIMAPResponse.getContent());
    }
    paramIMAPResponse.readString(']');
    if (paramIMAPResponse.readByte() != 93) {
      throw new MessageException(2, "BODY parse error: missing ``]'' at section end" + paramIMAPResponse.getContent());
    }
    paramIMAPResponse.skipSpaces();
    if (paramIMAPResponse.peekByte() == 60)
    {
      paramIMAPResponse.skip(1);
      paramIMAPResponse.readNumber();
      paramIMAPResponse.skip(1);
    }
    int i = paramIMAPResponse.readByte();
    if (i == 123)
    {
      i = paramIMAPResponse.getIndex();
      while (paramIMAPResponse.readByte() != 125) {
        if (paramIMAPResponse.getIndex() > paramIMAPResponse.size) {
          throw new MessageException(2, "BODY parse error: missing ``}'' at size end" + paramIMAPResponse.getContent());
        }
      }
      return ASCIIUtility.parseInt(paramIMAPResponse.getContent().getBytes(), i, paramIMAPResponse.getIndex() - 1);
    }
    if ((i == 110) || (i == 78)) {
      throw new MessageException(12, "fetch body nil" + paramIMAPResponse.getContent());
    }
    throw new MessageException(2, "BODY parse error: missing ``{'' at size start" + paramIMAPResponse.getContent());
  }
  
  private void handleAttachDecode(InputStream paramInputStream, OutputStream paramOutputStream, AttachListener paramAttachListener)
    throws IOException
  {
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    paramOutputStream.flush();
    if (paramAttachListener != null) {
      paramAttachListener.onSuccess(this.file.getPath());
    }
  }
  
  private boolean handleAttachDownload(int paramInt, InputStream paramInputStream, OutputStream paramOutputStream, AttachListener paramAttachListener)
    throws IOException
  {
    byte[] arrayOfByte = new byte[1024];
    int k = 0;
    int m;
    int i;
    int j;
    if (k < paramInt) {
      if (k + 1024 <= paramInt)
      {
        m = paramInputStream.read(arrayOfByte);
        i = m;
        if (m == -1) {
          break label147;
        }
        j = k + m;
        i = m;
        label55:
        if (i != -1) {
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        if (paramAttachListener == null) {
          break label208;
        }
      }
    }
    label147:
    label208:
    for (boolean bool = paramAttachListener.onProgress(j);; bool = false)
    {
      k = j;
      if (!bool) {
        break;
      }
      Logger.log(4, "IMAPAttach", "abort to delete tmp file:" + this.tempFile.getAbsolutePath());
      FileUtility.deleteFile(this.tempFile.getAbsolutePath());
      paramOutputStream.close();
      return false;
      i = -1;
      j = k;
      if (k + 1024 <= paramInt) {
        break label55;
      }
      m = paramInputStream.read(arrayOfByte, 0, paramInt - k);
      i = m;
      j = k;
      if (m == -1) {
        break label55;
      }
      j = k + m;
      i = m;
      break label55;
      paramOutputStream.flush();
      return true;
    }
  }
  
  private int handleAttachPre(LineInputStream paramLineInputStream)
    throws IOException, MessageException
  {
    int i = 0;
    String str = paramLineInputStream.readLine();
    IMAPResponse localIMAPResponse = new IMAPResponse(str);
    localIMAPResponse.getNumber();
    localIMAPResponse.skipSpaces();
    localIMAPResponse.readAtom();
    localIMAPResponse.skipSpaces();
    if (localIMAPResponse.peekByte() != 40) {
      Logger.log(4, "IMAPAttach", "line miss (:" + str);
    }
    for (int j = i;; j = i)
    {
      i = j;
      if (str != null) {
        break;
      }
      int k = j;
      do
      {
        return k;
        localIMAPResponse.skip(1);
        j = 0;
        if (localIMAPResponse.getIndex() < localIMAPResponse.size)
        {
          localIMAPResponse.skipSpaces();
          Object localObject2 = null;
          Object localObject1;
          int m;
          switch ((char)localIMAPResponse.readByte())
          {
          default: 
            localObject1 = localObject2;
            m = i;
            k = j;
          }
          for (;;)
          {
            j = k;
            i = m;
            if (localObject1 == null) {
              break;
            }
            this.itemList.add(localObject1);
            j = k;
            i = m;
            break;
            k = j;
            m = i;
            localObject1 = localObject2;
            if (match(IMAPFlags.name, localIMAPResponse))
            {
              localObject1 = new IMAPFlags(localIMAPResponse);
              k = j;
              m = i;
              continue;
              k = j;
              m = i;
              localObject1 = localObject2;
              if (match(IMAPBody.name, localIMAPResponse))
              {
                m = getAttachSize(localIMAPResponse);
                Logger.log(4, "IMAPAttach", "find attach body and size:" + m);
                k = 1;
                localObject1 = localObject2;
                continue;
                k = j;
                m = i;
                localObject1 = localObject2;
                if (match(IMAPUid.name, localIMAPResponse))
                {
                  localObject1 = new IMAPUid(localIMAPResponse);
                  k = j;
                  m = i;
                }
              }
            }
          }
        }
        k = i;
      } while (j != 0);
    }
  }
  
  private boolean handleAttachVerify(LineInputStream paramLineInputStream, String paramString)
    throws IOException, MessageException
  {
    String str = paramLineInputStream.readLine();
    Object localObject2 = null;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (str != null)
      {
        if (str.startsWith(paramString)) {
          localObject1 = new IMAPResponse(str);
        }
      }
      else
      {
        if (localObject1 == null) {
          break;
        }
        return ((IMAPResponse)localObject1).isOK();
      }
      str = paramLineInputStream.readLine();
    }
    return false;
  }
  
  private boolean match(char[] paramArrayOfChar, IMAPResponse paramIMAPResponse)
  {
    int k = paramArrayOfChar.length;
    int i = paramIMAPResponse.getIndex() - 1;
    int j = 0;
    for (;;)
    {
      if (j < k)
      {
        if (Character.toUpperCase((char)paramIMAPResponse.peekByte(i)) != paramArrayOfChar[j]) {
          return false;
        }
      }
      else
      {
        paramIMAPResponse.skip(k - 1);
        return true;
      }
      j += 1;
      i += 1;
    }
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  public File getTempFile()
  {
    return this.tempFile;
  }
  
  /* Error */
  public void read(InputStream paramInputStream, String paramString1, String paramString2, AttachListener paramAttachListener)
    throws MessageException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 8
    //   9: new 165	com/tencent/moai/mailsdk/util/stream/LineInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 234	com/tencent/moai/mailsdk/util/stream/LineInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore 11
    //   19: iconst_0
    //   20: istore 5
    //   22: iconst_4
    //   23: ldc 8
    //   25: new 36	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   32: ldc 236
    //   34: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 141	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:tempFile	Ljava/io/File;
    //   41: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   44: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 238
    //   49: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 120	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:file	Ljava/io/File;
    //   56: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 150	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 141	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:tempFile	Ljava/io/File;
    //   72: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   75: invokestatic 241	com/tencent/moai/mailsdk/util/FileUtility:createFile	(Ljava/lang/String;)Z
    //   78: pop
    //   79: aload_0
    //   80: getfield 141	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:tempFile	Ljava/io/File;
    //   83: invokestatic 245	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   86: astore 7
    //   88: aload_0
    //   89: aload_0
    //   90: aload 11
    //   92: invokespecial 247	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:handleAttachPre	(Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;)I
    //   95: aload_1
    //   96: aload 7
    //   98: aload 4
    //   100: invokespecial 249	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:handleAttachDownload	(ILjava/io/InputStream;Ljava/io/OutputStream;Lcom/tencent/moai/mailsdk/protocol/mime/AttachListener;)Z
    //   103: istore 6
    //   105: iload 6
    //   107: ifne +50 -> 157
    //   110: aload 7
    //   112: ifnull +8 -> 120
    //   115: aload 7
    //   117: invokevirtual 159	java/io/OutputStream:close	()V
    //   120: iconst_0
    //   121: ifeq +11 -> 132
    //   124: new 251	java/lang/NullPointerException
    //   127: dup
    //   128: invokespecial 252	java/lang/NullPointerException:<init>	()V
    //   131: athrow
    //   132: iconst_0
    //   133: ifeq +11 -> 144
    //   136: new 251	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 252	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: aload 4
    //   146: ifnull +10 -> 156
    //   149: aload 4
    //   151: invokeinterface 255 1 0
    //   156: return
    //   157: iconst_4
    //   158: ldc 8
    //   160: new 36	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 257
    //   170: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_0
    //   174: getfield 141	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:tempFile	Ljava/io/File;
    //   177: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 150	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   189: aload_0
    //   190: aload 11
    //   192: aload_3
    //   193: invokespecial 259	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:handleAttachVerify	(Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;Ljava/lang/String;)Z
    //   196: ifne +125 -> 321
    //   199: aload_0
    //   200: getfield 141	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:tempFile	Ljava/io/File;
    //   203: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   206: invokestatic 156	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   209: pop
    //   210: aload 7
    //   212: invokevirtual 159	java/io/OutputStream:close	()V
    //   215: new 28	com/tencent/moai/mailsdk/exception/MessageException
    //   218: dup
    //   219: iconst_1
    //   220: ldc_w 261
    //   223: invokespecial 53	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;)V
    //   226: athrow
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_1
    //   230: aload 8
    //   232: astore_3
    //   233: iload 5
    //   235: ifeq +205 -> 440
    //   238: aload_0
    //   239: getfield 120	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:file	Ljava/io/File;
    //   242: ifnull +14 -> 256
    //   245: aload_0
    //   246: getfield 120	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:file	Ljava/io/File;
    //   249: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   252: invokestatic 156	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   255: pop
    //   256: new 28	com/tencent/moai/mailsdk/exception/MessageException
    //   259: dup
    //   260: iconst_3
    //   261: ldc_w 262
    //   264: ldc_w 264
    //   267: aload_2
    //   268: invokespecial 267	com/tencent/moai/mailsdk/exception/MessageException:<init>	(IILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: athrow
    //   272: astore 8
    //   274: aload_3
    //   275: astore_2
    //   276: aload_1
    //   277: astore_3
    //   278: aload 8
    //   280: astore_1
    //   281: aload 7
    //   283: ifnull +8 -> 291
    //   286: aload 7
    //   288: invokevirtual 159	java/io/OutputStream:close	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 268	java/io/InputStream:close	()V
    //   299: aload_3
    //   300: ifnull +7 -> 307
    //   303: aload_3
    //   304: invokevirtual 159	java/io/OutputStream:close	()V
    //   307: aload 4
    //   309: ifnull +10 -> 319
    //   312: aload 4
    //   314: invokeinterface 255 1 0
    //   319: aload_1
    //   320: athrow
    //   321: aload_0
    //   322: getfield 120	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:file	Ljava/io/File;
    //   325: invokestatic 245	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   328: astore_1
    //   329: aload 10
    //   331: astore_3
    //   332: aload_0
    //   333: getfield 141	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:tempFile	Ljava/io/File;
    //   336: invokestatic 272	com/tencent/moai/mailsdk/util/FileUtility:getFileInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   339: aload_2
    //   340: invokestatic 278	com/tencent/moai/mailsdk/util/MimeUtility:decode	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   343: astore_2
    //   344: aload_2
    //   345: astore_3
    //   346: aload_0
    //   347: aload_2
    //   348: aload_1
    //   349: aload 4
    //   351: invokespecial 280	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:handleAttachDecode	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/tencent/moai/mailsdk/protocol/mime/AttachListener;)V
    //   354: aload_2
    //   355: astore_3
    //   356: iconst_4
    //   357: ldc 8
    //   359: new 36	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 282
    //   369: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: getfield 120	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:file	Ljava/io/File;
    //   376: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   379: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 150	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   388: aload_2
    //   389: astore_3
    //   390: aload_0
    //   391: getfield 141	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:tempFile	Ljava/io/File;
    //   394: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   397: invokestatic 156	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   400: pop
    //   401: aload 7
    //   403: ifnull +8 -> 411
    //   406: aload 7
    //   408: invokevirtual 159	java/io/OutputStream:close	()V
    //   411: aload_2
    //   412: ifnull +7 -> 419
    //   415: aload_2
    //   416: invokevirtual 268	java/io/InputStream:close	()V
    //   419: aload_1
    //   420: ifnull +7 -> 427
    //   423: aload_1
    //   424: invokevirtual 159	java/io/OutputStream:close	()V
    //   427: aload 4
    //   429: ifnull -273 -> 156
    //   432: aload 4
    //   434: invokeinterface 255 1 0
    //   439: return
    //   440: aload_0
    //   441: getfield 120	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:file	Ljava/io/File;
    //   444: ifnull +14 -> 458
    //   447: aload_0
    //   448: getfield 120	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:file	Ljava/io/File;
    //   451: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   454: invokestatic 156	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   457: pop
    //   458: aload_0
    //   459: getfield 141	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:tempFile	Ljava/io/File;
    //   462: ifnull +14 -> 476
    //   465: aload_0
    //   466: getfield 141	com/tencent/moai/mailsdk/protocol/imap/model/IMAPAttach:tempFile	Ljava/io/File;
    //   469: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   472: invokestatic 156	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   475: pop
    //   476: new 28	com/tencent/moai/mailsdk/exception/MessageException
    //   479: dup
    //   480: iconst_3
    //   481: ldc_w 284
    //   484: aload_2
    //   485: invokespecial 287	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   488: athrow
    //   489: astore_2
    //   490: goto -183 -> 307
    //   493: astore_1
    //   494: aconst_null
    //   495: astore_2
    //   496: aconst_null
    //   497: astore 7
    //   499: aload 9
    //   501: astore_3
    //   502: goto -221 -> 281
    //   505: astore_1
    //   506: aconst_null
    //   507: astore_2
    //   508: aload 9
    //   510: astore_3
    //   511: goto -230 -> 281
    //   514: astore 8
    //   516: aconst_null
    //   517: astore_2
    //   518: aload_1
    //   519: astore_3
    //   520: aload 8
    //   522: astore_1
    //   523: goto -242 -> 281
    //   526: astore 8
    //   528: aload_1
    //   529: astore_3
    //   530: aload 8
    //   532: astore_1
    //   533: goto -252 -> 281
    //   536: astore 8
    //   538: goto -62 -> 476
    //   541: astore 8
    //   543: goto -85 -> 458
    //   546: astore 8
    //   548: goto -292 -> 256
    //   551: astore_2
    //   552: aconst_null
    //   553: astore_1
    //   554: aconst_null
    //   555: astore 7
    //   557: aload 8
    //   559: astore_3
    //   560: goto -327 -> 233
    //   563: astore_2
    //   564: iconst_1
    //   565: istore 5
    //   567: aconst_null
    //   568: astore_1
    //   569: aload 8
    //   571: astore_3
    //   572: goto -339 -> 233
    //   575: astore_2
    //   576: iconst_1
    //   577: istore 5
    //   579: goto -346 -> 233
    //   582: astore_1
    //   583: goto -156 -> 427
    //   586: astore_1
    //   587: goto -443 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	IMAPAttach
    //   0	590	1	paramInputStream	InputStream
    //   0	590	2	paramString1	String
    //   0	590	3	paramString2	String
    //   0	590	4	paramAttachListener	AttachListener
    //   20	558	5	i	int
    //   103	3	6	bool	boolean
    //   86	470	7	localOutputStream	OutputStream
    //   7	224	8	localObject1	Object
    //   272	7	8	localObject2	Object
    //   514	7	8	localObject3	Object
    //   526	5	8	localObject4	Object
    //   536	1	8	localIOException1	IOException
    //   541	1	8	localIOException2	IOException
    //   546	24	8	localIOException3	IOException
    //   1	508	9	localObject5	Object
    //   4	326	10	localObject6	Object
    //   17	174	11	localLineInputStream	LineInputStream
    // Exception table:
    //   from	to	target	type
    //   88	105	227	java/io/IOException
    //   157	227	227	java/io/IOException
    //   238	256	272	finally
    //   256	272	272	finally
    //   440	458	272	finally
    //   458	476	272	finally
    //   476	489	272	finally
    //   286	291	489	java/io/IOException
    //   295	299	489	java/io/IOException
    //   303	307	489	java/io/IOException
    //   68	88	493	finally
    //   88	105	505	finally
    //   157	227	505	finally
    //   321	329	505	finally
    //   332	344	514	finally
    //   346	354	526	finally
    //   356	388	526	finally
    //   390	401	526	finally
    //   458	476	536	java/io/IOException
    //   440	458	541	java/io/IOException
    //   238	256	546	java/io/IOException
    //   68	88	551	java/io/IOException
    //   321	329	563	java/io/IOException
    //   332	344	575	java/io/IOException
    //   346	354	575	java/io/IOException
    //   356	388	575	java/io/IOException
    //   390	401	575	java/io/IOException
    //   406	411	582	java/io/IOException
    //   415	419	582	java/io/IOException
    //   423	427	582	java/io/IOException
    //   115	120	586	java/io/IOException
    //   124	132	586	java/io/IOException
    //   136	144	586	java/io/IOException
  }
  
  public void setFile(File paramFile)
  {
    this.file = paramFile;
  }
  
  public void setTempFile(File paramFile)
  {
    this.tempFile = paramFile;
  }
  
  /* Error */
  public void transferTmpAttach(String paramString1, String paramString2, String paramString3, AttachListener paramAttachListener)
    throws MessageException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: new 122	java/io/File
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 293	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokestatic 245	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   23: astore 10
    //   25: aload 10
    //   27: astore 7
    //   29: aload 9
    //   31: astore 6
    //   33: aload 7
    //   35: astore 9
    //   37: new 122	java/io/File
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 293	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: invokestatic 272	com/tencent/moai/mailsdk/util/FileUtility:getFileInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   48: aload_3
    //   49: invokestatic 278	com/tencent/moai/mailsdk/util/MimeUtility:decode	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   52: astore_3
    //   53: aload_3
    //   54: astore 8
    //   56: aload_3
    //   57: astore 6
    //   59: aload 7
    //   61: astore 9
    //   63: sipush 8192
    //   66: newarray byte
    //   68: astore 10
    //   70: aload_3
    //   71: astore 8
    //   73: aload_3
    //   74: astore 6
    //   76: aload 7
    //   78: astore 9
    //   80: aload_3
    //   81: aload 10
    //   83: invokevirtual 109	java/io/InputStream:read	([B)I
    //   86: istore 5
    //   88: iload 5
    //   90: iconst_m1
    //   91: if_icmpeq +74 -> 165
    //   94: aload_3
    //   95: astore 8
    //   97: aload_3
    //   98: astore 6
    //   100: aload 7
    //   102: astore 9
    //   104: aload 7
    //   106: aload 10
    //   108: iconst_0
    //   109: iload 5
    //   111: invokevirtual 115	java/io/OutputStream:write	([BII)V
    //   114: goto -44 -> 70
    //   117: astore_1
    //   118: aload 8
    //   120: astore 6
    //   122: aload 7
    //   124: astore 9
    //   126: new 28	com/tencent/moai/mailsdk/exception/MessageException
    //   129: dup
    //   130: iconst_3
    //   131: ldc_w 262
    //   134: ldc_w 264
    //   137: aload_1
    //   138: invokespecial 267	com/tencent/moai/mailsdk/exception/MessageException:<init>	(IILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: athrow
    //   142: astore_1
    //   143: aload 6
    //   145: ifnull +8 -> 153
    //   148: aload 6
    //   150: invokevirtual 268	java/io/InputStream:close	()V
    //   153: aload 9
    //   155: ifnull +8 -> 163
    //   158: aload 9
    //   160: invokevirtual 159	java/io/OutputStream:close	()V
    //   163: aload_1
    //   164: athrow
    //   165: aload_3
    //   166: astore 8
    //   168: aload_3
    //   169: astore 6
    //   171: aload 7
    //   173: astore 9
    //   175: aload 7
    //   177: invokevirtual 118	java/io/OutputStream:flush	()V
    //   180: aload 4
    //   182: ifnull +21 -> 203
    //   185: aload_3
    //   186: astore 8
    //   188: aload_3
    //   189: astore 6
    //   191: aload 7
    //   193: astore 9
    //   195: aload 4
    //   197: aload_2
    //   198: invokeinterface 131 2 0
    //   203: aload_3
    //   204: astore 8
    //   206: aload_3
    //   207: astore 6
    //   209: aload 7
    //   211: astore 9
    //   213: aload_1
    //   214: invokestatic 156	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   217: pop
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 268	java/io/InputStream:close	()V
    //   226: aload 7
    //   228: ifnull +8 -> 236
    //   231: aload 7
    //   233: invokevirtual 159	java/io/OutputStream:close	()V
    //   236: return
    //   237: astore_2
    //   238: goto -75 -> 163
    //   241: astore_1
    //   242: aconst_null
    //   243: astore 9
    //   245: aload 7
    //   247: astore 6
    //   249: goto -106 -> 143
    //   252: astore_1
    //   253: aconst_null
    //   254: astore 7
    //   256: goto -134 -> 122
    //   259: astore_1
    //   260: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	IMAPAttach
    //   0	261	1	paramString1	String
    //   0	261	2	paramString2	String
    //   0	261	3	paramString3	String
    //   0	261	4	paramAttachListener	AttachListener
    //   86	24	5	i	int
    //   1	247	6	localObject1	Object
    //   7	248	7	localObject2	Object
    //   10	195	8	str	String
    //   4	240	9	localObject3	Object
    //   23	84	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   37	53	117	java/io/IOException
    //   63	70	117	java/io/IOException
    //   80	88	117	java/io/IOException
    //   104	114	117	java/io/IOException
    //   175	180	117	java/io/IOException
    //   195	203	117	java/io/IOException
    //   213	218	117	java/io/IOException
    //   37	53	142	finally
    //   63	70	142	finally
    //   80	88	142	finally
    //   104	114	142	finally
    //   126	142	142	finally
    //   175	180	142	finally
    //   195	203	142	finally
    //   213	218	142	finally
    //   148	153	237	java/io/IOException
    //   158	163	237	java/io/IOException
    //   12	25	241	finally
    //   12	25	252	java/io/IOException
    //   222	226	259	java/io/IOException
    //   231	236	259	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPAttach
 * JD-Core Version:    0.7.0.1
 */