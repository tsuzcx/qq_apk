import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class xxl
  extends wjm<xxj, xbq>
{
  public xxl(xxj paramxxj)
  {
    super(paramxxj);
  }
  
  public void a(@NonNull xxj paramxxj, @NonNull xbq paramxbq)
  {
    if (xxj.a(paramxxj) != 1) {}
    label149:
    label209:
    label218:
    for (;;)
    {
      return;
      int i = 0;
      StoryVideoItem localStoryVideoItem;
      if (i < paramxbq.a.size())
      {
        localStoryVideoItem = (StoryVideoItem)paramxbq.a.get(i);
        if (!localStoryVideoItem.mVid.equals(xxj.a(paramxxj))) {}
      }
      for (paramxbq = localStoryVideoItem;; paramxbq = null)
      {
        if ((paramxbq == null) || (paramxbq.mErrorCode != 0)) {
          break label218;
        }
        localStoryVideoItem = xxj.a(paramxxj).a();
        i = localStoryVideoItem.comparedLevel;
        int j = xxj.a(paramxxj).a.jdField_a_of_type_Int;
        String str = xxj.a(paramxxj).a.jdField_a_of_type_JavaLangString;
        xxj.a(paramxxj, xxj.a(paramxxj), str, false, i, j);
        paramxxj = ((wtt)wth.a(2)).b(paramxbq.mOwnerUid);
        if ((paramxxj != null) && (paramxxj.isVip))
        {
          i = 1;
          if (i == 0) {
            break label209;
          }
        }
        for (paramxxj = "2";; paramxxj = "1")
        {
          yup.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramxxj, paramxbq.mVid, paramxbq.mOwnerUid, localStoryVideoItem.mVid });
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
    return xbq.class;
  }
  
  public void b(@NonNull xxj paramxxj, @NonNull xbq paramxbq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxl
 * JD-Core Version:    0.7.0.1
 */