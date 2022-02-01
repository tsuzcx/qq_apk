import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.io.File;

class wtx
  implements vmc
{
  wtx(wtr paramwtr, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(vma paramvma)
  {
    if (this.jdField_a_of_type_Wtr.isCanceled())
    {
      xvv.d(this.jdField_a_of_type_Wtr.a.jdField_a_of_type_JavaLangString, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramvma.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      xvv.e(this.jdField_a_of_type_Wtr.a.jdField_a_of_type_JavaLangString, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramvma.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
    if (!this.jdField_a_of_type_Wtr.a.d())
    {
      wtr.c(this.jdField_a_of_type_Wtr, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    Object localObject;
    if (paramvma.jdField_a_of_type_Boolean)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (!vmq.a((File)localObject)))
      {
        boolean bool = ((File)localObject).delete();
        xvv.d(this.jdField_a_of_type_Wtr.a.jdField_a_of_type_JavaLangString, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramvma.jdField_a_of_type_JavaLangString, Integer.valueOf(paramvma.jdField_a_of_type_Int), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramvma.b))
    {
      wtr.d(this.jdField_a_of_type_Wtr, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = wmz.a(new wnf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramvma.b, this.jdField_a_of_type_JavaLangString, "TVKsetVideoPath"));
    xvv.d(this.jdField_a_of_type_Wtr.a.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.length() - 15), paramvma.b });
    switch (i)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_Wtr.a, vls.a(paramvma.b));
      this.jdField_a_of_type_Wtr.a.c = paramvma.b;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Wtr.a, "SP", SystemClock.uptimeMillis());
      VideoViewVideoHolder.b(this.jdField_a_of_type_Wtr.a, SystemClock.uptimeMillis());
      this.jdField_a_of_type_Wtr.a.jdField_a_of_type_Wur.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_JavaLangString, paramvma.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes, (int)this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration, 0);
      return;
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_Wtr.a;
      StringBuilder localStringBuilder = new StringBuilder().append(amtj.a(2131715464));
      if (this.jdField_a_of_type_Wtr.a.b()) {}
      for (localObject = "TVK";; localObject = "TexView")
      {
        VideoViewVideoHolder.a(localVideoViewVideoHolder, (String)localObject);
        VideoViewVideoHolder.a(this.jdField_a_of_type_Wtr.a).a(this.jdField_a_of_type_Wtr.a, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramvma.b, null, false);
        break;
      }
      VideoViewVideoHolder.a(this.jdField_a_of_type_Wtr.a, amtj.a(2131715462));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Wtr.a, amtj.a(2131715456));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Wtr.a, amtj.a(2131715458));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtx
 * JD-Core Version:    0.7.0.1
 */