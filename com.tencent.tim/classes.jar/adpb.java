import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.troop.TroopPluginManager.a;

class adpb
  implements TroopPluginManager.a
{
  adpb(adpa paramadpa, QQAppInterface paramQQAppInterface) {}
  
  public void onInstallFinish(int paramInt)
  {
    if (paramInt == 0)
    {
      this.val$app.addObserver(this.this$0.b);
      ((acms)this.val$app.getBusinessHandler(20)).j(accc.Z(this.this$0.buS), true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpb
 * JD-Core Version:    0.7.0.1
 */