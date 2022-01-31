import com.dataline.core.MoloHandler;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.open.pcpush.PCPushProxy;
import com.tencent.open.pcpush.PCPushProxy.OnDownloadListener;
import com.tencent.open.pcpush.PCPushProxy.PkgEntry;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cw
  implements PCPushProxy.OnDownloadListener
{
  public cw(MoloHandler paramMoloHandler) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.a.a.a.a().a(paramString);
    switch (paramInt)
    {
    default: 
    case 1: 
    case 5: 
    case 4: 
    case 2: 
      do
      {
        do
        {
          for (;;)
          {
            return;
            QLog.d("MoloHandler", 1, "OnDownloadListener.START(" + paramString + ")");
            if (localObject != null)
            {
              paramString = ((List)localObject).iterator();
              while (paramString.hasNext())
              {
                localObject = (DataLineMsgRecord)paramString.next();
                ((DataLineMsgRecord)localObject).issuc = true;
                ((DataLineMsgRecord)localObject).fileMsgStatus = 0L;
                this.a.a.a.a().c(((DataLineMsgRecord)localObject).msgId);
                this.a.a.b(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path, Byte.valueOf((byte)DataLineHandler.EFILETYPE.FILE_TYPE_FILE.ordinal()), Boolean.valueOf(false), Boolean.valueOf(true), Long.valueOf(((DataLineMsgRecord)localObject).filesize) });
              }
              continue;
              QLog.d("MoloHandler", 1, "OnDownloadListener.CANCEL(" + paramString + ")");
              if (localObject != null)
              {
                paramString = ((List)localObject).iterator();
                while (paramString.hasNext())
                {
                  localObject = (DataLineMsgRecord)paramString.next();
                  if ((!((DataLineMsgRecord)localObject).issuc) || (((DataLineMsgRecord)localObject).progress != 1.0F))
                  {
                    ((DataLineMsgRecord)localObject).issuc = false;
                    this.a.a.a.a().g();
                    this.a.a.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
                  }
                }
              }
            }
          }
          QLog.d("MoloHandler", 1, "OnDownloadListener.FINISH(" + paramString + ")");
        } while (localObject == null);
        paramString = ((List)localObject).iterator();
        if (paramString.hasNext())
        {
          localObject = (DataLineMsgRecord)paramString.next();
          DataLineReportUtil.g(this.a.a.a);
          ((DataLineMsgRecord)localObject).issuc = true;
          ((DataLineMsgRecord)localObject).progress = 1.0F;
          ((DataLineMsgRecord)localObject).path = PCPushProxy.a().a(((DataLineMsgRecord)localObject).strMoloKey);
          if (((DataLineMsgRecord)localObject).path == null) {
            break label622;
          }
          QLog.d("MoloHandler", 1, "PCPushProxy.getDownloadPath(" + ((DataLineMsgRecord)localObject).strMoloKey + ") \"" + ((DataLineMsgRecord)localObject).path + "'");
        }
        for (;;)
        {
          this.a.a.a.a().a(((DataLineMsgRecord)localObject).msgId, ((DataLineMsgRecord)localObject).path);
          this.a.a.a.a().g();
          this.a.a.b(3, true, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
          this.a.a.a().a().a(((DataLineMsgRecord)localObject).msgId);
          break label411;
          break;
          QLog.d("MoloHandler", 1, "PCPushProxy.getDownloadPath(" + ((DataLineMsgRecord)localObject).strMoloKey + ") NULL");
        }
        QLog.d("MoloHandler", 1, "OnDownloadListener.PAUSE(" + paramString + ")");
      } while (localObject == null);
      paramString = ((List)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (DataLineMsgRecord)paramString.next();
        if ((!((DataLineMsgRecord)localObject).issuc) || (((DataLineMsgRecord)localObject).progress != 1.0F))
        {
          ((DataLineMsgRecord)localObject).issuc = false;
          ((DataLineMsgRecord)localObject).fileMsgStatus = 2L;
          this.a.a.a.a().c(((DataLineMsgRecord)localObject).msgId);
          this.a.a.a.a().g();
          this.a.a.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
        }
      }
    case 6: 
      label411:
      label622:
      QLog.d("MoloHandler", 1, "OnDownloadListener.INSTALLED(" + paramString + ")");
      DataLineReportUtil.i(this.a.a.a);
      this.a.a.b(9, true, new Object[] { paramString });
      return;
    }
    QLog.d("MoloHandler", 1, "OnDownloadListener.WAIT(" + paramString + ")");
  }
  
  public void a(PCPushProxy.PkgEntry paramPkgEntry, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if ((paramPkgEntry == null) && (paramInt1 == -25))
    {
      QLog.d("MoloHandler", 1, "onDownloadError( tm exit)");
      paramString = this.a.a.a().a().a().a();
      paramPkgEntry = this.a.a.a().a().a().a(true);
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = ((DataLineMsgSet)paramString.next()).values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
          if ((localDataLineMsgRecord.strMoloKey != null) && ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress != 1.0F)))
          {
            localDataLineMsgRecord.issuc = false;
            this.a.a.a.a().g();
            this.a.a.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path });
          }
        }
      }
      if (paramPkgEntry != null) {
        paramPkgEntry = paramPkgEntry.iterator();
      }
    }
    else
    {
      while (paramPkgEntry.hasNext())
      {
        paramString = ((DataLineMsgSet)paramPkgEntry.next()).values().iterator();
        while (paramString.hasNext())
        {
          localObject = (DataLineMsgRecord)paramString.next();
          if ((((DataLineMsgRecord)localObject).strMoloKey != null) && ((!((DataLineMsgRecord)localObject).issuc) || (((DataLineMsgRecord)localObject).progress != 1.0F)))
          {
            ((DataLineMsgRecord)localObject).issuc = false;
            this.a.a.a.a().g();
            this.a.a.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
          }
        }
        continue;
        QLog.d("MoloHandler", 1, "onDownloadError(" + paramPkgEntry.toString() + ")");
        paramPkgEntry = this.a.a.a.a().a(paramPkgEntry.a);
        if (paramPkgEntry != null) {
          break label411;
        }
      }
    }
    for (;;)
    {
      return;
      label411:
      paramPkgEntry = paramPkgEntry.iterator();
      while (paramPkgEntry.hasNext())
      {
        paramString = (DataLineMsgRecord)paramPkgEntry.next();
        DataLineReportUtil.l(this.a.a.a);
        paramString.issuc = false;
        this.a.a.a.a().g();
        this.a.a.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramString.sessionid), paramString.path });
      }
    }
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PCPushProxy.PkgEntry localPkgEntry = (PCPushProxy.PkgEntry)paramList.next();
      QLog.d("MoloHandler", 1, "onDownloadUpdate(" + localPkgEntry.e + ") " + localPkgEntry.f);
      Object localObject = this.a.a.a.a().a(localPkgEntry.a);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
          float f = localPkgEntry.f / 100.0F;
          if (localDataLineMsgRecord.progress < f) {
            localDataLineMsgRecord.progress = f;
          }
          this.a.a.b(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), Float.valueOf(f) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     cw
 * JD-Core Version:    0.7.0.1
 */