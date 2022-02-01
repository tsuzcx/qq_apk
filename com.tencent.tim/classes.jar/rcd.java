import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.troop.data.TroopBarPOI;

class rcd
  implements rdu
{
  rcd(rcc paramrcc) {}
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    ram.i("Q.qqstory.publish.edit.StoryDoodle", "onSelectLocation " + paramTroopBarPOI);
    if (paramTroopBarPOI != null)
    {
      this.this$0.a.setLocation(paramTroopBarPOI.AU());
      return;
    }
    this.this$0.a.setLocation("None for test!!");
  }
  
  public void bsG()
  {
    ram.i("Q.qqstory.publish.edit.StoryDoodle", "onSelectLocationCancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcd
 * JD-Core Version:    0.7.0.1
 */