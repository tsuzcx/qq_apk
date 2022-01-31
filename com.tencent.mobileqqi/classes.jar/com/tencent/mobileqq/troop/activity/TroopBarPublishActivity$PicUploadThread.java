package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopBarPostContentEntity.Pic_list;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class TroopBarPublishActivity$PicUploadThread
  extends Thread
{
  protected Handler a;
  protected ArrayList a;
  protected WeakReference a;
  
  public TroopBarPublishActivity$PicUploadThread(BaseActivity paramBaseActivity, Handler paramHandler, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      localObject1 = null;
      if ((localObject1 != null) && (((BaseActivity)localObject1).b != null)) {
        break label69;
      }
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "PicUploadThread activity is null!");
      }
      localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
    }
    label69:
    String str1;
    label286:
    do
    {
      return;
      localObject1 = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      break;
      String str2 = ((BaseActivity)localObject1).b.a();
      String str3 = ((TicketManager)((BaseActivity)localObject1).b.getManager(2)).getSkey(str2);
      if (TextUtils.isEmpty(str3))
      {
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label343;
        }
        str1 = (String)localIterator.next();
        if ((TroopBarPostContentEntity.Pic_list)TroopBarUtils.a.get(str1) == null)
        {
          if (((BaseActivity)localObject1).isFinishing()) {
            break;
          }
          Object localObject2 = TroopBarUtils.b(str1);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
            ((Message)localObject1).obj = str1;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("IphoneTitleBarActivity", 2, "scalePublishImage failed: path = " + str1);
            return;
          }
          localObject2 = TroopBarUtils.a((Context)localObject1, (String)localObject2, str2, str3);
          if (localObject2 == null) {
            break label286;
          }
          localObject2 = new TroopBarPostContentEntity.Pic_list((JSONObject)localObject2);
          TroopBarUtils.a.put(str1, localObject2);
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
      ((Message)localObject1).obj = str1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarActivity", 2, "scalePublishImage failed: path = " + str1);
    return;
    label343:
    Object localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1003);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.PicUploadThread
 * JD-Core Version:    0.7.0.1
 */