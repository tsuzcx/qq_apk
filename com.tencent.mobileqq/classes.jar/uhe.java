import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class uhe
  extends ste<uhc, tli>
{
  public uhe(uhc paramuhc)
  {
    super(paramuhc);
  }
  
  public void a(@NonNull uhc paramuhc, @NonNull tli paramtli)
  {
    if (uhc.a(paramuhc) != 1) {}
    label149:
    label209:
    label218:
    for (;;)
    {
      return;
      int i = 0;
      StoryVideoItem localStoryVideoItem;
      if (i < paramtli.a.size())
      {
        localStoryVideoItem = (StoryVideoItem)paramtli.a.get(i);
        if (!localStoryVideoItem.mVid.equals(uhc.a(paramuhc))) {}
      }
      for (paramtli = localStoryVideoItem;; paramtli = null)
      {
        if ((paramtli == null) || (paramtli.mErrorCode != 0)) {
          break label218;
        }
        localStoryVideoItem = uhc.a(paramuhc).a();
        i = localStoryVideoItem.comparedLevel;
        int j = uhc.a(paramuhc).a.jdField_a_of_type_Int;
        String str = uhc.a(paramuhc).a.jdField_a_of_type_JavaLangString;
        uhc.a(paramuhc, uhc.a(paramuhc), str, false, i, j);
        paramuhc = ((tdl)tcz.a(2)).b(paramtli.mOwnerUid);
        if ((paramuhc != null) && (paramuhc.isVip))
        {
          i = 1;
          if (i == 0) {
            break label209;
          }
        }
        for (paramuhc = "2";; paramuhc = "1")
        {
          vei.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramuhc, paramtli.mVid, paramtli.mOwnerUid, localStoryVideoItem.mVid });
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
    return tli.class;
  }
  
  public void b(@NonNull uhc paramuhc, @NonNull tli paramtli) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhe
 * JD-Core Version:    0.7.0.1
 */