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

public class FunnyFaceMessage
  implements Externalizable
{
  public static final int FACE_ID_BOMB = 2;
  public static final int FACE_ID_TURNTABLE = 1;
  private static int VERSION = 1;
  public Bomb bomb;
  public int faceId;
  public boolean playAnimation = true;
  public Turntable turntable;
  
  public FunnyFaceMessage() {}
  
  public FunnyFaceMessage(FunnyFaceMessage paramFunnyFaceMessage)
  {
    this.playAnimation = paramFunnyFaceMessage.playAnimation;
    this.faceId = paramFunnyFaceMessage.faceId;
    this.turntable = paramFunnyFaceMessage.turntable;
    this.bomb = paramFunnyFaceMessage.bomb;
  }
  
  public byte[] getBytes()
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunnyFaceMessage", 2, localIOException.getMessage(), localIOException);
      }
    }
    return null;
  }
  
  public boolean msgEquals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramObject == null)
    {
      bool2 = bool3;
      if (QLog.isColorLevel())
      {
        QLog.d("FunnyFaceMessage", 2, "msgEquals, obj == null");
        bool2 = bool3;
      }
    }
    do
    {
      do
      {
        return bool2;
        if (paramObject == this)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FunnyFaceMessage", 2, "msgEquals, obj == this");
          }
          return true;
        }
        if ((paramObject instanceof FunnyFaceMessage)) {
          break;
        }
        bool2 = bool3;
      } while (!QLog.isColorLevel());
      QLog.d("FunnyFaceMessage", 2, "msgEquals, obj not FunnyFaceMessage");
      return false;
      paramObject = (FunnyFaceMessage)paramObject;
      if (this.faceId == paramObject.faceId) {
        break;
      }
      bool2 = bool3;
    } while (!QLog.isColorLevel());
    QLog.d("FunnyFaceMessage", 2, "msgEquals, this.faceId == " + this.faceId + ", rhs.faceId == " + paramObject.faceId);
    return false;
    for (;;)
    {
      try
      {
        switch (this.faceId)
        {
        case 1: 
          if (!this.turntable.hitUin.equals(paramObject.turntable.hitUin)) {
            continue;
          }
          bool3 = this.turntable.uinList.equals(paramObject.turntable.uinList);
          if (!bool3) {
            continue;
          }
        }
      }
      catch (Exception paramObject)
      {
        boolean bool4;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FunnyFaceMessage", 2, paramObject.toString());
        bool1 = bool2;
        continue;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FunnyFaceMessage", 2, "msgEquals, ret == " + bool1);
      return bool1;
      bool1 = false;
      continue;
      bool3 = this.bomb.isBurst;
      bool4 = paramObject.bomb.isBurst;
      if (bool3 != bool4) {
        bool1 = false;
      }
    }
    return false;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    if (paramObjectInput.readInt() == 1)
    {
      this.faceId = paramObjectInput.readInt();
      this.playAnimation = paramObjectInput.readBoolean();
      if (this.faceId != 1) {
        break label58;
      }
      this.turntable = new Turntable();
      this.turntable.readExternal(paramObjectInput);
    }
    label58:
    while (this.faceId != 2) {
      return;
    }
    this.bomb = new Bomb();
    this.bomb.readExternal(paramObjectInput);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("faceId:").append(this.faceId);
    if (this.faceId == 1)
    {
      localStringBuilder.append(",hituin:").append(this.turntable.hitUin).append(",uinList[");
      Iterator localIterator = this.turntable.uinList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append(",");
      }
      localStringBuilder.append("]").append(",nickNane:").append(this.turntable.hitNickName);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (this.faceId == 2) {
        localStringBuilder.append(",isBurst:").append(this.bomb.isBurst);
      }
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeInt(VERSION);
    paramObjectOutput.writeInt(this.faceId);
    paramObjectOutput.writeBoolean(this.playAnimation);
    if (this.faceId == 1) {
      this.turntable.writeExternal(paramObjectOutput);
    }
    while (this.faceId != 2) {
      return;
    }
    this.bomb.writeExternal(paramObjectOutput);
  }
  
  public static class Bomb
    implements Externalizable
  {
    public boolean isBurst;
    
    public Bomb() {}
    
    public Bomb(ObjectInput paramObjectInput)
    {
      try
      {
        readExternal(paramObjectInput);
        return;
      }
      catch (IOException paramObjectInput)
      {
        paramObjectInput.printStackTrace();
        return;
      }
      catch (ClassNotFoundException paramObjectInput)
      {
        paramObjectInput.printStackTrace();
      }
    }
    
    public void readExternal(ObjectInput paramObjectInput)
      throws IOException, ClassNotFoundException
    {
      this.isBurst = paramObjectInput.readBoolean();
    }
    
    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      paramObjectOutput.writeBoolean(this.isBurst);
    }
  }
  
  public static class Turntable
    implements Externalizable
  {
    public String hitNickName;
    public String hitUin;
    public List<String> uinList = new ArrayList();
    
    public Turntable() {}
    
    public Turntable(ObjectInput paramObjectInput)
    {
      try
      {
        readExternal(paramObjectInput);
        return;
      }
      catch (IOException paramObjectInput)
      {
        paramObjectInput.printStackTrace();
        return;
      }
      catch (ClassNotFoundException paramObjectInput)
      {
        paramObjectInput.printStackTrace();
      }
    }
    
    public void readExternal(ObjectInput paramObjectInput)
      throws IOException, ClassNotFoundException
    {
      int j = paramObjectInput.readInt();
      int i = 0;
      while (i < j)
      {
        this.uinList.add(paramObjectInput.readUTF());
        i += 1;
      }
      this.hitUin = paramObjectInput.readUTF();
      this.hitNickName = paramObjectInput.readUTF();
    }
    
    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      paramObjectOutput.writeInt(this.uinList.size());
      Iterator localIterator = this.uinList.iterator();
      while (localIterator.hasNext()) {
        paramObjectOutput.writeUTF((String)localIterator.next());
      }
      paramObjectOutput.writeUTF(this.hitUin);
      paramObjectOutput.writeUTF(this.hitNickName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.FunnyFaceMessage
 * JD-Core Version:    0.7.0.1
 */