import com.tencent.mobileqq.activity.aio.anim.friendship.FriendShipWaveView;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.RotateAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;

class uot
  implements Action.OnActionEndListener
{
  uot(uos paramuos) {}
  
  public void a()
  {
    RotateAction localRotateAction = new RotateAction(3000, 360, 0);
    localRotateAction.a = true;
    this.a.a.d.a(new Action[] { localRotateAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uot
 * JD-Core Version:    0.7.0.1
 */