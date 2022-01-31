import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class vaf
  implements uni<vcj, vds>
{
  public Set<String> a = new HashSet();
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    vcj localvcj = new vcj();
    localvcj.jdField_b_of_type_JavaLangString = paramString1;
    localvcj.jdField_c_of_type_JavaLangString = paramString2;
    localvcj.jdField_a_of_type_Boolean = paramBoolean;
    localvcj.jdField_c_of_type_Int = paramInt;
    localvcj.jdField_b_of_type_Long = paramLong;
    ung.a().a(localvcj, this);
  }
  
  public void a(@NonNull vcj paramvcj, @Nullable vds paramvds, @NonNull ErrorMessage paramErrorMessage)
  {
    vag localvag = new vag();
    localvag.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localvag.jdField_a_of_type_JavaLangString = paramvcj.jdField_b_of_type_JavaLangString;
    if (xlh.a(localvag.jdField_a_of_type_JavaLangString)) {
      paramvcj.jdField_c_of_type_JavaLangString = "4_10000";
    }
    localvag.jdField_b_of_type_JavaLangString = paramvcj.jdField_c_of_type_JavaLangString;
    localvag.jdField_a_of_type_Boolean = paramvcj.jdField_a_of_type_Boolean;
    uro localuro = (uro)urr.a(5);
    if ((paramvcj.jdField_c_of_type_Int == 3) || (paramvcj.jdField_c_of_type_Int == 4) || (paramvcj.jdField_c_of_type_Int == 31) || (paramvcj.jdField_c_of_type_Int == 62))
    {
      localvag.jdField_a_of_type_Int = localuro.a("Q.qqstory.player.WatchVideoHandler", paramvcj.jdField_c_of_type_JavaLangString, paramvcj.jdField_b_of_type_JavaLangString);
      StoryItem localStoryItem = localuro.a(paramvcj.jdField_c_of_type_JavaLangString, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = localvag.jdField_a_of_type_Int;
        localuro.a(paramvcj.jdField_c_of_type_JavaLangString, 1, localStoryItem);
        wsv.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramvcj.jdField_b_of_type_JavaLangString, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramvds == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.a.add(paramvcj.jdField_b_of_type_JavaLangString);
      uht.a().dispatch(localvag);
    }
    label281:
    label294:
    do
    {
      return;
      localvag.jdField_a_of_type_Int = localuro.a(paramvcj.jdField_c_of_type_JavaLangString);
      wsv.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramvcj.jdField_b_of_type_JavaLangString, Integer.valueOf(paramvcj.jdField_c_of_type_Int));
      break;
      localuro.a(paramvcj.jdField_c_of_type_JavaLangString, 1);
      break label210;
      uht.a().dispatch(localvag);
      paramvds = localuro.a(paramvcj.jdField_b_of_type_JavaLangString);
    } while (paramvds == null);
    ((urh)urr.a(13)).a(paramvcj.jdField_b_of_type_JavaLangString, paramvcj.jdField_c_of_type_JavaLangString, paramvcj.jdField_a_of_type_Boolean, paramvds.mCreateTime, paramvcj.jdField_c_of_type_Int, paramvcj.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vaf
 * JD-Core Version:    0.7.0.1
 */