import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1;
import org.json.JSONObject;

public class apya
  implements anyo.a
{
  public apya(TroopInteractGiftAnimationController.1.1 param1, int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject) {}
  
  public void byj()
  {
    if (this.a.a.this$0.c == null) {
      return;
    }
    if (this.a.a.c.playTotalMicroseconds / 1000L > this.dXT + this.dXU)
    {
      String str = this.val$path + this.bZ.optString("videoPath", "3.mp4");
      this.a.a.this$0.c.a(str, new apyb(this));
      return;
    }
    this.a.a.this$0.ecD();
    if (this.a.a.a != null) {
      this.a.a.a.byj();
    }
    this.a.a.this$0.a(this.a.a.c, this.a.a.c.frienduin, this.a.a.c.interactId, this.a.a.c.animationPackageId, this.a.a.this$0.dXR, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apya
 * JD-Core Version:    0.7.0.1
 */