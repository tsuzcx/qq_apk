import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class vqx
  implements vqt
{
  private static final String jdField_a_of_type_JavaLangString = String.valueOf(140000);
  baif jdField_a_of_type_Baif;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public vqx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Baif = ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36));
  }
  
  private String a(String paramString)
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public QQCircleCounter.RedPointInfo a(String paramString)
  {
    int i = 0;
    paramString = this.jdField_a_of_type_Baif.a(a(paramString));
    if (paramString != null)
    {
      boolean bool;
      if (paramString.iNewFlag.get() == 1) {
        bool = true;
      }
      for (;;)
      {
        Object localObject1 = paramString.buffer.get();
        QLog.e("TianShuRedPointManagerDelegate", 1, "getSmallRedPointInfotByAppid hasSmallRedPoint: " + bool + ", buffer: " + (String)localObject1);
        if ((!bool) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label219;
        }
        paramString = new QQCircleCounter.RedPointInfo();
        paramString.redType.set(1);
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          Object localObject2 = ((JSONObject)localObject1).optString("_show_mission");
          localObject1 = ((JSONObject)localObject1).optJSONObject("param").optJSONObject((String)localObject2).optJSONArray("uin");
          if (localObject1 != null)
          {
            int j = ((JSONArray)localObject1).length();
            while (i < j)
            {
              localObject2 = new QQCircleCounter.RedDisplayInfo();
              ((QQCircleCounter.RedDisplayInfo)localObject2).headImg.set(((JSONArray)localObject1).getString(i));
              paramString.rptRedInfo.add((MessageMicro)localObject2);
              i += 1;
              continue;
              bool = false;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("TianShuRedPointManagerDelegate", 1, "getSmallRedPointInfotByAppid buffer error!");
        }
      }
      return paramString;
    }
    label219:
    return null;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Baif.b(a(paramString));
  }
  
  public void a(String paramString, vqv paramvqv, boolean paramBoolean)
  {
    this.jdField_a_of_type_Baif.a(paramvqv, paramBoolean);
  }
  
  public void a(String paramString, vqw paramvqw)
  {
    a(paramString);
  }
  
  public QQCircleCounter.RedPointInfo b(String paramString)
  {
    if (this.jdField_a_of_type_Baif.a(a(paramString)) != null)
    {
      paramString = new QQCircleCounter.RedPointInfo();
      paramString.redType.set(2);
      int i = this.jdField_a_of_type_Baif.a(null, true);
      paramString.redTotalNum.set(i);
      return paramString;
    }
    return null;
  }
  
  public void b(String paramString)
  {
    paramString = this.jdField_a_of_type_Baif.a(a(paramString));
    this.jdField_a_of_type_Baif.a(paramString, 9, "");
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqx
 * JD-Core Version:    0.7.0.1
 */