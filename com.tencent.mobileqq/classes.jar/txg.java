import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class txg
  implements syq<tmc, toa>
{
  txg(txf paramtxf, twt paramtwt) {}
  
  public void a(@NonNull tmc paramtmc, @Nullable toa paramtoa, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtoa == null) || (paramErrorMessage.isFail()))
    {
      this.jdField_a_of_type_Twt.a(paramErrorMessage, Collections.singletonList(this.jdField_a_of_type_Txf.jdField_a_of_type_Twl));
      return;
    }
    paramtoa.jdField_a_of_type_JavaUtilList = ((tcw)tcz.a(5)).a(paramtoa.jdField_a_of_type_JavaUtilList);
    paramtmc = paramtoa.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtmc.hasNext()) {
      ((StoryVideoItem)paramtmc.next()).mOwnerUid = txe.a(this.jdField_a_of_type_Txf.jdField_a_of_type_Txe).uid;
    }
    ((stl)tcz.a(28)).a(paramtoa.b);
    paramtmc = paramtoa.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtmc.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramtmc.next();
      txf.a(this.jdField_a_of_type_Txf).add(paramErrorMessage.mVid);
    }
    if ((paramtoa.jdField_a_of_type_Boolean) || (paramtoa.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramtmc = new twm(this.jdField_a_of_type_Txf.jdField_a_of_type_Twl);
      paramtmc.jdField_a_of_type_JavaUtilList = txf.a(this.jdField_a_of_type_Txf);
      paramtmc.a(txe.a(this.jdField_a_of_type_Txf.jdField_a_of_type_Txe).feedId);
      this.jdField_a_of_type_Twt.a(Collections.singletonList(paramtmc), true);
      return;
    }
    txf.a(this.jdField_a_of_type_Txf);
    if (txf.b(this.jdField_a_of_type_Txf) > 50)
    {
      this.jdField_a_of_type_Twt.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.jdField_a_of_type_Txf.jdField_a_of_type_Twl));
      return;
    }
    this.jdField_a_of_type_Txf.a(paramtoa.c, this.jdField_a_of_type_Twt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txg
 * JD-Core Version:    0.7.0.1
 */