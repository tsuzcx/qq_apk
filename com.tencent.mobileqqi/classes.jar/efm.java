import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter.ViewHolder;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.widget.AbsListView;

public class efm
  implements SlideDetectListView.OnScrollToTopListener
{
  public efm(SystemMsgListView paramSystemMsgListView) {}
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((SystemMsgListView.a(this.a) != null) && (paramInt == 0) && (SystemMsgListView.a(this.a) == SystemMsgListView.a(this.a).getCount())) {
      SystemMsgListView.b(this.a);
    }
    SystemMsgListView.a(this.a, paramInt);
    if (paramInt != 0)
    {
      SystemMsgListView.a(this.a).c();
      SystemMsgListView.a(this.a).a();
    }
    for (;;)
    {
      return;
      if (SystemMsgListView.a(this.a).a()) {
        SystemMsgListView.a(this.a).b();
      }
      int i = SystemMsgListView.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        SystemMsgListAdapter.ViewHolder localViewHolder = (SystemMsgListAdapter.ViewHolder)SystemMsgListView.a(this.a).getChildAt(paramInt).getTag();
        if ((localViewHolder != null) && (!TextUtils.isEmpty(localViewHolder.jdField_a_of_type_JavaLangString)))
        {
          Bitmap localBitmap = SystemMsgListView.a(this.a).a(1, localViewHolder.jdField_a_of_type_JavaLangString);
          paramAbsListView = localBitmap;
          if (localBitmap == null)
          {
            SystemMsgListView.a(this.a).a(localViewHolder.jdField_a_of_type_JavaLangString, 1, false);
            if (SystemMsgListView.a(this.a) == null) {
              SystemMsgListView.a(this.a, ImageUtil.a());
            }
            paramAbsListView = SystemMsgListView.a(this.a);
          }
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramAbsListView);
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    SystemMsgListView.b(this.a, paramInt1 + paramInt2 - 1);
    if (paramInt1 > 1) {
      FriendSystemMsgController.a().a();
    }
    while (!SystemMsgListView.c(this.a)) {
      return;
    }
    FriendSystemMsgController.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     efm
 * JD-Core Version:    0.7.0.1
 */