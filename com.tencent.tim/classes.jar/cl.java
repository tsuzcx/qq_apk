import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cl
{
  private asbe.a a = new cm(this);
  acde c;
  
  public cl(acde paramacde)
  {
    this.c = paramacde;
    asbe.a().a(this.a);
  }
  
  private long g(String paramString)
  {
    try
    {
      paramString = paramString.toUpperCase();
      int i = paramString.indexOf('G');
      if (i != -1) {
        return (Float.parseFloat(paramString.substring(0, i)) * 1024.0F * 1024.0F * 1024.0F);
      }
      i = paramString.indexOf('M');
      if (i != -1) {
        return (Float.parseFloat(paramString.substring(0, i)) * 1024.0F * 1024.0F);
      }
      i = paramString.indexOf('K');
      if (i != -1) {
        return (Float.parseFloat(paramString.substring(0, i)) * 1024.0F);
      }
      i = paramString.indexOf('B');
      if (i != -1)
      {
        float f = Float.parseFloat(paramString.substring(0, i));
        return f;
      }
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public boolean A(String paramString)
  {
    asbe.a().IL(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy pause(" + paramString + ")");
    }
    return true;
  }
  
  public void F(int paramInt)
  {
    asbe.a().F(paramInt);
  }
  
  public boolean W()
  {
    if ((this.c == null) || (this.c.getApp() == null) || (this.c.getApp().a() == null))
    {
      QLog.e("dataline.MoloHandler", 1, "cancelAll app about = null");
      return false;
    }
    Object localObject2 = this.c.getApp().a().a(0).a();
    Object localObject1 = this.c.getApp().a().a(0).a(true);
    localObject2 = ((DataLineMsgSetList)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((DataLineMsgSet)((Iterator)localObject2).next()).values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject3).next();
        if (localDataLineMsgRecord.strMoloKey != null) {
          A(localDataLineMsgRecord.strMoloKey);
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((DataLineMsgSetList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (DataLineMsgRecord)((Iterator)localObject2).next();
          if (((DataLineMsgRecord)localObject3).strMoloKey != null) {
            A(((DataLineMsgRecord)localObject3).strMoloKey);
          }
        }
      }
    }
    return true;
  }
  
  public boolean X()
  {
    if ((this.c == null) || (this.c.getApp() == null) || (this.c.getApp().a() == null))
    {
      QLog.e("dataline.MoloHandler", 1, "deleteAll app about = null");
      return false;
    }
    Object localObject2 = this.c.getApp().a().a(0).a();
    Object localObject1 = this.c.getApp().a().a(0).a(true);
    localObject2 = ((DataLineMsgSetList)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((DataLineMsgSet)((Iterator)localObject2).next()).values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject3).next();
        if (localDataLineMsgRecord.strMoloKey != null) {
          delete(localDataLineMsgRecord.strMoloKey);
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((DataLineMsgSetList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (DataLineMsgRecord)((Iterator)localObject2).next();
          if (((DataLineMsgRecord)localObject3).strMoloKey != null) {
            delete(((DataLineMsgRecord)localObject3).strMoloKey);
          }
        }
      }
    }
    return true;
  }
  
  public DataLineMsgRecord a(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    Object localObject = null;
    asbe.a().a(this.a);
    for (;;)
    {
      try
      {
        asbe.b localb = asbe.a().a(paramArrayOfByte);
        paramArrayOfByte = localObject;
        if (localb != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("dataline.MoloHandler", 2, "dealWith new pkgEntry:" + localb.appName);
          }
          long l = this.c.a(0).longValue();
          paramArrayOfByte = new DataLineMsgRecord();
          paramArrayOfByte.msg = this.c.getApp().getApp().getString(2131695395);
          paramArrayOfByte.msgtype = -2335;
          paramArrayOfByte.sessionid = l;
          paramArrayOfByte.isread = false;
          paramArrayOfByte.path = null;
          paramArrayOfByte.thumbPath = null;
          paramArrayOfByte.filename = localb.appName;
          paramArrayOfByte.filesize = g(localb.cEa);
          paramArrayOfByte.issuc = false;
          paramArrayOfByte.vipBubbleID = this.c.Ao();
          paramArrayOfByte.time = anaz.gQ();
          paramArrayOfByte.strMoloKey = localb.key;
          paramArrayOfByte.strMoloSource = localb.source;
          paramArrayOfByte.strMoloIconUrl = localb.iconUrl;
          paramArrayOfByte.strMoloSrcIconUrl = localb.cEb;
          if (localb.fileType != 1) {
            break label300;
          }
          bool1 = true;
          paramArrayOfByte.bIsApkFile = bool1;
          if (ahav.getFileType(paramArrayOfByte.filename) != 0) {
            break label305;
          }
          bool1 = bool2;
          paramArrayOfByte.bIsMoloImage = bool1;
          paramArrayOfByte.fileMsgStatus = 1L;
        }
      }
      catch (Exception localException)
      {
        paramArrayOfByte = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("dataline.MoloHandler", 2, "PCPushProxy.parse Exception:" + localException.toString());
        return null;
      }
      return paramArrayOfByte;
      label300:
      boolean bool1 = false;
      continue;
      label305:
      bool1 = false;
    }
  }
  
  public void cg()
  {
    asbe.a().b(this.a);
  }
  
  public boolean delete(String paramString)
  {
    asbe.a().delete(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy delete(" + paramString + ")");
    }
    return true;
  }
  
  public boolean isInstalled(String paramString)
  {
    boolean bool = asbe.a().isInstalled(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy isInstalled(" + paramString + "):" + bool);
    }
    return bool;
  }
  
  public int open(String paramString)
  {
    cu.j(this.c.app);
    int i = asbe.a().open(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy open(" + paramString + "):" + i);
    }
    return i;
  }
  
  public void report(int paramInt)
  {
    asbe.a().report(paramInt);
  }
  
  public boolean y(String paramString)
  {
    boolean bool = asbe.a().y(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy start(" + paramString + "):" + bool);
    }
    if (bool)
    {
      paramString = this.c.app.a(0).am(paramString);
      if (paramString == null) {
        return bool;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramString.next();
        localDataLineMsgRecord.issuc = true;
        localDataLineMsgRecord.fileMsgStatus = 0L;
        this.c.app.b().a(0).ig(localDataLineMsgRecord.msgId);
        this.c.e(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(true), Long.valueOf(localDataLineMsgRecord.filesize) });
      }
    }
    return bool;
  }
  
  public boolean z(String paramString)
  {
    cu.h(this.c.app);
    asbe.a().Xz(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy install : " + paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     cl
 * JD-Core Version:    0.7.0.1
 */