package com.tencent.mobileqq.magicface.magicfaceaction;

import android.os.Vibrator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceSensorOperation;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.qphone.base.util.QLog;
import gag;
import gah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class Action
{
  public static final String a = "Action";
  public int a;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  public ActionGlobalData a;
  public ActionProcess a;
  private MagicfaceDecoder.MagicPlayListener jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener = new gag(this);
  private MagicfacePlayRes jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes;
  public MagicfacePlayManager a;
  public List a;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask = new gah(this);
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public boolean a;
  public int b;
  public String b;
  public volatile boolean b;
  private int jdField_c_of_type_Int = 0;
  private volatile boolean jdField_c_of_type_Boolean = false;
  
  public Action()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = ((MagicfacePlayRes)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    MagicfacePlayRes localMagicfacePlayRes;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localMagicfacePlayRes = (MagicfacePlayRes)localIterator.next();
    } while ((localMagicfacePlayRes.jdField_a_of_type_Int > this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int) || (localMagicfacePlayRes.jdField_b_of_type_Int <= this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = localMagicfacePlayRes;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int > 0) {
      ThreadManager.a().schedule(this.jdField_a_of_type_JavaUtilTimerTask, this.jdField_a_of_type_Int * 1000);
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {}
    do
    {
      do
      {
        do
        {
          return;
          ActionProcess localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString)) || (paramInt < this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int)) {
            break;
          }
          b();
        } while (paramMagicfaceSensorOperation == null);
        paramMagicfaceSensorOperation.a();
        return;
        paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString));
      paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
      paramMagicfaceSensorOperation.jdField_b_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.a(paramInt);
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.k = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float);
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    c();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.g);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidOsVibrator.cancel();
      }
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Action", 2, "===Magicaction is stop====");
      }
      return true;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
  
  public void b(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {}
    do
    {
      do
      {
        do
        {
          return;
          ActionProcess localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString)) || (paramInt < this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d))) {
            break;
          }
          b();
        } while (paramMagicfaceSensorOperation == null);
        paramMagicfaceSensorOperation.a();
        return;
        paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString));
      paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
      paramMagicfaceSensorOperation.jdField_b_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.a(paramInt);
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.k = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float);
  }
  
  public void c(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {}
    do
    {
      do
      {
        return;
        ActionProcess localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d)) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int != paramInt));
      b();
    } while (paramMagicfaceSensorOperation == null);
    paramMagicfaceSensorOperation.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.Action
 * JD-Core Version:    0.7.0.1
 */