import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class wxl
  extends wwe
{
  wxl(wxa paramwxa, StoryVideoItem paramStoryVideoItem, wyi paramwyi)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    String str = (String)a("result");
    zdl.a(str);
    zdl.a(this.jdField_a_of_type_Wyi.d);
    if (this.jdField_a_of_type_Wyi.d == null)
    {
      this.jdField_a_of_type_Wyi.d = "";
      ykq.c(this.b, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.jdField_a_of_type_Wyi.d);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.jdField_a_of_type_Wyi.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxl
 * JD-Core Version:    0.7.0.1
 */