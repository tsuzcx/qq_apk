import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class xnr
  extends wag<xnp, wsb>
{
  public xnr(xnp paramxnp)
  {
    super(paramxnp);
  }
  
  public void a(@NonNull xnp paramxnp, @NonNull wsb paramwsb)
  {
    if (xnp.a(paramxnp) != 1) {}
    label149:
    label209:
    label218:
    for (;;)
    {
      return;
      int i = 0;
      StoryVideoItem localStoryVideoItem;
      if (i < paramwsb.a.size())
      {
        localStoryVideoItem = (StoryVideoItem)paramwsb.a.get(i);
        if (!localStoryVideoItem.mVid.equals(xnp.a(paramxnp))) {}
      }
      for (paramwsb = localStoryVideoItem;; paramwsb = null)
      {
        if ((paramwsb == null) || (paramwsb.mErrorCode != 0)) {
          break label218;
        }
        localStoryVideoItem = xnp.a(paramxnp).a();
        i = localStoryVideoItem.comparedLevel;
        int j = xnp.a(paramxnp).a.jdField_a_of_type_Int;
        String str = xnp.a(paramxnp).a.jdField_a_of_type_JavaLangString;
        xnp.a(paramxnp, xnp.a(paramxnp), str, false, i, j);
        paramxnp = ((wke)wjs.a(2)).b(paramwsb.mOwnerUid);
        if ((paramxnp != null) && (paramxnp.isVip))
        {
          i = 1;
          if (i == 0) {
            break label209;
          }
        }
        for (paramxnp = "2";; paramxnp = "1")
        {
          ykv.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramxnp, paramwsb.mVid, paramwsb.mOwnerUid, localStoryVideoItem.mVid });
          return;
          i += 1;
          break;
          i = 0;
          break label149;
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wsb.class;
  }
  
  public void b(@NonNull xnp paramxnp, @NonNull wsb paramwsb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnr
 * JD-Core Version:    0.7.0.1
 */