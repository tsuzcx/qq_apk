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

public class vpj
  implements vqp<wfh, wgs>
{
  public vpj(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull wfh paramwfh, @Nullable wgs paramwgs, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwgs == null))
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_Vpb });
    }
    label541:
    do
    {
      return;
      ((vpd)this.a.jdField_a_of_type_Vpb).d = (paramwgs.jdField_a_of_type_Long * 1000L);
      paramErrorMessage = ((vpd)this.a.jdField_a_of_type_Vpb).a();
      xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramwgs.jdField_a_of_type_JavaLangString });
      xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramwgs.c });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((vpd)this.a.jdField_a_of_type_Vpb).a(paramwgs.jdField_a_of_type_JavaLangString);
        paramErrorMessage.setDate(paramwgs.c);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramwgs.d))
        {
          ((vpd)this.a.jdField_a_of_type_Vpb).g = paramwgs.d;
          xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramwgs.d });
        }
        if (!TextUtils.isEmpty(paramwgs.e))
        {
          ((vpd)this.a.jdField_a_of_type_Vpb).g = paramwgs.e;
          xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramwgs.e });
        }
        ((vpd)this.a.jdField_a_of_type_Vpb).b = paramwgs.jdField_a_of_type_JavaUtilList;
        xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((vpd)this.a.jdField_a_of_type_Vpb).b);
        ((vpd)this.a.jdField_a_of_type_Vpb).e = paramwgs.b;
        if (!this.a.a()) {
          break label541;
        }
        this.a.a(this.a.jdField_a_of_type_Int, new ErrorMessage());
        xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_Vpb });
        if (this.a.jdField_a_of_type_Int != 7) {
          break;
        }
        new wbi().a(((vpd)this.a.jdField_a_of_type_Vpb).g);
        if (paramwgs.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        paramwfh = paramwgs.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwfh.hasNext())
        {
          paramwgs = ((wft)paramwfh.next()).a.values().iterator();
          while (paramwgs.hasNext())
          {
            paramErrorMessage = (String)paramwgs.next();
            new wbi().a(paramErrorMessage);
          }
        }
        break;
        if (!paramErrorMessage.feedId.equals(paramwgs.jdField_a_of_type_JavaLangString)) {
          xvv.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramwgs.jdField_a_of_type_JavaLangString });
        }
      }
      this.a.a(5, new ErrorMessage());
      xvv.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_Vpb });
    } while ((paramwfh.a == null) || (paramwfh.a.jdField_a_of_type_Int != 1));
    int i;
    int j;
    switch (((vpd)this.a.jdField_a_of_type_Vpb).f)
    {
    default: 
      i = 0;
      if (TextUtils.isEmpty(paramwfh.a.e))
      {
        j = 2;
        label655:
        paramwgs = paramwfh.a.a();
        if (paramwfh.e != 1) {
          break label727;
        }
      }
      break;
    }
    label727:
    for (paramwfh = "2";; paramwfh = "1")
    {
      xwa.a("video_edit", "pub_url", j, i, new String[] { paramwgs, "", paramwfh });
      return;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      j = 1;
      break label655;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpj
 * JD-Core Version:    0.7.0.1
 */