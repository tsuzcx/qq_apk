import com.tencent.mobileqq.activity.aio.anim.friendship.FriendShipWaveView;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.util.DisplayUtil;

public class uls
  implements Action.OnActionEndListener
{
  public uls(FriendShipWaveView paramFriendShipWaveView) {}
  
  public void a()
  {
    ScaleAction localScaleAction = new ScaleAction(500, 0.0F, 1.0F);
    this.a.d.b = 255;
    this.a.d.a(new Action[] { localScaleAction });
    localScaleAction.a(new ult(this));
    this.a.e = new Sprite();
    this.a.e.a(FriendShipWaveView.a(this.a));
    this.a.e.a(this.a.jdField_a_of_type_Int / 2 + DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 120.0F), this.a.b.d + 30.0F);
    this.a.a(this.a.e);
    localScaleAction = new ScaleAction(500, 0.0F, 1.0F);
    this.a.e.a(new Action[] { localScaleAction });
    localScaleAction.a(new ulu(this));
    this.a.f = new Sprite();
    this.a.f.a(FriendShipWaveView.b(this.a));
    this.a.f.a(this.a.jdField_a_of_type_Int / 2 - DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 142.0F), this.a.c.d - 50.0F);
    this.a.a(this.a.f);
    localScaleAction = new ScaleAction(500, 0.0F, 1.0F);
    this.a.f.a(new Action[] { localScaleAction });
    localScaleAction.a(new ulv(this));
    this.a.g = new Sprite();
    this.a.g.a(FriendShipWaveView.c(this.a));
    this.a.g.a(this.a.jdField_a_of_type_Int / 2 + DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 140.0F), this.a.c.d);
    this.a.a(this.a.g);
    localScaleAction = new ScaleAction(500, 0.0F, 1.0F);
    this.a.g.a(new Action[] { localScaleAction });
    localScaleAction.a(new ulw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uls
 * JD-Core Version:    0.7.0.1
 */