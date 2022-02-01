import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.io.File;

class xsm
  implements wkd
{
  xsm(xsg paramxsg, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(wkb paramwkb)
  {
    if (this.jdField_a_of_type_Xsg.isCanceled())
    {
      yuk.d(this.jdField_a_of_type_Xsg.a.jdField_a_of_type_JavaLangString, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramwkb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      yuk.e(this.jdField_a_of_type_Xsg.a.jdField_a_of_type_JavaLangString, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramwkb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
    if (!this.jdField_a_of_type_Xsg.a.d())
    {
      xsg.c(this.jdField_a_of_type_Xsg, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    Object localObject;
    if (paramwkb.jdField_a_of_type_Boolean)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (!wkr.a((File)localObject)))
      {
        boolean bool = ((File)localObject).delete();
        yuk.d(this.jdField_a_of_type_Xsg.a.jdField_a_of_type_JavaLangString, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramwkb.jdField_a_of_type_JavaLangString, Integer.valueOf(paramwkb.jdField_a_of_type_Int), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramwkb.b))
    {
      xsg.d(this.jdField_a_of_type_Xsg, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = xlo.a(new xlu(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramwkb.b, this.jdField_a_of_type_JavaLangString, "TVKsetVideoPath"));
    yuk.d(this.jdField_a_of_type_Xsg.a.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.length() - 15), paramwkb.b });
    switch (i)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xsg.a, wjt.a(paramwkb.b));
      this.jdField_a_of_type_Xsg.a.c = paramwkb.b;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xsg.a, "SP", SystemClock.uptimeMillis());
      VideoViewVideoHolder.b(this.jdField_a_of_type_Xsg.a, SystemClock.uptimeMillis());
      this.jdField_a_of_type_Xsg.a.jdField_a_of_type_Xtg.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_JavaLangString, paramwkb.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes, (int)this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration, 0);
      return;
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_Xsg.a;
      StringBuilder localStringBuilder = new StringBuilder().append(anzj.a(2131715230));
      if (this.jdField_a_of_type_Xsg.a.b()) {}
      for (localObject = "TVK";; localObject = "TexView")
      {
        VideoViewVideoHolder.a(localVideoViewVideoHolder, (String)localObject);
        VideoViewVideoHolder.a(this.jdField_a_of_type_Xsg.a).a(this.jdField_a_of_type_Xsg.a, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramwkb.b, null, false);
        break;
      }
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xsg.a, anzj.a(2131715228));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xsg.a, anzj.a(2131715222));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xsg.a, anzj.a(2131715224));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsm
 * JD-Core Version:    0.7.0.1
 */