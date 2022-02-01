import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

class yst
  extends QQUIEventReceiver<ysm, yyn>
{
  public yst(@NonNull ysm paramysm)
  {
    super(paramysm);
  }
  
  public void a(@NonNull ysm paramysm, @NonNull yyn paramyyn)
  {
    if (paramyyn.jdField_a_of_type_Int != 0) {
      paramysm.jdField_a_of_type_Yty.a("fail_face", 0, 0, new String[0]);
    }
    ysw localysw = paramysm.jdField_a_of_type_Ysw;
    if (localysw != null)
    {
      Object localObject = localysw.a(paramyyn.jdField_a_of_type_Yyd.a);
      if (!(localObject instanceof zbi))
      {
        yqp.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramyyn.jdField_a_of_type_Yyd.a);
        return;
      }
      localObject = (zbi)localObject;
      if (paramyyn.jdField_a_of_type_Int == 0)
      {
        if (paramyyn.jdField_a_of_type_Boolean)
        {
          yqp.b(this.TAG, "notify ui we finish downloading");
          ((zbi)localObject).jdField_a_of_type_Boolean = false;
          ((zbi)localObject).f = paramyyn.jdField_a_of_type_Yyd.a();
          ((zbi)localObject).jdField_a_of_type_Int = 0;
          ((zbi)localObject).b = 0;
          localysw.a((zbc)localObject);
          return;
        }
        yqp.a(this.TAG, "notify ui we new progress : " + paramyyn.b + " / " + paramyyn.jdField_a_of_type_Long);
        ((zbi)localObject).jdField_a_of_type_Boolean = true;
        ((zbi)localObject).f = null;
        ((zbi)localObject).jdField_a_of_type_Int = ((int)paramyyn.jdField_a_of_type_Long);
        ((zbi)localObject).b = ((int)paramyyn.b);
        localysw.a((zbc)localObject);
        return;
      }
      ((zbi)localObject).jdField_a_of_type_Boolean = false;
      ((zbi)localObject).f = null;
      ((zbi)localObject).jdField_a_of_type_Int = 0;
      ((zbi)localObject).b = 0;
      localysw.a((zbc)localObject);
      yqp.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramyyn.jdField_a_of_type_Int);
      QQToast.a(paramysm.a(), anni.a(2131702709), 1).a();
      yqv.a("0X80076C9");
      yqv.b("0X80075DE");
      return;
    }
    yqp.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return yyn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yst
 * JD-Core Version:    0.7.0.1
 */