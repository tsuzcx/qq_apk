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

public class vpm
  extends vnz
  implements IEventReceiver
{
  private long jdField_a_of_type_Long;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private vky jdField_a_of_type_Vky;
  private vpp jdField_a_of_type_Vpp;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public vpm(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131379611));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void a(int paramInt, vle paramvle, @NonNull ArrayList<vpk> paramArrayList)
  {
    wsv.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramvle);
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramvle, paramArrayList);
    if (!bool)
    {
      this.d = true;
      if (this.jdField_a_of_type_Vpp == null) {
        this.jdField_a_of_type_Vpp = new vpp(this);
      }
      uht.a().registerSubscriber("", this.jdField_a_of_type_Vpp);
    }
    if ((paramvle.c()) || (paramvle.b())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Vky.a().size();
      this.jdField_a_of_type_Vky.a(paramInt, paramArrayList, paramvle.a);
    } while (i == this.jdField_a_of_type_Vky.a().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(paramString);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Vky = new vky(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_Vky);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new vpn(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new vpo(this));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Vpp != null)
    {
      this.d = false;
      uht.a().unRegisterSubscriber(this.jdField_a_of_type_Vpp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpm
 * JD-Core Version:    0.7.0.1
 */