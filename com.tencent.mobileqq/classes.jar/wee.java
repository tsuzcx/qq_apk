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

public class wee
  implements wfk<wuc, wvn>
{
  public wee(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull wuc paramwuc, @Nullable wvn paramwvn, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwvn == null))
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_Wdw });
    }
    label541:
    do
    {
      return;
      ((wdy)this.a.jdField_a_of_type_Wdw).d = (paramwvn.jdField_a_of_type_Long * 1000L);
      paramErrorMessage = ((wdy)this.a.jdField_a_of_type_Wdw).a();
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramwvn.jdField_a_of_type_JavaLangString });
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramwvn.c });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((wdy)this.a.jdField_a_of_type_Wdw).a(paramwvn.jdField_a_of_type_JavaLangString);
        paramErrorMessage.setDate(paramwvn.c);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramwvn.d))
        {
          ((wdy)this.a.jdField_a_of_type_Wdw).g = paramwvn.d;
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramwvn.d });
        }
        if (!TextUtils.isEmpty(paramwvn.e))
        {
          ((wdy)this.a.jdField_a_of_type_Wdw).g = paramwvn.e;
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramwvn.e });
        }
        ((wdy)this.a.jdField_a_of_type_Wdw).b = paramwvn.jdField_a_of_type_JavaUtilList;
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((wdy)this.a.jdField_a_of_type_Wdw).b);
        ((wdy)this.a.jdField_a_of_type_Wdw).e = paramwvn.b;
        if (!this.a.a()) {
          break label541;
        }
        this.a.a(this.a.jdField_a_of_type_Int, new ErrorMessage());
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_Wdw });
        if (this.a.jdField_a_of_type_Int != 7) {
          break;
        }
        new wqd().a(((wdy)this.a.jdField_a_of_type_Wdw).g);
        if (paramwvn.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        paramwuc = paramwvn.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwuc.hasNext())
        {
          paramwvn = ((wuo)paramwuc.next()).a.values().iterator();
          while (paramwvn.hasNext())
          {
            paramErrorMessage = (String)paramwvn.next();
            new wqd().a(paramErrorMessage);
          }
        }
        break;
        if (!paramErrorMessage.feedId.equals(paramwvn.jdField_a_of_type_JavaLangString)) {
          ykq.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramwvn.jdField_a_of_type_JavaLangString });
        }
      }
      this.a.a(5, new ErrorMessage());
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_Wdw });
    } while ((paramwuc.a == null) || (paramwuc.a.jdField_a_of_type_Int != 1));
    int i;
    int j;
    switch (((wdy)this.a.jdField_a_of_type_Wdw).f)
    {
    default: 
      i = 0;
      if (TextUtils.isEmpty(paramwuc.a.e))
      {
        j = 2;
        label655:
        paramwvn = paramwuc.a.a();
        if (paramwuc.e != 1) {
          break label727;
        }
      }
      break;
    }
    label727:
    for (paramwuc = "2";; paramwuc = "1")
    {
      ykv.a("video_edit", "pub_url", j, i, new String[] { paramwvn, "", paramwuc });
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
 * Qualified Name:     wee
 * JD-Core Version:    0.7.0.1
 */