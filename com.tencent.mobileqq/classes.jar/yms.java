import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

class yms
  extends QQUIEventReceiver<yml, ysj>
{
  public yms(@NonNull yml paramyml)
  {
    super(paramyml);
  }
  
  public void a(@NonNull yml paramyml, @NonNull ysj paramysj)
  {
    if (paramysj.jdField_a_of_type_Int != 0) {
      paramyml.jdField_a_of_type_Ynw.a("fail_face", 0, 0, new String[0]);
    }
    ymv localymv = paramyml.jdField_a_of_type_Ymv;
    if (localymv != null)
    {
      Object localObject = localymv.a(paramysj.jdField_a_of_type_Yrz.a);
      if (!(localObject instanceof yux))
      {
        ykq.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramysj.jdField_a_of_type_Yrz.a);
        return;
      }
      localObject = (yux)localObject;
      if (paramysj.jdField_a_of_type_Int == 0)
      {
        if (paramysj.jdField_a_of_type_Boolean)
        {
          ykq.b(this.TAG, "notify ui we finish downloading");
          ((yux)localObject).jdField_a_of_type_Boolean = false;
          ((yux)localObject).f = paramysj.jdField_a_of_type_Yrz.a();
          ((yux)localObject).jdField_a_of_type_Int = 0;
          ((yux)localObject).b = 0;
          localymv.a((yur)localObject);
          return;
        }
        ykq.a(this.TAG, "notify ui we new progress : " + paramysj.b + " / " + paramysj.jdField_a_of_type_Long);
        ((yux)localObject).jdField_a_of_type_Boolean = true;
        ((yux)localObject).f = null;
        ((yux)localObject).jdField_a_of_type_Int = ((int)paramysj.jdField_a_of_type_Long);
        ((yux)localObject).b = ((int)paramysj.b);
        localymv.a((yur)localObject);
        return;
      }
      ((yux)localObject).jdField_a_of_type_Boolean = false;
      ((yux)localObject).f = null;
      ((yux)localObject).jdField_a_of_type_Int = 0;
      ((yux)localObject).b = 0;
      localymv.a((yur)localObject);
      ykq.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramysj.jdField_a_of_type_Int);
      QQToast.a(paramyml.a(), anvx.a(2131703398), 1).a();
      ykw.a("0X80076C9");
      ykw.b("0X80075DE");
      return;
    }
    ykq.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return ysj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yms
 * JD-Core Version:    0.7.0.1
 */