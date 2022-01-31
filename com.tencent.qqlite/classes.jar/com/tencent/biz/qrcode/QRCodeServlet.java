package com.tencent.biz.qrcode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QRCodeServlet
  extends MSFServlet
{
  private static String a = "QRCodeServlet";
  
  protected static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length + 4);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(paramArrayOfByte.length + 4);
      localDataOutputStream.write(paramArrayOfByte);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label76:
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        break label76;
      }
    }
  }
  
  protected static byte[] b(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(localByteArrayInputStream);
    try
    {
      paramArrayOfByte = new byte[localDataInputStream.readInt() - 4];
      label72:
      return paramArrayOfByte;
    }
    catch (Exception localException1)
    {
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException5) {}
      localException1 = localException1;
      paramArrayOfByte = null;
      localException1.printStackTrace();
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        return paramArrayOfByte;
      }
    }
    finally
    {
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException3)
      {
        break label72;
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(a, 2, paramFromServiceMsg.toString());
    Object localObject = null;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool = true;
      if (!bool) {
        break label116;
      }
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (paramFromServiceMsg != null) {
        break label71;
      }
      bool = false;
      paramFromServiceMsg = (FromServiceMsg)localObject;
    }
    for (;;)
    {
      notifyObserver(paramIntent, 0, bool, paramFromServiceMsg, BusinessObserver.class);
      return;
      bool = false;
      break;
      label71:
      localObject = b(paramFromServiceMsg);
      paramFromServiceMsg = new Bundle();
      localObject = new String((byte[])localObject);
      paramFromServiceMsg.putString("result", (String)localObject);
      QLog.d(a, 2, (String)localObject);
      continue;
      label116:
      QLog.e(a, 2, " MSF response is null");
      paramFromServiceMsg = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject1 = new JSONObject();
    for (;;)
    {
      int i;
      try
      {
        paramIntent = paramIntent.getExtras();
        String[] arrayOfString = new String[5];
        arrayOfString[0] = "skey";
        arrayOfString[1] = "d";
        arrayOfString[2] = "appid";
        arrayOfString[3] = "ul";
        arrayOfString[4] = "bqq";
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str = arrayOfString[i];
          if (!paramIntent.containsKey(str)) {
            break label183;
          }
          Object localObject2 = paramIntent.get(str);
          if ((localObject2 instanceof ArrayList)) {
            ((JSONObject)localObject1).put(str, new JSONArray((ArrayList)localObject2));
          } else {
            ((JSONObject)localObject1).put(str, localObject2);
          }
        }
      }
      catch (JSONException paramIntent)
      {
        QLog.d(a, 2, "json error");
        return;
      }
      localObject1 = ((JSONObject)localObject1).toString();
      paramPacket.setTimeout(30000L);
      paramPacket.setSSOCommand(paramIntent.getString("cmd"));
      paramPacket.putSendData(a(((String)localObject1).getBytes()));
      return;
      label183:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.QRCodeServlet
 * JD-Core Version:    0.7.0.1
 */