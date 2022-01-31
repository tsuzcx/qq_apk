import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class vgh
  extends QQUIEventReceiver<vga, vmb>
{
  public vgh(@NonNull vga paramvga)
  {
    super(paramvga);
  }
  
  public void a(@NonNull vga paramvga, @NonNull vmb paramvmb)
  {
    if (paramvmb.jdField_a_of_type_Int != 0) {
      paramvga.jdField_a_of_type_Vhm.a("fail_face", 0, 0, new String[0]);
    }
    vgk localvgk = paramvga.jdField_a_of_type_Vgk;
    if (localvgk != null)
    {
      Object localObject = localvgk.a(paramvmb.jdField_a_of_type_Vlr.a);
      if (!(localObject instanceof vow))
      {
        ved.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramvmb.jdField_a_of_type_Vlr.a);
        return;
      }
      localObject = (vow)localObject;
      if (paramvmb.jdField_a_of_type_Int == 0)
      {
        if (paramvmb.jdField_a_of_type_Boolean)
        {
          ved.b(this.TAG, "notify ui we finish downloading");
          ((vow)localObject).jdField_a_of_type_Boolean = false;
          ((vow)localObject).f = paramvmb.jdField_a_of_type_Vlr.a();
          ((vow)localObject).jdField_a_of_type_Int = 0;
          ((vow)localObject).b = 0;
          localvgk.a((voq)localObject);
          return;
        }
        ved.a(this.TAG, "notify ui we new progress : " + paramvmb.b + " / " + paramvmb.jdField_a_of_type_Long);
        ((vow)localObject).jdField_a_of_type_Boolean = true;
        ((vow)localObject).f = null;
        ((vow)localObject).jdField_a_of_type_Int = ((int)paramvmb.jdField_a_of_type_Long);
        ((vow)localObject).b = ((int)paramvmb.b);
        localvgk.a((voq)localObject);
        return;
      }
      ((vow)localObject).jdField_a_of_type_Boolean = false;
      ((vow)localObject).f = null;
      ((vow)localObject).jdField_a_of_type_Int = 0;
      ((vow)localObject).b = 0;
      localvgk.a((voq)localObject);
      ved.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramvmb.jdField_a_of_type_Int);
      bcql.a(paramvga.a(), ajya.a(2131703928), 1).a();
      vej.a("0X80076C9");
      vej.b("0X80075DE");
      return;
    }
    ved.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return vmb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgh
 * JD-Core Version:    0.7.0.1
 */