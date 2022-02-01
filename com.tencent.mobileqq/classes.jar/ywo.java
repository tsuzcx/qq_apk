import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

class ywo
  extends QQUIEventReceiver<ywh, zci>
{
  public ywo(@NonNull ywh paramywh)
  {
    super(paramywh);
  }
  
  public void a(@NonNull ywh paramywh, @NonNull zci paramzci)
  {
    if (paramzci.jdField_a_of_type_Int != 0) {
      paramywh.jdField_a_of_type_Yxt.a("fail_face", 0, 0, new String[0]);
    }
    ywr localywr = paramywh.jdField_a_of_type_Ywr;
    if (localywr != null)
    {
      Object localObject = localywr.a(paramzci.jdField_a_of_type_Zby.a);
      if (!(localObject instanceof zfd))
      {
        yuk.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramzci.jdField_a_of_type_Zby.a);
        return;
      }
      localObject = (zfd)localObject;
      if (paramzci.jdField_a_of_type_Int == 0)
      {
        if (paramzci.jdField_a_of_type_Boolean)
        {
          yuk.b(this.TAG, "notify ui we finish downloading");
          ((zfd)localObject).jdField_a_of_type_Boolean = false;
          ((zfd)localObject).f = paramzci.jdField_a_of_type_Zby.a();
          ((zfd)localObject).jdField_a_of_type_Int = 0;
          ((zfd)localObject).b = 0;
          localywr.a((zex)localObject);
          return;
        }
        yuk.a(this.TAG, "notify ui we new progress : " + paramzci.b + " / " + paramzci.jdField_a_of_type_Long);
        ((zfd)localObject).jdField_a_of_type_Boolean = true;
        ((zfd)localObject).f = null;
        ((zfd)localObject).jdField_a_of_type_Int = ((int)paramzci.jdField_a_of_type_Long);
        ((zfd)localObject).b = ((int)paramzci.b);
        localywr.a((zex)localObject);
        return;
      }
      ((zfd)localObject).jdField_a_of_type_Boolean = false;
      ((zfd)localObject).f = null;
      ((zfd)localObject).jdField_a_of_type_Int = 0;
      ((zfd)localObject).b = 0;
      localywr.a((zex)localObject);
      yuk.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramzci.jdField_a_of_type_Int);
      QQToast.a(paramywh.a(), anzj.a(2131702816), 1).a();
      yuq.a("0X80076C9");
      yuq.b("0X80075DE");
      return;
    }
    yuk.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return zci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywo
 * JD-Core Version:    0.7.0.1
 */