import com.tencent.mobileqq.activity.aio.anim.friendship.FriendShipWaveView;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;

public class utq
  implements Action.OnActionEndListener
{
  public utq(FriendShipWaveView paramFriendShipWaveView) {}
  
  public void a()
  {
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(300, 0.1F, 1.1F), new ScaleAction(100, 1.2F, 0.9F), new ScaleAction(100, 0.9F, 1.0F) });
    this.a.c.a(new Action[] { localSequenceAction });
    this.a.b.a(new Action[] { new ScaleAction(300, 0.0F, 1.0F) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utq
 * JD-Core Version:    0.7.0.1
 */