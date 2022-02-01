import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class wsg
  implements wfk<wuk, wvt>
{
  public Set<String> a = new HashSet();
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    wuk localwuk = new wuk();
    localwuk.jdField_b_of_type_JavaLangString = paramString1;
    localwuk.jdField_c_of_type_JavaLangString = paramString2;
    localwuk.jdField_a_of_type_Boolean = paramBoolean;
    localwuk.jdField_c_of_type_Int = paramInt;
    localwuk.jdField_b_of_type_Long = paramLong;
    wfi.a().a(localwuk, this);
  }
  
  public void a(@NonNull wuk paramwuk, @Nullable wvt paramwvt, @NonNull ErrorMessage paramErrorMessage)
  {
    wsh localwsh = new wsh();
    localwsh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localwsh.jdField_a_of_type_JavaLangString = paramwuk.jdField_b_of_type_JavaLangString;
    if (zcl.a(localwsh.jdField_a_of_type_JavaLangString)) {
      paramwuk.jdField_c_of_type_JavaLangString = "4_10000";
    }
    localwsh.jdField_b_of_type_JavaLangString = paramwuk.jdField_c_of_type_JavaLangString;
    localwsh.jdField_a_of_type_Boolean = paramwuk.jdField_a_of_type_Boolean;
    wjp localwjp = (wjp)wjs.a(5);
    if ((paramwuk.jdField_c_of_type_Int == 3) || (paramwuk.jdField_c_of_type_Int == 4) || (paramwuk.jdField_c_of_type_Int == 31) || (paramwuk.jdField_c_of_type_Int == 62))
    {
      localwsh.jdField_a_of_type_Int = localwjp.a("Q.qqstory.player.WatchVideoHandler", paramwuk.jdField_c_of_type_JavaLangString, paramwuk.jdField_b_of_type_JavaLangString);
      StoryItem localStoryItem = localwjp.a(paramwuk.jdField_c_of_type_JavaLangString, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = localwsh.jdField_a_of_type_Int;
        localwjp.a(paramwuk.jdField_c_of_type_JavaLangString, 1, localStoryItem);
        ykq.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramwuk.jdField_b_of_type_JavaLangString, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramwvt == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.a.add(paramwuk.jdField_b_of_type_JavaLangString);
      wad.a().dispatch(localwsh);
    }
    label281:
    label294:
    do
    {
      return;
      localwsh.jdField_a_of_type_Int = localwjp.a(paramwuk.jdField_c_of_type_JavaLangString);
      ykq.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramwuk.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwuk.jdField_c_of_type_Int));
      break;
      localwjp.a(paramwuk.jdField_c_of_type_JavaLangString, 1);
      break label210;
      wad.a().dispatch(localwsh);
      paramwvt = localwjp.a(paramwuk.jdField_b_of_type_JavaLangString);
    } while (paramwvt == null);
    ((wji)wjs.a(13)).a(paramwuk.jdField_b_of_type_JavaLangString, paramwuk.jdField_c_of_type_JavaLangString, paramwuk.jdField_a_of_type_Boolean, paramwvt.mCreateTime, paramwuk.jdField_c_of_type_Int, paramwuk.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsg
 * JD-Core Version:    0.7.0.1
 */