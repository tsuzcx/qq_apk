import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class umc
  implements uni<vcb, vdm>
{
  public umc(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull vcb paramvcb, @Nullable vdm paramvdm, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvdm == null))
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_Ulu });
    }
    label541:
    do
    {
      return;
      ((ulw)this.a.jdField_a_of_type_Ulu).d = (paramvdm.jdField_a_of_type_Long * 1000L);
      paramErrorMessage = ((ulw)this.a.jdField_a_of_type_Ulu).a();
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramvdm.jdField_a_of_type_JavaLangString });
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramvdm.c });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((ulw)this.a.jdField_a_of_type_Ulu).a(paramvdm.jdField_a_of_type_JavaLangString);
        paramErrorMessage.setDate(paramvdm.c);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramvdm.d))
        {
          ((ulw)this.a.jdField_a_of_type_Ulu).g = paramvdm.d;
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramvdm.d });
        }
        if (!TextUtils.isEmpty(paramvdm.e))
        {
          ((ulw)this.a.jdField_a_of_type_Ulu).g = paramvdm.e;
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramvdm.e });
        }
        ((ulw)this.a.jdField_a_of_type_Ulu).b = paramvdm.jdField_a_of_type_JavaUtilList;
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((ulw)this.a.jdField_a_of_type_Ulu).b);
        ((ulw)this.a.jdField_a_of_type_Ulu).e = paramvdm.b;
        if (!this.a.a()) {
          break label541;
        }
        this.a.a(this.a.jdField_a_of_type_Int, new ErrorMessage());
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_Ulu });
        if (this.a.jdField_a_of_type_Int != 7) {
          break;
        }
        new uyc().a(((ulw)this.a.jdField_a_of_type_Ulu).g);
        if (paramvdm.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        paramvcb = paramvdm.jdField_a_of_type_JavaUtilList.iterator();
        while (paramvcb.hasNext())
        {
          paramvdm = ((vcn)paramvcb.next()).a.values().iterator();
          while (paramvdm.hasNext())
          {
            paramErrorMessage = (String)paramvdm.next();
            new uyc().a(paramErrorMessage);
          }
        }
        break;
        if (!paramErrorMessage.feedId.equals(paramvdm.jdField_a_of_type_JavaLangString)) {
          wsv.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramvdm.jdField_a_of_type_JavaLangString });
        }
      }
      this.a.a(5, new ErrorMessage());
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_Ulu });
    } while ((paramvcb.a == null) || (paramvcb.a.jdField_a_of_type_Int != 1));
    int i;
    int j;
    switch (((ulw)this.a.jdField_a_of_type_Ulu).f)
    {
    case 3: 
    case 4: 
    default: 
      i = 0;
      if (TextUtils.isEmpty(paramvcb.a.e))
      {
        j = 2;
        label667:
        paramvdm = paramvcb.a.a();
        if (paramvcb.e != 1) {
          break label745;
        }
      }
      break;
    }
    label745:
    for (paramvcb = "2";; paramvcb = "1")
    {
      wta.a("video_edit", "pub_url", j, i, new String[] { paramvdm, "", paramvcb });
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      j = 1;
      break label667;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     umc
 * JD-Core Version:    0.7.0.1
 */