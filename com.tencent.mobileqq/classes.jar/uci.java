import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.io.File;

class uci
  implements sty
{
  uci(ucc paramucc, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(stw paramstw)
  {
    if (this.jdField_a_of_type_Ucc.isCanceled())
    {
      veg.d(this.jdField_a_of_type_Ucc.a.jdField_a_of_type_JavaLangString, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramstw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      veg.e(this.jdField_a_of_type_Ucc.a.jdField_a_of_type_JavaLangString, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramstw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
    if (!this.jdField_a_of_type_Ucc.a.d())
    {
      ucc.c(this.jdField_a_of_type_Ucc, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    Object localObject;
    if (paramstw.jdField_a_of_type_Boolean)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (!sum.a((File)localObject)))
      {
        boolean bool = ((File)localObject).delete();
        veg.d(this.jdField_a_of_type_Ucc.a.jdField_a_of_type_JavaLangString, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramstw.jdField_a_of_type_JavaLangString, Integer.valueOf(paramstw.jdField_a_of_type_Int), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramstw.b))
    {
      ucc.d(this.jdField_a_of_type_Ucc, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = tvk.a(new tvq(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramstw.b, this.jdField_a_of_type_JavaLangString, "TVKsetVideoPath"));
    veg.d(this.jdField_a_of_type_Ucc.a.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.length() - 15), paramstw.b });
    switch (i)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_Ucc.a, sto.a(paramstw.b));
      this.jdField_a_of_type_Ucc.a.c = paramstw.b;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Ucc.a, "SP", SystemClock.uptimeMillis());
      VideoViewVideoHolder.b(this.jdField_a_of_type_Ucc.a, SystemClock.uptimeMillis());
      this.jdField_a_of_type_Ucc.a.jdField_a_of_type_Udc.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_JavaLangString, paramstw.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes, (int)this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration, 0);
      return;
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_Ucc.a;
      StringBuilder localStringBuilder = new StringBuilder().append(ajyc.a(2131716449));
      if (this.jdField_a_of_type_Ucc.a.b()) {}
      for (localObject = "TVK";; localObject = "TexView")
      {
        VideoViewVideoHolder.a(localVideoViewVideoHolder, (String)localObject);
        VideoViewVideoHolder.a(this.jdField_a_of_type_Ucc.a).a(this.jdField_a_of_type_Ucc.a, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramstw.b, null, false);
        break;
      }
      VideoViewVideoHolder.a(this.jdField_a_of_type_Ucc.a, ajyc.a(2131716447));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Ucc.a, ajyc.a(2131716441));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Ucc.a, ajyc.a(2131716443));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uci
 * JD-Core Version:    0.7.0.1
 */