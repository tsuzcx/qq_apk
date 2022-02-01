import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class wya
  implements wld<xae, xbn>
{
  public Set<String> a = new HashSet();
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    xae localxae = new xae();
    localxae.jdField_b_of_type_JavaLangString = paramString1;
    localxae.jdField_c_of_type_JavaLangString = paramString2;
    localxae.jdField_a_of_type_Boolean = paramBoolean;
    localxae.jdField_c_of_type_Int = paramInt;
    localxae.jdField_b_of_type_Long = paramLong;
    wlb.a().a(localxae, this);
  }
  
  public void a(@NonNull xae paramxae, @Nullable xbn paramxbn, @NonNull ErrorMessage paramErrorMessage)
  {
    wyb localwyb = new wyb();
    localwyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localwyb.jdField_a_of_type_JavaLangString = paramxae.jdField_b_of_type_JavaLangString;
    if (zjb.a(localwyb.jdField_a_of_type_JavaLangString)) {
      paramxae.jdField_c_of_type_JavaLangString = "4_10000";
    }
    localwyb.jdField_b_of_type_JavaLangString = paramxae.jdField_c_of_type_JavaLangString;
    localwyb.jdField_a_of_type_Boolean = paramxae.jdField_a_of_type_Boolean;
    wpj localwpj = (wpj)wpm.a(5);
    if ((paramxae.jdField_c_of_type_Int == 3) || (paramxae.jdField_c_of_type_Int == 4) || (paramxae.jdField_c_of_type_Int == 31) || (paramxae.jdField_c_of_type_Int == 62))
    {
      localwyb.jdField_a_of_type_Int = localwpj.a("Q.qqstory.player.WatchVideoHandler", paramxae.jdField_c_of_type_JavaLangString, paramxae.jdField_b_of_type_JavaLangString);
      StoryItem localStoryItem = localwpj.a(paramxae.jdField_c_of_type_JavaLangString, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = localwyb.jdField_a_of_type_Int;
        localwpj.a(paramxae.jdField_c_of_type_JavaLangString, 1, localStoryItem);
        yqp.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramxae.jdField_b_of_type_JavaLangString, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramxbn == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.a.add(paramxae.jdField_b_of_type_JavaLangString);
      wfo.a().dispatch(localwyb);
    }
    label281:
    label294:
    do
    {
      return;
      localwyb.jdField_a_of_type_Int = localwpj.a(paramxae.jdField_c_of_type_JavaLangString);
      yqp.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramxae.jdField_b_of_type_JavaLangString, Integer.valueOf(paramxae.jdField_c_of_type_Int));
      break;
      localwpj.a(paramxae.jdField_c_of_type_JavaLangString, 1);
      break label210;
      wfo.a().dispatch(localwyb);
      paramxbn = localwpj.a(paramxae.jdField_b_of_type_JavaLangString);
    } while (paramxbn == null);
    ((wpc)wpm.a(13)).a(paramxae.jdField_b_of_type_JavaLangString, paramxae.jdField_c_of_type_JavaLangString, paramxae.jdField_a_of_type_Boolean, paramxbn.mCreateTime, paramxae.jdField_c_of_type_Int, paramxae.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wya
 * JD-Core Version:    0.7.0.1
 */