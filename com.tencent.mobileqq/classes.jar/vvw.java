import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class vvw
  extends uhw<vvu, vaa>
{
  public vvw(vvu paramvvu)
  {
    super(paramvvu);
  }
  
  public void a(@NonNull vvu paramvvu, @NonNull vaa paramvaa)
  {
    if (vvu.a(paramvvu) != 1) {}
    label149:
    label209:
    label218:
    for (;;)
    {
      return;
      int i = 0;
      StoryVideoItem localStoryVideoItem;
      if (i < paramvaa.a.size())
      {
        localStoryVideoItem = (StoryVideoItem)paramvaa.a.get(i);
        if (!localStoryVideoItem.mVid.equals(vvu.a(paramvvu))) {}
      }
      for (paramvaa = localStoryVideoItem;; paramvaa = null)
      {
        if ((paramvaa == null) || (paramvaa.mErrorCode != 0)) {
          break label218;
        }
        localStoryVideoItem = vvu.a(paramvvu).a();
        i = localStoryVideoItem.comparedLevel;
        int j = vvu.a(paramvvu).a.jdField_a_of_type_Int;
        String str = vvu.a(paramvvu).a.jdField_a_of_type_JavaLangString;
        vvu.a(paramvvu, vvu.a(paramvvu), str, false, i, j);
        paramvvu = ((usd)urr.a(2)).b(paramvaa.mOwnerUid);
        if ((paramvvu != null) && (paramvvu.isVip))
        {
          i = 1;
          if (i == 0) {
            break label209;
          }
        }
        for (paramvvu = "2";; paramvvu = "1")
        {
          wta.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramvvu, paramvaa.mVid, paramvaa.mOwnerUid, localStoryVideoItem.mVid });
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
    return vaa.class;
  }
  
  public void b(@NonNull vvu paramvvu, @NonNull vaa paramvaa) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvw
 * JD-Core Version:    0.7.0.1
 */