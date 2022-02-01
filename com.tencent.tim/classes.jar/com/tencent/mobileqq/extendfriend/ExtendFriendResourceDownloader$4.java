package com.tencent.mobileqq.extendfriend;

import afsi.b;
import afss;
import afsw;
import aoll;
import aolm;
import com.tencent.qphone.base.util.QLog;
import ige;

public class ExtendFriendResourceDownloader$4
  implements Runnable
{
  public ExtendFriendResourceDownloader$4(afss paramafss, afsi.b paramb) {}
  
  public void run()
  {
    aoll localaoll = new aoll();
    localaoll.bZ = this.a.url;
    localaoll.mHttpMethod = 0;
    String str = afss.a(this.this$0, this.a.md5);
    afss.a(this.this$0, str);
    localaoll.atY = str;
    localaoll.bw(this.a);
    QLog.d("ExtendFriendResourceDownloader", 2, "Limitchatres start download : " + this.a.name + " url: " + this.a.url + " w:" + localaoll.atY);
    localaoll.f = new afsw(this);
    ige.a().a(localaoll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */