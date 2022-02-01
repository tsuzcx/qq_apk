import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class wyw
  extends vll<wyu, wdg>
{
  public wyw(wyu paramwyu)
  {
    super(paramwyu);
  }
  
  public void a(@NonNull wyu paramwyu, @NonNull wdg paramwdg)
  {
    if (wyu.a(paramwyu) != 1) {}
    label149:
    label209:
    label218:
    for (;;)
    {
      return;
      int i = 0;
      StoryVideoItem localStoryVideoItem;
      if (i < paramwdg.a.size())
      {
        localStoryVideoItem = (StoryVideoItem)paramwdg.a.get(i);
        if (!localStoryVideoItem.mVid.equals(wyu.a(paramwyu))) {}
      }
      for (paramwdg = localStoryVideoItem;; paramwdg = null)
      {
        if ((paramwdg == null) || (paramwdg.mErrorCode != 0)) {
          break label218;
        }
        localStoryVideoItem = wyu.a(paramwyu).a();
        i = localStoryVideoItem.comparedLevel;
        int j = wyu.a(paramwyu).a.jdField_a_of_type_Int;
        String str = wyu.a(paramwyu).a.jdField_a_of_type_JavaLangString;
        wyu.a(paramwyu, wyu.a(paramwyu), str, false, i, j);
        paramwyu = ((vvj)vux.a(2)).b(paramwdg.mOwnerUid);
        if ((paramwyu != null) && (paramwyu.isVip))
        {
          i = 1;
          if (i == 0) {
            break label209;
          }
        }
        for (paramwyu = "2";; paramwyu = "1")
        {
          xwa.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramwyu, paramwdg.mVid, paramwdg.mOwnerUid, localStoryVideoItem.mVid });
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
    return wdg.class;
  }
  
  public void b(@NonNull wyu paramwyu, @NonNull wdg paramwdg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyw
 * JD-Core Version:    0.7.0.1
 */