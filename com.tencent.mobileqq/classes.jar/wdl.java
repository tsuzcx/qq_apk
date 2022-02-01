import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class wdl
  implements vqp<wfp, wgy>
{
  public Set<String> a = new HashSet();
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    wfp localwfp = new wfp();
    localwfp.jdField_b_of_type_JavaLangString = paramString1;
    localwfp.jdField_c_of_type_JavaLangString = paramString2;
    localwfp.jdField_a_of_type_Boolean = paramBoolean;
    localwfp.jdField_c_of_type_Int = paramInt;
    localwfp.jdField_b_of_type_Long = paramLong;
    vqn.a().a(localwfp, this);
  }
  
  public void a(@NonNull wfp paramwfp, @Nullable wgy paramwgy, @NonNull ErrorMessage paramErrorMessage)
  {
    wdm localwdm = new wdm();
    localwdm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localwdm.jdField_a_of_type_JavaLangString = paramwfp.jdField_b_of_type_JavaLangString;
    if (yns.a(localwdm.jdField_a_of_type_JavaLangString)) {
      paramwfp.jdField_c_of_type_JavaLangString = "4_10000";
    }
    localwdm.jdField_b_of_type_JavaLangString = paramwfp.jdField_c_of_type_JavaLangString;
    localwdm.jdField_a_of_type_Boolean = paramwfp.jdField_a_of_type_Boolean;
    vuu localvuu = (vuu)vux.a(5);
    if ((paramwfp.jdField_c_of_type_Int == 3) || (paramwfp.jdField_c_of_type_Int == 4) || (paramwfp.jdField_c_of_type_Int == 31) || (paramwfp.jdField_c_of_type_Int == 62))
    {
      localwdm.jdField_a_of_type_Int = localvuu.a("Q.qqstory.player.WatchVideoHandler", paramwfp.jdField_c_of_type_JavaLangString, paramwfp.jdField_b_of_type_JavaLangString);
      StoryItem localStoryItem = localvuu.a(paramwfp.jdField_c_of_type_JavaLangString, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = localwdm.jdField_a_of_type_Int;
        localvuu.a(paramwfp.jdField_c_of_type_JavaLangString, 1, localStoryItem);
        xvv.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramwfp.jdField_b_of_type_JavaLangString, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramwgy == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.a.add(paramwfp.jdField_b_of_type_JavaLangString);
      vli.a().dispatch(localwdm);
    }
    label281:
    label294:
    do
    {
      return;
      localwdm.jdField_a_of_type_Int = localvuu.a(paramwfp.jdField_c_of_type_JavaLangString);
      xvv.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramwfp.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwfp.jdField_c_of_type_Int));
      break;
      localvuu.a(paramwfp.jdField_c_of_type_JavaLangString, 1);
      break label210;
      vli.a().dispatch(localwdm);
      paramwgy = localvuu.a(paramwfp.jdField_b_of_type_JavaLangString);
    } while (paramwgy == null);
    ((vun)vux.a(13)).a(paramwfp.jdField_b_of_type_JavaLangString, paramwfp.jdField_c_of_type_JavaLangString, paramwfp.jdField_a_of_type_Boolean, paramwgy.mCreateTime, paramwfp.jdField_c_of_type_Int, paramwfp.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdl
 * JD-Core Version:    0.7.0.1
 */