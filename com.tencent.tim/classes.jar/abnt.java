import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.1;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.2;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class abnt
  extends asrs
{
  abnt(abnq paramabnq) {}
  
  public void aP(boolean paramBoolean, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", paramInt);
      abmt.a().callbackFromRequest(abnq.a(this.this$0), paramInt, "cs.audioRoom_set_mic.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmGameAvHandler", 2, "onMicStateChange error=" + localException.toString());
    }
  }
  
  public void aQ(boolean paramBoolean, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", paramInt);
      abmt.a().callbackFromRequest(abnq.a(this.this$0), paramInt, "cs.audioRoom_set_speaker.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmGameAvHandler", 2, "onSpeakerStateChange error=" + localException.toString());
    }
  }
  
  public void bM(int paramInt, String paramString)
  {
    if (paramInt != 0) {
      QLog.d("AVManager", 2, "on connect res=" + paramInt);
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("res", 0);
      abmt.a().callbackFromRequest(abnq.a(this.this$0), paramInt, "cs.audioRoom_init.local", paramString.toString());
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void bN(int paramInt, String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post(new CmGameAvHandler.15.1(this, paramInt));
  }
  
  public void bO(int paramInt, String paramString)
  {
    try
    {
      abnq.c(this.this$0, false);
      paramString = new JSONObject();
      paramString.put("res", "ok");
      abmt.a().callbackFromRequest(abnq.a(this.this$0), 0, "cs.audioRoom_disconnect.local", paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameAvHandler", 2, "onDisconnectRoom error=" + paramString.toString());
    }
  }
  
  public void f(int paramInt, String[] paramArrayOfString)
  {
    JSONObject localJSONObject1;
    ArrayList localArrayList;
    JSONArray localJSONArray1;
    JSONArray localJSONArray2;
    abpc localabpc;
    int i;
    Object localObject;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject1.put("lState", abnq.a(this.this$0));
      localJSONObject1.put("eventId", paramInt);
      localArrayList = new ArrayList();
      localJSONArray1 = new JSONArray();
      localJSONArray2 = new JSONArray();
      abmt.a();
      localabpc = abmt.a(abnq.a(this.this$0));
      if (localabpc != null) {
        break label488;
      }
      return;
    }
    catch (Exception paramArrayOfString)
    {
      JSONObject localJSONObject2;
      QLog.e("CmGameAvHandler", 2, "requestVideo error e=" + paramArrayOfString.toString());
      return;
    }
    if (i < paramArrayOfString.length)
    {
      localObject = localabpc.iC(paramArrayOfString[i]);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localArrayList.add(Long.valueOf(Long.parseLong(paramArrayOfString[i])));
        localJSONArray2.put(paramArrayOfString[i]);
      }
      else
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("openId", localObject);
        localJSONArray1.put(localJSONObject2);
      }
    }
    else
    {
      if (localJSONArray1.length() > 0)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("openIds", localJSONArray1);
        ((JSONObject)localObject).put("eventId", paramInt);
        ((JSONObject)localObject).put("userInfo", localJSONArray1);
        abmt.a().callbackFromRequest(abnq.a(this.this$0), 0, "cs.audioRoom_update_userinfo.local", ((JSONObject)localObject).toString());
      }
      if (localArrayList.size() > 0)
      {
        localJSONObject1.put("identifierList", localJSONArray2.toString());
        if (localabpc != null) {
          localabpc.a(1, null, localArrayList, 8, abnq.a(this.this$0), false, localJSONObject1.toString(), "");
        }
      }
      if (!QLog.isColorLevel()) {
        break label500;
      }
      QLog.d("CmGameAvHandler", 2, "avroom updateUserInfo data=" + localJSONObject1.toString() + " eventId=" + paramInt);
      break label500;
      label359:
      if (paramInt < paramArrayOfString.length) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < abnq.a(this.this$0).size())
      {
        if (((String)abnq.a(this.this$0).get(i)).equals(paramArrayOfString[paramInt])) {
          i = 1;
        }
      }
      else
      {
        for (;;)
        {
          if (i == 0)
          {
            abnq.a(this.this$0).add(paramArrayOfString[paramInt]);
            break label510;
            if (abnq.a(this.this$0))
            {
              paramArrayOfString = (CmGameAppInterface)abmt.getAppInterface();
              abnq.a(this.this$0, (String[])abnq.a(this.this$0).toArray(new String[abnq.a(this.this$0).size()]), paramArrayOfString.getCurrentAccountUin());
              return;
              i = 0;
            }
            else
            {
              label488:
              label500:
              do
              {
                return;
                i = 0;
                break;
                i += 1;
                break;
              } while (paramInt != 3);
              paramInt = 0;
              break;
            }
          }
        }
        label510:
        paramInt += 1;
        break label359;
      }
      i += 1;
    }
  }
  
  public void onExitRoomComplete()
  {
    try
    {
      abnq.c(this.this$0, false);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", "ok");
      if (this.this$0.b != null) {
        this.this$0.b.cBw();
      }
      abvq.a().a(null);
      abvq.a().cFM();
      abnq.a(this.this$0).clear();
      abmt.a().callbackFromRequest(abnq.a(this.this$0), 0, "cs.audioRoom_exit.local", localJSONObject.toString());
      new Handler(Looper.getMainLooper()).postDelayed(new CmGameAvHandler.15.2(this), 1000L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmGameAvHandler", 2, "onExitRoomComplete error=" + localException.toString());
    }
  }
  
  public void onSemiAutoRecvCameraVideo(String[] paramArrayOfString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abnt
 * JD-Core Version:    0.7.0.1
 */