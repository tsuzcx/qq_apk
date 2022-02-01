import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1;
import org.json.JSONObject;

public class apxx
  implements anyo.a
{
  public apxx(TroopInteractGiftAnimationController.1.1 param1, int paramInt1, String paramString, JSONObject paramJSONObject1, int paramInt2, JSONObject paramJSONObject2) {}
  
  public void byj()
  {
    if (this.a.a.this$0.c == null) {
      return;
    }
    if (this.a.a.c.playTotalMicroseconds / 1000L > this.dXT)
    {
      String str = this.val$path + this.bY.optString("videoPath", "2.mp4");
      this.a.a.this$0.c.a(str, new apxy(this));
      this.a.a.this$0.a(this.a.a.c, this.dXU - 300);
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
 * Qualified Name:     apxx
 * JD-Core Version:    0.7.0.1
 */