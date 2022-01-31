import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class tul
  extends sgl<tuj, syp>
{
  public tul(tuj paramtuj)
  {
    super(paramtuj);
  }
  
  public void a(@NonNull tuj paramtuj, @NonNull syp paramsyp)
  {
    if (tuj.a(paramtuj) != 1) {}
    label149:
    label209:
    label218:
    for (;;)
    {
      return;
      int i = 0;
      StoryVideoItem localStoryVideoItem;
      if (i < paramsyp.a.size())
      {
        localStoryVideoItem = (StoryVideoItem)paramsyp.a.get(i);
        if (!localStoryVideoItem.mVid.equals(tuj.a(paramtuj))) {}
      }
      for (paramsyp = localStoryVideoItem;; paramsyp = null)
      {
        if ((paramsyp == null) || (paramsyp.mErrorCode != 0)) {
          break label218;
        }
        localStoryVideoItem = tuj.a(paramtuj).a();
        i = localStoryVideoItem.comparedLevel;
        int j = tuj.a(paramtuj).a.jdField_a_of_type_Int;
        String str = tuj.a(paramtuj).a.jdField_a_of_type_JavaLangString;
        tuj.a(paramtuj, tuj.a(paramtuj), str, false, i, j);
        paramtuj = ((sqs)sqg.a(2)).b(paramsyp.mOwnerUid);
        if ((paramtuj != null) && (paramtuj.isVip))
        {
          i = 1;
          if (i == 0) {
            break label209;
          }
        }
        for (paramtuj = "2";; paramtuj = "1")
        {
          urp.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramtuj, paramsyp.mVid, paramsyp.mOwnerUid, localStoryVideoItem.mVid });
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
    return syp.class;
  }
  
  public void b(@NonNull tuj paramtuj, @NonNull syp paramsyp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tul
 * JD-Core Version:    0.7.0.1
 */