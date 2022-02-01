import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class xbv
  implements woy<xdz, xfi>
{
  public Set<String> a = new HashSet();
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    xdz localxdz = new xdz();
    localxdz.jdField_b_of_type_JavaLangString = paramString1;
    localxdz.jdField_c_of_type_JavaLangString = paramString2;
    localxdz.jdField_a_of_type_Boolean = paramBoolean;
    localxdz.jdField_c_of_type_Int = paramInt;
    localxdz.jdField_b_of_type_Long = paramLong;
    wow.a().a(localxdz, this);
  }
  
  public void a(@NonNull xdz paramxdz, @Nullable xfi paramxfi, @NonNull ErrorMessage paramErrorMessage)
  {
    xbw localxbw = new xbw();
    localxbw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localxbw.jdField_a_of_type_JavaLangString = paramxdz.jdField_b_of_type_JavaLangString;
    if (zmw.a(localxbw.jdField_a_of_type_JavaLangString)) {
      paramxdz.jdField_c_of_type_JavaLangString = "4_10000";
    }
    localxbw.jdField_b_of_type_JavaLangString = paramxdz.jdField_c_of_type_JavaLangString;
    localxbw.jdField_a_of_type_Boolean = paramxdz.jdField_a_of_type_Boolean;
    wte localwte = (wte)wth.a(5);
    if ((paramxdz.jdField_c_of_type_Int == 3) || (paramxdz.jdField_c_of_type_Int == 4) || (paramxdz.jdField_c_of_type_Int == 31) || (paramxdz.jdField_c_of_type_Int == 62))
    {
      localxbw.jdField_a_of_type_Int = localwte.a("Q.qqstory.player.WatchVideoHandler", paramxdz.jdField_c_of_type_JavaLangString, paramxdz.jdField_b_of_type_JavaLangString);
      StoryItem localStoryItem = localwte.a(paramxdz.jdField_c_of_type_JavaLangString, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = localxbw.jdField_a_of_type_Int;
        localwte.a(paramxdz.jdField_c_of_type_JavaLangString, 1, localStoryItem);
        yuk.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramxdz.jdField_b_of_type_JavaLangString, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramxfi == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.a.add(paramxdz.jdField_b_of_type_JavaLangString);
      wjj.a().dispatch(localxbw);
    }
    label281:
    label294:
    do
    {
      return;
      localxbw.jdField_a_of_type_Int = localwte.a(paramxdz.jdField_c_of_type_JavaLangString);
      yuk.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramxdz.jdField_b_of_type_JavaLangString, Integer.valueOf(paramxdz.jdField_c_of_type_Int));
      break;
      localwte.a(paramxdz.jdField_c_of_type_JavaLangString, 1);
      break label210;
      wjj.a().dispatch(localxbw);
      paramxfi = localwte.a(paramxdz.jdField_b_of_type_JavaLangString);
    } while (paramxfi == null);
    ((wsx)wth.a(13)).a(paramxdz.jdField_b_of_type_JavaLangString, paramxdz.jdField_c_of_type_JavaLangString, paramxdz.jdField_a_of_type_Boolean, paramxfi.mCreateTime, paramxdz.jdField_c_of_type_Int, paramxdz.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbv
 * JD-Core Version:    0.7.0.1
 */