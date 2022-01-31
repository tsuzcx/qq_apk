import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class vly
  implements uni<vau, vcs>
{
  vly(vlx paramvlx, vll paramvll) {}
  
  public void a(@NonNull vau paramvau, @Nullable vcs paramvcs, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramvcs == null) || (paramErrorMessage.isFail()))
    {
      this.jdField_a_of_type_Vll.a(paramErrorMessage, Collections.singletonList(this.jdField_a_of_type_Vlx.jdField_a_of_type_Vld));
      return;
    }
    paramvcs.jdField_a_of_type_JavaUtilList = ((uro)urr.a(5)).a(paramvcs.jdField_a_of_type_JavaUtilList);
    paramvau = paramvcs.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvau.hasNext()) {
      ((StoryVideoItem)paramvau.next()).mOwnerUid = vlw.a(this.jdField_a_of_type_Vlx.jdField_a_of_type_Vlw).uid;
    }
    ((uid)urr.a(28)).a(paramvcs.b);
    paramvau = paramvcs.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvau.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramvau.next();
      vlx.a(this.jdField_a_of_type_Vlx).add(paramErrorMessage.mVid);
    }
    if ((paramvcs.jdField_a_of_type_Boolean) || (paramvcs.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramvau = new vle(this.jdField_a_of_type_Vlx.jdField_a_of_type_Vld);
      paramvau.jdField_a_of_type_JavaUtilList = vlx.a(this.jdField_a_of_type_Vlx);
      paramvau.a(vlw.a(this.jdField_a_of_type_Vlx.jdField_a_of_type_Vlw).feedId);
      this.jdField_a_of_type_Vll.a(Collections.singletonList(paramvau), true);
      return;
    }
    vlx.a(this.jdField_a_of_type_Vlx);
    if (vlx.b(this.jdField_a_of_type_Vlx) > 50)
    {
      this.jdField_a_of_type_Vll.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.jdField_a_of_type_Vlx.jdField_a_of_type_Vld));
      return;
    }
    this.jdField_a_of_type_Vlx.a(paramvcs.c, this.jdField_a_of_type_Vll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vly
 * JD-Core Version:    0.7.0.1
 */