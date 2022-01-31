package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageForPlayTogetherResult$PlayTogetherResultInfo
  implements Externalizable
{
  public String mCallerNick;
  public String mGameName;
  public String mGamePicture;
  public String mMoreInfo;
  public String mSubHeading;
  public List mUinInfos;
  
  /* Error */
  public void fromBytes(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 27	java/io/ObjectInputStream
    //   3: dup
    //   4: new 29	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 31	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: invokespecial 34	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_0
    //   19: aload_2
    //   20: invokevirtual 38	com/tencent/mobileqq/data/MessageForPlayTogetherResult$PlayTogetherResultInfo:readExternal	(Ljava/io/ObjectInput;)V
    //   23: aload_2
    //   24: ifnull +7 -> 31
    //   27: aload_2
    //   28: invokevirtual 41	java/io/ObjectInputStream:close	()V
    //   31: return
    //   32: astore_1
    //   33: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -5 -> 31
    //   39: getstatic 52	com/tencent/mobileqq/data/MessageForPlayTogetherResult:TAG	Ljava/lang/String;
    //   42: iconst_2
    //   43: aload_1
    //   44: invokevirtual 56	java/io/IOException:getMessage	()Ljava/lang/String;
    //   47: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: return
    //   51: astore_3
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: astore_1
    //   56: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +16 -> 75
    //   62: aload_2
    //   63: astore_1
    //   64: getstatic 52	com/tencent/mobileqq/data/MessageForPlayTogetherResult:TAG	Ljava/lang/String;
    //   67: iconst_2
    //   68: aload_3
    //   69: invokevirtual 61	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   72: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_2
    //   76: ifnull -45 -> 31
    //   79: aload_2
    //   80: invokevirtual 41	java/io/ObjectInputStream:close	()V
    //   83: return
    //   84: astore_1
    //   85: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq -57 -> 31
    //   91: getstatic 52	com/tencent/mobileqq/data/MessageForPlayTogetherResult:TAG	Ljava/lang/String;
    //   94: iconst_2
    //   95: aload_1
    //   96: invokevirtual 56	java/io/IOException:getMessage	()Ljava/lang/String;
    //   99: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: return
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 41	java/io/ObjectInputStream:close	()V
    //   114: aload_2
    //   115: athrow
    //   116: astore_1
    //   117: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq -6 -> 114
    //   123: getstatic 52	com/tencent/mobileqq/data/MessageForPlayTogetherResult:TAG	Ljava/lang/String;
    //   126: iconst_2
    //   127: aload_1
    //   128: invokevirtual 56	java/io/IOException:getMessage	()Ljava/lang/String;
    //   131: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: goto -20 -> 114
    //   137: astore_2
    //   138: goto -32 -> 106
    //   141: astore_3
    //   142: goto -88 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	PlayTogetherResultInfo
    //   0	145	1	paramArrayOfByte	byte[]
    //   15	65	2	localObjectInputStream	java.io.ObjectInputStream
    //   103	12	2	localObject1	Object
    //   137	1	2	localObject2	Object
    //   51	18	3	localException1	java.lang.Exception
    //   141	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   27	31	32	java/io/IOException
    //   0	16	51	java/lang/Exception
    //   79	83	84	java/io/IOException
    //   0	16	103	finally
    //   110	114	116	java/io/IOException
    //   18	23	137	finally
    //   56	62	137	finally
    //   64	75	137	finally
    //   18	23	141	java/lang/Exception
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.mGameName = paramObjectInput.readUTF();
    this.mGamePicture = paramObjectInput.readUTF();
    this.mMoreInfo = paramObjectInput.readUTF();
    this.mSubHeading = paramObjectInput.readUTF();
    this.mCallerNick = paramObjectInput.readUTF();
    int j = paramObjectInput.readInt();
    if (j > 0)
    {
      if (this.mUinInfos == null) {
        this.mUinInfos = new ArrayList(j);
      }
      int i = 0;
      while (i < j)
      {
        MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo localPlayTogetherUinInfo = new MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo();
        localPlayTogetherUinInfo.mUin = paramObjectInput.readLong();
        localPlayTogetherUinInfo.mNickName = paramObjectInput.readUTF();
        localPlayTogetherUinInfo.mGrade = paramObjectInput.readInt();
        localPlayTogetherUinInfo.mScore = paramObjectInput.readUTF();
        this.mUinInfos.add(localPlayTogetherUinInfo);
        i += 1;
      }
    }
  }
  
  public byte[] toBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(MessageForPlayTogetherResult.TAG, 2, localIOException.getMessage());
      }
    }
    return null;
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.mGameName);
    paramObjectOutput.writeUTF(this.mGamePicture);
    paramObjectOutput.writeUTF(this.mMoreInfo);
    paramObjectOutput.writeUTF(this.mSubHeading);
    paramObjectOutput.writeUTF(this.mCallerNick);
    int i = this.mUinInfos.size();
    if (i > 0)
    {
      paramObjectOutput.writeInt(i);
      Iterator localIterator = this.mUinInfos.iterator();
      while (localIterator.hasNext())
      {
        MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo localPlayTogetherUinInfo = (MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo)localIterator.next();
        paramObjectOutput.writeLong(localPlayTogetherUinInfo.mUin);
        paramObjectOutput.writeUTF(localPlayTogetherUinInfo.mNickName);
        paramObjectOutput.writeInt(localPlayTogetherUinInfo.mGrade);
        paramObjectOutput.writeUTF(localPlayTogetherUinInfo.mScore);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPlayTogetherResult.PlayTogetherResultInfo
 * JD-Core Version:    0.7.0.1
 */