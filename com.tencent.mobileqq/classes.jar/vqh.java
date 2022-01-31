import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class vqh
  implements urr<vfd, vhb>
{
  vqh(vqg paramvqg, vpu paramvpu) {}
  
  public void a(@NonNull vfd paramvfd, @Nullable vhb paramvhb, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramvhb == null) || (paramErrorMessage.isFail()))
    {
      this.jdField_a_of_type_Vpu.a(paramErrorMessage, Collections.singletonList(this.jdField_a_of_type_Vqg.jdField_a_of_type_Vpm));
      return;
    }
    paramvhb.jdField_a_of_type_JavaUtilList = ((uvx)uwa.a(5)).a(paramvhb.jdField_a_of_type_JavaUtilList);
    paramvfd = paramvhb.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvfd.hasNext()) {
      ((StoryVideoItem)paramvfd.next()).mOwnerUid = vqf.a(this.jdField_a_of_type_Vqg.jdField_a_of_type_Vqf).uid;
    }
    ((umm)uwa.a(28)).a(paramvhb.b);
    paramvfd = paramvhb.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvfd.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramvfd.next();
      vqg.a(this.jdField_a_of_type_Vqg).add(paramErrorMessage.mVid);
    }
    if ((paramvhb.jdField_a_of_type_Boolean) || (paramvhb.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramvfd = new vpn(this.jdField_a_of_type_Vqg.jdField_a_of_type_Vpm);
      paramvfd.jdField_a_of_type_JavaUtilList = vqg.a(this.jdField_a_of_type_Vqg);
      paramvfd.a(vqf.a(this.jdField_a_of_type_Vqg.jdField_a_of_type_Vqf).feedId);
      this.jdField_a_of_type_Vpu.a(Collections.singletonList(paramvfd), true);
      return;
    }
    vqg.a(this.jdField_a_of_type_Vqg);
    if (vqg.b(this.jdField_a_of_type_Vqg) > 50)
    {
      this.jdField_a_of_type_Vpu.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.jdField_a_of_type_Vqg.jdField_a_of_type_Vpm));
      return;
    }
    this.jdField_a_of_type_Vqg.a(paramvhb.c, this.jdField_a_of_type_Vpu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqh
 * JD-Core Version:    0.7.0.1
 */