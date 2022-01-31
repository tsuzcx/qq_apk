import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class tln
  implements syq<tnr, tpa>
{
  public Set<String> a = new HashSet();
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    tnr localtnr = new tnr();
    localtnr.jdField_b_of_type_JavaLangString = paramString1;
    localtnr.jdField_c_of_type_JavaLangString = paramString2;
    localtnr.jdField_a_of_type_Boolean = paramBoolean;
    localtnr.jdField_c_of_type_Int = paramInt;
    localtnr.jdField_b_of_type_Long = paramLong;
    syo.a().a(localtnr, this);
  }
  
  public void a(@NonNull tnr paramtnr, @Nullable tpa paramtpa, @NonNull ErrorMessage paramErrorMessage)
  {
    tlo localtlo = new tlo();
    localtlo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localtlo.jdField_a_of_type_JavaLangString = paramtnr.jdField_b_of_type_JavaLangString;
    if (vwp.a(localtlo.jdField_a_of_type_JavaLangString)) {
      paramtnr.jdField_c_of_type_JavaLangString = "4_10000";
    }
    localtlo.jdField_b_of_type_JavaLangString = paramtnr.jdField_c_of_type_JavaLangString;
    localtlo.jdField_a_of_type_Boolean = paramtnr.jdField_a_of_type_Boolean;
    tcw localtcw = (tcw)tcz.a(5);
    if ((paramtnr.jdField_c_of_type_Int == 3) || (paramtnr.jdField_c_of_type_Int == 4) || (paramtnr.jdField_c_of_type_Int == 31) || (paramtnr.jdField_c_of_type_Int == 62))
    {
      localtlo.jdField_a_of_type_Int = localtcw.a("Q.qqstory.player.WatchVideoHandler", paramtnr.jdField_c_of_type_JavaLangString, paramtnr.jdField_b_of_type_JavaLangString);
      StoryItem localStoryItem = localtcw.a(paramtnr.jdField_c_of_type_JavaLangString, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = localtlo.jdField_a_of_type_Int;
        localtcw.a(paramtnr.jdField_c_of_type_JavaLangString, 1, localStoryItem);
        ved.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramtnr.jdField_b_of_type_JavaLangString, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramtpa == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.a.add(paramtnr.jdField_b_of_type_JavaLangString);
      stb.a().dispatch(localtlo);
    }
    label281:
    label294:
    do
    {
      return;
      localtlo.jdField_a_of_type_Int = localtcw.a(paramtnr.jdField_c_of_type_JavaLangString);
      ved.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramtnr.jdField_b_of_type_JavaLangString, Integer.valueOf(paramtnr.jdField_c_of_type_Int));
      break;
      localtcw.a(paramtnr.jdField_c_of_type_JavaLangString, 1);
      break label210;
      stb.a().dispatch(localtlo);
      paramtpa = localtcw.a(paramtnr.jdField_b_of_type_JavaLangString);
    } while (paramtpa == null);
    ((tcp)tcz.a(13)).a(paramtnr.jdField_b_of_type_JavaLangString, paramtnr.jdField_c_of_type_JavaLangString, paramtnr.jdField_a_of_type_Boolean, paramtpa.mCreateTime, paramtnr.jdField_c_of_type_Int, paramtnr.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tln
 * JD-Core Version:    0.7.0.1
 */