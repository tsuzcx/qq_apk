import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class xtq
  extends wfr<xto, wxv>
{
  public xtq(xto paramxto)
  {
    super(paramxto);
  }
  
  public void a(@NonNull xto paramxto, @NonNull wxv paramwxv)
  {
    if (xto.a(paramxto) != 1) {}
    label149:
    label209:
    label218:
    for (;;)
    {
      return;
      int i = 0;
      StoryVideoItem localStoryVideoItem;
      if (i < paramwxv.a.size())
      {
        localStoryVideoItem = (StoryVideoItem)paramwxv.a.get(i);
        if (!localStoryVideoItem.mVid.equals(xto.a(paramxto))) {}
      }
      for (paramwxv = localStoryVideoItem;; paramwxv = null)
      {
        if ((paramwxv == null) || (paramwxv.mErrorCode != 0)) {
          break label218;
        }
        localStoryVideoItem = xto.a(paramxto).a();
        i = localStoryVideoItem.comparedLevel;
        int j = xto.a(paramxto).a.jdField_a_of_type_Int;
        String str = xto.a(paramxto).a.jdField_a_of_type_JavaLangString;
        xto.a(paramxto, xto.a(paramxto), str, false, i, j);
        paramxto = ((wpy)wpm.a(2)).b(paramwxv.mOwnerUid);
        if ((paramxto != null) && (paramxto.isVip))
        {
          i = 1;
          if (i == 0) {
            break label209;
          }
        }
        for (paramxto = "2";; paramxto = "1")
        {
          yqu.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramxto, paramwxv.mVid, paramwxv.mOwnerUid, localStoryVideoItem.mVid });
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
    return wxv.class;
  }
  
  public void b(@NonNull xto paramxto, @NonNull wxv paramwxv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtq
 * JD-Core Version:    0.7.0.1
 */