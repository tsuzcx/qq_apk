import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class wiq
  extends whj
{
  wiq(wif paramwif, StoryVideoItem paramStoryVideoItem, wjn paramwjn)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    String str = (String)a("result");
    yos.a(str);
    yos.a(this.jdField_a_of_type_Wjn.d);
    if (this.jdField_a_of_type_Wjn.d == null)
    {
      this.jdField_a_of_type_Wjn.d = "";
      xvv.c(this.b, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.jdField_a_of_type_Wjn.d);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.jdField_a_of_type_Wjn.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wiq
 * JD-Core Version:    0.7.0.1
 */