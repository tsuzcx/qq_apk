import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class tlq
  implements syt<tnu, tpd>
{
  public Set<String> a = new HashSet();
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    tnu localtnu = new tnu();
    localtnu.jdField_b_of_type_JavaLangString = paramString1;
    localtnu.jdField_c_of_type_JavaLangString = paramString2;
    localtnu.jdField_a_of_type_Boolean = paramBoolean;
    localtnu.jdField_c_of_type_Int = paramInt;
    localtnu.jdField_b_of_type_Long = paramLong;
    syr.a().a(localtnu, this);
  }
  
  public void a(@NonNull tnu paramtnu, @Nullable tpd paramtpd, @NonNull ErrorMessage paramErrorMessage)
  {
    tlr localtlr = new tlr();
    localtlr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localtlr.jdField_a_of_type_JavaLangString = paramtnu.jdField_b_of_type_JavaLangString;
    if (vws.a(localtlr.jdField_a_of_type_JavaLangString)) {
      paramtnu.jdField_c_of_type_JavaLangString = "4_10000";
    }
    localtlr.jdField_b_of_type_JavaLangString = paramtnu.jdField_c_of_type_JavaLangString;
    localtlr.jdField_a_of_type_Boolean = paramtnu.jdField_a_of_type_Boolean;
    tcz localtcz = (tcz)tdc.a(5);
    if ((paramtnu.jdField_c_of_type_Int == 3) || (paramtnu.jdField_c_of_type_Int == 4) || (paramtnu.jdField_c_of_type_Int == 31) || (paramtnu.jdField_c_of_type_Int == 62))
    {
      localtlr.jdField_a_of_type_Int = localtcz.a("Q.qqstory.player.WatchVideoHandler", paramtnu.jdField_c_of_type_JavaLangString, paramtnu.jdField_b_of_type_JavaLangString);
      StoryItem localStoryItem = localtcz.a(paramtnu.jdField_c_of_type_JavaLangString, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = localtlr.jdField_a_of_type_Int;
        localtcz.a(paramtnu.jdField_c_of_type_JavaLangString, 1, localStoryItem);
        veg.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramtnu.jdField_b_of_type_JavaLangString, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramtpd == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.a.add(paramtnu.jdField_b_of_type_JavaLangString);
      ste.a().dispatch(localtlr);
    }
    label281:
    label294:
    do
    {
      return;
      localtlr.jdField_a_of_type_Int = localtcz.a(paramtnu.jdField_c_of_type_JavaLangString);
      veg.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramtnu.jdField_b_of_type_JavaLangString, Integer.valueOf(paramtnu.jdField_c_of_type_Int));
      break;
      localtcz.a(paramtnu.jdField_c_of_type_JavaLangString, 1);
      break label210;
      ste.a().dispatch(localtlr);
      paramtpd = localtcz.a(paramtnu.jdField_b_of_type_JavaLangString);
    } while (paramtpd == null);
    ((tcs)tdc.a(13)).a(paramtnu.jdField_b_of_type_JavaLangString, paramtnu.jdField_c_of_type_JavaLangString, paramtnu.jdField_a_of_type_Boolean, paramtpd.mCreateTime, paramtnu.jdField_c_of_type_Int, paramtnu.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlq
 * JD-Core Version:    0.7.0.1
 */