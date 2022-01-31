import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class uhh
  extends sth<uhf, tll>
{
  public uhh(uhf paramuhf)
  {
    super(paramuhf);
  }
  
  public void a(@NonNull uhf paramuhf, @NonNull tll paramtll)
  {
    if (uhf.a(paramuhf) != 1) {}
    label149:
    label209:
    label218:
    for (;;)
    {
      return;
      int i = 0;
      StoryVideoItem localStoryVideoItem;
      if (i < paramtll.a.size())
      {
        localStoryVideoItem = (StoryVideoItem)paramtll.a.get(i);
        if (!localStoryVideoItem.mVid.equals(uhf.a(paramuhf))) {}
      }
      for (paramtll = localStoryVideoItem;; paramtll = null)
      {
        if ((paramtll == null) || (paramtll.mErrorCode != 0)) {
          break label218;
        }
        localStoryVideoItem = uhf.a(paramuhf).a();
        i = localStoryVideoItem.comparedLevel;
        int j = uhf.a(paramuhf).a.jdField_a_of_type_Int;
        String str = uhf.a(paramuhf).a.jdField_a_of_type_JavaLangString;
        uhf.a(paramuhf, uhf.a(paramuhf), str, false, i, j);
        paramuhf = ((tdo)tdc.a(2)).b(paramtll.mOwnerUid);
        if ((paramuhf != null) && (paramuhf.isVip))
        {
          i = 1;
          if (i == 0) {
            break label209;
          }
        }
        for (paramuhf = "2";; paramuhf = "1")
        {
          vel.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramuhf, paramtll.mVid, paramtll.mOwnerUid, localStoryVideoItem.mVid });
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
    return tll.class;
  }
  
  public void b(@NonNull uhf paramuhf, @NonNull tll paramtll) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhh
 * JD-Core Version:    0.7.0.1
 */