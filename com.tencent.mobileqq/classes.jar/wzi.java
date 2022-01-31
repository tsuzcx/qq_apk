import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

class wzi
  extends QQUIEventReceiver<wzb, xfc>
{
  public wzi(@NonNull wzb paramwzb)
  {
    super(paramwzb);
  }
  
  public void a(@NonNull wzb paramwzb, @NonNull xfc paramxfc)
  {
    if (paramxfc.jdField_a_of_type_Int != 0) {
      paramwzb.jdField_a_of_type_Xan.a("fail_face", 0, 0, new String[0]);
    }
    wzl localwzl = paramwzb.jdField_a_of_type_Wzl;
    if (localwzl != null)
    {
      Object localObject = localwzl.a(paramxfc.jdField_a_of_type_Xes.a);
      if (!(localObject instanceof xhx))
      {
        wxe.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramxfc.jdField_a_of_type_Xes.a);
        return;
      }
      localObject = (xhx)localObject;
      if (paramxfc.jdField_a_of_type_Int == 0)
      {
        if (paramxfc.jdField_a_of_type_Boolean)
        {
          wxe.b(this.TAG, "notify ui we finish downloading");
          ((xhx)localObject).jdField_a_of_type_Boolean = false;
          ((xhx)localObject).f = paramxfc.jdField_a_of_type_Xes.a();
          ((xhx)localObject).jdField_a_of_type_Int = 0;
          ((xhx)localObject).b = 0;
          localwzl.a((xhr)localObject);
          return;
        }
        wxe.a(this.TAG, "notify ui we new progress : " + paramxfc.b + " / " + paramxfc.jdField_a_of_type_Long);
        ((xhx)localObject).jdField_a_of_type_Boolean = true;
        ((xhx)localObject).f = null;
        ((xhx)localObject).jdField_a_of_type_Int = ((int)paramxfc.jdField_a_of_type_Long);
        ((xhx)localObject).b = ((int)paramxfc.b);
        localwzl.a((xhr)localObject);
        return;
      }
      ((xhx)localObject).jdField_a_of_type_Boolean = false;
      ((xhx)localObject).f = null;
      ((xhx)localObject).jdField_a_of_type_Int = 0;
      ((xhx)localObject).b = 0;
      localwzl.a((xhr)localObject);
      wxe.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramxfc.jdField_a_of_type_Int);
      QQToast.a(paramwzb.a(), alud.a(2131704312), 1).a();
      wxk.a("0X80076C9");
      wxk.b("0X80075DE");
      return;
    }
    wxe.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return xfc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzi
 * JD-Core Version:    0.7.0.1
 */