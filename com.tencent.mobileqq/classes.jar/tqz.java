import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class tqz
  extends tpm
{
  tqz(tqk paramtqk, StoryVideoItem paramStoryVideoItem, trs paramtrs)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    String str = (String)a("result");
    vxs.a(str);
    vxs.a(this.jdField_a_of_type_Trs.d);
    if (this.jdField_a_of_type_Trs.d == null)
    {
      this.jdField_a_of_type_Trs.d = "";
      veg.c(this.b, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.jdField_a_of_type_Trs.d);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.jdField_a_of_type_Trs.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqz
 * JD-Core Version:    0.7.0.1
 */