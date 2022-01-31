import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.troop.data.TroopBarPOI;

class vgb
  implements vie
{
  vgb(vga paramvga) {}
  
  public void a()
  {
    ved.c("Q.qqstory.publish.edit.StoryDoodle", "onSelectLocationCancel");
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    ved.c("Q.qqstory.publish.edit.StoryDoodle", "onSelectLocation " + paramTroopBarPOI);
    if (paramTroopBarPOI != null)
    {
      this.a.a.setLocation(paramTroopBarPOI.a());
      return;
    }
    this.a.a.setLocation("None for test!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgb
 * JD-Core Version:    0.7.0.1
 */