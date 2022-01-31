import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.io.File;

class ucf
  implements stv
{
  ucf(ubz paramubz, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(stt paramstt)
  {
    if (this.jdField_a_of_type_Ubz.isCanceled())
    {
      ved.d(this.jdField_a_of_type_Ubz.a.jdField_a_of_type_JavaLangString, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramstt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      ved.e(this.jdField_a_of_type_Ubz.a.jdField_a_of_type_JavaLangString, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramstt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
    if (!this.jdField_a_of_type_Ubz.a.d())
    {
      ubz.c(this.jdField_a_of_type_Ubz, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    Object localObject;
    if (paramstt.jdField_a_of_type_Boolean)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (!suj.a((File)localObject)))
      {
        boolean bool = ((File)localObject).delete();
        ved.d(this.jdField_a_of_type_Ubz.a.jdField_a_of_type_JavaLangString, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramstt.jdField_a_of_type_JavaLangString, Integer.valueOf(paramstt.jdField_a_of_type_Int), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramstt.b))
    {
      ubz.d(this.jdField_a_of_type_Ubz, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = tvh.a(new tvn(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramstt.b, this.jdField_a_of_type_JavaLangString, "TVKsetVideoPath"));
    ved.d(this.jdField_a_of_type_Ubz.a.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.length() - 15), paramstt.b });
    switch (i)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_Ubz.a, stl.a(paramstt.b));
      this.jdField_a_of_type_Ubz.a.c = paramstt.b;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Ubz.a, "SP", SystemClock.uptimeMillis());
      VideoViewVideoHolder.b(this.jdField_a_of_type_Ubz.a, SystemClock.uptimeMillis());
      this.jdField_a_of_type_Ubz.a.jdField_a_of_type_Ucz.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_JavaLangString, paramstt.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes, (int)this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration, 0);
      return;
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_Ubz.a;
      StringBuilder localStringBuilder = new StringBuilder().append(ajya.a(2131716460));
      if (this.jdField_a_of_type_Ubz.a.b()) {}
      for (localObject = "TVK";; localObject = "TexView")
      {
        VideoViewVideoHolder.a(localVideoViewVideoHolder, (String)localObject);
        VideoViewVideoHolder.a(this.jdField_a_of_type_Ubz.a).a(this.jdField_a_of_type_Ubz.a, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramstt.b, null, false);
        break;
      }
      VideoViewVideoHolder.a(this.jdField_a_of_type_Ubz.a, ajya.a(2131716458));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Ubz.a, ajya.a(2131716452));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Ubz.a, ajya.a(2131716454));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucf
 * JD-Core Version:    0.7.0.1
 */