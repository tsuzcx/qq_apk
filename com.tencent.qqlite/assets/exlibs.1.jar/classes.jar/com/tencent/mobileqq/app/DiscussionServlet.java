package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qrcode.activity.QRDisplayActivity.GetNicknameObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class DiscussionServlet
  extends MSFServlet
{
  public static final int a = 20002;
  protected static final String a = "OidbSvc.0x4fa_7";
  public static final String b = "field_id";
  public static final String c = "uin_list";
  
  private byte[] a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1274);
    localOIDBSSOPkg.uint32_service_type.set(7);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfString1.length * 2 + 4 + paramArrayOfString2.length * 4);
    int n = paramArrayOfString1.length;
    int i = (byte)(n >> 8 & 0xFF);
    int j = (byte)(n & 0xFF);
    byte[] arrayOfByte = new byte[paramArrayOfString1.length * 2];
    int i1 = 0;
    int i2 = paramArrayOfString1.length;
    n = 0;
    long l;
    while (n < i2)
    {
      l = Long.parseLong(paramArrayOfString1[n]);
      arrayOfByte[i1] = ((byte)(int)(l >> 8 & 0xFF));
      arrayOfByte[(i1 + 1)] = ((byte)(int)(l & 0xFF));
      i1 += 2;
      n += 1;
    }
    n = paramArrayOfString2.length;
    int k = (byte)(n >> 8 & 0xFF);
    int m = (byte)(n & 0xFF);
    i1 = 0;
    paramArrayOfString1 = new byte[n * 4];
    i2 = paramArrayOfString2.length;
    n = 0;
    while (n < i2)
    {
      l = Long.parseLong(paramArrayOfString2[n]);
      paramArrayOfString1[(i1 + 3)] = ((byte)(int)(0xFF & l));
      paramArrayOfString1[(i1 + 2)] = ((byte)(int)(l >> 8 & 0xFF));
      paramArrayOfString1[(i1 + 1)] = ((byte)(int)(l >> 16 & 0xFF));
      paramArrayOfString1[i1] = ((byte)(int)(l >> 24 & 0xFF));
      i1 += 4;
      n += 1;
    }
    localByteBuffer.put(new byte[] { i, j }).put(arrayOfByte).put(new byte[] { k, m }).put(paramArrayOfString1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramArrayOfString1 = localOIDBSSOPkg.toByteArray();
    paramArrayOfString2 = ByteBuffer.allocate(paramArrayOfString1.length + 4);
    paramArrayOfString2.putInt(paramArrayOfString1.length + 4);
    paramArrayOfString2.put(paramArrayOfString1);
    return paramArrayOfString2.array();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = paramIntent.getIntExtra("key_cmd", -1);
    paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    switch (j)
    {
    default: 
      return;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        Object localObject = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject);
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject);
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          bool = true;
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (bool)
          {
            localObject = new byte[2];
            paramFromServiceMsg.get((byte[])localObject);
            int k = Utils.a((byte[])localObject, 0);
            int i = 0;
            if (i < k)
            {
              localObject = new byte[4];
              paramFromServiceMsg.get((byte[])localObject);
              localArrayList2.add(String.valueOf(Utils.a((byte[])localObject, 0)));
              localObject = new byte[2];
              paramFromServiceMsg.get((byte[])localObject);
              long l = Utils.a((byte[])localObject, 0);
              localObject = new byte[2];
              paramFromServiceMsg.get((byte[])localObject);
              l = Utils.a((byte[])localObject, 0);
              localObject = new byte[2];
              paramFromServiceMsg.get((byte[])localObject);
              localObject = new byte[Utils.a((byte[])localObject, 0)];
              paramFromServiceMsg.get((byte[])localObject);
              localObject = new String((byte[])localObject, "utf-8");
              localArrayList1.add(localObject);
              QLog.d("test", 2, "nickName:" + (String)localObject);
              i += 1;
              continue;
            }
          }
          localBundle.putStringArrayList("nickname_list", (ArrayList)localArrayList1);
          localBundle.putStringArrayList("uin_list", (ArrayList)localArrayList2);
          notifyObserver(paramIntent, j, bool, localBundle, QRDisplayActivity.GetNicknameObserver.class);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_cmd", -1);
    String str = null;
    switch (i)
    {
    }
    for (paramIntent = str;; paramIntent = str)
    {
      if (paramIntent != null) {
        paramPacket.setSSOCommand(paramIntent);
      }
      return;
      str = "OidbSvc.0x4fa_7";
      paramPacket.putSendData(a(paramIntent.getStringArrayExtra("field_id"), paramIntent.getStringArrayExtra("uin_list")));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionServlet
 * JD-Core Version:    0.7.0.1
 */