import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.mobileqq.vashealth.PathTraceManager.DataUploadTask;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitPoint;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitReq;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitRsp;

public class aqtv
  implements BusinessObserver
{
  public aqtv(PathTraceManager.DataUploadTask paramDataUploadTask, JSONObject paramJSONObject, List paramList, TracePathData paramTracePathData, SharedPreferences paramSharedPreferences, QQSportsOrbit.OrbitReq paramOrbitReq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    PathTraceManager.DataUploadTask.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$DataUploadTask, paramBoolean, paramInt);
    int i;
    if (paramBoolean)
    {
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        paramBundle = new QQSportsOrbit.OrbitRsp();
        try
        {
          paramBundle.mergeFrom(arrayOfByte);
          paramInt = paramBundle.lastNum.get();
          if ((paramInt == -1) || (paramBundle.retCode.get() != 0))
          {
            this.val$result.put("retCode", -10);
            if (this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$DataUploadTask.this$0.mUIHandler == null) {
              break label802;
            }
            paramBundle = Message.obtain();
            paramBundle.what = 1;
            paramBundle.obj = this.val$result;
            this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$DataUploadTask.this$0.mUIHandler.sendMessage(paramBundle);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("PathTraceManager", 1, "[run] json fail" + localException.getMessage());
            paramInt = -1;
          }
        }
        if (paramInt >= this.Jg.size())
        {
          this.val$result.put("retCode", 1);
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$DataUploadTask.this$0.mUIHandler != null)
          {
            paramBundle = Message.obtain();
            paramBundle.what = 1;
            paramBundle.obj = this.val$result;
            this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$DataUploadTask.this$0.mUIHandler.sendMessage(paramBundle);
          }
          this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$DataUploadTask.this$0.g(Long.valueOf(this.b.startTime));
          QLog.d("PathTraceManager", 1, "upload success");
          PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$DataUploadTask.this$0, null);
          this.ab.edit().clear().commit();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("PathTraceManager", 1, "[run] json fail" + paramBundle.getMessage());
        return;
      }
      if (this.Jg.size() > 0) {
        if (this.Jg.size() > 0) {
          i = paramInt;
        }
      }
    }
    for (;;)
    {
      if (i < paramInt + 3000)
      {
        paramBundle = new QQSportsOrbit.OrbitPoint();
        paramBundle.latitude.set(((TracePointsData)this.Jg.get(i)).latitude);
        paramBundle.longitude.set(((TracePointsData)this.Jg.get(i)).longitude);
        paramBundle.timef.set((int)((TracePointsData)this.Jg.get(i)).time);
        paramBundle.speedf.set(((TracePointsData)this.Jg.get(i)).speed);
        paramBundle.accuracy.set(((TracePointsData)this.Jg.get(i)).accuracy);
        paramBundle.step.set(((TracePointsData)this.Jg.get(i)).steps);
        paramBundle.altitude.set((float)((TracePointsData)this.Jg.get(i)).altitude);
        this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.tracePath.add(paramBundle);
        if (i != this.Jg.size() - 1) {}
      }
      else
      {
        if (paramInt + 3000 >= this.Jg.size()) {
          this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.isOver.set(1);
        }
        for (;;)
        {
          this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.num.set(paramInt + 1);
          paramBundle = new NewIntent(BaseApplicationImpl.sApplication.getApplicationContext(), ailu.class);
          paramBundle.putExtra("extra_cmd", PathTraceManager.DataUploadTask.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$DataUploadTask));
          paramBundle.putExtra("extra_data", PathTraceManager.gzip(this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.toByteArray()));
          this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.tracePath.clear();
          paramBundle.putExtra("extra_timeout", 15000);
          paramBundle.setObserver(this);
          BaseApplicationImpl.sApplication.getRuntime().startServlet(paramBundle);
          return;
          this.jdField_a_of_type_TencentImPbQqsportQQSportsOrbit$OrbitReq.isOver.set(0);
        }
        QLog.e("PathTraceManager", 1, "upload fail");
        try
        {
          paramBundle = new JSONObject();
          paramBundle.put("retCode", -10);
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$DataUploadTask.this$0.mUIHandler != null)
          {
            Message localMessage = Message.obtain();
            localMessage.what = 1;
            localMessage.obj = paramBundle;
            this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$DataUploadTask.this$0.mUIHandler.sendMessage(localMessage);
            return;
          }
        }
        catch (Exception paramBundle)
        {
          QLog.d("PathTraceManager", 1, "uploadfail:" + paramBundle.toString());
        }
        label802:
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtv
 * JD-Core Version:    0.7.0.1
 */