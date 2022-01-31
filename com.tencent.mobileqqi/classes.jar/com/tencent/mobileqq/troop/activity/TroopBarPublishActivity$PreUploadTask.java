package com.tencent.mobileqq.troop.activity;

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

public class TroopBarPublishActivity$PreUploadTask
  implements Runnable
{
  protected ArrayList a;
  protected WeakReference a;
  protected boolean a;
  
  public TroopBarPublishActivity$PreUploadTask(BaseActivity paramBaseActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
  }
  
  public void run()
  {
    BaseActivity localBaseActivity;
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      localBaseActivity = null;
      if ((localBaseActivity != null) && (localBaseActivity.b != null)) {
        break label49;
      }
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "PreUploadTask activity is null!");
      }
    }
    label49:
    label194:
    for (;;)
    {
      return;
      localBaseActivity = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      break;
      String str1 = localBaseActivity.b.a();
      String str2 = ((TicketManager)localBaseActivity.b.getManager(2)).getSkey(str1);
      if (!TextUtils.isEmpty(str2))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label194;
          }
          String str3 = (String)localIterator.next();
          if ((localBaseActivity.isFinishing()) || (this.jdField_a_of_type_Boolean)) {
            break;
          }
          if ((TroopBarPostContentEntity.Pic_list)TroopBarUtils.a.get(str3) == null)
          {
            Object localObject = TroopBarUtils.b(str3);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localObject = TroopBarUtils.a(localBaseActivity, (String)localObject, str1, str2);
              if (localObject != null)
              {
                localObject = new TroopBarPostContentEntity.Pic_list((JSONObject)localObject);
                TroopBarUtils.a.put(str3, localObject);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.PreUploadTask
 * JD-Core Version:    0.7.0.1
 */