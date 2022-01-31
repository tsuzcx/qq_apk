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

public class uql
  implements urr<vgk, vhv>
{
  public uql(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull vgk paramvgk, @Nullable vhv paramvhv, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvhv == null))
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_Uqd });
    }
    label541:
    do
    {
      return;
      ((uqf)this.a.jdField_a_of_type_Uqd).d = (paramvhv.jdField_a_of_type_Long * 1000L);
      paramErrorMessage = ((uqf)this.a.jdField_a_of_type_Uqd).a();
      wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramvhv.jdField_a_of_type_JavaLangString });
      wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramvhv.c });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((uqf)this.a.jdField_a_of_type_Uqd).a(paramvhv.jdField_a_of_type_JavaLangString);
        paramErrorMessage.setDate(paramvhv.c);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramvhv.d))
        {
          ((uqf)this.a.jdField_a_of_type_Uqd).g = paramvhv.d;
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramvhv.d });
        }
        if (!TextUtils.isEmpty(paramvhv.e))
        {
          ((uqf)this.a.jdField_a_of_type_Uqd).g = paramvhv.e;
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramvhv.e });
        }
        ((uqf)this.a.jdField_a_of_type_Uqd).b = paramvhv.jdField_a_of_type_JavaUtilList;
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((uqf)this.a.jdField_a_of_type_Uqd).b);
        ((uqf)this.a.jdField_a_of_type_Uqd).e = paramvhv.b;
        if (!this.a.a()) {
          break label541;
        }
        this.a.a(this.a.jdField_a_of_type_Int, new ErrorMessage());
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_Uqd });
        if (this.a.jdField_a_of_type_Int != 7) {
          break;
        }
        new vcl().a(((uqf)this.a.jdField_a_of_type_Uqd).g);
        if (paramvhv.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        paramvgk = paramvhv.jdField_a_of_type_JavaUtilList.iterator();
        while (paramvgk.hasNext())
        {
          paramvhv = ((vgw)paramvgk.next()).a.values().iterator();
          while (paramvhv.hasNext())
          {
            paramErrorMessage = (String)paramvhv.next();
            new vcl().a(paramErrorMessage);
          }
        }
        break;
        if (!paramErrorMessage.feedId.equals(paramvhv.jdField_a_of_type_JavaLangString)) {
          wxe.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramvhv.jdField_a_of_type_JavaLangString });
        }
      }
      this.a.a(5, new ErrorMessage());
      wxe.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_Uqd });
    } while ((paramvgk.a == null) || (paramvgk.a.jdField_a_of_type_Int != 1));
    int i;
    int j;
    switch (((uqf)this.a.jdField_a_of_type_Uqd).f)
    {
    case 3: 
    case 4: 
    default: 
      i = 0;
      if (TextUtils.isEmpty(paramvgk.a.e))
      {
        j = 2;
        label667:
        paramvhv = paramvgk.a.a();
        if (paramvgk.e != 1) {
          break label745;
        }
      }
      break;
    }
    label745:
    for (paramvgk = "2";; paramvgk = "1")
    {
      wxj.a("video_edit", "pub_url", j, i, new String[] { paramvhv, "", paramvgk });
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
 * Qualified Name:     uql
 * JD-Core Version:    0.7.0.1
 */