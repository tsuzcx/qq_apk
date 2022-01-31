import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class waf
  extends umf<wad, vej>
{
  public waf(wad paramwad)
  {
    super(paramwad);
  }
  
  public void a(@NonNull wad paramwad, @NonNull vej paramvej)
  {
    if (wad.a(paramwad) != 1) {}
    label149:
    label209:
    label218:
    for (;;)
    {
      return;
      int i = 0;
      StoryVideoItem localStoryVideoItem;
      if (i < paramvej.a.size())
      {
        localStoryVideoItem = (StoryVideoItem)paramvej.a.get(i);
        if (!localStoryVideoItem.mVid.equals(wad.a(paramwad))) {}
      }
      for (paramvej = localStoryVideoItem;; paramvej = null)
      {
        if ((paramvej == null) || (paramvej.mErrorCode != 0)) {
          break label218;
        }
        localStoryVideoItem = wad.a(paramwad).a();
        i = localStoryVideoItem.comparedLevel;
        int j = wad.a(paramwad).a.jdField_a_of_type_Int;
        String str = wad.a(paramwad).a.jdField_a_of_type_JavaLangString;
        wad.a(paramwad, wad.a(paramwad), str, false, i, j);
        paramwad = ((uwm)uwa.a(2)).b(paramvej.mOwnerUid);
        if ((paramwad != null) && (paramwad.isVip))
        {
          i = 1;
          if (i == 0) {
            break label209;
          }
        }
        for (paramwad = "2";; paramwad = "1")
        {
          wxj.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramwad, paramvej.mVid, paramvej.mOwnerUid, localStoryVideoItem.mVid });
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
    return vej.class;
  }
  
  public void b(@NonNull wad paramwad, @NonNull vej paramvej) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     waf
 * JD-Core Version:    0.7.0.1
 */