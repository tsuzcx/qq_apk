package com.tencent.mobileqq.vaswebviewplugin;

import Wallet.AuthCodeItem;
import Wallet.AuthCodeRsp;
import aqhq;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.File;
import java.util.ArrayList;

class QWalletCommonJsPlugin$2
  implements Runnable
{
  QWalletCommonJsPlugin$2(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = aqhq.readFile(this.val$cacheFileName);
        if (localObject1 == null)
        {
          QWalletCommonJsPlugin.access$000(this.this$0);
          return;
        }
        localObject2 = new JceInputStream((byte[])localObject1);
        localObject1 = new AuthCodeRsp();
        ((AuthCodeRsp)localObject1).readFrom((JceInputStream)localObject2);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localObject1 == null) || (((AuthCodeRsp)localObject1).items == null)) {
          break;
        }
        i = 0;
        if (i >= ((AuthCodeRsp)localObject1).items.size()) {
          break;
        }
        if ((((AuthCodeRsp)localObject1).items.get(i) == null) || (((AuthCodeItem)((AuthCodeRsp)localObject1).items.get(i)).appid != QWalletCommonJsPlugin.access$100(this.this$0)) || (((AuthCodeItem)((AuthCodeRsp)localObject1).items.get(i)).expireTime <= l)) {
          break label245;
        }
        this.this$0.doAuthCodeCallback(QWalletCommonJsPlugin.access$200(this.this$0), (AuthCodeItem)((AuthCodeRsp)localObject1).items.get(i));
        ((AuthCodeRsp)localObject1).items.remove(i);
        if (((AuthCodeRsp)localObject1).items.size() <= 0)
        {
          new File(this.val$cacheFileName).delete();
          return;
        }
      }
      catch (Exception localException)
      {
        QWalletCommonJsPlugin.access$000(this.this$0);
        return;
      }
      Object localObject2 = new JceOutputStream();
      localException.writeTo((JceOutputStream)localObject2);
      aqhq.writeFile(((JceOutputStream)localObject2).toByteArray(), this.val$cacheFileName);
      return;
      label245:
      i += 1;
    }
    QWalletCommonJsPlugin.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */