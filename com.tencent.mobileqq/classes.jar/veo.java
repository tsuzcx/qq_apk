import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class veo
  implements urr<vgs, vib>
{
  public Set<String> a = new HashSet();
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    vgs localvgs = new vgs();
    localvgs.jdField_b_of_type_JavaLangString = paramString1;
    localvgs.jdField_c_of_type_JavaLangString = paramString2;
    localvgs.jdField_a_of_type_Boolean = paramBoolean;
    localvgs.jdField_c_of_type_Int = paramInt;
    localvgs.jdField_b_of_type_Long = paramLong;
    urp.a().a(localvgs, this);
  }
  
  public void a(@NonNull vgs paramvgs, @Nullable vib paramvib, @NonNull ErrorMessage paramErrorMessage)
  {
    vep localvep = new vep();
    localvep.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localvep.jdField_a_of_type_JavaLangString = paramvgs.jdField_b_of_type_JavaLangString;
    if (xpq.a(localvep.jdField_a_of_type_JavaLangString)) {
      paramvgs.jdField_c_of_type_JavaLangString = "4_10000";
    }
    localvep.jdField_b_of_type_JavaLangString = paramvgs.jdField_c_of_type_JavaLangString;
    localvep.jdField_a_of_type_Boolean = paramvgs.jdField_a_of_type_Boolean;
    uvx localuvx = (uvx)uwa.a(5);
    if ((paramvgs.jdField_c_of_type_Int == 3) || (paramvgs.jdField_c_of_type_Int == 4) || (paramvgs.jdField_c_of_type_Int == 31) || (paramvgs.jdField_c_of_type_Int == 62))
    {
      localvep.jdField_a_of_type_Int = localuvx.a("Q.qqstory.player.WatchVideoHandler", paramvgs.jdField_c_of_type_JavaLangString, paramvgs.jdField_b_of_type_JavaLangString);
      StoryItem localStoryItem = localuvx.a(paramvgs.jdField_c_of_type_JavaLangString, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = localvep.jdField_a_of_type_Int;
        localuvx.a(paramvgs.jdField_c_of_type_JavaLangString, 1, localStoryItem);
        wxe.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramvgs.jdField_b_of_type_JavaLangString, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramvib == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.a.add(paramvgs.jdField_b_of_type_JavaLangString);
      umc.a().dispatch(localvep);
    }
    label281:
    label294:
    do
    {
      return;
      localvep.jdField_a_of_type_Int = localuvx.a(paramvgs.jdField_c_of_type_JavaLangString);
      wxe.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramvgs.jdField_b_of_type_JavaLangString, Integer.valueOf(paramvgs.jdField_c_of_type_Int));
      break;
      localuvx.a(paramvgs.jdField_c_of_type_JavaLangString, 1);
      break label210;
      umc.a().dispatch(localvep);
      paramvib = localuvx.a(paramvgs.jdField_b_of_type_JavaLangString);
    } while (paramvib == null);
    ((uvq)uwa.a(13)).a(paramvgs.jdField_b_of_type_JavaLangString, paramvgs.jdField_c_of_type_JavaLangString, paramvgs.jdField_a_of_type_Boolean, paramvib.mCreateTime, paramvgs.jdField_c_of_type_Int, paramvgs.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     veo
 * JD-Core Version:    0.7.0.1
 */