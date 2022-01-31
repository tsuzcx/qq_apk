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

public class uau
  extends tzh
  implements IEventReceiver
{
  private long jdField_a_of_type_Long;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private twg jdField_a_of_type_Twg;
  private uax jdField_a_of_type_Uax;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public uau(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131378957));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void a(int paramInt, twm paramtwm, @NonNull ArrayList<uas> paramArrayList)
  {
    ved.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramtwm);
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramtwm, paramArrayList);
    if (!bool)
    {
      this.d = true;
      if (this.jdField_a_of_type_Uax == null) {
        this.jdField_a_of_type_Uax = new uax(this);
      }
      stb.a().registerSubscriber("", this.jdField_a_of_type_Uax);
    }
    if ((paramtwm.c()) || (paramtwm.b())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Twg.a().size();
      this.jdField_a_of_type_Twg.a(paramInt, paramArrayList, paramtwm.a);
    } while (i == this.jdField_a_of_type_Twg.a().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(paramString);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Twg = new twg(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_Twg);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new uav(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new uaw(this));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Uax != null)
    {
      this.d = false;
      stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uax);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uau
 * JD-Core Version:    0.7.0.1
 */