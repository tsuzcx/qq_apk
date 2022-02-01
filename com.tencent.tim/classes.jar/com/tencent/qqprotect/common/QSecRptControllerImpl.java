package com.tencent.qqprotect.common;

import android.os.Handler.Callback;
import android.os.Message;
import aqiw;
import asxw;
import asxy;
import asya;
import aurf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.SafeReport.LogItem;
import com.tencent.ims.SafeReport.ReqBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Vector;
import jnm;
import mqq.app.MobileQQ;

public class QSecRptControllerImpl
  extends asxw
  implements Handler.Callback
{
  private static volatile asxw jdField_a_of_type_Asxw;
  private final Vector<asya> T = new Vector();
  private ReportRunnable jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable;
  private final long amK = 300000L;
  private aurf c = new aurf(ThreadManager.getSubThreadLooper(), this);
  
  private QSecRptControllerImpl()
  {
    this.c.sendEmptyMessageDelayed(12315, 300000L);
  }
  
  public static asxw a()
  {
    if (jdField_a_of_type_Asxw == null) {}
    try
    {
      if (jdField_a_of_type_Asxw == null) {
        jdField_a_of_type_Asxw = new QSecRptControllerImpl();
      }
      return jdField_a_of_type_Asxw;
    }
    finally {}
  }
  
  private void a(asya paramasya)
  {
    synchronized (this.T)
    {
      this.T.add(paramasya);
      if (QLog.isColorLevel()) {
        QLog.d("QSRPT", 2, String.format("add report: totally %d items in cache", new Object[] { Integer.valueOf(this.T.size()) }));
      }
      if ((paramasya.bvw == 2) || (this.T.size() >= 40)) {
        esk();
      }
      return;
    }
  }
  
  private void a(SafeReport.ReqBody paramReqBody)
  {
    if (paramReqBody == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSRPT", 2, String.format("totally sending report: %d items", new Object[] { Integer.valueOf(paramReqBody.LogItem_reportdata.size()) }));
    }
    jnm.a((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), new asxy(this), paramReqBody.toByteArray(), "MqqSafeDataRpt.MQDun");
  }
  
  private void esk()
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.sApplication)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable = new ReportRunnable(null);
    } while (this.jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable == null);
    synchronized (this.T)
    {
      ReportRunnable.a(this.jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable).addAll(this.T);
      this.T.removeAllElements();
      ThreadManager.post(this.jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable, 5, null, true);
      return;
    }
  }
  
  private void handleReport()
  {
    this.c.removeMessages(12315);
    esk();
    this.c.sendEmptyMessageDelayed(12315, this.amK);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 12316) {
      a((asya)paramMessage.obj);
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 12315) {
        handleReport();
      }
    }
  }
  
  public void s(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    asya localasya = new asya();
    localasya.eob = paramInt1;
    localasya.mSourceType = paramInt2;
    localasya.cFW = paramString;
    localasya.bvw = paramInt3;
    this.c.obtainMessage(12316, localasya).sendToTarget();
  }
  
  class ReportRunnable
    implements Runnable
  {
    private Vector<asya> U = new Vector();
    
    private ReportRunnable() {}
    
    public void run()
    {
      for (;;)
      {
        try
        {
          if (this.U == null) {
            break label298;
          }
          if (this.U.isEmpty()) {
            return;
          }
          localObject2 = new SafeReport.ReqBody();
          Iterator localIterator = this.U.iterator();
          int i = 0;
          int j = 0;
          if (localIterator.hasNext())
          {
            Object localObject3 = (asya)localIterator.next();
            if (localObject3 == null) {
              continue;
            }
            Object localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new SafeReport.ReqBody();
            }
            String str = asxw.gA(asxw.kU(((asya)localObject3).eob));
            localObject2 = new SafeReport.LogItem();
            ((SafeReport.LogItem)localObject2).uint32_rpt_id.set(((asya)localObject3).eob);
            localObject3 = str + "," + ((asya)localObject3).mSourceType + "," + ((asya)localObject3).cFW;
            ((SafeReport.LogItem)localObject2).bytes_rpt_data.set(ByteStringMicro.copyFrom(((String)localObject3).getBytes()));
            ((SafeReport.ReqBody)localObject1).LogItem_reportdata.add((MessageMicro)localObject2);
            j += 1;
            i = ((String)localObject3).length() + i;
            if ((j == 20) || (i > 1024))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QSRPT", 2, String.format("sending...item count: %d, package size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
              }
              QSecRptControllerImpl.a(QSecRptControllerImpl.this, (SafeReport.ReqBody)localObject1);
              localObject1 = null;
              i = 0;
              j = 0;
              break label299;
            }
          }
          else
          {
            if ((j > 0) && (localObject2 != null)) {
              QSecRptControllerImpl.a(QSecRptControllerImpl.this, (SafeReport.ReqBody)localObject2);
            }
            this.U.removeAllElements();
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        break label299;
        label298:
        return;
        label299:
        Object localObject2 = localException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptControllerImpl
 * JD-Core Version:    0.7.0.1
 */