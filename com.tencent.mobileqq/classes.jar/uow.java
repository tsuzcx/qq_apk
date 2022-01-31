import com.tencent.mobileqq.activity.aio.anim.friendship.FriendShipWaveView;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.RotateAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;

class uow
  implements Action.OnActionEndListener
{
  uow(uos paramuos) {}
  
  public void a()
  {
    RotateAction localRotateAction = new RotateAction(3000, 360, 0);
    localRotateAction.a = true;
    this.a.a.g.a(new Action[] { localRotateAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uow
 * JD-Core Version:    0.7.0.1
 */