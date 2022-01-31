import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tvc
  extends QQUIEventReceiver<tvb, sjc>
{
  public tvc(@NonNull tvb paramtvb)
  {
    super(paramtvb);
  }
  
  public void a(@NonNull tvb paramtvb, @NonNull sjc paramsjc)
  {
    if ((tvb.a(paramtvb) == null) || (paramsjc.a == null) || (!TextUtils.equals(tvb.a(paramtvb).a, paramsjc.a.mVid))) {
      return;
    }
    paramtvb.a.i();
  }
  
  public Class acceptEventClass()
  {
    return sjc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvc
 * JD-Core Version:    0.7.0.1
 */