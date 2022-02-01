import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class xha
  extends xft
{
  xha(xgp paramxgp, StoryVideoItem paramStoryVideoItem, xhx paramxhx)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    String str = (String)a("result");
    znw.a(str);
    znw.a(this.jdField_a_of_type_Xhx.d);
    if (this.jdField_a_of_type_Xhx.d == null)
    {
      this.jdField_a_of_type_Xhx.d = "";
      yuk.c(this.b, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.jdField_a_of_type_Xhx.d);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.jdField_a_of_type_Xhx.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xha
 * JD-Core Version:    0.7.0.1
 */