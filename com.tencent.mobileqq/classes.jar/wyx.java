import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class wyx
  extends wyv
{
  public int a;
  
  public wyx(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, 2131561785);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(wvn paramwvn)
  {
    super.a(paramwvn);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      znw.a(anzj.a(2131706480), new Object[0]);
      return;
    case 3: 
      this.itemView.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramwvn.c, false);
      String str = zpp.b(paramwvn.g);
      if (!TextUtils.isEmpty(str)) {
        b(str);
      }
      while ((paramwvn.a == null) || (paramwvn.a.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(1, 1 - paramwvn.b);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.setImageResource(2130846641);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(anzj.a(2131706479), false);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.setImageResource(2130846638);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyx
 * JD-Core Version:    0.7.0.1
 */