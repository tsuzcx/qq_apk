package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.json.JSONReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectSerializable
{
  private static boolean isUseNewSerializeMethod = true;
  
  public static Object deserializable(byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      ObjectInputStream localObjectInputStream = new ObjectInputStream(paramArrayOfByte);
      Object localObject = localObjectInputStream.readObject();
      paramArrayOfByte.close();
      localObjectInputStream.close();
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static Object fromByte(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      Object localObject1;
      Object localObject2;
      if (!isUseNewSerializeMethod) {
        try
        {
          paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
          localObject1 = new ObjectInputStream(paramArrayOfByte);
          localObject2 = ((ObjectInputStream)localObject1).readObject();
          paramArrayOfByte.close();
          ((ObjectInputStream)localObject1).close();
          return localObject2;
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return null;
        }
      }
      if (isUseNewSerializeMethod == true) {}
      try
      {
        System.currentTimeMillis();
        paramArrayOfByte = new String(paramArrayOfByte);
        if (paramArrayOfByte.startsWith("["))
        {
          paramArrayOfByte = paramArrayOfByte.substring(1, paramArrayOfByte.length() - 1);
          if (paramArrayOfByte.trim().equals("")) {
            return new ArrayList();
          }
          localObject2 = paramArrayOfByte.split(", ");
          localObject1 = new ArrayList(localObject2.length);
          int j = localObject2.length;
          for (;;)
          {
            paramArrayOfByte = (byte[])localObject1;
            if (i >= j) {
              break;
            }
            ((ArrayList)localObject1).add(localObject2[i]);
            i += 1;
          }
        }
        paramArrayOfByte = (JSONObject)JSONReader.parse(paramArrayOfByte);
        localObject1 = (String)paramArrayOfByte.get("class");
        if (((String)localObject1).equals("IndexStatus")) {
          return null;
        }
        if (((String)localObject1).equals("Folder")) {
          return null;
        }
        if (((String)localObject1).equals("Mail"))
        {
          localObject1 = new Mail();
          ((Mail)localObject1).parseWithDictionary(paramArrayOfByte);
          return localObject1;
        }
        if (((String)localObject1).equals("MailContent"))
        {
          localObject1 = new MailContent();
          ((MailContent)localObject1).parseWithDictionary(paramArrayOfByte);
          return localObject1;
        }
        if (((String)localObject1).equals("MailUI"))
        {
          localObject1 = new MailUI();
          ((MailUI)localObject1).parseWithDictionary(paramArrayOfByte);
          return localObject1;
        }
        if (((String)localObject1).equals("MailGroupContact"))
        {
          localObject1 = new MailGroupContact();
          ((MailGroupContact)localObject1).parseWithDictionary(paramArrayOfByte);
          return localObject1;
        }
        if (((String)localObject1).equals("MailGroupContactList"))
        {
          localObject1 = new MailGroupContactList();
          ((MailGroupContactList)localObject1).parseWithDictionary(paramArrayOfByte);
          return localObject1;
        }
        if (((String)localObject1).equals("ComposeData"))
        {
          localObject1 = new ComposeData();
          ((ComposeData)localObject1).parseWithDictionary(paramArrayOfByte);
          return localObject1;
        }
        if (((String)localObject1).equals("Attach"))
        {
          localObject1 = new Attach(false);
          ((Attach)localObject1).parseWithDictionary(paramArrayOfByte);
          return localObject1;
        }
        if (((String)localObject1).equals("ComposeMailUI"))
        {
          localObject1 = new ComposeMailUI();
          ((ComposeMailUI)localObject1).parseWithDictionary(paramArrayOfByte);
          return localObject1;
        }
        if (((String)localObject1).equals("MailVote"))
        {
          localObject1 = new MailVote();
          ((MailVote)localObject1).parseWithDictionary(paramArrayOfByte);
          return localObject1;
        }
        return null;
      }
      catch (Exception paramArrayOfByte) {}
    }
    return null;
    return null;
  }
  
  public static byte[] serializable(Object paramObject)
    throws Exception
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      paramObject = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static byte[] toByte(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      if (!isUseNewSerializeMethod) {
        try
        {
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
          localObjectOutputStream.writeObject(paramObject);
          localObjectOutputStream.flush();
          paramObject = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.close();
          localObjectOutputStream.close();
          return paramObject;
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return null;
        }
      }
    } while (isUseNewSerializeMethod != true);
    try
    {
      paramObject = paramObject.toString().getBytes();
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.ObjectSerializable
 * JD-Core Version:    0.7.0.1
 */