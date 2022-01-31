import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class uxh
  extends uxf
{
  public int a;
  
  public uxh(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, 2131561491);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(utx paramutx)
  {
    super.a(paramutx);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      xmh.a(alpo.a(2131707984), new Object[0]);
      return;
    case 3: 
      this.itemView.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramutx.c, false);
      String str = xoa.b(paramutx.g);
      if (!TextUtils.isEmpty(str)) {
        b(str);
      }
      while ((paramutx.a == null) || (paramutx.a.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(1, 1 - paramutx.b);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.setImageResource(2130846112);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(alpo.a(2131707983), false);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.setImageResource(2130846109);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxh
 * JD-Core Version:    0.7.0.1
 */