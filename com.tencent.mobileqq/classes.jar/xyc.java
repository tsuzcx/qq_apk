import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xyc
  extends QQUIEventReceiver<xyb, wmd>
{
  public xyc(@NonNull xyb paramxyb)
  {
    super(paramxyb);
  }
  
  public void a(@NonNull xyb paramxyb, @NonNull wmd paramwmd)
  {
    if ((xyb.a(paramxyb) == null) || (paramwmd.a == null) || (!TextUtils.equals(xyb.a(paramxyb).a, paramwmd.a.mVid))) {
      return;
    }
    paramxyb.a.i();
  }
  
  public Class acceptEventClass()
  {
    return wmd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyc
 * JD-Core Version:    0.7.0.1
 */