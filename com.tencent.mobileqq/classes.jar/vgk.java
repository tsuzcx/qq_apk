import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class vgk
  extends QQUIEventReceiver<vgd, vme>
{
  public vgk(@NonNull vgd paramvgd)
  {
    super(paramvgd);
  }
  
  public void a(@NonNull vgd paramvgd, @NonNull vme paramvme)
  {
    if (paramvme.jdField_a_of_type_Int != 0) {
      paramvgd.jdField_a_of_type_Vhp.a("fail_face", 0, 0, new String[0]);
    }
    vgn localvgn = paramvgd.jdField_a_of_type_Vgn;
    if (localvgn != null)
    {
      Object localObject = localvgn.a(paramvme.jdField_a_of_type_Vlu.a);
      if (!(localObject instanceof voz))
      {
        veg.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramvme.jdField_a_of_type_Vlu.a);
        return;
      }
      localObject = (voz)localObject;
      if (paramvme.jdField_a_of_type_Int == 0)
      {
        if (paramvme.jdField_a_of_type_Boolean)
        {
          veg.b(this.TAG, "notify ui we finish downloading");
          ((voz)localObject).jdField_a_of_type_Boolean = false;
          ((voz)localObject).f = paramvme.jdField_a_of_type_Vlu.a();
          ((voz)localObject).jdField_a_of_type_Int = 0;
          ((voz)localObject).b = 0;
          localvgn.a((vot)localObject);
          return;
        }
        veg.a(this.TAG, "notify ui we new progress : " + paramvme.b + " / " + paramvme.jdField_a_of_type_Long);
        ((voz)localObject).jdField_a_of_type_Boolean = true;
        ((voz)localObject).f = null;
        ((voz)localObject).jdField_a_of_type_Int = ((int)paramvme.jdField_a_of_type_Long);
        ((voz)localObject).b = ((int)paramvme.b);
        localvgn.a((vot)localObject);
        return;
      }
      ((voz)localObject).jdField_a_of_type_Boolean = false;
      ((voz)localObject).f = null;
      ((voz)localObject).jdField_a_of_type_Int = 0;
      ((voz)localObject).b = 0;
      localvgn.a((vot)localObject);
      veg.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramvme.jdField_a_of_type_Int);
      bcpw.a(paramvgd.a(), ajyc.a(2131703917), 1).a();
      vem.a("0X80076C9");
      vem.b("0X80075DE");
      return;
    }
    veg.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return vme.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgk
 * JD-Core Version:    0.7.0.1
 */