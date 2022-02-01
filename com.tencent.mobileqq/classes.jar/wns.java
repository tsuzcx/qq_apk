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

public class wns
  implements woy<xdr, xfc>
{
  public wns(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull xdr paramxdr, @Nullable xfc paramxfc, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramxfc == null))
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_Wnk });
    }
    label541:
    do
    {
      return;
      ((wnm)this.a.jdField_a_of_type_Wnk).d = (paramxfc.jdField_a_of_type_Long * 1000L);
      paramErrorMessage = ((wnm)this.a.jdField_a_of_type_Wnk).a();
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramxfc.jdField_a_of_type_JavaLangString });
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramxfc.c });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((wnm)this.a.jdField_a_of_type_Wnk).a(paramxfc.jdField_a_of_type_JavaLangString);
        paramErrorMessage.setDate(paramxfc.c);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramxfc.d))
        {
          ((wnm)this.a.jdField_a_of_type_Wnk).g = paramxfc.d;
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramxfc.d });
        }
        if (!TextUtils.isEmpty(paramxfc.e))
        {
          ((wnm)this.a.jdField_a_of_type_Wnk).g = paramxfc.e;
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramxfc.e });
        }
        ((wnm)this.a.jdField_a_of_type_Wnk).b = paramxfc.jdField_a_of_type_JavaUtilList;
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((wnm)this.a.jdField_a_of_type_Wnk).b);
        ((wnm)this.a.jdField_a_of_type_Wnk).e = paramxfc.b;
        if (!this.a.a()) {
          break label541;
        }
        this.a.a(this.a.jdField_a_of_type_Int, new ErrorMessage());
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_Wnk });
        if (this.a.jdField_a_of_type_Int != 7) {
          break;
        }
        new wzs().a(((wnm)this.a.jdField_a_of_type_Wnk).g);
        if (paramxfc.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        paramxdr = paramxfc.jdField_a_of_type_JavaUtilList.iterator();
        while (paramxdr.hasNext())
        {
          paramxfc = ((xed)paramxdr.next()).a.values().iterator();
          while (paramxfc.hasNext())
          {
            paramErrorMessage = (String)paramxfc.next();
            new wzs().a(paramErrorMessage);
          }
        }
        break;
        if (!paramErrorMessage.feedId.equals(paramxfc.jdField_a_of_type_JavaLangString)) {
          yuk.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramxfc.jdField_a_of_type_JavaLangString });
        }
      }
      this.a.a(5, new ErrorMessage());
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_Wnk });
    } while ((paramxdr.a == null) || (paramxdr.a.jdField_a_of_type_Int != 1));
    int i;
    int j;
    switch (((wnm)this.a.jdField_a_of_type_Wnk).f)
    {
    case 3: 
    case 4: 
    default: 
      i = 0;
      if (TextUtils.isEmpty(paramxdr.a.e))
      {
        j = 2;
        label667:
        paramxfc = paramxdr.a.a();
        if (paramxdr.e != 1) {
          break label745;
        }
      }
      break;
    }
    label745:
    for (paramxdr = "2";; paramxdr = "1")
    {
      yup.a("video_edit", "pub_url", j, i, new String[] { paramxfc, "", paramxdr });
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
 * Qualified Name:     wns
 * JD-Core Version:    0.7.0.1
 */