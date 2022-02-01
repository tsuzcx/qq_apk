import com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl;
import com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl.1.1;
import com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl.1.2;
import com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl.1.3;
import com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl.1.4;
import com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl.1.5;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper.ApiCallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class asgd
  implements tzd
{
  public asgd(DoraemonApiWrapperImpl paramDoraemonApiWrapperImpl, DoraemonApiWrapper.ApiCallback paramApiCallback, String paramString) {}
  
  public void onComplete()
  {
    if (DoraemonApiWrapperImpl.access$000(this.b) != null) {
      DoraemonApiWrapperImpl.access$000(this.b).queueEvent(new DoraemonApiWrapperImpl.1.4(this));
    }
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonApiWrapperImpl", 1, new Object[] { this.val$apiName, " onFailure" });
    }
    if (DoraemonApiWrapperImpl.access$000(this.b) != null) {
      DoraemonApiWrapperImpl.access$000(this.b).queueEvent(new DoraemonApiWrapperImpl.1.3(this, paramInt, paramString));
    }
  }
  
  public void onPermission(int paramInt)
  {
    if (DoraemonApiWrapperImpl.access$000(this.b) != null) {
      DoraemonApiWrapperImpl.access$000(this.b).queueEvent(new DoraemonApiWrapperImpl.1.1(this, paramInt));
    }
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonApiWrapperImpl", 1, new Object[] { this.val$apiName, " onSuccess result = ", paramJSONObject.toString() });
    }
    if (DoraemonApiWrapperImpl.access$000(this.b) != null) {
      DoraemonApiWrapperImpl.access$000(this.b).queueEvent(new DoraemonApiWrapperImpl.1.2(this, paramJSONObject));
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (DoraemonApiWrapperImpl.access$000(this.b) != null) {
      DoraemonApiWrapperImpl.access$000(this.b).queueEvent(new DoraemonApiWrapperImpl.1.5(this, paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgd
 * JD-Core Version:    0.7.0.1
 */