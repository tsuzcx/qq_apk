package com.tencent.mobileqq.filemanager.core;

import agkd;
import agkd.a;
import agke.a;
import agke.b;
import com.tencent.qphone.base.util.QLog;
import java.net.InetSocketAddress;
import java.net.Socket;

public class FileIPv6Detecter$1
  implements Runnable
{
  public FileIPv6Detecter$1(agkd paramagkd, agke.b paramb, long paramLong, agke.a parama) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject1 = new Socket();
    for (;;)
    {
      try
      {
        int j = this.jdField_a_of_type_Agke$b.mPort;
        i = j;
        if (j == 0) {
          i = 80;
        }
        ((Socket)localObject1).connect(new InetSocketAddress(this.jdField_a_of_type_Agke$b.vb(), i), 6000);
      }
      catch (Exception localException4)
      {
        int i;
        long l;
        localException4.printStackTrace();
        try
        {
          localException1.close();
          i = 1;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          i = 1;
        }
        continue;
      }
      finally
      {
        try
        {
          localException2.close();
          throw localObject2;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          continue;
        }
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
      }
      try
      {
        ((Socket)localObject1).close();
        i = 0;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        i = 0;
      }
    }
    l = System.currentTimeMillis();
    localObject1 = new StringBuilder().append("[IPv6-File] delectIP Result:");
    if (i == 0)
    {
      bool1 = true;
      QLog.i("FileIPv6Detecter<FileAssistant>", 1, bool1 + " cost:" + (l - this.YB) + " [" + this.jdField_a_of_type_Agke$a.mDomain + ":" + this.jdField_a_of_type_Agke$a.mPort + "] ipInfo[" + this.jdField_a_of_type_Agke$b.mIp + ":" + this.jdField_a_of_type_Agke$b.mPort + "]");
      localObject1 = agkd.a(this.this$0, this.jdField_a_of_type_Agke$a);
      if (localObject1 != null)
      {
        ((agkd.a)localObject1).cdI = false;
        if (i != 0) {
          break label322;
        }
        bool1 = true;
        ((agkd.a)localObject1).cdH = bool1;
        localObject1 = this.this$0;
        if (i != 0) {
          break label327;
        }
        bool1 = bool2;
        agkd.a((agkd)localObject1, bool1, this.jdField_a_of_type_Agke$a.mDomain, this.jdField_a_of_type_Agke$b.vb(), this.jdField_a_of_type_Agke$b.mPort);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6Detecter.1
 * JD-Core Version:    0.7.0.1
 */