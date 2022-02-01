import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class wpi
  extends wpg
{
  public int a;
  
  public wpi(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, 2131561731);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(wly paramwly)
  {
    super.a(paramwly);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      zdl.a(anvx.a(2131707062), new Object[0]);
      return;
    case 3: 
      this.itemView.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramwly.c, false);
      String str = zfe.b(paramwly.g);
      if (!TextUtils.isEmpty(str)) {
        b(str);
      }
      while ((paramwly.a == null) || (paramwly.a.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(1, 1 - paramwly.b);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.setImageResource(2130846645);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(anvx.a(2131707061), false);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.setImageResource(2130846642);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpi
 * JD-Core Version:    0.7.0.1
 */