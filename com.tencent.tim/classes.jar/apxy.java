import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1;
import org.json.JSONObject;

class apxy
  implements anyo.a
{
  apxy(apxx paramapxx) {}
  
  public void byj()
  {
    if (this.a.a.a.this$0.c == null) {
      return;
    }
    if (this.a.a.a.c.playTotalMicroseconds / 1000L > this.a.dXT + this.a.dXU)
    {
      String str = this.a.val$path + this.a.bZ.optString("videoPath", "3.mp4");
      this.a.a.a.this$0.c.a(str, new apxz(this));
      return;
    }
    this.a.a.a.this$0.ecD();
    if (this.a.a.a.a != null) {
      this.a.a.a.a.byj();
    }
    this.a.a.a.this$0.a(this.a.a.a.c, this.a.a.a.c.frienduin, this.a.a.a.c.interactId, this.a.a.a.c.animationPackageId, this.a.a.a.this$0.dXR, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apxy
 * JD-Core Version:    0.7.0.1
 */