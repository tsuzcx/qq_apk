import com.tencent.mobileqq.activity.aio.anim.friendship.FriendShipWaveView;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.MoveToAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.util.DisplayUtil;

public class uop
  implements Action.OnActionEndListener
{
  public uop(FriendShipWaveView paramFriendShipWaveView) {}
  
  public void a()
  {
    int i = (int)(this.a.b - DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 165.0F) - this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    int j = (int)(this.a.b - DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 200.0F) - this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    int k = (int)(this.a.b - DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 178.0F) - this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new MoveToAction(450, this.a.jdField_a_of_type_Int / 2, (int)(-this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F), this.a.jdField_a_of_type_Int / 2, i), new MoveToAction(450, this.a.jdField_a_of_type_Int / 2, i, this.a.jdField_a_of_type_Int / 2, j), new MoveToAction(450, this.a.jdField_a_of_type_Int / 2, j, this.a.jdField_a_of_type_Int / 2, k) });
    localSequenceAction.a(new uoq(this));
    this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { localSequenceAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uop
 * JD-Core Version:    0.7.0.1
 */