import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

class wuz
  extends QQUIEventReceiver<wus, xat>
{
  public wuz(@NonNull wus paramwus)
  {
    super(paramwus);
  }
  
  public void a(@NonNull wus paramwus, @NonNull xat paramxat)
  {
    if (paramxat.jdField_a_of_type_Int != 0) {
      paramwus.jdField_a_of_type_Wwe.a("fail_face", 0, 0, new String[0]);
    }
    wvc localwvc = paramwus.jdField_a_of_type_Wvc;
    if (localwvc != null)
    {
      Object localObject = localwvc.a(paramxat.jdField_a_of_type_Xaj.a);
      if (!(localObject instanceof xdo))
      {
        wsv.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramxat.jdField_a_of_type_Xaj.a);
        return;
      }
      localObject = (xdo)localObject;
      if (paramxat.jdField_a_of_type_Int == 0)
      {
        if (paramxat.jdField_a_of_type_Boolean)
        {
          wsv.b(this.TAG, "notify ui we finish downloading");
          ((xdo)localObject).jdField_a_of_type_Boolean = false;
          ((xdo)localObject).f = paramxat.jdField_a_of_type_Xaj.a();
          ((xdo)localObject).jdField_a_of_type_Int = 0;
          ((xdo)localObject).b = 0;
          localwvc.a((xdi)localObject);
          return;
        }
        wsv.a(this.TAG, "notify ui we new progress : " + paramxat.b + " / " + paramxat.jdField_a_of_type_Long);
        ((xdo)localObject).jdField_a_of_type_Boolean = true;
        ((xdo)localObject).f = null;
        ((xdo)localObject).jdField_a_of_type_Int = ((int)paramxat.jdField_a_of_type_Long);
        ((xdo)localObject).b = ((int)paramxat.b);
        localwvc.a((xdi)localObject);
        return;
      }
      ((xdo)localObject).jdField_a_of_type_Boolean = false;
      ((xdo)localObject).f = null;
      ((xdo)localObject).jdField_a_of_type_Int = 0;
      ((xdo)localObject).b = 0;
      localwvc.a((xdi)localObject);
      wsv.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramxat.jdField_a_of_type_Int);
      QQToast.a(paramwus.a(), alpo.a(2131704300), 1).a();
      wtb.a("0X80076C9");
      wtb.b("0X80075DE");
      return;
    }
    wsv.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return xat.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wuz
 * JD-Core Version:    0.7.0.1
 */