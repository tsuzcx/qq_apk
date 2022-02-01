import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.FriendListOpenFrame;
import com.tencent.open.agent.FriendListOpenFrame.ViewHolder;

public class hje
  implements Runnable
{
  public hje(FriendListOpenFrame paramFriendListOpenFrame, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        FriendListOpenFrame.ViewHolder localViewHolder = (FriendListOpenFrame.ViewHolder)this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.a.getChildAt(i).getTag();
        if ((localViewHolder != null) && (this.jdField_a_of_type_JavaLangString.equals(localViewHolder.jdField_b_of_type_JavaLangString))) {
          localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hje
 * JD-Core Version:    0.7.0.1
 */