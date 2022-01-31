import com.tencent.biz.qqstory.base.ErrorMessage;

class wtp
  implements wsy
{
  wtp(wtd paramwtd) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    wxe.e("Q.qqstory.home.StoryListPresenter", "step %s error occur when requestAllDataFromNet error=%s", new Object[] { paramErrorMessage.extraMsg, paramErrorMessage.getErrorMessage() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wtp
 * JD-Core Version:    0.7.0.1
 */