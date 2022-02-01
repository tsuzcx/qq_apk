import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

class xxz
  extends QQUIEventReceiver<xxs, ydq>
{
  public xxz(@NonNull xxs paramxxs)
  {
    super(paramxxs);
  }
  
  public void a(@NonNull xxs paramxxs, @NonNull ydq paramydq)
  {
    if (paramydq.jdField_a_of_type_Int != 0) {
      paramxxs.jdField_a_of_type_Xzd.a("fail_face", 0, 0, new String[0]);
    }
    xyc localxyc = paramxxs.jdField_a_of_type_Xyc;
    if (localxyc != null)
    {
      Object localObject = localxyc.a(paramydq.jdField_a_of_type_Ydg.a);
      if (!(localObject instanceof yge))
      {
        xvv.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramydq.jdField_a_of_type_Ydg.a);
        return;
      }
      localObject = (yge)localObject;
      if (paramydq.jdField_a_of_type_Int == 0)
      {
        if (paramydq.jdField_a_of_type_Boolean)
        {
          xvv.b(this.TAG, "notify ui we finish downloading");
          ((yge)localObject).jdField_a_of_type_Boolean = false;
          ((yge)localObject).f = paramydq.jdField_a_of_type_Ydg.a();
          ((yge)localObject).jdField_a_of_type_Int = 0;
          ((yge)localObject).b = 0;
          localxyc.a((yfy)localObject);
          return;
        }
        xvv.a(this.TAG, "notify ui we new progress : " + paramydq.b + " / " + paramydq.jdField_a_of_type_Long);
        ((yge)localObject).jdField_a_of_type_Boolean = true;
        ((yge)localObject).f = null;
        ((yge)localObject).jdField_a_of_type_Int = ((int)paramydq.jdField_a_of_type_Long);
        ((yge)localObject).b = ((int)paramydq.b);
        localxyc.a((yfy)localObject);
        return;
      }
      ((yge)localObject).jdField_a_of_type_Boolean = false;
      ((yge)localObject).f = null;
      ((yge)localObject).jdField_a_of_type_Int = 0;
      ((yge)localObject).b = 0;
      localxyc.a((yfy)localObject);
      xvv.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramydq.jdField_a_of_type_Int);
      QQToast.a(paramxxs.a(), amtj.a(2131703047), 1).a();
      xwb.a("0X80076C9");
      xwb.b("0X80075DE");
      return;
    }
    xvv.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return ydq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxz
 * JD-Core Version:    0.7.0.1
 */