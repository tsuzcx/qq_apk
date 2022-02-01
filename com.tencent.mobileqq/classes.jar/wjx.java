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

public class wjx
  implements wld<wzw, xbh>
{
  public wjx(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull wzw paramwzw, @Nullable xbh paramxbh, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramxbh == null))
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_Wjp });
    }
    label541:
    do
    {
      return;
      ((wjr)this.a.jdField_a_of_type_Wjp).d = (paramxbh.jdField_a_of_type_Long * 1000L);
      paramErrorMessage = ((wjr)this.a.jdField_a_of_type_Wjp).a();
      yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramxbh.jdField_a_of_type_JavaLangString });
      yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramxbh.c });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((wjr)this.a.jdField_a_of_type_Wjp).a(paramxbh.jdField_a_of_type_JavaLangString);
        paramErrorMessage.setDate(paramxbh.c);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramxbh.d))
        {
          ((wjr)this.a.jdField_a_of_type_Wjp).g = paramxbh.d;
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramxbh.d });
        }
        if (!TextUtils.isEmpty(paramxbh.e))
        {
          ((wjr)this.a.jdField_a_of_type_Wjp).g = paramxbh.e;
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramxbh.e });
        }
        ((wjr)this.a.jdField_a_of_type_Wjp).b = paramxbh.jdField_a_of_type_JavaUtilList;
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((wjr)this.a.jdField_a_of_type_Wjp).b);
        ((wjr)this.a.jdField_a_of_type_Wjp).e = paramxbh.b;
        if (!this.a.a()) {
          break label541;
        }
        this.a.a(this.a.jdField_a_of_type_Int, new ErrorMessage());
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_Wjp });
        if (this.a.jdField_a_of_type_Int != 7) {
          break;
        }
        new wvx().a(((wjr)this.a.jdField_a_of_type_Wjp).g);
        if (paramxbh.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        paramwzw = paramxbh.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwzw.hasNext())
        {
          paramxbh = ((xai)paramwzw.next()).a.values().iterator();
          while (paramxbh.hasNext())
          {
            paramErrorMessage = (String)paramxbh.next();
            new wvx().a(paramErrorMessage);
          }
        }
        break;
        if (!paramErrorMessage.feedId.equals(paramxbh.jdField_a_of_type_JavaLangString)) {
          yqp.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramxbh.jdField_a_of_type_JavaLangString });
        }
      }
      this.a.a(5, new ErrorMessage());
      yqp.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_Wjp });
    } while ((paramwzw.a == null) || (paramwzw.a.jdField_a_of_type_Int != 1));
    int i;
    int j;
    switch (((wjr)this.a.jdField_a_of_type_Wjp).f)
    {
    case 3: 
    case 4: 
    default: 
      i = 0;
      if (TextUtils.isEmpty(paramwzw.a.e))
      {
        j = 2;
        label667:
        paramxbh = paramwzw.a.a();
        if (paramwzw.e != 1) {
          break label745;
        }
      }
      break;
    }
    label745:
    for (paramwzw = "2";; paramwzw = "1")
    {
      yqu.a("video_edit", "pub_url", j, i, new String[] { paramxbh, "", paramwzw });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjx
 * JD-Core Version:    0.7.0.1
 */