import com.tencent.mobileqq.app.QQAppInterface;

class pwe
  extends pmd
{
  pwe(pvz parampvz) {}
  
  public void blR()
  {
    ram.d(pvz.access$100(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.this$0.mApp == null) {
      ram.e(pvz.access$100(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    puy localpuy = (puy)this.this$0.mApp.getManager(251);
    if (localpuy.Jc()) {
      if (this.this$0.Ji()) {
        this.this$0.jdField_a_of_type_Pvv.bq("exp_story", 3);
      }
    }
    do
    {
      do
      {
        return;
        if (!localpuy.Jd()) {
          break;
        }
      } while (!this.this$0.Ji());
      this.this$0.jdField_a_of_type_Pvv.bq("exp_story", 2);
      return;
      if (!this.this$0.jdField_a_of_type_Pvz$a.Jn()) {
        break;
      }
    } while (!this.this$0.Ji());
    this.this$0.jdField_a_of_type_Pvv.bq("exp_story", 5);
    return;
    if (localpuy.Je())
    {
      this.this$0.bno();
      localpuy.bmR();
      this.this$0.jdField_a_of_type_Pvv.bq("exp_hide", 0);
      return;
    }
    this.this$0.jdField_a_of_type_Pvv.bq("exp_hide", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwe
 * JD-Core Version:    0.7.0.1
 */