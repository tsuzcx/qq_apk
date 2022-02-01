import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class xng
  extends xlt
  implements IEventReceiver
{
  private long jdField_a_of_type_Long;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private xis jdField_a_of_type_Xis;
  private xnj jdField_a_of_type_Xnj;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public xng(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131380616));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void a(int paramInt, xiy paramxiy, @NonNull ArrayList<xne> paramArrayList)
  {
    yqp.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramxiy);
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramxiy, paramArrayList);
    if (!bool)
    {
      this.d = true;
      if (this.jdField_a_of_type_Xnj == null) {
        this.jdField_a_of_type_Xnj = new xnj(this);
      }
      wfo.a().registerSubscriber("", this.jdField_a_of_type_Xnj);
    }
    if ((paramxiy.c()) || (paramxiy.b())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Xis.a().size();
      this.jdField_a_of_type_Xis.a(paramInt, paramArrayList, paramxiy.a);
    } while (i == this.jdField_a_of_type_Xis.a().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(paramString);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Xis = new xis(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_Xis);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new xnh(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new xni(this));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Xnj != null)
    {
      this.d = false;
      wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Xnj);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.b();
  }
  
  public boolean isValidate()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xng
 * JD-Core Version:    0.7.0.1
 */