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

public class xhh
  extends xfu
  implements IEventReceiver
{
  private long jdField_a_of_type_Long;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private xct jdField_a_of_type_Xct;
  private xhk jdField_a_of_type_Xhk;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public xhh(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131380869));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void a(int paramInt, xcz paramxcz, @NonNull ArrayList<xhf> paramArrayList)
  {
    ykq.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramxcz);
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramxcz, paramArrayList);
    if (!bool)
    {
      this.d = true;
      if (this.jdField_a_of_type_Xhk == null) {
        this.jdField_a_of_type_Xhk = new xhk(this);
      }
      wad.a().registerSubscriber("", this.jdField_a_of_type_Xhk);
    }
    if ((paramxcz.c()) || (paramxcz.b())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Xct.a().size();
      this.jdField_a_of_type_Xct.a(paramInt, paramArrayList, paramxcz.a);
    } while (i == this.jdField_a_of_type_Xct.a().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(paramString);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Xct = new xct(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_Xct);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new xhi(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new xhj(this));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Xhk != null)
    {
      this.d = false;
      wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xhk);
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
 * Qualified Name:     xhh
 * JD-Core Version:    0.7.0.1
 */