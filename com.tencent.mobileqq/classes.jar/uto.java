import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class uto
  extends QQUIEventReceiver<uth, uzi>
{
  public uto(@NonNull uth paramuth)
  {
    super(paramuth);
  }
  
  public void a(@NonNull uth paramuth, @NonNull uzi paramuzi)
  {
    if (paramuzi.jdField_a_of_type_Int != 0) {
      paramuth.jdField_a_of_type_Uut.a("fail_face", 0, 0, new String[0]);
    }
    utr localutr = paramuth.jdField_a_of_type_Utr;
    if (localutr != null)
    {
      Object localObject = localutr.a(paramuzi.jdField_a_of_type_Uyy.a);
      if (!(localObject instanceof vcd))
      {
        urk.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramuzi.jdField_a_of_type_Uyy.a);
        return;
      }
      localObject = (vcd)localObject;
      if (paramuzi.jdField_a_of_type_Int == 0)
      {
        if (paramuzi.jdField_a_of_type_Boolean)
        {
          urk.b(this.TAG, "notify ui we finish downloading");
          ((vcd)localObject).jdField_a_of_type_Boolean = false;
          ((vcd)localObject).f = paramuzi.jdField_a_of_type_Uyy.a();
          ((vcd)localObject).jdField_a_of_type_Int = 0;
          ((vcd)localObject).b = 0;
          localutr.a((vbx)localObject);
          return;
        }
        urk.a(this.TAG, "notify ui we new progress : " + paramuzi.b + " / " + paramuzi.jdField_a_of_type_Long);
        ((vcd)localObject).jdField_a_of_type_Boolean = true;
        ((vcd)localObject).f = null;
        ((vcd)localObject).jdField_a_of_type_Int = ((int)paramuzi.jdField_a_of_type_Long);
        ((vcd)localObject).b = ((int)paramuzi.b);
        localutr.a((vbx)localObject);
        return;
      }
      ((vcd)localObject).jdField_a_of_type_Boolean = false;
      ((vcd)localObject).f = null;
      ((vcd)localObject).jdField_a_of_type_Int = 0;
      ((vcd)localObject).b = 0;
      localutr.a((vbx)localObject);
      urk.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramuzi.jdField_a_of_type_Int);
      bbmy.a(paramuth.a(), ajjy.a(2131638132), 1).a();
      urq.a("0X80076C9");
      urq.b("0X80075DE");
      return;
    }
    urk.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return uzi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uto
 * JD-Core Version:    0.7.0.1
 */